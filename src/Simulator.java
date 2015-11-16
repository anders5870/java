import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 * @author Anders Ålander
 * Contain's the main method.
 * This class loads the simulation's parameters from config.properties,
 * creates a Simulation object, runs it for a given number of steps determined
 * by time in properties and prints the statistics each step.
 */
public class Simulator{

	
    public static void main(String[] args) throws InterruptedException, IOException{
    	Properties prop = new Properties();
		InputStream input = null;
		int numberOfRegisters = 5;
		int maxGroceries = 20;
		int thresholdForNewRegister = 6;
		int intensity = 50;
        int time = 5;
		try{
			input = new FileInputStream("config.properties");
			prop.load(input);	
			numberOfRegisters = 
					Integer.parseInt(prop.getProperty("numberOfRegisters","8"));
			intensity = 
					Integer.parseInt(prop.getProperty("intensity","50"));
			maxGroceries = 
					Integer.parseInt(prop.getProperty("maxGroceries","10"));
			thresholdForNewRegister = 
					Integer.parseInt(prop.getProperty("thresholdForNewRegister","7"));
			time = 
					Integer.parseInt(prop.getProperty("time","5"));
			}catch(IOException e){
				numberOfRegisters = 5;
				intensity = 50;
				maxGroceries = 20;
				thresholdForNewRegister = 5;
			}   
        Simulation sim = new Simulation(numberOfRegisters, intensity, maxGroceries, thresholdForNewRegister); 
        for(int i = 0; i < time; i++){
            System.out.print(sim);
            sim.step();

            Thread.sleep(500);
        }
        System.out.println("");
        System.out.println("Simulation finished!");
    }
}
