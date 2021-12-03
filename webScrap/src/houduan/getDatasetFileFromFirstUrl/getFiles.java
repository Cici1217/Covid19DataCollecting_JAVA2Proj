package houduan.getDatasetFileFromFirstUrl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class getFiles {
    public static void main(String[] args) throws Exception {
        String origin = "https://covid19.who.int";
        String url = origin + "/table";
        Document doc = Jsoup.connect(url)
                .get();
        Elements elements = doc
                .getElementsByClass("sc-AxjAm sc-fzowVh hQbVOc")
                .select("a[href]");
        String newUrl = null;
        for (Element link : elements) {
            newUrl = link.attr("href");
        }
        newUrl = origin + newUrl;

        Document newDoc = Jsoup.connect(newUrl)
                .get();
        Elements newElements = newDoc
                .getElementById("Data Download")
                .select("a[href]")
                .tagName("a");
        String[] names = new String[]{
                "casesReportedDaily.csv",
                "casesReportedLatest.csv",
                "vaccinationData.csv",
                "vaccinationMetadata.csv"
        };
        int i = 0;
        for (Element element : newElements) {
            String eachUrl = element.attr("href");
            System.out.println(eachUrl);
            downloadFile(eachUrl, names[i++]);
        }
    }

    public static void downloadFile(String fileUrl, String fileLocal) throws Exception {
        URL url = new URL(fileUrl);
        HttpURLConnection urlCon = (HttpURLConnection) url.openConnection();
        String encValue = "UTF-8";
        InputStreamReader fileReader = new InputStreamReader(urlCon.getInputStream(), encValue);
        OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(fileLocal),encValue);
        int len;
        while ((len = fileReader.read()) != -1) {
            out.write((char) len);
        }
        out.close();
        fileReader.close();
    }

}
