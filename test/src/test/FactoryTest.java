package test;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 使用函数表达是进行工厂类的重新构造
 * @author wy
 *
 */
public class FactoryTest {

	/**
	 * 工厂类用于某种对象的生产行为，根据输入的参数构造不同的对象
	 * 在使用函数式表达式后，对工厂类的实现有了新的定义
	 * 函数式表达式应用于构造函数，函数式表达式意味着函数可以进行传递，这么构造函数也可以进行传递
	 * 使用函数式表达式实现工厂类，主要的思想是，通过提供参数调用工厂类时，
	 * 会根据提供的参数，调用不同的构造函数，构造不同的对象
	 */
	
	/**
	 * 不输入任何参数，就可以得到不同的对象，
	 * 因为使用函数式表达式，每个函数表达式都回有一种对于应的代表，
	 * 这种不输入任何参数就可以得到对象的行为的匹配接口式：Supplier
	 * 
	 * Supplier的get函数用于调用类似的函数，会返回生命的对象类型
	 * 这里是调用构造函数创建水果
	 */
	
	
	Supplier<Apple> AppleC = Apple :: new;
	
	Fruite getFruit() {
		return AppleC.get();
	}
	
	/**
	 * 通过输入一个参数进行构造行为
	 * 
	 * Function接口可以接受两个参数，一个是输入参数类型，一个是返回参数类型
	 * 这里通过调用Function的apply函数进行构造行为
	 */
	
	Function<String,Apple> AppleWithColorC = Apple :: new;
	
	Fruite getFruit(String color) {
		return AppleWithColorC.apply(color);
	}
	
	/**
	 * 通过输入两个参数进行构造行为
	 * 
	 * BiFunction接口输入三个参数，两个作为输入参数，一个作为返回类型
	 * 通过BiFunction的apply进行构造行为
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