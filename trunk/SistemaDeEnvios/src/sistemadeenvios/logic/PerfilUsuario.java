/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeenvios.logic;

import java.util.ArrayList;
import sistemadeenvios.persistence.IPerfilBuilder;
import sistemadeenvios.stubs.StubPerfilBuilder;

/**
 *
 * @author Andres
 */
public class PerfilUsuario implements IPerfilUsuario {

    private String perfilName;
    private ArrayList<String> accesos;
    IPerfilBuilder builder;

    public PerfilUsuario(String perfilName) {
        this.builder = StubPerfilBuilder.getInstance();
        this.perfilName = perfilName;
        if (this.builder.existePerfil(perfilName)) {
            this.accesos = this.builder.getPerfil(perfilName).getPermisos();
        }
    }

    public ArrayList<String> getPermisos() {
        return this.accesos;
    }

    public String getPerfilName() {
        return perfilName;
    }

    public boolean validarAcceso(String componente) {
        // Si tiene el componente es porque tiene acceso a el
        return tieneComponente(componente);
    }

    public void agregarAcceso(String nombreComponente) {
        if (this.accesos == null) {
            this.accesos = new ArrayList<String>();
        }
        if (!tieneComponente(nombreComponente)) {
            accesos.add(nombreComponente);
        }
    }

    public boolean tieneComponente(String componente) {
        boolean contiene = false;
        for (String acceso : accesos) {
            if (acceso.equalsIgnoreCase(componente)) {
                contiene = true;
            }
        }
        return contiene;
    }

    public void borrarPermisosPerfil() {
        for (int i = 0; i < accesos.size(); i++) {
            this.accesos.remove(i);
        }
    }

    public boolean crearPerfil() {
        return this.builder.crearPerfil(this.perfilName, this.accesos);
    }

    public boolean modificarPerfil() {
        return this.builder.modificarPerfil(this.perfilName, this.accesos);
    }

    public boolean borrarPerfil() {
        return this.builder.borrarPerfil(this.perfilName);
    }
}
