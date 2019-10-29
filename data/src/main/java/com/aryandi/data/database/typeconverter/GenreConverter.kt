package com.aryandi.data.database.typeconverter

import androidx.room.TypeConverter

/**
 * @author Aryandi Putra (aryandi.putra@dana.id)
 * @version GenreConverter, v 0.1 2019-10-24 09:29 by Aryandi Putra
 */
class GenreConverter {
    @TypeConverter
    fun gettingListFromString(genreIds: String): List<Int> {
        val list = mutableListOf<Int>()

        val array = genreIds.split(",".toRegex()).dropLastWhile {
            it.isEmpty()
        }.toTypedArray()

        for (s in array) {
            if (s.isNotEmpty()) {
                list.add(s.toInt())
            }
        }
        return list
    }

    @TypeConverter
    fun writingStringFromList(list: List<Int>): String {
        var genreIds=""
        for (i in list) genreIds += ",$i"
        return genreIds
    }}
