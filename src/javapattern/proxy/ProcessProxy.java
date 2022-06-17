package javapattern.proxy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author hbw
 */
public class ProcessProxy
        implements Process {

    private final Process process;

    public ProcessProxy(
            Process process) {

        this.process = process;
    }

    @Override
    public void method() {

        System.out.println("log: 方法method()被调用，时间："
                + LocalDateTime
                .now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd")));

        try {

            process.method();

            System.out.println("method() 调用成功");
        } catch (Exception e) {
            System.out.println("method() 调用失败");
        }
    }
}
