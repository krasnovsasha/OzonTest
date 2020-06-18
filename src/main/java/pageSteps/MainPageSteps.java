package pageSteps;

import io.cucumber.java.en.When;
import utils.DriverSettings;

public class MainPageSteps {
	@When("Перейдите на сервис {string}")
	public void goToPage(String page) {
		DriverSettings.getDriver().get(page);

	}
//
//	@When("Выполните поиск по {string}")
//	public void выполните_поиск_по_iphone() {
//		// Write code here that turns the phrase above into concrete actions
//
//	}
}
