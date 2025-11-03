package ar.unahur.edu.obj2.patroncommand.operaciones;

import ar.unahur.edu.obj2.patroncommand.Programable;

public abstract class Operacion implements Operable{

    private Programable microBackUp;

    @Override
    public void execute(Programable micro) {
        microBackUp = micro.copiar();
        this.doExecute(micro);
        micro.incProgramCounter();
    }

    protected abstract void doExecute(Programable micro);

    @Override
    public void undo(Programable micro) {
        micro.copiarDesde(microBackUp);
    }

    
}
