package model

data class Contact(
    val id: Int = 0,
    val name: String = "",
    val reverseName: String = "",
    val profilePicture: ByteArray = byteArrayOf(),
)