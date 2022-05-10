package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class VooEscalas extends Voo {
    private ArrayList<Rota> rotas;

    // Construtor
    public VooEscalas(ArrayList<Rota> rotas, LocalDateTime dh) {
        super(dh);
        this.rotas = rotas;
    }

    public ArrayList<Rota> getRotas() {
        return this.rotas;
    }
    
    @Override
    public String toString() {
       return super.toString() + " -> " + rotas;
    }

    @Override
    public Rota getRota() {
        return null;
    }

    @Override
    public Duration getDuracao() {
        Duration dur = Duration.ofMinutes(0);

        for (Rota r: rotas) {
            double distancia = Geo.distancia(r.getOrigem().getLocal(), r.getDestino().getLocal());

            int durationMinutes = (int)( (distancia / 805) * 60 );

            durationMinutes += 30;

            dur = dur.plus( Duration.ofMinutes( durationMinutes ) );
        }

        return dur;
    }

}
