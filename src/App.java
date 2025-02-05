

import java.io.BufferedReader;
import java.io.FileReader;

import commands.CommandRegistry;


public class App {

    public static void main(String[] args) {
        if (args.length != 1){
            throw new RuntimeException();
        }
        
        String inputFile = args[0];

        Configuration conf = Configuration.getInstance();

        CommandRegistry commandRegistry = conf.getCommandRegistry();

        try(BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {

            while (true) {
                String line = reader.readLine();
                if (line == null){
                    break;
                }
                commandRegistry.invokeCommand(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
      
}
