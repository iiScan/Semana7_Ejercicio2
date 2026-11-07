public class SistemaSeguridad {
    private String nombreSistema;
    private int intentosFallidos;

    public SistemaSeguridad(String nombreSistema) {
        this.nombreSistema = nombreSistema;
        this.intentosFallidos = 0;
    }

    public String getNombreSistema() {
        return nombreSistema;
    }

    public void setNombreSistema(String nombreSistema) {
        this.nombreSistema = nombreSistema;
    }

    public int getIntentosFallidos() {
        return intentosFallidos;
    }

    public void setIntentosFallidos(int intentosFallidos) {
        this.intentosFallidos = intentosFallidos;
    }

    public void registrarIntentoFallido() {
        this.intentosFallidos++;
    }

    public void reiniciarContador() {
        this.intentosFallidos = 0;
    }

    public void mostrarEstado() {
        if (this.intentosFallidos >= 3) {
            System.out.println("Sistema [" + nombreSistema + "] -> ESTADO: BLOQUEADO (" + intentosFallidos + " fallos)");
        } else {
            System.out.println("Sistema [" + nombreSistema + "] -> ESTADO: ACTIVO (" + intentosFallidos + " fallos)");
        }
    }
}