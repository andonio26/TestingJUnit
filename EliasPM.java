package METODOS_EPM;

public class EliasPM {
	
	/**
	 * 
	 * @param cadena Cadena que vamos a encriptar
	 * @param nRot Numero de rotaciones que queremos dar a cada caracter
	 * @return La cadena encriptada en el numero de rot especificado
	 * 
	 */
    public String rotN(String cadena, int nRot)
    {
        String result = "";
        for (int i = 0; i < cadena.length(); i++)
        {
            char c = cadena.charAt(i);

            if (c >= 'a' && c <= 'z')
                result += (char) ('a' + (c - 'a' + nRot) % 26);
            else if (c >= 'A' && c <= 'Z')
                result += (char) ('A' + (c - 'A' + nRot) % 26);
            else
                result += c;
        }
        return result;
    }

    
    /**
     * Invierte mayúsculas por minúsculas y minúsculas por mayúsculas
     * @param cadena Cadena de texto a invertir
     * @return La cadena con las mayúsculas y minúsculas invertidas
     */
    public String invertUpperLower(String cadena)
    {
        String result = "";
        for (int i = 0; i < cadena.length(); i++)
        {
            char c = cadena.charAt(i);

            if (c >= 'a' && c <= 'z') 
                result += Character.toUpperCase(c);
            else if (c >= 'A' && c <= 'Z')
                result += Character.toLowerCase(c);
            else
                result += c;
        }
        return result;
    }

    
    /**
     * Revierte el orden de los caracteres en una cadena.
     * @param cadena Cadena de texto a revertir.
     * @return La cadena con los caracteres en orden inverso.
     */
    public String revertString (String cadena)
    {
        String result = "";
        for (int i = cadena.length() - 1; i >= 0; i--)
            result += cadena.charAt(i);
        return result;
    }
}
