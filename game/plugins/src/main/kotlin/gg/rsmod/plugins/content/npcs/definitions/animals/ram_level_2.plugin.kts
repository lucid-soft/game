package gg.rsmod.plugins.content.npcs.definitions.animals

import gg.rsmod.plugins.content.drops.DropTableFactory

val ids = intArrayOf(Npcs.RAM, Npcs.RAM_3673, Npcs.RAM_5168, Npcs.RAM_12369, Npcs.RAM_12370, Npcs.RAM_12371)

val table = DropTableFactory
val ram =
    table.build {
        guaranteed {
            obj(Items.BONES)
        }
    }

table.register(ram, *ids)

on_npc_pre_death(*ids) {
    val p = npc.damageMap.getMostDamage()!! as Player
    p.playSound(Sfx.RAM_DEATH)
}

on_npc_death(*ids) {
    table.getDrop(world, npc.damageMap.getMostDamage()!! as Player, npc.id, npc.tile)
}

ids.forEach {
    set_combat_def(it) {
        configs {
            attackSpeed = 4
            respawnDelay = 45
        }
        stats {
            hitpoints = 80
            attack = 1
            strength = 1
            defence = 1
            magic = 1
            ranged = 1
        }
        bonuses {
            attackStab = -15
            attackCrush = -15
            defenceStab = -21
            defenceSlash = -21
            defenceCrush = -21
            defenceMagic = -21
            defenceRanged = -21
        }
        anims {
            attack = Anims.RAM_ATTACK
            death = Anims.RAM_DEATH
            block = Anims.RAM_BLOCK
        }
    }
}
