package estructuras;
/**
 * Write a description of class StackLimited here.
 * 
 * @author (Javier Sánchez) 
 * version (19-09-2016)
 */
public class StackLimited implements Stack{
    private static Object[] stack; //Arreglo que actuará como pila
    private static int top; //Lugar del tope de la pila

    /**
     * Constructor que inicializa el Stack creando una pila de diez.
     */
    public StackLimited(){
        this(10);
    }

    /**
     * Constructor que inicializa el Stack con valores de usuario.
     * @param n que es el tamaño de la pila
     */
    public StackLimited(int n){
        stack = new Object [n];
        top = 0; //El índice superior de la pila comienza en cero
    }

    /**
     * Método que ingresa un elemento a la pila.
     *
     * param elemento que es el elemento a agregar
     * return void
     */
    public void push(Object elemento){
        if (top < stack.length) {
            stack[top] = elemento; //Se agrega el elemento
            top++; //Por lo tanto, el indice se incrementa
        }
    }

    /**
     * Método que "extrae" el elemento superior de la pila.
     * @return stack
     * 
     */
    public  Object pop() throws Exception{
        if (top > 0) {
            top--;
        }
        return stack[top];
    }

    /**
     * Método para saber si la pila esta vacia (o no).
     * @return está vacío/no está vacío
     */
    public  boolean isEmpty() {
        return (top==0);
    }

    /**
     * metodo que regresa el elemento en el tope de la pila.
     *
     * @return stack[top - 1] que es el elemento.
     */
    public  Object top() throws Exception {
        return stack[top - 1];
    }

    /**
     * Método que regresa si la pila esta llena (o no).
     *
     * @return está lleno/ o no
     */
    public  boolean isFull() {
        return (top == stack.length);
    }
}