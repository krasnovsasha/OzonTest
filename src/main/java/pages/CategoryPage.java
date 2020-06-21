package pages;

import annotations.FieldName;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
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
	private WebElement resultForm;
	@FindBy(xpath = "(//div[@data-widget='searchResultsV2']//div[contains(text(),'В корзину')])/parent::div/parent::button")
	private List<WebElement> resultList;
	@FindBy(xpath = "(//div[@data-widget='searchResultsV2'])//a[@class=\"a2x5 tile-hover-target\"]")
	private List<WebElement> resultWithNames;
	@FindBy(xpath = "(//span[contains(text(),'Посмотреть все')])[1]")
	private WebElement showAllBrands;
	@FindBy(xpath = "(//input[@class='ui-av9 ui-av4'])[1]")
	private WebElement brandsInput;
	@FindBy(xpath = "//span[contains(text(),'Samsung')]")
	@FieldName(name = "Samsung")
	public WebElement samsungCheckBox;
	@FindBy(xpath = "(//span[contains(text(),'Xiaomi')])[4]")
	@FieldName(name = "Xiaomi")
	public WebElement xiaomiCheckBox;
	public static ArrayList<String> itemsAndNames = new ArrayList<>();

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
		try{
			WebElement element = getFieldName(fieldName);
			waitUntilElementToBeClickable(resultForm);
			moveToElement(element);
			waitUntilElementToBeVisible(element);
			waitUntilElementToBeClickable(element);
			element.click();
			waitUntilElementToBeClickable(resultForm);
		}catch (StaleElementReferenceException e) {
			clickCheckbox(fieldName);
		}

	}

	public void insertToBrandsInput(String brandName,WebElement brand){
		try {
			waitUntilElementToBeClickable(brandsInput);
			clearField(brandsInput);
			brandsInput.sendKeys(brandName);
			waitUntilElementToBeClickable(brand);
			brand.click();
			waitUntilElementToBeClickable(resultForm);
		} catch (StaleElementReferenceException e) {
			waitUntilElementToBeClickable(brandsInput);
			clearField(brandsInput);
			brandsInput.sendKeys(brandName);
			waitUntilElementToBeClickable(brand);
			brand.click();
			waitUntilElementToBeClickable(resultForm);
		}

	}
	public void waitUntilAllBrandsClickAble(){
		waitUntilElementToBeClickable(showAllBrands);
		showAllBrands.click();
	}

	public void addItemsToCart(int count) {
		int c = 0;
		ArrayList<WebElement> arrList = new ArrayList<>(resultWithNames);
		for (WebElement el : resultList) {
			try {
				if (c %2 != 0 && count > 0) {
					waitUntilElementToBeVisible(el);
					waitUntilElementToBeClickable(el);
					el.click();
					itemsAndNames.add(arrList.get(c).getText());
					c++;
					count--;
				} else {
					c++;
				}
			} catch (StaleElementReferenceException e) {
				waitUntilElementToBeVisible(el);
				waitUntilElementToBeClickable(el);
				el.click();
				itemsAndNames.add(arrList.get(c).getText());
				c++;
				count--;
			}
		}
	}
	public void addItemsToCart() {
		int c = 1;
		for (WebElement el : resultList) {
			try {
				if (c %2 == 0) {
					waitUntilElementToBeVisible(el);
					waitUntilElementToBeClickable(el);
					el.click();
					c++;
				} else {
					c++;
				}
			} catch (StaleElementReferenceException e) {
				addItemsToCart();
			}
		}
	}
}
