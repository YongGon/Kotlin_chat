package kyle.android.chatting.view.home

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import kyle.android.chatting.model.Inbox

class InboxRecyclerViewAdapter() : RecyclerView.Adapter<InboxViewHolder>() {

    private var items: MutableList<Inbox> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InboxViewHolder {
        return InboxViewHolder(parent)
    }

    override fun onBindViewHolder(holder: InboxViewHolder, position: Int) {
        holder.message.text = items.get(position).message
        holder.username.text = "test : "
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun addItem(inbox: Inbox) {
        items.add(inbox)
        notifyItemInserted(itemCount - 1)
    }

    fun itemReset(list: MutableList<Inbox>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }
}