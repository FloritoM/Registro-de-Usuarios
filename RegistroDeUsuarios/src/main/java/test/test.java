package test;

import datos.UsuarioDAO;
import domain.Usuario;
import java.sql.SQLException;
import java.util.Scanner;

public class test {
    public static void main(String[] args) throws SQLException {
        UsuarioDAO user = new UsuarioDAO();
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresá la opción a realizar en la DB: ");
        System.out.println("1- Update");
        System.out.println("2- Insert");
        System.out.println("3- Delete");
        System.out.println("4- Check");
        int opcion = Integer.parseInt(sc.nextLine());
        
        switch(opcion){
            case 1:
                System.out.println("UPDATE");
                System.out.println("Ingresa los datos actualizar: ");
                System.out.println("Mail: ");
                String mail = sc.nextLine();
                System.out.println("Nombre: ");
                String nombre = sc.nextLine();
                System.out.println("Apellido: ");
                String apellido = sc.nextLine();
                
                System.out.println("Contraseña: ");
                String password = sc.nextLine();
                
                Usuario usuarioUpdate = new Usuario(nombre, apellido, mail, password);
                
                user.update(usuarioUpdate);
                break;
            case 2:
                System.out.println("INSERT");
                System.out.println("Ingresá los datos del nuevo usuario: ");
                System.out.println("Nombre: ");
                nombre = sc.nextLine();
                System.out.println("Apellido: ");
                apellido = sc.nextLine();
                System.out.println("Mail: ");
                mail = sc.nextLine();
                System.out.println("Contraseña: ");
                password = sc.nextLine();
                
                Usuario usuarioInsert = new Usuario(nombre, apellido, mail, password);
                
                user.insert(usuarioInsert);
                break;
            case 3:
                System.out.println("DELETE");
                System.out.println("Ingresa el mail: ");
                mail = sc.nextLine();
                
                Usuario usuarioDelete = new Usuario(mail);
                user.delete(usuarioDelete);
                
                break;
            case 4:
                System.out.println("CHECK");
                System.out.println("Ingresa el mail: ");
                mail = sc.nextLine();
                
                Usuario usuarioCheck = new Usuario(mail);
                System.out.println(user.check(usuarioCheck));
                
                break;
            default:
                System.out.println("ERROR");
        }
        
        
        
        
        
        
        
        
    }
    
    
}
