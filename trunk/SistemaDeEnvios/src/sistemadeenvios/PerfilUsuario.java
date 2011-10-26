/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemadeenvios;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;
import sun.io.Converters;

/**
 *
 * @author Fede
 */
public class PerfilUsuario implements IPerfilUsuario{
    private Hashtable listaPermisos;
    private String nombrePerfil;
    public PerfilUsuario(String nombre)
    {
        this.nombrePerfil = nombre;
        this.listaPermisos = new Hashtable();
    }
    public void AgregarAcceso(String nombreComponente, boolean permitirAcesso)
    {
        this.listaPermisos.put(nombreComponente, permitirAcesso);
    }
    public boolean ValidarAcceso(String componente)
    {
        boolean permiso = false;
        if (this.listaPermisos.containsKey(componente))
        {
            Object o = listaPermisos.get(componente);
            permiso = Boolean.parseBoolean(String.valueOf(o));
        }
        return permiso;
    }
    public boolean TieneComponente(String componente)
    {
        return this.listaPermisos.containsKey(componente);
    }

    /**
     * @return the nombrePerfil
     */
    public String getNombrePerfil() {
        return nombrePerfil;
    }
}
