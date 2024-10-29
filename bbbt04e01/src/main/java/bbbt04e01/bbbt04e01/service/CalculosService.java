package bbbt04e01.bbbt04e01.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CalculosService {

    public boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
       
        for (int i = 2; i < numero; i++) {
            if (numero % i == 0) { 
                return false;
            }
        }
    
        return true;
    }

    public double calcularHipotenusa(double cateto1, double cateto2) {
        return Math.sqrt(Math.pow(cateto1, 2) + Math.pow(cateto2, 2));
    }

    public List<Integer> obtenerDivisores(int numero) {
        List<Integer> divisores = new ArrayList<>();
        for (int i = 1; i <= numero; i++) {
            if (numero % i == 0) {
                divisores.add(i);
            }
        }
        return divisores;
    }
    

}
