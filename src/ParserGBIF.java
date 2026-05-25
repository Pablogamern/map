import org.json.JSONArray;
import org.json.JSONObject;
public class ParserGBIF {
    public static void mostrarEspecies(String json) {

        JSONObject objeto = new JSONObject(json);

        JSONArray resultados = objeto.getJSONArray("results");

        for (int i = 0; i < resultados.length(); i++) {

            JSONObject especie = resultados.getJSONObject(i);

            String nombreEspecie = especie.optString("species");
            String nombreCientifico = especie.optString("scientificName");

            System.out.println("Especie: " + nombreEspecie);
            System.out.println("Nombre científico: " + nombreCientifico);
            System.out.println("-------------------------");
        }
    }

}
