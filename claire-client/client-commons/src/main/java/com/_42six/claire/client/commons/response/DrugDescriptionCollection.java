package com._42six.claire.client.commons.response;

import java.util.Collection;

public class DrugDescriptionCollection {

	public Collection<DrugDescription> descriptions;


	public static class DrugDescription {

		public String name;
		public String description;
		public String pharmacodynamics;
		public String genericName;

	}

}
