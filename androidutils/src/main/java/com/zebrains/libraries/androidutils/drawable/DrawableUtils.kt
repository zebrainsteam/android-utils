package com.zebrains.libraries.androidutils.drawable

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.net.Uri
import android.view.View
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import coil.loadAny
import coil.transform.CircleCropTransformation
import coil.transform.RoundedCornersTransformation
import com.google.android.material.snackbar.Snackbar

fun Context.getBitmapFromVectorDrawable(drawableId: Int): Bitmap? {
    var drawable = ContextCompat.getDrawable(this, drawableId) ?: return null

    val bitmap = Bitmap.createBitmap(
        drawable.intrinsicWidth,
        drawable.intrinsicHeight,
        Bitmap.Config.ARGB_8888) ?: return null
    val canvas = Canvas(bitmap)
    drawable.setBounds(0, 0, canvas.width, canvas.height)
    drawable.draw(canvas)

    return bitmap
}

fun View.showSnackBar(@StringRes messageId: Int): Snackbar =
    Snackbar.make(this, messageId, Snackbar.LENGTH_LONG)

fun ImageView.showImage(image: String) {
    loadImage(this, image)
}

fun ImageView.showImage(@DrawableRes image: Int, radius: Float = 48f) {
    loadImage(this, image, radius)
}

fun ImageView.showImage(image: Uri) {
    loadImage(this, image)
}

fun ImageView.showImage(image: Bitmap) {
    loadImage(this, image)
}

fun ImageView.showImage(image: Drawable) {
    loadImage(this, image)
}

fun ImageView.showImage(comparable: Comparable<*>) {
    loadImage(this, comparable)
}

fun ImageView.loadImage(url: String) {
    loadImageFromUrl(this, url)
}

private fun loadImageFromUrl(imageView: ImageView, image: Any) {
    imageView.loadAny(image) {
        crossfade(true)
    }
}

private fun loadImage(imageView: ImageView, image: Any, radius: Float = 48f) {
    imageView.loadAny(image) {
        crossfade(true)
        transformations(RoundedCornersTransformation(radius))
    }
}

fun ImageView.showAvatar(comparable: Comparable<*>) {
    this.loadAny(comparable) {
        crossfade(true)
        transformations(CircleCropTransformation())
    }
}

fun ImageView.showAvatar(comparable: Comparable<*>, radius: Float = 48f) {
    this.loadAny(comparable) {
        crossfade(true)
        transformations(RoundedCornersTransformation(radius))
    }
}