package com.droidyme.mysoc.model

data class Section(
    val id: Int,
    val name: String,
    val modules: ArrayList<Module> = arrayListOf()
) {
    data class Module(
        val id: Int,
        val icon: Int,
        val name: String
    )
}

