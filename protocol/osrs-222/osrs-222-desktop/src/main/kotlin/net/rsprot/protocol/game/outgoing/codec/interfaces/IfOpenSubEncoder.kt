package net.rsprot.protocol.game.outgoing.codec.interfaces

import io.netty.channel.ChannelHandlerContext
import net.rsprot.buffer.JagByteBuf
import net.rsprot.protocol.ServerProt
import net.rsprot.protocol.game.outgoing.interfaces.IfOpenSub
import net.rsprot.protocol.game.outgoing.prot.GameServerProt
import net.rsprot.protocol.message.codec.MessageEncoder
import net.rsprot.protocol.util.pCombinedIdAlt2

public class IfOpenSubEncoder : MessageEncoder<IfOpenSub> {
    override val prot: ServerProt = GameServerProt.IF_OPENSUB

    override fun encode(
        ctx: ChannelHandlerContext,
        buffer: JagByteBuf,
        message: IfOpenSub,
    ) {
        buffer.p1Alt2(message.type)
        buffer.p2Alt2(message.interfaceId)
        buffer.pCombinedIdAlt2(message.destinationCombinedId)
    }
}
