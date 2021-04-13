package com.hcl;

import java.text.NumberFormat;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

public class CarDao {
	public static void solution() {

		System.out.println("Enter Command:");
		Scanner scOperation = new Scanner(System.in);
		String command = scOperation.next();

		if (command.equalsIgnoreCase("quit")) {
			System.out.println("Good bye!");
		} else {
			Scanner sc = new Scanner(System.in);
			StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

			SessionFactory factory = meta.getSessionFactoryBuilder().build();
			Session session = factory.openSession();
			Transaction tx = session.beginTransaction();
			if (command.equalsIgnoreCase("add")) {
				Car car = new Car();

				System.out.println("Enter Maker :");
				car.setMake(sc.next());
				System.out.println("Enter Model :");
				car.setModel(sc.next());
				System.out.println("Enter Year :");
				car.setYear(sc.nextInt());
				System.out.println("Enter Sale Price in ($)");
				car.setSalePrice(sc.nextDouble());
				session.save(car);
				tx.commit();
				System.out.println("Car details added successfully.");

			} else if (command.equalsIgnoreCase("list")) {
				Query query = session.createSQLQuery("CALL GetListOfCar()").addEntity(Car.class);
				List<Car> list = query.list();
				System.out.println("------------------------------------------");
				if (list.size() == 0) {
					System.out.println("There are currently no cars in the catalog.");
				} else {
					NumberFormat formatter = NumberFormat.getCurrencyInstance();
					list.forEach(car -> {
						System.out.println(car.getYear() + " " + car.getMake() + "" + " " + car.getModel() + " "
								+ formatter.format(car.getSalePrice()));
					});
					Double totalInventory = list.stream().mapToDouble(j -> j.getSalePrice()).sum();
					System.out.println("");
					System.out.println("Numbers of Cars : " + list.size());
					System.out.println("Total inventory : " + formatter.format(totalInventory));
					System.out.println("");
				}

			} else if (command.equalsIgnoreCase("delete")) {
				System.out.println("Enter car Id to delete car details");
				int id = sc.nextInt();
				Query query = session.createQuery("delete Car where car_id= :car_id");
				query.setParameter("car_id", id);

				int result = query.executeUpdate();
				if (result > 0) {
					System.out.println("Car details with id " + id + " deleted Successfully");
				}
			}

			else if (command.equalsIgnoreCase("update")) {
				System.out.println("Enter car Id to update car details");
				int id = sc.nextInt();
				System.out.println("Enter which details you want to update");
				System.out.println("Make :");
				System.out.println("Model :");
				System.out.println("Year :");
				System.out.println("Sale Price ");
				System.out.println("--------------------------------------------");
				String detailToUpdate = sc.next();
				int result = 0;
				System.out.println("Enter new " + detailToUpdate);
				if (detailToUpdate.equalsIgnoreCase("make") || detailToUpdate.equalsIgnoreCase("model")) {
					String newDetail = sc.next();
					Query query = session.createQuery("update Car set " + detailToUpdate.toLowerCase() + " = :"
							+ detailToUpdate.toLowerCase() + " where car_id = :car_id");
					query.setParameter(detailToUpdate.toLowerCase(), newDetail);
					query.setParameter("car_id", id);
					result = query.executeUpdate();

				} else if (detailToUpdate.equalsIgnoreCase("year")) {
					int newDetail = sc.nextInt();
					Query query = session.createQuery("update Car set  year =:year where car_id = :car_id");
					query.setParameter("year", newDetail);
					query.setParameter("car_id", id);
					result = query.executeUpdate();
				} else if (detailToUpdate.trim().equalsIgnoreCase("saleprice")) {
					double newDetail = sc.nextDouble();
					Query query = session.createQuery("update Car set salePrice = :salePrice where car_id = :car_id");
					query.setParameter("salePrice", newDetail);
					query.setParameter("car_id", id);
					result = query.executeUpdate();
				} else {
					System.out.println("Sorry, but " + detailToUpdate + " is not a valid command. Please try again");
				}
				if (result > 0) {
					System.out.println("Car details updated Successfully");
				}

			} else {
				System.out.println("Sorry, but " + command + " is not a valid command. Please try again");
			}
			session.close();
			solution();
		}

	}

	public static void main(String[] args) {

		System.out.println("WelCome to Car Catalog ");
		System.out.println("Enter add -> To add a car to the catalog ");
		System.out.println("Enter list -> To list all cars in the catalog ");
		System.out.println("Enter Delete -> To delete car ");
		System.out.println("Enter Update -> To update car Details");
		System.out.println("Enter Quit -> To quit car catalog");
		System.out.println("--------------------------------------------");

		solution();

	}

}
