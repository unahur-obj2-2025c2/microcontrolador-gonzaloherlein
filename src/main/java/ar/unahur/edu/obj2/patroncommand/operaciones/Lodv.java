package ar.unahur.edu.obj2.patroncommand.operaciones;

import ar.unahur.edu.obj2.patroncommand.Programable;

public class Lodv extends Operacion{

    private Integer valor;

    public Lodv(Integer valor){
        this.valor = valor;
    }

    @Override
    protected void doExecute(Programable micro) {
        micro.setAcumuladorA(valor);
    }

}
