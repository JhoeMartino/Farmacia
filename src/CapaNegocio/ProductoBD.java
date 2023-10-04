package CapaNegocio;

import CapaConexion.Conexion;
import CapaDatos.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ProductoBD {

    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sql;

    public DefaultTableModel reportarProducto() {

        DefaultTableModel tabla_temporal;
        String[] cabecera = {"SERIE", "DESCRIPCION", "OBSERVACION", "DIGEMI", "CONDICION", "CATEGORIA", "MARCA", "PRESENTACION", "ID-CAT", "ID-MA", "ID-ME"};
        String[] registros = new String[11];
        tabla_temporal = new DefaultTableModel(null, cabecera);

        sql = "SELECT pSerie,pDescripcion,pObservacion,digemi,pCondicion,catNombre,maNombre,mPresentacion,c.idcategoria,m.idmarca,me.idmedida FROM producto AS p "
                + " INNER JOIN marca as m ON p.idmarca = m.idmarca "
                + " INNER JOIN medida as me ON p.idmedida = me.idmedida "
                + " INNER JOIN categoria as c ON p.idcategoria = c.idcategoria";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
            while (rs.next()) {
                registros[0] = rs.getString("pSerie");
                registros[1] = rs.getString("pDescripcion");
                registros[2] = rs.getString("pObservacion");
                registros[3] = rs.getString("digemi");
                registros[4] = rs.getString("pCondicion");
                registros[5] = rs.getString("catNombre");
                registros[6] = rs.getString("maNombre");
                registros[7] = rs.getString("mPresentacion");
                registros[8] = rs.getString("idcategoria");
                registros[9] = rs.getString("idmarca");
                registros[10] = rs.getString("idmedida");

                tabla_temporal.addRow(registros);
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e, "Error al reportar producto...", JOptionPane.ERROR_MESSAGE);
            return null;

        }
        return tabla_temporal;
    }

    public boolean registarProducto(Producto p) {
        boolean rpta = false;
        sql = "INSERT INTO producto(pSerie,pDescripcion,pObservacion,digemi,pCondicion,idcategoria,idmarca,idmedida) "
                + " VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, p.getpSerie());
            pst.setString(2, p.getpDescripcion());
            pst.setString(3, p.getpObsevacion());
            pst.setString(4, p.getDigemi());
            pst.setString(5, p.getpCondicion());
            pst.setInt(6, p.getIdcategoria());
            pst.setInt(7, p.getIdmarca());
            pst.setInt(8, p.getIdmedida());

            rpta = pst.executeUpdate() == 1 ? true : false;

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e, "Problemas Al Registrar Producto..,", JOptionPane.ERROR_MESSAGE);
            return rpta;
        }
        return rpta;
    }

    public DefaultTableModel buscarProducto(String serie) {

        DefaultTableModel tabla_temporal;
        String[] titulos = {"SERIE", "DESCRIPCION", "OBSERVACION", "DIGEMI", "CONDICION", "CATEGORIA", "MARCA", "PRESENTACION", "ID-CAT", "ID-MA", "ID-ME"};
        String[] registros = new String[11];
        tabla_temporal = new DefaultTableModel(null, titulos);

        sql = "SELECT pSerie,pDescripcion,pObservacion,digemi,pCondicion,catNombre,maNombre,mPresentacion,c.idcategoria,m.idmarca,me.idmedida FROM producto AS p "
                + " INNER JOIN marca as m ON p.idmarca = m.idmarca "
                + " INNER JOIN medida as me ON p.idmedida = me.idmedida "
                + "INNER JOIN categoria as c ON p.idcategoria = c.idcategoria "
                + "WHERE pSerie=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, serie);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                registros[0] = rs.getString("pSerie");
                registros[1] = rs.getString("pDescripcion");
                registros[2] = rs.getString("pObservacion");
                registros[3] = rs.getString("digemi");
                registros[4] = rs.getString("pCondicion");
                registros[5] = rs.getString("catNombre");
                registros[6] = rs.getString("maNombre");
                registros[7] = rs.getString("mPresentacion");
                registros[8] = rs.getString("idcategoria");
                registros[9] = rs.getString("idmarca");
                registros[10] = rs.getString("idmedida");

                tabla_temporal.addRow(registros);
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e, "Error al Buscar producto...", JOptionPane.ERROR_MESSAGE);
            return null;

        }
        return tabla_temporal;
    }

    public DefaultTableModel buscarProductoNombre(String descripcion) {

        DefaultTableModel tabla_temporal;
        String[] titulos = {"SERIE", "DESCRIPCION", "OBSERVACION", "DIGEMI", "CONDICION", "CATEGORIA", "MARCA", "PRESENTACION", "ID-CAT", "ID-MA", "ID-ME"};
        String[] registros = new String[11];
        tabla_temporal = new DefaultTableModel(null, titulos);

        sql = "SELECT pSerie,pDescripcion,pObservacion,digemi,pCondicion,catNombre,maNombre,mPresentacion,c.idcategoria,m.idmarca,me.idmedida FROM producto AS p "
                + " INNER JOIN marca as m ON p.idmarca = m.idmarca "
                + " INNER JOIN medida as me ON p.idmedida = me.idmedida "
                + " INNER JOIN categoria as c ON p.idcategoria = c.idcategoria "
                + " WHERE pDescripcion LIKE ?";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, "%" + descripcion + "%");

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                registros[0] = rs.getString("pSerie");
                registros[1] = rs.getString("pDescripcion");
                registros[2] = rs.getString("pObservacion");
                registros[3] = rs.getString("digemi");
                registros[4] = rs.getString("pCondicion");
                registros[5] = rs.getString("catNombre");
                registros[6] = rs.getString("maNombre");
                registros[7] = rs.getString("mPresentacion");
                registros[8] = rs.getString("idcategoria");
                registros[9] = rs.getString("idmarca");
                registros[10] = rs.getString("idmedida");

                tabla_temporal.addRow(registros);
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e, "Error al Buscar producto...", JOptionPane.ERROR_MESSAGE);
            return null;

        }
        return tabla_temporal;
    }

    public boolean modificarProducto(Producto p) {
        boolean rpta = false;
        sql = "UPDATE producto SET pDescripcion=?,pObservacion=?,digemi=?,pCondicion=?,idcategoria=?,idmarca=?,idmedida=? WHERE pSerie=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setString(1, p.getpDescripcion());
            pst.setString(2, p.getpObsevacion());
            pst.setString(3, p.getDigemi());
            pst.setString(4, p.getpCondicion());
            pst.setInt(5, p.getIdcategoria());
            pst.setInt(6, p.getIdmarca());
            pst.setInt(7, p.getIdmedida());
            pst.setString(8, p.getpSerie());

            rpta = pst.executeUpdate() == 1 ? true : false;

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, e, "Problemas Al Modificar Producto..,", JOptionPane.ERROR_MESSAGE);
            return rpta;
        }
        return rpta;
    }

    public boolean eliminarProducto(String serie) {
        boolean rpta = false;
        sql = "DELETE FROM producto WHERE pSerie=?";
        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, serie);

            rpta = pst.executeUpdate() == 1 ? true : false;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Problemas Al Eliminar", JOptionPane.ERROR_MESSAGE);
            return rpta;
        }
        return rpta;
    }
}
