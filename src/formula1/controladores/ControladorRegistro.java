/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formula1.controladores;

import formula1.modelos.ConsultasEscuderia;
import formula1.modelos.ConsultasPilotos;
import formula1.modelos.Escuderia;
import formula1.modelos.Piloto;
import formula1.vistas.VistaRegistro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author 505
 */
public class ControladorRegistro implements ActionListener {
    //Atributos
    Escuderia escuderia = new Escuderia();
    Piloto piloto = new Piloto();
    VistaRegistro vistaRegistro = new VistaRegistro();

    public ControladorRegistro() {
    }
    
    public ControladorRegistro(Escuderia escuderia,Piloto piloto, VistaRegistro vistaRegistro) {
        
        this.escuderia=escuderia;
        this.piloto=piloto;
        this.vistaRegistro=vistaRegistro;
        
        vistaRegistro.botonIngresar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        //Traer las consultas de escuderia y de piloto
        ConsultasEscuderia consultasEscuderia = new ConsultasEscuderia();
        ConsultasPilotos consultasPilotos = new ConsultasPilotos();
        
        //Armar una escuderia para grabar
        escuderia.setId(vistaRegistro.idEscuderia.getText());
        escuderia.setNombre(vistaRegistro.nombreEscuderia.getText());
        escuderia.setPresupuesto(Integer.parseInt(vistaRegistro.presupuesto.getText()));
        escuderia.setTipoMotor(vistaRegistro.motor.getText());
        
        
        //Armar un piloto para grabar
        piloto.setNombres(vistaRegistro.nombresPiloto.getText());
        piloto.setApellidos(vistaRegistro.apellidosPiloto.getText());
        piloto.setSalario(Integer.parseInt(vistaRegistro.salario.getText()));
        
        Date entrada = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaEntrada = formato.format(entrada);
        piloto.setFechaIn(fechaEntrada);
        
        piloto.setIdEscuderia(vistaRegistro.idEscuderia.getText());
        
        //Intentar registrar escuderia y piloto
        if(consultasEscuderia.registrarEscuderia(escuderia) && consultasPilotos.registrarPiloto(piloto)){
            
            JOptionPane.showMessageDialog(null, "Exito en el ingreso");
        
        }else{
            
            JOptionPane.showMessageDialog(null, "Uppsss.....intente nuevamente");
        
        }
        
    }
}
