package bbbt04e01.bbbt04e01.service;

import java.util.List;

public interface CalculosService {

    public boolean esPrimo(int numero);

    public double calcularHipotenusa(double cateto1, double cateto2);

    public List<Integer> obtenerDivisores(int numero);

}
