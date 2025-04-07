package com.isep.testjpa.model;

import javax.persistence.*;

@Entity
public class Emp {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long empno;

   private String ename;
   private String efirst;
   private String job;
   private Long mgr;
   private Double sal;
   private Double comm;

   // Constructeur par défaut
   public Emp() {
   }

   // Getters et Setters
   public Long getEmpno() {
      return empno;
   }

   public void setEmpno(Long empno) {
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

   public Long getMgr() {
      return mgr;
   }

   public void setMgr(Long mgr) {
      this.mgr = mgr;
   }

   public Double getSal() {
      return sal;
   }

   public void setSal(Double sal) {
      this.sal = sal;
   }

   public Double getComm() {
      return comm;
   }

   public void setComm(Double comm) {
      this.comm = comm;
   }

   @Override
   public String toString() {
      return "Emp{" +
              "empno=" + empno +
              ", ename='" + ename + '\'' +
              ", efirst='" + efirst + '\'' +
              ", job='" + job + '\'' +
              ", mgr=" + mgr +
              ", sal=" + sal +
              ", comm=" + comm +
              '}';
   }
}