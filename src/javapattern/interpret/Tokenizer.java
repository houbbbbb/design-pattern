package javapattern.interpret;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author hbw
 */
public class Tokenizer {

    private LinkedList<String> ls = new LinkedList<>();

    public Tokenizer(
            String text) {

        setLs(text);
    }

    private void setLs(
            String text) {

        if (null == text || text.isEmpty()) {

            throw new IllegalArgumentException("要解释的语言不能为空");
        }

        this.ls = new LinkedList<>(Arrays.asList(text.split(" ")));
    }

    public boolean hasNext() {

        return !ls.isEmpty();
    }

    public String next() {

        return ls.removeFirst();
    }
}
