package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;

public class VooDireto extends Voo {
    private Rota rota;

    public VooDireto(Rota rota, LocalDateTime dh) {
        super(dh);
        this.rota = rota;
    }

    public Rota getRota() {
        return this.rota;
    }
    
    @Override
    public String toString() {
       return super.toString() + " -> " + rota;
    }

    @Override
    public Duration getDuracao() {
        double distancia = Geo.distancia(this.rota.getOrigem().getLocal(), this.rota.getDestino().getLocal());

        int durationMinutes = (int)( (distancia / 805) * 60 );

        durationMinutes += 30;

        return Duration.ofMinutes( durationMinutes );
    }

}