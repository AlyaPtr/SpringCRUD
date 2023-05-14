package web.models;

import javax.persistence.*;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;

    public User() {}

    public User (String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public User (Long id, String name, String lastname) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
    }

    @Column(name = "Name")
    private String name;

    @Column(name = "Lastname")
    private String lastname;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLastname() {
        return lastname;
    }
}
