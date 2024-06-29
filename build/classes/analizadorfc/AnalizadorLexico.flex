package analizadorfc
import java_cup.runtime.*;
import java.io.Reader;
%%
%class AnalizadorLexico
%line
%column
%char
%cup

%{
    public SymbolHoc s;
    public int TipSimb;

    TablaSimbolos ListaSimb = new TablaSimbolos();

    private Symbol symbol (int type){
        return new Symbol(type, yyline, yycolumn);
    }

    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }

%}

Letra=[a-zA-Z]
Digito=[0-9]

%%
[ \t\n]+ { ;}
";" { return symbol(AnalizadorSintacticoSym.SEMIC); }
{Digito}+(\.{Digito}+)? { return symbol(AnalizadorSintacticoSym.NumReal, new float(yytext())); }
"=" { return symbol(AnalizadorSintacticoSym.OpAsig); }
"/" { return symbol(AnalizadorSintacticoSym.OpDiv); }
"*" { return symbol(AnalizadorSintacticoSym.OpProd); }
"-" { return symbol(AnalizadorSintacticoSym.OpResta); }
"+" { return symbol(AnalizadorSintacticoSym.OpSuma); }
"(" { return symbol(AnalizadorSintacticoSym.ParenIzq); }
")" { return symbol(AnalizadorSintacticoSym.ParenDer); }
\^ { return symbol(AnalizadorSintacticoSym.OpPotencia); }
{Letra}({Letra}|{Digito})* {
    s = ListaSimb.lookup(yytext());
    if (s == null)
        s = ListaSimb.install(yytext(), EnumTipoSymbol.UNDEF, (float)0.0);
    switch (s.TipoSymbol) {
        case UNDEF:
            TipSimb = AnalizadorSintacticoSym.VAR;
            break;
        case VAR:
            TipSimb = AnalizadorSintacticoSym.VAR;
            break;
        case BLTIN:
            TipSimb = AnalizadorSintacticoSym.BLTIN;
            break;
        case CONST_PREDEF:
            TipSimb = AnalizadorSintacticoSym.CONST_PRED;
            break;
    }
    return symbol(TipSimb, s);
}
. { return symbol(AnalizadorSintacticoSym.error); }