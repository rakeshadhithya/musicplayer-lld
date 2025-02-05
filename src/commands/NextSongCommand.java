package commands;

import java.util.List;

import services.Player.Player;


public class NextSongCommand implements ICommand{
    
    //constructor
    public NextSongCommand(Player player){
        this.player = player;
    }

    //service variables
    Player player;

    //override invoke
    @Override
    public void invoke(List<String> tokens){
        //no args for next song command
        //call the nextsong command in player
        String output = player.nextSong();
        //print the output
        System.out.println(output);
    }
}
