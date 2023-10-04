/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaNegocio;

import CapaConexion.Conexion;
import CapaDatos.Turno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TurnoBD {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sql;

    public DefaultTableModel reportarTurno() {

        DefaultTableModel modelo;

        String[] titulos = {"ID", "DESCRIPCION", "INICIO", "FIN", "USUARIO"};
        String[] registros = new String[5];
        modelo = new DefaultTableModel(null, titulos);
        sql = "SELECT idturno,descripcion,inicio,fin,CONCAT(uApellidos,' ',uNombre) AS usuario FROM turno AS t "
                + "INNER JOIN usuario AS u ON t.TuDni=u.uDni";
        try {

            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                registros[0] = rs.getString("idturno");
                registros[1] = rs.getString("descripcion");
                registros[2] = rs.getString("inicio");
                registros[3] = rs.getString("fin");
                registros[4] = rs.getString("usuario");

                modelo.addRow(registros);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Error al reportar Turno...", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return modelo;
    }

    public boolean resgistarTurno(Turno t) {
        boolean rpta = false;
        sql = "INSERT INTO turno(idturno,descripcion,inicio,fin,TuDni) VALUES(0,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, t.getDescripcion());
            pst.setString(2, t.getInicio());
            pst.setString(3, t.getFin());
            pst.setString(4, t.getuDni());

            rpta = pst.executeUpdate() == 1 ? true : false;

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e, "Problemas Al Registrar Turno..,", JOptionPane.ERROR_MESSAGE);
            return rpta;
        }
        return rpta;
    }

    public boolean eliminarTurno(int idturno) {
        boolean rpta = false;
        sql = "DELETE FROM turno WHERE idturno=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, idturno);

            rpta = pst.executeUpdate() == 1 ? true : false;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas Al Eliminar Turno ", JOptionPane.ERROR_MESSAGE);
            return rpta;
        }
        return rpta;
    }
    
     public List<Turno> buscarTurno(String inicio, String fin, String uDni) {

        List<Turno> lista = new ArrayList<>();
        sql = "SELECT idturno,descripcion,inicio,fin,TuDni FROM turno WHERE (inicio<? AND fin>?) AND TuDni=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, inicio);
            pst.setString(2, fin);
            pst.setString(3, uDni);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Turno oTurno = new Turno();
                oTurno.setIdturno(rs.getInt(1));
                oTurno.setDescripcion(rs.getString(2));
                oTurno.setInicio(rs.getString(3));
                oTurno.setFin(rs.getString(4));
                oTurno.setuDni(rs.getString(5));

                lista.add(oTurno);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "ERROR AL BUSCAR TURNO", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return lista;

    }
    
}
