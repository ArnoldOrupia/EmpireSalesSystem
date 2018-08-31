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
import javax.swing.*;

public class Hire extends JFrame {

    private static JLabel fname, lname, idNo, residence, tel, username, password;
    private static JTextField fname1, lname1, idNo1, residence1, tel1, username1, password1;
    private static JButton hire;
 
    private JPanel p;
    private JPanel p1;

    public Hire() {
        p = new JPanel(new GridLayout(7, 2, 2, 2));
        p.setBackground(Color.red);
        // p.setSize(250,100);
        add(p);

        fname = new JLabel("ENTER FIRST NAME");
        p.add(fname);
        fname1 = new JTextField();
        fname1.setSize(5, 5);
       fname1.setHorizontalAlignment(SwingConstants.RIGHT);
        p.add(fname1);
        
        lname = new JLabel("ENTER LAST NAME");
        p.add(lname);
        lname1 = new JTextField();
        p.add(lname1);
        
        
        idNo = new JLabel("ENTER ID NUMBER");
        p.add(idNo);
        idNo1 = new JTextField();
        p.add(idNo1);
        
        
        residence = new JLabel("ENTER RESIDENCE");
        p.add(residence);
        residence1 = new JTextField();
        p.add(residence1);
        
        
        tel = new JLabel("ENTER TELEPHONE NUMBER");
        p.add(tel);
        tel1 = new JTextField();
        p.add(tel1);
        
        
        username = new JLabel("ENTER USER NAME");
        p.add(username);
        username1 = new JTextField();
        p.add(username1);
        
       
        
        password = new JLabel("ENTER PASSWORD");
        p.add(password);
        password1 = new JTextField();
        p.add(password1);

        p1 = new JPanel();
        add(p1, BorderLayout.SOUTH);

        hire = new JButton("HIRE");
        p1.add(hire);

        hire.addActionListener(
                new ActionListener() {

                    @Override
                   public void actionPerformed(ActionEvent e) {
                        try (Connection con = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/empiresalessolution", "root", "")) {
                                    PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO hire VALUES (?,?,?,?,?,?,?)");
                                    preparedStatement.setString(1, fname1.getText());
                                    preparedStatement.setString(2, lname1.getText());
                                    preparedStatement.setInt(3, Integer.parseInt(idNo1.getText()));
                                    preparedStatement.setString(4, residence1.getText());
                                    preparedStatement.setString(5, username1.getText());
                                    preparedStatement.setString(6, password1.getText());
                                    preparedStatement.setString(7, tel1.getText());
                                    preparedStatement.execute();
                                    
                                    PreparedStatement preparedStatement1 = con.prepareStatement("INSERT INTO rockieslogin VALUES (?,?)");
                                    preparedStatement1.setString(1, username1.getText());
                                    preparedStatement1.setString(2, password1.getText());
                                    
                                    preparedStatement1.execute();
                                    JOptionPane.showMessageDialog(null, "Data saved");
                                    fname1.setText("");
                                     lname1.setText("");
                                      idNo1.setText("");
                                       residence1.setText("");
                                        username1.setText("");
                                         password1.setText("");
                                          tel1.setText("");

                                } catch (SQLException ex) {
                                    JOptionPane.showMessageDialog(null, "Unable to save");
                                    System.err.println("not saved" + ex.getMessage());
                                }

                    }
                }
        );

    }

    public static void main(String[] args) {
        Hire hire = new Hire();
        hire.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hire.setLocationRelativeTo(null);
        hire.setBackground(Color.red);
        hire.setSize(500, 500);
        hire.setVisible(true);

    }

    Hire(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
