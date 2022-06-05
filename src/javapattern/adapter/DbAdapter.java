package javapattern.adapter;

/**
 * @author 86136
 */
public class DbAdapter
        implements DbOperation {

    private DbOperation operation = new DbOperationImpl();

    private Secret secret = new SecretImpl();

    @Override
    public void save(
            UserEntity userEntity) {

        userEntity.setPassword(secret.encode(userEntity.getPassword()));
        userEntity.setEmail(secret.encode(userEntity.getEmail()));

        operation.save(userEntity);
    }
}
