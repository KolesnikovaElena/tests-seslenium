package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;





public class HomePage extends Page{

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void open() {
		driver.get("https://netuleny.com");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("brick-tour__block-link")));
		}
	
	
	@FindBy(css=".input-group [TYPE=TEXT]")
    public WebElement queryInput;
	
	@FindBy(css=".ng-valid button")
    public WebElement queryBtn;
	
	@FindBy(className="title")
    public WebElement tourSlider;
	
	@FindBy(className="banner-tour__location-item")
    public WebElement locationSlider;
	
	@FindBy(css="[aria-label=next]")
    public WebElement nextBtn;
	
	@FindBy(css="[aria-label=previous]")
    public WebElement previousBtn;
	
	@FindBy(className="brick-tour__title")
	public WebElement tourPreview;
	
	@FindBy(name="subscribeForm__email")
    public WebElement subscribeInput;
	
	@FindBy(css="body > site-content > ui-view > subscribe-to-news > div > form > div:nth-child(2) > div > div.input-group.input-group-lg > span > button")
    public WebElement subscribeBtn;
	
	@FindBy(css="href^=/contacts")
    public WebElement contacts;
	
	@FindBy(css="href^=/money")
    public WebElement money;
	
	 public boolean isOnThisPage() {
		return driver.findElements(By.className("banner-tour__slide is-selected")).size() > 0;
	        	    }
	

}
