package spm.component_room_paging_dagger2.room

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import spm.component_room_paging_dagger2.R
import spm.component_room_paging_dagger2.room.database.UserDatabase
import android.support.design.widget.BottomSheetDialog
import android.support.v7.widget.AppCompatButton
import android.support.v7.widget.AppCompatEditText
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.activity_room.*
import spm.component_room_paging_dagger2.room.dto.Address
import spm.component_room_paging_dagger2.room.dto.UserModel


class RoomActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(view: View?) {

        when (view!!.id) {

            R.id.fabAdd -> {
                showBottomSHeet()
            }


        }

    }
    lateinit var dialog: BottomSheetDialog
    lateinit var userDatabase: UserDatabase
    lateinit var mBottomSheetBehavior2: BottomSheetDialog
    lateinit var recyclerviewUsers: RecyclerView
    lateinit var userAdapter: RoomAdapter
    var listUser: ArrayList<UserModel> = ArrayList<UserModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)
        recyclerviewUsers = findViewById(R.id.recyclerviewUsers)
        recyclerviewUsers.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        userAdapter = RoomAdapter(listUser, this)
        recyclerviewUsers.adapter = userAdapter

        fabAdd.setOnClickListener(this)

        dialog = BottomSheetDialog(this)

        userDatabase = UserDatabase.getInstance(this)
    }

    fun showBottomSHeet() {


        val view = layoutInflater.inflate(R.layout.bottomsheet_user, null)

        var edittextFname: AppCompatEditText = view.findViewById<AppCompatEditText>(R.id.edittextFirstName)
        var edittextLname: AppCompatEditText = view.findViewById<AppCompatEditText>(R.id.edittextLastName)
        var edittextAge: AppCompatEditText = view.findViewById<AppCompatEditText>(R.id.edittextAge)
        var edittextMobile: AppCompatEditText = view.findViewById<AppCompatEditText>(R.id.edittextMobileNumber)
        var edittextAddress: AppCompatEditText = view.findViewById<AppCompatEditText>(R.id.edittextAddress)
        var buttonSubmitUser: AppCompatButton = view.findViewById<AppCompatButton>(R.id.buttonSubmitUser)




        buttonSubmitUser.setOnClickListener(View.OnClickListener {


            var userModel: UserModel = UserModel()
            userModel.fName = edittextFname.text.toString()
            userModel.lName = edittextLname.text.toString()
            userModel.age = edittextAge.text.toString().toInt()
            userModel.mobileNumber = edittextMobile.text.toString()

            var address: Address = Address()
            address.state = edittextAddress.text.toString()
            userModel.address = address

            UserDatabase.getInstance(this).getUserDao().insertUsers(userModel)

            val userListTemp: List<UserModel> = UserDatabase.getInstance(this).getUserDao().loadAllUsers()

            listUser.addAll(userListTemp)

            userAdapter.notifyDataSetChanged()

            dialog.dismiss()

        })


        /*  edittextFname.setText(userDao!!.fName.toString())
          edittextLname.setText(userDao!!.lName.toString())
          edittextAge.setText(userDao!!.age.toString())
          edittextMobile.setText(userDao!!.mobileNumber.toString())
          edittextAddress.setText(userDao!!.address.toString())
  */


        dialog.setContentView(view)
        dialog.show()

    }

}
