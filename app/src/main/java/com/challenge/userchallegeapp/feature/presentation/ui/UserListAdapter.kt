package com.challenge.userchallegeapp.feature.presentation.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.challenge.userchallegeapp.R
import com.challenge.userchallegeapp.databinding.ViewHolderUserBinding
import com.challenge.userchallegeapp.feature.data.model.User

class UserListAdapter : RecyclerView.Adapter<UserListAdapter.UserViewHolder>() {

    var dataSource: List<User> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(user: User) {
            ViewHolderUserBinding.bind(itemView).run {
                nickname.text = user.name
                email.text = user.mail
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.view_holder_user, parent, false)
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(dataSource[position])
    }

    override fun getItemCount(): Int {
        return dataSource.size
    }

}