package test;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * ±£œ’¿‡
 * @author wy
 *
 */
public class Insurance {

	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Stream<String> getNameStream() {
		return Stream.of(name);
	}
	
	public Optional<String> getNameOptional() {
		return Optional.ofNullable(name);
	}

	@Override
	public String toString() {
		return "Insurance [name=" + name + "]";
	}
}
