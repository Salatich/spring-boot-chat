package project.springbootchat.model;


import java.util.ArrayList;
import java.util.List;

public class GetMessagesResponse extends Response {

  private List<MessageWrapper> messages = new ArrayList<>();

  public void setMessages(List messages){
     this.messages = messages;
  }

  public List<MessageWrapper> getMessages(){
     return this.messages;
  }
}
