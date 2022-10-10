public class RecursoCompatido {
    private Trabajador propietario;
    public RecursoCompatido(Trabajador propietario){
        this.propietario = propietario;
    }
    public Trabajador getPropietario(){
        return propietario;
    }
    public synchronized void setPropietario(Trabajador propietario){
        this.propietario = propietario;
        
    }
}
