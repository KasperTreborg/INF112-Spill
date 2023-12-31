package game;

import gravity.SphereGravity;
import inf112.skeleton.app.ImageLoader;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import levels.Level;
import objects.GameActor;
import objects.IGameObject;
import player.Player;



/**
 * Gets the games graphics: sprites, background etc. And places them in the right place.
 */
public class GameGraphics {
	/**
	 * draws an object on the screen based on where object is in respect to the player
	 * @param context
	 * @param player
	 * @param obj
	 */
	private static void cameraView(GraphicsContext context, Player player, IGameObject obj) {
		double playerPosX = 500;
		double playerPosY = 300;
		double offsettX = player.getX() - playerPosX;
		double offsettY = player.getY() - playerPosY;
		context.save();
		context.translate(obj.getX()-offsettX, obj.getY()-offsettY);
		context.rotate(obj.getDeg());
		if (obj.getSprite() != null) {
			context.drawImage(obj.getSprite(),-obj.getWidth()*obj.getDirection()/2,-obj.getHeight()/2,obj.getWidth()*obj.getDirection(), obj.getHeight());
		}else{
			context.fillOval(-obj.getWidth()/2, -obj.getHeight()/2, obj.getWidth(), obj.getHeight());
		}
		context.restore();
	}
	/**
	 * draws the level and players positions and sprites
	 * @param canvas
	 * @param player
	 * @param level
	 */
	public static void drawScreen(Canvas canvas,Player player, Level level) {
		GraphicsContext context = canvas.getGraphicsContext2D();
		context.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		context.save();
		context.drawImage(ImageLoader.getImage("/sprites/background_elements/Space_Background.png"),0,0);
		Image playerSprite = player.getSprite();
		double w = player.getWidth()*player.getDirection();
		double h = player.getHeight();


		//context.setFill(Color.BLUE);
		context.setFill(new Color(0,0,1,0.3));
		for (SphereGravity gravity : level.getGravities()) {
			cameraView(context, player, gravity);
		}

		for(IGameObject obj : level.getBackground_environment()){
			cameraView(context, player, obj);
		}

		for(IGameObject obj : level.getCollectibles()){
			cameraView(context, player, obj);
		}
		for(IGameObject obj : level.getPowerUps()) {
			cameraView(context, player, obj);
		}
		for (IGameObject obj : level.getPortals()) {
			if(player.activePowerCell) cameraView(context, player, obj);
		}
		
		
		{//player
			context.translate(500, 300);
			context.rotate(player.getDeg());
			context.drawImage(playerSprite,-w/2,-h/2,w, h);
			context.restore();
			//context.drawImage(playerSprite,500-w/2*player.direction,300-h/2,w*player.direction, h);
		}

		for(IGameObject obj : level.getObjects()) {
			context.setFill(Color.WHITE);
			cameraView(context, player, obj);
		}
		for (GameActor c : level.getEnemies()) {
			cameraView(context, player, c);
		}
		
		
		
	}

	/**
	 * draws the hud elements
	 * @param canvas
	 * @param player
	 * @param game
	 */

	public static void drawHud(Canvas canvas, Player player, Game game) {
		GraphicsContext context = canvas.getGraphicsContext2D();

		// Power up
		if(player.activePowerCell) context.drawImage(ImageLoader.getImage("/sprites/other_assets/Other Sprites/EnergyPack.png"),canvas.getWidth()-58,70,60,60);

		// Coins/Diamonds Collected
		context.setFont(new Font(50));
		context.drawImage(ImageLoader.getImage("/sprites/other_assets/Other Sprites/Diamond.png"),canvas.getWidth()-58,5,60,60);
		context.fillText("" + game.coinsCollected, canvas.getWidth()-83,50);

		// Healthbar
		context.setFill(new Color(0,0,0,1));
		context.fillRect(0, canvas.getHeight()-40, 310, 40);
		context.setFill(new Color(1,0,0,1));
		context.fillRect(5, canvas.getHeight()-35, 300, 30);
		context.setFill(new Color(0,1,0,1));
		context.fillRect(5,canvas.getHeight()-35, 3*player.getHP(), 30);
		context.setFill(new Color(1,1,1,1));
		
		// Airbar
		context.setFill(new Color(0,0,0,1));
		context.fillRect(0, canvas.getHeight()-80, 251, 40);
		context.setFill(Color.GHOSTWHITE);
		context.fillRect(5, canvas.getHeight()-75, 240, 30);
		context.setFill(Color.LIGHTBLUE);
		context.fillRect(5,canvas.getHeight()-75, 4*player.getAirSupply(), 30);
		context.setFill(new Color(1,1,1,1));
	}
}
