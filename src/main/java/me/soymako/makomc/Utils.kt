package me.soymako.makomc

class Utils {

    fun <T> getUniqueElements(list:MutableList<T>, exclude: MutableList<T>): List<T>{
        return list.filter { !exclude.contains(it) }
    }

}