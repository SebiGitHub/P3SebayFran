package model;

public enum Titular {
    TITULAR_1("Juan Pérez"),
    TITULAR_2("Ana López"),
    TITULAR_3("Carlos Martínez"),
    TITULAR_4("Lucía García"),
    TITULAR_5("Pedro Sánchez"),
    TITULAR_6("María Rodríguez"),
    TITULAR_7("José Fernández"),
    TITULAR_8("Elena Gómez"),
    TITULAR_9("Francisco Ruiz"),
    TITULAR_10("Marta Díaz"),
    TITULAR_11("Luis Herrera"),
    TITULAR_12("Sofía Ramírez"),
    TITULAR_13("Antonio Vargas"),
    TITULAR_14("Isabel Castro"),
    TITULAR_15("Javier Moreno"),
    TITULAR_16("Carmen López"),
    TITULAR_17("David Sánchez"),
    TITULAR_18("Raquel Torres"),
    TITULAR_19("Ricardo Martín"),
    TITULAR_20("Patricia Gómez");

    private final String nombre;

    Titular(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
