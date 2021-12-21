package qianduan.UI;

import houduan.One.OneData;
import houduan.One.casesReportedDaily;
import houduan.Two.TwoData;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Side;
import javafx.scene.CacheHint;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.Effect;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;
import javafx.util.StringConverter;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Predicate;

public class Pro1Controller implements Initializable {
    String xxx = "";
    @FXML
    ImageView hk, ah, bj, cq, fj, gd, gs, gx, gz, hb, hb2, hlj, hn, hn2, hn3, jl,
            js, jx, ln, nmg, nx, qh, sc, sd, sh, sx, sx1, tj, tw, xj, xz, yn, zj;


    @FXML
    VBox vBox;
    @FXML
    AnchorPane an, chartPlace, labelPlace, buttonPlace, tipPlace;
    @FXML
    MenuBar menuBar;

    @FXML
    AnchorPane an2;

    @FXML
    Circle am;

    @FXML
    ListView<OneData> listView;


    @FXML
    Button bu, dataUpdate, close, save;

    @FXML
    MenuButton chartChoice;

    @FXML
    Menu sorting, dataSource;

    @FXML
    CustomMenuItem source1, source2;

    @FXML
    Menu sort1, sort2, sort3, sort4;

    @FXML
    TextField textField;

    @FXML
    MenuItem on1, on2, on3, on4, down1, down2, down3, down4, pieChart, barChart, lineChart;

    @FXML
    CheckBox totalCases, newlyCases, totalDeath, newlyDeath;

    @FXML
    Hyperlink link1, link2;


    String current = "PieChart";
    String PieChart = "PieChart", BarChart = "BarChart", LineChart = "LineChart";

    static ObservableList<OneData> temp = FXCollections.observableArrayList();
    static ArrayList<Integer> parameters = new ArrayList<>();

    static int hhh = 500;
    static int number = 0;
    static ObservableList<OneData> observableList = FXCollections.observableArrayList();//当前选择的ob
    static boolean isOne;//判断选择的第几个数据源
    static MenuButton start = new MenuButton("2020-01-03");
    static MenuButton end = new MenuButton("2020-01-03");
    static String dayNow;

    static ArrayList<String> b = new ArrayList<>();
    static ArrayList<String> bString = new ArrayList<>();

    static boolean isBar = false;
    static boolean isLine = false;
    static boolean isFirstBar = true;
    static boolean isFirstLine = true;

    static ObservableList<Node> paneNode;

    @FXML
    Button back = new Button("倒带");
    @FXML
    Button updateButton = new Button("更新");
    @FXML
    Button stop = new Button("暂停");
    @FXML
    Button speed = new Button("快进");


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Label label1 = new Label("一定范围日期内的趋势");
        label1.setLayoutX(900);
        label1.setLayoutY(11);

        start = new MenuButton("区间起点");
        start.setLayoutX(895.0);
        start.setLayoutY(2);

        end = new MenuButton("区间终点");
        end.setLayoutX(895.0);
        end.setLayoutY(65);

//        Button back=new Button("倒带");
        back.setLayoutX(733);
        back.setLayoutY(7);
//        Button updateButton=new Button("更新");
        updateButton.setLayoutX(527);
        updateButton.setLayoutY(7);
//        Button stop=new Button("暂停");
        stop.setLayoutX(594);
        stop.setLayoutY(7);
//        Button speed=new Button("快进");
        speed.setLayoutX(662);
        speed.setLayoutY(7);
//                                <Button fx:id="back" layoutX="733.0" layoutY="7.0" mnemonicParsing="false" text="倒带" />
//                        <Button fx:id="updateButton" layoutX="527.0" layoutY="7.0" mnemonicParsing="false" text="更新" />
//                         <Button fx:id="stop" layoutX="594.0" layoutY="7.0" mnemonicParsing="false" text="暂停" />
//                         <Button fx:id="speed" layoutX="662.0" layoutY="7.0" mnemonicParsing="false" text="快进" />
        MenuButton dayChoice = new MenuButton("总死亡病例（日期选择）");

        //重置焦点 不确定
        an.requestFocus();

//加入第一组国际数据
        ArrayList<OneData> dataArrayList1 = new ArrayList<>();
        casesReportedDaily casesReportedDaily1 = new casesReportedDaily();
        for (ArrayList<OneData> arrayList : casesReportedDaily1.Run().values()) {
            dataArrayList1.add(arrayList.get(arrayList.size() - 1));
        }
        OneData.setData(dataArrayList1);
        ObservableList<OneData> observableList1 = FXCollections.observableArrayList();
        observableList1.addAll(OneData.getData());







        /*
        添加label
         */
        dayNow = casesReportedDaily1.RunDate().get("China").get(casesReportedDaily1.RunDate().get("China").size() - 1);
        Label label = new Label(
                String.format("%-39s%-32s%-32s%-32s%-32s%s","CountryName","TotalCases","NewlyCases","TotalDeath","NewlyDeath", "NewlyDate:") + dayNow);

        labelPlace.getChildren().add(label);


//        Label label2 = new Label();


        /*
        设置source1，source2的监听器 改变label和listView
         */
        source1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                labelPlace.getChildren().remove(1);
                dayNow = casesReportedDaily1.RunDate().get("China").get(casesReportedDaily1.RunDate().get("China").size() - 1);
                Label label = new Label(        String.format("%-39s%-32s%-32s%-32s%-32s%s","CountryName","TotalCases","NewlyCases","TotalDeath","NewlyDeath", "NewlyDate:") + dayNow);
                labelPlace.getChildren().add(label);
//                ArrayList<OneData> dataArrayList1 = new ArrayList<>();
//                casesReportedDaily casesReportedDaily1 = new casesReportedDaily();
//                for (ArrayList<OneData> arrayList : casesReportedDaily1.Run().values()) {
//                    dataArrayList1.add(arrayList.get(arrayList.size() - 1));
//                }
//                OneData.setData(dataArrayList1);
//                ObservableList<OneData> observableList1 = FXCollections.observableArrayList();
//                observableList1.addAll(OneData.getData());
                observableList = observableList1;
                listView.setItems(observableList);
                isOne = true;

            }
        });
        source2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                isOne = false;

                an2.setPrefHeight(650);
                an2.setPrefWidth(1200);
                an2.setStyle("-fx-background-image: url(" + "qianduan/pic/bg2.png" + "); " +
                        "-fx-background-position: center center; " +
                        "-fx-background-repeat: stretch;" +
                        "-fx-background-color:  transparent;");
                an.setStyle("-fx-background-image: url(" + "qianduan/pic/bg2.png" + "); " +
                        "-fx-background-position: center center; " +
                        "-fx-background-repeat: stretch;" +
                        "-fx-background-color:  transparent;");

                paneNode = FXCollections.observableArrayList(an.getChildren());

                an.getChildren().clear();
                an.getChildren().add(an2);
                an2.requestFocus();

                  /*
        给close装监听器
         */
                close.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        an.getChildren().remove(an2);
                        an.getChildren().setAll(paneNode);
                    }
                });


            }
        });


        HashMap<String, TwoData> map = houduan.Two.getChinaDataFromFile.getDataInChina();
//        Map<String, int[]> map = new HashMap<>();



         /*
        添加imageview的监听器
         */
        Effect cur = gd.getEffect();


        Label label11 = new Label(String.format("城市：%s\n当前病例：%d\n总病例：%d\n总治愈病例：%d\n总死亡病例：%d\n",
                "广东", map.get("广东").getNewlyCase(), map.get("广东").getTotalCase(), map.get("广东").getTotalCured(), map.get("广东").getTotalDeath()));

        label11.setFont(new Font(18));
        gd.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().add(label11);
                ColorAdjust blackout = new ColorAdjust();
                blackout.setBrightness(-1.0);

                gd.setEffect(blackout);
                gd.setCache(true);
                gd.setCacheHint(CacheHint.SPEED);

            }
        });
        gd.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().remove(label11);
                gd.setEffect(cur);
                gd.setCache(true);
                gd.setCacheHint(CacheHint.SPEED);
            }
        });


        Label label12 = new Label(String.format("城市：%s\n当前病例：%d\n总病例：%d\n总治愈病例：%d\n总死亡病例：%d\n",
                "香港", map.get("香港").getNewlyCase(), map.get("香港").getTotalCase(), map.get("香港").getTotalCured(), map.get("香港").getTotalDeath()));

        label12.setFont(new Font(18));
        hk.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().add(label12);
                ColorAdjust blackout = new ColorAdjust();
                blackout.setBrightness(-1.0);

                hk.setEffect(blackout);
                hk.setCache(true);
                hk.setCacheHint(CacheHint.SPEED);

            }
        });
        hk.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().remove(label12);
                hk.setEffect(cur);
                hk.setCache(true);
                hk.setCacheHint(CacheHint.SPEED);
            }
        });

        Label label13 = new Label(String.format("城市：%s\n当前病例：%d\n总病例：%d\n总治愈病例：%d\n总死亡病例：%d\n",
                "安徽", map.get("安徽").getNewlyCase(), map.get("安徽").getTotalCase(), map.get("安徽").getTotalCured(), map.get("安徽").getTotalDeath()));

        label13.setFont(new Font(18));
        ah.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().add(label13);
                ColorAdjust blackout = new ColorAdjust();
                blackout.setBrightness(-1.0);

                ah.setEffect(blackout);
                ah.setCache(true);
                ah.setCacheHint(CacheHint.SPEED);

            }
        });
        ah.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().remove(label13);
                ah.setEffect(cur);
                ah.setCache(true);
                ah.setCacheHint(CacheHint.SPEED);
            }
        });

        Label label14 = new Label(String.format("城市：%s\n当前病例：%d\n总病例：%d\n总治愈病例：%d\n总死亡病例：%d\n",
                "北京", map.get("北京").getNewlyCase(), map.get("北京").getTotalCase(), map.get("北京").getTotalCured(), map.get("北京").getTotalDeath()));

        label14.setFont(new Font(18));
        bj.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().add(label14);
                ColorAdjust blackout = new ColorAdjust();
                blackout.setBrightness(-1.0);

                bj.setEffect(blackout);
                bj.setCache(true);
                bj.setCacheHint(CacheHint.SPEED);

            }
        });
        bj.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().remove(label14);
                bj.setEffect(cur);
                bj.setCache(true);
                bj.setCacheHint(CacheHint.SPEED);
            }
        });


        Label label15 = new Label(String.format("城市：%s\n当前病例：%d\n总病例：%d\n总治愈病例：%d\n总死亡病例：%d\n",
                "重庆", map.get("重庆").getNewlyCase(), map.get("重庆").getTotalCase(), map.get("重庆").getTotalCured(), map.get("重庆").getTotalDeath()));

        label15.setFont(new Font(18));
        cq.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().add(label15);

                ColorAdjust blackout = new ColorAdjust();
                blackout.setBrightness(-1.0);

                cq.setEffect(blackout);
                cq.setCache(true);
                cq.setCacheHint(CacheHint.SPEED);

            }
        });
        cq.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().add(label15);

                ColorAdjust blackout = new ColorAdjust();
                blackout.setBrightness(-1.0);

                cq.setEffect(blackout);
                cq.setCache(true);
                cq.setCacheHint(CacheHint.SPEED);
            }
        });


        cq.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().remove(label15);
                cq.setEffect(cur);
                cq.setCache(true);
                cq.setCacheHint(CacheHint.SPEED);
            }
        });


        Label label16 = new Label(String.format("城市：%s\n当前病例：%d\n总病例：%d\n总治愈病例：%d\n总死亡病例：%d\n",
                "福建", map.get("福建").getNewlyCase(), map.get("福建").getTotalCase(), map.get("福建").getTotalCured(), map.get("福建").getTotalDeath()));

        label16.setFont(new Font(18));
        fj.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().add(label16);

                ColorAdjust blackout = new ColorAdjust();
                blackout.setBrightness(-1.0);

                fj.setEffect(blackout);
                fj.setCache(true);
                fj.setCacheHint(CacheHint.SPEED);

            }
        });
        fj.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().remove(label16);
                fj.setEffect(cur);
                fj.setCache(true);
                fj.setCacheHint(CacheHint.SPEED);
            }
        });


        Label label17 = new Label(String.format("城市：%s\n当前病例：%d\n总病例：%d\n总治愈病例：%d\n总死亡病例：%d\n",
                "甘肃", map.get("甘肃").getNewlyCase(), map.get("甘肃").getTotalCase(), map.get("甘肃").getTotalCured(), map.get("甘肃").getTotalDeath()));

        label17.setFont(new Font(18));
        gs.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().add(label17);
                ColorAdjust blackout = new ColorAdjust();
                blackout.setBrightness(-1.0);

                gs.setEffect(blackout);
                gs.setCache(true);
                gs.setCacheHint(CacheHint.SPEED);

            }
        });
        gs.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().remove(label17);
                gs.setEffect(cur);
                gs.setCache(true);
                gs.setCacheHint(CacheHint.SPEED);
            }
        });


        Label label18 = new Label(String.format("城市：%s\n当前病例：%d\n总病例：%d\n总治愈病例：%d\n总死亡病例：%d\n",
                "广西", map.get("广西").getNewlyCase(), map.get("广西").getTotalCase(), map.get("广西").getTotalCured(), map.get("广西").getTotalDeath()));

        label18.setFont(new Font(18));
        gx.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().add(label18);

                ColorAdjust blackout = new ColorAdjust();
                blackout.setBrightness(-1.0);

                gx.setEffect(blackout);
                gx.setCache(true);
                gx.setCacheHint(CacheHint.SPEED);

            }
        });
        gx.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().remove(label18);
                gx.setEffect(cur);
                gx.setCache(true);
                gx.setCacheHint(CacheHint.SPEED);
            }
        });


        Label label19 = new Label(String.format("城市：%s\n当前病例：%d\n总病例：%d\n总治愈病例：%d\n总死亡病例：%d\n",
                "贵州", map.get("贵州").getNewlyCase(), map.get("贵州").getTotalCase(), map.get("贵州").getTotalCured(), map.get("贵州").getTotalDeath()));

        label19.setFont(new Font(18));
        gz.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().add(label19);

                ColorAdjust blackout = new ColorAdjust();
                blackout.setBrightness(-1.0);

                gz.setEffect(blackout);
                gz.setCache(true);
                gz.setCacheHint(CacheHint.SPEED);

            }
        });
        gz.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().remove(label19);
                gz.setEffect(cur);
                gz.setCache(true);
                gz.setCacheHint(CacheHint.SPEED);
            }
        });


        Label label21 = new Label(String.format("城市：%s\n当前病例：%d\n总病例：%d\n总治愈病例：%d\n总死亡病例：%d\n",
                "河北", map.get("河北").getNewlyCase(), map.get("河北").getTotalCase(), map.get("河北").getTotalCured(), map.get("河北").getTotalDeath()));

        label21.setFont(new Font(18));
        hb.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().add(label21);

                ColorAdjust blackout = new ColorAdjust();
                blackout.setBrightness(-1.0);

                hb.setEffect(blackout);
                hb.setCache(true);
                hb.setCacheHint(CacheHint.SPEED);

            }
        });
        hb.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().remove(label21);
                hb.setEffect(cur);
                hb.setCache(true);
                hb.setCacheHint(CacheHint.SPEED);
            }
        });


        Label label22 = new Label(String.format("城市：%s\n当前病例：%d\n总病例：%d\n总治愈病例：%d\n总死亡病例：%d\n",
                "湖北", map.get("湖北").getNewlyCase(), map.get("湖北").getTotalCase(), map.get("湖北").getTotalCured(), map.get("湖北").getTotalDeath()));

        label22.setFont(new Font(18));
        hb2.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().add(label22);

                ColorAdjust blackout = new ColorAdjust();
                blackout.setBrightness(-1.0);

                hb2.setEffect(blackout);
                hb2.setCache(true);
                hb2.setCacheHint(CacheHint.SPEED);

            }
        });
        hb2.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().remove(label22);
                hb2.setEffect(cur);
                hb2.setCache(true);
                hb2.setCacheHint(CacheHint.SPEED);
            }
        });


        Label label23 = new Label(String.format("城市：%s\n当前病例：%d\n总病例：%d\n总治愈病例：%d\n总死亡病例：%d\n",
                "黑龙江", map.get("黑龙江").getNewlyCase(), map.get("黑龙江").getTotalCase(), map.get("黑龙江").getTotalCured(), map.get("黑龙江").getTotalDeath()));

        label23.setFont(new Font(18));
        hlj.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().add(label23);

                ColorAdjust blackout = new ColorAdjust();
                blackout.setBrightness(-1.0);

                hlj.setEffect(blackout);
                hlj.setCache(true);
                hlj.setCacheHint(CacheHint.SPEED);

            }
        });
        hlj.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().remove(label23);
                hlj.setEffect(cur);
                hlj.setCache(true);
                hlj.setCacheHint(CacheHint.SPEED);
            }
        });


        Label label24 = new Label(String.format("城市：%s\n当前病例：%d\n总病例：%d\n总治愈病例：%d\n总死亡病例：%d\n",
                "河南", map.get("河南").getNewlyCase(), map.get("河南").getTotalCase(), map.get("河南").getTotalCured(), map.get("河南").getTotalDeath()));

        label24.setFont(new Font(18));
        hn.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().add(label24);

                ColorAdjust blackout = new ColorAdjust();
                blackout.setBrightness(-1.0);

                hn.setEffect(blackout);
                hn.setCache(true);
                hn.setCacheHint(CacheHint.SPEED);

            }
        });
        hn.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().remove(label24);
                hn.setEffect(cur);
                hn.setCache(true);
                hn.setCacheHint(CacheHint.SPEED);
            }
        });


        Label label25 = new Label(String.format("城市：%s\n当前病例：%d\n总病例：%d\n总治愈病例：%d\n总死亡病例：%d\n",
                "湖南", map.get("湖南").getNewlyCase(), map.get("湖南").getTotalCase(), map.get("湖南").getTotalCured(), map.get("湖南").getTotalDeath()));

        label25.setFont(new Font(18));
        hn2.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().add(label25);

                ColorAdjust blackout = new ColorAdjust();
                blackout.setBrightness(-1.0);

                hn2.setEffect(blackout);
                hn2.setCache(true);
                hn2.setCacheHint(CacheHint.SPEED);

            }
        });
        hn2.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().remove(label25);
                hn2.setEffect(cur);
                hn2.setCache(true);
                hn2.setCacheHint(CacheHint.SPEED);
            }
        });


        Label label26 = new Label(String.format("城市：%s\n当前病例：%d\n总病例：%d\n总治愈病例：%d\n总死亡病例：%d\n",
                "海南", map.get("海南").getNewlyCase(), map.get("海南").getTotalCase(), map.get("海南").getTotalCured(), map.get("海南").getTotalDeath()));

        label26.setFont(new Font(18));
        hn3.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().add(label26);

                ColorAdjust blackout = new ColorAdjust();
                blackout.setBrightness(-1.0);

                hn3.setEffect(blackout);
                hn3.setCache(true);
                hn3.setCacheHint(CacheHint.SPEED);

            }
        });
        hn3.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().remove(label26);
                hn3.setEffect(cur);
                hn3.setCache(true);
                hn3.setCacheHint(CacheHint.SPEED);
            }
        });


        Label label27 = new Label(String.format("城市：%s\n当前病例：%d\n总病例：%d\n总治愈病例：%d\n总死亡病例：%d\n",
                "吉林", map.get("吉林").getNewlyCase(), map.get("吉林").getTotalCase(), map.get("吉林").getTotalCured(), map.get("吉林").getTotalDeath()));

        label27.setFont(new Font(18));
        jl.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().add(label27);

                ColorAdjust blackout = new ColorAdjust();
                blackout.setBrightness(-1.0);

                jl.setEffect(blackout);
                jl.setCache(true);
                jl.setCacheHint(CacheHint.SPEED);

            }
        });
        jl.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().remove(label27);
                jl.setEffect(cur);
                jl.setCache(true);
                jl.setCacheHint(CacheHint.SPEED);
            }
        });


        Label label28 = new Label(String.format("城市：%s\n当前病例：%d\n总病例：%d\n总治愈病例：%d\n总死亡病例：%d\n",
                "江苏", map.get("江苏").getNewlyCase(), map.get("江苏").getTotalCase(), map.get("江苏").getTotalCured(), map.get("江苏").getTotalDeath()));

        label28.setFont(new Font(18));
        js.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().add(label28);

                ColorAdjust blackout = new ColorAdjust();
                blackout.setBrightness(-1.0);

                js.setEffect(blackout);
                js.setCache(true);
                js.setCacheHint(CacheHint.SPEED);

            }
        });
        js.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().remove(label28);
                js.setEffect(cur);
                js.setCache(true);
                js.setCacheHint(CacheHint.SPEED);
            }
        });


        Label label29 = new Label(String.format("城市：%s\n当前病例：%d\n总病例：%d\n总治愈病例：%d\n总死亡病例：%d\n",
                "江西", map.get("江西").getNewlyCase(), map.get("江西").getTotalCase(), map.get("江西").getTotalCured(), map.get("江西").getTotalDeath()));

        label29.setFont(new Font(18));
        jx.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().add(label29);

                ColorAdjust blackout = new ColorAdjust();
                blackout.setBrightness(-1.0);

                jx.setEffect(blackout);
                jx.setCache(true);
                jx.setCacheHint(CacheHint.SPEED);

            }
        });
        jx.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().remove(label29);
                jx.setEffect(cur);
                jx.setCache(true);
                jx.setCacheHint(CacheHint.SPEED);
            }
        });


        Label label31 = new Label(String.format("城市：%s\n当前病例：%d\n总病例：%d\n总治愈病例：%d\n总死亡病例：%d\n",
                "辽宁", map.get("辽宁").getNewlyCase(), map.get("辽宁").getTotalCase(), map.get("辽宁").getTotalCured(), map.get("辽宁").getTotalDeath()));

        label31.setFont(new Font(18));
        ln.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().add(label31);

                ColorAdjust blackout = new ColorAdjust();
                blackout.setBrightness(-1.0);

                ln.setEffect(blackout);
                ln.setCache(true);
                ln.setCacheHint(CacheHint.SPEED);

            }
        });
        ln.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().remove(label31);
                ln.setEffect(cur);
                ln.setCache(true);
                ln.setCacheHint(CacheHint.SPEED);
            }
        });


        Label label32 = new Label(String.format("城市：%s\n当前病例：%d\n总病例：%d\n总治愈病例：%d\n总死亡病例：%d\n",
                "内蒙古", map.get("内蒙古").getNewlyCase(), map.get("内蒙古").getTotalCase(), map.get("内蒙古").getTotalCured(), map.get("内蒙古").getTotalDeath()));

        label32.setFont(new Font(18));
        nmg.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().add(label32);

                ColorAdjust blackout = new ColorAdjust();
                blackout.setBrightness(-1.0);

                nmg.setEffect(blackout);
                nmg.setCache(true);
                nmg.setCacheHint(CacheHint.SPEED);

            }
        });
        nmg.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().remove(label32);
                nmg.setEffect(cur);
                nmg.setCache(true);
                nmg.setCacheHint(CacheHint.SPEED);
            }
        });


        Label label33 = new Label(String.format("城市：%s\n当前病例：%d\n总病例：%d\n总治愈病例：%d\n总死亡病例：%d\n",
                "宁夏", map.get("宁夏").getNewlyCase(), map.get("宁夏").getTotalCase(), map.get("宁夏").getTotalCured(), map.get("宁夏").getTotalDeath()));

        label33.setFont(new Font(18));
        nx.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().add(label33);

                ColorAdjust blackout = new ColorAdjust();
                blackout.setBrightness(-1.0);

                nx.setEffect(blackout);
                nx.setCache(true);
                nx.setCacheHint(CacheHint.SPEED);

            }
        });
        nx.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().remove(label33);
                nx.setEffect(cur);
                nx.setCache(true);
                nx.setCacheHint(CacheHint.SPEED);
            }
        });


        Label label34 = new Label(String.format("城市：%s\n当前病例：%d\n总病例：%d\n总治愈病例：%d\n总死亡病例：%d\n",
                "青海", map.get("青海").getNewlyCase(), map.get("青海").getTotalCase(), map.get("青海").getTotalCured(), map.get("青海").getTotalDeath()));

        label34.setFont(new Font(18));
        qh.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().add(label34);

                ColorAdjust blackout = new ColorAdjust();
                blackout.setBrightness(-1.0);

                qh.setEffect(blackout);
                qh.setCache(true);
                qh.setCacheHint(CacheHint.SPEED);

            }
        });
        qh.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().remove(label34);
                qh.setEffect(cur);
                qh.setCache(true);
                qh.setCacheHint(CacheHint.SPEED);
            }
        });


        Label label35 = new Label(String.format("城市：%s\n当前病例：%d\n总病例：%d\n总治愈病例：%d\n总死亡病例：%d\n",
                "四川", map.get("四川").getNewlyCase(), map.get("四川").getTotalCase(), map.get("四川").getTotalCured(), map.get("四川").getTotalDeath()));

        label35.setFont(new Font(18));
        sc.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().add(label35);

                ColorAdjust blackout = new ColorAdjust();
                blackout.setBrightness(-1.0);

                sc.setEffect(blackout);
                sc.setCache(true);
                sc.setCacheHint(CacheHint.SPEED);

            }
        });
        sc.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().remove(label35);
                sc.setEffect(cur);
                sc.setCache(true);
                sc.setCacheHint(CacheHint.SPEED);
            }
        });


        Label label36 = new Label(String.format("城市：%s\n当前病例：%d\n总病例：%d\n总治愈病例：%d\n总死亡病例：%d\n",
                "上海", map.get("上海").getNewlyCase(), map.get("上海").getTotalCase(), map.get("上海").getTotalCured(), map.get("上海").getTotalDeath()));

        label36.setFont(new Font(18));
        sh.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().add(label36);

                ColorAdjust blackout = new ColorAdjust();
                blackout.setBrightness(-1.0);

                sh.setEffect(blackout);
                sh.setCache(true);
                sh.setCacheHint(CacheHint.SPEED);

            }
        });
        sh.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().remove(label36);
                sh.setEffect(cur);
                sh.setCache(true);
                sh.setCacheHint(CacheHint.SPEED);
            }
        });


        Label label37 = new Label(String.format("城市：%s\n当前病例：%d\n总病例：%d\n总治愈病例：%d\n总死亡病例：%d\n",
                "陕西", map.get("陕西").getNewlyCase(), map.get("陕西").getTotalCase(), map.get("陕西").getTotalCured(), map.get("陕西").getTotalDeath()));

        label37.setFont(new Font(18));
        sx.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().add(label37);

                ColorAdjust blackout = new ColorAdjust();
                blackout.setBrightness(-1.0);

                sx.setEffect(blackout);
                sx.setCache(true);
                sx.setCacheHint(CacheHint.SPEED);

            }
        });
        sx.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().remove(label37);
                sx.setEffect(cur);
                sx.setCache(true);
                sx.setCacheHint(CacheHint.SPEED);
            }
        });


        Label label38 = new Label(String.format("城市：%s\n当前病例：%d\n总病例：%d\n总治愈病例：%d\n总死亡病例：%d\n",
                "山西", map.get("山西").getNewlyCase(), map.get("山西").getTotalCase(), map.get("山西").getTotalCured(), map.get("山西").getTotalDeath()));

        label38.setFont(new Font(18));
        sx1.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().add(label38);

                ColorAdjust blackout = new ColorAdjust();
                blackout.setBrightness(-1.0);

                sx1.setEffect(blackout);
                sx1.setCache(true);
                sx1.setCacheHint(CacheHint.SPEED);

            }
        });
        sx1.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().remove(label38);
                sx1.setEffect(cur);
                sx1.setCache(true);
                sx1.setCacheHint(CacheHint.SPEED);
            }
        });


        Label label39 = new Label(String.format("城市：%s\n当前病例：%d\n总病例：%d\n总治愈病例：%d\n总死亡病例：%d\n",
                "天津", map.get("天津").getNewlyCase(), map.get("天津").getTotalCase(), map.get("天津").getTotalCured(), map.get("天津").getTotalDeath()));

        label39.setFont(new Font(18));
        tj.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().add(label39);

                ColorAdjust blackout = new ColorAdjust();
                blackout.setBrightness(-1.0);

                tj.setEffect(blackout);
                tj.setCache(true);
                tj.setCacheHint(CacheHint.SPEED);

            }
        });
        tj.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().remove(label39);
                tj.setEffect(cur);
                tj.setCache(true);
                tj.setCacheHint(CacheHint.SPEED);
            }
        });


        Label label41 = new Label(String.format("城市：%s\n当前病例：%d\n总病例：%d\n总治愈病例：%d\n总死亡病例：%d\n",
                "台湾", map.get("台湾").getNewlyCase(), map.get("台湾").getTotalCase(), map.get("台湾").getTotalCured(), map.get("台湾").getTotalDeath()));

        label41.setFont(new Font(18));
        tw.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().add(label41);

                ColorAdjust blackout = new ColorAdjust();
                blackout.setBrightness(-1.0);

                tw.setEffect(blackout);
                tw.setCache(true);
                tw.setCacheHint(CacheHint.SPEED);

            }
        });
        tw.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().remove(label41);
                tw.setEffect(cur);
                tw.setCache(true);
                tw.setCacheHint(CacheHint.SPEED);
            }
        });


        Label label42 = new Label(String.format("城市：%s\n当前病例：%d\n总病例：%d\n总治愈病例：%d\n总死亡病例：%d\n",
                "新疆", map.get("新疆").getNewlyCase(), map.get("新疆").getTotalCase(), map.get("新疆").getTotalCured(), map.get("新疆").getTotalDeath()));

        label42.setFont(new Font(18));
        xj.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().add(label42);

                ColorAdjust blackout = new ColorAdjust();
                blackout.setBrightness(-1.0);

                xj.setEffect(blackout);
                xj.setCache(true);
                xj.setCacheHint(CacheHint.SPEED);

            }
        });
        xj.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().remove(label42);
                xj.setEffect(cur);
                xj.setCache(true);
                xj.setCacheHint(CacheHint.SPEED);
            }
        });


        Label label43 = new Label(String.format("城市：%s\n当前病例：%d\n总病例：%d\n总治愈病例：%d\n总死亡病例：%d\n",
                "西藏", map.get("西藏").getNewlyCase(), map.get("西藏").getTotalCase(), map.get("西藏").getTotalCured(), map.get("西藏").getTotalDeath()));

        label43.setFont(new Font(18));
        xz.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().add(label43);

                ColorAdjust blackout = new ColorAdjust();
                blackout.setBrightness(-1.0);

                xz.setEffect(blackout);
                xz.setCache(true);
                xz.setCacheHint(CacheHint.SPEED);

            }
        });
        xz.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().remove(label43);
                xz.setEffect(cur);
                xz.setCache(true);
                xz.setCacheHint(CacheHint.SPEED);
            }
        });


        Label label44 = new Label(String.format("城市：%s\n当前病例：%d\n总病例：%d\n总治愈病例：%d\n总死亡病例：%d\n",
                "云南", map.get("云南").getNewlyCase(), map.get("云南").getTotalCase(), map.get("云南").getTotalCured(), map.get("云南").getTotalDeath()));

        label44.setFont(new Font(18));
        yn.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().add(label44);

                ColorAdjust blackout = new ColorAdjust();
                blackout.setBrightness(-1.0);

                yn.setEffect(blackout);
                yn.setCache(true);
                yn.setCacheHint(CacheHint.SPEED);

            }
        });
        yn.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().remove(label44);
                yn.setEffect(cur);
                yn.setCache(true);
                yn.setCacheHint(CacheHint.SPEED);
            }
        });


        Label label45 = new Label(String.format("城市：%s\n当前病例：%d\n总病例：%d\n总治愈病例：%d\n总死亡病例：%d\n",
                "浙江", map.get("浙江").getNewlyCase(), map.get("浙江").getTotalCase(), map.get("浙江").getTotalCured(), map.get("浙江").getTotalDeath()));

        label45.setFont(new Font(18));
        zj.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().add(label45);

                ColorAdjust blackout = new ColorAdjust();
                blackout.setBrightness(-1.0);

                zj.setEffect(blackout);
                zj.setCache(true);
                zj.setCacheHint(CacheHint.SPEED);

            }
        });
        zj.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().remove(label45);
                zj.setEffect(cur);
                zj.setCache(true);
                zj.setCacheHint(CacheHint.SPEED);
            }
        });


        Label label46 = new Label(String.format("城市：%s\n当前病例：%d\n总病例：%d\n总治愈病例：%d\n总死亡病例：%d\n",
                "澳门", map.get("澳门").getNewlyCase(), map.get("澳门").getTotalCase(), map.get("澳门").getTotalCured(), map.get("澳门").getTotalDeath()));

        label46.setFont(new Font(18));
        am.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().add(label46);

                ColorAdjust blackout = new ColorAdjust();
                blackout.setBrightness(-1.0);

                am.setEffect(blackout);
                am.setCache(true);
                am.setCacheHint(CacheHint.SPEED);

            }
        });
        am.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().remove(label46);
                am.setEffect(cur);
                am.setCache(true);
                am.setCacheHint(CacheHint.SPEED);
            }
        });

        Label label47 = new Label(String.format("城市：%s\n当前病例：%d\n总病例：%d\n总治愈病例：%d\n总死亡病例：%d\n",
                "山东", map.get("山东").getNewlyCase(), map.get("山东").getTotalCase(), map.get("山东").getTotalCured(), map.get("山东").getTotalDeath()));

        label47.setFont(new Font(18));
        sd.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().add(label47);

                ColorAdjust blackout = new ColorAdjust();
                blackout.setBrightness(-1.0);

                sd.setEffect(blackout);
                sd.setCache(true);
                sd.setCacheHint(CacheHint.SPEED);

            }
        });
        sd.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                tipPlace.getChildren().remove(label47);
                sd.setEffect(cur);
                sd.setCache(true);
                sd.setCacheHint(CacheHint.SPEED);
            }
        });











        /*
        设置listview版面
         */
        listView.setCellFactory(TextFieldListCell.forListView(new StringConverter<OneData>() {
            @Override
            public String toString(OneData object) {
//                String s = "\t" + object.getCountry() + "\t\t\t" + object.getCumulative_cases() + "\t\t\t" + object.getNew_cases() +
//                        "\t\t\t" + object.getCumulative_deaths() + "\t\t\t" + object.getNew_deaths();
                String s = String.format("%-40s%-40s%-40s%-40s%-40s", object.getCountry(), object.getCumulative_cases(), object.getNew_cases(),
                        object.getCumulative_deaths(), object.getNew_deaths());
                return s;
            }

            @Override
            public OneData fromString(String string) {
                return null;
            }
        }));

        /*
        设置数据更新button
         */
        dataUpdate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
//                AnchorPane an4=new AnchorPane();
//                Label tips=new Label("Please wait");
//                Label tips2=new Label("OK!");

                try {





                    houduan.One.getFileAboradOnLine.upDate();
                    houduan.Two.WebGetChinaFile.update2();

                    Label tips=new Label("Please wait");
                    tips.setFont(new Font(15));

                    chartPlace.getChildren().add(tips);
                    chartPlace.getChildren().remove(tips);
                    Label tips2=new Label("OK!");
                    chartPlace.getChildren().add(tips2);
//                    Thread.sleep(2000);
                    chartPlace.getChildren().remove(tips2);

                } catch (Exception e) {
                    e.printStackTrace();
                }
                ArrayList<OneData> dataArrayList11 = new ArrayList<>();
                casesReportedDaily casesReportedDaily11 = new casesReportedDaily();
                for (ArrayList<OneData> arrayList : casesReportedDaily11.Run().values()) {
                    dataArrayList11.add(arrayList.get(arrayList.size() - 1));
                }

                OneData.setData(dataArrayList11);
                ObservableList<OneData> observableList11 = FXCollections.observableArrayList();
                observableList11.addAll(dataArrayList11);
                observableList = observableList11;

                listView.setItems(observableList);
                Label label = new Label(String.format("%-39s%-32s%-32s%-32s%-32s%s","CountryName","TotalCases","NewlyCases","TotalDeath","NewlyDeath", "NewlyDate:") + dayNow);
                labelPlace.getChildren().add(label);

            }
        });


        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                FilteredList<OneData> fin = observableList.filtered(new Predicate<OneData>() {
                    @Override
                    public boolean test(OneData data) {
                        if (data.getCountry().toLowerCase(Locale.ROOT).contains(newValue.toLowerCase(Locale.ROOT))) {//全转换为小写看是否包含
                            return true;
                        } else {
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
                SortedList<OneData> fin = observableList.sorted(new Comparator<OneData>() {
                    @Override
                    public int compare(OneData o1, OneData o2) {

                        return o1.getCumulative_cases() - o2.getCumulative_cases();
                    }
                });
                listView.setItems(fin);
            }
        });
        down1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SortedList<OneData> fin = observableList.sorted(new Comparator<OneData>() {
                    @Override
                    public int compare(OneData o1, OneData o2) {

                        return o2.getCumulative_cases() - o1.getCumulative_cases();
                    }
                });
                listView.setItems(fin);
            }
        });

        on2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SortedList<OneData> fin = observableList.sorted(new Comparator<OneData>() {
                    @Override
                    public int compare(OneData o1, OneData o2) {

                        return o1.getNew_cases() - o2.getNew_cases();
                    }
                });
                listView.setItems(fin);
            }
        });
        down2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SortedList<OneData> fin = observableList.sorted(new Comparator<OneData>() {
                    @Override
                    public int compare(OneData o1, OneData o2) {

                        return o2.getNew_cases() - o1.getNew_cases();
                    }
                });
                listView.setItems(fin);
            }
        });
        on3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SortedList<OneData> fin = observableList.sorted(new Comparator<OneData>() {
                    @Override
                    public int compare(OneData o1, OneData o2) {

                        return o1.getCumulative_deaths() - o2.getCumulative_deaths();
                    }
                });
                listView.setItems(fin);
            }
        });
        down3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SortedList<OneData> fin = observableList.sorted(new Comparator<OneData>() {
                    @Override
                    public int compare(OneData o1, OneData o2) {

                        return o2.getCumulative_deaths() - o1.getCumulative_deaths();
                    }
                });
                listView.setItems(fin);
            }
        });
        on4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SortedList<OneData> fin = observableList.sorted(new Comparator<OneData>() {
                    @Override
                    public int compare(OneData o1, OneData o2) {

                        return o1.getNew_deaths() - o2.getNew_deaths();
                    }
                });
                listView.setItems(fin);
            }
        });
        down4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SortedList<OneData> fin = observableList.sorted(new Comparator<OneData>() {
                    @Override
                    public int compare(OneData o1, OneData o2) {

                        return o2.getNew_deaths() - o1.getNew_deaths();
                    }
                });
                listView.setItems(fin);
            }
        });
        on1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                SortedList<OneData> fin = observableList.sorted(new Comparator<OneData>() {
                    @Override
                    public int compare(OneData o1, OneData o2) {

                        return o1.getCumulative_cases() - o2.getCumulative_cases();
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
                } else {
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
                } else {
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
                } else {
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
                } else {
                    parameters.remove(new Integer(3));
                    parameters.forEach(System.out::println);
                }
            }
        });


//        listView.setItems(observableList);
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<OneData>() {
            @Override
            public void changed(ObservableValue<? extends OneData> observable, OneData oldValue, OneData newValue) {
                temp.clear();
                temp.addAll(listView.getSelectionModel().getSelectedItems());
//                temp.forEach(data -> System.out.println(data.getCountry()));
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
                switch (current) {
                    case "PieChart":
                        ObservableList<PieChart.Data> dataObservableList = FXCollections.observableArrayList();
                        for (int i = 0; i < temp.size(); i++) {
                            PieChart.Data datai = new PieChart.Data(temp.get(i).getCountry(), temp.get(i).getCumulative_cases());
                            dataObservableList.add(datai);
                        }
                        PieChart pieChart = setPieChart(dataObservableList);
                        break;

                    case "BarChart":
                        ObservableList<XYChart.Series<String, Number>> obl1 = FXCollections.observableArrayList();
                        for (int i = 0; i < parameters.size(); i++) {
                            XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
                            series.setName(OneData.getName(parameters.get(i)));
                            for (int j = 0; j < temp.size(); j++) {
                                series.getData().add(new XYChart.Data<String, Number>(temp.get(j).getCountry(), temp.get(j).getParameter(parameters.get(i))));
                            }
                            obl1.add(series);

                        }
                        BarChart<String, Number> barChart = setBarChart(obl1);
                        break;

                    case "LineChart":
                        ObservableList<XYChart.Series<Number, Number>> obl2 = FXCollections.observableArrayList();
                        casesReportedDaily c = new casesReportedDaily();
                        HashMap<String, ArrayList<OneData>> hashMap = c.Run();
                        for (int i = 0; i < temp.size(); i++) {
                            XYChart.Series<Number, Number> series = new XYChart.Series<Number, Number>();
                            series.setName(temp.get(i).getCountry());
                            xxx = temp.get(i).getCountry();
//                            series.getData().add(new XYChart.Data<Number,Number>( 0,temp.get(i).getParameter(parameters.get(0))));
                            series.getData().add(new XYChart.Data<Number, Number>(i, hashMap.get("China").get(i).getCumulative_cases()));
                            obl2.add(series);
                        }


                        LineChart<Number, Number> lineChart = setLineChart(obl2);


                    default:
                        /*
                        默认选择饼状图
                         */
                        ObservableList<PieChart.Data> dataObservableList2 = FXCollections.observableArrayList();
                        for (int i = 0; i < temp.size(); i++) {
                            PieChart.Data datai = new PieChart.Data(temp.get(i).getCountry(), temp.get(i).getParameter(parameters.get(0)));
                            dataObservableList2.add(datai);
                        }
                        PieChart pieChart2 = setPieChart(dataObservableList2);
                        break;
                }
            }
        });

        pieChart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                chartPlace.getChildren().clear();
                chartPlace.getChildren().removeAll();
                buttonPlace.getChildren().remove(updateButton);
                buttonPlace.getChildren().remove(stop);
                buttonPlace.getChildren().remove(speed);
                buttonPlace.getChildren().remove(back);
                buttonPlace.getChildren().remove(dayChoice);
                buttonPlace.getChildren().remove(label1);
                ObservableList<PieChart.Data> dataObservableList = FXCollections.observableArrayList();
                for (int i = 0; i < temp.size(); i++) {
                    PieChart.Data datai = new PieChart.Data(temp.get(i).getCountry(), temp.get(i).getParameter(parameters.get(0)));
                    dataObservableList.add(datai);
                }
                PieChart pieChart = setPieChart(dataObservableList);

                current = PieChart;
            }
        });


        barChart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                chartPlace.getChildren().clear();
                chartPlace.getChildren().removeAll();
                buttonPlace.getChildren().remove(updateButton);
                buttonPlace.getChildren().remove(stop);
                buttonPlace.getChildren().remove(speed);
                buttonPlace.getChildren().remove(back);


                buttonPlace.getChildren().remove(label1);
                if (!isBar) {
                    buttonPlace.getChildren().add(dayChoice);
                }

                dayChoice.setLayoutX(600);
                dayChoice.setLayoutY(7);

                b.clear();

                ObservableList<XYChart.Series<String, Number>> obl = FXCollections.observableArrayList();
                for (int i = 0; i < parameters.size(); i++) {
                    XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
                    series.setName(OneData.getName(parameters.get(i)));
                    for (int j = 0; j < temp.size(); j++) {
                        series.getData().add(new XYChart.Data<String, Number>(
                                temp.get(j).getCountry()
                                , temp.get(j).getParameter(parameters.get(i))));
                    }
                    obl.add(series);
                }
                BarChart<String, Number> barChart = setBarChart(obl);
                current = BarChart;

                for (int i = 0; i < temp.size(); i++) {
                    casesReportedDaily cRD = new casesReportedDaily();
                    OneData oneData = temp.get(i);

                    ArrayList<Integer> a = cRD.RunCulCases().get(oneData.getCountry());
                    b = cRD.RunDate().get(oneData.getCountry());
                    for (int j = 0; j < a.size(); j++) {
                        oneData.getDay_case().add(b.get(j));
                        oneData.getDay_death().add(a.get(j));
                    }
                }

                if (isFirstBar) {
//                    每一个国家的daycase大小相同
                    for (int i = 0; i < b.size(); i++) {
                        MenuItem day = new MenuItem(b.get(i));
                        String dayName = b.get(i);
                        dayChoice.getItems().add(day);
                        int finalI = i;
                        day.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                dayChoice.setText(((MenuItem) event.getSource()).getText());
                                chartPlace.getChildren().clear();
                                chartPlace.getChildren().removeAll();
                                ObservableList<XYChart.Series<String, Number>> obl1 = FXCollections.observableArrayList();
                                XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
                                series.setName(dayName);
                                for (int j = 0; j < temp.size(); j++) {
                                    series.getData().add(new XYChart.Data<String, Number>(temp.get(j).getCountry(), temp.get(j).getDay_death().get(finalI)));
                                }
                                obl1.add(series);


                                CategoryAxis x = new CategoryAxis();
                                x.setLabel("CountryName" + dayName);
                                int height = 0;
                                for (int j = 0; j < temp.size(); j++) {
                                    if (temp.get(j).getDay_death().get(finalI) > height) {
                                        height = temp.get(j).getDay_death().get(finalI);
                                    }

                                }
                                NumberAxis y = new NumberAxis(0, height + 20, 10);
                                y.setAccessibleText("万人");
                                BarChart<String, Number> barChart = new BarChart<String, Number>(x, y, obl1);


                                barChart.setLayoutX(200);
                                barChart.setPrefHeight(370);
                                barChart.setLayoutY(0);
                                barChart.setAnimated(true);
                                barChart.setLegendSide(Side.LEFT);


                                chartPlace.getChildren().add(barChart);
                                save.setOnAction(Event -> {
                                    // 构造快照参数
                                    SnapshotParameters params = new SnapshotParameters();
                                    params.setFill(Color.TRANSPARENT);// 设置透明背景或其他颜色

                                    // 生成快照，保存到文件
                                    WritableImage image = chartPlace.snapshot(params, null);

                                    File file = new File(System.getProperty("user.dir") + File.separator + "pictures" + File.separator + "BarChart" + bCount + ".png");
                                    try {
                                        ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    System.out.println("生成快照完成，图片路径：" + file.getAbsolutePath());
                                    pCount++;
                                });


                                barChart.getData().forEach(t -> {
                                    t.getData().forEach(data -> {
                                                Node node = data.getNode();
                                                Tooltip tooltip = new Tooltip(data.getXValue() + "-" + t.getName() + "-" + data.getYValue());
                                                tooltip.setFont(new Font(14));
                                                Tooltip.install(node, tooltip);

                                                data.YValueProperty().addListener(new ChangeListener<Number>() {
                                                    @Override
                                                    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                                                        Node node = data.getNode();
                                                        Tooltip tooltip = new Tooltip(data.getXValue() + "-" + t.getName() + "-" + data.getYValue());
                                                        tooltip.setFont(new Font(17));
                                                        Tooltip.install(node, tooltip);

                                                    }
                                                });
                                            }
                                    );
                                });
                            }
                        });
                    }
                }

                isBar = true;
                isLine = false;
                isFirstBar = false;
            }
        });


        lineChart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                chartPlace.getChildren().clear();
                //
                chartPlace.getChildren().removeAll();
                buttonPlace.getChildren().remove(dayChoice);
                chartPlace.getChildren().clear();
                //
                chartPlace.getChildren().removeAll();
                buttonPlace.getChildren().remove(dayChoice);


                if (!isLine) {
                    buttonPlace.getChildren().add(label1);
                    buttonPlace.getChildren().add(updateButton);
                    buttonPlace.getChildren().add(stop);
                    buttonPlace.getChildren().add(speed);
                    buttonPlace.getChildren().add(back);
                }
                chartPlace.getChildren().add(start);
                chartPlace.getChildren().add(end);

                bString.clear();

                ObservableList<XYChart.Series<Number, Number>> obl = FXCollections.observableArrayList();
                for (int i = 0; i < temp.size(); i++) {
                    XYChart.Series<Number, Number> series = new XYChart.Series<Number, Number>();
                    series.setName(temp.get(i).getCountry());
//                    series.getData().add(new XYChart.Data<Number, Number>(0, 0));
                    //temp.get(i).getParameter(parameters.get(0))


                    obl.add(series);
                }


                setLineChart(obl);
                current = LineChart;


                for (int i = 0; i < temp.size(); i++) {
                    casesReportedDaily cRD = new casesReportedDaily();
                    OneData oneData = temp.get(i);


                    ArrayList<Integer> a = cRD.RunCulCases().get(oneData.getCountry());
                    bString = cRD.RunDate().get(oneData.getCountry());
                    for (int j = 0; j < a.size(); j++) {
                        oneData.getDay_case().add(bString.get(j));
                        oneData.getDay_death().add(a.get(j));
                    }
                }

                if (isFirstLine) {
                    //每一个国家的daycase大小相同
//                    String lastDay = bString.get(bString.size() - 1);
                    dayNow = casesReportedDaily1.RunDate().get("China").get(casesReportedDaily1.RunDate().get("China").size() - 1);
                    String lastDay = dayNow;
                    String firstDay = "2020-01-03";
                    String[] lastDayYMD = lastDay.split("-");
                    String[] firstDayYMD = firstDay.split("-");
                    int xMonths = (Integer.parseInt(lastDayYMD[0]) - Integer.parseInt(firstDayYMD[0])) * 12
                            + Integer.parseInt(lastDayYMD[1]) - Integer.parseInt(firstDayYMD[1]) + 1;
                    String[] monthsString = new String[xMonths];
                    int count = 0;

                    int[] monthDayStart = new int[xMonths];
                    int[] monthDayEnd = new int[xMonths];

                    monthDayStart[0] = 3;
                    for (int i = 1; i < xMonths; i++) {
                        monthDayStart[i]++;
                    }

                    boolean c = true;
                    for (int i = 0; i < xMonths - 1; i++) {
                        int month = i % 12 + 1;
                        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                            monthDayEnd[i] = 31;
                        } else if (month == 2) {
                            if (c) {
                                monthDayEnd[i] = 29;
                                c = false;
                            } else {
                                monthDayEnd[i] = 28;
                            }

                        } else {
                            monthDayEnd[i] = 30;
                        }
                    }
                    monthDayEnd[xMonths - 1] = Integer.parseInt(dayNow.split("-")[2]);


                    for (int i = 0; i < xMonths; i++) {
                        int year = Integer.parseInt(firstDayYMD[0]) + (count) / 12;
                        int month = (Integer.parseInt(firstDayYMD[1]) + (count++) - 1) % 12 + 1;
                        if (1 <= month && month <= 9)
                            monthsString[i] = String.valueOf(year) + "-0" + String.valueOf(month);
                        else monthsString[i] = String.valueOf(year) + "-" + String.valueOf(month);

                    }


                    for (int i = 0; i < xMonths; i++) {
                        Menu day1 = new Menu(monthsString[i]);
                        Menu day2 = new Menu(monthsString[i]);
                        String dayName = bString.get(i);
                        start.getItems().add(day1);
                        end.getItems().add(day2);

                        int x1 = monthDayStart[i];
                        int x2 = monthDayEnd[i];
                        String temp = monthsString[i] + "-";


                        for (int j = x1; j <= x2; j++) {
                            MenuItem d1 = null;
                            if (1 <= j && j <= 9) d1 = new MenuItem(temp + "0" + String.valueOf(j));
                            else d1 = new MenuItem(temp + String.valueOf(j));
                            day1.getItems().add(d1);
                            d1.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    start.setText(((MenuItem) event.getSource()).getText());
                                }
                            });
                        }
                        start.setText(((MenuItem) event.getSource()).getText());


//                        end.getItems().clear();
                        end.setText(((MenuItem) event.getSource()).getText());
                        for (int j = x1; j <= x2; j++) {
                            MenuItem d2 = null;
                            if (1 <= j && j <= 9) d2 = new MenuItem(temp + "0" + String.valueOf(j));
                            else d2 = new MenuItem(temp + String.valueOf(j));
                            day2.getItems().add(d2);
                            d2.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    end.setText(((MenuItem) event.getSource()).getText());
                                }
                            });
                        }


                    }
                }
                isLine = true;
                isBar = false;
                isFirstLine = false;
            }

        });


    }

    static int pCount = 0;

    public PieChart setPieChart(ObservableList<PieChart.Data> dataObservableList) {
        PieChart pieChart = new PieChart();
        pieChart.setData(dataObservableList);
        pieChart.setLegendSide(Side.LEFT);
        pieChart.setLayoutX(100);
        pieChart.setPrefHeight(370);
        pieChart.setPrefWidth(800);
        pieChart.setLayoutY(0);
        pieChart.setAnimated(true);
        chartPlace.getChildren().add(pieChart);

        pieChart.getData().forEach(data -> {
            Node node = data.getNode();
            Tooltip tooltip = new Tooltip(data.getName() + data.getPieValue());
            tooltip.setFont(new Font(17));
            Tooltip.install(node, tooltip);
            data.pieValueProperty().addListener(new ChangeListener<Number>() {
                @Override
                public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                    data.setPieValue((Double) newValue);
                    Node node = data.getNode();
                    Tooltip tooltip = new Tooltip(data.getName() + "-" + data.getPieValue());
                    tooltip.setFont(new Font(17));
                    Tooltip.install(node, tooltip);

                }
            });

        });

        updateButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
//                temp.get(0).setCumulative_cases(400);
                ObservableList<PieChart.Data> dataObservableList1 = FXCollections.observableArrayList();
                for (int i = 0; i < temp.size(); i++) {
                    pieChart.getData().get(i).setPieValue(temp.get(i).getCumulative_cases());
                }
            }
        });
        /*
        保存数据
         */
        save.setOnAction(event -> {
            // 构造快照参数
            SnapshotParameters params = new SnapshotParameters();
            params.setFill(Color.TRANSPARENT);// 设置透明背景或其他颜色

            // 生成快照，保存到文件
            WritableImage image = chartPlace.snapshot(params, null);
//            String s=now+"PieChart";
            File file = new File(System.getProperty("user.dir") + File.separator + "pictures" + File.separator + "PieChart" + pCount + ".png");
            try {
                ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("生成快照完成，图片路径：" + file.getAbsolutePath());
            pCount++;
        });


        return pieChart;

    }

    static int bCount = 0;

    public BarChart<String, Number> setBarChart(ObservableList<XYChart.Series<String, Number>> obl) {
        CategoryAxis x = new CategoryAxis();
        x.setLabel("CountryName");
/*
改barchart高度
 */
        int height = 0;
        for (int i = 0; i < temp.size(); i++) {
            for (int j = 0; j < parameters.size(); j++) {
                if (temp.get(i).getParameter(parameters.get(j)) > height) {
                    height = temp.get(i).getParameter(parameters.get(j));
                }
            }
        }
        NumberAxis y = new NumberAxis(0, height + 20, 10);
        y.setAccessibleText("万人");
        BarChart<String, Number> barChart = new BarChart<String, Number>(x, y, obl);


        barChart.setLayoutX(100);
        barChart.setPrefHeight(370);
        barChart.setPrefWidth(800);
        barChart.setLayoutY(0);
        barChart.setAnimated(true);
        barChart.setLegendSide(Side.LEFT);


        chartPlace.getChildren().add(barChart);


        barChart.getData().forEach(t -> {
            t.getData().forEach(data -> {
                        Node node = data.getNode();
                        Tooltip tooltip = new Tooltip(data.getXValue() + "-" + t.getName() + "-" + data.getYValue());
                        tooltip.setFont(new Font(14));
                        Tooltip.install(node, tooltip);

                        data.YValueProperty().addListener(new ChangeListener<Number>() {
                            @Override
                            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                                Node node = data.getNode();
                                Tooltip tooltip = new Tooltip(data.getXValue() + "-" + t.getName() + "-" + data.getYValue());
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
//                temp.get(0).setCumulative_cases(400);
//                temp.get(0).setCumulative_deaths(80);
                ObservableList<XYChart.Series<String, Number>> dataObservableList1 = FXCollections.observableArrayList();
                int x = 500;
                for (int i = 0; i < parameters.size(); i++) {
                    for (int j = 0; j < temp.size(); j++) {
                        if (temp.get(j).getParameter(parameters.get(i)) > x) {
                            x = temp.get(j).getParameter(parameters.get(i));
                        }
//                        if (temp.get(j).getParameter(parameters.get(i)) >= 500) {
//
//                            System.out.println("here  " + temp.get(j).getParameter(parameters.get(i)));
//                            ((NumberAxis) barChart.getYAxis()).setUpperBound(temp.get(j).getParameter(parameters.get(i)));
//                        }

//                        barChart.getData().get(i).getData().get()   temp.get(i).getCumulative_cases())
                        System.out.println("hh" + temp.get(j));
                        System.out.println("bar value: " + temp.get(j).getParameter(parameters.get(i)));
                        barChart.getData().get(i).getData().get(j).setYValue(temp.get(j).getParameter(parameters.get(i)));

                    }
                }
                ((NumberAxis) barChart.getYAxis()).setUpperBound(x);
            }
        });
         /*
        保存数据
         */
        save.setOnAction(event -> {
            // 构造快照参数
            SnapshotParameters params = new SnapshotParameters();
            params.setFill(Color.TRANSPARENT);// 设置透明背景或其他颜色

            // 生成快照，保存到文件
            WritableImage image = chartPlace.snapshot(params, null);
            File file = new File(System.getProperty("user.dir") + File.separator + "pictures" + File.separator + "BarChart" + bCount + ".png");
            try {
                ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("生成快照完成，图片路径：" + file.getAbsolutePath());
            bCount++;
        });
        return barChart;
    }

    static int lCount = 0;

    public LineChart<Number, Number> setLineChart(ObservableList<XYChart.Series<Number, Number>> obl) {

        NumberAxis y = new NumberAxis(0, 500, 10);
        NumberAxis x = new NumberAxis(0, 20, 1);

        LineChart<Number, Number> lineChart = new LineChart<>(x, y, obl);
        lineChart.setAnimated(true);
        y.autoRangingProperty().setValue(true);
        y.setAnimated(true);
        lineChart.setLayoutX(100);
        lineChart.setPrefHeight(370);
        lineChart.setPrefWidth(800);
        lineChart.setLayoutY(0);
        lineChart.setAnimated(true);
        lineChart.setPrefWidth(600);
        lineChart.setLegendSide(Side.LEFT);

//        lineChart.setCreateSymbols(false);

        chartPlace.getChildren().add(lineChart);

        lineChart.getData().forEach(t -> {
            t.getData().forEach(data -> {


                        Node node = data.getNode();

                        node.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                System.out.println("Yesssss");
                            }
                        });

                        Tooltip tooltip = new Tooltip(data.getXValue() + "-" + t.getName() + "-" + data.getYValue());
                        tooltip.setFont(new Font(200));
                        Tooltip.install(node, tooltip);

                        data.XValueProperty().addListener(new ChangeListener<Number>() {
                            @Override
                            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                                Node node = data.getNode();
                                Tooltip tooltip = new Tooltip(data.getXValue() + "-" + t.getName() + "-" + data.getYValue());
                                tooltip.setFont(new Font(200));
                                Tooltip.install(node, tooltip);
                                System.out.println("nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
                            }
                        });

                        data.YValueProperty().addListener(new ChangeListener<Number>() {
                            @Override
                            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                                Node node = data.getNode();
                                Tooltip tooltip = new Tooltip(data.getXValue() + "-" + t.getName() + "-" + data.getYValue());
                                tooltip.setFont(new Font(200));
                                Tooltip.install(node, tooltip);
                                System.out.println("yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
                            }
                        });


                    }
            );
        });

        number = 0;
//        for (int i = 0; i < temp.size(); i++) {
        DataTask task = new DataTask();
        task.setDelay(Duration.seconds(0));
        task.setPeriod(Duration.seconds(1));
        task.valueProperty().addListener(new ChangeListener<ArrayList<Integer>>() {

            @Override
            public void changed(ObservableValue<? extends ArrayList<Integer>> observable, ArrayList<Integer> oldValue, ArrayList<Integer> newValue) {
                if (newValue != null) {
                    casesReportedDaily c = new casesReportedDaily();
                    int right = c.RunDate().get("China").indexOf(Pro1Controller.end.getText());

                    for (int i = 0; i < temp.size(); i++) {
                        int xIndex = obl.get(i).getData().size();
                        if (xIndex >= 20) {
                            ((NumberAxis) lineChart.getXAxis()).setLowerBound(0);
                            ((NumberAxis) lineChart.getXAxis()).setUpperBound(xIndex);
                        }
                        if (newValue.get(i) >= hhh) {
                            ((NumberAxis) lineChart.getYAxis()).setUpperBound(newValue.get(i));
                            hhh = newValue.get(i);
                        }

//                        if (xIndex >= 20) {
//                            ((NumberAxis) lineChart.getXAxis()).setLowerBound(0);
//                            ((NumberAxis) lineChart.getXAxis()).setUpperBound(xIndex);
//                        }

                        obl.get(i).getData().add(new XYChart.Data<Number, Number>(xIndex, newValue.get(i)));
                    }
                    number++;
                }
            }
        });

        DataTask task2 = new DataTask();
        task2.setDelay(Duration.seconds(0));
        task2.setPeriod(Duration.seconds(1));
        task2.valueProperty().addListener(new ChangeListener<ArrayList<Integer>>() {
            @Override
            public void changed(ObservableValue<? extends ArrayList<Integer>> observable, ArrayList<Integer> oldValue, ArrayList<Integer> newValue) {
                int xIndex = obl.get(0).getData().size();
                if (newValue != null && xIndex > 1) {
                    for (int i = 0; i < obl.size(); i++) {
                        if (x.getLowerBound() > 0) {
                            x.setLowerBound(x.getLowerBound() - 1);
                            x.setUpperBound(x.getUpperBound() - 1);
                        }

                        obl.get(i).getData().remove(xIndex - 1);
                    }
                    number--;

                }

            }
        });

        updateButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (task2.isRunning()) {
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
                if (task2.isRunning()) {
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
                if (task2.isRunning()) {
                    task.setPeriod(Duration.seconds(0.3));
                }

            }
        });

        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (task.isRunning()) {
                    task.cancel();
                    task.reset();
                }
                if (!task2.isRunning()) {
                    lineChart.setAnimated(true);
                    task2.start();

                }
            }
        });

        save.setOnAction(event -> {
            // 构造快照参数
            SnapshotParameters params = new SnapshotParameters();
            params.setFill(Color.TRANSPARENT);// 设置透明背景或其他颜色

            // 生成快照，保存到文件
            WritableImage image = chartPlace.snapshot(params, null);

            File file = new File(System.getProperty("user.dir") + File.separator + "pictures" + File.separator + "LineChart" + lCount + ".png");
            try {
                ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            lCount++;
            System.out.println("生成快照完成，图片路径：" + file.getAbsolutePath());
        });
        return lineChart;
    }

    /*
    随机改变temp的方法
     */

}







