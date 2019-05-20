package com.lori.entity;

/**
 CREATE TABLE `cst_customer` (
 `cust_id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '客户编号(主键)',
 `cust_name` varchar(32) NOT NULL COMMENT '客户名称(公司名称)',
 `cust_source` varchar(32) DEFAULT NULL COMMENT '客户信息来源',
 `cust_industry` varchar(32) DEFAULT NULL COMMENT '客户所属行业',
 `cust_level` varchar(32) DEFAULT NULL COMMENT '客户级别',
 `cust_phone` varchar(64) DEFAULT NULL COMMENT '固定电话',
 `cust_mobile` varchar(16) DEFAULT NULL COMMENT '移动电话',
 PRIMARY KEY (`cust_id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
 */
public class Customer {
    private Long custId;
    private String custName;
    private String custPhone;
    private String custMobile;
    private String custImage;


    //客户和字典多对一的关系：需要在多的一方放一的对象
    private BaseDict baseDicrSource;
    private BaseDict baseDicrIndustry;
    private BaseDict baseDictLevel;

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    public String getCustMobile() {
        return custMobile;
    }

    public void setCustMobile(String custMobile) {
        this.custMobile = custMobile;
    }

    public BaseDict getBaseDicrSource() {
        return baseDicrSource;
    }

    public void setBaseDicrSource(BaseDict baseDicrSource) {
        this.baseDicrSource = baseDicrSource;
    }

    public BaseDict getBaseDicrIndustry() {
        return baseDicrIndustry;
    }

    public void setBaseDicrIndustry(BaseDict baseDicrIndustry) {
        this.baseDicrIndustry = baseDicrIndustry;
    }

    public BaseDict getBaseDictLevel() {
        return baseDictLevel;
    }

    public void setBaseDictLevel(BaseDict baseDictLevel) {
        this.baseDictLevel = baseDictLevel;
    }

    public String getCustImage() {
        return custImage;
    }

    public void setCustImage(String custImage) {
        this.custImage = custImage;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", custName='" + custName + '\'' +
                ", custPhone='" + custPhone + '\'' +
                ", custMobile='" + custMobile + '\'' +
                '}';
    }
}
