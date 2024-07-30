import entities.User;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		User aldo = new User("Aldo", "Baglio", 20);
		User giovanni = new User("Giovanni", "Storti", 30);
		User giacomo = new User("Giacomo", "Poretti", 40);

		// ArrayList<User> usersList = new ArrayList<>(); // Tra le parentesi angolari vado ad inserire il tipo di dato che sarà conservato nella lista
		List<User> usersList = new LinkedList<>(); // <-- UPCASTING, potrò in futuro eventualmente sostituire l'ArrayList con una lista compatibile tipo LinkedList
		// perché avendo utilizzato l'upcasting sono sicuro che nelle seguenti righe di codice avrò utilizzato solo metodi appartenenti a List e non a ArrayList
		// Se avessi utilizzato metodi specifici di ArrayList invece non avrei potuto sostituirla con una LinkedList perché questa non possiede tali metodi

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
		usersList.addAll(List.of(new User[]{aldo, giovanni, giacomo})); // Non posso passare direttamente un array come parametro al metodo perché esso vuole una
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

		// ******************************************************* RIMUOVERE ELEMENTI DA LISTA ************************************************
		ArrayList<String> lettere = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e"));

		for (String lettera : lettere) {
			if (lettera.equals("d")) lettere.remove(lettera);
			else System.out.println(lettera);
		}


		// Sarebbe meglio rimuovere gli elementi tramite l'iterator piuttosto che con un ciclo for e un if
		Iterator<String> iterator = lettere.iterator();

		while (iterator.hasNext()) { // Fino a che ci sono ulteriori elementi da ciclare, continua
			String letteraCorrente = iterator.next(); // iterator.next() mi ritorna sempre l'elemento corrente
			if (letteraCorrente.equals("d")) iterator.remove(); // N.B. attenzione che sto facendo iterator.remove() e non lettere.remove(),
				// però il risultato finale sarà sempre la rimozione dell'elemento dalla lista

			else System.out.println(letteraCorrente);
		}


		// ******************************************************* SET ************************************************
		HashSet<User> usersSet = new HashSet<>(); // HashSet non consente duplicati e non mantiene un ordine di inserzione
		// LinkedHashSet come sopra non consente duplicati e inoltre mantiene l'ordine di inserzione degli elementi

		usersSet.add(aldo);
		usersSet.add(giovanni);
		usersSet.add(giacomo);
		// usersSet.add(aldo); // <-- Aggiungere un duplicato non è vietato (nel senso che non avrò eccezioni) però IntelliJ
		// mi fa notare la cosa con un warning indicando quindi che non ha molto senso farlo. Nei Set .add() significa
		// che Java dovrà scansionare tutto il Set prima di poter aggiungere un elemento
		System.out.println(usersSet);

		TreeSet<String> alfabeto = new TreeSet<>(); // Il TreeSet oltre a non consentire duplicati ordina pure gli elementi (operazione molto costosa)
		alfabeto.add("g");
		alfabeto.add("b");
		alfabeto.add("h");
		alfabeto.add("c");

		System.out.println(alfabeto);

		TreeSet<User> userTreeSet = new TreeSet<>();
		// Per rendere compatibili oggetti creati da noi con i TreeSet, essi dovranno implementare l'interfaccia Comparable
		// Implementare l'interfaccia vuol dire dover implementare obbligatoriamente il metodo compareTo, il quale
		// servirà per il TreeSet per capire come confrontare due elementi e ordinarli
		userTreeSet.add(aldo);
		userTreeSet.add(giovanni);
		userTreeSet.add(giacomo);
		userTreeSet.add(new User("Ajeje", "Brazorf", 50));

		System.out.println(userTreeSet);

		// ******************************************************* MAP ************************************************
		// Le Map sono strutture in cui ogni elemento è caratterizzato da una coppia <CHIAVE, VALORE>
		HashMap<Integer, User> usersMap = new HashMap<>(); // Ad esempio qua sto dichiarando che ogni elemento della Map sarà rappresentato
		// da una chiave di tipo numerico intero ed un valore di tipo User. Ad esempio potrei usarla per salvare e ricercare gli utenti in base al
		// loro id. Ogni elemento sarà tipo
		// 111111 - Aldo Baglio 20
		// 222222 - Giovanni Storti 30

		HashMap<String, String> dizionario = new HashMap<>(); // Qua sia chiave che valore sono String
		// Ogni elemento sarà tipo:
		// "Albero" - "Definizione della parola albero..blablabla"
		// "Porta" - "Definizione della parola porta...."

		System.out.println("-------------------------------------------- AGGIUNTA ELEMENTI ---------------------------------------------");
		usersMap.put(111111, aldo);
		usersMap.put(222222, giovanni);
		usersMap.put(333333, giacomo);

		System.out.println(usersMap);

		dizionario.put("Albero", "Definizione della parola albero..blablabla");
		dizionario.put("Porta", "Definizione della parola porta....");
		// dizionario.put("Albero", "Bla bla bla"); <-- Non ci possono essere duplicati nelle chiavi, verrà effettuata una sovrascrittura

		System.out.println(dizionario);


		System.out.println("-------------------------------------------- LEGGERE ELEMENTI ---------------------------------------------");
		System.out.println("La definizione di albero è: " + dizionario.get("Albero")); // La chiave serve per accedere agli elementi in lettura, scrittura, rimozione

		System.out.println("-------------------------------------------- RIMPIAZZARE ELEMENTI ---------------------------------------------");
		dizionario.replace("Albero", "Una definizione più aggiornata di albero");

		System.out.println("-------------------------------------------- RIMUOVERE ELEMENTI ---------------------------------------------");
		// dizionario.remove("Albero");

		Set<String> chiaviDizionario = dizionario.keySet(); // Mi ritorna l'elenco di tutte le chiavi. E' un SET perché le chiavi non ammettono duplicati

		for (String chiave : chiaviDizionario) {
			System.out.println("Chiave: " + chiave);
			System.out.println("Valore: " + dizionario.get(chiave));
		}

		Collection<String> valori = dizionario.values();

		System.out.println(valori);


	}
}