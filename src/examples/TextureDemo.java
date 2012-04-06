package examples;

import static org.lwjgl.opengl.GL11.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.lwjgl.opengl.*;
import org.lwjgl.*;
import org.newdawn.slick.opengl.*;

public class TextureDemo {

	private Texture rgb;
	
	public TextureDemo(){
		try{
			Display.setDisplayMode(new DisplayMode(640, 480));
			Display.setTitle("Textures!");
			Display.create();
		}catch (LWJGLException e){
			e.printStackTrace();
		}
		
		rgb = loadTexture("rgb");
		
		//opengl init code
		
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, 640, 480, 0, 1, -1);
		//    width-^   ^- height
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_TEXTURE_2D);
		
	
		while(!Display.isCloseRequested()){
			
			glClear(GL_COLOR_BUFFER_BIT);// 
			
			rgb.bind();
			
			glBegin(GL_QUADS);
				glTexCoord2f(0, 0);
				glVertex2i(400, 400);//UpLeft
				glTexCoord2f(1,0);
				glVertex2i(450, 400);//UPRIght
				glTexCoord2f(1, 1);
				glVertex2i(450, 450);//DOWNRIGHT
				glTexCoord2f(0, 1);
				glVertex2i(400, 450);//DOWNLEFT
			glEnd();
			
			glBegin(GL_LINES);
				glVertex2i(100, 100);
				glVertex2i(200, 200);
				
			glEnd();
				
			
			
			
			

			Display.update();
			Display.sync(60);
			
		}
		
		Display.destroy();
	}
	
	private Texture loadTexture(String key){
		try {
			return TextureLoader.getTexture("PNG", new FileInputStream(new File("res/" + key +".png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new TextureDemo();

	}

		
	

}