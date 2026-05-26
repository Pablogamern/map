
package usuario;
import java.io.*;
import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class GestorCuentas{
    private ArrayList<Usuario> usuarios = new ArrayList<>();; 
    private String archivoDatos = "cuentas.dat";

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
    
    
    public GestorCuentas() {
        
        cargarUsuarios();
    }
    
   
    public void agregarUsuario(Usuario usuario) {
        
            usuarios.add(usuario);
            guardarUsuarios();

    }
    
    
    public Usuario buscarUsuario(String username) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombres().equals(username)) {
                return usuario;
            }
        }
        return null;
    }
    

    public boolean iniciarSesion(String username, String password) {
        Usuario usuario = buscarUsuario(username);
        if (usuario != null && usuario.getNoDocumento().equals(password)) {           
            return true;
        } else {
            
            return false;
        }
    }
    

    public void guardarUsuarios() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivoDatos))) {
            oos.writeObject(usuarios);
        } catch (IOException e) {
            
        }
    }
    
    // Cargar usuarios desde archivo local
    @SuppressWarnings("unchecked")
    public void cargarUsuarios() {
        File archivo = new File(archivoDatos);
        if (archivo.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
                usuarios = (ArrayList<Usuario>) ois.readObject();
                System.out.println("Usuarios cargados correctamente");
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error al cargar usuarios: " + e.getMessage());
                usuarios = new ArrayList<>();
            }
        } else {
            System.out.println("?Creando nuevo archivo de usuarios");
        }
    }
    
    // Método para mostrar todos los usuarios (para depuración)
    public void mostrarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados");
        } else {
            System.out.println("\n=== Usuarios Registrados ===");
            for (Usuario usuario : usuarios) {
                System.out.println("- " + usuario);
            }
        }
    }
}
