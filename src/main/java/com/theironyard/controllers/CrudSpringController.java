package com.theironyard.controllers;

import java.util.List;
import com.theironyard.entities.Note;
import com.theironyard.services.NoteRepository;
import com.theironyard.utilities.PasswordStorage;
import com.theironyard.entities.User;
import com.theironyard.services.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;


/**
 * Created by Taylor on 6/10/16.
 */
@Controller
public class CrudSpringController {


    @Autowired
    UserRepository userRepository;
    @Autowired
    NoteRepository noteRepository;


    //map "/"


    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session) {
        User user = userRepository.findByUserName((String) session.getAttribute("userName"));
        if(user == null) {
            return "redirect:/login";
        }
        model.addAttribute("userName", session.getAttribute("userName"));

        return "login";
    }

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String login(HttpSession session, Model model){
        User user = userRepository.findByUserName((String) session.getAttribute("userName"));

        if(user != null){
            return "redirect:/home";
        }

        /*Iterable<User> allUsers = userRepository.findAll();
        for(User listedUser : allUsers){
            Iterable<Note> allNotes = noteRepository.findNotesByUser(listedUser);
            model.addAttribute("allNotes", allNotes);
        }
        model.addAttribute("allUsers", allUsers);*/

        Iterable<Note> allNotes = noteRepository.findAll();
        model.addAttribute("allNotes", allNotes);

        return "login";
    }

    @RequestMapping(path="/login", method = RequestMethod.POST)
    public String loginUser (HttpSession session, String userName, String password) throws Exception{

        User user = userRepository.findByUserName(userName);

        if(user == null){
            user = new User(userName, PasswordStorage.createHash(password));
            session.setAttribute("userName", user.getuserName());
            userRepository.save(user);
            return "redirect:/home";
        }
        else if (!PasswordStorage.verifyPassword(password, user.getPasswordHash())) {
            return "redirect:/login";
        }
        session.setAttribute("userName", user.getuserName());
        return "redirect:/home";
    }

    @RequestMapping(path="/logout", method = RequestMethod.POST)
    public String logoutUser (HttpSession session){
        session.invalidate();
        return "redirect:/";
    }

    @RequestMapping(path = "/home", method = RequestMethod.GET)
    public String home(HttpSession session, Model model){
        User user = userRepository.findByUserName((String) session.getAttribute("userName"));
        if(user == null){
            return "redirect:/login";
        }
        Iterable<Note> notes = noteRepository.findNotesByUser(user);
        model.addAttribute("notes", notes);

        //Iterable<User> allUsers = userRepository.findAll();
        Iterable<Note> allNotes = noteRepository.findAll();
      /*  for(User listedUser : allUsers){
            Iterable<Note> findNotes = noteRepository.findNotesByUser(listedUser);
            if(findNotes.iterator().hasNext()){
                allNotes.add();
            }
        }*/

        model.addAttribute("allNotes", allNotes);

        //model.addAttribute("allUsers", allUsers);
        model.addAttribute("userName", user.getuserName());
        return "home";
    }


    @RequestMapping(path="/add-note", method=RequestMethod.POST)
    public String addNote(HttpSession session, String note) {
        User user = userRepository.findByUserName((String) session.getAttribute("userName"));
        if(user == null){
            return "redirect:/login";
        }
        Note newNote = new Note(note, user);
        noteRepository.save(newNote);
        return "redirect:/home";
    }

    @RequestMapping(path="/edit-note", method = RequestMethod.POST)
    public String editNote(HttpSession session, Integer editId, String editNote){
        User user = userRepository.findByUserName((String) session.getAttribute("userName"));
        if(user == null){
            return "redirect:/home";
        }
        Note oldNote = noteRepository.findOne(editId);
        oldNote.setNoteContent(editNote);
        noteRepository.save(oldNote);

        return "redirect:/home";
    }

    @RequestMapping(path="delete-note", method=RequestMethod.POST)
    public String deleteNote(HttpSession session, Integer deleteId){
        User user = userRepository.findByUserName((String) session.getAttribute("userName"));
        if(user == null){
            return "redirect:/login";
        }
         noteRepository.delete(deleteId);

        return "redirect:/home";
    }

}

