package Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest {
	public String baseurl = "https://chandanachaitanya.github.io/selenium-practice-site/";
	public String driverPath = "E://geckodriver.exe";
	public WebDriver driver;

	@Test(priority =1)
	public void rbMagazinesTest() {
		beroforeTest();
		System.out.println("radio button Magazine Test");
		WebElement listElements = driver.findElement(By.id("booksCheckboxes"));
		WebElement elementName = driver.findElement(By.id("magazines-radio-btn"));
		rbTest(listElements, elementName);

	}
	@Test(priority =2)
	public void rbnovelsTest() {
		beroforeTest();
		System.out.println("radio button novels Test");
		WebElement listElements = driver.findElement(By.id("booksCheckboxes"));
		WebElement elementName = driver.findElement(By.id("novels-radio-btn"));
		rbTest(listElements, elementName);

	}
	@Test(priority =3)
	public void rbSelfhelpbooksTest() {
		beroforeTest();
		System.out.println("radio button Self help books Test");
		WebElement listElements = driver.findElement(By.id("booksCheckboxes"));
		WebElement elementName = driver.findElement(By.id("self-help-radio-btn"));
		rbTest(listElements, elementName);

	}

	public void beroforeTest() {
		System.out.println("Loading firefox...");
		System.setProperty("webdriver.firefox.driver", driverPath);
		driver = new FirefoxDriver();
		driver.get(baseurl);
	}

	public boolean IsEnableRB(WebElement listElements, WebElement elementName) {
		List<WebElement> childElements = listElements.findElements(By.tagName("input"));
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

	public void rbSelectTest(WebElement listElements, WebElement elementName) {
		List<WebElement> childElements = listElements.findElements(By.tagName("input"));
		String eleN = elementName.getAttribute("Value");
		for (int i = 0; i < childElements.size(); i++) {
			WebElement or = childElements.get(i);
			if (childElements.get(i).getAttribute("Value").equals(eleN) && !childElements.get(i).isSelected()) {
				childElements.get(i).click();
				System.out.println(or.getAttribute("value") + " is Selected: " + or.isSelected());
				Assert.assertEquals(or.isSelected(), true);
			} else {
				System.out.println(or.getAttribute("value") + " is Selected: " + or.isSelected());
				Assert.assertEquals(or.isSelected(), false);
			}
		}
	}
	public void rbTest(WebElement listElements, WebElement elementName) {
		boolean enable = IsEnableRB(listElements, elementName);
		if (enable == true) {
			rbSelectTest(listElements, elementName);

		} else {
			System.out.println(elementName.getAttribute("value") + " is disabled");
			Assert.assertEquals(true, true);

		}
		driver.close();
	}
}
