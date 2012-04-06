package examples;

import static org.lwjgl.opengl.GL11.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.lwjgl.opengl.*;
import org.lwjgl.*;
import org.lwjgl.input.*;

public class InputDemo {
	
	List<Box> shapes = new ArrayList<Box>(16);

	public InputDemo(){
		try{
			Display.setDisplayMode(new DisplayMode(640, 480));
			Display.setTitle("InputTest");
			Display.create();
		}catch (LWJGLException e){
			e.printStackTrace();
		}
		//opengl init code
		
		shapes.add(new Box(15, 15));
		shapes.add(new Box(100, 150));
		
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, 640, 480, 0, 1, -1);
		//    width-^   ^- height
		glMatrixMode(GL_MODELVIEW);
		
	
		while(!Display.isCloseRequested()){
			
			glClear(GL_COLOR_BUFFER_BIT);// 
			
			if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)){
				Display.destroy();
				System.exit(0);
				
			}
			
			int dx = Mouse.getDX();
			int dy = -Mouse.getDY();
			
			System.out.println(dy+", " +dx);
			for(Box box :shapes){
				box.draw();
				
			}
			
			Display.update();
			Display.sync(60);
			
		}
		
		Display.destroy();
	}
	
	
	private static class Box{
		public int x, y;
		public boolean selected = false;
		private float colorRed, colorBlue, colorGreen;
		
		Box (int x, int y){
			this.x = x;
			this.y = y;
			
			Random randomGenerator = new Random();
			colorRed = randomGenerator.nextFloat();
			colorBlue = randomGenerator.nextFloat();
			colorGreen = randomGenerator.nextFloat();

		}
		
		boolean inBounds(int mousex, int mousey){
			if(mousex > x && mousex < x+50 && mousey > y && mousey < y+50){
				return true;
			}else{
				return false;
			}
			
		}
		
		void update(int dx, int dy){
			x += dx;
			y += dy;
			
		}
		
		void ramdomizeColors(){
			
			Random randomGenerator = new Random();
			colorRed = randomGenerator.nextFloat();
			colorBlue = randomGenerator.nextFloat();
			colorGreen = randomGenerator.nextFloat();
			
			
		}
		
		void draw(){
			
			glColor3f(colorRed, colorGreen, colorBlue);
			glBegin(GL_QUADS);
				glVertex2f(x, y);
				glVertex2f(x+50, y);
				glVertex2f(x+50, y+50);
				glVertex2f(x, y+50);
			glEnd();
			
		}
		
		
		
		
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new InputDemo();

	}

		
	

}