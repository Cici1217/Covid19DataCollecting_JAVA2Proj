import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class demo {
    //It's a test
    public static void main(String[] args) throws IOException {
        String url4 = "https://covid19.who.int/table";

        Jsoup.connect(url4).timeout(8000);

        Jsoup.connect(url4).method(Connection.Method.GET);

        Jsoup.connect(url4).maxBodySize(0);

        Jsoup.connect(url4).followRedirects(false);

        Connection resp = Jsoup.connect(url4);

        try {
            Thread.sleep(5);//在jsoup获取到内容之后，经过5s在解析即可
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        Document doc = resp.get();


        Elements elements = doc.getElementsByClass("tr depth_0   ");

        ArrayList<DataFromWHO> dataFromWHO = new ArrayList<>();

        for (Element el : elements) {
            DataFromWHO temp = new DataFromWHO();
//            temp.setName((el.getElementsByTag("img").eq(0).attr("src")));
            temp.setName(el.getElementsByClass("column_name td").text());
            temp.setTotalCasesNum(el.getElementsByClass("column_Cumulative_Confirmed td").text());
            temp.setNewlyReportedIn7DaysNum(el.getElementsByClass("column_Last_7_Days_Confirmed td").text());
            temp.setTotalDeathNum(el.getElementsByClass("column_Cumulative_Deaths td").text());
            temp.setNewlyReportedDeathIn7DayNum(el.getElementsByClass("column_Last_7_Days_Deaths td").text());
            temp.setTotalVaccinePer100Population(el.getElementsByClass("column_Total_Vaccinations_Per_100 td").text());
            temp.setFullyVaccinePer100Population(el.getElementsByClass("column_Total_Fully_Vacc_Per_100 td").text());
            dataFromWHO.add(temp);
        }
        System.out.print(dataFromWHO.toString());
    }

    //doc.html();//url to html
    //doc.title();


    public void test() throws IOException {
        String url = "https://tieba.baidu.com/f?kw=%E5%8F%A4%E9%A3%8E&ie=utf-8&tab=good&cid=3";
        Document parse = Jsoup.connect(url).get();

        Elements select = parse.select("a.j_th_tit");
        for (Element element : select) {
            System.out.println(element.attr("abs:href"));
        }
    }

    public static Document getDocumentFromUrl(String webString) throws IOException {
        return Jsoup.connect(webString).get();
    }

    //File->Document
    public static Document getDocumentFromFile(String pathName) throws IOException {
        return Jsoup.parse(new File(pathName), "UTF-8");
    }

    //String->Document
    public static Document getDocumentFromString(String string) throws IOException {
        return Jsoup.parse(string);
    }

    public static Elements getURLLinks(String webString) throws IOException {
        //获得全部超链接
        return Jsoup.connect(webString).get().select("a[href]");
    }

    public static void getAllLinkAndTestFromLinks(String webString) throws IOException {
        Elements elements = getURLLinks(webString);
        for (Element link : elements) {
            System.out.println(link.attr("href"));
            System.out.println(link.text());
            System.out.println();
        }
    }


    public static String getFav(String webString) throws IOException {
        Document document = getDocumentFromUrl(webString);
        Element element = document.head().select("link[href~=.*\\.(ico|png)]").first();
        if (element == null) {
            element = document.head().select("meta[itemprop=image]").first();
            if (element != null) {
                return element.attr("content");
            }
        } else {
            return element.attr("href");
        }
        return null;
    }


}
