package frameWork;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import com.mysql.cj.jdbc.Driver;
import Generic_Utils.EndPoints;
import Generic_Utils.IConstant_API;
import Generic_Utils.Java_Utils;
import static io.restassured.RestAssured.*;

public class GUI_ProjectCreationAndValidation {
	@Test
	public void gUI_ProjectCreationAndValidation() throws Throwable {
		// GUI config
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver:8084/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		Java_Utils ju = new Java_Utils();
		String PN = "Proj__" + ju.randomIntegerNumber(1000);

		baseURI = "http://rmgtestingserver";
		port = 8084;
		
		// Login in to app
		driver.findElement(By.xpath("//input[@id='usernmae']")).sendKeys("rmgyantra");
		driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();

		// Create Project
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys(PN);
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("Dinga__" + ju.randomIntegerNumber(1000));
		Select sel = new Select(driver.findElement(By.xpath("(//select[@name='status'])[2]")));
		sel.selectByVisibleText("Created");
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		// get Project ID
		String Pid = driver.findElement(By.xpath("(//td[text()='" + PN + "']/ancestor::tr/td)[1]")).getText();
		System.out.println(Pid);

		// API get project
		when().get(EndPoints.getSingleProject + Pid).then().log().all();

		// DataBase Validation
		String query = "SELECT * FROM PROJECT;";
		Driver drive = new Driver();
		DriverManager.registerDriver(drive);
		Connection con = DriverManager.getConnection(IConstant_API.RMG_DBURL, IConstant_API.RMG_DBUS,
				IConstant_API.RMG_DBPSD);
		Statement state = con.createStatement();
		ResultSet res = state.executeQuery(query);
		boolean flag = false;
		for (;res.next();) {
			if (Pid.equals(res.getString(1))) {
				flag = true;
				break;
			}
		}
		if (flag) {
			System.out.println("Data is Present in DB");
		} else {
			System.out.println("Data is not Present in DB");
		}
		driver.quit();
	}
}
