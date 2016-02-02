package es.iessaladillo.gabrielguerrero.ej032_retrofit;

import android.app.Application;

import java.util.List;

import retrofit2.Call;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by Usuario on 28/01/2016.
 */
public class Instituto extends Application {
    private static final String BASE_URL = "http://10.0.3.2:3000/";
    private static InstitutoInterface servicio;

    public interface InstitutoInterface{
        @GET("alumnos")
        Call<List<Alumno>> listarAlumnos();
        @POST("alumnos")
        Call<Alumno> agregarAlumno(@Body Alumno alumno);
        @DELETE("alumnos/{id}")
        Call<Alumno> eliminarAlumno(@Path("id") Integer idAlumno);
        @PUT("alumnos/{id}")
        Call<Alumno> updateAlumno(@Path("id") Integer idAlumno,@Body Alumno nuevo);
    }

    @Override
    public void onCreate(){
        super.onCreate();

        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        servicio = retrofit.create(InstitutoInterface.class);
    }

    public static InstitutoInterface getServicio(){
        return servicio;
    }
}
