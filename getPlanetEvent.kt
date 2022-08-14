import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.*
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.wearable.watchface.CanvasWatchFaceService
import android.support.wearable.watchface.WatchFaceService
import android.support.wearable.watchface.WatchFaceStyle
import android.view.SurfaceHolder
import android.widget.Toast
import androidx.palette.graphics.Palette
import java.lang.ref.WeakReference
import java.text.SimpleDateFormat
import java.time.temporal.TemporalField
import java.util.*
import kotlin.math.abs


private fun getPlanetEvent(): String {
            val d = Date()
            val sdf0 = SimpleDateFormat("yyyy MMMM")
            val yearMonth: String = sdf0.format(d)
            val planetOpposition =
                when(yearMonth){
                    "2022 January" -> ""
                    "2022 February" -> ""
                    "2022 March" -> ""
                    "2022 April" -> ""
                    "2022 May" -> ""
                    "2022 June" -> "June 28, 2022: Neptune begins retrograde motion"
                    "2022 July" -> "July 28, 2022: Jupiter begins retrograde motion"
                    "2022 August" -> "Saturn is in Opposition on August 14" //August 24, 2022: Uranus begins retrograde motion
                    "2022 September" -> "Jupiter opposition 2022 – September 26" //Septemper 16, 2022: Neptune at opposition
                    "2022 October" -> "Saturn ends retrograde motion"
                    "2022 November" -> "November 23, 2022: Jupiter ends retrograde motion" // 2022 Uranus opposition – November 9
                    "2022 December" -> "Mars is in Opposition on December 8"

                    "2023 January" -> "Uranus ends retrograde motion"
                    "2023 February" -> "February 16, 2023: Saturn in conjunction with the sun"
                    "2023 March" -> "Neptune at solar conjunction" //Uranus at solar conjunction
                    "2023 April" -> "April 11, 2023: Jupiter at solar conjunction"
                    "2023 May" -> ""
                    "2023 June" -> "Neptune begins retrograde motion"
                    "2023 July" -> ""
                    "2023 August" -> "Saturn is in Opposition on August 27" // Uranus begins retrograde motion
                    "2023 September" -> "September 19, 2023: Neptune at opposition"
                    "2023 October" -> ""
                    "2023 November" -> "Jupiter opposition 2023 – November 2" // 2023 Uranus opposition – November 13
                    "2023 December" -> ""

                    "2024 January" -> ""
                    "2024 February" -> ""
                    "2024 March" -> ""
                    "2024 April" -> ""
                    "2024 May" -> ""
                    "2024 June" -> ""
                    "2024 July" -> ""
                    "2024 August" -> ""
                    "2024 September" -> "Saturn is in Opposition on September 8"
                    "2024 October" -> ""
                    "2024 November" -> "2024 Uranus opposition – November 16"
                    "2024 December" -> "Jupiter opposition 2024 – December 7"

                    "2025 January" -> "Jupiter opposition 2025 – January 10" // "Mars is in Opposition on January 16th"
                    "2025 February" -> ""
                    "2025 March" -> ""
                    "2025 April" -> ""
                    "2025 May" -> ""
                    "2025 June" -> ""
                    "2025 July" -> ""
                    "2025 August" -> ""
                    "2025 September" -> "Saturn is in Opposition on September 25"
                    "2025 October" -> ""
                    "2025 November" -> "2025 Uranus opposition – November 21"
                    "2025 December" -> ""

                    else -> "Saturn"
                }
            return planetOpposition

        }
