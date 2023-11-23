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
import com.example.demo.model.Gps;
import com.example.demo.repository.GpsRepo;

@Service

public class GpsServ {
	@Autowired
	GpsRepo gpsRepo;

	public List<Gps> getList() {
		return gpsRepo.findAll();
	}

	public Optional<Gps> getOne(int id) {
		Optional<Gps> gps = gpsRepo.findById(id);
		if (gps.isPresent()) {
			Gps gpsBody = gpsRepo.findById(id).get();
			System.out.println(gpsBody);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not-found-with-id," + id);
		}
		return gps;
	}

	public Gps addGps(Gps gps) {
		return gpsRepo.save(gps);
	}

	public Gps updateGps(int id, Gps gps) {
		Gps gpsId = gpsRepo.findById(id).orElseThrow(() -> new GPSException(ExceptionUtils.E_RECORD_NOT_EXIST));
		Gps gpsBody = gpsRepo.findById(id).get();
		if(gpsId != null) {
			gpsBody.setName(gps.getName());
			gpsBody.setUrl(gps.getUrl());
			gpsBody.setProvider(gps.getProvider());
			gpsBody.setInventory(gps.getInventory());
			gpsBody.setDes(gps.getDes());
			gpsBody.setImportPrice(gps.getImportPrice());
			gpsBody.setQuantity(gps.getQuantity());
			gpsBody.setSalePrice(gps.getSalePrice());
			gpsBody.setCode(gps.getCode());
		}	
		
		return gpsRepo.save(gpsBody);
	}

	public Boolean deleteGps(int id) {
		gpsRepo.deleteById(id);
		return true;
	}

	public List<String> findGpsByProviderAndName(String name) {
		if (gpsRepo.findGpsByProviderAndName(name).size() <= 0)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not-found-with-name/provider,");
		return gpsRepo.findGpsByProviderAndName(name);
	}
	
	public List<Map<String, Object>> findByType(String code) {
		if (gpsRepo.findByType(code).size() <= 0)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not-found-with-name," + code);
		return gpsRepo.findByType(code);
	}

}
