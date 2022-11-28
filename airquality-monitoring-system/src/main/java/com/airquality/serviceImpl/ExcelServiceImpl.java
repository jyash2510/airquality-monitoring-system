package com.airquality.serviceImpl;

import java.util.List;

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

}
