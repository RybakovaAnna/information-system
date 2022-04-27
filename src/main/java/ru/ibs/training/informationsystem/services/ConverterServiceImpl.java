package ru.ibs.training.informationsystem.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ibs.training.informationsystem.model.report.ReportEntity;
import ru.ibs.training.informationsystem.repositories.report.ReportRepository;
import ru.ibs.training.informationsystem.services.interfaces.ConverterService;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

@Service
public class ConverterServiceImpl implements ConverterService {

    private final ReportRepository repository;

    @Autowired
    public ConverterServiceImpl(ReportRepository repository) {
        this.repository = repository;
    }

    @Override
    public Document convertToPDF(Long id) throws DocumentException, FileNotFoundException {
        ReportEntity reportEntity = repository.getById(id);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(reportEntity.toString());
        String prettyJsonString = gson.toJson(je);

        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("myJSON.pdf"));

        document.open();
        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
        Chunk chunk = new Chunk(prettyJsonString, font);

        document.add(chunk);
        document.close();

        return document;
    }

    @Override
    public Document convertToHTML(Long id) {
        return null;
    }
}
