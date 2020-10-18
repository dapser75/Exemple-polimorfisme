package com.jobs.application;

import java.util.ArrayList;
import java.util.List;

import com.jobs.domain.*;
import com.jobs.persistence.*;

public class JobsController {

	private EmployeeRepository repository = new EmployeeRepository();
	
	public JobsController(){
		
	}
	
	public void createBossEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee boss = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateBoss());
		repository.addMember(boss);
	}
	
	public void createEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee employee = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateEmployee());
		repository.addMember(employee);
	}

	public void createManagerEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{
		// TODO Auto-generated method stub
		Employee manager = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentManager());
		repository.addMember(manager);
		
	}
	
	public void createVolunteer(String name, String address, String phone) throws Exception {
		// TODO Auto-generated method stub
		String description = "Voluntario perteneciente a Cruz Roja";
		Volunteer volunter = new Volunteer(name, address, phone,  description);
		repository.addMember(volunter);
		
	}
	

	//Método para pagar a los empleados para verificar que el pago es correcto se ha creado un bucle para verificarlo.
	public void payAllEmployeers() {
		List<AbsStaffMember> members = repository.getAllMembers();
		System.out.println("PAGO A LOS EMPLEADOS:");
			for (int i=0; i<members.size();i++) {
				members.get(i).pay(); //Metodo de pago que se rellena en la lsita
				System.out.println(members.get(i).getName() + ". Total a pagar: " + members.get(i).getTotalPaid());
			}
	}

	
	//Metodo para obtener todos los miembros de la lista en un string
	public String getAllEmployees() {
		List<AbsStaffMember> members = repository.getAllMembers();
		String totalEmployees="";
		Employee employee;
		Volunteer volunteer;
		for (int i=0; i<members.size();i++) {
			if (members.get(i) instanceof Employee){ //Añadir datos del tipo empleado. Se compara a que clase pertenece el objeto.
				employee= (Employee)members.get(i);
				totalEmployees += "\n Nombre: " + employee.getName() 
						+ ". Dirección: " + employee.getAddress()  
						+ ". Telefono: " + employee.getPhone() 
						+ ". Salario: " + employee.getSalaryPerMonth() 
						+ ". Total a pagar: " + employee.getTotalPaid() + ".";	
						
			}else { //añadir datos del tipo voluntario
				volunteer= (Volunteer)members.get(i);
				totalEmployees +="\n Nombre: " + volunteer.getName() 
				+ ". Dirección: " + volunteer.getAddress()  
				+ ". Telefono: " + volunteer.getPhone()
				+ ". Descripción: " + volunteer.getDescription()					
				+ ". Total a pagar: " + volunteer.getTotalPaid() + ".";	
			}
		}//end for
		return totalEmployees; //Retorno del string.
	}//fin metodo getAllEmployees
}
