package javapattern.prototype;

import java.io.*;

/**
 * @author 86136
 */
public class Customer2
        implements
        Serializable {

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
    public Customer2 clone() {

        try {
            ByteArrayOutputStream bao = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(bao);
            objectOutputStream.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bao
                    .toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            return (Customer2) ois.readObject();
        } catch (Exception e) {
            throw new RuntimeException("不支持复制");
        }
    }
}
