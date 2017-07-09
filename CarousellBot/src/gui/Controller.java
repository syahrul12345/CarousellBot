package gui;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Controller {
private JPanel panel;
IndividualInfo individualInfo = new IndividualInfo();
SaleInfo saleInfo = new SaleInfo();

	public Controller() {
		
	}
	
	public void execute() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","/Users/muhdsyahrulnizam/Downloads/chromedriver");
		WebDriver chromeDriver = new ChromeDriver();
		String username = individualInfo.getUsername();
		String password = individualInfo.getPassword();
		String keyword = individualInfo.getKeyword();
		panel = new JPanel();
		ArrayList<String> list = new ArrayList<String>();
		chromeDriver.get("https://sg.carousell.com/login/?intent_sell=1&next=/");
		chromeDriver.findElement(By.id("username")).sendKeys(username);
		chromeDriver.findElement(By.id("password")).sendKeys(password);
		chromeDriver.findElement(By.xpath("//*[@id='root']/div/div[1]/div/form/button")).click();
		Thread.sleep(1000);
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
			
			String itemName = saleInfo.getItemName();
			String itemCat = saleInfo.getItemCat();
			String price = saleInfo.getPrice();
			String cond = saleInfo.getCond();
			String descText = saleInfo.getDescription();
			String deliveroption = saleInfo.getDeliveroption();
			String path = saleInfo.getPath();
			
			chromeDriver.findElement(By.xpath("//a[@id='navbarSellLink']")).click();
			chromeDriver.findElement(By.xpath("//input[@placeholder='Item name']")).sendKeys(itemName);
			chromeDriver.findElement(By.xpath("//div[@id='sellFormCategoryDropdown']")).click();
			chromeDriver.findElement(By.xpath("//div[contains(text(),'Everything Else')]")).click();
			chromeDriver.findElement((By.xpath("//div[contains(text(), 'Others')]"))).click();
			chromeDriver.findElement(By.xpath("//input[@type ='number']")).sendKeys(price);
			
			if(cond.equals("new")) {
				chromeDriver.findElement(By.xpath("//label[@for='formSellNewCondition']")).click();
			} else if(cond.equals("used")) {
				chromeDriver.findElement(By.xpath("//label[@for='formSellUsedCondition']")).click();
			}
			chromeDriver.findElement(By.id("formSellDescription")).sendKeys(descText);
			if(deliveroption.equals("meetup")) {
				chromeDriver.findElement(By.xpath("//label[@for='formSellDeliveryMeetupOption']")).click();
			} else if(deliveroption.equals("delivery")) {
				chromeDriver.findElement(By.xpath("//label[@for='formSellDeliveryMailOption']")).click();

			}
			chromeDriver.findElement(By.id("photo0")).sendKeys(path);
			chromeDriver.findElement(By.xpath("//*[@id='root']/div/div[1]/div/div/div[2]/div/form/div[4]/button")).click();
			
		}
	}


	public void addPersonInfo(String username, String keyword, String password) {
		individualInfo.addInfo(username,keyword,password);
		
	}

	public void addSaleInfo(String itemName, String itemCat, String price, String cond, String description,
			String deliveroption, String path) {
			saleInfo.addInfo(itemName,itemCat,price,cond,description,deliveroption,path);
	}

	public void loadImage(String path) {
		saleInfo.setPath(path);
		
		
	}

	public String getPath() {
		return saleInfo.getPath();
	}

	


	

	
	

}
