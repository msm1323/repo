package hw._3;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Forming {

    private List<Company> companies = new LinkedList<>();

    public void form(String p) throws IOException {
        JSONObject jsonObject = new JSONObject(Files.readString(Path.of(p).toAbsolutePath()));
        JSONArray jsonArray = jsonObject.getJSONArray("companies");

        for (int i = 0; i < jsonArray.length(); i++) {
            companies.add(new Company(jsonArray.getJSONObject(i).get("id"), jsonArray.getJSONObject(i).get("name"),
                    jsonArray.getJSONObject(i).get("address"), jsonArray.getJSONObject(i).get("phoneNumber"),
                    jsonArray.getJSONObject(i).get("inn"), jsonArray.getJSONObject(i).get("founded")
                    , (JSONArray) jsonArray.getJSONObject(i).get("securities")));
        }
    }

    public void shortNameFounded() {        //#1
        companies.forEach(Company::shortNameFounded);
    }

    public void overdueSecurities() {       //#2
        int counter = 0;
        System.out.println("\nПросроченные ценные бумаги:");
        for (Company company : companies) {
            List<Company.Security> securities = company.getSecurities().stream()
                    .filter(s -> s.getDate().isBefore(LocalDate.now()))
                    .collect(Collectors.toList());
            securities.forEach(Company.Security::print);
            counter += securities.size();
        }
        System.out.println("\nКоличество просроченных ценных бумаг: " + counter);
    }

    public void foundedAfter(LocalDate date) {       //#3
        companies.stream().filter(company -> company.getFounded().isAfter(date)).forEach(Company::printNameFounded);
    }

    public void securitiesCodesOfCompanies(String userCur) {        //#4
        for (Company company : companies) {
            List<Company.Security> securities = company.getSecurities().stream()
                    .filter(s -> s.getCurrency().contains(userCur)).collect(Collectors.toList());
            if (!securities.isEmpty()) {
                System.out.println(company.getId());
                securities.forEach(Company.Security::printCode);
            }
        }
    }

}
