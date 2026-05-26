// Generated from grammar/first.g4 by ANTLR 4.13.1
package grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class firstParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		GUEST=1, DISH=2, INGREDIENTS=3, TYPE=4, DIET=5, ALLERGIES=6, ALLERGENS=7, 
		TAGS=8, NAME=9, ID=10, QUOTE=11, EQ=12, ADD=13, COMMA=14, SEMI=15, COLON=16, 
		LPAREN=17, RPAREN=18, LCURLY=19, RCURLY=20, COMMENT=21, LINE_COMMENT=22, 
		NEWLINE=23, WS=24;
	public static final int
		RULE_program = 0, RULE_stat = 1, RULE_guest_attr = 2, RULE_dish_attr = 3, 
		RULE_full_name = 4;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "stat", "guest_attr", "dish_attr", "full_name"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'guest'", "'dish'", "'ingredients'", "'type'", "'diet'", "'allergies'", 
			"'allergens'", "'tags'", null, null, "'\"'", "'='", "'+'", "','", "';'", 
			"':'", "'('", "')'", "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "GUEST", "DISH", "INGREDIENTS", "TYPE", "DIET", "ALLERGIES", "ALLERGENS", 
			"TAGS", "NAME", "ID", "QUOTE", "EQ", "ADD", "COMMA", "SEMI", "COLON", 
			"LPAREN", "RPAREN", "LCURLY", "RCURLY", "COMMENT", "LINE_COMMENT", "NEWLINE", 
			"WS"
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
	public String getGrammarFileName() { return "first.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public firstParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(firstParser.EOF, 0); }
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof firstListener ) ((firstListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof firstListener ) ((firstListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof firstVisitor ) return ((firstVisitor<? extends T>)visitor).visitProgram(this);
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
			setState(11); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(10);
				stat();
				}
				}
				setState(13); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==GUEST || _la==DISH );
			setState(15);
			match(EOF);
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
	public static class StatContext extends ParserRuleContext {
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	 
		public StatContext() { }
		public void copyFrom(StatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Guest_statContext extends StatContext {
		public TerminalNode GUEST() { return getToken(firstParser.GUEST, 0); }
		public List<TerminalNode> QUOTE() { return getTokens(firstParser.QUOTE); }
		public TerminalNode QUOTE(int i) {
			return getToken(firstParser.QUOTE, i);
		}
		public Full_nameContext full_name() {
			return getRuleContext(Full_nameContext.class,0);
		}
		public TerminalNode LCURLY() { return getToken(firstParser.LCURLY, 0); }
		public TerminalNode RCURLY() { return getToken(firstParser.RCURLY, 0); }
		public List<Guest_attrContext> guest_attr() {
			return getRuleContexts(Guest_attrContext.class);
		}
		public Guest_attrContext guest_attr(int i) {
			return getRuleContext(Guest_attrContext.class,i);
		}
		public Guest_statContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof firstListener ) ((firstListener)listener).enterGuest_stat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof firstListener ) ((firstListener)listener).exitGuest_stat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof firstVisitor ) return ((firstVisitor<? extends T>)visitor).visitGuest_stat(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Dish_statContext extends StatContext {
		public TerminalNode DISH() { return getToken(firstParser.DISH, 0); }
		public List<TerminalNode> QUOTE() { return getTokens(firstParser.QUOTE); }
		public TerminalNode QUOTE(int i) {
			return getToken(firstParser.QUOTE, i);
		}
		public Full_nameContext full_name() {
			return getRuleContext(Full_nameContext.class,0);
		}
		public TerminalNode LCURLY() { return getToken(firstParser.LCURLY, 0); }
		public TerminalNode RCURLY() { return getToken(firstParser.RCURLY, 0); }
		public List<Dish_attrContext> dish_attr() {
			return getRuleContexts(Dish_attrContext.class);
		}
		public Dish_attrContext dish_attr(int i) {
			return getRuleContext(Dish_attrContext.class,i);
		}
		public Dish_statContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof firstListener ) ((firstListener)listener).enterDish_stat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof firstListener ) ((firstListener)listener).exitDish_stat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof firstVisitor ) return ((firstVisitor<? extends T>)visitor).visitDish_stat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stat);
		int _la;
		try {
			setState(43);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case GUEST:
				_localctx = new Guest_statContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(17);
				match(GUEST);
				setState(18);
				match(QUOTE);
				setState(19);
				full_name();
				setState(20);
				match(QUOTE);
				setState(21);
				match(LCURLY);
				setState(25);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DIET || _la==ALLERGIES) {
					{
					{
					setState(22);
					guest_attr();
					}
					}
					setState(27);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(28);
				match(RCURLY);
				}
				break;
			case DISH:
				_localctx = new Dish_statContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(30);
				match(DISH);
				setState(31);
				match(QUOTE);
				setState(32);
				full_name();
				setState(33);
				match(QUOTE);
				setState(34);
				match(LCURLY);
				setState(38);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 408L) != 0)) {
					{
					{
					setState(35);
					dish_attr();
					}
					}
					setState(40);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(41);
				match(RCURLY);
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
	public static class Guest_attrContext extends ParserRuleContext {
		public Guest_attrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_guest_attr; }
	 
		public Guest_attrContext() { }
		public void copyFrom(Guest_attrContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Diet_listContext extends Guest_attrContext {
		public TerminalNode DIET() { return getToken(firstParser.DIET, 0); }
		public TerminalNode COLON() { return getToken(firstParser.COLON, 0); }
		public List<Full_nameContext> full_name() {
			return getRuleContexts(Full_nameContext.class);
		}
		public Full_nameContext full_name(int i) {
			return getRuleContext(Full_nameContext.class,i);
		}
		public TerminalNode SEMI() { return getToken(firstParser.SEMI, 0); }
		public List<TerminalNode> COMMA() { return getTokens(firstParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(firstParser.COMMA, i);
		}
		public Diet_listContext(Guest_attrContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof firstListener ) ((firstListener)listener).enterDiet_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof firstListener ) ((firstListener)listener).exitDiet_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof firstVisitor ) return ((firstVisitor<? extends T>)visitor).visitDiet_list(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Allergies_listContext extends Guest_attrContext {
		public TerminalNode ALLERGIES() { return getToken(firstParser.ALLERGIES, 0); }
		public TerminalNode COLON() { return getToken(firstParser.COLON, 0); }
		public List<Full_nameContext> full_name() {
			return getRuleContexts(Full_nameContext.class);
		}
		public Full_nameContext full_name(int i) {
			return getRuleContext(Full_nameContext.class,i);
		}
		public TerminalNode SEMI() { return getToken(firstParser.SEMI, 0); }
		public List<TerminalNode> COMMA() { return getTokens(firstParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(firstParser.COMMA, i);
		}
		public Allergies_listContext(Guest_attrContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof firstListener ) ((firstListener)listener).enterAllergies_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof firstListener ) ((firstListener)listener).exitAllergies_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof firstVisitor ) return ((firstVisitor<? extends T>)visitor).visitAllergies_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Guest_attrContext guest_attr() throws RecognitionException {
		Guest_attrContext _localctx = new Guest_attrContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_guest_attr);
		int _la;
		try {
			setState(69);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DIET:
				_localctx = new Diet_listContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(45);
				match(DIET);
				setState(46);
				match(COLON);
				setState(47);
				full_name();
				setState(52);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(48);
					match(COMMA);
					setState(49);
					full_name();
					}
					}
					setState(54);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(55);
				match(SEMI);
				}
				break;
			case ALLERGIES:
				_localctx = new Allergies_listContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(57);
				match(ALLERGIES);
				setState(58);
				match(COLON);
				setState(59);
				full_name();
				setState(64);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(60);
					match(COMMA);
					setState(61);
					full_name();
					}
					}
					setState(66);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(67);
				match(SEMI);
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
	public static class Dish_attrContext extends ParserRuleContext {
		public Dish_attrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dish_attr; }
	 
		public Dish_attrContext() { }
		public void copyFrom(Dish_attrContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Ing_listContext extends Dish_attrContext {
		public TerminalNode INGREDIENTS() { return getToken(firstParser.INGREDIENTS, 0); }
		public TerminalNode COLON() { return getToken(firstParser.COLON, 0); }
		public List<Full_nameContext> full_name() {
			return getRuleContexts(Full_nameContext.class);
		}
		public Full_nameContext full_name(int i) {
			return getRuleContext(Full_nameContext.class,i);
		}
		public TerminalNode SEMI() { return getToken(firstParser.SEMI, 0); }
		public List<TerminalNode> COMMA() { return getTokens(firstParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(firstParser.COMMA, i);
		}
		public Ing_listContext(Dish_attrContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof firstListener ) ((firstListener)listener).enterIng_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof firstListener ) ((firstListener)listener).exitIng_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof firstVisitor ) return ((firstVisitor<? extends T>)visitor).visitIng_list(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Type_listContext extends Dish_attrContext {
		public TerminalNode TYPE() { return getToken(firstParser.TYPE, 0); }
		public TerminalNode COLON() { return getToken(firstParser.COLON, 0); }
		public List<Full_nameContext> full_name() {
			return getRuleContexts(Full_nameContext.class);
		}
		public Full_nameContext full_name(int i) {
			return getRuleContext(Full_nameContext.class,i);
		}
		public TerminalNode SEMI() { return getToken(firstParser.SEMI, 0); }
		public List<TerminalNode> COMMA() { return getTokens(firstParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(firstParser.COMMA, i);
		}
		public Type_listContext(Dish_attrContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof firstListener ) ((firstListener)listener).enterType_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof firstListener ) ((firstListener)listener).exitType_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof firstVisitor ) return ((firstVisitor<? extends T>)visitor).visitType_list(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Allergens_listContext extends Dish_attrContext {
		public TerminalNode ALLERGENS() { return getToken(firstParser.ALLERGENS, 0); }
		public TerminalNode COLON() { return getToken(firstParser.COLON, 0); }
		public List<Full_nameContext> full_name() {
			return getRuleContexts(Full_nameContext.class);
		}
		public Full_nameContext full_name(int i) {
			return getRuleContext(Full_nameContext.class,i);
		}
		public TerminalNode SEMI() { return getToken(firstParser.SEMI, 0); }
		public List<TerminalNode> COMMA() { return getTokens(firstParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(firstParser.COMMA, i);
		}
		public Allergens_listContext(Dish_attrContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof firstListener ) ((firstListener)listener).enterAllergens_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof firstListener ) ((firstListener)listener).exitAllergens_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof firstVisitor ) return ((firstVisitor<? extends T>)visitor).visitAllergens_list(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Tag_listContext extends Dish_attrContext {
		public TerminalNode TAGS() { return getToken(firstParser.TAGS, 0); }
		public TerminalNode COLON() { return getToken(firstParser.COLON, 0); }
		public List<Full_nameContext> full_name() {
			return getRuleContexts(Full_nameContext.class);
		}
		public Full_nameContext full_name(int i) {
			return getRuleContext(Full_nameContext.class,i);
		}
		public TerminalNode SEMI() { return getToken(firstParser.SEMI, 0); }
		public List<TerminalNode> COMMA() { return getTokens(firstParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(firstParser.COMMA, i);
		}
		public Tag_listContext(Dish_attrContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof firstListener ) ((firstListener)listener).enterTag_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof firstListener ) ((firstListener)listener).exitTag_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof firstVisitor ) return ((firstVisitor<? extends T>)visitor).visitTag_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Dish_attrContext dish_attr() throws RecognitionException {
		Dish_attrContext _localctx = new Dish_attrContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_dish_attr);
		int _la;
		try {
			setState(119);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INGREDIENTS:
				_localctx = new Ing_listContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				match(INGREDIENTS);
				setState(72);
				match(COLON);
				setState(73);
				full_name();
				setState(78);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(74);
					match(COMMA);
					setState(75);
					full_name();
					}
					}
					setState(80);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(81);
				match(SEMI);
				}
				break;
			case TYPE:
				_localctx = new Type_listContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(83);
				match(TYPE);
				setState(84);
				match(COLON);
				setState(85);
				full_name();
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(86);
					match(COMMA);
					setState(87);
					full_name();
					}
					}
					setState(92);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(93);
				match(SEMI);
				}
				break;
			case ALLERGENS:
				_localctx = new Allergens_listContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(95);
				match(ALLERGENS);
				setState(96);
				match(COLON);
				setState(97);
				full_name();
				setState(102);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(98);
					match(COMMA);
					setState(99);
					full_name();
					}
					}
					setState(104);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(105);
				match(SEMI);
				}
				break;
			case TAGS:
				_localctx = new Tag_listContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(107);
				match(TAGS);
				setState(108);
				match(COLON);
				setState(109);
				full_name();
				setState(114);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(110);
					match(COMMA);
					setState(111);
					full_name();
					}
					}
					setState(116);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(117);
				match(SEMI);
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
	public static class Full_nameContext extends ParserRuleContext {
		public List<TerminalNode> NAME() { return getTokens(firstParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(firstParser.NAME, i);
		}
		public Full_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_full_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof firstListener ) ((firstListener)listener).enterFull_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof firstListener ) ((firstListener)listener).exitFull_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof firstVisitor ) return ((firstVisitor<? extends T>)visitor).visitFull_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Full_nameContext full_name() throws RecognitionException {
		Full_nameContext _localctx = new Full_nameContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_full_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(121);
				match(NAME);
				}
				}
				setState(124); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NAME );
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

	public static final String _serializedATN =
		"\u0004\u0001\u0018\u007f\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0001\u0000\u0004\u0000\f\b\u0000\u000b\u0000\f\u0000\r\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0005\u0001\u0018\b\u0001\n\u0001\f\u0001\u001b\t\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0005\u0001%\b\u0001\n\u0001\f\u0001(\t\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u0001,\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0005\u00023\b\u0002\n\u0002\f\u00026\t\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0005\u0002?\b\u0002\n\u0002\f\u0002B\t\u0002\u0001\u0002"+
		"\u0001\u0002\u0003\u0002F\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0005\u0003M\b\u0003\n\u0003\f\u0003P\t\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0005\u0003Y\b\u0003\n\u0003\f\u0003\\\t\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0005\u0003e\b\u0003\n\u0003\f\u0003h\t\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003"+
		"q\b\u0003\n\u0003\f\u0003t\t\u0003\u0001\u0003\u0001\u0003\u0003\u0003"+
		"x\b\u0003\u0001\u0004\u0004\u0004{\b\u0004\u000b\u0004\f\u0004|\u0001"+
		"\u0004\u0000\u0000\u0005\u0000\u0002\u0004\u0006\b\u0000\u0000\u0088\u0000"+
		"\u000b\u0001\u0000\u0000\u0000\u0002+\u0001\u0000\u0000\u0000\u0004E\u0001"+
		"\u0000\u0000\u0000\u0006w\u0001\u0000\u0000\u0000\bz\u0001\u0000\u0000"+
		"\u0000\n\f\u0003\u0002\u0001\u0000\u000b\n\u0001\u0000\u0000\u0000\f\r"+
		"\u0001\u0000\u0000\u0000\r\u000b\u0001\u0000\u0000\u0000\r\u000e\u0001"+
		"\u0000\u0000\u0000\u000e\u000f\u0001\u0000\u0000\u0000\u000f\u0010\u0005"+
		"\u0000\u0000\u0001\u0010\u0001\u0001\u0000\u0000\u0000\u0011\u0012\u0005"+
		"\u0001\u0000\u0000\u0012\u0013\u0005\u000b\u0000\u0000\u0013\u0014\u0003"+
		"\b\u0004\u0000\u0014\u0015\u0005\u000b\u0000\u0000\u0015\u0019\u0005\u0013"+
		"\u0000\u0000\u0016\u0018\u0003\u0004\u0002\u0000\u0017\u0016\u0001\u0000"+
		"\u0000\u0000\u0018\u001b\u0001\u0000\u0000\u0000\u0019\u0017\u0001\u0000"+
		"\u0000\u0000\u0019\u001a\u0001\u0000\u0000\u0000\u001a\u001c\u0001\u0000"+
		"\u0000\u0000\u001b\u0019\u0001\u0000\u0000\u0000\u001c\u001d\u0005\u0014"+
		"\u0000\u0000\u001d,\u0001\u0000\u0000\u0000\u001e\u001f\u0005\u0002\u0000"+
		"\u0000\u001f \u0005\u000b\u0000\u0000 !\u0003\b\u0004\u0000!\"\u0005\u000b"+
		"\u0000\u0000\"&\u0005\u0013\u0000\u0000#%\u0003\u0006\u0003\u0000$#\u0001"+
		"\u0000\u0000\u0000%(\u0001\u0000\u0000\u0000&$\u0001\u0000\u0000\u0000"+
		"&\'\u0001\u0000\u0000\u0000\')\u0001\u0000\u0000\u0000(&\u0001\u0000\u0000"+
		"\u0000)*\u0005\u0014\u0000\u0000*,\u0001\u0000\u0000\u0000+\u0011\u0001"+
		"\u0000\u0000\u0000+\u001e\u0001\u0000\u0000\u0000,\u0003\u0001\u0000\u0000"+
		"\u0000-.\u0005\u0005\u0000\u0000./\u0005\u0010\u0000\u0000/4\u0003\b\u0004"+
		"\u000001\u0005\u000e\u0000\u000013\u0003\b\u0004\u000020\u0001\u0000\u0000"+
		"\u000036\u0001\u0000\u0000\u000042\u0001\u0000\u0000\u000045\u0001\u0000"+
		"\u0000\u000057\u0001\u0000\u0000\u000064\u0001\u0000\u0000\u000078\u0005"+
		"\u000f\u0000\u00008F\u0001\u0000\u0000\u00009:\u0005\u0006\u0000\u0000"+
		":;\u0005\u0010\u0000\u0000;@\u0003\b\u0004\u0000<=\u0005\u000e\u0000\u0000"+
		"=?\u0003\b\u0004\u0000><\u0001\u0000\u0000\u0000?B\u0001\u0000\u0000\u0000"+
		"@>\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000AC\u0001\u0000\u0000"+
		"\u0000B@\u0001\u0000\u0000\u0000CD\u0005\u000f\u0000\u0000DF\u0001\u0000"+
		"\u0000\u0000E-\u0001\u0000\u0000\u0000E9\u0001\u0000\u0000\u0000F\u0005"+
		"\u0001\u0000\u0000\u0000GH\u0005\u0003\u0000\u0000HI\u0005\u0010\u0000"+
		"\u0000IN\u0003\b\u0004\u0000JK\u0005\u000e\u0000\u0000KM\u0003\b\u0004"+
		"\u0000LJ\u0001\u0000\u0000\u0000MP\u0001\u0000\u0000\u0000NL\u0001\u0000"+
		"\u0000\u0000NO\u0001\u0000\u0000\u0000OQ\u0001\u0000\u0000\u0000PN\u0001"+
		"\u0000\u0000\u0000QR\u0005\u000f\u0000\u0000Rx\u0001\u0000\u0000\u0000"+
		"ST\u0005\u0004\u0000\u0000TU\u0005\u0010\u0000\u0000UZ\u0003\b\u0004\u0000"+
		"VW\u0005\u000e\u0000\u0000WY\u0003\b\u0004\u0000XV\u0001\u0000\u0000\u0000"+
		"Y\\\u0001\u0000\u0000\u0000ZX\u0001\u0000\u0000\u0000Z[\u0001\u0000\u0000"+
		"\u0000[]\u0001\u0000\u0000\u0000\\Z\u0001\u0000\u0000\u0000]^\u0005\u000f"+
		"\u0000\u0000^x\u0001\u0000\u0000\u0000_`\u0005\u0007\u0000\u0000`a\u0005"+
		"\u0010\u0000\u0000af\u0003\b\u0004\u0000bc\u0005\u000e\u0000\u0000ce\u0003"+
		"\b\u0004\u0000db\u0001\u0000\u0000\u0000eh\u0001\u0000\u0000\u0000fd\u0001"+
		"\u0000\u0000\u0000fg\u0001\u0000\u0000\u0000gi\u0001\u0000\u0000\u0000"+
		"hf\u0001\u0000\u0000\u0000ij\u0005\u000f\u0000\u0000jx\u0001\u0000\u0000"+
		"\u0000kl\u0005\b\u0000\u0000lm\u0005\u0010\u0000\u0000mr\u0003\b\u0004"+
		"\u0000no\u0005\u000e\u0000\u0000oq\u0003\b\u0004\u0000pn\u0001\u0000\u0000"+
		"\u0000qt\u0001\u0000\u0000\u0000rp\u0001\u0000\u0000\u0000rs\u0001\u0000"+
		"\u0000\u0000su\u0001\u0000\u0000\u0000tr\u0001\u0000\u0000\u0000uv\u0005"+
		"\u000f\u0000\u0000vx\u0001\u0000\u0000\u0000wG\u0001\u0000\u0000\u0000"+
		"wS\u0001\u0000\u0000\u0000w_\u0001\u0000\u0000\u0000wk\u0001\u0000\u0000"+
		"\u0000x\u0007\u0001\u0000\u0000\u0000y{\u0005\t\u0000\u0000zy\u0001\u0000"+
		"\u0000\u0000{|\u0001\u0000\u0000\u0000|z\u0001\u0000\u0000\u0000|}\u0001"+
		"\u0000\u0000\u0000}\t\u0001\u0000\u0000\u0000\r\r\u0019&+4@ENZfrw|";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}