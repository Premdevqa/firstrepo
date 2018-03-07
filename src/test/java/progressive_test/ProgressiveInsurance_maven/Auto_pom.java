package progressive_test.ProgressiveInsurance_maven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Auto_pom {
	
	String autobutton=".//*[@id='primary']/div/ul[1]/li[2]";
	String zipcode_txtbx=".//*[@id='zipCode_ueno']";
	String quoteauto_btn=".//*[@id='qsButton_ueno']";
	String firstname_txtbx=".//*[@id='NameAndAddressFormModel_FirstName_Value']";
	String Lastname_txtbx=".//*[@id='NameAndAddressFormModel_LastName_Value']";
	String address_txtbx=".//*[@id='NameAndAddressFormModel_MailingAddress_Value']";
	String aptno_txtbx=".//*[@id='NameAndAddressFormModel_ApartmentUnit_Value']";
	String month_txtbx=".//*[@id='NameAndAddressFormModel_DateOfBirth_Month']";
	String day_txtbx=".//*[@id='NameAndAddressFormModel_DateOfBirth_Day']";
	String year_txtbx=".//*[@id='NameAndAddressFormModel_DateOfBirth_Year']";
	
	WebDriver adriver;
	
	public Auto_pom(WebDriver driver){
		adriver=driver;
		
	}
	
	public WebElement auto_button() {
		
		WebElement autobtn=adriver.findElement(By.xpath(autobutton));
		return autobtn;
	}
	
    public WebElement zipcodetxtbx() {
		
		WebElement zipcode_txtbx1=adriver.findElement(By.xpath(zipcode_txtbx));
		return zipcode_txtbx1;
	}
    
    public WebElement quoteautobtn() {
	
	WebElement quoteauto_btn1=adriver.findElement(By.xpath(quoteauto_btn));
	return quoteauto_btn1;
    }
    
    public WebElement firstnametxtbx() {
	
	WebElement firstname_txtbx1=adriver.findElement(By.xpath(firstname_txtbx));
	return firstname_txtbx1;
    }

    
    

}
