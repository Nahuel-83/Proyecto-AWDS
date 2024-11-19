package bbbt05e03.bbbt05e03;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class FormInfo {

    private Integer votoSPM1 = 0;
    private Integer votoSPM2 = 0;
    private Integer votoSPM3 = 0;
    private Set<String> emails = new HashSet<>();

    public Integer getVotoSPM1() {
        return votoSPM1;
    }

    public void setVotoSPM1(Integer votoSPM1) {
        this.votoSPM1 = votoSPM1;
    }

    public Integer getVotoSPM2() {
        return votoSPM2;
    }

    public void setVotoSPM2(Integer votoSPM2) {
        this.votoSPM2 = votoSPM2;
    }

    public Integer getVotoSPM3() {
        return votoSPM3;
    }

    public void setVotoSPM3(Integer votoSPM3) {
        this.votoSPM3 = votoSPM3;
    }

    public Set<String> getEmails() {
        return emails;
    }

    public void setEmails(Set<String> emails) {
        this.emails = emails;
    }
}