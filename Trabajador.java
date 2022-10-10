public class Trabajador {
    private String nombre;
    private boolean activo;
    public Trabajador(String nombre, boolean activo){
        this.activo = activo;
        this.nombre = nombre;
    }
    public String getNombre(){
        return nombre;
    }
    public boolean estaActivo(){
        return activo;
    }
    public synchronized void trabajo(RecursoCompatido recursoCompartido, Trabajador otroTrabajador){
        while(activo){
            if(recursoCompartido.getPropietario() != this){
                try {
                    wait(10);
                } catch (InterruptedException e) {}
                continue;
            }
            if(otroTrabajador.estaActivo()){
                System.out.println(getNombre() + " : dar el recurso al Trabajador" + otroTrabajador.getNombre());
                recursoCompartido.setPropietario(otroTrabajador);
                continue;
            }
            System.out.println(getNombre() + " : trabajando en el recurso comun. ");
            activo = false;
            recursoCompartido.setPropietario(otroTrabajador);
        }
    }
}