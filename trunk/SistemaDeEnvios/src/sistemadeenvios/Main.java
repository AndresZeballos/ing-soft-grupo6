/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeenvios;

import sistemadeenvios.ui.VentPrincipal;
import sistemadeenvios.ui.Login;

/**
 *
 * @author Andres
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Login vp = new Login();
        vp.setVisible(true);
        vp.setDefaultCloseOperation(VentPrincipal.EXIT_ON_CLOSE);
    }
}
