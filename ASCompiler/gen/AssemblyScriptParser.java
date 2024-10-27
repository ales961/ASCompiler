// Generated from C:/Users/User/IdeaProjects/ASCompiler/src/main/java/AssemblyScript.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class AssemblyScriptParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		VAR=1, LET=2, CONST=3, FUNCTION=4, EXPORT=5, RETURN=6, IF=7, ELSE=8, WHILE=9, 
		TYPE_INT=10, ASSIGN=11, PLUS=12, MINUS=13, MULT=14, DIV=15, LT=16, GT=17, 
		LTE=18, GTE=19, EQ=20, NEQ=21, NOT=22, AND=23, OR=24, LPAREN=25, RPAREN=26, 
		LBRACE=27, RBRACE=28, SEMI=29, COMMA=30, COLON=31, DOT=32, IDENTIFIER=33, 
		INT_LITERAL=34, FLOAT_LITERAL=35, STRING_LITERAL=36, BOOL_LITERAL=37, 
		WS=38, LINE_COMMENT=39, BLOCK_COMMENT=40;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_varDecl = 2, RULE_letDecl = 3, 
		RULE_varList = 4, RULE_assignment = 5, RULE_functionDecl = 6, RULE_returnStmt = 7, 
		RULE_ifStmt = 8, RULE_whileStmt = 9, RULE_expr = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statement", "varDecl", "letDecl", "varList", "assignment", 
			"functionDecl", "returnStmt", "ifStmt", "whileStmt", "expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'var'", "'let'", "'const'", "'function'", "'export'", "'return'", 
			"'if'", "'else'", "'while'", "'i32'", "'='", "'+'", "'-'", "'*'", "'/'", 
			"'<'", "'>'", "'<='", "'>='", "'=='", "'!='", "'!'", "'&&'", "'||'", 
			"'('", "')'", "'{'", "'}'", "';'", "','", "':'", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "VAR", "LET", "CONST", "FUNCTION", "EXPORT", "RETURN", "IF", "ELSE", 
			"WHILE", "TYPE_INT", "ASSIGN", "PLUS", "MINUS", "MULT", "DIV", "LT", 
			"GT", "LTE", "GTE", "EQ", "NEQ", "NOT", "AND", "OR", "LPAREN", "RPAREN", 
			"LBRACE", "RBRACE", "SEMI", "COMMA", "COLON", "DOT", "IDENTIFIER", "INT_LITERAL", 
			"FLOAT_LITERAL", "STRING_LITERAL", "BOOL_LITERAL", "WS", "LINE_COMMENT", 
			"BLOCK_COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "AssemblyScript.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public AssemblyScriptParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AssemblyScriptListener ) ((AssemblyScriptListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AssemblyScriptListener ) ((AssemblyScriptListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AssemblyScriptVisitor ) return ((AssemblyScriptVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(25);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8589935318L) != 0)) {
				{
				{
				setState(22);
				statement();
				}
				}
				setState(27);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public LetDeclContext letDecl() {
			return getRuleContext(LetDeclContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public FunctionDeclContext functionDecl() {
			return getRuleContext(FunctionDeclContext.class,0);
		}
		public ReturnStmtContext returnStmt() {
			return getRuleContext(ReturnStmtContext.class,0);
		}
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public WhileStmtContext whileStmt() {
			return getRuleContext(WhileStmtContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AssemblyScriptListener ) ((AssemblyScriptListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AssemblyScriptListener ) ((AssemblyScriptListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AssemblyScriptVisitor ) return ((AssemblyScriptVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(35);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(28);
				varDecl();
				}
				break;
			case LET:
				enterOuterAlt(_localctx, 2);
				{
				setState(29);
				letDecl();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 3);
				{
				setState(30);
				assignment();
				}
				break;
			case FUNCTION:
				enterOuterAlt(_localctx, 4);
				{
				setState(31);
				functionDecl();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 5);
				{
				setState(32);
				returnStmt();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 6);
				{
				setState(33);
				ifStmt();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 7);
				{
				setState(34);
				whileStmt();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VarDeclContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(AssemblyScriptParser.VAR, 0); }
		public VarListContext varList() {
			return getRuleContext(VarListContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(AssemblyScriptParser.SEMI, 0); }
		public VarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AssemblyScriptListener ) ((AssemblyScriptListener)listener).enterVarDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AssemblyScriptListener ) ((AssemblyScriptListener)listener).exitVarDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AssemblyScriptVisitor ) return ((AssemblyScriptVisitor<? extends T>)visitor).visitVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_varDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			match(VAR);
			setState(38);
			varList();
			setState(39);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LetDeclContext extends ParserRuleContext {
		public TerminalNode LET() { return getToken(AssemblyScriptParser.LET, 0); }
		public VarListContext varList() {
			return getRuleContext(VarListContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(AssemblyScriptParser.SEMI, 0); }
		public LetDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_letDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AssemblyScriptListener ) ((AssemblyScriptListener)listener).enterLetDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AssemblyScriptListener ) ((AssemblyScriptListener)listener).exitLetDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AssemblyScriptVisitor ) return ((AssemblyScriptVisitor<? extends T>)visitor).visitLetDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LetDeclContext letDecl() throws RecognitionException {
		LetDeclContext _localctx = new LetDeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_letDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			match(LET);
			setState(42);
			varList();
			setState(43);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VarListContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(AssemblyScriptParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(AssemblyScriptParser.IDENTIFIER, i);
		}
		public List<TerminalNode> ASSIGN() { return getTokens(AssemblyScriptParser.ASSIGN); }
		public TerminalNode ASSIGN(int i) {
			return getToken(AssemblyScriptParser.ASSIGN, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(AssemblyScriptParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(AssemblyScriptParser.COMMA, i);
		}
		public VarListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AssemblyScriptListener ) ((AssemblyScriptListener)listener).enterVarList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AssemblyScriptListener ) ((AssemblyScriptListener)listener).exitVarList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AssemblyScriptVisitor ) return ((AssemblyScriptVisitor<? extends T>)visitor).visitVarList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarListContext varList() throws RecognitionException {
		VarListContext _localctx = new VarListContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_varList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			match(IDENTIFIER);
			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(46);
				match(ASSIGN);
				setState(47);
				expr(0);
				}
			}

			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(50);
				match(COMMA);
				setState(51);
				match(IDENTIFIER);
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(52);
					match(ASSIGN);
					setState(53);
					expr(0);
					}
				}

				}
				}
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(AssemblyScriptParser.IDENTIFIER, 0); }
		public TerminalNode ASSIGN() { return getToken(AssemblyScriptParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(AssemblyScriptParser.SEMI, 0); }
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AssemblyScriptListener ) ((AssemblyScriptListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AssemblyScriptListener ) ((AssemblyScriptListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AssemblyScriptVisitor ) return ((AssemblyScriptVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			match(IDENTIFIER);
			setState(62);
			match(ASSIGN);
			setState(63);
			expr(0);
			setState(64);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionDeclContext extends ParserRuleContext {
		public TerminalNode FUNCTION() { return getToken(AssemblyScriptParser.FUNCTION, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(AssemblyScriptParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(AssemblyScriptParser.IDENTIFIER, i);
		}
		public TerminalNode LPAREN() { return getToken(AssemblyScriptParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(AssemblyScriptParser.RPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(AssemblyScriptParser.LBRACE, 0); }
		public TerminalNode RETURN() { return getToken(AssemblyScriptParser.RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(AssemblyScriptParser.SEMI, 0); }
		public TerminalNode RBRACE() { return getToken(AssemblyScriptParser.RBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(AssemblyScriptParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(AssemblyScriptParser.COMMA, i);
		}
		public FunctionDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AssemblyScriptListener ) ((AssemblyScriptListener)listener).enterFunctionDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AssemblyScriptListener ) ((AssemblyScriptListener)listener).exitFunctionDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AssemblyScriptVisitor ) return ((AssemblyScriptVisitor<? extends T>)visitor).visitFunctionDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclContext functionDecl() throws RecognitionException {
		FunctionDeclContext _localctx = new FunctionDeclContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_functionDecl);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			match(FUNCTION);
			setState(67);
			match(IDENTIFIER);
			setState(68);
			match(LPAREN);
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(69);
				match(IDENTIFIER);
				setState(74);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(70);
					match(COMMA);
					setState(71);
					match(IDENTIFIER);
					}
					}
					setState(76);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(79);
			match(RPAREN);
			setState(80);
			match(LBRACE);
			setState(84);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(81);
					statement();
					}
					} 
				}
				setState(86);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			setState(87);
			match(RETURN);
			setState(88);
			expr(0);
			setState(89);
			match(SEMI);
			setState(90);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStmtContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(AssemblyScriptParser.RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(AssemblyScriptParser.SEMI, 0); }
		public ReturnStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AssemblyScriptListener ) ((AssemblyScriptListener)listener).enterReturnStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AssemblyScriptListener ) ((AssemblyScriptListener)listener).exitReturnStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AssemblyScriptVisitor ) return ((AssemblyScriptVisitor<? extends T>)visitor).visitReturnStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStmtContext returnStmt() throws RecognitionException {
		ReturnStmtContext _localctx = new ReturnStmtContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_returnStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(RETURN);
			setState(93);
			expr(0);
			setState(94);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfStmtContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(AssemblyScriptParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(AssemblyScriptParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(AssemblyScriptParser.RPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(AssemblyScriptParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(AssemblyScriptParser.RBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AssemblyScriptListener ) ((AssemblyScriptListener)listener).enterIfStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AssemblyScriptListener ) ((AssemblyScriptListener)listener).exitIfStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AssemblyScriptVisitor ) return ((AssemblyScriptVisitor<? extends T>)visitor).visitIfStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_ifStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(IF);
			setState(97);
			match(LPAREN);
			setState(98);
			expr(0);
			setState(99);
			match(RPAREN);
			setState(100);
			match(LBRACE);
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8589935318L) != 0)) {
				{
				{
				setState(101);
				statement();
				}
				}
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(107);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhileStmtContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(AssemblyScriptParser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(AssemblyScriptParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(AssemblyScriptParser.RPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(AssemblyScriptParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(AssemblyScriptParser.RBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public WhileStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AssemblyScriptListener ) ((AssemblyScriptListener)listener).enterWhileStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AssemblyScriptListener ) ((AssemblyScriptListener)listener).exitWhileStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AssemblyScriptVisitor ) return ((AssemblyScriptVisitor<? extends T>)visitor).visitWhileStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStmtContext whileStmt() throws RecognitionException {
		WhileStmtContext _localctx = new WhileStmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_whileStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(WHILE);
			setState(110);
			match(LPAREN);
			setState(111);
			expr(0);
			setState(112);
			match(RPAREN);
			setState(113);
			match(LBRACE);
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8589935318L) != 0)) {
				{
				{
				setState(114);
				statement();
				}
				}
				setState(119);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(120);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(AssemblyScriptParser.IDENTIFIER, 0); }
		public TerminalNode INT_LITERAL() { return getToken(AssemblyScriptParser.INT_LITERAL, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(AssemblyScriptParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(AssemblyScriptParser.MINUS, 0); }
		public TerminalNode MULT() { return getToken(AssemblyScriptParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(AssemblyScriptParser.DIV, 0); }
		public TerminalNode GT() { return getToken(AssemblyScriptParser.GT, 0); }
		public TerminalNode LT() { return getToken(AssemblyScriptParser.LT, 0); }
		public TerminalNode GTE() { return getToken(AssemblyScriptParser.GTE, 0); }
		public TerminalNode LTE() { return getToken(AssemblyScriptParser.LTE, 0); }
		public TerminalNode EQ() { return getToken(AssemblyScriptParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(AssemblyScriptParser.NEQ, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AssemblyScriptListener ) ((AssemblyScriptListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AssemblyScriptListener ) ((AssemblyScriptListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AssemblyScriptVisitor ) return ((AssemblyScriptVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				setState(123);
				match(IDENTIFIER);
				}
				break;
			case INT_LITERAL:
				{
				setState(124);
				match(INT_LITERAL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(135);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(133);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(127);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(128);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 61440L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(129);
						expr(5);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(130);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(131);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4128768L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(132);
						expr(4);
						}
						break;
					}
					} 
				}
				setState(137);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 10:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001(\u008b\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0001\u0000\u0005\u0000\u0018"+
		"\b\u0000\n\u0000\f\u0000\u001b\t\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001$\b\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004"+
		"1\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004"+
		"7\b\u0004\u0005\u00049\b\u0004\n\u0004\f\u0004<\t\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006I\b\u0006\n\u0006"+
		"\f\u0006L\t\u0006\u0003\u0006N\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0005\u0006S\b\u0006\n\u0006\f\u0006V\t\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\bg"+
		"\b\b\n\b\f\bj\t\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0005\tt\b\t\n\t\f\tw\t\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\n\u0003\n~\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005"+
		"\n\u0086\b\n\n\n\f\n\u0089\t\n\u0001\n\u0000\u0001\u0014\u000b\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0000\u0002\u0001\u0000\f\u000f"+
		"\u0001\u0000\u0010\u0015\u0091\u0000\u0019\u0001\u0000\u0000\u0000\u0002"+
		"#\u0001\u0000\u0000\u0000\u0004%\u0001\u0000\u0000\u0000\u0006)\u0001"+
		"\u0000\u0000\u0000\b-\u0001\u0000\u0000\u0000\n=\u0001\u0000\u0000\u0000"+
		"\fB\u0001\u0000\u0000\u0000\u000e\\\u0001\u0000\u0000\u0000\u0010`\u0001"+
		"\u0000\u0000\u0000\u0012m\u0001\u0000\u0000\u0000\u0014}\u0001\u0000\u0000"+
		"\u0000\u0016\u0018\u0003\u0002\u0001\u0000\u0017\u0016\u0001\u0000\u0000"+
		"\u0000\u0018\u001b\u0001\u0000\u0000\u0000\u0019\u0017\u0001\u0000\u0000"+
		"\u0000\u0019\u001a\u0001\u0000\u0000\u0000\u001a\u0001\u0001\u0000\u0000"+
		"\u0000\u001b\u0019\u0001\u0000\u0000\u0000\u001c$\u0003\u0004\u0002\u0000"+
		"\u001d$\u0003\u0006\u0003\u0000\u001e$\u0003\n\u0005\u0000\u001f$\u0003"+
		"\f\u0006\u0000 $\u0003\u000e\u0007\u0000!$\u0003\u0010\b\u0000\"$\u0003"+
		"\u0012\t\u0000#\u001c\u0001\u0000\u0000\u0000#\u001d\u0001\u0000\u0000"+
		"\u0000#\u001e\u0001\u0000\u0000\u0000#\u001f\u0001\u0000\u0000\u0000#"+
		" \u0001\u0000\u0000\u0000#!\u0001\u0000\u0000\u0000#\"\u0001\u0000\u0000"+
		"\u0000$\u0003\u0001\u0000\u0000\u0000%&\u0005\u0001\u0000\u0000&\'\u0003"+
		"\b\u0004\u0000\'(\u0005\u001d\u0000\u0000(\u0005\u0001\u0000\u0000\u0000"+
		")*\u0005\u0002\u0000\u0000*+\u0003\b\u0004\u0000+,\u0005\u001d\u0000\u0000"+
		",\u0007\u0001\u0000\u0000\u0000-0\u0005!\u0000\u0000./\u0005\u000b\u0000"+
		"\u0000/1\u0003\u0014\n\u00000.\u0001\u0000\u0000\u000001\u0001\u0000\u0000"+
		"\u00001:\u0001\u0000\u0000\u000023\u0005\u001e\u0000\u000036\u0005!\u0000"+
		"\u000045\u0005\u000b\u0000\u000057\u0003\u0014\n\u000064\u0001\u0000\u0000"+
		"\u000067\u0001\u0000\u0000\u000079\u0001\u0000\u0000\u000082\u0001\u0000"+
		"\u0000\u00009<\u0001\u0000\u0000\u0000:8\u0001\u0000\u0000\u0000:;\u0001"+
		"\u0000\u0000\u0000;\t\u0001\u0000\u0000\u0000<:\u0001\u0000\u0000\u0000"+
		"=>\u0005!\u0000\u0000>?\u0005\u000b\u0000\u0000?@\u0003\u0014\n\u0000"+
		"@A\u0005\u001d\u0000\u0000A\u000b\u0001\u0000\u0000\u0000BC\u0005\u0004"+
		"\u0000\u0000CD\u0005!\u0000\u0000DM\u0005\u0019\u0000\u0000EJ\u0005!\u0000"+
		"\u0000FG\u0005\u001e\u0000\u0000GI\u0005!\u0000\u0000HF\u0001\u0000\u0000"+
		"\u0000IL\u0001\u0000\u0000\u0000JH\u0001\u0000\u0000\u0000JK\u0001\u0000"+
		"\u0000\u0000KN\u0001\u0000\u0000\u0000LJ\u0001\u0000\u0000\u0000ME\u0001"+
		"\u0000\u0000\u0000MN\u0001\u0000\u0000\u0000NO\u0001\u0000\u0000\u0000"+
		"OP\u0005\u001a\u0000\u0000PT\u0005\u001b\u0000\u0000QS\u0003\u0002\u0001"+
		"\u0000RQ\u0001\u0000\u0000\u0000SV\u0001\u0000\u0000\u0000TR\u0001\u0000"+
		"\u0000\u0000TU\u0001\u0000\u0000\u0000UW\u0001\u0000\u0000\u0000VT\u0001"+
		"\u0000\u0000\u0000WX\u0005\u0006\u0000\u0000XY\u0003\u0014\n\u0000YZ\u0005"+
		"\u001d\u0000\u0000Z[\u0005\u001c\u0000\u0000[\r\u0001\u0000\u0000\u0000"+
		"\\]\u0005\u0006\u0000\u0000]^\u0003\u0014\n\u0000^_\u0005\u001d\u0000"+
		"\u0000_\u000f\u0001\u0000\u0000\u0000`a\u0005\u0007\u0000\u0000ab\u0005"+
		"\u0019\u0000\u0000bc\u0003\u0014\n\u0000cd\u0005\u001a\u0000\u0000dh\u0005"+
		"\u001b\u0000\u0000eg\u0003\u0002\u0001\u0000fe\u0001\u0000\u0000\u0000"+
		"gj\u0001\u0000\u0000\u0000hf\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000"+
		"\u0000ik\u0001\u0000\u0000\u0000jh\u0001\u0000\u0000\u0000kl\u0005\u001c"+
		"\u0000\u0000l\u0011\u0001\u0000\u0000\u0000mn\u0005\t\u0000\u0000no\u0005"+
		"\u0019\u0000\u0000op\u0003\u0014\n\u0000pq\u0005\u001a\u0000\u0000qu\u0005"+
		"\u001b\u0000\u0000rt\u0003\u0002\u0001\u0000sr\u0001\u0000\u0000\u0000"+
		"tw\u0001\u0000\u0000\u0000us\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000"+
		"\u0000vx\u0001\u0000\u0000\u0000wu\u0001\u0000\u0000\u0000xy\u0005\u001c"+
		"\u0000\u0000y\u0013\u0001\u0000\u0000\u0000z{\u0006\n\uffff\uffff\u0000"+
		"{~\u0005!\u0000\u0000|~\u0005\"\u0000\u0000}z\u0001\u0000\u0000\u0000"+
		"}|\u0001\u0000\u0000\u0000~\u0087\u0001\u0000\u0000\u0000\u007f\u0080"+
		"\n\u0004\u0000\u0000\u0080\u0081\u0007\u0000\u0000\u0000\u0081\u0086\u0003"+
		"\u0014\n\u0005\u0082\u0083\n\u0003\u0000\u0000\u0083\u0084\u0007\u0001"+
		"\u0000\u0000\u0084\u0086\u0003\u0014\n\u0004\u0085\u007f\u0001\u0000\u0000"+
		"\u0000\u0085\u0082\u0001\u0000\u0000\u0000\u0086\u0089\u0001\u0000\u0000"+
		"\u0000\u0087\u0085\u0001\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000"+
		"\u0000\u0088\u0015\u0001\u0000\u0000\u0000\u0089\u0087\u0001\u0000\u0000"+
		"\u0000\r\u0019#06:JMThu}\u0085\u0087";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}