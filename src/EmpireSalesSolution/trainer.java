package EmpireSalesSolution;

import static EmpireSalesSolution.manager.password;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class trainer extends JFrame {

    public static JLabel username, pass;
    public static JButton submit;
    public static JPasswordField password;
    public static JTextField trainer;
    
    public static JTextField getTrainerField(){
        return trainer;
    }

    public trainer() {
        setSize(500, 500);
        setLayout(null);
        setBackground(Color.red);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        getContentPane().setBackground(Color.red);

        trainer = new JTextField("");
        trainer.setBounds(250, 30, 120, 30);
        password = new JPasswordField();
        password.setBounds(250, 80, 120, 30);
        username = new JLabel("ENTER USERNAME");
        username.setBounds(70, 30, 120, 30);
        pass = new JLabel("ENTER PASSWORD");
        pass.setBounds(70, 80, 120, 30);

        submit = new JButton("SUBMIT");
        submit.setBounds(150, 150, 120, 30);

        add(trainer);
        add(password);
        add(username);
        add(pass);
        add(submit);
        repaint();
        setVisible(true);
        
        submit.addActionListener(
        new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String user,pass;
                    user = trainer.getText();
                    pass = password.getText();
                try {
                    
                    
                    Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/empiresalessolution", "root", "" );
                   Statement st = con.createStatement();
                   String sql = "SELECT username,password from trainserslogin";
                   ResultSet rs = st.executeQuery(sql);
                   
                   while (rs.next()) {
                       String user2 = rs.getString("username");
                       String pass2 = rs.getString("password");
                        
                        if (user.equals(user2)&&pass.equals(pass2)) {
                            JOptionPane.showMessageDialog(null, "succesfully ");
                            new tpanel();
                        }
                   }
            }
                catch (SQLException ex){
                    JOptionPane.showMessageDialog(null,"wrong username and password combinations.contact the manager if you have forgot your password"+ex.getMessage() );
                }
                    
        }
        }
        );

    }
    public static void main(String[] args) {
        new trainer();
    }
}
