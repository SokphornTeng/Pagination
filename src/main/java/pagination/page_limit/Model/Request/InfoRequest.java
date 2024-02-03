package pagination.page_limit.Model.Request;

import java.io.Serializable;

import pagination.page_limit.Model.Entity.Infor;

public class InfoRequest implements Serializable {

	private String name;
	private Integer age;
	private String job;
	private String province;
	private String status;
	
	public InfoRequest(String name, Integer age, String job, String province, String status) {
		super();
		this.name = name;
		this.age = age;
		this.job = job;
		this.province = province;
		this.status = status;
	}
	
	public Infor requestMethod() {
		Infor newInfo = new Infor();
		newInfo.setName(this.name);
		newInfo.setAge(this.age);
		newInfo.setProvince(this.province);
		newInfo.setJob(this.job);
		newInfo.setStatus(this.status);
		return newInfo;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
