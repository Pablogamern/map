import org.json.JSONArray;
import org.json.JSONObject;

public class Controlador {

    public static void procesarDatos(String json,
                                     MapaPanel mapa,
                                     TablaPanel tabla) {

       
        JSONObject obj = new JSONObject(json);
        JSONArray results = obj.getJSONArray("results");
        JSONArray media = obj.optJSONArray("media");

        String imagenURL = null;
        for (int i = 0; i < results.length(); i++) {

            JSONObject item = results.getJSONObject(i);

            String especie = item.optString("species", "Desconocido");
            String cientifico = item.optString("scientificName", "N/A");
            String genero = item.optString("genus", "N/A");
            String familia = item.optString("family", "N/A");
            String filo = item.optString("phylum", "N/A");

            double lat = item.optDouble("decimalLatitude", Double.NaN);
            double lon = item.optDouble("decimalLongitude", Double.NaN);


            double offset = 0.01;

lat += (Math.random() - 0.5) * offset;
lon += (Math.random() - 0.5) * offset;


                tabla.agregarFila(especie, cientifico, genero, familia, filo, lat, lon);
            if (media != null && media.length() > 0) {
    JSONObject mediaObj = media.getJSONObject(0);
    imagenURL = mediaObj.optString("identifier");
}
            mapa.agregarAnimal(lat, lon, especie,imagenURL);
        }
    }
}
