/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeenvios.logic;

import sistemadeenvios.persistence.IUserBuilder;
import sistemadeenvios.stubs.StubUserBuilder;
import java.util.ArrayList;
import sistemadeenvios.persistence.IPerfilBuilder;
import sistemadeenvios.stubs.StubPerfilBuilder;

/*
 * @author Fede
 */
public class Usuario implements IUsuario {

    private ArrayList<IPerfilUsuario> listaPerfiles;
    private String userName, password;
    private IUserBuilder builder;

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @return the listaPerfiles
     */
    public ArrayList<IPerfilUsuario> getListaPerfiles() {
        return listaPerfiles;
    }

    public Usuario(String userName) {
        this.builder = StubUserBuilder.getInstance();
        if (this.builder.existeUserName(userName)) {
            this.userName = userName;
            this.password = this.builder.getPassword(userName);
            this.listaPerfiles = this.builder.getPerfiles(userName);
        }
    }

    public Usuario(String userName, String password,
            ArrayList<String> listaPerfiles) {
        this.builder = StubUserBuilder.getInstance();
        this.userName = userName;
        this.password = password;
        this.listaPerfiles = this.builder.getPerfiles(userName);
    }

    public boolean validarPassword(String password) {
        if (this.password == null) {
            return false;
        }
        return this.password.equals(password);
    }

    public boolean validarAcceso(String componente) {
        boolean permitirAcceso = true;
        boolean containsAcceso = false;
        for (IPerfilUsuario p : this.listaPerfiles) {
            if (p.tieneComponente(componente)) {
                containsAcceso = true;
                permitirAcceso = permitirAcceso && p.validarAcceso(componente);
            }
        }
        if (!containsAcceso) {
            permitirAcceso = false;
        }
        return permitirAcceso;
    }

    public boolean addPerfil(String perfilUsuario) {
        IPerfilBuilder perfilBuilder = StubPerfilBuilder.getInstance();
        if (perfilBuilder.existePerfil(perfilUsuario)) {
            IPerfilUsuario perfil = perfilBuilder.getPerfil(perfilUsuario);
            Boolean contiene = false;
            for (IPerfilUsuario p : listaPerfiles) {
                if (p.getPerfilName().equals(perfil.getPerfilName())) {
                    contiene = true;
                    break;
                }
            }
            if (!contiene) {
                this.listaPerfiles.add(perfil);
                return true;
            }
        }
        return false;
    }

    /*
     * se crea un user builder y se invoca el metodo de delete para borrar el
     * usuario de la base de datos.
     */
    public boolean crearUsuario() {
        ArrayList<String> lista = new ArrayList<String>();
        for (IPerfilUsuario p : this.listaPerfiles) {
            lista.add(p.getPerfilName());
        }
        return this.builder.crearUsuario(this.userName, this.password, lista);
    }

    public boolean borrarUsuario() {
        return this.builder.borrarUsuario(this.userName);
    }

    public boolean modificarUsuario() {
        ArrayList<String> lista = new ArrayList<String>();
        for (IPerfilUsuario p : this.listaPerfiles) {
            lista.add(p.getPerfilName());
        }
        return this.builder.crearUsuario(this.userName, this.password, lista);
    }
}
