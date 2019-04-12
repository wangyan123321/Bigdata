package test;

import java.util.Optional;
import java.util.Properties;

public class Test3 {
	
	static public Properties properties ;
	
	static {
		properties = new Properties();
		properties.setProperty("a", "5");
		properties.setProperty("b", "true");
		properties.setProperty("c", "-3");
	}
	
	public static Optional<Integer> integerResolve(String rawStr) {
		try {
			return Optional.of( Integer.valueOf(rawStr));
		} catch (Exception e) {
			// TODO: handle exception
			return Optional.empty();
		}
	}

	public static Integer getValue(Properties properties, String raw) {
		Optional<String> strOptional = Optional.ofNullable(properties.get(raw).toString());
		return strOptional.flatMap(b->Test3.integerResolve(b)).orElse(0);
	}
	
	public static void main(String[] args) {
		String name = "TaiPinYang";
		
		Insurance insurance = new Insurance();
		Optional< Insurance> inOptional = Optional.of(insurance);
		insurance.setName(name);
		
		Car car = new Car();
		car.setInsurance(insurance);
		
		Person person = new Person();
		person.setCar(car);
		Optional<Person> perOptional = Optional.of(person);
		
		Insurance insurance2 = new Insurance();
		Optional<Insurance> inOptional2 = Optional.ofNullable(insurance2);
		
		System.err.println(inOptional.flatMap(Insurance::getNameOptional).get());
		
		System.err.println(inOptional2.map(Insurance::getName));
		
		System.err.println(perOptional.flatMap(Person::getCar));
		
		
		System.err.println(getValue(properties,"b"));
	}
}
