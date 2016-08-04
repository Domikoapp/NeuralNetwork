package util;

public class Util {

	public static double sigmoid(double z) {
		return 1.0 / (1.0 + Math.exp(-z));
	}

}
