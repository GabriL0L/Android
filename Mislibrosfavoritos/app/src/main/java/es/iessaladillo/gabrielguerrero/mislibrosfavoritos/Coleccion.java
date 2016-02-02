package es.iessaladillo.gabrielguerrero.mislibrosfavoritos;

import java.util.ArrayList;

/**
 * Created by Usuario on 11/12/2015.
 */
public class Coleccion {

    private static ArrayList<Libro> libros;

    static{
        libros = new ArrayList();
        libros.add(new Libro("Ofrenda a la tormenta","Dolores Redondo","2014","http://image.casadellibro.com/a/l/t0/88/9788423348688.jpg","El esperadísimo final de la Trilogía del Baztán, un éxito que ya ha cautivado a más de 200.000 lectores. Nunca lo habrías imaginado. Una mujer denuncia que la muerte súbita de su nieta, oficialmente una muerte de cuna, le parece sospechosa tras el comportamiento extraño del padre de la niña, que ha sido detenido cuando i ntentaba robar el cadáver pronunciando palabras inconexas acerca de entregar a su propia hija. El bebé tiene unas marcas rojizas en el rostro que indican que ha habido presión y parece claro que ha sido asesinada. La abuela de la pequeña habla de una criatura mágica de la zona, un ser maléfico, causante de las pesadillas que producen en el durmiente una inmovilización que les impide despertar. Se trata del inguma, el ser que arrebata la vida durante el sueño. La investigación de este caso llevará a Amaia y a su equipo a descubrir algunas irregularidades en casos parecidos que se produjeron en el valle en el pasado, demasiados casos en una zona relativamente pequeña. Y entonces, trasladado por orden del juez Marquina, el asesino Berasategui aparece muerto en su celda, tras un coma inducido por una droga que alguien ha tenido que facilitarle. Trepidante y estremecedora, la trama se acelera hacia una resolución sorprendente, en la que Amaia debe enfrentarse al auténtico origen de los sucesos que han asolado el valle del Baztán. Y mientras una impresionante tormenta de nieve parece querer sepultar una verdad demoledora."));
        libros.add(new Libro("El impostor","Javier Cercas","2012","http://image.casadellibro.com/a/l/t0/23/9788439729723.jpg","He aquí una fascinante novela sin ficción saturada de ficción; la ficción no la pone el autor: la pone Enric Marco. ¿Quién es Enric Marco? Un nonagenario barcelonés que se hizo pasar por superviviente de los campos nazis y que fue desenmascarado en mayo de 2005, después de presidir durante tres años la asociación española de los supervivientes, pronunciar centenares de conferencias, conceder decenas de entrevistas, recibir importantes distinciones y conmover en algún caso hasta las lágrimas a los parlamentarios españoles reunidos para rendir homenaje por vez primera a los republicanos deportados por el III Reich. El caso dio la vuelta al mundo y convirtió a Marco en el gran impostor y el gran maldito. Ahora, casi una década más tarde, Javier Cercas asedia, en este thriller hipnótico que es también un banquete con muchos platos -narración, crónica, ensayo, biografía y autobiografía-, el enigma del personaje, su verdad y sus falsedades y, a través de esa indagación que recorre casi un siglo de historia de España, bucea con una pasión de kamikaze y una honestidad desgarradora en lo más profundo de nosotros mismos: en nuestra infinita capacidad de autoengaño, en nuestro conformismo y nuestras mentiras, en nuestra sed insaciable de afecto, en nuestras necesidades contrapuestas de ficción y de realidad, en las zonas"));
        libros.add(new Libro("El umbral de la eternidad","Ken Follet","2013","http://image.casadellibro.com/a/l/t0/96/9788401342196.jpg","Después de La caída de los gigantes y El invierno del mundo llega el final de la gran historia de las cinco familias cuyas vidas se han entrelazado a través del siglo XX. En el año 1961 Rebecca Hoffman, profesora en Alemania del Este y nieta de lady Maud, descubrirá que la policía secreta está vigilándola mientras su herma no menor, Walli, sueña con huir a Occidente para convertirse en músico de rock. George Jakes, joven abogado que trabaja con los hermanos Kennedy, es un activista del movimiento por los derechos civiles de los negros en Estados Unidos que participará en las protestas de los estados del Sur y en la marcha sobre Washington liderada por Martin Luther King. En Rusia las inclinaciones políticas enfrentan a los hermanos Tania y Dimka Dvorkin. Este se convierte en una de las jóvenes promesas del Kremlin mientras su hermana entrará a formar parte de un grupo activista que promueve la insurrección. Desde el sur de Estados Unidos hasta la remota Siberia, desde la isla de Cuba hasta el vibrante Londres de los años sesenta, El umbral de la eternidad es la historia de aquellas personas que lucharon por la libertad individual en medio del conflicto titánico entre los dos países más poderosos jamás conocidos."));
    }

    public static void anadirLibro(Libro libro){
        libros.add(libro);
    }

    public static Libro getLibro(int posicion){
        return libros.get(posicion);
    }

    public static void borrarLibro(Libro libro){
        libros.remove(libro);
    }

    public static ArrayList<Libro> obtenerColeccion(){
        return libros;
    }

}
