package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HotelPage {
    private final WebDriver driver;
    public HotelPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy (xpath = "//span[@data-testid='address']")
    private List<WebElement> listLocationHotel;

    public boolean neededTown (String nameTown) {
        for (WebElement location: listLocationHotel) {
            String locationHotelText = location.getText();
            String[] parts = locationHotelText.split(", ");
            String part1 = parts[0];
            String part2 = parts[1];
            if (part2.equals(nameTown)) {
                continue;
            }
            else {
                return false;
            }
        }
        return true;
    }
}
