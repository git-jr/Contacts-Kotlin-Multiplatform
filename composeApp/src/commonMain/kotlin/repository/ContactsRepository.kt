package repository

import kotlinx.coroutines.flow.MutableStateFlow
import model.Contact

class ContactRepository {

    fun getContacts(): MutableStateFlow<List<Contact>> {
        return contacts
    }

    fun updateContact(contact: Contact) {
        contacts.value = contacts.value.map {
            if (it.id == contact.id) {
                contact
            } else {
                it
            }
        }
    }

    fun getContact(contactId: Int): Contact {
        return contacts.value.first { it.id == contactId }
    }

    companion object {
        private val contacts = MutableStateFlow(
            listOf(
                Contact(
                    id = 1,
                    name = "João",
                    reverseName = "ãooJ",
                    profilePicture = byteArrayOf()
                ),
                Contact(
                    id = 2,
                    name = "Maria",
                    reverseName = "airaM",
                    profilePicture = byteArrayOf()
                ),
            )
        )
    }
}