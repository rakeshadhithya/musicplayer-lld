package commands;

import java.util.List;

import entities.Song;
import services.SongService;


public class AddSongCommand implements ICommand{
    
    //constructor
    public AddSongCommand(SongService songService){
        this.songService = songService;
    }

    //service varible
    SongService songService;

    //override invoke
    @Override
    public void invoke(List<String> tokens){
        //extract the arguments in add song command
        String name = tokens.get(1);
        String artist = tokens.get(2);
        String album = tokens.get(3);
        String genere = tokens.get(4);
        //create a new song instance with the given args
        Song newSong = new Song(name, artist, album, genere);
        //add song to repo using SongService
        Song s = songService.addSong(newSong);
        //print the added song
        System.out.println(s);
    }
}
