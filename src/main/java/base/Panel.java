package base;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class Panel implements ComponentListener {
    Panel() {
        JWindow f = new JWindow();
        JPanel panel = new JPanel();
        panel.setBounds(10, 10, 100, 90);
        JButton b1 = new JButton("Button 1");
        b1.setBounds(11, 11, 80, 30);
        b1.setBackground(Color.yellow);
        JButton b2 = new JButton("Button 2");
        b2.setBounds(11, 42, 80, 30);
        b2.setBackground(Color.green);
        panel.add(b1);
        panel.add(b2);
        f.add(panel);
        f.setSize(100, 90);
        f.setLayout(null);
        f.setVisible(true);
        panel.addComponentListener(this);
    }

    @Override
    public void componentResized(ComponentEvent e) {
        System.out.println("resised");
    }

    @Override
    public void componentMoved(ComponentEvent e) {
        System.out.println("moved");
    }

    @Override
    public void componentShown(ComponentEvent e) {
        System.out.println("shown");
    }

    @Override
    public void componentHidden(ComponentEvent e) {
        System.out.println("hidden");
    }
}
