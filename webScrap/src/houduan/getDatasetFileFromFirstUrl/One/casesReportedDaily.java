package houduan.getDatasetFileFromFirstUrl.One;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class casesReportedDaily {
    public static void main(String[] args) {
        File file = new File("casesReportedDaily.csv");
        HashMap<String, ArrayList<OneData>> hashMap = new HashMap<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
            String temp;
            reader.readLine();
            while ((temp = reader.readLine()) != null) {
                String[] body = temp.split(",", -1);
                OneData oneData = new OneData();
                if (body.length > 8) {
                    String t = body[2].substring(1) + "," + body[3].substring(0, body[3].length() - 1);
                    oneData.setDate_reported(body[0]);
                    oneData.setCountry_code(body[1]);
                    oneData.setCountry(t);
                    oneData.setWHO_region(body[4]);
                    oneData.setNew_cases(body[5]);
                    oneData.setCumulative_cases(body[6]);
                    oneData.setNew_deaths(body[7]);
                    oneData.setCumulative_deaths(body[8]);
                    if (hashMap.containsKey(t)) {
                        hashMap.get(t).add(oneData);
                        hashMap.put(t, hashMap.get(t));
                    } else {
                        ArrayList<OneData> a = new ArrayList<>();
                        a.add(oneData);
                        hashMap.put(t, a);
                    }
                } else {
                    oneData.setDate_reported(body[0]);
                    oneData.setCountry_code(body[1]);
                    oneData.setCountry(body[2]);
                    oneData.setWHO_region(body[3]);
                    oneData.setNew_cases(body[4]);
                    oneData.setCumulative_cases(body[5]);
                    oneData.setNew_deaths(body[6]);
                    oneData.setCumulative_deaths(body[7]);
                    if (hashMap.containsKey(body[2])) {
                        hashMap.get(body[2]).add(oneData);
                        hashMap.put(body[2], hashMap.get(body[2]));
                    } else {
                        ArrayList<OneData> a = new ArrayList<>();
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

        //You can process hashmap here


    }
}
