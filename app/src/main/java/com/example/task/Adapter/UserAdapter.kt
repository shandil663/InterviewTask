package com.example.task.Adapter


import android.content.ClipData.Item
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.task.R
import com.example.task.model.ItemsList

class UserAdapter(private val users: ItemsList) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    val list = users.results

    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameText: TextView = view.findViewById(R.id.userName)
        val emailText: TextView = view.findViewById(R.id.userEmail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = list[position]
        holder.nameText.text = user.title
        holder.emailText.text = user.overview
    }

    override fun getItemCount() = list.size
}

