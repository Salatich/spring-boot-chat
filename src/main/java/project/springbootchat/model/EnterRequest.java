package project.springbootchat.model;

import lombok.Getter;
import lombok.Setter;

public class EnterRequest extends AuthRequest {
    @Getter @Setter private String roomName;
}
