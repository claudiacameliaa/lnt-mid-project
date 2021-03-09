package data;

public class Manager extends Employee{
	private int bonus = (1/10);
	public Manager(String nama, String kode, String jk, String jabatan, int gaji, int bonus) {
		super(nama, kode, jk, jabatan, gaji + 8000000);
		this.bonus = bonus;
	}
	public int getBonus() {
		return bonus;
	}
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	
}
