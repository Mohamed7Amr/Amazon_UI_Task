package pages;

import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Set;

/**
 * @author MAmr
 * 1) This class is where I delacre object (WebDriver data-type) that will have the same value of the object created
 * in the TestBase.
 * 3) This class will have all the common methods that can be used by all Action Classes.
 */
public class Page_Base {

    /*****************************************OBJECTS_DECLARATIONS******************************************/
    protected WebDriver driver;
    private Actions action;
    private JavascriptExecutor js;
    private WebDriverWait wait;
    private Robot robot;

    /*****************************************CONSTRUCTORS*******************************************/
    public Page_Base(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /******************************************USER_ACTIONS**************************************/
    /**
     * 1) This method keeps checking for the element visibility for 5 seconds.
     * 2) If visible, the webpage will be scrolled to the target webElement, and will have background-color as green &
     * borders as black.
     * 3) try code; click on the element exactly as shown on the UI (if there's overlay, won't be clicked).
     * 4) catch code; Click on the element from the DOM, thus even if the element is covered by an overlay but already
     * exist in the DOM, then it will be clicked.
     * @param ele the target WebElement
     */
    protected void clickWebElement(WebElement ele)
    {
        try {
            wait_Element_Visibility(15,ele);
        }
        catch (Exception e) {
            wait_Invisible_Element(5,ele);
            System.out.println(ele.getAccessibleName() + ": is invisible ");
        }

        scrollTo_Highlight(ele, "green");

        try {
            ele.click();
        }
        catch (Exception e) {
            js_Click(ele);
            System.out.println("JS click has been used on: " + ele.getAccessibleName());
        }
    }

    /**
     * 1) This method keeps checking for the element visibility for 5 seconds.
     * 2) If visible, the webpage will be scrolled to the target webElement, and will have background-color as yellow &
     * borders as black.
     * 3) Send text to the Target WebElement.
     * @param ele the target WebElement
     * @param text the text that shall be written in the target webElement
     */
    protected void writeText(WebElement ele, String text)
    {
        wait_Element_Visibility(10, ele);
        scrollTo_Highlight(ele,"yellow");
        ele.sendKeys(text);
    }
    protected String getText(WebElement ele)
    {
        wait_Element_Visibility(10, ele);
        scrollTo_Highlight(ele,"yellow");
        try{
            return ele.getText();
        }
        catch (Exception e){
            return js_Get_Text(ele);
        }
    }
    protected void thread_Sleep(int seconds)
    {
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /****************************************NAVIGATION_ACTIONS*******************************************/
    public void reload()
    {
        driver.navigate().refresh();
    }

    /*****************************************WINDOWS_HANDLING*********************************************/
    protected String get_Window_Handle()
    {
        return driver.getWindowHandle();
    }
    protected Set<String> get_Windows_Handles()
    {
        return driver.getWindowHandles();
    }
    protected void switch_To_Window(String window_Handle)
    {
        driver.switchTo().window(window_Handle);
    }


    /*****************************************LOCATING_ELEMENTS********************************************/
    /**
     * It's better using locators as parameters with ExpectedCondition class to wait upon,
     * they are more stable than web-elements, and in this method you can send locators extracted
     * by different selectors to this method
     * @param locator it must have "By" data-type because it carries value of By.Selector(xpath,cssSelect,id,etc..)
     * @return web-element object of data-type "WebElement" to interact with.
     */
    protected WebElement find_Element(By locator)
    {
        try {
            return driver.findElement(wait_Locator_Visibility(locator));
        }
        catch (TimeoutException e)
        {
            e.printStackTrace();
            reload();
            return driver.findElement(wait_Locator_Visibility(locator));
        }
    }
    protected List<WebElement> find_Elements(By locator)
    {
        try {
            return driver.findElements(wait_Element_Presence(10,locator));
        }
        catch (TimeoutException e)
        {
            e.printStackTrace();
            reload();
            return driver.findElements(wait_Element_Presence(10,locator));
        }
    }
    /*****************************************ASSISTIVE_METHODS******************************************/
    protected void scrollTo_Highlight(WebElement ele, String color)
    {
        js_Scroll_View_Element_Center_With_Window(ele);
        js_Highlight_Element(ele,color);
    }

    /**
     * convert String DataType to Integer, then do a mathematical operation upon it, then convert it again
     * to String because I would like to write the data in a textBox.
     * @param data is the String data that must have numbers and been extracted from a web-element
     * @return String data of a number that had mathematical operation acted-upon
     */
    protected String do_Math_Operation_On_String(String data, char arithmetic_Operator, int amount)
    {
        return switch (arithmetic_Operator) {
            case '+' -> Integer.toString(Integer.parseInt(data) + amount);
            case '-' -> Integer.toString(Integer.parseInt(data) - amount);
            case '*' -> Integer.toString(Integer.parseInt(data) * amount);
            default -> "Invalid Mathematical operation";
        };
    }

    /******************************************ACTIONS_CLASS_METHODS*************************************/
    protected void hover_WebElement(WebElement ele)
    {
        action = new Actions(driver);
        action.moveToElement(ele).perform();
    }

    /******************************************JS_INJECTION*********************************************/
    protected void js_Click(WebElement ele)
    {
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].focus()", ele);
        js.executeScript("arguments[0].click()", ele);
    }

    protected void js_Write_Text(WebElement ele, String text)
    {
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].focus",ele);
        js.executeScript("arguments[0].innerText=" + text, ele);
    }
    protected String js_Get_Text(WebElement ele)
    {
        js = (JavascriptExecutor) driver;
        return (String)js.executeScript("return arguments[0].textContent;",ele);
    }
    protected void js_Highlight_Element(WebElement ele, String color)
    {
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.background = '"+ color + "'", ele);
        js.executeScript("arguments[0].style.border='2px solid red'", ele);
    }
    protected void js_Scroll_View_Element_Center_With_Window(WebElement ele)
    {
        js = (JavascriptExecutor) driver;

        Point coordinates = ele.getLocation();
        int x = coordinates.getX();
        int y = coordinates.getY();

        Dimension dims = driver.manage().window().getSize();
        int windowWidth = dims.getWidth();
        int windowHeight = dims.getHeight();

        js.executeScript("window.scrollTo(" + (x - windowWidth/2) + "," + (y - windowHeight/2) + ");");
    }
    protected void js_Scroll_View_Element_TopWindow(WebElement ele)
    {
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", ele);
    }

    /******************************************EXPLICIT_WAIT*********************************************/
    protected By wait_Element_Presence(int seconds, By ele)
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.presenceOfElementLocated(ele));
        return ele;
    }
    protected By wait_Locator_Visibility(By locator)
    {
        wait = new WebDriverWait(driver,Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return locator;
    }
    protected WebElement wait_Element_Visibility(int seconds, WebElement ele)
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOf(ele));
        return ele;
    }
    protected List<WebElement> wait_Elements_Visibility(int seconds, List<WebElement> eles)
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOfAllElements(eles));
        return eles;
    }
    protected void wait_Invisible_Element(int seconds, WebElement ele)
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.invisibilityOf(ele));
    }
    protected WebElement wait_Element_Clickable(int seconds, WebElement ele)
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.elementToBeClickable(ele));
        return ele;
    }

    protected void wait_Text_In_Element(int seconds, WebElement ele, String text)
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.textToBePresentInElement(ele, text));
    }

    /******************************************ROBOT_CLASS******************************************/
    /**
     * Method to select anything String (path,data) and then put it in the Windows-system's clipboard to be pasted later.
     * @param sth_To_Copy of String data-type
     */
    protected void copy_File_Inside_Project(String sth_To_Copy)
    {
        StringSelection selection = new StringSelection(sth_To_Copy);
        Clipboard system_Clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        system_Clipboard.setContents(selection,null);
    }
    @SneakyThrows
    protected void paste_Ctrl_V()
    {
        robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_V);
        robot.delay(2000);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        robot.delay(2000);
    }
    @SneakyThrows
    protected void press_Enter_Button()
    {
        robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    /******************************************COMMON_ASSERTIONS*************************************/
    protected void assert_Actual_Text_Contains_Expected_Text(WebElement ele1, WebElement ele2, String assertion_Message)
    {
        String expected_Result = getText(ele1);
        String actual_Result = getText(ele2);
        Assert.assertTrue(actual_Result.contains(expected_Result),assertion_Message);
    }
    protected void assert_Actual_Text_Contains_Expected_Text(String text, WebElement ele, String assertion_Message)
    {
        String actual_Result = getText(ele);
        Assert.assertTrue(actual_Result.contains(text),assertion_Message);
    }
    protected void assert_Actual_Text_contains_Expected_Text(By locator1, By locator2, String assertion_Message)
    {
        String expected_Result = getText(find_Element(locator1));
        String actual_Result = getText(find_Element(locator2));
        Assert.assertTrue(actual_Result.contains(expected_Result),assertion_Message);
    }
    protected void assert_Actual_Text_Contains_Expected_Text(String text, By locator, String assertion_Message)
    {
        String actual_Result = getText(find_Element(locator));
        Assert.assertTrue(actual_Result.contains(text),assertion_Message);
    }
    /******************************************STRING_REPLACEMENTS************************************/
    protected String replace_String_With_Regex(String to_Be_Replaced_Within, String regex, String replacement)
    {
        return to_Be_Replaced_Within.replaceAll(regex,replacement);
    }
    protected String replace_String_With_String(String to_Be_Replaced_Within, String to_Be_Replaced, String replacement)
    {
        return to_Be_Replaced_Within.replace(to_Be_Replaced,replacement);
    }

    /******************************************DATA_TYPES_CONVERSIONS********************************/
    protected int convert_String_To_Integer(String data)
    {
        return Integer.parseInt(data);
    }
    protected double convert_String_To_Double(String data)
    {
        return Double.parseDouble(data);
    }

    /******************************************KEYS_CLASS****************************************/
    protected void press_Enter_On(WebElement ele)
    {
        ele.sendKeys(Keys.ENTER);
    }

    /******************************************SCREENSHOT_INTERFACE***************************************/
    @SneakyThrows
    public void take_ScreenShot(String pass_Fail_Dir, String ssName_Extension) {
        TakesScreenshot ss = (TakesScreenshot) driver;
        File sourceFile = ss.getScreenshotAs(OutputType.FILE);
        File targetFile = new File("Screenshots/"+ pass_Fail_Dir + ssName_Extension);
        FileUtils.copyFile(sourceFile,targetFile);
    }

}
