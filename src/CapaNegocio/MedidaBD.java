package CapaNegocio;

import CapaConexion.Conexion;
import CapaDatos.Medida;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MedidaBD {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sql;

    public DefaultTableModel reportarMedida() {

        DefaultTableModel modelo;
        String[] titulos = {"ID", "PRESENTACION", "EQUIVALENCIA"};
        String[] registros = new String[3];
        modelo = new DefaultTableModel(null, titulos);
        sql = "SELECT idmedida,mPresentacion,mEquivalencia FROM medida";

        try {

            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
            while (rs.next()) {
                registros[0] = rs.getString("idmedida");
                registros[1] = rs.getString("mPresentacion");
                registros[2] = rs.getString("mEquivalencia");

                modelo.addRow(registros);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Error al reportar Medida...", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return modelo;
    }

    public boolean registarMedida(Medida m) {

        sql = "INSERT INTO medida(idmedida,mPresentacion,mEquivalencia) VALUES(0,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, m.getMePresentacion());
            pst.setString(2, m.getMeEquivalencia());

            pst.executeUpdate();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e, "Problemas Al Registrar Medida..,", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean modificarMedida(Medida m) {

        sql = "UPDATE medida SET mPresentacion=?,mEquivalencia=? WHERE idmedida=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setString(1, m.getMePresentacion());
            pst.setString(2, m.getMeEquivalencia());
            pst.setInt(3, m.getIdmedida());

            pst.executeUpdate();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e, "Error al Modificar Medida", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean eliminarMedida(int codigo) {

        sql = "DELETE FROM medida WHERE idmedida=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, codigo);
            pst.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas Al Eliminar Un Medida BD ", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}
