package project.springbootchat.model;

import lombok.Getter;
import lombok.Setter;

public class SendMessageRequest extends AuthRequest {
    @Getter @Setter private String message;
}
