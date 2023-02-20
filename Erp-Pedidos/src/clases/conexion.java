
package clases;

import java.sql.*;
import java.sql.DriverManager;

public class conexion {
  static Connection con = null;
  static String driver ="net.ucanaccess.jdbc.UcanaccessDriver";
  static String url = "jdbc:ucanaccess://C:\\Users\\alejo\\OneDrive\\Documents\\NetBeansProjects\\ERP-PEDIDOS\\Erp-Pedidos\\equipos2.accdb";
          
          public static Connection obtenerconexion(){
              try{
                  if (con==null){
                      Class.forName(driver);
                      con = DriverManager.getConnection(url);
                      
                  }
              }catch(Exception ex){
                  ex.printStackTrace();
                  con=null;
              }
              return con;
          }
          public static void main(String [] args){
              
              Connection cn = conexion.obtenerconexion();
          }
}
