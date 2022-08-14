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
                    "2023 October" -> "October 21, 22 - Orionids Meteor Shower"
                    "2023 November" -> "Jupiter opposition 2023 – November 2" // 2023 Uranus opposition – November 13
                    "2023 December" -> "December 13, 14 - Geminids Meteor Shower"

                    "2024 January" -> "Full Wolf Moon Jan 25th"
                    "2024 February" -> "Full Snow Moon Feb 24th"
                    "2024 March" -> "Mercury Visible at Sunset"
                    "2024 April" -> "Full Pink Moon April 23"
                    "2024 May" -> "Mercury Visible at Sunrise"
                    "2024 June" -> "Venus at superior solar conjunction : 04 Jun 2024"
                    "2024 July" -> "Pluto at Opposition : 23 Jul 2024" //Mercury visible at Sunset
                    "2024 August" -> "Full Sturgeon Moon Aug 19 "
                    "2024 September" -> "Saturn is in Opposition on September 8" //Mercury visible at Sunrise
                    "2024 October" -> "Full Hunter’s Moon October 17"
                    "2024 November" -> "2024 Uranus opposition – November 16" //Mercury visible at sunset
                    "2024 December" -> "Jupiter opposition 2024 – December 7"

                    "2025 January" -> "Jupiter opposition 2025 – January 10" // "Mars is in Opposition on January 16th"
                    "2025 February" -> "Venus at greatest brightness: 16 Feb 2025"
                    "2025 March" -> "Mercury visible at Sunset"
                    "2025 April" -> "April 12, 2025: Full Pink Moon"
                    "2025 May" -> "May 12, 2025: Full Flower Moon"
                    "2025 June" -> "June 11, 2025: Full Strawberry Moon"
                    "2025 July" -> "Pluto at Opposition :25 Jul 2025"
                    "2025 August" -> "August 9, 2025: Full Corn Moon"
                    "2025 September" -> "Saturn is in Opposition on September 25"
                    "2025 October" -> "October 6, 2025: Full Harvest Moon"
                    "2025 November" -> "2025 Uranus opposition – November 21"
                    "2025 December" -> "December 13, 14 - Geminids Meteor Shower"

                    else -> "none"
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
                    "2023 February" -> "February 5 , 10:30 am Full Snow Moon "
                    "2023 March" -> "Uranus at solar conjunction"
                    "2023 April" -> "Full Pink Moon April 5th"
                    "2023 May" -> "Mercury Visible at Sunrise"
                    "2023 June" -> "June 21 2023 Summer Solstice"
                    "2023 July" -> "Full Buck Moon July 3rd"
                    "2023 August" -> "Uranus begins retrograde motion"
                    "2023 September" -> "Fall Equinox Sep 23 2023"
                    "2023 October" -> "Full Hunter’s Moon October 28 , 1:24 pm"
                    "2023 November" -> "2023 Uranus opposition – November 13"
                    "2023 December" -> "Winter Solstice Dec 21 2023"

                    "2024 January" -> "January 3, 4 - Quadrantids Meteor Shower"
                    "2024 February" -> "None"
                    "2024 March" -> "Spring Equinox Mar 19 2024"
                    "2024 April" -> "April 8: Total Solar Eclipse parts of USA"
                    "2024 May" -> "May 6, 7 - Eta Aquarids Meteor Shower"
                    "2024 June" -> "Summer Solstice Jun 20 2024"
                    "2024 July" -> "Mercury visible at Sunset"
                    "2024 August" -> "August 12, 13 - Perseids Meteor Shower"
                    "2024 September" -> "Mercury visible at Sunrise"
                    "2024 October" -> "October 21, 22 - Orionids Meteor Shower"
                    "2024 November" -> "Mercury visible at sunset"
                    "2024 December" -> "Winter Solstice Dec 21 2024"

                    "2025 January" -> "Mars is in Opposition on January 16th"
                    "2025 February" -> "February 12 - Full Snow Moon"
                    "2025 March" -> "Spring Equinox Mar 20 2025"
                    "2025 April" -> "April 22, 23 - Lyrids Meteor Shower"
                    "2025 May" -> "May 6, 7 - Eta Aquarids Meteor Shower."
                    "2025 June" -> "Summer Solstice Jun 20 2025"
                    "2025 July" -> "July 28, 29 - Delta Aquarids Meteor Shower"
                    "2025 August" -> "August 12, 13 - Perseids Meteor Shower"
                    "2025 September" -> "Fall Equinox September 22 2025"
                    "2025 October" -> "October 21, 22 - Orionids Meteor Shower"
                    "2025 November" -> "November 4, 5 - Taurids Meteor Shower"
                    "2025 December" -> "Winter Solstice Dec 21 2025"

                    else -> "none"
                }
            return planetOpposition

        }
        private fun getPlanetEvent3(): String {
            val planetOpposition =
                when(getHoroscope()){
                    "Aries" -> "Monthly Ruling Planet: Mars"
                    "Taurus" -> "Monthly Ruling Planet: Venus"
                    "Gemini" -> "Monthly Ruling Planet: Mercury"
                    "Cancer" -> "Monthly Ruling in Sky: Moon"
                    "Leo" -> "Monthly Ruling in Sky: Sun"
                    "Virgo" -> "Monthly Ruling Planet: Mercury"
                    "Libra" -> "Monthly Ruling Planet: Venus"
                    "Scorpio" ->"Monthly Ruling Planet: Pluto"
                    "Sagittarius" -> "Monthly Ruling Planet: Jupiter"
                    "Capricorn" -> "Monthly Ruling Planet: Saturn"
                    "Aquarius" -> "Monthly Ruling Planet: Uranus"
                    "Pisces" -> "Monthly Ruling Planet: Neptune"
                    else -> "Monthly Ruling Planet: Saturn"
                }
            return planetOpposition

        }
       private fun getPlanetEventTYPE(): String {

            val planetType = when{
                getPlanetEvent().contains("moon") -> "moon"
                getPlanetEvent().contains("Moon") -> "moon"
                getPlanetEvent().contains("Solstice" )-> "sun"
                    getPlanetEvent().contains("Equinox")-> "sun"
                        getPlanetEvent().contains("solstice")-> "sun"
                            getPlanetEvent().contains("equinox")-> "sun"
                                getPlanetEvent().contains("Mercury")-> "mercury"
                                    getPlanetEvent().contains("Venus")-> "venus"
                                        getPlanetEvent().contains("Mars")-> "mars"
                                            getPlanetEvent().contains("Jupiter")-> "jupiter"
                                                getPlanetEvent().contains("Saturn")-> "saturn"
                                                    getPlanetEvent().contains("Uranus")-> "uranus"
                                                        getPlanetEvent().contains("Neptune")-> "neptune"
                                                            getPlanetEvent().contains("Pluto")-> "pluto"
                                                                getPlanetEvent().contains("Meteor")-> "sun"
                                                                    getPlanetEvent().contains("meteor")-> "sun"
                                                                        getPlanetEvent().contains("None")-> "none"
                    else -> "none"
            }

            return planetType
        }

        private fun getPlanetEventTYPE2(): String {

            val planetType2 : String = when{
                getPlanetEvent().contains("moon") -> "moon"
                getPlanetEvent().contains("Moon") -> "moon"
                getPlanetEvent().contains("Solstice" )-> "sun"
                getPlanetEvent().contains("Equinox")-> "sun"
                getPlanetEvent().contains("solstice")-> "sun"
                getPlanetEvent().contains("equinox")-> "sun"
                getPlanetEvent().contains("Mercury")-> "mercury"
                getPlanetEvent().contains("Venus")-> "venus"
                getPlanetEvent().contains("Mars")-> "mars"
                getPlanetEvent().contains("Jupiter")-> "jupiter"
                getPlanetEvent().contains("Saturn")-> "saturn"
                getPlanetEvent().contains("Uranus")-> "uranus"
                getPlanetEvent().contains("Neptune")-> "neptune"
                getPlanetEvent().contains("Pluto")-> "pluto"
                getPlanetEvent().contains("Meteor")-> "sun"
                getPlanetEvent().contains("meteor")-> "sun"
                getPlanetEvent().contains("None")-> "none"
                else -> "none"
            }

            return planetType2
        }

        private fun getPlanetEventTYPE3(): String {

            val planetType3 = when{
                getPlanetEvent3().contains("moon") -> "moon"
                getPlanetEvent3().contains("Moon") -> "moon"
                getPlanetEvent3().contains("Solstice" )-> "sun"
                getPlanetEvent3().contains("Equinox")-> "sun"
                getPlanetEvent3().contains("solstice")-> "sun"
                getPlanetEvent3().contains("equinox")-> "sun"
                getPlanetEvent3().contains("Mercury")-> "mercury"
                getPlanetEvent3().contains("Venus")-> "venus"
                getPlanetEvent3().contains("Mars")-> "mars"
                getPlanetEvent3().contains("Jupiter")-> "jupiter"
                getPlanetEvent3().contains("Saturn")-> "saturn"
                getPlanetEvent3().contains("Uranus")-> "uranus"
                getPlanetEvent3().contains("Neptune")-> "neptune"
                getPlanetEvent3().contains("Pluto")-> "pluto"
                getPlanetEvent3().contains("Meteor")-> "sun"
                getPlanetEvent3().contains("meteor")-> "sun"
                getPlanetEvent3().contains("None")-> "none"
                else -> "none"
            }

            return planetType3
        }


