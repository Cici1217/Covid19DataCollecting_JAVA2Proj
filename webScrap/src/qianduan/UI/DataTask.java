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
                            if (i <= right) {
                                list.add(hashMap.get(s).get(i).getCumulative_cases());
                                System.out.println("cul case. " + s + hashMap.get(s).get(i).getCumulative_cases());
                            }
                            break;
                        case 1:
                            if (i <= right)
                                list.add(hashMap.get(s).get(i).getNew_cases());
                            break;
                        case 2:

                            if (i <= right)
                                list.add(hashMap.get(s).get(i).getCumulative_deaths());
                            break;
                        case 3:
                            if (i <= right)
                                list.add(hashMap.get(s).get(i).getNew_deaths());
                            break;
                        default:
                    }
                }
                return list;
            }
        };
        return task;
    }
}

