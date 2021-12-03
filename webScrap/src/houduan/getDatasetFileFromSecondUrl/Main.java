package getDatasetFileFromSecondUrl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://voice.baidu.com/act/newpneumonia/newpneumonia";
        Document doc = Jsoup.connect(url)
                .get();
//        System.out.println(doc.html());
        Elements elements = doc
                .getElementsByTag("ul");
        for (Element element : elements) {
//            System.out.println(element.html());
            System.out.println(element.html());
        }

    }
}
