package EntityClass;

import java.util.Date;

public class Employees {
    // Employees (EmployeeName, Username, Password, Gender, DateOfBirth, EmployeeRole, Email, PhoneNumber, MoreInfo)
    int nextId = 1;
    int idEmployee;
    String employeeName;
    String userName;
    String employeePassword;
    boolean gender;
    Date dateOfBirth;
    boolean employeeRole;
    String email;
    String phoneNumber;
    String moreInfo;

    public Employees() {
    }

    public Employees(int idEmployee, String employeeName, String userName, String employeePassword, boolean gender, Date dateOfBirth, boolean employeeRole, String email, String phoneNumber, String moreInfo) {
        this.idEmployee = idEmployee;
        this.employeeName = employeeName;
        this.userName = userName;
        this.employeePassword = employeePassword;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.employeeRole = employeeRole;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.moreInfo = moreInfo;
    }

    public int getNextId() {
        return nextId;
    }

    public void setNextId(int nextId) {
        this.nextId = nextId;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmployeePassword() {
        return employeePassword;
    }

    public void setEmployeePassword(String employeePassword) {
        this.employeePassword = employeePassword;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isEmployeeRole() {
        return employeeRole;
    }

    public void setEmployeeRole(boolean employeeRole) {
        this.employeeRole = employeeRole;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }

   

}