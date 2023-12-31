package objects;

import gravity.SphereGravity;

public abstract class GameActor extends AbstractObject{
	protected double hp;
	protected double dx, dy;
	
	protected boolean grounded = false;
	protected SphereGravity gravity;
	
	protected int frameCount = 0;

	/**
	 * moves object in a horizontal direction based on actor direction, vel distance.
	 * @param vel
	 */
	public void moveHorizontal(double vel) {
		double r = this.deg*Math.PI/180;
		this.dx += Math.cos(r) * vel;
		this.dy += Math.sin(r) * vel;
	}

	/**
	 * moves object in a vertical direction based on actor direction, vel distance.
	 * @param vel
	 */
	public void moveVertical(double vel) {
		double r = (this.deg + 90)*Math.PI/180;
		this.dx += Math.cos(r) * vel;
		this.dy += Math.sin(r) * vel;
	}

	/**
	 * moves object in a direction r, vel distance.
	 * @param vel
	 * @param r
	 */
	public void moveInDir(double vel, double r) {
		double r1 = (r + 90)*Math.PI/180;
		this.dx += Math.cos(r1) * vel;
		this.dy += Math.sin(r1) * vel;		
	}
	
	/**
	 * steps the character
	 */
	public void step() {
		this.dx = 0;
		this.dy = 0;
		if (this.gravity != null) {
			this.deg = 180 - Math.toDegrees(Math.atan2(this.x - this.gravity.getX(), this.y - this.gravity.getY()));
			double dist = Math.sqrt(Math.pow(this.x - this.gravity.getX(),2) + Math.pow(this.y - this.gravity.getY(),2));
			moveVertical(10*this.gravity.getWeight()/(dist));
		}
		move();
		this.x += this.dx;
		this.y += this.dy;
	}
	
	/**
	* @Return HP of Game Character
	*/
	public double getHP() {
		return this.hp;
	}

	/**
	 *@return boolean of whether character is alive or dead
	 */
	public boolean isAlive() {
		return this.hp > 0;
	}
	/**
	 * Sets HP
	 */
	public void setHp(double hp) {
		this.hp = hp;
	}
	/**
	 * Sets x-coordinate
	 */
	public void setX(double x) {
		this.x = x;
	}
	/**
	 * Sets y-coordinate
	 */
	public void setY(double y) {
		this.y = y;
	}
	public double getDX() {
		return this.dx;
	}
	public double getDY() {
		return this.dy;
	}

	/**
	 * checks if actor is standing
	 * @return
	 */
	public boolean isGrounded() {
		return this.grounded;
	}

	/**
	 * sets gravity to effect actor
	 * @param gravity
	 */
	public void setGravity(SphereGravity gravity) {
		this.gravity = gravity;
	}

	/**
	 * sets if actor is standing
	 * @param grounded
	 */

	public void setGrounded(boolean grounded) {
		this.grounded = grounded;
	}

	/**
	 * moves a actor to a given x and y
	 * @param x
	 * @param y
	 */

	public void moveTo(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * gets the frame actor is on
	 * @return
	 */
	public int getFrameCount() {
		return this.frameCount;
	}

	/**
	 * sets the frame the actor is on
	 * @param frame
	 */
	public void setFrameCount(int frame) {
		this.frameCount = frame;
	}	
}
