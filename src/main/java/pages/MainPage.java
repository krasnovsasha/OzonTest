package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
	@FindBy(xpath = "//input[@placeholder='Искать на Ozon']")
	private WebElement searchForm;

	public MainPage clickToPlaceholder() {
		waitUntilElementToBeClickable(searchForm);
		searchForm.click();
		return this;
	}
	public void fillField(String itemName){
//		WebElement field = searchForm.findElement(By.xpath("//input[@placeholder]"));
		searchForm.sendKeys(itemName);
		searchForm.sendKeys(Keys.ENTER);
	}
}
