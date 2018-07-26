package spm.component_room_paging_dagger2.paging.paging_lib;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import spm.component_room_paging_dagger2.R;
import spm.component_room_paging_dagger2.paging.dto.Movie;
import spm.component_room_paging_dagger2.paging.paging_lib.adapter.MyPagingAdapter;
import spm.component_room_paging_dagger2.paging.viewmodel.MovieViewModel;

public class PagingMainActivity extends AppCompatActivity {

    List<Movie> moviesList = new ArrayList<>();
    private MyPagingAdapter myPagingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paging);

        MovieViewModel viewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
        myPagingAdapter = new MyPagingAdapter();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.main_recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        viewModel.getMovies().observe(this, myPagingAdapter::submitList);

        recyclerView.setAdapter(myPagingAdapter);



        subscribeCountryList(viewModel);
    }

    private void subscribeCountryList(MovieViewModel countryViewModel) {
        countryViewModel.getMovies().observe(this, countryResults -> {
            if (countryResults != null) {
                myPagingAdapter.notifyDataSetChanged();
            }
        });
    }

    /*public static final DiffCallback<Movie> DIFF_CALLBACK = new DiffCallback<Movie>() {
        @Override
        public boolean areItemsTheSame(@NonNull Movie oldPokemon, @NonNull Movie newPokemon) {
            return oldPokemon.getId() == newPokemon.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Movie oldPokemon, @NonNull Movie newPokemon) {
            return oldPokemon.getOriginalTitle().equals(newPokemon.getOriginalTitle());
        }
    };*/

}