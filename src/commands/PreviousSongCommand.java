package commands;

import java.util.List;

import services.Player.Player;


public class PreviousSongCommand implements ICommand{
    //constructor
    public PreviousSongCommand(Player player){
        this.player = player;
    }

    //service variables
    Player player;

    //override invoke
    @Override
    public void invoke(List<String> tokens){
        //no args for previous song command
        //call the previoussong command in player
        String output = player.previousSong();
        //print the output
        System.out.println(output);
    }
    
}
