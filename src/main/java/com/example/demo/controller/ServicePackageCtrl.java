package com.example.demo.controller;

import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ServicePackage;
import com.example.demo.security.SecurityUtils;
import com.example.demo.service.ServicePackageServ;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Tag(name = "servicepackage", description = "API service ")
@RestController
@RequestMapping("/api/service")
@RequiredArgsConstructor
public class ServicePackageCtrl {
	private final ServicePackageServ servicePackageServ;

	@PostMapping
	@Operation(summary = "ADMIN - Thêm mới service")
	@ApiResponse(responseCode = "201", description = "Thêm service thành công")
	public ResponseEntity<?> create(
			//@RequestHeader(HttpHeaders.AUTHORIZATION) String token,
			@RequestBody @Valid ServicePackage request) {
		//SecurityUtils.validateToken(token, SecurityUtils.ADMINS);
		servicePackageServ.addService(request);
		System.out.println(servicePackageServ.addService(request));
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@GetMapping("/")
	@Operation(summary = "ADMIN - Danh sách service")
	@ApiResponse(responseCode = "200", description = "Lấy thành công")
	public ResponseEntity<?> get(
			//@RequestHeader(HttpHeaders.AUTHORIZATION) String token
			) {
		//SecurityUtils.validateToken(token, SecurityUtils.ADMINS);
		return ResponseEntity.ok(servicePackageServ.getList());
	}
	

	@PutMapping("/{id}")
	@Operation(summary = "ADMIN - Cập nhật service")
	@ApiResponse(responseCode = "202", description = "Cập nhật service thành công")
	public ResponseEntity<?> update(
			//@RequestHeader(HttpHeaders.AUTHORIZATION) String token, 
			@PathVariable int id,
			@RequestBody @Valid ServicePackage request) {
		//SecurityUtils.validateToken(token, SecurityUtils.ADMINS);
		servicePackageServ.updateService(id, request);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}

	@GetMapping("/{id}")
	@Operation(summary = "ADMIN - Chi tiết service")
	@ApiResponse(responseCode = "200", description = "Lấy thành công")
	public ResponseEntity<?> get(
			//@RequestHeader(HttpHeaders.AUTHORIZATION) String token, 
			@PathVariable int id) {
		//SecurityUtils.validateToken(token, SecurityUtils.ADMINS);
		return ResponseEntity.ok(servicePackageServ.getOne(id));
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "ADMIN - Xoá service")
	@ApiResponse(responseCode = "204", description = "Xoá thành công")
	public ResponseEntity<?> delete(
			//@RequestHeader(HttpHeaders.AUTHORIZATION) String token, 
			@PathVariable int id) {
		//SecurityUtils.validateToken(token, SecurityUtils.ADMINS);
		servicePackageServ.deleteService(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@GetMapping("/{key}")
	@Operation(summary = "ADMIN -  Tìm service theo code/name")
	@ApiResponse(responseCode = "200", description = "Lấy thành công")
	public ResponseEntity<?> findservicePackageByProviderAndName(
			//@RequestHeader(HttpHeaders.AUTHORIZATION) String token,
			@Param(value = "key") String key) {
		//SecurityUtils.validateToken(token, SecurityUtils.ADMINS);
		return ResponseEntity.ok(servicePackageServ.findByCodeAndName(key));
	}
	
	@GetMapping("/{type}")
	@Operation(summary = "ADMIN -  Tìm service theo type")
	@ApiResponse(responseCode = "200", description = "Lấy thành công")
	public ResponseEntity<?> findByType(
			//@RequestHeader(HttpHeaders.AUTHORIZATION) String token,
			@Param(value = "code") String code) {
		//SecurityUtils.validateToken(token, SecurityUtils.ADMINS);
		return ResponseEntity.ok(servicePackageServ.findByType(code));
	}
}
