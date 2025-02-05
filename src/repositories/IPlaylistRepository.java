package repositories;

import java.util.List;
import java.util.Optional;
import entities.Playlist;


public interface IPlaylistRepository {
    public Playlist save(Playlist playlist);

    public boolean existsById(Long id);

    public Optional<Playlist> findById(Long id);

    public List<Playlist> findAll();

    public void deleteById(Long id);

    public long count();
    
}
