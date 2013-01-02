package controller;

public class Helper {
	public static String arrayToString(String[] array) {
		StringBuffer strBuffer = new StringBuffer();
		for (int i = 0; i < array.length; i++) {
			if (i == 0) {
				strBuffer.append(array[i]);
			} else {
				strBuffer.append(";" + array[i]);
			}
		}
		return strBuffer.toString();
	}

	public static String[] splitByLength(String s, int chunkSize) {
		int arraySize = (int) Math.ceil((double) s.length() / chunkSize);

		String[] returnArray = new String[arraySize];

		int index = 0;
		for (int i = 0; i < s.length(); i = i + chunkSize) {
			if (s.length() - i < chunkSize) {
				returnArray[index++] = s.substring(i);
			} else {
				returnArray[index++] = s.substring(i, i + chunkSize);
			}
		}

		return returnArray;
	}
}
