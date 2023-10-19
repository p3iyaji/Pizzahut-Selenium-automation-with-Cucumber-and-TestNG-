package pageObjects;

import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DealsPage {

	WebDriver driver;

	public DealsPage(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//input[@name='toggle-button-0'][1]")
	private WebElement btn_vegetarian;

	@FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div[1]/div[1]/div[3]/div[1]/div/a[2]")
	private WebElement pizzaMenu;

	@FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div[1]/div[1]/div[3]/div[2]/div[2]/span/div[1]/a[1]/div[3]/div/button/span[1]/span")
	private WebElement btn_add;

	@FindBy(how = How.XPATH, using = "//button[contains(@class,'justify-between')]//span[contains(@class,'bg-green-dark pl-5 pr-5 rounded')]")
	private WebElement basketItemCount;

	@FindBy(how = How.XPATH, using = "//span[contains(@class,'subtotal')]")
	private WebElement subTotal;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'₹11.70')]")
	private WebElement totalTax;

	@FindBy(how = How.XPATH, using = "//span[@class='amountdue']")
	private WebElement totalBasketPrice;

	@FindBy(how = How.XPATH, using = "//button[contains(@class,'justify-between')]/child::span/child::span")
	private WebElement itemCount;

	@FindBy(how = How.XPATH, using = "//button[contains(@class,'justify-between')]//span[contains(@class,'absolute inset-0 flex-center')]")
	private WebElement btn_checkout;

	@FindBy(how = How.XPATH, using = "//h3[contains(@class,'typography-2 mt-30')]//span[contains(text(),'You')]")
	private WebElement checkoutMessage;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Continue Shopping')]")
	private WebElement continueShopping;

	@FindBy(how = How.XPATH, using = "//a[contains(@class,'capitalize lg:border-r')]//span[contains(text(),'Drinks')]")
	private WebElement drinksMenu;

	@FindBy(how = How.XPATH, using = "//body/div[@id='app']/div[contains(@class,'app en-IN app-bg')]/div[contains(@class,'order')]/div[contains(@class,'basket-placeholder')]/div[contains(@class,'flex lg:flex-col')]/div[contains(@class,'w-full side-menu-placeholder md:pt-60 lg:pt-0')]/div[contains(@class,'container md:pt-5')]/span[contains(@data-testid,'drinks')]/div[contains(@class,'sc-fznXWL eMYOOu product-grid')]/a[1]/div[3]/div[1]/button[1]/span[1]")
	private WebElement pepsiOption;

	@FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div[1]/div[2]/div/div[2]/div[3]/div/div/div/a/span[1]/span")
	private WebElement verifyItemcount;

	@FindBy(how = How.XPATH, using = "//span[@class='amountdue']")
	private WebElement amountDue;

	@FindBy(how = How.XPATH, using = "//button[@data-synth='basket-item-remove--pepsi-600ml']")
	private WebElement btn_removePepsi;

	@FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div[1]/div[2]/div/div[2]/div[3]/div[2]/div/div/button/span[1]/span")
	private WebElement newItemCount;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Checkout')]")
	private WebElement final_checkout;

	@FindBy(how = How.XPATH, using = "//h3[contains(@class,'typography-2 mt-30')]//span[contains(text(),'You')]")
	private WebElement minimumOrderPopup;

	public boolean verifyDealsPage() {
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.pizzahut.co.in/order/deals/";
		if (currentUrl == expectedUrl) {
			System.out.println("We are on the Deals page");
		}
		return true;
	}

	public boolean verifyVegetarianBtnDisabled() {

		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (!btn_vegetarian.isEnabled()) {
			System.out.println("The vegetarian radio button is disabled");
		}
		return true;
	}

	public void selectPizzaMenu() {
		pizzaMenu.click();
	}

	public void addPizza() {
		btn_add.click();
	}

	public boolean basketItemVisible() {
		String itemCount = basketItemCount.getText();
		if (basketItemCount.isDisplayed()) {
			System.out.println(itemCount + "is Present");
		}
		return true;

	}

	public boolean confirmTotalBasketPrice() {

		String itemCost = subTotal.getText();
		String itemC = itemCost.replaceAll("[₹,]", "");
		String tax = totalTax.getText();
		String taxC = tax.replaceAll("[₹,]", "");
		String basketPrice = totalBasketPrice.getText();
		String basketC = basketPrice.replaceAll("[₹,]", "");

		double costAmount = Double.parseDouble(itemC);
		double taxAmount = Double.parseDouble(taxC);

		double basketAmount = Double.parseDouble(basketC);

		if ((costAmount + taxAmount) == basketAmount) {
			System.out.println("The checkout price is correct");
		} else {
			System.out.println("The Checkout price is not correct");
		}

		return true;
	}

	public boolean confirmItemCountVisible() {
		String iCount = itemCount.getText();
		if (!iCount.isEmpty()) {
			System.out.println("Item count is present");
		} else {
			System.out.println("Item count is not present");
		}
		return true;

	}

	public void confirmCheckoutBtnCount() {
		btn_checkout.click();
		checkoutMessage.isDisplayed();
	}

	public void drinksOption() {
		continueShopping.click();
		drinksMenu.click();
	}

	public void addPepsi() {
		pepsiOption.click();
	}

	public boolean verifyItemCount() {
		String iCount = verifyItemcount.getText();
		String expectedIcount = "2 1tems";
		if (iCount == expectedIcount) {
			System.out.println("Item count is correct");
		} else {
			System.out.println("Item count is wrong");
		}
		return true;
	}

	public boolean verifyCheckoutprice() {
		String newPrice = amountDue.getText();
		String checkoutAmount = newPrice.replaceAll("[₹,]", "");
		double newPrice2 = Double.parseDouble(checkoutAmount);

		String basketPrice = totalBasketPrice.getText();
		String basketC = basketPrice.replaceAll("[₹,]", "");

		double basketAmount = Double.parseDouble(basketC);
		if (newPrice2 > basketAmount) {
			System.out.println("new checkout price is greater than old checkout price");
		} else {
			System.out.println("new checkout price is not greater than old checkout price");
		}

		return true;

	}

	public void removePepsiFromBasket() {
		btn_removePepsi.click();
	}

	public boolean noCheckoutBtnPrice() {
		boolean exists = false;
		try {
			driver.getPageSource().contains("basket-value");
			exists = true;
		} catch (NoSuchElementException e) {
			System.out.println("No Checkout Button Price");
			exists = false;
		}
		return exists;
	}

	@Test
	public void newItemCountisVisible() {
		String itemCount2 = newItemCount.getText();
		String expectedItemCount = "1 item";
		Assert.assertEquals(itemCount2, expectedItemCount);
	}

	public void clickCheckout() {
		final_checkout.click();
	}

	public void verifyMinimumOrderPopup() {
		minimumOrderPopup.isDisplayed();
	}

}
