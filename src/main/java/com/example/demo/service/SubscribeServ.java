package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.dto.subcrible.SubscribeCreateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.exceptions.ExceptionUtils;
import com.example.demo.exceptions.GPSException;
import com.example.demo.model.Subscribe;
import com.example.demo.repository.SubscribeRepo;



@RequiredArgsConstructor
@Service
public class SubscribeServ {

	private final SubscribeRepo subscribeRepo;
	private final AddressService addressService;


	public List<Subscribe> getList() {
		return subscribeRepo.findAll();
	}

	public Optional<Subscribe> getOne(int id) {
		Optional<Subscribe> subscribe = subscribeRepo.findById(id);
		if (subscribe.isPresent()) {
			Subscribe subscribeBody = subscribeRepo.findById(id).get();
			System.out.println(subscribeBody);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not-found-with-id," + id);
		}
		return subscribe;
	}

	public void addSubscribe(SubscribeCreateDTO request) {
		Subscribe newSubcrible =
				Subscribe.builder()
						.vehicle(request.getVehicle())
						.controlPlate(request.getControlPlate())
						.gps(request.getGps())
						.type(request.getType())
						.sim(request.getSim())
						.provider(request.getProvider())
						.service(request.getService())
						.des(request.getDes())
						.startDate(request.getStartDate())
						.enddate(request.getEnddate())
						.url(request.getUrl())
						.fullname(request.getFullname())
						.email(request.getEmail())
						.phone(request.getPhone())
						.username(request.getUsername())
						.password(request.getPassword())
						.status(request.getStatus())
						.ward(addressService.getWard(request.getWardCode()))
						.build();
		subscribeRepo.save(newSubcrible);
	}

	public Subscribe updateSubscribe(int id, Subscribe subscribe) {
		Subscribe subscribeId = subscribeRepo.findById(id).orElseThrow(() -> new GPSException(ExceptionUtils.E_RECORD_NOT_EXIST));
		Subscribe subscribeBody = subscribeRepo.findById(id).get();
		if (subscribeId != null) {
			subscribeBody.setControlPlate(subscribe.getControlPlate());
			subscribeBody.setDes(subscribe.getDes());
			subscribeBody.setEmail(subscribe.getEmail());
			subscribeBody.setEnddate(subscribe.getEnddate());
			subscribeBody.setFullname(subscribe.getFullname());
			subscribeBody.setGps(subscribe.getGps());
			subscribeBody.setPassword(subscribe.getPassword());
			subscribeBody.setPhone(subscribe.getPhone());
			subscribeBody.setProvider(subscribe.getProvider());
			subscribeBody.setService(subscribe.getService());
			subscribeBody.setSim(subscribe.getSim());
			subscribeBody.setStartDate(subscribe.getStartDate());
			subscribeBody.setStatus(subscribe.getStatus());
			subscribeBody.setType(subscribe.getType());
			subscribeBody.setUrl(subscribe.getUrl());
			subscribeBody.setUsername(subscribe.getUsername());
			subscribeBody.setVehicle(subscribe.getVehicle());
			
		}

		return subscribeRepo.save(subscribeBody);
	}

	public Boolean deleteSubscribe(int id) {
		subscribeRepo.deleteById(id);
		return true;
	}
	
	public List<String> findSubscribe(String key) {
		if (subscribeRepo.findSubscribe(key).size() <= 0)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not-found-with-name," + key);
		return subscribeRepo.findSubscribe(key);
	}

}
