package ShuttleProject.Project1.Repositories;

import ShuttleProject.Project1.DataBases.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengersDataRepository extends JpaRepository<Passenger,Integer> {
}
