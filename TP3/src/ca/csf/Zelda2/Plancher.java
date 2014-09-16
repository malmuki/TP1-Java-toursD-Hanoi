package ca.csf.Zelda2;

import org.lwjgl.opengl.GL11;

public class Plancher {
	
	public void draw(){
		 GL11.glLoadIdentity();
		 GL11.glBegin(GL11.GL_QUADS);
		 GL11.glColor3f(0.2f, 0.4f, 0.0f);
		 GL11.glVertex3f(-100.0f, -1.0f, 100.0f);
		 GL11.glVertex3f(-100.0f, -1.0f, -100.0f);
		 GL11.glVertex3f(100.0f, -1.0f, -100.0f);
		 GL11.glVertex3f(100.0f, -1.0f, 100.0f);
		 GL11.glEnd();
		 }
	
	
}
