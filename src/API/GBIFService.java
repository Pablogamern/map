package API;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.JOptionPane;

public class GBIFService {

    public static String buscarEspecies(double lat, double lon) {
            try {

            String urlString = "https://api.inaturalist.org/v1/observations"+ "?lat=" + lat + "&lng=" + lon+ "&radius=100"+ "&per_page=800"+ "&order=desc"+ "&order_by=created_at"+ "&quality_grade=research" + "&iconic_taxa="+ "Mammalia,Aves,Reptilia,Amphibia,"+ "Insecta,Arachnida,Actinopterygii";

            URL url = new URL(urlString);

            HttpURLConnection conexion =
                    (HttpURLConnection) url.openConnection();
            
            conexion.setRequestMethod("GET");
            conexion.setRequestProperty(
        "User-Agent",
        "Mozilla/5.0"
);

conexion.setRequestProperty(
        "Accept",
        "application/json"
);
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            conexion.getInputStream()
                    )
            );

            String linea;
            StringBuilder respuesta = new StringBuilder();

            while ((linea = reader.readLine()) != null) {
                respuesta.append(linea);
            }

            reader.close();

            return respuesta.toString();

        } catch (Exception e) {
            e.printStackTrace();
                JOptionPane.showMessageDialog(null, "No hay conexion");
        }
        return null;
    }
}