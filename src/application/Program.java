package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("===== Test: 1 Seller findById =====");
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);
		System.out.println("\n===== Test: 2 Seller findByDepartment =====");
		
		Department dep = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(dep);
		for (Seller obj: list) {
			System.out.println(obj);
		}
		System.out.println("\n===== Test: 3 Seller findAll =====");
		
		list = sellerDao.findAll();
		for (Seller obj: list) {
			System.out.println(obj);
		}
	
		System.out.println("===== Test: 4 Seller Insertion =====");
		Seller newSeller = new Seller(null, "Greg", "Greg@gmail.com", new Date(), 4000.0, dep );
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New Id : " + newSeller.getId());

		System.out.println("===== Test: 5 Seller Update =====");
		seller = sellerDao.findById(1);
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		System.out.println("Update complete!");
	
		System.out.println("===== Test: 6 Seller Delete =====");

		System.out.print("Enter Id to delete : ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed.");
		sc.close();
	
	}

}
