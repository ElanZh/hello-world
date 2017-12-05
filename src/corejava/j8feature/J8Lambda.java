package corejava.j8feature;

import org.junit.Test;

import java.util.*;
import java.util.function.*;

/**
 * @author 张一然
 * @date 2017/12/5 10:02
 * @Package corejava.j8feature
 * @Description:
 * Java8中引入了一个新的操作符 "->" 该操作符称为箭头操作符或 Lambda 操作符
 * 箭头操作符将 Lambda 表达式拆分成两部分：
 * 左侧：Lambda 表达式的参数列表
 * 右侧：Lambda 表达式中所需执行的功能， 即 Lambda 体
 */
public class J8Lambda {
    final String str1 = "秦时明月汉时关";
    final String str2 = "万里长征人未还";
    final String str3 = "但使龙城飞将在";
    final String str4 = "不教胡马度阴山";
    List<String> strList = Arrays.asList(str1,str2,str3,str4);
    Map<Integer,String> strMap = new HashMap<Integer, String>(4){{
        put(1,str1);
        put(2,str2);
        put(3,str3);
        put(4,str4);
    }};

    @Test
    public void test1(){

        strList.forEach(str -> System.out.println(str));

        strMap.forEach((k,v) ->{
            System.out.print(k+"--");
            System.out.println(v);
        });

    }

    /**
     * Lambda 表达式需要“函数式接口”的支持
     *
     * 只拥有一个方法的接口称之为函数式接口
     * 我们可以在任意函数式接口上使用 @FunctionalInterface 注解，
     * 这样做可以检查它是否是一个函数式接口，
     * 同时 javadoc 也会包含一条声明，说明这个接口是一个函数式接口。
     * 为了更好的支持λ语法，Java8 内置了四大核心函数式接口：
     * Consumer<T> 消费型接口
     * Supplier<T> 供给型接口
     * Function<T, R> 函数型接口
     * Predicate<T> 断言型接口
     */

    /**
     * Consumer<T> 消费型接口
     */
    @Test
    public void test2(){
        happy(10000, (m) -> System.out.println("老铁喜欢大宝剑，每次消费：" + m + "元"));
    }
    public void happy(double money, Consumer<Double> con){
        con.accept(money);
    }

    /**
     * Supplier<T> 供给型接口
     */
    @Test
    public void test3(){
        List<Integer> numList = getNumList(10, () -> (int)(Math.random() * 100));

        for (Integer num : numList) {
            System.out.println(num);
        }
    }
    public List<Integer> getNumList(int num, Supplier<Integer> sup){
        //需求：产生指定个数的整数，并放入集合中
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Integer n = sup.get();
            list.add(n);
        }
        return list;
    }

    /**
     * Function<T, R> 函数型接口
     */
    @Test
    public void test4(){
        String subStr = strHandler(str1, (str) -> str.substring(2, 5));
        System.out.println(subStr);
    }
    //需求：用于处理字符串
    public String strHandler(String str, Function<String, String> fun){
        return fun.apply(str);
    }

    /**
     * Predicate<T> 断言型接口
     */
    @Test
    public void test5(){
        List<String> strList1 = Arrays.asList("Hello", "Lambda", "www", "ok");
        List<String> strList2 = filterStr(strList1, (s) -> s.length() > 3);

        for (String str : strList2) {
            System.out.println(str);
        }
    }

    //需求：将满足条件的字符串，放入集合中
    public List<String> filterStr(List<String> list, Predicate<String> pre){
        List<String> strList = new ArrayList<>();

        for (String str : list) {
            if(pre.test(str)){
                strList.add(str);
            }
        }

        return strList;
    }
}
