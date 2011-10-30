/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemadeenvios.logic;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;

/**
 *
 * @author agustin
 */
public class PerfilConsultar implements IPerfilUsuario{
    private Hashtable listaPermisos;

    public PerfilConsultar()
    {
        this.listaPermisos = new Hashtable();
    }

    public void agregarAcceso(String nombreComponente, boolean permitirAcesso)
    {
        this.listaPermisos.put(nombreComponente, permitirAcesso);
    }

    public boolean validarAcceso(String componente)
    {
        boolean permiso = false;
        if (this.listaPermisos.containsKey(componente))
        {
            Object o = listaPermisos.get(componente);
            permiso = Boolean.parseBoolean(String.valueOf(o));
        }
        return permiso;
    }

    public boolean tieneComponente(String componente)
    {
        return this.listaPermisos.containsKey(componente);
    }
}
