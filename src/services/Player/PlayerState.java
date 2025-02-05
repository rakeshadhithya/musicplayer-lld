package services.Player;

public interface PlayerState {
    public String playSong(Player player);
    public String nextSong(Player player);
    public String previousSong(Player player);
    public String stopSong(Player player);
}
