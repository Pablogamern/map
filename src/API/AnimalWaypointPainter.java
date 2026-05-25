package API;
import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.painter.Painter;
import java.awt.Point;
import java.awt.*;
import java.awt.geom.Point2D;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.jxmapviewer.viewer.GeoPosition;

public class AnimalWaypointPainter implements Painter<JXMapViewer> {

    private Set<AnimalWaypoint> waypoints;
    
        private Map<String, Integer> densidad;

    private boolean mostrarDensidad;
    public AnimalWaypointPainter(Set<AnimalWaypoint> waypoints, boolean mostrarDensidad, Map<String, Integer> densidad) {
        this.waypoints = waypoints;
        this.mostrarDensidad  = mostrarDensidad;
        this.densidad = densidad;
    }

    @Override
public void paint(Graphics2D g, JXMapViewer map, int w, int h) {
    
     g = (Graphics2D) g.create();
     Rectangle rect = map.getViewportBounds();
      if (mostrarDensidad) {
          
            for (String key : densidad.keySet()) {

                int cantidad = densidad.get(key);

                String[] partes = key.split("_");

                double lat =
                        Integer.parseInt(partes[0]) / 10.0;

                double lon =
                        Integer.parseInt(partes[1]) / 10.0;

                Point2D pt =
                        map.getTileFactory()
                                .geoToPixel(
                                        new GeoPosition(lat, lon),
                                        map.getZoom()
                                );

                int x =
                        (int) (pt.getX() - rect.getX());

                int y =
                        (int) (pt.getY() - rect.getY());

                if (cantidad > 20) {

                    g.setColor(
                            new Color(255, 0, 0, 120)
                    );

                } else if (cantidad > 10) {

                    g.setColor(
                            new Color(255, 255, 0, 120)
                    );

                } else {

                    g.setColor(
                            new Color(0, 255, 0, 120)
                    );
                }

                int radio = cantidad * 8;

                g.fillOval(
                        x - radio / 2,
                        y - radio / 2,
                        radio,
                        radio
                );
            }
        }
    Set<AnimalWaypoint> copia = new HashSet<>(waypoints);

    for (AnimalWaypoint wp : copia) {

        Point2D pt = map.getTileFactory()
                .geoToPixel(wp.getPosition(), map.getZoom());

        

        int x = (int) (pt.getX() - rect.getX());
        int y = (int) (pt.getY() - rect.getY());

        
        g.setColor(wp.getColor());

        
        int size = 18;

        
        g.fillOval(
                x - size / 2,
                y - size / 2,
                size,
                size
        );        
        g.setColor(Color.BLACK);

        g.drawOval(
                x - size / 2,
                y - size / 2,
                size,
                size
        );
    }

    g.dispose();
}
    
}