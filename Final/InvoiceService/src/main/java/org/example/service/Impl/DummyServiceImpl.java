package org.example.service.Impl;

import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.*;
import org.example.models.Dummy;
import org.example.service.DummyService;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.HashMap;

@Slf4j
@Service
public class DummyServiceImpl implements DummyService {
    @Override
    public Dummy generateFileInvoice(String filename) throws JRException {

        HashMap<String, Object> map = new HashMap<>();
        map.put("id", "1");
        map.put("username", "Nico");
        map.put("film_name", "Gotoubun No Hanayome The Movie 2022");
        map.put("seat_code", "13");
        map.put("studio_id", "C");
        map.put("schedule_id", "2022-09-01");
        map.put("ticket_price", "50000");
        InputStream employeeReportStream = getClass().getResourceAsStream("/Invoice.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(employeeReportStream);

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map);
        byte[] data = JasperExportManager.exportReportToPdf(jasperPrint);
        Dummy fileDataDB = new Dummy();
        fileDataDB.setData(data);
        fileDataDB.setFilename(filename);
        fileDataDB.setFileType("application/pdf");
        return fileDataDB;
    }

}
