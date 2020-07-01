package designpattern.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : hbw
 * @desctiption : 将构建逻辑转移到实例化外部
 * 将构建与表示相分离，相同的构建过程创建不同的表示
 * 构建复杂对象时，相同的过程，不同的组合
 * @date : 2020-06-29 09:24
 */
public class BuilderDemo {
}

interface Item {
    String name();
    Packing packing();
    float price();
}

interface Packing {
    String pack();
}

class Wrapper implements Packing {
    @Override
    public String pack() {
        return "Wrapper";
    }
}

class Bottle implements Packing {
    @Override
    public String pack() {
        return "Bottle";
    }
}

abstract class Burger implements Item {
    @Override
    public Packing packing() {
        return new Wrapper();
    }
}

abstract class ColdDrink implements Item {
    @Override
    public Packing packing() {
        return new Bottle();
    }
}

class VegBurger extends Burger {
    @Override
    public String name() {
        return "VegBurger";
    }
    @Override
    public float price() {
        return 25.0F;
    }
}

class ChickenBurger extends Burger {
    @Override
    public String name() {
        return "ChickenBurger";
    }

    @Override
    public float price() {
        return 50.0F;
    }
}

class Coke extends ColdDrink {
    @Override
    public String name() {
        return "Coke";
    }

    @Override
    public float price() {
        return 30.0F;
    }
}

class Pepsi extends ColdDrink {
    @Override
    public String name() {
        return "Pepsi";
    }

    @Override
    public float price() {
        return 35.0F;
    }
}

class Meal {
    List<Item> itemList = new ArrayList<>();

    public void addItem(Item item) {
        itemList.add(item);
    }

    public float getCost() {
        return itemList.stream().map(Item::price).reduce((a, b) -> a + b).get();
    }

    public void showItems() {
        itemList.forEach((item) -> {
            StringBuilder sb = new StringBuilder();
            String itemStr = sb.append("name").append(" : ").append(item.name()).append(",")
                    .append(" ").append("packing").append(" : ").append(item.packing().pack()).append(",")
                    .append(" ").append("price").append(" : ").append(item.price())
                    .toString();
            System.out.println(itemStr);
        });
    }
}

class MealBuilder {
    private MealBuilder(){}
    public static MealBuilder create(){
        return new MealBuilder();
    }

    public MealBuilder vegMeal(){
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        meal.showItems();
        System.out.println("cost : " + meal.getCost());
        return this;
    }

    public MealBuilder nonVegMeal(){
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        meal.showItems();
        System.out.println("cost : " + meal.getCost());
        return this;
    }
}

class BuilderTest {
    public static void main(String[] args) {
        MealBuilder.create().vegMeal().nonVegMeal();
    }
}
