package corejava.mystack;

/**
 * @author 张一然
 * @date 2017/12/4 10:05
 * @Package corejava.mystack
 * @Description: 这是一个简单栈，不考虑泛型，只有int
 */
public class SimpleStack {
    private int[] data;
    private int size; // 栈容量
    private int top = 0; // 指向栈顶

    public SimpleStack(int size) {
        this.size = size;
        this.data = new int[size];
    }

    /**
     * @Description：压栈
     * @param num
     * @return：void
     */
    public void push(int num) {
        data[top++] = num;
    }

    /**
     * @Description：弹栈
     * @param num
     * @return：int
     */
    public int pop(int num) {
        if(isEmpty()){
            throw new ArrayIndexOutOfBoundsException("本栈已空");
        }else {
            return data[--top];
        }
    }

    /**
     * @Description：查看栈顶
     * @param num
     * @return：int
     */
    public int getTop(int num) {
        return data[top-1];
    }

    /**
     * @Description：是否为空
     * @param
     * @return：boolean
     */
    public boolean isEmpty() {
        return top == 0;
    }
}
