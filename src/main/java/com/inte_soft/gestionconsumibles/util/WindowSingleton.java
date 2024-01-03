/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inte_soft.gestionconsumibles.util;

/**
 *
 * @author alejo
 */
public class WindowSingleton {
    
    private Boolean windowState;
    
    public WindowSingleton(){
        this.windowState = Boolean.FALSE;
    }
    
    public void setOpenWindow(){

        this.windowState = Boolean.TRUE;
    }
    
    public void setCloseWindow(){
        this.windowState = Boolean.FALSE;
    }

    public Boolean getWindowState(){
        return this.windowState;
    }
    
}
