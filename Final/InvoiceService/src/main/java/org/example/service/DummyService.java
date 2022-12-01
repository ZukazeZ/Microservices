package org.example.service;

import net.sf.jasperreports.engine.JRException;
import org.example.models.Dummy;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;

@Service
public interface DummyService {
    Dummy generateFileInvoice(String filename) throws  FileNotFoundException, JRException;
}

