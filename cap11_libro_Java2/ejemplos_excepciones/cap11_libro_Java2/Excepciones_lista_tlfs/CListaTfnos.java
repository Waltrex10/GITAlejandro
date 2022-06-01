package ejemplos_excepciones.cap11_libro_Java2.Excepciones_lista_tlfs;

/////////////////////////////////////////////////////////////////
// Definici�n de la clase CListaTfnos.
//
public class CListaTfnos
{
  private CPersona[] listaTelefonos; // matriz de objetos
  private int nElementos; // numero de elementos de la matriz
  
  private CPersona[] asignarMemoria(int nElementos)
  {
    try
    {
      return new CPersona[nElementos];
    }
    catch (OutOfMemoryError e)
    {
      System.out.println(e.getMessage());
      return listaTelefonos;
    }
  }
  
  public CListaTfnos()
  {
    // Crear una lista vac�a
    nElementos = 0;
    listaTelefonos = asignarMemoria(nElementos);
  }
  
  private void unElementoMes(CPersona[] listaActual)
  {
    nElementos = listaActual.length;
    listaTelefonos = asignarMemoria(nElementos + 1);
    // Copiar la lista actual
    for ( int i = 0; i < nElementos; i++ )
      listaTelefonos[i] = listaActual[i];
    nElementos++;
  }
  
  private void unElementoMenos(CPersona[] listaActual)
  {
    if (listaActual.length == 0) return;
    int k = 0;
    nElementos = listaActual.length;
    listaTelefonos = asignarMemoria(nElementos - 1);
    // Copiar la lista actual
    for ( int i = 0; i < nElementos; i++ )
      if (listaActual[i] != null)
        listaTelefonos[k++] = listaActual[i];
    nElementos--;
  }
  
  public void ponerValorEn( int i, CPersona objeto )
  {
    if (i >= 0 && i < nElementos)
      listaTelefonos[i] = objeto;
    else
      System.out.println("�ndice fuera de l�mites");
  }
  
  public CPersona valorEn( int i )
  {
    if (i >= 0 && i < nElementos)
      return listaTelefonos[i];
    else
    {
      System.out.println("�ndice fuera de l�mites");
      return null;
    }
  }
  
  public int longitud() { return nElementos; }
  
  public void anadir(CPersona obj)
  {
    unElementoMes(listaTelefonos);
    ponerValorEn( nElementos - 1, obj );
  }
  
  public boolean eliminar(long tel)
  {
    // Buscar el telefono y eliminar registro
    for ( int i = 0; i < nElementos; i++ )
      if (listaTelefonos[i].obtenerTelefono() == tel)
      {
        listaTelefonos[i] = null;
        unElementoMenos(listaTelefonos);
        return true;
      }
    return false;
  }
  
  public int buscar(String str, int pos)
  {
    String nom;
    if (str == null) return -1;
    if (pos < 0) pos = 0;
    for ( int i = pos; i < nElementos; i++ )
    {
      nom = listaTelefonos[i].obtenerNombre();
      if (nom == null) continue;
      // estr este contenida en nom?
      if (nom.indexOf(str) > -1)
        return i;
    }
    return -1;
  }
}
