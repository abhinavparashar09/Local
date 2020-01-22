package cucumberBase.pageFactory;

import cucumberBase.helpers.javaScript.JavaScriptHelper;
import cucumberBase.helpers.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

public class CommonMethods {
    public static SimpleDateFormat ccDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    public static WebDriverWait wait;
    final String CSVSRCPrefix = "src/main/resources/dataCSV/";
    private final Logger log = LoggerHelper.getLogger(CommonMethods.class);
    public int SCREENHEIGHT = 1080;
    int ELEMENTWAITTIME = 80;
    private WebDriver driver;
    private JavaScriptHelper jsHelper;


    /**
     * This is constructor for this class
     *
     * @param driver
     */
    public CommonMethods(WebDriver driver) {
        PageFactory.initElements(driver, this);
        log.info("CommonMethods has been initialised.... ");
        wait = new WebDriverWait(driver, ELEMENTWAITTIME);
        jsHelper = new JavaScriptHelper(driver);
    }


    // wait for element to be visible and click
    public static WebElement getWhenVisible(By locator) {
        WebElement element = null;
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element;
    }

    public static void clickWhenReady(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public static List<WebElement> getAllWhenVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public static WebElement getWhenClickable(By locator) {
        WebElement element = null;
        element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        return element;
    }


    public void setBrand(String csvFilePath, String oldBrand, String newBrand) {

        try {

            BufferedReader reader = new BufferedReader(new FileReader(csvFilePath));
            String line = "", oldtext = "";
            while ((line = reader.readLine()) != null) {
                oldtext += line + "\r\n";
            }
            reader.close();
            // replace a TestBrand in the CSV
            String newtext = oldtext.replace(oldBrand, newBrand);

            FileWriter writer = new FileWriter(csvFilePath);
            writer.write(newtext);
            writer.close();
            log.info("Setting brand as " + newBrand);
        } catch (IOException ioe) {
            log.info("Setting brand is fail.");
            ioe.printStackTrace();
        }

    }


    public String generateProductCSV(String channelName) {

        String sourceFileName = CSVSRCPrefix + channelName + ".csv";
        String targetFileName = sourceFileName.replace(channelName, channelName + "_product");
        String line = "";
        File tF = new File(targetFileName);

        try {
            BufferedReader br = new BufferedReader(new FileReader(sourceFileName));

            Calendar current = Calendar.getInstance();
            SimpleDateFormat formatter = new SimpleDateFormat("HHmmddMMMYY");
            formatter.setTimeZone(TimeZone.getTimeZone("Australia/Sydney"));
            String currentTime = formatter.format(current.getTime());
            log.info("Product index is " + currentTime);
            FileWriter fw = new FileWriter(tF);

            if (!tF.exists()) {
                tF.createNewFile();
            }

            while ((line = br.readLine()) != null) {
                line = line.replace("shirt39", currentTime);
                //2nd replacement is for TheMarket channel because it needs unique EAN for every new product
                line = line.replace("T4925873489", currentTime);
                fw.write(line + "\r\n");
            }
            br.close();
            fw.close();
            log.info(channelName + " Product CSV file is generated.");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return tF.getAbsolutePath();
    }


}
