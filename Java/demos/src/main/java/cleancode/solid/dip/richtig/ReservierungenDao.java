package cleancode.solid.dip.richtig;

import java.util.List;
import java.util.Optional;

public interface ReservierungenDao {
    Optional<Reservierung> perIdFinden(int id);

    List<Reservierung> alleFinden();
}
