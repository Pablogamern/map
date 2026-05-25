/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package API;

import java.awt.Desktop;
import java.net.URI;


public class INaturalistTilePainter {
    public static void abrirMapa(
            double lat,
            double lon
    ) {

        try {

            String url =
                    "https://www.inaturalist.org/observations/map"
                    + "?lat=" + lat
                    + "&lng=" + lon
                    + "&zoom=10";

            Desktop.getDesktop().browse(
                    new URI(url)
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
