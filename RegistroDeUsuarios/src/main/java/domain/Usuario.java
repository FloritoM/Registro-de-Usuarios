package domain;

public class Usuario {
    private String nombre;
    private String apellido;
    private String mail;
    private String password;

    public Usuario() {
    }
    
    public Usuario(String mail) {
            this.mail = mail;
        }
    
    public Usuario(String nombre, String apellido, String mail, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Usuario{nombre=").append(nombre);
        sb.append(", apellido=").append(apellido);
        sb.append(", mail=").append(mail);
        sb.append(", password=").append(password);
        sb.append('}');
        return sb.toString();
    }

    
    
    
    
}
