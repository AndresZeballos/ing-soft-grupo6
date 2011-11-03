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
        this.perfilName = perfilName;
        this.accesos = new ArrayList<String>();
        this.builder = new StubPerfilBuilder();
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
        for (Object comp : accesos.toArray())
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
    public boolean crearPerfil()
    {
        boolean resultado = true && this.builder.crearPerfil(this.perfilName);
        resultado = resultado && this.builder.modificarPerfil(this.perfilName, this.accesos);
        return resultado;
    }
    public boolean modificarPerfil()
    {
        return this.builder.modificarPerfil(this.perfilName, this.accesos);
    }
    public boolean borrarPerfil()
    {
        return this.builder.borrarPerfil(this.perfilName);
    }
}
