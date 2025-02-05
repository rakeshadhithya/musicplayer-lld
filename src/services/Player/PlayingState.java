package services.Player;

import java.util.List;

import entities.Song;


public class PlayingState implements PlayerState {

    public String playSong(Player player){
        //active playlist in the player
        List<Song> activePlaylist = player.getActivePlaylist();
        //in playing state if pressed play, player state changes to paused
        player.setState(new PausedState());
        //return the paused song as specified
        Song pausedSong = activePlaylist.get(0);
        return String.format("%s is paused!", pausedSong.toString());
    }

    public String nextSong(Player player){
        //active playlist in the player
        List<Song> activePlaylist = player.getActivePlaylist();
        //in playing state if next, first song removed & added to last
        Song firstSong = activePlaylist.remove(0);
        activePlaylist.add(firstSong);
        //now the second song will become the top song and it will play
        Song nextSong = activePlaylist.get(0);
        //return the song as specified (player state remains same)
        return String.format("%s is playing!",nextSong.toString());
    }

    public String previousSong(Player player){
        //active playlist in the player
        List<Song> activePlaylist = player.getActivePlaylist();
        //in playing state if prev, last song removed & added to first
        int size = activePlaylist.size();
        Song lastSong = activePlaylist.remove(size - 1);
        //now add that last song to first
        activePlaylist.add(0, lastSong);
        //return the added song as specified (state remains same)
        return String.format("%s is playing!",lastSong.toString());

    }

    public String stopSong(Player player){
        //active playlist in the player
        List<Song> activePlaylist = player.getActivePlaylist();
        //in playing state, if stop player state changes to idle
        player.setState(new IdleState());
        //return the stopped song as specified
        Song stoppedSong = activePlaylist.get(0);
        return String.format("%s is stopped!", stoppedSong.toString());
    }
    
}
