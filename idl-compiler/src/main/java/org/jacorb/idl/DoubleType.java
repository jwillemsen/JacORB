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

package org.jacorb.idl;

import java.io.PrintWriter;

/**
 * @author Gerald Brose
 */

public class DoubleType
    extends FloatPtType
{
    public DoubleType( int num )
    {
        super( num );
    }

    public String typeName()
    {
        return "double";
    }

    public void setLongDouble()
    {
        // no effect as IDL type long double is
        // not supported by standard IDL/Java mappings.
    }

    public TypeSpec typeSpec()
    {
        return this;
    }

    public boolean basic()
    {
        return true;
    }

    public int getTCKind()
    {
        return 7; // org.omg.CORBA.TCKind._tk_double
    }

    public String toString()
    {
        return typeName();
    }

    public String holderName()
    {
        return "org.omg.CORBA.DoubleHolder";
    }

    public String printReadExpression( String strname )
    {
        return strname + ".read_double()";
    }

    public String printWriteStatement( String var_name, String strname )
    {
        return strname + ".write_double(" + var_name + ");";
    }

    public String printInsertExpression()
    {
        return "insert_double";
    }

    public String printExtractExpression()
    {
        return "extract_double";
    }

    public void printInsertIntoAny(PrintWriter ps,
                                   String anyname,
                                   String varname)
    {
        ps.println( "\t\t" + anyname + "."
                 + printInsertExpression() + "(" + varname + ");");

   }



    public void printExtractResult(PrintWriter ps,
                                   String resultname,
                                   String anyname,
                                   String resulttype)
    {
        ps.println("\t\t" + resultname + " = " + anyname + "." + printExtractExpression() + "();");
    }

}

























