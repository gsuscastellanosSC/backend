package com.backend.poll.util;

public class BackendPollUtil {

	/**
	 * @param args
	 * @return String
	 */
	public static String generateString(String... args) {
		StringBuilder stringBuilder = new StringBuilder();
		if (null != args) {
			for (String arg : args) {
				stringBuilder.append(arg);
			}
		}
		return stringBuilder.toString();
	}
}
