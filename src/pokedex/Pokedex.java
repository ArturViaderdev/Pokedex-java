package pokedex;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.Iterator;

/**
 *
 * @author arturv
 */
public class Pokedex {
    static ArrayList<String> lista = new ArrayList<String>();
    private static void fillpokedexauto()
    {
        if(lista.contains("Ratta") || lista.contains("Pikachu") || lista.contains("Nidorino") || lista.contains("Persian") || lista.contains("Windie"))
        {
            System.out.println("Ya existían pokemons de los que se quieren añadir.");
        }
        else
        {
            lista.add("Ratta");
            lista.add("Pikachu");
            lista.add("Nidorino");
            lista.add("Persian");
            lista.add("Windie");
            System.out.println("5 pokemons añadidos: Ratta, Pikachu, Nidorino, Persian y Windie.");
        }   
    }
    
    private static void addpokemon()
    {
        System.out.println("Introduce un pokemon.");
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            String pokemon=lector.readLine();
            if(lista.contains(pokemon))
            {
                System.out.println("El pokemon ya existía en la pokedex.");
            }
            else
            {
                lista.add(pokemon);
                System.out.println("Pokemon " + pokemon + " añadido a la pokedex.");
            } 
               
        }
        catch(Exception e){
          System.out.println("Error. Introduce un nombre.");
        }
        
    }
    
    private static void addpokemonatposition()
    {
        System.out.println("Introduce un pokemon.");
        int posicion;
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        Scanner entrada=new Scanner(System.in);
        try
        {
            String pokemon=lector.readLine();
            if(lista.contains(pokemon))
            {
                System.out.println("El pokemon ya existía en la pokedex.");
            }
            else
            {
                System.out.println("Introduce la posición donde quieres guardar el pokemon.");
                posicion = entrada.nextInt();
                if(posicion<=lista.size())
                {
                    lista.add(posicion, pokemon);
                    System.out.println("Pokemon " + pokemon + " añadido a la pokedex.");
                }
                else
                {
                    System.out.println("Error. Introduce un nombre y una posición válida menor o igual que la longitud de la lista que es " + lista.size());            
                }                  
            }              
        }
        catch(Exception e){
          System.out.println("Error.");
        }
    }
    
    private static void deletepokemon()
    {
        if(lista.size()>0)
        {
            System.out.println("Introduce un pokemon para eliminar.");
            BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
            try
            {
                String pokemon=lector.readLine();
                if(lista.contains(pokemon))
                {
                    lista.remove(pokemon);
                    System.out.println("Pokemon eliminado de la lista.");
                }
                else
                {
                    System.out.println("El pokemon introducido no existe.");
                }            
            }
            catch(Exception e){
                System.out.println("Error. Introduce un nombre.");
            }
        }
        else
        {
            System.out.println("No hay pokemons en la pokedex.");
        }  
    }
    
    private static void deletepokemonatposition()
    {
        if(lista.size()>0)
        {
            System.out.println("Introduce la posición del pokemon que deseas eliminar.");
            Scanner entrada=new Scanner(System.in);
            try
            {
                int posicion = entrada.nextInt();
                if(posicion<lista.size() && posicion>=0)
                {
                    lista.remove(posicion);
                    System.out.println("Pokemon de la posicion " + posicion + " eliminado.");
                }
                else
                {
                    System.out.println("Posición incorrecta, la lista es de " + lista.size() + " elementos.");
                }          
            }
            catch(Exception e){
                System.out.println("Error. Introduce una posición.");
            }
        }
        else
        {
            System.out.println("No hay pokemons en la pokedex.");
        }     
    }
    
    private static void findpokemon()
    {
        if(lista.size()>0)
        {
            System.out.println("Introduce el nombre del pokemon que quieres buscar.");
            BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
            try
            {
                String pokemon = lector.readLine();
                int posicion = lista.indexOf(pokemon);
                if(posicion!=-1)
                {
                    System.out.println("La posición del pokemon " + pokemon + " es " + posicion + ".");
                }
                else
                {
                    System.out.println("El pokemon no existe.");
                }
            }
            catch(Exception e){
                System.out.println("Error. Introduce un nombre.");
            }
        }
        else    
        {
            System.out.println("No hay pokemons en la pokedex.");
        }
        
    }
    
    private static void showallpokemon()
    {
        if(lista.size()>0)
        {
            for(String pokemon : lista)
            {
                System.out.println(pokemon);
            }
            System.out.println(" ");
            for(int cont=0;cont<lista.size();cont++)
            {
                System.out.println(lista.get(cont));
            }
            System.out.println(" ");
            Iterator itr = lista.iterator();
            while(itr.hasNext()){
                System.out.println(itr.next());
            }
        }
        else
        {
            System.out.println("No hay pokemons en la pokedex.");
        }
        
    }
    
    private static void getpokemonatposition()
    {
        if(lista.size()>0)
        {
            System.out.println("Introduce la posición del pokemon.");
            Scanner entrada=new Scanner(System.in);
            try
            {
                int posicion = entrada.nextInt();
                if(posicion<lista.size() && posicion>=0)
                {
                    String pokemon = lista.get(posicion);
                    System.out.println(pokemon);
                }
                else
                {
                    System.out.println("Posición incorrecta. La lista es de " + lista.size() + " elementos.");
                }
            }
            catch(Exception e)
            {
                System.out.println("Error. Introduce una posición.");
            }   
        }
        else
        {
            System.out.println("No hay pokemons en la pokedex.");
        }
    }
    
    private static void countpokemon()
    {
        System.out.println("El número de pokemons es " + lista.size() + ".");
    }
    
    private static void hackpokedex()
    {
        for(int cont=0;cont<lista.size();cont++)
        {
            lista.set(cont, "ditto");
        }
        if(lista.size()>0)
        {
            System.out.println("Todos los pokemons se llaman ditto.");
        }
        else
        {
            System.out.println("No se ha hecho nada porque no hay pokemons en la pokedex.");
        }
    }
    
    private static void erasepokedexinfo()
    {
        lista.clear();
        System.out.println("Toda la información de la pokedex ha sido eliminada.");
    }
    
    private static void menu()
    {
         int opcion;
        
        Scanner entrada=new Scanner(System.in);
        try{
            do
            {
                System.out.println("1-Fill pokedex auto");
                System.out.println("2-Add Pokemon");
                System.out.println("3-Add Pokemon at Position");
                System.out.println("4-Delete Pokemon");
                System.out.println("5-Delete pokemon at positon");
                System.out.println("6-Find pokemon");
                System.out.println("7-Show all pokemon");
                System.out.println("8-Get pokemon at positon");
                System.out.println("9-Count Pokemon");
                System.out.println("10-Hack pokedex");
                System.out.println("11-Erase Pokedex Info");
                System.out.println("12-Exit");
                opcion = entrada.nextInt();
                switch(opcion)
                {
                    case 1:
                        fillpokedexauto();
                        break;
                    case 2:
                        addpokemon();
                        break;
                    case 3:
                        addpokemonatposition();
                        break;
                    case 4:
                        deletepokemon();
                        break;
                    case 5:
                        deletepokemonatposition();
                        break;
                    case 6:
                        findpokemon();
                        break;
                    case 7:
                        showallpokemon();
                        break;
                    case 8:
                        getpokemonatposition();
                        break;
                    case 9:
                        countpokemon();
                        break;
                    case 10:
                        hackpokedex();
                        break;
                    case 11:
                        erasepokedexinfo();
                        break;
                    case 12:
                        break;
                    default:
                        System.out.println("Introduce un número del 1 al 12.");
                    
                }
            }while(opcion!=12);     
        }
        catch(Exception e){
          System.out.println("Error. Introduce números, no letras.");
          menu();
        }    
    }
    
    public static void main(String[] args) {
        menu();
    }  
}
