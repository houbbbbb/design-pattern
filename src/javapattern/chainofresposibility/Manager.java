package javapattern.chainofresposibility;

/**
 * @author hbw
 */
public class Manager
        implements Approver {

    private String name;
    private Approver next;

    public Manager(
            String name,
            Approver next) {

        this.setName(name);
        this.setNext(next);
    }


    private void setName(
            String name) {

        if (null == name || name.isEmpty()) {

            throw new IllegalArgumentException("名字不能为空");
        }

        this.name = name;
    }

    private void setNext(
            Approver next) {

        if (null == next) {

            throw new IllegalArgumentException("下一个处理者不能为空");
        }

        this.next = next;
    }

    @Override
    public void process(
            ParamValue paramValue) {

        if (paramValue.getDays() >=3 && paramValue.getDays() < 10) {

            System.out.println("经理 " + this.name + " 审批");
        } else {

            this.next.process(paramValue);
        }
    }
}
