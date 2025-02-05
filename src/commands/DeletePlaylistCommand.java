package commands;

import java.util.List;
import java.util.Optional;

import entities.Playlist;
import services.PlaylistService;

public class DeletePlaylistCommand implements ICommand{
    //constructor
    public DeletePlaylistCommand(PlaylistService playlistService){
        this.playlistService = playlistService;
    }

    //service variable
    PlaylistService playlistService;

    //override invoke
    @Override
    public void invoke(List<String> tokens){
        //extract args in delete playlist command
        String playlistName = tokens.get(1);

        //get the playlist with given name
        Optional<Playlist> playlistOptional = playlistService.findByName(playlistName);
        //given id's are always valid, extract playlist from optional
        Playlist playlist = playlistOptional.get();
        //get id of the playlist
        long playlistId = playlist.getId();

        //call deleteplaylist in playlistservice
        String output = playlistService.deletePlaylist(playlistId);
        System.out.println(output);
    }
}
