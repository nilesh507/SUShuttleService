package ShuttleProject.Project1.DataBases;

import javax.persistence.*;

import ShuttleProject.Project1.DataBases.ShuttleLocation;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name="PassengersData")
public class Passenger {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String address;
    private Integer suid;
    private Integer shuttleid;



    public Integer getShuttleid() {
        return shuttleid;
    }

    public void setShuttleid(Integer shuttleid) {
        this.shuttleid = shuttleid;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getSuid() {
        return suid;
    }

    public void setSuid(Integer suid) {
        this.suid = suid;
    }
}
