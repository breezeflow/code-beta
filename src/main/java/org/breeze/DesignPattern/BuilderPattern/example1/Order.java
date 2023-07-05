package org.breeze.DesignPattern.BuilderPattern.example1;

import java.util.Arrays;

public enum Order {
	desc, asc;

	public static Order getByName(String name) {
		return Arrays.stream(Order.values()).filter(e -> e.name().equals(name))
				.findFirst().orElse(null);
	}
}
