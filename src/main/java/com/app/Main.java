package com.app;

import com.app.services.AbstractParserService;
import com.app.services.AbstractTaskService;
import com.app.services.CommonParserService;
import com.app.services.TaskService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter filename to parse: ");
        startExcelParserApp(new CommonParserService(String.format("src/main/resources/%s.xlsx", in.toString())), new TaskService());
    }

    public static void startExcelParserApp(AbstractParserService parserService, AbstractTaskService taskService) {
        parserService.parse();
        taskService.setData(parserService.getParsedData());
        taskService.completeTasks();
    }
}