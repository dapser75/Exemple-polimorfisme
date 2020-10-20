package com.jobs.domain;

public class Volunteer extends AbsStaffMember {
	
	protected String description;

	public Volunteer(String name, String address, String phone, String description) throws Exception {
		super(name, address, phone);
		
		this.description=description; //Se a�ade la descripcion
		
		//TODO
	}

	
	@Override
	public void pay() {
		totalPaid=0;
		
	}


	public String getDescription() {
		return description;
	}
	
	@Override
	public String getMember() {
		String datosParticulares="";
		datosParticulares = "\n.- Nombre: " + name + ". Direcci�n: " + address + 
							". Tel�fono: " + phone + ". Descripci�n: " + description + 
							". Total a pagar: " + totalPaid + ".";
	
		return datosParticulares;
	}
}
