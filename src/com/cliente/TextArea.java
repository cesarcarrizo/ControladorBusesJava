package com.cliente;

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
        area.setRows(40);
        area.setColumns(50);
        area.setEditable(false);// readonly
        area.setVisible(true);

        this.add(new JScrollPane(area));
    }

    public void logErase(String str) {

        area.setText(str);
    }

    public void logContinue(String str) {
        area.append(str);
    }

}
