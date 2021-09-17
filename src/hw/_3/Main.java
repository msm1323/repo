package hw._3;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {             //  src/hw/_3/resources/companies.json
    public static void main(String[] args) throws IOException {
        Forming forming = new Forming();
        forming.form(args[0]);

        forming.shortNameFounded();       //#1
        forming.overdueSecurities();      //#2

        Scanner in = new Scanner(System.in);
        while (true) {
            String request = in.nextLine();
            try {                           //#3
                if (request.matches("\\d\\d\\.\\d\\d\\.\\d\\d\\d\\d")) {
                    forming.foundedAfter(LocalDate.parse(request, DateTimeFormatter.ofPattern("dd.MM.yyyy")));
                } else if (request.matches("\\d\\d\\.\\d\\d,\\d\\d")) {
                    forming.foundedAfter(LocalDate.parse(request, DateTimeFormatter.ofPattern("dd.MM,yy")).minusYears(1000));
                } else if (request.matches("\\d\\d/\\d\\d/\\d\\d\\d\\d")) {
                    forming.foundedAfter(LocalDate.parse(request, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                } else if (request.matches("\\d\\d/\\d\\d/\\d\\d")) {
                    forming.foundedAfter(LocalDate.parse(request, DateTimeFormatter.ofPattern("dd/MM/yy")).minusYears(1000));
                } else if (request.matches("EU|USD|RUB")) {         //#4
                    forming.securitiesCodesOfCompanies(request);
                } else {
                    System.out.println("Неверный формат запроса!");
                }
            } catch (DateTimeParseException ex) {
                System.out.println(ex.getMessage() + "\nНеккоректная дата!");
            }
        }

    }

}