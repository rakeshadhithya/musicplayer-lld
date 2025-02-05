package commands;

import java.util.List;
import java.util.Optional;

import entities.Playlist;
import services.PlaylistService;


public class AddSongToPlaylistCommand implements ICommand{
    
    //constructor
    public AddSongToPlaylistCommand(PlaylistService playlistService){
        this.playlistService = playlistService;
    }

    //service variable
    PlaylistService playlistService;

    //override invoke method
    @Override
    public void invoke(List<String> tokens){
        //extract the args in addsongtoplaylist command
        String playlistName = tokens.get(1);
        long songId = Long.valueOf(tokens.get(2));
 

        //get the playlist with given name
        Optional<Playlist> playlistOptional = playlistService.findByName(playlistName);
        //given id's are always valid, extract playlist from optional
        Playlist playlist = playlistOptional.get();
        //get id of the playlist
        long playlistId = playlist.getId();

        //now call the addSong method from playlistService
        String revisedPlaylist = playlistService.addSong(playlistId, songId);
        //print the revisedPlaylist
        System.out.println(revisedPlaylist);
    }
}
