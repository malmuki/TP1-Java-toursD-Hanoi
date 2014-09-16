package ca.csf.Zelda2;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.lwjgl.util.glu.GLU;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;

public class Game {

	private Plancher floor;// a simple floor
	private Box box;// the box to be positioned
	private Box box2;
	private Matrix4f viewMatrix = null;

	public Game() {
		floor = new Plancher();

		box = new Box();
		box.setPos(-1.0f, -0.4f, -10.0f);
		box.setHeading(45.0f);
		box.setPitch(-1.0f);
		box.setRoll(0.1f);

		box2 = new Box();
		box2.setPos(-5.0f, 0.4f, -10.0f);
		box2.setHeading(45.0f);
		box2.setPitch(-1.0f);
		box2.setRoll(0.1f);
	}

	/*
	 * Every game loop we poll the keyboard and draw the objects
	 */
	public void tick() {
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		GL11.glLoadIdentity();
		floor.draw();
		box.draw();
		box2.draw();
		GL11.glFlush();
		if (Keyboard.isKeyDown(Keyboard.KEY_0)) {

		}

		Vector3f cameraPos = new Vector3f(1,1,1);
		Matrix4f.translate(cameraPos, viewMatrix, viewMatrix);

	}
}
