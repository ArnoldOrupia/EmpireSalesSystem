/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmpireSalesSolution;

import java.awt.Color;
import javax.swing.*;
import javax.swing.JMenuBar;

/**
 *
 * @author ARNOH
 */
public class ViewRockie extends JFrame {
    
    public static JComboBox box;
    
    String  [] data = {"betty","rocky","arno","james","bondo"};
    
    public ViewRockie(){
        
         setSize(500, 500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        getContentPane().setBackground(Color.red);
        
        box = new JComboBox(data);
        box.setBounds(100,100,200,30);
        add(box);
        
        repaint();
        setVisible(true);
    }
    public static void main(String [] args){
        new ViewRockie();
    }
    
}
