
package EmpireSalesSolution;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class Fire extends JFrame{
    private static JLabel head, employeeid, reason;
    private static JTextField username, reason1;
    private static JButton fire;
    private JPanel p;
    private JPanel p1;
    

public Fire() {
        p = new JPanel(new GridLayout(2, 2, 2, 2));
        //p.setBackground(Color.red);
       // p.setSize(250,100);
        p.setBorder(new TitledBorder("FILL IN THE FIELDS"));
        add(p);
        

        employeeid = new JLabel("ENTER EMPLOYEE USERNAME");
        p.add(employeeid);
        username = new JTextField();
       // fname1.setSize(5, 5);
        //fname1.setHorizontalAlignment(SwingConstants.RIGHT);
        p.add(username);
         reason = new JLabel("ENTER REASON FOR FIRING");
        p.add(reason);
        reason1 = new JTextField();
        p.add(reason1);
        
        p1 = new JPanel();
        add(p1,BorderLayout.SOUTH);
        
        fire= new JButton("FIRE");
        p1.add(fire);
        
        fire.addActionListener(
        new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try(Connection con = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/empiresalessolution", "root", "")){
                    PreparedStatement preparestatement = con.prepareStatement("DELETE FROM hire WHERE username='"+username.getText()+"'");
                   
                            preparestatement.execute();
                            
                            JOptionPane.showMessageDialog(null, "successfully fired");
                    
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                  
                }
                
                
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        }
        );
}
        
   public static void main(String[] args) {
        Fire fire = new Fire();
        fire.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //fire.setLocationRelativeTo(null);
        fire.setBackground(Color.red);
        fire.setSize(500, 150);
        fire.setVisible(true);

    }     
}
        



