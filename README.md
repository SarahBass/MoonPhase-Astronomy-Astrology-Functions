# Astrology and Astronomy Kotlin Functions

WORK IN PROGRESS- NOT COMPLETE
____________________________

### getHoroscope()

### getMoonPhase()

### getPlanetEvent()

### getMoonAlmanac()

____________________________

Description: Simple Horoscope and Moon Phase Functions in Kotlin (.kt) for Android Wear-OS

Uses Locally Stored Data: 2022-2030

UNDER CONSTRUCTION

* Disclaimer: Kotlin Functions designed for API 28 for WEAR-OS , Specifically and tested only on Ticwatch E-3.
Change as needed after 2030. The code goes directly in your .KT file. Data is all locally stored for convienence. In 2030, I will release an update Branch on this to include the next eight years of Moon Phase Data for a 2030 - 2038 Version. 

* ***Large Disclaimer: All data is only accurate for 8 years at a time (This version is for 2022 until 2030)***  

* All Moon Data was compiled from this source: https://www.timeanddate.com/moon/phases

<p align="center"> 
  
  <img src="https://github.com/SarahBass/GetHoroscope-and-GetMoonPhase-Kotlin/blob/main/Screen%20Shot%202022-08-13%20at%203.43.12%20PM.png" width="450" height="300" >
</p>

Moon Phase calculated by the standard ( Moon Age / Moon Cycle Length) = Moon Cycle Percentage % calculation. This will give you a roughly accurate picture of the moon, but not exact. To make it more exact, I have two arrays of 8 years data: New Moon dates and Full Moon dates. Two Functions will spit out Strings to tell you the exact dates which you can display next to the image to ensure better accuracy. The goal was to be accurate enough for the image to make sense to the user.   

* Solar Conjunction and Solar Opposition Functions are raw data from https://earthsky.org


<p align="center"> 
<img src="https://github.com/SarahBass/MoonPhase-Astronomy-Astrology-Functions/blob/main/Screen%20Shot%202022-08-13%20at%204.34.13%20PM.png" width="450" height="300" >
</p>

___________________________________________

# Contents

----------
## Functions
-----------

> getMoonPhase() returns a String for the moon Phase 

> getHoroscope() returns a String for the Horoscope Phase 

> getNewMoon() Returns a String for New Moon Date every month
 
> getFullMoon() Returns a String for Full Moon Date every month

> getPlanetEvent() Returns a String for Planet events
 
> getPlanetEventType() Returns a String for type of event 

> getMoonAlmanac() Returns a String for Almanac Moon

-------------


## MOON PHASES


New Moon

<img src="https://github.com/SarahBass/HoroscopeWatchAndroid/blob/main/GITHUB_PNG/newmoon.png" width="300" height="300">

Waxing Crescent Moon

<img src="https://github.com/SarahBass/HoroscopeWatchAndroid/blob/main/GITHUB_PNG/rightcrescent.png" width="300" height="300">

Waxing Half Moon

<img src="https://github.com/SarahBass/HoroscopeWatchAndroid/blob/main/GITHUB_PNG/halfmoonright.png" width="300" height="300">

Waxing Gibbous Moon

<img src="https://github.com/SarahBass/HoroscopeWatchAndroid/blob/main/GITHUB_PNG/gibright.png" width="300" height="300">

Full Moon

<img src="https://github.com/SarahBass/HoroscopeWatchAndroid/blob/main/GITHUB_PNG/fulloon.png" width="300" height="300">

Waning Gibbous Moon

<img src="https://github.com/SarahBass/HoroscopeWatchAndroid/blob/main/GITHUB_PNG/gibleft.png" width="300" height="300">

Waxing half Moon

<img src="https://github.com/SarahBass/HoroscopeWatchAndroid/blob/main/GITHUB_PNG/halfmoonleft.png" width="300" height="300">

Waxing Crescent Moon

<img src="https://github.com/SarahBass/HoroscopeWatchAndroid/blob/main/GITHUB_PNG/rightcrescent.png" width="300" height="300">

New moon

<img src="https://github.com/SarahBass/HoroscopeWatchAndroid/blob/main/GITHUB_PNG/newmoon.png" width="300" height="300">

-----------------------


## SPACE & PLANETS

SUN

<img src="https://github.com/SarahBass/MoonPhase-Astronomy-Astrology-Functions/blob/main/drawables/planets/sun.png" width="300" height="300">


MERCURY

<img src="https://github.com/SarahBass/HoroscopeWatchAndroid/blob/main/GITHUB_PNG/mercury.png" width="300" height="300">

VENUS

<img src="https://github.com/SarahBass/HoroscopeWatchAndroid/blob/main/GITHUB_PNG/venus.png" width="300" height="300">

EARTH

<img src="https://github.com/SarahBass/MoonPhase-Astronomy-Astrology-Functions/blob/main/drawables/planets/earth.png" width="300" height="300">

MARS

<img src="https://github.com/SarahBass/HoroscopeWatchAndroid/blob/main/GITHUB_PNG/mars.png" width="300" height="300">

METEOR

<img src="https://github.com/SarahBass/MoonPhase-Astronomy-Astrology-Functions/blob/main/drawables/planets/shower.png" width="300" height="300">

JUPITER

<img src="https://github.com/SarahBass/HoroscopeWatchAndroid/blob/main/GITHUB_PNG/jupiter.png" width="300" height="300">

SATURN

<img src="https://github.com/SarahBass/HoroscopeWatchAndroid/blob/main/GITHUB_PNG/saturn.png" width="300" height="300">

NEPTUNE

<img src="https://github.com/SarahBass/HoroscopeWatchAndroid/blob/main/GITHUB_PNG/neptune.png" width="300" height="300">

URANUS

<img src="https://github.com/SarahBass/HoroscopeWatchAndroid/blob/main/GITHUB_PNG/uranus.png" width="300" height="300">

PLUTO

<img src="https://github.com/SarahBass/HoroscopeWatchAndroid/blob/main/GITHUB_PNG/pluto.png" width="300" height="300">

-----------

## HOROSCOPES

Aquarius

<img src="https://github.com/SarahBass/HoroscopeWatchAndroid/blob/main/GITHUB_PNG/aquarius.png" width="300" height="300">

Aries

<img src="https://github.com/SarahBass/HoroscopeWatchAndroid/blob/main/GITHUB_PNG/aries.png" width="300" height="300">

Cancer

<img src="https://github.com/SarahBass/HoroscopeWatchAndroid/blob/main/GITHUB_PNG/cancer.png" width="300" height="300">

Capricorn

<img src="https://github.com/SarahBass/HoroscopeWatchAndroid/blob/main/GITHUB_PNG/capricorn.png" width="300" height="300">

Gemini

<img src="https://github.com/SarahBass/HoroscopeWatchAndroid/blob/main/GITHUB_PNG/gemini.png" width="300" height="300">

Leo

<img src="https://github.com/SarahBass/HoroscopeWatchAndroid/blob/main/GITHUB_PNG/leo.png" width="300" height="300">

Libra

<img src="https://github.com/SarahBass/HoroscopeWatchAndroid/blob/main/GITHUB_PNG/libra.png" width="300" height="300">

Pisces

<img src="https://github.com/SarahBass/HoroscopeWatchAndroid/blob/main/GITHUB_PNG/pisces.png" width="300" height="300">

Sagitarius

<img src="https://github.com/SarahBass/HoroscopeWatchAndroid/blob/main/GITHUB_PNG/sagitarius.png" width="300" height="300">

Scorpio

<img src="https://github.com/SarahBass/HoroscopeWatchAndroid/blob/main/GITHUB_PNG/scorpio.png" width="300" height="300">

Taurus

<img src="https://github.com/SarahBass/HoroscopeWatchAndroid/blob/main/GITHUB_PNG/taurus.png" width="300" height="300">

Virgo

<img src="https://github.com/SarahBass/HoroscopeWatchAndroid/blob/main/GITHUB_PNG/virgo.png" width="300" height="300">

-----------

## MOON Almanac


Wolf Moon : January

<img src="https://github.com/SarahBass/MoonPhase-Astronomy-Astrology-Functions/blob/main/drawables/moonAlmanac/moonwolf.png" width="300" height="300">

Snow Moon : February

<img src="https://github.com/SarahBass/MoonPhase-Astronomy-Astrology-Functions/blob/main/drawables/moonAlmanac/moonsnow.png" width="300" height="300">

Worm Moon : March

<img src="https://github.com/SarahBass/MoonPhase-Astronomy-Astrology-Functions/blob/main/drawables/moonAlmanac/moonworm.png" width="300" height="300">

Pink Moon : April & May

<img src="https://github.com/SarahBass/MoonPhase-Astronomy-Astrology-Functions/blob/main/drawables/moonAlmanac/moonpink.png" width="300" height="300">

Strawberry Moon: June

<img src="https://github.com/SarahBass/MoonPhase-Astronomy-Astrology-Functions/blob/main/drawables/moonAlmanac/moonstrawberry.png" width="300" height="300">

Animal Moon (Sturgeon and Buck) : July & August

<img src="https://github.com/SarahBass/MoonPhase-Astronomy-Astrology-Functions/blob/main/drawables/moonAlmanac/moonanimal.png" width="300" height="300">

Corn Moon: September

<img src="https://github.com/SarahBass/MoonPhase-Astronomy-Astrology-Functions/blob/main/drawables/moonAlmanac/mooncorn.png" width="300" height="300">

Harvest Moon: October

<img src="https://github.com/SarahBass/MoonPhase-Astronomy-Astrology-Functions/blob/main/drawables/moonAlmanac/moonharvest.png" width="300" height="300">

Beaver Moon: November

<img src="https://github.com/SarahBass/MoonPhase-Astronomy-Astrology-Functions/blob/main/drawables/moonAlmanac/moonbeaver.png" width="300" height="300">

Cold Moon : December

<img src="https://github.com/SarahBass/MoonPhase-Astronomy-Astrology-Functions/blob/main/drawables/moonAlmanac/mooncold.png" width="300" height="300">

-----------------------


## Contents:

<img src="https://github.com/SarahBass/HoroscopeWatchAndroid/blob/main/horoscopewatch.jpeg" width="300" height="150">

Contents | Description
------------- | -------------
MyWatchFace.kt | Kotlin/Java Code including functions that return Strings of the Horoscope and Moonphase
------------- | -------------
moonPhases | Free Drawable sources you could use for Moon Phases - Art Designed by myself in SVG using Vectornator on iPad, posted here as PNG 320X320 
------------- | -------------
Horoscopes | Free Drawable sources you could use for Horoscopes - Art Designed by myself in SVG using Vectornator on iPad, posted here as PNG 320X320
------------- | -------------
