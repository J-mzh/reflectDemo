package org.maomao.entity;

import java.io.Serializable;

import javax.annotation.Resource;

@Resource
public class Computer implements Serializable {
	@Resource
	private String brand;
	
	public double price;
	
	private String color;
	
	public Computer(String brand, double price, String color) {
		super();
		this.brand = brand;
		this.price = price;
		this.color = color;
		System.out.println("我从春天走来,....");
	}

	public Computer() {
		super();
		System.out.println("你走这了");
	}

	private void showInfo(String name){
		
	}
	
	public void playGame(){
		System.out.println("电脑品牌：" + this.brand);
		System.out.println("我正在津津有味的玩着画图板");
	}
}












