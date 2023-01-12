package stepDefinition;

import org.apache.commons.lang3.RandomStringUtils;

public class GetDataUtility {
	public static String getProgramName() {
		String generatedString = RandomStringUtils.randomAlphabetic(7);
		String generatedNum = RandomStringUtils.randomNumeric(1);
		System.out.println("Jan-23 "+generatedString+" SDET-"+generatedNum);
		return ("Jan-23 "+generatedString+" SDET-"+generatedNum);
	}
	public static void main(String[] args) {
		getProgramName();
	}

}
