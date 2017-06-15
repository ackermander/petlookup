package ce.ackermander.petlookup.kits;

public class JsonArrayKit {

	private StringBuilder jsonBuilder = new StringBuilder();

	public JsonArrayKit(String head) {
		jsonBuilder.append("{\"");
		jsonBuilder.append(head);
		jsonBuilder.append("\":[");
	}

	public JsonArrayKit() {
		jsonBuilder.append("{[");
	}

	public void addJsonObject(String jsonObject) {
		jsonBuilder.append(jsonObject);
		jsonBuilder.append(",");
	}

	public String getJsonArray() {
		jsonBuilder.deleteCharAt(jsonBuilder.length() - 1);
		jsonBuilder.append("]}");
		return jsonBuilder.toString();
	}

}
