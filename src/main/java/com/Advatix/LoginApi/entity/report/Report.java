package com.Advatix.LoginApi.entity.report;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Report {
    @Id
    private int reportId;
    private String reportName;
    private Date createdOn;
    private boolean reportStatus;
}
