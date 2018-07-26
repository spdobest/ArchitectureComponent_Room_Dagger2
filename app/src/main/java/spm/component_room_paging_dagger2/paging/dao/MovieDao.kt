package spm.component_room_paging_dagger2.paging.dao

import android.arch.lifecycle.LiveData
import android.arch.paging.DataSource
import android.arch.persistence.room.*
import spm.component_room_paging_dagger2.paging.dto.Movie


@Dao
interface MovieDao {

    @Query("SELECT * FROM movie")
    fun loadAllMovies(): LiveData<List<Movie>>

    @Query("SELECT * FROM movie")
    fun getAllMovies():DataSource.Factory<Int,Movie>


}