package com.airquality.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.airquality.Helper.Helper;
import com.airquality.Model.Airqualitymonitor;
import com.airquality.repository.AirqualitymonitorRepo;
import com.airquality.service.ExcelService;

@Service
public class ExcelServiceImpl implements ExcelService {

	AirqualitymonitorRepo repository;

	public ExcelServiceImpl(AirqualitymonitorRepo repository) {
		this.repository = repository;
	}

	@Override
	public void saveExcelData(MultipartFile file) {
		try {
			List<Airqualitymonitor> airqualitymonitors = Helper.convertExcelToList(file.getInputStream());

			repository.saveAll(airqualitymonitors);

		} catch (Exception e) {
			System.out.println("Error while saving the data");
		}
	}

	@Override
	public List<Airqualitymonitor> listOfAirqualitymonitors() {
		return repository.findAll();
	}

	@Override
	public List<Airqualitymonitor> listOfInvalidData() {
		return repository.findAll().stream()
				.filter(aqm -> aqm.getDustParicle() > 15 || aqm.getDustParicle() < 1 || aqm.getCarbonDioxide() > 15
						|| aqm.getCarbonDioxide() < 1 || aqm.getCarbonMonoxide() > 15 || aqm.getCarbonMonoxide() < 1
						|| aqm.getNitrogenDioxide() > 15 || aqm.getNitrogenDioxide() < 1
						|| aqm.getSculptureDioxide() > 15 || aqm.getSculptureDioxide() < 1)
				.collect(Collectors.toList());
	}

}
