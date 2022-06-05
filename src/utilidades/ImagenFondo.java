/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import vista.basico.VistaUsuarioBasicoForm;

/**
 *
 * @author Manolo
 */
public class ImagenFondo extends JPanel{
    private Image imagen;
    
    public void paint(Graphics g){
        imagen = new ImageIcon(VistaUsuarioBasicoForm.class.getClassLoader().getResource("resources/img/granulado3.png")).getImage();
        g.drawImage(imagen, 0, 0, getWidth(),getHeight(), this);            
        setOpaque(false);
        super.paint(g);
    }    
        
}