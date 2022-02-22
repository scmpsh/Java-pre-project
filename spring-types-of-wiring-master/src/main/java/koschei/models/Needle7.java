package koschei.models;

import org.springframework.beans.factory.annotation.Autowired;

public class Needle7 {

    @Autowired
    private Deth8 deth8;

    public Needle7(Deth8 deth8) {
        this.deth8 = deth8;
    }

    @Override
    public String toString() {
        return ", смерть Кощея на игле :( " + "";
    }
}
