/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeenvios.stubs;

import sistemadeenvios.logic.IPerfilUsuario;

/**
 *
 * @author agustin
 */
public class StubUsuarioAdministrador implements sistemadeenvios.logic.IUsuario {

    private String userName;

    public StubUsuarioAdministrador() {
        this.userName = "admin";
    }

    public boolean addPerfil(IPerfilUsuario perfilUsuario) {
        return true;
    }

    public boolean validarAcceso(String componente) {
        return true;
    }

    public boolean validarPassword(String password) {
        return password.equals("admin");
    }

    public String getUserName() {
        return this.userName;
    }

    public boolean crearUsuario() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean borrarUsuario() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean modificarUsuario() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
