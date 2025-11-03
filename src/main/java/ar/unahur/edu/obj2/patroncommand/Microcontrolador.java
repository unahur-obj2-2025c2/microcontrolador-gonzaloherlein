package ar.unahur.edu.obj2.patroncommand;

import java.util.Arrays;
import java.util.List;

import ar.unahur.edu.obj2.patroncommand.operaciones.Operable;

public class Microcontrolador implements Programable{
    private Integer acumuladorA;
    private Integer acumuladorB;
    private Integer programCounter;
    private List<Integer> memoria = Arrays.asList(new Integer[1024]);

    public Microcontrolador(Integer acumuladorA, Integer acumuladorB, Integer programCounter) {
        this.acumuladorA = acumuladorA;
        this.acumuladorB = acumuladorB;
        this.programCounter = programCounter;
    }
    @Override
    public void run(List<Operable> operaciones) {
        operaciones.forEach(o -> o.execute(this));
    }
    @Override
    public void incProgramCounter() {
        programCounter++;
    }
    @Override
    public Integer getProgramCounter() {
        return programCounter;
    }
    @Override
    public void setAcumuladorA(Integer value) {
        acumuladorA = value;
    }
    @Override
    public Integer getAcumuladorA() {
        return acumuladorA;
    }
    @Override
    public void setAcumuladorB(Integer value) {
        acumuladorB = value;
    }
    @Override
    public Integer getAcumuladorB() {
        return acumuladorB;
    }
    @Override
    public void setAddr(Integer addr) {
        if (addr < 0 || addr >= memoria.size()){
            throw new FueraDeRangoException("No se puede acceder a una direccion de memoria fuera de rango");
        }
        memoria.set(addr, acumuladorA);
    }
    @Override
    public Integer getAddr(Integer addr) {
        if (addr < 0 || addr >= memoria.size()){
            throw new FueraDeRangoException("No se puede acceder a una direccion de memoria fuera de rango");
        }
        return memoria.get(addr);
    }
    @Override
    public void reset() {
        acumuladorA = 0;
        acumuladorA = 0;
        programCounter = 0;
    }
    @Override
    public Programable copiar() {
        Microcontrolador auxiliar = new Microcontrolador(acumuladorA, acumuladorB, programCounter);
        return auxiliar;
    }
    @Override
    public void copiarDesde(Programable microRespaldo) {
        this.setAcumuladorA(microRespaldo.getAcumuladorA());
        this.setAcumuladorB(microRespaldo.getAcumuladorB());
        this.programCounter = microRespaldo.getProgramCounter();
    }
}
