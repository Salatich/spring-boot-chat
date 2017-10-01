package project.springbootchat.model;


import lombok.Getter;
import lombok.Setter;

public class MessageWrapper {
    @Getter @Setter private String text;
    @Getter @Setter private String userName;
}
