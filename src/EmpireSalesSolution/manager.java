package EmpireSalesSolution;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class manager extends JFrame {

    public static JButton button1;
    public static JLabel label1;
    public static JPasswordField password;
    public static boolean isVisible;

    public manager(boolean isVisible) {
        setSize(500, 500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        getContentPane().setBackground(Color.red);

        password = new JPasswordField();
        label1 = new JLabel("Enter password:");

        button1 = new JButton("SUBMIT");
        label1.setForeground(Color.BLUE);
        label1.setBounds(20, 30, 120, 30);

        button1.setForeground(Color.BLUE);
        button1.setBounds(100, 80, 100, 30);

        password.setForeground(Color.BLUE);
        password.setBounds(170, 30, 120, 30);

        button1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empire", "root", "");
                    Statement st = con.createStatement();
                    String sql = "SELECT password From users";
                    ResultSet rs = st.executeQuery(sql);

                    while (rs.next()) {
                        String pas = rs.getString("password");
                        String p = password.getText();
                        if (pas.equals(p)) {
                            JOptionPane.showMessageDialog(null, "succesfully ");
                            new mpanel();
                        }
                    }
                } catch (SQLException exc) {
                    JOptionPane.showMessageDialog(null, "error" + exc.getMessage());
                }
            }
        });

        add(password);
        add(button1);
        add(label1);
        repaint();
        setVisible(isVisible);

    }

}
