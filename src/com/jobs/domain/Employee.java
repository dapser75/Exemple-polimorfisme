package com.jobs.domain;

import com.jobs.persistence.*;

public class Employee extends AbsStaffMember {

	protected double salaryPerMonth;
	protected IPaymentRate paymentRate;	

	public Employee(String name, String address, String phone, double salaryPerMonth,IPaymentRate paymentRate) throws Exception {
		super(name, address, phone);		
		if(salaryPerMonth<0) throw new Exception();
		if(paymentRate==null) throw new Exception();
				
		this.salaryPerMonth=salaryPerMonth;
		this.paymentRate=paymentRate;
	}

	
	@Override
	public void pay() {
		totalPaid=paymentRate.pay(salaryPerMonth);
	}


	public double getSalaryPerMonth() {
		return salaryPerMonth;
	}

	@Override
	public String getMember() {
		String datosParticulares="";
		datosParticulares = "\n.- Nombre: " + name + ". Dirección: " + address +
							". Teléfono: " + phone + ". Salario: " + salaryPerMonth + 
							". Total a pagar: " + totalPaid + ".";
	
		return datosParticulares;
	}
	
	
}
