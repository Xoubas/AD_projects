/*
 * Autor: Pepe Calo
 * Realizado con fines educativos.
 * Puede modificarlo siempre que no lo haga con fines comerciales.
 */
package org.example;

/**
 *
 * @author pepecalo
 */
public class AppLigaBaloncesto {

    public static final String DEFAULT_ARCHIVO = "e:\\temp\\clasificacion.dat";

    /**
     * @param args argumentos desde la línea de órdenes
     */
    public static void main(String[] args) {

        //        // Inicio
        Equipo e1 = new Equipo("Real Madrid", 18, 5, 1920, 1695);
        Equipo e2 = new Equipo("FC Barcelona", 22, 2, 1785, 1585);
        Equipo e3 = new Equipo("Manresa", 15, 7, 1903, 1808);
        Equipo e4 = new Equipo("Valencia", 14, 8, 1834, 1760);
        Equipo e5 = new Equipo("Obradoiro", 23, 1, 2834, 1560);
        Equipo e6 = new Equipo("Obradoiro", 26, 1, 2834, 1560);
        
        /**
Real Madrid 4	4	0 374 311	63
Baskonia 4	3	1	346	320	26
Bàsquet Girona	4	3	1	353	333	20
UCAM Murcia	4	3	1	340	322	18
Valencia Basket	4	3	1	346	330	16
Barça	4	3	1	75	349	335	14
Surne Bilbao Basket	4	3	1	322	310	12
Joventut Badalona	4	3	1	329	319	10
Monbus Obradoiro	4	2	2	320	299	21
BAXI Manresa	4	2	2	350	351	-1
Dreamland Gran Canaria	4	2	2	312	338	-26
Unicaja	4	1	3	335	333	2
Río Breogán	4	1	3	314	328	-14
MoraBanc Andorra	4	1	3	310	329	-19
Lenovo Tenerife	4	1	3	317	353	-36
Casademont Zaragoza	4	1	3	317	354	-37
Coviran Granada	4	0	4	353	382	-29
Zunder Palencia	4	0	4	290	330	-40
         */

        // Creación e escritura:
        Clasificacion clasificacion = new Clasificacion();
        clasificacion.addEquipo(e1);
        clasificacion.addEquipo(e2);
        clasificacion.addEquipo(e3);
        clasificacion.addEquipo(e4);
        clasificacion.addEquipo(e5);
        clasificacion.addEquipo(e6);
        
  /*     ClasificacionDAO clasificacionDAO = new ClasificacionDAO();
       clasificacionDAO.saveToJSON(clasificacion);
       
       Clasificacion c = clasificacionDAO.getToJSON("E:\\clasificacion.json");
        System.out.println(c);*/
       
//        clasificacion.saveClasificion(DEFAULT_ARCHIVO); // Método instancia

//        Clasificacion.saveClasificion(DEFAULT_ARCHIVO, clasificacion); // estático
//
//       System.out.println(clasificacion);
//        Lectura
//        Clasificacion c2 = Clasificacion.loadClasificacion(DEFAULT_ARCHIVO);
//        System.out.println(c2);

    }

}
