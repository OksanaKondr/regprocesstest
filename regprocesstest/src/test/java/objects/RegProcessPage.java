package objects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegProcessPage {
	
	WebDriver driver;

	public RegProcessPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(xpath = ".//*[@class='container']")
	private WebElement containerTable;

	@FindBy(xpath = ".//*[@id='servertable']/div[@class='navbar navbar-default bento-toolbar ng-isolate-scope']")
	private WebElement tableBar;
	
	@FindBy(xpath = ".//a[@ng-click='actions.add()']")
	private WebElement addButton;

	@FindBy(xpath = ".//a[@ng-click='actions.import()']")
	private WebElement importButton;

	@FindBy(xpath = ".//a[@ng-click='actions.export()']")
	private WebElement exportButton;

	@FindBy(xpath = ".//a[@ng-click='actions.delete()']")
	private WebElement deleteButton;

	@FindBy(xpath = ".//*[@id='DataTables_Table_0_wrapper']//th[text()='Name']")
	private WebElement captionName;
	
	@FindBy(xpath = ".//*[@id='DataTables_Table_0_wrapper']//th[text()='Email']")
	private WebElement captionEmail;
	
	@FindBy(xpath = ".//*[@id='DataTables_Table_0_wrapper']//th[text()='Country']")
	private WebElement captionCountry;
	
	@FindBy(xpath = ".//*[@id='DataTables_Table_0_wrapper']//th[text()='Company']")
	private WebElement captionCompany;
	
	@FindBy(xpath = ".//*[@id='DataTables_Table_0_wrapper']//th[text()='User Status']")
	private WebElement captionUserStatus;
	
	@FindBy(xpath = ".//*[@id='DataTables_Table_0_wrapper']//th[text()='Salary']")
	private WebElement captionSalary;

	@FindBy(xpath = ".//*[@id='DataTables_Table_0_wrapper']//div[@class='dataTables_scrollBody']")
	private WebElement gridData;
	
	@FindBy(xpath = ".//*[@id='DataTables_Table_0']/tbody/tr/td")
	private WebElement grid;

	@FindBy(xpath = ".//a[@ng-click='goToPage('max')']")  
	private WebElement endButton;
	
	@FindBy(xpath = ".//a[@ng-click='goToPage(1)']")  
	private WebElement startButton;
	
	@FindBy(xpath = ".//a[@ng-click='goToPage(currentPage+1)']")  
	private WebElement nextPage;
	
	@FindBy(xpath = ".//*[@id='servertable']")  
	private WebElement serverTable;
	
	@FindBy(xpath = ".//*[@id='servertable']//input[@ng-keypress='keySelectPage($event, VM.tgtPage)'][@placeholder]")  
	private WebElement pageInput;
	
	@FindBy(xpath = ".//*[@id='servertable']//button[@class='go btn btn-default ng-binding']")  
	private WebElement goButton;
	
	@FindBy(xpath = ".//*[@id='servertable']//li[@class='paginate_info ng-scope']/span[@class='ng-scope ng-binding']")  
	private WebElement pageOf;
	
	@FindBy(xpath = ".//*[@id='servertable']//li[@class='paginate-bento-select']/span/select")  
	private WebElement pageLayout;
	
	@FindBy(xpath = ".//*[@id='servertable']//li[@class='paginate-bento-select']/span/select/option")  
	private WebElement pageLayoutOption;
	
	@FindBy(xpath = ".//*[@id='servertable']//li[@class='paginate_info_select ng-scope']/span[@class='ng-scope ng-binding']")  
	private WebElement entries;
	

	//To move to the last page.
	public void end() {
		endButton.click();
	}

	//To move to the first page.
	public void start() {
		startButton.click();
	}
	
	//To move to the next page.
	public void next() {
		nextPage.click();
	}
	
	//To move to the previous page.
	public void previous() {
		;
	}

	//To ensure that the database data table is enabled.
	public boolean isGridDataEnabled() {
		
		return gridData.isEnabled();
		//(new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//tr[@class='odd compiled ng-scope' or @class='even compiled ng-scope']/td[@class='sorting_1']")));
	}
	
	//To ensure that appropriate names are present on a page.
    public boolean namesEnsure(String personName) {
		
        for (WebElement name : gridData.findElements(By.xpath(".//td[@class='sorting_1']"))) {
        	if (name.getText().equals(personName)) {
        		System.out.println(name.getText());
        		return true;
        	}
		}
        return false;	
	} 
    
    public void nameClick() 
    {
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	captionName.click();
    }
    
    public void salaryClick() 
    {
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	captionSalary.click();
    }
    
    public void emailClick() 
    {
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	captionEmail.click();
    }
    
    //To sort and then obtain an array of Salary values.
    //To ensure that the Salary values are sorted correctly.
    public void salarySortEnsure(int value)
    {
    	int [] list = new int [value];
    	int k = 0;
        for (WebElement name : gridData.findElements(By.xpath(".//tr[@class='odd compiled ng-scope' or @class='even compiled ng-scope']/td[@class='sorting_1']"))) 
        {
        	String s = name.getText();
        	list[k] = Integer.parseInt(s);
        	System.out.print(list[k]);
        	System.out.print(" ; ");
        	k++;
		}	
    	
    	int [] a = new int [list.length];
    	
    	boolean b = false;
    	
    	for (int i=0; i<list.length; i++) 
    	{
    		a[i] = list[i];
    	}
    	
    	for (int i=0; i<list.length; i++) 
    	{
    		for (int j=list.length-1; j>i; j--) 
    		{
    			if (a[j] < a[j-1]) 
    			{
    				b = true;
    				int temp = a[j];
    				a[j] = a[j-1];
    				a[j-1] = temp;
    			}
    		}
    	}
    	if (b == false) System.out.println("Salary values are sorted correctly.");
    }
    
    
    public String [] nameSort(int value) 
    {	
    	String [] list = new String [value];
    	int k = 0;
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        for (WebElement name : gridData.findElements(By.xpath(".//tr[@class='odd compiled ng-scope' or @class='even compiled ng-scope']/td[@class='sorting_1']"))) 
        {
        	String s = name.getText();
        	list[k] = s;
        	k++;
		}
        return list;
    }   
    	
        
    //To sort and then obtain an array of Name values.
    //To ensure that the Name values are sorted correctly.
    public void nameSortEnsure(int value) 
    {
    	
    	String [] list = new String [value];
    	int k = 0;
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        for (WebElement name : gridData.findElements(By.xpath(".//tr[@class='odd compiled ng-scope' or @class='even compiled ng-scope']/td[@class='sorting_1']"))) 
        {
        	String s = name.getText();
        	list[k] = s;
        	System.out.print(list[k]);
        	System.out.print(" ; ");
        	k++;
		}	
    	
    	String [] a = new String [list.length];
    	
    	boolean b = false;
    	
    	for (int i=0; i<list.length; i++) 
    	{
    		a[i] = list[i];
    	}
    	
    	for (int i=0; i<list.length; i++) 
    	{
    		for (int j=list.length-1; j>i; j--) 
    		{
    			if (a[j].compareTo(a[j-1])<0) 
    			{
    				b = true;
    				String temp = a[j];
    				a[j] = a[j-1];
    				a[j-1] = temp;
    			}
    		}  
    	}
    	if (b == false) System.out.println("Name values are sorted correctly.");
    }
    
    //To sort and then obtain an array of Name values.
    //To ensure that the Name values are sorted correctly.
    public void emailSortEnsure(int value) 
    {
    	
    	String [] list = new String [value];
    	String [] a = new String [list.length];
    	int k = 0;
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        for (WebElement name : gridData.findElements(By.xpath(".//tr[@class='odd compiled ng-scope' or @class='even compiled ng-scope']/td[@class='sorting_1']"))) 
        {
        	String s = name.getText();
        	list[k] = s;
        	int pos1 = list[k].indexOf(".");
        	int pos2 = list[k].indexOf("@");
        	String attr1 = list[k].substring(0, pos1);
        	String attr2 = list[k].substring(pos1+1, pos2);
        	System.out.print(list[k]);
        	System.out.print(" ; ");
        	a[k] = attr1 + attr2;
        	k++;
		}	
    		
    	boolean b = false;
    	
    	for (int i=0; i<list.length; i++) 
    	{
    		a[i] = list[i];
    	}
    	
    	for (int i=0; i<list.length; i++) 
    	{
    		for (int j=list.length-1; j>i; j--) 
    		{
    			if (a[j].compareTo(a[j-1])<0) 
    			{
    				b = true;
    				String temp = a[j];
    				a[j] = a[j-1];
    				a[j-1] = temp;
    			}
    		}  
    	}
    	if (b == false) System.out.println("Email values are sorted correctly.");
    }
	
    //To go to a certain page and then ensure that a correct page is opened.
    public void setPage(int value) {
    	if (pageInput.isEnabled()) pageInput.clear();
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    	String s = Integer.toString(value);
    	pageInput.sendKeys(s);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		goButton.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println(pageOf.getText());
	}
   
  //To go to a certain number of entries per page and then ensure that a correct number of entries is shown.
    public void setEntries(String value) {
    	if (pageLayout.isEnabled()) pageLayout.sendKeys(value);
    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println(entries.getText());
	}
    
}
