package Titanic_xchart;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;
import org.knowm.xchart.*;




public class XChart {
    public static void main(String[] args) {
        ObjectMapper map = new ObjectMapper();
        map.configure (DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try{
            FileInputStream fileInputStream = new FileInputStream("files\\titanic_csv.json");
            List<Passengers> passengers = map.readValue(fileInputStream, new TypeReference<List<Passengers>>() {});
            
            XChart.catagoryChart(passengers);
            XChart.pieChart(passengers);
            XChart.boxChart(passengers);


        } catch (FileNotFoundException e) {
        } catch (IOException e) {
    }}
    public static void catagoryChart(List<Passengers> allPassengers) {

        CategoryChart ch = new CategoryChartBuilder().width(1024)
                .height(1000)
                .title("Age ")
                .xAxisTitle("Names")
                .yAxisTitle("Age")
                .build();


        List<Float> allAges = allPassengers.stream().map(Passengers::getAge).limit(5).collect(Collectors.toList());
        List<String> allNames = allPassengers.stream().map(Passengers::getName).limit(5).collect(Collectors.toList());

        ch.addSeries("all ages ", allNames, allAges);
        new SwingWrapper(ch).displayChart();

    }


    public static void pieChart(List<Passengers> allPassengers) {
        PieChart chart2 = new PieChartBuilder().width(1000).height(1000).title("second chart").build();
        try{
        Map<Float, List<Passengers>> pclasses= allPassengers.stream()
                .collect(Collectors.groupingBy(Passengers::getPclass));

        pclasses.keySet().stream().forEach((key) -> chart2.addSeries("Pclass " + key, (Number) pclasses.get(key)));
        new SwingWrapper(chart2).displayChart();
        }catch(Exception e){}
    }

    public static void boxChart(List<Passengers> allPassengers) {
        BoxChart chart1 = new BoxChartBuilder().width(1000).height(1000).title("first chart").build();
        List<Float> ages = allPassengers.stream().map(Passengers::getAge).collect(Collectors.toList());
        chart1.addSeries("Passenger's Ages ", ages);
        new SwingWrapper(chart1).displayChart();

    }
    
}