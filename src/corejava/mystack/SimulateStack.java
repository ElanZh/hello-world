package corejava.mystack;

import java.util.ArrayList;

/**
 * @author 张一然
 * @date 2017/12/4 10:10
 * @Package corejava.mystack
 * @Description: 模拟栈
 */
public class SimulateStack<T> {
    private ArrayList<T> list;
    private int size;

    public SimulateStack(int size) {
        this.size = size;
        this.list = new ArrayList<T>(size);
    }

    public static void main(String args) {
        SimulateStack<Integer> s = new SimulateStack<Integer>(10);
    }
}
