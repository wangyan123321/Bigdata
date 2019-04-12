package test;

import java.util.Optional;

/**
 * 汽车类，汽车类中会包含一个保险类
 * @author wy
 *
 */
public class Car {

	Optional<Insurance> insurance;

	public Optional<Insurance> getInsurance() {
		return insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = Optional.ofNullable(insurance);
	}

	@Override
	public String toString() {
		return "Car [insurance=" + insurance + "]";
	}
}
