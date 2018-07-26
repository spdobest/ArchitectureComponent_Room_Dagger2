package spm.component_room_paging_dagger2.paging.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import spm.component_room_paging_dagger2.paging.dao.MovieDao;
import spm.component_room_paging_dagger2.paging.viewmodel.MovieViewModel;
import spm.component_room_paging_dagger2.room.dao.MyDao;

@Database(entities = {MovieViewModel.class}, version = 1)
public abstract class MovieDatabase extends RoomDatabase {

    private static MovieDatabase noteDB;

    public static MovieDatabase getInstance(Context context) {
        if (null == noteDB) {
            noteDB = buildDatabaseInstance(context);
        }
        return noteDB;
    }

    private static MovieDatabase buildDatabaseInstance(Context context) {
        return Room.databaseBuilder(context,
                MovieDatabase.class,
                "myPagingDatabase")
                .allowMainThreadQueries().build();
    }

    public abstract MovieDao getMovieDao();

    public void cleanUp() {
        noteDB = null;
    }

}