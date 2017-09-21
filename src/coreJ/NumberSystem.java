package coreJ;
/**
 * 1、写一个程序，输入是一个十进制整数，输出是它的二进制表示的字符串。函数原型是

	String oct2Bin(int a)
	
	例如，输入8，返回值是“1000”。要考虑负数哦。
	
	2、写一个程序，进行数制的相互转换，原型是
	
	String transform(String s, int radixSrc, int radixTgt)
	
	其中，s代表原始的字符串，radixA代表源进制，radixB代表目标进制。例如
	
	transform("221", 3, 2)，返回“11001”。因为3进制的221，就是十进制的25，而十进制的25就是二进制的11001。同理，transform("11001", 2, 3)返回值就是“221”。
	
	3、猜想一下以下代码的运行结果是什么？并写程序验证，体验一下数据溢出。
	
	short a = Byte.MIN_VALUE;
	int b = Short.MIN_VALUE;
	short c = Byte.MAX_VALUE + 1;
	byte d = (byte)(Byte.MAX_VALUE + 1);
	
	4、自己查一下float和double在计算机内是以什么格式输出的，并思考，如果在网络上只能以字节流的方式传送，这些数字应该怎么办？（例如，InputStream/OutputStream都只能处理字节流。）
 * @author Elan
 *
 */
public class NumberSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	String oct2Bin(int a) {
		return null;
	}
	
	String transform(String s, int radixSrc, int radixTgt) {
		return s;
	}
}
