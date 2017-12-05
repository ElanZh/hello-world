package corejava.j8feature;

import org.junit.Test;

import java.util.*;
import java.util.stream.*;

/**
 * @author 张一然
 * @date 2017/12/5 10:01
 * @Package corejava.j8feature
 * @see java.util.stream
 * @Description:
 * java8 的一个新特性 新的java.util.stream包
 * 目前翻译为“流”，但与Java IO包中的InputStream和OutputStream完全不是一个概念
 * Stream是对集合功能的一种增强，主要用于对集合对象进行各种非常便利高效的聚合和大批量数据的操作
 * 结合Lambda表达式可以极大的提高开发效率和代码可读性。
 * ①Stream不存储值
 * ②Stream的操作会产生一个结果，但是Stream并不会改变数据源
 * ③Stream的操作是惰性的，只有需要求结果时才会执行
 * 所以，根据其特征更应该命名为“惰性操作流水线”
 */
public class J8Stream {
    List<String> testData = Arrays.asList("张三","李四","王二","马六");

    @Test
    public void test1(){
        testData.stream()
                .filter(x -> x.length() == 2)
                .map(x -> x.replace("三","五"))
                .sorted()
                .filter(x -> x.contains("五"))
                .forEach(System.out::println);
    }
}
