package kyle.android.chatting.view.home

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_message.view.*
import kyle.android.chatting.R
import kyle.android.chatting.databinding.ItemMessageBinding

/**
 * Created by gon on 2018. 8. 6..
 */
class InboxViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(DataBindingUtil.inflate<ItemMessageBinding>(LayoutInflater.from(parent.context), R.layout.item_message, parent, false).root) {

    val username = itemView.username
    val message = itemView.message

}