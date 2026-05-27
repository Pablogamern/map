/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuario;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class GestorCuentas {
     private ArrayList<Usuario> usuario;
    private final String archivo;
    
    public GestorCuentas() {
        this.archivo = System.getProperty("user.home") + File.separator + "usuario.dat";
        usuario = cargarEstudiantes();
    }
    public GestorCuentas(String rutaArchivo) {
        this.archivo = rutaArchivo;
        usuario = cargarEstudiantes();
    }
   public void registrarEstudiante(String nombres,String noDocumento,String apellido) {
        usuario.add(new Usuario(nombres, nombres, apellido));
        guardarEstudiates();
    }
    public ArrayList<Usuario> listarUsuarios() {
        return usuario;
    }
    public boolean buscarUsuario(String identificacion){
        String id = identificacion;
        for (Usuario e : usuario){
            if (e.getContraseña().equals(id)){
             return true;
                
            
            }
        
        }
        return false;
    }
    public Usuario buscarUsuario1(String identificacion){
        String id = identificacion;
        for (Usuario e : usuario){
            if (e.getContraseña().equals(id)){
             return e;
                
            
            }
        
        }
        return null;
    }
    public void guardarAnimal(Usuario usu, Animales anmial){
       usu.agregaranimal(anmial);
       guardarEstudiates();
    }
    
    
        // Guardar en archivo
    private void guardarEstudiates() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(usuario);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Cargar desde archivo
    @SuppressWarnings("unchecked")
    private ArrayList<Usuario> cargarEstudiantes() {
        File f = new File(archivo);
        if (!f.exists()) {
            return new ArrayList<>();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            return (ArrayList<Usuario>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
