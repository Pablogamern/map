import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GBIFService {

    public static String buscarEspecies(double lat, double lon) {
        try {

            String urlString = "https://api.gbif.org/v1/occurrence/search?decimalLatitude="
                    + lat + "&decimalLongitude=" + lon + "&radius=350";

            URL url = new URL(urlString);

            HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conexion.getInputStream()));

            String linea;
            StringBuilder respuesta = new StringBuilder();

            while ((linea = reader.readLine()) != null) {
                respuesta.append(linea);
            }

            reader.close();

            return respuesta.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}