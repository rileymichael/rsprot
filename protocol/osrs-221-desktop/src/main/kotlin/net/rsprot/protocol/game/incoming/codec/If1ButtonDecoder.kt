package net.rsprot.protocol.game.incoming.codec

import net.rsprot.buffer.JagByteBuf
import net.rsprot.protocol.ClientProt
import net.rsprot.protocol.game.incoming.If1ButtonEvent
import net.rsprot.protocol.game.incoming.prot.GameClientProt
import net.rsprot.protocol.message.codec.MessageDecoder
import net.rsprot.protocol.metadata.Consistent
import net.rsprot.protocol.util.gCombinedId

@Consistent
public class If1ButtonDecoder : MessageDecoder<If1ButtonEvent> {
    override val prot: ClientProt = GameClientProt.IF_BUTTON

    override fun decode(buffer: JagByteBuf): If1ButtonEvent {
        val combinedId = buffer.gCombinedId()
        return If1ButtonEvent(combinedId)
    }
}
