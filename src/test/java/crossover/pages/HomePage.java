package crossover.pages;

import crossover.ATC.test_cases.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import static crossover.utilities.WebElementExtension.waitForWebElementVisibility;


/**
 * Created by olga on 5/12/16.
 */
public class HomePage {

	public enum MenuTab {
		COMPANIES,
		JOBS,
		CAREERS,
		MISSION,
		ABOUT,
		BLOG,
		CONTACT,
		LOGIN
	}

	@FindBy(xpath = "//body[contains(@class, 'home page')]")
	WebElement body;

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);

	}
	public void open() {
		driver.get(TestBase.BASE_URL);
	}

	public boolean isUrlOpen() {
		return driver.getCurrentUrl().equals(TestBase.BASE_URL);
	}

	public boolean isBodyPresent() {
		return waitForWebElementVisibility(driver, body, true);
	}

	public void selectTab(MenuTab tabName) {
		driver.findElement(By.linkText(tabName.toString())).click();
	}
}
