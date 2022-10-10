public class Main {
    public static void main(String[] args) {
        final Trabajador trabajador1 = new Trabajador("Trabajador 1", true);
        final Trabajador trabajador2 = new Trabajador("Trabajador 2", true);
        final RecursoCompatido recursoCompatido =  new RecursoCompatido(trabajador1);
        new Thread(new Runnable(){
            @Override
            public void run() {
                trabajador1.trabajo(recursoCompatido, trabajador2);
            }
        }).start();
        new Thread(new Runnable(){
            @Override
            public void run() {
                trabajador2.trabajo(recursoCompatido, trabajador1);
            }
        }).start();
    }
}
