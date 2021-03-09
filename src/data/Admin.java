package data;

public class Admin extends Employee{
	private int bonus = (5/100);
	public Admin(String nama, String kode, String jk, String jabatan, int gaji, int bonus) {
		super(nama, kode, jk, jabatan, gaji + 4000000);
		this.bonus = bonus;
	}
	public int getBonus() {
		return bonus;
	}
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

}
