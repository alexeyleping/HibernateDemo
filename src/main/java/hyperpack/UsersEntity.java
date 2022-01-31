package hyperpack;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
public class UsersEntity {
    private int idusers;
    private String name;

   // @OneToMany(fetch = FetchType.LAZY, mappedBy = "usersEntity")
    //private Set<UsersEntity> usersEntitySet;


    @Id
    @Column(name = "idusers")
    public int getIdusers() {
        return idusers;
    }

    public void setIdusers(int idusers) {
        this.idusers = idusers;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersEntity that = (UsersEntity) o;
        return idusers == that.idusers && Objects.equals(name, that.name);
    }

    @Override
    public String toString() {
        return "UsersEntity{" +
                "idusers=" + idusers +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(idusers, name);
    }
}
