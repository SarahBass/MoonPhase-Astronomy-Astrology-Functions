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
        
