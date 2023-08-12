package com.techelevator.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.Date;

public class Pothole {
    private int id;
    private String description;

    private int severity;
    private String address;
    private LocalDate reportedDate;
    private LocalDate inspectedDate;
    private LocalDate repairDate;
    private boolean canContact;
    private boolean inspected;
    private boolean repaired;
    private String zipcode;
    private boolean inTraffic;
    private boolean potentialDamage;
    private String locationDetails;
    private int reporterId;
    private Reporter reporter;

    public Pothole(int id, String description, int severity, String address, LocalDate reportedDate, LocalDate inspectedDate,
                   LocalDate repairDate, boolean canContact, boolean inspected, boolean repaired, String zipcode,
                   boolean inTraffic, boolean potentialDamage, String locationDetails, int reporterId) {
        this.id = id;
        this.description = description;
        this.severity = severity;
        this.address = address;
        this.reportedDate = reportedDate;
        this.inspectedDate = inspectedDate;
        this.repairDate = repairDate;
        this.canContact = canContact;
        this.inspected = inspected;
        this.repaired = repaired;
        this.zipcode = zipcode;
        this.inTraffic = inTraffic;
        this.potentialDamage = potentialDamage;
        this.locationDetails = locationDetails;
        this.reporterId = reporterId;
        this.reporter = reporter;
    }

    public Pothole() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSeverity() {
        return severity;
    }

    public void setSeverity(int severity) {
        this.severity = severity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getReportedDate() {
        return reportedDate;
    }

    public void setReportedDate(LocalDate reportedDate) {
        this.reportedDate = reportedDate;
    }

    public LocalDate getInspectedDate() {
        return inspectedDate;
    }

    public LocalDate getRepairDate() {
        return repairDate;
    }

    public boolean isCanContact() {
        return canContact;
    }

    public boolean isInspected() {
        return inspected;
    }

    public boolean isRepaired() {
        return repaired;
    }

    public String getZipcode() {
        return zipcode;
    }

    public boolean isInTraffic() {
        return inTraffic;
    }

    public boolean isPotentialDamage() {
        return potentialDamage;
    }

    public void setInspectedDate(LocalDate inspectedDate) {
        this.inspectedDate = inspectedDate;
    }

    public void setRepairDate(LocalDate repairDate) {
        this.repairDate = repairDate;
    }

    public void setCanContact(boolean canContact) {
        this.canContact = canContact;
    }

    public void setInspected(boolean inspected) {
        this.inspected = inspected;
    }

    public void setRepaired(boolean repaired) {
        this.repaired = repaired;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public void setInTraffic(boolean inTraffic) {
        this.inTraffic = inTraffic;
    }

    public void setPotentialDamage(boolean potentialDamage) {
        this.potentialDamage = potentialDamage;
    }

    public String getLocationDetails() {
        return locationDetails;
    }

    public void setLocationDetails(String locationDetails) {
        this.locationDetails = locationDetails;
    }

    public int getReporterId() {
        return reporterId;
    }

    public void setReporterId(int reporterId) {
        this.reporterId = reporterId;
    }

    public Reporter getReporter() {
        return reporter;
    }

    public void setReporter(Reporter reporter) {
        this.reporter = reporter;
    }
}
