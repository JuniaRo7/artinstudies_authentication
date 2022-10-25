package bra.edu.ifsp.artinstudies.repository;
import org.springframework.data.repository.CrudRepository;
import bra.edu.ifsp.artinstudies.model.Playlist;

public interface PlaylistRepository extends CrudRepository<Playlist, Long> {

}