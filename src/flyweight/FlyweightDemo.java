package flyweight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : hbw
 * @desctiption : 享元模式，作用 : 大量细粒度对象的共享
 * @date : 2020-06-28 10:31
 */
public class FlyweightDemo {
}

class Flyweight{
    private static final Map<String, FlyObj> FLY_OBJ_MAP = new HashMap<>();

    public static FlyObj getInstance(String name) {
        if(!FLY_OBJ_MAP.containsKey(name)){
            FLY_OBJ_MAP.put(name, new FlyObj(name));
        }
        return FLY_OBJ_MAP.get(name);
    }
}

class FlyObj{
    private String name;
    public FlyObj(String name){
        this.name = name;
    }

    public void print(){
        System.out.println("name : " + name + " --- obj : " + this);
    }
}

class FlyweightTest{
    public static void main(String[] args) {
        String[] names = {"obj1", "obj2", "obj3", "obj4"};

        Map<String, List<FlyObj>> map = new HashMap<>();
        for(int i=0, j=0; i<10; i++, j++){
            if(j > 3) j = 0;
            if(map.containsKey(names[j])){
                map.get(names[j]).add(Flyweight.getInstance(names[j]));
            }else {
                List<FlyObj> flyObjList = new ArrayList<>();
                flyObjList.add(Flyweight.getInstance(names[j]));
                map.put(names[j], flyObjList);
            }
        }

        map.forEach((a, b) -> System.out.println(a + " --- " + b));

    }
}
