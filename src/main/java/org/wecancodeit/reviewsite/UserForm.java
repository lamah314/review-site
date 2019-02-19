package org.wecancodeit.reviewsite;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserForm {

    @NotNull
    @Size(min=2, max=30)
    private String userName;

    @NotNull
    @Size(min=6, max=30)
     private String password;

    public String getName() {
        return this.userName;
    }

    public void setName(String name) {
        this.userName = name;
    }

    public String password() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "Name: " + this.userName;
    }
}
