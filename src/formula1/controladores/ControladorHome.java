/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formula1.controladores;

import formula1.modelos.ConsultasEscuderia;
import formula1.modelos.Escuderia;
import formula1.modelos.Piloto;
import formula1.vistas.VistaHome;
import formula1.vistas.VistaRegistro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author 505
 */
public class ControladorHome implements ActionListener {
    
    //Atributos
    Escuderia escuderia = new Escuderia();
    Piloto piloto = new Piloto();
    VistaHome vistaHome = new VistaHome();

    public ControladorHome() {
    }
       
    public ControladorHome(Escuderia escuderia, Piloto piloto, VistaHome vistaHome ) {
        this.escuderia=escuderia;
        this.piloto=piloto;
        this.vistaHome=vistaHome;
        
        vistaHome.botonIngresar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        //Crear objeto de la clase consulta ESCUDERIA
        ConsultasEscuderia consulta = new ConsultasEscuderia();
        
        //obtener el id de la vista
        String id = vistaHome.cajaEscuderia.getText();
        
        //intento buscar la escuderia por id
        
        //Si no esta vacio la busqueda por id
        if(consulta.buscarEscuderia(id) != null){
            JOptionPane.showMessageDialog(null, "Ya existe");
        }else{
            //Si esta vacia la busqueda (si no existe)
            VistaRegistro vistaRegistro = new VistaRegistro();
            vistaRegistro.setVisible(true);
            vistaHome.setVisible(false);
            
            ControladorRegistro controladorRegistro = new ControladorRegistro(escuderia,piloto,vistaRegistro);
        }
    }
       
    
}
