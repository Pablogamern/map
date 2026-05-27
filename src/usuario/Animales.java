
package usuario;

import java.io.Serializable;


public class Animales implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nombreComun;

    public Animales(String nombreComun) {
        this.nombreComun = nombreComun;
    }

    public String getNombreComun() {
        return nombreComun;
    }

    public void setNombreComun(String nombreComun) {
        this.nombreComun = nombreComun;
    }

    @Override
    public String toString() {
        return nombreComun;
    }
    
}
