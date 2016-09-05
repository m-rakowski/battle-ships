import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
	Board board = new Board(7);;
	Player player;
	List<Ship> ships;

	public void run() {

		createShips();
		play();

	}

	private void play() {
		Player player = new Player();
		Scanner sc = new Scanner(System.in);
		int scannedX;
		int scannedY;
		String scannedString;

		while (!player.hasWon()) {
			// scannedX = sc.nextInt();
			// scannedY = sc.nextInt();
			scannedString = sc.next();

			if (scannedString.toUpperCase().charAt(0) == 'A') {
				scannedX = 0;
			} else if (scannedString.toUpperCase().charAt(0) == 'B') {
				scannedX = 1;
			} else if (scannedString.toUpperCase().charAt(0) == 'C') {
				scannedX = 2;
			} else if (scannedString.toUpperCase().charAt(0) == 'D') {
				scannedX = 3;
			} else if (scannedString.toUpperCase().charAt(0) == 'E') {
				scannedX = 4;
			} else if (scannedString.toUpperCase().charAt(0) == 'F') {
				scannedX = 5;
			} else if (scannedString.toUpperCase().charAt(0) == 'G') {
				scannedX = 6;
			} else {
				scannedX = 7;
			}

			scannedY = Character.getNumericValue(scannedString.charAt(1)) -1;

			if (scannedX == 100 && scannedX == 100) {
				for (Ship ship : ships) {
					System.out.println("---sunk just now-- " + ship.name + ": " + ship.sunkJustNow());
					System.out.println("---health-- " + ship.name + ": " + ship.getHealth());
				}
			}

			if (scannedX < board.getSize() && scannedY < board.getSize()) {
				shoot(scannedX, scannedY);
			} else {
				System.out.println("input coordinates must be integers between 0 and 6");
			}
			player.setWon(board.areAllShipsSunken());
		}
		System.out.println("Congratulations, you have won!");
	}

	private void shoot(int scannedX, int scannedY) {
		boolean shipGotHit = false;

		for (Ship ship : ships) {

			shipGotHit = ship.gotHit(scannedX, scannedY);

			if (shipGotHit) {
				System.out.println("ka-boom!");
				shipGotHit = true;
				if (ship.sunkJustNow())
					System.out.println(ship.name + " has sunk!");
				break;
			}

		}
		if (!shipGotHit)
			System.out.println("plop, plop..");

	}

	private void createShips() {
		ships = new ArrayList<Ship>();
		ships.add(new Ship("Santa María", new Point(0, 1), new Point(0, 2), new Point(0, 3)));
		ships.add(new Ship("Dar Pomorza", new Point(2, 2), new Point(2, 3), new Point(2, 4)));
		ships.add(new Ship("Titanic", new Point(4, 6), new Point(5, 6), new Point(6, 6)));
		board.loadShips(ships);
	}

}
