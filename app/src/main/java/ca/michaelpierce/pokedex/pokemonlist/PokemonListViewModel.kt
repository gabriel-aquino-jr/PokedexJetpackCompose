package ca.michaelpierce.pokedex.pokemonlist

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.palette.graphics.Palette
import ca.michaelpierce.pokedex.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {

    fun calcDominantColor(drawable: Drawable, onFinished: (Color) -> Unit){
        // Convert image from API into a compatible image for Palette
        val bmp = (drawable as BitmapDrawable).bitmap.copy(Bitmap.Config.ARGB_8888, true)

        // Generate palette from image
        Palette.from(bmp).generate {
            // Get the dominant color from the palette
            it?.dominantSwatch?.rgb?.let { colorValue ->
                // Convert color int into a Composable Color
                onFinished(Color(colorValue))
            }
        }
    }
}