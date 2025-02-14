package e09.e09.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import e09.e09.model.Equipo;
import e09.e09.model.Jornada;
import e09.e09.model.Partido;
import e09.e09.repository.EquipoRepository;
import e09.e09.repository.JornadaRepository;
import e09.e09.repository.PartidoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LigaServiceImpl implements LigaService {
    private final EquipoRepository equipoRepository;
    private final JornadaRepository jornadaRepository;
    private final PartidoRepository partidoRepository;

    private Random random = new Random(); // Inicializar el generador de números aleatorios

    @Override
    public List<Equipo> getClasificacion() {
        List<Equipo> equipos = equipoRepository.findAll();
        // Ordenar de menor a mayor por puntos, goles a favor y nombre
        equipos.sort(Comparator
                .comparingInt(Equipo::getPuntos) // Puntos de menor a mayor
                .thenComparingInt(Equipo::getGoles_favor) // Goles a favor de menor a mayor
                .thenComparing(Equipo::getNombre)); // Nombre de forma ascendente
        return equipos;
    }

    @Override
    public List<Jornada> getJornadas() {
        return jornadaRepository.findAll();
    }

    @Override
    public void simularJornada() {
        // Verificar si ya existen 38 jornadas
        long numJornadas = jornadaRepository.count();
        if (numJornadas >= 38) {
            throw new IllegalArgumentException("El máximo de 38 jornadas ya ha sido alcanzado. Reinicia la liga.");
        }

        // Cargar la lista de equipos del repositorio
        List<Equipo> equipos = equipoRepository.findAll();

        if (equipos.size() % 2 != 0) {
            throw new IllegalArgumentException("El número de equipos debe ser par para simular la jornada.");
        }

        // Dividir los equipos en dos listas: una para locales y otra para visitantes
        List<Equipo> locales = new ArrayList<>();
        List<Equipo> visitantes = new ArrayList<>();

        for (int i = 0; i < equipos.size(); i++) {
            if (i % 2 == 0) {
                locales.add(equipos.get(i)); // Equipos en posiciones pares
            } else {
                visitantes.add(equipos.get(i)); // Equipos en posiciones impares
            }
        }

        // Crear nueva jornada y actualizar su número
        Jornada jornada = new Jornada();
        jornada.actualizarNumeroJornada(jornadaRepository); // Actualizar número de jornada automáticamente
        jornadaRepository.save(jornada); // Guardar la jornada

        // Emparejar y simular los partidos
        for (int i = 0; i < locales.size(); i++) {
            Partido partido = new Partido();
            partido.setLocal(locales.get(i)); // Equipo local
            partido.setVisitante(visitantes.get(i)); // Equipo visitante

            // Simulación de goles aleatorios
            partido.setGolesLocal(random.nextInt(5)); // Goles aleatorios para el equipo local
            partido.setGolesVisitante(random.nextInt(5)); // Goles aleatorios para el equipo visitante

            // Actualizar estadísticas
            actualizarEstadisticas(partido);

            partido.setJornada(jornada);
            partidoRepository.save(partido); // Guardar el partido
        }
    }

    private void actualizarEstadisticas(Partido partido) {
        Equipo local = partido.getLocal();
        Equipo visitante = partido.getVisitante();

        local.setPartidos_jugados(local.getPartidos_jugados() + 1);
        visitante.setPartidos_jugados(visitante.getPartidos_jugados() + 1);

        local.setGoles_favor(local.getGoles_favor() + partido.getGolesLocal());
        local.setGoles_contra(local.getGoles_contra() + partido.getGolesVisitante());
        visitante.setGoles_favor(visitante.getGoles_favor() + partido.getGolesVisitante());
        visitante.setGoles_contra(visitante.getGoles_contra() + partido.getGolesLocal());

        if (partido.getGolesLocal() > partido.getGolesVisitante()) {
            local.setGanados(local.getGanados() + 1);
            local.setPuntos(local.getPuntos() + 3);
            visitante.setPerdidos(visitante.getPerdidos() + 1);
        } else if (partido.getGolesLocal() < partido.getGolesVisitante()) {
            visitante.setGanados(visitante.getGanados() + 1);
            visitante.setPuntos(visitante.getPuntos() + 3);
            local.setPerdidos(local.getPerdidos() + 1);
        } else {
            local.setEmpatados(local.getEmpatados() + 1);
            visitante.setEmpatados(visitante.getEmpatados() + 1);
            local.setPuntos(local.getPuntos() + 1);
            visitante.setPuntos(visitante.getPuntos() + 1);
        }

        equipoRepository.save(local);
        equipoRepository.save(visitante);
    }
}