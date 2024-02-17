package bka.lytien;

public class CaChuon extends LopCa{
	
	private String colorEye;
	private String colorSkin;
	
	public CaChuon() {
	}
	
//	protected void boi() {
//		System.out.println("Cá chuồn bơi theo kiểu cá chuồn");
//	}
	
//	public CaChuon(String colorEye, String colorSkin, String colorEyeParent, String colorSkinParent) {
//		this.colorEye = colorEye;
//		this.colorSkin = colorSkin;
//		super.colorEye= colorEyeParent;
//		super.colorSkin= colorSkinParent;
//	}

	public String getColorEye() {
//		return "children"+this.colorEye + "- Parent "+super.colorEye;
		return colorEye;
	}

	public String getColorSkin() {
		return colorSkin;
	}

	public void setColorEye(String colorEye) {
		this.colorEye = colorEye;
	}

	public void setColorSkin(String colorSkin) {
		this.colorSkin = colorSkin;
	}
	
	protected void boi() {
		System.out.println("Cá nào mà chẳng biết bơi");
	}

	
}
