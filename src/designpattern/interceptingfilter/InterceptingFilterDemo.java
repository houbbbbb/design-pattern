package designpattern.interceptingfilter;

import java.util.ArrayList;
import java.util.List;

/**
 * @todo: 拦截过滤器模式
 * 过滤器 + 职责链
 * @author: hbw
 * @date: 2020/7/29
 **/
public class InterceptingFilterDemo {
    interface Filter {
        /**
         * 过滤
         * @param request
         */
        void filter (String request);
    }

    static class AuthFilter implements Filter {

        @Override
        public void filter(String request) {
            System.out.println("auth filter " + request);
        }
    }

    static class DebugFilter implements Filter {
        @Override
        public void filter(String request) {
            System.out.println("debug filter " + request);
        }
    }

    static class Target {
        public void exe (String request) {
            System.out.println("execute request " + request);
        }
    }

    static class FilterChain {
        private List<Filter> filterChain;
        private Target target;

        public FilterChain () {
            filterChain = new ArrayList<>(16);
            target = new Target();
        }

        public void addFilter (Filter filter) {
            filterChain.add(filter);
        }

        public void doIt (String request) {
            filterChain.forEach(filter -> filter.filter(request));
            target.exe(request);
        }
    }

    public static void main(String[] args) {
        FilterChain filterChain = new FilterChain();
        filterChain.addFilter(new AuthFilter());
        filterChain.addFilter(new DebugFilter());

        filterChain.doIt("myRequest");
    }
}
