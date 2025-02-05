package services.Player;

import java.util.List;
import entities.Song;

public class PausedState implements PlayerState {

    public String playSong(Player player){
        //active playlist in the player
        List<Song> activePlaylist = player.getActivePlaylist();
        //in paused state if pressed play, player state changes to playing
        player.setState(new PlayingState());
        //return the playing song as specified
        Song playingSong = activePlaylist.get(0);
        return String.format("%s is playing!", playingSong.toString());
    }

    public String nextSong(Player player){
        //active playlist in the player
        List<Song> activePlaylist = player.getActivePlaylist();
        //in paused state if next, first song removed & added to last
        Song firstSong = activePlaylist.remove(0);
        activePlaylist.add(firstSong);
        //now the second song will become the top song and it will play
        Song nextSong = activePlaylist.get(0);
        //player state changes to playing
        player.setState(new PlayingState());
        //return the song as specified (player state remains same)
        return String.format("%s is playing!",nextSong.toString());
    }

    public String previousSong(Player player){
        //active playlist in the player
        List<Song> activePlaylist = player.getActivePlaylist();
        //in paused state if prev, last song removed & added to first
        int size = activePlaylist.size();
        Song lastSong = activePlaylist.remove(size - 1);
        //now add that last song to first
        activePlaylist.add(0, lastSong);
        //player state changes to playing
        player.setState(new PlayingState());
        //return the added song as specified (state remains same)
        return String.format("%s is playing!",lastSong.toString());

    }

    public String stopSong(Player player){
        //active playlist in the player
        List<Song> activePlaylist = player.getActivePlaylist();
        //in paused state, if stop player state changes to idle
        player.setState(new IdleState());
        //return the stopped song as specified
        Song stoppedSong = activePlaylist.get(0);
        return String.format("%s is stopped!", stoppedSong.toString());
    }
    
}
