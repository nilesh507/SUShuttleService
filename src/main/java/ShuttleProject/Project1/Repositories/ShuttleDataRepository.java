package ShuttleProject.Project1.Repositories;

import ShuttleProject.Project1.DataBases.ShuttleLocation;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ShuttleDataRepository extends JpaRepository<ShuttleLocation,Integer> {



}
