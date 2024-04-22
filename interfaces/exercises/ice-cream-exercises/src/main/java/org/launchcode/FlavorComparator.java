package org.launchcode;

import java.util.Comparator;

public class FlavorComparator implements Comparator<Flavor> {
    @Override
    public int compare(Flavor flavor1, Flavor flavor2) {
        // Get the number of allergens for each flavor
        int allergensCount1 = flavor1.getAllergensCount();
        int allergensCount2 = flavor2.getAllergensCount();

        // Compare allergens count in descending order
        return Integer.compare(allergensCount2, allergensCount1);
    }
}