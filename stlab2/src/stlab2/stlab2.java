package stlab2;
import java.io.File;
import java.nio.charset.Charset;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.csvreader.CsvReader;

public class stlab2 {
	static Thread th = new Thread(); 

	@Test
	public void main() throws Exception {
		WebDriver driver = new FirefoxDriver();		
		CsvReader r = new CsvReader("C://Users//ebbtide//Desktop//inputgit.csv", ',',Charset.forName("UTF-8"));
		r.readHeaders();
    	while (r.readRecord()) {
    		String id = r.get("学号");
    		String password = id.substring(4);
    		String github1 = r.get("github地址");
    		driver.get("http://121.193.130.195:8080/");  
    		th.sleep(1000);
            WebElement txtbox1 = driver.findElement(By.id("name"));
            txtbox1.sendKeys(id);
            WebElement txtbox2 = driver.findElement(By.id("pwd"));
            txtbox2.sendKeys(password);
            WebElement btn = driver.findElement(By.id("submit"));
            btn.click();
            th.sleep(1000);
            
            WebElement text = driver.findElement(By.xpath("//*[@id='table-main']/tr[3]/td[2]"));
            String github2 = text.getText();
            assertEquals(github1,github2);
        }
        r.close();
	}

}
