package houduan.getDatasetFileFromFirstUrl.One;

import qianduan.Data;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class casesReportedDaily {
//    public static HashMap<String,ArrayList<Data>> toUseHashMap = new HashMap<>();
    public static void main(String[] args) {
        //You can process hashmap here
//        toUseHashMap = Run();
    }

    public HashMap<String,ArrayList<Data>> Run(){
        File file = new File("casesReportedDaily.csv");
        HashMap<String, ArrayList<Data>> hashMap = new HashMap<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
            String temp;
            reader.readLine();
            while ((temp = reader.readLine()) != null) {
                String[] body = temp.split(",", -1);

                if (body.length > 8) {
                    String t = body[2].substring(1) + "," + body[3].substring(0, body[3].length() - 1);

                    Data oneData = new Data(body[0],body[1],t,body[4],body[6],body[5],body[8],body[7]);

//                    oneData.setDate_reported(body[0]);
//                    oneData.setCountry_code(body[1]);
//                    oneData.setCountry(t);
//                    oneData.setWHO_region(body[4]);
//                    oneData.setNew_cases(body[6]);
//                    oneData.setCumulative_cases(body[5]);
//                    oneData.setNew_deaths(body[8]);
//                    oneData.setCumulative_deaths(body[7]);
                    if (hashMap.containsKey(t)) {
                        hashMap.get(t).add(oneData);
                        hashMap.put(t, hashMap.get(t));
                    } else {
                        ArrayList<Data> a = new ArrayList<>();
                        a.add(oneData);
                        hashMap.put(t, a);
                    }
                } else {
                    Data oneData = new Data(body[0],body[1],body[2],body[3],body[5],body[4],body[7],body[6]);
//
//                    oneData.setDate_reported(body[0]);
//                    oneData.setCountry_code(body[1]);
//                    oneData.setCountry(body[2]);
//                    oneData.setWHO_region(body[3]);
//                    oneData.setNew_cases(body[5]);
//                    oneData.setCumulative_cases(body[4]);
//                    oneData.setNew_deaths(body[7]);
//                    oneData.setCumulative_deaths(body[6]);
                    if (hashMap.containsKey(body[2])) {
                        hashMap.get(body[2]).add(oneData);
                        hashMap.put(body[2], hashMap.get(body[2]));
                    } else {
                        ArrayList<Data> a = new ArrayList<>();
                        a.add(oneData);
                        hashMap.put(body[2], a);
                    }
                }

            }
//            String n = "occupied Palestinian territory, including east Jerusalem";
//            int x = hashMap.get(n).size();
//            for (int i = 0; i < x; i++) {
//                OneData oneData = hashMap.get(n).get(i);
//                System.out.print(oneData.getNew_cases() + " ");
//                System.out.print(oneData.getCumulative_cases()+" ");
//                System.out.println(oneData.getDate_reported());
//            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hashMap;
    }
}
