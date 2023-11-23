package com.example.demo.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.exceptions.ExceptionUtils;
import com.example.demo.exceptions.GPSException;
import com.example.demo.model.ServicePackage;
import com.example.demo.repository.ServicePackageRepo;

@Service
public class ServicePackageServ {
	@Autowired
	ServicePackageRepo serviceRepo;

	public List<ServicePackage> getList() {
		return serviceRepo.findAll();
	}

	public Optional<ServicePackage> getOne(int id) {
		Optional<ServicePackage> service = serviceRepo.findById(id);
		if (service.isPresent()) {
			ServicePackage serviceBody = serviceRepo.findById(id).get();
			System.out.println(serviceBody);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not-found-with-id," + id);
		}
		return service;
	}

	public ServicePackage addService(ServicePackage service) {
		return serviceRepo.save(service);
	}

	public ServicePackage updateService(int id, ServicePackage service) {
		ServicePackage serviceId = serviceRepo.findById(id).orElseThrow(() -> new GPSException(ExceptionUtils.E_RECORD_NOT_EXIST));
		ServicePackage serviceBody = serviceRepo.findById(id).get();
		if(serviceId != null) {
			serviceBody.setName(service.getName());
			serviceBody.setCode(service.getCode());
			serviceBody.setDes(service.getDes());
			serviceBody.setPrice(service.getPrice());
			serviceBody.setTime(service.getTime());
		}	
		
		return serviceRepo.save(serviceBody);
	}

	public Boolean deleteService(int id) {
		serviceRepo.deleteById(id);
		return true;
	}

	public List<String> findByCodeAndName(String key) {
		if (serviceRepo.findByCodeAndName(key).size() <= 0)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not-found-with-name/provider," + key);
		return serviceRepo.findByCodeAndName(key);
	}
	
	public List<Map<String, Object>> findByType(String code) {
		if (serviceRepo.findByType(code).size() <= 0)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not-found-with-name," + code);
		return serviceRepo.findByType(code);
	}

}
