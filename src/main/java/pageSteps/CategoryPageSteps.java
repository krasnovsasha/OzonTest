package pageSteps;


import io.cucumber.java.en.When;
import pages.CategoryPage;

public class CategoryPageSteps {

	CategoryPage cp = new CategoryPage();

	@When("Ограничить цену до {string}")
	public void choosePrice(String string) {
		cp.waitLeftMenuClickable()
				.choosePrice(string);

	}
	@When("Отметить чекбокс – {string}")
	public void clickCheckBox(String string) {
			cp.clickCheckbox(string);
	}

	@When("Из результатов поиска добавьте в корзину первые {int} нечетных товаров")
	public void addItemToBasket(Integer count) {
		cp.waitResultFormClickable();
		cp.addItemsToCart(count);
	}
//	@When("Запомнить название товаров")
//	public void запомнить_название_товаров() {
//		// Write code here that turns the phrase above into concrete actions
//
//	}

	@When("Перейдите в корзину, убедитесь, что все добавленные ранее товары находятся в корзине")
	public void goToCart() {
		cp.cart.click();
	}
}
