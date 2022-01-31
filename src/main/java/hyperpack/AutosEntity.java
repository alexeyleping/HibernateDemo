package hyperpack;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "autos")
public class AutosEntity {
    private int idautos;
    private String marka;
    private int users_idusers;

    public int getUsers_idusers() {
        return users_idusers;
    }

    public void setUsers_idusers(int users_idusers) {
        this.users_idusers = users_idusers;
    }

    @Id
    @Column(name = "idautos")
    public int getIdautos() {
        return idautos;
    }

    public void setIdautos(int idautos) {
        this.idautos = idautos;
    }

    @Basic
    @Column(name = "marka")
    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AutosEntity that = (AutosEntity) o;
        return idautos == that.idautos && Objects.equals(marka, that.marka);
    }

    @Override
    public String toString() {
        return "AutosEntity{" +
                "idautos=" + idautos +
                ", marka='" + marka + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(idautos, marka);
    }
}
