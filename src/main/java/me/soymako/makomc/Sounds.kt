package me.soymako.makomc

import org.bukkit.Bukkit
import org.bukkit.Sound
import org.bukkit.entity.Player

class Sounds {

    fun errorOrWarn(p: Player){
        p.playSound(p, Sound.ENTITY_GHAST_SCREAM, 1f, 1f)
    }

    fun succes(p: Player){
        p.playSound(p, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f,1f)
    }


}