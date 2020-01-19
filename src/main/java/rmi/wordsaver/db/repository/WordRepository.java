package rmi.wordsaver.db.repository;

import org.springframework.data.repository.CrudRepository;
import rmi.wordsaver.model.Word;

public interface WordRepository extends CrudRepository<Word, Long> {

    Word findById(long id);

}