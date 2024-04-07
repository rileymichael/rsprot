package net.rsprot.protocol.game.outgoing.specific

import net.rsprot.protocol.message.OutgoingMessage

/**
 * Npc spot-anim specific packets are used to play a spotanim on a NPC
 * for a specific player and not the entire world.
 * @property index the index of the NPC in the world
 * @property id the id of the spotanim to play
 * @property slot the slot of the spotanim
 * @property height the height of the spotanim
 * @property delay the delay of the spotanim in client cycles (20ms/cc)
 */
@Suppress("MemberVisibilityCanBePrivate", "DuplicatedCode")
public class NpcSpotAnimSpecific private constructor(
    private val _index: UShort,
    private val _id: UShort,
    private val _slot: UByte,
    private val _height: UShort,
    private val _delay: UShort,
) : OutgoingMessage {
    public constructor(
        index: Int,
        id: Int,
        slot: Int,
        height: Int,
        delay: Int,
    ) : this(
        index.toUShort(),
        id.toUShort(),
        slot.toUByte(),
        height.toUShort(),
        delay.toUShort(),
    )

    public val index: Int
        get() = _index.toInt()
    public val id: Int
        get() = _id.toInt()
    public val slot: Int
        get() = _slot.toInt()
    public val height: Int
        get() = _height.toInt()
    public val delay: Int
        get() = _delay.toInt()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as NpcSpotAnimSpecific

        if (_index != other._index) return false
        if (_id != other._id) return false
        if (_slot != other._slot) return false
        if (_height != other._height) return false
        if (_delay != other._delay) return false

        return true
    }

    override fun hashCode(): Int {
        var result = _index.hashCode()
        result = 31 * result + _id.hashCode()
        result = 31 * result + _slot.hashCode()
        result = 31 * result + _height.hashCode()
        result = 31 * result + _delay.hashCode()
        return result
    }

    override fun toString(): String {
        return "NpcSpotAnimSpecific(" +
            "index=$index, " +
            "id=$id, " +
            "slot=$slot, " +
            "height=$height, " +
            "delay=$delay" +
            ")"
    }
}
