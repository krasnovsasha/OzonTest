package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
	@FindBy(xpath = "//form[@class='b2m4']")
	private WebElement searchForm;

	public MainPage clickToPlaceholder() {
		waitClickable(searchForm.findElement(By.xpath("//input[@placeholder]"))).click();
		return this;
	}
	public void fillField(String itemName){
		WebElement field = searchForm.findElement(By.xpath("//input[@placeholder]"));
		field.sendKeys(itemName);
		field.sendKeys(Keys.ENTER);
	}
}
