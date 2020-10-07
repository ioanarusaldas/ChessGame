
public class Position {
	public char x;//pozitia unei piese privind latimea tablei(a-h)
	public char y;//pozitia unei piese privind inaltimea tablei(1-8)

	public Position(char x, char y) {
		this.x = x;
		this.y = y;
	}

	public char getX() {
		return x;
	}

	public void setX(char x) {
		this.x = x;
	}

	public char getY() {
		return y;
	}

	public void setY(char y) {
		this.y = y;
	}
}
