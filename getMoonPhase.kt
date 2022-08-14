    private fun getMoonPhase(): String {
            val d = Date()
            val sdf1 = SimpleDateFormat("d")
            val dayOfMonth: String = sdf1.format(d)
            val LUNAR_MONTH = 29.530588853;
            val newMoondifference = abs((Integer.parseInt(dayOfMonth)) - (Integer.parseInt(getnewMoonDate())))
            val moonPercent : Double = newMoondifference / LUNAR_MONTH
            val moonString : String = if(moonPercent < 0.05 ){"New Moon"}
            else if (moonPercent >= .05 && moonPercent < 0.25 ){"Waxing Crescent Moon"}
            else if(moonPercent >=0.25 && moonPercent < 0.35){"Waxing Half Moon"}
            else if(moonPercent >=0.35 && moonPercent < 0.47){"Waxing Gibbous Moon"}
            else if(moonPercent >=0.47 && moonPercent < 0.55){"Full Moon"}
            else if(moonPercent >=0.55 && moonPercent < 0.65){"Waning Gibbous Moon"}
            else if(moonPercent >=0.65 && moonPercent < 0.75){"Waning half Moon"}
            else if(moonPercent >=0.75 && moonPercent < 0.95){"Waning Crescent Moon"}
            else {"New Moon"}
            return moonString
        }
        
        
        private fun getFullMoonDate(): String {
            val d = Date()
            val sdf0 = SimpleDateFormat("yyyy MMMM")
            val yearMonth: String = sdf0.format(d)
        val fullMoonDate = when(yearMonth){
            "2022 January" -> "17"
            "2022 February" -> "16"
            "2022 March" -> "18"
            "2022 April" -> "16"
            "2022 May" -> "16"
            "2022 June" -> "14"
            "2022 July" -> "13"
            "2022 August" -> "11"
            "2022 September" -> "10"
            "2022 October" -> "9"
            "2022 November" -> "8"
            "2022 December" -> "7"
            "2023 January" -> "6"
            "2023 February" -> "5"
            "2023 March" -> "7"
            "2023 April" -> "5"
            "2023 May" -> "5"
            "2023 June" -> "3"
            "2023 July" -> "3"
            "2023 August" -> "1"
            "2023 September" -> "29"
            "2023 October" -> "28"
            "2023 November" -> "27"
            "2023 December" -> "26"
            "2024 January" -> "25"
            "2024 February" -> "24"
            "2024 March" -> "25"
            "2024 April" -> "23"
            "2024 May" -> "23"
            "2024 June" -> "21"
            "2024 July" -> "21"
            "2024 August" -> "19"
            "2024 September" -> "17"
            "2024 October" -> "17"
            "2024 November" -> "15"
            "2024 December" -> "15"
            "2025 January" -> "13"
            "2025 February" -> "12"
            "2025 March" -> "13"
            "2025 April" -> "12"
            "2025 May" -> "12"
            "2025 June" -> "11"
            "2025 July" -> "10"
            "2025 August" -> "9"
            "2025 September" -> "7"
            "2025 October" -> "6"
            "2025 November" -> "5"
            "2025 December" -> "4"
            "2026 January" -> "3"
            "2026 February" -> "1"
            "2026 March" -> "3"
            "2026 April" -> "1"
            "2026 May" -> "1"
            "2026 June" -> "29"
            "2026 July" -> "29"
            "2026 August" -> "27"
            "2026 September" -> "26"
            "2026 October" -> "25"
            "2026 November" -> "24"
            "2026 December" -> "23"
            "2027 January" -> "22"
            "2027 February" -> "20"
            "2027 March" -> "22"
            "2027 April" -> "20"
            "2027 May" -> "20"
            "2027 June" -> "18"
            "2027 July" -> "18"
            "2027 August" -> "17"
            "2027 September" -> "15"
            "2027 October" -> "15"
            "2027 November" -> "13"
            "2027 December" -> "13"
            "2028 January" -> "11"
            "2028 February" -> "10"
            "2028 March" -> "10"
            "2028 April" -> "9"
            "2028 May" -> "8"
            "2028 June" -> "6"
            "2028 July" -> "6"
            "2028 August" -> "5"
            "2028 September" -> "3"
            "2028 October" -> "3"
            "2028 November" -> "2"
            "2028 December" -> "1"
            else -> "1"
        }
        return fullMoonDate
    }

        private fun getnewMoonDate(): String {
            val d = Date()
            val sdf0 = SimpleDateFormat("yyyy MMMM")
            val yearMonth: String = sdf0.format(d)
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
            return newMoonDate.toString()
        }
