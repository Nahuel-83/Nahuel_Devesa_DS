package e04.e04.model;

import e04.e04.config.Tarifas;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class PacienteConsulta extends Paciente{
    private String motivoConsulta;

    @Override
    public Double facturar(Tarifas tarifas){
        return tarifas.getTarifaConsulta();
    }

}
