import entities.User;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		User aldo = new User("Aldo", "Baglio", 20);
		User giovanni = new User("Giovanni", "Storti", 30);
		User giacomo = new User("Giacomo", "Poretti", 40);

		ArrayList<User> usersList = new ArrayList<>(); // Tra le parentesi angolari vado ad inserire il tipo di dato che sarà conservato nella lista

		System.out.println("La lista ha " + usersList.size() + " elementi");
		usersList.add(aldo);
		usersList.add(giovanni);
		usersList.add(1, giacomo);
		usersList.add(new User("Ajeje", "Brazorf", 50));
		System.out.println("La lista ha " + usersList.size() + " elementi");

		System.out.println(usersList);

		for (User user : usersList) {
			System.out.println(user);
		}

		System.out.println("------------------------------- GET ---------------------------------");
		try {
			User found = usersList.get(5); // <-- IndexOutOfBoundsException
			System.out.println(found);
		} catch (IndexOutOfBoundsException ex) {
			System.out.println("Utente non trovato!");
		}

		System.out.println("------------------------------- INDEX OF ---------------------------------");
		System.out.println("L'indice di Giovanni è: " + usersList.indexOf(giovanni));

		System.out.println("------------------------------- CONTAINS ---------------------------------");
		if (usersList.contains(aldo)) {
			// .contains() internamente utilizza il metodo .equals dei nostri oggetti. Ciò significa che di default compara le celle di memoria, ma
			// volendo potrei anche fare un Override di equals per avere un criterio personalizzato
			System.out.println("La lista contiene Aldo");
		} else {
			System.out.println("La lista non contiene Aldo");
		}

		System.out.println("------------------------------- REMOVE ---------------------------------");
		usersList.remove(aldo);
		usersList.removeFirst();
		usersList.remove(1);

		System.out.println("La lista ha " + usersList.size() + " elementi");
		System.out.println(usersList);

		System.out.println("------------------------------- ADD ALL ---------------------------------");
		User[] usersArray = {aldo, giovanni, giacomo};
		usersList.addAll(Arrays.asList(usersArray)); // Non posso passare direttamente un array come parametro al metodo perché esso vuole una
		// COLLECTION. Pertanto potrò passargli solo List, Queue, Set ma niente array. La soluzione è convertire l'array in una Collection tipo List
		System.out.println("La lista ha " + usersList.size() + " elementi");
		System.out.println(usersList);

		System.out.println("------------------------------- REMOVE ALL ---------------------------------");
		User[] usersArray2 = {aldo, giovanni, giacomo};
		usersList.removeAll(Arrays.asList(usersArray2));
		System.out.println("La lista ha " + usersList.size() + " elementi");
		System.out.println(usersList);

		System.out.println("------------------------------- CLEAR ---------------------------------");
		System.out.println("La lista è vuota? " + usersList.isEmpty());
		usersList.clear();
		System.out.println("La lista è vuota? " + usersList.isEmpty());

		// ******************************************************* COLLECTIONS E TIPI PRIMITIVI ************************************************
		// ArrayList<int> numbers = new ArrayList<>(); <-- Non posso creare Collections contenenti dei tipi primitivi, quindi fare ArrayList<int>
		// è sbagliato. Posso però come creare delle Collection di interi, double, boolean ecc sfruttando le cosiddette WRAPPER CLASSES
		// Ogni tipo primitivo avrà una sua classe di corrispondenza --> Integer, Double, Boolean, Byte, Short, ecc ecc
		ArrayList<Integer> numbers = new ArrayList<>();
		numbers.add(1);
		numbers.add(100);

	}
}