package project.springbootchat.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

public class Response {

    @Getter @Setter private HttpStatus httpStatus;
    @Getter @Setter private String message;


}
