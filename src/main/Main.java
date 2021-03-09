package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import data.Admin;
import data.Employee;
import data.Manager;
import data.Supervisor;

public class Main {
	private Scanner scan = new Scanner(System.in);
	private ArrayList<Employee> list = new ArrayList<Employee>();
	
	//kayaknya ini harus dijadiin private void Main
	public Main() {
		int choice = 0;
		do {
			System.out.println("PT. Mentol");
			System.out.println("----------");
			System.out.println("1. Insert Data Karyawan");
			System.out.println("2. View Data Karyawan");
			System.out.println("3. Update Data Karyawan");
			System.out.println("4. Delete Data Karyawan");
			System.out.print("Pilih menu : ");
			choice = tryCatch();
		} while (choice < 1 || choice > 4);
		
		switch (choice) {
		case 1:
			insertData();
			break;
		case 2:
			viewData();
			break;
		case 3:
			updateData();
			break;
		case 4:
			deleteData();
			break;
		}
	}
	
	private void insertData() {
		String nama, jk, jabatan, kode="";
		int gaji=0, bonus=0;
		
		do {
			System.out.print("Input nama karyawan [>= 3]: ");
			nama = scan.nextLine();
		} while (nama.length() < 3);
		
		do {
			System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
			jk = scan.nextLine();
		} while (!(jk.equals("Laki-laki") || jk.equals("Perempuan")));
		
		do {
			System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
			jabatan = scan.nextLine();
		} while (!(jabatan.equals("Manager") || jabatan.equals("Supervisor") || jabatan.equals("Admin")));
		
		Random rndm = new Random();
		//0+65 = 65 A , 1+65 = 65 B
		kode = "" + (char)(rndm.nextInt(26)+65)
				+ (char)(rndm.nextInt(26)+65)
				+ "-"
				+ rndm.nextInt(10) 
				+ rndm.nextInt(10) 
				+ rndm.nextInt(10) 
				+ rndm.nextInt(10);
		
		System.out.println("Berhasil menambahkan karyawan dengan id " +kode);
		
		switch (jabatan) {
		case "Manager":
			list.add(new Manager(nama, kode, jabatan, jk, gaji, bonus));
			break;
		case "Supervisor":
			list.add(new Supervisor(nama, kode, jabatan, jk, gaji, bonus));
			break;
		case "Admin":
			list.add(new Admin(nama, kode, jabatan, jk, gaji, bonus));
			break;
		}
		
		if (jabatan.equals("Manager")) {
			String bonusM = "10%";
			System.out.println("Bonus sebesar" + bonusM + "telah diberikan kepada karyawan dengan id" + kode);
		}else if (jabatan.equals("Supervisor")) {
			String bonusS = "7,5%";
			System.out.println("Bonus sebesar" + bonusS + "telah diberikan kepada karyawan dengan id" + kode);
		}else if (jabatan.equals("Admin")) {
			String bonusA = "5%";
			System.out.println("Bonus sebesar" + bonusA + "telah diberikan kepada karyawan dengan id" + kode);
		}
		
	}
	
	private void viewData() {
		if (list.isEmpty()) {
			System.out.println("Data Belum di Masukkan");
		}else {
			System.out.println("|---|-----------------|-------------------------|---------------|---------------|-------------|");
			System.out.printf("| %-3s| %-17s| %-25s| %-15s| %-15s| %-13s|\n",
					"No" , "Kode Karyawan" , "Nama Karyawan" , "Jenis Kelamin", "Jabatan", "Gaji Karyawan");
			System.out.println("|---|-----------------|-------------------------|---------------|---------------|-------------|");
			
			//Collections.sort(list);
			int i = 0;
			for (Employee employee : list) {
				i++;
			System.out.printf("| %-3d| %-17d| %-25d| %-15d| %-15d| %-13d|\n", i , employee.getKode(), 
					employee.getNama(), employee.getJk(), employee.getJabatan(), employee.getGaji());
			}
			
			System.out.println("|---|-----------------|-------------------------|---------------|---------------|-------------|");
		}
	}
	
	private void updateData() {
		viewData();
		int update = 0;
		do {
			System.out.println("Silahkan masukkan nomor yang ingin diupdate [1 - " +(list.size())+ "]: ");
			update = scan.nextInt();
			scan.nextLine();
			
			insertData();
			
			scan.nextLine();
		} while (update < 1 || update > list.size());
	}
	
	private void deleteData() {
		viewData();
		int angka = 0;
		do {
			System.out.print("Silahkan masukkan nomor yang ingin dihapus [1 - " +(list.size())+ "]: ");
			angka = scan.nextInt(); scan.nextLine();
		} while (angka < 1 || angka > list.size());
		list.remove(angka-1);
	}
	
	public static void enter() {
		System.out.println("Press enter to Continue...");
		try {
			System.in.read();
		} catch (Exception e) {
			
		} System.out.println();
	}
	
	private Integer tryCatch() {
		int a = 0;
		try {
			a = scan.nextInt();
		} catch (Exception e) {
			a = -1;
			System.err.println("Please input number only");
		} scan.nextLine();
		return a;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
