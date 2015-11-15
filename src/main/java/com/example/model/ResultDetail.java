package com.example.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the result_detail database table.
 * 
 */
@Entity
@Table(name="result_detail")
@NamedQuery(name="ResultDetail.findAll", query="SELECT r FROM ResultDetail r")
public class ResultDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int point;

	//bi-directional many-to-one association to Result
	@ManyToOne
	@JsonIgnore
	private Result result;

	//bi-directional many-to-one association to Staff
	@ManyToOne
	private Staff staff;

	public ResultDetail() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPoint() {
		return this.point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public Result getResult() {
		return this.result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public Staff getStaff() {
		return this.staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

}