import org.jxmapviewer.viewer.DefaultWaypoint;

public class AnimalWaypoint extends DefaultWaypoint {

    private String nombre;
    private String imageUrl;

    public AnimalWaypoint(double lat, double lon, String nombre, String imageUrl) {
        super(lat, lon);
        this.nombre = nombre;
        this.imageUrl = imageUrl;
    }

    public String getNombre() {
        return nombre;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
