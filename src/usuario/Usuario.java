
package usuario;

import java.io.Serializable;


public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nombres;
    private String noDocumento;
    private String apellido;
         
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getNoDocumento() {
        return noDocumento;
    }

    public void setNoDocumento(String noDocumento) {
        this.noDocumento = noDocumento;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Usuario(String nombres, String noDocumento, String apellido) {
        this.nombres = nombres;
        this.noDocumento = noDocumento;
        this.apellido = apellido;
    }
    @Override
    public String toString() {
        return "Usuario{" + "username=" + nombres + ", contraseña=" + noDocumento + '}';
    }
    
    
}
