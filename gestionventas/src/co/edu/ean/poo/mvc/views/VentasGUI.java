package co.edu.ean.poo.mvc.views;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.plaf.basic.BasicComboBoxEditor;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;

import co.edu.ean.poo.mvc.controllers.Controller;
import co.edu.ean.poo.mvc.controllers.VentasController;
import co.edu.ean.poo.ventas.Vendedor;


/**
 * Ventana que muestra la información de los vendedores y sus ventas
 * Implementa la interfaz VentasView que permite identificarla como una vista
 * de ventas válida
 */
public class VentasGUI extends JFrame implements VentasView {
    private VentasController controller;
    private DefaultComboBoxModel<Vendedor> modeloComboBox;
    private JComboBox<Vendedor> comboBoxVendedores;
    private JLabel labelIdVendedor;
    private JLabel labelNombre;
    private JLabel labelApellido;
    private JLabel labelFechaIngreso;
    private JTable tablaVentas;
    private DefaultTableModel modeloTabla;
    private String nombreParcial;


    /**
     * Inicializa la ventana y todos sus componentes
     */
    private void inicializarGUI() {

        javax.swing.JLabel lbVendedores = new javax.swing.JLabel();
        comboBoxVendedores = new javax.swing.JComboBox<>();
        configurarComboBoxVendedores();
        javax.swing.JPanel panelDatosVendedor = new javax.swing.JPanel();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
        labelIdVendedor = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        labelApellido = new javax.swing.JLabel();
        labelFechaIngreso = new javax.swing.JLabel();
        javax.swing.JScrollPane panelVentas = new javax.swing.JScrollPane();
        modeloTabla = new DefaultTableModel(new Object[]{"Fecha", "Valor Venta", "Comisión"}, 0);
        tablaVentas = new javax.swing.JTable(modeloTabla);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Vendedores y sus ventas");

        lbVendedores.setLabelFor(comboBoxVendedores);
        lbVendedores.setText("Vendedor");

        comboBoxVendedores.setToolTipText("Digita el nombre del vendedor a visualizar");

        panelDatosVendedor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del vendedor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 0, 14), new java.awt.Color(0, 102, 102))); // NOI18N

        jLabel2.setText("ID");

        jLabel3.setText("Nombre");

        jLabel4.setText("Apellido");

        jLabel5.setText("Fecha de ingreso");

        javax.swing.GroupLayout panelDatosVendedorLayout = new javax.swing.GroupLayout(panelDatosVendedor);
        panelDatosVendedor.setLayout(panelDatosVendedorLayout);
        panelDatosVendedorLayout.setHorizontalGroup(
            panelDatosVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosVendedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(20, 20, 20)
                .addGroup(panelDatosVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelIdVendedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelApellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelFechaIngreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelDatosVendedorLayout.setVerticalGroup(
            panelDatosVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosVendedorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(labelIdVendedor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(labelNombre))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(labelApellido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDatosVendedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(labelFechaIngreso))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelVentas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ventas realizadas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 0, 14), new java.awt.Color(0, 102, 102))); // NOI18N

        tablaVentas.setAutoCreateRowSorter(true);
        
        DefaultTableCellRenderer renderizadorDerecha = new DefaultTableCellRenderer();
        renderizadorDerecha.setHorizontalAlignment(SwingConstants.RIGHT);
        tablaVentas.getColumnModel().getColumn(1).setCellRenderer(renderizadorDerecha);
        tablaVentas.getColumnModel().getColumn(2).setCellRenderer(renderizadorDerecha);
        panelVentas.setViewportView(tablaVentas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelVentas, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                    .addComponent(panelDatosVendedor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lbVendedores)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboBoxVendedores, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbVendedores)
                    .addComponent(comboBoxVendedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelDatosVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelVentas, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }

    // private void inicializarGUI() {
    //     setTitle("Visualización de Ventas");
    //     //setSize(600, 400);
    //     setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    //     setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

    //     // Sección superior: JComboBox editable
    //     comboBoxVendedores = new JComboBox<>();
    //     configurarComboBoxVendedores();
    //     add(comboBoxVendedores);

    //     // Sección media: Detalles del vendedor con JLabel
    //     JPanel panelDetalles = new JPanel(new GridLayout(4, 2));
    //     panelDetalles.add(new JLabel("ID:"));
    //     labelIdVendedor = new JLabel();
    //     panelDetalles.add(labelIdVendedor);
    //     panelDetalles.add(new JLabel("Nombre:"));
    //     labelNombre = new JLabel();
    //     panelDetalles.add(labelNombre);
    //     panelDetalles.add(new JLabel("Apellido:"));
    //     labelApellido = new JLabel();
    //     panelDetalles.add(labelApellido);
    //     panelDetalles.add(new JLabel("Fecha de Ingreso:"));
    //     labelFechaIngreso = new JLabel();
    //     panelDetalles.add(labelFechaIngreso);
    //     add(panelDetalles);

    //     // Sección inferior: Tabla de ventas
    //     modeloTabla = new DefaultTableModel(new Object[]{"Fecha", "Valor Venta", "Comisión"}, 0);
    //     tablaVentas = new JTable(modeloTabla);
    //     tablaVentas.setAutoCreateRowSorter(true);
    //     DefaultTableCellRenderer renderizadorDerecha = new DefaultTableCellRenderer();
    //     renderizadorDerecha.setHorizontalAlignment(SwingConstants.RIGHT);
    //     tablaVentas.getColumnModel().getColumn(1).setCellRenderer(renderizadorDerecha);
    //     tablaVentas.getColumnModel().getColumn(2).setCellRenderer(renderizadorDerecha);
    //     add(new JScrollPane(tablaVentas) );
    //     pack();
    // }

    /**
     * configura todas las propiedades requeridas del JComboBox
     * y le agrega todos los eventos necesarios para permitir
     * filtrar los vendedores y mostrar sus detalles cuando
     * se selecciona uno
     */
    private void configurarComboBoxVendedores() {
        modeloComboBox = new DefaultComboBoxModel<>();
        comboBoxVendedores.setModel(modeloComboBox);
        comboBoxVendedores.setPreferredSize(new Dimension(300,25));
        comboBoxVendedores.setEditable(true);
        comboBoxVendedores.setSelectedItem(null);


        // Permite que se muestre el nombre y apellido del vendedor en el JComboBox en lugar de vendedor.toString()
        comboBoxVendedores.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<? extends Object> list, Object value, int index,
                    boolean isSelected, boolean cellHasFocus) {
                var v = (Vendedor)value;
                var nombre = "%s %s".formatted(v.getNombre(), v.getApellido());
                return super.getListCellRendererComponent(list, nombre, index, isSelected, cellHasFocus);
            }
        });

        // Muestre los detalles del vendedor seleccionado en el JComboBox
        comboBoxVendedores.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                var obj = comboBoxVendedores.getSelectedItem();
                if ( obj != null && obj instanceof Vendedor v) {
                    controller.vendedorSeleccionado(v);
                }
            }
        });

        // permite filtrar los vendedores en el JComboBox cada vez que se escribe el nombre de uno
        var ec = new BasicComboBoxEditor() {
            @Override
            public void setItem(Object anObject) {
                if (anObject == null) {
                    // Si el objeto es nulo (ej., al limpiar la selección), establece el texto vacío.
                    ((JTextComponent) editor).setText("");
                } else if (anObject instanceof Vendedor v) {
                    // Si es un Vendedor, muestra su nombre.
                    ((JTextComponent) editor).setText(v.getNombre() + " " + v.getApellido());
                } 
            }
        };
        comboBoxVendedores.setEditor(ec);

        // Captura los eventos de escritura en el editor del JComboBox para ir filtrando
        // vendedores a medida que se escribe el nombre
        var ecc = (JTextComponent) comboBoxVendedores.getEditor().getEditorComponent();
        ecc.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                var kc = e.getKeyCode();
                if ( kc >= 'a' && kc <= 'z' || kc >= 'A' && kc <= 'Z' || 
                     kc == KeyEvent.VK_SPACE || kc == KeyEvent.VK_BACK_SPACE ) {
                    nombreParcial = ecc.getText();
                    controller.filtrarVendedores(nombreParcial);
                }
            }

            // Si se presiona Enter, se selecciona el vendedor y se muestran sus detalles
            // Si se presiona flecha arriba o abajo, se navega por la lista de vendedores
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    var si = comboBoxVendedores.getSelectedItem();
                    if (si != null && si instanceof Vendedor v) {
                        ecc.setText(v.getNombre() + " " + v.getApellido());
                        controller.vendedorSeleccionado(v);
                    }
                } else if ( e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_UP ) {
                    comboBoxVendedores.dispatchEvent(e);
                }
            }
        });
    }


    /**
     * Actualiza la lista de vendedores en el JComboBox
     */
    @Override
    public void setListaVendedores(List<Vendedor> vendedores ) {
        if ( controller == null ) return;
        modeloComboBox.removeAllElements();
        modeloComboBox.addAll(vendedores);
        // Si hay un nombre parcial, significa que la ventana es visible
        // y que estoy escribiendo en el editor del JComboBox
        if ( nombreParcial != null && ! nombreParcial.isBlank() ) {
            var ec = (JTextComponent) comboBoxVendedores.getEditor().getEditorComponent();
            ec.setText( nombreParcial );
            comboBoxVendedores.showPopup();
        }
    }

    /**
     * Muestra los detalles del vendedor seleccionado en el JComboBox
     * Esto es, los datos del vendedor y las ventas que ha realizado
     * @param v Vendedor seleccionado
     */
    @Override
    public void mostrarDetallesVendedor( Vendedor v ) {
        if ( v == null ) return;
        labelIdVendedor.setText(String.valueOf(v.getNumeroVendedor() ) );
        labelNombre.setText(v.getNombre());
        labelApellido.setText(v.getApellido());
        labelFechaIngreso.setText(v.getFechaIngreso().toString() );

        // Limpiar la tabla de ventas y la pobla nuevamente con
        // las ventas del vendedor seleccionado
        modeloTabla.setRowCount(0);
        for ( var venta : v.getVentas() ) {
            if ( venta == null ) continue;
            modeloTabla.addRow(new Object[]{ 
                venta.fecha(), 
                String.format("%,d", venta.valor() ), 
                String.format("%,.2f", controller.calcularComision(v, venta).comision() 
                )
            });
        }
    }

    /**
     * Hace que la ventana se haga visible solamente si se tiene establecido un controller
     * @throws IllegalStateException si el controlador no ha sido inicializado
     */
    @Override
    public void mostrarVista() {
        if (controller == null) {
            throw new IllegalStateException("El controlador no ha sido inicializado");
        }
        SwingUtilities.invokeLater( new Runnable() {
            @Override
            public void run() {
                setVisible(true);
            }
        });
    }

    @Override
    public void ocultarVista() {
        dispose();
    }

    @Override
    public void setController(Controller c) {
        if( c instanceof VentasController vc )
            controller = vc;
        else
            throw new IllegalArgumentException("La vista de ventas debe tener un VentasController");
        // los componentes gráficos de la ventana solamente se inicializan
        // una vez el controlador ha sido establecido
        inicializarGUI();
    }
}
