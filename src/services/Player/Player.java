package services.Player;

import java.util.LinkedList;
import java.util.List;

import entities.Playlist;
import entities.Song;


public class Player {
    //constructors
    public Player(){
        this.currentState = new IdleState();
    }
    
    //direct attribute
    private List<Song> activePlaylist;
    //relation attribute
    private PlayerState currentState;

    //getters
    public List<Song> getActivePlaylist(){
        return this.activePlaylist;
    }
    public PlayerState getState(){
        return this.currentState;
    }


    //behaviours
    public void setState(PlayerState playerState){
        this.currentState = playerState;
    }
    //main behaviours of player
    public String loadPlaylist(Playlist playList){
        activePlaylist = new LinkedList<>();
        for(Song s : playList.getListOfSongs()){
            activePlaylist.add(s);
        }
        return String.format("Playlist %s is loaded!",playList.getName());
    }
    
    public String playSong(){
        return currentState.playSong(this);
    }
    public String nextSong(){
        return currentState.nextSong(this);
    }
    public String previousSong(){
        return currentState.previousSong(this);
    }
    public String stopSong(){
        return currentState.stopSong(this);
    } 
}
