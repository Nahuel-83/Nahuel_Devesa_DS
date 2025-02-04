package e04.e04.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import e04.e04.config.Tarifas;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class PacienteRevision extends Paciente{
    private LocalDate fechaUltimaRevision;

    @Override
    public Double facturar(Tarifas tarifas) {
        long edad = ChronoUnit.YEARS.between(this.getFechaNacimiento(), LocalDate.now());
        if (edad <= 65) {
            return tarifas.getTarifaRevisionAdulto();
        } else{
            return tarifas.getTarifaRevisionJubilado();
        }
    }
}
