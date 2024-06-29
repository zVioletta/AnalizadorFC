/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analizadorfc;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author roman
 */
public class TablaSimbolos {
    List<SymbolHoc> ListaSimbolos;
    
    public TablaSimbolos() {
        ListaSimbolos = new LinkedList<>();
        this.init();
    }
    
    public SymbolHoc lookup(String name) {
        SymbolHoc s;
        Iterator it = ListaSimbolos.iterator();
        while(it.hasNext()) {
            s = (SymbolHoc) it.next();
            if (s.name.equals(name)) {
                return s;
            }
        }
        return null;
    }

    public SymbolHoc install(String name, EnumTipoSymbol type, float val) {
        SymbolHoc s = new SymbolHoc();
        s.SetSymbol(name, type, val);
        ListaSimbolos.add(s);
        return s;
    }

    public SymbolHoc install(String name, EnumTipoSymbol type, EnumBLTIN funcPredef) {
        SymbolHoc s = new SymbolHoc();
        s.SetSymbol(name, type, funcPredef);
        ListaSimbolos.add(s);
        return s;
    }

    private void init() {
        ListaSimbolos.clear();
        InitConstPredef();
        InitFuncPredef();
    }

    private void InitConstPredef() {
        SymbolHoc s;
        float val;

        s = new SymbolHoc();
        val = (float)3.14159265358979323846;
        s.SetSymbol("PI", EnumTipoSymbol.CONST_PREDEF, val);
        ListaSimbolos.add(s);

        s = new SymbolHoc();
        val = (float)2.71828182845904523536;
        s.SetSymbol("E", EnumTipoSymbol.CONST_PREDEF, val);
        ListaSimbolos.add(s);

        s = new SymbolHoc();
        val = (float)0.57721566490153286060;
        s.SetSymbol("GAMMA", EnumTipoSymbol.CONST_PREDEF, val);
        ListaSimbolos.add(s);

        s = new SymbolHoc();
        val = (float)57.29577951308232087680;
        s.SetSymbol("DEG", EnumTipoSymbol.CONST_PREDEF, val);
        ListaSimbolos.add(s);

        s = new SymbolHoc();
        val = (float)1.61803398874989484820;
        s.SetSymbol("PHI", EnumTipoSymbol.CONST_PREDEF, val);
        ListaSimbolos.add(s);
    }

    private void InitFuncPredef() {
        SymbolHoc s;

        s = new SymbolHoc();
        s.SetSymbol("sin", EnumTipoSymbol.BLTIN, EnumBLTIN.SIN);
        ListaSimbolos.add(s);

        s = new SymbolHoc();
        s.SetSymbol("cos", EnumTipoSymbol.BLTIN, EnumBLTIN.COS);
        ListaSimbolos.add(s);

        s = new SymbolHoc();
        s.SetSymbol("atan", EnumTipoSymbol.BLTIN, EnumBLTIN.ATAN);
        ListaSimbolos.add(s);

        s = new SymbolHoc();
        s.SetSymbol("log", EnumTipoSymbol.BLTIN, EnumBLTIN.LOG);
        ListaSimbolos.add(s);

        s = new SymbolHoc();
        s.SetSymbol("log10", EnumTipoSymbol.BLTIN, EnumBLTIN.LOG10);
        ListaSimbolos.add(s);

        s = new SymbolHoc();
        s.SetSymbol("exp", EnumTipoSymbol.BLTIN, EnumBLTIN.EXP);
        ListaSimbolos.add(s);

        s = new SymbolHoc();
        s.SetSymbol("sqrt", EnumTipoSymbol.BLTIN, EnumBLTIN.SQRT);
        ListaSimbolos.add(s);

        s = new SymbolHoc();
        s.SetSymbol("int", EnumTipoSymbol.BLTIN, EnumBLTIN.INT);
        ListaSimbolos.add(s);

        s = new SymbolHoc();
        s.SetSymbol("abs", EnumTipoSymbol.BLTIN, EnumBLTIN.ABS);
        ListaSimbolos.add(s);
    }
}
