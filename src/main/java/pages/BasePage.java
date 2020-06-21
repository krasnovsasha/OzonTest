package pages;

import annotations.FieldName;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverSettings;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.lang.reflect.Field;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public abstract class BasePage {
	private static FluentWait<WebDriver> fluentWait;

	public BasePage() {
		PageFactory.initElements(DriverSettings.getDriver(), this);
	}

	protected WebElement waitClickable(WebElement element) {
		return DriverSettings.getWait().until(ExpectedConditions.elementToBeClickable(element));
	}

	protected void moveToElement(WebElement element) {
		Actions actions = new Actions(DriverSettings.getDriver());
		actions.moveToElement(element).perform();
	}

	protected static void waitUntilElementToBeVisible(WebElement element) {
		fluentWait = new FluentWait<>(DriverSettings.getDriver())
				.withTimeout(Duration.ofMillis(25000))
				.pollingEvery(Duration.ofMillis(500))
				.ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.visibilityOf(element));
	}

	protected static void waitUntilElementToBeClickable(WebElement element) {
		fluentWait = new FluentWait<>(DriverSettings.getDriver())
				.withTimeout(Duration.ofMillis(25000))
				.pollingEvery(Duration.ofMillis(500))
				.ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.elementToBeClickable(element));
	}

	protected WebElement getField(String name, String className) {
		Class example = null;
		try {
			example = Class.forName(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		List<Field> fields = Arrays.asList(example.getFields());
		for (Field field : fields) {
			if (field.getAnnotation(FieldName.class).name().equals(name)) {
				return DriverSettings.getDriver().findElement(By.xpath(field.getAnnotation(FindBy.class).xpath()));
			}
		}
		Assert.fail("Не объявлен элемент с наименованием " + name);
		return null;
	}


	protected void waitToRefreshByText(WebElement element) {
		try {
			WebDriverWait wdw = new WebDriverWait(DriverSettings.getDriver(), 10);
			String textBefore  = element.getText();
			System.out.println("textBefore : " + textBefore);
			wdw.until(driver -> {
				String textAfter = element.getText();
				System.out.println("textAfter : " +textAfter);
				return textAfter != textBefore;
			});
		} catch (org.openqa.selenium.TimeoutException e) {
			e.printStackTrace();
		}
	}

	protected void clearField(WebElement field) {
		field.click();
		field.sendKeys(Keys.CONTROL + "a");
		field.sendKeys(Keys.BACK_SPACE);
	}

	protected void inputField(WebElement field, String value){
		field.clear();
		field.sendKeys(value);
		field.sendKeys(Keys.ENTER);
	}
}
