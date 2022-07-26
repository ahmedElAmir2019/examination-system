package Login;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import java.net.URL;
import java.util.ResourceBundle;

public class instructor_form implements Initializable {
    @FXML private PieChart pie_chart;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<PieChart.Data>
                PieChartData= FXCollections.observableArrayList(
        new PieChart.Data("cars",5000),
        new PieChart.Data("bike",80),
        new PieChart.Data("mike",1000),
        new PieChart.Data("sasa",300),
        new PieChart.Data("zzz",2000)
        );
        pie_chart.setData(PieChartData);
    }
}
