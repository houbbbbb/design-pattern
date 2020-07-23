package designpattern.mvc;

/**
 * @todo: 适用于应用程序的分层开发
 * Model: 业务处理与数据固化
 * View: 数据展示
 * Controller: Model与View的协调与控制
 * @author: hbw
 * @date: 2020/7/23
 **/
public class MvcDemo {
    static class Model {
        private String name;
        public Model (String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    static class View {
        public void print (String name) {
            System.out.println("name : " + name);
        }
    }

    static class Controller {
        private Model model;
        private View view;
        public Controller (Model model, View view) {
            this.model = model;
            this.view = view;
        }

        public void show () {
            view.print(model.getName());
        }
    }

    public static void main(String[] args) {
        Model model = new Model("myname");
        View view = new View();
        Controller controller = new Controller(model, view);
        controller.show();
    }
}
