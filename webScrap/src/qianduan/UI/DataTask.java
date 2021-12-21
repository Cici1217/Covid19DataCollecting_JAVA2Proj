package qianduan.UI;

import houduan.One.OneData;
import houduan.One.casesReportedDaily;
import javafx.collections.ObservableList;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class DataTask extends ScheduledService<ArrayList<Integer>> {

    @Override
    protected Task<ArrayList<Integer>> createTask() {

        Task<ArrayList<Integer>> task = new Task<ArrayList<Integer>>() {
            @Override
            protected ArrayList<Integer> call() throws Exception {
                casesReportedDaily c = new casesReportedDaily();
                HashMap<String, ArrayList<OneData>> hashMap = c.Run();
                ArrayList<Integer> arrayList = Pro1Controller.parameters;
                ArrayList<Integer> list = new ArrayList<>();
                ObservableList<OneData> temp = Pro1Controller.temp;
                String s;
                int left = c.RunDate().get("China").indexOf(Pro1Controller.start.getText());
                int right = c.RunDate().get("China").indexOf(Pro1Controller.end.getText());
                int i = left + Pro1Controller.number;
                int x = arrayList.get(0);
                Random r = new Random();
                for (int j = 0; j < temp.size(); j++) {
                    s = temp.get(j).getCountry();
                    System.out.println("j = " + x + " country" + s);
                    switch (x) {
                        case 0:
//                            for (int i = left; i <= right; i++) {
                            if (i <= right) {
                                list.add(hashMap.get(s).get(i).getCumulative_cases());
                                System.out.println("cul case. " + s + hashMap.get(s).get(i).getCumulative_cases());
                            }

//                                temp.add(hashMap.get(s).get(i));
//                            }
                            break;
                        case 1:
//                            for (int i = left; i <= right; i++) {
                            if (i <= right)
                                list.add(hashMap.get(s).get(i).getNew_cases());
//                                temp.add(hashMap.get(s).get(i));
//                            }
                            break;
                        case 2:
//                            for (int i = left; i <= right; i++) {
                            if (i <= right)
                                list.add(hashMap.get(s).get(i).getCumulative_deaths());
//                                temp.add(hashMap.get(s).get(i));
//                            }
                            break;
                        case 3:
//                            for (int i = left; i <= right; i++) {
//                        for (int i = 0; i < hashMap.get(s).size(); i++) {
                            if (i <= right)
                                list.add(hashMap.get(s).get(i).getNew_deaths());
//                                temp.add(hashMap.get(s).get(i));
//                            }
                            break;

                        default:


                    }
                }

//                for (int k = 0; k < temp.size(); k++) {
//
//                    System.out.println(left);

//                    System.out.println(right);
//                    s = temp.get(k).getCountry();
//                    System.out.println("this country: "+String.valueOf(Pro1Controller.number)+s);
//
//                    switch (j) {
//                        case 0:
////                            for (int i = left; i <= right; i++) {
//                                list.add(hashMap.get(s).get(i).getCumulative_cases());
//                                temp.add(hashMap.get(s).get(i));
////                            }
//
//                        case 1:
////                            for (int i = left; i <= right; i++) {
//                                list.add(hashMap.get(s).get(i).getNew_cases());
//                                temp.add(hashMap.get(s).get(i));
////                            }
//
//                        case 2:
////                            for (int i = left; i <= right; i++) {
//                                list.add(hashMap.get(s).get(i).getCumulative_deaths());
//                                temp.add(hashMap.get(s).get(i));
////                            }
//
//                        case 3:
////                            for (int i = left; i <= right; i++) {
////                        for (int i = 0; i < hashMap.get(s).size(); i++) {
//                                list.add(hashMap.get(s).get(i).getNew_deaths());
//                                temp.add(hashMap.get(s).get(i));
////                            }
//
//
//                        default:
//
//                    }
//                }
//                Pro1Controller.number++;
                return list;
            }
        };
        return task;
    }
}


//
//package qianduan;
//
//import houduan.getDatasetFileFromFirstUrl.One.OneData;
//import javafx.collections.ObservableList;
//import javafx.concurrent.ScheduledService;
//import javafx.concurrent.Task;
//
//
//import java.util.ArrayList;
//import java.util.Random;
//import java.util.concurrent.ScheduledThreadPoolExecutor;
//
//public class DataTask extends ScheduledService<ArrayList<Integer>> {
//
//    @Override
//    protected Task<ArrayList<Integer>> createTask() {
//        Task<ArrayList<Integer>> task=new Task<ArrayList<Integer>>() {
//            @Override
//            protected ArrayList<Integer> call() throws Exception {
//                ArrayList<Integer> list=new ArrayList<>();
//
//                ObservableList<OneData> temp=Pro1Controller.temp;
//                ArrayList<Integer> parameters=Pro1Controller.parameters;
//                Random random=new Random();
//                temp.forEach(data ->
//                        list.add(random.nextInt(500)));
//                return list;
//            }
//        };
//        return task;
//    }
//}
