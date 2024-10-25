package com.dataquad.service;

import java.io.IOException;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataLocationNotFoundException;
import org.springframework.web.multipart.MultipartFile;

import com.dataquad.dao.AdminDao;
import com.dataquad.dao.ExcelDataDao;
import com.dataquad.exception.AdminNotFoundException;
import com.dataquad.exception.DataNotFoundException;
import com.dataquad.model.AdminDto;
import com.dataquad.model.AdminModel;
import com.dataquad.model.ExcelDataModel;

public class AdminService implements AdminserviceInterface {

	@Autowired
	public AdminDao adminDao;

	@Autowired
	public ModelMapper mapper;

	@Autowired
	public ExcelDataDao excelDataDao;

	@Override
	
	public AdminDto createAdmin(AdminDto adminDto) {

		AdminModel admin = mapper.map(adminDto, AdminModel.class);

		String firstName = admin.getFirstName();
		firstName = firstName + "@dataquad";

		admin.setPassword(firstName);
		adminDao.save(admin);

		return mapper.map(admin, AdminDto.class);
	}

	@Override
	public AdminDto loginAdmin(String username, String password) {
		AdminModel adminModel = adminDao.findById(username)
				.orElseThrow(() -> new AdminNotFoundException("No Details Found"));

		return mapper.map(adminModel, AdminDto.class);
	}

	@Override
	public List<ExcelDataModel> getExcelData() {

	//	List<ExcelDataModel> excelData = excelDataDao.findAll();
		
		 List<ExcelDataModel> dataList = new ArrayList<>();

	        // Create sample objects
	        ExcelDataModel data1 = new ExcelDataModel("Alice Smith", "A", "Ref123", "Recruiter A", 
	                "Team Alpha", "Full-time", "Java, Spring", "H1B", "None", 
	                "5 years", "123-456-7890", "987-654-3210", "alice@example.com", 
	                "New York", "1990-01-01", "1990-01-01", 
	                "https://linkedin.com/in/alicesmith", "Yes", "$50/hr", 
	                "Payroll A", "2023-01-15", "Active");

	        ExcelDataModel data2 = new ExcelDataModel("Bob Johnson", "B", "Ref456", "Recruiter B", 
	                "Team Beta", "Contract", "JavaScript, React", "L1", "None", 
	                "3 years", "123-456-7891", "987-654-3211", "bob@example.com", 
	                "Los Angeles", "1992-02-02", "1992-02-02", 
	                "https://linkedin.com/in/bobjohnson", "No", "$45/hr", 
	                "Payroll B", "2023-02-20", "Inactive");

	        ExcelDataModel data3 = new ExcelDataModel("Charlie Brown", "C", "Ref789", "Recruiter C", 
	                "Team Gamma", "Full-time", "Python, Django", "H1B", "None", 
	                "4 years", "123-456-7892", "987-654-3212", "charlie@example.com", 
	                "Chicago", "1991-03-03", "1991-03-03", 
	                "https://linkedin.com/in/charliebrown", "Yes", "$55/hr", 
	                "Payroll C", "2023-03-10", "Active");

	        ExcelDataModel data4 = new ExcelDataModel("Diana Prince", "A", "Ref101", "Recruiter D", 
	                "Team Delta", "Intern", "C++, Python", "OPT", "None", 
	                "1 year", "123-456-7893", "987-654-3213", "diana@example.com", 
	                "Seattle", "1993-04-04", "1993-04-04", 
	                "https://linkedin.com/in/dianaprince", "Yes", "$20/hr", 
	                "Payroll D", "2023-04-15", "Active");

	        ExcelDataModel data5 = new ExcelDataModel("Ethan Hunt", "B", "Ref202", "Recruiter E", 
	                "Team Epsilon", "Contract", "Java, Spring", "H1B", "None", 
	                "6 years", "123-456-7894", "987-654-3214", "ethan@example.com", 
	                "Boston", "1989-05-05", "1989-05-05", 
	                "https://linkedin.com/in/ethanhunt", "No", "$60/hr", 
	                "Payroll E", "2023-05-20", "Inactive");

	        // Add objects to the list
	        dataList.add(data1);
	        dataList.add(data2);
	        dataList.add(data3);
	        dataList.add(data4);
	        dataList.add(data5);
		if (dataList.isEmpty()) {
			throw new DataNotFoundException("Data Not Found");
		} else {
			return dataList;
		}
	}
	
	
	
	 public void saveExcelData(MultipartFile file) throws IOException {
	        try (XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream())) {
	            var sheet = workbook.getSheetAt(0);
	            Iterator<Row> rowIterator = sheet.iterator();

	            // Skip the first row (header)
	            if (rowIterator.hasNext()) {
	                rowIterator.next();
	            }

	            while (rowIterator.hasNext()) {
	                Row row = rowIterator.next();
	              //  User user = new User();
	                
	                ExcelDataModel dataModel=new ExcelDataModel();
	                
	           //     dataModel.setEmailId();
	                
	                // Assuming your Excel file has 24 columns; adjust indices as needed
//	                dataModel.setName(row.getCell(0).getStringCellValue());
//	                dataModel.setEmail(row.getCell(1).getStringCellValue());
//	                dataModel.setAge((int) row.getCell(2).getNumericCellValue()); // Example for an integer
	                
	                // Continue setting other fields based on your columns
	                // For example:
	                // user.setOtherField(row.getCell(3).getStringCellValue());

	                 excelDataDao.save(dataModel);
	            }

}
	 }
}
