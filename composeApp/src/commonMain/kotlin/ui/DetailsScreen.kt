package ui

import ImagePicker
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import model.Contact
import rememberBitmapFromBytes


@Composable
 fun DetailsScreen(
    selectedContact: Contact,
    selectedBytes: ByteArray,
    imagePicker: ImagePicker,
    onBack: () -> Unit = {},
    onUpdate: (ByteArray) -> Unit = {}
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.primary)
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clickable { onBack() }
            ) {
                Icon(
                    Icons.Default.ArrowBack,
                    contentDescription = null,
                    modifier = Modifier
                        .size(24.dp)
                        .align(Alignment.Center),
                    tint = MaterialTheme.colors.onPrimary
                )
            }

            Text(
                text = "Editar Contato",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.onPrimary
            )

            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clickable {
                        onBack()
                    }
            ) {
                IconButton(
                    onClick = {
                        onUpdate(selectedBytes)
                    },
                    modifier = Modifier
                        .size(24.dp)
                        .align(Alignment.Center),
                ) {
                    Icon(
                        Icons.Default.Done,
                        contentDescription = null,
                        tint = MaterialTheme.colors.onPrimary,
                    )
                }
            }
        }

        Spacer(Modifier.height(16.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(300.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colors.primary.copy(alpha = 0.5f))
                    .clickable {
                        imagePicker.pickImage()
                    }
            ) {
                if (selectedBytes.isNotEmpty()) {
                    Image(
                        bitmap = rememberBitmapFromBytes(selectedBytes),
                        contentDescription = null,
                        modifier = Modifier
                            .size(300.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )
                } else {
                    Text(
                        text = "Foto",
                        color = Color.White,
                        fontSize = 20.sp,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }

            }

            Spacer(Modifier.height(22.dp))

            Text(
                text = selectedContact.reverseName,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
            )

            Text(
                text = selectedContact.name,
                fontSize = 16.sp,
                color = Color.Gray,
                modifier = Modifier.padding(top = 16.dp)
            )

        }
    }
}