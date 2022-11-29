package ReportedUser;
import com.sdaproject.watchIt.report.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/reportuser")
public class ReportedUserController {
    @Autowired private ReportService reportservice;
}
