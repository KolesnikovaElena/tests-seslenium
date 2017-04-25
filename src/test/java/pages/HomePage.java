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
	
	@FindBy(className = "brick-tour__toggle-bookmark")
	public WebElement starTour;
	
	@FindBy(className = "count")
	public WebElement countBookmark;
	
	@FindBy(css="[data-autotest-id=more-recommend-tours-desktop-link]")
    public WebElement allRecommendTousr;
		
	@FindBy(css="[data-autotest-id=all-tours-by-activities-desktop-link]")
    public WebElement allToursByActivity;
	
	@FindBy(css="[data-autotest-id=all-tours-by-locations-desktop-link]")
    public WebElement allToursByLocation;
	
	@FindBy(css="[data-autotest-id=all-tours-by-months-desktop-link]")
    public WebElement allToursByMonth;
	
	@FindBy(css="[data-autotest-id=all-tours-by-styles-desktop-link]")
    public WebElement allToursByStyle;
	
	@FindBy(css="[data-autotest-id=all-posts-desktop-link]")
    public WebElement blog;
	
	@FindBy(className="brick-post__block-link")
    public WebElement post;	
	
	@FindBy(css="[data-autotest-id=subsribe-to-news-big-input]")
    public WebElement subscribeInput;
	
	@FindBy(css="[data-autotest-id=subsribe-to-news-big-submit-button]")
    public WebElement subscribeBtn;
	
	@FindBy(css="[data-autotest-id=site-footer-contacts-link]")
	public WebElement contacts;
		
	@FindBy(css="[data-autotest-id=site-footer-money-link]")
    public WebElement money;
	
	@FindBy(css="[data-autotest-id=site-footer-policy-link]")
    public WebElement policy;
	
	
	
	
	 public boolean isOnThisPage() {
		return driver.findElements(By.className("banner-tour__slide is-selected")).size() > 0;
	        	    }
	

}
