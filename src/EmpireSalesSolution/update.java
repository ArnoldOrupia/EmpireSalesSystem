
package EmpireSalesSolution;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;

public class update extends JFrame {
    public static JScrollPane scrol;
    public static JTable table;
    public static JPanel panel1,panel2 ,panel3;
    public static JLabel label1,label2,label3,label4,label5;
    public static JTextField text1,text2,text3,text4,text5,text6,text7,text8,text9,text10,
            text11,text12,text13,text14,text15;
    
    public update(){
        
        panel3=new JPanel();
        add(panel3,BorderLayout.NORTH);
        panel3.setBorder(new TitledBorder ("ENTER THE DAILY SALES"));
        
        
        
        panel1=new JPanel();
        panel1.setLayout(new GridLayout(4,5,2,2));
        panel1.setBackground(Color.red);
        
        add(panel1,BorderLayout.CENTER);
        
        
        
        label1=new JLabel("EMPLOYEE ID");
        panel1.add(label1);
        
        //label2=new JLabel("CATEGORY");
        //panel1.add(label2);
        
        label3=new JLabel("HOTPOTS");
        panel1.add(label3);
        
        label4=new JLabel("GLASSES");
        panel1.add(label4);
        
        label5=new JLabel("FLASKS");
        panel1.add(label5);
        
        
       /* text1= new JTextField();
        panel1.add(text1);
        
        text2= new JTextField();
        panel1.add(text2);
        
        text3= new JTextField();
        panel1.add(text3);*/
        
        text4= new JTextField();
        panel1.add(text4);
        
    text5= new JTextField();
        panel1.add(text5);
        text6= new JTextField();
        panel1.add(text6);
        text7= new JTextField();
        panel1.add(text7);
        text8= new JTextField();
        panel1.add(text8);
        text9= new JTextField();
        panel1.add(text9);
        
        text10= new JTextField();
        panel1.add(text10);

    text11= new JTextField();
        panel1.add(text11);
    text12= new JTextField();
        panel1.add(text12);
    text13= new JTextField();
        panel1.add(text13);
    text14= new JTextField();
        panel1.add(text14);
    text15= new JTextField();
        panel1.add(text15);
        
        panel2= new JPanel();
        add(panel2,BorderLayout.SOUTH);
        
        JButton btn=new JButton("SUBMIT");
        panel2.add(btn);
        
        
    
    
    }
    public static void main (String [] args){
        update up= new update();
        up.setSize(500, 200);
        up.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        up.setVisible(true);
        
    }
}
