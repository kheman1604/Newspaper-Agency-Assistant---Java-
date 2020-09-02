package connection.papermaster;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import connection.dbconnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class papermasterFxmlController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> txtNameCombo;

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
    void doAddNew(ActionEvent event) {
    	try {
			pstmt=dbcon.prepareStatement("insert into papermaster values(?,?)");
			pstmt.setString(1,PaperTitle);
			pstmt.setFloat(2,Float.parseFloat(txtPrice.getText()));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

    }

    @FXML
    void doRemove(ActionEvent event) {

    }

    @FXML
    void doSave(ActionEvent event) {
    	

    }

    String PaperTitle;
    
    @FXML
    void doSelectComboValue(ActionEvent event) {
    	PaperTitle=txtNameCombo.getSelectionModel().getSelectedItem();
    	
		 /*
		 * Alert alert=new Alert(AlertType.ERROR); alert.setTitle("Title");
		 * alert.setContentText(PaperTitle); alert.show();
		 */


    }

    @FXML
    void doUpdate(ActionEvent event) {

    }

    
    Connection dbcon;
    PreparedStatement pstmt;
    @FXML
    void initialize() {
    	
    	dbcon=dbconnection.getConnection();
        assert txtNameCombo != null : "fx:id=\"txtNameCombo\" was not injected: check your FXML file 'papermasterFxml.fxml'.";
        assert txtPrice != null : "fx:id=\"txtPrice\" was not injected: check your FXML file 'papermasterFxml.fxml'.";
        assert btnAdd != null : "fx:id=\"btnAdd\" was not injected: check your FXML file 'papermasterFxml.fxml'.";
        assert btnsave != null : "fx:id=\"btnsave\" was not injected: check your FXML file 'papermasterFxml.fxml'.";
        assert btnUpdate != null : "fx:id=\"btnUpdate\" was not injected: check your FXML file 'papermasterFxml.fxml'.";
        assert btnRemove != null : "fx:id=\"btnRemove\" was not injected: check your FXML file 'papermasterFxml.fxml'.";

    }
}
