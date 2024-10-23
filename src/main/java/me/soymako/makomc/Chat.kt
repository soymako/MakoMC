package me.soymako.makomc

import org.bukkit.ChatColor
import org.bukkit.Sound
import org.bukkit.entity.Player

class Chat {

    fun playerMessage(p:Player, t:String){
        p.sendMessage(translate(t))
    }

    fun translate(t:String): String{
        return ChatColor.translateAlternateColorCodes('&', t)
    }

    private fun getErrorPrefix():String{
        return translate("&e&l[&c&lError&e&l]&r ")
    }

    private fun getWarnPrefix():String{
        return translate("&e&l[&c&lAdvertencia&e&l]&r ")
    }

    private fun getAlertPrefix():String{
        return translate("&e&l[Alerta]&r ")
    }

    private fun getMACPrefix():String{
        return translate("&c&l[&4&lMAC&c&l]&r ")
    }

    private fun getStaffPrefix():String{
        return translate("&d&l[&d&lStaff&d&l]&r ")
    }

    fun commandError(p:Player, t:String?, usage:String, sound:Boolean) {
        if (sound){
            Sounds().errorOrWarn(p)
        }
        if (t == null) {
            playerMessage(
                p,
                getErrorPrefix() + "&cError al usar el comando. Esta es la sintaxis que debes de seguir: &e\n$usage"
            )
            return
        }
        playerMessage(p, getErrorPrefix() + t + "\n&eUso: $usage")
    }

    fun commandNotAllowed(p:Player, t:String?, sound:Boolean){
        if (sound){
            Sounds().errorOrWarn(p)
        }
        if (t == null){
            playerMessage(p, "&cNo tienes permisos de usar este comando...")
        }
        else{
            playerMessage(p, t)
        }
    }

    fun succes(p:Player, t:String, sound:Boolean){
        if (sound){
            Sounds().succes(p)
        }
        playerMessage(p, "&a$t")
    }

    fun alerta(p:Player, t:String, sound:Boolean){
        if (sound){
            Sounds().errorOrWarn(p)
        }
        playerMessage(p, getAlertPrefix() + "&c$t")
    }

}