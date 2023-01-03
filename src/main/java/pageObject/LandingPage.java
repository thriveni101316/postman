package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.BaseClass;

public class LandingPage extends BaseClass{
	
	WebDriver driver;
	
	By login = By.xpath("//span[contains(text(),'Login')]");
	By title = By.cssSelector("#content h2");
	By contact = By.xpath("//a[text()=\"Contact\"]");
	By header = By.cssSelector("div[class*=\"video-banner\"] h3");
	By popup = By.xpath("//button[text()=\"NO THANKS\"]");

	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	public WebElement getLogin()
	{
		return(driver.findElement(login));
	}
	public WebElement getTitle()
	{
		return(driver.findElement(title));
	}
	public WebElement getContact()
	{
		return(driver.findElement(contact));
	}
	public WebElement getHeader()
	{
		return(driver.findElement(header));
	}
	public List<WebElement> getPopupSize()
	{
		return(driver.findElements(popup));
	}
	public WebElement getPopup()
	{
		return(driver.findElement(popup));
	}
	


	
	
	

}
