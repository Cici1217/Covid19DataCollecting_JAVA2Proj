package qianduan;

import houduan.getDatasetFileFromFirstUrl.One.OneData;
import houduan.getDatasetFileFromFirstUrl.One.casesReportedDaily;
import javafx.collections.ObservableList;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class DataTask extends ScheduledService<ArrayList<Integer>> {

    @Override
    protected Task<ArrayList<Integer>> createTask() {
        Task<ArrayList<Integer>> task = new Task<ArrayList<Integer>>() {
            @Override
            protected ArrayList<Integer> call() throws Exception {
                ArrayList<Integer> list = new ArrayList<>();
                ObservableList<OneData> temp = Pro1Controller.temp;
                ArrayList<Integer> parameters = Pro1Controller.parameters;
                casesReportedDaily c = new casesReportedDaily();
                HashMap<String, ArrayList<OneData>> hashMap = c.Run();
//                int i = 0;
//
//                for (int j = 0; j < temp.size(); j++) {
//                    list.add(temp.get(i).getCumulative_cases());
//                }
                Random random = new Random();
                temp.forEach(data -> list.add(
                        random.nextInt(500)
                        )
                );
                return list;
            }
        };
        return task;
    }
}
