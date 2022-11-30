package ReportedUser;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name = "reporteduser")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

public class ReportedUser {

    @Id
    private int userId;

    @Id
    private int reportedUserId;

    @Column(nullable = false, length = 255)
    private String complaint;

    @Column(nullable = false)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date reportDate;

    @Column
    private boolean processed;
}
