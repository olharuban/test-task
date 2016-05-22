package crossover.utilities.wrapper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

/**
 * Created by olga on 5/11/16.
 */
public class CustomButton extends TypifiedElement {

	public CustomButton(WebElement wrappedElement) {
		super(wrappedElement);
	}

	public void click() {
		getWrappedElement().click();
	}

	public void clickRight(WebDriver driver) {
		Actions action = new Actions(driver);
		action.contextClick(getWrappedElement()).perform();
	}

	public void dblClick(WebDriver driver) {
		Actions action = new Actions(driver);
		action.doubleClick(getWrappedElement()).perform();
	}

	public void dblRightClick(WebDriver driver) {
		Actions action = new Actions(driver);
		action.contextClick(getWrappedElement()).
			   contextClick(getWrappedElement()).perform();
	}

}

