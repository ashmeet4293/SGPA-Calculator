package sgpa.calculator;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author ashmeet
 */
public class FXMLDocumentController implements Initializable {

    private Label label;
    @FXML
    private ComboBox<String> grade1;
    @FXML
    private ComboBox<String> crHour1;
    @FXML
    private ComboBox<String> grade2;
    @FXML
    private ComboBox<String> crHour2;
    @FXML
    private ComboBox<String> grade3;
    @FXML
    private ComboBox<String> crHour3;
    @FXML
    private Label lblShowSGPA;
    @FXML
    private ComboBox<String> grade4;
    @FXML
    private ComboBox<String> crHour4;
    @FXML
    private ComboBox<String> grade5;
    @FXML
    private ComboBox<String> crHour5;
    @FXML
    private ComboBox<String> grade6;
    @FXML
    private ComboBox<String> crHour6;
    @FXML
    private ComboBox<String> grade7;
    @FXML
    private ComboBox<String> crHour7;
    @FXML
    private ComboBox<String> grade8;
    @FXML
    private ComboBox<String> crHour8;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> grade = FXCollections.observableArrayList("A", "A-", "B+", "B", "B-", "C+", "C",
                "C-", "D+", "D", "F");
        ObservableList<String> crHr = FXCollections.observableArrayList("5", "4", "3", "2", "1");

        grade1.setItems(grade);
        grade2.setItems(grade);
        grade3.setItems(grade);
        grade4.setItems(grade);
        grade5.setItems(grade);
        grade6.setItems(grade);
        grade7.setItems(grade);
        grade8.setItems(grade);

        crHour1.setItems(crHr);
        crHour2.setItems(crHr);
        crHour3.setItems(crHr);
        crHour4.setItems(crHr);
        crHour5.setItems(crHr);
        crHour6.setItems(crHr);
        crHour7.setItems(crHr);
        crHour8.setItems(crHr);

    }

    @FXML
    private void handleGradeAction(ActionEvent event) {
    }

    @FXML
    private void handleCreditHourAction(ActionEvent event) {
    }

    @FXML
    private void handleCalculateSGPA(ActionEvent event) {

        List<String> value = new ArrayList();
        value.add(crHour1.getSelectionModel().getSelectedItem() + "/" + grade1.getSelectionModel().getSelectedItem());
        value.add(crHour2.getSelectionModel().getSelectedItem() + "/" + grade2.getSelectionModel().getSelectedItem());
        value.add(crHour3.getSelectionModel().getSelectedItem() + "/" + grade3.getSelectionModel().getSelectedItem());
        value.add(crHour4.getSelectionModel().getSelectedItem() + "/" + grade4.getSelectionModel().getSelectedItem());
        value.add(crHour5.getSelectionModel().getSelectedItem() + "/" + grade5.getSelectionModel().getSelectedItem());
        value.add(crHour6.getSelectionModel().getSelectedItem() + "/" + grade6.getSelectionModel().getSelectedItem());
        value.add(crHour7.getSelectionModel().getSelectedItem() + "/" + grade7.getSelectionModel().getSelectedItem());
        value.add(crHour8.getSelectionModel().getSelectedItem() + "/" + grade8.getSelectionModel().getSelectedItem());

        double grade = 0, totalValue = 0;
        Double finalValue = 0.0;
        Integer countCrHour = 0;
        int crHour;
        for (String a : value) {
            try {
                if ((a.contains("null/null")) | (a.contains("null/")) | (a.contains("/null"))) {
                    throw new NullPointerException("Error ");
                }

                String[] parts = a.split("/");
                String part1 = parts[0];
                String part2 = parts[1];
                crHour = Integer.parseInt(part1);

                countCrHour = countCrHour + crHour;
                switch (part2) {
                    case "A":
                        totalValue = 4 * crHour;
                        finalValue = finalValue + totalValue;
                        break;
                    case "A-":
                        totalValue = 3.7 * crHour;
                        finalValue = finalValue + totalValue;
                        break;
                    case "B+":
                        totalValue = 3.3 * crHour;
                        finalValue = finalValue + totalValue;
                        break;

                    case "B":
                        totalValue = 3.0 * crHour;
                        finalValue = finalValue + totalValue;
                        break;
                    case "B-":
                        totalValue = 2.7 * crHour;
                        finalValue = finalValue + totalValue;
                        break;
                    case "C+":
                        totalValue = 2.3 * crHour;
                        finalValue = finalValue + totalValue;
                        break;
                    case "C":
                        totalValue = 2.0 * crHour;
                        finalValue = finalValue + totalValue;
                        break;
                    case "C-":
                        totalValue = 1.7 * crHour;
                        finalValue = finalValue + totalValue;
                        break;
                    case "D+":
                        totalValue = 1.3 * crHour;
                        finalValue = finalValue + totalValue;
                        break;
                    case "D":
                        totalValue = 1.0 * crHour;
                        finalValue = finalValue + totalValue;
                        break;
                    case "F":
                        totalValue = 0 * crHour;
                        finalValue = finalValue + totalValue;
                        break;

                    default:
                        return;
                }
            } catch (NullPointerException ex) {
                System.out.println("Others are null ");
            }
        }
        if (totalValue == 0) {
            System.out.println("Failed");
            lblShowSGPA.setText("Failed");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Sorry ! ");
            alert.setContentText("You are failed");
            alert.showAndWait();
//            txtResult.setText("Failed");
            return;
        }
        System.out.println("SGPA : " + (finalValue));
        double sgpa = finalValue / countCrHour;

        lblShowSGPA.setText("SGPA : " + (double) Math.round(sgpa * 100) / 100);
//        txtResult.setText("SGPA : "+(double)Math.round(sgpa*100)/100);
    }

    @FXML
    private void handleMenuAboutUs(ActionEvent event) {
    }

    @FXML
    private void handleMenuHelpAction(ActionEvent event) {
    }

    @FXML
    private void handleClearAction(ActionEvent event) {
         grade1.setItems(null);
        grade2.setItems(null);
        grade3.setItems(null);
        grade4.setItems(null);
        grade5.setItems(null);
        grade6.setItems(null);
        grade7.setItems(null);
        grade8.setItems(null);

        crHour1.setItems(null);
        crHour2.setItems(null);
        crHour3.setItems(null);
        crHour4.setItems(null);
        crHour5.setItems(null);
        crHour6.setItems(null);
        crHour7.setItems(null);
        crHour8.setItems(null);
        
    }

}
