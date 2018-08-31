/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmpireSalesSolution;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ARNOH
 */
public class CloseSales extends JFrame{
    public static JButton promote,demote;
    
    
    public CloseSales(){
        setSize(500, 500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        getContentPane().setBackground(Color.red);
        
        promote = new JButton("PROMOTE");
        promote.setBounds(100, 100, 200, 50);
        add(promote);
        
         demote = new JButton("DEMOTE");
        demote.setBounds(100, 200, 200, 50);
        add(demote);

        repaint();
        setVisible(true);
        
        promote.addActionListener(
        new ActionListener() {
            

            @Override
            public void actionPerformed(ActionEvent e) {
                try(Connection con = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/empiresalessolution", "root", "")){
                    PreparedStatement preparestatement = con.prepareStatement("SELECT * FROM salaries WHERE ((0.01 * (0.01 * (hotpots+flasks+glasses)))+ (0.01 * (hotpots+flasks+glasses)))>=10000 ");
                   
                            preparestatement.execute();
                            
                            JOptionPane.showMessageDialog(null, "successfully promoted to trainers position");
                    
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                  
                }
                
                
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        }
        );
        
        demote.addActionListener(
        new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try(Connection con = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/empiresalessolution", "root", "")){
                    PreparedStatement preparestatement = con.prepareStatement("SELECT * FROM salaries WHERE ((0.01 * (0.01 * (hotpots+flasks+glasses)))+ (0.01 * (hotpots+flasks+glasses)))<=10000 ");
                   
                            preparestatement.execute();
                            
                            JOptionPane.showMessageDialog(null, "successfully demoted to rockie position");
                    
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                  
                }
                
                
                
                
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        }
        );
    }
   
    
    public static void main(String [] args){
        new CloseSales();
    }
    
}
