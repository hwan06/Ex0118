package application;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Screen1Contoroller implements Initializable {

	@FXML Label lblSum,lblText;
	@FXML Button btnScreenMove, btnScreenClose,btnCal;
	@FXML TextField txtPer,txtPrice;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	//두번째화면으로 전환
	public void btnScreenMoveAction(ActionEvent event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Screen2.fxml"));
			Stage stage = new Stage();
			stage.setTitle("두번째 화면");
			stage.setScene(new Scene(root,600,400));
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//창닫기
	public void btnScreenClosAction(ActionEvent event) {
		Stage stage = (Stage) btnScreenClose.getScene().getWindow();
		stage.close();
	}
	
	public void btnCalAction(ActionEvent event) {
		
		 // 수량값을 숫자로 변환
		 int tempPer1 = Integer.parseInt(txtPer.getText());
		
		 // 단가값을 숫자로 변환
		 int price = Integer.parseInt(txtPrice.getText());
		
		 // 클래스 접근용 객체 선언
		 MulModel sum = new MulModel();
		 // 1000단위당 쉼표
		 DecimalFormat df = new DecimalFormat("#,###");
		 
		 
		 // 매개변수인 'tempPer1','price' 선언
		 int tmpSum = sum.mul(tempPer1, price);
		 
		 // 출력 (DecimalFormat은 문자열이기 때문에 굳이 문자열 변환이 필요없음)
		 lblSum.setText(df.format(tmpSum));
		
	}
	
}
