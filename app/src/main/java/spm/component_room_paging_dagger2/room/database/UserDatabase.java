package spm.component_room_paging_dagger2.room.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import spm.component_room_paging_dagger2.room.dao.MyDao;
import spm.component_room_paging_dagger2.room.dto.UserModel;

@Database(entities = {UserModel.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {

    private static UserDatabase noteDB;

    public static UserDatabase getInstance(Context context) {
        if (null == noteDB) {
            noteDB = buildDatabaseInstance(context);
        }
        return noteDB;
    }

    private static UserDatabase buildDatabaseInstance(Context context) {
        return Room.databaseBuilder(context,
                UserDatabase.class,
                "myRoomDatabase")
                .allowMainThreadQueries().build();
    }

    public abstract MyDao getUserDao();

    public void cleanUp() {
        noteDB = null;
    }

}