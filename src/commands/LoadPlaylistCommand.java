package commands;

import java.util.List;
import java.util.Optional;

import entities.Playlist;
import services.PlaylistService;
import services.Player.Player;


public class LoadPlaylistCommand implements ICommand{
    
    //constructor
    public LoadPlaylistCommand(PlaylistService playlistService, Player player){
        this.playlistService = playlistService;
        this.player = player;
    }

    //service variables
    PlaylistService playlistService;
    Player player;

    //override invoke
    @Override
    public void invoke(List<String> tokens){
        
        //extract args in loadplaylist command
        String playlistName = tokens.get(1);
        
        //get the playlist with given name
        Optional<Playlist> playlistOptional = playlistService.findByName(playlistName);
        //given id's are always valid, extract playlist from optional
        Playlist playlist = playlistOptional.get();

        //call the loadPlaylist method in player
        String output = player.loadPlaylist(playlist);
        //print the output
        System.out.println(output);
    }
}
