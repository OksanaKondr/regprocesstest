package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import objects.RegProcessPage;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import utils.DriverSetup;

public class TRRegProcessTest extends DriverSetup {
	
	WebDriver driver;
	RegProcessPage regPage;
   
    @BeforeClass
    public void init() throws IOException {

	driver = setUp();
	regPage = new RegProcessPage(driver);

	}
    
    @Test
    @Features("Demo")
    @Stories("Demo test")
    public void testDemo() throws Exception {
    	
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	regPage.next();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	regPage.start();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
    	Assert.assertTrue(regPage.isGridDataEnabled());
    	Assert.assertTrue(regPage.namesEnsure("Aaron Abel"), "Aaron Abel not found");
    	Assert.assertTrue(regPage.namesEnsure("Aaron Ackerman"), "Aaron Ackerman not found");
    	Assert.assertTrue(regPage.namesEnsure("Aaron Adair"), "Aaron Adair not found");
    	Assert.assertTrue(regPage.namesEnsure("Aaron Addison"), "Aaron Addison not found");
    	Assert.assertTrue(regPage.namesEnsure("Aaron Akins"), "Aaron Akins not found");
    	Assert.assertTrue(regPage.namesEnsure("Aaron Alaniz"), "Aaron Alaniz not found");
    	Assert.assertTrue(regPage.namesEnsure("Aaron Albertson"), "Aaron Albertson not found");
    	Assert.assertTrue(regPage.namesEnsure("Aaron Alfaro"), "Aaron Alfaro not found");
    	Assert.assertTrue(regPage.namesEnsure("Aaron Alicea"), "Aaron Alicea not found");
    	regPage.setPage(76);
    	regPage.setPage(342);
    	regPage.setPage(85682);
    	regPage.setPage(98954);
    	regPage.setPage(1);
    	regPage.setEntries("100");
    	Thread.sleep(5000);
    	regPage.salaryClick();
    	Thread.sleep(5000);
    	for (int i=1; i<=2; i++) 
    	{
    		regPage.setPage(i);
        	Thread.sleep(5000);
    		regPage.salarySortEnsure(100);
    	}	
    	Thread.sleep(5000);
    	regPage.nameClick();
    	Thread.sleep(5000);
    	for (int i=1; i<=2; i++) 
    	{
    	    regPage.setPage(i);
    	    Thread.sleep(5000);
    		regPage.nameSortEnsure(100);
    	} 
    	Thread.sleep(5000);
    	regPage.emailClick();
    	Thread.sleep(5000);
    	for (int i=1; i<=10; i++) 
    	{
    	    regPage.setPage(i);
    	    Thread.sleep(5000);
    		regPage.emailSortEnsure(100);
    	} 
    	}
 
    @AfterClass
    public void shutDown() {
	driver.quit();
    }

}
