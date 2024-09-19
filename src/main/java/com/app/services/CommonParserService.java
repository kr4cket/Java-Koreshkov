package com.app.services;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

import com.app.mapper.ExcelMapper;

public class CommonParserService extends AbstractParserService {

    public CommonParserService(String source) {
        super(source);
    }

    @Override
    public void parse() {
        for (Row row : this.sheet) {
            if (!this.isRowValid(row)) {
                continue;
            }

            boolean isIndividual = !ExcelMapper.getCellValue(row.getCell(7)).isEmpty()
                    || !ExcelMapper.getCellValue(row.getCell(8)).isEmpty();

            this.arrayList.add(isIndividual ? ExcelMapper.toIndividual(row) : ExcelMapper.toCompany(row));
        }
    }

    private boolean isRowValid(Row row) {
        if (row.getRowNum() == 0 || row.getRowNum() == 1 || row.getRowNum() == 2) {
            return false;
        }
        if (row.getCell(0) == null || row.getCell(0).getCellType() == CellType.BLANK) {
            return false;
        }

        return true;
    }
}
