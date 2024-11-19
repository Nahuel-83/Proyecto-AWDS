package bbbt05e03.bbbt05e03.service;

import bbbt05e03.bbbt05e03.FormInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeliculasServiceImpl implements PeliculasService {

    @Autowired
    private FormInfo formInfo;

    @Override
    public boolean yaHaVotado(String email) {
        return formInfo.getEmails().contains(email);
    }

    @Override
    public boolean votarPelicula(String email, int idPelicula) {
        if (yaHaVotado(email)) {
            return false; // Se xa votou non rexistra o voto
        }

        formInfo.getEmails().add(email);

        switch (idPelicula) {
            case 1:
                formInfo.setVotoSPM1(formInfo.getVotoSPM1() + 1);
                break;
            case 2:
                formInfo.setVotoSPM2(formInfo.getVotoSPM2() + 1);
                break;
            case 3:
                formInfo.setVotoSPM3(formInfo.getVotoSPM3() + 1);
                break;
            default:
                return false;
        }
        return true;
    }

    @Override
    public FormInfo obtenerInfoVotos() {
        return formInfo;
    }
}
