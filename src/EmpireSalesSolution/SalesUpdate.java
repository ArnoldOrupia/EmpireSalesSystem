package EmpireSalesSolution;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;

public class SalesUpdate extends JFrame {

    public static JLabel label1, label2, label3, label4, label5;
    public static JTextField text1, text2, text3, text4;
    public static JButton btn;
    public static JPanel panel;

    public SalesUpdate() {
        Container contentPane = getContentPane();
        setLayout(null);
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.red);

        panel = new JPanel();
        panel.setSize(400, 400);
        panel.setBackground(Color.red);
        panel.setLayout(null);

        label1 = new JLabel("ENTER THE DAILY SALES");
        label1.setBounds(120, 20, 500, 30);
        panel.add(label1);
        label2 = new JLabel("username");
        label2.setBounds(100, 70, 130, 30);
        panel.add(label2);
        label3 = new JLabel("hotpots");
        label3.setBounds(100, 120, 130, 30);
        panel.add(label3);
        label4 = new JLabel("flasks");
        label4.setBounds(100, 170, 130, 30);
        panel.add(label4);
        label5 = new JLabel("glasses");
        label5.setBounds(100, 220, 130, 30);
        panel.add(label5);

        text1 = new JTextField(" ");
        text1.setBounds(240, 70, 130, 30);
        panel.add(text1);
        text2 = new JTextField(" ");
        text2.setBounds(240, 120, 130, 30);
        panel.add(text2);
        text3 = new JTextField(" ");
        text3.setBounds(240, 170, 130, 30);
        panel.add(text3);
        text4 = new JTextField(" ");
        text4.setBounds(240, 220, 130, 30);
        panel.add(text4);

        btn = new JButton("SUBMIT");
        btn.setBounds(150, 270, 130, 30);
        panel.add(btn);
        add(panel);
        repaint();
        setVisible(true);

        btn.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        
                                  
//
//                        if (!verifyNumbersOnlyFields(text1.getText())
//                        && !verifyNumbersOnlyFields(text2.getText())
//                        && !verifyNumbersOnlyFields(text3.getText())
//                        && !verifyNumbersOnlyFields(text4.getText())) {

                        try (Connection con = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/empiresalessolution", "root", "")) {
                                    PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO salesupdate VALUES (?,?,?,?)");
                                    preparedStatement.setString(1, text1.getText());
                                    preparedStatement.setString(2, text2.getText());
                                    preparedStatement.setString(3, text3.getText());
                                    preparedStatement.setString(4, text4.getText());
                                    preparedStatement.execute();
                                    updateSalaries();
                                    text1.setText("");
                                    text2.setText("");
                                    text3.setText("");
                                    text4.setText("");

                        } catch (SQLException ex) {
                                    JOptionPane.showMessageDialog(null, "Unable to save");
                                    System.err.println("not saved" + ex.getMessage());
                                }

//                        } else {
//                            JOptionPane.showMessageDialog(null, "please enter numeric values only");
//                        }
                    }
                }
        );

    }

    public boolean verifyNumbersOnlyFields(Object enteredString) {

        Pattern numbersOnlyPattern = Pattern.compile("\\d*");
        Matcher numbersOnlyMatcher = numbersOnlyPattern.matcher(enteredString.toString());
        return numbersOnlyMatcher.matches();
    }

    public static void main(String[] args) {

        SalesUpdate up = new SalesUpdate();
        up.setSize(400, 400);
        up.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        up.setVisible(true);
        //new SalesUpdate();

    }

    private static void updateSalaries() {
        String data1 = String.valueOf(Double.parseDouble(text2.getText())* 1000);
        String data2 = String.valueOf(Double.parseDouble(text3.getText())* 900);
        String data3 = String.valueOf(Double.parseDouble(text4.getText())* 800);
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/empiresalessolution", "root", "")) {
            PreparedStatement preparedStatement1 = connection.prepareStatement("INSERT INTO Salaries VALUES (?,?,?,?)");
            preparedStatement1.setString(1, text1.getText());
            preparedStatement1.setString(2, data1);
            preparedStatement1.setString(3, data2);
            preparedStatement1.setString(4, data3);
            preparedStatement1.execute();
            JOptionPane.showMessageDialog(null, "Data saved");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Unable to save" + ex.getMessage());
            System.err.println("not saved" + ex.getMessage());
        }

    }
}
