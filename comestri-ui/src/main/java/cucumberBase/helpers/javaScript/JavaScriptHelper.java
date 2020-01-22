package cucumberBase.helpers.javaScript;


import cucumberBase.helpers.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static cucumberBase.helpers.wait.WaitHelper.SCREENHEIGHT;

public class JavaScriptHelper {

    private WebDriver driver;

    private Logger log = LoggerHelper.getLogger(JavaScriptHelper.class);

    public JavaScriptHelper(WebDriver driver) {
        this.driver = driver;
        log.info("JavaScriptHelper has been initialised");
    }


    /**
     * This method will execute java script
     *
     * @param script
     * @return
     */
    public Object executeScript(String script) {
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        return exe.executeScript(script);
    }


    /**
     * This method will scroll till given pixel (e.g=1500)
     */
    public void scrollDownByPixel() {

        executeScript("window.scrollBy(0, 1080)");
    }


    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);", element);

    }

    public void scrollUpByPixel() {
        executeScript("window.scrollBy(0,-500)");
    }


    public void scrollByX() {
        String js = String.format("window.scrollTo(0, %s)", SCREENHEIGHT);
        ((JavascriptExecutor) driver).executeScript(js);
    }

    public void scrollByScreenHeight3x() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript(String.format("window.scrollBy(0,%s)", 0.3 * SCREENHEIGHT));
    }

    public void scrollByScreenHeightUp() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript(String.format("window.scrollBy(0, %s)", -SCREENHEIGHT));
    }
}
