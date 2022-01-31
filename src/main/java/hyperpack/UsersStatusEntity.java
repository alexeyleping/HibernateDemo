package hyperpack;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "status")

public class UsersStatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int statusid;


    private  String statusUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idusers")
    private UsersEntity usersEntity;



    @Override
    public String toString() {
        return "UsersStatusEntity{" +
                "statusid=" + statusid +
                ", statusUser='" + statusUser + '\'' +
                ", usersEntity=" + usersEntity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersStatusEntity that = (UsersStatusEntity) o;
        return statusid == that.statusid && statusUser.equals(that.statusUser) && usersEntity.equals(that.usersEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statusid, statusUser, usersEntity);
    }

    public String getStatusUser() {
        return statusUser;
    }

    public void setStatusUser(String statusUser) {
        this.statusUser = statusUser;
    }

    public UsersEntity getUsersEntity() {
        return usersEntity;
    }

    public void setUsersEntity(UsersEntity usersEntity) {
        this.usersEntity = usersEntity;
    }

    public int getStatusid() {
        return statusid;
    }

    public void setStatusid(int statusid) {
        this.statusid = statusid;
    }
}
