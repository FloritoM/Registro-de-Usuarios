package datos;

import static datos.Conexion.close;
import static datos.Conexion.getConnection;
import domain.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private static final String SQL_INSERT_USER = "INSERT INTO usuarios(nombre, apellido, mail, password) "
            + " VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE_USER = "UPDATE usuarios SET nombre=?, apellido=?, mail=?, password=? WHERE mail=?";
    private static final String SQL_DELETE = "DELETE FROM usuarios WHERE mail=?";
    private static final String SQL_USER_CHECK = "SELECT * FROM usuarios WHERE mail=?";
    
    public int insert(Usuario usuario) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT_USER);
            
            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getApellido());
            stmt.setString(3, usuario.getMail());
            stmt.setString(4, usuario.getPassword());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }
    
    public int update(Usuario usuario) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE_USER);

            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getApellido());
            stmt.setString(3, usuario.getMail());
            stmt.setString(4, usuario.getPassword());
            stmt.setString(5, usuario.getMail());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }
    
    public int delete(Usuario usuario) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, usuario.getMail());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    public boolean check(Usuario usuario) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null; 
        ResultSet rs = null;
        
        try {
            conn = Conexion.getConnection(); 
            stmt = conn.prepareStatement(SQL_USER_CHECK);
            stmt.setString(1, usuario.getMail());
            rs = stmt.executeQuery();
            
            //rs.next();
            // Si existe el registro devuelve true
            if(rs.next()){
                return true;
            }
                        
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally { 
            try {
                Conexion.close(rs); 
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return false;
    }
    
}
