package spm.component_room_paging_dagger2.paging.paging_lib.interactor;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import spm.component_room_paging_dagger2.paging.dto.Movie;
import spm.component_room_paging_dagger2.paging.dto.MoviesResponse;
import spm.component_room_paging_dagger2.paging.paging_lib.network.RetrofitAPIInterface;

/**
 * Created by root on 7/20/18.
 */

public class MovieInteractor {

    private static final String TAG = "MovieInteractor";
    /**
     * Here we will do all the network call and send the data to viewModel
     *
     */

    private RetrofitAPIInterface retrofitAPIInterface;
    private static MovieInteractor MovieInteractor;

    private MovieInteractor() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/movie/550?api_key=b7eb389e9e6ad5e434077e4b6d83ad78")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofitAPIInterface = retrofit.create(RetrofitAPIInterface.class);
    }

    public synchronized static MovieInteractor getInstance() {
        if (MovieInteractor == null) {
            if (MovieInteractor == null) {
                MovieInteractor = new MovieInteractor();
            }
        }
        return MovieInteractor;
    }

    public LiveData<List<Movie>> getMovieList() {
        final MutableLiveData<List<Movie>> data = new MutableLiveData<>();

        retrofitAPIInterface.getMovies().enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                if(response!=null && response.body()!=null &&
                        response.body().getMovies()!=null &&
                        response.body().getMovies().size()>0
                        ){
                    data.setValue(response.body().getMovies());
                }
            }
            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
                Log.i(TAG, "onFailure: "+call.toString());
            }
            // Error handling will be explained in the next article …
        });
        Log.i(TAG, "on Return Value");
        return data;
    }
}
