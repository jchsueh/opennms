/*******************************************************************************
 * This file is part of OpenNMS(R).
 *
 * Copyright (C) 2018 The OpenNMS Group, Inc.
 * OpenNMS(R) is Copyright (C) 1999-2018 The OpenNMS Group, Inc.
 *
 * OpenNMS(R) is a registered trademark of The OpenNMS Group, Inc.
 *
 * OpenNMS(R) is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
 *
 * OpenNMS(R) is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with OpenNMS(R).  If not, see:
 *      http://www.gnu.org/licenses/
 *
 * For more information contact:
 *     OpenNMS(R) Licensing <license@opennms.org>
 *     http://www.opennms.org/
 *     http://www.opennms.com/
 *******************************************************************************/

package org.opennms.netmgt.telemetry.listeners.sflow.proto.flows;

import java.nio.ByteBuffer;

import org.opennms.netmgt.telemetry.listeners.api.utils.BufferUtils;
import org.opennms.netmgt.telemetry.listeners.sflow.InvalidPacketException;

// struct extended_socket_ipv6 {
//    unsigned int protocol;     /* IP Protocol type
//                                  (for example, TCP = 6, UDP = 17) */
//    ip_v6 local_ip;            /* local IP address */
//    ip_v6 remote_ip;           /* remote IP address */
//    unsigned int local_port;   /* TCP/UDP local port number or equivalent */
//    unsigned int remote_port;  /* TCP/UDP remote port number of equivalent */
// };

public class ExtendedSocketIpv6 implements FlowData {
    public final long protocol;
    public final IpV6 local_ip;
    public final IpV6 remote_ip;
    public final long local_port;
    public final long remote_port;

    public ExtendedSocketIpv6(final ByteBuffer buffer) throws InvalidPacketException {
        this.protocol = BufferUtils.uint32(buffer);
        this.local_ip = new IpV6(buffer);
        this.remote_ip = new IpV6(buffer);
        this.local_port = BufferUtils.uint32(buffer);
        this.remote_port = BufferUtils.uint32(buffer);
    }
}