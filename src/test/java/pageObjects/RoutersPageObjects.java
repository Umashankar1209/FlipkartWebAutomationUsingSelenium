package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RoutersPageObjects {
	
	
	
	@FindBy(xpath="/html/body/div[4]/div[1]/object/a[1]")
	public static WebElement ElectronicsAudio;
	@FindBy(xpath="//div[text()='Routers']")
	public static WebElement Routers;
	@FindBy(xpath="//div[text()='TP-Link TL-WA850RE(IN) 300 Mbps WiFi Range Extender']")
	public static WebElement DLinkRouter;
	@FindBy(xpath="//button[text()='Buy Now']")
	public static WebElement BuyNowButton;
	

}
