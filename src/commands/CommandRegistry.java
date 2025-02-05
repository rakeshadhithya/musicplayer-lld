package commands;

import java.util.Arrays;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CommandRegistry {

    //map to hold command instances
    private static final Map<String,ICommand> commandRegistry = new HashMap<>();

    //register command method
    public void registerCommand(String commandKeyword, ICommand command){
        commandRegistry.put(commandKeyword, command);
    }
    //unregister command
    public void unRegisterCommand(String commandKeyword){
        commandRegistry.remove(commandKeyword);
    }

    public void invokeCommand(String input){
        //split the line to list of tokens
        List<String> tokens = Arrays.stream(input.split(" ")).collect(Collectors.toList());
        //get the command instance as per command name 
        ICommand command = commandRegistry.get(tokens.get(0));
        //throw a runtime exception if it is null
        if(command == null) throw new RuntimeException("invlaid command");
        //call the invoke method in command with the list of tokens
        command.invoke(tokens);
    }
    
}
