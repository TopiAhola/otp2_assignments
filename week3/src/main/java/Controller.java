import javafx.fxml.FXML;
import javafx.geometry.NodeOrientation;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.util.Locale;
import java.util.ResourceBundle;


public class Controller {

    @FXML
    private VBox root;
    @FXML
    private Label titleLabel;
    @FXML
    private Label lblDistance;
    @FXML
    private Label lblConsumption;
    @FXML
    private Label lblPrice;
    @FXML
    private Label lblResult;
    @FXML
    private TextField txtDistance;
    @FXML
    private TextField txtConsumption;
    @FXML
    private TextField txtPrice;
    @FXML
    private TextField lblResultText;
    @FXML
    private Button btnCalculate;
    @FXML
    private Button btnEN;
    @FXML
    private Button btnFR;
    @FXML
    private Button btnJP;
    @FXML
    private Button btnIR;


    //resourceBundles
    ResourceBundle currentBundle;
    ResourceBundle[] bundles;

    //reference to Calculator
    Calculator calculator;

    @FXML
    public void initialize(){

        //Locales
        Locale eng = new Locale("en", "US");
        Locale fra = new Locale("fr","FR");
        Locale jpn = new Locale("ja","JP");
        Locale per = new Locale("fa","IR");

        //ResourceBundles
        ResourceBundle english = ResourceBundle.getBundle("moreLanguages", eng);
        ResourceBundle french = ResourceBundle.getBundle("moreLanguages", fra);
        ResourceBundle japanese = ResourceBundle.getBundle("moreLanguages", jpn);
        ResourceBundle persian = ResourceBundle.getBundle("moreLanguages", per);

        //set default bundle
        bundles = new ResourceBundle[] {english,french,japanese, persian};
        currentBundle = english;
        root.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        btnIR.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

        //make the calculator
        calculator = new Calculator();

        //load text
        loadLanguageStrings();

        //set functions for language buttons
        btnEN.setOnAction(e -> {
            currentBundle = english;
            setLeftToRight();
            loadLanguageStrings();
        });
        btnFR.setOnAction(e -> {
            currentBundle = french;
            setLeftToRight();
            loadLanguageStrings();
        });
        btnJP.setOnAction(e -> {
            currentBundle = japanese;
            setLeftToRight();
            loadLanguageStrings();
        });
        btnIR.setOnAction(e -> {
            currentBundle = persian;
            setRightToLeft();
            loadLanguageStrings();
        });

        //function for calculate button
        btnCalculate.setOnAction(e -> {
          try {
              double distance = Double.parseDouble(txtDistance.getText().trim());
              double consumption =  Double.parseDouble(txtConsumption.getText().trim());
              double price = Double.parseDouble(txtPrice.getText().trim());

              System.out.println(distance + " " + consumption + " " + price);

              lblResultText.setText(
                      String.format("%.02fl %.02f" ,
                      calculator.calculateConsumption(distance,consumption),
                      calculator.calculateCost(distance,consumption, price)
                      )
              );

          } catch (Exception ex) {
              ex.printStackTrace();
              lblResultText.setText(currentBundle.getString("errorMessage"));
          }
        });

    }


    protected void loadLanguageStrings(){
        titleLabel.setText(currentBundle.getString("titleLabel"));
        btnEN.setText(currentBundle.getString("btnEN"));
        btnFR.setText(currentBundle.getString("btnFR"));
        btnJP.setText(currentBundle.getString("btnJP"));
        btnIR.setText(currentBundle.getString("btnIR"));

        lblDistance.setText(currentBundle.getString("lblDistance"));
        lblConsumption.setText(currentBundle.getString("lblConsumption"));
        lblPrice.setText(currentBundle.getString("lblPrice"));
        lblResult.setText(currentBundle.getString("lblResult"));
        btnCalculate.setText(currentBundle.getString("btnCalculate"));

        //prompts
        txtDistance.setPromptText(currentBundle.getString("txtDistance"));
        txtConsumption.setPromptText(currentBundle.getString("txtConsumption"));
        txtPrice.setPromptText(currentBundle.getString("txtPrice"));
        lblResultText.setPromptText(currentBundle.getString("lblResultText"));

        //try setting font that has japanese characters
        //Font font = Font.font("Noto", 10);   /Noto Serif CJK

        Font font = Font.font("Noto Sans CJK JP", 10);
        if(font != null){
            root.setStyle("-fx-font-family: Noto Sans CJK JP;");

            titleLabel.setFont(font);
            btnEN.setFont(font);
            btnFR.setFont(font);
            btnJP.setFont(font);
            btnIR.setFont(font);

            lblDistance.setFont(font);
            lblConsumption.setFont(font);
            lblPrice.setFont(font);
            lblResult.setFont(font);
            btnCalculate.setFont(font);

            //promptssetFont(font);
            txtDistance.setFont(font);
            txtConsumption.setFont(font);
            txtPrice.setFont(font);
            lblResultText.setFont(font);

        }

    }


    protected void setLeftToRight(){
        //persian is always rtl
        btnIR.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        btnEN.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        btnFR.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        btnJP.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);

        titleLabel.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        lblDistance.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        lblConsumption.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        lblPrice.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        lblResult.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        btnCalculate.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        txtDistance.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        txtConsumption.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        txtPrice.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        lblResultText.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
    }

    protected void setRightToLeft(){
        //persian is always rtl
        btnIR.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        btnEN.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        btnFR.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        btnJP.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);

        titleLabel.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        lblDistance.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        lblConsumption.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        lblPrice.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        lblResult.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        btnCalculate.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        txtDistance.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        txtConsumption.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        txtPrice.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        lblResultText.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

    }







}
