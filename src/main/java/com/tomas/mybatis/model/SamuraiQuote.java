package com.tomas.mybatis.model;

import org.mybatis.cdi.Mapper;


public class SamuraiQuote {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SAMURAIQUOTE.ID
     *
     * @mbg.generated Mon Apr 19 13:41:06 EEST 2021
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SAMURAIQUOTE.SAMURAIID
     *
     * @mbg.generated Mon Apr 19 13:41:06 EEST 2021
     */
    private Long samuraiid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column SAMURAIQUOTE.TEXT
     *
     * @mbg.generated Mon Apr 19 13:41:06 EEST 2021
     */
    private String text;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SAMURAIQUOTE.ID
     *
     * @return the value of SAMURAIQUOTE.ID
     *
     * @mbg.generated Mon Apr 19 13:41:06 EEST 2021
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SAMURAIQUOTE.ID
     *
     * @param id the value for SAMURAIQUOTE.ID
     *
     * @mbg.generated Mon Apr 19 13:41:06 EEST 2021
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SAMURAIQUOTE.SAMURAIID
     *
     * @return the value of SAMURAIQUOTE.SAMURAIID
     *
     * @mbg.generated Mon Apr 19 13:41:06 EEST 2021
     */
    public Long getSamuraiid() {
        return samuraiid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SAMURAIQUOTE.SAMURAIID
     *
     * @param samuraiid the value for SAMURAIQUOTE.SAMURAIID
     *
     * @mbg.generated Mon Apr 19 13:41:06 EEST 2021
     */
    public void setSamuraiid(Long samuraiid) {
        this.samuraiid = samuraiid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column SAMURAIQUOTE.TEXT
     *
     * @return the value of SAMURAIQUOTE.TEXT
     *
     * @mbg.generated Mon Apr 19 13:41:06 EEST 2021
     */
    public String getText() {
        return text;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column SAMURAIQUOTE.TEXT
     *
     * @param text the value for SAMURAIQUOTE.TEXT
     *
     * @mbg.generated Mon Apr 19 13:41:06 EEST 2021
     */
    public void setText(String text) {
        this.text = text;
    }
}