package playerTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import player.Player;
import player.PlayerMovementState;

public class MovementTest {

	/**
	 * tests that player is idle when not actioned
	 */

	@Test
	void testPlayerIdleMovement(){
		Player player = new Player(0,0);
		
		double prevX = player.getX();
		double prevY = player.getY();
		
		PlayerMovementState state = player.getMovementState();
		
		//if playerstate is idle the character should not move
		assertTrue(state == PlayerMovementState.idle);
		
		player.move();
		
		assertTrue(prevX == player.getX() && prevY == player.getY());
	}

	/**
	 * tests that player moves when running
	 */
	@Test
	void testPlayerRunMovement(){
		Player player = new Player(0,0);
		
		double prevX = player.getX();
		
		//if playerstate should start off idle
		assertTrue(player.getMovementState() == PlayerMovementState.idle);


		player.moveLeft(true);
		player.setGrounded(true);
		
		player.step();
		
		assertTrue(player.getMovementState() == PlayerMovementState.run);
		
		//player has moved if x is not equal to previous x
		assertTrue(prevX != player.getX());
	}
	
	
}
