package hw._1;

public class Chocolate extends Sweet {

    Form form;

    Chocolate(String title, double weight, double price, Form form) {
        super(title, weight, price);
        this.form = form;
    }

    @Override
    void info() {
        super.info();
        System.out.printf("hw._1.Form: %s\n", this.form);
    }
}

enum Form {
    STANDARD,
    SQUARE
}