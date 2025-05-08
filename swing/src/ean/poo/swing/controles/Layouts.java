package ean.poo.swing.controles;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Layouts {
    public static JFrame flowlayout(int alignment) {
        JFrame f = new JFrame("FlowLayout");
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setLayout(new FlowLayout(alignment));
        
        for (int i = 0; i < 9; i++) {
            JButton btn = new JButton("Botón " + (i + 1));
            f.add(btn);
        }
        f.pack();
        return f;
    }

    public static JFrame boxlayout(int alignment) {
        JFrame f = new JFrame("BoxLayout");
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setLayout(new BoxLayout(f.getContentPane(), alignment));
        
        for (int i = 0; i < 5; i++) {
            JButton btn = new JButton("Botón " + (i + 1));
            f.getContentPane().add(btn);
        }
        f.pack();
        return f;
    }

    public static JFrame gridlayout(int nb, int filas, int columnas) {
        JFrame f = new JFrame("GridLayout");
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setLayout(new GridLayout( filas, columnas, 5, 5 ));
        
        for (int i = 0; i < nb; i++) {
            JButton btn = new JButton("Botón " + (i + 1));
            f.add(btn);
        }
        f.pack();
        return f;
    }

    public static JFrame borderlayout(int nb) {
        String[] pos = { BorderLayout.CENTER, BorderLayout.PAGE_START,  BorderLayout.LINE_START, BorderLayout.LINE_END,  BorderLayout.PAGE_END  };
        JFrame f = new JFrame("BorderLayout");
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        for (int i = 0; i < nb; i++) {
            JButton btn = new JButton("Botón " + (i + 1));
            f.add(btn, pos[i]);
        }
        f.pack();
        return f;
    }

    public static JFrame gridbaglayout() {
        JFrame ff = new JFrame("GridBagLayout");
        ff.setLayout(new BoxLayout(ff.getContentPane(), BoxLayout.Y_AXIS));
        ff.add(new JLabel("el titulo"));
        JPanel f = new JPanel();
        ff.add( f );
        ff.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setLayout(new GridBagLayout());
        
        JButton[] btns = new JButton[10];
        for (int i = 0; i < 10; i++) 
            btns[i] = new JButton("Botón " + (i ));
        
        GridBagConstraints gbc = new GridBagConstraints();
        f.add( btns[0], gbc);
        f.add( btns[1], gbc);
        f.add( btns[2], gbc);
        f.add( btns[3], gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridy = 1;
        gbc.gridwidth = 4;
        f.add( btns[4], gbc);

        gbc.gridy = 2;
        gbc.gridwidth = 3;
        f.add( btns[5], gbc);
        f.add( btns[6], gbc);

        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.VERTICAL;
        f.add( btns[7], gbc);

        gbc.gridheight = 1;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        f.add( btns[8], gbc);

        gbc.gridwidth = 3;
        gbc.gridy = 4;
        f.add( btns[9], gbc);

        ff.pack();
        return ff;
    }
}
