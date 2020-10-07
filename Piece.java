
public class Piece {
	private String name;
	private String color;
	private Position position;

	public Piece() {
		this.name = "null";
		this.color = "null";
		this.position = null;

	}

	public Piece(String name, String color, Position position) {
		this.name = name;
		this.color = color;
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
}
