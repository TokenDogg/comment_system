package com.tokendogg.comment_system.entity;

public class Report {

    private Integer report_id;
    private Integer comment_id;
    private Integer user_id;
    private String reason;

    public Integer getReport_id() {
        return report_id;
    }

    public void setReport_id(Integer report_id) {
        this.report_id = report_id;
    }

    public Integer getComment_id() {
        return comment_id;
    }

    public void setComment_id(Integer comment_id) {
        this.comment_id = comment_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "Report{" +
                "report_id=" + report_id +
                ", comment_id=" + comment_id +
                ", used_id=" + user_id +
                ", reason='" + reason + '\'' +
                '}';
    }
}
