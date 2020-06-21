package pageSteps;

import io.cucumber.java.en.When;
import pages.MainPage;
import utils.DriverSettings;

public class MainPageSteps {
	MainPage mp = new MainPage();

	@When("Перейдите на сервис {string}")
	public void goToPage(String page) {
		DriverSettings.getDriver().get(page);
	}

	@When("Выполните поиск по {string}")
	public void findItem(String itemName) {
		mp.clickToPlaceholder().fillField(itemName);
	}
}
