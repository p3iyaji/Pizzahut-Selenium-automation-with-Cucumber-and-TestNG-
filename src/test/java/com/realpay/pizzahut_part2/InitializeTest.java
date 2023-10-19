package com.realpay.pizzahut_part2;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.PizzahutTestngPOM;
import util.ReadExcelData;

public class InitializeTest {

	WebDriver driver;

	@BeforeSuite
	public void setUp() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test(dataProvider = "getTestData", priority = 0)
	public void myTest(String browser, String url) {
		driver.get(url);

	}

	@Test(priority = 1)
	public void closeBlackScreen() {
		PizzahutTestngPOM pizza = new PizzahutTestngPOM(driver);

		Assert.assertTrue(pizza.blackScreen().isDisplayed());
		pizza.closeBS();

	}

	@Test(priority = 2)
	public void enterLocation() {

		PizzahutTestngPOM pizza = new PizzahutTestngPOM(driver);
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		pizza.location();

	}

	@Test(priority = 3)
	public void urlContainsDeals() {

		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String newUrl = driver.getCurrentUrl();
		System.out.println(newUrl);
		Assert.assertTrue(newUrl.contains("deals"));

	}

	@Test(priority = 4)
	public void addItemToCart() {

		PizzahutTestngPOM pizza = new PizzahutTestngPOM(driver);

		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		pizza.enterProductBelow200();
	}

	@Test(priority = 5)
	public void verifyItemAddedtoBasket() {

		PizzahutTestngPOM pizza = new PizzahutTestngPOM(driver);

		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertTrue(pizza.basketItemVisible().isDisplayed());
	}

	@Test(priority = 6)
	public void drinksMenu() {

		PizzahutTestngPOM pizza = new PizzahutTestngPOM(driver);

		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		pizza.drinksMenu();
	}

	@Test(priority = 7)
	public void addTwoDrinksToBasket() {

		PizzahutTestngPOM pizza = new PizzahutTestngPOM(driver);

		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		pizza.addTwoDrinkstoBasket();

	}

	@Test(priority = 8)
	public void checkout() {

		PizzahutTestngPOM pizza = new PizzahutTestngPOM(driver);
		pizza.checkout();

		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.pizzahut.co.in/order/checkout/";
		Assert.assertEquals(actualUrl, expectedUrl);

	}

	@Test(priority = 9)
	public void verifyOnlinePaymentOption() {

		PizzahutTestngPOM pizza = new PizzahutTestngPOM(driver);

		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertTrue(pizza.radioButton().isDisplayed());

	}

	@Test(priority = 10)
	public void selectCashOption() {

		PizzahutTestngPOM pizza = new PizzahutTestngPOM(driver);
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		pizza.selectCashOption();

	}

	@Test(priority = 11)
	public void verifyPromoOptionSelected() {

		PizzahutTestngPOM pizza = new PizzahutTestngPOM(driver);
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertTrue(pizza.promoOption().isSelected());

	}

	@Test(priority = 12)
	public void enterCheckoutDetails() {

		PizzahutTestngPOM pizza = new PizzahutTestngPOM(driver);
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		pizza.checkoutDetails();

	}

	@Test(priority = 13)
	public void applyGiftCard() {

		PizzahutTestngPOM pizza = new PizzahutTestngPOM(driver);
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		pizza.applyGiftCard();

	}

	@Test(priority = 14)
	public void enterVoucher() {

		PizzahutTestngPOM pizza = new PizzahutTestngPOM(driver);
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		pizza.voucher();

	}

	@Test(priority = 15)
	public void giftCardSubmit() {

		PizzahutTestngPOM pizza = new PizzahutTestngPOM(driver);
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		pizza.giftCardSubmit();

	}

	@Test(priority = 16)
	public void verifyErrorMessage() {

		PizzahutTestngPOM pizza = new PizzahutTestngPOM(driver);
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertTrue(pizza.errorMessage().isDisplayed());

	}

	@Test(priority = 17)
	public void closePopupWindow() {

		PizzahutTestngPOM pizza = new PizzahutTestngPOM(driver);
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		pizza.closePopup();

	}

	@Test(priority = 18)
	public void verifyUserReturnToBasketPage() {

		PizzahutTestngPOM pizza = new PizzahutTestngPOM(driver);
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertTrue(pizza.backToBasket().isDisplayed());

	}

	@AfterSuite
	public void tearDown() {
		// driver.quit();
	}

	@DataProvider(name = "getTestData")
	public Object[][] getData() {

		ReadExcelData rb = new ReadExcelData();

		String[][] data = new String[][] { { rb.readExcelData("0,2,1"), rb.readExcelData("0,2,2") }

		};
		return data;

	}

}
