public class Main {

    public static void main(String[] args) throws OverflowBoxException {

        System.out.println("myBox:");
        MyBox myBox = new MyBox();
        myBox.add(new Baklava("Baklava1", 3.9, 75.5, Filling.WALNUT));
        myBox.add(new Candy("Candy2", 3.0, 10, Type.CHOCOLATE));
        myBox.add(new Candy("Candy1", 2.6, 25, Type.CARAMEL));
        myBox.add(new Baklava("Baklava2", 3, 90.85, Filling.CASHEW));
        myBox.add(new Chocolate("Chocolate1", 9, 85.9, Form.STANDARD));
        myBox.add(new Chocolate("Chocolate2", 5.6, 45.65, Form.SQUARE));
        myBox.add(new Baklava("Baklava3", 3.2, 63.65, Filling.PISTACHIO));

        System.out.println("Weight = " + myBox.getWeight());
        System.out.println("Price = " + myBox.getPrice());
        myBox.info();

        System.out.println("someFixedBox:");
        SomeFixedBox someFixedBox = new SomeFixedBox(7);
        someFixedBox.add(new Candy("Candy1", 2.6, 25, Type.CARAMEL));
        someFixedBox.add(new Baklava("Baklava2", 3, 90.85, Filling.CASHEW));
        someFixedBox.add(new Chocolate("Chocolate2", 5.6, 45.65, Form.SQUARE));
        someFixedBox.add(new Baklava("Baklava3", 3.2, 63.65, Filling.PISTACHIO));
        someFixedBox.add(new Candy("Candy2", 3.0, 10, Type.CHOCOLATE));
        someFixedBox.add(new Baklava("Baklava1", 3.9, 75.5, Filling.WALNUT));
        someFixedBox.add(new Baklava("Baklava1", 7.9, 150.5, Filling.WALNUT));

        System.out.println("Weight = " + someFixedBox.getWeight());
        System.out.println("Price = " + someFixedBox.getPrice());
        someFixedBox.info();
    }

}