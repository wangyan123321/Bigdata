package test;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * ʹ�ú�������ǽ��й���������¹���
 * @author wy
 *
 */
public class FactoryTest {

	/**
	 * ����������ĳ�ֶ����������Ϊ����������Ĳ������첻ͬ�Ķ���
	 * ��ʹ�ú���ʽ���ʽ�󣬶Թ������ʵ�������µĶ���
	 * ����ʽ���ʽӦ���ڹ��캯��������ʽ���ʽ��ζ�ź������Խ��д��ݣ���ô���캯��Ҳ���Խ��д���
	 * ʹ�ú���ʽ���ʽʵ�ֹ����࣬��Ҫ��˼���ǣ�ͨ���ṩ�������ù�����ʱ��
	 * ������ṩ�Ĳ��������ò�ͬ�Ĺ��캯�������첻ͬ�Ķ���
	 */
	
	/**
	 * �������κβ������Ϳ��Եõ���ͬ�Ķ���
	 * ��Ϊʹ�ú���ʽ���ʽ��ÿ���������ʽ������һ�ֶ���Ӧ�Ĵ���
	 * ���ֲ������κβ����Ϳ��Եõ��������Ϊ��ƥ��ӿ�ʽ��Supplier
	 * 
	 * Supplier��get�������ڵ������Ƶĺ������᷵�������Ķ�������
	 * �����ǵ��ù��캯������ˮ��
	 */
	
	
	Supplier<Apple> AppleC = Apple :: new;
	
	Fruite getFruit() {
		return AppleC.get();
	}
	
	/**
	 * ͨ������һ���������й�����Ϊ
	 * 
	 * Function�ӿڿ��Խ�������������һ��������������ͣ�һ���Ƿ��ز�������
	 * ����ͨ������Function��apply�������й�����Ϊ
	 */
	
	Function<String,Apple> AppleWithColorC = Apple :: new;
	
	Fruite getFruit(String color) {
		return AppleWithColorC.apply(color);
	}
	
	/**
	 * ͨ�����������������й�����Ϊ
	 * 
	 * BiFunction�ӿ���������������������Ϊ���������һ����Ϊ��������
	 * ͨ��BiFunction��apply���й�����Ϊ
	 */
	BiFunction<String,Integer,Apple> AppleWithColorAndWeightC = Apple :: new;
	
	Fruite getFruit(String color,Integer weight) {
		return AppleWithColorAndWeightC.apply(color, weight);
	}
	
	
	public static void main(String[] args) {
		FactoryTest factory = new FactoryTest();
		
		Fruite fruite = factory.getFruit();
		
		System.err.println(fruite);
		
		fruite =factory.getFruit("blue");
		
		System.err.println(fruite);
		
		fruite =factory.getFruit("yellow", 100);
		System.err.println(fruite);
		
	}
}