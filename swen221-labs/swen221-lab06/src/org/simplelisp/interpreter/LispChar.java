// This file is part of the Simple Lisp Interpreter.
//
// The Simple Lisp Interpreter is free software; you can 
// redistribute it and/or modify it under the terms of the 
// GNU General Public License as published by the Free Software 
// Foundation; either version 2 of the License, or (at your 
// option) any later version.
//
// The Simpular Program Interpreter is distributed in the hope
// that it will be useful, but WITHOUT ANY WARRANTY; without 
// even the implied warranty of MERCHANTABILITY or FITNESS FOR 
// A PARTICULAR PURPOSE.  See the GNU General Public License 
// for more details.
//
// You should have received a copy of the GNU General Public 
// License along with the Simpular Program Interpreter; if not, 
// write to the Free Software Foundation, Inc., 59 Temple Place, 
// Suite 330, Boston, MA  02111-1307  USA
//
// (C) David James Pearce, 2005. 

package org.simplelisp.interpreter;

import java.util.*;

public final class LispChar implements LispExpr {
    private final char value;
    public LispChar(char c) { value=c; }

    public String toString() { return Character.toString(value); }
    
    public boolean equals(Object o) {
    	return (o instanceof LispChar) && value == ((LispChar)o).value;
    }

    public LispExpr evaluate(HashMap<String, LispExpr> locals, 
			     HashMap<String, LispExpr> globals) {
    	return this;
    } 
}

