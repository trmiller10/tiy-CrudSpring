package com.theironyard.services;

import java.util.List;
import com.theironyard.entities.Note;
import com.theironyard.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Taylor on 6/11/16.
 */
@Repository
public interface NoteRepository extends CrudRepository<Note, Integer> {
    List<Note> findNotesByUser(User user);
}
