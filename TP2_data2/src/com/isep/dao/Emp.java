package com.isep.dao.model;

public class Emp {
	private int empno;
	private String ename;
	private String efirst;
	private String job;
	private int sal;
	private Emp mgr;  // Le manager est un objet Emp

	// Getters et Setters
	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEfirst() {
		return efirst;
	}

	public void setEfirst(String efirst) {
		this.efirst = efirst;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public Emp getMgr() {
		return mgr;
	}

	public void setMgr(Emp mgr) {
		this.mgr = mgr;
	}

	// Optionnel : redéfinition de toString pour faciliter le débogage
	@Override
	public String toString() {
		return "Emp [empno=" + empno
				+ ", ename=" + ename
				+ ", efirst=" + efirst
				+ ", job=" + job
				+ ", sal=" + sal
				+ ", mgr=" + (mgr != null ? mgr.getEmpno() : "null") + "]";
	}
}
