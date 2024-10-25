package com.dataquad.service;

import java.io.IOException;
import java.nio.file.attribute.UserPrincipalNotFoundException;
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

		List<ExcelDataModel> excelData = excelDataDao.findAll();
		if (excelData.isEmpty()) {
			throw new DataNotFoundException("Data Not Found");
		} else {
			return excelData;
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
