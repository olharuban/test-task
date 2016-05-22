package crossover.utilities;

import com.google.common.base.Function;
import crossover.ATC.test_cases.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static crossover.utilities.ExpectedConditions.invisibilityOf;
import static crossover.utilities.ExpectedConditions.invisibilityOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;


/**
 * Created by olga on 5/12/16.
 */
public class WebElementExtension {

	public static boolean waitForWebElementVisibility(WebDriver driver, WebElement element, boolean expectedBoolean) {
		if (expectedBoolean) {
			return isExpectedConditionTrue(driver, visibilityOf(element));
		} else {
			return isExpectedConditionTrue(driver, invisibilityOf(element));
		}
	}

	public static boolean waitForWebElementVisibility(WebDriver driver, By locator, boolean expectedBoolean) {
		if (expectedBoolean) {
			return isExpectedConditionTrue(driver, ExpectedConditions.visibilityOfElementLocated(locator));
		} else {
			return isExpectedConditionTrue(driver, invisibilityOfElementLocated(locator));
		}
	}

	private static boolean isExpectedConditionTrue(WebDriver driver, ExpectedCondition expectedConditions) {
		WebDriverWait wait = new WebDriverWait(driver, TestBase.TIMEOUTS.SEC.IMPLICITLY);
		try {
			wait.until((Function<? super WebDriver, Object>) expectedConditions);
			return true;
		} catch (TimeoutException e) {
			return false;
		}
	}

}
