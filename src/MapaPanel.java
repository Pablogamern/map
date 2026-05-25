import org.jxmapviewer.*;
import org.jxmapviewer.viewer.*;
import org.jxmapviewer.input.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class MapaPanel extends JPanel {
    
    private JXMapViewer map;
    private Set<AnimalWaypoint> waypoints;

    public MapaPanel() {
        System.setProperty("http.agent", "map/1.0");
        setLayout(new BorderLayout());

        map = new JXMapViewer();

        TileFactoryInfo info = new TileFactoryInfo(
        0, 17, 17,
        256,
        true, true,
        "https://tile.openstreetmap.org",
        "x", "y", "z"
) {
    @Override
    public String getTileUrl(int x, int y, int zoom) {
        int z = 17 - zoom;
        return this.baseURL + "/" + z + "/" + x + "/" + y + ".png";
    }
};
        DefaultTileFactory tileFactory = new DefaultTileFactory(info);
        map.setTileFactory(tileFactory);

        GeoPosition pos = new GeoPosition(4.60971, -74.08175);
        map.setAddressLocation(pos);
        map.setZoom(5);


        map.addMouseListener(new PanMouseInputListener(map));
        map.addMouseMotionListener(new PanMouseInputListener(map));
        map.addMouseWheelListener(new ZoomMouseWheelListenerCursor(map));

        waypoints = new HashSet<>();
        map.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            detectarClick(e);
        }
    });
        add(map, BorderLayout.CENTER);
    }
    private void detectarClick(MouseEvent e) {

    for (AnimalWaypoint wp : waypoints) {

        Point2D pt = map.getTileFactory()
                .geoToPixel(wp.getPosition(), map.getZoom());

        Rectangle rect = map.getViewportBounds();

        int x = (int) (pt.getX() - rect.getX());
        int y = (int) (pt.getY() - rect.getY());

        Rectangle area = new Rectangle(x - 5, y - 5, 10, 10);

        if (area.contains(e.getPoint())) {
            mostrarInfo(wp);
            break;
        }
    }
}
    private void mostrarInfo(AnimalWaypoint wp) {

    try {
        if (wp.getImageUrl() != null && !wp.getImageUrl().isEmpty()) {

            ImageIcon icon = new ImageIcon(new URL(wp.getImageUrl()));

            JLabel label = new JLabel(wp.getNombre(), icon, JLabel.CENTER);
            label.setHorizontalTextPosition(JLabel.CENTER);
            label.setVerticalTextPosition(JLabel.BOTTOM);

            JOptionPane.showMessageDialog(this, label);

        } else {
            JOptionPane.showMessageDialog(this,
                    "Animal: " + wp.getNombre() + "\n(Sin imagen)");
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this,
                "Error cargando imagen");
    }
}
    public void agregarAnimal(double lat, double lon, String nombre,String imageUrl) {

            AnimalWaypoint wp = new AnimalWaypoint(lat, lon, nombre,imageUrl);

    waypoints.add(wp); 
    AnimalWaypointPainter painter = new AnimalWaypointPainter(waypoints);
    map.setOverlayPainter(painter);
    }

    public JXMapViewer getMap() {
        return map;
    }
}