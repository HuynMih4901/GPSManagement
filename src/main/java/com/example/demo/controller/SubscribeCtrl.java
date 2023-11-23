package com.example.demo.controller;

import com.example.demo.model.Subscribe;
import com.example.demo.security.SecurityUtils;
import com.example.demo.service.SubscribeServ;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Subscribe", description = "API subscribe")
@RestController
@RequestMapping("/api/subscribe")
@RequiredArgsConstructor
public class SubscribeCtrl {

	private final SubscribeServ subscribeServ;

	@PostMapping
	@Operation(summary = "ADMIN - Thêm mới subscribe")
	@ApiResponse(responseCode = "201", description = "Thêm subscribe thành công")
	public ResponseEntity<?> create(
			// @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
			@RequestBody @Valid Subscribe request) {
		// SecurityUtils.validateToken(token, SecurityUtils.ADMINS);
		subscribeServ.addSubscribe(request);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@PutMapping("/{id}")
	@Operation(summary = "ADMIN - Cập nhật subscribe")
	@ApiResponse(responseCode = "202", description = "Cập nhật cung cấp thành công")
	public ResponseEntity<?> update(
			// @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
			@PathVariable int id, @RequestBody @Valid Subscribe request) {
		// SecurityUtils.validateToken(token, SecurityUtils.ADMINS);
		subscribeServ.updateSubscribe(id, request);
		return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}

	@GetMapping("/{id}")
	@Operation(summary = "ADMIN - Chi tiết subscribe")
	@ApiResponse(responseCode = "200", description = "Lấy thành công")
	public ResponseEntity<?> get(
			// @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
			@PathVariable int id) {
		// SecurityUtils.validateToken(token, SecurityUtils.ADMINS);
		return ResponseEntity.ok(subscribeServ.getOne(id));
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "ADMIN - Xoá subscribe")
	@ApiResponse(responseCode = "204", description = "Xoá thành công")
	public ResponseEntity<?> delete(
			// @RequestHeader(HttpHeaders.AUTHORIZATION) String token,
			@PathVariable int id) {
		// SecurityUtils.validateToken(token, SecurityUtils.ADMINS);
		subscribeServ.deleteSubscribe(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@GetMapping
	@Operation(summary = "ADMIN - Tìm subscribe")
	@ApiResponse(responseCode = "200", description = "Lấy thành công")
	public ResponseEntity<?> find(
			//@RequestHeader(HttpHeaders.AUTHORIZATION) String token,
			@Param(value = "key") String key) {
		//SecurityUtils.validateToken(token, SecurityUtils.ADMINS);
		return ResponseEntity.ok(subscribeServ.findSubscribe(key));
	}
}