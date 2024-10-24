package com.Advatix.LoginApi.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private  String uName;
    private  String password;
    private  Long roleId;
    private  String mail;
    private Integer pNo;
    private Boolean status;
    private  Long clientId;
    private  Long cityId;

//    public UserDto(User updatedUser) {
//    }
//
//    // Getters and Setters
//    public static String getUname() {
//        return uName;
//    }
//
//    public void setUname(String uName) {
//        this.uName = uName;
//    }
//
//    public static String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public static long getRoleId() {
//        return Long.parseLong(roleId);
//    }
//
//    public void setRoleId(String roleId) {
//        this.roleId = roleId;
//    }
//
//    public static String getMail() {
//        return mail;
//    }
//
//    public void setMail(String mail) {
//        this.mail = mail;
//    }
//
//    public Integer getPno() {
//        return pNo;
//    }
//
//    public void setPno(Integer pNo) {
//        this.pNo = pNo;
//    }
//
//    public Boolean getStatus() {
//        return status;
//    }
//
//    public void setStatus(Boolean status) {
//        this.status = status;
//    }
//
//    public static Long getClientId() {
//        return clientId;
//    }
//
//    public Long setClientId() {
//        return clientId;
//    }
//
//
//    public static Long getCitytId() {
//        return cityId;
//    }
//
//    public Long setCitytId() {
//        return cityId;
//    }
}
