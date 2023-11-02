package ShuttleProject.Project1.DataBases;

import javax.persistence.*;

@Entity
public class User {
    @Id
    private Integer SUID;
    private String name;
    private UserStatus userStatus;
    private String address;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSUID() {
        return SUID;
    }

    public void setSUID(Integer SUID) {
        this.SUID = SUID;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address=address;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

