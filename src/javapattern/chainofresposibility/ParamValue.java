package javapattern.chainofresposibility;

/**
 * @author hbw
 */
public final class ParamValue {

    private Integer days;

    public ParamValue(
            Integer days) {

        this.setDays(days);
    }

    private void setDays(
            Integer days) {

        if (null == days) {

            throw new IllegalArgumentException("天数不能为空");
        }

        if (days < 1) {

            throw new IllegalArgumentException("天数不能小于1");
        }

        this.days = days;
    }

    public Integer getDays() {

        return days;
    }
}
