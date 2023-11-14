package es.uah.patronescomportamiento.Interpreter;

import java.util.StringTokenizer;

/**
 * Interpreta una expresión introducida por el cliente.
 *
 * @author Salvador Oton
 */
public class InterpreteCliente {

    // Referencia al contexto.
    Contexto contexto;

    /**
     * Constructor
     *
     * @param contexto
     */
    public InterpreteCliente(Contexto contexto) {
        this.contexto = contexto;
    }

    /**
     * Interpreta la expresion introducida por el cliente
     *
     * @param expresion Expresión a interpretar.
     */
    public void interpreta(String expresion) {
        String tokenActual;
        StringTokenizer tokens = new StringTokenizer(expresion);

        char mostrar = ' ';         //que hay que mostar?
        char mostrarPor = ' ';      //por que criterio hay que ordenarlo?
        boolean usaPor = false;     //hay que ordenarlo por algo?

        while (tokens.hasMoreTokens()) //analizamos la cadena expresión
        {
            tokenActual = tokens.nextToken();
            switch (tokenActual) {
                //seguimos analizando más elementos...
                case "muestra":
                    //en el caso de que el elemento de la orden sea muestra
                    continue;
                //si el elemento es empresas
                //lo mismo que antes para empleados
                case "empresas":
                    if (mostrar == ' ') //y mostrar no esta inicializado
                    {
                        mostrar = 'E';
                    } //lo inicializamos a E (de empresa)
                    else //si ya estaba inicalizado
                    {    //si utiliza por y mostrarPor no esta inicalizado
                        if ((mostrarPor == ' ') && (usaPor)) {
                            mostrarPor = 'E';
                        } //lo inicializamos a E
                    }   break;
                //si no es empresa
                //si el elemento es por actualizamos usaPor
                case "empleados":
                    if (mostrar == ' ') //y mostrar no esta inicializado
                    {
                        mostrar = 'T';
                    } //lo inicializamos a T (trabajador)
                    else {//si utiliza Por y no esta inicializado
                        if ((mostrarPor == ' ') && (usaPor)) {
                            mostrarPor = 'T';
                        } //lo inicializamos a T
                    }   break;
                case "por":
                    usaPor = true;
                    break;
                default:
                    break;
            }

        }//while

        Interprete interprete = null;//declaramos un interprete

        switch (mostrar) {
            case 'T': //si es mostrar empleado
            {
                switch (mostrarPor) //y ademas por empresa
                {
                    case 'E': {	//invocamos un InterpreteEmpleado
                        interprete = new InterpreteEmpleadoEmpresa();
                        break;
                    }
                    default: {//sino es que no utliliza por y se invoca un InterpreteEmpleado
                        interprete = new InterpreteEmpleado();
                        break;
                    }
                }
                break;
            }
            case 'E': //si es mostrar empresa
            {
                switch (mostrarPor) //y además por empleado
                {
                    case 'T': {   //InterpreteEmpresaEmpleado
                        interprete = new InterpreteEmpresaEmpleado();
                        break;
                    }
                    default: {   //sino InterpreteEmpresa
                        interprete = new InterpreteEmpresa();
                        break;
                    }
                }
                break;
            }

        }
        //interpretamos con el interprete que sea
        interprete.interpretar(contexto);
    }
}
