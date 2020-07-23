/*******************************************************************************
 * This file is part of OpenNMS(R).
 *
 * Copyright (C) 2020 The OpenNMS Group, Inc.
 * OpenNMS(R) is Copyright (C) 1999-2020 The OpenNMS Group, Inc.
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

package org.opennms.features.openconfig.telemetry;

import java.net.InetAddress;

import org.opennms.core.rpc.utils.mate.EmptyScope;
import org.opennms.core.rpc.utils.mate.EntityScopeProvider;
import org.opennms.core.rpc.utils.mate.Scope;

public class MockEntityProvider implements EntityScopeProvider {
    @Override
    public Scope getScopeForNode(Integer nodeId) {
        return EmptyScope.EMPTY;
    }

    @Override
    public Scope getScopeForInterface(Integer nodeId, String ipAddress) {
        return EmptyScope.EMPTY;
    }

    @Override
    public Scope getScopeForInterfaceByIfIndex(Integer nodeId, int ifIndex) {
        return EmptyScope.EMPTY;
    }

    @Override
    public Scope getScopeForService(Integer nodeId, InetAddress ipAddress, String serviceName) {
        return EmptyScope.EMPTY;
    }
}
