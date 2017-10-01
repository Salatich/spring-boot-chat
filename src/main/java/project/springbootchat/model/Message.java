package project.springbootchat.model;

import com.sun.istack.internal.Nullable;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;

@Entity
@Table
public class Message {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter private long id;

    @Column
    @Getter @Setter private String text;

    @ManyToOne
    @JoinColumn(name="room_name")
    @Getter
    @Setter
    @Nullable
    private Room room;

    @ManyToOne
    @JoinColumn(name="sender_login")
    @Getter
    @Setter
    private User user;

}
