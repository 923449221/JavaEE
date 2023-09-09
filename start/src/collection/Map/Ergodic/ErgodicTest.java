package collection.Map.Ergodic;

import com.sun.prism.shader.Solid_TextureYV12_AlphaTest_Loader;

import java.util.*;

/**
 * @author li
 * @create 2022--07
 * @description
 */
public class ErgodicTest {
    public static void main(String[] args) {
        HashMap map = new HashMap();

        map.put("1", 1);                         //获取key，在获取value
        map.put("2", 2);
        map.put("3", 3);
        Set set = map.keySet();
        Iterator iterator1 = set.iterator();
        while (iterator1.hasNext()) {
            String key = (String) iterator1.next();
            System.out.println(key);
            System.out.println(map.get(key));
        }

        Collection set2 = map.values();                        //直接获取key
        Iterator iterator2 = set2.iterator();
        while (iterator2.hasNext()) {
            int values = (int) iterator2.next();
            System.out.println(values);

        }

        Set entrySet = map.entrySet();                             //获取entrySet
        Iterator iterator3 =  entrySet.iterator();
        while (iterator3.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator3.next();
            System.out.println(entry);
            System.out.println(entry.getKey()+"------"+entry.getValue());

        }

        for(Object entyry2:entrySet){                                 //for循环遍历增强entryset
            Map.Entry entry2  = (Map.Entry) entyry2;
            System.out.println(entry2.getKey()+"==="+entry2.getValue());
        }



    }


}
