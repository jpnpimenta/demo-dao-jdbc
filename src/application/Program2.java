package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		DepartmentDao departmentDao = DaoFactory.createDepartamentDao();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("===== Test: 1 Department findById =====");
		Department dep = departmentDao.findById(2);
		System.out.println(dep);

		System.out.println("\n===== Test: 2 Department findAll =====");

		
		List<Department> list = departmentDao.findAll();
		for (Department d: list) {
			System.out.println(d);
		}

		System.out.println("===== Test: 3 Department Insertion =====");
		Department newDepartment = new Department(null, "Music" );
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New Id : " + newDepartment.getId());
		
		System.out.println("===== Test: 4 Department Update =====");
		dep = departmentDao.findById(1);
		dep.setName("Food");
		departmentDao.update(dep);
		System.out.println("Update complete!");
		
		System.out.println("===== Test: 5 Seller Delete =====");

		System.out.print("Enter Id to delete : ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed.");
		
		sc.close();
	}

}
