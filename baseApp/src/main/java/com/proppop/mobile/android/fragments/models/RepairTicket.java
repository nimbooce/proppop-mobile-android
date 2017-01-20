package com.proppop.mobile.android.fragments.models;

/**
 * Created by animal@martus.org on 9/30/16.
 */

public class RepairTicket {

    private String createdByUid;
    private String description;
    private String statusCode;
    private String currentAssignedUid;

    public RepairTicket() {
    }

    public RepairTicket(String createdByUid, String currentAssignedUid, String description, String statusCode) {
        this.createdByUid = createdByUid;
        this.currentAssignedUid = currentAssignedUid;
        this.description = description;
        this.statusCode = statusCode;
    }

    public String getCreatedByUid() {
        return createdByUid;
    }

    public String getDescription() {
        return description;
    }

    public void setCreatedByUid(String createdByUid) {
        this.createdByUid = createdByUid;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getCurrentAssignedUid() {
        return currentAssignedUid;
    }

    public void setCurrentAssignedUid(String currentAssignedUid) {
        this.currentAssignedUid = currentAssignedUid;
    }
}

