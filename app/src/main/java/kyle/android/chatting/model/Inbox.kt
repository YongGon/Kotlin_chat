package kyle.android.chatting.model

data class Inbox(val id: Long, val userId: Long, val message: String, val user: User)