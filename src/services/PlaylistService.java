package services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import entities.Playlist;
import entities.Song;
import repositories.IPlaylistRepository;
import repositories.ISongRepository;


public class PlaylistService {
    //constructor
    public PlaylistService(IPlaylistRepository playlistRepository, ISongRepository songRepository ){
        this.playlistRepository = playlistRepository;
        this.songRepository = songRepository;
    }

    //repo variable
    private final IPlaylistRepository playlistRepository;
    private final ISongRepository songRepository;
    
    //methods required in system

    public Playlist createPlaylist(String name, List<Long> songIds){
        //crreate a new palylist with given name and genere
        Playlist newPlaylist = new Playlist(name);
        //add all songs in given list to playlist
        for(long id : songIds){
            Optional<Song> optional = songRepository.findById(id);
            if(optional.isPresent()){
                newPlaylist.addSong(optional.get());
            }
        }
        //add playlist to repo
        Playlist savedPlaylist = playlistRepository.save(newPlaylist);
        //return the newPlaylist as instance
        return savedPlaylist;
    }

    public String addSong(Long playlistId, Long songId){
        //get the song with id & preconditional check
        Optional<Song> optionalSong = songRepository.findById(songId);
        if(!optionalSong.isPresent())
            throw new IllegalArgumentException("Song with the given id not present");
        Song songWithGivenId = optionalSong.get();

        //get the playlist with id & preconditional check
        Optional<Playlist> optionalPlaylist = playlistRepository.findById(playlistId);
        if(!optionalPlaylist.isPresent())
            throw new IllegalArgumentException("playlist with the given id not present");
        Playlist playlistWithGivenId = optionalPlaylist.get();

        //add song with given id in the palylist with given id
        playlistWithGivenId.addSong(songWithGivenId);

        
        //return as specified (Playlist PLAYLIST_2 is revised with [Song [id=1], Song [id=3]])
        //name of playlist with given id
        String nameOfPlaylist = playlistWithGivenId.getName();
        //list of songs in palylist as string
        String songsInPlaylistAsString = playlistWithGivenId.getListOfSongs().stream()
                                                            .map(Song::toString)
                                                            .collect(Collectors.joining(", "));
        //return as specified
        return String.format("Playlist %s is revised with [%s]", nameOfPlaylist, songsInPlaylistAsString);
    }

    public String removeSong(Long playlistId, Long songId){
        //get the song with id & preconditional check
        Optional<Song> optionalSong = songRepository.findById(songId);
        if(!optionalSong.isPresent())
            throw new IllegalArgumentException("Song with the given id not present");
        Song songWithGivenId = optionalSong.get();

        //get the playlist with id & preconditional check
        Optional<Playlist> optionalPlaylist = playlistRepository.findById(playlistId);
        if(!optionalPlaylist.isPresent())
            throw new IllegalArgumentException("playlist with the given id not present");
        Playlist playlistWithGivenId = optionalPlaylist.get();

        //remove song with given id in the palylist with given id
        playlistWithGivenId.removeSong(songWithGivenId);


        //return as specified (Playlist PLAYLIST_2 is revised with [Song [id=1], Song [id=3]])
        //name of playlist with given id
        String nameOfPlaylist = playlistWithGivenId.getName();
        //list of songs in palylist as string
        String songsInPlaylistAsString = playlistWithGivenId.getListOfSongs().stream()
                                                            .map(Song::toString)
                                                            .collect(Collectors.joining(", "));
        //return as specified
        return String.format("Playlist %s is revised with [%s]", nameOfPlaylist, songsInPlaylistAsString);
   
    }


    public String deletePlaylist(Long playlistId){
        //assuming valid id as given, get the playlistOptional and then playlist
        Playlist playlistWithGivenId = playlistRepository.findById(playlistId).get();

        //delete the playlist with given id from repository
        playlistRepository.deleteById(playlistId);

        //return as specified  (Playlist PLAYLIST_1 is deleted!)
        return String.format("Playlist %s is deleted!", playlistWithGivenId.getName());
    }

    public Optional<Playlist> findByName(String givenName){
        //get all the playlists in the repository
        List<Playlist> allPlaylists = playlistRepository.findAll();
        //for all playlists in the repository
        for(Playlist playlist : allPlaylists){
            //if the given name matches with playlist name
            if(givenName.equals(playlist.getName())){
                //return as optional
                return Optional.ofNullable(playlist);
            }
        }
        return null;
    }
}
