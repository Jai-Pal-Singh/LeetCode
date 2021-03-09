package bipartite_graph;

public enum Color {
	NO_COLOR(-1),
	RED(0),
	BLACK(1);

	private Integer value;
	
	Color(Integer i) {
		this.setValue(i);
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
}
