package hospital;


import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;       
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.*;    

import hospital.MySQLConnect;

public class cost_2 extends AbstractTableModel {
	
	
		

	Vector RowData,ColumnNames;
    static String sql = null;  
    static MySQLConnect db = null;  
    static ResultSet ret = null; 
    
 
 
    public cost_2(String sql)
    {
    	
    	ColumnNames= new Vector();
    	ColumnNames.add("病人id");
		ColumnNames.add("药品名");
		ColumnNames.add("数量");
		ColumnNames.add("价格");
		RowData=new Vector(); 						
	    db = new MySQLConnect(sql);							
	    try {
			ret = db.pst.executeQuery();				
			while (ret.next()) {
	            Vector hang=new Vector();
	        	hang.add(ret.getString(1));
	        	hang.add(ret.getString(2));
	        	hang.add(ret.getInt(3));
	        	hang.add(ret.getDouble(4));
	        	RowData.add(hang);
	        }
	        ret.close();		
	        db.close();			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
    }
    
    
    public cost_2()
    {
		ColumnNames= new Vector();
		ColumnNames.add("病人id");
		ColumnNames.add("药品名");
		ColumnNames.add("数量");
		ColumnNames.add("价格");
		
		
		
		
		RowData=new Vector(); 
		sql = "SELECT Pa_id,Me_id,Me_count,price FROM Me_List";						
	    db = new MySQLConnect(sql);							
	    try {
			ret = db.pst.executeQuery();
			
			while (ret.next()) {
	            Vector hang=new Vector();
	        	hang.add(ret.getString(1));
	        	hang.add(ret.getString(2));
	        	hang.add(ret.getInt(3));
	        	hang.add(ret.getDouble(4));
	        	RowData.add(hang);
	        }
	        ret.close();		
	        db.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    

	
	public int getColumnCount() {
		
		
		return this.ColumnNames.size();
	}

	
	public int getRowCount() {
		
		return this.RowData.size();
	}

	@Override
	public String getColumnName(int arg0) {
		
		return (String)this.ColumnNames.get(arg0);
	}


	
	public Object getValueAt(int row, int column) {
		
		return ((Vector)this.RowData.get(row)).get(column);
	}

}
    
