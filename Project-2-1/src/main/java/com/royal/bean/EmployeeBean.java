package com.royal.bean;

public class EmployeeBean {
	private int empId;
	private String empName;
	private int deptId;
	private String doj;
	private int salary;
	private String gujaratiName;
	

	public EmployeeBean() {
		super();
	}

	public EmployeeBean(int empId, String empName, int deptId, String doj, int salary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.deptId = deptId;
		this.doj = doj;
		this.salary = salary;
	}
	
	public EmployeeBean(int empId, String empName, int deptId, String doj, int salary, String gujaratiName) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.deptId = deptId;
		this.doj = doj;
		this.salary = salary;
		this.gujaratiName = gujaratiName;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public String getGujaratiName() {
		return gujaratiName;
	}
	
	public void setGujaratiName(String gujaratiName) {
		this.gujaratiName = gujaratiName;
	}
}
