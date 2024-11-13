package cleancode.solid.dip.richtig;

import java.util.List;
import java.util.Optional;

public class Rezeption {
    private final ReservierungenDao reservierungenDao;

    public Rezeption(ReservierungenDao reservierungenDao) {
        this.reservierungenDao = reservierungenDao;
    }

    public Optional<Reservierung> perIdFinden(int id) {
        return reservierungenDao.perIdFinden(id);
    }

    public List<Reservierung> alleFinden() {
        return reservierungenDao.alleFinden();
    }
}
