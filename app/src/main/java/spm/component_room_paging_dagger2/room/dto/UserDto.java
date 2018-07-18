package spm.component_room_paging_dagger2.room.dto;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by root on 7/17/18.
 */



@Entity(tableName = "user",indices={@Index(value="firstName", unique=true),@Index(value="mobileNumber", unique=true)})
//@Entity(primaryKeys = {"firstName", "lastName"},tableName = "Sibaprasad")

// @Entity(indices = {@Index("name"),@Index(value = {"last_name", "address"})})

// @Entity(indices = {@Index(value = {"first_name", "last_name"}, unique = true)})

// @Entity(tableName = "users")
public class UserDto {

    /**
     * how to declare primary key in room database
     * if u declare any column as primary key then, it automatically create a index for
     * the particular column
     */
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "uid")
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

    int age;

    @NonNull
    String pinCode;

    /**
     * if u define any variable as Ignore , it will not
     */
    @Ignore
    boolean isChecked;

    @Embedded
    public Address address;

}


