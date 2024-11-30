package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class BrokersPage extends BasePage {

    private final By brokersInfoBox = By.cssSelector(".MuiCardContent-root.mui-style-q8glis");
    private final By brokersName = By.cssSelector(".MuiTypography-root.MuiTypography-h6.mui-style-fnahqf");
    private final By searchField = By.id("broker-keyword");
    private final By name = By.cssSelector(".MuiTypography-root.MuiTypography-h6.mui-style-fnahqf");
    private final By address = By.cssSelector(".MuiTypography-root.MuiTypography-textSmallRegular.mui-style-14x3no9");
    private final By numberOfProperties = By.xpath("//a[contains(text(), 'properties')]");
    private final By details = By.xpath("//button[text()='Details']");
    private final By department = By.xpath("//span[contains(text(), 'Department')]");
    private final By landlinePhoneNumber = By.xpath("//a[contains(text(), '+359')][1]");
    private final By mobilePhoneNumber = By.xpath("//a[contains(text(), '+359')][2]");
    private final By understoodButtonCookies = By.xpath("//button[text()='Understood']");

    public BrokersPage(WebDriver driver){
        super(driver);
    }

    public List<String> everyBrokerName() throws InterruptedException {
        Thread.sleep(5000);
        List<WebElement> elementsList = driver.findElements(brokersName);
        List<String> brokersNames = new ArrayList<>();

        for(int i = 0 ; i<elementsList.size() ; i++) {
            brokersNames.add(elementsList.get(i).getText());
        }

        return brokersNames;
    }

    public void searchForBroker(String brokerName){
        writeToField(searchField, brokerName);
    }

    public int getNumberOfBrokers(){
        List<WebElement> brokersInfo = driver.findElements(brokersInfoBox);
        return brokersInfo.size();
    }

    public String getBrokerName(){
        return driver.findElement(name).getText();
    }

    public boolean isAddressDisplayed(){
        return isElementDisplayed(address);
    }

    public boolean isNumberOfPropertiesDisplayed(){
        return isElementDisplayed(numberOfProperties);
    }

    public void clickDetails(){
        clickElement(details);
    }

    public boolean isLandlinePhoneNumberDisplayed(){
        return isElementDisplayed(landlinePhoneNumber);
    }

    public boolean isMobilePhoneNumberDisplayed(){
        return isElementDisplayed(mobilePhoneNumber);
    }

    public boolean isDepartmentDisplayed(){
        return isElementDisplayed(department);
    }

    public void acceptCookies(){
        clickElement(understoodButtonCookies);
    }
}