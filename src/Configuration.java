import commands.AddSongCommand;
import commands.AddSongToPlaylistCommand;
import commands.CommandKeyword;
import commands.CommandRegistry;
import commands.CreatePlaylistCommand;
import commands.DeletePlaylistCommand;
import commands.DeleteSongFromPlaylistCommand;
import commands.ICommand;
import commands.ListSongsCommand;
import commands.LoadPlaylistCommand;
import commands.NextSongCommand;
import commands.PlaySongCommand;
import commands.PreviousSongCommand;
import commands.StopSongCommand;
import repositories.IPlaylistRepository;
import repositories.ISongRepository;
import repositories.PlaylistRepository;
import repositories.SongRepository;
import services.PlaylistService;
import services.SongService;
import services.Player.Player;

public class Configuration {

    //singleton pattern
    //make constructor private
    private Configuration(){}

    //instantiate a single configuration instance
    private static Configuration config = new Configuration();

    //static getter to return the only config instance
    public static Configuration getInstance(){
        return config;
    }


    //instantiate repositories
    ISongRepository songRepository = new SongRepository();
    IPlaylistRepository playlistRepository = new PlaylistRepository();

    //instantiate services passing repos to their constructor
    SongService songService = new SongService(songRepository);
    PlaylistService playlistService = new PlaylistService(playlistRepository, songRepository);
    Player player = new Player();

    //instantiate the commands passing services to their constructor
    ICommand addSongCommand = new AddSongCommand(songService);
    ICommand addsongtoplaylistCommand = new AddSongToPlaylistCommand(playlistService);
    ICommand createPlaylistCommand = new CreatePlaylistCommand(playlistService);
    ICommand deletePlaylistCommand = new DeletePlaylistCommand(playlistService);
    ICommand deletesongfromplaylistCommand = new DeleteSongFromPlaylistCommand(playlistService);
    ICommand listSongsCommand = new ListSongsCommand(songService);
    ICommand loadPlaylistCommand = new LoadPlaylistCommand(playlistService, player);
    ICommand nextSongCommand = new NextSongCommand(player);
    ICommand playSongCommand = new PlaySongCommand(player);
    ICommand previousSongCommand = new PreviousSongCommand(player);
    ICommand stopSongCommand = new StopSongCommand(player);

    //instantiate the command registry
    CommandRegistry commandRegistry = new CommandRegistry();
    
    //used in getcommandregistry method. 
    //register all the commands with their names & instances to the command registry
    private void registerCommands(){
        commandRegistry.registerCommand(CommandKeyword.ADD_SONG_COMMAND.getName(), addSongCommand);
        commandRegistry.registerCommand(CommandKeyword.ADD_SONG_TO_PLAYLIST_COMMAND.getName(), addsongtoplaylistCommand);
        commandRegistry.registerCommand(CommandKeyword.CREATE_PLAYLIST_COMMAND.getName(), createPlaylistCommand);
        commandRegistry.registerCommand(CommandKeyword.DELETE_PLAYLIST_COMMAND.getName(), deletePlaylistCommand);
        commandRegistry.registerCommand(CommandKeyword.DELETE_SONG_FROM_PLAYLIST_COMMAND.getName(), deletesongfromplaylistCommand);
        commandRegistry.registerCommand(CommandKeyword.LIST_SONGS_COMMAND.getName(), listSongsCommand);
        commandRegistry.registerCommand(CommandKeyword.LOAD_PLAYLIST_COMMAND.getName(), loadPlaylistCommand);
        commandRegistry.registerCommand(CommandKeyword.NEXT_SONG_COMMAND.getName(), nextSongCommand);
        commandRegistry.registerCommand(CommandKeyword.PLAY_SONG_COMMAND.getName(), playSongCommand);
        commandRegistry.registerCommand(CommandKeyword.PREVIOUS_SONG_COMMAND.getName(), previousSongCommand);
        commandRegistry.registerCommand(CommandKeyword.STOP_SONG_COMMAND.getName(), stopSongCommand);
    }

    //getter to register and send the commands
    public CommandRegistry getCommandRegistry(){
        registerCommands();
        return commandRegistry;
    }

}
