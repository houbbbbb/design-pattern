package designpattern.compositeentity;

/**
 * @todo: 组合实体模式
 * 实体之间组合组合再组合
 * @author: hbw
 * @date: 2020/7/27
 **/
public class CompositeEntityDemo {
    static class DependentObj1 {
        private String data;

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }
    }

    static class DependentObj2 {
        private String data;

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }
    }

    /**
     * 粗粒度实体
     */
    static class CoarseGrainedEntity {
        private DependentObj1 dependentObj1 = new DependentObj1();
        private DependentObj2 dependentObj2 = new DependentObj2();

        public void setData (String data1, String data2) {
            dependentObj1.setData(data1);
            dependentObj2.setData(data2);
        }

        public String[] getData () {
            return new String[]{dependentObj1.getData(), dependentObj2.getData()};
        }
    }

    static class CompositeEntity {
        private CoarseGrainedEntity coarseGrainedEntity = new CoarseGrainedEntity();

        public void setData (String data1, String data2) {
            coarseGrainedEntity.setData(data1, data2);
        }

        public String[] getData () {
            return coarseGrainedEntity.getData();
        }
    }

    static class Client {
        private CompositeEntity compositeEntity = new CompositeEntity();

        public void setData (String data1, String data2) {
            compositeEntity.setData(data1, data2);
        }

        public void printData () {
            int len = compositeEntity.getData().length;
            if (len > 0) {
                for (int i = 0; i < len; i++) {
                    System.out.println(compositeEntity.getData()[i]);
                }
            }
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.setData("hello", "good");
        client.printData();
        System.out.println();
        client.setData("mm", "dd");
        client.printData();
    }
}
