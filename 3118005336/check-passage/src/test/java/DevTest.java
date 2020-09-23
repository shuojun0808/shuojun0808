import org.junit.Test;
import simhash.SimHash;
import simhash.formula;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DevTest {

    @Test
    public void SimHashTest() throws IOException {
        SimHash s1 = new SimHash("广东工业大学今天正式欢迎新生入学");
        SimHash s2 = new SimHash("广东工业大学昨天已经欢迎老生回校");
        int i = s1.hammingDistance(s2);
        System.out.println(formula.getSimliar(i));
    }

    @Test
    public void mapTest(){
        Map<String, Integer> test = new HashMap<>();
        test.put("h",0);
        if(test.containsKey("h")){
            test.put("h",test.get("h")+1);
            System.out.println("here");
        }
        Integer h = test.get("h");
        System.out.println(h);
    }

    @Test
    public void charTest(){
        String SE = "软件工程";
        char s = '工';
        String s1 = String.valueOf(s);
        System.out.println(s1);
    }

    @Test
    public void stringLengthTest(){
        String test = "软件工程大法好，面向开源,拥抱开源！";
        System.out.println(test.length());
    }
}
