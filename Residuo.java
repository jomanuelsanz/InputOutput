public class Residuo {
    // Atributos
    private int id;
    private String nombre;
    private double nivel;
    private double pesoKg;
    private int diasAlmacenado;

    // Constructor con los atributos
    public Residuo (int id, String nombre, double nivel, double pesoKg, int diasAlmacenado){
        this.id = id; 
        this.nombre = nombre;
        this.nivel = nivel;
        this.pesoKg = pesoKg;
        this.diasAlmacenado = diasAlmacenado;
    }

    // Getters
    public int getId(){
        return id;
    }
    public String getNombre(){
        return nombre;
    }
    public double getNivel(){
        return nivel;
    }
    public double pesoKg(){
        return pesoKg;
    }
    public int diasAlmacenado(){
        return diasAlmacenado;
    }

    // Método que usa Math
    // Fórmula:
    // riesgo = nivel * MathAbs(pesoKg - diasAlmacenado)
    public double calcularRiesgo(){
        double diferencia = Math.abs(pesoKg - diasAlmacenado);
        double riesgo = nivel * diferencia;
        return riesgo;
    }

    // Método para generar informe
    public String generarInforme(){
        return "ID: " + id + 
        ", Nombre: " + nombre + 
        ", Nivel: " + nivel + 
        ", Peso: " + pesoKg + 
        ", Dias: " + diasAlmacenado + 
        ", Riesgo: " + calcularRiesgo();
        
    }

}