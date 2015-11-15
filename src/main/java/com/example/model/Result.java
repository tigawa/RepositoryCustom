package com.example.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


/**
 * The persistent class for the result database table.
 * 
 */
@Entity
@NamedQuery(name="Result.findAll", query="SELECT r FROM Result r")
public class Result implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="type_code")
	private int typeCode;

	//bi-directional many-to-one association to ResultDetail
	@OneToMany(mappedBy="result")
	private List<ResultDetail> resultDetails;

	public Result() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTypeCode() {
		return this.typeCode;
	}

	public void setTypeCode(int typeCode) {
		this.typeCode = typeCode;
	}

	public List<ResultDetail> getResultDetails() {
		return this.resultDetails;
	}

	public void setResultDetails(List<ResultDetail> resultDetails) {
		this.resultDetails = resultDetails;
	}

	public ResultDetail addResultDetail(ResultDetail resultDetail) {
		getResultDetails().add(resultDetail);
		resultDetail.setResult(this);

		return resultDetail;
	}

	public ResultDetail removeResultDetail(ResultDetail resultDetail) {
		getResultDetails().remove(resultDetail);
		resultDetail.setResult(null);

		return resultDetail;
	}

}