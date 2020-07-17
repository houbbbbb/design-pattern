package designpattern.iterator;

/**
 * @todo: 遍历对象内部元素的内容，无需暴露内部表示
 * @author: hbw
 * @date: 2020/7/17
 **/
public class IteratorDemo {
    interface Iterator {
        /**
         * 判断下一个
         * @return
         */
        Boolean hasNext();

        /**
         * 下一个
         * @return
         */
        Object next();
    }

    interface Container {
        /**
         * 获取迭代器
         * @return
         */
        Iterator getIterator ();
    }

    static class NameContainer implements Container {
        private String[] names;

        public String[] getNames() {
            return names;
        }

        public void setNames(String[] names) {
            this.names = names;
        }

        @Override
        public Iterator getIterator() {
            return new NameIterator();
        }

        class NameIterator implements Iterator {
            private Integer index = 0;

            @Override
            public Boolean hasNext() {
                if (null !=  names && index < names.length) {
                    return true;
                }
                return false;
            }

            @Override
            public Object next() {
                return names[index++];
            }
        }
    }

    public static void main(String[] args) {
        NameContainer nameContainer = new NameContainer();
        nameContainer.setNames(new String[]{"hello", "world", "good", "me"});
        Iterator iterator = nameContainer.getIterator();
        while (iterator.hasNext()) {
            Object o = iterator.next();
            System.out.println("next : " + o);
        }
    }
}
