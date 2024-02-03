package pagination.page_limit.Model.Response;

import java.io.Serializable;

import pagination.page_limit.Model.Entity.Infor;

public class InforResponse implements Serializable{

	private Long id;
	private String name;
	private Integer age;
	private String job;
	private String province;
	private String status;
	
	public InforResponse(Long id, String name, Integer age, String job, String province, String status) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.job = job;
		this.province = province;
		this.status = status;
	}
	
	public static InforResponse responseMethod(Infor newInfo) {
		return new InforResponse(
				newInfo.getId(),
				newInfo.getName(),
				newInfo.getAge(),
				newInfo.getJob(),
				newInfo.getProvince(),
				newInfo.getStatus()
				);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
