package com.Advatix.LoginApi.entity.report;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class ReportParameter {
    @Id
    private int id;
    private int reportId;
    private String reportName;
}
