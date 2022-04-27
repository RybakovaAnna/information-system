package ru.ibs.training.informationsystem.services.interfaces;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;

import java.io.FileNotFoundException;

public interface ConverterService {

    Document convertToPDF(Long id) throws DocumentException, FileNotFoundException;
    Document convertToHTML(Long id);
}
