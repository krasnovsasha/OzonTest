package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends BasePage {
	@FindBy(xpath = "//div[@delete_button_name='Удалить выбранные']//span")
	public WebElement delChose;
	@FindBy(xpath = "//div[contains(text(),'Удалить')]")
	public WebElement delSubmit;
	@FindBy(xpath = "//span[contains(text(),'Ваша корзина')]")
	public WebElement cartText;
	@FindBy(xpath = "//span[contains(text(),'8 товаров')]")
	public WebElement countItems;
	@FindBy(xpath = "//h1[contains(text(),'Корзина пуста')]")
	public WebElement textEmptyCart;

	public String getTextElement(WebElement element){
		waitUntilElementToBeVisible(element);
		return element.getText();
	}
	public void delItems(){
		waitUntilElementToBeClickable(delChose);
		delChose.click();
		waitUntilElementToBeClickable(delSubmit);
		delSubmit.click();
	}
	public boolean checkCartIsEmpty(){
		waitUntilElementToBeVisible(textEmptyCart);
		return textEmptyCart.isDisplayed();
	}
}
