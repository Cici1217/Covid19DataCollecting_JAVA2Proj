package getDatasetFileFromFirstUrl.Two;

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
                TwoData twoData = new TwoData();
                if (body.length == 12 || body[0].equals("Global")) {
                    if(body[0].equals("Other")){
                        for (int i = 0; i < body.length; i++) {
                            if(body[i].equals("")) body[i] = "0";
                        }
                    }
                    twoData.setName(body[0]);
                    twoData.setWHO_region(body[1]);
                    twoData.setCumulativeCases(body[2]);
                    twoData.setCumulativeCasesPer100000(body[3]);
                    twoData.setNewlyReportedCasesIn7Days(body[4]);
                    twoData.setNewlyReportedCasesIn7DaysPer100000(body[5]);
                    twoData.setNewlyReportedCasesIn24Hours(body[6]);
                    twoData.setCumulativeDeaths(body[7]);
                    twoData.setCumulativeDeathsPer100000(body[8]);
                    twoData.setNewlyReportedDeathsIn7Days(body[9]);
                    twoData.setNewlyReportedDeathsIn7DaysPer100000(body[10]);
                    twoData.setNewlyReportedDeathsIn24Hours(body[11]);
                    hashMap.put(body[0], twoData);
                } else {
                    String t = body[0].substring(1) + "," + body[1].substring(0, body[1].length() - 1);
                    twoData.setName(t);
                    twoData.setWHO_region(body[2]);
                    twoData.setCumulativeCases(body[3]);
                    twoData.setCumulativeCasesPer100000(body[4]);
                    twoData.setNewlyReportedCasesIn7Days(body[5]);
                    twoData.setNewlyReportedCasesIn7DaysPer100000(body[6]);
                    twoData.setNewlyReportedCasesIn24Hours(body[7]);
                    twoData.setCumulativeDeaths(body[8]);
                    twoData.setCumulativeDeathsPer100000(body[9]);
                    twoData.setNewlyReportedDeathsIn7Days(body[10]);
                    twoData.setNewlyReportedDeathsIn7DaysPer100000(body[11]);
                    twoData.setNewlyReportedDeathsIn24Hours(body[12]);
                    hashMap.put(t, twoData);
                }
            }
            reader.close();
//            System.out.println(hashMap);
//            You can process data here.
        } catch (IOException e) {
            e.printStackTrace();
        }
//            Or You can process data here. It seems more beautiful.
    }
}
