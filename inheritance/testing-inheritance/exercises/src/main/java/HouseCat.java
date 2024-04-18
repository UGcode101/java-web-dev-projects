public class HouseCat extends Cat {
    private String name;
    private String species = "Felis catus";

    public HouseCat(String name, double weight) {
        super(weight);
        this.name = name;
    }

    public static void main(String[] args) {
        HouseCat houseCat = new HouseCat("Mina", 22);
        System.out.println(houseCat.getFamily());
        System.out.println(houseCat.noise());
        Cat cat = houseCat;
        System.out.println(cat.noise());
    }

    @Override
    public String noise() {
        return "Hello, my name is " + name + "!";
    }

    public boolean isSatisfied() {
        return !isHungry() && !isTired();
    }

    public String purr() {
        return "I'm a HouseCat";
    }
}
