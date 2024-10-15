package com.example.art_space_project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.art_space_project.ui.theme.Art_Space_ProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Art_Space_ProjectTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpace()
                }
            }
        }
    }
}

@Composable
fun ArtSpace() {
    // Listes des ressources d'images, titres d'œuvres, artistes et années
    val imageResources = listOf(
        R.drawable.vibrant_abstract_artwork_with_colorful_paint_splatters,
        R.drawable.vibrant_and_expressive_faces_of_women_in_abstract_art,
        R.drawable.vibrant_painting_of_a_woman_s_face_with_colorful_paint_splatters
    )

    // Titres des œuvres
    val titles = listOf(
        "Vibrant Abstract Artwork with Colorful Paint Splatters",
        "Vibrant and Expressive Faces of Women in Abstract Art",
        "Vibrant Painting of a Woman Face with Colorful Paint Splatters"
    )

    // Artistes et années
    val artists = listOf(
        "Creative Fabrica (2024)",
        "Creative Fabrica(2024)",
        "Creative Fabrica (2024)"
    )

    var currentIndex by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF0F0F0))
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        // Cadre pour l'image avec ombre et coins arrondis
        Box(
            modifier = Modifier
                .padding(top = 16.dp, bottom = 16.dp)
                .size(350.dp)
                .background(
                    color = Color(0xFFEEEEEE),
                    shape = RoundedCornerShape(20.dp)
                )
                .shadow(12.dp, RoundedCornerShape(20.dp))
        ) {
            val image = painterResource(imageResources[currentIndex])
            Image(
                painter = image,
                contentDescription = "Artistic representation",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Titre de l'œuvre
        Text(
            text = titles[currentIndex],
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF2E3B55),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        )

        // Artiste et année
        Text(
            text = artists[currentIndex],
            fontSize = 18.sp,
            color = Color(0xFF616161),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        )

        // Boutons Previous et Next
        Row(
            modifier = Modifier
                .padding(vertical = 24.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Bouton Previous
            Button(
                onClick = { if (currentIndex > 0) currentIndex-- },
                enabled = currentIndex > 0,
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50))
            ) {
                Text("Previous", fontSize = 16.sp, color = Color.White)
            }

            // Bouton Next
            Button(
                onClick = { if (currentIndex < imageResources.lastIndex) currentIndex++ },
                enabled = currentIndex < imageResources.lastIndex,
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF5722))
            ) {
                Text("Next", fontSize = 16.sp, color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    Art_Space_ProjectTheme {
        ArtSpace()
    }
}
