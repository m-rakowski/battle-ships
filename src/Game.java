import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
	Board board;
	Player player;
	List<Ship> ships;

	public void run() {

		initiate();
		board = new Board(7);
		board.loadShips(ships);
		Player player = new Player();

		Scanner sc = new Scanner(System.in);
		int scannedX;
		int scannedY;

		while (!player.hasWon()) {
			scannedX = sc.nextInt();
			scannedY = sc.nextInt();

	
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
				break;
			}
			if(ship.gotHitJustNow()) System.out.println(ship.name +" has sunk!");

		}
		if (!shipGotHit)
			System.out.println("plop, plop..");

	}
	private void initiate() {
		ships = new ArrayList<Ship>();
		ships.add(new Ship("Santa María", new Point(0, 1), new Point(0, 2), new Point(0, 3)));
		ships.add(new Ship("Dar Pomorza", new Point(2, 2), new Point(2, 3), new Point(2, 4)));
		ships.add(new Ship("Titanic", new Point(4, 6), new Point(5, 6), new Point(6, 6)));
	}

	
}
