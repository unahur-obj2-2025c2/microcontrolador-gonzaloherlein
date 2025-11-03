package ar.unahur.edu.obj2.patroncommand;

import java.util.ArrayList;
import java.util.List;

import ar.unahur.edu.obj2.patroncommand.operaciones.Operable;

public class Programa {
    List<Operable> operaciones;

    public Programa(){
        this.operaciones = new ArrayList<>();
    }

    public void agregarOperaciones(Operable operacion){
        operaciones.add(operacion);
    }

    public void vaciarLista(){
        operaciones.clear();
    }

    public void ejecutar(Programable micro){
        micro.run(operaciones);
    }

    public void resetearMicro(Programable micro){
        micro.reset();
    }

    public List<Operable> getOperaciones() {
        return operaciones;
    }

    
}

