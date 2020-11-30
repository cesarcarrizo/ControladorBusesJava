package com.cliente;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;

/**
 *
 * @author Mario
 */
public class TextArea extends JPanel {

    private JTextArea area;

    public TextArea() {
        super();
     
        area = new JTextArea();
//        area.setRows(10);
//        area.setColumns(20);

        this.setLayout(new GridLayout(1,1));
        area.setEditable(false);// readonly
        area.setVisible(true);
        
        area.setFont(new Font("Bahnschrift", Font.BOLD, 18));
        area.setBackground(Color.BLACK);
        area.setForeground(Color.WHITE);

        this.add(new JScrollPane(area));
    }

    public void logErase(String str) {
        
        area.setText(str);
    }

    public void logContinue(String str) {
        area.append(str);
    }

}
