package tests;

//import static dataReader.LoadProperties.*;

import listeners.IRetryAnalyzer_Listener;
import listeners.ITestListener_Listener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.add_address_page.AddAddressPage;
import pages.checkout_page.CheckoutPage;
import pages.login_page.LoginPage;
import pages.navigation_menu.Navigation_Menu_Actions;
import pages.shopping_cart_page.ShoppingCartPage;
import pages.shopping_cart_page.Shopping_Cart_Actions;
import pages.video_games_page.VideoGamesPage;
import pages.video_games_page.Video_Games_Actions;
import testBases.TestBase;

/**
 * @author moham
 */
@Listeners({ITestListener_Listener.class})
public class Buy_Video_Games_Test extends TestBase {

    /****************************************OBJECTS_DECLARATIONS/INSTANTIATIONS**************************************/
    private Navigation_Menu_Actions nma;
    private LoginPage lp;
    private Video_Games_Actions vga;
    private Shopping_Cart_Actions sca;
    private AddAddressPage aap;
    private CheckoutPage cp;

    /*******************************************TEST_DATA****************************************************/
//    private String username = userTestData.getProperty("username");
//    private String password = userTestData.getProperty("password");

    /************************************************TEST_STEPS******************************************************/
    @Test()//retryAnalyzer = IRetryAnalyzer_Listener.class)
    public void buy_Video_Game()
    {
        ITestListener_Listener.driver = driver;
        nma = new Navigation_Menu_Actions(driver);
        lp = new LoginPage(driver);
        vga = new Video_Games_Actions(driver);
        sca = new Shopping_Cart_Actions(driver);
        aap = new AddAddressPage(driver);
        cp = new CheckoutPage(driver);

        nma.choose_English_Language();
        nma.open_All_Menu();
        nma.click_See_All();
        nma.click_Video_Games();
        nma.click_All_Video_Games();
        vga.filter_With_Free_Shipping();
        vga.filter_With_New_Condition();
        vga.open_Sort_Menu();
        vga.sort_High_To_Low();
        vga.add_Products_with_Price_Less_Than_Cap_Price(15000);

//        vgp.videoGamesScreenConfirmation();
//        vgp.chooseFreeShipping();
//        vgp.chooseNewCondition();
//        vgp.sortPriceHighLow();
//        vgp.addToCart();
//        vgp.goToCart();
//        scp.confirmSubtotal();
//        scp.proceedToBuy();
//        lp.login(username, password);
//        aap.shippingAddressDetailsDisplay();
//        aap.insertFullName(name);
//        aap.insertMobileNumber(mobile);
//        aap.insertStreetName(street);
//        aap.insertBuildingNumber(building);
//        aap.selectCity(cityName);
//        aap.selectDistrict(districtName);
//        aap.addLandmark(landmarkName);
//        aap.chooseAddressType();
//        aap.addAddressToDelivery();
//        cp.compareTotalAmount();
    }
}
