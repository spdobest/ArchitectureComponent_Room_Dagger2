package spm.component_room_paging_dagger2.room.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.ArrayList;
import java.util.List;

import spm.component_room_paging_dagger2.room.dto.UserModel;

@Dao
public interface MyDao {

    /**
     * INSERT
     */

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertUsers(UserModel... users);

    @Insert
    public void insertBothUsers(UserModel user1, UserModel user2);

    @Insert
    public void insertUsersAndFriends(UserModel user, List<UserModel> friends);

    /**
     * QUERY
    */
    @Query("SELECT * FROM user WHERE age BETWEEN :minAge AND :maxAge")
    public List<UserModel> loadAllUsersBetweenAges(int minAge, int maxAge);

    @Query("SELECT * FROM user WHERE first_name LIKE :search "
           + "OR last_name LIKE :search")
    public List<UserModel> findUserWithName(String search);

    @Query("SELECT * FROM user WHERE age > :minAge")
    public List<UserModel> loadAllUsersOlderThan(int minAge);

    @Query("SELECT * FROM user")
    public List<UserModel> loadAllUsers();

//    @Query("SELECT first_name, last_name FROM user")
//    public List<UserModel> loadFullName();

    /**
     * DELETE
     */

    @Delete
    public void deleteUsers(UserModel... users);

    /**
     * UPDATE
     */
    @Update
    public void updateUsers(UserModel... users);
}