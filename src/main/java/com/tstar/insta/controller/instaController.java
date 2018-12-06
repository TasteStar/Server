package com.tstar.insta.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.options;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gargoylesoftware.htmlunit.javascript.host.dom.Document;
import com.tstar.insta.service.instaService;

@Controller
public class instaController {
	
	
	@RequestMapping(value = "/instaMain", method = {RequestMethod.POST, RequestMethod.GET})
	public String loginview(Model model, HttpServletRequest request, HttpServletResponse reponse) {
		    
			

		return "/jsp/index";
	}
	
	
	@RequestMapping(value = "/parseInstaHeader/{tagName}", method = {RequestMethod.POST, RequestMethod.GET},produces = "application/json; charset=utf8")
	@ResponseBody
	public String parseInstaHeader(@PathVariable("tagName") String tagName,HttpServletRequest request, HttpServletResponse reponse) throws UnsupportedEncodingException{
		System.setProperty("webdriver.chrome.driver", "D:/neon/Tstar/tstar/src/main/webapp/resources/win32/chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
	
        options.addArguments("headless");
        options.addArguments("window-size=1920x1080");
        options.addArguments("disable-gpu");
        options.addArguments("user-agent=Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36");
        WebDriver driver = new ChromeDriver(options);
    	WebDriverWait wait = new WebDriverWait(driver, 5);
        String rs ="";
		
		if(tagName==null || "".equals(tagName)){
			driver.quit();
			return "{\"status\" : \"ERR\"}";
		}else{
		
			
			rs = instaService.getInstaHeadData(driver, wait, tagName);

			
			driver.quit();
		}
		return rs;
	}
	
	@RequestMapping(value = "/parseInsta/{tagName}", method = {RequestMethod.POST, RequestMethod.GET},produces = "application/json; charset=utf8")
	@ResponseBody
	public String parseInsta(@PathVariable("tagName") String tagName,HttpServletRequest request, HttpServletResponse reponse) throws UnsupportedEncodingException{
		System.setProperty("webdriver.chrome.driver", "D:/neon/Tstar/tstar/src/main/webapp/resources/win32/chromedriver.exe");
		
		
		//driver = this.setChrome();
		ChromeOptions options = new ChromeOptions();
		
        options.addArguments("headless");
        options.addArguments("window-size=1920x1080");
        options.addArguments("disable-gpu");
        options.addArguments("user-agent=Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36");
        WebDriver driver = new ChromeDriver(options);
    	WebDriverWait wait = new WebDriverWait(driver, 5);
        String rs ="";
		
		if(tagName==null || "".equals(tagName)){
			driver.quit();
			return "{\"status\" : \"ERR\"}";
		}else{
		
			
			rs = instaService.getInstaArticleData(driver, wait, tagName);

			
			driver.quit();
		}
		return rs;
	}
	

	
}
