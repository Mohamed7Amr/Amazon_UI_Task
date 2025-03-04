package pages.navigation_menu;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class Navigation_Menu_Actions extends Navigation_Menu_WebElements{

    /*****************************************CONSTRUCTORS*******************************************/
    public Navigation_Menu_Actions(WebDriver driver) {
        super(driver);
    }

    /****************************************ACTIONS*************************************************/
    @Step("Choose English button")
    public void choose_English_Language()
    {
        hover_WebElement(find_Element(localization_Btn_Locator));
        clickWebElement(find_Element(english_Option_Locator));
        thread_Sleep(3000);
    }
    @Step("Open \"All\" menu")
    public void open_All_Menu()
    {
        clickWebElement(all_Menu_DDL);
    }
    @Step("Click \"see all\" list item")
    public void click_See_All()
    {
        clickWebElement(see_All_Li);
    }
    @Step("Click \"video games\" list item")
    public void click_Video_Games()
    {
        clickWebElement(video_Games_Li);
    }
    @Step("Click \"all video game\" list item")
    public void click_All_Video_Games()
    {
        js_Click(all_Video_Games_Li);
    }
}
