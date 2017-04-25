package app;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import pages.HomePage;

public class Application {

	private WebDriver driver;
	private WebDriverWait wait;

	private HomePage homePage;


	public Application() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 10);
		homePage = new HomePage(driver);


	}

	public void quit() {
		driver.quit();
	}
	
	protected boolean isElementPresent(WebDriver driver, By locator) {
		try {
			driver.findElement(locator);
			return true;
		} catch (NoSuchElementException ex) {
			return false;
		}
	}
	
	public  boolean areElementsPresent(WebDriver driver, By locator) {
		return driver.findElements(locator).size() > 0;
	}

	public void clickSliderBtn() {
		System.out.println("Test clickSliderBtn start");
		homePage.open();
		homePage.nextBtn.click();
		homePage.nextBtn.click();
		homePage.previousBtn.click();
		System.out.println("Test clickSliderBtn finish");
	}

	public void openTourFromSlider() {
		System.out.println("Test openTourFromSlider start");
		homePage.open();
		String titleTourS = homePage.tourSlider.getAttribute("textContent");
		homePage.tourSlider.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("page-tour-content__tour-title")));
		WebElement titleTour = driver.findElement(By.className("page-tour-content__tour-title"));
		assertEquals(titleTour.getAttribute("textContent"),titleTourS);
		System.out.println("Test openTourFromSlider finish");
	}

	public void openLocationFromSlider() {
		System.out.println("Test openLocationFromSlider start");
		homePage.open();
		String titleLocationS = homePage.locationSlider.getAttribute("textContent");
		homePage.locationSlider.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("brick-tour__image")));
		WebElement titleLocation = driver.findElement(By.tagName("H1"));
		assertEquals(titleLocation.getAttribute("textContent"),titleLocationS);
		System.out.println("Test openLocationFromSlider finish");
	}

	public void checkTitle() {
		System.out.println("Test checkTitle start");
		homePage.open();
		assertEquals("Нетюленьи путешествия. Путешествия и активный отдых в России" , driver.getTitle());
		System.out.println("Test checkTitle finish");
	}

	public void checkLogo() {
		System.out.println("Test checkLogo finish");
		homePage.open();
		if (	isElementPresent(driver, By.className("site-header__logo"))) {
			System.out.println("Logo - passed"); 
		}
		System.out.println("Test checkLogo finish");
	}

	public void checkTelephone() {
		System.out.println("Test checkTelephone start");
		homePage.open();
		if (isElementPresent(driver, By.className("site-header__phone"))) {
			System.out.println("Phone - passed"); 
		}
		System.out.println("Test checkTelephone finish");

	}

	public void checkTEmail() {
		System.out.println("Test checkTEmail start");
		homePage.open();
		if (	isElementPresent(driver, By.className("site-header__email"))) {
			System.out.println("Email - passed"); 
		}	
		System.out.println("Test checkTEmail finish");
	}

	public void checkStar() {
		System.out.println("Test checkStar start");
		homePage.open();
		if (	isElementPresent(driver, By.className("material-icons"))) {
			System.out.println("Star - passed"); 
		}
		System.out.println("Test checkStar finish");
	}

	public void checkBookmarks() {
		System.out.println("Test checkBookmarks start");
		homePage.open();
		if (	isElementPresent(driver, By.className("site-header__bookmarks"))) {
			System.out.println("Bookmarks - passed"); 
		}
		System.out.println("Test checkBookmarks finish");
	}

	public void checkSignIn() {
		System.out.println("Test checkSignIn start");
		homePage.open();
		if (isElementPresent(driver, By.className("site-header__sign-in"))) {
			System.out.println("Sign in - passed"); 
		}
		System.out.println("Test checkSignIn finish");
	}

	

	public void checkPrice() {
		System.out.println("Test checkPrice start");
		homePage.open();
		if (areElementsPresent(driver, By.className("multi-currency-price__price"))) {
			System.out.println("check price - passed"); 
		}
		System.out.println("Test checkPrice finish");
		
	}

	public void checkCurrency() {
		System.out.println("Test checkCurrency start");
		homePage.open();
		if (areElementsPresent(driver, By.className("multi-currency-price__currency"))) {
			System.out.println("check currency - passed"); 
		}
		System.out.println("Test checkCurrency finish");
		
	}

	public void checkDuration() {
		System.out.println("Test checkDuration start");
		homePage.open();
		if (areElementsPresent(driver, By.className("brick-tour__duration"))) {
			System.out.println("check duration - passed"); 
		}
		System.out.println("Test checkDuration finish");
				
	}

	public void openTourFromPreview() {
		System.out.println("Test openTourFromPreview start");
		homePage.open();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("brick-tour__title")));
		String titleTourP = homePage.tourPreview.getAttribute("textContent");
		homePage.tourPreview.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("page-tour-content__tour-title")));
		WebElement titleTour = driver.findElement(By.className("page-tour-content__tour-title"));
		assertEquals(titleTour.getAttribute("textContent"),titleTourP);
		System.out.println("Test openTourFromPreview finish");
		
	}

	public void addBookmark() {
		System.out.println("Test openTourFromPreview start");
		homePage.open();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("brick-tour__title")));
		homePage.allToursByActivity.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("brick-tours-collection__image")));
		//WebElement links = (WebElement) ((JavascriptExecutor) driver)
		//		  .executeScript("return $$('a:contains((WebDriver)')");
	/*	homePage.starTour.click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("продолжить инкогнито")).click();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("count")));
		String count = homePage.countBookmark.getAttribute("textContent");
		System.out.println(count);*/
	//	System.out.println(strto);
	}

	public void openAllToursByActivity() {
		System.out.println("Test openAllToursByActivity start");
		homePage.open();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("brick-tour__title")));
		homePage.allToursByActivity.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("brick-tours-collection__image")));
		System.out.println("Test openAllToursByActivity finish");
	}

	public void openAllToursByLocation() {
		System.out.println("Test openAllToursByLocation start");
		homePage.open();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("brick-tour__title")));
		homePage.allToursByLocation.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("brick-tours-collection__image")));
		System.out.println("Test openAllToursByLocation finish");
	}

	public void openAllToursByMonth() {
		System.out.println("Test openAllToursByMonth start");
		homePage.open();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("brick-tour__title")));
		homePage.allToursByMonth.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("brick-tours-collection__image")));
		System.out.println("Test openAllToursByMonth finish");	
	}

	public void openAllToursByStyle() {
		System.out.println("Test openAllToursByStyle start");
		homePage.open();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("brick-tour__title")));
		homePage.allToursByStyle.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("brick-tours-collection__image")));
		System.out.println("Test openAllToursByStyle finish");	
	}

	public void openBlog() {
		System.out.println("Test openBlog start");
		homePage.open();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("brick-post__block-link")));
		homePage.blog.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("brick-post__block-link")));
		System.out.println("Test openBlog finish");	
	}
	
	public void openPost() {
		System.out.println("Test openPost start");
		homePage.open();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("brick-post__block-link")));
		homePage.post.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("page-post-content__post-image")));
		System.out.println("Test openPost finish");	
	}
	
	public void openContacts() {
		System.out.println("Test openContacts start");
		homePage.open();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("brick-tour__title")));
		homePage.contacts.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("contacts")));
		System.out.println("Test openContacts finish");	
	}
	
	public void openMoney() {
		System.out.println("Test openMoney start");
		homePage.open();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("brick-tour__title")));
		homePage.money.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("page-common__article")));
		System.out.println("Test openMoney finish");	
	}
	
	public void openPolicy() {
		System.out.println("Test openPolicy start");
		homePage.open();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("brick-tour__title")));
		homePage.policy.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("page-common__article")));
		System.out.println("Test openPolicy finish");	
	}
}
