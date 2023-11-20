package WithDataProvider;

import java.io.FileInputStream;
import java.util.Random;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import PojoClasses.PojoClassForProjectCreation_RMG;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

public class Excel_CreateMultipleProjects_RMG {
	@Test(dataProvider = "newdata")
	public void excel_CreateMultipleProjects_RMG(String createdBy, String projectName, String status, String teamSize) {
		int ts = Integer.parseInt(teamSize);
		baseURI="http://rmgtestingserver";
		port=8084;
		int ran = new Random().nextInt(1000);
		PojoClassForProjectCreation_RMG pojo= new PojoClassForProjectCreation_RMG(createdBy+ran, projectName+ran, status, ts);
		given()
		 .body(pojo)
		 .contentType(ContentType.JSON)
		 .when()
		 .post("/addProject")
		 .then()
		 .assertThat()
		 .statusCode(201)
		 .log().all();
	}

	@DataProvider(name = "newdata")
	public Object[][] data() throws Throwable {
	    FileInputStream fis = new FileInputStream("G:\\Selenium Practice\\Rest_Assured\\src\\main\\resources\\ExcelFiles\\DDTInput.xlsx");
	    Workbook wb = WorkbookFactory.create(fis);
	    Sheet sheet = wb.getSheet("Sheet1");
	    int LR = sheet.getLastRowNum() + 1;
	    int LC = sheet.getRow(0).getLastCellNum();
	    Object[][] obj = new Object[LR][LC];
	    for (int i = 0; i < LR; i++) {
	        for (int j = 0; j < LC; j++) {
	            obj[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
	        }
	    }
	    return obj;
	}


}
