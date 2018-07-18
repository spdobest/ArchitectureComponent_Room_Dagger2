package spm.component_room_paging_dagger2.room

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import spm.component_room_paging_dagger2.R
import spm.component_room_paging_dagger2.room.database.UserDatabase
import android.R.id.button2
import android.support.design.widget.BottomSheetDialog
import spm.component_room_paging_dagger2.room.dto.UserDto


class RoomActivity : AppCompatActivity() {

    lateinit var userDatabase: UserDatabase
    lateinit var mBottomSheetBehavior2: BottomSheetDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        userDatabase = UserDatabase.getInstance(this)
    }

    fun showBottomSHeet(userDao:UserDto){
        val view = layoutInflater.inflate(R.layout.bottomsheet_user, null)

        val dialog = BottomSheetDialog(this)
        dialog.setContentView(view)
        dialog.show()
    }

}
