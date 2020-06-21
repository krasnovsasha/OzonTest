package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class BasketPage extends BasePage {
	@FindBy(xpath = "//div[@delete_button_name='Удалить выбранные']//span")
	private WebElement delChose;
	@FindBy(xpath = "//div[contains(text(),'Удалить')]")
	private WebElement delSubmit;
	@FindBy(xpath = "//span[contains(text(),'Ваша корзина')]")
	private WebElement cartText;
	@FindBy(xpath = "//span[contains(text(),'8 товаров')]")
	private WebElement countItems;
	@FindBy(xpath = "//h1[contains(text(),'Корзина пуста')]")
	private WebElement textEmptyCart;
	@FindBy(xpath = "//span[@style='color: rgb(0, 26, 52);']")
	private List<WebElement> itemsInCart;

	public WebElement getCartText() {
		return cartText;
	}

	public WebElement getCountItems() {
		return countItems;
	}

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
	public boolean checkCartIsEmptyOrNot(){
		waitUntilElementToBeVisible(textEmptyCart);
		return textEmptyCart.isDisplayed();
	}
	ArrayList<WebElement> arrList = new ArrayList<>(itemsInCart);
	public static ArrayList<String> arrList1 = new ArrayList<>();
	public void addIt(){
		for (WebElement el: arrList) {
			arrList1.add(el.getText());
		}
	}
}
