package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.HotelPage;
import utility.ConfProperties;

import java.time.Duration;

public class VerifyDestinationTownTest extends BaseTest{
    public HomePage homePage;
    public HotelPage hotelPage;
    private final String nameTown = "New York";
    private final String month = "December";
    private final String dateStart = "1";
    private final String dateFinish = "31";
    private final String year = "2022";
    private final Duration duration = Duration.ofSeconds(Integer.parseInt(ConfProperties.getProperty("duration")));

    @BeforeClass
    public void preconditions() {
        homePage = new HomePage(driver);
        hotelPage = new HotelPage(driver);
    }

    @Test
    public void verifyDestinationTown () {
        homePage.clickDestinationTownBtn();
        homePage.chooseDestinationTown(nameTown);
        homePage.clickCheckInBtn();
        homePage.calendarComponent.choseNeededMonthYear(month, year, duration);
        homePage.calendarComponent.clickNeededDate(dateStart);
        homePage.calendarComponent.choseNeededMonthYear(month, year, duration);
        homePage.calendarComponent.clickNeededDate(dateFinish);
        homePage.clickSearchBtn();
        boolean neededTown_actual = hotelPage.neededTown(nameTown);
        Assert.assertTrue(neededTown_actual, "The town is wrong");
    }
}
