package commands;


import java.util.ArrayList;
import java.util.List;

import entities.Playlist;
import services.PlaylistService;

public class CreatePlaylistCommand implements ICommand{
    
    //constructor
    public CreatePlaylistCommand(PlaylistService playlistService){
        this.playlistService = playlistService;
    }

    //service variable
    PlaylistService playlistService;

    //override invoke
    @Override
    public void invoke(List<String> tokens){
        //get the args in createplaylistcommand
        String playlistName = tokens.get(1);
        //create a list of song ids from arg 2
        List<Long> songIds= new ArrayList<>();
        for(int i=2; i<tokens.size(); i++){
            String songId = tokens.get(i);
            songIds.add(Long.valueOf(songId));
        }

        //now call the createplaylist method in palylist service
        Playlist newPlaylist = playlistService.createPlaylist(playlistName, songIds);
        //print the new playlist
        System.out.println(newPlaylist);

    }
}
