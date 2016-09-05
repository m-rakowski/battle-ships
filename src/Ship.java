import java.util.ArrayList;
import java.util.List;

public class Ship {
	String name;
	private List<Point> points;
	private boolean down;
	private boolean sunkJustNow;
	public int health = 3;
	
	public Ship() {

	}

	public Ship(String name, Point p1, Point p2, Point p3) {
		this.name = name;
		points = new ArrayList<Point>();
		points.add(p1);
		points.add(p2);
		points.add(p3);
	}
	
	public boolean gotHit(int scannedX, int scannedY) {

		/*
		 * check every point
		 * if [ it's not dead and it's the point indicated by the user ]
		 *    kill it
		 *    health -= 1;
		 *    
		 */
		sunkJustNow=false;
		boolean success = false;
		for (Point point : points) {
			if( !point.isDead())
			{
				if (point.getX() == scannedX && point.getY() == scannedY) {
					point.setDead(true);
					success = true;
					if(health==1) sunkJustNow=true;
					health-=1;
					return success;
	
				}
			}

		}

		return success;

	}

	public boolean isDown() {
		
		for (Point point : points) {
			if (!point.isDead()) {
				down = false;
				return false;
			}
		}
		
		down = true;
		return true;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public boolean sunkJustNow() {
		return sunkJustNow;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}



}
