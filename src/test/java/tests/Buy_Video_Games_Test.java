package tests;

import static data_reader.Load_Properties.*;
import listeners.IRetryAnalyzer_Listener;
import listeners.ITestListener_Listener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.navigation_menu.Navigation_Menu_Actions;
import pages.shopping_cart_page.Shopping_Cart_Actions;
import pages.video_games_page.Video_Games_Actions;
import test_bases.TestBase;

/**
 * @author moham
 */
@Listeners({ITestListener_Listener.class})
public class Buy_Video_Games_Test extends TestBase {

    /****************************************OBJECTS_DECLARATIONS/INSTANTIATIONS**************************************/
    private Navigation_Menu_Actions nma;
    private Video_Games_Actions vga;
    private Shopping_Cart_Actions sca;

    /*******************************************TEST_DATA****************************************************/
    private final String max_Price = add_To_Cart_Data.getProperty("max_Price");

    /************************************************TEST_STEPS******************************************************/
    @Test(groups = {"Regression"},retryAnalyzer = IRetryAnalyzer_Listener.class)
    public void buy_Video_Game()
    {
        ITestListener_Listener.driver = driver;
        nma = new Navigation_Menu_Actions(driver);
        vga = new Video_Games_Actions(driver);
        sca = new Shopping_Cart_Actions(driver);

        nma.choose_English_Language();
        nma.open_All_Menu();
        nma.click_See_All();
        nma.click_Video_Games();
        nma.click_All_Video_Games();
        vga.filter_With_Free_Shipping();
        vga.filter_With_New_Condition();
        vga.open_Sort_Menu();
        vga.sort_High_To_Low();
        vga.add_Products_with_Price_Less_Than_Cap_Price(max_Price);
        vga.click_On_Cart();
        sca.validate_All_Products_Are_Added_To_Cart();
    }
}
