/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inte_soft.gestionconsumibles.util;

import java.awt.Dialog;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author alejo
 */
public class AdvertenciaModal {
    
    public void advertenciaModal (JDialog modal, String mensaje, String titulo){
        JOptionPane.getRootFrame().setAlwaysOnTop(true);
        modal.setModalExclusionType(Dialog.ModalExclusionType.NO_EXCLUDE);
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.WARNING_MESSAGE);
        modal.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
    }
}
