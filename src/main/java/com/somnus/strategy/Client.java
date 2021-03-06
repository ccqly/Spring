package com.somnus.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public class Client {

}

interface IService{
	String who();
	String where();
}
@Service
class ServiceImpl implements IService{
	public String who(){
		return "Somnus";
	}
	public String where(){
		return "ShangHai";
	}
}
class A{
	private IService service;
	public IService getService() {
		return service;
	}
	public void setService(IService service) {
		this.service = service;
	}
	protected void say() {
		System.out.println("I am " + service.who());
	}
}
@Component
class B extends A{
	@Autowired
	public void setService(IService service) {
		super.setService(service);
	}
	public void lol(){
		super.say();
		IService service = getService();
		System.out.println("Here is " + service.where());
				
	}
}