package handling_mouse_actions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class GoogleAssignFrames {
	public static void main(String[] args) throws AWTException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//a[@aria-label='Google apps']")).click();
		driver.switchTo().frame(0);
		Actions a=new Actions(driver);
	    WebElement Music = driver.findElement(By.xpath("//span[text()='YouTube Music']"));
	    a.moveToElement(Music).perform();
	    a.contextClick(Music).perform();
	    Robot r=new Robot();
	    r.keyPress(KeyEvent.VK_T);
	    Set<String> allwid = driver.getWindowHandles();
	    for(String wid:allwid) {
	    	driver.switchTo().window(wid);
	    }
	    driver.findElement(By.xpath("//input[@id='input']")).sendKeys("nuvu simhame song tamil"+Keys.ENTER);
	    
	}

}
