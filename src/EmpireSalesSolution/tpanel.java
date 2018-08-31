
package EmpireSalesSolution;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import EmpireSalesSolution.View;

public class tpanel extends JFrame {
    
   
    public static JButton b1;
    public static JButton b2;
    public static JButton b3,b4;
    public static JLabel l1;
      public static JScrollPane scroll;
    public static JTable table;
    public tpanel(){
        
      // super(" "+trainer.trainer.getText()+" logged in");
      
        setSize(500,500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        getContentPane().setBackground(Color.red);
        
         
        b1 = new JButton("VIEW ROCKIES");
        b1.setForeground(Color.BLUE);
        b1.setBounds(150,30, 120, 30);
        
        b2 = new JButton("VIEW SALES");
        b2.setForeground(Color.BLUE);
        b2.setBounds(150,80, 120, 30);
        
    
        
        b3 = new JButton("VIEW PENALTIES");
        b3.setForeground(Color.BLUE);
        b3.setBounds(150,130, 120, 30);
        
         b4 = new JButton("LOG OUT");
        b4.setForeground(Color.BLUE);
        b4.setBounds(150,180, 120, 30);
        
        l1 = new JLabel ("TRAINER LOGGED IN"); 
        l1.setForeground(Color.BLUE);
        l1.setBounds(150,10, 150, 10);
        
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(l1);
        repaint();
        setVisible(true);
        
        
        //TRAINER TO VIEW THEIR OWN SALES REPORT
        
        b2.addActionListener(
                
        new ActionListener(){
        public void actionPerformed(ActionEvent e){
            new View();
                
            
        }
    }
        );
        
         b4.addActionListener(
                
        new ActionListener(){
        public void actionPerformed(ActionEvent e){
            new Homepage();
                
            
        }
    }
        );
        
    
    }
    public static void main(String[] args) {
        new tpanel();
       
    }
    
}
