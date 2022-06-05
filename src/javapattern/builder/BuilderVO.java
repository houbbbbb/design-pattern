package javapattern.builder;

/**
 * @author 86136
 */
public class BuilderVO {

    private String classname;

    private Boolean menu;

    private Boolean list;

    private Boolean win;

    private Boolean bar;

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public Boolean getMenu() {
        return menu;
    }

    public void setMenu(Boolean menu) {
        this.menu = menu;
    }

    public Boolean getList() {
        return list;
    }

    public void setList(Boolean list) {
        this.list = list;
    }

    public Boolean getWin() {
        return win;
    }

    public void setWin(Boolean win) {
        this.win = win;
    }

    public Boolean getBar() {
        return bar;
    }

    public void setBar(Boolean bar) {
        this.bar = bar;
    }

    @Override
    public String toString() {
        return "BuilderVO{" +
                "classname='" + classname + '\'' +
                ", menu=" + menu +
                ", list=" + list +
                ", win=" + win +
                ", bar=" + bar +
                '}';
    }
}
