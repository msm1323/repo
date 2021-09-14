package hw._1;

public interface SweetBoxable {

    void add(Sweet sweet) throws OverflowBoxException;
    void remove();
    void remove(int index);
    double getWeight();
    double getPrice();
    void info();
    void optimizeWeightByWeight(double weight);
    void optimizeWeightByPrice(double weight);

}

class OverflowBoxException extends Exception{
    public OverflowBoxException(String message){
        super(message);
    }
}