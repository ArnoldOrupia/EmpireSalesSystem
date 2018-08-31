
package EmpireSalesSolution;

import javax.swing.*;
import java.awt.*;
public class TView extends JFrame{
    private JLabel l1,l2,l3,l4,l5,l6;
    private JTextField txt1,txt2,txt3,txt4,txt5,txt6;
    public TView(){
        JPanel panel=new JPanel();
        panel.setBackground(Color.red);
        panel.setLayout(new GridLayout(2,3,2,2));
        add(panel);
        
        
      
     
        l4=new JLabel("Thermos");
        panel.add(l4);
        l5=new JLabel("Hotpot");
        panel.add(l5);
        l6=new JLabel("Glass");
        panel.add(l6);
        
        

        txt4=new JTextField();
        panel.add(txt4);
        txt5=new JTextField();
        panel.add(txt5);
        txt6=new JTextField();
        panel.add(txt6);
    }
    
    public static void main(String[] args){
        TView view=new TView();
        view.setLocationRelativeTo(null);
        view.setSize(500,150);
        view.setVisible(true);
    }
    
}
