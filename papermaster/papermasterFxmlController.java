package connection.papermaster;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import connection.dbconnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class papermasterFxmlController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox <String> txtNameCombo;

    @FXML
    private TextField txtPrice;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnsave;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnRemove;

    @FXML
    void doAddNew(ActionEvent event)
    {
    	try 
    	{
			pstmt=dbcon.prepareStatement("insert into papermaster values(?,?)");
			pstmt.setString(1,PaperTitle);
			pstmt.setFloat(2,Float.parseFloat(txtPrice.getText()));
			int status=pstmt.executeUpdate();
			if(status!=0) 
			{
				  Alert alert=new Alert(AlertType.INFORMATION); 
			      alert.setTitle("Success");
				  alert.setContentText("Newspaper Added Successfully"); 
				  alert.show();	 
			}
			else
			{
				  Alert alert=new Alert(AlertType.ERROR); 
			      alert.setTitle("Aw Snap !");
				  alert.setContentText("Something Went Wrong"); 
				  alert.show();	 
				
			}
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    }
    
    @FXML
    void doRemove(ActionEvent event) 
    {
    	try 
    	{
			pstmt=dbcon.prepareStatement("delete from papermaster where title=?");
			pstmt.setString(1,PaperTitle);
			int status=pstmt.executeUpdate();
			if(status!=0) 
			{
				  Alert alert=new Alert(AlertType.INFORMATION); 
			      alert.setTitle("Success");
				  alert.setContentText("Deleted Succesfully"); 
				  alert.show();	  
			}
			else
			{
				  Alert alert=new Alert(AlertType.ERROR); 
			      alert.setTitle("Something Went Wrong");
				  alert.setContentText("Not Deleted"); 
				  alert.show();
				
			}
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}

    }

    @FXML
    void doSave(ActionEvent event) 
    {
    	

    }

    String PaperTitle;
    
    @FXML
    void doSelectComboValue(ActionEvent event) {
    	PaperTitle=txtNameCombo.getSelectionModel().getSelectedItem();
    	
    	try {
			pstmt=dbcon.prepareStatement("select * from papermaster where title=?");
			pstmt.setString(1,PaperTitle);
			
			ResultSet table=pstmt.executeQuery();
			   if(table.next())
			    {
				  float price=table.getFloat("price");
				  txtPrice.setText(String.valueOf(price));
			    }
			   else
			     {
				      Alert alert=new Alert(AlertType.CONFIRMATION); 
				      alert.setTitle("New Paper Addition Detected");
					  alert.setContentText("Adding a New Newspaper , Please Set the Price Accordingly"); 
					  alert.show(); 
			     }
		    } 
    	catch (SQLException e)
    	{	
			e.printStackTrace();
		}
		 
    }

    @FXML
    void doUpdate(ActionEvent event) 
    {
    	try 
    	{
			pstmt=dbcon.prepareStatement("update papermaster set title=? , price=? where title=? ");
			pstmt.setString(1,PaperTitle);
			pstmt.setFloat(2,Float.parseFloat(txtPrice.getText()));
			pstmt.setString(3,PaperTitle);
			int status=pstmt.executeUpdate();
			if(status!=0) 
			{
				  Alert alert=new Alert(AlertType.INFORMATION); 
			      alert.setTitle("Success");
				  alert.setContentText("Updated Succesfully"); 
				  alert.show();	  
			}
			else
			{
				  Alert alert=new Alert(AlertType.ERROR); 
			      alert.setTitle("Something Went Wrong");
				  alert.setContentText("Updation Not Possible , Check Details"); 
				  alert.show();
				
			}
			
			
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
		

    }

    
    Connection dbcon;
    PreparedStatement pstmt;
    ArrayList <String> lst=new ArrayList<String>() ;
    @FXML
    void initialize() {
    	
    	dbcon=dbconnection.getConnection();
        
        try {
			pstmt=dbcon.prepareStatement("select * from papermaster");
			ResultSet table= pstmt.executeQuery();
			
			while(table.next())
			{
				String title =table.getString("title");
				lst.add(title);
			}
		  } 
        catch (SQLException e) {
			e.printStackTrace();
		}
         
        txtNameCombo.getItems().addAll(lst);

    }
}
