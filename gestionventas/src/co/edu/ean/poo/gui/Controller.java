package co.edu.ean.poo.gui;

import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.ListDataListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import co.edu.ean.poo.comisiones.CalculadoraComisiones;
import co.edu.ean.poo.ventas.Vendedor;
import co.edu.ean.poo.ventas.Venta;

public class Controller {
    private List<Vendedor> vendedores;
    
    public Controller(List<Vendedor> ls ) {
        vendedores = ls;
    }

    void mostrarDetallesVendedor( Vendedor v, JLabel lbid, JLabel lbnm, JLabel lbap, JLabel lbf, DefaultTableModel modeloTabla ) {
        if (v == null) return;
        lbid.setText(String.valueOf(v.getNumeroVendedor() ) );
        lbnm.setText(v.getNombre());
        lbap.setText(v.getApellido());
        lbf.setText(v.getFechaIngreso().toString() );

        modeloTabla.setRowCount(0);
        for ( Venta venta : v.getVentas() ) {
            if ( venta == null ) continue;
            modeloTabla.addRow(new Object[]{ 
                venta.fecha(), 
                venta.valor(), 
                CalculadoraComisiones.calcularComision(v.getFechaIngreso(), venta.fecha(), venta.valor() ).comision() 
            });
        }
    }

    ComboBoxModel<Vendedor> getComboboxModel() {
        VendedorGUI[] vgui = new VendedorGUI[ vendedores.size() ];
        for( int i=0; i< vgui.length; i++ )
            if ( vendedores.get(i) != null )
                vgui[i] = new VendedorGUI( vendedores.get(i) );
        return new DefaultComboBoxModel<>( vgui );
    }

    void filtrarVendedores(JComboBox<Vendedor> cb) {
        System.out.println("filtrando...");
        String texto = ((JTextField) cb.getEditor().getEditorComponent()).getText();
        DefaultComboBoxModel<Vendedor> modelo = (DefaultComboBoxModel<Vendedor>) cb.getModel();

        modelo.removeAllElements();
        for (Vendedor vendedor : vendedores) {
            if (vendedor.getNombre().toLowerCase().contains(texto.toLowerCase()) || vendedor.getApellido().toLowerCase().contains(texto.toLowerCase())) {
                modelo.addElement(vendedor);
            }
        }
        ((JTextField) cb.getEditor().getEditorComponent()).setText(texto);
        cb.showPopup();
    }
}
