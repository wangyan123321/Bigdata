package test;

import java.util.Optional;

/**
 * »ÀŒÔ¿‡
 * @author wy
 *
 */
public class Person {

	Optional<Car> car;

	public Optional<Car> getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = Optional.ofNullable(car);
	}

	@Override
	public String toString() {
		return "Person [car=" + car + "]";
	}
}
