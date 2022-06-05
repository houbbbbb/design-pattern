package javapattern.adapter;

import org.junit.Test;

public class AdapterTest {

    @Test
    public void test() {

        DbOperation operation = DbOperation.getInstance("adapter.adapter");

        UserEntity userEntity = new UserEntity();

        userEntity.setPassword("password");
        userEntity.setEmail("email");

        operation.save(userEntity);
    }
}
