package org.launchcode;

import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Case menu = new Case();
        ArrayList<Flavor> flavors = menu.getFlavors();
        ArrayList<Cone> cones = menu.getCones();
        ArrayList<Topping> toppings = menu.getToppings();

        Comparator<Flavor> flavorComparator = new FlavorComparator();
        Comparator<Cone> coneComparator = new ConeComparator();
        Comparator<Topping> toppingComparator = new ToppingComparator();

        // Sort and display the items
        cones.sort(coneComparator);
        flavors.sort(flavorComparator);
        toppings.sort(toppingComparator);

        System.out.println("Flavors: " + flavors);
        System.out.println("Cones: " + cones);
        System.out.println("Toppings: " + toppings);
    }
}