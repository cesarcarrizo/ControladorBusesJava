/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import com.cliente.Ventana;
import javax.swing.SwingUtilities;

/**
 *
 * @author Mario
 */
public class TestGUI {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Ventana v = new Ventana();

        });
    }
}
