/*
 *        JacORB - a free Java ORB
 *
 *   Copyright (C) 1997-2014 Gerald Brose / The JacORB Team.
 *
 *   This library is free software; you can redistribute it and/or
 *   modify it under the terms of the GNU Library General Public
 *   License as published by the Free Software Foundation; either
 *   version 2 of the License, or (at your option) any later version.
 *
 *   This library is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *   Library General Public License for more details.
 *
 *   You should have received a copy of the GNU Library General Public
 *   License along with this library; if not, write to the Free
 *   Software Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */

package javax.rmi.CORBA;

import java.rmi.Remote;

import org.omg.CORBA.ORB;
import org.omg.CORBA.portable.InvokeHandler;

/**
 * Legacy RMI interface for JacORB.
 */
public interface Tie extends InvokeHandler
{
    org.omg.CORBA.Object thisObject();

    void deactivate() throws java.rmi.NoSuchObjectException;

    ORB orb();

    void orb(ORB orb);

    void setTarget(java.rmi.Remote target);

    Remote getTarget();
}
