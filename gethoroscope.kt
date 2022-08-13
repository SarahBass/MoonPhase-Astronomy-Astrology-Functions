fun handleUpdateTimeMessage() {
            invalidate()
            if (shouldTimerBeRunning()) {
                val timeMs = System.currentTimeMillis()
                val delayMs = INTERACTIVE_UPDATE_RATE_MS - timeMs % INTERACTIVE_UPDATE_RATE_MS
                mUpdateTimeHandler.sendEmptyMessageDelayed(MSG_UPDATE_TIME, delayMs)
            }
        }
        private fun getHoroscope(): String {

            val sdf = SimpleDateFormat("EEE")
            val sdf1 = SimpleDateFormat("EEEE")
            val sdf2 = SimpleDateFormat("MMMM")
            val sdf3 = SimpleDateFormat("d")
            val sdf4 = SimpleDateFormat("yyyy")
            val sdf5 = SimpleDateFormat("MMMM d yyyy")
            val d = Date()
            val dayOfTheWeek: String = sdf.format(d)
            val dayOfTheWeekLong: String = sdf1.format(d)
            val monthOfYear: String = sdf2.format(d)
            val dayOfMonth: String = sdf3.format(d)
            val year4digits: String = sdf4.format(d)
            val fullDateSpaces: String = sdf5.format(d)

            val horoscopeString = when(monthOfYear){
                "January" -> if(Integer.parseInt(dayOfMonth) in 1..19){ "Capricorn" }
                else {"Aquarius" }
                "February" ->  if(Integer.parseInt(dayOfMonth) in 1..18 ){"Aquarius"}
                else {"Pisces"}
                "March" -> if(Integer.parseInt(dayOfMonth) in 1..20 ){"Pisces"}
                else{ "Aries"}
                "April" -> if(Integer.parseInt(dayOfMonth) in 1..19 ){"Aries"}
                else {"Taurus"}
                "May" -> {"Taurus"}
                "June" -> if(Integer.parseInt(dayOfMonth) in 1..20 ){"Gemini"}
                else{"Cancer"}
                "July" -> if(Integer.parseInt(dayOfMonth) in 1..22) {"Cancer"}
                else {"Leo"}
                "August" ->if(Integer.parseInt(dayOfMonth) in 1..22){ "Leo"}
                else {"Virgo"}
                "September" -> if(Integer.parseInt(dayOfMonth) in 1..22) {"Virgo"}
               else{"Libra"}
                "October" -> if(Integer.parseInt(dayOfMonth) in 1..22) {"Libra"}
                else {"Scorpio"}
                "November" ->if(Integer.parseInt(dayOfMonth) in 1..21) { "Scorpio"}
                else {"Sagittarius"}
                "December" -> if(Integer.parseInt(dayOfMonth) in 1..21) { "Sagittarius"}
                else{ "Capricorn"}
                else -> "Cancer" }
            return horoscopeString
        }

         private fun drawAnimation(canvas: Canvas, bounds: Rect) {
            val scale = 1.5
            val dst = Rect(
                (bounds.left / scale).toInt(),
                (bounds.top / scale).toInt(),
                (bounds.right / scale).toInt(),
                (bounds.bottom / scale).toInt()
            )

            val frameTime = INTERACTIVE_UPDATE_RATE_MS

            val starsCount = 2
            val timeTimeSwitch = 20000


            val drawable = when (getAnimationCase()) {
         //Animation of Horoscope 
                    when(getHoroscope()) {
                        "Aquarius" -> R.drawable.aquarius
                        "Aries" -> R.drawable.aries
                        "Cancer" -> R.drawable.cancer1
                        "Capricorn" -> R.drawable.capricorn
                        "Gemini" -> R.drawable.gemini
                        "Leo" -> R.drawable.leo
                        "Libra" -> R.drawable.libra
                        "Pisces" -> R.drawable.pices
                        "Sagittarius" -> R.drawable.sagitarius
                        "Scorpio" -> R.drawable.scorpio
                        "Taurus" -> R.drawable.taurus
                        "Virgo" -> R.drawable.virgo
                     else -> R.drawable.rainbow1 }
                     }


            canvas.drawBitmap(
                BitmapFactory.decodeResource(applicationContext.resources, drawable),
                bounds,
                dst,
                null
            )
        
         private fun getMoonPhase(): String {
            val d = Date()
            val sdf0 = SimpleDateFormat("yyyy MMMM")
            val sdf1 = SimpleDateFormat("d")
            val yearMonth: String = sdf0.format(d)
            val dayOfMonth: String = sdf1.format(d)
            val LUNAR_MONTH = 29.530588853;
            val newMoonDate = when(yearMonth){
                "2022 January" -> 2
                "2022 February" -> 1
                "2022 March" -> 2
                "2022 April" -> 1
                "2022 May" -> 30
                "2022 June" -> 28
                "2022 July" -> 28
                "2022 August" -> 27
                "2022 September" -> 25
                "2022 October" -> 25
                "2022 November" -> 23
                "2022 December" -> 23
                "2023 January" -> 21
                "2023 February" -> 19
                "2023 March" -> 21
                "2023 April" -> 19
                "2023 May" -> 19
                "2023 June" -> 17
                "2023 July" -> 17
                "2023 August" -> 16
                "2023 September" -> 14
                "2023 October" -> 14
                "2023 November" -> 13
                "2023 December" -> 12
                else -> 1
            }
            val fullMoonDate = when(yearMonth){
                "2022 January" -> 17
                "2022 February" -> 16
                "2022 March" -> 18
                "2022 April" -> 16
                "2022 May" -> 16
                "2022 June" -> 14
                "2022 July" -> 13
                "2022 August" -> 11
                "2022 September" -> 10
                "2022 October" -> 9
                "2022 November" -> 8
                "2022 December" -> 7
                "2023 January" -> 6
                "2023 February" -> 5
                "2023 March" -> 7
                "2023 April" -> 5
                "2023 May" -> 5
                "2023 June" -> 3
                "2023 July" -> 3
                "2023 August" -> 1
                "2023 September" -> 29
                "2023 October" -> 28
                "2023 November" -> 27
                "2023 December" -> 26
                else -> 1
            }

            val newMoondifference = abs((Integer.parseInt(dayOfMonth)) - newMoonDate)
            val moonPercent: Double = newMoondifference / LUNAR_MONTH
            val moonString : String = if(moonPercent < 0.05 ){"New Moon"}
            else if (moonPercent >= .05 && moonPercent < 0.25 ){"Waxing Crescent Moon"}
            else if(moonPercent >=0.25 && moonPercent < 0.35){"Waxing Half Moon"}
            else if(moonPercent >=0.35 && moonPercent < 0.47){"Waxing Gibbous Moon"}
            else if(moonPercent >=0.47 && moonPercent < 0.55){"Full Moon"}
            else if(moonPercent >=0.55 && moonPercent < 0.65){"Waning Gibbous Moon"}
            else if(moonPercent >=0.65 && moonPercent < 0.75){"Waning half Moon"}
            else if(moonPercent >=0.75 && moonPercent < 0.95){"Waning Crescent Moon"}
            else {"New Moon"}
            //0% - 5% new moon | USE : ARRAY EXACT DATE
            //5% - 25% crescent right
            //25% - 35% half moon right
            //35 - 45% gib moon right
            // 45% - 55%  full moon | USE : ARRAY EXACT DATE
            // 55% - 65%  gib left moon
            //65% - 75% half moon left
            //75% - 90% crescent left
            //90% - 100% new moon | USE : ARRAY EXACT DATE
            return moonString
        }
