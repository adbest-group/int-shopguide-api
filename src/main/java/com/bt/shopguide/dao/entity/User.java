package com.bt.shopguide.dao.entity;

import java.util.Date;

public class User {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column USERS.id
     *
     * @mbggenerated Tue Oct 17 15:29:37 CST 2017
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column USERS.cookie
     *
     * @mbggenerated Tue Oct 17 15:29:37 CST 2017
     */
    private String cookie;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column USERS.ip
     *
     * @mbggenerated Tue Oct 17 15:29:37 CST 2017
     */
    private String ip;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column USERS.device_id
     *
     * @mbggenerated Tue Oct 17 15:29:37 CST 2017
     */
    private String deviceId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column USERS.create_time
     *
     * @mbggenerated Tue Oct 17 15:29:37 CST 2017
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column USERS.id
     *
     * @return the value of USERS.id
     *
     * @mbggenerated Tue Oct 17 15:29:37 CST 2017
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column USERS.id
     *
     * @param id the value for USERS.id
     *
     * @mbggenerated Tue Oct 17 15:29:37 CST 2017
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column USERS.cookie
     *
     * @return the value of USERS.cookie
     *
     * @mbggenerated Tue Oct 17 15:29:37 CST 2017
     */
    public String getCookie() {
        return cookie;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column USERS.cookie
     *
     * @param cookie the value for USERS.cookie
     *
     * @mbggenerated Tue Oct 17 15:29:37 CST 2017
     */
    public void setCookie(String cookie) {
        this.cookie = cookie == null ? null : cookie.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column USERS.ip
     *
     * @return the value of USERS.ip
     *
     * @mbggenerated Tue Oct 17 15:29:37 CST 2017
     */
    public String getIp() {
        return ip;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column USERS.ip
     *
     * @param ip the value for USERS.ip
     *
     * @mbggenerated Tue Oct 17 15:29:37 CST 2017
     */
    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column USERS.device_id
     *
     * @return the value of USERS.device_id
     *
     * @mbggenerated Tue Oct 17 15:29:37 CST 2017
     */
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column USERS.device_id
     *
     * @param deviceId the value for USERS.device_id
     *
     * @mbggenerated Tue Oct 17 15:29:37 CST 2017
     */
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column USERS.create_time
     *
     * @return the value of USERS.create_time
     *
     * @mbggenerated Tue Oct 17 15:29:37 CST 2017
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column USERS.create_time
     *
     * @param createTime the value for USERS.create_time
     *
     * @mbggenerated Tue Oct 17 15:29:37 CST 2017
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}