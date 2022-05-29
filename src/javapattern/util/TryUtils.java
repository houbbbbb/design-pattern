package javapattern.util;

/**
 * @author 86136
 */
public class TryUtils {

    public static void exc(Exc exc) {

        try {
            exc.exc();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object re(Re re) {

        try {
            return re.exc();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public interface Exc {

        /**
         * 执行
         * @throws Exception
         */
        void exc()
                throws Exception;
    }

    public interface Re {

        /**
         * 执行
         * @return
         * @throws Exception
         */
         Object exc()
                throws Exception;
    }
}
