package com.iot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Broker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String activeProfile = null;
		String[] values = {"devazure","canary20","eu10","devaws"};
		
		if (Arrays.stream(values).anyMatch(val -> (val.equalsIgnoreCase("devazure")))) {
			activeProfile = "devazure";
		} else if (Arrays.stream(values).anyMatch(val -> (val.equalsIgnoreCase("canary20")))) {
			activeProfile = "canary20";
		} else if (Arrays.stream(values).anyMatch(val -> (val.equalsIgnoreCase("eu10")))) {
			activeProfile = "eu10";
		} 
		System.out.println(activeProfile);
		
//		for (String profile : values) {
//			String[] validLocalProfiles = {"devazure","canary20","eu10","devaws"};
//			if (validLocalProfiles.contains(profile)) {
//				activeProfile = profile;
//			}
//		}


		//		if (Arrays.stream(environment.getActiveProfiles()).anyMatch(env -> (env.equalsIgnoreCase("devazure")))) {
		//			System.out.println("Pass");
		//		}


		ArrayList<String> tags = new ArrayList<String>();
		tags.add("devazure_4.33.0");
		tags.add("devazure_4.34.0");
		tags.add("canary20_4.33.0");
		tags.add("eu10_4.33.0");
		System.out.println(tags);

		final List<String> releaseTags = tags.stream()
				.filter(tag -> tag.startsWith("devazure"))
				.collect(Collectors.toList());

		for (String tag : releaseTags) {
			String version = tag.substring(tag.indexOf("_")+1).trim();
			System.out.println(version);
			String relversion = "devazure" + "_" + version;
			System.out.println(relversion);
		}

		System.out.println(releaseTags);
	}

}
