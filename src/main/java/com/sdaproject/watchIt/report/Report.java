package com.sdaproject.watchIt.report;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;

@Entity
@Table(name = "report")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reportId;

    @Column(nullable = false)
    private int userId;

    @Column(nullable = false)
    private Date reportDate;

    private String location;

    @Column(nullable = false)
    private String text;

    @Column(nullable = false)
    private boolean processed;

}
