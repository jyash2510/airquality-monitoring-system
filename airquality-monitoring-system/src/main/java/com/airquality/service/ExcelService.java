package com.airquality.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.airquality.Model.Airqualitymonitor;

public interface ExcelService {

    public void saveExcelData(MultipartFile file);

    public List<Airqualitymonitor> listOfAirqualitymonitors();
}
