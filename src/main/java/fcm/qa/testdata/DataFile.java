package fcm.qa.testdata;

import fcm.qa.util.Xls_Reader;

public class DataFile {

	public  Xls_Reader d = new Xls_Reader("C:\\QA\\Selanium_Workspace\\FreeCrmAutomationTest\\src\\main\\java\\fcm\\qa\\testdata\\data.xlsx");

	public  String name = d.getCellData("Sheet1", "Name", 2);
	public  String companyName = d.getCellData("Sheet1", "CompanyName", 2);
	public  String jobPosition = d.getCellData("Sheet1", "Job Position", 2);
	public  String phone = d.getCellData("Sheet1", "Phone", 2);
	public  String mobile = d.getCellData("Sheet1", "Mobile", 2);
	public  String emailD = d.getCellData("Sheet1", "Email", 2);
}
