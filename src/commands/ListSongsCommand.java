package commands;

import java.util.List;

import entities.Song;
import services.SongService;

public class ListSongsCommand implements ICommand{
    
    //constructor
    public ListSongsCommand(SongService songService){
        this.songService = songService;
    }

    //service variable
    SongService songService;

    //override invoke
    @Override
    public void invoke(List<String> tokens){
        //directly call list songs in songservice (no args for this command)
        List<Song> allSongs = songService.getSongs();
        //print the list
        System.out.println(allSongs);
    }
}
