package ua.lviv.iot;

public abstract class Drink
{
	String name; // назва
	double price; // ціна
	int size; // розмір
	public Drink(String name, double price,int size){
		this.name = name;
		this.price = price;
		this.size = size;
		
	}
}