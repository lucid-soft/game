package gg.rsmod.plugins.content.npcs.definitions.animals

import gg.rsmod.game.model.combat.SlayerAssignment
import gg.rsmod.plugins.content.drops.DropTableFactory

val ids =
    intArrayOf(Npcs.COW, Npcs.COW_397, Npcs.COW_1767, Npcs.COW_3309, Npcs.COW_12362, Npcs.COW_12363, Npcs.COW_12365)

val table = DropTableFactory
val cow =
    table.build {
        guaranteed {
            obj(Items.BONES)
            obj(Items.RAW_BEEF)
            obj(Items.COWHIDE)
        }

        main {
            total(1024)
            obj(Items.SLING, quantity = 1, slots = 64)
            nothing(slots = 960)
        }
        table("Charms") {
            total(1000)
            obj(Items.GOLD_CHARM, quantity = 1, slots = 9)
            obj(Items.GREEN_CHARM, quantity = 1, slots = 40)
            obj(Items.CRIMSON_CHARM, quantity = 1, slots = 3)
            obj(Items.BLUE_CHARM, quantity = 1, slots = 1)
            nothing(slots = 947)
        }
    }

table.register(cow, *ids)

on_npc_pre_death(*ids) {
    val p = npc.damageMap.getMostDamage()!! as Player
    p.playSound(Sfx.COW_DEATH)
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
            attack = Anims.COW_ATTACK
            death = Anims.COW_DEATH
            block = Anims.COW_BLOCK
        }
        slayer {
            level = 1
            experience = 8.0
            assignment = SlayerAssignment.COW
        }
    }
}
