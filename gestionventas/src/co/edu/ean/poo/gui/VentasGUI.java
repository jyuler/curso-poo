package co.edu.ean.poo.gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class VentasGUI extends JFrame {
    private VentasController controller;
    private JComboBox<VendedorGUI> comboBoxVendedores;
    private JLabel labelIdVendedor;
    private JLabel labelNombre;
    private JLabel labelApellido;
    private JLabel labelFechaIngreso;
    private JTable tablaVentas;
    private DefaultTableModel modeloTabla;


    public VentasGUI(VentasController c) {
        controller = c;
        inicializarGUI();
    }

    private void inicializarGUI() {
        setTitle("Visualización de Ventas");
        //setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Sección superior: JComboBox editable
        comboBoxVendedores = new JComboBox<>(controller.getComboboxModel());
        comboBoxVendedores.setPreferredSize(new Dimension(300,25));
        comboBoxVendedores.setEditable(true);
        comboBoxVendedores.setSelectedItem(null);
        comboBoxVendedores.addActionListener(e -> controller.mostrarDetallesVendedor(
            comboBoxVendedores.getSelectedItem(),
            labelIdVendedor, labelNombre, labelApellido, labelFechaIngreso,
            modeloTabla
        ));
        comboBoxVendedores.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                controller.filtrarVendedores(comboBoxVendedores);
            }
        });
        add(comboBoxVendedores);

        // Sección media: Detalles del vendedor con JLabel
        JPanel panelDetalles = new JPanel(new GridLayout(4, 2));
        panelDetalles.add(new JLabel("ID:"));
        labelIdVendedor = new JLabel();
        panelDetalles.add(labelIdVendedor);
        panelDetalles.add(new JLabel("Nombre:"));
        labelNombre = new JLabel();
        panelDetalles.add(labelNombre);
        panelDetalles.add(new JLabel("Apellido:"));
        labelApellido = new JLabel();
        panelDetalles.add(labelApellido);
        panelDetalles.add(new JLabel("Fecha de Ingreso:"));
        labelFechaIngreso = new JLabel();
        panelDetalles.add(labelFechaIngreso);
        add(panelDetalles);

        // Sección inferior: Tabla de ventas
        modeloTabla = new DefaultTableModel(new Object[]{"Fecha", "Valor Venta", "Comisión"}, 0);
        tablaVentas = new JTable(modeloTabla);
        tablaVentas.setAutoCreateRowSorter(true);
        DefaultTableCellRenderer renderizadorDerecha = new DefaultTableCellRenderer();
        renderizadorDerecha.setHorizontalAlignment(SwingConstants.RIGHT);
        tablaVentas.getColumnModel().getColumn(1).setCellRenderer(renderizadorDerecha);
        tablaVentas.getColumnModel().getColumn(2).setCellRenderer(renderizadorDerecha);
        add(new JScrollPane(tablaVentas) );
        pack();
    }


}
