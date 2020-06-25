package proxy;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author hbw
 * @date 2020-06-25 07:51
 * 为对象提供一种代理以控制对这个对象的访问
 */
public class ProxyDemo {
}

// 静态代理
interface ComProxyINF{
    void play();
}

class ComProxyImpl implements ComProxyINF{
    @Override
    public void play() {
        System.out.println("实例 --- ");
    }
}

class ComProxy implements ComProxyINF{
    private ComProxyINF comProxyINF;
    public ComProxy(ComProxyINF comProxyINF){
        this.comProxyINF = comProxyINF;
    }

    @Override
    public void play() {
        System.out.println("代理头 --- ");
        comProxyINF.play();
        System.out.println("代理尾 --- ");
    }
}

// JDK 动态代理
interface JDKProxyINF{
    void play();
}

class JDKProxyImpl implements JDKProxyINF{
    @Override
    public void play() {
        System.out.println("JDK 实例 --- ");
    }
}

//cglib 动态代理
class CgProxyImpl{
    public void play(){
        System.out.println("cg 实例 --- ");
    }
}


class ProxyTest{
    public static void main(String[] args) {
        // 静态代理
        System.out.println("静态代理 : ");
        ComProxy comProxy = new ComProxy(new ComProxyImpl());
        comProxy.play();

        // JDK动态代理
        System.out.println("JDK 动态代理 : ");
        JDKProxyINF jdkProxyImpl = new JDKProxyImpl();
        JDKProxyINF jdkProxy = (JDKProxyINF)Proxy.newProxyInstance(jdkProxyImpl.getClass().getClassLoader(), new Class[]{JDKProxyINF.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("JDK 代理头 --- ");
                method.invoke(jdkProxyImpl, args);
                System.out.println("JDK 代理尾 --- ");
                return null;
            }
        });
        jdkProxy.play();

        // cglib 动态代理
        System.out.println("cg 动态代理 : ");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(CgProxyImpl.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("cg 代理头 --- ");
                methodProxy.invokeSuper(o, objects);
                System.out.println("cg 代理尾 --- ");
                return null;
            }
        });
        CgProxyImpl cgProxy = (CgProxyImpl) enhancer.create();
        cgProxy.play();

    }
}
