package excepciones;

/** Created by xtrs84zk on 16/10/2016. **/
public class IsNotBalancedException extends Exception{

        private String message = "La expresión no está correctamente balanceada.";

        public IsNotBalancedException() {
            super();
        }

        public IsNotBalancedException(String message) {
            super(message);
            this.message = message;
        }

        public IsNotBalancedException(Throwable cause) {
            super(cause);
        }

        @Override
        public String toString() {
            return message;
        }

        @Override
        public String getMessage() {
            return message;
        }
    }
