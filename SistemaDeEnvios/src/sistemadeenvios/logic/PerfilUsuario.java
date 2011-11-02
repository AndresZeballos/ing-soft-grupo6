/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeenvios.logic;

import java.util.ArrayList;

/**
 *
 * @author Andres
 */
public class PerfilUsuario implements IPerfilUsuario {

    private String perfilName;
    private ArrayList accesos;

    public PerfilUsuario(String perfilName) {
        this.perfilName = perfilName;
    }

    public String getPerfilName() {
        return perfilName;
    }

    public boolean validarAcceso(String componente) {
        return tieneComponente(componente);
    }

    public void agregarAcceso(String nombreComponente) {
        if (!tieneComponente(nombreComponente))
        {
            accesos.add(nombreComponente);
        }
    }

    public boolean tieneComponente(String componente) {
        boolean contiene = false;
        String acceso;
        for (Object comp : accesos)
        {
            acceso = (String)comp;
            if (acceso.equalsIgnoreCase(componente))
            {
                contiene = true;
            }
        }
        return contiene;
    }
    public void borrarTodo()
    {
        for (int i = 0; i < accesos.size(); i++)
        {
            this.accesos.remove(i);
        }
    }
}
