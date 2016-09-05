import java.util.List;

public class Board {
	private int size;
	private List<Ship> ships;

	public Board(int size) {
		this.size = size;
	}

	public void loadShips(List<Ship> ships) {
		this.ships = ships;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public List<Ship> getShips() {
		return ships;
	}

	public void setShips(List<Ship> ships) {
		this.ships = ships;
	}

	public boolean areAllShipsSunken() {

		for (Ship ship : ships) {
			if (!ship.isDown())
				return false;

		}
		return true;
	}

}
