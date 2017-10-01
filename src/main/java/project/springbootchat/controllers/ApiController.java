package project.springbootchat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import project.springbootchat.model.*;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import project.springbootchat.service.MessageService;
import project.springbootchat.service.RoomService;
import project.springbootchat.service.UserService;


@Controller
public class ApiController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private MessageService messageService;

    @RequestMapping(path = "/init",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Response init(@RequestBody User user){
        Response response = new Response();
        response.setHttpStatus(HttpStatus.OK);
        if(userService.getUserByLogin(user.getLogin()) == null){
            userService.createUser(user);
            response.setMessage("user with login "+user.getLogin()+" successfully created");
        } else {
            response.setMessage("user with login "+user.getLogin()+" is already exist!");
        }
        return response;

    }

    @RequestMapping(path = "/enter",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Response enter(@RequestBody EnterRequest request){
        Response response = new Response();
        response.setHttpStatus(HttpStatus.OK);
        User user = request.getUser();
        if(userService.getUserByLogin(user.getLogin()) == null){
            response.setMessage("you are not authorized!");
            response.setHttpStatus(HttpStatus.OK);
            return response;
        } else{
                Room room = new Room();
                room.setName(request.getRoomName());
                if(roomService.getRoomByName(room.getName()) == null) {
                    roomService.createRoom(room);
                    response.setMessage("room with name "+room.getName()+"has been created");
                } else{
                    response.setMessage("you enjoy the room with name "+room.getName());
                }
                user.setRoom(room);
                userService.saveUser(user);

            return response;
        }
    }

    @RequestMapping(path = "/sendMessage",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Response sendMessage(@RequestBody SendMessageRequest request){
        Response response = new Response();
        response.setHttpStatus(HttpStatus.OK);
        User user = userService.getUserByLogin(request.getUser().getLogin());
        if(user == null){
            response.setMessage("you are not authorized!");
            return response;
        } else if (user.getRoom() == null){
            response.setMessage("you have to join a room to start messaging");
            return response;
        } else{
            Message message = new Message();
            message.setUser(user);
            message.setRoom(user.getRoom());
            message.setText(request.getMessage());
            messageService.createMessage(message);
            response.setMessage("you've sent a message...");
        }
        return  response;
    }

    @RequestMapping(path = "/getMessages",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Response getMessages(@RequestBody AuthRequest request){
        GetMessagesResponse response = new GetMessagesResponse();
        response.setHttpStatus(HttpStatus.OK);
        User user = userService.getUserByLogin(request.getUser().getLogin());
        if(user == null){
            response.setMessage("you are not authorized!");
            return response;
        } else if (user.getRoom() == null){
            response.setMessage("you have to join a room to start messaging");
            return response;
        } else {
                response.setMessages(messageService.getMessagesInRoom(user.getRoom()));
        }

        return response;
    }
}
