package examples;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class OBJLoader {
	public static Model loadModel(File f) throws FileNotFoundException, IOException{
		BufferedReader reader = new BufferedReader(new FileReader(f));
		Model m - new Model();
		String line;
		while((line =reader.readLine())!= null){
			//parse
			if (line.startsWith)
		}
		return m;

		
	}
}
