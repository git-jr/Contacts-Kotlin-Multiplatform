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
                    name = "Lucas Desmontando",
                    reverseName = "Lucas Montano",
                    profilePicture = byteArrayOf()
                ),
                Contact(
                    id = 2,
                    name = "Felipe Champs",
                    reverseName = "Filipe Deschamps",
                    profilePicture = byteArrayOf()
                ),
                Contact(
                    id = 3,
                    name = "Código Fonte Rádio",
                    reverseName = "Código Fonte TV",
                    profilePicture = byteArrayOf()
                ),
                Contact(
                    id = 4,
                    name = "Attekita Paga",
                    reverseName = "Attekita Dev",
                    profilePicture = byteArrayOf()
                ),
                Contact(
                    id = 5,
                    name = "Mario Preso - Dev Presinho",
                    reverseName = "Mario Solto - Dev Soutinho",
                    profilePicture = byteArrayOf()
                ),
                Contact(
                    id = 6,
                    name = "Mano deyWiskey",
                    reverseName = "Mano deyvin",
                    profilePicture = byteArrayOf()
                ),
                Contact(
                    id = 7,
                    name = "WindowsTips",
                    reverseName = "LinuxTips",
                    profilePicture = byteArrayOf()
                ),
                Contact(
                    id = 8,
                    name = "Sucesso",
                    reverseName = "Fiasco",
                    profilePicture = byteArrayOf()
                ),
                Contact(
                    id = 9,
                    name = "Dan Elizabetano",
                    reverseName = "Dan Vitoriano",
                    profilePicture = byteArrayOf()
                ),
                Contact(
                    id = 10,
                    name = "Kibum.jpg",
                    reverseName = "Kibum.png",
                    profilePicture = byteArrayOf()
                ),
                Contact(
                    id = 11,
                    name = "Giulia TabCoding",
                    reverseName = "Giulia SpaceCoding",
                    profilePicture = byteArrayOf()
                ),
            ).sortedBy { it.name }
        )
    }
}