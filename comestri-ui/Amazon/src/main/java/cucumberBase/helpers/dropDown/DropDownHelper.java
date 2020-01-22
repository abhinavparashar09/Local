package cucumberBase.helpers.dropDown;


import cucumberBase.helpers.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.LinkedList;
import java.util.List;

public class DropDownHelper {

    public WebDriver driver;
    private Logger log = LoggerHelper.getLogger(DropDownHelper.class);

    /**
     * This is constructor of dropdownhelper class
     */
    public DropDownHelper(WebDriver driver) {
        this.driver = driver;
        log.info("Dropdown Helper object has been created....");

    }

    /**
     * This method can be used to SELECT dropdown item using VALUE
     *
     * @param element
     * @param value
     */
    public void selectUsingValue(WebElement element, String value) {
        Select select = new Select(element);
        log.info("selectUsingValue and value is: " + value);
        select.selectByValue(value);
    }

    /**
     * This method can be used to SELECT dropdown item using INDEX
     *
     * @param element
     * @param index
     */
    public void selectUsingIndex(WebElement element, int index) {
        Select select = new Select(element);
        log.info("selectUsingIndex and index is: " + index);
        select.selectByIndex(index);
    }

    /**
     * This method can be used to SELECT dropdown item using VISIBLE TEXT
     *
     * @param element
     * @param visibleText
     */
    public void selectUsingVisibleText(WebElement element, String visibleText) {
        Select select = new Select(element);
        log.info("selectUsingVisibleText and visibleText is: " + visibleText);
        select.selectByVisibleText(visibleText);
    }


    /**
     * This method can be used to get all the values/items from dropdown
     *
     * @param element
     * @return
     */
    public List<String> getAllDropDown(WebElement element) {
        Select select = new Select(element);
        List<WebElement> elementList = select.getOptions();
        List<String> valueList = new LinkedList<String>();
        for (WebElement ele : elementList) {
            log.info(ele.getText());
            valueList.add(ele.getText());
        }
        return valueList;
    }


    /**
     * This method can be used to DESELECT dropdown item using VALUE
     *
     * @param element
     * @param value
     */
    public void deSelectUsingValue(WebElement element, String value) {
        Select select = new Select(element);
        log.info("deSelectUsingValue and value is: " + value);
        select.deselectByValue(value);
    }

    /**
     * This method can be used to DESELECT dropdown item using INDEX
     *
     * @param element
     * @param index
     */
    public void deSelectUsingIndex(WebElement element, int index) {
        Select select = new Select(element);
        log.info("deSelectUsingIndex and index is: " + index);
        select.deselectByIndex(index);
    }

    public void deSelectUsingVisibleText(WebElement element, String visibleText) {
        Select select = new Select(element);
        log.info("deselectByVisibleText and visibleText is: " + visibleText);
        select.deselectByVisibleText(visibleText);
    }


}
