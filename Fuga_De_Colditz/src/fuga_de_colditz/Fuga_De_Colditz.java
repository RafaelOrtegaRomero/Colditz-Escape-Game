//JUGADOR PHILIPS JONES, UNIFORME 3, ID:354612087, POS: FILA 5 COL 5, Nº CENTINELAS=10
//Realizado por Rafael Ortega Romero
package fuga_de_colditz;

import java.util.Arrays;
import java.util.Scanner;


public class Fuga_De_Colditz {
    //elegimos fila aleatoria para centinela
           public static int elegir_fila(){
        int fila=(int)(Math.random()*10);
        return fila;
   }
   //elegimos columna aleatoria para centinela
    public static int elegir_columna(){
        int columna=(int)(Math.random()*10);
        return columna;
   }
    //rellena espacios en el tablero con x y posiciones fijas
    public static void rellenar(char [][]tablero_jugable_x){
      for(int i=0;i<tablero_jugable_x.length;i++){
                for(int j=0;j<tablero_jugable_x.length;j++){
                    
                    tablero_jugable_x[i][j]='x';
            
                }
        }
       
       tablero_jugable_x[0][3]='p';
       tablero_jugable_x[0][4]='p';
       tablero_jugable_x[0][5]='p';
       tablero_jugable_x[4][9]='u';
       tablero_jugable_x[5][9]='u';
       tablero_jugable_x[6][9]='u';
       tablero_jugable_x[9][3]='a';
       tablero_jugable_x[9][4]='a';
       tablero_jugable_x[9][5]='a';
       
       tablero_jugable_x[5][5]='J';
    
    }
    //rellenamos los centinelas en posiciones aleatorias
    public static void rellenar_centinelas(char [][]tablero){
        
        int fila, columna;
        
        for(int i=0;i<10;i++){
        fila=elegir_fila();
        columna=elegir_columna();
        
        if(tablero[fila][columna]=='x'){
        
                tablero[fila][columna]='c';
            
            }else{
                i=i-1;
            }
        }
        
        
    }
    //recorre un array de int (pasaporte)
public static void recorrer_array(int[]array){
            for(int i=0;i<array.length;i++){
            System.out.print(array[i]);
        }
            System.out.println("\n");
    }
    //recorre la matriz principal char
public static void recorrer_array_char(char[][]array){
         
    System.out.println("Mostrando array...");
            for(int i=0;i<array.length;i++){
                for(int j=0;j<array.length;j++){
                    
            System.out.print(array[i][j]+"  ");
            
                }
                System.out.print("\n");
        }
            
    }
//si encuentras el pasaporte
public static boolean Pasaporte(){
    boolean pas=true;
     int [] codigo={3,5,4,6,1,2,0,8,7};
    System.out.print(" Necesito un pasaporte, aunque parece que tengo que ordenar una especie de codigo... ");
    
    recorrer_array(codigo);
    
    System.out.print( " Ya lo tengo, ¡hay que ordenarlo!, si lo ordeno sería... ");
    
    Arrays.sort(codigo);
    
    recorrer_array(codigo);
    
    System.out.println("Pasaporte conseguido...");
    
return pas;
}
//si encuentras el uniforme
public static boolean Uniforme(){
Scanner scan=new Scanner(System.in);
    boolean uniforme=false;
    int numero;
    
    System.out.println(" Vaya parece que aquí hay uniformes que puedo usar, cual me estará bien? (elegir un numero  del 1 al 3) ");
    numero=scan.nextInt();
    //si seleccionamos el 3 nos dara el uniforme y saldremos de aquí, no se pierden intentos
    while(uniforme==false){
    switch(numero){
        case 1:
            System.out.println(" Parece que este no me cabe, ¿cual deberia revisar ahora? (1,2 o 3) ");
            numero=scan.nextInt();
            break;
        case 2:
            System.out.println(" Parece que este no me cabe, ¿cual deberia revisar ahora? (1,2 o 3) ");
            numero=scan.nextInt();
            break;
        case 3:
            
             System.out.println("Parece que aqui hay un uniforme y me cabe, tiene: gafas, abrigo y pantalon pinza, lo usaré");
            uniforme=true;
         break;
    }
    
    }
    
    System.out.println("Uniforme conseguido...");
    
return uniforme;
}
//si encuentro los alicates
public static boolean Alicates(int intentos){
Scanner scan=new Scanner(System.in);
int numero;
boolean ganar=false;

System.out.println("Para conseguir los alicates debo jugar a piedra papel tijeras con uno de los centinelas... ¿que deberia de usar? (1:piedra, 2:papel, 3:tijera)");
   numero=scan.nextInt();
   //jugamos piedra papel tijeras, el centinela elige aleatoriamente que hará, se pierden intentos cada vez que perdamos
while(ganar==false && intentos>0){
    
    int centinela=(int)(Math.random()*3)+1;
    
    if((numero==1 && centinela==3) || (numero==2 && centinela==1) ||(numero==3 && centinela==2)){
    
        System.out.println("¡Gane y consegui los alicates!");
        ganar=true;
        
    }else{
        
        intentos=intentos-1;
        System.out.println("Mierda perdí, pero puedo volver a intentarlo "+intentos+" veces, que deberia de usar ahora (1:piedra,2:papel,3:tijera)");
        numero=scan.nextInt();
    }
    
}
    
return ganar;
}

/*public static void fase_mover(int filaJ, int columnaJ, char[][]tablero,int intentos, boolean Pasaporte, boolean Uniforme, boolean Alicates,int movimiento){

switch(tablero[filaJ][columnaJ]){
                    
                    case'c':
                        System.out.println("Mierda me pillo un centinela, he perdido...");
                          intentos=0;
                          movimiento=0;
                          
                    break;
                    case 'p':
                        if(Pasaporte==false){
                        Pasaporte=Pasaporte();}
                    break;
                    case 'u':
                        if(Uniforme==false){
                       Uniforme=Uniforme();}
                    break;
                    case 'a':
                        if(Alicates==false){
                        Alicates=Alicates(intentos);}
                   break;
                   case'x':
                       System.out.println("Parece que aqui no hay nada, seguire moviendome");
                   break;
                   case'J':
                       System.out.println("Ya estuve aquí y no habia nada");
                   break;
                           }
}*/

// juego principal
public static void Juego(char [][] tablero, char [][] tablero_jugable_x){
Scanner scan=new Scanner(System.in);

int intentos=10;
boolean Pasaporte=false, Alicates=false, Uniforme=false;
boolean ganador=false;
char mover;
int filaJ=5, columnaJ=5;

 System.out.println("Debo escapar... más me vale empezar a moverme...");
 
 while(intentos>0 && ganador==false){
     //mostramos el tablero que vera el jugador
 recorrer_array_char(tablero_jugable_x);
 
 System.out.println("Tirando dado...");
 //tiramos el dado para que el jugador se mueva
  int movimiento=(int)(Math.random()*6)+1;
  //realizamos el movimiento
  while(movimiento>0){
      //elegimos hacia donde nos movemos
   System.out.println("Puedo moverme "+movimiento+" veces,¿hacia donde debería? (a:arriba, b:abajo, c:izquierda, d:derecha)");
    mover=scan.next().charAt(0);
   
    //secgun que nos encontremos podemos, o que no pase nada, que intentemos obtener uno de los elementos para ganar o que nos pillen
   switch(mover){
        case 'a':
           filaJ= filaJ-1;
           columnaJ=columnaJ;
                    
                    //fase_mover(filaJ, columnaJ, tablero, intentos,  Pasaporte,  Uniforme,  Alicates,movimiento);
                    switch(tablero[filaJ][columnaJ]){
                    
                    case'c':
                        System.out.println("Mierda me pillo un centinela, he perdido...");
                          intentos=0;
                          movimiento=0;
                          
                    break;
                    case 'p':
                        if(Pasaporte==false){
                        Pasaporte=Pasaporte();}
                    break;
                    case 'u':
                        if(Uniforme==false){
                       Uniforme=Uniforme();}
                    break;
                    case 'a':
                        if(Alicates==false){
                        Alicates=Alicates(intentos);}
                   break;
                   case'x':
                       System.out.println("Parece que aqui no hay nada");
                   break;
                   case'J':
                       System.out.println("Ya estuve aquí y no habia nada");
                   break;
                           }
            movimiento=movimiento-1;
           
            break;
        case 'b':
            filaJ= filaJ+1;
           columnaJ=columnaJ;
            
             // fase_mover(filaJ, columnaJ, tablero, intentos,  Pasaporte,  Uniforme,  Alicates,movimiento);
           switch(tablero[filaJ][columnaJ]){
                    
                    case'c':
                        System.out.println("Mierda me pillo un centinela, he perdido...");
                          intentos=0;
                          movimiento=0;
                          
                    break;
                    case 'p':
                        if(Pasaporte==false){
                        Pasaporte=Pasaporte();}
                    break;
                    case 'u':
                        if(Uniforme==false){
                       Uniforme=Uniforme();}
                    break;
                    case 'a':
                        if(Alicates==false){
                        Alicates=Alicates(intentos);}
                   break;
                   case'x':
                       System.out.println("Parece que aqui no hay nada");
                   break;
                   case'J':
                       System.out.println("Ya estuve aquí y no habia nada");
                   break;
                           }
            movimiento=movimiento-1;
            
            break;
        case 'c':
            filaJ= filaJ;
           columnaJ=columnaJ-1;
           
           //   fase_mover(filaJ, columnaJ, tablero, intentos,  Pasaporte,  Uniforme,  Alicates,movimiento);
           switch(tablero[filaJ][columnaJ]){
                    
                    case'c':
                        System.out.println("Mierda me pillo un centinela, he perdido...");
                          intentos=0;
                          movimiento=0;
                          
                    break;
                    case 'p':
                        if(Pasaporte==false){
                        Pasaporte=Pasaporte();}
                    break;
                    case 'u':
                        if(Uniforme==false){
                       Uniforme=Uniforme();}
                    break;
                    case 'a':
                        if(Alicates==false){
                        Alicates=Alicates(intentos);}
                   break;
                   case'x':
                       System.out.println("Parece que aqui no hay nada");
                   break;
                   case'J':
                       System.out.println("Ya estuve aquí y no habia nada");
                   break;
                           }
             movimiento=movimiento-1;
            
         break;
         case 'd':
            filaJ= filaJ;
           columnaJ=columnaJ+1;
           
            //  fase_mover(filaJ, columnaJ, tablero, intentos,  Pasaporte,  Uniforme,  Alicates,movimiento);
           switch(tablero[filaJ][columnaJ]){
                    
                    case'c':
                        System.out.println("Mierda me pillo un centinela, he perdido...");
                          intentos=0;
                          movimiento=0;
                          
                    break;
                    case 'p':
                        if(Pasaporte==false){
                        Pasaporte=Pasaporte();}
                    break;
                    case 'u':
                        if(Uniforme==false){
                       Uniforme=Uniforme();}
                    break;
                    case 'a':
                        if(Alicates==false){
                        Alicates=Alicates(intentos);}
                   break;
                   case'x':
                       System.out.println("Parece que aqui no hay nada");
                   break;
                   case'J':
                       System.out.println("Ya estuve aquí y no habia nada");
                   break;
                           }
             movimiento=movimiento-1;
            
         break;
    }
     //si lo tenemos todo hemos ganado
   if(Pasaporte==true && Alicates==true && Uniforme==true){
       System.out.println("He podido escapar (ganaste)");
       ganador=true;
       intentos=0;
       movimiento=0;
   }
  }
  //guardamos una J en la nueva pos en la que nos encontramos
   tablero_jugable_x[filaJ][columnaJ]='J';
    intentos=intentos-1;
    
  
   
 }
 if(intentos==0){
 System.out.println("Parece que no puedo moverme más... perdi...(Te quedaste sin intentos) ");
 }
 
 
}


    public static void main(String[] args) {
        
         char [][] tablero=new char[10][10]; 
       char [][] tablero_jugable_x=new char[10][10];
       
       //rellenamos con x y con las posiciones fijas
        rellenar(tablero_jugable_x);
        
        rellenar(tablero);
        
        //rellenamos con los centinelas
        rellenar_centinelas(tablero);
        
      //  recorrer_array_char(tablero_jugable_x);
      //  recorrer_array_char(tablero);
    
       Juego(tablero,tablero_jugable_x);
    }
    
}
