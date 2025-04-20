package co.edu.ean.poo.gui;

import java.util.Collection;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import co.edu.ean.poo.comisiones.CalculadoraComisiones;
import co.edu.ean.poo.ventas.Vendedor;
import co.edu.ean.poo.ventas.Venta;

public class VentasController {
    private Collection<Vendedor> vendedores;
    
    public VentasController(Collection<Vendedor> vs ) {
        vendedores = vs;
    }

    void mostrarDetallesVendedor( Object ov, JLabel lbid, JLabel lbnm, JLabel lbap, JLabel lbf, DefaultTableModel modeloTabla ) {
        if (ov == null || ! (ov instanceof VendedorGUI) ) return;
        Vendedor v = (VendedorGUI) ov; 
        lbid.setText(String.valueOf(v.getNumeroVendedor() ) );
        lbnm.setText(v.getNombre());
        lbap.setText(v.getApellido());
        lbf.setText(v.getFechaIngreso().toString() );

        modeloTabla.setRowCount(0);
        for ( Venta venta : v.getVentas() ) {
            if ( venta == null ) continue;
            modeloTabla.addRow(new Object[]{ 
                venta.fecha(), 
                String.format("%,d", venta.valor() ), 
                String.format("%,.2f",
                    CalculadoraComisiones.calcularComision(v.getFechaIngreso(), venta.fecha(), venta.valor() ).comision() 
                )
            });
        }
    }

    ComboBoxModel<VendedorGUI> getComboboxModel() {
        VendedorGUI[] vgui = new VendedorGUI[ vendedores.size() ];
        int i=0;
        for( Vendedor v : vendedores ) {
            if ( v == null ) continue;
            vgui[i++] = new VendedorGUI( v );
        }
        return new DefaultComboBoxModel<VendedorGUI>( vgui );
    }

    void filtrarVendedores(JComboBox<VendedorGUI> cb) {
        System.out.println("filtrando...");
        String texto = ((JTextField) cb.getEditor().getEditorComponent()).getText();
        DefaultComboBoxModel<VendedorGUI> modelo = (DefaultComboBoxModel<VendedorGUI>) cb.getModel();

        modelo.removeAllElements();
        for (Vendedor vendedor : vendedores) {
            if (vendedor.getNombre().toLowerCase().contains(texto.toLowerCase()) || vendedor.getApellido().toLowerCase().contains(texto.toLowerCase())) {
                modelo.addElement(new VendedorGUI( vendedor ));
            }
        }
        ((JTextField) cb.getEditor().getEditorComponent()).setText(texto);
        cb.showPopup();
    }

    public void mostrarVentas() {
        SwingUtilities.invokeLater(() -> new VentasGUI(this).setVisible(true) );
    }
}
