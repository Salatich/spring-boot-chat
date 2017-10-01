package project.springbootchat.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
public class Room {

    @Column
    @Id
    @Getter
    @Setter
    private String name;

}
