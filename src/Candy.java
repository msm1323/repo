public class Candy extends Sweet{

    Type type;

    Candy(String title, double weight, double price, Type type) {
        super(title, weight, price);
        this.type = type;
    }

    @Override
    void info() {
        super.info();
        System.out.printf("Type: %s\n", this.type);
    }

}

enum Type{
    CARAMEL,
    CHOCOLATE,
    WAFFLE
}
