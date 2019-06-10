package com.lori.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class SaleVisit {
    private String visit_id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date visit_time;
    private String visit_addr;
    private String visit_detail;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date visit_nextTime;

    private Customer customer;

    private User user;

    public String getVisit_id() {
        return visit_id;
    }

    public void setVisit_id(String visit_id) {
        this.visit_id = visit_id;
    }

    public Date getVisit_time() {
        return visit_time;
    }

    public void setVisit_time(Date visit_time) {
        this.visit_time = visit_time;
    }

    public String getVisit_addr() {
        return visit_addr;
    }

    public void setVisit_addr(String visit_addr) {
        this.visit_addr = visit_addr;
    }

    public String getVisit_detail() {
        return visit_detail;
    }

    public void setVisit_detail(String visit_detail) {
        this.visit_detail = visit_detail;
    }

    public Date getVisit_nextTime() {
        return visit_nextTime;
    }

    public void setVisit_nextTime(Date visit_nextTime) {
        this.visit_nextTime = visit_nextTime;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "SaleVisit{" +
                "visit_id='" + visit_id + '\'' +
                ", visit_time=" + visit_time +
                ", visit_addr='" + visit_addr + '\'' +
                ", visit_detail='" + visit_detail + '\'' +
                ", visit_nextTime=" + visit_nextTime +
                ", customer=" + customer +
                ", user=" + user +
                '}';
    }
}
