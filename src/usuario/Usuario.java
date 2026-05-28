
package usuario;

import java.awt.List;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JTextArea;


public class Usuario implements Serializable{
    private static final long serialVersionUID = 1L;
    private String nombres;
    private String contraseña;
    private String apellido;
    private ArrayList<Animales> animales = new ArrayList<>();
    
    
    
    public ArrayList<Animales> getAnimales() {
        return animales;
    }

    public void setAnimales(ArrayList<Animales> animales) {
        this.animales = animales;
    }

    public Usuario(String nombres, String contraseña, String apellido) {
        this.nombres = nombres;
        this.contraseña = contraseña;
        this.apellido = apellido;
        this.animales = new ArrayList<>();
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public void agregaranimal(Animales animal){
        animales.add(animal);
    }
    public void mostrar(JTextArea area){
        area.setText("Avistamientos Recientes");
        for (Animales animale : animales) {
           
            area.append("\nNombre: "+animale.getNombreComun());
        }
    }
    @Override
    public String toString() {
        return "Nombre: " + nombres + " | Usuario: " + contraseña;
    }

    
    
}
