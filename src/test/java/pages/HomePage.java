package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageComponents.CalendarComponent;

import java.time.Duration;

public class HomePage {

    private final WebDriver driver;
    private WebDriverWait wait;
    public final CalendarComponent calendarComponent;

    public HomePage(WebDriver driver)   {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        calendarComponent = new CalendarComponent(driver);
    }
    @FindBy (xpath = "//span[text() = 'Type your destination']/following-sibling::input")
    private WebElement destinationTownField;

    @FindBy (xpath = "//div[@data-mode = 'checkin']")
    private WebElement checkInBtn;

    @FindBy (xpath = "//div[@data-placeholder = 'Check-out']")
    private WebElement checkOutBtn;

    @FindBy (xpath = "//button[@data-sb-id='main']")
    private WebElement searchBtn;

    public void clickDestinationTownBtn () {
        destinationTownField.click();
    }

    public void chooseDestinationTown (String nameTown) {
        destinationTownField.sendKeys(nameTown);
    }

    public void clickSearchBtn () {
        searchBtn.click();
    }

    public void clickCheckInBtn () {
        checkInBtn.click();
    }
}
