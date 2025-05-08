package ean.poo.swing.controles;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;

public class ControlesConModelo {
    public static JFrame combobox() {
        JFrame f = new JFrame("Lista desplegable");
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        String[] nombres = { "Juan", "Pedro", "Maria", "Ana" };
        JComboBox<String> cboNombres = new JComboBox<>(nombres);
        f.add(cboNombres);
        f.pack();

        cboNombres.setSelectedIndex(3);
        System.out.println( cboNombres.getSelectedIndex());
        System.out.println( cboNombres.getSelectedItem());

        return f;
    }

    public static JFrame lista() {
        JFrame f = new JFrame("Lista");
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        String[] nombres = { "Juan", "Pedro", "Maria", "Ana" };
        JList<String> lsNombres = new JList<>(nombres);
        f.add(lsNombres);
        f.pack();

        lsNombres.setSelectedIndex(1);
        System.out.println( lsNombres.getSelectedIndex());
        System.out.println( lsNombres.getSelectedValue());

        return f;
    }

    public static JFrame comboboxConModel() {
        JFrame f = new JFrame("Lista desplegable");
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       
        DefaultComboBoxModel<Persona> cbm = new DefaultComboBoxModel<>();
        cbm.addElement( new Persona(11,"Juan" ) );
        cbm.addElement( new Persona(20,"Pedro" ) );
        cbm.addElement( new Persona(30,"Maria" ) );
        cbm.addElement( new Persona(40,"Ana" ) );
        cbm.addElement( new Persona(50,"Luis" ) );
        cbm.addElement( new Persona(60,"Javier" ) );
        cbm.addElement( new Persona(70,"Jose" ) );
        cbm.addElement( new Persona(80,"Pablo" ) );
        cbm.addElement( new Persona(90,"Diego" ) );
        cbm.addElement( new Persona(10,"Andres" ) );
        
        JComboBox<Persona> cboNombres = new JComboBox<>(cbm);

        f.add(cboNombres);
        f.pack();
        return f;
    }
}
class Persona {
    int id; String nombre;
    Persona(int id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
