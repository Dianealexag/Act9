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