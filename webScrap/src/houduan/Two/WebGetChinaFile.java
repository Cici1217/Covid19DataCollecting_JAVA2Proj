package houduan.Two;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.*;
import java.util.HashMap;

public class WebGetChinaFile {
    public static void main(String[] args) throws IOException {
        String origin = "http://www.sy72.com/covid/list.asp?id=";
        String[] city = new String[]{
                "湖北", "浙江", "广东", "河南", "湖南", "安徽",
                "重庆", "江西", "山东", "四川", "江苏", "北京",
                "上海", "福建", "广西", "云南", "陕西", "河北",
                "海南", "黑龙江", "辽宁", "山西", "天津", "甘肃",
                "内蒙古", "宁夏", "新疆", "吉林", "贵州", "香港",
                "台湾", "青海", "澳门", "西藏"
        };
        try {
        StringBuilder s = new StringBuilder();
//        HashMap<String, int[]> hashMap = new HashMap<>();
        for (int i = 0; i < city.length; i++) {
            int x = i + 439;
            String url = origin + String.valueOf(x);
            Document doc = Jsoup.connect(url)
                    .get();
            s.append(city[i]).append(" ");
            System.out.println(city[i]+ " "+ url);

            s.append(doc.getElementsByClass("t1 c0").text().split(" ")[0]).append(" ")
                    .append(doc.getElementsByClass("t1 c1").text().split(" ")[0]).append(" ")
                    .append(doc.getElementsByClass("t1 c3").text().split(" ")[0]).append(" ")
                    .append(doc.getElementsByClass("t1 c4").text().split(" ")[0]).append(" ").append("\n");
            Thread.sleep(2000);
        }

            FileOutputStream fos = new FileOutputStream("test.txt");
            String outString = s.toString();
            byte output[] = outString.getBytes("UTF-8");
            fos.write(output);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        writer.close();
//        fop.close();


    }
}
