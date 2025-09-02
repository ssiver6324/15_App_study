package com.verr.myapplication.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import com.verr.myapplication.R

@Composable
fun BaseImage(
    imageUrl: String,
    contentDescription: String,
    modifier: Modifier = Modifier,
    error: Painter = painterResource(id = R.drawable.ic_launcher_foreground),
    placeholder: Painter = painterResource(id = R.drawable.ic_launcher_foreground),
    contentScale: ContentScale = ContentScale.Fit
) {
    AsyncImage(
        model = imageUrl,
        contentDescription = contentDescription,
        error = error,
        placeholder = placeholder,
        contentScale = contentScale,
        modifier = modifier,
    )
}