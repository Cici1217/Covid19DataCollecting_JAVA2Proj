package qianduan;

import houduan.getDatasetFileFromFirstUrl.One.casesReportedDaily;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.util.Duration;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class Pro1Controller implements Initializable {
    @FXML
    VBox vBox;
    @FXML
    AnchorPane an,chartPlace;
    @FXML
    MenuBar menuBar;

    @FXML
    ListView<Data> listView;

    @FXML
    Label label;

    @FXML
    Button updateButton,bu,stop,speed,back;

    @FXML
    MenuButton chartChoice;

    @FXML
    Menu sorting,dataSource;

    @FXML
    CustomMenuItem source1,source2;



    @FXML
    Menu sort1,sort2,sort3,sort4;

    @FXML
    TextField textField;

    @FXML
    MenuItem on1,on2,on3,on4,down1,down2,down3,down4,pieChart,barChart,lineChart;

    @FXML
    CheckBox totalCases,newlyCases,totalDeath,newlyDeath;

    @FXML
    Hyperlink link1,link2;


    String current="PieChart";
    String PieChart="PieChart",BarChart="BarChart",LineChart="LineChart";

    static ObservableList<Data> temp = FXCollections.observableArrayList();
    static  ArrayList<Integer> parameters=new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {



        //重置焦点 不确定
        an.requestFocus();


        //暂时这么写样本数据(Data.data)



        ArrayList<Data> dataArrayList =new ArrayList<>();

        casesReportedDaily casesReportedDaily = new casesReportedDaily();
        for(ArrayList<Data> arrayList : casesReportedDaily.Run().values()){
            dataArrayList.add(arrayList.get(arrayList.size()-1));

        };


        Data.setData(dataArrayList);


       //暂时这么加入样本数据，不确定对不对
        ObservableList<Data> observableList=FXCollections.observableArrayList();
        observableList.addAll(Data.getData());




        listView.setCellFactory(TextFieldListCell.forListView(new StringConverter<Data>() {
            @Override
            public String toString(Data object) {
                String s="\t"+object.getCountry()+"\t\t\t"+object.getCumulative_cases()+"\t\t\t"+object.getNew_cases()+
                        "\t\t\t"+object.getCumulative_deaths()+"\t\t\t"+object.getNew_deaths();
                return s;
            }

            @Override
            public Data fromString(String string) {
                return null;
            }
        }));



        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                FilteredList<Data> fin=observableList.filtered(new Predicate<Data>() {
                    @Override
                    public boolean test(Data data) {
                        if (data.getCountry().contains(newValue)){
                            return true;
                        }else {
                            return false;
                        }
                    }
                });
                listView.setItems(fin);
            }
        });

        on1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SortedList<Data> fin=observableList.sorted(new Comparator<Data>() {
                    @Override
                    public int compare(Data o1, Data o2) {

                        return o1.getCumulative_cases()-o2.getCumulative_cases();
                    }
                });
                listView.setItems(fin);
            }
        });
        down1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SortedList<Data> fin=observableList.sorted(new Comparator<Data>() {
                    @Override
                    public int compare(Data o1, Data o2) {

                        return o2.getCumulative_cases()-o1.getCumulative_cases();
                    }
                });
                listView.setItems(fin);
            }
        });

        on2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SortedList<Data> fin=observableList.sorted(new Comparator<Data>() {
                    @Override
                    public int compare(Data o1, Data o2) {

                        return o1.getNew_cases()-o2.getNew_cases();
                    }
                });
                listView.setItems(fin);
            }
        });
        down2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SortedList<Data> fin=observableList.sorted(new Comparator<Data>() {
                    @Override
                    public int compare(Data o1, Data o2) {

                        return o2.getNew_cases()-o1.getNew_cases();
                    }
                });
                listView.setItems(fin);
            }
        });
        on3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SortedList<Data> fin=observableList.sorted(new Comparator<Data>() {
                    @Override
                    public int compare(Data o1, Data o2) {

                        return o1.getCumulative_deaths()-o2.getCumulative_deaths();
                    }
                });
                listView.setItems(fin);
            }
        });
        down3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SortedList<Data> fin=observableList.sorted(new Comparator<Data>() {
                    @Override
                    public int compare(Data o1, Data o2) {

                        return o2.getCumulative_deaths()-o1.getCumulative_deaths();
                    }
                });
                listView.setItems(fin);
            }
        });
        on4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SortedList<Data> fin=observableList.sorted(new Comparator<Data>() {
                    @Override
                    public int compare(Data o1, Data o2) {

                        return o1.getNew_deaths()-o2.getNew_deaths();
                    }
                });
                listView.setItems(fin);
            }
        });
        down4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SortedList<Data> fin=observableList.sorted(new Comparator<Data>() {
                    @Override
                    public int compare(Data o1, Data o2) {

                        return o2.getNew_deaths()-o1.getNew_deaths();
                    }
                });
                listView.setItems(fin);
            }
        });
        on1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SortedList<Data> fin=observableList.sorted(new Comparator<Data>() {
                    @Override
                    public int compare(Data o1, Data o2) {

                        return o1.getCumulative_cases()-o2.getCumulative_cases();
                    }
                });
                listView.setItems(fin);
            }
        });

        menuBar.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                listView.setItems(observableList);

            }
        });


        totalCases.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (totalCases.isSelected()) {
                    System.out.println("totalCases");
                    parameters.add(0);
                    parameters.forEach(System.out::println);
                }else {
                    parameters.remove(new Integer(0));
                    parameters.forEach(System.out::println);
                }
            }
        });

        totalCases.setSelected(true);
//        parameters.add(0);


        newlyCases.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (newlyCases.isSelected()) {
                    System.out.println("newlyCases");
                    parameters.add(1);
                    parameters.forEach(System.out::println);
                }else {
                    parameters.remove(new Integer(1));
                    parameters.forEach(System.out::println);
                }
            }
        });




        totalDeath.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (totalDeath.isSelected()) {
                    System.out.println("totalDeath");
                    parameters.add(2);
                    parameters.forEach(System.out::println);
                }else {
                    parameters.remove(new Integer(2));
                    parameters.forEach(System.out::println);
                }
            }
        });



        newlyDeath.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (newlyDeath.isSelected()) {
                    System.out.println("newlyDeath");
                    parameters.add(3);
                   parameters.forEach(System.out::println);
                }else {
                    parameters.remove(new Integer(3));
                    parameters.forEach(System.out::println);
                }
            }
        });







        listView.setItems(observableList);
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Data>() {
            @Override
            public void changed(ObservableValue<? extends Data> observable, Data oldValue, Data newValue) {
                temp.clear();
                temp.addAll(listView.getSelectionModel().getSelectedItems());
                temp.forEach(data->System.out.println(data.getCountry()));
//                System.out.println(newValue.getCountryName());
//                temp.add(newValue);
            }
        });




//default pieChart
        bu.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                chartPlace.getChildren().clear();
                chartPlace.getChildren().removeAll();
                switch (current){
                    case "PieChart":
                    ObservableList<PieChart.Data> dataObservableList = FXCollections.observableArrayList();
                    for (int i = 0; i < temp.size(); i++) {
                        PieChart.Data datai = new PieChart.Data(temp.get(i).getCountry(), temp.get(i).getCumulative_cases());
                        dataObservableList.add(datai);
                    }
                    PieChart pieChart = setPieChart(dataObservableList);
                    break;

                    case "BarChart":
                        ObservableList<XYChart.Series<String,Number>> obl1=FXCollections.observableArrayList();
                        for (int i=0;i<parameters.size();i++){
                            XYChart.Series<String,Number> series=new XYChart.Series<String,Number>();
                            series.setName(Data.getName(parameters.get(i)));
                            for (int j=0;j<temp.size();j++){
                                series.getData().add(new XYChart.Data<String,Number>(temp.get(j).getCountry(),temp.get(j).getParameter(parameters.get(i))));
                            }
                            obl1.add(series);

                        }
                        BarChart<String,Number> barChart=setBarChart(obl1);
                        break;

                    case "LineChart":

                        ObservableList<XYChart.Series<Number,Number>> obl2 = FXCollections.observableArrayList();
                        for (int i = 0; i < temp.size(); i++) {
                            XYChart.Series<Number,Number> series = new XYChart.Series<Number,Number>();
                            series.setName(temp.get(i).getCountry());
                            series.getData().add(new XYChart.Data<Number,Number>( 0,temp.get(i).getParameter(parameters.get(0))));



                            obl2.add(series);
                        }

                        LineChart<Number,Number> lineChart=setLineChart(obl2);

                    default:
//                        ObservableList<PieChart.Data> dataObservableList2 = FXCollections.observableArrayList();
//                        for (int i = 0; i < temp.size(); i++) {
//                            PieChart.Data datai = new PieChart.Data(temp.get(i).getCountryName(), temp.get(i).getTotalCases());
//                            dataObservableList2.add(datai);
//                        }
//                        PieChart pieChart2 = setPieChart(dataObservableList2);
                        break;
                }
            }
        });



        pieChart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                chartPlace.getChildren().clear();
                //
                chartPlace.getChildren().removeAll();
                ObservableList<PieChart.Data> dataObservableList=FXCollections.observableArrayList();
                for (int i=0;i<temp.size();i++){
                    PieChart.Data datai=new PieChart.Data(temp.get(1).getCountry(),temp.get(i).getParameter(parameters.get(0)));
                    dataObservableList.add(datai);
                }
                PieChart pieChart=setPieChart(dataObservableList);
                current=PieChart;
            }
        });





        barChart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                chartPlace.getChildren().clear();
                //
                chartPlace.getChildren().removeAll();
                ObservableList<XYChart.Series<String,Number>> obl=FXCollections.observableArrayList();
                for (int i=0;i<parameters.size();i++){
                    XYChart.Series<String,Number> series=new XYChart.Series<String,Number>();
                    series.setName(Data.getName(parameters.get(i)));
                    for (int j=0;j<temp.size();j++){
                       series.getData().add(new XYChart.Data<String,Number>(temp.get(j).getCountry(),temp.get(j).getParameter(parameters.get(i))));
                        //但是好像变化的时候没有跟着一起变，所以先不用
//                        VBox v=new VBox();
//                        v.setAlignment(Pos.CENTER);
//                        v.getChildren().add(new Label(String.valueOf(temp.get(j).getParameter(parameters.get(i)))));
//                        datai.setNode(v);
                        //

                    }
                    obl.add(series);

                }
                BarChart<String,Number> barChart=setBarChart(obl);
                current=BarChart;
            }
        });






        lineChart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                chartPlace.getChildren().clear();
                //
                chartPlace.getChildren().removeAll();
                ObservableList<XYChart.Series<Number,Number>> obl = FXCollections.observableArrayList();
                for (int i = 0; i < temp.size(); i++) {
                    XYChart.Series<Number,Number> series = new XYChart.Series<Number,Number>();
                    series.setName(temp.get(i).getCountry());
                    series.getData().add(new XYChart.Data<Number,Number>( 0,temp.get(i).getParameter(parameters.get(0))));



                    obl.add(series);
                }

                LineChart<Number,Number> lineChart=setLineChart(obl);
                current=LineChart;
            }

        });




    }



    public PieChart setPieChart(ObservableList<PieChart.Data> dataObservableList){
        PieChart pieChart=new PieChart();
        pieChart.setData(dataObservableList);
        pieChart.setLegendSide(Side.LEFT);
        pieChart.setLayoutX(200);
        pieChart.setPrefHeight(370);
       pieChart.setLayoutY(0);
        pieChart.setAnimated(true);
        chartPlace.getChildren().add(pieChart);

        pieChart.getData().forEach(data -> {
            Node node=data.getNode();
            Tooltip tooltip=new Tooltip(data.getName()+data.getPieValue());
            tooltip.setFont(new Font(14));
            Tooltip.install(node,tooltip);
            data.pieValueProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                    data.setPieValue((Double) newValue);
                    Node node=data.getNode();
                    Tooltip tooltip=new Tooltip(data.getName()+"-"+data.getPieValue());
                    tooltip.setFont(new Font(17));
                    Tooltip.install(node,tooltip);

                }
            });

        });

        updateButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                temp.get(0).setCumulative_cases(400);
                ObservableList<PieChart.Data> dataObservableList1=FXCollections.observableArrayList();
                for (int i=0;i<temp.size();i++){
                    pieChart.getData().get(i).setPieValue(temp.get(i).getCumulative_cases());
                }
            }
        });
        return pieChart;

    }




    public BarChart<String,Number> setBarChart(ObservableList<XYChart.Series<String,Number>> obl) {
        CategoryAxis x = new CategoryAxis();
        x.setLabel("CountryName");
        //
//        x.setTickLength(5);
        //
        NumberAxis y = new NumberAxis(0, 500, 10);
        y.setAccessibleText("万人");
        BarChart<String, Number> barChart = new BarChart<String, Number>(x, y,obl);


        barChart.setLayoutX(200);
        barChart.setPrefHeight(370);
        barChart.setLayoutY(0);
        barChart.setAnimated(true);
        barChart.setLegendSide(Side.LEFT);


        chartPlace.getChildren().add(barChart);



    barChart.getData().forEach(t -> {t.getData().forEach(data->{
                Node node = data.getNode();
                Tooltip tooltip = new Tooltip(data.getXValue() + "-" +t.getName()+"-" +data.getYValue());
                tooltip.setFont(new Font(14));
                Tooltip.install(node, tooltip);

                data.YValueProperty().addListener(new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                        Node node = data.getNode();
                        Tooltip tooltip = new Tooltip(data.getXValue() + "-" + t.getName()+"-"+data.getYValue());
                        tooltip.setFont(new Font(17));
                        Tooltip.install(node, tooltip);

                    }
                });
            }
            );
    });

            updateButton.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    temp.get(0).setCumulative_cases(400);
                    temp.get(0).setCumulative_deaths(80);
                    ObservableList<XYChart.Series<String, Number>> dataObservableList1 = FXCollections.observableArrayList();
                    for (int i = 0; i < parameters.size(); i++) {
                        for (int j = 0; j < temp.size(); j++) {
                            barChart.getData().get(i).getData().get(j).setYValue(temp.get(j).getParameter(parameters.get(i)));
                        }
                    }


                }
            });


            return barChart;

    }





    public LineChart<Number,Number> setLineChart(ObservableList<XYChart.Series<Number,Number>> obl){
        NumberAxis y=new NumberAxis(0,500,10);
        NumberAxis x=new NumberAxis(0,20,1);

        LineChart<Number,Number> lineChart=new LineChart<>(x,y,obl);

        lineChart.setLayoutX(200);
        lineChart.setPrefHeight(370);
        lineChart.setLayoutY(0);
        lineChart.setAnimated(true);
        lineChart.setPrefWidth(600);
        lineChart.setLegendSide(Side.LEFT);

//        lineChart.setCreateSymbols(false);

        chartPlace.getChildren().add(lineChart);

        lineChart.getData().forEach(t -> {t.getData().forEach(data->{
                    Node node = data.getNode();
                    Tooltip tooltip = new Tooltip(data.getXValue() + "-" +t.getName()+"-" +data.getYValue());
                    tooltip.setFont(new Font(14));
                    Tooltip.install(node, tooltip);

                    data.XValueProperty().addListener(new ChangeListener<Number>() {
                        @Override
                        public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                            Node node = data.getNode();
                            Tooltip tooltip = new Tooltip(data.getXValue() + "-" + t.getName()+"-"+data.getYValue());
                            tooltip.setFont(new Font(17));
                            Tooltip.install(node, tooltip);

                        }
                    });
                }
        );
        });

        DataTask task=new DataTask();
        task.setDelay(Duration.seconds(0));
        task.setPeriod(Duration.seconds(1));
        task.valueProperty().addListener(new ChangeListener<ArrayList<Integer>>() {
            @Override
            public void changed(ObservableValue<? extends ArrayList<Integer>> observable, ArrayList<Integer> oldValue, ArrayList<Integer> newValue) {
                if (newValue!=null){


                    for (int i=0;i<obl.size();i++) {

                        int xIndex=obl.get(i).getData().size();
                        if (xIndex>=18){
                            x.setLowerBound(x.getLowerBound()+1);
                            x.setUpperBound(x.getUpperBound()+1);
                        }
                        if (xIndex==50){
                            obl.forEach(t->t.getData().clear());
                            x.setLowerBound(0);
                            y.setUpperBound(20);
                        }
                        obl.get(i).getData().add(new XYChart.Data<Number, Number>(xIndex, newValue.get(i)));
                    }
                }
            }
        });

        DataTask task2=new DataTask();
        task2.setDelay(Duration.seconds(0));
        task2.setPeriod(Duration.seconds(1));
        task2.valueProperty().addListener(new ChangeListener<ArrayList<Integer>>() {
            @Override
            public void changed(ObservableValue<? extends ArrayList<Integer>> observable, ArrayList<Integer> oldValue, ArrayList<Integer> newValue) {
                int xIndex=obl.get(0).getData().size();
                if (newValue!=null&&xIndex>1){


                    for (int i=0;i<obl.size();i++) {


                        if (x.getLowerBound()>0){
                            x.setLowerBound(x.getLowerBound()-1);
                            x.setUpperBound(x.getUpperBound()-1);
                        }
//                        if (xIndex==50){
//                            obl.forEach(t->t.getData().clear());
//                            x.setLowerBound(0);
//                            y.setUpperBound(20);
//                        }
                        obl.get(i).getData().remove(xIndex-1);
                    }
                }
            }
        });

        updateButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (task2.isRunning()){
                    task2.cancel();
                    task2.reset();
                }
                if (!task.isRunning()) {
                    task.start();
                    lineChart.setAnimated(true);
                }
            }
        });

        stop.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (task.isRunning()) {
                    task.cancel();
                    task.reset();
                }
                if (task2.isRunning()){
                    task2.cancel();
                    task2.reset();
                }
            }
        });
        speed.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                lineChart.setAnimated(false);
                if (task.isRunning()) {
                    task.setPeriod(Duration.seconds(0.3));
                }
                if (task2.isRunning()){
                    task.setPeriod(Duration.seconds(0.3));
                }

            }
        });
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (task.isRunning()){
                    task.cancel();
                    task.reset();
                }
                if (!task2.isRunning()){
                    lineChart.setAnimated(true);
                    task2.start();

                }
            }
        });

//        updateButton.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                temp.get(0).setTotalCases(400);
//                temp.get(0).setTotalDeath(80);
//                ObservableList<XYChart.Series<String, Number>> dataObservableList1 = FXCollections.observableArrayList();
//                for (int i = 0; i < parameters.size(); i++) {
//                    for (int j = 0; j < temp.size(); j++) {
//                        lineChart.getData().get(i).getData().get(j).setXValue(temp.get(j).getParameter(parameters.get(i)));
//                    }
//                }
//
//
//            }
//        });



        return lineChart;
    }





    /*
    随机改变temp的方法
     */

}
