package com.nychat.reactiverest.users;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;


@Jacksonized
@Builder
public record UserPayload(@JsonProperty("name") String name, @JsonProperty("access") boolean access) {

}
