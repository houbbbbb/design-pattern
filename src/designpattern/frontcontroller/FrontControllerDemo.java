package designpattern.frontcontroller;

/**
 * @todo: 前端控制器模式
 * 提供一个统一的请求处理接口，以便控制器验证与请求追踪
 * @author: hbw
 * @date: 2020/7/28
 **/
public class FrontControllerDemo {
    interface View {
        /**
         * 显示
         */
        void show ();
    }

    static class StudentView implements View {
        @Override
        public void show() {
            System.out.println("student view");
        }
    }

    static class HomeView implements View {
        @Override
        public void show() {
            System.out.println("home view");
        }
    }

    static class Dispatcher {
        private View studentView = new StudentView();
        private View homeView = new HomeView();

        public void dispatch (String type) {
            if ("STU".equals(type)) {
                studentView.show();
            } else {
                homeView.show();
            }
        }
    }

    static class FrontController {
        private Dispatcher dispatcher;

        public FrontController () {
            dispatcher = new Dispatcher();
        }

        public void disPatchRequest (Request request) {
            traceRequest(request);
            if (hasAuth(request)) {
                dispatcher.dispatch(request.getType());
            }
        }

        private Boolean hasAuth (Request request) {
            if ("name".equals(request.getName())) {
                System.out.println("auth success");
                return true;
            }
            System.out.println("auth fail");
            return false;
        }

        private void traceRequest (Request request) {
            System.out.println("trace request : " + request.getName() + " " + request.getType());
        }
    }

    static class Request {
        private String type;
        private String name;

        public Request (String name, String type) {
            this.name = name;
            this.type = type;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        FrontController frontController = new FrontController();
        frontController.disPatchRequest(new Request("name", "STU"));
        System.out.println();
        frontController.disPatchRequest(new Request("name", "HOME"));
        System.out.println();
        frontController.disPatchRequest(new Request("noname", "HOME"));
    }
}
