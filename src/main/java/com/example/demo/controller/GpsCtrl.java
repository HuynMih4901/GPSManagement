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

import com.example.demo.model.Gps;
import com.example.demo.security.SecurityUtils;
import com.example.demo.service.GpsServ;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Tag(name = "Gps", description = "API gps ")
@RestController
@RequestMapping("/api/gps")
@RequiredArgsConstructor
public class GpsCtrl {
	private final GpsServ gpsServ;

	@PostMapping
	@Operation(summary = "ADMIN - Thêm mới gps")
	@ApiResponse(responseCode = "201", description = "Thêm gps thành công")
	public ResponseEntity<?> create(
			//@RequestHeader(HttpHeaders.AUTHORIZATION) String token,
			@RequestBody @Valid Gps request) {
		//SecurityUtils.validateToken(token, SecurityUtils.ADMINS);
		gpsServ.addGps(request);
		System.out.println(gpsServ.addGps(request));
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@GetMapping("/")
	@Operation(summary = "ADMIN - Danh sách gps")
	@ApiResponse(responseCode = "200", description = "Lấy thành công")
	public ResponseEntity<?> get(
			//@RequestHeader(HttpHeaders.AUTHORIZATION) String token
			) {
		//SecurityUtils.validateToken(token, SecurityUtils.ADMINS);
		return ResponseEntity.ok(gpsServ.getList());
	}
	

	@PutMapping("/{id}")
	@Operation(summary = "ADMIN - Cập nhật gps")
	@ApiResponse(responseCode = "202", description = "Cập nhật gps thành công")
	public ResponseEntity<?> update(
			//@RequestHeader(HttpHeaders.AUTHORIZATION) String token, 
			@PathVariable int id,
			@RequestBody @Valid Gps request) {
		//SecurityUtils.validateToken(token, SecurityUtils.ADMINS);
		gpsServ.updateGps(id, request);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}

	@GetMapping("/{id}")
	@Operation(summary = "ADMIN - Chi tiết gps")
	@ApiResponse(responseCode = "200", description = "Lấy thành công")
	public ResponseEntity<?> get(
			//@RequestHeader(HttpHeaders.AUTHORIZATION) String token, 
			@PathVariable int id) {
		//SecurityUtils.validateToken(token, SecurityUtils.ADMINS);
		return ResponseEntity.ok(gpsServ.getOne(id));
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "ADMIN - Xoá gps")
	@ApiResponse(responseCode = "204", description = "Xoá thành công")
	public ResponseEntity<?> delete(
			//@RequestHeader(HttpHeaders.AUTHORIZATION) String token, 
			@PathVariable int id) {
		//SecurityUtils.validateToken(token, SecurityUtils.ADMINS);
		gpsServ.deleteGps(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@GetMapping("/{key}")
	@Operation(summary = "ADMIN - Danh sách/ Tìm gps theo provider/name")
	@ApiResponse(responseCode = "200", description = "Lấy thành công")
	public ResponseEntity<?> findGpsByProviderAndName(
			//@RequestHeader(HttpHeaders.AUTHORIZATION) String token,
			@Param(value = "key") String name) {
		//SecurityUtils.validateToken(token, SecurityUtils.ADMINS);
		return ResponseEntity.ok(gpsServ.findGpsByProviderAndName(name));
	}
	
	@GetMapping("/{type}")
	@Operation(summary = "ADMIN - Danh sách/ Tìm gps theo type")
	@ApiResponse(responseCode = "200", description = "Lấy thành công")
	public ResponseEntity<?> findByType(
			//@RequestHeader(HttpHeaders.AUTHORIZATION) String token,
			@Param(value = "type") String type) {
		//SecurityUtils.validateToken(token, SecurityUtils.ADMINS);
		return ResponseEntity.ok(gpsServ.findByType(type));
	}
}
