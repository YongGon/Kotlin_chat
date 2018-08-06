package kyle.android.chatting.view.home

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import kyle.android.chatting.model.Inbox

class InboxRecyclerViewAdapter(val list: ArrayList<Inbox>) : RecyclerView.Adapter<InboxViewHolder>() {

    private var items: MutableList<Inbox> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InboxViewHolder {
        return InboxViewHolder(parent)
    }

    override fun onBindViewHolder(holder: InboxViewHolder, position: Int) {
        holder.message.text = "hi"
        holder.username.text = "kyle : "
    }

    override fun getItemCount(): Int {
        return list.size
    }
}