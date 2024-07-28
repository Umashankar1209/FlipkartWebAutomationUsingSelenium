package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlipkartMainPageObjects 
{
	@FindBy(xpath ="//*[@id='container']/div/div[1]/div/div/div/div/div[1]/div/div/div/div[2]/div[1]/div/div[1]/div/div/div/div/div[1]/div[2]")
	public static WebElement Electronics;
	@FindBy(name="q")
	public static WebElement searchBox;
	@FindBy(xpath="//li[@class='_3D0G9a']//div/a/div[2]")
	public static List<WebElement> autoSuggestion;
}
