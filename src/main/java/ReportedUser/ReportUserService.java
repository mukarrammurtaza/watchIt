package ReportedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class ReportUserService {
    @Autowired private ReportedUserRepository reporteduserrepository;

}
