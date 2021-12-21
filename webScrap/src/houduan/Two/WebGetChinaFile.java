package houduan.Two;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.HashMap;

public class WebGetChinaFile {
    public static void main(String[] args) throws IOException {
        update2();
    }

    public static void update2() throws IOException {
        String url = "http://www.sy72.com/covid19/";
        String[] city = new String[]{
                "湖北", "浙江", "广东", "河南", "湖南", "安徽",
                "重庆", "江西", "山东", "四川", "江苏", "北京",
                "上海", "福建", "广西", "云南", "陕西", "河北",
                "海南", "黑龙江", "辽宁", "山西", "天津", "甘肃",
                "内蒙古", "宁夏", "新疆", "吉林", "贵州", "香港",
                "台湾", "青海", "澳门", "西藏"
        };
        StringBuilder s = new StringBuilder();

        Document doc = Jsoup.connect(url).get();
        Elements els = doc.getElementsByClass("nav1").tagName("li");
        String word = "";
        for (Element element : els) {
            word = element.getElementsByTag("dl").text();
        }
        String[] words = word.split(" ");
        int j = city.length - 1;
        for (int i = 0; i < words.length; i++) {
            if (j>=0&&words[i].equals(city[j])) {
                s.append(words[i++]).append(" ");
                s.append(words[i++]).append(" ");
                s.append(words[i++]).append(" ");
                i++;
                s.append(words[i++]).append(" ");
                i++;
                s.append(words[i++]).append(" ");
                s.append("\n");
                j--;
            }
        }

        FileOutputStream fos = new FileOutputStream("test.txt");
        String outString = s.toString();
        byte output[] = outString.getBytes("UTF-8");
        fos.write(output);
        fos.close();
    }
}
