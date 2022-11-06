/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.iudigital.cruddao.presentacion;

import com.iudigital.cruddao.controller.FuncionarioController;
import com.iudigital.cruddao.dominio.Funcionario;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author personal
 */
public class Main2 extends javax.swing.JFrame {
    private final FuncionarioController funcionarioController;
    private static final String[] COLUMNS = { "ID", "TIPO IDENTIFICACION", "IDENTIFICACION", "NOMBRES", "APELLIDOS", "ESTADO CIVIL", "SEXO", "DIRECCION", "TELEFONO", "FECHA DE NACIMIENTO", "TITULO ACADEMICO", "NIVEL ACADEMICO", "UNIVERSIDAD" };
    private static final String SELECCIONE = "-- SELECCIONE --";

    /**
     * Creates new form Main2
     */
    public Main2() {
        initComponents();
        txtFuncionarioId.setEditable(false);
        funcionarioController = new FuncionarioController();
        listarFuncionarios();
        addListener();
    }
    
    private void listarFuncionarios() {
        cbxFuncionarios.removeAllItems();
        
        Funcionario funcionario1 = new Funcionario();
        funcionario1.setNombres(SELECCIONE);
        funcionario1.setApellidos("");
        cbxFuncionarios.addItem(funcionario1);
        tblFuncionarios.removeAll();
        
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        for (String COLUMN: COLUMNS) {
            defaultTableModel.addColumn(COLUMN);
        }
        
        tblFuncionarios.setModel(defaultTableModel);
        
        try {
            List<Funcionario> funcionarios = funcionarioController.obtener();
            if (funcionarios.isEmpty()) {
                return;
            }
            
            defaultTableModel.setRowCount(funcionarios.size());
            
            int row = 0;
            for (Funcionario funcionario: funcionarios) {
                defaultTableModel.setValueAt(funcionario.getId(), row, 0);
                defaultTableModel.setValueAt(funcionario.getTipoIdentificacion(), row, 1);
                defaultTableModel.setValueAt(funcionario.getIdentificacion(), row, 2);
                defaultTableModel.setValueAt(funcionario.getNombres(), row, 3);
                defaultTableModel.setValueAt(funcionario.getApellidos(), row, 4);
                defaultTableModel.setValueAt(funcionario.getEstadoCivil(), row, 5);
                defaultTableModel.setValueAt(funcionario.getSexo(), row, 6);
                defaultTableModel.setValueAt(funcionario.getDireccion(), row, 7);
                defaultTableModel.setValueAt(funcionario.getTelefono(), row, 8);
                defaultTableModel.setValueAt(funcionario.getFechaNacimiento(), row, 9);
                defaultTableModel.setValueAt(funcionario.getTituloGrado(), row, 10);
                defaultTableModel.setValueAt(funcionario.getNivelAcademico(), row, 11);
                defaultTableModel.setValueAt(funcionario.getUniversidad(), row, 12);
                row++;
                
                cbxFuncionarios.addItem(funcionario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }   
    }
    
    private void addListener() {
        cbxFuncionarios.addItemListener(event -> {
            Funcionario selectedFuncionario = (Funcionario) event.getItem();
            if (selectedFuncionario.getNombres().equals(SELECCIONE)) {
                txtFuncionarioId.setText("");
                txtTipoIdentificacionEdit.setText("");
                txtIdentificacionEdit.setText("");
                txtNombresEdit.setText("");
                txtApellidosEdit.setText("");
                txtEstadoCivilEdit.setText("");
                txtSexoEdit.setText("");
                txtDireccionEdit.setText("");
                txtTelefonoEdit.setText("");
                txtFechaNacimientoEdit.setText("");
                txtTituloGradoEdit.setText("");
                txtNivelAcademicoEdit.setText("");
                txtUniversidadEdit.setText("");
            } else {
                txtFuncionarioId.setText(String.valueOf(selectedFuncionario.getId()));
                txtTipoIdentificacionEdit.setText(selectedFuncionario.getTipoIdentificacion());
                txtIdentificacionEdit.setText(selectedFuncionario.getIdentificacion());
                txtNombresEdit.setText(selectedFuncionario.getNombres());
                txtApellidosEdit.setText(selectedFuncionario.getApellidos());
                txtEstadoCivilEdit.setText(selectedFuncionario.getEstadoCivil());
                txtSexoEdit.setText(selectedFuncionario.getSexo());
                txtDireccionEdit.setText(selectedFuncionario.getDireccion());
                txtTelefonoEdit.setText(selectedFuncionario.getTelefono());
                txtFechaNacimientoEdit.setText(selectedFuncionario.getFechaNacimiento().toString());
                txtTituloGradoEdit.setText(selectedFuncionario.getTituloGrado());
                txtNivelAcademicoEdit.setText(selectedFuncionario.getNivelAcademico());
                txtUniversidadEdit.setText(selectedFuncionario.getUniversidad());
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTPanels = new javax.swing.JTabbedPane();
        jPFuncionario = new javax.swing.JPanel();
        jPFuncionario1 = new javax.swing.JPanel();
        lblTipoIdentificacion = new javax.swing.JLabel();
        lblIdentificacion = new javax.swing.JLabel();
        lblNombres = new javax.swing.JLabel();
        lblApellidos = new javax.swing.JLabel();
        lblEstadoCivil = new javax.swing.JLabel();
        lblSexo = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblFechaNacimiento = new javax.swing.JLabel();
        lblTituloGrado = new javax.swing.JLabel();
        lblNivelAcademico = new javax.swing.JLabel();
        lblUniversidad = new javax.swing.JLabel();
        txtTipoIdentificacion = new javax.swing.JTextField();
        txtIdentificacion = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        txtApellidos = new javax.swing.JTextField();
        txtEstadoCivil = new javax.swing.JTextField();
        txtSexo = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtFechaNacimiento = new javax.swing.JTextField();
        txtTituloGrado = new javax.swing.JTextField();
        txtNivelAcademico = new javax.swing.JTextField();
        txtUniversidad = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblFuncionarios = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        editPanel = new javax.swing.JPanel();
        lblFuncionarios = new javax.swing.JLabel();
        lblFuncionarioId = new javax.swing.JLabel();
        lblIdentificacionEdit = new javax.swing.JLabel();
        lblNombresEdit = new javax.swing.JLabel();
        lblApellidosEdit = new javax.swing.JLabel();
        lblEstadoCivilEdit = new javax.swing.JLabel();
        lblSexoEdit = new javax.swing.JLabel();
        lblDireccionEdit = new javax.swing.JLabel();
        lblTelefonoEdit = new javax.swing.JLabel();
        lblFechaNacimientoEdit = new javax.swing.JLabel();
        lblTituloGradoEdit = new javax.swing.JLabel();
        lblNivelAcademicoEdit = new javax.swing.JLabel();
        lblUniversidadEdit = new javax.swing.JLabel();
        lblTipoIdentificacionEdit = new javax.swing.JLabel();
        txtFuncionarioId = new javax.swing.JTextField();
        txtTipoIdentificacionEdit = new javax.swing.JTextField();
        txtIdentificacionEdit = new javax.swing.JTextField();
        txtNombresEdit = new javax.swing.JTextField();
        txtApellidosEdit = new javax.swing.JTextField();
        txtEstadoCivilEdit = new javax.swing.JTextField();
        txtSexoEdit = new javax.swing.JTextField();
        txtDireccionEdit = new javax.swing.JTextField();
        txtTelefonoEdit = new javax.swing.JTextField();
        txtFechaNacimientoEdit = new javax.swing.JTextField();
        txtTituloGradoEdit = new javax.swing.JTextField();
        txtNivelAcademicoEdit = new javax.swing.JTextField();
        txtUniversidadEdit = new javax.swing.JTextField();
        cbxFuncionarios = new javax.swing.JComboBox<>();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(jTable4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("GESTION DE FUNCIONARIOS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, -1, -1));

        jPFuncionario1.setBorder(javax.swing.BorderFactory.createTitledBorder("Digite los siguientes campos"));

        lblTipoIdentificacion.setText("TIPO DE IDENTIFICACION");

        lblIdentificacion.setText("IDENTIFICACION");

        lblNombres.setText("NOMBRES");

        lblApellidos.setText("APELLIDOS");

        lblEstadoCivil.setText("ESTADO CIVIL");

        lblSexo.setText("SEXO");

        lblDireccion.setText("DIRECCION");

        lblTelefono.setText("TELEFONO");

        lblFechaNacimiento.setText("FECHA DE NACIMIENTO");

        lblTituloGrado.setText("TITULO ACADEMICO");

        lblNivelAcademico.setText("NIVEL ACADEMICO");

        lblUniversidad.setText("UNIVERSIDAD");

        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPFuncionario1Layout = new javax.swing.GroupLayout(jPFuncionario1);
        jPFuncionario1.setLayout(jPFuncionario1Layout);
        jPFuncionario1Layout.setHorizontalGroup(
            jPFuncionario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPFuncionario1Layout.createSequentialGroup()
                .addComponent(txtTituloGrado, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtNivelAcademico, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtUniversidad, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPFuncionario1Layout.createSequentialGroup()
                .addGroup(jPFuncionario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPFuncionario1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTituloGrado, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblNivelAcademico)
                        .addGap(18, 18, 18)
                        .addComponent(lblUniversidad))
                    .addGroup(jPFuncionario1Layout.createSequentialGroup()
                        .addComponent(txtTipoIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPFuncionario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblApellidos))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPFuncionario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEstadoCivil)
                            .addGroup(jPFuncionario1Layout.createSequentialGroup()
                                .addComponent(txtEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPFuncionario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPFuncionario1Layout.createSequentialGroup()
                                        .addComponent(txtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPFuncionario1Layout.createSequentialGroup()
                        .addComponent(lblTipoIdentificacion)
                        .addGap(24, 24, 24)
                        .addComponent(lblIdentificacion)
                        .addGap(29, 29, 29)
                        .addComponent(lblNombres)
                        .addGap(206, 206, 206)
                        .addComponent(lblSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblDireccion)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 194, Short.MAX_VALUE)
                .addGroup(jPFuncionario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTelefono, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPFuncionario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFechaNacimiento)
                    .addGroup(jPFuncionario1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
        );
        jPFuncionario1Layout.setVerticalGroup(
            jPFuncionario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPFuncionario1Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPFuncionario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipoIdentificacion)
                    .addComponent(lblIdentificacion)
                    .addComponent(lblNombres)
                    .addComponent(lblApellidos)
                    .addComponent(lblSexo)
                    .addComponent(lblDireccion)
                    .addComponent(lblTelefono)
                    .addComponent(lblFechaNacimiento)
                    .addComponent(lblEstadoCivil))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPFuncionario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTipoIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPFuncionario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTituloGrado)
                    .addComponent(lblNivelAcademico)
                    .addComponent(lblUniversidad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPFuncionario1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTituloGrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNivelAcademico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUniversidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(btnGuardar)
                .addContainerGap())
        );

        tblFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane5.setViewportView(tblFuncionarios);

        javax.swing.GroupLayout jPFuncionarioLayout = new javax.swing.GroupLayout(jPFuncionario);
        jPFuncionario.setLayout(jPFuncionarioLayout);
        jPFuncionarioLayout.setHorizontalGroup(
            jPFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPFuncionarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPFuncionario1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane5))
                .addContainerGap())
        );
        jPFuncionarioLayout.setVerticalGroup(
            jPFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPFuncionarioLayout.createSequentialGroup()
                .addComponent(jPFuncionario1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTPanels.addTab("Crear Funcionario", jPFuncionario);

        lblFuncionarios.setText("FUNCIONARIOS");

        lblFuncionarioId.setText("ID");

        lblIdentificacionEdit.setText("IDENTIFICACION");

        lblNombresEdit.setText("NOMBRES");

        lblApellidosEdit.setText("APELLIDOS");

        lblEstadoCivilEdit.setText("ESTADO CIVIL");

        lblSexoEdit.setText("SEXO");

        lblDireccionEdit.setText("DIRECCION");

        lblTelefonoEdit.setText("TELEFONO");

        lblFechaNacimientoEdit.setText("FECHA DE NACIMIENTO");

        lblTituloGradoEdit.setText("TITULO ACADEMICO");

        lblNivelAcademicoEdit.setText("NIVEL ACADEMICO");

        lblUniversidadEdit.setText("UNIVERSIDAD");

        lblTipoIdentificacionEdit.setText("TIPO DE IDENTIFICACION");

        javax.swing.GroupLayout editPanelLayout = new javax.swing.GroupLayout(editPanel);
        editPanel.setLayout(editPanelLayout);
        editPanelLayout.setHorizontalGroup(
            editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editPanelLayout.createSequentialGroup()
                        .addGroup(editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblFuncionarioId, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFuncionarioId, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTipoIdentificacionEdit)
                            .addGroup(editPanelLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(txtTipoIdentificacionEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblIdentificacionEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtIdentificacionEdit))
                        .addGap(18, 18, 18)
                        .addGroup(editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(editPanelLayout.createSequentialGroup()
                                .addComponent(lblNombresEdit)
                                .addGap(70, 70, 70)
                                .addComponent(lblApellidosEdit))
                            .addGroup(editPanelLayout.createSequentialGroup()
                                .addComponent(txtNombresEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtApellidosEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30)
                        .addGroup(editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEstadoCivilEdit)
                            .addComponent(txtEstadoCivilEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSexoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSexoEdit))
                        .addGap(32, 32, 32)
                        .addGroup(editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDireccionEdit)
                            .addComponent(txtDireccionEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addGroup(editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTelefonoEdit)
                            .addComponent(txtTelefonoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblFechaNacimientoEdit)
                            .addComponent(txtFechaNacimientoEdit)))
                    .addGroup(editPanelLayout.createSequentialGroup()
                        .addComponent(lblFuncionarios)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(editPanelLayout.createSequentialGroup()
                .addGroup(editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editPanelLayout.createSequentialGroup()
                        .addGroup(editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTituloGradoEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTituloGradoEdit))
                        .addGap(18, 18, 18)
                        .addGroup(editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblNivelAcademicoEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNivelAcademicoEdit))
                        .addGap(18, 18, 18)
                        .addGroup(editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUniversidadEdit)
                            .addComponent(txtUniversidadEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(cbxFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        editPanelLayout.setVerticalGroup(
            editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblFuncionarios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFuncionarioId)
                    .addComponent(lblIdentificacionEdit)
                    .addComponent(lblNombresEdit)
                    .addComponent(lblApellidosEdit)
                    .addComponent(lblEstadoCivilEdit)
                    .addComponent(lblSexoEdit)
                    .addComponent(lblDireccionEdit)
                    .addComponent(lblTelefonoEdit)
                    .addComponent(lblFechaNacimientoEdit)
                    .addComponent(lblTipoIdentificacionEdit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFuncionarioId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTipoIdentificacionEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdentificacionEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombresEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellidosEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEstadoCivilEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSexoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccionEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefonoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFechaNacimientoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTituloGradoEdit)
                    .addComponent(lblNivelAcademicoEdit)
                    .addComponent(lblUniversidadEdit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTituloGradoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNivelAcademicoEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUniversidadEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(editPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnActualizar)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar)
                .addGap(455, 455, 455))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(editPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminar))
                .addGap(0, 161, Short.MAX_VALUE))
        );

        jTPanels.addTab("Editar Funcionario", jPanel1);

        getContentPane().add(jTPanels, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 1150, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (txtTipoIdentificacion.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debe digitar tipo de identificacion");
            txtTipoIdentificacion.requestFocus();
            return;
        }
        
        if (txtIdentificacion.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debe digitar numero de identificacion");
            txtIdentificacion.requestFocus();
            return;
        }
        
        if (txtNombres.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debe digitar nombres");
            txtNombres.requestFocus();
            return;
        }
        
        if (txtApellidos.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debe digitar apellidos");
            txtApellidos.requestFocus();
            return;
        }
        
        if (txtEstadoCivil.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debe digitar estado civil");
            txtEstadoCivil.requestFocus();
            return;
        }
        
        if (txtSexo.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debe digitar sexo");
            txtSexo.requestFocus();
            return;
        }
        
        if (txtDireccion.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debe digitar direccion");
            txtDireccion.requestFocus();
            return;
        }
        
        if (txtTelefono.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debe digitar telefono");
            txtTelefono.requestFocus();
            return;
        }
        
        if (txtFechaNacimiento.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debe digitar fecha de nacimiento en el formato YYYY-MM-DD");
            txtFechaNacimiento.requestFocus();
            return;
        }
        
        if (txtTituloGrado.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debe digitar titulo de grado academico");
            txtTituloGrado.requestFocus();
            return;
        }
        
        if (txtNivelAcademico.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debe digitar nivel academico");
            txtNivelAcademico.requestFocus();
            return;
        }
        
        if (txtUniversidad.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debe digitar universidad");
            txtUniversidad.requestFocus();
            return;
        }
        
        try {
            Funcionario funcionario = new Funcionario();
            funcionario.setTipoIdentificacion(txtTipoIdentificacion.getText());
            funcionario.setIdentificacion(txtIdentificacion.getText());
            funcionario.setNombres(txtNombres.getText());
            funcionario.setApellidos(txtApellidos.getText());
            funcionario.setEstadoCivil(txtEstadoCivil.getText());
            funcionario.setSexo(txtSexo.getText());
            funcionario.setDireccion(txtDireccion.getText());
            funcionario.setTelefono(txtTelefono.getText());
            Date fechaNacimiento = new SimpleDateFormat("yyyy-MM-dd").parse(txtFechaNacimiento.getText());
            funcionario.setFechaNacimiento(fechaNacimiento);
            funcionario.setTituloGrado(txtTituloGrado.getText());
            funcionario.setNivelAcademico(txtNivelAcademico.getText());
            funcionario.setUniversidad(txtUniversidad.getText());

            funcionarioController.crear(funcionario);
            
            txtTipoIdentificacion.setText("");
            txtIdentificacion.setText("");
            txtNombres.setText("");
            txtApellidos.setText("");
            txtEstadoCivil.setText("");
            txtSexo.setText("");
            txtDireccion.setText("");
            txtTelefono.setText("");
            txtFechaNacimiento.setText("");
            txtTituloGrado.setText("");
            txtNivelAcademico.setText("");
            txtUniversidad.setText("");
            listarFuncionarios();
            JOptionPane.showMessageDialog(null, "Funcionario creado con exito");
        } catch (SQLException|ParseException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "No fue posible crear el funcionario");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if (txtFuncionarioId.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccionar un funcionario de la lista");
            txtFuncionarioId.requestFocus();
            return;
        }
        
        if (txtTipoIdentificacionEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debe digitar tipo de identificacion");
            txtTipoIdentificacionEdit.requestFocus();
            return;
        }
        
        if (txtIdentificacionEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debe digitar numero de identificacion");
            txtIdentificacionEdit.requestFocus();
            return;
        }
        
        if (txtNombresEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debe digitar nombres");
            txtNombresEdit.requestFocus();
            return;
        }
        
        if (txtApellidosEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debe digitar apellidos");
            txtApellidosEdit.requestFocus();
            return;
        }
        
        if (txtEstadoCivilEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debe digitar estado civil");
            txtEstadoCivilEdit.requestFocus();
            return;
        }
        
        if (txtSexoEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debe digitar sexo");
            txtSexoEdit.requestFocus();
            return;
        }
        
        if (txtDireccionEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debe digitar direccion");
            txtDireccionEdit.requestFocus();
            return;
        }
        
        if (txtTelefonoEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debe digitar telefono");
            txtTelefonoEdit.requestFocus();
            return;
        }
        
        if (txtFechaNacimientoEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debe digitar fecha de nacimiento en el formato YYYY-MM-DD");
            txtFechaNacimientoEdit.requestFocus();
            return;
        }
        
        if (txtTituloGradoEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debe digitar titulo de grado academico");
            txtTituloGradoEdit.requestFocus();
            return;
        }
        
        if (txtNivelAcademicoEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debe digitar nivel academico");
            txtNivelAcademicoEdit.requestFocus();
            return;
        }
        
        if (txtUniversidadEdit.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debe digitar universidad");
            txtUniversidadEdit.requestFocus();
            return;
        }
        
        int opt = JOptionPane.showConfirmDialog(null, "Desea actualizar el funcionario", "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opt == 0) {
            try {
                Funcionario funcionario = new Funcionario();
                funcionario.setTipoIdentificacion(txtTipoIdentificacionEdit.getText());
                funcionario.setIdentificacion(txtIdentificacionEdit.getText());
                funcionario.setNombres(txtNombresEdit.getText());
                funcionario.setApellidos(txtApellidosEdit.getText());
                funcionario.setEstadoCivil(txtEstadoCivilEdit.getText());
                funcionario.setSexo(txtSexoEdit.getText());
                funcionario.setDireccion(txtDireccionEdit.getText());
                funcionario.setTelefono(txtTelefonoEdit.getText());
                Date fechaNacimiento = new SimpleDateFormat("yyyy-MM-dd").parse(txtFechaNacimientoEdit.getText());
                funcionario.setFechaNacimiento(fechaNacimiento);
                funcionario.setTituloGrado(txtTituloGradoEdit.getText());
                funcionario.setNivelAcademico(txtNivelAcademicoEdit.getText());
                funcionario.setUniversidad(txtUniversidadEdit.getText());
                
                funcionarioController.actualizar(Integer.parseInt(txtFuncionarioId.getText()), funcionario);
                
                txtFuncionarioId.setText("");
                txtTipoIdentificacionEdit.setText("");
                txtIdentificacionEdit.setText("");
                txtNombresEdit.setText("");
                txtApellidosEdit.setText("");
                txtEstadoCivilEdit.setText("");
                txtSexoEdit.setText("");
                txtDireccionEdit.setText("");
                txtTelefonoEdit.setText("");
                txtFechaNacimientoEdit.setText("");
                txtTituloGradoEdit.setText("");
                txtNivelAcademicoEdit.setText("");
                txtUniversidadEdit.setText("");
                listarFuncionarios();
                JOptionPane.showMessageDialog(null, "Funcionario actualizado con exito");
            } catch (SQLException|ParseException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "No fue posible actualizar el funcionario");
            }
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (txtFuncionarioId.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccionar un funcionario de la lista");
            txtFuncionarioId.requestFocus();
            return;
        }
        
        int opt = JOptionPane.showConfirmDialog(null, "Esta seguro de borrar funcionario", "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opt == 0) {
            try {
                funcionarioController.eliminar(Integer.parseInt(txtFuncionarioId.getText()));
                
                txtFuncionarioId.setText("");
                txtTipoIdentificacionEdit.setText("");
                txtIdentificacionEdit.setText("");
                txtNombresEdit.setText("");
                txtApellidosEdit.setText("");
                txtEstadoCivilEdit.setText("");
                txtSexoEdit.setText("");
                txtDireccionEdit.setText("");
                txtTelefonoEdit.setText("");
                txtFechaNacimientoEdit.setText("");
                txtTituloGradoEdit.setText("");
                txtNivelAcademicoEdit.setText("");
                txtUniversidadEdit.setText("");
                listarFuncionarios();
                JOptionPane.showMessageDialog(null, "Se elminió funcionario correctamente");
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "No fue posible eliminar funcionario");
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<Funcionario> cbxFuncionarios;
    private javax.swing.JPanel editPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPFuncionario;
    private javax.swing.JPanel jPFuncionario1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTPanels;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblApellidosEdit;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblDireccionEdit;
    private javax.swing.JLabel lblEstadoCivil;
    private javax.swing.JLabel lblEstadoCivilEdit;
    private javax.swing.JLabel lblFechaNacimiento;
    private javax.swing.JLabel lblFechaNacimientoEdit;
    private javax.swing.JLabel lblFuncionarioId;
    private javax.swing.JLabel lblFuncionarios;
    private javax.swing.JLabel lblIdentificacion;
    private javax.swing.JLabel lblIdentificacionEdit;
    private javax.swing.JLabel lblNivelAcademico;
    private javax.swing.JLabel lblNivelAcademicoEdit;
    private javax.swing.JLabel lblNombres;
    private javax.swing.JLabel lblNombresEdit;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JLabel lblSexoEdit;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTelefonoEdit;
    private javax.swing.JLabel lblTipoIdentificacion;
    private javax.swing.JLabel lblTipoIdentificacionEdit;
    private javax.swing.JLabel lblTituloGrado;
    private javax.swing.JLabel lblTituloGradoEdit;
    private javax.swing.JLabel lblUniversidad;
    private javax.swing.JLabel lblUniversidadEdit;
    private javax.swing.JTable tblFuncionarios;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtApellidosEdit;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDireccionEdit;
    private javax.swing.JTextField txtEstadoCivil;
    private javax.swing.JTextField txtEstadoCivilEdit;
    private javax.swing.JTextField txtFechaNacimiento;
    private javax.swing.JTextField txtFechaNacimientoEdit;
    private javax.swing.JTextField txtFuncionarioId;
    private javax.swing.JTextField txtIdentificacion;
    private javax.swing.JTextField txtIdentificacionEdit;
    private javax.swing.JTextField txtNivelAcademico;
    private javax.swing.JTextField txtNivelAcademicoEdit;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JTextField txtNombresEdit;
    private javax.swing.JTextField txtSexo;
    private javax.swing.JTextField txtSexoEdit;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTelefonoEdit;
    private javax.swing.JTextField txtTipoIdentificacion;
    private javax.swing.JTextField txtTipoIdentificacionEdit;
    private javax.swing.JTextField txtTituloGrado;
    private javax.swing.JTextField txtTituloGradoEdit;
    private javax.swing.JTextField txtUniversidad;
    private javax.swing.JTextField txtUniversidadEdit;
    // End of variables declaration//GEN-END:variables
}
