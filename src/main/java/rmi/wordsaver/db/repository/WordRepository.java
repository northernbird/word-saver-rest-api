package rmi.wordsaver.db.repository;

import org.springframework.data.repository.CrudRepository;
import rmi.wordsaver.model.Word;

public interface WordRepository extends CrudRepository<Word, Long> {

    // TODO (rmi) check why it doesn't work correctly
//    Word findByWordId(long id);

}