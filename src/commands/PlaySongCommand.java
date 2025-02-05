package commands;

import java.util.List;

import services.Player.Player;



public class PlaySongCommand implements ICommand{
    //constructor
    public PlaySongCommand(Player player){
        this.player = player;
    }

    //service variables
    Player player;

    //override invoke
    @Override
    public void invoke(List<String> tokens){
        //no args for play song command
        //call the playsong command in player
        String output = player.playSong();
        //print the output
        System.out.println(output);
    }
    
}
