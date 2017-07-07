package Model;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Controller {
private PersonInfo personInfo;
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
		chromeDriver.get("https://sg.carousell.com/login/?intent_sell=1&next=/");
		chromeDriver.findElement(By.id("username")).sendKeys(username);
		chromeDriver.findElement(By.id("password")).sendKeys(password);
		chromeDriver.findElement(By.xpath("//*[@id='root']/div/div[1]/div/form/button")).click();
		if(keyword.equals("")) {
			JOptionPane.showMessageDialog(null, "No keyword, wtf u expecting mate");
		} else {
			chromeDriver.get("https://sg.carousell.com/search/products/?query=" + keyword);
			System.out.println("keyword input");
		}
	}

}
