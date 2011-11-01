/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeenvios.logic;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;

/**
 *
 * @author Andres
 */
public class PerfilUsuario implements IPerfilUsuario {

    private String perfilName;
    private Hashtable accesos;

    public PerfilUsuario(String perfilName) {
        this.perfilName = perfilName;
    }

    public String getPerfilName() {
        return perfilName;
    }

    public boolean validarAcceso(String componente) {
        if (tieneComponente(componente)){
            return Boolean.parseBoolean(accesos.get(componente).toString());
        }
        return false;
    }

    public void agregarAcceso(String nombreComponente, boolean permitirAcesso) {
        if (tieneComponente(nombreComponente)) {
            accesos.remove(nombreComponente);
        }
        accesos.put(nombreComponente.toLowerCase(), permitirAcesso);
    }

    public boolean tieneComponente(String componente) {
        return accesos.containsKey(componente.toLowerCase());
    }
}
