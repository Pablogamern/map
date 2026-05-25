import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class LocationService {

    public static double[] obtenerUbicacion() {

        try {

            URL url = new URL("http://ip-api.com/json");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));

            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();

            JSONObject json = new JSONObject(response.toString());

            double lat = json.getDouble("lat");
            double lon = json.getDouble("lon");

            return new double[]{lat, lon};

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}