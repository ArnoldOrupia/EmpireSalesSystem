package EmpireSalesSolution;

import static EmpireSalesSolution.manager.button1;
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

public class rockie extends JFrame {

    public static JLabel username, pass;
    public static JButton submit;
    public static JPasswordField password;
    public static JTextField rockie;

    public rockie() {
        setSize(500, 500);
        setLayout(null);
        setBackground(Color.red);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        getContentPane().setBackground(Color.red);

        rockie = new JTextField("");
        rockie.setBounds(250, 30, 120, 30);
        password = new JPasswordField();
        password.setBounds(250, 80, 120, 30);
        username = new JLabel("ENTER USERNAME");
        username.setBounds(70, 30, 120, 30);
        pass = new JLabel("ENTER PASSWORD");
        pass.setBounds(70, 80, 120, 30);

        submit = new JButton("SUBMIT");
        submit.setBounds(150, 150, 120, 30);

        submit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                authenticate();
            }
        });

        add(rockie);
        add(password);
        add(username);
        add(pass);
        add(submit);
        repaint();
        setVisible(true);

    }
    
    public void authenticate() {

        String user, pass;
        user = rockie.getText();
        pass = String.valueOf(password.getPassword());

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empiresalessolution", "root", "");
            Statement st = con.createStatement();
            String sql = "SELECT password From rockieslogin  where username = '"+rockie.getText()+"'";
            ResultSet rs = st.executeQuery(sql);

            String pass2 = "";
            while (rs.next()) {
                pass2 = rs.getString("password");
            }
            String p = String.valueOf(password.getPassword());
            if (pass.equals(pass2)) {
                JOptionPane.showMessageDialog(null, "succesfully ");

                new rpanel();

            } else {
                JOptionPane.showMessageDialog(null, "invalid password or username");

            }

        } catch (SQLException exc) {
            JOptionPane.showMessageDialog(null, "error" + exc.getMessage());
        }

    }

}
