package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TVPageObjects 
{
	@FindBy(xpath="//div[text()='SAMSUNG 80 cm (32 Inch) HD Ready LED Smart Tizen TV with Bezel-free Design']")
    public static WebElement samsungTV;
	@FindBy(xpath="//button[text()='Buy Now']")
	public static WebElement BuyNowButton;
}
