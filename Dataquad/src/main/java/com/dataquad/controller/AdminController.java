package com.dataquad.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dataquad.model.AdminDto;
import com.dataquad.model.ExcelDataModel;
import com.dataquad.service.AdminService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/admin")
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	public AdminService adminService;

	@PostMapping("/")
	public ResponseEntity<AdminDto> createAdmin(@Valid @RequestBody AdminDto adminDto) {
		logger.info("Creating admin with username: {}", adminDto.getFirstName());
		AdminDto admin = adminService.createAdmin(adminDto);
		logger.info("Admin created successfully: {}", admin);

		return new ResponseEntity<>(admin, HttpStatus.CREATED);
	}

	@GetMapping("/")
	public ResponseEntity<AdminDto> loginAdmin(@RequestParam("username") String username,
			@RequestParam("password") String password) {
		logger.info("Attempting to log in admin with username: {}", username);
		AdminDto adminDto = adminService.loginAdmin(username, password);

		if (adminDto != null) {
			logger.info("Admin logged in successfully: {}", adminDto);
			return new ResponseEntity<>(adminDto, HttpStatus.OK);
		} else {
			logger.warn("Login failed for username: {}", username);
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}

	@GetMapping("/data")
	public ResponseEntity<List<ExcelDataModel>> getExcelData() {
		logger.info("Fetching Excel data");
		List<ExcelDataModel> excelData = adminService.getExcelData();
		logger.info("Excel data fetched successfully, total records: {}", excelData.size());

		return new ResponseEntity<>(excelData, HttpStatus.OK);
	}


	/*
	 * @PostMapping("/upload") public ResponseEntity<String>
	 * uploadExcelFile(@RequestParam("file") MultipartFile file) {
	 * logger.info("Received file upload request for file: {}",
	 * file.getOriginalFilename()); try { adminService.saveExcelData(file);
	 * logger.info("File uploaded and data saved successfully."); return
	 * ResponseEntity.ok("File uploaded and data saved successfully."); } catch
	 * (Exception e) { logger.error("Error processing file: {}", e.getMessage(), e);
	 * return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
	 * body("Error processing file."); } }
	 */
}
