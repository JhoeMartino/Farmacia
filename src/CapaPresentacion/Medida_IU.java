/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaPresentacion;

import CapaDatos.Medida;
import CapaNegocio.MedidaBD;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Martino
 */
public class Medida_IU extends javax.swing.JInternalFrame {

    /**
     * Creates new form Medida_IU
     */
    public Medida_IU() {
        initComponents();
        reportar_medidas();
    }

    private void reportar_medidas() {
        try {
            setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
            DefaultTableModel tabla_temporal;
            MedidaBD oMedidaBD = new MedidaBD();
            tabla_temporal = oMedidaBD.reportarMedida();
            
            tabla_reporte_medida.setModel(tabla_temporal);
            int cant = tabla_temporal.getRowCount();
            txtCantidad.setText("" + cant);

            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        } catch (Exception e) {
            setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            JOptionPane.showMessageDialog(this, e, "Problemas al reportar Medidad", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiar_cajas() {
        txtCodigo.setText("");
        txtCantidad.setText("");
        txtEquivalencia.setText("");
        txtPresentacion.setText("");

    }

    private void exito(String mensaje) {
        JOptionPane.showConfirmDialog(this, mensaje, "MENSAJE", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
    }

    private void error(String mensaje) {
        JOptionPane.showConfirmDialog(this, mensaje, "ERROR", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
    }

    private void advertencia(String mensaje) {
        JOptionPane.showConfirmDialog(this, mensaje, "ADVERTENCIA", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRegistrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtPresentacion = new javax.swing.JTextField();
        btnCerrar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_reporte_medida = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtEquivalencia = new javax.swing.JTextField();

        setTitle("MEDIDA");

        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardar.png"))); // NOI18N
        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        jLabel2.setText("PRESENTACION");

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lapiz.png"))); // NOI18N
        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar2.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/limpiar.png"))); // NOI18N
        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        jLabel1.setText("CODIGO");

        txtCodigo.setEditable(false);

        txtPresentacion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPresentacionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPresentacionFocusLost(evt);
            }
        });
        txtPresentacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPresentacionKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPresentacionKeyTyped(evt);
            }
        });

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cerrar.png"))); // NOI18N
        btnCerrar.setText("CERRAR");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        jLabel4.setText("CANTIDAD");

        txtCantidad.setEditable(false);

        tabla_reporte_medida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabla_reporte_medida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabla_reporte_medidaMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_reporte_medida);

        jLabel3.setText("EQUIVALENCIA");

        txtEquivalencia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEquivalenciaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEquivalenciaFocusLost(evt);
            }
        });
        txtEquivalencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEquivalenciaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEquivalenciaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRegistrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCerrar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEquivalencia)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtPresentacion))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtEquivalencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEliminar)
                        .addComponent(btnLimpiar)
                        .addComponent(btnCerrar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnRegistrar)
                        .addComponent(btnModificar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (txtPresentacion.getText().length() > 0) {
            if (txtEquivalencia.getText().length() > 0) {
                if (txtCodigo.getText().length() == 0) {

                    Medida oMedida = new Medida();
                    MedidaBD oMedidaBD = new MedidaBD();
                    oMedida.setMePresentacion(txtPresentacion.getText().toUpperCase().trim());
                    oMedida.setMeEquivalencia(txtEquivalencia.getText().toUpperCase().trim());
                    boolean rpta = oMedidaBD.registarMedida(oMedida);

                    if (rpta) {
                        exito("Se Registro Con Exito");
                        reportar_medidas();
                        limpiar_cajas();
                        txtPresentacion.requestFocus();
                    } else {
                        error("Tienes Problemas Al Registrar Medida");
                    }

                } else {
                    error("Ya Existe Esta Medida");
                }
            } else {
                advertencia("Ingrese Equivalencia");
                txtEquivalencia.requestFocus();
            }
        } else {
            advertencia("Ingrese la Presentacion");
            txtPresentacion.requestFocus();
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (txtPresentacion.getText().length() > 0) {
            if (txtEquivalencia.getText().length() > 0) {
                if (txtCodigo.getText().length() > 0) {

                    Medida oMedida = new Medida();
                    MedidaBD oMedidaBD = new MedidaBD();
                    
                    oMedida.setIdmedida(Integer.parseInt(txtCodigo.getText().trim()));
                    oMedida.setMePresentacion(txtPresentacion.getText().toUpperCase().trim());
                    oMedida.setMeEquivalencia(txtEquivalencia.getText().toUpperCase().trim());
                    
                    boolean rpta = oMedidaBD.modificarMedida(oMedida);

                    if (rpta) {
                        exito("Se Modifico Con Exito");
                        reportar_medidas();
                        limpiar_cajas();
                        txtPresentacion.requestFocus();
                    } else {
                        error("Tienes Problemas Al Modificar Medida");
                    }

                } else {
                    error("Tiene que seleccionar la Medida a Modificar");
                }
            } else {
                advertencia("Ingrese Equivalencia");
                txtEquivalencia.requestFocus();
            }
        } else {
            advertencia("Ingrese la Presentacion");
            txtPresentacion.requestFocus();
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (txtCodigo.getText().length() > 0) {
            int aviso = JOptionPane.showConfirmDialog(rootPane, "Estas seguro de eliminar");
            if (aviso == 0) {

                int codigo = Integer.parseInt(txtCodigo.getText());
                Medida oMedida = new Medida();
                MedidaBD oMedidaBD = new MedidaBD();
                
                oMedida.setIdmedida(codigo);
                boolean rpta = oMedidaBD.eliminarMedida(codigo);
                if (rpta) {
                    exito("Se Elimino Correctamente");
                    reportar_medidas();
                    limpiar_cajas();
                    txtPresentacion.requestFocus();
                } else {
                    error("Tienes Problemas al Eliminar");
                }
            }

        } else {
            advertencia("Ingrese un codigo");

        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar_cajas();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtPresentacionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPresentacionFocusGained
        txtPresentacion.setBackground(Color.cyan);
    }//GEN-LAST:event_txtPresentacionFocusGained

    private void txtPresentacionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPresentacionFocusLost
        txtPresentacion.setBackground(Color.white);
    }//GEN-LAST:event_txtPresentacionFocusLost

    private void txtPresentacionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPresentacionKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtEquivalencia.requestFocus();

        }
    }//GEN-LAST:event_txtPresentacionKeyPressed

    private void txtPresentacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPresentacionKeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c) || txtPresentacion.getText().length() >= 40) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPresentacionKeyTyped

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void tabla_reporte_medidaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_reporte_medidaMousePressed
        if (evt.getClickCount() == 2) {
            limpiar_cajas();
            int fila_seleccionada = tabla_reporte_medida.getSelectedRow();
            txtCodigo.setText(tabla_reporte_medida.getValueAt(fila_seleccionada, 0).toString());
            txtPresentacion.setText(tabla_reporte_medida.getValueAt(fila_seleccionada, 1).toString());
            txtEquivalencia.setText(tabla_reporte_medida.getValueAt(fila_seleccionada, 2).toString());
        }
    }//GEN-LAST:event_tabla_reporte_medidaMousePressed

    private void txtEquivalenciaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEquivalenciaFocusGained
       txtEquivalencia.setBackground(Color.cyan);
    }//GEN-LAST:event_txtEquivalenciaFocusGained

    private void txtEquivalenciaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEquivalenciaFocusLost
        txtEquivalencia.setBackground(Color.white);
    }//GEN-LAST:event_txtEquivalenciaFocusLost

    private void txtEquivalenciaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEquivalenciaKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
            btnRegistrar.requestFocus();
            btnRegistrar.doClick();
        }
    }//GEN-LAST:event_txtEquivalenciaKeyPressed

    private void txtEquivalenciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEquivalenciaKeyTyped
       char c = evt.getKeyChar();
        if (Character.isDigit(c) || txtEquivalencia.getText().length() >= 40) {
            evt.consume();
        }
    }//GEN-LAST:event_txtEquivalenciaKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_reporte_medida;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtEquivalencia;
    private javax.swing.JTextField txtPresentacion;
    // End of variables declaration//GEN-END:variables
}
