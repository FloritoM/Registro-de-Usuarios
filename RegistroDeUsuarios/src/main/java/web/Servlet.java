package web;

import datos.UsuarioDAO;
import domain.Usuario;
import java.io.*;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException{
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
 
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String mail = request.getParameter("mail");
        String password = request.getParameter("password");
        
        String accion = request.getParameter("accion");
        
        HttpSession session = request.getSession();

        session.setAttribute("nombre", nombre);
        session.setAttribute("apellido", apellido);
        session.setAttribute("mail", mail);
        session.setAttribute("password", password);
        
//        // hacer validacion si ya existe el mail
//
//        if(nombre != null){
//            try {
//                Usuario userNuevo = new Usuario(nombre, apellido, mail, password);
//                this.insertarCliente(request, response, userNuevo);
//                request.getRequestDispatcher("ingresoOK.jsp").forward(request, response);
//            } catch (SQLException ex) {
//                ex.printStackTrace(System.out);
//            }
//        }
        Usuario usuario = new Usuario(mail);
        UsuarioDAO userDao = new UsuarioDAO();
        // ESTO ES LO QUE ANDA
//        try {
//            if(userDao.check(usuario) == false){
//                 try {
//                    Usuario userNuevo = new Usuario(nombre, apellido, mail, password);
//                    this.insertarCliente(request, response, userNuevo);
//                    request.getRequestDispatcher("ingresoOK.jsp").forward(request, response);
//                } catch (SQLException ex) {
//                    ex.printStackTrace(System.out);
//                }
//            } else {
//                request.getRequestDispatcher("oops.jsp").forward(request, response);
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace(System.out);
//        }
        if(accion.equals("registro")){
            try {
                if(userDao.check(usuario) == false){
                     try {
                        Usuario userNuevo = new Usuario(nombre, apellido, mail, password);
                        this.insertarCliente(request, response, userNuevo);
                        request.getRequestDispatcher("ingresoOK.jsp").forward(request, response);
                    } catch (SQLException ex) {
                        ex.printStackTrace(System.out);
                    }
                } else {
                    request.getRequestDispatcher("oops.jsp").forward(request, response);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        } else if(accion.equals("modificar")){
            try {
                Usuario userNuevo = new Usuario(nombre, apellido, mail, password);
                this.modificarCliente(request, response, userNuevo);
                request.getRequestDispatcher("ingresoOK.jsp").forward(request, response);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
            
        }

    }
    
    private void insertarCliente(HttpServletRequest request, HttpServletResponse response, Usuario usuario) 
            throws SQLException, IOException{
        UsuarioDAO userDao = new UsuarioDAO();
        int registros = userDao.insert(usuario);
        //System.out.println("registrosModificados = " + registros);
    }
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException{
        String mail = request.getParameter("mail");
       
        String nombre = "eliminado";
        String apellido = "eliminado";
        String password = "eliminado";
        
        HttpSession session = request.getSession();

        session.setAttribute("nombre", nombre);
        session.setAttribute("apellido", apellido);
        session.setAttribute("mail", mail);
        session.setAttribute("password", password);
        
        if(mail != null){
            try {
                Usuario usuarioEliminar = new Usuario(mail);
                this.eliminarCliente(request, response, usuarioEliminar);
                request.getRequestDispatcher("ingresoOK.jsp").forward(request, response);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }
    
    private void eliminarCliente(HttpServletRequest request, HttpServletResponse response, Usuario usuario)
        throws SQLException, IOException{
        UsuarioDAO userDao = new UsuarioDAO();
        int registros = userDao.delete(usuario);
    }
    
    private void modificarCliente(HttpServletRequest request, HttpServletResponse response, Usuario usuario) 
            throws SQLException{
        UsuarioDAO userDao = new UsuarioDAO();
        int registros = userDao.update(usuario);
    }
}
