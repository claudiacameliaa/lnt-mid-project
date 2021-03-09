package data;

public class Supervisor extends Employee{
	private int bonus = (75/1000);
	public Supervisor(String nama, String kode, String jk, String jabatan, int gaji, int bonus) {
		super(nama, kode, jk, jabatan, gaji + 6000000);
		this.bonus = bonus;
	}
	public int getBonus() {
		return bonus;
	}
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

}
