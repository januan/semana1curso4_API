package com.javiernunez.puppies.restAPI;

import com.javiernunez.puppies.restAPI.modelo.MascotaResponse;
import com.javiernunez.puppies.restAPI.modelo.UsuarioResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Javier Núñez on 26/06/2016.
 */
public interface EndPointsAPI {

    @GET(ConstantesRestAPI.URL_GET_INFO_USER)
    Call<UsuarioResponse> getDatosUsuario(@Query("q") String nomUsuario);

    @GET(ConstantesRestAPI.URL_GET_RECENT_MEDIA_USER)
    Call<MascotaResponse> getRecentMedia(@Path("userid") String userID);
}
