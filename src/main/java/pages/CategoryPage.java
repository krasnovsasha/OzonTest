package pages;

import annotations.FieldName;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class CategoryPage extends BasePage {
	@FindBy(xpath = "//aside")
	private WebElement leftOptionsMenu;
	@FindBy(xpath = "(//input[@qa-id='range-to'])[1]")
	private WebElement priceRangeTo;
	@FindBy(xpath = "//div[@value='Высокий рейтинг']//span[contains(text(),'Высокий рейтинг')]")
	@FieldName(name = "Высокий рейтинг")
	public WebElement hightRating;
	@FindBy(xpath = "//span[contains(text(), 'NFC')][1]")
	@FieldName(name = "NFC")
	public WebElement NFC;
	@FindBy(xpath = "(//div[@data-widget='searchResultsV2'])")
	public WebElement resultForm;
	@FindBy(xpath = "(//div[@data-widget='searchResultsV2']//div[contains(text(),'В корзину')])[1]")
	public WebElement resultFormItem;
	@FindBy(xpath = "(//div[@data-widget='searchResultsV2']//div[contains(text(),'В корзину')])[1]/parent::div/parent::button")
	public WebElement buttonAddToCart;
	@FindBy(xpath = "(//div[@data-widget='searchResultsV2']//div[contains(text(),'В корзину')])/parent::div/parent::button")
	public List<WebElement> resultList;
	@FindBy(xpath = "//div[@data-widget='searchResultsSort']//span[contains(text(),'Высокий рейтинг')]")
	public WebElement hightRatingResult;
	@FindBy(xpath = "//a[@href='/cart']")
	public WebElement cart;

	public CategoryPage waitLeftMenuClickable() {
		waitUntilElementToBeClickable(leftOptionsMenu);
		return this;
	}

	public CategoryPage waitResultFormClickable() {
		waitUntilElementToBeClickable(resultForm);
		return this;
	}

	public CategoryPage choosePrice(String price) {
		waitUntilElementToBeClickable(priceRangeTo);
		clearField(priceRangeTo);
		waitToRefreshByText(priceRangeTo);
		inputField(priceRangeTo, price);
		return this;
	}

	public WebElement getFieldName(String name) {
		return getField(name, "pages.CategoryPage");
	}

	public void clickCheckbox(String fieldName) {
		WebElement element = getFieldName(fieldName);
		waitUntilElementToBeClickable(resultForm);
		moveToElement(element);
		waitUntilElementToBeVisible(element);
		waitUntilElementToBeClickable(element);
		element.click();
		waitUntilElementToBeClickable(resultForm);
	}

	public void addItemsToCart(int count) {
		int c = 0;
		for (WebElement el : resultList) {
			try {
				if (c %2 != 0 && count > 0) {
					waitUntilElementToBeClickable(el);
					el.click();
					c++;
					count--;
				} else {
					c++;
				}
			} catch (StaleElementReferenceException e) {
			}
		}
	}
}
