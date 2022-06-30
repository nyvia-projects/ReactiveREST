package com.nychat.reactiverest.users;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Document(collection = "Users")
public class User implements Serializable {

    @Id
    private String id;

    private String name;

    private boolean access;

}
