/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formula1.modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author 505
 */
public class ConsultasEscuderia extends ModeloBD{
    
    PreparedStatement consultaSQL;
    ResultSet resultadoSQL;
    
    public boolean registrarEscuderia(Escuderia escuderia){
        
        Connection conexion=conectarBD();
        String query="INSERT INTO escuderias(id,nombre,presupuesto,tipo_motor)"
                + "VALUES (?,?,?,?)";
        
        try{
            //Peparate que voy con toa
            consultaSQL=conexion.prepareStatement(query);
            
            //Ajusto la consulta
            consultaSQL.setString(1,escuderia.getId());
            consultaSQL.setString(2,escuderia.getNombre());
            consultaSQL.setInt(3,escuderia.getPresupuesto());
            consultaSQL.setString(4,escuderia.getTipoMotor());
            
            //Ejecuto la consulta
            int resultado=consultaSQL.executeUpdate();
            
            //validando el resultado
            if(resultado>0){
              return true;  
            }else{
               return false; 
            }
            
        }catch(Exception error){
            System.out.println("upsss... "+error);
            return false;
        }
        
    }
    
   public Escuderia buscarEscuderia(String id){
       
        Connection conexion=conectarBD();
        String query="SELECT * from escuderias where id=?";
        
        try{
            
            //Peparate que voy con toa
            consultaSQL=conexion.prepareStatement(query);
            
            //Ajusto la consulta
            consultaSQL.setString(1, id);
            
            //Ejecuto la consulta
            resultadoSQL=consultaSQL.executeQuery();
            
            //Orgaizo el resultado
            Escuderia escuderia= new Escuderia();
            if(resultadoSQL.next()){
                
                escuderia.setId(resultadoSQL.getString("id"));
                escuderia.setNombre(resultadoSQL.getString("nombre"));
                escuderia.setPresupuesto(resultadoSQL.getInt("presupuesto"));
                escuderia.setTipoMotor(resultadoSQL.getString("tipo_motor"));
                
                return escuderia;
                
            }else{
                return null;
            }
            
         
            
        }catch(Exception error){
            System.out.println("upsss... "+error);
            return null;
        }
        
       
   } 
           
    
}
