package com.theironyard.entities;

import javax.persistence.*;

/**
 * Created by Taylor on 6/11/16.
 */

@Entity
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue
    private int noteId;

    private String noteContent;

    @ManyToOne
    private User user;

    public Note() {}

    public Note(String noteContent){
        this.noteContent = noteContent;
    }

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

}
