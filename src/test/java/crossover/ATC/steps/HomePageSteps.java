package crossover.ATC.steps;

import crossover.pages.HomePage;
import org.openqa.selenium.WebDriver;

import static crossover.ATC.ErrorMessages.PAGE_SHOULD_BE_OPEN;
import static crossover.ATC.ErrorMessages.WRONG_HTML_BODY;
import static org.junit.Assert.assertTrue;


/**
 * Created by olga on 5/13/16.
 */
public class HomePageSteps {

	private HomePage homePage;

	public HomePageSteps(WebDriver driver) {
		homePage = new HomePage(driver);
	}

	public void openHomePage() {
		homePage.open();
	}

	public void verifyPageOpen() {
		assertTrue(PAGE_SHOULD_BE_OPEN + homePage.getClass().getSimpleName(), homePage.isUrlOpen());
		assertTrue(WRONG_HTML_BODY, homePage.isBodyPresent());
	}

	public void selectMenuTab(HomePage.MenuTab tab) {
		homePage.selectTab(tab);
	}
}
