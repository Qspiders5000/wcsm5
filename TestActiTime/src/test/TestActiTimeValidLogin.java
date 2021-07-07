package test;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import generic.BaseTest;
import generic.CustomListner;
import generic.Flib;
import generic.WebDriverCommonLib;
import page.LoginPage;
@Listeners(CustomListner.class)
public class TestActiTimeValidLogin extends BaseTest {
@Test
public void validActiTimeLogin() throws IOException
{
	Flib flib = new Flib();
	String username = flib.readPropertyData(PROP_PATH, "un");
	String password = flib.readPropertyData(PROP_PATH, "pwd");
	LoginPage lp = new LoginPage(driver);
	lp.validLoginActiTime(username, password);
	
	WebDriverCommonLib wb = new WebDriverCommonLib();
	wb.waitForPageLoad(30, "Enter");
	String homePageTitle = wb.getTitleOfTheWebPage();
	Assert.assertEquals(homePageTitle, "actiTIME - Enter Time-Track");
	
}
}
