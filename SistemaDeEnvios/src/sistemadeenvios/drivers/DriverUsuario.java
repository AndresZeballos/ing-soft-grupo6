/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeenvios.drivers;

import sistemadeenvios.stubs.*;
import java.util.ArrayList;
import sistemadeenvios.logic.IUsuario;
import sistemadeenvios.logic.IPerfilUsuario;
import sistemadeenvios.logic.Usuario;

/**
 *
 * @author Andres
 */
public class DriverUsuario {

    public static void main(String[] args) {
        perfilAdmin();
        perfilConsultor();
        perfilUsuario();

    }

    private static void perfilAdmin() {
        IUsuario user = new Usuario("admin");

    }

    private static void perfilConsultor() {
    }

    private static void perfilUsuario() {
    }
}
