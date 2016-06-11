package com.theironyard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by Taylor on 6/10/16.
 */
@Controller
public class CrudSpringController {


    @Autowired UserRepository
    //autowire noterepository


    //map "/"


    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session) {


        return "home";
    }



/*    @Autowired
    MessageRepository messageRepository;


    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session) {

        Iterable<Message> messages = messageRepository.findAll();

        model.addAttribute("userName", session.getAttribute("userName"));
        model.addAttribute("messages", messages);
        return "home";
    }

    @RequestMapping(path="/login", method = RequestMethod.POST)
    public String loginUser(HttpSession session, String userName){
        session.setAttribute("userName", userName);
        return "redirect:/";
    }

    @RequestMapping(path="/add-message", method=RequestMethod.POST)
    public String addMessage(String message) {
        Message newMessage = new Message(message);
        messageRepository.save(newMessage);
        return "redirect:/";
    }
    @RequestMapping(path="/edit-message", method = RequestMethod.POST)
    public String editMessage(int editId, String editMessage){
        Message oldMessage = messageRepository.findOne(editId);
        oldMessage.setText(editMessage);
        messageRepository.save(oldMessage);

        return "redirect:/";
    }
    @RequestMapping(path="delete-message", method=RequestMethod.POST)
    public String deleteMessage(int deleteId){
        messageRepository.delete(deleteId);
        return "redirect:/";
    }*/
}

