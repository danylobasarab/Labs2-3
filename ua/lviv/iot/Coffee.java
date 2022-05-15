package ua.lviv.iot;


public class Coffee extends NonAlcoholic implements Comparable <Coffee>
{ 
	Type type;  // фізичний стан кави
	int weight; // об'єм кави
	public Coffee(String name, double price,int size, Type type, int weight){
		super(name, price, size);
		this.type = type;
		this.weight = weight;	
	}
	int getWeight(){
		
		return weight;
	}
	@Override
    public int compareTo(Coffee o) {
		return this.name.compareToIgnoreCase(o.name); 
    }
}