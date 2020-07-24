package designpattern.businessdelegate;

/**
 * @todo: 用于表示层与业务层的解耦
 * 主要就是根据业务类型，调用不同的实体实现对应的功能
 * 但是在表示层的调用方式是一致的
 * @author: hbw
 * @date: 2020/7/24
 **/
public class BusinessDelegateDemo {
    interface BusinessService {
        /**
         * 执行
         */
        void doProcession ();
    }

    static class AService implements BusinessService {
        @Override
        public void doProcession() {
            System.out.println("AService::doProcession");
        }
    }

    static class BService implements BusinessService {
        @Override
        public void doProcession() {
            System.out.println("BService::doProcession");
        }
    }

    /**
     * 以上可以看做是业务工场
     */
    static class BusinessFactory {
        public BusinessService getBusinessService (String type) {
            if ("A".equals(type)) {
                return new AService();
            } else {
                return new BService();
            }
        }
    }

    static class BusinessDelegate {
        private BusinessFactory businessFactory = new BusinessFactory();
        private String type;

        public void setType(String type) {
            this.type = type;
        }

        public void doTask () {
            BusinessService service = businessFactory.getBusinessService(type);
            service.doProcession();
        }
    }

    static class Client {
        private BusinessDelegate businessDelegate;
        public Client (BusinessDelegate businessDelegate) {
            this.businessDelegate = businessDelegate;
        }

        public void doTask () {
            businessDelegate.doTask();
        }
    }

    public static void main(String[] args) {
        BusinessDelegate businessDelegate = new BusinessDelegate();
        businessDelegate.setType("A");

        Client client = new Client(businessDelegate);
        client.doTask();

        businessDelegate.setType("B");
        client.doTask();
    }
}
