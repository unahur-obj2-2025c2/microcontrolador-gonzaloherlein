package ar.unahur.edu.obj2.patroncommand;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.unahur.edu.obj2.patroncommand.operaciones.Add;
import ar.unahur.edu.obj2.patroncommand.operaciones.Lod;
import ar.unahur.edu.obj2.patroncommand.operaciones.Lodv;
import ar.unahur.edu.obj2.patroncommand.operaciones.Nop;
import ar.unahur.edu.obj2.patroncommand.operaciones.Operable;
import ar.unahur.edu.obj2.patroncommand.operaciones.Str;
import ar.unahur.edu.obj2.patroncommand.operaciones.Swap;

public class Parte1Test {
    private Programable micro = new Microcontrolador(0, 0, 0);
    private Programa p = new Programa();

    @BeforeEach()
    void setUp(){
        p.vaciarLista();
        p.resetearMicro(micro);
    }

    @Test
    void testHacerAvanzar3PosicionesElPc() {
        Operable nop = new Nop();
        p.agregarOperaciones(nop);
        p.agregarOperaciones(nop);
        p.agregarOperaciones(nop);
        p.ejecutar(micro);
        assertEquals(3,micro.getProgramCounter());
    }

    @Test
    void testSumar20y17(){
        Operable lodv = new Lodv(20);
        Operable swap = new Swap();
        Operable lodv2 = new Lodv(17);
        Operable add = new Add();

        p.agregarOperaciones(lodv);
        p.agregarOperaciones(swap);
        p.agregarOperaciones(lodv2);
        p.agregarOperaciones(add);
        p.ejecutar(micro);

        assertEquals(37, micro.getAcumuladorA());
        assertEquals(0,micro.getAcumuladorB());
        assertEquals(4,micro.getProgramCounter());
    }

    @Test
    void testSumar2mas8mas5(){
        Operable lodv = new Lodv(2);
        Operable str = new Str(0);
        Operable lodv2 = new Lodv(8);
        Operable swap = new Swap();
        Operable lodv3 = new Lodv(5);
        Operable add = new Add();
        Operable swap2 = new Swap();
        Operable lod = new Lod(0);
        Operable add2 = new Add();

        p.agregarOperaciones(lodv);
        p.agregarOperaciones(str);
        p.agregarOperaciones(lodv2);
        p.agregarOperaciones(swap);
        p.agregarOperaciones(lodv3);
        p.agregarOperaciones(add);
        p.agregarOperaciones(swap2);
        p.agregarOperaciones(lod);
        p.agregarOperaciones(add2);
        p.ejecutar(micro);

        assertEquals(15,micro.getAcumuladorA());
        assertEquals(0, micro.getAcumuladorB());
    }
}
