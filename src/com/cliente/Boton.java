
package com.cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Mario
 */
public class Boton extends JButton implements ActionListener {
    
    private String busString;
    private TextArea ta;

    public Boton(String text, TextArea ta) {
        super(text);
        
        this.ta = ta;
        addActionListener(this);
    }

    @Override public void actionPerformed(ActionEvent e) {
        
        JButton b = (JButton) e.getSource();
        busString = b.getText();
        
        ta.logErase(busString);
        
    }
    
}
