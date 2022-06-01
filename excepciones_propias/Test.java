package ejemplos_excepciones.excepciones_propias;

public class Test
{
  public static void main(String[] args)
  {
    int x = 0;
    ValoresNoValidos01 obj = new ValoresNoValidos01();
    try
    {
      obj.valorCero(x);
    }
    catch (EValorNoValido e)
    {
      System.out.println(e.getMessage());
    }
    System.out.println("Continúa la ejecución");
  }
}
