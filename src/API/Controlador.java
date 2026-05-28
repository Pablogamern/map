package API;


import org.json.JSONArray;
import org.json.JSONObject;

public class Controlador {

    public static void procesarDatos(String json, MapaPanel mapa,TablaPanel tabla) {      
JSONObject obj = new JSONObject(json);
JSONArray results = obj.getJSONArray("results");
for (int i = 0; i < results.length(); i++) {
    JSONObject item = results.getJSONObject(i);
    String especie =item.optString("species_guess", "Desconocido");
    JSONObject taxon =item.optJSONObject("taxon");
    String cientifico = "N/A";
    String genero = "N/A";
    String familia = "N/A";
    String filo = "N/A";
    String clase = "Desconocido";

    if (taxon != null) {        
        cientifico =taxon.optString("name", "N/A");        
        genero =taxon.optString("genus", "N/A");
        familia =taxon.optString("family", "N/A");
        filo =taxon.optString("phylum", "N/A");
        clase =taxon.optString("iconic_taxon_name","Desconocido");
    }

   
    JSONObject geo =item.optJSONObject("geojson");
    if (geo == null) {
        continue;
    }
    JSONArray coords =geo.optJSONArray("coordinates");
    if (coords == null || coords.length() < 2) {
        continue;
    }
    double lon = coords.getDouble(0);
    double lat = coords.getDouble(1);
    String imagenURL = null;
    JSONArray fotos =item.optJSONArray("photos");
    if (fotos != null && fotos.length() > 0) {
       JSONObject foto =fotos.getJSONObject(0);
        imagenURL =foto.optString("url");
        if (imagenURL != null) {
            imagenURL =imagenURL.replace("square", "medium");
        }
    }


    tabla.agregarFila(especie,cientifico,lat,lon);
        mapa.agregarAnimal(lat,lon,especie,imagenURL, clase);
    
        }
    }
}
