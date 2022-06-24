package javapattern.interpret;

/**
 * @author hbw
 */
public class Context {

    private Tokenizer tokenizer;

    public Context(
            String text) {

        setText(text);
    }

    private void setText(
            String text) {

        if (null == text || text.isEmpty()) {

            throw new IllegalArgumentException("内容不能为空");
        }

        this.tokenizer = new Tokenizer(text);
    }

    public String word() {

        if (this.tokenizer.hasNext()) {

            return this.tokenizer.next();
        }

        throw new IllegalArgumentException("结尾");
    }
}
