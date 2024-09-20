package com.example.ejemploenclase1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ejemploenclase1.ui.screens.HomeScreen
import com.example.ejemploenclase1.ui.screens.MenuScreen
import com.example.ejemploenclase1.ui.theme.EjemploEnClase1Theme
import com.example.ejemploenclase1.ui.screens.MenuScreen
import com.example.ejemploenclase1.ui.screens.HomeScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.ui.draw.clip
import androidx.compose.material3.IconButton
import androidx.compose.material3.Icon

// Define los colores para el borde degradado
val GradientColors = Brush.linearGradient(
    colors = listOf(Color.Red, Color.Yellow, Color.Blue)
)

// Datos de ejemplo para las historias
data class Story(val imageResId: Int, val userName: String)

val sampleStories = listOf(
    Story(R.drawable.profile1, "Your story"),
    Story(R.drawable.profile2, "gvanille"),
    Story(R.drawable.profile3, "pledis_boos"),
    Story(R.drawable.profile4, "edvinrydings"),
    Story(R.drawable.profile5, "nayeonyny"),
    Story(R.drawable.profile6, "sharon_s11"),
    Story(R.drawable.profile7, "kassuwu")



)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Column (
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState()) // Habilitar el desplazamiento vertical
                ) {
                    InstagramTopBar()

                    // Lista de historias debajo de la barra superior
                    StoriesList(stories = sampleStories)

                    InstagramPost(
                        profileImage = painterResource(id = R.drawable.zb1pfp),
                        userName = "zb1official",
                        songTitle = "♫ ZEROBASEONE • The Sea (ZB1 Remake)",
                        postImage = painterResource(id = R.drawable.post_image),
                        likes = "354K",
                        comments = "3,092",
                        shares = "15.1K",
                        description = "제로즈 보고싶어어엉",
                        timePosted = "September 11"
                    )

                    InstagramPost(
                        profileImage = painterResource(id = R.drawable.catpfp),
                        userName = "sansanmaoer",
                        songTitle = "Suggested for you",
                        postImage = painterResource(id = R.drawable.post_image2),
                        likes = "92.2K",
                        comments = "266",
                        shares = "11.6K",
                        description = "only one ear\uD83D\uDC42",
                        timePosted = "1 day ago"
                    )

                    InstagramPost(
                        profileImage = painterResource(id = R.drawable.jeonpfp),
                        userName = "jeonghaniyoo_n",
                        songTitle = "♫ SEVENTEEN • Headliner",
                        postImage = painterResource(id = R.drawable.post_image4),
                        likes = "1.7M",
                        comments = "34.3K",
                        shares = "63.9K",
                        description = "lollapalooza berlin\uD83D\uDC98",
                        timePosted = "September 10"
                    )

                    InstagramPost(
                        profileImage = painterResource(id = R.drawable.lisapfp),
                        userName = "lalalalisa_m",
                        songTitle = "♫ LISA • ROCKSTAR",
                        postImage = painterResource(id = R.drawable.post_image3),
                        likes = "4.7M",
                        comments = "29.2K",
                        shares = "58.9K",
                        description = "Thank you mtv and vmas for this award.",
                        timePosted = "6 days ago"

                    )


                }
                // Barra de navegación inferior, siempre visible en la parte inferior
                BottomNavigationBar(
                    modifier = Modifier
                        .align(Alignment.BottomCenter) // Fija la barra en la parte inferior
                )
            }

        }

        // Configurar el color de la barra de estado y la barra de navegación
        WindowCompat.getInsetsController(window, window.decorView).let { controller ->
            controller.isAppearanceLightStatusBars = true
            controller.isAppearanceLightNavigationBars = true
        }

        window.statusBarColor = ContextCompat.getColor(this, R.color.white) // Cambia R.color.white por el color deseado
        window.navigationBarColor = ContextCompat.getColor(this, R.color.white) // Cambia R.color.white por el color deseado

    }
}


@Preview(showBackground = true)
@Composable
fun InstagramTopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Imagen del logo de Instagram a la izquierda
        Image(
            painter = painterResource(id = R.drawable.instagram_logo), // Reemplaza con el nombre de tu imagen en drawable
            contentDescription = "Logo de Instagram",
            modifier = Modifier
                .height(75.dp) // Ajusta el tamaño según prefieras
                .width(120.dp)

        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            // Icono de notificaciones (solo visual)
            Icon(
                painter = painterResource(id = R.drawable.ic_notifications),
                contentDescription = "Notificaciones",
                tint = Color.Black,
                modifier = Modifier
                    .size(25.dp)
                    //.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            // Icono de mensajes (solo visual)
            Icon(
                painter = painterResource(id = R.drawable.ic_messages),
                contentDescription = "Mensajes",
                tint = Color.Black,
                modifier = Modifier
                    .size(23.dp)

            )
        }
    }
}

@Composable
fun StoryItem(image: Painter, userName: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(horizontal = 8.dp)
            //.padding(vertical = 60.dp)
    ) {
        Box(
            modifier = Modifier
                .size(82.dp) // Tamaño del círculo
                .border(
                    width = 3.dp,
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color.Yellow,
                            Color.Magenta)
                    ),
                    shape = CircleShape
                )
                .background(Color.White, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = image,
                contentDescription = "Story Image",
                modifier = Modifier
                    .size(69.dp) // Tamaño de la imagen dentro del círculo
                    .clip(CircleShape), // Asegúrate de que la imagen se recorte a forma circular




            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = userName,
            fontSize = 12.sp,
            maxLines = 1
        )
    }
}

@Composable
fun StoriesList(stories: List<Story>) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(stories) { story ->
            StoryItem(
                image = painterResource(id = story.imageResId),
                userName = story.userName
            )
        }
    }
}

@Composable
fun InstagramPost(
    profileImage: Painter,
    userName: String,
    songTitle: String,
    postImage: Painter,
    likes: String,
    comments: String,
    shares: String,
    description: String,
    timePosted: String
) {
    Column(modifier = Modifier.fillMaxWidth()
        //.padding(vertical = 60.dp)

    ) {
        // Encabezado de la publicación
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Foto de perfil
            Image(
                painter = profileImage,
                contentDescription = "Profile Image",
                modifier = Modifier
                    .size(32.dp)
                    .clip(CircleShape)
                    .background(Color.Gray) // Color de fondo opcional
            )

            Spacer(modifier = Modifier.width(8.dp))

            // Nombre de usuario y canción
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = userName,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
                Text(
                    text = songTitle,
                    fontSize = 12.sp,
                   // color = Color.Gray
                )
            }

            // Ícono de 3 puntos (ajustes)
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = "More options",
                modifier = Modifier.size(24.dp)
            )
        }

        // Imagen de la publicación (llena toda la pantalla en ancho y alto)
        Image(
            painter = postImage,
            contentDescription = "Post Image",
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(), // Modifica esta proporción según lo que necesites
            contentScale = ContentScale.Crop
        )

        // Sección de acciones (likes, comentarios, compartir, guardar)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconWithText(icon = painterResource(id = R.drawable.ic_like), text = "$likes")
                Spacer(modifier = Modifier.width(16.dp))
                IconWithText(icon = painterResource(id = R.drawable.ic_comment), text = "$comments")
                Spacer(modifier = Modifier.width(16.dp))
                IconWithText(icon = painterResource(id = R.drawable.ic_share), text = "$shares")
            }

            Icon(
                painter = painterResource(id = R.drawable.ic_save),
                contentDescription = "Save",
                modifier = Modifier.size(24.dp)
            )
        }

        // Nombre de usuario y descripción
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        ) {
            Text(
                text = userName,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = description,
                fontSize = 14.sp
            )
        }

        // Texto "View all comments"
        Text(
            text = "View all comments",
            color = Color.Gray,
            fontSize = 14.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 4.dp)
        )

        // Texto "7 hours ago"
        Text(
            text = timePosted,
            color = Color.Gray,
            fontSize = 12.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 2.dp)
        )
    }
}

@Composable
fun IconWithText(icon: Painter, text: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            painter = icon,
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = text,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold)
    }
}

@Composable
fun BottomNavigationBar(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(Color(0xFFfafafa)), // Cambia el color de fondo si es necesario
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Iconos de la barra de navegación inferior
            IconButton(onClick = { /* Acción de inicio */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_inicio),
                    contentDescription = "Home",
                    modifier = Modifier.size(24.dp)
                )
            }
            IconButton(onClick = { /* Acción de buscar */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_explorar),
                    contentDescription = "Search",
                    modifier = Modifier.size(24.dp)
                )
            }
            IconButton(onClick = { /* Acción de nuevo */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_nuevo),
                    contentDescription = "New Post",
                    modifier = Modifier.size(24.dp)
                )
            }
            IconButton(onClick = { /* Acción de reels */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_reels),
                    contentDescription = "Reels",
                    modifier = Modifier.size(24.dp)
                )
            }
            IconButton(onClick = { /* Acción de perfil */ }) {
                Image(
                    painter = painterResource(id = R.drawable.profile1),
                    contentDescription = "Profile",
                    modifier = Modifier
                        .size(28.dp)
                        .clip(CircleShape) // Imagen circular para el icono de perfil
                )
            }
        }
    }
}




/*@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EjemploEnClase1Theme {
        Greeting("Android")
    }
}

@Preview(showBackground = true)
@Composable
fun ModifierExample(){
    Column (
        modifier = Modifier
            .padding(24.dp)

    ){
        Text(text = "Hello World")
    }

}

@Preview(showBackground = true)
@Composable
fun ModifierExample2(){
    Column (
        modifier = Modifier
            .padding(24.dp)
            .fillMaxWidth()
            .clickable(onClick = { clickAction() })
    ){
        Text(text = "Hello World")
    }

}

fun clickAction(){
    println("Column Clicked")
}

@Preview(showBackground = true)
@Composable
fun ModifierExample3(){
    Column (
        modifier = Modifier

            .fillMaxHeight()
            .padding(16.dp)
            .background(Color.Magenta)
            .border(width = 2.dp, color = Color.Blue)
            .width(200.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement =  Arrangement.SpaceEvenly
    ){
        Text(text = "Item 1")
        Text(text = "Item 2")
        Text(text = "Item 3")
        Text(text = "Item 4")
        Text(text = "Item 5")
    }

}

@Preview(showBackground = true)
@Composable
fun CustomText(){
    Column {
        Text(
            stringResource(R.string.Hello_World_Text),
            color = colorResource(R.color.Pink),
            fontSize = 20.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.ExtraBold
        )
        val gradientColors = listOf(Cyan, Blue)
        Text(
            stringResource(R.string.Hello_World_Text),
            style = TextStyle(brush = Brush.linearGradient(colors = gradientColors))

        )
    }
}

@Preview(showBackground = true)
@Composable
fun Picture1(){
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
    ){
        Image(
            modifier = Modifier
                .fillMaxWidth(),
            painter = painterResource(R.drawable.j0b8jkwfohdd1),
            contentDescription = "Logo BLACKPINK",
            contentScale = ContentScale.FillWidth
        )
    }
}

@Preview (showBackground = true)
@Composable
fun Content1(){
    Card(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Text(
            text = "THIS IS A TITLE",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(10.dp)
        )
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            painter = painterResource(id = R.drawable.blackpink),
            contentDescription = "Blackpink logo, espero funcione",
            contentScale = ContentScale.Crop
        )
        Text(
            stringResource(R.string.Style),
            textAlign = TextAlign.Center,
            lineHeight = 18.sp,
            modifier = Modifier
                .padding(10.dp)
        )
    }
}

@Preview (showBackground = true)
@Composable
fun Content2(){
    Card(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)

        ){
            Image(
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp),
                painter = painterResource(id = R.drawable.blackpink),
                contentDescription = "Blackpink logo, espero funcione",
                contentScale = ContentScale.Crop
            )

            Column (
                modifier = Modifier
                    .fillMaxWidth()
            ){
                Text(
                    text = "THIS IS A TITLE",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(10.dp)
                )

                Text(
                    stringResource(R.string.Style),
                    textAlign = TextAlign.Center,
                    lineHeight = 18.sp,
                    modifier = Modifier
                        .padding(10.dp)
                )

            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun BoxExample1(){
    Box(
        modifier = Modifier
            .background(Color.Magenta)
            .fillMaxWidth()
            .padding(5.dp)
    ){
        Image(painterResource(R.drawable.j0b8jkwfohdd1),
            contentDescription = "navia",
            contentScale = ContentScale.FillBounds
            )
        Row (
            modifier = Modifier
                //.background(Color.Blue)
                .padding(0.dp, 150.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center

        ){
            Icon(
                Icons.Filled.FavoriteBorder,
                contentDescription = "icono"
            )
            Text(text = "Text")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun BoxExample2(){
    Box(
        modifier = Modifier
            .background(Color.Magenta)
            .padding(5.dp)
            .size(250.dp)
    ){
        Text(text = "TopStart", modifier = Modifier.align(Alignment.TopStart))
        Text(text = "TopEnd", modifier = Modifier.align(Alignment.TopEnd))
        Text(text = "BottomStart", modifier = Modifier.align(Alignment.BottomStart))
        Text(text = "BottomEnd", modifier = Modifier.align(Alignment.BottomEnd))
        Text(text = "CenterStart", modifier = Modifier.align(Alignment.CenterStart))
        Text(text = "Center", modifier = Modifier.align(Alignment.Center))
        Text(text = "CenterEnd", modifier = Modifier.align(Alignment.CenterEnd))

    }
}*/

/*@Composable
fun ComposeMultiScreenApp(){
    val navController = rememberNavController()
    Surface(color = Color.White){
        SetupNavGraph(navController = navController)
    }

}

@Composable
fun SetupNavGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = "menu"){
        composable("menu"){ MenuScreen(navController)}
        composable("home"){ HomeScreen(navController)}

    }
}*/




