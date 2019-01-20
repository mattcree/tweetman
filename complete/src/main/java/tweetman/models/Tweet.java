package tweetman.models;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Tweet {

    @NotEmpty
    @NotNull
    @JsonProperty("username")
    private String username;

    @NotEmpty
    @NotNull
    @JsonProperty("content")
    private String content;

    public String getUsername() {
        return username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
