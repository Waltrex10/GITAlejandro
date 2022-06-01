package ejemplos_excepciones.excepciones_propias;

public class ValoresNoValidos01
{
  // ...
  public void valorCero(int a) throws EValorNoValido
  {
    // ...
    if (a == 0)
      throw new EValorNoValido("Error: valor cero");
    
    // ...
  }
  // ...
}
