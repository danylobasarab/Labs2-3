package ua.lviv.iot;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.io.*;

public class App 
{
	// пошук напоїв, які приготовані з використанням кави, залежно від заданого фізичного стану
	// та сортування по використаному об’єму кави
	public static ArrayList<Drink> findCoffee(List<Drink> arrlist, Type type)
	{
		ArrayList<Drink> coffeeList = new ArrayList<Drink>();
		for (int counter = 0; counter < arrlist.size(); counter++) { 
			if(arrlist.get(counter) instanceof Coffee){
				Coffee coffee = (Coffee)arrlist.get(counter);
				if(coffee.type == type){
					coffeeList.add(arrlist.get(counter));
				}
			} 		  
		} 
		Comparator<Drink> compareByWeight = (Drink o1, Drink o2) -> Integer.compare(((Coffee)o1).weight, ((Coffee)o2).weight);

		Collections.sort(coffeeList, compareByWeight);
		
		return coffeeList;
	}
	
	// виведення результатів
	public static void printDrinks(List<Drink> arrlist){
		System.out.format("%26s %6s %4s %7s %4s \n","Name", "Price", "Size", "Type", "Weight" );		
		for (int counter = 0; counter < arrlist.size(); counter++) { 
			System.out.format("%26s %6.2f %4d ",arrlist.get(counter).name, arrlist.get(counter).price, arrlist.get(counter).size );
			if(arrlist.get(counter) instanceof Coffee){
				Coffee coffee = (Coffee)arrlist.get(counter);
				System.out.format("%7s %4d",coffee.type, coffee.weight );
			} 
			System.out.println("");			
		}
	}
	
	// алгоритм сортування
	public static ArrayList<Drink> quickSort(ArrayList<Drink> list, boolean asc)
	{
		if (list.isEmpty()) 
			return list; 
		ArrayList<Drink> sorted; 
		ArrayList<Drink> smaller = new ArrayList<Drink>(); 
		ArrayList<Drink> greater = new ArrayList<Drink>(); 
		Drink pivot = list.get(0);  
		int i;
		Drink j;     
		for (i=1;i<list.size();i++)
		{
			j=list.get(i);
			if(asc){
				if (j.name.compareToIgnoreCase(pivot.name)<0)  
					smaller.add(j);
				else
					greater.add(j);
			}
			else
			{
				if (j.name.compareToIgnoreCase(pivot.name)<0)  
					greater.add(j);
				else
					smaller.add(j);
			}
		}
		smaller=quickSort(smaller,asc);  
		greater=quickSort(greater,asc);  
		smaller.add(pivot);          
		smaller.addAll(greater);     
		sorted = smaller;            

		return sorted;
	}
	
    public static void main( String[] args )
    {
		// ініціалізація початкових даних
		ArrayList<Drink> listAnything = new ArrayList<Drink>();
		
		//  						  назва	   ціна розмір	  тип	   об'єм
		//											порції				кави
		listAnything.add(new Coffee("Americano",45,  200, Type.GROUND,  121));
		
		listAnything.add(new Coffee("Filtered Coffee",50,900, Type.GROUND,152));
		listAnything.add(new Coffee("Cold brew",79,150, Type.GROUND,112));
		listAnything.add(new Coffee("Coffee with ice cream",75,200, Type.GROUND,12));	
		listAnything.add(new Coffee("Cappuccino",55,800, Type.PACK,123));
		listAnything.add(new Coffee("Latte",66,200, Type.GROUND,18));
		listAnything.add(new Coffee("Flat white",60,200, Type.INSTANT,14));
		listAnything.add(new Coffee("Raff coffee",90,200, Type.INSTANT,16));
		listAnything.add(new Coffee("Nut latte with cream",90,700, Type.PACK,12));
		listAnything.add(new Coffee("Lviv rainy day coffee",111,600, Type.BEAN,132));
		listAnything.add(new Coffee("Relaxing coffee",71,200, Type.BEAN,112));
		listAnything.add(new Coffee("Evening coffee",72,500, Type.BEAN,142));
		listAnything.add(new Coffee("Best served in bed",100,215, Type.BEAN,162));
		listAnything.add(new Coffee("For lovers",110,400, Type.BEAN,182));
		listAnything.add(new Coffee("Banderivska",65,200, Type.BEAN,172));
		listAnything.add(new Coffee("Mocaccino",85,300, Type.BEAN,192));
		listAnything.add(new Coffee("Fancy latte with roses",75,100, Type.BEAN,12));
		
		listAnything.add(new WarmDrink("Homemade tea",71,220));
		listAnything.add(new WarmDrink("Tea",78,200));
		listAnything.add(new WarmDrink("Masala Chai",77,330));
		listAnything.add(new WarmDrink("Cocoa with marshmallow",75,200));
		
		listAnything.add(new NonAlcoholicDrink("Galicia, natural juices",50,300));
		listAnything.add(new NonAlcoholicDrink("Jaffa juices and nectars",47,250));
		listAnything.add(new NonAlcoholicDrink("Coca-cola",50,250));
		
		listAnything.add(new Beer("Coca-cola",75,330));
		listAnything.add(new Beer("Bottled beer",74,330));
		
		listAnything.add(new Wine("TM SHABO Classic",400,500));
		listAnything.add(new Wine("Riesling Trocken.Dr.Loosen",600,500));
		listAnything.add(new Wine("Rose d'Anjou",600,500));
		listAnything.add(new Wine("Chianti. Poliziano",800,500));
		listAnything.add(new Wine("Shiraz-Malbec.Esperado",750,500));
		
		// виведення всього асортименту напоїв
		System.out.println("All drinks list");
		printDrinks(listAnything);
		
		// виведення списку типів кави залежно від заданого фізичного стану
		Type coffeeType;
		System.out.println("\nChoose your coffee type:");
		System.out.println("1. BEAN");		// Зернова
		System.out.println("2. GROUND");	// Мелена
		System.out.println("3. INSTANT");	// Розчинна в банках
		System.out.println("4. PACK");		// В пакетиках
		
		// вводимо обраний тип кави 
		Scanner in = new Scanner(System.in);
		int inType = in.nextInt();
		switch(inType){
			case 1:
			coffeeType = Type.BEAN;
			break;
			case 2:
			coffeeType = Type.GROUND;
			break;
			case 3:
			coffeeType = Type.INSTANT;
			break;
			case 4:
			coffeeType = Type.PACK;
			break;
			default:
			coffeeType = Type.BEAN;
		}
		
		// пошук та сортування кави залежно від фізичного стану, за об’ємом
		System.out.println("\nSorted coffee responds to the request(Weight)");
		ArrayList<Drink> finded = findCoffee(listAnything, coffeeType);
		printDrinks(finded);
		
		ArrayList<Drink> listSorted;
	
		// сортування за назвою (за зростанням)
		System.out.println("\nCoffee sorted by name ascending");
		listSorted = quickSort(finded, true);
		printDrinks(listSorted);
		
		// сортування за назвою (за спаданням)			
		System.out.println("\nCoffee sorted by name descending");
		listSorted = quickSort(finded, false);
		printDrinks(listSorted);
		
    }
}
