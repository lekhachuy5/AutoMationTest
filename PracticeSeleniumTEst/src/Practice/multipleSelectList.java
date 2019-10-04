package Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class multipleSelectList {
	public String baseurl = "https://chandanachaitanya.github.io/selenium-practice-site/";
	public String driverPath = "E://geckodriver.exe";
	public WebDriver driver;

	@Test(priority = 1)
	public void slJavaTest() {
		beroforeTest();
		System.out.println("select list Java Test");
		WebElement listElements = driver.findElement(By.id("selenium_suite"));

		WebElement elementName = driver.findElement(By.xpath("/html/body/form/div[3]/div[1]/select[2]/option[1]"));
		slTest(listElements, elementName);
	}

	@Test(priority = 2)
	public void slCTest() {
		beroforeTest();
		System.out.println("select list C++ Test");
		WebElement listElements = driver.findElement(By.id("selenium_suite"));

		WebElement elementName = driver.findElement(By.xpath("/html/body/form/div[3]/div[1]/select[2]/option[2]"));
		slTest(listElements, elementName);
	}

	@Test(priority = 3)
	public void slCSTest() {
		beroforeTest();
		System.out.println("select list C# Test");
		WebElement listElements = driver.findElement(By.id("selenium_suite"));

		WebElement elementName = driver.findElement(By.xpath("/html/body/form/div[3]/div[1]/select[2]/option[3]"));
		slTest(listElements, elementName);
	}

	@Test(priority = 4)
	public void slJavaScriptTest() {
		beroforeTest();
		System.out.println("select list JavaScript Test");
		WebElement listElements = driver.findElement(By.id("selenium_suite"));

		WebElement elementName = driver.findElement(By.xpath("/html/body/form/div[3]/div[1]/select[2]/option[4]"));
		slTest(listElements, elementName);
	}

	@Test(priority = 5)
	public void slPythonTest() {
		beroforeTest();
		System.out.println("select list Python Test");
		WebElement listElements = driver.findElement(By.id("selenium_suite"));

		WebElement elementName = driver.findElement(By.xpath("/html/body/form/div[3]/div[1]/select[2]/option[5]"));
		slTest(listElements, elementName);
	}

	@Test(priority = 6)
	public void slPHPTest() {
		beroforeTest();
		System.out.println("select list PHP Test");
		WebElement listElements = driver.findElement(By.id("selenium_suite"));

		WebElement elementName = driver.findElement(By.xpath("/html/body/form/div[3]/div[1]/select[2]/option[6]"));
		slTest(listElements, elementName);
	}

	@Test(priority = 7)
	public void slIsMultiple() {
		beroforeTest();
		System.out.println("select list PHP Test");
		WebElement listElements = driver.findElement(By.id("selenium_suite"));
		Select msl = new Select(listElements);
		List<WebElement> childElements = listElements.findElements(By.tagName("option"));
		System.out.println("is multiple Select List: " + msl.isMultiple());
		msl.deselectAll();
		for (int i = 0; i < childElements.size(); i++) {
			System.out.println(
					childElements.get(i).getAttribute("value") + "is selected: " + childElements.get(i).isSelected());
		}
		msl.getAllSelectedOptions();
		for (int i = 0; i < childElements.size(); i++) {
			System.out.println(
					childElements.get(i).getAttribute("value") + "is selected: " + childElements.get(i).isSelected());
		}
		driver.close();
	}

	public void beroforeTest() {
		System.out.println("Loading firefox...");
		System.setProperty("webdriver.firefox.driver", driverPath);
		driver = new FirefoxDriver();
		driver.get(baseurl);
	}

	public boolean IsEnableSL(WebElement listElements, WebElement elementName) {

		List<WebElement> childElements = listElements.findElements(By.tagName("option"));
		String eleN = elementName.getAttribute("Value");
		boolean enable = true;
		for (int i = 0; i < childElements.size(); i++) {
			if (childElements.get(i).getAttribute("Value").equals(eleN)) {
				if (enable == childElements.get(i).isEnabled()) {

					enable = true;
				} else {
					enable = false;
					System.out.println(childElements.get(i).getAttribute("Value") + "is disable");
				}

			}
		}
		return enable;
	}

	public void slSelectTest(WebElement listElements, WebElement elementName) {
		Select lE = new Select(listElements);
		List<WebElement> childElements = listElements.findElements(By.tagName("option"));
		String eleN = elementName.getAttribute("Value");
		for (int i = 0; i < childElements.size(); i++) {
			WebElement or = childElements.get(i);
			if (childElements.get(i).getAttribute("Value").equals(eleN)) {
				lE.selectByIndex(i);
				Assert.assertEquals(or.isSelected(), true);
			}

		}
		for (

				int i = 0; i < childElements.size(); i++) {
			WebElement or = childElements.get(i);
			System.out.println(or.getAttribute("value") + " is Selected: " + or.isSelected());
		}

	}

	public void slTest(WebElement listElements, WebElement elementName) {

		boolean enable = IsEnableSL(listElements, elementName);
		if (enable == true) {
			slSelectTest(listElements, elementName);

		} else {
			System.out.println(elementName.getAttribute("value") + " is disabled");
			Assert.assertEquals(true, true);

		}
		driver.close();
	}
}
