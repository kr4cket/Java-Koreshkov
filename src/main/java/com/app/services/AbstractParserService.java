package com.app.services;

import com.app.models.employers.Employee;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public abstract class AbstractParserService {
    protected String source;
    protected Workbook workbook;
    protected Sheet sheet;
    protected ArrayList<Employee> arrayList;

    public AbstractParserService(String source) {
        try {
            this.source = source;
            this.workbook = new XSSFWorkbook(new FileInputStream(new File(source)));
            this.sheet = workbook.getSheetAt(0);
            this.arrayList = new ArrayList<>();
        } catch (IOException e) {
            System.out.println("Ошибка инициализации парсера: \n" + e.getMessage());
        }
    }

    /**
     * Method returns parsed data
     */
    public ArrayList<Employee> getParsedData() {
        return arrayList;
    }

    /**
     * Method parses excel file
     */
    abstract public void parse();
}
