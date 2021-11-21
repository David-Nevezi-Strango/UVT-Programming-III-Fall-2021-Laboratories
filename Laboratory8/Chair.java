package Laboratory8;

import org.json.simple.JSONObject;

public class Chair {
	String producer;
	String fabric;
	double price;

	public Chair(String producer, String fabric, double price) {
		super();
		this.producer = producer;
		this.fabric = fabric;
		this.price = price;
	}

	@Override
	public String toString() {
		// Note: To use the JSON, for the json-simple-1.1.1 attached jar:
		// attached.jar > Build Path > Add to Build Path
		JSONObject obj = new JSONObject();

		obj.put("producer", this.producer);
		obj.put("fabric", this.fabric);
		obj.put("price", this.price);

		return obj.toString();
	}
}
