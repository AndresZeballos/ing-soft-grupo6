/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sistemadeenvios.stubs;

/**
 *
 * @author Fede
 */
public class UsuarioAdministrador implements sistemadeenvios.IUsuario{
    public boolean validarAcceso(String componente)
    {
        return true;
    }
    public boolean validarPassword(String password)
    {
        return password.equals("admin");
    }
}
