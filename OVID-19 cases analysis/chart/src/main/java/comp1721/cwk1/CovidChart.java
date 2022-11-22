package comp1721.cwk1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

// Implement your solution to the Advanced task here
// (Note: the class must be named CovidChart)
public class CovidChart extends Application {
        @Override
        public void start(Stage stage) {
            //创建标题
            stage.setTitle("COMP1721 Coursework1");
            //创建x轴数据域和标签
            NumberAxis xAxis = new NumberAxis(280, 349, 5);
            xAxis.setLabel("Day of Year");
            //创建y轴数据域和标签
            NumberAxis yAxis = new NumberAxis(0, 850, 50);
            yAxis.setLabel("Active Cases");
            //创建折线图标
            final LineChart<Number,Number> lineChart =
                    new LineChart<>(xAxis,yAxis);
            //给折线图表指定相应名称
            lineChart.setTitle("Active Coronavirus Cases,University of Leeds");
            //准备xy相应对象,准备放数据并指定折线名称
            XYChart.Series<Number,Number> series = new XYChart.Series<>();
            series.setName("../datafiles/2020-daily.csv");
            //从2020-active.csv文件中读取相应消息
            BufferedReader reader= null;
            try {
                reader = new BufferedReader(new FileReader("D:\\final coursework\\coursework\\cwk1\\chart\\datafiles\\2020-active.csv"));
                reader.readLine();
                String line = null;
                while((line=reader.readLine())!=null){
                    String[] item = line.split(",");
                    LocalDate date = LocalDate.parse(item[0]);
                    int staffCases = Integer.parseInt(item[1]);
                    int studentCases = Integer.parseInt(item[2]);
                    int otherCases = Integer.parseInt(item[3]);
                    //将日期进行转化成相应天数的算法
                    int days = 0;
                    if(date.isLeapYear()){
                        for (int i = 1; i <date.getMonth().getValue() ; i++) {
                            if(i==2){
                                days+=29;
                            }else if(i==1||i==3||i==5||i==7||i==8||i==10||i==12){
                                days+=31;
                            }else {
                                days+=30;
                            }
                        }
                    }else{
                        for (int i = 1; i <date.getMonth().getValue() ; i++) {
                            if(i==2){
                                days+=28;
                            }else if(i==1||i==3||i==5||i==7||i==8||i==10||i==12){
                                days+=31;
                            }else {
                                days+=30;
                            }
                        }
                    }
                    days+=date.getDayOfMonth();
//                    LocalDate yeraoffirstday = LocalDate.of(2020, 1, 1);
//                    LocalDate yeraoflastday = LocalDate.of(2020, 9, 28);
//                    Period period = Period.between(yeraoffirstday,yeraoflastday);
                    //计算当天的总比例数
                    int sumcases=staffCases+studentCases+otherCases;
                    //指定相应坐标数据
                    series.getData().add(new XYChart.Data<Number,Number>(days, sumcases));
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //建立数据到折线表
            lineChart.getData().add(series);
            //建立折线图的尺寸
            Scene scene  = new Scene(lineChart,800,600);
            stage.setScene(scene);
            stage.show();
        }

        public static void main(String[] args) {
            //javafx.application.Application下的静态方法
            launch(args);
        }
}


