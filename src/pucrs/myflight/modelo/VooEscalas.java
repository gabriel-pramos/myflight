package pucrs.myflight.modelo;

import java.time.Duration;
import java.time.LocalDateTime;

public class VooEscalas extends Voo {
    private Rota rotaFinal;

    // Construtor
    public VooEscalas(Rota rota, Rota rotaFinal, LocalDateTime dh, Duration dur) {
        super(rota, dh, dur);
        this.rotaFinal = rotaFinal;
    }

    public Rota getRotaFinal() {
        return this.rotaFinal;
    }
    
    @Override
    public String toString() {
       return super.toString() + " -> " + rotaFinal;
    }

}
