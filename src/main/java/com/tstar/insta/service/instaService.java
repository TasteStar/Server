package com.tstar.insta.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Service;

@Service
public class instaService {

	public static String getInstaHeadData(WebDriver driver, WebDriverWait wait, String Tag) {
			String result = "";
			System.out.println(driver.getTitle());
	/*		WebElement coolestWidgetEvah = driver.findElement(By.id("coolestWidgetEvah")); //id로 Element 가져오기
	        WebElement cheese = driver.findElements(By.className("cheese")); //클래스이름으로 Element 가져오기
	        WebElement iframe = driver.findElement(By.tagName("iframe")); //태그이름으로 Element 가져오기
	*/		
			try {
			driver.get("https://www.instagram.com/explore/tags/".concat(URLEncoder.encode(Tag, "UTF-8")));
			 
			WebElement findHeaderTag = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//header/div[2]/div/h1")));
			WebElement findHeaderPostCount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//header/div[2]/div[2]/span")));
			WebElement findHeaderImg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//header/div/div/div/img")));
			System.out.println(findHeaderTag.getText());
			System.out.println(findHeaderPostCount.getText());
			System.out.println(findHeaderImg.getAttribute("src"));
			//System.out.println(findHeader.getAttribute("//img/@src"));
			System.out.println("==================");
			//System.out.println(findHeader2.getText());
			result = "suc";
			}
			catch (UnsupportedEncodingException e) {
				result = "fail";
				e.printStackTrace();
			}
		
		
		return result;
	}
	
	public static String getInstaArticleData(WebDriver driver, WebDriverWait wait, String Tag) {
		String result = "";
//		List atclList = new ArrayList(); 
		System.out.println(driver.getTitle());
/*		WebElement coolestWidgetEvah = driver.findElement(By.id("coolestWidgetEvah")); //id로 Element 가져오기
        WebElement cheese = driver.findElements(By.className("cheese")); //클래스이름으로 Element 가져오기
        WebElement iframe = driver.findElement(By.tagName("iframe")); //태그이름으로 Element 가져오기
*/		
	//	JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
		
		driver.get("https://www.instagram.com/explore/tags/".concat(URLEncoder.encode(Tag, "UTF-8")));
	//	WebElement Element = driver.findElement((By.linkText("VBScript")));
		
		
		int roop = 2;
		//'//*[@id="react-root"]/section/main/article/div[2]/div/div[1]/div[1]/a/div'
		WebElement findArtcle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"react-root\"]/section/main/article/div[2]/div/div[1]/div[1]/a/div")));
		WebElement findArtcleList = driver.findElement(By.xpath("//*[@id=\"react-root\"]/section/main/article/div[2]/div"));
		List<WebElement> elements = findArtcleList.findElements(By.xpath("//div"));
		System.out.println(findArtcleList.getAttribute("innerHTML"));
	
		/*for (WebElement objLink : elements) {
			
			System.out.println(objLink.getAttribute("innerHTML"));
			System.out.println("==================");
		}*/
	//	System.out.println(findArtcleList.getAttribute("innerHTML"));
	//	WebElement findArtcleList = (WebElement) driver.findElements(By.xpath("//*[@id=\"react-root\"]/section/main/article/div[2]/div/div"));
		
		/*for (WebElement objLink : findArtcleList) {
			//objLink.getText();
	
			String strLinkText = objLink.getText();
			System.out.println("text : "+ objLink.getAttribute("innerHTML"));
			System.out.println("==================");
		}*/
	

		//System.out.println("text : "+findArtcle.getText());
		System.out.println("==================");
		//System.out.println(findArtcle.getAttribute("innerHTML"));
		//System.out.println(findHeader.getAttribute("//img/@src"));
		System.out.println("==================");
		//System.out.println("List : "+findArtcleList.getAttribute("innerHTML"));
		//System.out.println(findHeader2.getText());
		//result = findArtcleList.getAttribute("innerHTML");
		
		
		 for(int i = 0 ; i < roop ; i++){
			 	System.out.println(i);
			//   js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			 //i++;
		 }
		
		}
		catch (UnsupportedEncodingException e) {
			result = "fail";
			e.printStackTrace();
		}
		
		return result;
	}

	
	
}
