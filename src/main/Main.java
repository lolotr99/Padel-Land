/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javax.swing.JFrame;
import vista.basico.VistaUsuarioBasicoForm;

/**
 *
 * @author Manolo
 */
public class Main {
     public static void main(String args[]){
        VistaUsuarioBasicoForm ventana = new VistaUsuarioBasicoForm();
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
        ventana.pack();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
