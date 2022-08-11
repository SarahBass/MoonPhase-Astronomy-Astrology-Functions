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
        
        //Get moonphase: 
        /*
        private fun getMoonPhase(): String {
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
            val moonPercent : Double = 0.5

        val moonString = if((moonPercent * 100) in 0..10 || (moonPercent * 100) in 90..100){"Newmoon"}
            else if (toInt(moonPercent * 100) in 45..54) {"Full Moon"}
            else if((moonPercent * 100) in 10..24) {"Right Crescent Moon"}
            else if((moonPercent * 100) in 75..89) {"Left Crescent Moon"}
            else if((moonPercent * 100) in 35..44) {"Right Gib Moon"}
            else if((moonPercent * 100) in 55..64) {"left Gib Moon"}
        else if((moonPercent * 100) in 55..64) {"left Gib Moon"}
            else {"half moon"}
        //0-10% newmoon
        //10 - 25% crescent right
        //25%-35% halfmoon right
        //35-45% gib moon right
        // 45% to 55%  full moon
        // 55% to 65%  gib left moon
        //65% - 75% halfmoon left
        //75-90% crescent left
        //90-100% newmoon



            //array
            //January 31 2022
            //March 2 2022
            //April 30 2022
            //May 30 2022
            //June 28 2022
            //July 28 2022
            //August 27 2022
            //September 25 2022
            //October 25 2022
            //November 23 2022
            //December 23 2022


            // Date date = sdf5.parse(arrayNewMoon());
            //long diff = endDateValue.getTime() - startDateValue.getTime();
            //TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));

            //Moon Phases Function
            //moon phase length is roughly 29.5 days
            //get number of days in year current date, subtract days from newmoon
            //fraction less than 1 = newmoon 0-10% and 90%-100% newmoon
            //0-10% newmoon
            //10 - 25% crescent right
            //25%-35% halfmoon right
            //35-45% gib moon right
            // 45% to 55%  full moon
            // 55% to 65%  gib left moon
            //65% - 75% halfmoon left
            //75-90% crescent left
            //90-100% newmoon

            //daysSinceNewMoon  / 29.5 days
        }
            return moonString
        }*/
