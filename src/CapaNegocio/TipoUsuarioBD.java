/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaNegocio;

import CapaConexion.Conexion;
import CapaDatos.TipoUsuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TipoUsuarioBD {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sql;

    public DefaultTableModel reportarTipoUsuario() {

        DefaultTableModel modelo;
        String[] cabecera = {"CODIGO", "NOMBRE"};
        String[] registros = new String[2];
        modelo = new DefaultTableModel(null, cabecera);
        sql = "SELECT idtipousuario,tuNombre FROM tipousuario";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                registros[0] = rs.getString("idtipousuario");
                registros[1] = rs.getString("tuNombre");

                modelo.addRow(registros);
            }
            return modelo;

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e, "Error al reportar usuario...", JOptionPane.ERROR_MESSAGE);
            return null;

        }
    }

    public boolean registrarTipoUsuario(TipoUsuario u) {

        sql = "INSERT INTO tipousuario(idtipousuario,tuNombre) VALUES (0,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, u.getTuNombre());

            pst.executeUpdate();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e, "Problemas al registrar", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean modificarTipoUsuario(TipoUsuario u) {

        sql = "UPDATE tipousuario SET tuNombre =? WHERE idtipousuario =?";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setString(1, u.getTuNombre());
            pst.setInt(2, u.getIdtipousuario());

            pst.executeUpdate();
            return true;
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e);
            return false;
        }
    }

    public boolean eliminarTipoUsuario(TipoUsuario u) {

        sql = "DELETE from tipousuario WHERE idtipousuario=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, u.getIdtipousuario());

            pst.executeUpdate();
            return true;
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e, "Problemas al eliminar",JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

}
