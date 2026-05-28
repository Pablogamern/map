package API;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TablaPanel extends JPanel {

    private JTable tabla;
    private DefaultTableModel modelo;

    public TablaPanel() {
        setLayout(new java.awt.BorderLayout());
        modelo = new DefaultTableModel();
        modelo.addColumn("Especie");
        modelo.addColumn("Nombre Científico");
        modelo.addColumn("Lat");
        modelo.addColumn("Lon");
        tabla = new JTable(modelo);
        add(new JScrollPane(tabla), java.awt.BorderLayout.CENTER);
    }
    public void agregarFila(String especie, String cientifico,double lat, double lon) {
        modelo.addRow(new Object[]{especie, cientifico, lat, lon});
    }
    public JTable getTabla() {
        return tabla;
    }
}