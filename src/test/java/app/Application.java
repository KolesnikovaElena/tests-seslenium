package app;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;


import org.openqa.selenium.By;
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

	protected boolean isElementPresent(WebDriver driver, By locator) {
		try {
			driver.findElement(locator);
			return true;
		} catch (NoSuchElementException ex) {
			return false;
		}
	}

}
