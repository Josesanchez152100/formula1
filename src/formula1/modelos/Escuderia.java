/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formula1.modelos;

/**
 *
 * @author 505
 */
public class Escuderia {
    
    private String id;
    private String nombre;
    private int presupuesto;
    private String tipoMotor;

    public Escuderia() {
    }

    public Escuderia(String id, String nombre, int presupuesto, String tipoMotor) {
        this.id = id;
        this.nombre = nombre;
        this.presupuesto = presupuesto;
        this.tipoMotor = tipoMotor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(int presupuesto) {
        this.presupuesto = presupuesto;
    }

    public String getTipoMotor() {
        return tipoMotor;
    }

    public void setTipoMotor(String tipoMotor) {
        this.tipoMotor = tipoMotor;
    }
    
    
    
    
    
}
