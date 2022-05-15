package com.lne.fmmall.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.time.LocalDateTime;

public class Users {
    /**
     * 主键id
     */
    @Id
    @Column(name = "user_id")
    private Long userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 真实名称
     */
    private String realname;

    /**
     * 用户头像
     */
    @Column(name = "user_img")
    private String userImg;

    /**
     * 手机号
     */
    @Column(name = "user_mobile")
    private String userMobile;

    /**
     * 邮箱
     */
    @Column(name = "user_email")
    private String userEmail;

    /**
     * 性别
     */
    @Column(name = "user_sex")
    private String userSex;

    /**
     * 出生日期
     */
    @Column(name = "user_birth")
    private LocalDateTime userBirth;

    /**
     * 注册时间
     */
    @Column(name = "user_regtime")
    private LocalDateTime userRegtime;

    /**
     * 更新时间
     */
    @Column(name = "user_modtime")
    private LocalDateTime userModtime;

    /**
     * 获取主键id
     *
     * @return user_id - 主键id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置主键id
     *
     * @param userId 主键id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取用户名
     *
     * @return username - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取昵称
     *
     * @return nickname - 昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置昵称
     *
     * @param nickname 昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * 获取真实名称
     *
     * @return realname - 真实名称
     */
    public String getRealname() {
        return realname;
    }

    /**
     * 设置真实名称
     *
     * @param realname 真实名称
     */
    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    /**
     * 获取用户头像
     *
     * @return user_img - 用户头像
     */
    public String getUserImg() {
        return userImg;
    }

    /**
     * 设置用户头像
     *
     * @param userImg 用户头像
     */
    public void setUserImg(String userImg) {
        this.userImg = userImg == null ? null : userImg.trim();
    }

    /**
     * 获取手机号
     *
     * @return user_mobile - 手机号
     */
    public String getUserMobile() {
        return userMobile;
    }

    /**
     * 设置手机号
     *
     * @param userMobile 手机号
     */
    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile == null ? null : userMobile.trim();
    }

    /**
     * 获取邮箱
     *
     * @return user_email - 邮箱
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * 设置邮箱
     *
     * @param userEmail 邮箱
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    /**
     * 获取性别
     *
     * @return user_sex - 性别
     */
    public String getUserSex() {
        return userSex;
    }

    /**
     * 设置性别
     *
     * @param userSex 性别
     */
    public void setUserSex(String userSex) {
        this.userSex = userSex == null ? null : userSex.trim();
    }

    /**
     * 获取出生日期
     *
     * @return user_birth - 出生日期
     */
    public LocalDateTime getUserBirth() {
        return userBirth;
    }

    /**
     * 设置出生日期
     *
     * @param userBirth 出生日期
     */
    public void setUserBirth(LocalDateTime userBirth) {
        this.userBirth = userBirth;
    }

    /**
     * 获取注册时间
     *
     * @return user_regtime - 注册时间
     */
    public LocalDateTime getUserRegtime() {
        return userRegtime;
    }

    /**
     * 设置注册时间
     *
     * @param userRegtime 注册时间
     */
    public void setUserRegtime(LocalDateTime userRegtime) {
        this.userRegtime = userRegtime;
    }

    /**
     * 获取更新时间
     *
     * @return user_modtime - 更新时间
     */
    public LocalDateTime getUserModtime() {
        return userModtime;
    }

    /**
     * 设置更新时间
     *
     * @param userModtime 更新时间
     */
    public void setUserModtime(LocalDateTime userModtime) {
        this.userModtime = userModtime;
    }
}