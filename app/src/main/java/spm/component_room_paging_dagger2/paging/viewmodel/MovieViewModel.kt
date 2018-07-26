package spm.component_room_paging_dagger2.paging.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.arch.paging.DataSource
import android.arch.paging.LivePagedListBuilder
import android.service.autofill.Dataset
import spm.component_room_paging_dagger2.paging.dao.MovieDao
import spm.component_room_paging_dagger2.paging.database.MovieDatabase
import spm.component_room_paging_dagger2.paging.dto.Movie

class MovieViewModel(val movieDao:MovieDao) : ViewModel() {
    val movies : LiveData<List<Movie>> = movieDao.loadAllMovies()



   /* init {
        val factory:DataSource.Factory = MovieDatabase.getInstance(getApp);
        movies = LivePagedListBuilder<factory,30>().bui
    }*/

}