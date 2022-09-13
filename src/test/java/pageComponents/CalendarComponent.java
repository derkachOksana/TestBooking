package pageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class CalendarComponent {
    private final WebDriver driver;
    private WebDriverWait wait;
    private final Actions action;
    public CalendarComponent(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        action = new Actions(driver);
    }

    @FindBy (xpath = "//div[@class='bui-calendar__wrapper'][1]//tbody/tr/td")
    private List<WebElement> dateContainer;

    @FindBy (xpath = "//div[@class='bui-calendar__content']/div[1]/div")
    private WebElement monthYearField;

    @FindBy (xpath = "//div[@data-bui-ref = 'calendar-next']")
    private WebElement nextCalendarBtn;

    public void choseNeededMonthYear (String month, String year, Duration duration) {
        wait = new WebDriverWait(driver,duration);
        for (int i = 0; i <= 2; i++) {
            try {

                wait.until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//div[@class='bui-calendar__content']/div[1]/div")));
            } catch (Exception e) {

            }
        }
        for (int i = 0; i < 12; i ++) {
            String monthWithYear = monthYearField.getText();
            String[] parts = monthWithYear.split(" ");
            String resultMonth = parts[0];
            String resultYear = parts[1];
            if (resultMonth.equals(month) && resultYear.equals(year)) {
                break;
            }
            nextCalendarBtn.click();
        }
    }

    public void clickNeededDate (String date) {
        for (WebElement dateIndex: dateContainer) {
                if (dateIndex.getText().equals(date)) {
                    dateIndex.click();
                }
        }
    }
}


