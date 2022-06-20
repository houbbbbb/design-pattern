package javapattern.chainofresposibility;

/**
 * @author hbw
 */
public class GeneralManager
        implements Approver {

    private String name;

    public GeneralManager(
            String name) {

        this.setName(name);
    }

    private void setName(String name) {

        if (null == name || name.isEmpty()) {

            throw new IllegalArgumentException("名字不能为空");
        }

        this.name = name;
    }

    @Override
    public void process(
            ParamValue paramValue) {

        if (paramValue.getDays() >= 10 && paramValue.getDays() < 30) {

            System.out.println("总经理 " + this.name + " 审批");
        } else {

            throw new IllegalArgumentException("超出审核权限");
        }
    }
}
