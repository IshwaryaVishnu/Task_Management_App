package se.lexicon.model;

import java.util.Objects;

public class AppUser {
    private Integer id;
    private String userName;
    private String passWord;
    private boolean active;
    private roles role;

    public AppUser(Integer id, String userName, String passWord, boolean active, roles role) {
        setId(id);
        setUserName(userName);
        setPassWord(passWord);
        setActive(active);
        setRole(role);
    }

    public AppUser( String userName, String passWord,roles role) {
        setUserName(userName);
        setPassWord(passWord);
        this.role = role;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        if(id == null)throw new RuntimeException("id was null");
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        if(userName == null|| userName.length() == 0)throw new IllegalArgumentException("username was null");
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        if (passWord ==null)throw new IllegalArgumentException("password was null");
        if(passWord.length() < 8)throw new IllegalArgumentException("password length was not valid");
        this.passWord = passWord;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public roles getRole() {
        return role;
    }

    public void setRole(roles role) {
        if(role == null)role =roles.ROLE_USER;
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppUser appUser = (AppUser) o;
        return active == appUser.active && Objects.equals(id, appUser.id) && Objects.equals(userName, appUser.userName) && role == appUser.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, active, role);
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", active=" + active +
                '}';
    }
}
