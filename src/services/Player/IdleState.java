package services.Player;

import java.util.List;

import entities.Song;



public class IdleState implements PlayerState {

    public String playSong(Player player){
        //active playlist in the player
        List<Song> activePlaylist = player.getActivePlaylist();
        //in idle state, is play first song of the playlist is played
        Song firstSong = activePlaylist.get(0);
        //and player state changes to playing
        player.setState(new PlayingState());
        //return the playing song as specified
        return String.format("%s is playing!",firstSong.toString());
    }

    public String nextSong(Player player){
        return "Player is in Idle State!";
    }
    public String previousSong(Player player){
        return "Player is in Idle State!";
    }
    public String stopSong(Player player){
        return "Player is in Idle State!";
    }
    
}
