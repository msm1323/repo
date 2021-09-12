import java.util.Comparator;

public abstract class Sweet {
    static int num = 0;
    final int id;
    String title;
    double weight;
    double price;

    Sweet(String title, double weight, double price){
        id = num++;
        this.title = title;
        this.weight = weight;
        try {
            if (!String.valueOf(price).matches("[1-9]++\\d*+\\.\\d{1,2}?")){
                throw new InvalidFormat("Цена представлена в неверном формате." +
                        "\nНеобходимый формат: 0.00 (рубли и копейки)");
            }
            this.price = price;
        } catch(InvalidFormat ex){
            System.out.println(ex.getMessage());
        }
    }

    void info(){
        System.out.printf("Title: %s\nID: %d\nPrice: %f\nWeight: %f\n",
                this.title, this.id, this.price, this.weight);
    }

}

class SweetComparatorByWeight implements Comparator<Sweet> {
    @Override
    public int compare(Sweet o1, Sweet o2) {
        return Double.compare(o1.weight, o2.weight);
    }
}

class SweetComparatorByPrice implements Comparator<Sweet> {
    @Override
    public int compare(Sweet o1, Sweet o2) {
        return Double.compare(o1.price, o2.price);
    }
}

class InvalidFormat extends Exception{
    public InvalidFormat(String message){
        super(message);
    }
}