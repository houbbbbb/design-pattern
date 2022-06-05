package javapattern.prototype;

import java.util.Objects;

/**
 * @author 86136
 */
public class Customer1
        implements
        Cloneable {

    private String name;

    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public Customer1 clone() {

        try {
            return (Customer1) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("不支持的复制");
        }
    }

    @Override
    public boolean equals(
            Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer1 customer1 = (Customer1) o;
        return Objects.equals(name, customer1.name)
                && Objects.equals(address, customer1.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address);
    }
}
