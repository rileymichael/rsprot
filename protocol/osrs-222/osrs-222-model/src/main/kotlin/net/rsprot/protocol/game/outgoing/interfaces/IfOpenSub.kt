package net.rsprot.protocol.game.outgoing.interfaces

import net.rsprot.protocol.ServerProtCategory
import net.rsprot.protocol.game.outgoing.GameServerProtCategory
import net.rsprot.protocol.message.OutgoingGameMessage
import net.rsprot.protocol.message.toIntOrMinusOne
import net.rsprot.protocol.util.CombinedId

/**
 * If open-sub messages are used to open non-root interfaces
 * on root interfaces.
 *
 * Interface types:
 * ```
 * | Id |   Name  | Is modal |
 * |:--:|:-------:|:--------:|
 * |  0 |  Modal  |    Yes   |
 * |  1 | Overlay |    No    |
 * |  3 |  Client |    Yes   |
 * ```
 *
 * Note: Client type is only intended to be created/used by the client.
 * It is used for interfaces like input box (int, name, string) and is fully
 * managed client-sided.
 *
 * @property destinationInterfaceId the destination interface on which the sub
 * interface is being opened
 * @property destinationComponentId the component on the destination interface
 * on which the sub interface is being opened
 * @property interfaceId the sub interface id
 * @property type the type of the interface to be opened as (modal, overlay, client)
 */
@Suppress("MemberVisibilityCanBePrivate")
public class IfOpenSub(
    public val destinationCombinedId: CombinedId,
    private val _interfaceId: UShort,
    private val _type: UByte,
) : OutgoingGameMessage {
    public constructor(
        destinationInterfaceId: Int,
        destinationComponentId: Int,
        interfaceId: Int,
        type: Int,
    ) : this(
        CombinedId(destinationInterfaceId, destinationComponentId),
        interfaceId.toUShort(),
        type.toUByte(),
    )

    public val destinationInterfaceId: Int
        get() = destinationCombinedId.interfaceId
    public val destinationComponentId: Int
        get() = destinationCombinedId.componentId
    public val interfaceId: Int
        get() = _interfaceId.toIntOrMinusOne()
    public val type: Int
        get() = _type.toInt()
    override val category: ServerProtCategory
        get() = GameServerProtCategory.LOW_PRIORITY_PROT

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as IfOpenSub

        if (destinationCombinedId != other.destinationCombinedId) return false
        if (_interfaceId != other._interfaceId) return false
        if (_type != other._type) return false

        return true
    }

    override fun hashCode(): Int {
        var result = destinationCombinedId.hashCode()
        result = 31 * result + _interfaceId.hashCode()
        result = 31 * result + _type.hashCode()
        return result
    }

    override fun toString(): String =
        "IfOpenSub(" +
            "destinationInterfaceId=$destinationInterfaceId, " +
            "destinationComponentId=$destinationComponentId, " +
            "interfaceId=$interfaceId, " +
            "type=$type" +
            ")"
}
