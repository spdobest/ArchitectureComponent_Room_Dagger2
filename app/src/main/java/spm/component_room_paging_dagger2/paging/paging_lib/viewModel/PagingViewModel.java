package spm.component_room_paging_dagger2.paging.paging_lib.viewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.OnLifecycleEvent;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.PagedList;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;
import spm.component_room_paging_dagger2.paging.dto.Movie;
import spm.component_room_paging_dagger2.paging.paging_lib.interactor.MovieInteractor;

public class PagingViewModel extends AndroidViewModel {

    private static final String TAG = "CountryViewModel";

    private LiveData<List<Movie>> countryList = new MutableLiveData<>();

    // create livedata country list
    private LiveData<List<Movie>> livedataCountryList;

    public PagingViewModel(@NonNull Application application) {
        super(application);

    }

    public LiveData<List<Movie>> getMoviesListObservable() {
        if(livedataCountryList==null){
            countryList = MovieInteractor.getInstance().getMovieList();
        }
        return countryList;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    void any() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void stop() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void onCreate() {
        Log.i(TAG, "onCreate: ");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    void onStart() {
        Log.i(TAG, "onStart: ");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void onStop() {
        Log.i(TAG, "onStop: ");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    void onPause() {
        Log.i(TAG, "onPause: ");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    void onResume() {
        Log.i(TAG, "onResume: ");
    }
}