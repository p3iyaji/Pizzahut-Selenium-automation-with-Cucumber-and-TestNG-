package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PizzahutTestngPOM {

	WebDriver driver;

	@FindBy(how = How.XPATH, using = "//span[contains(text(), 'Sorry, we are not currently')]")
	private WebElement blackScreenPageConfirm;
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Close')]")
	private WebElement btn_closeBlackScreen;
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Enter your location for delivery']")
	private WebElement myLocation;
	@FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div[4]/div/div/div/div[2]/form/div/div[2]/div/button[2]/div[2]/div[1]")
	private WebElement firstOption;
	@FindBy(how = How.XPATH, using = "//a[contains(@class,'capitalize lg:border-r')]//span[contains(text(),'Sides')]")
	private WebElement sidesMenu;
	@FindBy(how = How.XPATH, using = "//body/div[@id='app']/div[contains(@class,'app en-IN app-bg')]/div[contains(@class,'order')]/div[contains(@class,'basket-placeholder')]/div[contains(@class,'flex lg:flex-col')]/div[contains(@class,'w-full side-menu-placeholder md:pt-60 lg:pt-0')]/div[contains(@class,'container md:pt-5')]/span[contains(@data-testid,'sides')]/div[contains(@class,'sc-fznXWL eMYOOu product-grid')]/a[1]/div[3]/div[1]/button[1]/span[1]")
	private WebElement productSelect;
	@FindBy(how = How.XPATH, using = "//button[contains(@class,'justify-between')]//span[contains(@class,'bg-green-dark pl-5 pr-5 rounded')]")
	private WebElement basketItemCount;
	@FindBy(how = How.XPATH, using = "//a[contains(@class,'capitalize lg:border-r')]//span[contains(text(),'Drinks')]")
	private WebElement drinksMenu;
	@FindBy(how = How.XPATH, using = "//body/div[@id='app']/div[@class='app en-IN app-bg']/div[@class='order']/div[@class='basket-placeholder']/div[@class='flex lg:flex-col']/div[@class='w-full side-menu-placeholder md:pt-60 lg:pt-0']/div[@class='container md:pt-5']/span[@data-testid='drinks']/div[@class='sc-fznXWL eMYOOu product-grid']/a[1]/div[3]/div[1]/button[1]/span[1]")
	private WebElement firstDrink;
	@FindBy(how = How.XPATH, using = "//body/div[@id='app']/div[@class='app en-IN app-bg']/div[@class='order']/div[@class='basket-placeholder']/div[@class='flex lg:flex-col']/div[@class='w-full side-menu-placeholder md:pt-60 lg:pt-0']/div[@class='container md:pt-5']/span[@data-testid='drinks']/div[@class='sc-fznXWL eMYOOu product-grid']/a[2]/div[3]/div[1]/button[1]/span[1]")
	private WebElement secondDrink;
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Checkout')]")
	private WebElement btn_checkout;
	@FindBy(how = How.XPATH, using = "//label[@for='payment-method--razorpay']//i[@class='mt-4']")
	private WebElement radio_btn;
	@FindBy(how = How.XPATH, using = "//label[@for='payment-method--cash']")
	private WebElement cash_btn;
	@FindBy(how = How.XPATH, using = "//input[@id='marketingOptIn']")
	private WebElement promo;
	@FindBy(how = How.XPATH, using = "//input[@id='checkout__name']")
	private WebElement checkout_name;
	@FindBy(how = How.XPATH, using = "//input[@id='checkout__phone']")
	private WebElement checkout_mobile;
	@FindBy(how = How.XPATH, using = "//input[@id='checkout__email']")
	private WebElement checkout_email;
	@FindBy(how = How.XPATH, using = "//span[normalize-space()='Apply Gift Card']")
	private WebElement giftCard;
	@FindBy(how = How.XPATH, using = "//span[normalize-space()='Coupon']")
	private WebElement coupon;
	@FindBy(how = How.XPATH, using = "//input[@placeholder='e.g. ABC1234']")
	private WebElement voucher;
	@FindBy(how = How.XPATH, using = "//span[normalize-space()='Apply']")
	private WebElement btn_apply_giftcard;
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Sorry, we don’t currently support that coupon code')]")
	private WebElement error_message;
	@FindBy(how = How.XPATH, using = "//button[@class='icon-remove-3 absolute top-0 right-0 mr-20 mt-20']")
	private WebElement close_popup;
	@FindBy(how = How.XPATH, using = "//span[normalize-space()='Your Basket']")
	private WebElement basket;

	public PizzahutTestngPOM(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement blackScreen() {
		return blackScreenPageConfirm;
	}

	public void closeBS() {
		btn_closeBlackScreen.click();
	}

	public void location() {
		myLocation.sendKeys("LuLu Mall Hyderabad");
		firstOption.click();
	}

	public void enterProductBelow200() {
		sidesMenu.click();
		productSelect.click();
	}

	public WebElement basketItemVisible() {
		return basketItemCount;
	}

	public void drinksMenu() {
		drinksMenu.click();
	}

	public void addTwoDrinkstoBasket() {
		firstDrink.click();
		secondDrink.click();
	}

	public void checkout() {
		btn_checkout.click();
	}

	public WebElement radioButton() {
		return radio_btn;
	}

	public void selectCashOption() {
		cash_btn.click();
	}

	public WebElement promoOption() {
		return promo;
	}

	public void checkoutDetails() {
		checkout_name.sendKeys("Paul Iyaji");
		checkout_mobile.sendKeys("0785995949");
		checkout_email.sendKeys("pauliyaji@xyz.com");
	}

	public void applyGiftCard() {
		giftCard.click();
	}

	public void voucher() {
		coupon.click();
		voucher.sendKeys("12345");
	}

	public void giftCardSubmit() {
		btn_apply_giftcard.click();
	}

	public WebElement errorMessage() {
		return error_message;
	}

	public void closePopup() {
		close_popup.click();
	}

	public WebElement backToBasket() {
		return basket;
	}

}
