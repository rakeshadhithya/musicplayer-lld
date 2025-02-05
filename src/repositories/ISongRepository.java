package repositories;

import java.util.List;
import java.util.Optional;

import entities.Song;

public interface ISongRepository {
    public Song save(Song song);

    public boolean existsById(Long id);

    public Optional<Song> findById(Long id);

    public List<Song> findAll();

    public void deleteById(Long id);

    public long count();
    
}
