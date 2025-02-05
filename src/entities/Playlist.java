package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Playlist {

    //constructors
    public Playlist(Long id, String name){
        this.id = id;
        this.name = name;
    }
    public Playlist(String name){
        this.name = name;
    }

    
    //direct 
    private Long id;
    private String name;
    //relations
    private List<Song> listOfSongs = new ArrayList<>();

    
    //getters
    public Long getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public List<Song> getListOfSongs(){
        return listOfSongs;
    }

    //behaviours
    public void addSong(Song s){
        listOfSongs.add(s);
    }
    public void removeSong(Song s){
        listOfSongs.remove(s);
    }

    @Override
    public String toString(){
        return String.format("Playlist [id=%d]",id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.id);
    }

    @Override
    public boolean equals(Object obj){
        if(obj==this) 
            return true;
        if(obj ==null || obj.getClass() != this.getClass())
            return false;
        Playlist p = (Playlist) obj;
        return p.getId().equals(this.getId());
    }
}
