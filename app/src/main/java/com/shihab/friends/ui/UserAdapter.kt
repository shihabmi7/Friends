package com.shihab.friends.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import coil.load
import coil.transform.CircleCropTransformation
import com.shihab.friends.R
import com.shihab.friends.databinding.ItemNoteBinding
import com.shihab.friends.model.User
import com.shihab.friends.utils.OnItemClickListener
import java.util.*

class UserAdapter(val OnItemClickListener: OnItemClickListener) : Adapter<UserAdapter.UserViewHolder>() {

    private val userList: MutableList<User> = ArrayList()

    inner class UserViewHolder(private val binding: ItemNoteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            binding.user = user
            binding.image.load(user.picture?.medium) {
                transformations(CircleCropTransformation())
            }

            binding.cardView.setOnClickListener {
                OnItemClickListener.onClicked(user)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = DataBindingUtil.inflate<ItemNoteBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_note, parent, false
        )
        return UserViewHolder(view)
    }

    override fun getItemCount() = userList.size

    fun addAllUser(list: List<User>) {
        userList.clear()
        userList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(userList[position])
    }
}