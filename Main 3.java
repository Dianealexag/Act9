import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido a Poker!");

        int option;
        try {
            do {
                option = showMenu(scanner);
                try {
                    switch (option) {
                        case 1:
                            deck.shuffle();
                            break;
                        case 2:
                            deck.head();
                            break;
                        case 3:
                            deck.pick();
                            break;
                        case 4:
                            deck.hand();
                            break;
                        case 0:
                            System.out.println("Gracias por jugar a Poker!");
                            break;
                        default:
                            throw new Exception("Opción no válida");
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } while (option != 0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static int showMenu(Scanner scanner) throws Exception {
        System.out.println("Selecciona una opción:");
        System.out.println("1 Mezclar deck");
        System.out.println("2 Sacar una carta");
        System.out.println("3 Carta al azar");
        System.out.println("4 Generar una mano de 5 cartas");
        System.out.println("0 Salir");
        int option = scanner.nextInt();
        if (option < 0 || option > 4) {
            throw new Exception("Opción no válida");
        }
        return option;
    }
}

class Deck {
    private List<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
        initializeDeck();
    }

    private void initializeDeck() {
        String[] suits = {"tréboles", "corazones", "picas", "diamantes"};
        String[] colors = {"negro", "rojo"};
        String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "A", "J", "Q", "K"};

        for (String suit : suits) {
            for (String color : colors) {
                for (String value : values) {
                    cards.add(new Card(suit, color, value));
                }
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
        System.out.println("Se mezcló el Deck.");
    }

    public void head() throws Exception {
        if (!cards.isEmpty()) {
            Card firstCard = cards.remove(0);
            System.out.println(firstCard.toString());
            System.out.println("Quedan " + cards.size() + " cartas en deck");
        } else {
            throw new Exception("Se han agotado las cartas");
        }
    }

    public void pick() throws Exception {
        if (!cards.isEmpty()) {
            int randomIndex = (int) (Math.random() * cards.size());
            Card pickedCard = cards.remove(randomIndex);
            System.out.println(pickedCard.toString());
            System.out.println("Quedan " + cards.size() + " cartas en deck");
        } else {
            throw new Exception("Se han agotado las cartas");
        }
    }

    public void hand() throws Exception {
        if (cards.size() >= 5) {
            System.out.println("Mano de cartas:");

            for (int i = 0; i < 5; i++) {
                Card card = cards.remove(0);
                System.out.println(card.toString());
            }

            System.out.println("Quedan " + cards.size() + " cartas en deck");
        } else {
            throw new Exception("No hay suficientes cartas en el deck para repartir una mano.");
        }
    }
}

class Card {
    private String suit;
    private String color;
    private String value;

    public Card(String suit, String color, String value) {
        this.suit = suit;
        this.color = color;
        this.value = value;
    }

    @Override
    public String toString() {
        return suit + "," + color + "," + value;
    }
}