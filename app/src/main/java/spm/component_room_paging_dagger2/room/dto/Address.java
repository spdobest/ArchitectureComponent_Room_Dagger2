package spm.component_room_paging_dagger2.room.dto;

import android.arch.persistence.room.ColumnInfo;

public class Address {
    public String street;
    public String state;
    public String city;

    @ColumnInfo(name = "post_code")
    public int postCode;
}
