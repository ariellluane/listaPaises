package util;

import java.util.List;

import Model.Paises;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class HttpRetro {
    private static final String BASE_URL = "https://restcountries.eu/";

    //Inicializa Retrofit
    public static PaisesInterface getPaisesClient() {
        Retrofit restAdapter = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return restAdapter.create(PaisesInterface.class);
    }

    // Interface com métodos de requisicao
    public interface PaisesInterface {
        @GET("rest/v1/all")
        Call<List<Paises>> getPaises();
    }
}
