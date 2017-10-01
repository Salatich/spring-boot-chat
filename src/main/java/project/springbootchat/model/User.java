package project.springbootchat.model;

import com.sun.istack.internal.Nullable;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table
public class User {

    @Column
    @Id
    @Getter @Setter private String login;

    @Column
    @Getter @Setter private String password;


    @ManyToOne
    @JoinColumn(name="room_name")
    @Getter @Setter
    @Nullable
    private Room room;

}
