package e04.e04.model;

import java.util.List;

import e04.e04.config.Tarifas;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class PacienteReceta extends Paciente {
    private List<String> listaMedicamentos;

    @Override
    public Double facturar(Tarifas tarifas) {
        return tarifas.getTarifaReceta() * listaMedicamentos.size();
    }
}
