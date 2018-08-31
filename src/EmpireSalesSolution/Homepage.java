package EmpireSalesSolution;

import javax.swing.*;
import java.awt.*;
import static java.awt.Color.RED;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
public class Homepage extends JFrame {

    public static JButton button1, button2, button3;
    public static JLabel title;
    public static JLabel head;
    private static JLabel imagelabel;

    public Homepage() {
        super(" LOGIN TO YOUR RESPECTIVE CATEGORY");
        Container contentPane = getContentPane();
        setLayout(null);
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.red);

        JPanel panel = new JPanel(null);
        panel.setBounds(0, 0, 400, 400);
        panel.setBackground(Color.decode("#2980B9"));
        
        imagelabel= new JLabel(new ImageIcon(getClass().getResource("/images/pic1.jpg")));
        imagelabel.setBounds(0,0 , 400, 400);
        

        title = new JLabel("WELCOME TO EMPIRE SALES LIMITED");
        title.setBounds(100, 20, 300, 30);
        title.setForeground(Color.white);
        panel.add(title);
        head = new JLabel("HARDWORK PAYS!!!");
        head.setForeground(Color.white);
        head.setBounds(150, 40, 250, 30);

        panel.add(title);
        panel.add(head);

        button1 = new JButton("MANAGER LOGIN");
        button2 = new JButton("TRAINER LOGIN");
        button3 = new JButton("ROCKIE LOGIN");

        button1.setBounds(120, 90, 130, 30);
        //button1.setBackground(Color.BLUE);
        //button1.setBorder(new LineBorder(Color.BLUE));
        //button1.setForeground(Color.WHITE);

        button2.setBounds(120, 140, 130, 30);
        button3.setBounds(120, 190, 130, 30);

        panel.add(button1);
        panel.add(button2);
        panel.add(button3);

        button1.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        manager m = new manager(true);
                    }
                }
        );
        button2.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        trainer trainer = new trainer();
                    }
                }
        );
        button3.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        rockie  rockie= new rockie();
                    }
                }
        );

        panel.add(imagelabel);
        add(panel);
        
        repaint();
        setVisible(true);

    }

    public static void main(String[] args) {
        new Homepage();
    }

}
