package ejemplos_excepciones.cap11_libro_Java2.Crear_excepcion;

public class EValorNoValido extends Exception
{
  public EValorNoValido() {}
  public EValorNoValido(String mensaje)
  {
    super(mensaje);
  }
}
