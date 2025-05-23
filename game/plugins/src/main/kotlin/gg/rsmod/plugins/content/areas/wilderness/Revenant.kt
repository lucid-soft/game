package gg.rsmod.plugins.content.areas.wilderness

import gg.rsmod.plugins.api.cfg.Anims
import gg.rsmod.plugins.api.cfg.Npcs

enum class Revenant(
    val id: Int,
    val mageAnim: Int,
    val rangedAnim: Int,
    val healAnim: Int
) {
    REVENANT_IMP(
        Npcs.REVENANT_IMP, Anims.REVENANT_IMP_MAGE_ATTACK, Anims.REVENANT_IMP_RANGED_ATTACK,
        Anims.REVENANT_IMP_HEAL),
    REVENANT_GOBLIN_15(
        Npcs.REVENANT_GOBLIN, Anims.REVENANT_GOBLIN_MAGE_ATTACK, Anims.REVENANT_GOBLIN_RANGED_ATTACK,
        Anims.REVENANT_GOBLIN_HEAL),
    REVENANT_GOBLIN_30(
        Npcs.REVENANT_GOBLIN_13468, Anims.REVENANT_GOBLIN_MAGE_ATTACK, Anims.REVENANT_GOBLIN_RANGED_ATTACK,
        Anims.REVENANT_GOBLIN_HEAL),
    REVENANT_GOBLIN_37(
        Npcs.REVENANT_GOBLIN_13469, Anims.REVENANT_GOBLIN_MAGE_ATTACK, Anims.REVENANT_GOBLIN_RANGED_ATTACK,
        Anims.REVENANT_GOBLIN_HEAL),
    REVENANT_ICEFIEND(
        Npcs.REVENANT_ICEFIEND, Anims.REVENANT_FIEND_MAGE_ATTACK, Anims.REVENANT_FIEND_RANGED_ATTACK,
        Anims.REVENANT_FIEND_HEAL),
    REVENANT_PYREFIEND(
        Npcs.REVENANT_PYREFIEND, Anims.REVENANT_FIEND_MAGE_ATTACK, Anims.REVENANT_FIEND_RANGED_ATTACK,
        Anims.REVENANT_FIEND_HEAL),
    REVENANT_HOBGOBLIN(
        Npcs.REVENANT_HOBGOBLIN, Anims.REVENANT_HOBGOBLIN_MAGE_ATTACK, Anims.REVENANT_HOBGOBLIN_RANGED_ATTACK,
        Anims.REVENANT_HOBGOBLIN_HEAL),
    REVENANT_VAMPYRE(
        Npcs.REVENANT_VAMPYRE, Anims.REVENANT_VAMPYRE_MAGE_ATTACK, Anims.REVENANT_VAMPYRE_RANGED_ATTACK,
        Anims.REVENANT_VAMPYRE_HEAL),
    REVENANT_WEREWOLF(
        Npcs.REVENANT_WEREWOLF, Anims.REVENANT_WEREWOLF_MAGE_ATTACK, Anims.REVENANT_WEREWOLF_RANGED_ATTACK,
        Anims.REVENANT_WEREWOLF_HEAL),
    REVENANT_CYCLOPS(
        Npcs.REVENANT_CYCLOPS, Anims.REVENANT_CYCLOPS_MAGE_ATTACK, Anims.REVENANT_CYCLOPS_RANGED_ATTACK,
        Anims.REVENANT_CYCLOPS_HEAL),
    REVENANT_HELLHOUND(
        Npcs.REVENANT_HELLHOUND, Anims.REVENANT_HELLHOUND_MAGE_ATTACK, Anims.REVENANT_HELLHOUND_RANGED_ATTACK,
        Anims.REVENANT_HELLHOUND_HEAL),
    REVENANT_DEMON(
        Npcs.REVENANT_DEMON, Anims.REVENANT_DMEON_MAGE_ATTACK, Anims.REVENANT_DEMON_RANGED_ATTACK,
        Anims.REVENANT_DEMON_HEAL),
    REVENANT_ORK(
        Npcs.REVENANT_ORK, Anims.REVENANT_ORK_MAGE_ATTACK, Anims.REVENANT_ORK_RANGED_ATTACK,
        Anims.REVENANT_ORK_HEAL),
    REVENANT_DARK_BEAST(
        Npcs.REVENANT_DARK_BEAST, Anims.REVENANT_DARK_BEAST_MAGE_ATTACK, Anims.REVENANT_DARK_BEAST_RANGED_ATTACK,
        Anims.REVENANT_DARK_BEAST_HEAL),
    REVENANT_KNIGHT(
        Npcs.REVENANT_KNIGHT, Anims.REVENANT_KNIGHT_MAGE_ATTACK, Anims.REVENANT_KNIGHT_RANGED_ATTACK,
        Anims.REVENANT_KNIGHT_HEAL),
    REVENANT_DRAGON(
        Npcs.REVENANT_DRAGON, Anims.REVENANT_DRAGON_PROJ, Anims.REVENANT_DRAGON_PROJ,
        Anims.REVENANT_DRAGON_HEAL)
    ;

    companion object {
        fun forId(id: Int): Revenant {
            Revenant.values().forEach {
                if (it.id == id) {
                    return it
                }
            }
            return REVENANT_IMP
        }
    }

}
