package Model;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Controller {
private PersonInfo personInfo;
private JPanel panel;
	public Controller() {
		
	}
	public void write(String username, String password, String keyword) {
		personInfo = new PersonInfo(username,password,keyword);
	}
	public void execute() {
		System.setProperty("webdriver.chrome.driver","/Users/muhdsyahrulnizam/Downloads/chromedriver");
		WebDriver chromeDriver = new ChromeDriver();
		String username = personInfo.getUsername();
		String password = personInfo.getPassword();
		String keyword = personInfo.getKeyword();
		panel = new JPanel();
		ArrayList<String> list = new ArrayList<String>();
		chromeDriver.get("https://sg.carousell.com/login/?intent_sell=1&next=/");
		chromeDriver.findElement(By.id("username")).sendKeys(username);
		chromeDriver.findElement(By.id("password")).sendKeys(password);
		chromeDriver.findElement(By.xpath("//*[@id='root']/div/div[1]/div/form/button")).click();
		
		if(chromeDriver.getCurrentUrl().equals("https://sg.carousell.com/login/?intent_sell=1&next=/")) {
			JOptionPane.showMessageDialog(panel, "Incorrect log in info!");
		}
		if(keyword.equals("")) {
			JOptionPane.showMessageDialog(null, "No keyword, wtf u expecting mate");
		} else {
			chromeDriver.get("https://sg.carousell.com/search/products/?query=" + keyword);
			int count2 = chromeDriver.findElements(By.xpath("//h3[@class='pdt-card-username media-heading']")).size();
			for(int j=0;j<count2;j++) {
				
				String text =chromeDriver.findElements(By.xpath("//h3[@class='pdt-card-username media-heading']")).get(j).getText(); //prints out the names of all selelrs with the KEYWORD search
				list.add(text);
			}
		}
		if(list.contains(username)) {
			JOptionPane.showMessageDialog(panel, "You already have a listing");
			chromeDriver.close();
		} else {
			String set = "new"; //convert to input field
			String meet = "meetup"; //convert to input field
			String descText = "text"; //convert to input field
			chromeDriver.findElement(By.xpath("//a[@id='navbarSellLink']")).click();
			chromeDriver.findElement(By.xpath("//input[@placeholder='Item name']")).sendKeys(keyword);
			chromeDriver.findElement(By.xpath("//div[@id='sellFormCategoryDropdown']")).click();
			chromeDriver.findElement(By.xpath("//div[contains(text(),'Everything Else')]")).click();
			chromeDriver.findElement((By.xpath("//div[contains(text(), 'Others')]"))).click();
			chromeDriver.findElement(By.xpath("//input[@type ='number']")).sendKeys("200.000 this is hardcoded change later");
			if(set.equals("new")) {
				chromeDriver.findElement(By.xpath("//label[@for='formSellNewCondition']")).click();
			} else if(set.equals("used")) {
				chromeDriver.findElement(By.xpath("//label[@for='formSellUsedCondition']")).click();
			}
			chromeDriver.findElement(By.id("formSellDescription")).sendKeys(descText);
			if(meet.equals("meetup")) {
				chromeDriver.findElement(By.xpath("//label[@for='formSellDeliveryMeetupOption']")).click();
			} else if(meet.equals("delivery")) {
				chromeDriver.findElement(By.xpath("//label[@for='formSellDeliveryMailOption']")).click();

			}
			
		}
	}

}
