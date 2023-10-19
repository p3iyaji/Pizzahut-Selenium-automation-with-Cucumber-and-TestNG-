package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//span[contains(text(), 'Sorry, we are not currently')]")
	private WebElement blackScreenPageConfirm;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Close')]")
	private WebElement btn_closeBlackScreen;

	@FindBy(how = How.XPATH, using = "//span[contains(text(), 'Enter your address to see your local deals, coupons and offers.')]")
	private WebElement deliveryPageText;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Enter your location for delivery']")
	private WebElement myLocation;

	@FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div[4]/div/div/div/div[2]/form/div/div[2]/div/button[2]/div[2]/div[1]")
	private WebElement firstOption;

	public void confirmBlackScreenOpen() {
		blackScreenPageConfirm.isDisplayed();
	}

	public void closeBlackScreen() {
		btn_closeBlackScreen.click();
	}

	public void deliveryPopup() {
		deliveryPageText.isDisplayed();
	}

	public void enterLocation(String location) {
		myLocation.sendKeys(location);
	}

	public void selectFirstOption() {
		Actions actions = new Actions(driver);
		actions.moveToElement(firstOption).click().perform();
	}

}
