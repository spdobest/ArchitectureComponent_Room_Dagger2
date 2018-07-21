package spm.component_room_paging_dagger2.room.dto;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by root on 7/21/18.
 */

@Entity(tableName = "user")
public class UserModel {

    /**
     * how to declare primary key in room database
     * if u declare any column as primary key then, it automatically create a index for
     * the particular column
     */
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "uid")
    public int uid;


    /**
     * you may or may not define ColumnInfo
     * if you define - It will save the data in table in the Given Column
     * If you not define - it will take the variable name
     */

    @ColumnInfo(name = "first_name")
    public String fName;

    @ColumnInfo(name = "last_name")
    public String lName;

    public String mobileNumber;

    public int age;

    @ColumnInfo(name = "pinCode")
    public String pinCode;

    @Embedded
    public Address address;
    /**
     * if u define any variable as Ignore , it will not
     */
    @Ignore
    boolean isChecked;

}