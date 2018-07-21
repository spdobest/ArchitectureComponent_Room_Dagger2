package spm.component_room_paging_dagger2.room.dto;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

/*@Entity(foreignKeys = @ForeignKey(entity = UserModel.class,
                                  parentColumns = "uid",
                                  childColumns = "user_id"))*/
public class Book {
    @PrimaryKey
    public int bookId;

    public String title;

    @ColumnInfo(name = "user_id")
    public int userId;
}