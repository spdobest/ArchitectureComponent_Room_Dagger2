package spm.component_room_paging_dagger2.room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by root on 7/17/18.
 */
@Entity(indices={@Index(value="name", unique=true),@Index(value="mobileNumber", unique=true)})
//@Entity(primaryKeys = {"firstName", "lastName"},tableName = "Sibaprasad")

// @Entity(indices = {@Index("name"),@Index(value = {"last_name", "address"})})
public class UserDto {
    @PrimaryKey(autoGenerate = true)
    int uid;


    /**
     * you may or may not define ColumnInfo
     * if you define - It will save the data in table in the Given Column
     * If you not define - it will take the variable name
      */

    @ColumnInfo(name = "firstName")
    String fName;

    @ColumnInfo(name = "lastName")
    String lName;

    String mobileNumber;

    @NonNull
    String pinCode;

    /**
     * if u define any variable as Ignore , it will not
     */
    @Ignore
    boolean isChecked;

}
