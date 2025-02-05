package repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import entities.Song;

public class SongRepository implements ISongRepository {
    //constructor
    public SongRepository(){
        songMap = new HashMap<>();
    }

    //ds and the id variable
    private final Map<Long,Song> songMap;
    private Long autoIncrement = 1L;
    
    //mandatory methods

    public Song save(Song song){
        //deep copy the variables into new song
        Song s = new Song(autoIncrement, song.getName(), song.getArtist(), song.getAlbum(), song.getGenere());
        //put new song to map
        songMap.put(autoIncrement, s);
        //autoIncrement the varibale
        autoIncrement++;
        //return newly created object
        return s;
    }

    public boolean existsById(Long id){
        return songMap.containsKey(id);
    }

    public Optional<Song> findById(Long id){
        return Optional.ofNullable(songMap.get(id));
    }

    public List<Song> findAll(){
        return songMap.values().stream().collect(Collectors.toList());
    }

    public void deleteById(Long id){
        songMap.remove(id);
    }

    public long count(){
        return songMap.size();
    }

}
