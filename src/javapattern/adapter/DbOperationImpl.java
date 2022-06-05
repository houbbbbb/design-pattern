package javapattern.adapter;

/**
 * @author 86136
 */
public class DbOperationImpl
        implements DbOperation {

    @Override
    public void save(
            UserEntity userEntity) {

        System.out.println("保存用户：" + userEntity);
    }
}
