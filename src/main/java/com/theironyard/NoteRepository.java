package com.theironyard;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by Taylor on 6/11/16.
 */
public interface NoteRepository extends CrudRepository<Note, Integer> {
}
