package hw._1;

import java.util.Arrays;

public class SomeFixedBox implements SweetBoxable {

    private Sweet[] sweets;
    private double totalWeight = 0;
    private double totalPrice = 0;

    SomeFixedBox(int size) {
        sweets = new Sweet[size];
    }

    @Override
    public void add(Sweet sweet) throws OverflowBoxException {
        for (int i = 0; i < sweets.length; i++) {
            if (sweets[i] == null) {
                sweets[i] = sweet;
                totalWeight += sweet.weight;
                totalPrice += sweet.price;
                break;
            }
            if (i == sweets.length - 1) {
                throw new OverflowBoxException("В коробке больше нет места!");
            }
        }

    }

    @Override
    public void remove() {
        totalWeight -= sweets[sweets.length - 1].weight;
        totalPrice -= sweets[sweets.length - 1].price;
        sweets[sweets.length - 1] = null;
    }

    @Override
    public void remove(int index) {
        totalWeight -= sweets[index].weight;
        totalPrice -= sweets[index].price;
        sweets[index] = null;
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
            Arrays.sort(sweets, new SweetComparatorByWeight());
            int i = 0;
            while (totalWeight >= weight) {
                this.remove(i++);
            }
        }
    }

    @Override
    public void optimizeWeightByPrice(double weight) {
        if (totalWeight < weight) {
            System.out.println("Коробка не нуждается в оптимизации!");
        } else {
            Arrays.sort(sweets, new SweetComparatorByPrice());
            int i = 0;
            while (totalWeight >= weight) {
                this.remove(i++);
            }
        }
    }
}