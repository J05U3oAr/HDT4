public class Calculator {
    // Instancia única (Singleton)
    private static Calculator instance = null;

    // Constructor privado
    private Calculator() { }

    // Método para obtener la instancia única
    public static Calculator getInstance() {
        if (instance == null) {
            instance = new Calculator();
        }
        return instance;
    }
    

    public String convertInfixToPostfix(String infixExpression) {
        StringBuilder postfix = new StringBuilder();
        IStack<Character> opStack = new VectorStack<>(); // Usamos VectorStack para operadores

        for (int i = 0; i < infixExpression.length(); i++) {
            char ch = infixExpression.charAt(i);

            // Si el carácter es un dígito, leer el número completo
            if (Character.isDigit(ch)) {
                StringBuilder number = new StringBuilder();
                while (i < infixExpression.length() && Character.isDigit(infixExpression.charAt(i))) {
                    number.append(infixExpression.charAt(i));
                    i++;
                }
                i--; // Ajustar el índice, ya que el bucle for incrementará
                postfix.append(number.toString());
                postfix.append(" ");
            } else if (ch == '(') {
                opStack.push(ch);
            } else if (ch == ')') {
                // Sacar de la pila hasta encontrar el '('
                while (!opStack.isEmpty() && opStack.peek() != '(') {
                    postfix.append(opStack.pop());
                    postfix.append(" ");
                }
                if (!opStack.isEmpty() && opStack.peek() == '(') {
                    opStack.pop();
                }
            } else if (isOperator(ch)) {
                // Mientras haya operadores en la pila con mayor o igual precedencia, extraerlos
                while (!opStack.isEmpty() && opStack.peek() != '('
                        && getPrecedence(ch) <= getPrecedence(opStack.peek())) {
                    postfix.append(opStack.pop());
                    postfix.append(" ");
                }
                opStack.push(ch);
            }
            // Se ignoran los espacios y otros caracteres
        }

        // Vaciar la pila de operadores
        while (!opStack.isEmpty()) {
            postfix.append(opStack.pop());
            postfix.append(" ");
        }

        return postfix.toString().trim();
    }
  
    
    public int evaluatePostfix(String postfixExpression) {
        IStack<Integer> stack = new VectorStack<>();
        String[] tokens = postfixExpression.split("\\s+");
        
        for (String token : tokens) {
            // Si el token es un número, lo empuja a la pila
            if (token.matches("\\d+")) {
                stack.push(Integer.parseInt(token));
            }
            // Si el token es un operador, extrae dos operandos y aplica la operación
            else if (token.length() == 1 && isOperator(token.charAt(0))) {
                if (stack.size() < 2) {
                    throw new RuntimeException("Operación inválida: no hay suficientes operandos.");
                }
                int b = stack.pop();
                int a = stack.pop();
                int result = 0;
                char operator = token.charAt(0);
                switch (operator) {
                    case '+': result = a + b; break;
                    case '-': result = a - b; break;
                    case '*': result = a * b; break;
                    case '/':
                        if (b == 0) {
                            throw new ArithmeticException("División por cero.");
                        }
                        result = a / b; break;
                    case '%': result = a % b; break;
                    case '^': result = (int) Math.pow(a, b); break;
                    default:
                        throw new RuntimeException("Operador desconocido: " + operator);
                }
                stack.push(result);
            }
            else {
                throw new RuntimeException("Token inválido: " + token);
            }
        }
        
        if (stack.size() != 1) {
            throw new RuntimeException("La expresión es inválida, quedan múltiples valores en la pila.");
        }
        return stack.pop();
    }
    
    // Método auxiliar: verifica si un carácter es un operador válido.
    private boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '%' || ch == '^';
    }
    
    // Método auxiliar: retorna la precedencia de un operador.
    private int getPrecedence(char op) {
        switch (op) {
            case '+':
            case '-': return 1;
            case '*':
            case '/':
            case '%': return 2;
            case '^': return 3;
            default:  return -1;
        }
    }
    
    
    public void evaluar(String operacion) {
        IStack<Integer> pila = new VectorStack<>();
        boolean exito = true;
        
        for (int i = 0; i < operacion.length(); i++) {
            char caracter = operacion.charAt(i);
            
            if (Character.isDigit(caracter)) {
                int numero = Character.getNumericValue(caracter);
                while ((i + 1 < operacion.length()) && Character.isDigit(operacion.charAt(i + 1))) {
                    i++;
                    numero = numero * 10 + Character.getNumericValue(operacion.charAt(i));
                }
                pila.push(numero);
            } 
            else if (isOperator(caracter)) {
                if (pila.size() < 2) {
                    System.out.println("No hay suficientes números para operar");
                    exito = false;
                    break;
                }
                int b = pila.pop();
                int a = pila.pop();
                int resultado = 0;
                switch (caracter) {
                    case '+': resultado = a + b; break;
                    case '-': resultado = a - b; break;
                    case '*': resultado = a * b; break;
                    case '/':
                        if (b == 0) {
                            System.out.println("No se puede dividir por 0");
                            exito = false;
                        } else {
                            resultado = a / b;
                        }
                        break;
                    case '%': resultado = a % b; break;
                }
                if (!exito) break;
                pila.push(resultado);
            } 
            else if (caracter != ' ') {
                exito = false;
                System.out.println("La cadena contiene un carácter inválido");
                break;
            }
        }
        
        if (exito) {
            if (pila.size() == 1) {
                System.out.println("Resultado: " + pila.pop());
            } else {
                System.out.println("Quedan demasiados números en la pila");
            }
        }
    }
}
