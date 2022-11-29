package ReportedUser;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportedUserRepository extends CrudRepository <ReportedUser, Integer> {
}
