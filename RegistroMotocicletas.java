import java.util.*;

public class RegistroMotocicletas {
    private List<Motocicleta> lista = new ArrayList<>();

    public RegistroMotocicletas() {
        // 5 predefinidas
        lista.add(new Motocicleta("ABC-123", "Honda",   "CB125", 2020));
        lista.add(new Motocicleta("DEF-456", "Yamaha",  "YZF-R3", 2019));
        lista.add(new Motocicleta("GHI-789", "Suzuki",  "GSX-R6", 2021));
        lista.add(new Motocicleta("JKL-012", "Kawasaki","Ninja", 2022));
        lista.add(new Motocicleta("MNO-345", "Ducati",  "Monster", 2018));
    }

    // R1. Ingreso
    public void agregar(Motocicleta m) {
        lista.add(m);
    }

    // R2. Actualizar: buscar por placa y modificar campos
    public boolean actualizar(String placa, Motocicleta datos) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getPlaca().equalsIgnoreCase(placa)) {
                lista.set(i, datos);
                return true;
            }
        }
        return false;
    }

    // R3. Buscar por placa y devolver el objeto
    public Motocicleta buscar(String placa) {
        return lista.stream()
                .filter(m -> m.getPlaca().equalsIgnoreCase(placa))
                .findFirst().orElse(null);
    }

    // R3. Ordenar (alfabéticamente por marca+modelo)
    public List<Motocicleta> ordenarPorMarcaModelo() {
        List<Motocicleta> copia = new ArrayList<>(lista);
        copia.sort(Comparator.comparing(m -> (m.getMarca() + m.getModelo())));
        return copia;
    }

    public List<Motocicleta> getAll() {
        return Collections.unmodifiableList(lista);
    }
}