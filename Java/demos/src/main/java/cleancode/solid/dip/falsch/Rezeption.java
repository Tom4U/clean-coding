package cleancode.solid.dip.falsch;

import java.util.List;
import java.util.Optional;

public class Rezeption {
    private final StandardReservierungenDao reservierungenDao = new StandardReservierungenDao();

    public Optional<Reservierung> perIdFinden(int id) {
        return reservierungenDao.perIdFinden(id);
    }

    public List<Reservierung> alleFinden() {
        return reservierungenDao.alleFinden();
    }
}
