package examples;

import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.opengl.*;
import org.lwjgl.*;

public class LWJGLHelloWorld {

	public LWJGLHelloWorld(){
		try{
			Display.setDisplayMode(new DisplayMode(640, 480));
			Display.setTitle("HELLOWORLD");
			Display.create();
		}catch (LWJGLException e){
			e.printStackTrace();
		}
		//opengl init code
	
		while(!Display.isCloseRequested()){

			Display.update();
			Display.sync(60);
			
		}
		
		Display.destroy();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new LWJGLHelloWorld();

	}

		
	

}
