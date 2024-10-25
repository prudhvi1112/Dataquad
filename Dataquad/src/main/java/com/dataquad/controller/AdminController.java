package com.dataquad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dataquad.model.AdminDto;
import com.dataquad.model.AdminModel;
import com.dataquad.model.ExcelDataModel;
import com.dataquad.service.AdminService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	public AdminService adminService;

	@PostMapping("/")
	public ResponseEntity<AdminDto> createAdmin(@Valid @RequestBody AdminDto adminDto) {
		AdminDto admin = adminService.createAdmin(adminDto);

		return new ResponseEntity<AdminDto>(admin, HttpStatus.CREATED);

	}

	@GetMapping("/")
	public ResponseEntity<AdminDto> loginAdmin(@RequestParam("username") String username,
			@RequestParam("password") String password) {
		AdminDto adminDto = adminService.loginAdmin(username, password);

		return new ResponseEntity<AdminDto>(adminDto, HttpStatus.FOUND);

	}
	
	
	
//	@PostMapping("/upload")
//    public ResponseEntity<String> uploadExcelFile(@RequestParam("file") MultipartFile file) {
//        try {
//            adminService.saveExcelData(file);
//            return ResponseEntity.ok("File uploaded and data saved successfully.");
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing file.");
//        }
//    }
//	
	
	@GetMapping("/data")
	public ResponseEntity<List<ExcelDataModel>> getExcelData()
	{
		return new ResponseEntity<List<ExcelDataModel>>(adminService.getExcelData(), HttpStatus.OK);
		
	}

}
