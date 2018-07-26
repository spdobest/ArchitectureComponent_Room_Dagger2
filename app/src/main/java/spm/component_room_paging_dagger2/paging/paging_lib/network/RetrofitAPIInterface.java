package spm.component_room_paging_dagger2.paging.paging_lib.network;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import spm.component_room_paging_dagger2.paging.dto.MoviesResponse;
import spm.component_room_paging_dagger2.paging.paging_lib.model.CountryResponse;

public interface RetrofitAPIInterface {


    @GET("all")
    Call<CountryResponse> getAllCountries();

    @GET("")
    Call<MoviesResponse> getMovies();

}