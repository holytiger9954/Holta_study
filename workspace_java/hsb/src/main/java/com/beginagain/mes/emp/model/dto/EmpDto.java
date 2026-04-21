package com.beginagain.mes.emp.model.dto;

import java.io.Serializable;

public class EmpDto implements Serializable {
    private int empId;
    private String empNo;
    private String empName;
    private String roleName;
    private String pwChangeRequired;

    public int getEmpId() { return empId; }
    public void setEmpId(int empId) { this.empId = empId; }
    public String getEmpNo() { return empNo; }
    public void setEmpNo(String empNo) { this.empNo = empNo; }
    public String getEmpName() { return empName; }
    public void setEmpName(String empName) { this.empName = empName; }
    public String getRoleName() { return roleName; }
    public void setRoleName(String roleName) { this.roleName = roleName; }
    public String getPwChangeRequired() { return pwChangeRequired; }
    public void setPwChangeRequired(String pwChangeRequired) { this.pwChangeRequired = pwChangeRequired; }
}
