package services;

import java.util.List;

import entities.Song;
import repositories.ISongRepository;



public class SongService {
    //constructor
    public SongService(ISongRepository songRepository){
    this.songRepository = songRepository;
    }

    //repo variable
    private final ISongRepository songRepository;

    //methods required in system
    public Song addSong(Song song){
        return songRepository.save(song);
    }

    public List<Song> getSongs(){
        return songRepository.findAll();
    }
   
}


