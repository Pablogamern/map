package API;

import java.awt.Color;
import org.jxmapviewer.viewer.DefaultWaypoint;

public class AnimalWaypoint extends DefaultWaypoint {

    private String nombre;
    private String imageUrl;
    private String clase;
    private Color color;
    public AnimalWaypoint(double lat, double lon,String nombre,String imageurl, String clase) {
    super(lat, lon);
    this.nombre = nombre;
    this.clase = clase;
    this.imageUrl = imageurl;
    color = obtenerColor(clase);
}
    private Color obtenerColor(String clase) {
    switch (clase.toLowerCase()) {
        case "mammalia":
            return Color.RED;

        case "aves":
            return Color.BLUE;

        case "reptilia":
            return Color.GREEN;

        case "amphibia":
            return Color.MAGENTA;

        case "insecta":
            return Color.YELLOW;

        case "arachnida":
            return Color.DARK_GRAY;

        case "actinopterygii":
            return Color.CYAN;

        case "chondrichthyes":
            return new Color(0, 0, 120);

        case "gastropoda":
            return new Color(139, 69, 19);

        case "bivalvia":
            return Color.GRAY;

        case "cephalopoda":
            return Color.ORANGE;

        case "malacostraca":
            return new Color(150, 0, 0);

        case "diplopoda":
            return new Color(120, 70, 15);

        case "chilopoda":
            return new Color(200, 100, 0);

        case "anthozoa":
            return Color.PINK;

        case "hydrozoa":
            return new Color(100, 200, 255);

        case "polychaeta":
            return new Color(90, 50, 20);

        case "clitellata":
            return new Color(120, 0, 120);
        case "bacterium":
            return new Color(134, 0, 134);

        default:
            return Color.WHITE;
    }
}
    public Color getColor() {
    return color;
}

    public String getNombre() {
        return nombre;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
