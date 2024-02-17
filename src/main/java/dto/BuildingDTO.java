package dto;

public class BuildingDTO extends BaseDTO{
	
	private Long id;
	private String name;
	private String address;
	private String typeOutput;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTypeOutput() {
		return typeOutput;
	}
	public void setTypeOutput(String typeOutput) {
		this.typeOutput = typeOutput;
	}
	
	
}
