package ca.csf.Zelda2;

import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

public class Box{

	 /*
	 * this is the identity matrix... the same one set when glLoadIdentity
	 * is called.
	 */
	
	 private float[] mat={ 1,0,0,0,
	 0,1,0,0,
	 0,0,1,0,
	 0,0,0,1};
	 private FloatBuffer posMat;//translate x, y, z
	 private FloatBuffer headingMat;//rotate around y
	 private FloatBuffer pitchMat;//rotate around x
	 private FloatBuffer rollMat;//rotate around z
	 /*
	 * these values are set by the Game class which owns the box
	 */
	 private float posx, posy, posz;
	 private float heading;
	 private float pitch;
	 private float roll;
	 
	 public Box(){
	 //declare FloatBuffers
	 posMat=BufferUtils.createFloatBuffer(mat.length);
	 headingMat=BufferUtils.createFloatBuffer(mat.length);
	 pitchMat=BufferUtils.createFloatBuffer(mat.length);
	 rollMat=BufferUtils.createFloatBuffer(mat.length); 
	
	 //initialize with the identity matrix
	 posMat.put(mat);
	 headingMat.put(mat);
	 pitchMat.put(mat);
	 rollMat.put(mat);
	 }

	 public void draw(){
	 //set the ModelView matrix to the identity matrix
	 GL11.glLoadIdentity();
	 /*
	 * multiply by the matrices holding position and heading, etc.
	 * Note that the oder of multiplication will alter the transformation
	 * of the box in the game world.
	 */
	 posMat.rewind();
	 GL11.glMultMatrix(posMat);
	 headingMat.rewind();
	 GL11.glMultMatrix(headingMat);
	 pitchMat.rewind();
	 GL11.glMultMatrix(pitchMat);
	 rollMat.rewind();
	 GL11.glMultMatrix(rollMat);

	 //draw the box
	 GL11.glColor3f(0.8f, 0.5f, 0.3f);
	 GL11.glBegin(GL11.GL_QUADS);
	 // Front Face
	 GL11.glNormal3f(0.0f, 0.0f, 1.0f);
	 GL11.glTexCoord2f(0.0f, 0.0f);
	 GL11.glVertex3f(-1.0f, -1.0f, 1.0f);
	 GL11.glColor3f(0, 1, 0);
	 GL11.glTexCoord2f(1.0f, 0.0f);
	 GL11.glVertex3f(1.0f, -1.0f, 1.0f);
	 GL11.glColor3f(0, 1, 0);
	 GL11.glTexCoord2f(1.0f, 1.0f);
	 GL11.glVertex3f(1.0f, 1.0f, 1.0f);
	 GL11.glColor3f(0, 1, 0);
	 GL11.glTexCoord2f(0.0f, 1.0f);
	 GL11.glVertex3f(-1.0f, 1.0f, 1.0f);
	 // Back Face
	 GL11.glNormal3f(0.0f, 0.0f, -1.0f);
	 GL11.glTexCoord2f(1.0f, 0.0f);
	 GL11.glVertex3f(-1.0f, -1.0f, -1.0f);
	 GL11.glTexCoord2f(1.0f, 1.0f);
	 GL11.glVertex3f(-1.0f, 1.0f, -1.0f);
	 GL11.glColor3f(0, 1, 0);
	 GL11.glTexCoord2f(0.0f, 1.0f);
	 GL11.glVertex3f(1.0f, 1.0f, -1.0f);
	 GL11.glTexCoord2f(0.0f, 0.0f);
	 GL11.glVertex3f(1.0f, -1.0f, -1.0f);
	 // Top Face
	 GL11.glNormal3f(0.0f, 1.0f, 0.0f);
	 GL11.glTexCoord2f(0.0f, 1.0f);
	 GL11.glVertex3f(-1.0f, 1.0f, -1.0f);
	 GL11.glTexCoord2f(0.0f, 0.0f);
	 GL11.glVertex3f(-1.0f, 1.0f, 1.0f);
	 GL11.glTexCoord2f(1.0f, 0.0f);
	 GL11.glVertex3f(1.0f, 1.0f, 1.0f);
	 GL11.glTexCoord2f(1.0f, 1.0f);
	 GL11.glVertex3f(1.0f, 1.0f, -1.0f);
	 // Bottom Face
	 GL11.glNormal3f(0.0f, -1.0f, 0.0f);
	 GL11.glTexCoord2f(1.0f, 1.0f);
	 GL11.glVertex3f(-1.0f, -1.0f, -1.0f);
	 GL11.glTexCoord2f(0.0f, 1.0f);
	 GL11.glVertex3f(1.0f, -1.0f, -1.0f);
	 GL11.glTexCoord2f(0.0f, 0.0f);
	 GL11.glVertex3f(1.0f, -1.0f, 1.0f);
	 GL11.glTexCoord2f(1.0f, 0.0f);
	 GL11.glVertex3f(-1.0f, -1.0f, 1.0f);
	 // Right face
	 GL11.glNormal3f(1.0f, 0.0f, 0.0f);
	 GL11.glTexCoord2f(1.0f, 0.0f);
	 GL11.glVertex3f(1.0f, -1.0f, -1.0f);
	 GL11.glTexCoord2f(1.0f, 1.0f);
	 GL11.glVertex3f(1.0f, 1.0f, -1.0f);
	 GL11.glTexCoord2f(0.0f, 1.0f);
	 GL11.glVertex3f(1.0f, 1.0f, 1.0f);
	 GL11.glTexCoord2f(0.0f, 0.0f);
	 GL11.glVertex3f(1.0f, -1.0f, 1.0f);
	 // Left Face
	 GL11.glNormal3f(-1.0f, 0.0f, 0.0f);
	 GL11.glTexCoord2f(0.0f, 0.0f);
	 GL11.glVertex3f(-1.0f, -1.0f, -1.0f);
	 GL11.glTexCoord2f(1.0f, 0.0f);
	 GL11.glVertex3f(-1.0f, -1.0f, 1.0f);
	 GL11.glTexCoord2f(1.0f, 1.0f);
	 GL11.glVertex3f(-1.0f, 1.0f, 1.0f);
	 GL11.glTexCoord2f(0.0f, 1.0f);
	 GL11.glVertex3f(-1.0f, 1.0f, -1.0f);
	 GL11.glEnd();
	 }
	 /*
	 * setter methods. 
	 */
	 public void setPos(float x, float y, float z){
	 posMat.put(12, x);
	 posMat.put(13, y);
	 posMat.put(14, z);
	 }
	 public void setHeading(float deg){
	 headingMat.put(0, (float)Math.cos(deg));
	 headingMat.put(2, -(float)Math.sin(deg));
	 headingMat.put(8, (float)Math.sin(deg));
	 headingMat.put(10, (float)Math.cos(deg));
	 }
	 public void setPitch(float deg){
	 pitchMat.put(5, (float)Math.cos(deg));
	 pitchMat.put(6, (float)Math.sin(deg));
	 pitchMat.put(9, -(float)Math.sin(deg));
	 pitchMat.put(10, (float)Math.cos(deg));
	 }
	 public void setRoll(float deg){
	 rollMat.put(0, (float)Math.cos(deg));
	 rollMat.put(1, (float)Math.sin(deg));
	 rollMat.put(4, -(float)Math.sin(deg));
	 rollMat.put(5, (float)Math.cos(deg));
	 }

	}