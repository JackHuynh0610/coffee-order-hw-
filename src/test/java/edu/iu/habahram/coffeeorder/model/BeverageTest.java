package edu.iu.habahram.coffeeorder.model;

import org.junit.jupiter.api.Test;

public class BeverageTest {
    Beverage beverage = new Espresso();
    Beverage beverage2 = new HouseBlend();
    @Test
    void testCost() {
        assert(beverage.cost() == 1.34F);
        Milk milkEspresso = new Milk(beverage);
        assert(milkEspresso.cost() == 0.4F + 1.34F);
        Soy soyEspresso = new Soy(milkEspresso);
        assert(soyEspresso.cost() == 0.27F + milkEspresso.cost());
        Whip whipEspresso = new Whip(soyEspresso);
        assert(whipEspresso.cost() == 0.25F + soyEspresso.cost());
        
        assert(beverage2.cost() == 0.89F);
        Milk milkHouseBlend = new Milk(beverage2);
        assert(milkHouseBlend.cost() == 0.4F + 0.89F);
        Soy soyHouseBlend = new Soy(milkHouseBlend);
        assert(soyHouseBlend.cost() == 0.27F + milkHouseBlend.cost());
        Whip whipHouseBlend = new Whip(soyHouseBlend);
        assert(whipHouseBlend.cost() == 0.25F + soyHouseBlend.cost());

        
    }

    @Test
    void testGetDescription() {
        assert(beverage.getDescription().equals("Espresso"));
        Milk milkEspresso = new Milk(beverage);
        assert(milkEspresso.getDescription().equals("Espresso, Milk"));
        Soy soyEspresso = new Soy(milkEspresso);
        assert(soyEspresso.getDescription().equals("Espresso, Milk, Soy"));
        Whip whipEspresso = new Whip(soyEspresso);
        assert(whipEspresso.getDescription().equals("Espresso, Milk, Soy, Whip"));

        assert(beverage2.getDescription().equals("House Blend"));
        Milk milkHouseBlend = new Milk(beverage2);
        assert(milkHouseBlend.getDescription().equals("House Blend, Milk"));
        Soy soyHouseBlend = new Soy(milkHouseBlend);
        assert(soyHouseBlend.getDescription().equals("House Blend, Milk, Soy"));
        Whip whipHouseBlend = new Whip(soyHouseBlend);
        assert(whipHouseBlend.getDescription().equals("House Blend, Milk, Soy, Whip"));
    }
}
