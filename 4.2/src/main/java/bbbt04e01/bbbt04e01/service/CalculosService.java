package bbbt04e01.bbbt04e01.service;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface CalculosService {

    public boolean esPrimo(int numero);

    public double calcularHipotenusa(double cateto1, double cateto2);

    public List<Integer> obtenerDivisores(int numero);

}
