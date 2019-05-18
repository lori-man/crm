package com.lori.entity;

/**
 * 与customer是一对多的关系
 */

/**
 * CREATE TABLE `base_dict` (
 *   `dict_id` varchar(32) NOT NULL COMMENT '数据字典id(主键)',
 *   `dict_type_code` varchar(10) NOT NULL COMMENT '数据字典类别代码',
 *   `dict_type_name` varchar(64) NOT NULL COMMENT '数据字典类别名称',
 *   `dict_item_name` varchar(64) NOT NULL COMMENT '数据字典项目名称',
 *   `dict_item_code` varchar(10) DEFAULT NULL COMMENT '数据字典项目(可为空)',
 *   `dict_sort` int(10) DEFAULT NULL COMMENT '排序字段',
 *   `dict_enable` char(1) NOT NULL COMMENT '1:使用 0:停用',
 *   `dict_memo` varchar(64) DEFAULT NULL COMMENT '备注',
 *   PRIMARY KEY (`dict_id`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */
public class BaseDict {
    private String dictId;
    private String dictTypeCode;
    private String dictTypeName;
    private String dictItemName;
    private String dictItemCode;
    private Integer dictSort;
    private String dictEnable;
    private String dictMemo;

    public String getDictId() {
        return dictId;
    }

    public void setDictId(String dictId) {
        this.dictId = dictId;
    }

    public String getDictTypeCode() {
        return dictTypeCode;
    }

    public void setDictTypeCode(String dictTypeCode) {
        this.dictTypeCode = dictTypeCode;
    }

    public String getDictTypeName() {
        return dictTypeName;
    }

    public void setDictTypeName(String dictTypeName) {
        this.dictTypeName = dictTypeName;
    }

    public String getDictItemName() {
        return dictItemName;
    }

    public void setDictItemName(String dictItemName) {
        this.dictItemName = dictItemName;
    }

    public String getDictItemCode() {
        return dictItemCode;
    }

    public void setDictItemCode(String dictItemCode) {
        this.dictItemCode = dictItemCode;
    }

    public Integer getDictSort() {
        return dictSort;
    }

    public void setDictSort(Integer dictSort) {
        this.dictSort = dictSort;
    }

    public String getDictEnable() {
        return dictEnable;
    }

    public void setDictEnable(String dictEnable) {
        this.dictEnable = dictEnable;
    }

    public String getDictMemo() {
        return dictMemo;
    }

    public void setDictMemo(String dictMemo) {
        this.dictMemo = dictMemo;
    }

    @Override
    public String toString() {
        return "BaseDict{" +
                "dictId='" + dictId + '\'' +
                ", dictTypeCode='" + dictTypeCode + '\'' +
                ", dictTypeName='" + dictTypeName + '\'' +
                ", dictItemName='" + dictItemName + '\'' +
                ", dictItemCode='" + dictItemCode + '\'' +
                ", dictSort=" + dictSort +
                ", dictEnable='" + dictEnable + '\'' +
                ", dictMemo='" + dictMemo + '\'' +
                '}';
    }
}
