package StepDefs;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.DealsPage;
import pageObjects.HomePage;

public class StepDefinition {

	WebDriver driver;
	HomePage home;
	DealsPage deal;

	@Given("User launch Pizzahut application with {string}")
	public void user_launch_pizzahut_application_with(String URL) {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(URL);

	}

	@When("User wait for auto location black pop up screen")
	public void user_wait_for_auto_location_black_pop_up_screen() {
		try {
			Thread.sleep(2000);
			home = new HomePage(driver);
			home.confirmBlackScreenOpen();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Then("User close the pop up screen")
	public void user_close_the_pop_up_screen() {
		home = new HomePage(driver);

		home.closeBlackScreen();
	}

	@Then("User see pop up for delivery asking for enter location")
	public void user_see_pop_up_for_delivery_asking_for_enter_location() {
		home = new HomePage(driver);
		home.deliveryPopup();
	}

	@Then("User type address as {string}")
	public void user_type_address_as(String Location) {
		home = new HomePage(driver);
		home.enterLocation(Location);
	}

	@Then("User select first auto populate drop down option")
	public void user_select_first_auto_populate_drop_down_option() {
		home = new HomePage(driver);
		home.selectFirstOption();
	}

	@When("User navigate to deails page")
	public void user_navigate_to_deails_page() {
		deal = new DealsPage(driver);
		deal.verifyDealsPage();
	}

	@Then("User validate vegetarian radio button flag is off")
	public void user_validate_vegetarian_radio_button_flag_is_off() {
		deal = new DealsPage(driver);
		deal.verifyVegetarianBtnDisabled();
	}

	@Then("User clicks on Pizzas menu bar option")
	public void user_clicks_on_pizzas_menu_bar_option() {
		deal = new DealsPage(driver);
		deal.selectPizzaMenu();
	}

	@When("User select add button of any pizza from Recommended")
	public void user_select_add_button_of_any_pizza_from_recommended() {
		deal = new DealsPage(driver);
		deal.addPizza();
	}

	@Then("User see that the pizza is getting added under Your Basket")
	public void user_see_that_the_pizza_is_getting_added_under_your_basket() {
		deal = new DealsPage(driver);
		deal.basketItemVisible();
	}

	@Then("User validate pizza price plus Tax is checkout price")
	public void user_validate_pizza_price_plus_tax_is_checkout_price() {
		deal = new DealsPage(driver);
		deal.confirmTotalBasketPrice();
	}

	@Then("User validate checkout button contains Item count")
	public void user_validate_checkout_button_contains_item_count() {
		deal = new DealsPage(driver);
		deal.confirmItemCountVisible();
	}

	@Then("User validate checkout button contains total price count")
	public void user_validate_checkout_button_contains_total_price_count() {
		deal = new DealsPage(driver);
		deal.confirmCheckoutBtnCount();
	}

	@Then("User clicks on Drinks option")
	public void user_clicks_on_drinks_option() {
		deal = new DealsPage(driver);
		deal.drinksOption();
	}

	@Then("User select Pepsi option to add into the Basket")
	public void user_select_pepsi_option_to_add_into_the_basket() {
		deal = new DealsPage(driver);
		deal.addPepsi();
	}

	@Then("User see {int} items are showing under checkout button")
	public void user_see_items_are_showing_under_checkout_button(Integer int1) {
		deal = new DealsPage(driver);
		deal.verifyItemCount();
	}

	@Then("User see total price is now more than before")
	public void user_see_total_price_is_now_more_than_before() {
		deal = new DealsPage(driver);
		deal.verifyCheckoutprice();
	}

	@Then("User remove the Pizza item from Basket")
	public void user_remove_the_pizza_item_from_basket() {
		deal = new DealsPage(driver);
		deal.removePepsiFromBasket();
	}

	@Then("see Price tag got removed from the checkout button")
	public void see_price_tag_got_removed_from_the_checkout_button() {
		deal = new DealsPage(driver);
		deal.noCheckoutBtnPrice();
	}

	@Then("User see {int} item showing in checkout button")
	public void user_see_item_showing_in_checkout_button(Integer int1) {
		deal = new DealsPage(driver);
		deal.newItemCountisVisible();
	}

	@Then("User Clicks on Checkout button")
	public void user_clicks_on_checkout_button() {
		deal = new DealsPage(driver);
		deal.clickCheckout();
	}

	@Then("User see minimum order required pop up is getting displayed")
	public void user_see_minimum_order_required_pop_up_is_getting_displayed() {
		deal = new DealsPage(driver);
	}

}
