import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.painter.Painter;
import java.awt.Point;
import java.awt.*;
import java.awt.geom.Point2D;
import java.util.HashSet;
import java.util.Set;

public class AnimalWaypointPainter implements Painter<JXMapViewer> {

    private Set<AnimalWaypoint> waypoints;

    public AnimalWaypointPainter(Set<AnimalWaypoint> waypoints) {
        this.waypoints = waypoints;
    }

    @Override
public void paint(Graphics2D g, JXMapViewer map, int w, int h) {

    g = (Graphics2D) g.create();


    Set<AnimalWaypoint> copia = new HashSet<>(waypoints);

    for (AnimalWaypoint wp : copia) {

        Point2D pt = map.getTileFactory()
                .geoToPixel(wp.getPosition(), map.getZoom());

        Rectangle rect = map.getViewportBounds();

        int x = (int) (pt.getX() - rect.getX());
        int y = (int) (pt.getY() - rect.getY());

        g.fillOval(x - 5, y - 5, 10, 10);
    }

    g.dispose();
}
    
}