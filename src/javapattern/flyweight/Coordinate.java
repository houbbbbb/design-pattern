package javapattern.flyweight;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author hbw
 */
@AllArgsConstructor
@NoArgsConstructor
public class Coordinate {

    private Integer x;

    private Integer y;

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }
}
