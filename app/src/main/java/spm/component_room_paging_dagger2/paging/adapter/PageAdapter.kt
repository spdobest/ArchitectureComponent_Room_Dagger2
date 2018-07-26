package spm.component_room_paging_dagger2.paging.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.itemview_room.view.*
import spm.component_room_paging_dagger2.R
import spm.component_room_paging_dagger2.paging.dto.Movie
import spm.component_room_paging_dagger2.paging.viewmodel.MovieViewModel
import spm.component_room_paging_dagger2.room.RoomAdapter
import spm.component_room_paging_dagger2.room.dto.UserModel

@SuppressLint("ParcelCreator")
/**
 * Created by root on 7/21/18.
 */
class PageAdapter() : ListAdapter<Movie, PageAdapter.PagingViewHolder>(
        object : DiffUtil.ItemCallback<Movie>(){
            override fun areItemsTheSame(oldItem: Movie?, newItem: Movie?):Boolean {
                if(oldItem!!.id == newItem!!.id){
                    return true
                }
                else{
                    return false
                }
            }

            override fun areContentsTheSame(oldItem: Movie?, newItem: Movie?) = oldItem==newItem
        }

) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.itemview_room, parent, false)
        return PagingViewHolder(view)
    }

    override fun onBindViewHolder(holder: PagingViewHolder, position: Int) {

    }

    class PagingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textViewName:TextView = itemView.textViewName
        var textViewAge:TextView = itemView.textViewAge
        var textViewMobileNumber:TextView = itemView.textViewMobileNumber
        var textViewAddress:TextView = itemView.textViewAddress
    }
}
