package net.rsprot.protocol.game.incoming.codec.players

import net.rsprot.buffer.JagByteBuf
import net.rsprot.protocol.ClientProt
import net.rsprot.protocol.game.incoming.players.OpPlayerEvent
import net.rsprot.protocol.game.incoming.prot.GameClientProt
import net.rsprot.protocol.message.codec.MessageDecoder

public class OpPlayer7Decoder : MessageDecoder<OpPlayerEvent> {
    override val prot: ClientProt = GameClientProt.OPPLAYER7

    override fun decode(buffer: JagByteBuf): OpPlayerEvent {
        val controlKey = buffer.g1Alt2() == 1
        val index = buffer.g2Alt1()
        return OpPlayerEvent(
            index,
            controlKey,
            7,
        )
    }
}
