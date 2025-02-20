public class Calculadora {

    public void evaluar(String operacion) {
        // Creación de la instancia de la pila
        Stack<Integer> pila = new VectorStack<>();

        // Creación de una variable booleana para asegurar que la operación se realizó correctamente
        boolean exito = true;

        for (int i = 0; i < operacion.length(); i++) {
            char caracter = operacion.charAt(i);

            // Verificar si el carácter es un número y si tiene más de un dígito
            if (Character.isDigit(caracter)) {
                int numero = Character.getNumericValue(caracter);

                while ((i + 1 < operacion.length()) && Character.isDigit(operacion.charAt(i + 1))) {
                    i++;
                    numero = numero * 10 + Character.getNumericValue(operacion.charAt(i));
                }

                pila.push(numero);
            } 
            // Verificar operadores válidos
            else if (caracter == '+' || caracter == '-' || caracter == '*' || 
                     caracter == '/' || caracter == '%') {

                // Verificar que haya suficientes números para operar
                if (pila.size() < 2) {
                    System.out.println("No hay suficientes números para operar");
                    exito = false;
                    break;
                }

                // Obtener ambos números
                int b = pila.pop();
                int a = pila.pop();
                int resultado = 0;

                // Seleccionar la operación a realizar
                switch (caracter) {
                    case '+':
                        resultado = a + b;
                        break;
                    case '-':
                        resultado = a - b;
                        break;
                    case '*':
                        resultado = a * b;
                        break;
                    case '/':
                        if (b == 0) {
                            System.out.println("No se puede dividir por 0");
                            exito = false;
                            break;
                        } else {
                            resultado = a / b;
                        }
                        break;
                    case '%':
                        resultado = a % b;
                        break;
                }
                if (!exito) break;
                pila.push(resultado);
            } 
            // Manejar caracteres no válidos, ignorando espacios
            else if (caracter != ' ') {
                exito = false;
                System.out.println("La cadena contiene un carácter inválido");
                break;
            }
        }

        if (exito) {
            // Asegurarse de que solo quede un número en la pila
            if (pila.size() == 1) {
                System.out.println("Resultado: " + pila.pop());
            } else {
                System.out.println("Quedan demasiados números en la pila");
            }
        }
    }
}
