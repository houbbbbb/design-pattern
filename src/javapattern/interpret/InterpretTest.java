package javapattern.interpret;

import org.junit.Test;

/**
 * @author hbw
 */
public class InterpretTest {

    @Test
    public void test() {

        String text = "COPY VIEW FROM srcDB TO desDB";

        Context context = new Context(text);

        Sentence sentence = new Sentence(
                new Action(),
                new Table(),
                new Db(),
                new From(),
                new To());

        sentence.interpret(context);
    }
}
