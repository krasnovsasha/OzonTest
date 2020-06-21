package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends BasePage {
	@FindBy(xpath = "//div[@delete_button_name='Удалить выбранные']")
	public WebElement delChose;
	@FindBy(xpath = "//span[contains(text(),'Ваша корзина')]")
	public WebElement cartText;
	@FindBy(xpath = "//span[contains(text(),'8 товаров')]")
	public WebElement countItems;

	public String getTextElement(WebElement element){
		waitUntilElementToBeVisible(element);
		return element.getText();
	}
}
