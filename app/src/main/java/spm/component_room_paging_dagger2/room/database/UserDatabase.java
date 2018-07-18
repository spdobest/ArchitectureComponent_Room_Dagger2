package spm.component_room_paging_dagger2.room.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import spm.component_room_paging_dagger2.room.dto.UserDto;

@Database(entities = {UserDto.class}, version = 1)
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

    public abstract UserDto getUserDao();

    public void cleanUp() {
        noteDB = null;
    }

}