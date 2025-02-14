package e01.e01.service;

import e01.e01.domain.Empleado;
import e01.e01.repository.EmpleadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmpleadoServiceImpl implements EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    @Override
    public Page<Empleado> obtenerTodos(Pageable pageable) {
        return empleadoRepository.findAll(pageable);
    }
}