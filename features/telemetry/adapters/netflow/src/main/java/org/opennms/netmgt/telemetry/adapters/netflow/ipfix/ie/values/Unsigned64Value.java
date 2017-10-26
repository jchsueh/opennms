/*******************************************************************************
 * This file is part of OpenNMS(R).
 *
 * Copyright (C) 2017 The OpenNMS Group, Inc.
 * OpenNMS(R) is Copyright (C) 1999-2017 The OpenNMS Group, Inc.
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

package org.opennms.netmgt.telemetry.adapters.netflow.ipfix.ie.values;

import static org.opennms.netmgt.telemetry.adapters.netflow.ipfix.BufferUtils.bytes;

import java.nio.ByteBuffer;

import org.opennms.netmgt.telemetry.adapters.netflow.ipfix.BufferUtils;
import org.opennms.netmgt.telemetry.adapters.netflow.ipfix.ie.Value;

import com.google.common.primitives.UnsignedLong;

public class Unsigned64Value extends Value {
    public final UnsignedLong value;

    public Unsigned64Value(final String name,
                           final UnsignedLong value) {
        super(name);
        this.value = value;
    }

    @Override
    public String toString() {
        return "Unsigned64Value{" +
                "value=" + value +
                '}';
    }

    public static Value.Parser parser(final String name) {
        return new Value.Parser() {
            @Override
            public Value parse(final ByteBuffer buffer) {
                return new Unsigned64Value(name, BufferUtils.uint(buffer, buffer.remaining()));
            }

            @Override
            public int getMaximumFieldLength() {
                return 8;
            }

            @Override
            public int getMinimumFieldLength() {
                return 1;
            }
        };
    }
}