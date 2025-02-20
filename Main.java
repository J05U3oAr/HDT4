import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario la implementación de la pila
        System.out.println("Seleccione la implementación de la pila:");
        System.out.println("1. ArrayList");
        System.out.println("2. Vector");
        System.out.println("3. Lista");
        System.out.print("Ingrese opción (1-3): ");
        int option = scanner.nextInt();
        scanner.nextLine(); // consumir el salto de línea

        String stackType = "";
        String listType = "";

        switch (option) {
            case 1:
                stackType = "ArrayList";
                break;
            case 2:
                stackType = "Vector";
                break;
            case 3:
                stackType = "List";
                System.out.println("Seleccione la implementación de la lista:");
                System.out.println("a. Simplemente Encadenada");
                System.out.println("b. Doblemente Encadenada");
                System.out.print("Ingrese opción (a/b): ");
                listType = scanner.nextLine().trim().toLowerCase();
                if (listType.equals("a")) {
                    listType = "SinglyLinkedList";
                } else if (listType.equals("b")) {
                    listType = "DoublyLinkedList";
                } else {
                    System.out.println("Opción inválida. Se usará la implementación por defecto: Simplemente Encadenada.");
                    listType = "SinglyLinkedList";
                }
                break;
            default:
                System.out.println("Opción inválida. Se usará la implementación por defecto: ArrayList.");
                stackType = "ArrayList";
                break;
        }

        // Crear la pila utilizando el patrón Factory
        // Se asume que StackFactory y IStack están implementados adecuadamente.
        IStack<Integer> stack = StackFactory.createStack(stackType, listType);

        // Leer la expresión infix desde el archivo "datos.txt"
        String infixExpression = "";
        try (BufferedReader br = new BufferedReader(new FileReader("datos.txt"))) {
            infixExpression = br.readLine();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo datos.txt: " + e.getMessage());
            e.printStackTrace();
            scanner.close();
            return;
        }

        System.out.println("Expresión infix leída del archivo: " + infixExpression);

        // Obtener la instancia única de Calculator (patrón Singleton)
        Calculator calculator = Calculator.getInstance();

        // Convertir la expresión infix a postfix
        String postfixExpression = calculator.convertInfixToPostfix(infixExpression);
        System.out.println("Expresión en formato postfix: " + postfixExpression);

        // Evaluar la expresión postfix
        int result = calculator.evaluatePostfix(postfixExpression);
        System.out.println("Resultado de la evaluación: " + result);

        scanner.close();
    }
}
