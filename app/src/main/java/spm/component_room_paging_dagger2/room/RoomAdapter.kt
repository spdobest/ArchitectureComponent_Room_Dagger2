package spm.component_room_paging_dagger2.room

import android.annotation.SuppressLint
import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.itemview_room.view.*
import spm.component_room_paging_dagger2.R
import spm.component_room_paging_dagger2.room.dto.UserModel

@SuppressLint("ParcelCreator")
/**
 * Created by root on 7/21/18.
 */
class RoomAdapter(internal var  listData: ArrayList<UserModel>, val context: Context) :
        RecyclerView.Adapter<RoomAdapter.RoomViewHolder>() {


    override fun onBindViewHolder(holder: RoomViewHolder, position: Int) {
        val userModel: UserModel = listData.get(position)
        holder.textViewName.text = userModel.fName+" "+userModel!!.lName
        holder.textViewMobileNumber.text = userModel.mobileNumber
        holder.textViewAge.text = userModel.age.toString()
        holder.textViewAddress.text = userModel.address!!.state
    }

    override fun getItemCount(): Int {
        return listData!!.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : RoomViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.itemview_room, parent, false)
        return RoomViewHolder(view)
    }


    class RoomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textViewName:TextView = itemView.textViewName
        var textViewAge:TextView = itemView.textViewAge
        var textViewMobileNumber:TextView = itemView.textViewMobileNumber
        var textViewAddress:TextView = itemView.textViewAddress
    }
}