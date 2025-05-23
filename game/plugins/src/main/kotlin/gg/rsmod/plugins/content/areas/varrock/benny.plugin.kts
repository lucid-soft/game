package gg.rsmod.plugins.content.areas.varrock

/**
 * @author MrSlayerGod <https://github.com/MrSlayerGod>
 */

val FORCE_CHAT_TIMER = TimerKey()
val DELAY = 33..50 // ~20 to 30 seconds

on_npc_spawn(npc = Npcs.BENNY) {
    npc.timers[FORCE_CHAT_TIMER] = world.random(DELAY)
}

on_timer(FORCE_CHAT_TIMER) {
    when (world.random(3)) {
        0 -> npc.forceChat("Varrock Herald, on sale here!")
        1 -> npc.forceChat("Get your Varrock Herald here!")
        3 -> npc.forceChat("Extra! Extra! Read all about it!")
    }
    npc.timers[FORCE_CHAT_TIMER] = world.random(DELAY)
}

on_npc_option(Npcs.BENNY, option = "talk-to") {
    player.queue { chat(this) }
}

suspend fun chat(it: QueueTask) {
    val title = when (it.player.appearance) {
        Appearance.DEFAULT -> "Guv"
        Appearance.DEFAULT_FEMALE -> "Missus"
        else -> "Guv"
    }

    when (
        it.options(
            "Can I have a newspaper, please?",
            "How much does a paper cost?",
            "Varrock Herald? Never heard of it.",
            "Anything interesting in there?",
        )
    ) {
        1 -> {
            it.chatPlayer("Can I have a newspaper, please?")
            it.chatNpc("Certainly, $title. That'll be 50 gold pieces, please.")
            when (it.options("Sure, here you go...", "No, thanks.")) {
                1 -> {
                    if (it.player.inventory.hasFreeSpace()) {
                        if (it.player.inventory.remove(Items.COINS_995, 50).hasSucceeded()) {
                            it.player.inventory.add(Items.NEWSPAPER)
                            it.chatPlayer("Sure, here you go...")
                        } else {
                            it.chatNpc("Well, no cash, no paper. Live in ignorance.")
                        }
                    }
                }
                2 -> {
                    it.chatPlayer("No, thanks.", facialExpression = FacialExpression.CALM_TALK)
                    it.chatNpc("Okay, suit yourself. Plenty more fish in the sea.", facialExpression = FacialExpression.HAPPY_TALKING)
                }
            }
        }
        2 -> {
            it.chatPlayer("How much does a paper cost?", facialExpression = FacialExpression.CONFUSED)
            it.chatNpc("Just 50 coins! A steal,", "if you ask me. Do you want one or not?", facialExpression = FacialExpression.CALM_TALK, wrap = true)
            when (it.options("Yes, please.", "No, thanks.")) {
                1 -> {
                    it.chatPlayer("Yes, please.", facialExpression = FacialExpression.HAPPY_TALKING)
                    if (it.player.inventory.hasFreeSpace()) {
                        if (it.player.inventory.remove(Items.COINS_995, 50).hasSucceeded()) {
                            it.player.inventory.add(Items.NEWSPAPER)
                        } else {
                            it.chatNpc("Well, no cash, no paper. Live in ignorance.", facialExpression = FacialExpression.ANGRY)
                        }
                    }
                }
                2 -> {
                    it.chatPlayer("No, thanks.", facialExpression = FacialExpression.CALM_TALK)
                    it.chatNpc("Okay, suit yourself. Plenty more fish in the sea.", facialExpression = FacialExpression.HAPPY_TALKING)
                }
            }
        }
        3 -> {
            it.chatPlayer("Varrock Herald? Never heard of it.", facialExpression = FacialExpression.CONFUSED)
            it.chatNpc(
                "For the illiterate amongst us, I shall elucidate. The",
                "Varrock Herald is a new newspaper.",
                facialExpression = FacialExpression.HAPPY_TALKING
            )
            it.chatNpc(
                "It is edited, printed ",
                "and published by myself, Benny Gutenberg, and each",
                "edition promises to enthrall the reader with captivating material!",
                facialExpression = FacialExpression.HAPPY_TALKING
            )
            it.chatNpc(
                "Now, can I interest you in buying one for a mere 50 coins? ",
                "You won't regret it, I assure you.",
                facialExpression = FacialExpression.HAPPY_TALKING
            )
            when (it.options("Yes, please.", "No, thanks.")) {
                1 -> {
                    it.chatPlayer("Yes, please.", facialExpression = FacialExpression.HAPPY_TALKING)
                    if (it.player.inventory.hasFreeSpace()) {
                        if (it.player.inventory.remove(Items.COINS_995, 50).hasSucceeded()) {
                            it.player.inventory.add(Items.NEWSPAPER)
                        } else {
                            it.chatNpc("Well, no cash, no paper. Live in ignorance.", facialExpression = FacialExpression.ANGRY)
                        }
                    }
                }
                2 -> {
                    it.chatPlayer("No, thanks.", facialExpression = FacialExpression.CALM_TALK)
                    it.chatNpc("Okay, suit yourself. Plenty more fish in the sea.", facialExpression = FacialExpression.HAPPY_TALKING)
                }
            }
        }
        4 -> {
            it.chatPlayer("Anything interesting in there?", facialExpression = FacialExpression.CONFUSED)
            it.chatNpc("Of course there is, mate. Packed full of thought-provoking ", "insights, contentious interviews and celebrity scandalmongering!", facialExpression = FacialExpression.HAPPY_TALKING)
            it.chatNpc("An excellent read and all for just 50 coins!", "What are you waiting for? Grab one before they run out!", facialExpression = FacialExpression.HAPPY_TALKING)
            when (it.options("Yes, please.", "No, thanks.")) {
                1 -> {
                    it.chatPlayer("Yes, please.", facialExpression = FacialExpression.HAPPY_TALKING)
                    if (it.player.inventory.hasFreeSpace()) {
                        if (it.player.inventory.remove(Items.COINS_995, 50).hasSucceeded()) {
                            it.player.inventory.add(Items.NEWSPAPER)
                        } else {
                            it.chatNpc("Well, no cash, no paper. Live in ignorance.", facialExpression = FacialExpression.ANGRY)
                        }
                    }
                }
                2 -> {
                    it.chatPlayer("No, thanks.", facialExpression = FacialExpression.CALM_TALK)
                    it.chatNpc("Okay, suit yourself. Plenty more fish in the sea.", facialExpression = FacialExpression.HAPPY_TALKING)
                }
            }
        }
    }

}
