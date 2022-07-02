package com.nychat.reactiverest.users;


import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.TypeAlias;

@SuperBuilder
@AllArgsConstructor
@TypeAlias("Moderator")
public class Moderator extends Member{

}
