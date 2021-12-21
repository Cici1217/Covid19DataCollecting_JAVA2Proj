package houduan.Two;

import java.io.*;
import java.util.HashMap;

public class getChinaDataFromFile {
    public static void main(String[] args) {
        getDataInChina();

        //you can process hashmap here
    }

    public static HashMap<String, TwoData> getDataInChina() {
        HashMap<String, TwoData> hashMap = new HashMap<>();
        BufferedReader reader;
        File file = new File("test.txt");

        try {
            reader = new BufferedReader(new FileReader(file));
            String temp;
            while ((temp = reader.readLine()) != null) {
                String[] body = temp.split(" ", -1);
                TwoData twoData = new TwoData(body[0],
                        Integer.parseInt(body[1]),
                        Integer.parseInt(body[2]),
                        Integer.parseInt(body[3]),
                        Integer.parseInt(body[4])
                );
                hashMap.put(body[0], twoData);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(hashMap);
        return hashMap;
    }
}
