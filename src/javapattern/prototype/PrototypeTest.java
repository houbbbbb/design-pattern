package javapattern.prototype;

import org.junit.Test;

/**
 * @author 86136
 */
public class PrototypeTest {

    @Test
    public void test() {

        Customer1 customer1 = new Customer1();

        Address address = new Address();
        address.setAddress("地址");
        customer1.setAddress(address);
        customer1.setName("hello");

        Customer1 customer1Clone = customer1.clone();

        System.out.println(customer1 == customer1Clone);
        System.out.println(customer1.getAddress()
                == customer1Clone.getAddress());


        Customer2 customer2 = new Customer2();

        Address address2 = new Address();
        address2.setAddress("地址");
        customer2.setAddress(address2);
        customer2.setName("good");

        Customer2 customer2Clone = customer2.clone();

        System.out.println(customer2 == customer2Clone);
        System.out.println(customer2.getAddress()
                == customer2Clone.getAddress());
    }
}
