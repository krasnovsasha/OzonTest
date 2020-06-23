package pageSteps;

import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.BasketPage;
import pages.CategoryPage;
import utils.AllureUtils;

public class BasketPageSteps {
	BasketPage bp = new BasketPage();

	@When("Убедитесь, что все добавленные ранее товары находятся в корзине")
	public void checkItemsInCart(){
		AllureUtils.takeScreenShot();
		for (String s: CategoryPage.itemsAndNames) {
			System.out.println(s);
		}
//		bp.addIt();
//		for (String s1: BasketPage.arrList1) {
//			System.out.println(s1);
//		}
	}

	@When("Проверить, что отображается текст {string} - {string}")
	public void checkText(String text, String count) {
		Assert.assertEquals("Не отображается текст " + text,text,bp.getTextElement(bp.getCartText()));
		String[] str = bp.getTextElement(bp.getCountItems()).split(" ");
		StringBuilder sb = new StringBuilder();
		sb.append(str[0]).append(" ").append(str[1]);
		Assert.assertEquals("Не отображается текст " + count,count,sb.toString());
	}
	@When("Удалите все товары из корзины")
	public void delItems() {
		bp.delItems();
	}
	@When("Проверьте, что корзина не содержит никаких товаров")
	public void checkCartIsEmpty() {
		Assert.assertEquals("Корзина не пустая ",true,bp.checkCartIsEmptyOrNot());
	}
}
