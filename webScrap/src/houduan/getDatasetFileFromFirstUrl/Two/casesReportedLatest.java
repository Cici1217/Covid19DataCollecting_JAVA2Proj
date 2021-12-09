package houduan.getDatasetFileFromFirstUrl.Two;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class casesReportedLatest {
    public static void main(String[] args) {
        File file = new File("casesReportedLatest.csv");
        HashMap<String, TwoData> hashMap = new HashMap<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
            String temp;
            reader.readLine();
            while ((temp = reader.readLine()) != null) {
                String[] body = temp.split(",", -1);
                TwoData twoData;
                if (body.length == 12 || body[0].equals("Global")) {
                    if(body[0].equals("Other")){
                        for (int i = 0; i < body.length; i++) {
                            if(body[i].equals("")) body[i] = "0";
                        }
                    }
                    twoData = new TwoData(body[0],body[1],body[2],body[3],
                            body[4],body[5],body[6],body[7],body[8],body[9],body[10],body[11]);
                    hashMap.put(body[0], twoData);
                } else {
                    String t = body[0].substring(1) + "," + body[1].substring(0, body[1].length() - 1);
                    twoData = new TwoData(t,body[2],body[3], body[4],
                            body[5],body[6],body[7],body[8],body[9],body[10],body[11],body[12]);
                    hashMap.put(t, twoData);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    System.out.println(hashMap);

    }
}
