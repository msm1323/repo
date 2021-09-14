package hw._1;

import java.util.ArrayList;
import java.util.Collections;

public class MyBox implements SweetBoxable {

    private ArrayList<Sweet> sweets = new ArrayList<>();
    private double totalWeight = 0;
    private double totalPrice = 0;

    @Override
    public void add(Sweet sweet) {
        sweets.add(sweet);
        totalWeight += sweet.weight;
        totalPrice += sweet.price;
    }

    @Override
    public void remove() {
        totalWeight -= sweets.get(sweets.size() - 1).weight;
        totalPrice -= sweets.get(sweets.size() - 1).price;
        sweets.remove(sweets.size() - 1);
    }

    @Override
    public void remove(int index) {
        totalWeight -= sweets.get(index).weight;
        totalPrice -= sweets.get(index).price;
        sweets.remove(index);
    }

    @Override
    public double getWeight() {
        return totalWeight;
    }

    @Override
    public double getPrice() {
        return totalPrice;
    }

    @Override
    public void info() {
        for (Sweet sweet : sweets) {
            sweet.info();
            System.out.println();
        }
    }

    @Override
    public void optimizeWeightByWeight(double weight) {
        if (totalWeight < weight) {
            System.out.println("Коробка не нуждается в оптимизации!");
        } else {
            sweets.sort(Collections.reverseOrder(new SweetComparatorByPrice()));
            while (totalWeight >= weight) {
                this.remove();
            }
        }
    }

    @Override
    public void optimizeWeightByPrice(double weight) {
        if (totalWeight < weight) {
            System.out.println("Коробка не нуждается в оптимизации!");
        } else {
            sweets.sort(Collections.reverseOrder(new SweetComparatorByPrice()));
            while (totalWeight >= weight) {
                this.remove();
            }
        }
    }

}