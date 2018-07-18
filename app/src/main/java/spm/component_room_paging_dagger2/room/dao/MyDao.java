package spm.component_room_paging_dagger2.room.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import spm.component_room_paging_dagger2.room.dto.UserDto;

@Dao
public interface MyDao {

    /**
     * INSERT
     */

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertUsers(UserDto... users);

    @Insert
    public void insertBothUsers(UserDto user1, UserDto user2);

    @Insert
    public void insertUsersAndFriends(UserDto user, List<UserDto> friends);

    /**
     * QUERY
    */
    @Query("SELECT * FROM user WHERE age BETWEEN :minAge AND :maxAge")
    public List<UserDto> loadAllUsersBetweenAges(int minAge, int maxAge);

    @Query("SELECT * FROM user WHERE first_name LIKE :search "
           + "OR last_name LIKE :search")
    public List<UserDto> findUserWithName(String search);

    @Query("SELECT * FROM user WHERE age > :minAge")
    public List<UserDto> loadAllUsersOlderThan(int minAge);

    @Query("SELECT * FROM user")
    public List<UserDto> loadAllUsers();

    @Query("SELECT first_name, last_name FROM user")
    public List<UserDto> loadFullName();

    /**
     * DELETE
     */

    @Delete
    public void deleteUsers(UserDto... users);

    /**
     * UPDATE
     */
    @Update
    public void updateUsers(UserDto... users);
}