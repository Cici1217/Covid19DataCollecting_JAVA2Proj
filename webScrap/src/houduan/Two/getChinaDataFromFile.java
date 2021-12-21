package houduan.Two;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class getChinaDataFromFile {
    public static void main(String[] args) {
getDataInChina();

        //you can process hashmap here
    }

    public static HashMap<String,int[]> getDataInChina(){
        HashMap<String, int[]> hashMap = new HashMap<>();
        BufferedReader reader;
        File file = new File("test.txt");

        try {
            reader = new BufferedReader(new FileReader(file));
            String temp;
            while ((temp = reader.readLine()) != null) {
                String[] body = temp.split(" ", -1);
                hashMap.put(body[0], new int[]{
                        Integer.parseInt(body[1]),
                        Integer.parseInt(body[2]),
                        Integer.parseInt(body[3]),
                        Integer.parseInt(body[4])
                });
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(hashMap);
        return hashMap;
    }
}
