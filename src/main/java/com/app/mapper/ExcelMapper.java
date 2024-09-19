package com.app.mapper;

import com.app.enums.CompanyType;
import com.app.models.bank.BankAccount;
import com.app.models.employers.Company;
import com.app.models.employers.Individual;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;

public class ExcelMapper {
    public static String getCellValue(Cell cell) {
        return switch (cell.getCellType()) {
            case STRING -> cell.getStringCellValue();
            case NUMERIC -> (DateUtil.isCellDateFormatted(cell))
                    ? cell.getDateCellValue().toString()
                    : String.valueOf(cell.getNumericCellValue());
            case BOOLEAN -> String.valueOf(cell.getBooleanCellValue());
            case FORMULA -> cell.getCellFormula();
            default -> "";
        };
    }

    public static Company toCompany(Row row) {
        BankAccount bankAccount = toBankAccount(row);
        long id =(long)Double.parseDouble(getCellValue(row.getCell(0)));
        String email = getCellValue(row.getCell(2));
        String phone = getCellValue(row.getCell(3));
        String address = getCellValue(row.getCell(4));
        String name = getCellValue(row.getCell(11));
        CompanyType companyType = CompanyType.valueOf(getCellValue(row.getCell(12)).toUpperCase());

        return new Company(id, email, phone, address, bankAccount, name, companyType);
    }

    public static Individual toIndividual(Row row) {
        BankAccount bankAccount = toBankAccount(row);
        long id = (long) Double.parseDouble(getCellValue(row.getCell(0)).trim());
        String email = getCellValue(row.getCell(2));
        String phone = getCellValue(row.getCell(3));
        String address = getCellValue(row.getCell(4));
        String firstName = getCellValue(row.getCell(6));
        String lastName = getCellValue(row.getCell(7));
        boolean hasChildren = Boolean.parseBoolean(getCellValue(row.getCell(8)));
        int age = (int) Double.parseDouble(getCellValue(row.getCell(9)).trim());

        return new Individual(id, email, phone, address, bankAccount, firstName, lastName, hasChildren, age);
    }

    public static BankAccount toBankAccount(Row row) {
        String iban = getCellValue(row.getCell(14));
        String bic = getCellValue(row.getCell(15));
        String accountHolder = getCellValue(row.getCell(16));
        return new BankAccount(iban, bic, accountHolder);
    }
}

