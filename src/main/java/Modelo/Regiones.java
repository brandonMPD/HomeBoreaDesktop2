package Modelo;
public class Regiones {
    private byte region_id;
    private String nombre;
    private String descripcion;

    public byte getRegion_id() {
        return region_id;
    }

    public void setRegion_id(byte region_id) {
        this.region_id = region_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
