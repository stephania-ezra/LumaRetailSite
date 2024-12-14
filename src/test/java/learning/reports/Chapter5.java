package learning.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class Chapter5 {
    public static void main(String[] args) throws IOException {
        ExtentReports er = new ExtentReports();

        File file = new File("Extent Report part2.html");
        ExtentSparkReporter esr = new ExtentSparkReporter(file);

        er.attachReporter(esr);

        er.createTest("Text Based Test")
                .log(Status.PASS,"pass information")
                .log(Status.PASS,"<b>pass information</b>")
                .log(Status.PASS,"<i>pass information</i>")
                .log(Status.PASS,"<b><i>pass information</i></b>")
                .log(Status.PASS,"<mark>pass information</mark>"); // marker highlight :) ha ha

        //Highlighted Message in Redcolor
        //used for assertion , error message ... we can highlight :)
        er.createTest("Text Based Test")
                .info("This is not a Highlighted Message")
                .info(MarkupHelper.createLabel("My First Highlighted Message", ExtentColor.RED));


        //xml based data

        String xmlData = "<menu id=\"file\" value=\"File\">\n" +
                "  <popup>\n" +
                "    <menuitem value=\"New\" onclick=\"CreateNewDoc()\" />\n" +
                "    <menuitem value=\"Open\" onclick=\"OpenDoc()\" />\n" +
                "    <menuitem value=\"Close\" onclick=\"CloseDoc()\" />\n" +
                "  </popup>\n" +
                "</menu>";


        //info and log both methods are same only

        er.createTest("XML Based Test")
                //.log(Status.INFO,"XML data");
                        .info(MarkupHelper.createCodeBlock(xmlData, CodeLanguage.XML));

        //JSON based data
        String jsonData= "{\"menu\": {\n" +
                "  \"id\": \"file\",\n" +
                "  \"value\": \"File\",\n" +
                "  \"popup\": {\n" +
                "    \"menuitem\": [\n" +
                "      {\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},\n" +
                "      {\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},\n" +
                "      {\"value\": \"Close\", \"onclick\": \"CloseDoc()\"}\n" +
                "    ]\n" +
                "  }\n" +
                "}}";

        er.createTest("JSON based Test")
                        .info(MarkupHelper.createCodeBlock(jsonData, CodeLanguage.JSON));

        //List type data

        List<String> list = new ArrayList<String>();
        list.add("Ezra");
        list.add("Ethan");
        list.add("Stephania");

        er.createTest("List based Test")
                .info(MarkupHelper.createOrderedList(list)) // details displayed by number
                .info(MarkupHelper.createUnorderedList(list)); // details displayed in bullet points

        //HashMap type data

        Map<String,Integer> mapData = new HashMap<String,Integer>();
        mapData.put("Coll",765);
        mapData.put("Ezra",567);
        mapData.put("Ethan",333);
        mapData.put("David",444);

        er.createTest("Map based Test")
                .info(MarkupHelper.createOrderedList(mapData)) // details displayed by number
                .info(MarkupHelper.createUnorderedList(mapData));

        //Set type data
        Set<String> setData = mapData.keySet();

        er.createTest("Set based Test")
                .info(MarkupHelper.createOrderedList(setData)) // details displayed by number
                .info(MarkupHelper.createUnorderedList(setData));

    try{
        int x = 5; int y =0;
        int z = x/y;
    } catch (Exception e) {
        er.createTest("Exception1")
                .fail(e);
    }

    Throwable t = new RuntimeException("This is a Customized Exception");
    er.createTest("Arithmetic Exception Test")
            .fail(t);

        er.flush();
        Desktop.getDesktop().browse(new File("Extent Report part2.html").toURI());
    }
}
