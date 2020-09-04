package com.jxqdwh.erp.entity;


public class Users {

  private long userId;
  private String userName;
  private java.sql.Timestamp creatTime;
  private java.sql.Timestamp lastLoginTime;
  private String passwd;

  @Override
  public String toString() {
    return "Users{" +
            "userId=" + userId +
            ", userName='" + userName + '\'' +
            ", creatTime=" + creatTime +
            ", lastLoginTime=" + lastLoginTime +
            ", passwd='" + passwd + '\'' +
            ", states=" + states +
            ", departmentI='" + departmentI + '\'' +
            ", department='" + department + '\'' +
            ", subdepartment='" + subdepartment + '\'' +
            ", positionAuthority=" + positionAuthority +
            ", systemPermissions='" + systemPermissions + '\'' +
            '}';
  }

  private long states;
  private String departmentI;
  private String department;
  private String subdepartment;
  private long positionAuthority;
  private String systemPermissions;


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  public java.sql.Timestamp getCreatTime() {
    return creatTime;
  }

  public void setCreatTime(java.sql.Timestamp creatTime) {
    this.creatTime = creatTime;
  }


  public java.sql.Timestamp getLastLoginTime() {
    return lastLoginTime;
  }

  public void setLastLoginTime(java.sql.Timestamp lastLoginTime) {
    this.lastLoginTime = lastLoginTime;
  }


  public String getPasswd() {
    return passwd;
  }

  public void setPasswd(String passwd) {
    this.passwd = passwd;
  }


  public long getStates() {
    return states;
  }

  public void setStates(long states) {
    this.states = states;
  }


  public String getDepartmentI() {
    return departmentI;
  }

  public void setDepartmentI(String departmentI) {
    this.departmentI = departmentI;
  }


  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }


  public String getSubdepartment() {
    return subdepartment;
  }

  public void setSubdepartment(String subdepartment) {
    this.subdepartment = subdepartment;
  }


  public long getPositionAuthority() {
    return positionAuthority;
  }

  public void setPositionAuthority(long positionAuthority) {
    this.positionAuthority = positionAuthority;
  }


  public String getSystemPermissions() {
    return systemPermissions;
  }

  public void setSystemPermissions(String systemPermissions) {
    this.systemPermissions = systemPermissions;
  }

}
