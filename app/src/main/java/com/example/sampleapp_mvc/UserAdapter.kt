package com.example.sampleapp_mvc

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sampleapp_mvc.data.model.UserItem

class UserAdapter(
    private val users: ArrayList<UserItem>
): RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val listItemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return UserViewHolder(listItemView)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount(): Int {
        return users.size
    }

    fun addData(list: List<UserItem>) {
        users.clear()
        users.addAll(list)
        notifyDataSetChanged()
    }

    inner class UserViewHolder(
        private val itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        fun bind(userItem: UserItem) {
            itemView.apply {
                findViewById<TextView>(R.id.text_name).text = userItem.name
                findViewById<TextView>(R.id.text_email).text = userItem.name
                val imageAvatar = findViewById<ImageView>(R.id.image_avatar)
                Glide.with(imageAvatar.context)
                    .load(userItem.avatar)
                    .centerCrop()
                    .into(imageAvatar)
            }
        }
    }
}