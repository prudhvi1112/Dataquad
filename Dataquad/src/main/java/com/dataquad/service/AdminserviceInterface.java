package com.dataquad.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dataquad.model.AdminDto;
import com.dataquad.model.AdminModel;
import com.dataquad.model.ExcelDataModel;

@Service
public interface AdminserviceInterface
{
	
	public AdminDto createAdmin(AdminDto adminDto);
	
	public AdminDto loginAdmin(String username,String password);
	
	public List<ExcelDataModel> getExcelData();
	


}
