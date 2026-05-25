package API;


import javax.swing.*;
import org.jxmapviewer.JXMapViewer;
import org.jxmapviewer.viewer.*;
public class MainFrame extends JFrame{
public MainFrame() {

        setTitle("Mapa de Animales - GBIF");
        setSize(1100, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MapaPanel mapa = new MapaPanel();
        TablaPanel tablaPanel = new TablaPanel();

        JSplitPane split = new JSplitPane(
                JSplitPane.HORIZONTAL_SPLIT,
                mapa,
                tablaPanel
        );

        split.setDividerLocation(650);
        add(split);


        tablaPanel.getTabla().getSelectionModel().addListSelectionListener(e -> {

            int fila = tablaPanel.getTabla().getSelectedRow();

            if (fila != -1) {
                double lat = (double) tablaPanel.getTabla().getValueAt(fila, 5);
                double lon = (double) tablaPanel.getTabla().getValueAt(fila, 6);

                mapa.getMap().setAddressLocation(new GeoPosition(lat, lon));
                mapa.getMap().setZoom(6);
            }
        });

        setVisible(true);


        double lat = 4.60971;
        double lon = -74.08175;

        String json = GBIFService.buscarEspecies(lat, lon);

        Controlador.procesarDatos(json, mapa, tablaPanel);
    }

    /*public static void main(String[] args) {
        new MainFrame();
    }*/
  }
