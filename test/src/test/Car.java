package test;

import java.util.Optional;

/**
 * �����࣬�������л����һ��������
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
