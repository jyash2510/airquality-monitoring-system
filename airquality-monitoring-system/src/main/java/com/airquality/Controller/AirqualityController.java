package com.airquality.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.airquality.Helper.Helper;
import com.airquality.Model.Airqualitymonitor;
import com.airquality.service.ExcelService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class AirqualityController {

    @Autowired
    ExcelService excelService;

    // localhost:8080/save

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestParam("file") MultipartFile file) {

        if (Helper.checkExcelType(file)) {

            excelService.saveExcelData(file);

            return ResponseEntity.status(HttpStatus.OK).body("File is uploaded and data saved successfully");

        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("The file type is incorrect. Please choose Excel file");
    }

    // localhost:8080/list
    @GetMapping("/list")
    public List<Airqualitymonitor> getListOfAirqualitymonitors() {
        return excelService.listOfAirqualitymonitors();
    }

}
