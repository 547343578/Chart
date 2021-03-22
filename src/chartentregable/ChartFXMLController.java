/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chartentregable;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author 王竹青
 */
public class ChartFXMLController implements Initializable {
    
  
    @FXML
    private PieChart pieChart;
    @FXML
    private LineChart<?, ?> lineChart;
    @FXML
    private BarChart<?, ?> barChart;
         
         int suspenso = 0; int aprobado = 0;int bien = 0;int notable = 0;int sobresaliente = 0;
    boolean checkBright = true;
      
         ObservableList<PieChart.Data> pie_chart_data = FXCollections.observableArrayList(
         new PieChart.Data("Suspenso",suspenso),
         new PieChart.Data("Aprobado",aprobado),
         new PieChart.Data("Bien",bien),
         new PieChart.Data("Notable",notable),
         new PieChart.Data("Sobresaliente",sobresaliente)
         );
         ObservableList<XYChart.Data<String,Number>> line_chart_data = FXCollections.observableArrayList(
         new XYChart.Data("Suspenso",suspenso),
         new XYChart.Data("Aprobado",aprobado),
         new XYChart.Data("Bien",bien),
         new XYChart.Data("Notable",notable),
         new XYChart.Data("Sobresaliente",sobresaliente)
         );
         ObservableList<XYChart.Data<String,Number>> bar_chart_data = FXCollections.observableArrayList(
         new XYChart.Data("Suspenso",suspenso),
         new XYChart.Data("Aprobado",aprobado),
         new XYChart.Data("Bien",bien),
         new XYChart.Data("Notable",notable),
         new XYChart.Data("Sobresaliente",sobresaliente)
         );
    @FXML
    private ImageView barButton;
    @FXML
    private ImageView lineButton;
    @FXML
    private ImageView brightButton;
    @FXML
    private Button Suspendido;
    @FXML
    private Button Aprobado;
    @FXML
    private Button Bien;
    @FXML
    private Button Notable;
    @FXML
    private Button Sobresaliente;
    @FXML
    private Button bar2;
    @FXML
    private Button line2;
    @FXML
    private Button constrast2;
    @FXML
    private AnchorPane anchorPane;
         
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
        Image image = new Image("/icons/bar.png");
        Image image2 = new Image("/icons/line.png");
        Image image3 = new Image("/icons/color.png");            
        barButton.setImage(image);
        lineButton.setImage(image2);
        brightButton.setImage(image3);
        
       XYChart.Series s1 = new XYChart.Series(bar_chart_data); 
       XYChart.Series s2 = new XYChart.Series(line_chart_data);
       s1.setName("Alumnos con cada nota");
       s2.setName("Alumnos con cada nota");
       
        
       pieChart.setData(pie_chart_data);
       lineChart.getData().add(s2);
       barChart.getData().add(s1);
       
       
       barButton.setOpacity(0.25);
       lineButton.setOpacity(1);
       barChart.setVisible(true);
       lineChart.setVisible(false); 
    }    
  
    @FXML
    private void barClicked(MouseEvent event) {
     barButton.setOpacity(0.25);
     lineButton.setOpacity(1);
     barChart.setVisible(true);
     lineChart.setVisible(false);
    }
    
            

    @FXML
    private void lineClicked(MouseEvent event) {
     barButton.setOpacity(1);
     barChart.setVisible(false);
     lineChart.setVisible(true);
     lineButton.setOpacity(0.25);
    }

    @FXML
    private void contrastClicked(MouseEvent event) {
        if(this.checkBright == true){
        String cssDark = this.getClass().getResource("ChartCSScontrast.css").toExternalForm();
        anchorPane.getStylesheets().clear();
        anchorPane.getStylesheets().add(cssDark);
        this.checkBright = false;
        } 
        else{
        String cssClear = this.getClass().getResource("ChartCSS.css").toExternalForm();
        anchorPane.getStylesheets().clear();
        anchorPane.getStylesheets().add(cssClear);
        this.checkBright = true;
        
             }
    }

    @FXML
    private void SuspensoClicked(MouseEvent event) {
          pie_chart_data.get(0).setPieValue(suspenso+1);
          bar_chart_data.get(0).YValueProperty().bind(pie_chart_data.get(0).pieValueProperty());
          line_chart_data.get(0).YValueProperty().bind(pie_chart_data.get(0).pieValueProperty());
          suspenso++;
          
    }

    @FXML
    private void AprobadoClicked(MouseEvent event) {
        pie_chart_data.get(1).setPieValue(aprobado+1);
        bar_chart_data.get(1).YValueProperty().bind(pie_chart_data.get(1).pieValueProperty());
        line_chart_data.get(1).YValueProperty().bind(pie_chart_data.get(1).pieValueProperty());
        aprobado++;
    }

    @FXML
    private void BienClicked(MouseEvent event) {
        pie_chart_data.get(2).setPieValue(bien+1);
        bar_chart_data.get(2).YValueProperty().bind(pie_chart_data.get(2).pieValueProperty());
        line_chart_data.get(2).YValueProperty().bind(pie_chart_data.get(2).pieValueProperty());
        bien++;
    }

    @FXML
    private void NotableClicked(MouseEvent event) {
        pie_chart_data.get(3).setPieValue(notable+1);
        bar_chart_data.get(3).YValueProperty().bind(pie_chart_data.get(3).pieValueProperty());
        line_chart_data.get(3).YValueProperty().bind(pie_chart_data.get(3).pieValueProperty());
        notable++;
    }

    @FXML
    private void SobresalienteClicked(MouseEvent event) {
        pie_chart_data.get(4).setPieValue(sobresaliente+1);
        bar_chart_data.get(4).YValueProperty().bind(pie_chart_data.get(4).pieValueProperty());
        line_chart_data.get(4).YValueProperty().bind(pie_chart_data.get(4).pieValueProperty());
        sobresaliente++;
    }
    
    
}
