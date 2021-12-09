package houduan.getDatasetFileFromFirstUrl.One;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class casesReportedDaily {

    public HashMap<String, ArrayList<OneData>> Run() {
        File file = new File("casesReportedDaily.csv");
        HashMap<String, ArrayList<OneData>> hashMap = new HashMap<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
            String temp;
            reader.readLine();
            while ((temp = reader.readLine()) != null) {
                String[] body = temp.split(",", -1);

                if (body.length > 8) {
                    String t = body[2].substring(1) + "," + body[3].substring(0, body[3].length() - 1);
                    OneData oneData = new OneData(body[0], body[1], t, body[4], body[6], body[5], body[8], body[7]);
                    if (hashMap.containsKey(t)) {
                        hashMap.get(t).add(oneData);
                        hashMap.put(t, hashMap.get(t));
                    } else {
                        ArrayList<OneData> a = new ArrayList<>();
                        a.add(oneData);
                        hashMap.put(t, a);
                    }
                } else {
                    OneData oneData = new OneData(body[0], body[1], body[2], body[3], body[5], body[4], body[7], body[6]);
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
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hashMap;
    }
}
