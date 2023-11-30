import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlinx.coroutines.flow.asStateFlow
import model.Contact
import repository.ContactRepository
import ui.ContactsList
import ui.DetailsScreen


@Composable
fun App() {
    MaterialTheme {
        var selectedContact by remember { mutableStateOf(Contact()) }

        val repository = ContactRepository()
        val contacts = repository.getContacts().asStateFlow()

        if (selectedContact.id == 0) {
            ContactsList(contacts) { contactId ->
                selectedContact = repository.getContact(contactId)
            }
        } else {
            var selectedBytes: ByteArray by remember { mutableStateOf(ByteArray(0)) }
            val imagePicker = ImagePickerFactory(context = getPlatformContext()).createPicker()
            imagePicker.RegisterPicker { bytes: ByteArray ->
                println("Bytes: $bytes")
                selectedBytes = bytes
            }

            DetailsScreen(
                selectedContact = selectedContact,
                selectedBytes = selectedBytes,
                imagePicker = imagePicker,
                onBack = {
                    selectedContact = Contact()
                },
                onUpdate = { bytes ->
                    repository.updateContact(selectedContact.copy(profilePicture = selectedBytes))
                    selectedContact = Contact()
                }
            )
        }
    }
}


