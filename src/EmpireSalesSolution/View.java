
package EmpireSalesSolution;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class View extends JFrame{
    public static JLabel label1;
    public static JPanel panel;
    public static JScrollPane scroll;
    public static JTable table;
    public static String trainerName;
    public View(){
        
    Container contentPane = getContentPane();
    setLayout  (null);
    setSize(1200,1200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.RED);
        
        JPanel panel =new JPanel(null);
        panel.setBounds(0, 0, 1200, 50);
        panel.setBackground(Color.red);
        
        JTable table = new JTable();
       // table.setBounds(0, 50, 1190, 1100);
        add(table);
        
        
        JScrollPane scroll = new JScrollPane(table,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(0, 50, 1190, 1100);
        scroll.getViewport().add(createView());
        //scroll.setBackground(Color.red);
        add(scroll);
        
        label1 =new JLabel("THE FOLLOWING IS YOUR PROGRESS REPORT");
        label1.setBounds(30, 0, 700, 50);
        panel.add(label1);
        
        add(panel);
        repaint();
        setVisible(true);
        
    }
    
     public static DefaultTableModel buildtableModel(ResultSet resultSet) throws SQLException {

        ResultSetMetaData metaData = resultSet.getMetaData();

        Vector<String> columnNames = new Vector<>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));

        }

        Vector<Vector<Object>> data = new Vector<>();
        while (resultSet.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(resultSet.getObject(columnIndex));
            }
            data.add(vector);
        }
 
        return new DefaultTableModel(data, columnNames);

    }

    protected static JTable createView() {
        try {
            trainerName=trainer.getTrainerField().getText();
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/empiresalessolution", "root", "");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT hotpots,flasks,glasses FROM SALARIES where username='"+trainerName+"'");

            table = new JTable(buildtableModel(rs));
            table.setRowHeight(30);
            table.setShowGrid(true);
            table.setBackground(Color.WHITE);
            table.setFont(new Font("calibri", Font.PLAIN, 16));
            
            rs.close();

        } catch (SQLException | HeadlessException exc) {
            JOptionPane.showMessageDialog(null, exc);
        }
        return table;
    }
    
    
    public static void main (String [] args){
        new View();
    }
}
