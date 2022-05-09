package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class VooVariasEscalas extends Voo {
    private ArrayList<Rota> escalas;

    public VooVariasEscalas(Rota rota, LocalDateTime datahora, Duration duracao, ArrayList<Rota> escalas) {
        super(rota, datahora, duracao);
        this.escalas = escalas;
    }

    public ArrayList<Rota> getEscalas() {
        return escalas;
    }
    
    @Override
    public String toString() {
       return super.toString() + "\nEscalas: " + escalas;
    }
    
}
