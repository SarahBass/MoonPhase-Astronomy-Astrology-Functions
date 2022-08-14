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
                    "2022 January" -> "Jupiter in Pisces January 1 to May 9, 2022" //Mercury Visible at Sunset
                    "2022 February" -> "Venus Brightest on February 9, 2022" //Pluto returns. This happens only once 248 years
                    "2022 March" -> "March 20 - March Equinox" //March 18: Worm Moon
                    "2022 April" -> "Mercury will be visible at Sunrise" //April 16: Pink Moon
                    "2022 May" -> "May 16: Flower Moon" // May 5/6: Eta Aquarid Meteors
                    "2022 June" -> "June 28, 2022: Neptune begins retrograde motion" //Mercury Visible at Sunrise
                    "2022 July" -> "July 28, 2022: Jupiter begins retrograde motion" // Pluto at Opposition 20 Jul 2022
                    "2022 August" -> "Saturn is in Opposition on August 14" //August 24, 2022: Uranus begins retrograde motion
                    "2022 September" -> "Jupiter opposition 2022 – September 26" //Septemper 16, 2022: Neptune at opposition
                    "2022 October" -> "Saturn ends retrograde motion" //Mars in Retrograde October 30, 2022
                    "2022 November" -> "November 23, 2022: Jupiter ends retrograde motion" // 2022 Uranus opposition – November 9
                    "2022 December" -> "Mars is in Opposition on December 8" //Dec 21: December Solstice

                    "2023 January" -> "Uranus ends retrograde motion" //Jan 7, 2023: Inferior conjunction Mercury
                    "2023 February" -> "February 16, 2023: Saturn in conjunction with the sun"
                    "2023 March" -> "Neptune at solar conjunction" //Uranus at solar conjunction
                    "2023 April" -> "April 11, 2023: Jupiter at solar conjunction"
                    "2023 May" -> "Venus Brightest on 12 May 2023" // Mercury Visible at Sunrise
                    "2023 June" -> "Neptune begins retrograde motion"
                    "2023 July" -> "Pluto at Opposition : 22 Jul 2023"
                    "2023 August" -> "Saturn is in Opposition on August 27" // Uranus begins retrograde motion
                    "2023 September" -> "September 19, 2023: Neptune at opposition"
                    "2023 October" -> ""
                    "2023 November" -> "Jupiter opposition 2023 – November 2" // 2023 Uranus opposition – November 13
                    "2023 December" -> ""

                    "2024 January" -> ""
                    "2024 February" -> ""
                    "2024 March" -> "Mercury Visible at Sunset"
                    "2024 April" -> ""
                    "2024 May" -> "Mercury Visible at Sunrise"
                    "2024 June" -> "Venus at superior solar conjunction : 04 Jun 2024"
                    "2024 July" -> "Pluto at Opposition : 23 Jul 2024" //Mercury visible at Sunset
                    "2024 August" -> ""
                    "2024 September" -> "Saturn is in Opposition on September 8" //Mercury visible at Sunrise
                    "2024 October" -> ""
                    "2024 November" -> "2024 Uranus opposition – November 16" //Mercury visible at sunset
                    "2024 December" -> "Jupiter opposition 2024 – December 7"

                    "2025 January" -> "Jupiter opposition 2025 – January 10" // "Mars is in Opposition on January 16th"
                    "2025 February" -> "Venus at greatest brightness: 16 Feb 2025"
                    "2025 March" -> "Mercury visible at Sunset"
                    "2025 April" -> ""
                    "2025 May" -> ""
                    "2025 June" -> ""
                    "2025 July" -> "Pluto at Opposition :25 Jul 2025"
                    "2025 August" -> ""
                    "2025 September" -> "Saturn is in Opposition on September 25"
                    "2025 October" -> ""
                    "2025 November" -> "2025 Uranus opposition – November 21"
                    "2025 December" -> ""

                    else -> "Saturn"
                }
            return planetOpposition

        }

        private fun getPlanetEventTYPE1(): String {
            val d = Date()
            val sdf0 = SimpleDateFormat("yyyy MMMM")
            val yearMonth: String = sdf0.format(d)
            val planetOpposition =
                when(yearMonth){
                    "2022 January" -> "Jupiter" //Mercury
                    "2022 February" -> "Venus" //Pluto
                    "2022 March" -> "Equinox" //Moon
                    "2022 April" -> "Mercury" //Moon
                    "2022 May" -> "Moon" // Meteors
                    "2022 June" -> "Neptune" //Mercury
                    "2022 July" -> "Jupiter" // Pluto
                    "2022 August" -> "Saturn" //Uranus
                    "2022 September" -> "Jupiter" //Neptune
                    "2022 October" -> "Saturn" //Mars
                    "2022 November" -> "Jupiter" //Uranus
                    "2022 December" -> "Mars" //Solstice

                    "2023 January" -> "Uranus" //Mercury
                    "2023 February" -> "Saturn"
                    "2023 March" -> "Neptune" //Uranus
                    "2023 April" -> "Jupiter"
                    "2023 May" -> "Venus" // Mercury
                    "2023 June" -> "Neptune"
                    "2023 July" -> "Pluto"
                    "2023 August" -> "Saturn " // Uranus
                    "2023 September" -> "Neptune"
                    "2023 October" -> ""
                    "2023 November" -> "Jupiter" //Uranus
                    "2023 December" -> ""

                    "2024 January" -> ""
                    "2024 February" -> ""
                    "2024 March" -> "Mercury"
                    "2024 April" -> ""
                    "2024 May" -> "Mercury"
                    "2024 June" -> "Venus"
                    "2024 July" -> "Pluto" //Mercury
                    "2024 August" -> ""
                    "2024 September" -> "Saturn" //Mercury
                    "2024 October" -> ""
                    "2024 November" -> "Uranus" //Mercury
                    "2024 December" -> "Jupiter"

                    "2025 January" -> "Jupiter" // "Mars"
                    "2025 February" -> "Venus"
                    "2025 March" -> "Mercury"
                    "2025 April" -> ""
                    "2025 May" -> ""
                    "2025 June" -> ""
                    "2025 July" -> "Pluto"
                    "2025 August" -> ""
                    "2025 September" -> "Saturn"
                    "2025 October" -> ""
                    "2025 November" -> "Uranus"
                    "2025 December" -> ""

                    else -> "Saturn"
                }
            return planetOpposition

        }

        private fun getPlanetEvent2(): String {
            val d = Date()
            val sdf0 = SimpleDateFormat("yyyy MMMM")
            val yearMonth: String = sdf0.format(d)
            val planetOpposition =
                when(yearMonth){
                    "2022 January" -> "Mercury Visible at Sunset"
                    "2022 February" -> "Pluto returns. This happens only once 248 years"
                    "2022 March" -> "March 18: Worm Moon"
                    "2022 April" -> "April 16: Pink Moon"
                    "2022 May" -> "May 5/6: Eta Aquarid Meteors"
                    "2022 June" -> "Mercury Visible at Sunrise"
                    "2022 July" -> "Pluto at Opposition 20 Jul 2022"
                    "2022 August" -> "August 24, 2022: Uranus begins retrograde motion"
                    "2022 September" -> "Septemper 16, 2022: Neptune at opposition"
                    "2022 October" -> "Mars in Retrograde October 30, 2022"
                    "2022 November" -> "2022 Uranus opposition – November 9"
                    "2022 December" -> "Dec 21: December Solstice"

                    "2023 January" -> "Jan 7, 2023: Inferior conjunction Mercury"
                    "2023 February" -> ""
                    "2023 March" -> "Uranus at solar conjunction"
                    "2023 April" -> ""
                    "2023 May" -> "Mercury Visible at Sunrise"
                    "2023 June" -> ""
                    "2023 July" -> ""
                    "2023 August" -> "Uranus begins retrograde motion"
                    "2023 September" -> ""
                    "2023 October" -> ""
                    "2023 November" -> "2023 Uranus opposition – November 13"
                    "2023 December" -> ""

                    "2024 January" -> ""
                    "2024 February" -> ""
                    "2024 March" -> ""
                    "2024 April" -> ""
                    "2024 May" -> ""
                    "2024 June" -> ""
                    "2024 July" -> "Mercury visible at Sunset"
                    "2024 August" -> ""
                    "2024 September" -> "Mercury visible at Sunrise"
                    "2024 October" -> ""
                    "2024 November" -> "Mercury visible at sunset"
                    "2024 December" -> ""

                    "2025 January" -> "Mars is in Opposition on January 16th"
                    "2025 February" -> ""
                    "2025 March" -> ""
                    "2025 April" -> ""
                    "2025 May" -> ""
                    "2025 June" -> ""
                    "2025 July" -> ""
                    "2025 August" -> ""
                    "2025 September" -> ""
                    "2025 October" -> ""
                    "2025 November" -> ""
                    "2025 December" -> ""

                    else -> "Saturn"
                }
            return planetOpposition

        }

        private fun getPlanetEventTYPE2(): String {
            val d = Date()
            val sdf0 = SimpleDateFormat("yyyy MMMM")
            val yearMonth: String = sdf0.format(d)
            val planetOpposition =
                when(yearMonth){
                    "2022 January" -> "Mercury"
                    "2022 February" -> "Pluto"
                    "2022 March" -> "Moon"
                    "2022 April" -> "Moon"
                    "2022 May" -> "Meteors"
                    "2022 June" -> "Mercury"
                    "2022 July" -> "Pluto"
                    "2022 August" -> "Uranus"
                    "2022 September" -> "Neptune"
                    "2022 October" -> "Mars"
                    "2022 November" -> "Uranus"
                    "2022 December" -> "Solstice"

                    "2023 January" -> "Mercury"
                    "2023 February" -> ""
                    "2023 March" -> "Uranus"
                    "2023 April" -> ""
                    "2023 May" -> "Mercury"
                    "2023 June" -> ""
                    "2023 July" -> ""
                    "2023 August" -> "Uranus"
                    "2023 September" -> ""
                    "2023 October" -> ""
                    "2023 November" -> "Uranus"
                    "2023 December" -> ""

                    "2024 January" -> ""
                    "2024 February" -> ""
                    "2024 March" -> ""
                    "2024 April" -> ""
                    "2024 May" -> ""
                    "2024 June" -> ""
                    "2024 July" -> "Mercury"
                    "2024 August" -> ""
                    "2024 September" -> "Mercury"
                    "2024 October" -> ""
                    "2024 November" -> "Mercury"
                    "2024 December" -> ""

                    "2025 January" -> "Mars"
                    "2025 February" -> ""
                    "2025 March" -> ""
                    "2025 April" -> ""
                    "2025 May" -> ""
                    "2025 June" -> ""
                    "2025 July" -> ""
                    "2025 August" -> ""
                    "2025 September" -> ""
                    "2025 October" -> ""
                    "2025 November" -> ""
                    "2025 December" -> ""

                    else -> "Saturn"
                }
            return planetOpposition

        }
