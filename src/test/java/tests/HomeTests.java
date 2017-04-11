package tests;

import org.junit.Test;

public class HomeTests extends TestBase{

	@Test
	public void slider()  {
		app.clickSliderBtn();
	}

	@Test
	public void sliderTour() {
		app.openTourFromSlider();
	}

	@Test
	public void checHomePage() {
		app.checkTitle();
		app.checkLogo();
		app.checkTelephone();
		app.checkStar();
		app.checkBookmarks();
		app.checkSignIn();
	}	

	@  Test
	public void sliderLocation() {
		app.openLocationFromSlider();
	}
}