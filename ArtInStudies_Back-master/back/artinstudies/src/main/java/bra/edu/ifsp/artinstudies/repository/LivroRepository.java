package bra.edu.ifsp.artinstudies.repository;
import org.springframework.data.repository.CrudRepository;
import bra.edu.ifsp.artinstudies.model.Livro;

public interface LivroRepository extends CrudRepository<Livro, Long> {

}