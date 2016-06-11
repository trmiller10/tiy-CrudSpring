package com.theironyard;

import javax.persistence.*;

/**
 * Created by Taylor on 6/11/16.
 */

@Entity
public class Note {

    @Id
    @GeneratedValue
    private int noteId;

    @Column
    private String noteContent;

    @Column
    @ManyToOne
    private User user;

    public Note() {}

    public Note(String noteContent, User user) {
        this.noteContent = noteContent;
        this.user = user;
    }

    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
