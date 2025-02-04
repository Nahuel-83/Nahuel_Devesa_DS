package e04.e04.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Component
public class Tarifas {
    @Value("${tarifaConsulta}")
    private Double tarifaConsulta;

    @Value("${tarifaReceta}")
    private Double tarifaReceta;

    @Value("${tarifaRevisionAdulto}")
    private Double tarifaRevisionAdulto;

    @Value("${tarifaRevisionJubilado}")
    private Double tarifaRevisionJubilado;
}
