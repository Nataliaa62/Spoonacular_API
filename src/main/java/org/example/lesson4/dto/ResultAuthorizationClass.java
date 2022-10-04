package org.example.lesson4.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class ResultAuthorizationClass {
    @JsonIgnore
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String status;
    private String username;
    private String spoonacularPassword;
    private String hash;

    /*public ResultAuthorizationClass() {
    }

    public ResultAuthorizationClass(String status, String username, String spoonacularPassword, String hash) {
        this.status = status;
        this.username = username;
        this.spoonacularPassword = spoonacularPassword;
        this.hash = hash;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSpoonacularPassword() {
        return spoonacularPassword;
    }

    public void setSpoonacularPassword(String spoonacularPassword) {
        this.spoonacularPassword = spoonacularPassword;
    }

    public ResultAuthorizationClass(String hash, String username) {
        this.hash = hash;
        this.username = username;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
*/
    @Override
    public String toString() {
        return "ResultAuthorizationClass{" +
                "hash='" + hash + '\'' +
                ", name='" + username + '\'' +
                '}';
    }
}
