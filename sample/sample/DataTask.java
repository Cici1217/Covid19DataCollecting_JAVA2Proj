package sample;

import javafx.collections.ObservableList;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class DataTask extends ScheduledService<ArrayList<Integer>> {

    @Override
    protected Task<ArrayList<Integer>> createTask() {
        Task<ArrayList<Integer>> task=new Task<ArrayList<Integer>>() {
            @Override
            protected ArrayList<Integer> call() throws Exception {
                ArrayList<Integer> list=new ArrayList<>();
                ObservableList<Data> temp=Pro1Controller.temp;
                ArrayList<Integer> parameters=Pro1Controller.parameters;
                Random random=new Random();
                temp.forEach(data -> list.add(random.nextInt(500)));
//                temp.forEach(data -> list.add(data.getParameter(parameters.get(0))));
                return list;
            }
        };
        return task;
    }
}
