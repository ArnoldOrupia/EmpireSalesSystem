package EmpireSalesSolution;

import static EmpireSalesSolution.Homepage.button1;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.beans.PropertyChangeListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.OperationNotSupportedException;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

public class mpanel extends JFrame {
    

    public static JButton b1;
    public static JButton b2;
    public static JButton b3;
    public static JButton b4,b5,b6,b7;
    public static JLabel l1;

    public mpanel() {
        super ("MANAGER LOGGED IN");
        setSize(500, 500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        getContentPane().setBackground(Color.red);

        b1 = new JButton("HIRE ROCKIE");
        b1.setForeground(Color.BLUE);
        b1.setBounds(150, 50, 150, 30);
        //b1.addActionListener(this);
        b2 = new JButton("UPDATE SALES");
        b2.setForeground(Color.BLUE);
        b2.addActionListener(new Action());
        b2.setBounds(150, 100, 150, 30);

        b3 = new JButton("FIRE ROCKIE");
        b3.setForeground(Color.BLUE);
        b3.addActionListener(new Action());
        b3.setBounds(150, 150, 150, 30);

        b4 = new JButton("VIEW SALES");
        b4.setForeground(Color.BLUE);
        b4.addActionListener(new Action());
        b4.setBounds(150, 200, 150, 30);
        
        b5 = new JButton("LOG OUT");
        b5.setForeground(Color.BLUE);
        b5.addActionListener(new Action());
        b5.setBounds(150, 250, 150, 30);
        
         b6 = new JButton("PRINT REPORT");
        b6.setForeground(Color.BLUE);
        b6.addActionListener(new Action());
        b6.setBounds(150, 300, 150, 30);
        
         b7 = new JButton("CLOSE SALES");
        b7.setForeground(Color.BLUE);
        b7.addActionListener(new Action());
        b7.setBounds(150, 350, 150, 30);
        
        l1 = new JLabel("MANAGER LOGGED IN");
        l1.setForeground(Color.BLUE);
        l1.setBounds(160, 5, 150, 30);
        add(l1);

        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
         add(b7);
        repaint();
        setVisible(true);
        b1.addActionListener(new Action());
    }

    static class Action implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            
            if(e.getSource().equals(b1)){
            Hire hire = new Hire();
             hire.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            hire.setLocationRelativeTo(null);
            hire.setBackground(Color.red);
            hire.setSize(500, 500);
            hire.setVisible(true);
           
        }
            else if(e.getSource().equals(b2)){
                SalesUpdate up= new SalesUpdate();
        up.setSize(400, 400);
        up.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        up.setVisible(true);
            }
            
            
            else if(e.getSource().equals(b3)){
           Fire fire = new Fire();
        fire.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //fire.setLocationRelativeTo(null);
        fire.setBackground(Color.red);
        fire.setSize(500, 150);
        fire.setVisible(true);
        }
             else if(e.getSource().equals(b4)){
           Salaries s =new Salaries();
//        view.setLocationRelativeTo(null);
//        view.setSize(500,150);
//        view.setVisible(true);
//        
        }
              else if(e.getSource().equals(b7)){
                  new CloseSales();
              }
             else if(e.getSource().equals(b5)){
                 Homepage h = new Homepage();
             }
             else if(e.getSource().equals(b6)){
                try {
                    Salaries.printtable();
                } catch (PrinterException ex) {
                    Logger.getLogger(mpanel.class.getName()).log(Level.SEVERE, null, ex);
                }
             }
            
        }

    public static void main(String[] args) {
        new mpanel();
    }
    }
}

    
