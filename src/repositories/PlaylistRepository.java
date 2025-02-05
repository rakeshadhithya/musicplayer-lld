package repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import entities.Playlist;
import entities.Song;


public class PlaylistRepository implements IPlaylistRepository{
    //constructor
    public PlaylistRepository(){
        playlistMap = new HashMap<>();
    }


    //ds and id variable
    private final Map<Long,Playlist> playlistMap;
    private Long autoIncrement = 1L;

    //mandatory methods

    public Playlist save(Playlist playlist){
        //deep copy the variables of given playlist into new playlist
        Playlist p = new Playlist(autoIncrement, playlist.getName());
        for(Song s : playlist.getListOfSongs()){
            p.addSong(s);
        }
        //put the newly created playlist into map
        playlistMap.put(autoIncrement,p);
        //autoIncrement the variable
        autoIncrement++;
        //return the newly created playlist
        return p;
    }

    public boolean existsById(Long id){
        return playlistMap.containsKey(id);
    }

    public Optional<Playlist> findById(Long id){
        return Optional.ofNullable(playlistMap.get(id));
    }

    public List<Playlist> findAll(){
        return playlistMap.values().stream().collect(Collectors.toList());
    }

    public void deleteById(Long id){
        playlistMap.remove(id);
    }

    public long count(){
        return playlistMap.size();
    }
}
