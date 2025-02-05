package commands;

import java.util.List;

import services.Player.Player;

public class StopSongCommand implements ICommand {

    //constructor
    public StopSongCommand(Player player){
        this.player = player;
    }

    //service variables
    Player player;

    //override invoke
    @Override
    public void invoke(List<String> tokens){
        //no args for play song command
        //call the stopsong command in player
        String output = player.stopSong();
        //print the output
        System.out.println(output);
    }
    
}
