/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.inte_soft.gestionconsumibles;

import com.inte_soft.gestionconsumibles.serviceImplement.MasterServiceImplement;

/**
 *
 * @author Inte-Soft
 */
public class GestionConsumibles {

    public static void main(String[] args) {
     // MasterServiceImplement masterServiceImplement = new MasterServiceImplement(); 
      
      //masterServiceImplement.createMaster("C:\\Users\\alejo\\Downloads\\LISTADO MAESTRO 1.xlsx");
    
    MasterServiceImplement masterServiceImplement = new MasterServiceImplement(); 
      
      masterServiceImplement.updatemaster("C:\\Users\\alejo\\Downloads\\LISTADO MAESTRO 1.xlsx");
    }
}
