package Modelo;
public class Subcategorias {
    private byte subcategoria_id;
    private String nombre;
    private byte categoria_id;
    private int empleado_id;

    public byte getSubcategoria_id() {
        return subcategoria_id;
    }

    public void setSubcategoria_id(byte subcategoria_id) {
        this.subcategoria_id = subcategoria_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(byte categoria_id) {
        this.categoria_id = categoria_id;
    }

    public int getEmpleado_id() {
        return empleado_id;
    }

    public void setEmpleado_id(int empleado_id) {
        this.empleado_id = empleado_id;
    }
    
}
