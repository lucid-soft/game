package gg.rsmod.game.message

import gg.rsmod.game.message.encoder.*
import gg.rsmod.game.message.impl.*

/**
 * Stores all the [MessageEncoder]s that are used on the
 * [gg.rsmod.game.service.GameService].
 *
 * @author Tom <rspsmods@gmail.com>
 */
class MessageEncoderSet {
    /**
     * The [MessageEncoder]s stored in respect to their [Message] class.
     */
    private val encoders = hashMapOf<Class<out Message>, MessageEncoder<out Message>>()

    /**
     * Links [MessageEncoder] to their respective [Message] class.
     */
    fun init() {
        put(RebuildLoginEncoder(), RebuildLoginMessage::class.java)
        put(IfOpenSubEncoder(), IfOpenSubMessage::class.java)
        put(RebuildNormalEncoder(), RebuildNormalMessage::class.java)
        put(IfOpenTopEncoder(), IfOpenTopMessage::class.java)
        put(UpdateStatEncoder(), UpdateStatMessage::class.java)
        put(UpdateInvPartialEncoder(), UpdateInvPartialMessage::class.java)
        put(UpdateInvFullEncoder(), UpdateInvFullMessage::class.java)
        put(MessageGameEncoder(), MessageGameMessage::class.java)
        put(UpdateRunEnergyEncoder(), UpdateRunEnergyMessage::class.java)
        put(LogoutFullEncoder(), LogoutFullMessage::class.java)
        put(VarpSmallEncoder(), VarpSmallMessage::class.java)
        put(VarpLargeEncoder(), VarpLargeMessage::class.java)
        put(SetMapFlagEncoder(), SetMapFlagMessage::class.java)
        put(IfCloseSubEncoder(), IfCloseSubMessage::class.java)
        put(UpdateZoneFullFollowsEncoder(), UpdateZoneFullFollowsMessage::class.java)
        put(UpdateZonePartialFollowsEncoder(), UpdateZonePartialFollowsMessage::class.java)
        put(UpdateZonePartialEnclosedEncoder(), UpdateZonePartialEnclosedMessage::class.java)
        put(LodAddChangeEncoder(), LocAddChangeMessage::class.java)
        put(LocDelEncoder(), LocDelMessage::class.java)
        put(IfSetEventsEncoder(), IfSetEventsMessage::class.java)
        put(IfSetTextEncoder(), IfSetTextMessage::class.java)
        put(RunClientScriptEncoder(), RunClientScriptMessage::class.java)
        put(IfSetObjectEncoder(), IfSetObjectMessage::class.java)
        put(VarbitSmallEncoder(), VarbitSmallMessage::class.java)
        put(VarbitLargeEncoder(), VarbitLargeMessage::class.java)
        put(VarcSmallEncoder(), VarcSmallMessage::class.java)
        put(VarcLargeEncoder(), VarcLargeMessage::class.java)
        put(ObjAddEncoder(), ObjAddMessage::class.java)
        put(ObjDelEncoder(), ObjDelMessage::class.java)
        put(ObjCountEncoder(), ObjCountMessage::class.java)
        put(IfSetHideEncoder(), IfSetHideMessage::class.java)
        put(VarcStringEncoder(), VarcStringMessage::class.java)
        put(PublicChatEncoder(), PublicChatMessage::class.java)
        put(IfSetPlayerHeadEncoder(), IfSetPlayerHeadMessage::class.java)
        put(IfSetNpcHeadEncoder(), IfSetNpcHeadMessage::class.java)
        put(IfSetAnimEncoder(), IfSetAnimMessage::class.java)
        put(UpdateRunWeightEncoder(), UpdateRunWeightMessage::class.java)
        put(MapProjAnimEncoder(), MapProjAnimMessage::class.java)
        put(SetOpPlayerEncoder(), SetOpPlayerMessage::class.java)
        put(MusicEffectEncoder(), MusicEffectMessage::class.java)
        put(SoundAreaEncoder(), SoundAreaMessage::class.java)
        put(SynthSoundEncoder(), SynthSoundMessage::class.java)
        put(UpdateRebootTimerEncoder(), UpdateRebootTimerMessage::class.java)
        put(IfSetSpriteEncoder(), IfSetSpriteMessage::class.java)
        put(IfSetScrollVerticalEncoder(), IfSetScrollVerticalMessage::class.java)
        put(MidiSongEncoder(), MidiSongMessage::class.java)
        put(MapAnimEncoder(), MapAnimMessage::class.java)
        put(LocAnimEncoder(), LocAnimMessage::class.java)
        put(FriendListLoadedEncoder(), FriendListLoadedMessage::class.java)
        put(UpdateFriendListEncoder(), UpdateFriendListMessage::class.java)
        put(MessagePrivateReceivedEncoder(), MessagePrivateReceivedMessage::class.java)
        put(SetPublicTradeChatFilterEncoder(), SetPublicTradeChatFilterMessage::class.java)
        put(SetPrivateChatFilterEncoder(), SetPrivateChatFilterMessage::class.java)
        put(MessagePrivateSentEncoder(), MessagePrivateSentMessage::class.java)
        put(UpdateIgnoreListEncoder(), UpdateIgnoreListMessage::class.java)
        put(CameraForceAngleEncoder(), CameraForceAngleMessage::class.java)
        put(CameraMoveToEncoder(), CameraMoveToMessage::class.java)
        put(CameraShakeEncoder(), CameraShakeMessage::class.java)
        put(CameraResetEncoder(), CameraResetMessage::class.java)
        put(CameraLookAtEncoder(), CameraLookAtMessage::class.java)
        put(CameraSmoothResetEncoder(), CameraSmoothResetMessage::class.java)
        put(MinimapToggleEncoder(), MinimapToggleMessage::class.java)
        put(RebuildRegionEncoder(), RebuildRegionMessage::class.java)
    }

    private fun <T : Message> put(
        encoder: MessageEncoder<T>,
        message: Class<out T>,
    ) {
        encoders[message] = encoder
    }

    @Suppress("UNCHECKED_CAST")
    fun <T : Message> get(type: Class<out T>): MessageEncoder<Message>? {
        return encoders[type] as? MessageEncoder<Message>
    }
}
