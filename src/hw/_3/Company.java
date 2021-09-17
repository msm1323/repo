package hw._3;

import org.json.JSONArray;
import org.json.JSONObject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

public class Company {
    private int id;
    private String name;
    private String address;
    private String phoneNumber;
    private String inn;
    private LocalDate founded;
    private List<Security> securities = new LinkedList<>();

    public Company(Object id, Object name, Object address, Object phoneNumber, Object inn, Object founded
            , JSONArray jArrSecurities) {
        this.id = (Integer) id;
        this.name = (String) name;
        this.address = (String) address;
        this.phoneNumber = (String) phoneNumber;
        this.inn = (String) inn;
        this.founded = LocalDate.parse((CharSequence) founded, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        for (int i = 0; i < jArrSecurities.length(); i++) {
            JSONObject jsObj = (JSONObject) jArrSecurities.get(i);
            JSONArray jsArrCurr = jsObj.getJSONArray("currency");
            securities.add(new Security(jsObj.get("name"), jsArrCurr, jsObj.get("code"), jsObj.get("date")));
        }
    }

    public int getId() {
        return id;
    }

    public LocalDate getFounded() {
        return founded;
    }

    public List<Security> getSecurities() {
        return securities;
    }

    public void printNameFounded() {
        System.out.println(name);
        System.out.println(founded);
    }

    public void print() {
        System.out.println("__________________________________________");
        System.out.println(name);
        System.out.println("id: " + id);
        System.out.println("address: " + address);
        System.out.println("phoneNumber: " + phoneNumber);
        System.out.println("inn: " + inn);
        System.out.println("founded: " + founded);
        System.out.println("securities:");
        securities.forEach(Security::print);
    }

    public void shortNameFounded() {
        System.out.println(name + " - Дата основания " + founded.format(DateTimeFormatter.ofPattern("dd/MM/yy")));
    }

    static class Security {
        private String name;
        private List<String> currency = new LinkedList<>();
        private String code;
        private LocalDate date;

        Security(Object name, JSONArray jArrCurrency, Object code, Object date) {
            this.name = (String) name;

            for (int i = 0; i < jArrCurrency.length(); i++) {
                currency.add((String) jArrCurrency.get(i));
            }

            this.code = (String) code;
            this.date = LocalDate.parse((CharSequence) date, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        }

        public List<String> getCurrency() {
            return currency;
        }

        public LocalDate getDate() {
            return date;
        }

        public void printCode() {
            System.out.println(code);
        }

        public void print() {
            System.out.println("\n" + name);
            System.out.println("code: " + code);
            System.out.println("date: " + date);
            System.out.print("currency:");
            currency.forEach(System.out::println);
        }

    }

}
