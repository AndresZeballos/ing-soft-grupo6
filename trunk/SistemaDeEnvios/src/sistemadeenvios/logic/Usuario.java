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
        IUserBuilder userBuilder = new StubUserBuilder();
        if (userBuilder.existeUserName(userName)) {
            this.userName = userName;
            this.password = userBuilder.getPassword(userName);
            this.listaPerfiles = userBuilder.getPerfiles(userName);
        }
    }

    public Usuario(String userName, String password,
            ArrayList<String> listaPerfiles) {
        IUserBuilder userBuilder = new StubUserBuilder();
        this.userName = userName;
        this.password = password;
        this.listaPerfiles = userBuilder.getPerfiles(userName);
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
        IPerfilBuilder perfilBuilder = new StubPerfilBuilder();
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
        IUserBuilder constructor = new StubUserBuilder();
        ArrayList<String> lista = new ArrayList<String>();
        for (IPerfilUsuario p : this.listaPerfiles) {
            lista.add(p.getPerfilName());
        }
        return constructor.crearUsuario(this.userName, this.password, lista);
    }

    public boolean borrarUsuario() {
        IUserBuilder constructor = new StubUserBuilder();
        return constructor.borrarUsuario(this.userName);
    }

    public boolean modificarUsuario() {
        IUserBuilder constructor = new StubUserBuilder();
        ArrayList<String> lista = new ArrayList<String>();
        for (IPerfilUsuario p : this.listaPerfiles) {
            lista.add(p.getPerfilName());
        }
        return constructor.crearUsuario(this.userName, this.password, lista);
    }
}
