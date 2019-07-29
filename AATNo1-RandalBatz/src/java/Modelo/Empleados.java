package Modelo;

public class Empleados {
    private byte emp_codigo;
    private String nombre;
    private String apellido;
    private int telMovil;
    private String contrasenia;
    private String direccion;
    private String correo;

    public Empleados() {
    }

    public byte getEmp_codigo() {
        return emp_codigo;
    }

    public void setEmp_codigo(byte emp_codigo) {
        this.emp_codigo = emp_codigo;
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

    public int getTelMovil() {
        return telMovil;
    }

    public void setTelMovil(int telMovil) {
        this.telMovil = telMovil;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    
    
    
}
