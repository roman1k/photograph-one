package com.example.photographone.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table( name = "userLog", uniqueConstraints={@UniqueConstraint(columnNames={"username"})})
public class User  implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;
    @OneToOne
    private UserDepended userDep = new UserDepended();

//    @Column(unique = true)
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    private boolean isAccountNonExpired = true;
    private boolean isAccountNonLocked =true;
    private boolean isCredentialsNonExpired = true;
    private boolean isEnabled = false;
    private String activationCode;



    public User() {
    }
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public User(String username, String password,String e) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User(String username) {
        this.username = username;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public UserDepended getUserDep() {
        return userDep;
    }

    public void setUserDep(UserDepended userDep) {
        this.userDep = userDep;
    }

    public int getId() {
        return id;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        isAccountNonExpired = accountNonExpired;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        isAccountNonLocked = accountNonLocked;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        isCredentialsNonExpired = credentialsNonExpired;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
         List<SimpleGrantedAuthority> authorities = new ArrayList<>();
         authorities.add( new SimpleGrantedAuthority(role.name()));
        return authorities;
    }

    @Override
    public String getPassword() {
       return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    @Override
    public String toString() {

        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userDep, user.userDep) &&
                Objects.equals(username, user.username) &&
                role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userDep, username);
    }
}
