package hw._1;

public class Baklava extends Sweet {
    Filling filling;

    Baklava(String title, double weight, double price, Filling filling) {
        super(title, weight, price);
        this.filling = filling;
    }

    @Override
    void info() {
        super.info();
        System.out.printf("hw._1.Filling: %s\n", this.filling);
    }
}

enum Filling {
    WALNUT,
    CASHEW,
    PISTACHIO,
    CHOCOLATE
}