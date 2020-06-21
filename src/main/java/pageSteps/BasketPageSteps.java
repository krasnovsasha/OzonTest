package pageSteps;

import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.BasketPage;

public class BasketPageSteps {
	BasketPage bp = new BasketPage();

	@When("Проверить, что отображается текст {string} - {string}")
	public void checkText(String text, String count) {
		String textActual = bp.getTextElement(bp.cartText);
		Assert.assertEquals("Не отображается текст " + text,text,textActual);
		String countActual = bp.getTextElement(bp.countItems);
		String[] str = countActual.split(" ");
		StringBuilder sb = new StringBuilder();
		sb.append(str[0]).append(" ").append(str[1]);
		String actual = sb.toString();
		Assert.assertEquals("Не отображается текст " + count,count,actual);
	}
//	@When("Удалите все товары из корзины")
//	public void delItems() {
//
//	}
//	@When("Проверьте, что корзина не содержит никаких товаров")
//	public void проверьте_что_корзина_не_содержит_никаких_товаров() {
//		// Write code here that turns the phrase above into concrete actions
//
//	}
}
