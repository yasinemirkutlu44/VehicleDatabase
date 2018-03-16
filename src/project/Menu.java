package project;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu {
    private JButton AAAAButton;

    public Menu() {
        AAAAButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AAAAButton.setText("TIKLADI");
                super.mouseClicked(e);

            }
        });
    }
}
