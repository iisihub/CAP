
/*! JSON v3.2.2 | http://bestiejs.github.com/json3 | Copyright 2012, Kit Cambridge | http://kit.mit-license.org */
;(function(){function g(a){throw a;}var k=void 0,l=!0,m=null,n={}.toString,o,p,q="function"===typeof define&&define.c,s="object"==typeof exports&&exports,u='{"A":[1,true,false,null,"\\u0000\\b\\n\\f\\r\\t"]}',w,x,y,B,C,D,E,F,G,H,I,M,N=new Date(-3509827334573292),O,P,Q;try{N=-109252==N.getUTCFullYear()&&0===N.getUTCMonth()&&1==N.getUTCDate()&&10==N.getUTCHours()&&37==N.getUTCMinutes()&&6==N.getUTCSeconds()&&708==N.getUTCMilliseconds()}catch(R){}
N||(O=Math.floor,P=[0,31,59,90,120,151,181,212,243,273,304,334],Q=function(a,b){return P[b]+365*(a-1970)+O((a-1969+(b=+(1<b)))/4)-O((a-1901+b)/100)+O((a-1601+b)/400)});q||s?(q&&define("json",s={}),"object"==typeof JSON&&JSON&&(s.stringify=JSON.stringify,s.parse=JSON.parse)):s=this.JSON||(this.JSON={});
if(w="function"==typeof s.stringify&&!Q){(N=function(){return 1}).toJSON=N;try{w="0"===s.stringify(0)&&"0"===s.stringify(new Number)&&'""'==s.stringify(new String)&&s.stringify(n)===k&&s.stringify(k)===k&&s.stringify()===k&&"1"===s.stringify(N)&&"[1]"==s.stringify([N])&&"null"==s.stringify(m)&&"[null,null,null]"==s.stringify([k,n,m])&&s.stringify({result:[N,l,!1,m,"\x00\u0008\n\u000c\r\t"]})==u&&"1"===s.stringify(m,N)&&"[\n 1,\n 2\n]"==s.stringify([1,2],m,1)&&'"-271821-04-20T00:00:00.000Z"'==s.stringify(new Date(-864E13))&&
'"+275760-09-13T00:00:00.000Z"'==s.stringify(new Date(864E13))&&'"-000001-01-01T00:00:00.000Z"'==s.stringify(new Date(-621987552E5))&&'"1969-12-31T23:59:59.999Z"'==s.stringify(new Date(-1))}catch(S){w=!1}}if("function"==typeof s.parse)try{if(0===s.parse("0")&&!s.parse(!1)&&(N=s.parse(u),D=5==N.a.length&&1==N.a[0])){try{D=!s.parse('"\t"')}catch(T){}if(D)try{D=1!=s.parse("01")}catch(U){}}}catch(V){D=!1}N=u=m;
if(!w||!D){if(!(o={}.hasOwnProperty))o=function(a){var b={},d;if((b.__proto__=m,b.__proto__={toString:1},b).toString!=n)o=function(c){var a=this.__proto__,c=c in(this.__proto__=m,this);this.__proto__=a;return c};else{d=b.constructor;o=function(a){var b=(this.constructor||d).prototype;return a in this&&!(a in b&&this[a]===b[a])}}b=m;return o.call(this,a)};p=function(a,b){var d=0,c,f,j;(c=function(){this.valueOf=0}).prototype.valueOf=0;f=new c;for(j in f)o.call(f,j)&&d++;c=f=m;if(d)d=d==2?function(a,
b){var c={},d=n.call(a)=="[object Function]",f;for(f in a)!(d&&f=="prototype")&&!o.call(c,f)&&(c[f]=1)&&o.call(a,f)&&b(f)}:function(a,b){var c=n.call(a)=="[object Function]",d,f;for(d in a)!(c&&d=="prototype")&&o.call(a,d)&&!(f=d==="constructor")&&b(d);(f||o.call(a,d="constructor"))&&b(d)};else{f=["valueOf","toString","toLocaleString","propertyIsEnumerable","isPrototypeOf","hasOwnProperty","constructor"];d=function(a,b){var c=n.call(a)=="[object Function]",d;for(d in a)!(c&&d=="prototype")&&o.call(a,
d)&&b(d);for(c=f.length;d=f[--c];o.call(a,d)&&b(d));}}d(a,b)};w||(x={"\\":"\\\\",'"':'\\"',"\u0008":"\\b","\u000c":"\\f","\n":"\\n","\r":"\\r","\t":"\\t"},y=function(a,b){return("000000"+(b||0)).slice(-a)},B=function(a){for(var b='"',d=0,c;c=a.charAt(d);d++)b=b+('\\"\u0008\u000c\n\r\t'.indexOf(c)>-1?x[c]:c<" "?"\\u00"+y(2,c.charCodeAt(0).toString(16)):c);return b+'"'},C=function(a,b,d,c,f,j,h){var e=b[a],i,r,t,v,J,K,L,z,A;if(typeof e=="object"&&e)if(n.call(e)=="[object Date]"&&!o.call(e,"toJSON"))if(e>
-1/0&&e<1/0){if(Q){t=O(e/864E5);for(i=O(t/365.2425)+1970-1;Q(i+1,0)<=t;i++);for(r=O((t-Q(i,0))/30.42);Q(i,r+1)<=t;r++);t=1+t-Q(i,r);v=(e%864E5+864E5)%864E5;J=O(v/36E5)%24;K=O(v/6E4)%60;L=O(v/1E3)%60;v=v%1E3}else{i=e.getUTCFullYear();r=e.getUTCMonth();t=e.getUTCDate();J=e.getUTCHours();K=e.getUTCMinutes();L=e.getUTCSeconds();v=e.getUTCMilliseconds()}e=(i<=0||i>=1E4?(i<0?"-":"+")+y(6,i<0?-i:i):y(4,i))+"-"+y(2,r+1)+"-"+y(2,t)+"T"+y(2,J)+":"+y(2,K)+":"+y(2,L)+"."+y(3,v)+"Z"}else e=m;else typeof e.toJSON==
"function"&&(e=e.toJSON(a));d&&(e=d.call(b,a,e));if(e===m)return"null";i=n.call(e);if(i=="[object Boolean]")return""+e;if(i=="[object Number]")return e>-1/0&&e<1/0?""+e:"null";if(i=="[object String]")return B(e);if(typeof e=="object"){for(a=h.length;a--;)h[a]===e&&g(TypeError());h.push(e);z=[];b=j;j=j+f;if(i=="[object Array]"){r=0;for(a=e.length;r<a;A||(A=l),r++){i=C(r,e,d,c,f,j,h);z.push(i===k?"null":i)}return A?f?"[\n"+j+z.join(",\n"+j)+"\n"+b+"]":"["+z.join(",")+"]":"[]"}p(c||e,function(a){var b=
C(a,e,d,c,f,j,h);b!==k&&z.push(B(a)+":"+(f?" ":"")+b);A||(A=l)});return A?f?"{\n"+j+z.join(",\n"+j)+"\n"+b+"}":"{"+z.join(",")+"}":"{}"}},s.stringify=function(a,b,d){var c,f,j,h,e;if(typeof b=="function"||typeof b=="object"&&b)if(n.call(b)=="[object Function]")f=b;else if(n.call(b)=="[object Array]"){j={};for(h=b.length;h--;(e=b[h])&&(n.call(e)=="[object String]"||n.call(e)=="[object Number]")&&(j[e]=1));}if(d)if(n.call(d)=="[object Number]"){if((d=d-d%1)>0){c="";for(d>10&&(d=10);c.length<d;c=c+" ");
}}else n.call(d)=="[object String]"&&(c=d.length<=10?d:d.slice(0,10));return C("",(e={},e[""]=a,e),f,j,c,"",[])});D||(E=String.fromCharCode,F={"\\":"\\",'"':'"',"/":"/",b:"\u0008",t:"\t",n:"\n",f:"\u000c",r:"\r"},G=function(a){for(var b=a[0],d=b.length,c,f,j,h,e;a[1]<d;){c=b.charAt(a[1]);if("\t\r\n ".indexOf(c)>-1)a[1]++;else{if("{}[]:,".indexOf(c)>-1){a[1]++;return c}if(c=='"'){f="@";for(a[1]++;a[1]<d;){c=b.charAt(a[1]);c<" "&&g(SyntaxError());if(c=="\\"){c=b.charAt(++a[1]);if('\\"/btnfr'.indexOf(c)>
-1){f=f+F[c];a[1]++}else if(c=="u"){j=++a[1];for(h=a[1]+4;a[1]<h;a[1]++){c=b.charAt(a[1]);c>="0"&&c<="9"||c>="a"&&c<="f"||c>="A"&&c<="F"||g(SyntaxError())}f=f+E("0x"+b.slice(j,a[1]))}else g(SyntaxError())}else{if(c=='"')break;f=f+c;a[1]++}}if(b.charAt(a[1])=='"'){a[1]++;return f}}else{j=a[1];if(c=="-"){e=l;c=b.charAt(++a[1])}if(c>="0"&&c<="9"){for(c=="0"&&(c=b.charAt(a[1]+1),c>="0"&&c<="9")&&g(SyntaxError());a[1]<d&&(c=b.charAt(a[1]),c>="0"&&c<="9");a[1]++);if(b.charAt(a[1])=="."){for(h=++a[1];h<
d&&(c=b.charAt(h),c>="0"&&c<="9");h++);h==a[1]&&g(SyntaxError());a[1]=h}c=b.charAt(a[1]);if(c=="e"||c=="E"){c=b.charAt(++a[1]);(c=="+"||c=="-")&&a[1]++;for(h=a[1];h<d&&(c=b.charAt(h),c>="0"&&c<="9");h++);h==a[1]&&g(SyntaxError());a[1]=h}return+b.slice(j,a[1])}e&&g(SyntaxError());if(b.slice(a[1],a[1]+4)=="true"){a[1]=a[1]+4;return l}if(b.slice(a[1],a[1]+5)=="false"){a[1]=a[1]+5;return false}if(b.slice(a[1],a[1]+4)=="null"){a[1]=a[1]+4;return m}}g(SyntaxError())}}return"$"},H=function(a,b){var d,c;
b=="$"&&g(SyntaxError());if(typeof b=="string"){if(b.charAt(0)=="@")return b.slice(1);if(b=="["){for(d=[];;c||(c=l)){b=G(a);if(b=="]")break;if(c)if(b==","){b=G(a);b=="}"&&g(SyntaxError())}else g(SyntaxError());b==","&&g(SyntaxError());d.push(H(a,b))}return d}if(b=="{"){for(d={};;c||(c=l)){b=G(a);if(b=="}")break;if(c)if(b==","){b=G(a);b=="}"&&g(SyntaxError())}else g(SyntaxError());(b==","||typeof b!="string"||b.charAt(0)!="@"||G(a)!=":")&&g(SyntaxError());d[b.slice(1)]=H(a,G(a))}return d}g(SyntaxError())}return b},
M=function(a,b,d){d=I(a,b,d);d===k?delete a[b]:a[b]=d},I=function(a,b,d){var c=a[b],f;if(typeof c=="object"&&c)if(n.call(c)=="[object Array]")for(f=c.length;f--;)M(c,f,d);else p(c,function(a){M(c,a,d)});return d.call(a,b,c)},s.parse=function(a,b){var d=[a,0],c=H(d,G(d));G(d)!="$"&&g(SyntaxError());return b&&n.call(b)=="[object Function]"?I((d={},d[""]=c,d),"",b):c})};
}());
define("json3", function(){});

/*!
 * jQuery JavaScript Library v1.8.2
 * http://jquery.com/
 *
 * Includes Sizzle.js
 * http://sizzlejs.com/
 *
 * Copyright 2012 jQuery Foundation and other contributors
 * Released under the MIT license
 * http://jquery.org/license
 *
 * Date: Thu Sep 20 2012 21:13:05 GMT-0400 (Eastern Daylight Time)
 */
(function( window, undefined ) {
var
	// A central reference to the root jQuery(document)
	rootjQuery,

	// The deferred used on DOM ready
	readyList,

	// Use the correct document accordingly with window argument (sandbox)
	document = window.document,
	location = window.location,
	navigator = window.navigator,

	// Map over jQuery in case of overwrite
	_jQuery = window.jQuery,

	// Map over the $ in case of overwrite
	_$ = window.$,

	// Save a reference to some core methods
	core_push = Array.prototype.push,
	core_slice = Array.prototype.slice,
	core_indexOf = Array.prototype.indexOf,
	core_toString = Object.prototype.toString,
	core_hasOwn = Object.prototype.hasOwnProperty,
	core_trim = String.prototype.trim,

	// Define a local copy of jQuery
	jQuery = function( selector, context ) {
		// The jQuery object is actually just the init constructor 'enhanced'
		return new jQuery.fn.init( selector, context, rootjQuery );
	},

	// Used for matching numbers
	core_pnum = /[\-+]?(?:\d*\.|)\d+(?:[eE][\-+]?\d+|)/.source,

	// Used for detecting and trimming whitespace
	core_rnotwhite = /\S/,
	core_rspace = /\s+/,

	// Make sure we trim BOM and NBSP (here's looking at you, Safari 5.0 and IE)
	rtrim = /^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g,

	// A simple way to check for HTML strings
	// Prioritize #id over <tag> to avoid XSS via location.hash (#9521)
	rquickExpr = /^(?:[^#<]*(<[\w\W]+>)[^>]*$|#([\w\-]*)$)/,

	// Match a standalone tag
	rsingleTag = /^<(\w+)\s*\/?>(?:<\/\1>|)$/,

	// JSON RegExp
	rvalidchars = /^[\],:{}\s]*$/,
	rvalidbraces = /(?:^|:|,)(?:\s*\[)+/g,
	rvalidescape = /\\(?:["\\\/bfnrt]|u[\da-fA-F]{4})/g,
	rvalidtokens = /"[^"\\\r\n]*"|true|false|null|-?(?:\d\d*\.|)\d+(?:[eE][\-+]?\d+|)/g,

	// Matches dashed string for camelizing
	rmsPrefix = /^-ms-/,
	rdashAlpha = /-([\da-z])/gi,

	// Used by jQuery.camelCase as callback to replace()
	fcamelCase = function( all, letter ) {
		return ( letter + "" ).toUpperCase();
	},

	// The ready event handler and self cleanup method
	DOMContentLoaded = function() {
		if ( document.addEventListener ) {
			document.removeEventListener( "DOMContentLoaded", DOMContentLoaded, false );
			jQuery.ready();
		} else if ( document.readyState === "complete" ) {
			// we're here because readyState === "complete" in oldIE
			// which is good enough for us to call the dom ready!
			document.detachEvent( "onreadystatechange", DOMContentLoaded );
			jQuery.ready();
		}
	},

	// [[Class]] -> type pairs
	class2type = {};

jQuery.fn = jQuery.prototype = {
	constructor: jQuery,
	init: function( selector, context, rootjQuery ) {
		var match, elem, ret, doc;

		// Handle $(""), $(null), $(undefined), $(false)
		if ( !selector ) {
			return this;
		}

		// Handle $(DOMElement)
		if ( selector.nodeType ) {
			this.context = this[0] = selector;
			this.length = 1;
			return this;
		}

		// Handle HTML strings
		if ( typeof selector === "string" ) {
			if ( selector.charAt(0) === "<" && selector.charAt( selector.length - 1 ) === ">" && selector.length >= 3 ) {
				// Assume that strings that start and end with <> are HTML and skip the regex check
				match = [ null, selector, null ];

			} else {
				match = rquickExpr.exec( selector );
			}

			// Match html or make sure no context is specified for #id
			if ( match && (match[1] || !context) ) {

				// HANDLE: $(html) -> $(array)
				if ( match[1] ) {
					context = context instanceof jQuery ? context[0] : context;
					doc = ( context && context.nodeType ? context.ownerDocument || context : document );

					// scripts is true for back-compat
					selector = jQuery.parseHTML( match[1], doc, true );
					if ( rsingleTag.test( match[1] ) && jQuery.isPlainObject( context ) ) {
						this.attr.call( selector, context, true );
					}

					return jQuery.merge( this, selector );

				// HANDLE: $(#id)
				} else {
					elem = document.getElementById( match[2] );

					// Check parentNode to catch when Blackberry 4.6 returns
					// nodes that are no longer in the document #6963
					if ( elem && elem.parentNode ) {
						// Handle the case where IE and Opera return items
						// by name instead of ID
						if ( elem.id !== match[2] ) {
							return rootjQuery.find( selector );
						}

						// Otherwise, we inject the element directly into the jQuery object
						this.length = 1;
						this[0] = elem;
					}

					this.context = document;
					this.selector = selector;
					return this;
				}

			// HANDLE: $(expr, $(...))
			} else if ( !context || context.jquery ) {
				return ( context || rootjQuery ).find( selector );

			// HANDLE: $(expr, context)
			// (which is just equivalent to: $(context).find(expr)
			} else {
				return this.constructor( context ).find( selector );
			}

		// HANDLE: $(function)
		// Shortcut for document ready
		} else if ( jQuery.isFunction( selector ) ) {
			return rootjQuery.ready( selector );
		}

		if ( selector.selector !== undefined ) {
			this.selector = selector.selector;
			this.context = selector.context;
		}

		return jQuery.makeArray( selector, this );
	},

	// Start with an empty selector
	selector: "",

	// The current version of jQuery being used
	jquery: "1.8.2",

	// The default length of a jQuery object is 0
	length: 0,

	// The number of elements contained in the matched element set
	size: function() {
		return this.length;
	},

	toArray: function() {
		return core_slice.call( this );
	},

	// Get the Nth element in the matched element set OR
	// Get the whole matched element set as a clean array
	get: function( num ) {
		return num == null ?

			// Return a 'clean' array
			this.toArray() :

			// Return just the object
			( num < 0 ? this[ this.length + num ] : this[ num ] );
	},

	// Take an array of elements and push it onto the stack
	// (returning the new matched element set)
	pushStack: function( elems, name, selector ) {

		// Build a new jQuery matched element set
		var ret = jQuery.merge( this.constructor(), elems );

		// Add the old object onto the stack (as a reference)
		ret.prevObject = this;

		ret.context = this.context;

		if ( name === "find" ) {
			ret.selector = this.selector + ( this.selector ? " " : "" ) + selector;
		} else if ( name ) {
			ret.selector = this.selector + "." + name + "(" + selector + ")";
		}

		// Return the newly-formed element set
		return ret;
	},

	// Execute a callback for every element in the matched set.
	// (You can seed the arguments with an array of args, but this is
	// only used internally.)
	each: function( callback, args ) {
		return jQuery.each( this, callback, args );
	},

	ready: function( fn ) {
		// Add the callback
		jQuery.ready.promise().done( fn );

		return this;
	},

	eq: function( i ) {
		i = +i;
		return i === -1 ?
			this.slice( i ) :
			this.slice( i, i + 1 );
	},

	first: function() {
		return this.eq( 0 );
	},

	last: function() {
		return this.eq( -1 );
	},

	slice: function() {
		return this.pushStack( core_slice.apply( this, arguments ),
			"slice", core_slice.call(arguments).join(",") );
	},

	map: function( callback ) {
		return this.pushStack( jQuery.map(this, function( elem, i ) {
			return callback.call( elem, i, elem );
		}));
	},

	end: function() {
		return this.prevObject || this.constructor(null);
	},

	// For internal use only.
	// Behaves like an Array's method, not like a jQuery method.
	push: core_push,
	sort: [].sort,
	splice: [].splice
};

// Give the init function the jQuery prototype for later instantiation
jQuery.fn.init.prototype = jQuery.fn;

jQuery.extend = jQuery.fn.extend = function() {
	var options, name, src, copy, copyIsArray, clone,
		target = arguments[0] || {},
		i = 1,
		length = arguments.length,
		deep = false;

	// Handle a deep copy situation
	if ( typeof target === "boolean" ) {
		deep = target;
		target = arguments[1] || {};
		// skip the boolean and the target
		i = 2;
	}

	// Handle case when target is a string or something (possible in deep copy)
	if ( typeof target !== "object" && !jQuery.isFunction(target) ) {
		target = {};
	}

	// extend jQuery itself if only one argument is passed
	if ( length === i ) {
		target = this;
		--i;
	}

	for ( ; i < length; i++ ) {
		// Only deal with non-null/undefined values
		if ( (options = arguments[ i ]) != null ) {
			// Extend the base object
			for ( name in options ) {
				src = target[ name ];
				copy = options[ name ];

				// Prevent never-ending loop
				if ( target === copy ) {
					continue;
				}

				// Recurse if we're merging plain objects or arrays
				if ( deep && copy && ( jQuery.isPlainObject(copy) || (copyIsArray = jQuery.isArray(copy)) ) ) {
					if ( copyIsArray ) {
						copyIsArray = false;
						clone = src && jQuery.isArray(src) ? src : [];

					} else {
						clone = src && jQuery.isPlainObject(src) ? src : {};
					}

					// Never move original objects, clone them
					target[ name ] = jQuery.extend( deep, clone, copy );

				// Don't bring in undefined values
				} else if ( copy !== undefined ) {
					target[ name ] = copy;
				}
			}
		}
	}

	// Return the modified object
	return target;
};

jQuery.extend({
	noConflict: function( deep ) {
		if ( window.$ === jQuery ) {
			window.$ = _$;
		}

		if ( deep && window.jQuery === jQuery ) {
			window.jQuery = _jQuery;
		}

		return jQuery;
	},

	// Is the DOM ready to be used? Set to true once it occurs.
	isReady: false,

	// A counter to track how many items to wait for before
	// the ready event fires. See #6781
	readyWait: 1,

	// Hold (or release) the ready event
	holdReady: function( hold ) {
		if ( hold ) {
			jQuery.readyWait++;
		} else {
			jQuery.ready( true );
		}
	},

	// Handle when the DOM is ready
	ready: function( wait ) {

		// Abort if there are pending holds or we're already ready
		if ( wait === true ? --jQuery.readyWait : jQuery.isReady ) {
			return;
		}

		// Make sure body exists, at least, in case IE gets a little overzealous (ticket #5443).
		if ( !document.body ) {
			return setTimeout( jQuery.ready, 1 );
		}

		// Remember that the DOM is ready
		jQuery.isReady = true;

		// If a normal DOM Ready event fired, decrement, and wait if need be
		if ( wait !== true && --jQuery.readyWait > 0 ) {
			return;
		}

		// If there are functions bound, to execute
		readyList.resolveWith( document, [ jQuery ] );

		// Trigger any bound ready events
		if ( jQuery.fn.trigger ) {
			jQuery( document ).trigger("ready").off("ready");
		}
	},

	// See test/unit/core.js for details concerning isFunction.
	// Since version 1.3, DOM methods and functions like alert
	// aren't supported. They return false on IE (#2968).
	isFunction: function( obj ) {
		return jQuery.type(obj) === "function";
	},

	isArray: Array.isArray || function( obj ) {
		return jQuery.type(obj) === "array";
	},

	isWindow: function( obj ) {
		return obj != null && obj == obj.window;
	},

	isNumeric: function( obj ) {
		return !isNaN( parseFloat(obj) ) && isFinite( obj );
	},

	type: function( obj ) {
		return obj == null ?
			String( obj ) :
			class2type[ core_toString.call(obj) ] || "object";
	},

	isPlainObject: function( obj ) {
		// Must be an Object.
		// Because of IE, we also have to check the presence of the constructor property.
		// Make sure that DOM nodes and window objects don't pass through, as well
		if ( !obj || jQuery.type(obj) !== "object" || obj.nodeType || jQuery.isWindow( obj ) ) {
			return false;
		}

		try {
			// Not own constructor property must be Object
			if ( obj.constructor &&
				!core_hasOwn.call(obj, "constructor") &&
				!core_hasOwn.call(obj.constructor.prototype, "isPrototypeOf") ) {
				return false;
			}
		} catch ( e ) {
			// IE8,9 Will throw exceptions on certain host objects #9897
			return false;
		}

		// Own properties are enumerated firstly, so to speed up,
		// if last one is own, then all properties are own.

		var key;
		for ( key in obj ) {}

		return key === undefined || core_hasOwn.call( obj, key );
	},

	isEmptyObject: function( obj ) {
		var name;
		for ( name in obj ) {
			return false;
		}
		return true;
	},

	error: function( msg ) {
		throw new Error( msg );
	},

	// data: string of html
	// context (optional): If specified, the fragment will be created in this context, defaults to document
	// scripts (optional): If true, will include scripts passed in the html string
	parseHTML: function( data, context, scripts ) {
		var parsed;
		if ( !data || typeof data !== "string" ) {
			return null;
		}
		if ( typeof context === "boolean" ) {
			scripts = context;
			context = 0;
		}
		context = context || document;

		// Single tag
		if ( (parsed = rsingleTag.exec( data )) ) {
			return [ context.createElement( parsed[1] ) ];
		}

		parsed = jQuery.buildFragment( [ data ], context, scripts ? null : [] );
		return jQuery.merge( [],
			(parsed.cacheable ? jQuery.clone( parsed.fragment ) : parsed.fragment).childNodes );
	},

	parseJSON: function( data ) {
		if ( !data || typeof data !== "string") {
			return null;
		}

		// Make sure leading/trailing whitespace is removed (IE can't handle it)
		data = jQuery.trim( data );

		// Attempt to parse using the native JSON parser first
		if ( window.JSON && window.JSON.parse ) {
			return window.JSON.parse( data );
		}

		// Make sure the incoming data is actual JSON
		// Logic borrowed from http://json.org/json2.js
		if ( rvalidchars.test( data.replace( rvalidescape, "@" )
			.replace( rvalidtokens, "]" )
			.replace( rvalidbraces, "")) ) {

			return ( new Function( "return " + data ) )();

		}
		jQuery.error( "Invalid JSON: " + data );
	},

	// Cross-browser xml parsing
	parseXML: function( data ) {
		var xml, tmp;
		if ( !data || typeof data !== "string" ) {
			return null;
		}
		try {
			if ( window.DOMParser ) { // Standard
				tmp = new DOMParser();
				xml = tmp.parseFromString( data , "text/xml" );
			} else { // IE
				xml = new ActiveXObject( "Microsoft.XMLDOM" );
				xml.async = "false";
				xml.loadXML( data );
			}
		} catch( e ) {
			xml = undefined;
		}
		if ( !xml || !xml.documentElement || xml.getElementsByTagName( "parsererror" ).length ) {
			jQuery.error( "Invalid XML: " + data );
		}
		return xml;
	},

	noop: function() {},

	// Evaluates a script in a global context
	// Workarounds based on findings by Jim Driscoll
	// http://weblogs.java.net/blog/driscoll/archive/2009/09/08/eval-javascript-global-context
	globalEval: function( data ) {
		if ( data && core_rnotwhite.test( data ) ) {
			// We use execScript on Internet Explorer
			// We use an anonymous function so that context is window
			// rather than jQuery in Firefox
			( window.execScript || function( data ) {
				window[ "eval" ].call( window, data );
			} )( data );
		}
	},

	// Convert dashed to camelCase; used by the css and data modules
	// Microsoft forgot to hump their vendor prefix (#9572)
	camelCase: function( string ) {
		return string.replace( rmsPrefix, "ms-" ).replace( rdashAlpha, fcamelCase );
	},

	nodeName: function( elem, name ) {
		return elem.nodeName && elem.nodeName.toLowerCase() === name.toLowerCase();
	},

	// args is for internal usage only
	each: function( obj, callback, args ) {
		var name,
			i = 0,
			length = obj.length,
			isObj = length === undefined || jQuery.isFunction( obj );

		if ( args ) {
			if ( isObj ) {
				for ( name in obj ) {
					if ( callback.apply( obj[ name ], args ) === false ) {
						break;
					}
				}
			} else {
				for ( ; i < length; ) {
					if ( callback.apply( obj[ i++ ], args ) === false ) {
						break;
					}
				}
			}

		// A special, fast, case for the most common use of each
		} else {
			if ( isObj ) {
				for ( name in obj ) {
					if ( callback.call( obj[ name ], name, obj[ name ] ) === false ) {
						break;
					}
				}
			} else {
				for ( ; i < length; ) {
					if ( callback.call( obj[ i ], i, obj[ i++ ] ) === false ) {
						break;
					}
				}
			}
		}

		return obj;
	},

	// Use native String.trim function wherever possible
	trim: core_trim && !core_trim.call("\uFEFF\xA0") ?
		function( text ) {
			return text == null ?
				"" :
				core_trim.call( text );
		} :

		// Otherwise use our own trimming functionality
		function( text ) {
			return text == null ?
				"" :
				( text + "" ).replace( rtrim, "" );
		},

	// results is for internal usage only
	makeArray: function( arr, results ) {
		var type,
			ret = results || [];

		if ( arr != null ) {
			// The window, strings (and functions) also have 'length'
			// Tweaked logic slightly to handle Blackberry 4.7 RegExp issues #6930
			type = jQuery.type( arr );

			if ( arr.length == null || type === "string" || type === "function" || type === "regexp" || jQuery.isWindow( arr ) ) {
				core_push.call( ret, arr );
			} else {
				jQuery.merge( ret, arr );
			}
		}

		return ret;
	},

	inArray: function( elem, arr, i ) {
		var len;

		if ( arr ) {
			if ( core_indexOf ) {
				return core_indexOf.call( arr, elem, i );
			}

			len = arr.length;
			i = i ? i < 0 ? Math.max( 0, len + i ) : i : 0;

			for ( ; i < len; i++ ) {
				// Skip accessing in sparse arrays
				if ( i in arr && arr[ i ] === elem ) {
					return i;
				}
			}
		}

		return -1;
	},

	merge: function( first, second ) {
		var l = second.length,
			i = first.length,
			j = 0;

		if ( typeof l === "number" ) {
			for ( ; j < l; j++ ) {
				first[ i++ ] = second[ j ];
			}

		} else {
			while ( second[j] !== undefined ) {
				first[ i++ ] = second[ j++ ];
			}
		}

		first.length = i;

		return first;
	},

	grep: function( elems, callback, inv ) {
		var retVal,
			ret = [],
			i = 0,
			length = elems.length;
		inv = !!inv;

		// Go through the array, only saving the items
		// that pass the validator function
		for ( ; i < length; i++ ) {
			retVal = !!callback( elems[ i ], i );
			if ( inv !== retVal ) {
				ret.push( elems[ i ] );
			}
		}

		return ret;
	},

	// arg is for internal usage only
	map: function( elems, callback, arg ) {
		var value, key,
			ret = [],
			i = 0,
			length = elems.length,
			// jquery objects are treated as arrays
			isArray = elems instanceof jQuery || length !== undefined && typeof length === "number" && ( ( length > 0 && elems[ 0 ] && elems[ length -1 ] ) || length === 0 || jQuery.isArray( elems ) ) ;

		// Go through the array, translating each of the items to their
		if ( isArray ) {
			for ( ; i < length; i++ ) {
				value = callback( elems[ i ], i, arg );

				if ( value != null ) {
					ret[ ret.length ] = value;
				}
			}

		// Go through every key on the object,
		} else {
			for ( key in elems ) {
				value = callback( elems[ key ], key, arg );

				if ( value != null ) {
					ret[ ret.length ] = value;
				}
			}
		}

		// Flatten any nested arrays
		return ret.concat.apply( [], ret );
	},

	// A global GUID counter for objects
	guid: 1,

	// Bind a function to a context, optionally partially applying any
	// arguments.
	proxy: function( fn, context ) {
		var tmp, args, proxy;

		if ( typeof context === "string" ) {
			tmp = fn[ context ];
			context = fn;
			fn = tmp;
		}

		// Quick check to determine if target is callable, in the spec
		// this throws a TypeError, but we will just return undefined.
		if ( !jQuery.isFunction( fn ) ) {
			return undefined;
		}

		// Simulated bind
		args = core_slice.call( arguments, 2 );
		proxy = function() {
			return fn.apply( context, args.concat( core_slice.call( arguments ) ) );
		};

		// Set the guid of unique handler to the same of original handler, so it can be removed
		proxy.guid = fn.guid = fn.guid || jQuery.guid++;

		return proxy;
	},

	// Multifunctional method to get and set values of a collection
	// The value/s can optionally be executed if it's a function
	access: function( elems, fn, key, value, chainable, emptyGet, pass ) {
		var exec,
			bulk = key == null,
			i = 0,
			length = elems.length;

		// Sets many values
		if ( key && typeof key === "object" ) {
			for ( i in key ) {
				jQuery.access( elems, fn, i, key[i], 1, emptyGet, value );
			}
			chainable = 1;

		// Sets one value
		} else if ( value !== undefined ) {
			// Optionally, function values get executed if exec is true
			exec = pass === undefined && jQuery.isFunction( value );

			if ( bulk ) {
				// Bulk operations only iterate when executing function values
				if ( exec ) {
					exec = fn;
					fn = function( elem, key, value ) {
						return exec.call( jQuery( elem ), value );
					};

				// Otherwise they run against the entire set
				} else {
					fn.call( elems, value );
					fn = null;
				}
			}

			if ( fn ) {
				for (; i < length; i++ ) {
					fn( elems[i], key, exec ? value.call( elems[i], i, fn( elems[i], key ) ) : value, pass );
				}
			}

			chainable = 1;
		}

		return chainable ?
			elems :

			// Gets
			bulk ?
				fn.call( elems ) :
				length ? fn( elems[0], key ) : emptyGet;
	},

	now: function() {
		return ( new Date() ).getTime();
	}
});

jQuery.ready.promise = function( obj ) {
	if ( !readyList ) {

		readyList = jQuery.Deferred();

		// Catch cases where $(document).ready() is called after the browser event has already occurred.
		// we once tried to use readyState "interactive" here, but it caused issues like the one
		// discovered by ChrisS here: http://bugs.jquery.com/ticket/12282#comment:15
		if ( document.readyState === "complete" ) {
			// Handle it asynchronously to allow scripts the opportunity to delay ready
			setTimeout( jQuery.ready, 1 );

		// Standards-based browsers support DOMContentLoaded
		} else if ( document.addEventListener ) {
			// Use the handy event callback
			document.addEventListener( "DOMContentLoaded", DOMContentLoaded, false );

			// A fallback to window.onload, that will always work
			window.addEventListener( "load", jQuery.ready, false );

		// If IE event model is used
		} else {
			// Ensure firing before onload, maybe late but safe also for iframes
			document.attachEvent( "onreadystatechange", DOMContentLoaded );

			// A fallback to window.onload, that will always work
			window.attachEvent( "onload", jQuery.ready );

			// If IE and not a frame
			// continually check to see if the document is ready
			var top = false;

			try {
				top = window.frameElement == null && document.documentElement;
			} catch(e) {}

			if ( top && top.doScroll ) {
				(function doScrollCheck() {
					if ( !jQuery.isReady ) {

						try {
							// Use the trick by Diego Perini
							// http://javascript.nwbox.com/IEContentLoaded/
							top.doScroll("left");
						} catch(e) {
							return setTimeout( doScrollCheck, 50 );
						}

						// and execute any waiting functions
						jQuery.ready();
					}
				})();
			}
		}
	}
	return readyList.promise( obj );
};

// Populate the class2type map
jQuery.each("Boolean Number String Function Array Date RegExp Object".split(" "), function(i, name) {
	class2type[ "[object " + name + "]" ] = name.toLowerCase();
});

// All jQuery objects should point back to these
rootjQuery = jQuery(document);
// String to Object options format cache
var optionsCache = {};

// Convert String-formatted options into Object-formatted ones and store in cache
function createOptions( options ) {
	var object = optionsCache[ options ] = {};
	jQuery.each( options.split( core_rspace ), function( _, flag ) {
		object[ flag ] = true;
	});
	return object;
}

/*
 * Create a callback list using the following parameters:
 *
 *	options: an optional list of space-separated options that will change how
 *			the callback list behaves or a more traditional option object
 *
 * By default a callback list will act like an event callback list and can be
 * "fired" multiple times.
 *
 * Possible options:
 *
 *	once:			will ensure the callback list can only be fired once (like a Deferred)
 *
 *	memory:			will keep track of previous values and will call any callback added
 *					after the list has been fired right away with the latest "memorized"
 *					values (like a Deferred)
 *
 *	unique:			will ensure a callback can only be added once (no duplicate in the list)
 *
 *	stopOnFalse:	interrupt callings when a callback returns false
 *
 */
jQuery.Callbacks = function( options ) {

	// Convert options from String-formatted to Object-formatted if needed
	// (we check in cache first)
	options = typeof options === "string" ?
		( optionsCache[ options ] || createOptions( options ) ) :
		jQuery.extend( {}, options );

	var // Last fire value (for non-forgettable lists)
		memory,
		// Flag to know if list was already fired
		fired,
		// Flag to know if list is currently firing
		firing,
		// First callback to fire (used internally by add and fireWith)
		firingStart,
		// End of the loop when firing
		firingLength,
		// Index of currently firing callback (modified by remove if needed)
		firingIndex,
		// Actual callback list
		list = [],
		// Stack of fire calls for repeatable lists
		stack = !options.once && [],
		// Fire callbacks
		fire = function( data ) {
			memory = options.memory && data;
			fired = true;
			firingIndex = firingStart || 0;
			firingStart = 0;
			firingLength = list.length;
			firing = true;
			for ( ; list && firingIndex < firingLength; firingIndex++ ) {
				if ( list[ firingIndex ].apply( data[ 0 ], data[ 1 ] ) === false && options.stopOnFalse ) {
					memory = false; // To prevent further calls using add
					break;
				}
			}
			firing = false;
			if ( list ) {
				if ( stack ) {
					if ( stack.length ) {
						fire( stack.shift() );
					}
				} else if ( memory ) {
					list = [];
				} else {
					self.disable();
				}
			}
		},
		// Actual Callbacks object
		self = {
			// Add a callback or a collection of callbacks to the list
			add: function() {
				if ( list ) {
					// First, we save the current length
					var start = list.length;
					(function add( args ) {
						jQuery.each( args, function( _, arg ) {
							var type = jQuery.type( arg );
							if ( type === "function" && ( !options.unique || !self.has( arg ) ) ) {
								list.push( arg );
							} else if ( arg && arg.length && type !== "string" ) {
								// Inspect recursively
								add( arg );
							}
						});
					})( arguments );
					// Do we need to add the callbacks to the
					// current firing batch?
					if ( firing ) {
						firingLength = list.length;
					// With memory, if we're not firing then
					// we should call right away
					} else if ( memory ) {
						firingStart = start;
						fire( memory );
					}
				}
				return this;
			},
			// Remove a callback from the list
			remove: function() {
				if ( list ) {
					jQuery.each( arguments, function( _, arg ) {
						var index;
						while( ( index = jQuery.inArray( arg, list, index ) ) > -1 ) {
							list.splice( index, 1 );
							// Handle firing indexes
							if ( firing ) {
								if ( index <= firingLength ) {
									firingLength--;
								}
								if ( index <= firingIndex ) {
									firingIndex--;
								}
							}
						}
					});
				}
				return this;
			},
			// Control if a given callback is in the list
			has: function( fn ) {
				return jQuery.inArray( fn, list ) > -1;
			},
			// Remove all callbacks from the list
			empty: function() {
				list = [];
				return this;
			},
			// Have the list do nothing anymore
			disable: function() {
				list = stack = memory = undefined;
				return this;
			},
			// Is it disabled?
			disabled: function() {
				return !list;
			},
			// Lock the list in its current state
			lock: function() {
				stack = undefined;
				if ( !memory ) {
					self.disable();
				}
				return this;
			},
			// Is it locked?
			locked: function() {
				return !stack;
			},
			// Call all callbacks with the given context and arguments
			fireWith: function( context, args ) {
				args = args || [];
				args = [ context, args.slice ? args.slice() : args ];
				if ( list && ( !fired || stack ) ) {
					if ( firing ) {
						stack.push( args );
					} else {
						fire( args );
					}
				}
				return this;
			},
			// Call all the callbacks with the given arguments
			fire: function() {
				self.fireWith( this, arguments );
				return this;
			},
			// To know if the callbacks have already been called at least once
			fired: function() {
				return !!fired;
			}
		};

	return self;
};
jQuery.extend({

	Deferred: function( func ) {
		var tuples = [
				// action, add listener, listener list, final state
				[ "resolve", "done", jQuery.Callbacks("once memory"), "resolved" ],
				[ "reject", "fail", jQuery.Callbacks("once memory"), "rejected" ],
				[ "notify", "progress", jQuery.Callbacks("memory") ]
			],
			state = "pending",
			promise = {
				state: function() {
					return state;
				},
				always: function() {
					deferred.done( arguments ).fail( arguments );
					return this;
				},
				then: function( /* fnDone, fnFail, fnProgress */ ) {
					var fns = arguments;
					return jQuery.Deferred(function( newDefer ) {
						jQuery.each( tuples, function( i, tuple ) {
							var action = tuple[ 0 ],
								fn = fns[ i ];
							// deferred[ done | fail | progress ] for forwarding actions to newDefer
							deferred[ tuple[1] ]( jQuery.isFunction( fn ) ?
								function() {
									var returned = fn.apply( this, arguments );
									if ( returned && jQuery.isFunction( returned.promise ) ) {
										returned.promise()
											.done( newDefer.resolve )
											.fail( newDefer.reject )
											.progress( newDefer.notify );
									} else {
										newDefer[ action + "With" ]( this === deferred ? newDefer : this, [ returned ] );
									}
								} :
								newDefer[ action ]
							);
						});
						fns = null;
					}).promise();
				},
				// Get a promise for this deferred
				// If obj is provided, the promise aspect is added to the object
				promise: function( obj ) {
					return obj != null ? jQuery.extend( obj, promise ) : promise;
				}
			},
			deferred = {};

		// Keep pipe for back-compat
		promise.pipe = promise.then;

		// Add list-specific methods
		jQuery.each( tuples, function( i, tuple ) {
			var list = tuple[ 2 ],
				stateString = tuple[ 3 ];

			// promise[ done | fail | progress ] = list.add
			promise[ tuple[1] ] = list.add;

			// Handle state
			if ( stateString ) {
				list.add(function() {
					// state = [ resolved | rejected ]
					state = stateString;

				// [ reject_list | resolve_list ].disable; progress_list.lock
				}, tuples[ i ^ 1 ][ 2 ].disable, tuples[ 2 ][ 2 ].lock );
			}

			// deferred[ resolve | reject | notify ] = list.fire
			deferred[ tuple[0] ] = list.fire;
			deferred[ tuple[0] + "With" ] = list.fireWith;
		});

		// Make the deferred a promise
		promise.promise( deferred );

		// Call given func if any
		if ( func ) {
			func.call( deferred, deferred );
		}

		// All done!
		return deferred;
	},

	// Deferred helper
	when: function( subordinate /* , ..., subordinateN */ ) {
		var i = 0,
			resolveValues = core_slice.call( arguments ),
			length = resolveValues.length,

			// the count of uncompleted subordinates
			remaining = length !== 1 || ( subordinate && jQuery.isFunction( subordinate.promise ) ) ? length : 0,

			// the master Deferred. If resolveValues consist of only a single Deferred, just use that.
			deferred = remaining === 1 ? subordinate : jQuery.Deferred(),

			// Update function for both resolve and progress values
			updateFunc = function( i, contexts, values ) {
				return function( value ) {
					contexts[ i ] = this;
					values[ i ] = arguments.length > 1 ? core_slice.call( arguments ) : value;
					if( values === progressValues ) {
						deferred.notifyWith( contexts, values );
					} else if ( !( --remaining ) ) {
						deferred.resolveWith( contexts, values );
					}
				};
			},

			progressValues, progressContexts, resolveContexts;

		// add listeners to Deferred subordinates; treat others as resolved
		if ( length > 1 ) {
			progressValues = new Array( length );
			progressContexts = new Array( length );
			resolveContexts = new Array( length );
			for ( ; i < length; i++ ) {
				if ( resolveValues[ i ] && jQuery.isFunction( resolveValues[ i ].promise ) ) {
					resolveValues[ i ].promise()
						.done( updateFunc( i, resolveContexts, resolveValues ) )
						.fail( deferred.reject )
						.progress( updateFunc( i, progressContexts, progressValues ) );
				} else {
					--remaining;
				}
			}
		}

		// if we're not waiting on anything, resolve the master
		if ( !remaining ) {
			deferred.resolveWith( resolveContexts, resolveValues );
		}

		return deferred.promise();
	}
});
jQuery.support = (function() {

	var support,
		all,
		a,
		select,
		opt,
		input,
		fragment,
		eventName,
		i,
		isSupported,
		clickFn,
		div = document.createElement("div");

	// Preliminary tests
	div.setAttribute( "className", "t" );
	div.innerHTML = "  <link/><table></table><a href='/a'>a</a><input type='checkbox'/>";

	all = div.getElementsByTagName("*");
	a = div.getElementsByTagName("a")[ 0 ];
	a.style.cssText = "top:1px;float:left;opacity:.5";

	// Can't get basic test support
	if ( !all || !all.length ) {
		return {};
	}

	// First batch of supports tests
	select = document.createElement("select");
	opt = select.appendChild( document.createElement("option") );
	input = div.getElementsByTagName("input")[ 0 ];

	support = {
		// IE strips leading whitespace when .innerHTML is used
		leadingWhitespace: ( div.firstChild.nodeType === 3 ),

		// Make sure that tbody elements aren't automatically inserted
		// IE will insert them into empty tables
		tbody: !div.getElementsByTagName("tbody").length,

		// Make sure that link elements get serialized correctly by innerHTML
		// This requires a wrapper element in IE
		htmlSerialize: !!div.getElementsByTagName("link").length,

		// Get the style information from getAttribute
		// (IE uses .cssText instead)
		style: /top/.test( a.getAttribute("style") ),

		// Make sure that URLs aren't manipulated
		// (IE normalizes it by default)
		hrefNormalized: ( a.getAttribute("href") === "/a" ),

		// Make sure that element opacity exists
		// (IE uses filter instead)
		// Use a regex to work around a WebKit issue. See #5145
		opacity: /^0.5/.test( a.style.opacity ),

		// Verify style float existence
		// (IE uses styleFloat instead of cssFloat)
		cssFloat: !!a.style.cssFloat,

		// Make sure that if no value is specified for a checkbox
		// that it defaults to "on".
		// (WebKit defaults to "" instead)
		checkOn: ( input.value === "on" ),

		// Make sure that a selected-by-default option has a working selected property.
		// (WebKit defaults to false instead of true, IE too, if it's in an optgroup)
		optSelected: opt.selected,

		// Test setAttribute on camelCase class. If it works, we need attrFixes when doing get/setAttribute (ie6/7)
		getSetAttribute: div.className !== "t",

		// Tests for enctype support on a form(#6743)
		enctype: !!document.createElement("form").enctype,

		// Makes sure cloning an html5 element does not cause problems
		// Where outerHTML is undefined, this still works
		html5Clone: document.createElement("nav").cloneNode( true ).outerHTML !== "<:nav></:nav>",

		// jQuery.support.boxModel DEPRECATED in 1.8 since we don't support Quirks Mode
		boxModel: ( document.compatMode === "CSS1Compat" ),

		// Will be defined later
		submitBubbles: true,
		changeBubbles: true,
		focusinBubbles: false,
		deleteExpando: true,
		noCloneEvent: true,
		inlineBlockNeedsLayout: false,
		shrinkWrapBlocks: false,
		reliableMarginRight: true,
		boxSizingReliable: true,
		pixelPosition: false
	};

	// Make sure checked status is properly cloned
	input.checked = true;
	support.noCloneChecked = input.cloneNode( true ).checked;

	// Make sure that the options inside disabled selects aren't marked as disabled
	// (WebKit marks them as disabled)
	select.disabled = true;
	support.optDisabled = !opt.disabled;

	// Test to see if it's possible to delete an expando from an element
	// Fails in Internet Explorer
	try {
		delete div.test;
	} catch( e ) {
		support.deleteExpando = false;
	}

	if ( !div.addEventListener && div.attachEvent && div.fireEvent ) {
		div.attachEvent( "onclick", clickFn = function() {
			// Cloning a node shouldn't copy over any
			// bound event handlers (IE does this)
			support.noCloneEvent = false;
		});
		div.cloneNode( true ).fireEvent("onclick");
		div.detachEvent( "onclick", clickFn );
	}

	// Check if a radio maintains its value
	// after being appended to the DOM
	input = document.createElement("input");
	input.value = "t";
	input.setAttribute( "type", "radio" );
	support.radioValue = input.value === "t";

	input.setAttribute( "checked", "checked" );

	// #11217 - WebKit loses check when the name is after the checked attribute
	input.setAttribute( "name", "t" );

	div.appendChild( input );
	fragment = document.createDocumentFragment();
	fragment.appendChild( div.lastChild );

	// WebKit doesn't clone checked state correctly in fragments
	support.checkClone = fragment.cloneNode( true ).cloneNode( true ).lastChild.checked;

	// Check if a disconnected checkbox will retain its checked
	// value of true after appended to the DOM (IE6/7)
	support.appendChecked = input.checked;

	fragment.removeChild( input );
	fragment.appendChild( div );

	// Technique from Juriy Zaytsev
	// http://perfectionkills.com/detecting-event-support-without-browser-sniffing/
	// We only care about the case where non-standard event systems
	// are used, namely in IE. Short-circuiting here helps us to
	// avoid an eval call (in setAttribute) which can cause CSP
	// to go haywire. See: https://developer.mozilla.org/en/Security/CSP
	if ( div.attachEvent ) {
		for ( i in {
			submit: true,
			change: true,
			focusin: true
		}) {
			eventName = "on" + i;
			isSupported = ( eventName in div );
			if ( !isSupported ) {
				div.setAttribute( eventName, "return;" );
				isSupported = ( typeof div[ eventName ] === "function" );
			}
			support[ i + "Bubbles" ] = isSupported;
		}
	}

	// Run tests that need a body at doc ready
	jQuery(function() {
		var container, div, tds, marginDiv,
			divReset = "padding:0;margin:0;border:0;display:block;overflow:hidden;",
			body = document.getElementsByTagName("body")[0];

		if ( !body ) {
			// Return for frameset docs that don't have a body
			return;
		}

		container = document.createElement("div");
		container.style.cssText = "visibility:hidden;border:0;width:0;height:0;position:static;top:0;margin-top:1px";
		body.insertBefore( container, body.firstChild );

		// Construct the test element
		div = document.createElement("div");
		container.appendChild( div );

		// Check if table cells still have offsetWidth/Height when they are set
		// to display:none and there are still other visible table cells in a
		// table row; if so, offsetWidth/Height are not reliable for use when
		// determining if an element has been hidden directly using
		// display:none (it is still safe to use offsets if a parent element is
		// hidden; don safety goggles and see bug #4512 for more information).
		// (only IE 8 fails this test)
		div.innerHTML = "<table><tr><td></td><td>t</td></tr></table>";
		tds = div.getElementsByTagName("td");
		tds[ 0 ].style.cssText = "padding:0;margin:0;border:0;display:none";
		isSupported = ( tds[ 0 ].offsetHeight === 0 );

		tds[ 0 ].style.display = "";
		tds[ 1 ].style.display = "none";

		// Check if empty table cells still have offsetWidth/Height
		// (IE <= 8 fail this test)
		support.reliableHiddenOffsets = isSupported && ( tds[ 0 ].offsetHeight === 0 );

		// Check box-sizing and margin behavior
		div.innerHTML = "";
		div.style.cssText = "box-sizing:border-box;-moz-box-sizing:border-box;-webkit-box-sizing:border-box;padding:1px;border:1px;display:block;width:4px;margin-top:1%;position:absolute;top:1%;";
		support.boxSizing = ( div.offsetWidth === 4 );
		support.doesNotIncludeMarginInBodyOffset = ( body.offsetTop !== 1 );

		// NOTE: To any future maintainer, we've window.getComputedStyle
		// because jsdom on node.js will break without it.
		if ( window.getComputedStyle ) {
			support.pixelPosition = ( window.getComputedStyle( div, null ) || {} ).top !== "1%";
			support.boxSizingReliable = ( window.getComputedStyle( div, null ) || { width: "4px" } ).width === "4px";

			// Check if div with explicit width and no margin-right incorrectly
			// gets computed margin-right based on width of container. For more
			// info see bug #3333
			// Fails in WebKit before Feb 2011 nightlies
			// WebKit Bug 13343 - getComputedStyle returns wrong value for margin-right
			marginDiv = document.createElement("div");
			marginDiv.style.cssText = div.style.cssText = divReset;
			marginDiv.style.marginRight = marginDiv.style.width = "0";
			div.style.width = "1px";
			div.appendChild( marginDiv );
			support.reliableMarginRight =
				!parseFloat( ( window.getComputedStyle( marginDiv, null ) || {} ).marginRight );
		}

		if ( typeof div.style.zoom !== "undefined" ) {
			// Check if natively block-level elements act like inline-block
			// elements when setting their display to 'inline' and giving
			// them layout
			// (IE < 8 does this)
			div.innerHTML = "";
			div.style.cssText = divReset + "width:1px;padding:1px;display:inline;zoom:1";
			support.inlineBlockNeedsLayout = ( div.offsetWidth === 3 );

			// Check if elements with layout shrink-wrap their children
			// (IE 6 does this)
			div.style.display = "block";
			div.style.overflow = "visible";
			div.innerHTML = "<div></div>";
			div.firstChild.style.width = "5px";
			support.shrinkWrapBlocks = ( div.offsetWidth !== 3 );

			container.style.zoom = 1;
		}

		// Null elements to avoid leaks in IE
		body.removeChild( container );
		container = div = tds = marginDiv = null;
	});

	// Null elements to avoid leaks in IE
	fragment.removeChild( div );
	all = a = select = opt = input = fragment = div = null;

	return support;
})();
var rbrace = /(?:\{[\s\S]*\}|\[[\s\S]*\])$/,
	rmultiDash = /([A-Z])/g;

jQuery.extend({
	cache: {},

	deletedIds: [],

	// Remove at next major release (1.9/2.0)
	uuid: 0,

	// Unique for each copy of jQuery on the page
	// Non-digits removed to match rinlinejQuery
	expando: "jQuery" + ( jQuery.fn.jquery + Math.random() ).replace( /\D/g, "" ),

	// The following elements throw uncatchable exceptions if you
	// attempt to add expando properties to them.
	noData: {
		"embed": true,
		// Ban all objects except for Flash (which handle expandos)
		"object": "clsid:D27CDB6E-AE6D-11cf-96B8-444553540000",
		"applet": true
	},

	hasData: function( elem ) {
		elem = elem.nodeType ? jQuery.cache[ elem[jQuery.expando] ] : elem[ jQuery.expando ];
		return !!elem && !isEmptyDataObject( elem );
	},

	data: function( elem, name, data, pvt /* Internal Use Only */ ) {
		if ( !jQuery.acceptData( elem ) ) {
			return;
		}

		var thisCache, ret,
			internalKey = jQuery.expando,
			getByName = typeof name === "string",

			// We have to handle DOM nodes and JS objects differently because IE6-7
			// can't GC object references properly across the DOM-JS boundary
			isNode = elem.nodeType,

			// Only DOM nodes need the global jQuery cache; JS object data is
			// attached directly to the object so GC can occur automatically
			cache = isNode ? jQuery.cache : elem,

			// Only defining an ID for JS objects if its cache already exists allows
			// the code to shortcut on the same path as a DOM node with no cache
			id = isNode ? elem[ internalKey ] : elem[ internalKey ] && internalKey;

		// Avoid doing any more work than we need to when trying to get data on an
		// object that has no data at all
		if ( (!id || !cache[id] || (!pvt && !cache[id].data)) && getByName && data === undefined ) {
			return;
		}

		if ( !id ) {
			// Only DOM nodes need a new unique ID for each element since their data
			// ends up in the global cache
			if ( isNode ) {
				elem[ internalKey ] = id = jQuery.deletedIds.pop() || jQuery.guid++;
			} else {
				id = internalKey;
			}
		}

		if ( !cache[ id ] ) {
			cache[ id ] = {};

			// Avoids exposing jQuery metadata on plain JS objects when the object
			// is serialized using JSON.stringify
			if ( !isNode ) {
				cache[ id ].toJSON = jQuery.noop;
			}
		}

		// An object can be passed to jQuery.data instead of a key/value pair; this gets
		// shallow copied over onto the existing cache
		if ( typeof name === "object" || typeof name === "function" ) {
			if ( pvt ) {
				cache[ id ] = jQuery.extend( cache[ id ], name );
			} else {
				cache[ id ].data = jQuery.extend( cache[ id ].data, name );
			}
		}

		thisCache = cache[ id ];

		// jQuery data() is stored in a separate object inside the object's internal data
		// cache in order to avoid key collisions between internal data and user-defined
		// data.
		if ( !pvt ) {
			if ( !thisCache.data ) {
				thisCache.data = {};
			}

			thisCache = thisCache.data;
		}

		if ( data !== undefined ) {
			thisCache[ jQuery.camelCase( name ) ] = data;
		}

		// Check for both converted-to-camel and non-converted data property names
		// If a data property was specified
		if ( getByName ) {

			// First Try to find as-is property data
			ret = thisCache[ name ];

			// Test for null|undefined property data
			if ( ret == null ) {

				// Try to find the camelCased property
				ret = thisCache[ jQuery.camelCase( name ) ];
			}
		} else {
			ret = thisCache;
		}

		return ret;
	},

	removeData: function( elem, name, pvt /* Internal Use Only */ ) {
		if ( !jQuery.acceptData( elem ) ) {
			return;
		}

		var thisCache, i, l,

			isNode = elem.nodeType,

			// See jQuery.data for more information
			cache = isNode ? jQuery.cache : elem,
			id = isNode ? elem[ jQuery.expando ] : jQuery.expando;

		// If there is already no cache entry for this object, there is no
		// purpose in continuing
		if ( !cache[ id ] ) {
			return;
		}

		if ( name ) {

			thisCache = pvt ? cache[ id ] : cache[ id ].data;

			if ( thisCache ) {

				// Support array or space separated string names for data keys
				if ( !jQuery.isArray( name ) ) {

					// try the string as a key before any manipulation
					if ( name in thisCache ) {
						name = [ name ];
					} else {

						// split the camel cased version by spaces unless a key with the spaces exists
						name = jQuery.camelCase( name );
						if ( name in thisCache ) {
							name = [ name ];
						} else {
							name = name.split(" ");
						}
					}
				}

				for ( i = 0, l = name.length; i < l; i++ ) {
					delete thisCache[ name[i] ];
				}

				// If there is no data left in the cache, we want to continue
				// and let the cache object itself get destroyed
				if ( !( pvt ? isEmptyDataObject : jQuery.isEmptyObject )( thisCache ) ) {
					return;
				}
			}
		}

		// See jQuery.data for more information
		if ( !pvt ) {
			delete cache[ id ].data;

			// Don't destroy the parent cache unless the internal data object
			// had been the only thing left in it
			if ( !isEmptyDataObject( cache[ id ] ) ) {
				return;
			}
		}

		// Destroy the cache
		if ( isNode ) {
			jQuery.cleanData( [ elem ], true );

		// Use delete when supported for expandos or `cache` is not a window per isWindow (#10080)
		} else if ( jQuery.support.deleteExpando || cache != cache.window ) {
			delete cache[ id ];

		// When all else fails, null
		} else {
			cache[ id ] = null;
		}
	},

	// For internal use only.
	_data: function( elem, name, data ) {
		return jQuery.data( elem, name, data, true );
	},

	// A method for determining if a DOM node can handle the data expando
	acceptData: function( elem ) {
		var noData = elem.nodeName && jQuery.noData[ elem.nodeName.toLowerCase() ];

		// nodes accept data unless otherwise specified; rejection can be conditional
		return !noData || noData !== true && elem.getAttribute("classid") === noData;
	}
});

jQuery.fn.extend({
	data: function( key, value ) {
		var parts, part, attr, name, l,
			elem = this[0],
			i = 0,
			data = null;

		// Gets all values
		if ( key === undefined ) {
			if ( this.length ) {
				data = jQuery.data( elem );

				if ( elem.nodeType === 1 && !jQuery._data( elem, "parsedAttrs" ) ) {
					attr = elem.attributes;
					for ( l = attr.length; i < l; i++ ) {
						name = attr[i].name;

						if ( !name.indexOf( "data-" ) ) {
							name = jQuery.camelCase( name.substring(5) );

							dataAttr( elem, name, data[ name ] );
						}
					}
					jQuery._data( elem, "parsedAttrs", true );
				}
			}

			return data;
		}

		// Sets multiple values
		if ( typeof key === "object" ) {
			return this.each(function() {
				jQuery.data( this, key );
			});
		}

		parts = key.split( ".", 2 );
		parts[1] = parts[1] ? "." + parts[1] : "";
		part = parts[1] + "!";

		return jQuery.access( this, function( value ) {

			if ( value === undefined ) {
				data = this.triggerHandler( "getData" + part, [ parts[0] ] );

				// Try to fetch any internally stored data first
				if ( data === undefined && elem ) {
					data = jQuery.data( elem, key );
					data = dataAttr( elem, key, data );
				}

				return data === undefined && parts[1] ?
					this.data( parts[0] ) :
					data;
			}

			parts[1] = value;
			this.each(function() {
				var self = jQuery( this );

				self.triggerHandler( "setData" + part, parts );
				jQuery.data( this, key, value );
				self.triggerHandler( "changeData" + part, parts );
			});
		}, null, value, arguments.length > 1, null, false );
	},

	removeData: function( key ) {
		return this.each(function() {
			jQuery.removeData( this, key );
		});
	}
});

function dataAttr( elem, key, data ) {
	// If nothing was found internally, try to fetch any
	// data from the HTML5 data-* attribute
	if ( data === undefined && elem.nodeType === 1 ) {

		var name = "data-" + key.replace( rmultiDash, "-$1" ).toLowerCase();

		data = elem.getAttribute( name );

		if ( typeof data === "string" ) {
			try {
				data = data === "true" ? true :
				data === "false" ? false :
				data === "null" ? null :
				// Only convert to a number if it doesn't change the string
				+data + "" === data ? +data :
				rbrace.test( data ) ? jQuery.parseJSON( data ) :
					data;
			} catch( e ) {}

			// Make sure we set the data so it isn't changed later
			jQuery.data( elem, key, data );

		} else {
			data = undefined;
		}
	}

	return data;
}

// checks a cache object for emptiness
function isEmptyDataObject( obj ) {
	var name;
	for ( name in obj ) {

		// if the public data object is empty, the private is still empty
		if ( name === "data" && jQuery.isEmptyObject( obj[name] ) ) {
			continue;
		}
		if ( name !== "toJSON" ) {
			return false;
		}
	}

	return true;
}
jQuery.extend({
	queue: function( elem, type, data ) {
		var queue;

		if ( elem ) {
			type = ( type || "fx" ) + "queue";
			queue = jQuery._data( elem, type );

			// Speed up dequeue by getting out quickly if this is just a lookup
			if ( data ) {
				if ( !queue || jQuery.isArray(data) ) {
					queue = jQuery._data( elem, type, jQuery.makeArray(data) );
				} else {
					queue.push( data );
				}
			}
			return queue || [];
		}
	},

	dequeue: function( elem, type ) {
		type = type || "fx";

		var queue = jQuery.queue( elem, type ),
			startLength = queue.length,
			fn = queue.shift(),
			hooks = jQuery._queueHooks( elem, type ),
			next = function() {
				jQuery.dequeue( elem, type );
			};

		// If the fx queue is dequeued, always remove the progress sentinel
		if ( fn === "inprogress" ) {
			fn = queue.shift();
			startLength--;
		}

		if ( fn ) {

			// Add a progress sentinel to prevent the fx queue from being
			// automatically dequeued
			if ( type === "fx" ) {
				queue.unshift( "inprogress" );
			}

			// clear up the last queue stop function
			delete hooks.stop;
			fn.call( elem, next, hooks );
		}

		if ( !startLength && hooks ) {
			hooks.empty.fire();
		}
	},

	// not intended for public consumption - generates a queueHooks object, or returns the current one
	_queueHooks: function( elem, type ) {
		var key = type + "queueHooks";
		return jQuery._data( elem, key ) || jQuery._data( elem, key, {
			empty: jQuery.Callbacks("once memory").add(function() {
				jQuery.removeData( elem, type + "queue", true );
				jQuery.removeData( elem, key, true );
			})
		});
	}
});

jQuery.fn.extend({
	queue: function( type, data ) {
		var setter = 2;

		if ( typeof type !== "string" ) {
			data = type;
			type = "fx";
			setter--;
		}

		if ( arguments.length < setter ) {
			return jQuery.queue( this[0], type );
		}

		return data === undefined ?
			this :
			this.each(function() {
				var queue = jQuery.queue( this, type, data );

				// ensure a hooks for this queue
				jQuery._queueHooks( this, type );

				if ( type === "fx" && queue[0] !== "inprogress" ) {
					jQuery.dequeue( this, type );
				}
			});
	},
	dequeue: function( type ) {
		return this.each(function() {
			jQuery.dequeue( this, type );
		});
	},
	// Based off of the plugin by Clint Helfers, with permission.
	// http://blindsignals.com/index.php/2009/07/jquery-delay/
	delay: function( time, type ) {
		time = jQuery.fx ? jQuery.fx.speeds[ time ] || time : time;
		type = type || "fx";

		return this.queue( type, function( next, hooks ) {
			var timeout = setTimeout( next, time );
			hooks.stop = function() {
				clearTimeout( timeout );
			};
		});
	},
	clearQueue: function( type ) {
		return this.queue( type || "fx", [] );
	},
	// Get a promise resolved when queues of a certain type
	// are emptied (fx is the type by default)
	promise: function( type, obj ) {
		var tmp,
			count = 1,
			defer = jQuery.Deferred(),
			elements = this,
			i = this.length,
			resolve = function() {
				if ( !( --count ) ) {
					defer.resolveWith( elements, [ elements ] );
				}
			};

		if ( typeof type !== "string" ) {
			obj = type;
			type = undefined;
		}
		type = type || "fx";

		while( i-- ) {
			tmp = jQuery._data( elements[ i ], type + "queueHooks" );
			if ( tmp && tmp.empty ) {
				count++;
				tmp.empty.add( resolve );
			}
		}
		resolve();
		return defer.promise( obj );
	}
});
var nodeHook, boolHook, fixSpecified,
	rclass = /[\t\r\n]/g,
	rreturn = /\r/g,
	rtype = /^(?:button|input)$/i,
	rfocusable = /^(?:button|input|object|select|textarea)$/i,
	rclickable = /^a(?:rea|)$/i,
	rboolean = /^(?:autofocus|autoplay|async|checked|controls|defer|disabled|hidden|loop|multiple|open|readonly|required|scoped|selected)$/i,
	getSetAttribute = jQuery.support.getSetAttribute;

jQuery.fn.extend({
	attr: function( name, value ) {
		return jQuery.access( this, jQuery.attr, name, value, arguments.length > 1 );
	},

	removeAttr: function( name ) {
		return this.each(function() {
			jQuery.removeAttr( this, name );
		});
	},

	prop: function( name, value ) {
		return jQuery.access( this, jQuery.prop, name, value, arguments.length > 1 );
	},

	removeProp: function( name ) {
		name = jQuery.propFix[ name ] || name;
		return this.each(function() {
			// try/catch handles cases where IE balks (such as removing a property on window)
			try {
				this[ name ] = undefined;
				delete this[ name ];
			} catch( e ) {}
		});
	},

	addClass: function( value ) {
		var classNames, i, l, elem,
			setClass, c, cl;

		if ( jQuery.isFunction( value ) ) {
			return this.each(function( j ) {
				jQuery( this ).addClass( value.call(this, j, this.className) );
			});
		}

		if ( value && typeof value === "string" ) {
			classNames = value.split( core_rspace );

			for ( i = 0, l = this.length; i < l; i++ ) {
				elem = this[ i ];

				if ( elem.nodeType === 1 ) {
					if ( !elem.className && classNames.length === 1 ) {
						elem.className = value;

					} else {
						setClass = " " + elem.className + " ";

						for ( c = 0, cl = classNames.length; c < cl; c++ ) {
							if ( setClass.indexOf( " " + classNames[ c ] + " " ) < 0 ) {
								setClass += classNames[ c ] + " ";
							}
						}
						elem.className = jQuery.trim( setClass );
					}
				}
			}
		}

		return this;
	},

	removeClass: function( value ) {
		var removes, className, elem, c, cl, i, l;

		if ( jQuery.isFunction( value ) ) {
			return this.each(function( j ) {
				jQuery( this ).removeClass( value.call(this, j, this.className) );
			});
		}
		if ( (value && typeof value === "string") || value === undefined ) {
			removes = ( value || "" ).split( core_rspace );

			for ( i = 0, l = this.length; i < l; i++ ) {
				elem = this[ i ];
				if ( elem.nodeType === 1 && elem.className ) {

					className = (" " + elem.className + " ").replace( rclass, " " );

					// loop over each item in the removal list
					for ( c = 0, cl = removes.length; c < cl; c++ ) {
						// Remove until there is nothing to remove,
						while ( className.indexOf(" " + removes[ c ] + " ") >= 0 ) {
							className = className.replace( " " + removes[ c ] + " " , " " );
						}
					}
					elem.className = value ? jQuery.trim( className ) : "";
				}
			}
		}

		return this;
	},

	toggleClass: function( value, stateVal ) {
		var type = typeof value,
			isBool = typeof stateVal === "boolean";

		if ( jQuery.isFunction( value ) ) {
			return this.each(function( i ) {
				jQuery( this ).toggleClass( value.call(this, i, this.className, stateVal), stateVal );
			});
		}

		return this.each(function() {
			if ( type === "string" ) {
				// toggle individual class names
				var className,
					i = 0,
					self = jQuery( this ),
					state = stateVal,
					classNames = value.split( core_rspace );

				while ( (className = classNames[ i++ ]) ) {
					// check each className given, space separated list
					state = isBool ? state : !self.hasClass( className );
					self[ state ? "addClass" : "removeClass" ]( className );
				}

			} else if ( type === "undefined" || type === "boolean" ) {
				if ( this.className ) {
					// store className if set
					jQuery._data( this, "__className__", this.className );
				}

				// toggle whole className
				this.className = this.className || value === false ? "" : jQuery._data( this, "__className__" ) || "";
			}
		});
	},

	hasClass: function( selector ) {
		var className = " " + selector + " ",
			i = 0,
			l = this.length;
		for ( ; i < l; i++ ) {
			if ( this[i].nodeType === 1 && (" " + this[i].className + " ").replace(rclass, " ").indexOf( className ) >= 0 ) {
				return true;
			}
		}

		return false;
	},

	val: function( value ) {
		var hooks, ret, isFunction,
			elem = this[0];

		if ( !arguments.length ) {
			if ( elem ) {
				hooks = jQuery.valHooks[ elem.type ] || jQuery.valHooks[ elem.nodeName.toLowerCase() ];

				if ( hooks && "get" in hooks && (ret = hooks.get( elem, "value" )) !== undefined ) {
					return ret;
				}

				ret = elem.value;

				return typeof ret === "string" ?
					// handle most common string cases
					ret.replace(rreturn, "") :
					// handle cases where value is null/undef or number
					ret == null ? "" : ret;
			}

			return;
		}

		isFunction = jQuery.isFunction( value );

		return this.each(function( i ) {
			var val,
				self = jQuery(this);

			if ( this.nodeType !== 1 ) {
				return;
			}

			if ( isFunction ) {
				val = value.call( this, i, self.val() );
			} else {
				val = value;
			}

			// Treat null/undefined as ""; convert numbers to string
			if ( val == null ) {
				val = "";
			} else if ( typeof val === "number" ) {
				val += "";
			} else if ( jQuery.isArray( val ) ) {
				val = jQuery.map(val, function ( value ) {
					return value == null ? "" : value + "";
				});
			}

			hooks = jQuery.valHooks[ this.type ] || jQuery.valHooks[ this.nodeName.toLowerCase() ];

			// If set returns undefined, fall back to normal setting
			if ( !hooks || !("set" in hooks) || hooks.set( this, val, "value" ) === undefined ) {
				this.value = val;
			}
		});
	}
});

jQuery.extend({
	valHooks: {
		option: {
			get: function( elem ) {
				// attributes.value is undefined in Blackberry 4.7 but
				// uses .value. See #6932
				var val = elem.attributes.value;
				return !val || val.specified ? elem.value : elem.text;
			}
		},
		select: {
			get: function( elem ) {
				var value, i, max, option,
					index = elem.selectedIndex,
					values = [],
					options = elem.options,
					one = elem.type === "select-one";

				// Nothing was selected
				if ( index < 0 ) {
					return null;
				}

				// Loop through all the selected options
				i = one ? index : 0;
				max = one ? index + 1 : options.length;
				for ( ; i < max; i++ ) {
					option = options[ i ];

					// Don't return options that are disabled or in a disabled optgroup
					if ( option.selected && (jQuery.support.optDisabled ? !option.disabled : option.getAttribute("disabled") === null) &&
							(!option.parentNode.disabled || !jQuery.nodeName( option.parentNode, "optgroup" )) ) {

						// Get the specific value for the option
						value = jQuery( option ).val();

						// We don't need an array for one selects
						if ( one ) {
							return value;
						}

						// Multi-Selects return an array
						values.push( value );
					}
				}

				// Fixes Bug #2551 -- select.val() broken in IE after form.reset()
				if ( one && !values.length && options.length ) {
					return jQuery( options[ index ] ).val();
				}

				return values;
			},

			set: function( elem, value ) {
				var values = jQuery.makeArray( value );

				jQuery(elem).find("option").each(function() {
					this.selected = jQuery.inArray( jQuery(this).val(), values ) >= 0;
				});

				if ( !values.length ) {
					elem.selectedIndex = -1;
				}
				return values;
			}
		}
	},

	// Unused in 1.8, left in so attrFn-stabbers won't die; remove in 1.9
	attrFn: {},

	attr: function( elem, name, value, pass ) {
		var ret, hooks, notxml,
			nType = elem.nodeType;

		// don't get/set attributes on text, comment and attribute nodes
		if ( !elem || nType === 3 || nType === 8 || nType === 2 ) {
			return;
		}

		if ( pass && jQuery.isFunction( jQuery.fn[ name ] ) ) {
			return jQuery( elem )[ name ]( value );
		}

		// Fallback to prop when attributes are not supported
		if ( typeof elem.getAttribute === "undefined" ) {
			return jQuery.prop( elem, name, value );
		}

		notxml = nType !== 1 || !jQuery.isXMLDoc( elem );

		// All attributes are lowercase
		// Grab necessary hook if one is defined
		if ( notxml ) {
			name = name.toLowerCase();
			hooks = jQuery.attrHooks[ name ] || ( rboolean.test( name ) ? boolHook : nodeHook );
		}

		if ( value !== undefined ) {

			if ( value === null ) {
				jQuery.removeAttr( elem, name );
				return;

			} else if ( hooks && "set" in hooks && notxml && (ret = hooks.set( elem, value, name )) !== undefined ) {
				return ret;

			} else {
				elem.setAttribute( name, value + "" );
				return value;
			}

		} else if ( hooks && "get" in hooks && notxml && (ret = hooks.get( elem, name )) !== null ) {
			return ret;

		} else {

			ret = elem.getAttribute( name );

			// Non-existent attributes return null, we normalize to undefined
			return ret === null ?
				undefined :
				ret;
		}
	},

	removeAttr: function( elem, value ) {
		var propName, attrNames, name, isBool,
			i = 0;

		if ( value && elem.nodeType === 1 ) {

			attrNames = value.split( core_rspace );

			for ( ; i < attrNames.length; i++ ) {
				name = attrNames[ i ];

				if ( name ) {
					propName = jQuery.propFix[ name ] || name;
					isBool = rboolean.test( name );

					// See #9699 for explanation of this approach (setting first, then removal)
					// Do not do this for boolean attributes (see #10870)
					if ( !isBool ) {
						jQuery.attr( elem, name, "" );
					}
					elem.removeAttribute( getSetAttribute ? name : propName );

					// Set corresponding property to false for boolean attributes
					if ( isBool && propName in elem ) {
						elem[ propName ] = false;
					}
				}
			}
		}
	},

	attrHooks: {
		type: {
			set: function( elem, value ) {
				// We can't allow the type property to be changed (since it causes problems in IE)
				if ( rtype.test( elem.nodeName ) && elem.parentNode ) {
					jQuery.error( "type property can't be changed" );
				} else if ( !jQuery.support.radioValue && value === "radio" && jQuery.nodeName(elem, "input") ) {
					// Setting the type on a radio button after the value resets the value in IE6-9
					// Reset value to it's default in case type is set after value
					// This is for element creation
					var val = elem.value;
					elem.setAttribute( "type", value );
					if ( val ) {
						elem.value = val;
					}
					return value;
				}
			}
		},
		// Use the value property for back compat
		// Use the nodeHook for button elements in IE6/7 (#1954)
		value: {
			get: function( elem, name ) {
				if ( nodeHook && jQuery.nodeName( elem, "button" ) ) {
					return nodeHook.get( elem, name );
				}
				return name in elem ?
					elem.value :
					null;
			},
			set: function( elem, value, name ) {
				if ( nodeHook && jQuery.nodeName( elem, "button" ) ) {
					return nodeHook.set( elem, value, name );
				}
				// Does not return so that setAttribute is also used
				elem.value = value;
			}
		}
	},

	propFix: {
		tabindex: "tabIndex",
		readonly: "readOnly",
		"for": "htmlFor",
		"class": "className",
		maxlength: "maxLength",
		cellspacing: "cellSpacing",
		cellpadding: "cellPadding",
		rowspan: "rowSpan",
		colspan: "colSpan",
		usemap: "useMap",
		frameborder: "frameBorder",
		contenteditable: "contentEditable"
	},

	prop: function( elem, name, value ) {
		var ret, hooks, notxml,
			nType = elem.nodeType;

		// don't get/set properties on text, comment and attribute nodes
		if ( !elem || nType === 3 || nType === 8 || nType === 2 ) {
			return;
		}

		notxml = nType !== 1 || !jQuery.isXMLDoc( elem );

		if ( notxml ) {
			// Fix name and attach hooks
			name = jQuery.propFix[ name ] || name;
			hooks = jQuery.propHooks[ name ];
		}

		if ( value !== undefined ) {
			if ( hooks && "set" in hooks && (ret = hooks.set( elem, value, name )) !== undefined ) {
				return ret;

			} else {
				return ( elem[ name ] = value );
			}

		} else {
			if ( hooks && "get" in hooks && (ret = hooks.get( elem, name )) !== null ) {
				return ret;

			} else {
				return elem[ name ];
			}
		}
	},

	propHooks: {
		tabIndex: {
			get: function( elem ) {
				// elem.tabIndex doesn't always return the correct value when it hasn't been explicitly set
				// http://fluidproject.org/blog/2008/01/09/getting-setting-and-removing-tabindex-values-with-javascript/
				var attributeNode = elem.getAttributeNode("tabindex");

				return attributeNode && attributeNode.specified ?
					parseInt( attributeNode.value, 10 ) :
					rfocusable.test( elem.nodeName ) || rclickable.test( elem.nodeName ) && elem.href ?
						0 :
						undefined;
			}
		}
	}
});

// Hook for boolean attributes
boolHook = {
	get: function( elem, name ) {
		// Align boolean attributes with corresponding properties
		// Fall back to attribute presence where some booleans are not supported
		var attrNode,
			property = jQuery.prop( elem, name );
		return property === true || typeof property !== "boolean" && ( attrNode = elem.getAttributeNode(name) ) && attrNode.nodeValue !== false ?
			name.toLowerCase() :
			undefined;
	},
	set: function( elem, value, name ) {
		var propName;
		if ( value === false ) {
			// Remove boolean attributes when set to false
			jQuery.removeAttr( elem, name );
		} else {
			// value is true since we know at this point it's type boolean and not false
			// Set boolean attributes to the same name and set the DOM property
			propName = jQuery.propFix[ name ] || name;
			if ( propName in elem ) {
				// Only set the IDL specifically if it already exists on the element
				elem[ propName ] = true;
			}

			elem.setAttribute( name, name.toLowerCase() );
		}
		return name;
	}
};

// IE6/7 do not support getting/setting some attributes with get/setAttribute
if ( !getSetAttribute ) {

	fixSpecified = {
		name: true,
		id: true,
		coords: true
	};

	// Use this for any attribute in IE6/7
	// This fixes almost every IE6/7 issue
	nodeHook = jQuery.valHooks.button = {
		get: function( elem, name ) {
			var ret;
			ret = elem.getAttributeNode( name );
			return ret && ( fixSpecified[ name ] ? ret.value !== "" : ret.specified ) ?
				ret.value :
				undefined;
		},
		set: function( elem, value, name ) {
			// Set the existing or create a new attribute node
			var ret = elem.getAttributeNode( name );
			if ( !ret ) {
				ret = document.createAttribute( name );
				elem.setAttributeNode( ret );
			}
			return ( ret.value = value + "" );
		}
	};

	// Set width and height to auto instead of 0 on empty string( Bug #8150 )
	// This is for removals
	jQuery.each([ "width", "height" ], function( i, name ) {
		jQuery.attrHooks[ name ] = jQuery.extend( jQuery.attrHooks[ name ], {
			set: function( elem, value ) {
				if ( value === "" ) {
					elem.setAttribute( name, "auto" );
					return value;
				}
			}
		});
	});

	// Set contenteditable to false on removals(#10429)
	// Setting to empty string throws an error as an invalid value
	jQuery.attrHooks.contenteditable = {
		get: nodeHook.get,
		set: function( elem, value, name ) {
			if ( value === "" ) {
				value = "false";
			}
			nodeHook.set( elem, value, name );
		}
	};
}


// Some attributes require a special call on IE
if ( !jQuery.support.hrefNormalized ) {
	jQuery.each([ "href", "src", "width", "height" ], function( i, name ) {
		jQuery.attrHooks[ name ] = jQuery.extend( jQuery.attrHooks[ name ], {
			get: function( elem ) {
				var ret = elem.getAttribute( name, 2 );
				return ret === null ? undefined : ret;
			}
		});
	});
}

if ( !jQuery.support.style ) {
	jQuery.attrHooks.style = {
		get: function( elem ) {
			// Return undefined in the case of empty string
			// Normalize to lowercase since IE uppercases css property names
			return elem.style.cssText.toLowerCase() || undefined;
		},
		set: function( elem, value ) {
			return ( elem.style.cssText = value + "" );
		}
	};
}

// Safari mis-reports the default selected property of an option
// Accessing the parent's selectedIndex property fixes it
if ( !jQuery.support.optSelected ) {
	jQuery.propHooks.selected = jQuery.extend( jQuery.propHooks.selected, {
		get: function( elem ) {
			var parent = elem.parentNode;

			if ( parent ) {
				parent.selectedIndex;

				// Make sure that it also works with optgroups, see #5701
				if ( parent.parentNode ) {
					parent.parentNode.selectedIndex;
				}
			}
			return null;
		}
	});
}

// IE6/7 call enctype encoding
if ( !jQuery.support.enctype ) {
	jQuery.propFix.enctype = "encoding";
}

// Radios and checkboxes getter/setter
if ( !jQuery.support.checkOn ) {
	jQuery.each([ "radio", "checkbox" ], function() {
		jQuery.valHooks[ this ] = {
			get: function( elem ) {
				// Handle the case where in Webkit "" is returned instead of "on" if a value isn't specified
				return elem.getAttribute("value") === null ? "on" : elem.value;
			}
		};
	});
}
jQuery.each([ "radio", "checkbox" ], function() {
	jQuery.valHooks[ this ] = jQuery.extend( jQuery.valHooks[ this ], {
		set: function( elem, value ) {
			if ( jQuery.isArray( value ) ) {
				return ( elem.checked = jQuery.inArray( jQuery(elem).val(), value ) >= 0 );
			}
		}
	});
});
var rformElems = /^(?:textarea|input|select)$/i,
	rtypenamespace = /^([^\.]*|)(?:\.(.+)|)$/,
	rhoverHack = /(?:^|\s)hover(\.\S+|)\b/,
	rkeyEvent = /^key/,
	rmouseEvent = /^(?:mouse|contextmenu)|click/,
	rfocusMorph = /^(?:focusinfocus|focusoutblur)$/,
	hoverHack = function( events ) {
		return jQuery.event.special.hover ? events : events.replace( rhoverHack, "mouseenter$1 mouseleave$1" );
	};

/*
 * Helper functions for managing events -- not part of the public interface.
 * Props to Dean Edwards' addEvent library for many of the ideas.
 */
jQuery.event = {

	add: function( elem, types, handler, data, selector ) {

		var elemData, eventHandle, events,
			t, tns, type, namespaces, handleObj,
			handleObjIn, handlers, special;

		// Don't attach events to noData or text/comment nodes (allow plain objects tho)
		if ( elem.nodeType === 3 || elem.nodeType === 8 || !types || !handler || !(elemData = jQuery._data( elem )) ) {
			return;
		}

		// Caller can pass in an object of custom data in lieu of the handler
		if ( handler.handler ) {
			handleObjIn = handler;
			handler = handleObjIn.handler;
			selector = handleObjIn.selector;
		}

		// Make sure that the handler has a unique ID, used to find/remove it later
		if ( !handler.guid ) {
			handler.guid = jQuery.guid++;
		}

		// Init the element's event structure and main handler, if this is the first
		events = elemData.events;
		if ( !events ) {
			elemData.events = events = {};
		}
		eventHandle = elemData.handle;
		if ( !eventHandle ) {
			elemData.handle = eventHandle = function( e ) {
				// Discard the second event of a jQuery.event.trigger() and
				// when an event is called after a page has unloaded
				return typeof jQuery !== "undefined" && (!e || jQuery.event.triggered !== e.type) ?
					jQuery.event.dispatch.apply( eventHandle.elem, arguments ) :
					undefined;
			};
			// Add elem as a property of the handle fn to prevent a memory leak with IE non-native events
			eventHandle.elem = elem;
		}

		// Handle multiple events separated by a space
		// jQuery(...).bind("mouseover mouseout", fn);
		types = jQuery.trim( hoverHack(types) ).split( " " );
		for ( t = 0; t < types.length; t++ ) {

			tns = rtypenamespace.exec( types[t] ) || [];
			type = tns[1];
			namespaces = ( tns[2] || "" ).split( "." ).sort();

			// If event changes its type, use the special event handlers for the changed type
			special = jQuery.event.special[ type ] || {};

			// If selector defined, determine special event api type, otherwise given type
			type = ( selector ? special.delegateType : special.bindType ) || type;

			// Update special based on newly reset type
			special = jQuery.event.special[ type ] || {};

			// handleObj is passed to all event handlers
			handleObj = jQuery.extend({
				type: type,
				origType: tns[1],
				data: data,
				handler: handler,
				guid: handler.guid,
				selector: selector,
				needsContext: selector && jQuery.expr.match.needsContext.test( selector ),
				namespace: namespaces.join(".")
			}, handleObjIn );

			// Init the event handler queue if we're the first
			handlers = events[ type ];
			if ( !handlers ) {
				handlers = events[ type ] = [];
				handlers.delegateCount = 0;

				// Only use addEventListener/attachEvent if the special events handler returns false
				if ( !special.setup || special.setup.call( elem, data, namespaces, eventHandle ) === false ) {
					// Bind the global event handler to the element
					if ( elem.addEventListener ) {
						elem.addEventListener( type, eventHandle, false );

					} else if ( elem.attachEvent ) {
						elem.attachEvent( "on" + type, eventHandle );
					}
				}
			}

			if ( special.add ) {
				special.add.call( elem, handleObj );

				if ( !handleObj.handler.guid ) {
					handleObj.handler.guid = handler.guid;
				}
			}

			// Add to the element's handler list, delegates in front
			if ( selector ) {
				handlers.splice( handlers.delegateCount++, 0, handleObj );
			} else {
				handlers.push( handleObj );
			}

			// Keep track of which events have ever been used, for event optimization
			jQuery.event.global[ type ] = true;
		}

		// Nullify elem to prevent memory leaks in IE
		elem = null;
	},

	global: {},

	// Detach an event or set of events from an element
	remove: function( elem, types, handler, selector, mappedTypes ) {

		var t, tns, type, origType, namespaces, origCount,
			j, events, special, eventType, handleObj,
			elemData = jQuery.hasData( elem ) && jQuery._data( elem );

		if ( !elemData || !(events = elemData.events) ) {
			return;
		}

		// Once for each type.namespace in types; type may be omitted
		types = jQuery.trim( hoverHack( types || "" ) ).split(" ");
		for ( t = 0; t < types.length; t++ ) {
			tns = rtypenamespace.exec( types[t] ) || [];
			type = origType = tns[1];
			namespaces = tns[2];

			// Unbind all events (on this namespace, if provided) for the element
			if ( !type ) {
				for ( type in events ) {
					jQuery.event.remove( elem, type + types[ t ], handler, selector, true );
				}
				continue;
			}

			special = jQuery.event.special[ type ] || {};
			type = ( selector? special.delegateType : special.bindType ) || type;
			eventType = events[ type ] || [];
			origCount = eventType.length;
			namespaces = namespaces ? new RegExp("(^|\\.)" + namespaces.split(".").sort().join("\\.(?:.*\\.|)") + "(\\.|$)") : null;

			// Remove matching events
			for ( j = 0; j < eventType.length; j++ ) {
				handleObj = eventType[ j ];

				if ( ( mappedTypes || origType === handleObj.origType ) &&
					 ( !handler || handler.guid === handleObj.guid ) &&
					 ( !namespaces || namespaces.test( handleObj.namespace ) ) &&
					 ( !selector || selector === handleObj.selector || selector === "**" && handleObj.selector ) ) {
					eventType.splice( j--, 1 );

					if ( handleObj.selector ) {
						eventType.delegateCount--;
					}
					if ( special.remove ) {
						special.remove.call( elem, handleObj );
					}
				}
			}

			// Remove generic event handler if we removed something and no more handlers exist
			// (avoids potential for endless recursion during removal of special event handlers)
			if ( eventType.length === 0 && origCount !== eventType.length ) {
				if ( !special.teardown || special.teardown.call( elem, namespaces, elemData.handle ) === false ) {
					jQuery.removeEvent( elem, type, elemData.handle );
				}

				delete events[ type ];
			}
		}

		// Remove the expando if it's no longer used
		if ( jQuery.isEmptyObject( events ) ) {
			delete elemData.handle;

			// removeData also checks for emptiness and clears the expando if empty
			// so use it instead of delete
			jQuery.removeData( elem, "events", true );
		}
	},

	// Events that are safe to short-circuit if no handlers are attached.
	// Native DOM events should not be added, they may have inline handlers.
	customEvent: {
		"getData": true,
		"setData": true,
		"changeData": true
	},

	trigger: function( event, data, elem, onlyHandlers ) {
		// Don't do events on text and comment nodes
		if ( elem && (elem.nodeType === 3 || elem.nodeType === 8) ) {
			return;
		}

		// Event object or event type
		var cache, exclusive, i, cur, old, ontype, special, handle, eventPath, bubbleType,
			type = event.type || event,
			namespaces = [];

		// focus/blur morphs to focusin/out; ensure we're not firing them right now
		if ( rfocusMorph.test( type + jQuery.event.triggered ) ) {
			return;
		}

		if ( type.indexOf( "!" ) >= 0 ) {
			// Exclusive events trigger only for the exact event (no namespaces)
			type = type.slice(0, -1);
			exclusive = true;
		}

		if ( type.indexOf( "." ) >= 0 ) {
			// Namespaced trigger; create a regexp to match event type in handle()
			namespaces = type.split(".");
			type = namespaces.shift();
			namespaces.sort();
		}

		if ( (!elem || jQuery.event.customEvent[ type ]) && !jQuery.event.global[ type ] ) {
			// No jQuery handlers for this event type, and it can't have inline handlers
			return;
		}

		// Caller can pass in an Event, Object, or just an event type string
		event = typeof event === "object" ?
			// jQuery.Event object
			event[ jQuery.expando ] ? event :
			// Object literal
			new jQuery.Event( type, event ) :
			// Just the event type (string)
			new jQuery.Event( type );

		event.type = type;
		event.isTrigger = true;
		event.exclusive = exclusive;
		event.namespace = namespaces.join( "." );
		event.namespace_re = event.namespace? new RegExp("(^|\\.)" + namespaces.join("\\.(?:.*\\.|)") + "(\\.|$)") : null;
		ontype = type.indexOf( ":" ) < 0 ? "on" + type : "";

		// Handle a global trigger
		if ( !elem ) {

			// TODO: Stop taunting the data cache; remove global events and always attach to document
			cache = jQuery.cache;
			for ( i in cache ) {
				if ( cache[ i ].events && cache[ i ].events[ type ] ) {
					jQuery.event.trigger( event, data, cache[ i ].handle.elem, true );
				}
			}
			return;
		}

		// Clean up the event in case it is being reused
		event.result = undefined;
		if ( !event.target ) {
			event.target = elem;
		}

		// Clone any incoming data and prepend the event, creating the handler arg list
		data = data != null ? jQuery.makeArray( data ) : [];
		data.unshift( event );

		// Allow special events to draw outside the lines
		special = jQuery.event.special[ type ] || {};
		if ( special.trigger && special.trigger.apply( elem, data ) === false ) {
			return;
		}

		// Determine event propagation path in advance, per W3C events spec (#9951)
		// Bubble up to document, then to window; watch for a global ownerDocument var (#9724)
		eventPath = [[ elem, special.bindType || type ]];
		if ( !onlyHandlers && !special.noBubble && !jQuery.isWindow( elem ) ) {

			bubbleType = special.delegateType || type;
			cur = rfocusMorph.test( bubbleType + type ) ? elem : elem.parentNode;
			for ( old = elem; cur; cur = cur.parentNode ) {
				eventPath.push([ cur, bubbleType ]);
				old = cur;
			}

			// Only add window if we got to document (e.g., not plain obj or detached DOM)
			if ( old === (elem.ownerDocument || document) ) {
				eventPath.push([ old.defaultView || old.parentWindow || window, bubbleType ]);
			}
		}

		// Fire handlers on the event path
		for ( i = 0; i < eventPath.length && !event.isPropagationStopped(); i++ ) {

			cur = eventPath[i][0];
			event.type = eventPath[i][1];

			handle = ( jQuery._data( cur, "events" ) || {} )[ event.type ] && jQuery._data( cur, "handle" );
			if ( handle ) {
				handle.apply( cur, data );
			}
			// Note that this is a bare JS function and not a jQuery handler
			handle = ontype && cur[ ontype ];
			if ( handle && jQuery.acceptData( cur ) && handle.apply && handle.apply( cur, data ) === false ) {
				event.preventDefault();
			}
		}
		event.type = type;

		// If nobody prevented the default action, do it now
		if ( !onlyHandlers && !event.isDefaultPrevented() ) {

			if ( (!special._default || special._default.apply( elem.ownerDocument, data ) === false) &&
				!(type === "click" && jQuery.nodeName( elem, "a" )) && jQuery.acceptData( elem ) ) {

				// Call a native DOM method on the target with the same name name as the event.
				// Can't use an .isFunction() check here because IE6/7 fails that test.
				// Don't do default actions on window, that's where global variables be (#6170)
				// IE<9 dies on focus/blur to hidden element (#1486)
				if ( ontype && elem[ type ] && ((type !== "focus" && type !== "blur") || event.target.offsetWidth !== 0) && !jQuery.isWindow( elem ) ) {

					// Don't re-trigger an onFOO event when we call its FOO() method
					old = elem[ ontype ];

					if ( old ) {
						elem[ ontype ] = null;
					}

					// Prevent re-triggering of the same event, since we already bubbled it above
					jQuery.event.triggered = type;
					elem[ type ]();
					jQuery.event.triggered = undefined;

					if ( old ) {
						elem[ ontype ] = old;
					}
				}
			}
		}

		return event.result;
	},

	dispatch: function( event ) {

		// Make a writable jQuery.Event from the native event object
		event = jQuery.event.fix( event || window.event );

		var i, j, cur, ret, selMatch, matched, matches, handleObj, sel, related,
			handlers = ( (jQuery._data( this, "events" ) || {} )[ event.type ] || []),
			delegateCount = handlers.delegateCount,
			args = core_slice.call( arguments ),
			run_all = !event.exclusive && !event.namespace,
			special = jQuery.event.special[ event.type ] || {},
			handlerQueue = [];

		// Use the fix-ed jQuery.Event rather than the (read-only) native event
		args[0] = event;
		event.delegateTarget = this;

		// Call the preDispatch hook for the mapped type, and let it bail if desired
		if ( special.preDispatch && special.preDispatch.call( this, event ) === false ) {
			return;
		}

		// Determine handlers that should run if there are delegated events
		// Avoid non-left-click bubbling in Firefox (#3861)
		if ( delegateCount && !(event.button && event.type === "click") ) {

			for ( cur = event.target; cur != this; cur = cur.parentNode || this ) {

				// Don't process clicks (ONLY) on disabled elements (#6911, #8165, #11382, #11764)
				if ( cur.disabled !== true || event.type !== "click" ) {
					selMatch = {};
					matches = [];
					for ( i = 0; i < delegateCount; i++ ) {
						handleObj = handlers[ i ];
						sel = handleObj.selector;

						if ( selMatch[ sel ] === undefined ) {
							selMatch[ sel ] = handleObj.needsContext ?
								jQuery( sel, this ).index( cur ) >= 0 :
								jQuery.find( sel, this, null, [ cur ] ).length;
						}
						if ( selMatch[ sel ] ) {
							matches.push( handleObj );
						}
					}
					if ( matches.length ) {
						handlerQueue.push({ elem: cur, matches: matches });
					}
				}
			}
		}

		// Add the remaining (directly-bound) handlers
		if ( handlers.length > delegateCount ) {
			handlerQueue.push({ elem: this, matches: handlers.slice( delegateCount ) });
		}

		// Run delegates first; they may want to stop propagation beneath us
		for ( i = 0; i < handlerQueue.length && !event.isPropagationStopped(); i++ ) {
			matched = handlerQueue[ i ];
			event.currentTarget = matched.elem;

			for ( j = 0; j < matched.matches.length && !event.isImmediatePropagationStopped(); j++ ) {
				handleObj = matched.matches[ j ];

				// Triggered event must either 1) be non-exclusive and have no namespace, or
				// 2) have namespace(s) a subset or equal to those in the bound event (both can have no namespace).
				if ( run_all || (!event.namespace && !handleObj.namespace) || event.namespace_re && event.namespace_re.test( handleObj.namespace ) ) {

					event.data = handleObj.data;
					event.handleObj = handleObj;

					ret = ( (jQuery.event.special[ handleObj.origType ] || {}).handle || handleObj.handler )
							.apply( matched.elem, args );

					if ( ret !== undefined ) {
						event.result = ret;
						if ( ret === false ) {
							event.preventDefault();
							event.stopPropagation();
						}
					}
				}
			}
		}

		// Call the postDispatch hook for the mapped type
		if ( special.postDispatch ) {
			special.postDispatch.call( this, event );
		}

		return event.result;
	},

	// Includes some event props shared by KeyEvent and MouseEvent
	// *** attrChange attrName relatedNode srcElement  are not normalized, non-W3C, deprecated, will be removed in 1.8 ***
	props: "attrChange attrName relatedNode srcElement altKey bubbles cancelable ctrlKey currentTarget eventPhase metaKey relatedTarget shiftKey target timeStamp view which".split(" "),

	fixHooks: {},

	keyHooks: {
		props: "char charCode key keyCode".split(" "),
		filter: function( event, original ) {

			// Add which for key events
			if ( event.which == null ) {
				event.which = original.charCode != null ? original.charCode : original.keyCode;
			}

			return event;
		}
	},

	mouseHooks: {
		props: "button buttons clientX clientY fromElement offsetX offsetY pageX pageY screenX screenY toElement".split(" "),
		filter: function( event, original ) {
			var eventDoc, doc, body,
				button = original.button,
				fromElement = original.fromElement;

			// Calculate pageX/Y if missing and clientX/Y available
			if ( event.pageX == null && original.clientX != null ) {
				eventDoc = event.target.ownerDocument || document;
				doc = eventDoc.documentElement;
				body = eventDoc.body;

				event.pageX = original.clientX + ( doc && doc.scrollLeft || body && body.scrollLeft || 0 ) - ( doc && doc.clientLeft || body && body.clientLeft || 0 );
				event.pageY = original.clientY + ( doc && doc.scrollTop  || body && body.scrollTop  || 0 ) - ( doc && doc.clientTop  || body && body.clientTop  || 0 );
			}

			// Add relatedTarget, if necessary
			if ( !event.relatedTarget && fromElement ) {
				event.relatedTarget = fromElement === event.target ? original.toElement : fromElement;
			}

			// Add which for click: 1 === left; 2 === middle; 3 === right
			// Note: button is not normalized, so don't use it
			if ( !event.which && button !== undefined ) {
				event.which = ( button & 1 ? 1 : ( button & 2 ? 3 : ( button & 4 ? 2 : 0 ) ) );
			}

			return event;
		}
	},

	fix: function( event ) {
		if ( event[ jQuery.expando ] ) {
			return event;
		}

		// Create a writable copy of the event object and normalize some properties
		var i, prop,
			originalEvent = event,
			fixHook = jQuery.event.fixHooks[ event.type ] || {},
			copy = fixHook.props ? this.props.concat( fixHook.props ) : this.props;

		event = jQuery.Event( originalEvent );

		for ( i = copy.length; i; ) {
			prop = copy[ --i ];
			event[ prop ] = originalEvent[ prop ];
		}

		// Fix target property, if necessary (#1925, IE 6/7/8 & Safari2)
		if ( !event.target ) {
			event.target = originalEvent.srcElement || document;
		}

		// Target should not be a text node (#504, Safari)
		if ( event.target.nodeType === 3 ) {
			event.target = event.target.parentNode;
		}

		// For mouse/key events, metaKey==false if it's undefined (#3368, #11328; IE6/7/8)
		event.metaKey = !!event.metaKey;

		return fixHook.filter? fixHook.filter( event, originalEvent ) : event;
	},

	special: {
		load: {
			// Prevent triggered image.load events from bubbling to window.load
			noBubble: true
		},

		focus: {
			delegateType: "focusin"
		},
		blur: {
			delegateType: "focusout"
		},

		beforeunload: {
			setup: function( data, namespaces, eventHandle ) {
				// We only want to do this special case on windows
				if ( jQuery.isWindow( this ) ) {
					this.onbeforeunload = eventHandle;
				}
			},

			teardown: function( namespaces, eventHandle ) {
				if ( this.onbeforeunload === eventHandle ) {
					this.onbeforeunload = null;
				}
			}
		}
	},

	simulate: function( type, elem, event, bubble ) {
		// Piggyback on a donor event to simulate a different one.
		// Fake originalEvent to avoid donor's stopPropagation, but if the
		// simulated event prevents default then we do the same on the donor.
		var e = jQuery.extend(
			new jQuery.Event(),
			event,
			{ type: type,
				isSimulated: true,
				originalEvent: {}
			}
		);
		if ( bubble ) {
			jQuery.event.trigger( e, null, elem );
		} else {
			jQuery.event.dispatch.call( elem, e );
		}
		if ( e.isDefaultPrevented() ) {
			event.preventDefault();
		}
	}
};

// Some plugins are using, but it's undocumented/deprecated and will be removed.
// The 1.7 special event interface should provide all the hooks needed now.
jQuery.event.handle = jQuery.event.dispatch;

jQuery.removeEvent = document.removeEventListener ?
	function( elem, type, handle ) {
		if ( elem.removeEventListener ) {
			elem.removeEventListener( type, handle, false );
		}
	} :
	function( elem, type, handle ) {
		var name = "on" + type;

		if ( elem.detachEvent ) {

			// #8545, #7054, preventing memory leaks for custom events in IE6-8 –
			// detachEvent needed property on element, by name of that event, to properly expose it to GC
			if ( typeof elem[ name ] === "undefined" ) {
				elem[ name ] = null;
			}

			elem.detachEvent( name, handle );
		}
	};

jQuery.Event = function( src, props ) {
	// Allow instantiation without the 'new' keyword
	if ( !(this instanceof jQuery.Event) ) {
		return new jQuery.Event( src, props );
	}

	// Event object
	if ( src && src.type ) {
		this.originalEvent = src;
		this.type = src.type;

		// Events bubbling up the document may have been marked as prevented
		// by a handler lower down the tree; reflect the correct value.
		this.isDefaultPrevented = ( src.defaultPrevented || src.returnValue === false ||
			src.getPreventDefault && src.getPreventDefault() ) ? returnTrue : returnFalse;

	// Event type
	} else {
		this.type = src;
	}

	// Put explicitly provided properties onto the event object
	if ( props ) {
		jQuery.extend( this, props );
	}

	// Create a timestamp if incoming event doesn't have one
	this.timeStamp = src && src.timeStamp || jQuery.now();

	// Mark it as fixed
	this[ jQuery.expando ] = true;
};

function returnFalse() {
	return false;
}
function returnTrue() {
	return true;
}

// jQuery.Event is based on DOM3 Events as specified by the ECMAScript Language Binding
// http://www.w3.org/TR/2003/WD-DOM-Level-3-Events-20030331/ecma-script-binding.html
jQuery.Event.prototype = {
	preventDefault: function() {
		this.isDefaultPrevented = returnTrue;

		var e = this.originalEvent;
		if ( !e ) {
			return;
		}

		// if preventDefault exists run it on the original event
		if ( e.preventDefault ) {
			e.preventDefault();

		// otherwise set the returnValue property of the original event to false (IE)
		} else {
			e.returnValue = false;
		}
	},
	stopPropagation: function() {
		this.isPropagationStopped = returnTrue;

		var e = this.originalEvent;
		if ( !e ) {
			return;
		}
		// if stopPropagation exists run it on the original event
		if ( e.stopPropagation ) {
			e.stopPropagation();
		}
		// otherwise set the cancelBubble property of the original event to true (IE)
		e.cancelBubble = true;
	},
	stopImmediatePropagation: function() {
		this.isImmediatePropagationStopped = returnTrue;
		this.stopPropagation();
	},
	isDefaultPrevented: returnFalse,
	isPropagationStopped: returnFalse,
	isImmediatePropagationStopped: returnFalse
};

// Create mouseenter/leave events using mouseover/out and event-time checks
jQuery.each({
	mouseenter: "mouseover",
	mouseleave: "mouseout"
}, function( orig, fix ) {
	jQuery.event.special[ orig ] = {
		delegateType: fix,
		bindType: fix,

		handle: function( event ) {
			var ret,
				target = this,
				related = event.relatedTarget,
				handleObj = event.handleObj,
				selector = handleObj.selector;

			// For mousenter/leave call the handler if related is outside the target.
			// NB: No relatedTarget if the mouse left/entered the browser window
			if ( !related || (related !== target && !jQuery.contains( target, related )) ) {
				event.type = handleObj.origType;
				ret = handleObj.handler.apply( this, arguments );
				event.type = fix;
			}
			return ret;
		}
	};
});

// IE submit delegation
if ( !jQuery.support.submitBubbles ) {

	jQuery.event.special.submit = {
		setup: function() {
			// Only need this for delegated form submit events
			if ( jQuery.nodeName( this, "form" ) ) {
				return false;
			}

			// Lazy-add a submit handler when a descendant form may potentially be submitted
			jQuery.event.add( this, "click._submit keypress._submit", function( e ) {
				// Node name check avoids a VML-related crash in IE (#9807)
				var elem = e.target,
					form = jQuery.nodeName( elem, "input" ) || jQuery.nodeName( elem, "button" ) ? elem.form : undefined;
				if ( form && !jQuery._data( form, "_submit_attached" ) ) {
					jQuery.event.add( form, "submit._submit", function( event ) {
						event._submit_bubble = true;
					});
					jQuery._data( form, "_submit_attached", true );
				}
			});
			// return undefined since we don't need an event listener
		},

		postDispatch: function( event ) {
			// If form was submitted by the user, bubble the event up the tree
			if ( event._submit_bubble ) {
				delete event._submit_bubble;
				if ( this.parentNode && !event.isTrigger ) {
					jQuery.event.simulate( "submit", this.parentNode, event, true );
				}
			}
		},

		teardown: function() {
			// Only need this for delegated form submit events
			if ( jQuery.nodeName( this, "form" ) ) {
				return false;
			}

			// Remove delegated handlers; cleanData eventually reaps submit handlers attached above
			jQuery.event.remove( this, "._submit" );
		}
	};
}

// IE change delegation and checkbox/radio fix
if ( !jQuery.support.changeBubbles ) {

	jQuery.event.special.change = {

		setup: function() {

			if ( rformElems.test( this.nodeName ) ) {
				// IE doesn't fire change on a check/radio until blur; trigger it on click
				// after a propertychange. Eat the blur-change in special.change.handle.
				// This still fires onchange a second time for check/radio after blur.
				if ( this.type === "checkbox" || this.type === "radio" ) {
					jQuery.event.add( this, "propertychange._change", function( event ) {
						if ( event.originalEvent.propertyName === "checked" ) {
							this._just_changed = true;
						}
					});
					jQuery.event.add( this, "click._change", function( event ) {
						if ( this._just_changed && !event.isTrigger ) {
							this._just_changed = false;
						}
						// Allow triggered, simulated change events (#11500)
						jQuery.event.simulate( "change", this, event, true );
					});
				}
				return false;
			}
			// Delegated event; lazy-add a change handler on descendant inputs
			jQuery.event.add( this, "beforeactivate._change", function( e ) {
				var elem = e.target;

				if ( rformElems.test( elem.nodeName ) && !jQuery._data( elem, "_change_attached" ) ) {
					jQuery.event.add( elem, "change._change", function( event ) {
						if ( this.parentNode && !event.isSimulated && !event.isTrigger ) {
							jQuery.event.simulate( "change", this.parentNode, event, true );
						}
					});
					jQuery._data( elem, "_change_attached", true );
				}
			});
		},

		handle: function( event ) {
			var elem = event.target;

			// Swallow native change events from checkbox/radio, we already triggered them above
			if ( this !== elem || event.isSimulated || event.isTrigger || (elem.type !== "radio" && elem.type !== "checkbox") ) {
				return event.handleObj.handler.apply( this, arguments );
			}
		},

		teardown: function() {
			jQuery.event.remove( this, "._change" );

			return !rformElems.test( this.nodeName );
		}
	};
}

// Create "bubbling" focus and blur events
if ( !jQuery.support.focusinBubbles ) {
	jQuery.each({ focus: "focusin", blur: "focusout" }, function( orig, fix ) {

		// Attach a single capturing handler while someone wants focusin/focusout
		var attaches = 0,
			handler = function( event ) {
				jQuery.event.simulate( fix, event.target, jQuery.event.fix( event ), true );
			};

		jQuery.event.special[ fix ] = {
			setup: function() {
				if ( attaches++ === 0 ) {
					document.addEventListener( orig, handler, true );
				}
			},
			teardown: function() {
				if ( --attaches === 0 ) {
					document.removeEventListener( orig, handler, true );
				}
			}
		};
	});
}

jQuery.fn.extend({

	on: function( types, selector, data, fn, /*INTERNAL*/ one ) {
		var origFn, type;

		// Types can be a map of types/handlers
		if ( typeof types === "object" ) {
			// ( types-Object, selector, data )
			if ( typeof selector !== "string" ) { // && selector != null
				// ( types-Object, data )
				data = data || selector;
				selector = undefined;
			}
			for ( type in types ) {
				this.on( type, selector, data, types[ type ], one );
			}
			return this;
		}

		if ( data == null && fn == null ) {
			// ( types, fn )
			fn = selector;
			data = selector = undefined;
		} else if ( fn == null ) {
			if ( typeof selector === "string" ) {
				// ( types, selector, fn )
				fn = data;
				data = undefined;
			} else {
				// ( types, data, fn )
				fn = data;
				data = selector;
				selector = undefined;
			}
		}
		if ( fn === false ) {
			fn = returnFalse;
		} else if ( !fn ) {
			return this;
		}

		if ( one === 1 ) {
			origFn = fn;
			fn = function( event ) {
				// Can use an empty set, since event contains the info
				jQuery().off( event );
				return origFn.apply( this, arguments );
			};
			// Use same guid so caller can remove using origFn
			fn.guid = origFn.guid || ( origFn.guid = jQuery.guid++ );
		}
		return this.each( function() {
			jQuery.event.add( this, types, fn, data, selector );
		});
	},
	one: function( types, selector, data, fn ) {
		return this.on( types, selector, data, fn, 1 );
	},
	off: function( types, selector, fn ) {
		var handleObj, type;
		if ( types && types.preventDefault && types.handleObj ) {
			// ( event )  dispatched jQuery.Event
			handleObj = types.handleObj;
			jQuery( types.delegateTarget ).off(
				handleObj.namespace ? handleObj.origType + "." + handleObj.namespace : handleObj.origType,
				handleObj.selector,
				handleObj.handler
			);
			return this;
		}
		if ( typeof types === "object" ) {
			// ( types-object [, selector] )
			for ( type in types ) {
				this.off( type, selector, types[ type ] );
			}
			return this;
		}
		if ( selector === false || typeof selector === "function" ) {
			// ( types [, fn] )
			fn = selector;
			selector = undefined;
		}
		if ( fn === false ) {
			fn = returnFalse;
		}
		return this.each(function() {
			jQuery.event.remove( this, types, fn, selector );
		});
	},

	bind: function( types, data, fn ) {
		return this.on( types, null, data, fn );
	},
	unbind: function( types, fn ) {
		return this.off( types, null, fn );
	},

	live: function( types, data, fn ) {
		jQuery( this.context ).on( types, this.selector, data, fn );
		return this;
	},
	die: function( types, fn ) {
		jQuery( this.context ).off( types, this.selector || "**", fn );
		return this;
	},

	delegate: function( selector, types, data, fn ) {
		return this.on( types, selector, data, fn );
	},
	undelegate: function( selector, types, fn ) {
		// ( namespace ) or ( selector, types [, fn] )
		return arguments.length === 1 ? this.off( selector, "**" ) : this.off( types, selector || "**", fn );
	},

	trigger: function( type, data ) {
		return this.each(function() {
			jQuery.event.trigger( type, data, this );
		});
	},
	triggerHandler: function( type, data ) {
		if ( this[0] ) {
			return jQuery.event.trigger( type, data, this[0], true );
		}
	},

	toggle: function( fn ) {
		// Save reference to arguments for access in closure
		var args = arguments,
			guid = fn.guid || jQuery.guid++,
			i = 0,
			toggler = function( event ) {
				// Figure out which function to execute
				var lastToggle = ( jQuery._data( this, "lastToggle" + fn.guid ) || 0 ) % i;
				jQuery._data( this, "lastToggle" + fn.guid, lastToggle + 1 );

				// Make sure that clicks stop
				event.preventDefault();

				// and execute the function
				return args[ lastToggle ].apply( this, arguments ) || false;
			};

		// link all the functions, so any of them can unbind this click handler
		toggler.guid = guid;
		while ( i < args.length ) {
			args[ i++ ].guid = guid;
		}

		return this.click( toggler );
	},

	hover: function( fnOver, fnOut ) {
		return this.mouseenter( fnOver ).mouseleave( fnOut || fnOver );
	}
});

jQuery.each( ("blur focus focusin focusout load resize scroll unload click dblclick " +
	"mousedown mouseup mousemove mouseover mouseout mouseenter mouseleave " +
	"change select submit keydown keypress keyup error contextmenu").split(" "), function( i, name ) {

	// Handle event binding
	jQuery.fn[ name ] = function( data, fn ) {
		if ( fn == null ) {
			fn = data;
			data = null;
		}

		return arguments.length > 0 ?
			this.on( name, null, data, fn ) :
			this.trigger( name );
	};

	if ( rkeyEvent.test( name ) ) {
		jQuery.event.fixHooks[ name ] = jQuery.event.keyHooks;
	}

	if ( rmouseEvent.test( name ) ) {
		jQuery.event.fixHooks[ name ] = jQuery.event.mouseHooks;
	}
});
/*!
 * Sizzle CSS Selector Engine
 * Copyright 2012 jQuery Foundation and other contributors
 * Released under the MIT license
 * http://sizzlejs.com/
 */
(function( window, undefined ) {

var cachedruns,
	assertGetIdNotName,
	Expr,
	getText,
	isXML,
	contains,
	compile,
	sortOrder,
	hasDuplicate,
	outermostContext,

	baseHasDuplicate = true,
	strundefined = "undefined",

	expando = ( "sizcache" + Math.random() ).replace( ".", "" ),

	Token = String,
	document = window.document,
	docElem = document.documentElement,
	dirruns = 0,
	done = 0,
	pop = [].pop,
	push = [].push,
	slice = [].slice,
	// Use a stripped-down indexOf if a native one is unavailable
	indexOf = [].indexOf || function( elem ) {
		var i = 0,
			len = this.length;
		for ( ; i < len; i++ ) {
			if ( this[i] === elem ) {
				return i;
			}
		}
		return -1;
	},

	// Augment a function for special use by Sizzle
	markFunction = function( fn, value ) {
		fn[ expando ] = value == null || value;
		return fn;
	},

	createCache = function() {
		var cache = {},
			keys = [];

		return markFunction(function( key, value ) {
			// Only keep the most recent entries
			if ( keys.push( key ) > Expr.cacheLength ) {
				delete cache[ keys.shift() ];
			}

			return (cache[ key ] = value);
		}, cache );
	},

	classCache = createCache(),
	tokenCache = createCache(),
	compilerCache = createCache(),

	// Regex

	// Whitespace characters http://www.w3.org/TR/css3-selectors/#whitespace
	whitespace = "[\\x20\\t\\r\\n\\f]",
	// http://www.w3.org/TR/css3-syntax/#characters
	characterEncoding = "(?:\\\\.|[-\\w]|[^\\x00-\\xa0])+",

	// Loosely modeled on CSS identifier characters
	// An unquoted value should be a CSS identifier (http://www.w3.org/TR/css3-selectors/#attribute-selectors)
	// Proper syntax: http://www.w3.org/TR/CSS21/syndata.html#value-def-identifier
	identifier = characterEncoding.replace( "w", "w#" ),

	// Acceptable operators http://www.w3.org/TR/selectors/#attribute-selectors
	operators = "([*^$|!~]?=)",
	attributes = "\\[" + whitespace + "*(" + characterEncoding + ")" + whitespace +
		"*(?:" + operators + whitespace + "*(?:(['\"])((?:\\\\.|[^\\\\])*?)\\3|(" + identifier + ")|)|)" + whitespace + "*\\]",

	// Prefer arguments not in parens/brackets,
	//   then attribute selectors and non-pseudos (denoted by :),
	//   then anything else
	// These preferences are here to reduce the number of selectors
	//   needing tokenize in the PSEUDO preFilter
	pseudos = ":(" + characterEncoding + ")(?:\\((?:(['\"])((?:\\\\.|[^\\\\])*?)\\2|([^()[\\]]*|(?:(?:" + attributes + ")|[^:]|\\\\.)*|.*))\\)|)",

	// For matchExpr.POS and matchExpr.needsContext
	pos = ":(even|odd|eq|gt|lt|nth|first|last)(?:\\(" + whitespace +
		"*((?:-\\d)?\\d*)" + whitespace + "*\\)|)(?=[^-]|$)",

	// Leading and non-escaped trailing whitespace, capturing some non-whitespace characters preceding the latter
	rtrim = new RegExp( "^" + whitespace + "+|((?:^|[^\\\\])(?:\\\\.)*)" + whitespace + "+$", "g" ),

	rcomma = new RegExp( "^" + whitespace + "*," + whitespace + "*" ),
	rcombinators = new RegExp( "^" + whitespace + "*([\\x20\\t\\r\\n\\f>+~])" + whitespace + "*" ),
	rpseudo = new RegExp( pseudos ),

	// Easily-parseable/retrievable ID or TAG or CLASS selectors
	rquickExpr = /^(?:#([\w\-]+)|(\w+)|\.([\w\-]+))$/,

	rnot = /^:not/,
	rsibling = /[\x20\t\r\n\f]*[+~]/,
	rendsWithNot = /:not\($/,

	rheader = /h\d/i,
	rinputs = /input|select|textarea|button/i,

	rbackslash = /\\(?!\\)/g,

	matchExpr = {
		"ID": new RegExp( "^#(" + characterEncoding + ")" ),
		"CLASS": new RegExp( "^\\.(" + characterEncoding + ")" ),
		"NAME": new RegExp( "^\\[name=['\"]?(" + characterEncoding + ")['\"]?\\]" ),
		"TAG": new RegExp( "^(" + characterEncoding.replace( "w", "w*" ) + ")" ),
		"ATTR": new RegExp( "^" + attributes ),
		"PSEUDO": new RegExp( "^" + pseudos ),
		"POS": new RegExp( pos, "i" ),
		"CHILD": new RegExp( "^:(only|nth|first|last)-child(?:\\(" + whitespace +
			"*(even|odd|(([+-]|)(\\d*)n|)" + whitespace + "*(?:([+-]|)" + whitespace +
			"*(\\d+)|))" + whitespace + "*\\)|)", "i" ),
		// For use in libraries implementing .is()
		"needsContext": new RegExp( "^" + whitespace + "*[>+~]|" + pos, "i" )
	},

	// Support

	// Used for testing something on an element
	assert = function( fn ) {
		var div = document.createElement("div");

		try {
			return fn( div );
		} catch (e) {
			return false;
		} finally {
			// release memory in IE
			div = null;
		}
	},

	// Check if getElementsByTagName("*") returns only elements
	assertTagNameNoComments = assert(function( div ) {
		div.appendChild( document.createComment("") );
		return !div.getElementsByTagName("*").length;
	}),

	// Check if getAttribute returns normalized href attributes
	assertHrefNotNormalized = assert(function( div ) {
		div.innerHTML = "<a href='#'></a>";
		return div.firstChild && typeof div.firstChild.getAttribute !== strundefined &&
			div.firstChild.getAttribute("href") === "#";
	}),

	// Check if attributes should be retrieved by attribute nodes
	assertAttributes = assert(function( div ) {
		div.innerHTML = "<select></select>";
		var type = typeof div.lastChild.getAttribute("multiple");
		// IE8 returns a string for some attributes even when not present
		return type !== "boolean" && type !== "string";
	}),

	// Check if getElementsByClassName can be trusted
	assertUsableClassName = assert(function( div ) {
		// Opera can't find a second classname (in 9.6)
		div.innerHTML = "<div class='hidden e'></div><div class='hidden'></div>";
		if ( !div.getElementsByClassName || !div.getElementsByClassName("e").length ) {
			return false;
		}

		// Safari 3.2 caches class attributes and doesn't catch changes
		div.lastChild.className = "e";
		return div.getElementsByClassName("e").length === 2;
	}),

	// Check if getElementById returns elements by name
	// Check if getElementsByName privileges form controls or returns elements by ID
	assertUsableName = assert(function( div ) {
		// Inject content
		div.id = expando + 0;
		div.innerHTML = "<a name='" + expando + "'></a><div name='" + expando + "'></div>";
		docElem.insertBefore( div, docElem.firstChild );

		// Test
		var pass = document.getElementsByName &&
			// buggy browsers will return fewer than the correct 2
			document.getElementsByName( expando ).length === 2 +
			// buggy browsers will return more than the correct 0
			document.getElementsByName( expando + 0 ).length;
		assertGetIdNotName = !document.getElementById( expando );

		// Cleanup
		docElem.removeChild( div );

		return pass;
	});

// If slice is not available, provide a backup
try {
	slice.call( docElem.childNodes, 0 )[0].nodeType;
} catch ( e ) {
	slice = function( i ) {
		var elem,
			results = [];
		for ( ; (elem = this[i]); i++ ) {
			results.push( elem );
		}
		return results;
	};
}

function Sizzle( selector, context, results, seed ) {
	results = results || [];
	context = context || document;
	var match, elem, xml, m,
		nodeType = context.nodeType;

	if ( !selector || typeof selector !== "string" ) {
		return results;
	}

	if ( nodeType !== 1 && nodeType !== 9 ) {
		return [];
	}

	xml = isXML( context );

	if ( !xml && !seed ) {
		if ( (match = rquickExpr.exec( selector )) ) {
			// Speed-up: Sizzle("#ID")
			if ( (m = match[1]) ) {
				if ( nodeType === 9 ) {
					elem = context.getElementById( m );
					// Check parentNode to catch when Blackberry 4.6 returns
					// nodes that are no longer in the document #6963
					if ( elem && elem.parentNode ) {
						// Handle the case where IE, Opera, and Webkit return items
						// by name instead of ID
						if ( elem.id === m ) {
							results.push( elem );
							return results;
						}
					} else {
						return results;
					}
				} else {
					// Context is not a document
					if ( context.ownerDocument && (elem = context.ownerDocument.getElementById( m )) &&
						contains( context, elem ) && elem.id === m ) {
						results.push( elem );
						return results;
					}
				}

			// Speed-up: Sizzle("TAG")
			} else if ( match[2] ) {
				push.apply( results, slice.call(context.getElementsByTagName( selector ), 0) );
				return results;

			// Speed-up: Sizzle(".CLASS")
			} else if ( (m = match[3]) && assertUsableClassName && context.getElementsByClassName ) {
				push.apply( results, slice.call(context.getElementsByClassName( m ), 0) );
				return results;
			}
		}
	}

	// All others
	return select( selector.replace( rtrim, "$1" ), context, results, seed, xml );
}

Sizzle.matches = function( expr, elements ) {
	return Sizzle( expr, null, null, elements );
};

Sizzle.matchesSelector = function( elem, expr ) {
	return Sizzle( expr, null, null, [ elem ] ).length > 0;
};

// Returns a function to use in pseudos for input types
function createInputPseudo( type ) {
	return function( elem ) {
		var name = elem.nodeName.toLowerCase();
		return name === "input" && elem.type === type;
	};
}

// Returns a function to use in pseudos for buttons
function createButtonPseudo( type ) {
	return function( elem ) {
		var name = elem.nodeName.toLowerCase();
		return (name === "input" || name === "button") && elem.type === type;
	};
}

// Returns a function to use in pseudos for positionals
function createPositionalPseudo( fn ) {
	return markFunction(function( argument ) {
		argument = +argument;
		return markFunction(function( seed, matches ) {
			var j,
				matchIndexes = fn( [], seed.length, argument ),
				i = matchIndexes.length;

			// Match elements found at the specified indexes
			while ( i-- ) {
				if ( seed[ (j = matchIndexes[i]) ] ) {
					seed[j] = !(matches[j] = seed[j]);
				}
			}
		});
	});
}

/**
 * Utility function for retrieving the text value of an array of DOM nodes
 * @param {Array|Element} elem
 */
getText = Sizzle.getText = function( elem ) {
	var node,
		ret = "",
		i = 0,
		nodeType = elem.nodeType;

	if ( nodeType ) {
		if ( nodeType === 1 || nodeType === 9 || nodeType === 11 ) {
			// Use textContent for elements
			// innerText usage removed for consistency of new lines (see #11153)
			if ( typeof elem.textContent === "string" ) {
				return elem.textContent;
			} else {
				// Traverse its children
				for ( elem = elem.firstChild; elem; elem = elem.nextSibling ) {
					ret += getText( elem );
				}
			}
		} else if ( nodeType === 3 || nodeType === 4 ) {
			return elem.nodeValue;
		}
		// Do not include comment or processing instruction nodes
	} else {

		// If no nodeType, this is expected to be an array
		for ( ; (node = elem[i]); i++ ) {
			// Do not traverse comment nodes
			ret += getText( node );
		}
	}
	return ret;
};

isXML = Sizzle.isXML = function( elem ) {
	// documentElement is verified for cases where it doesn't yet exist
	// (such as loading iframes in IE - #4833)
	var documentElement = elem && (elem.ownerDocument || elem).documentElement;
	return documentElement ? documentElement.nodeName !== "HTML" : false;
};

// Element contains another
contains = Sizzle.contains = docElem.contains ?
	function( a, b ) {
		var adown = a.nodeType === 9 ? a.documentElement : a,
			bup = b && b.parentNode;
		return a === bup || !!( bup && bup.nodeType === 1 && adown.contains && adown.contains(bup) );
	} :
	docElem.compareDocumentPosition ?
	function( a, b ) {
		return b && !!( a.compareDocumentPosition( b ) & 16 );
	} :
	function( a, b ) {
		while ( (b = b.parentNode) ) {
			if ( b === a ) {
				return true;
			}
		}
		return false;
	};

Sizzle.attr = function( elem, name ) {
	var val,
		xml = isXML( elem );

	if ( !xml ) {
		name = name.toLowerCase();
	}
	if ( (val = Expr.attrHandle[ name ]) ) {
		return val( elem );
	}
	if ( xml || assertAttributes ) {
		return elem.getAttribute( name );
	}
	val = elem.getAttributeNode( name );
	return val ?
		typeof elem[ name ] === "boolean" ?
			elem[ name ] ? name : null :
			val.specified ? val.value : null :
		null;
};

Expr = Sizzle.selectors = {

	// Can be adjusted by the user
	cacheLength: 50,

	createPseudo: markFunction,

	match: matchExpr,

	// IE6/7 return a modified href
	attrHandle: assertHrefNotNormalized ?
		{} :
		{
			"href": function( elem ) {
				return elem.getAttribute( "href", 2 );
			},
			"type": function( elem ) {
				return elem.getAttribute("type");
			}
		},

	find: {
		"ID": assertGetIdNotName ?
			function( id, context, xml ) {
				if ( typeof context.getElementById !== strundefined && !xml ) {
					var m = context.getElementById( id );
					// Check parentNode to catch when Blackberry 4.6 returns
					// nodes that are no longer in the document #6963
					return m && m.parentNode ? [m] : [];
				}
			} :
			function( id, context, xml ) {
				if ( typeof context.getElementById !== strundefined && !xml ) {
					var m = context.getElementById( id );

					return m ?
						m.id === id || typeof m.getAttributeNode !== strundefined && m.getAttributeNode("id").value === id ?
							[m] :
							undefined :
						[];
				}
			},

		"TAG": assertTagNameNoComments ?
			function( tag, context ) {
				if ( typeof context.getElementsByTagName !== strundefined ) {
					return context.getElementsByTagName( tag );
				}
			} :
			function( tag, context ) {
				var results = context.getElementsByTagName( tag );

				// Filter out possible comments
				if ( tag === "*" ) {
					var elem,
						tmp = [],
						i = 0;

					for ( ; (elem = results[i]); i++ ) {
						if ( elem.nodeType === 1 ) {
							tmp.push( elem );
						}
					}

					return tmp;
				}
				return results;
			},

		"NAME": assertUsableName && function( tag, context ) {
			if ( typeof context.getElementsByName !== strundefined ) {
				return context.getElementsByName( name );
			}
		},

		"CLASS": assertUsableClassName && function( className, context, xml ) {
			if ( typeof context.getElementsByClassName !== strundefined && !xml ) {
				return context.getElementsByClassName( className );
			}
		}
	},

	relative: {
		">": { dir: "parentNode", first: true },
		" ": { dir: "parentNode" },
		"+": { dir: "previousSibling", first: true },
		"~": { dir: "previousSibling" }
	},

	preFilter: {
		"ATTR": function( match ) {
			match[1] = match[1].replace( rbackslash, "" );

			// Move the given value to match[3] whether quoted or unquoted
			match[3] = ( match[4] || match[5] || "" ).replace( rbackslash, "" );

			if ( match[2] === "~=" ) {
				match[3] = " " + match[3] + " ";
			}

			return match.slice( 0, 4 );
		},

		"CHILD": function( match ) {
			/* matches from matchExpr["CHILD"]
				1 type (only|nth|...)
				2 argument (even|odd|\d*|\d*n([+-]\d+)?|...)
				3 xn-component of xn+y argument ([+-]?\d*n|)
				4 sign of xn-component
				5 x of xn-component
				6 sign of y-component
				7 y of y-component
			*/
			match[1] = match[1].toLowerCase();

			if ( match[1] === "nth" ) {
				// nth-child requires argument
				if ( !match[2] ) {
					Sizzle.error( match[0] );
				}

				// numeric x and y parameters for Expr.filter.CHILD
				// remember that false/true cast respectively to 0/1
				match[3] = +( match[3] ? match[4] + (match[5] || 1) : 2 * ( match[2] === "even" || match[2] === "odd" ) );
				match[4] = +( ( match[6] + match[7] ) || match[2] === "odd" );

			// other types prohibit arguments
			} else if ( match[2] ) {
				Sizzle.error( match[0] );
			}

			return match;
		},

		"PSEUDO": function( match ) {
			var unquoted, excess;
			if ( matchExpr["CHILD"].test( match[0] ) ) {
				return null;
			}

			if ( match[3] ) {
				match[2] = match[3];
			} else if ( (unquoted = match[4]) ) {
				// Only check arguments that contain a pseudo
				if ( rpseudo.test(unquoted) &&
					// Get excess from tokenize (recursively)
					(excess = tokenize( unquoted, true )) &&
					// advance to the next closing parenthesis
					(excess = unquoted.indexOf( ")", unquoted.length - excess ) - unquoted.length) ) {

					// excess is a negative index
					unquoted = unquoted.slice( 0, excess );
					match[0] = match[0].slice( 0, excess );
				}
				match[2] = unquoted;
			}

			// Return only captures needed by the pseudo filter method (type and argument)
			return match.slice( 0, 3 );
		}
	},

	filter: {
		"ID": assertGetIdNotName ?
			function( id ) {
				id = id.replace( rbackslash, "" );
				return function( elem ) {
					return elem.getAttribute("id") === id;
				};
			} :
			function( id ) {
				id = id.replace( rbackslash, "" );
				return function( elem ) {
					var node = typeof elem.getAttributeNode !== strundefined && elem.getAttributeNode("id");
					return node && node.value === id;
				};
			},

		"TAG": function( nodeName ) {
			if ( nodeName === "*" ) {
				return function() { return true; };
			}
			nodeName = nodeName.replace( rbackslash, "" ).toLowerCase();

			return function( elem ) {
				return elem.nodeName && elem.nodeName.toLowerCase() === nodeName;
			};
		},

		"CLASS": function( className ) {
			var pattern = classCache[ expando ][ className ];
			if ( !pattern ) {
				pattern = classCache( className, new RegExp("(^|" + whitespace + ")" + className + "(" + whitespace + "|$)") );
			}
			return function( elem ) {
				return pattern.test( elem.className || (typeof elem.getAttribute !== strundefined && elem.getAttribute("class")) || "" );
			};
		},

		"ATTR": function( name, operator, check ) {
			return function( elem, context ) {
				var result = Sizzle.attr( elem, name );

				if ( result == null ) {
					return operator === "!=";
				}
				if ( !operator ) {
					return true;
				}

				result += "";

				return operator === "=" ? result === check :
					operator === "!=" ? result !== check :
					operator === "^=" ? check && result.indexOf( check ) === 0 :
					operator === "*=" ? check && result.indexOf( check ) > -1 :
					operator === "$=" ? check && result.substr( result.length - check.length ) === check :
					operator === "~=" ? ( " " + result + " " ).indexOf( check ) > -1 :
					operator === "|=" ? result === check || result.substr( 0, check.length + 1 ) === check + "-" :
					false;
			};
		},

		"CHILD": function( type, argument, first, last ) {

			if ( type === "nth" ) {
				return function( elem ) {
					var node, diff,
						parent = elem.parentNode;

					if ( first === 1 && last === 0 ) {
						return true;
					}

					if ( parent ) {
						diff = 0;
						for ( node = parent.firstChild; node; node = node.nextSibling ) {
							if ( node.nodeType === 1 ) {
								diff++;
								if ( elem === node ) {
									break;
								}
							}
						}
					}

					// Incorporate the offset (or cast to NaN), then check against cycle size
					diff -= last;
					return diff === first || ( diff % first === 0 && diff / first >= 0 );
				};
			}

			return function( elem ) {
				var node = elem;

				switch ( type ) {
					case "only":
					case "first":
						while ( (node = node.previousSibling) ) {
							if ( node.nodeType === 1 ) {
								return false;
							}
						}

						if ( type === "first" ) {
							return true;
						}

						node = elem;

						/* falls through */
					case "last":
						while ( (node = node.nextSibling) ) {
							if ( node.nodeType === 1 ) {
								return false;
							}
						}

						return true;
				}
			};
		},

		"PSEUDO": function( pseudo, argument ) {
			// pseudo-class names are case-insensitive
			// http://www.w3.org/TR/selectors/#pseudo-classes
			// Prioritize by case sensitivity in case custom pseudos are added with uppercase letters
			// Remember that setFilters inherits from pseudos
			var args,
				fn = Expr.pseudos[ pseudo ] || Expr.setFilters[ pseudo.toLowerCase() ] ||
					Sizzle.error( "unsupported pseudo: " + pseudo );

			// The user may use createPseudo to indicate that
			// arguments are needed to create the filter function
			// just as Sizzle does
			if ( fn[ expando ] ) {
				return fn( argument );
			}

			// But maintain support for old signatures
			if ( fn.length > 1 ) {
				args = [ pseudo, pseudo, "", argument ];
				return Expr.setFilters.hasOwnProperty( pseudo.toLowerCase() ) ?
					markFunction(function( seed, matches ) {
						var idx,
							matched = fn( seed, argument ),
							i = matched.length;
						while ( i-- ) {
							idx = indexOf.call( seed, matched[i] );
							seed[ idx ] = !( matches[ idx ] = matched[i] );
						}
					}) :
					function( elem ) {
						return fn( elem, 0, args );
					};
			}

			return fn;
		}
	},

	pseudos: {
		"not": markFunction(function( selector ) {
			// Trim the selector passed to compile
			// to avoid treating leading and trailing
			// spaces as combinators
			var input = [],
				results = [],
				matcher = compile( selector.replace( rtrim, "$1" ) );

			return matcher[ expando ] ?
				markFunction(function( seed, matches, context, xml ) {
					var elem,
						unmatched = matcher( seed, null, xml, [] ),
						i = seed.length;

					// Match elements unmatched by `matcher`
					while ( i-- ) {
						if ( (elem = unmatched[i]) ) {
							seed[i] = !(matches[i] = elem);
						}
					}
				}) :
				function( elem, context, xml ) {
					input[0] = elem;
					matcher( input, null, xml, results );
					return !results.pop();
				};
		}),

		"has": markFunction(function( selector ) {
			return function( elem ) {
				return Sizzle( selector, elem ).length > 0;
			};
		}),

		"contains": markFunction(function( text ) {
			return function( elem ) {
				return ( elem.textContent || elem.innerText || getText( elem ) ).indexOf( text ) > -1;
			};
		}),

		"enabled": function( elem ) {
			return elem.disabled === false;
		},

		"disabled": function( elem ) {
			return elem.disabled === true;
		},

		"checked": function( elem ) {
			// In CSS3, :checked should return both checked and selected elements
			// http://www.w3.org/TR/2011/REC-css3-selectors-20110929/#checked
			var nodeName = elem.nodeName.toLowerCase();
			return (nodeName === "input" && !!elem.checked) || (nodeName === "option" && !!elem.selected);
		},

		"selected": function( elem ) {
			// Accessing this property makes selected-by-default
			// options in Safari work properly
			if ( elem.parentNode ) {
				elem.parentNode.selectedIndex;
			}

			return elem.selected === true;
		},

		"parent": function( elem ) {
			return !Expr.pseudos["empty"]( elem );
		},

		"empty": function( elem ) {
			// http://www.w3.org/TR/selectors/#empty-pseudo
			// :empty is only affected by element nodes and content nodes(including text(3), cdata(4)),
			//   not comment, processing instructions, or others
			// Thanks to Diego Perini for the nodeName shortcut
			//   Greater than "@" means alpha characters (specifically not starting with "#" or "?")
			var nodeType;
			elem = elem.firstChild;
			while ( elem ) {
				if ( elem.nodeName > "@" || (nodeType = elem.nodeType) === 3 || nodeType === 4 ) {
					return false;
				}
				elem = elem.nextSibling;
			}
			return true;
		},

		"header": function( elem ) {
			return rheader.test( elem.nodeName );
		},

		"text": function( elem ) {
			var type, attr;
			// IE6 and 7 will map elem.type to 'text' for new HTML5 types (search, etc)
			// use getAttribute instead to test this case
			return elem.nodeName.toLowerCase() === "input" &&
				(type = elem.type) === "text" &&
				( (attr = elem.getAttribute("type")) == null || attr.toLowerCase() === type );
		},

		// Input types
		"radio": createInputPseudo("radio"),
		"checkbox": createInputPseudo("checkbox"),
		"file": createInputPseudo("file"),
		"password": createInputPseudo("password"),
		"image": createInputPseudo("image"),

		"submit": createButtonPseudo("submit"),
		"reset": createButtonPseudo("reset"),

		"button": function( elem ) {
			var name = elem.nodeName.toLowerCase();
			return name === "input" && elem.type === "button" || name === "button";
		},

		"input": function( elem ) {
			return rinputs.test( elem.nodeName );
		},

		"focus": function( elem ) {
			var doc = elem.ownerDocument;
			return elem === doc.activeElement && (!doc.hasFocus || doc.hasFocus()) && !!(elem.type || elem.href);
		},

		"active": function( elem ) {
			return elem === elem.ownerDocument.activeElement;
		},

		// Positional types
		"first": createPositionalPseudo(function( matchIndexes, length, argument ) {
			return [ 0 ];
		}),

		"last": createPositionalPseudo(function( matchIndexes, length, argument ) {
			return [ length - 1 ];
		}),

		"eq": createPositionalPseudo(function( matchIndexes, length, argument ) {
			return [ argument < 0 ? argument + length : argument ];
		}),

		"even": createPositionalPseudo(function( matchIndexes, length, argument ) {
			for ( var i = 0; i < length; i += 2 ) {
				matchIndexes.push( i );
			}
			return matchIndexes;
		}),

		"odd": createPositionalPseudo(function( matchIndexes, length, argument ) {
			for ( var i = 1; i < length; i += 2 ) {
				matchIndexes.push( i );
			}
			return matchIndexes;
		}),

		"lt": createPositionalPseudo(function( matchIndexes, length, argument ) {
			for ( var i = argument < 0 ? argument + length : argument; --i >= 0; ) {
				matchIndexes.push( i );
			}
			return matchIndexes;
		}),

		"gt": createPositionalPseudo(function( matchIndexes, length, argument ) {
			for ( var i = argument < 0 ? argument + length : argument; ++i < length; ) {
				matchIndexes.push( i );
			}
			return matchIndexes;
		})
	}
};

function siblingCheck( a, b, ret ) {
	if ( a === b ) {
		return ret;
	}

	var cur = a.nextSibling;

	while ( cur ) {
		if ( cur === b ) {
			return -1;
		}

		cur = cur.nextSibling;
	}

	return 1;
}

sortOrder = docElem.compareDocumentPosition ?
	function( a, b ) {
		if ( a === b ) {
			hasDuplicate = true;
			return 0;
		}

		return ( !a.compareDocumentPosition || !b.compareDocumentPosition ?
			a.compareDocumentPosition :
			a.compareDocumentPosition(b) & 4
		) ? -1 : 1;
	} :
	function( a, b ) {
		// The nodes are identical, we can exit early
		if ( a === b ) {
			hasDuplicate = true;
			return 0;

		// Fallback to using sourceIndex (in IE) if it's available on both nodes
		} else if ( a.sourceIndex && b.sourceIndex ) {
			return a.sourceIndex - b.sourceIndex;
		}

		var al, bl,
			ap = [],
			bp = [],
			aup = a.parentNode,
			bup = b.parentNode,
			cur = aup;

		// If the nodes are siblings (or identical) we can do a quick check
		if ( aup === bup ) {
			return siblingCheck( a, b );

		// If no parents were found then the nodes are disconnected
		} else if ( !aup ) {
			return -1;

		} else if ( !bup ) {
			return 1;
		}

		// Otherwise they're somewhere else in the tree so we need
		// to build up a full list of the parentNodes for comparison
		while ( cur ) {
			ap.unshift( cur );
			cur = cur.parentNode;
		}

		cur = bup;

		while ( cur ) {
			bp.unshift( cur );
			cur = cur.parentNode;
		}

		al = ap.length;
		bl = bp.length;

		// Start walking down the tree looking for a discrepancy
		for ( var i = 0; i < al && i < bl; i++ ) {
			if ( ap[i] !== bp[i] ) {
				return siblingCheck( ap[i], bp[i] );
			}
		}

		// We ended someplace up the tree so do a sibling check
		return i === al ?
			siblingCheck( a, bp[i], -1 ) :
			siblingCheck( ap[i], b, 1 );
	};

// Always assume the presence of duplicates if sort doesn't
// pass them to our comparison function (as in Google Chrome).
[0, 0].sort( sortOrder );
baseHasDuplicate = !hasDuplicate;

// Document sorting and removing duplicates
Sizzle.uniqueSort = function( results ) {
	var elem,
		i = 1;

	hasDuplicate = baseHasDuplicate;
	results.sort( sortOrder );

	if ( hasDuplicate ) {
		for ( ; (elem = results[i]); i++ ) {
			if ( elem === results[ i - 1 ] ) {
				results.splice( i--, 1 );
			}
		}
	}

	return results;
};

Sizzle.error = function( msg ) {
	throw new Error( "Syntax error, unrecognized expression: " + msg );
};

function tokenize( selector, parseOnly ) {
	var matched, match, tokens, type, soFar, groups, preFilters,
		cached = tokenCache[ expando ][ selector ];

	if ( cached ) {
		return parseOnly ? 0 : cached.slice( 0 );
	}

	soFar = selector;
	groups = [];
	preFilters = Expr.preFilter;

	while ( soFar ) {

		// Comma and first run
		if ( !matched || (match = rcomma.exec( soFar )) ) {
			if ( match ) {
				soFar = soFar.slice( match[0].length );
			}
			groups.push( tokens = [] );
		}

		matched = false;

		// Combinators
		if ( (match = rcombinators.exec( soFar )) ) {
			tokens.push( matched = new Token( match.shift() ) );
			soFar = soFar.slice( matched.length );

			// Cast descendant combinators to space
			matched.type = match[0].replace( rtrim, " " );
		}

		// Filters
		for ( type in Expr.filter ) {
			if ( (match = matchExpr[ type ].exec( soFar )) && (!preFilters[ type ] ||
				// The last two arguments here are (context, xml) for backCompat
				(match = preFilters[ type ]( match, document, true ))) ) {

				tokens.push( matched = new Token( match.shift() ) );
				soFar = soFar.slice( matched.length );
				matched.type = type;
				matched.matches = match;
			}
		}

		if ( !matched ) {
			break;
		}
	}

	// Return the length of the invalid excess
	// if we're just parsing
	// Otherwise, throw an error or return tokens
	return parseOnly ?
		soFar.length :
		soFar ?
			Sizzle.error( selector ) :
			// Cache the tokens
			tokenCache( selector, groups ).slice( 0 );
}

function addCombinator( matcher, combinator, base ) {
	var dir = combinator.dir,
		checkNonElements = base && combinator.dir === "parentNode",
		doneName = done++;

	return combinator.first ?
		// Check against closest ancestor/preceding element
		function( elem, context, xml ) {
			while ( (elem = elem[ dir ]) ) {
				if ( checkNonElements || elem.nodeType === 1  ) {
					return matcher( elem, context, xml );
				}
			}
		} :

		// Check against all ancestor/preceding elements
		function( elem, context, xml ) {
			// We can't set arbitrary data on XML nodes, so they don't benefit from dir caching
			if ( !xml ) {
				var cache,
					dirkey = dirruns + " " + doneName + " ",
					cachedkey = dirkey + cachedruns;
				while ( (elem = elem[ dir ]) ) {
					if ( checkNonElements || elem.nodeType === 1 ) {
						if ( (cache = elem[ expando ]) === cachedkey ) {
							return elem.sizset;
						} else if ( typeof cache === "string" && cache.indexOf(dirkey) === 0 ) {
							if ( elem.sizset ) {
								return elem;
							}
						} else {
							elem[ expando ] = cachedkey;
							if ( matcher( elem, context, xml ) ) {
								elem.sizset = true;
								return elem;
							}
							elem.sizset = false;
						}
					}
				}
			} else {
				while ( (elem = elem[ dir ]) ) {
					if ( checkNonElements || elem.nodeType === 1 ) {
						if ( matcher( elem, context, xml ) ) {
							return elem;
						}
					}
				}
			}
		};
}

function elementMatcher( matchers ) {
	return matchers.length > 1 ?
		function( elem, context, xml ) {
			var i = matchers.length;
			while ( i-- ) {
				if ( !matchers[i]( elem, context, xml ) ) {
					return false;
				}
			}
			return true;
		} :
		matchers[0];
}

function condense( unmatched, map, filter, context, xml ) {
	var elem,
		newUnmatched = [],
		i = 0,
		len = unmatched.length,
		mapped = map != null;

	for ( ; i < len; i++ ) {
		if ( (elem = unmatched[i]) ) {
			if ( !filter || filter( elem, context, xml ) ) {
				newUnmatched.push( elem );
				if ( mapped ) {
					map.push( i );
				}
			}
		}
	}

	return newUnmatched;
}

function setMatcher( preFilter, selector, matcher, postFilter, postFinder, postSelector ) {
	if ( postFilter && !postFilter[ expando ] ) {
		postFilter = setMatcher( postFilter );
	}
	if ( postFinder && !postFinder[ expando ] ) {
		postFinder = setMatcher( postFinder, postSelector );
	}
	return markFunction(function( seed, results, context, xml ) {
		// Positional selectors apply to seed elements, so it is invalid to follow them with relative ones
		if ( seed && postFinder ) {
			return;
		}

		var i, elem, postFilterIn,
			preMap = [],
			postMap = [],
			preexisting = results.length,

			// Get initial elements from seed or context
			elems = seed || multipleContexts( selector || "*", context.nodeType ? [ context ] : context, [], seed ),

			// Prefilter to get matcher input, preserving a map for seed-results synchronization
			matcherIn = preFilter && ( seed || !selector ) ?
				condense( elems, preMap, preFilter, context, xml ) :
				elems,

			matcherOut = matcher ?
				// If we have a postFinder, or filtered seed, or non-seed postFilter or preexisting results,
				postFinder || ( seed ? preFilter : preexisting || postFilter ) ?

					// ...intermediate processing is necessary
					[] :

					// ...otherwise use results directly
					results :
				matcherIn;

		// Find primary matches
		if ( matcher ) {
			matcher( matcherIn, matcherOut, context, xml );
		}

		// Apply postFilter
		if ( postFilter ) {
			postFilterIn = condense( matcherOut, postMap );
			postFilter( postFilterIn, [], context, xml );

			// Un-match failing elements by moving them back to matcherIn
			i = postFilterIn.length;
			while ( i-- ) {
				if ( (elem = postFilterIn[i]) ) {
					matcherOut[ postMap[i] ] = !(matcherIn[ postMap[i] ] = elem);
				}
			}
		}

		// Keep seed and results synchronized
		if ( seed ) {
			// Ignore postFinder because it can't coexist with seed
			i = preFilter && matcherOut.length;
			while ( i-- ) {
				if ( (elem = matcherOut[i]) ) {
					seed[ preMap[i] ] = !(results[ preMap[i] ] = elem);
				}
			}
		} else {
			matcherOut = condense(
				matcherOut === results ?
					matcherOut.splice( preexisting, matcherOut.length ) :
					matcherOut
			);
			if ( postFinder ) {
				postFinder( null, results, matcherOut, xml );
			} else {
				push.apply( results, matcherOut );
			}
		}
	});
}

function matcherFromTokens( tokens ) {
	var checkContext, matcher, j,
		len = tokens.length,
		leadingRelative = Expr.relative[ tokens[0].type ],
		implicitRelative = leadingRelative || Expr.relative[" "],
		i = leadingRelative ? 1 : 0,

		// The foundational matcher ensures that elements are reachable from top-level context(s)
		matchContext = addCombinator( function( elem ) {
			return elem === checkContext;
		}, implicitRelative, true ),
		matchAnyContext = addCombinator( function( elem ) {
			return indexOf.call( checkContext, elem ) > -1;
		}, implicitRelative, true ),
		matchers = [ function( elem, context, xml ) {
			return ( !leadingRelative && ( xml || context !== outermostContext ) ) || (
				(checkContext = context).nodeType ?
					matchContext( elem, context, xml ) :
					matchAnyContext( elem, context, xml ) );
		} ];

	for ( ; i < len; i++ ) {
		if ( (matcher = Expr.relative[ tokens[i].type ]) ) {
			matchers = [ addCombinator( elementMatcher( matchers ), matcher ) ];
		} else {
			// The concatenated values are (context, xml) for backCompat
			matcher = Expr.filter[ tokens[i].type ].apply( null, tokens[i].matches );

			// Return special upon seeing a positional matcher
			if ( matcher[ expando ] ) {
				// Find the next relative operator (if any) for proper handling
				j = ++i;
				for ( ; j < len; j++ ) {
					if ( Expr.relative[ tokens[j].type ] ) {
						break;
					}
				}
				return setMatcher(
					i > 1 && elementMatcher( matchers ),
					i > 1 && tokens.slice( 0, i - 1 ).join("").replace( rtrim, "$1" ),
					matcher,
					i < j && matcherFromTokens( tokens.slice( i, j ) ),
					j < len && matcherFromTokens( (tokens = tokens.slice( j )) ),
					j < len && tokens.join("")
				);
			}
			matchers.push( matcher );
		}
	}

	return elementMatcher( matchers );
}

function matcherFromGroupMatchers( elementMatchers, setMatchers ) {
	var bySet = setMatchers.length > 0,
		byElement = elementMatchers.length > 0,
		superMatcher = function( seed, context, xml, results, expandContext ) {
			var elem, j, matcher,
				setMatched = [],
				matchedCount = 0,
				i = "0",
				unmatched = seed && [],
				outermost = expandContext != null,
				contextBackup = outermostContext,
				// We must always have either seed elements or context
				elems = seed || byElement && Expr.find["TAG"]( "*", expandContext && context.parentNode || context ),
				// Nested matchers should use non-integer dirruns
				dirrunsUnique = (dirruns += contextBackup == null ? 1 : Math.E);

			if ( outermost ) {
				outermostContext = context !== document && context;
				cachedruns = superMatcher.el;
			}

			// Add elements passing elementMatchers directly to results
			for ( ; (elem = elems[i]) != null; i++ ) {
				if ( byElement && elem ) {
					for ( j = 0; (matcher = elementMatchers[j]); j++ ) {
						if ( matcher( elem, context, xml ) ) {
							results.push( elem );
							break;
						}
					}
					if ( outermost ) {
						dirruns = dirrunsUnique;
						cachedruns = ++superMatcher.el;
					}
				}

				// Track unmatched elements for set filters
				if ( bySet ) {
					// They will have gone through all possible matchers
					if ( (elem = !matcher && elem) ) {
						matchedCount--;
					}

					// Lengthen the array for every element, matched or not
					if ( seed ) {
						unmatched.push( elem );
					}
				}
			}

			// Apply set filters to unmatched elements
			matchedCount += i;
			if ( bySet && i !== matchedCount ) {
				for ( j = 0; (matcher = setMatchers[j]); j++ ) {
					matcher( unmatched, setMatched, context, xml );
				}

				if ( seed ) {
					// Reintegrate element matches to eliminate the need for sorting
					if ( matchedCount > 0 ) {
						while ( i-- ) {
							if ( !(unmatched[i] || setMatched[i]) ) {
								setMatched[i] = pop.call( results );
							}
						}
					}

					// Discard index placeholder values to get only actual matches
					setMatched = condense( setMatched );
				}

				// Add matches to results
				push.apply( results, setMatched );

				// Seedless set matches succeeding multiple successful matchers stipulate sorting
				if ( outermost && !seed && setMatched.length > 0 &&
					( matchedCount + setMatchers.length ) > 1 ) {

					Sizzle.uniqueSort( results );
				}
			}

			// Override manipulation of globals by nested matchers
			if ( outermost ) {
				dirruns = dirrunsUnique;
				outermostContext = contextBackup;
			}

			return unmatched;
		};

	superMatcher.el = 0;
	return bySet ?
		markFunction( superMatcher ) :
		superMatcher;
}

compile = Sizzle.compile = function( selector, group /* Internal Use Only */ ) {
	var i,
		setMatchers = [],
		elementMatchers = [],
		cached = compilerCache[ expando ][ selector ];

	if ( !cached ) {
		// Generate a function of recursive functions that can be used to check each element
		if ( !group ) {
			group = tokenize( selector );
		}
		i = group.length;
		while ( i-- ) {
			cached = matcherFromTokens( group[i] );
			if ( cached[ expando ] ) {
				setMatchers.push( cached );
			} else {
				elementMatchers.push( cached );
			}
		}

		// Cache the compiled function
		cached = compilerCache( selector, matcherFromGroupMatchers( elementMatchers, setMatchers ) );
	}
	return cached;
};

function multipleContexts( selector, contexts, results, seed ) {
	var i = 0,
		len = contexts.length;
	for ( ; i < len; i++ ) {
		Sizzle( selector, contexts[i], results, seed );
	}
	return results;
}

function select( selector, context, results, seed, xml ) {
	var i, tokens, token, type, find,
		match = tokenize( selector ),
		j = match.length;

	if ( !seed ) {
		// Try to minimize operations if there is only one group
		if ( match.length === 1 ) {

			// Take a shortcut and set the context if the root selector is an ID
			tokens = match[0] = match[0].slice( 0 );
			if ( tokens.length > 2 && (token = tokens[0]).type === "ID" &&
					context.nodeType === 9 && !xml &&
					Expr.relative[ tokens[1].type ] ) {

				context = Expr.find["ID"]( token.matches[0].replace( rbackslash, "" ), context, xml )[0];
				if ( !context ) {
					return results;
				}

				selector = selector.slice( tokens.shift().length );
			}

			// Fetch a seed set for right-to-left matching
			for ( i = matchExpr["POS"].test( selector ) ? -1 : tokens.length - 1; i >= 0; i-- ) {
				token = tokens[i];

				// Abort if we hit a combinator
				if ( Expr.relative[ (type = token.type) ] ) {
					break;
				}
				if ( (find = Expr.find[ type ]) ) {
					// Search, expanding context for leading sibling combinators
					if ( (seed = find(
						token.matches[0].replace( rbackslash, "" ),
						rsibling.test( tokens[0].type ) && context.parentNode || context,
						xml
					)) ) {

						// If seed is empty or no tokens remain, we can return early
						tokens.splice( i, 1 );
						selector = seed.length && tokens.join("");
						if ( !selector ) {
							push.apply( results, slice.call( seed, 0 ) );
							return results;
						}

						break;
					}
				}
			}
		}
	}

	// Compile and execute a filtering function
	// Provide `match` to avoid retokenization if we modified the selector above
	compile( selector, match )(
		seed,
		context,
		xml,
		results,
		rsibling.test( selector )
	);
	return results;
}

if ( document.querySelectorAll ) {
	(function() {
		var disconnectedMatch,
			oldSelect = select,
			rescape = /'|\\/g,
			rattributeQuotes = /\=[\x20\t\r\n\f]*([^'"\]]*)[\x20\t\r\n\f]*\]/g,

			// qSa(:focus) reports false when true (Chrome 21),
			// A support test would require too much code (would include document ready)
			rbuggyQSA = [":focus"],

			// matchesSelector(:focus) reports false when true (Chrome 21),
			// matchesSelector(:active) reports false when true (IE9/Opera 11.5)
			// A support test would require too much code (would include document ready)
			// just skip matchesSelector for :active
			rbuggyMatches = [ ":active", ":focus" ],
			matches = docElem.matchesSelector ||
				docElem.mozMatchesSelector ||
				docElem.webkitMatchesSelector ||
				docElem.oMatchesSelector ||
				docElem.msMatchesSelector;

		// Build QSA regex
		// Regex strategy adopted from Diego Perini
		assert(function( div ) {
			// Select is set to empty string on purpose
			// This is to test IE's treatment of not explictly
			// setting a boolean content attribute,
			// since its presence should be enough
			// http://bugs.jquery.com/ticket/12359
			div.innerHTML = "<select><option selected=''></option></select>";

			// IE8 - Some boolean attributes are not treated correctly
			if ( !div.querySelectorAll("[selected]").length ) {
				rbuggyQSA.push( "\\[" + whitespace + "*(?:checked|disabled|ismap|multiple|readonly|selected|value)" );
			}

			// Webkit/Opera - :checked should return selected option elements
			// http://www.w3.org/TR/2011/REC-css3-selectors-20110929/#checked
			// IE8 throws error here (do not put tests after this one)
			if ( !div.querySelectorAll(":checked").length ) {
				rbuggyQSA.push(":checked");
			}
		});

		assert(function( div ) {

			// Opera 10-12/IE9 - ^= $= *= and empty values
			// Should not select anything
			div.innerHTML = "<p test=''></p>";
			if ( div.querySelectorAll("[test^='']").length ) {
				rbuggyQSA.push( "[*^$]=" + whitespace + "*(?:\"\"|'')" );
			}

			// FF 3.5 - :enabled/:disabled and hidden elements (hidden elements are still enabled)
			// IE8 throws error here (do not put tests after this one)
			div.innerHTML = "<input type='hidden'/>";
			if ( !div.querySelectorAll(":enabled").length ) {
				rbuggyQSA.push(":enabled", ":disabled");
			}
		});

		// rbuggyQSA always contains :focus, so no need for a length check
		rbuggyQSA = /* rbuggyQSA.length && */ new RegExp( rbuggyQSA.join("|") );

		select = function( selector, context, results, seed, xml ) {
			// Only use querySelectorAll when not filtering,
			// when this is not xml,
			// and when no QSA bugs apply
			if ( !seed && !xml && (!rbuggyQSA || !rbuggyQSA.test( selector )) ) {
				var groups, i,
					old = true,
					nid = expando,
					newContext = context,
					newSelector = context.nodeType === 9 && selector;

				// qSA works strangely on Element-rooted queries
				// We can work around this by specifying an extra ID on the root
				// and working up from there (Thanks to Andrew Dupont for the technique)
				// IE 8 doesn't work on object elements
				if ( context.nodeType === 1 && context.nodeName.toLowerCase() !== "object" ) {
					groups = tokenize( selector );

					if ( (old = context.getAttribute("id")) ) {
						nid = old.replace( rescape, "\\$&" );
					} else {
						context.setAttribute( "id", nid );
					}
					nid = "[id='" + nid + "'] ";

					i = groups.length;
					while ( i-- ) {
						groups[i] = nid + groups[i].join("");
					}
					newContext = rsibling.test( selector ) && context.parentNode || context;
					newSelector = groups.join(",");
				}

				if ( newSelector ) {
					try {
						push.apply( results, slice.call( newContext.querySelectorAll(
							newSelector
						), 0 ) );
						return results;
					} catch(qsaError) {
					} finally {
						if ( !old ) {
							context.removeAttribute("id");
						}
					}
				}
			}

			return oldSelect( selector, context, results, seed, xml );
		};

		if ( matches ) {
			assert(function( div ) {
				// Check to see if it's possible to do matchesSelector
				// on a disconnected node (IE 9)
				disconnectedMatch = matches.call( div, "div" );

				// This should fail with an exception
				// Gecko does not error, returns false instead
				try {
					matches.call( div, "[test!='']:sizzle" );
					rbuggyMatches.push( "!=", pseudos );
				} catch ( e ) {}
			});

			// rbuggyMatches always contains :active and :focus, so no need for a length check
			rbuggyMatches = /* rbuggyMatches.length && */ new RegExp( rbuggyMatches.join("|") );

			Sizzle.matchesSelector = function( elem, expr ) {
				// Make sure that attribute selectors are quoted
				expr = expr.replace( rattributeQuotes, "='$1']" );

				// rbuggyMatches always contains :active, so no need for an existence check
				if ( !isXML( elem ) && !rbuggyMatches.test( expr ) && (!rbuggyQSA || !rbuggyQSA.test( expr )) ) {
					try {
						var ret = matches.call( elem, expr );

						// IE 9's matchesSelector returns false on disconnected nodes
						if ( ret || disconnectedMatch ||
								// As well, disconnected nodes are said to be in a document
								// fragment in IE 9
								elem.document && elem.document.nodeType !== 11 ) {
							return ret;
						}
					} catch(e) {}
				}

				return Sizzle( expr, null, null, [ elem ] ).length > 0;
			};
		}
	})();
}

// Deprecated
Expr.pseudos["nth"] = Expr.pseudos["eq"];

// Back-compat
function setFilters() {}
Expr.filters = setFilters.prototype = Expr.pseudos;
Expr.setFilters = new setFilters();

// Override sizzle attribute retrieval
Sizzle.attr = jQuery.attr;
jQuery.find = Sizzle;
jQuery.expr = Sizzle.selectors;
jQuery.expr[":"] = jQuery.expr.pseudos;
jQuery.unique = Sizzle.uniqueSort;
jQuery.text = Sizzle.getText;
jQuery.isXMLDoc = Sizzle.isXML;
jQuery.contains = Sizzle.contains;


})( window );
var runtil = /Until$/,
	rparentsprev = /^(?:parents|prev(?:Until|All))/,
	isSimple = /^.[^:#\[\.,]*$/,
	rneedsContext = jQuery.expr.match.needsContext,
	// methods guaranteed to produce a unique set when starting from a unique set
	guaranteedUnique = {
		children: true,
		contents: true,
		next: true,
		prev: true
	};

jQuery.fn.extend({
	find: function( selector ) {
		var i, l, length, n, r, ret,
			self = this;

		if ( typeof selector !== "string" ) {
			return jQuery( selector ).filter(function() {
				for ( i = 0, l = self.length; i < l; i++ ) {
					if ( jQuery.contains( self[ i ], this ) ) {
						return true;
					}
				}
			});
		}

		ret = this.pushStack( "", "find", selector );

		for ( i = 0, l = this.length; i < l; i++ ) {
			length = ret.length;
			jQuery.find( selector, this[i], ret );

			if ( i > 0 ) {
				// Make sure that the results are unique
				for ( n = length; n < ret.length; n++ ) {
					for ( r = 0; r < length; r++ ) {
						if ( ret[r] === ret[n] ) {
							ret.splice(n--, 1);
							break;
						}
					}
				}
			}
		}

		return ret;
	},

	has: function( target ) {
		var i,
			targets = jQuery( target, this ),
			len = targets.length;

		return this.filter(function() {
			for ( i = 0; i < len; i++ ) {
				if ( jQuery.contains( this, targets[i] ) ) {
					return true;
				}
			}
		});
	},

	not: function( selector ) {
		return this.pushStack( winnow(this, selector, false), "not", selector);
	},

	filter: function( selector ) {
		return this.pushStack( winnow(this, selector, true), "filter", selector );
	},

	is: function( selector ) {
		return !!selector && (
			typeof selector === "string" ?
				// If this is a positional/relative selector, check membership in the returned set
				// so $("p:first").is("p:last") won't return true for a doc with two "p".
				rneedsContext.test( selector ) ?
					jQuery( selector, this.context ).index( this[0] ) >= 0 :
					jQuery.filter( selector, this ).length > 0 :
				this.filter( selector ).length > 0 );
	},

	closest: function( selectors, context ) {
		var cur,
			i = 0,
			l = this.length,
			ret = [],
			pos = rneedsContext.test( selectors ) || typeof selectors !== "string" ?
				jQuery( selectors, context || this.context ) :
				0;

		for ( ; i < l; i++ ) {
			cur = this[i];

			while ( cur && cur.ownerDocument && cur !== context && cur.nodeType !== 11 ) {
				if ( pos ? pos.index(cur) > -1 : jQuery.find.matchesSelector(cur, selectors) ) {
					ret.push( cur );
					break;
				}
				cur = cur.parentNode;
			}
		}

		ret = ret.length > 1 ? jQuery.unique( ret ) : ret;

		return this.pushStack( ret, "closest", selectors );
	},

	// Determine the position of an element within
	// the matched set of elements
	index: function( elem ) {

		// No argument, return index in parent
		if ( !elem ) {
			return ( this[0] && this[0].parentNode ) ? this.prevAll().length : -1;
		}

		// index in selector
		if ( typeof elem === "string" ) {
			return jQuery.inArray( this[0], jQuery( elem ) );
		}

		// Locate the position of the desired element
		return jQuery.inArray(
			// If it receives a jQuery object, the first element is used
			elem.jquery ? elem[0] : elem, this );
	},

	add: function( selector, context ) {
		var set = typeof selector === "string" ?
				jQuery( selector, context ) :
				jQuery.makeArray( selector && selector.nodeType ? [ selector ] : selector ),
			all = jQuery.merge( this.get(), set );

		return this.pushStack( isDisconnected( set[0] ) || isDisconnected( all[0] ) ?
			all :
			jQuery.unique( all ) );
	},

	addBack: function( selector ) {
		return this.add( selector == null ?
			this.prevObject : this.prevObject.filter(selector)
		);
	}
});

jQuery.fn.andSelf = jQuery.fn.addBack;

// A painfully simple check to see if an element is disconnected
// from a document (should be improved, where feasible).
function isDisconnected( node ) {
	return !node || !node.parentNode || node.parentNode.nodeType === 11;
}

function sibling( cur, dir ) {
	do {
		cur = cur[ dir ];
	} while ( cur && cur.nodeType !== 1 );

	return cur;
}

jQuery.each({
	parent: function( elem ) {
		var parent = elem.parentNode;
		return parent && parent.nodeType !== 11 ? parent : null;
	},
	parents: function( elem ) {
		return jQuery.dir( elem, "parentNode" );
	},
	parentsUntil: function( elem, i, until ) {
		return jQuery.dir( elem, "parentNode", until );
	},
	next: function( elem ) {
		return sibling( elem, "nextSibling" );
	},
	prev: function( elem ) {
		return sibling( elem, "previousSibling" );
	},
	nextAll: function( elem ) {
		return jQuery.dir( elem, "nextSibling" );
	},
	prevAll: function( elem ) {
		return jQuery.dir( elem, "previousSibling" );
	},
	nextUntil: function( elem, i, until ) {
		return jQuery.dir( elem, "nextSibling", until );
	},
	prevUntil: function( elem, i, until ) {
		return jQuery.dir( elem, "previousSibling", until );
	},
	siblings: function( elem ) {
		return jQuery.sibling( ( elem.parentNode || {} ).firstChild, elem );
	},
	children: function( elem ) {
		return jQuery.sibling( elem.firstChild );
	},
	contents: function( elem ) {
		return jQuery.nodeName( elem, "iframe" ) ?
			elem.contentDocument || elem.contentWindow.document :
			jQuery.merge( [], elem.childNodes );
	}
}, function( name, fn ) {
	jQuery.fn[ name ] = function( until, selector ) {
		var ret = jQuery.map( this, fn, until );

		if ( !runtil.test( name ) ) {
			selector = until;
		}

		if ( selector && typeof selector === "string" ) {
			ret = jQuery.filter( selector, ret );
		}

		ret = this.length > 1 && !guaranteedUnique[ name ] ? jQuery.unique( ret ) : ret;

		if ( this.length > 1 && rparentsprev.test( name ) ) {
			ret = ret.reverse();
		}

		return this.pushStack( ret, name, core_slice.call( arguments ).join(",") );
	};
});

jQuery.extend({
	filter: function( expr, elems, not ) {
		if ( not ) {
			expr = ":not(" + expr + ")";
		}

		return elems.length === 1 ?
			jQuery.find.matchesSelector(elems[0], expr) ? [ elems[0] ] : [] :
			jQuery.find.matches(expr, elems);
	},

	dir: function( elem, dir, until ) {
		var matched = [],
			cur = elem[ dir ];

		while ( cur && cur.nodeType !== 9 && (until === undefined || cur.nodeType !== 1 || !jQuery( cur ).is( until )) ) {
			if ( cur.nodeType === 1 ) {
				matched.push( cur );
			}
			cur = cur[dir];
		}
		return matched;
	},

	sibling: function( n, elem ) {
		var r = [];

		for ( ; n; n = n.nextSibling ) {
			if ( n.nodeType === 1 && n !== elem ) {
				r.push( n );
			}
		}

		return r;
	}
});

// Implement the identical functionality for filter and not
function winnow( elements, qualifier, keep ) {

	// Can't pass null or undefined to indexOf in Firefox 4
	// Set to 0 to skip string check
	qualifier = qualifier || 0;

	if ( jQuery.isFunction( qualifier ) ) {
		return jQuery.grep(elements, function( elem, i ) {
			var retVal = !!qualifier.call( elem, i, elem );
			return retVal === keep;
		});

	} else if ( qualifier.nodeType ) {
		return jQuery.grep(elements, function( elem, i ) {
			return ( elem === qualifier ) === keep;
		});

	} else if ( typeof qualifier === "string" ) {
		var filtered = jQuery.grep(elements, function( elem ) {
			return elem.nodeType === 1;
		});

		if ( isSimple.test( qualifier ) ) {
			return jQuery.filter(qualifier, filtered, !keep);
		} else {
			qualifier = jQuery.filter( qualifier, filtered );
		}
	}

	return jQuery.grep(elements, function( elem, i ) {
		return ( jQuery.inArray( elem, qualifier ) >= 0 ) === keep;
	});
}
function createSafeFragment( document ) {
	var list = nodeNames.split( "|" ),
	safeFrag = document.createDocumentFragment();

	if ( safeFrag.createElement ) {
		while ( list.length ) {
			safeFrag.createElement(
				list.pop()
			);
		}
	}
	return safeFrag;
}

var nodeNames = "abbr|article|aside|audio|bdi|canvas|data|datalist|details|figcaption|figure|footer|" +
		"header|hgroup|mark|meter|nav|output|progress|section|summary|time|video",
	rinlinejQuery = / jQuery\d+="(?:null|\d+)"/g,
	rleadingWhitespace = /^\s+/,
	rxhtmlTag = /<(?!area|br|col|embed|hr|img|input|link|meta|param)(([\w:]+)[^>]*)\/>/gi,
	rtagName = /<([\w:]+)/,
	rtbody = /<tbody/i,
	rhtml = /<|&#?\w+;/,
	rnoInnerhtml = /<(?:script|style|link)/i,
	rnocache = /<(?:script|object|embed|option|style)/i,
	rnoshimcache = new RegExp("<(?:" + nodeNames + ")[\\s/>]", "i"),
	rcheckableType = /^(?:checkbox|radio)$/,
	// checked="checked" or checked
	rchecked = /checked\s*(?:[^=]|=\s*.checked.)/i,
	rscriptType = /\/(java|ecma)script/i,
	rcleanScript = /^\s*<!(?:\[CDATA\[|\-\-)|[\]\-]{2}>\s*$/g,
	wrapMap = {
		option: [ 1, "<select multiple='multiple'>", "</select>" ],
		legend: [ 1, "<fieldset>", "</fieldset>" ],
		thead: [ 1, "<table>", "</table>" ],
		tr: [ 2, "<table><tbody>", "</tbody></table>" ],
		td: [ 3, "<table><tbody><tr>", "</tr></tbody></table>" ],
		col: [ 2, "<table><tbody></tbody><colgroup>", "</colgroup></table>" ],
		area: [ 1, "<map>", "</map>" ],
		_default: [ 0, "", "" ]
	},
	safeFragment = createSafeFragment( document ),
	fragmentDiv = safeFragment.appendChild( document.createElement("div") );

wrapMap.optgroup = wrapMap.option;
wrapMap.tbody = wrapMap.tfoot = wrapMap.colgroup = wrapMap.caption = wrapMap.thead;
wrapMap.th = wrapMap.td;

// IE6-8 can't serialize link, script, style, or any html5 (NoScope) tags,
// unless wrapped in a div with non-breaking characters in front of it.
if ( !jQuery.support.htmlSerialize ) {
	wrapMap._default = [ 1, "X<div>", "</div>" ];
}

jQuery.fn.extend({
	text: function( value ) {
		return jQuery.access( this, function( value ) {
			return value === undefined ?
				jQuery.text( this ) :
				this.empty().append( ( this[0] && this[0].ownerDocument || document ).createTextNode( value ) );
		}, null, value, arguments.length );
	},

	wrapAll: function( html ) {
		if ( jQuery.isFunction( html ) ) {
			return this.each(function(i) {
				jQuery(this).wrapAll( html.call(this, i) );
			});
		}

		if ( this[0] ) {
			// The elements to wrap the target around
			var wrap = jQuery( html, this[0].ownerDocument ).eq(0).clone(true);

			if ( this[0].parentNode ) {
				wrap.insertBefore( this[0] );
			}

			wrap.map(function() {
				var elem = this;

				while ( elem.firstChild && elem.firstChild.nodeType === 1 ) {
					elem = elem.firstChild;
				}

				return elem;
			}).append( this );
		}

		return this;
	},

	wrapInner: function( html ) {
		if ( jQuery.isFunction( html ) ) {
			return this.each(function(i) {
				jQuery(this).wrapInner( html.call(this, i) );
			});
		}

		return this.each(function() {
			var self = jQuery( this ),
				contents = self.contents();

			if ( contents.length ) {
				contents.wrapAll( html );

			} else {
				self.append( html );
			}
		});
	},

	wrap: function( html ) {
		var isFunction = jQuery.isFunction( html );

		return this.each(function(i) {
			jQuery( this ).wrapAll( isFunction ? html.call(this, i) : html );
		});
	},

	unwrap: function() {
		return this.parent().each(function() {
			if ( !jQuery.nodeName( this, "body" ) ) {
				jQuery( this ).replaceWith( this.childNodes );
			}
		}).end();
	},

	append: function() {
		return this.domManip(arguments, true, function( elem ) {
			if ( this.nodeType === 1 || this.nodeType === 11 ) {
				this.appendChild( elem );
			}
		});
	},

	prepend: function() {
		return this.domManip(arguments, true, function( elem ) {
			if ( this.nodeType === 1 || this.nodeType === 11 ) {
				this.insertBefore( elem, this.firstChild );
			}
		});
	},

	before: function() {
		if ( !isDisconnected( this[0] ) ) {
			return this.domManip(arguments, false, function( elem ) {
				this.parentNode.insertBefore( elem, this );
			});
		}

		if ( arguments.length ) {
			var set = jQuery.clean( arguments );
			return this.pushStack( jQuery.merge( set, this ), "before", this.selector );
		}
	},

	after: function() {
		if ( !isDisconnected( this[0] ) ) {
			return this.domManip(arguments, false, function( elem ) {
				this.parentNode.insertBefore( elem, this.nextSibling );
			});
		}

		if ( arguments.length ) {
			var set = jQuery.clean( arguments );
			return this.pushStack( jQuery.merge( this, set ), "after", this.selector );
		}
	},

	// keepData is for internal use only--do not document
	remove: function( selector, keepData ) {
		var elem,
			i = 0;

		for ( ; (elem = this[i]) != null; i++ ) {
			if ( !selector || jQuery.filter( selector, [ elem ] ).length ) {
				if ( !keepData && elem.nodeType === 1 ) {
					jQuery.cleanData( elem.getElementsByTagName("*") );
					jQuery.cleanData( [ elem ] );
				}

				if ( elem.parentNode ) {
					elem.parentNode.removeChild( elem );
				}
			}
		}

		return this;
	},

	empty: function() {
		var elem,
			i = 0;

		for ( ; (elem = this[i]) != null; i++ ) {
			// Remove element nodes and prevent memory leaks
			if ( elem.nodeType === 1 ) {
				jQuery.cleanData( elem.getElementsByTagName("*") );
			}

			// Remove any remaining nodes
			while ( elem.firstChild ) {
				elem.removeChild( elem.firstChild );
			}
		}

		return this;
	},

	clone: function( dataAndEvents, deepDataAndEvents ) {
		dataAndEvents = dataAndEvents == null ? false : dataAndEvents;
		deepDataAndEvents = deepDataAndEvents == null ? dataAndEvents : deepDataAndEvents;

		return this.map( function () {
			return jQuery.clone( this, dataAndEvents, deepDataAndEvents );
		});
	},

	html: function( value ) {
		return jQuery.access( this, function( value ) {
			var elem = this[0] || {},
				i = 0,
				l = this.length;

			if ( value === undefined ) {
				return elem.nodeType === 1 ?
					elem.innerHTML.replace( rinlinejQuery, "" ) :
					undefined;
			}

			// See if we can take a shortcut and just use innerHTML
			if ( typeof value === "string" && !rnoInnerhtml.test( value ) &&
				( jQuery.support.htmlSerialize || !rnoshimcache.test( value )  ) &&
				( jQuery.support.leadingWhitespace || !rleadingWhitespace.test( value ) ) &&
				!wrapMap[ ( rtagName.exec( value ) || ["", ""] )[1].toLowerCase() ] ) {

				value = value.replace( rxhtmlTag, "<$1></$2>" );

				try {
					for (; i < l; i++ ) {
						// Remove element nodes and prevent memory leaks
						elem = this[i] || {};
						if ( elem.nodeType === 1 ) {
							jQuery.cleanData( elem.getElementsByTagName( "*" ) );
							elem.innerHTML = value;
						}
					}

					elem = 0;

				// If using innerHTML throws an exception, use the fallback method
				} catch(e) {}
			}

			if ( elem ) {
				this.empty().append( value );
			}
		}, null, value, arguments.length );
	},

	replaceWith: function( value ) {
		if ( !isDisconnected( this[0] ) ) {
			// Make sure that the elements are removed from the DOM before they are inserted
			// this can help fix replacing a parent with child elements
			if ( jQuery.isFunction( value ) ) {
				return this.each(function(i) {
					var self = jQuery(this), old = self.html();
					self.replaceWith( value.call( this, i, old ) );
				});
			}

			if ( typeof value !== "string" ) {
				value = jQuery( value ).detach();
			}

			return this.each(function() {
				var next = this.nextSibling,
					parent = this.parentNode;

				jQuery( this ).remove();

				if ( next ) {
					jQuery(next).before( value );
				} else {
					jQuery(parent).append( value );
				}
			});
		}

		return this.length ?
			this.pushStack( jQuery(jQuery.isFunction(value) ? value() : value), "replaceWith", value ) :
			this;
	},

	detach: function( selector ) {
		return this.remove( selector, true );
	},

	domManip: function( args, table, callback ) {

		// Flatten any nested arrays
		args = [].concat.apply( [], args );

		var results, first, fragment, iNoClone,
			i = 0,
			value = args[0],
			scripts = [],
			l = this.length;

		// We can't cloneNode fragments that contain checked, in WebKit
		if ( !jQuery.support.checkClone && l > 1 && typeof value === "string" && rchecked.test( value ) ) {
			return this.each(function() {
				jQuery(this).domManip( args, table, callback );
			});
		}

		if ( jQuery.isFunction(value) ) {
			return this.each(function(i) {
				var self = jQuery(this);
				args[0] = value.call( this, i, table ? self.html() : undefined );
				self.domManip( args, table, callback );
			});
		}

		if ( this[0] ) {
			results = jQuery.buildFragment( args, this, scripts );
			fragment = results.fragment;
			first = fragment.firstChild;

			if ( fragment.childNodes.length === 1 ) {
				fragment = first;
			}

			if ( first ) {
				table = table && jQuery.nodeName( first, "tr" );

				// Use the original fragment for the last item instead of the first because it can end up
				// being emptied incorrectly in certain situations (#8070).
				// Fragments from the fragment cache must always be cloned and never used in place.
				for ( iNoClone = results.cacheable || l - 1; i < l; i++ ) {
					callback.call(
						table && jQuery.nodeName( this[i], "table" ) ?
							findOrAppend( this[i], "tbody" ) :
							this[i],
						i === iNoClone ?
							fragment :
							jQuery.clone( fragment, true, true )
					);
				}
			}

			// Fix #11809: Avoid leaking memory
			fragment = first = null;

			if ( scripts.length ) {
				jQuery.each( scripts, function( i, elem ) {
					if ( elem.src ) {
						if ( jQuery.ajax ) {
							jQuery.ajax({
								url: elem.src,
								type: "GET",
								dataType: "script",
								async: false,
								global: false,
								"throws": true
							});
						} else {
							jQuery.error("no ajax");
						}
					} else {
						jQuery.globalEval( ( elem.text || elem.textContent || elem.innerHTML || "" ).replace( rcleanScript, "" ) );
					}

					if ( elem.parentNode ) {
						elem.parentNode.removeChild( elem );
					}
				});
			}
		}

		return this;
	}
});

function findOrAppend( elem, tag ) {
	return elem.getElementsByTagName( tag )[0] || elem.appendChild( elem.ownerDocument.createElement( tag ) );
}

function cloneCopyEvent( src, dest ) {

	if ( dest.nodeType !== 1 || !jQuery.hasData( src ) ) {
		return;
	}

	var type, i, l,
		oldData = jQuery._data( src ),
		curData = jQuery._data( dest, oldData ),
		events = oldData.events;

	if ( events ) {
		delete curData.handle;
		curData.events = {};

		for ( type in events ) {
			for ( i = 0, l = events[ type ].length; i < l; i++ ) {
				jQuery.event.add( dest, type, events[ type ][ i ] );
			}
		}
	}

	// make the cloned public data object a copy from the original
	if ( curData.data ) {
		curData.data = jQuery.extend( {}, curData.data );
	}
}

function cloneFixAttributes( src, dest ) {
	var nodeName;

	// We do not need to do anything for non-Elements
	if ( dest.nodeType !== 1 ) {
		return;
	}

	// clearAttributes removes the attributes, which we don't want,
	// but also removes the attachEvent events, which we *do* want
	if ( dest.clearAttributes ) {
		dest.clearAttributes();
	}

	// mergeAttributes, in contrast, only merges back on the
	// original attributes, not the events
	if ( dest.mergeAttributes ) {
		dest.mergeAttributes( src );
	}

	nodeName = dest.nodeName.toLowerCase();

	if ( nodeName === "object" ) {
		// IE6-10 improperly clones children of object elements using classid.
		// IE10 throws NoModificationAllowedError if parent is null, #12132.
		if ( dest.parentNode ) {
			dest.outerHTML = src.outerHTML;
		}

		// This path appears unavoidable for IE9. When cloning an object
		// element in IE9, the outerHTML strategy above is not sufficient.
		// If the src has innerHTML and the destination does not,
		// copy the src.innerHTML into the dest.innerHTML. #10324
		if ( jQuery.support.html5Clone && (src.innerHTML && !jQuery.trim(dest.innerHTML)) ) {
			dest.innerHTML = src.innerHTML;
		}

	} else if ( nodeName === "input" && rcheckableType.test( src.type ) ) {
		// IE6-8 fails to persist the checked state of a cloned checkbox
		// or radio button. Worse, IE6-7 fail to give the cloned element
		// a checked appearance if the defaultChecked value isn't also set

		dest.defaultChecked = dest.checked = src.checked;

		// IE6-7 get confused and end up setting the value of a cloned
		// checkbox/radio button to an empty string instead of "on"
		if ( dest.value !== src.value ) {
			dest.value = src.value;
		}

	// IE6-8 fails to return the selected option to the default selected
	// state when cloning options
	} else if ( nodeName === "option" ) {
		dest.selected = src.defaultSelected;

	// IE6-8 fails to set the defaultValue to the correct value when
	// cloning other types of input fields
	} else if ( nodeName === "input" || nodeName === "textarea" ) {
		dest.defaultValue = src.defaultValue;

	// IE blanks contents when cloning scripts
	} else if ( nodeName === "script" && dest.text !== src.text ) {
		dest.text = src.text;
	}

	// Event data gets referenced instead of copied if the expando
	// gets copied too
	dest.removeAttribute( jQuery.expando );
}

jQuery.buildFragment = function( args, context, scripts ) {
	var fragment, cacheable, cachehit,
		first = args[ 0 ];

	// Set context from what may come in as undefined or a jQuery collection or a node
	// Updated to fix #12266 where accessing context[0] could throw an exception in IE9/10 &
	// also doubles as fix for #8950 where plain objects caused createDocumentFragment exception
	context = context || document;
	context = !context.nodeType && context[0] || context;
	context = context.ownerDocument || context;

	// Only cache "small" (1/2 KB) HTML strings that are associated with the main document
	// Cloning options loses the selected state, so don't cache them
	// IE 6 doesn't like it when you put <object> or <embed> elements in a fragment
	// Also, WebKit does not clone 'checked' attributes on cloneNode, so don't cache
	// Lastly, IE6,7,8 will not correctly reuse cached fragments that were created from unknown elems #10501
	if ( args.length === 1 && typeof first === "string" && first.length < 512 && context === document &&
		first.charAt(0) === "<" && !rnocache.test( first ) &&
		(jQuery.support.checkClone || !rchecked.test( first )) &&
		(jQuery.support.html5Clone || !rnoshimcache.test( first )) ) {

		// Mark cacheable and look for a hit
		cacheable = true;
		fragment = jQuery.fragments[ first ];
		cachehit = fragment !== undefined;
	}

	if ( !fragment ) {
		fragment = context.createDocumentFragment();
		jQuery.clean( args, context, fragment, scripts );

		// Update the cache, but only store false
		// unless this is a second parsing of the same content
		if ( cacheable ) {
			jQuery.fragments[ first ] = cachehit && fragment;
		}
	}

	return { fragment: fragment, cacheable: cacheable };
};

jQuery.fragments = {};

jQuery.each({
	appendTo: "append",
	prependTo: "prepend",
	insertBefore: "before",
	insertAfter: "after",
	replaceAll: "replaceWith"
}, function( name, original ) {
	jQuery.fn[ name ] = function( selector ) {
		var elems,
			i = 0,
			ret = [],
			insert = jQuery( selector ),
			l = insert.length,
			parent = this.length === 1 && this[0].parentNode;

		if ( (parent == null || parent && parent.nodeType === 11 && parent.childNodes.length === 1) && l === 1 ) {
			insert[ original ]( this[0] );
			return this;
		} else {
			for ( ; i < l; i++ ) {
				elems = ( i > 0 ? this.clone(true) : this ).get();
				jQuery( insert[i] )[ original ]( elems );
				ret = ret.concat( elems );
			}

			return this.pushStack( ret, name, insert.selector );
		}
	};
});

function getAll( elem ) {
	if ( typeof elem.getElementsByTagName !== "undefined" ) {
		return elem.getElementsByTagName( "*" );

	} else if ( typeof elem.querySelectorAll !== "undefined" ) {
		return elem.querySelectorAll( "*" );

	} else {
		return [];
	}
}

// Used in clean, fixes the defaultChecked property
function fixDefaultChecked( elem ) {
	if ( rcheckableType.test( elem.type ) ) {
		elem.defaultChecked = elem.checked;
	}
}

jQuery.extend({
	clone: function( elem, dataAndEvents, deepDataAndEvents ) {
		var srcElements,
			destElements,
			i,
			clone;

		if ( jQuery.support.html5Clone || jQuery.isXMLDoc(elem) || !rnoshimcache.test( "<" + elem.nodeName + ">" ) ) {
			clone = elem.cloneNode( true );

		// IE<=8 does not properly clone detached, unknown element nodes
		} else {
			fragmentDiv.innerHTML = elem.outerHTML;
			fragmentDiv.removeChild( clone = fragmentDiv.firstChild );
		}

		if ( (!jQuery.support.noCloneEvent || !jQuery.support.noCloneChecked) &&
				(elem.nodeType === 1 || elem.nodeType === 11) && !jQuery.isXMLDoc(elem) ) {
			// IE copies events bound via attachEvent when using cloneNode.
			// Calling detachEvent on the clone will also remove the events
			// from the original. In order to get around this, we use some
			// proprietary methods to clear the events. Thanks to MooTools
			// guys for this hotness.

			cloneFixAttributes( elem, clone );

			// Using Sizzle here is crazy slow, so we use getElementsByTagName instead
			srcElements = getAll( elem );
			destElements = getAll( clone );

			// Weird iteration because IE will replace the length property
			// with an element if you are cloning the body and one of the
			// elements on the page has a name or id of "length"
			for ( i = 0; srcElements[i]; ++i ) {
				// Ensure that the destination node is not null; Fixes #9587
				if ( destElements[i] ) {
					cloneFixAttributes( srcElements[i], destElements[i] );
				}
			}
		}

		// Copy the events from the original to the clone
		if ( dataAndEvents ) {
			cloneCopyEvent( elem, clone );

			if ( deepDataAndEvents ) {
				srcElements = getAll( elem );
				destElements = getAll( clone );

				for ( i = 0; srcElements[i]; ++i ) {
					cloneCopyEvent( srcElements[i], destElements[i] );
				}
			}
		}

		srcElements = destElements = null;

		// Return the cloned set
		return clone;
	},

	clean: function( elems, context, fragment, scripts ) {
		var i, j, elem, tag, wrap, depth, div, hasBody, tbody, len, handleScript, jsTags,
			safe = context === document && safeFragment,
			ret = [];

		// Ensure that context is a document
		if ( !context || typeof context.createDocumentFragment === "undefined" ) {
			context = document;
		}

		// Use the already-created safe fragment if context permits
		for ( i = 0; (elem = elems[i]) != null; i++ ) {
			if ( typeof elem === "number" ) {
				elem += "";
			}

			if ( !elem ) {
				continue;
			}

			// Convert html string into DOM nodes
			if ( typeof elem === "string" ) {
				if ( !rhtml.test( elem ) ) {
					elem = context.createTextNode( elem );
				} else {
					// Ensure a safe container in which to render the html
					safe = safe || createSafeFragment( context );
					div = context.createElement("div");
					safe.appendChild( div );

					// Fix "XHTML"-style tags in all browsers
					elem = elem.replace(rxhtmlTag, "<$1></$2>");

					// Go to html and back, then peel off extra wrappers
					tag = ( rtagName.exec( elem ) || ["", ""] )[1].toLowerCase();
					wrap = wrapMap[ tag ] || wrapMap._default;
					depth = wrap[0];
					div.innerHTML = wrap[1] + elem + wrap[2];

					// Move to the right depth
					while ( depth-- ) {
						div = div.lastChild;
					}

					// Remove IE's autoinserted <tbody> from table fragments
					if ( !jQuery.support.tbody ) {

						// String was a <table>, *may* have spurious <tbody>
						hasBody = rtbody.test(elem);
							tbody = tag === "table" && !hasBody ?
								div.firstChild && div.firstChild.childNodes :

								// String was a bare <thead> or <tfoot>
								wrap[1] === "<table>" && !hasBody ?
									div.childNodes :
									[];

						for ( j = tbody.length - 1; j >= 0 ; --j ) {
							if ( jQuery.nodeName( tbody[ j ], "tbody" ) && !tbody[ j ].childNodes.length ) {
								tbody[ j ].parentNode.removeChild( tbody[ j ] );
							}
						}
					}

					// IE completely kills leading whitespace when innerHTML is used
					if ( !jQuery.support.leadingWhitespace && rleadingWhitespace.test( elem ) ) {
						div.insertBefore( context.createTextNode( rleadingWhitespace.exec(elem)[0] ), div.firstChild );
					}

					elem = div.childNodes;

					// Take out of fragment container (we need a fresh div each time)
					div.parentNode.removeChild( div );
				}
			}

			if ( elem.nodeType ) {
				ret.push( elem );
			} else {
				jQuery.merge( ret, elem );
			}
		}

		// Fix #11356: Clear elements from safeFragment
		if ( div ) {
			elem = div = safe = null;
		}

		// Reset defaultChecked for any radios and checkboxes
		// about to be appended to the DOM in IE 6/7 (#8060)
		if ( !jQuery.support.appendChecked ) {
			for ( i = 0; (elem = ret[i]) != null; i++ ) {
				if ( jQuery.nodeName( elem, "input" ) ) {
					fixDefaultChecked( elem );
				} else if ( typeof elem.getElementsByTagName !== "undefined" ) {
					jQuery.grep( elem.getElementsByTagName("input"), fixDefaultChecked );
				}
			}
		}

		// Append elements to a provided document fragment
		if ( fragment ) {
			// Special handling of each script element
			handleScript = function( elem ) {
				// Check if we consider it executable
				if ( !elem.type || rscriptType.test( elem.type ) ) {
					// Detach the script and store it in the scripts array (if provided) or the fragment
					// Return truthy to indicate that it has been handled
					return scripts ?
						scripts.push( elem.parentNode ? elem.parentNode.removeChild( elem ) : elem ) :
						fragment.appendChild( elem );
				}
			};

			for ( i = 0; (elem = ret[i]) != null; i++ ) {
				// Check if we're done after handling an executable script
				if ( !( jQuery.nodeName( elem, "script" ) && handleScript( elem ) ) ) {
					// Append to fragment and handle embedded scripts
					fragment.appendChild( elem );
					if ( typeof elem.getElementsByTagName !== "undefined" ) {
						// handleScript alters the DOM, so use jQuery.merge to ensure snapshot iteration
						jsTags = jQuery.grep( jQuery.merge( [], elem.getElementsByTagName("script") ), handleScript );

						// Splice the scripts into ret after their former ancestor and advance our index beyond them
						ret.splice.apply( ret, [i + 1, 0].concat( jsTags ) );
						i += jsTags.length;
					}
				}
			}
		}

		return ret;
	},

	cleanData: function( elems, /* internal */ acceptData ) {
		var data, id, elem, type,
			i = 0,
			internalKey = jQuery.expando,
			cache = jQuery.cache,
			deleteExpando = jQuery.support.deleteExpando,
			special = jQuery.event.special;

		for ( ; (elem = elems[i]) != null; i++ ) {

			if ( acceptData || jQuery.acceptData( elem ) ) {

				id = elem[ internalKey ];
				data = id && cache[ id ];

				if ( data ) {
					if ( data.events ) {
						for ( type in data.events ) {
							if ( special[ type ] ) {
								jQuery.event.remove( elem, type );

							// This is a shortcut to avoid jQuery.event.remove's overhead
							} else {
								jQuery.removeEvent( elem, type, data.handle );
							}
						}
					}

					// Remove cache only if it was not already removed by jQuery.event.remove
					if ( cache[ id ] ) {

						delete cache[ id ];

						// IE does not allow us to delete expando properties from nodes,
						// nor does it have a removeAttribute function on Document nodes;
						// we must handle all of these cases
						if ( deleteExpando ) {
							delete elem[ internalKey ];

						} else if ( elem.removeAttribute ) {
							elem.removeAttribute( internalKey );

						} else {
							elem[ internalKey ] = null;
						}

						jQuery.deletedIds.push( id );
					}
				}
			}
		}
	}
});
// Limit scope pollution from any deprecated API
(function() {

var matched, browser;

// Use of jQuery.browser is frowned upon.
// More details: http://api.jquery.com/jQuery.browser
// jQuery.uaMatch maintained for back-compat
jQuery.uaMatch = function( ua ) {
	ua = ua.toLowerCase();

	var match = /(chrome)[ \/]([\w.]+)/.exec( ua ) ||
		/(webkit)[ \/]([\w.]+)/.exec( ua ) ||
		/(opera)(?:.*version|)[ \/]([\w.]+)/.exec( ua ) ||
		/(msie) ([\w.]+)/.exec( ua ) ||
		ua.indexOf("compatible") < 0 && /(mozilla)(?:.*? rv:([\w.]+)|)/.exec( ua ) ||
		[];

	return {
		browser: match[ 1 ] || "",
		version: match[ 2 ] || "0"
	};
};

matched = jQuery.uaMatch( navigator.userAgent );
browser = {};

if ( matched.browser ) {
	browser[ matched.browser ] = true;
	browser.version = matched.version;
}

// Chrome is Webkit, but Webkit is also Safari.
if ( browser.chrome ) {
	browser.webkit = true;
} else if ( browser.webkit ) {
	browser.safari = true;
}

jQuery.browser = browser;

jQuery.sub = function() {
	function jQuerySub( selector, context ) {
		return new jQuerySub.fn.init( selector, context );
	}
	jQuery.extend( true, jQuerySub, this );
	jQuerySub.superclass = this;
	jQuerySub.fn = jQuerySub.prototype = this();
	jQuerySub.fn.constructor = jQuerySub;
	jQuerySub.sub = this.sub;
	jQuerySub.fn.init = function init( selector, context ) {
		if ( context && context instanceof jQuery && !(context instanceof jQuerySub) ) {
			context = jQuerySub( context );
		}

		return jQuery.fn.init.call( this, selector, context, rootjQuerySub );
	};
	jQuerySub.fn.init.prototype = jQuerySub.fn;
	var rootjQuerySub = jQuerySub(document);
	return jQuerySub;
};

})();
var curCSS, iframe, iframeDoc,
	ralpha = /alpha\([^)]*\)/i,
	ropacity = /opacity=([^)]*)/,
	rposition = /^(top|right|bottom|left)$/,
	// swappable if display is none or starts with table except "table", "table-cell", or "table-caption"
	// see here for display values: https://developer.mozilla.org/en-US/docs/CSS/display
	rdisplayswap = /^(none|table(?!-c[ea]).+)/,
	rmargin = /^margin/,
	rnumsplit = new RegExp( "^(" + core_pnum + ")(.*)$", "i" ),
	rnumnonpx = new RegExp( "^(" + core_pnum + ")(?!px)[a-z%]+$", "i" ),
	rrelNum = new RegExp( "^([-+])=(" + core_pnum + ")", "i" ),
	elemdisplay = {},

	cssShow = { position: "absolute", visibility: "hidden", display: "block" },
	cssNormalTransform = {
		letterSpacing: 0,
		fontWeight: 400
	},

	cssExpand = [ "Top", "Right", "Bottom", "Left" ],
	cssPrefixes = [ "Webkit", "O", "Moz", "ms" ],

	eventsToggle = jQuery.fn.toggle;

// return a css property mapped to a potentially vendor prefixed property
function vendorPropName( style, name ) {

	// shortcut for names that are not vendor prefixed
	if ( name in style ) {
		return name;
	}

	// check for vendor prefixed names
	var capName = name.charAt(0).toUpperCase() + name.slice(1),
		origName = name,
		i = cssPrefixes.length;

	while ( i-- ) {
		name = cssPrefixes[ i ] + capName;
		if ( name in style ) {
			return name;
		}
	}

	return origName;
}

function isHidden( elem, el ) {
	elem = el || elem;
	return jQuery.css( elem, "display" ) === "none" || !jQuery.contains( elem.ownerDocument, elem );
}

function showHide( elements, show ) {
	var elem, display,
		values = [],
		index = 0,
		length = elements.length;

	for ( ; index < length; index++ ) {
		elem = elements[ index ];
		if ( !elem.style ) {
			continue;
		}
		values[ index ] = jQuery._data( elem, "olddisplay" );
		if ( show ) {
			// Reset the inline display of this element to learn if it is
			// being hidden by cascaded rules or not
			if ( !values[ index ] && elem.style.display === "none" ) {
				elem.style.display = "";
			}

			// Set elements which have been overridden with display: none
			// in a stylesheet to whatever the default browser style is
			// for such an element
			if ( elem.style.display === "" && isHidden( elem ) ) {
				values[ index ] = jQuery._data( elem, "olddisplay", css_defaultDisplay(elem.nodeName) );
			}
		} else {
			display = curCSS( elem, "display" );

			if ( !values[ index ] && display !== "none" ) {
				jQuery._data( elem, "olddisplay", display );
			}
		}
	}

	// Set the display of most of the elements in a second loop
	// to avoid the constant reflow
	for ( index = 0; index < length; index++ ) {
		elem = elements[ index ];
		if ( !elem.style ) {
			continue;
		}
		if ( !show || elem.style.display === "none" || elem.style.display === "" ) {
			elem.style.display = show ? values[ index ] || "" : "none";
		}
	}

	return elements;
}

jQuery.fn.extend({
	css: function( name, value ) {
		return jQuery.access( this, function( elem, name, value ) {
			return value !== undefined ?
				jQuery.style( elem, name, value ) :
				jQuery.css( elem, name );
		}, name, value, arguments.length > 1 );
	},
	show: function() {
		return showHide( this, true );
	},
	hide: function() {
		return showHide( this );
	},
	toggle: function( state, fn2 ) {
		var bool = typeof state === "boolean";

		if ( jQuery.isFunction( state ) && jQuery.isFunction( fn2 ) ) {
			return eventsToggle.apply( this, arguments );
		}

		return this.each(function() {
			if ( bool ? state : isHidden( this ) ) {
				jQuery( this ).show();
			} else {
				jQuery( this ).hide();
			}
		});
	}
});

jQuery.extend({
	// Add in style property hooks for overriding the default
	// behavior of getting and setting a style property
	cssHooks: {
		opacity: {
			get: function( elem, computed ) {
				if ( computed ) {
					// We should always get a number back from opacity
					var ret = curCSS( elem, "opacity" );
					return ret === "" ? "1" : ret;

				}
			}
		}
	},

	// Exclude the following css properties to add px
	cssNumber: {
		"fillOpacity": true,
		"fontWeight": true,
		"lineHeight": true,
		"opacity": true,
		"orphans": true,
		"widows": true,
		"zIndex": true,
		"zoom": true
	},

	// Add in properties whose names you wish to fix before
	// setting or getting the value
	cssProps: {
		// normalize float css property
		"float": jQuery.support.cssFloat ? "cssFloat" : "styleFloat"
	},

	// Get and set the style property on a DOM Node
	style: function( elem, name, value, extra ) {
		// Don't set styles on text and comment nodes
		if ( !elem || elem.nodeType === 3 || elem.nodeType === 8 || !elem.style ) {
			return;
		}

		// Make sure that we're working with the right name
		var ret, type, hooks,
			origName = jQuery.camelCase( name ),
			style = elem.style;

		name = jQuery.cssProps[ origName ] || ( jQuery.cssProps[ origName ] = vendorPropName( style, origName ) );

		// gets hook for the prefixed version
		// followed by the unprefixed version
		hooks = jQuery.cssHooks[ name ] || jQuery.cssHooks[ origName ];

		// Check if we're setting a value
		if ( value !== undefined ) {
			type = typeof value;

			// convert relative number strings (+= or -=) to relative numbers. #7345
			if ( type === "string" && (ret = rrelNum.exec( value )) ) {
				value = ( ret[1] + 1 ) * ret[2] + parseFloat( jQuery.css( elem, name ) );
				// Fixes bug #9237
				type = "number";
			}

			// Make sure that NaN and null values aren't set. See: #7116
			if ( value == null || type === "number" && isNaN( value ) ) {
				return;
			}

			// If a number was passed in, add 'px' to the (except for certain CSS properties)
			if ( type === "number" && !jQuery.cssNumber[ origName ] ) {
				value += "px";
			}

			// If a hook was provided, use that value, otherwise just set the specified value
			if ( !hooks || !("set" in hooks) || (value = hooks.set( elem, value, extra )) !== undefined ) {
				// Wrapped to prevent IE from throwing errors when 'invalid' values are provided
				// Fixes bug #5509
				try {
					style[ name ] = value;
				} catch(e) {}
			}

		} else {
			// If a hook was provided get the non-computed value from there
			if ( hooks && "get" in hooks && (ret = hooks.get( elem, false, extra )) !== undefined ) {
				return ret;
			}

			// Otherwise just get the value from the style object
			return style[ name ];
		}
	},

	css: function( elem, name, numeric, extra ) {
		var val, num, hooks,
			origName = jQuery.camelCase( name );

		// Make sure that we're working with the right name
		name = jQuery.cssProps[ origName ] || ( jQuery.cssProps[ origName ] = vendorPropName( elem.style, origName ) );

		// gets hook for the prefixed version
		// followed by the unprefixed version
		hooks = jQuery.cssHooks[ name ] || jQuery.cssHooks[ origName ];

		// If a hook was provided get the computed value from there
		if ( hooks && "get" in hooks ) {
			val = hooks.get( elem, true, extra );
		}

		// Otherwise, if a way to get the computed value exists, use that
		if ( val === undefined ) {
			val = curCSS( elem, name );
		}

		//convert "normal" to computed value
		if ( val === "normal" && name in cssNormalTransform ) {
			val = cssNormalTransform[ name ];
		}

		// Return, converting to number if forced or a qualifier was provided and val looks numeric
		if ( numeric || extra !== undefined ) {
			num = parseFloat( val );
			return numeric || jQuery.isNumeric( num ) ? num || 0 : val;
		}
		return val;
	},

	// A method for quickly swapping in/out CSS properties to get correct calculations
	swap: function( elem, options, callback ) {
		var ret, name,
			old = {};

		// Remember the old values, and insert the new ones
		for ( name in options ) {
			old[ name ] = elem.style[ name ];
			elem.style[ name ] = options[ name ];
		}

		ret = callback.call( elem );

		// Revert the old values
		for ( name in options ) {
			elem.style[ name ] = old[ name ];
		}

		return ret;
	}
});

// NOTE: To any future maintainer, we've window.getComputedStyle
// because jsdom on node.js will break without it.
if ( window.getComputedStyle ) {
	curCSS = function( elem, name ) {
		var ret, width, minWidth, maxWidth,
			computed = window.getComputedStyle( elem, null ),
			style = elem.style;

		if ( computed ) {

			ret = computed[ name ];
			if ( ret === "" && !jQuery.contains( elem.ownerDocument, elem ) ) {
				ret = jQuery.style( elem, name );
			}

			// A tribute to the "awesome hack by Dean Edwards"
			// Chrome < 17 and Safari 5.0 uses "computed value" instead of "used value" for margin-right
			// Safari 5.1.7 (at least) returns percentage for a larger set of values, but width seems to be reliably pixels
			// this is against the CSSOM draft spec: http://dev.w3.org/csswg/cssom/#resolved-values
			if ( rnumnonpx.test( ret ) && rmargin.test( name ) ) {
				width = style.width;
				minWidth = style.minWidth;
				maxWidth = style.maxWidth;

				style.minWidth = style.maxWidth = style.width = ret;
				ret = computed.width;

				style.width = width;
				style.minWidth = minWidth;
				style.maxWidth = maxWidth;
			}
		}

		return ret;
	};
} else if ( document.documentElement.currentStyle ) {
	curCSS = function( elem, name ) {
		var left, rsLeft,
			ret = elem.currentStyle && elem.currentStyle[ name ],
			style = elem.style;

		// Avoid setting ret to empty string here
		// so we don't default to auto
		if ( ret == null && style && style[ name ] ) {
			ret = style[ name ];
		}

		// From the awesome hack by Dean Edwards
		// http://erik.eae.net/archives/2007/07/27/18.54.15/#comment-102291

		// If we're not dealing with a regular pixel number
		// but a number that has a weird ending, we need to convert it to pixels
		// but not position css attributes, as those are proportional to the parent element instead
		// and we can't measure the parent instead because it might trigger a "stacking dolls" problem
		if ( rnumnonpx.test( ret ) && !rposition.test( name ) ) {

			// Remember the original values
			left = style.left;
			rsLeft = elem.runtimeStyle && elem.runtimeStyle.left;

			// Put in the new values to get a computed value out
			if ( rsLeft ) {
				elem.runtimeStyle.left = elem.currentStyle.left;
			}
			style.left = name === "fontSize" ? "1em" : ret;
			ret = style.pixelLeft + "px";

			// Revert the changed values
			style.left = left;
			if ( rsLeft ) {
				elem.runtimeStyle.left = rsLeft;
			}
		}

		return ret === "" ? "auto" : ret;
	};
}

function setPositiveNumber( elem, value, subtract ) {
	var matches = rnumsplit.exec( value );
	return matches ?
			Math.max( 0, matches[ 1 ] - ( subtract || 0 ) ) + ( matches[ 2 ] || "px" ) :
			value;
}

function augmentWidthOrHeight( elem, name, extra, isBorderBox ) {
	var i = extra === ( isBorderBox ? "border" : "content" ) ?
		// If we already have the right measurement, avoid augmentation
		4 :
		// Otherwise initialize for horizontal or vertical properties
		name === "width" ? 1 : 0,

		val = 0;

	for ( ; i < 4; i += 2 ) {
		// both box models exclude margin, so add it if we want it
		if ( extra === "margin" ) {
			// we use jQuery.css instead of curCSS here
			// because of the reliableMarginRight CSS hook!
			val += jQuery.css( elem, extra + cssExpand[ i ], true );
		}

		// From this point on we use curCSS for maximum performance (relevant in animations)
		if ( isBorderBox ) {
			// border-box includes padding, so remove it if we want content
			if ( extra === "content" ) {
				val -= parseFloat( curCSS( elem, "padding" + cssExpand[ i ] ) ) || 0;
			}

			// at this point, extra isn't border nor margin, so remove border
			if ( extra !== "margin" ) {
				val -= parseFloat( curCSS( elem, "border" + cssExpand[ i ] + "Width" ) ) || 0;
			}
		} else {
			// at this point, extra isn't content, so add padding
			val += parseFloat( curCSS( elem, "padding" + cssExpand[ i ] ) ) || 0;

			// at this point, extra isn't content nor padding, so add border
			if ( extra !== "padding" ) {
				val += parseFloat( curCSS( elem, "border" + cssExpand[ i ] + "Width" ) ) || 0;
			}
		}
	}

	return val;
}

function getWidthOrHeight( elem, name, extra ) {

	// Start with offset property, which is equivalent to the border-box value
	var val = name === "width" ? elem.offsetWidth : elem.offsetHeight,
		valueIsBorderBox = true,
		isBorderBox = jQuery.support.boxSizing && jQuery.css( elem, "boxSizing" ) === "border-box";

	// some non-html elements return undefined for offsetWidth, so check for null/undefined
	// svg - https://bugzilla.mozilla.org/show_bug.cgi?id=649285
	// MathML - https://bugzilla.mozilla.org/show_bug.cgi?id=491668
	if ( val <= 0 || val == null ) {
		// Fall back to computed then uncomputed css if necessary
		val = curCSS( elem, name );
		if ( val < 0 || val == null ) {
			val = elem.style[ name ];
		}

		// Computed unit is not pixels. Stop here and return.
		if ( rnumnonpx.test(val) ) {
			return val;
		}

		// we need the check for style in case a browser which returns unreliable values
		// for getComputedStyle silently falls back to the reliable elem.style
		valueIsBorderBox = isBorderBox && ( jQuery.support.boxSizingReliable || val === elem.style[ name ] );

		// Normalize "", auto, and prepare for extra
		val = parseFloat( val ) || 0;
	}

	// use the active box-sizing model to add/subtract irrelevant styles
	return ( val +
		augmentWidthOrHeight(
			elem,
			name,
			extra || ( isBorderBox ? "border" : "content" ),
			valueIsBorderBox
		)
	) + "px";
}


// Try to determine the default display value of an element
function css_defaultDisplay( nodeName ) {
	if ( elemdisplay[ nodeName ] ) {
		return elemdisplay[ nodeName ];
	}

	var elem = jQuery( "<" + nodeName + ">" ).appendTo( document.body ),
		display = elem.css("display");
	elem.remove();

	// If the simple way fails,
	// get element's real default display by attaching it to a temp iframe
	if ( display === "none" || display === "" ) {
		// Use the already-created iframe if possible
		iframe = document.body.appendChild(
			iframe || jQuery.extend( document.createElement("iframe"), {
				frameBorder: 0,
				width: 0,
				height: 0
			})
		);

		// Create a cacheable copy of the iframe document on first call.
		// IE and Opera will allow us to reuse the iframeDoc without re-writing the fake HTML
		// document to it; WebKit & Firefox won't allow reusing the iframe document.
		if ( !iframeDoc || !iframe.createElement ) {
			iframeDoc = ( iframe.contentWindow || iframe.contentDocument ).document;
			iframeDoc.write("<!doctype html><html><body>");
			iframeDoc.close();
		}

		elem = iframeDoc.body.appendChild( iframeDoc.createElement(nodeName) );

		display = curCSS( elem, "display" );
		document.body.removeChild( iframe );
	}

	// Store the correct default display
	elemdisplay[ nodeName ] = display;

	return display;
}

jQuery.each([ "height", "width" ], function( i, name ) {
	jQuery.cssHooks[ name ] = {
		get: function( elem, computed, extra ) {
			if ( computed ) {
				// certain elements can have dimension info if we invisibly show them
				// however, it must have a current display style that would benefit from this
				if ( elem.offsetWidth === 0 && rdisplayswap.test( curCSS( elem, "display" ) ) ) {
					return jQuery.swap( elem, cssShow, function() {
						return getWidthOrHeight( elem, name, extra );
					});
				} else {
					return getWidthOrHeight( elem, name, extra );
				}
			}
		},

		set: function( elem, value, extra ) {
			return setPositiveNumber( elem, value, extra ?
				augmentWidthOrHeight(
					elem,
					name,
					extra,
					jQuery.support.boxSizing && jQuery.css( elem, "boxSizing" ) === "border-box"
				) : 0
			);
		}
	};
});

if ( !jQuery.support.opacity ) {
	jQuery.cssHooks.opacity = {
		get: function( elem, computed ) {
			// IE uses filters for opacity
			return ropacity.test( (computed && elem.currentStyle ? elem.currentStyle.filter : elem.style.filter) || "" ) ?
				( 0.01 * parseFloat( RegExp.$1 ) ) + "" :
				computed ? "1" : "";
		},

		set: function( elem, value ) {
			var style = elem.style,
				currentStyle = elem.currentStyle,
				opacity = jQuery.isNumeric( value ) ? "alpha(opacity=" + value * 100 + ")" : "",
				filter = currentStyle && currentStyle.filter || style.filter || "";

			// IE has trouble with opacity if it does not have layout
			// Force it by setting the zoom level
			style.zoom = 1;

			// if setting opacity to 1, and no other filters exist - attempt to remove filter attribute #6652
			if ( value >= 1 && jQuery.trim( filter.replace( ralpha, "" ) ) === "" &&
				style.removeAttribute ) {

				// Setting style.filter to null, "" & " " still leave "filter:" in the cssText
				// if "filter:" is present at all, clearType is disabled, we want to avoid this
				// style.removeAttribute is IE Only, but so apparently is this code path...
				style.removeAttribute( "filter" );

				// if there there is no filter style applied in a css rule, we are done
				if ( currentStyle && !currentStyle.filter ) {
					return;
				}
			}

			// otherwise, set new filter values
			style.filter = ralpha.test( filter ) ?
				filter.replace( ralpha, opacity ) :
				filter + " " + opacity;
		}
	};
}

// These hooks cannot be added until DOM ready because the support test
// for it is not run until after DOM ready
jQuery(function() {
	if ( !jQuery.support.reliableMarginRight ) {
		jQuery.cssHooks.marginRight = {
			get: function( elem, computed ) {
				// WebKit Bug 13343 - getComputedStyle returns wrong value for margin-right
				// Work around by temporarily setting element display to inline-block
				return jQuery.swap( elem, { "display": "inline-block" }, function() {
					if ( computed ) {
						return curCSS( elem, "marginRight" );
					}
				});
			}
		};
	}

	// Webkit bug: https://bugs.webkit.org/show_bug.cgi?id=29084
	// getComputedStyle returns percent when specified for top/left/bottom/right
	// rather than make the css module depend on the offset module, we just check for it here
	if ( !jQuery.support.pixelPosition && jQuery.fn.position ) {
		jQuery.each( [ "top", "left" ], function( i, prop ) {
			jQuery.cssHooks[ prop ] = {
				get: function( elem, computed ) {
					if ( computed ) {
						var ret = curCSS( elem, prop );
						// if curCSS returns percentage, fallback to offset
						return rnumnonpx.test( ret ) ? jQuery( elem ).position()[ prop ] + "px" : ret;
					}
				}
			};
		});
	}

});

if ( jQuery.expr && jQuery.expr.filters ) {
	jQuery.expr.filters.hidden = function( elem ) {
		return ( elem.offsetWidth === 0 && elem.offsetHeight === 0 ) || (!jQuery.support.reliableHiddenOffsets && ((elem.style && elem.style.display) || curCSS( elem, "display" )) === "none");
	};

	jQuery.expr.filters.visible = function( elem ) {
		return !jQuery.expr.filters.hidden( elem );
	};
}

// These hooks are used by animate to expand properties
jQuery.each({
	margin: "",
	padding: "",
	border: "Width"
}, function( prefix, suffix ) {
	jQuery.cssHooks[ prefix + suffix ] = {
		expand: function( value ) {
			var i,

				// assumes a single number if not a string
				parts = typeof value === "string" ? value.split(" ") : [ value ],
				expanded = {};

			for ( i = 0; i < 4; i++ ) {
				expanded[ prefix + cssExpand[ i ] + suffix ] =
					parts[ i ] || parts[ i - 2 ] || parts[ 0 ];
			}

			return expanded;
		}
	};

	if ( !rmargin.test( prefix ) ) {
		jQuery.cssHooks[ prefix + suffix ].set = setPositiveNumber;
	}
});
var r20 = /%20/g,
	rbracket = /\[\]$/,
	rCRLF = /\r?\n/g,
	rinput = /^(?:color|date|datetime|datetime-local|email|hidden|month|number|password|range|search|tel|text|time|url|week)$/i,
	rselectTextarea = /^(?:select|textarea)/i;

jQuery.fn.extend({
	serialize: function() {
		return jQuery.param( this.serializeArray() );
	},
	serializeArray: function() {
		return this.map(function(){
			return this.elements ? jQuery.makeArray( this.elements ) : this;
		})
		.filter(function(){
			return this.name && !this.disabled &&
				( this.checked || rselectTextarea.test( this.nodeName ) ||
					rinput.test( this.type ) );
		})
		.map(function( i, elem ){
			var val = jQuery( this ).val();

			return val == null ?
				null :
				jQuery.isArray( val ) ?
					jQuery.map( val, function( val, i ){
						return { name: elem.name, value: val.replace( rCRLF, "\r\n" ) };
					}) :
					{ name: elem.name, value: val.replace( rCRLF, "\r\n" ) };
		}).get();
	}
});

//Serialize an array of form elements or a set of
//key/values into a query string
jQuery.param = function( a, traditional ) {
	var prefix,
		s = [],
		add = function( key, value ) {
			// If value is a function, invoke it and return its value
			value = jQuery.isFunction( value ) ? value() : ( value == null ? "" : value );
			s[ s.length ] = encodeURIComponent( key ) + "=" + encodeURIComponent( value );
		};

	// Set traditional to true for jQuery <= 1.3.2 behavior.
	if ( traditional === undefined ) {
		traditional = jQuery.ajaxSettings && jQuery.ajaxSettings.traditional;
	}

	// If an array was passed in, assume that it is an array of form elements.
	if ( jQuery.isArray( a ) || ( a.jquery && !jQuery.isPlainObject( a ) ) ) {
		// Serialize the form elements
		jQuery.each( a, function() {
			add( this.name, this.value );
		});

	} else {
		// If traditional, encode the "old" way (the way 1.3.2 or older
		// did it), otherwise encode params recursively.
		for ( prefix in a ) {
			buildParams( prefix, a[ prefix ], traditional, add );
		}
	}

	// Return the resulting serialization
	return s.join( "&" ).replace( r20, "+" );
};

function buildParams( prefix, obj, traditional, add ) {
	var name;

	if ( jQuery.isArray( obj ) ) {
		// Serialize array item.
		jQuery.each( obj, function( i, v ) {
			if ( traditional || rbracket.test( prefix ) ) {
				// Treat each array item as a scalar.
				add( prefix, v );

			} else {
				// If array item is non-scalar (array or object), encode its
				// numeric index to resolve deserialization ambiguity issues.
				// Note that rack (as of 1.0.0) can't currently deserialize
				// nested arrays properly, and attempting to do so may cause
				// a server error. Possible fixes are to modify rack's
				// deserialization algorithm or to provide an option or flag
				// to force array serialization to be shallow.
				buildParams( prefix + "[" + ( typeof v === "object" ? i : "" ) + "]", v, traditional, add );
			}
		});

	} else if ( !traditional && jQuery.type( obj ) === "object" ) {
		// Serialize object item.
		for ( name in obj ) {
			buildParams( prefix + "[" + name + "]", obj[ name ], traditional, add );
		}

	} else {
		// Serialize scalar item.
		add( prefix, obj );
	}
}
var
	// Document location
	ajaxLocParts,
	ajaxLocation,

	rhash = /#.*$/,
	rheaders = /^(.*?):[ \t]*([^\r\n]*)\r?$/mg, // IE leaves an \r character at EOL
	// #7653, #8125, #8152: local protocol detection
	rlocalProtocol = /^(?:about|app|app\-storage|.+\-extension|file|res|widget):$/,
	rnoContent = /^(?:GET|HEAD)$/,
	rprotocol = /^\/\//,
	rquery = /\?/,
	rscript = /<script\b[^<]*(?:(?!<\/script>)<[^<]*)*<\/script>/gi,
	rts = /([?&])_=[^&]*/,
	rurl = /^([\w\+\.\-]+:)(?:\/\/([^\/?#:]*)(?::(\d+)|)|)/,

	// Keep a copy of the old load method
	_load = jQuery.fn.load,

	/* Prefilters
	 * 1) They are useful to introduce custom dataTypes (see ajax/jsonp.js for an example)
	 * 2) These are called:
	 *    - BEFORE asking for a transport
	 *    - AFTER param serialization (s.data is a string if s.processData is true)
	 * 3) key is the dataType
	 * 4) the catchall symbol "*" can be used
	 * 5) execution will start with transport dataType and THEN continue down to "*" if needed
	 */
	prefilters = {},

	/* Transports bindings
	 * 1) key is the dataType
	 * 2) the catchall symbol "*" can be used
	 * 3) selection will start with transport dataType and THEN go to "*" if needed
	 */
	transports = {},

	// Avoid comment-prolog char sequence (#10098); must appease lint and evade compression
	allTypes = ["*/"] + ["*"];

// #8138, IE may throw an exception when accessing
// a field from window.location if document.domain has been set
try {
	ajaxLocation = location.href;
} catch( e ) {
	// Use the href attribute of an A element
	// since IE will modify it given document.location
	ajaxLocation = document.createElement( "a" );
	ajaxLocation.href = "";
	ajaxLocation = ajaxLocation.href;
}

// Segment location into parts
ajaxLocParts = rurl.exec( ajaxLocation.toLowerCase() ) || [];

// Base "constructor" for jQuery.ajaxPrefilter and jQuery.ajaxTransport
function addToPrefiltersOrTransports( structure ) {

	// dataTypeExpression is optional and defaults to "*"
	return function( dataTypeExpression, func ) {

		if ( typeof dataTypeExpression !== "string" ) {
			func = dataTypeExpression;
			dataTypeExpression = "*";
		}

		var dataType, list, placeBefore,
			dataTypes = dataTypeExpression.toLowerCase().split( core_rspace ),
			i = 0,
			length = dataTypes.length;

		if ( jQuery.isFunction( func ) ) {
			// For each dataType in the dataTypeExpression
			for ( ; i < length; i++ ) {
				dataType = dataTypes[ i ];
				// We control if we're asked to add before
				// any existing element
				placeBefore = /^\+/.test( dataType );
				if ( placeBefore ) {
					dataType = dataType.substr( 1 ) || "*";
				}
				list = structure[ dataType ] = structure[ dataType ] || [];
				// then we add to the structure accordingly
				list[ placeBefore ? "unshift" : "push" ]( func );
			}
		}
	};
}

// Base inspection function for prefilters and transports
function inspectPrefiltersOrTransports( structure, options, originalOptions, jqXHR,
		dataType /* internal */, inspected /* internal */ ) {

	dataType = dataType || options.dataTypes[ 0 ];
	inspected = inspected || {};

	inspected[ dataType ] = true;

	var selection,
		list = structure[ dataType ],
		i = 0,
		length = list ? list.length : 0,
		executeOnly = ( structure === prefilters );

	for ( ; i < length && ( executeOnly || !selection ); i++ ) {
		selection = list[ i ]( options, originalOptions, jqXHR );
		// If we got redirected to another dataType
		// we try there if executing only and not done already
		if ( typeof selection === "string" ) {
			if ( !executeOnly || inspected[ selection ] ) {
				selection = undefined;
			} else {
				options.dataTypes.unshift( selection );
				selection = inspectPrefiltersOrTransports(
						structure, options, originalOptions, jqXHR, selection, inspected );
			}
		}
	}
	// If we're only executing or nothing was selected
	// we try the catchall dataType if not done already
	if ( ( executeOnly || !selection ) && !inspected[ "*" ] ) {
		selection = inspectPrefiltersOrTransports(
				structure, options, originalOptions, jqXHR, "*", inspected );
	}
	// unnecessary when only executing (prefilters)
	// but it'll be ignored by the caller in that case
	return selection;
}

// A special extend for ajax options
// that takes "flat" options (not to be deep extended)
// Fixes #9887
function ajaxExtend( target, src ) {
	var key, deep,
		flatOptions = jQuery.ajaxSettings.flatOptions || {};
	for ( key in src ) {
		if ( src[ key ] !== undefined ) {
			( flatOptions[ key ] ? target : ( deep || ( deep = {} ) ) )[ key ] = src[ key ];
		}
	}
	if ( deep ) {
		jQuery.extend( true, target, deep );
	}
}

jQuery.fn.load = function( url, params, callback ) {
	if ( typeof url !== "string" && _load ) {
		return _load.apply( this, arguments );
	}

	// Don't do a request if no elements are being requested
	if ( !this.length ) {
		return this;
	}

	var selector, type, response,
		self = this,
		off = url.indexOf(" ");

	if ( off >= 0 ) {
		selector = url.slice( off, url.length );
		url = url.slice( 0, off );
	}

	// If it's a function
	if ( jQuery.isFunction( params ) ) {

		// We assume that it's the callback
		callback = params;
		params = undefined;

	// Otherwise, build a param string
	} else if ( params && typeof params === "object" ) {
		type = "POST";
	}

	// Request the remote document
	jQuery.ajax({
		url: url,

		// if "type" variable is undefined, then "GET" method will be used
		type: type,
		dataType: "html",
		data: params,
		complete: function( jqXHR, status ) {
			if ( callback ) {
				self.each( callback, response || [ jqXHR.responseText, status, jqXHR ] );
			}
		}
	}).done(function( responseText ) {

		// Save response for use in complete callback
		response = arguments;

		// See if a selector was specified
		self.html( selector ?

			// Create a dummy div to hold the results
			jQuery("<div>")

				// inject the contents of the document in, removing the scripts
				// to avoid any 'Permission Denied' errors in IE
				.append( responseText.replace( rscript, "" ) )

				// Locate the specified elements
				.find( selector ) :

			// If not, just inject the full result
			responseText );

	});

	return this;
};

// Attach a bunch of functions for handling common AJAX events
jQuery.each( "ajaxStart ajaxStop ajaxComplete ajaxError ajaxSuccess ajaxSend".split( " " ), function( i, o ){
	jQuery.fn[ o ] = function( f ){
		return this.on( o, f );
	};
});

jQuery.each( [ "get", "post" ], function( i, method ) {
	jQuery[ method ] = function( url, data, callback, type ) {
		// shift arguments if data argument was omitted
		if ( jQuery.isFunction( data ) ) {
			type = type || callback;
			callback = data;
			data = undefined;
		}

		return jQuery.ajax({
			type: method,
			url: url,
			data: data,
			success: callback,
			dataType: type
		});
	};
});

jQuery.extend({

	getScript: function( url, callback ) {
		return jQuery.get( url, undefined, callback, "script" );
	},

	getJSON: function( url, data, callback ) {
		return jQuery.get( url, data, callback, "json" );
	},

	// Creates a full fledged settings object into target
	// with both ajaxSettings and settings fields.
	// If target is omitted, writes into ajaxSettings.
	ajaxSetup: function( target, settings ) {
		if ( settings ) {
			// Building a settings object
			ajaxExtend( target, jQuery.ajaxSettings );
		} else {
			// Extending ajaxSettings
			settings = target;
			target = jQuery.ajaxSettings;
		}
		ajaxExtend( target, settings );
		return target;
	},

	ajaxSettings: {
		url: ajaxLocation,
		isLocal: rlocalProtocol.test( ajaxLocParts[ 1 ] ),
		global: true,
		type: "GET",
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		processData: true,
		async: true,
		/*
		timeout: 0,
		data: null,
		dataType: null,
		username: null,
		password: null,
		cache: null,
		throws: false,
		traditional: false,
		headers: {},
		*/

		accepts: {
			xml: "application/xml, text/xml",
			html: "text/html",
			text: "text/plain",
			json: "application/json, text/javascript",
			"*": allTypes
		},

		contents: {
			xml: /xml/,
			html: /html/,
			json: /json/
		},

		responseFields: {
			xml: "responseXML",
			text: "responseText"
		},

		// List of data converters
		// 1) key format is "source_type destination_type" (a single space in-between)
		// 2) the catchall symbol "*" can be used for source_type
		converters: {

			// Convert anything to text
			"* text": window.String,

			// Text to html (true = no transformation)
			"text html": true,

			// Evaluate text as a json expression
			"text json": jQuery.parseJSON,

			// Parse text as xml
			"text xml": jQuery.parseXML
		},

		// For options that shouldn't be deep extended:
		// you can add your own custom options here if
		// and when you create one that shouldn't be
		// deep extended (see ajaxExtend)
		flatOptions: {
			context: true,
			url: true
		}
	},

	ajaxPrefilter: addToPrefiltersOrTransports( prefilters ),
	ajaxTransport: addToPrefiltersOrTransports( transports ),

	// Main method
	ajax: function( url, options ) {

		// If url is an object, simulate pre-1.5 signature
		if ( typeof url === "object" ) {
			options = url;
			url = undefined;
		}

		// Force options to be an object
		options = options || {};

		var // ifModified key
			ifModifiedKey,
			// Response headers
			responseHeadersString,
			responseHeaders,
			// transport
			transport,
			// timeout handle
			timeoutTimer,
			// Cross-domain detection vars
			parts,
			// To know if global events are to be dispatched
			fireGlobals,
			// Loop variable
			i,
			// Create the final options object
			s = jQuery.ajaxSetup( {}, options ),
			// Callbacks context
			callbackContext = s.context || s,
			// Context for global events
			// It's the callbackContext if one was provided in the options
			// and if it's a DOM node or a jQuery collection
			globalEventContext = callbackContext !== s &&
				( callbackContext.nodeType || callbackContext instanceof jQuery ) ?
						jQuery( callbackContext ) : jQuery.event,
			// Deferreds
			deferred = jQuery.Deferred(),
			completeDeferred = jQuery.Callbacks( "once memory" ),
			// Status-dependent callbacks
			statusCode = s.statusCode || {},
			// Headers (they are sent all at once)
			requestHeaders = {},
			requestHeadersNames = {},
			// The jqXHR state
			state = 0,
			// Default abort message
			strAbort = "canceled",
			// Fake xhr
			jqXHR = {

				readyState: 0,

				// Caches the header
				setRequestHeader: function( name, value ) {
					if ( !state ) {
						var lname = name.toLowerCase();
						name = requestHeadersNames[ lname ] = requestHeadersNames[ lname ] || name;
						requestHeaders[ name ] = value;
					}
					return this;
				},

				// Raw string
				getAllResponseHeaders: function() {
					return state === 2 ? responseHeadersString : null;
				},

				// Builds headers hashtable if needed
				getResponseHeader: function( key ) {
					var match;
					if ( state === 2 ) {
						if ( !responseHeaders ) {
							responseHeaders = {};
							while( ( match = rheaders.exec( responseHeadersString ) ) ) {
								responseHeaders[ match[1].toLowerCase() ] = match[ 2 ];
							}
						}
						match = responseHeaders[ key.toLowerCase() ];
					}
					return match === undefined ? null : match;
				},

				// Overrides response content-type header
				overrideMimeType: function( type ) {
					if ( !state ) {
						s.mimeType = type;
					}
					return this;
				},

				// Cancel the request
				abort: function( statusText ) {
					statusText = statusText || strAbort;
					if ( transport ) {
						transport.abort( statusText );
					}
					done( 0, statusText );
					return this;
				}
			};

		// Callback for when everything is done
		// It is defined here because jslint complains if it is declared
		// at the end of the function (which would be more logical and readable)
		function done( status, nativeStatusText, responses, headers ) {
			var isSuccess, success, error, response, modified,
				statusText = nativeStatusText;

			// Called once
			if ( state === 2 ) {
				return;
			}

			// State is "done" now
			state = 2;

			// Clear timeout if it exists
			if ( timeoutTimer ) {
				clearTimeout( timeoutTimer );
			}

			// Dereference transport for early garbage collection
			// (no matter how long the jqXHR object will be used)
			transport = undefined;

			// Cache response headers
			responseHeadersString = headers || "";

			// Set readyState
			jqXHR.readyState = status > 0 ? 4 : 0;

			// Get response data
			if ( responses ) {
				response = ajaxHandleResponses( s, jqXHR, responses );
			}

			// If successful, handle type chaining
			if ( status >= 200 && status < 300 || status === 304 ) {

				// Set the If-Modified-Since and/or If-None-Match header, if in ifModified mode.
				if ( s.ifModified ) {

					modified = jqXHR.getResponseHeader("Last-Modified");
					if ( modified ) {
						jQuery.lastModified[ ifModifiedKey ] = modified;
					}
					modified = jqXHR.getResponseHeader("Etag");
					if ( modified ) {
						jQuery.etag[ ifModifiedKey ] = modified;
					}
				}

				// If not modified
				if ( status === 304 ) {

					statusText = "notmodified";
					isSuccess = true;

				// If we have data
				} else {

					isSuccess = ajaxConvert( s, response );
					statusText = isSuccess.state;
					success = isSuccess.data;
					error = isSuccess.error;
					isSuccess = !error;
				}
			} else {
				// We extract error from statusText
				// then normalize statusText and status for non-aborts
				error = statusText;
				if ( !statusText || status ) {
					statusText = "error";
					if ( status < 0 ) {
						status = 0;
					}
				}
			}

			// Set data for the fake xhr object
			jqXHR.status = status;
			jqXHR.statusText = ( nativeStatusText || statusText ) + "";

			// Success/Error
			if ( isSuccess ) {
				deferred.resolveWith( callbackContext, [ success, statusText, jqXHR ] );
			} else {
				deferred.rejectWith( callbackContext, [ jqXHR, statusText, error ] );
			}

			// Status-dependent callbacks
			jqXHR.statusCode( statusCode );
			statusCode = undefined;

			if ( fireGlobals ) {
				globalEventContext.trigger( "ajax" + ( isSuccess ? "Success" : "Error" ),
						[ jqXHR, s, isSuccess ? success : error ] );
			}

			// Complete
			completeDeferred.fireWith( callbackContext, [ jqXHR, statusText ] );

			if ( fireGlobals ) {
				globalEventContext.trigger( "ajaxComplete", [ jqXHR, s ] );
				// Handle the global AJAX counter
				if ( !( --jQuery.active ) ) {
					jQuery.event.trigger( "ajaxStop" );
				}
			}
		}

		// Attach deferreds
		deferred.promise( jqXHR );
		jqXHR.success = jqXHR.done;
		jqXHR.error = jqXHR.fail;
		jqXHR.complete = completeDeferred.add;

		// Status-dependent callbacks
		jqXHR.statusCode = function( map ) {
			if ( map ) {
				var tmp;
				if ( state < 2 ) {
					for ( tmp in map ) {
						statusCode[ tmp ] = [ statusCode[tmp], map[tmp] ];
					}
				} else {
					tmp = map[ jqXHR.status ];
					jqXHR.always( tmp );
				}
			}
			return this;
		};

		// Remove hash character (#7531: and string promotion)
		// Add protocol if not provided (#5866: IE7 issue with protocol-less urls)
		// We also use the url parameter if available
		s.url = ( ( url || s.url ) + "" ).replace( rhash, "" ).replace( rprotocol, ajaxLocParts[ 1 ] + "//" );

		// Extract dataTypes list
		s.dataTypes = jQuery.trim( s.dataType || "*" ).toLowerCase().split( core_rspace );

		// A cross-domain request is in order when we have a protocol:host:port mismatch
		if ( s.crossDomain == null ) {
			parts = rurl.exec( s.url.toLowerCase() ) || false;
			s.crossDomain = parts && ( parts.join(":") + ( parts[ 3 ] ? "" : parts[ 1 ] === "http:" ? 80 : 443 ) ) !==
				( ajaxLocParts.join(":") + ( ajaxLocParts[ 3 ] ? "" : ajaxLocParts[ 1 ] === "http:" ? 80 : 443 ) );
		}

		// Convert data if not already a string
		if ( s.data && s.processData && typeof s.data !== "string" ) {
			s.data = jQuery.param( s.data, s.traditional );
		}

		// Apply prefilters
		inspectPrefiltersOrTransports( prefilters, s, options, jqXHR );

		// If request was aborted inside a prefilter, stop there
		if ( state === 2 ) {
			return jqXHR;
		}

		// We can fire global events as of now if asked to
		fireGlobals = s.global;

		// Uppercase the type
		s.type = s.type.toUpperCase();

		// Determine if request has content
		s.hasContent = !rnoContent.test( s.type );

		// Watch for a new set of requests
		if ( fireGlobals && jQuery.active++ === 0 ) {
			jQuery.event.trigger( "ajaxStart" );
		}

		// More options handling for requests with no content
		if ( !s.hasContent ) {

			// If data is available, append data to url
			if ( s.data ) {
				s.url += ( rquery.test( s.url ) ? "&" : "?" ) + s.data;
				// #9682: remove data so that it's not used in an eventual retry
				delete s.data;
			}

			// Get ifModifiedKey before adding the anti-cache parameter
			ifModifiedKey = s.url;

			// Add anti-cache in url if needed
			if ( s.cache === false ) {

				var ts = jQuery.now(),
					// try replacing _= if it is there
					ret = s.url.replace( rts, "$1_=" + ts );

				// if nothing was replaced, add timestamp to the end
				s.url = ret + ( ( ret === s.url ) ? ( rquery.test( s.url ) ? "&" : "?" ) + "_=" + ts : "" );
			}
		}

		// Set the correct header, if data is being sent
		if ( s.data && s.hasContent && s.contentType !== false || options.contentType ) {
			jqXHR.setRequestHeader( "Content-Type", s.contentType );
		}

		// Set the If-Modified-Since and/or If-None-Match header, if in ifModified mode.
		if ( s.ifModified ) {
			ifModifiedKey = ifModifiedKey || s.url;
			if ( jQuery.lastModified[ ifModifiedKey ] ) {
				jqXHR.setRequestHeader( "If-Modified-Since", jQuery.lastModified[ ifModifiedKey ] );
			}
			if ( jQuery.etag[ ifModifiedKey ] ) {
				jqXHR.setRequestHeader( "If-None-Match", jQuery.etag[ ifModifiedKey ] );
			}
		}

		// Set the Accepts header for the server, depending on the dataType
		jqXHR.setRequestHeader(
			"Accept",
			s.dataTypes[ 0 ] && s.accepts[ s.dataTypes[0] ] ?
				s.accepts[ s.dataTypes[0] ] + ( s.dataTypes[ 0 ] !== "*" ? ", " + allTypes + "; q=0.01" : "" ) :
				s.accepts[ "*" ]
		);

		// Check for headers option
		for ( i in s.headers ) {
			jqXHR.setRequestHeader( i, s.headers[ i ] );
		}

		// Allow custom headers/mimetypes and early abort
		if ( s.beforeSend && ( s.beforeSend.call( callbackContext, jqXHR, s ) === false || state === 2 ) ) {
				// Abort if not done already and return
				return jqXHR.abort();

		}

		// aborting is no longer a cancellation
		strAbort = "abort";

		// Install callbacks on deferreds
		for ( i in { success: 1, error: 1, complete: 1 } ) {
			jqXHR[ i ]( s[ i ] );
		}

		// Get transport
		transport = inspectPrefiltersOrTransports( transports, s, options, jqXHR );

		// If no transport, we auto-abort
		if ( !transport ) {
			done( -1, "No Transport" );
		} else {
			jqXHR.readyState = 1;
			// Send global event
			if ( fireGlobals ) {
				globalEventContext.trigger( "ajaxSend", [ jqXHR, s ] );
			}
			// Timeout
			if ( s.async && s.timeout > 0 ) {
				timeoutTimer = setTimeout( function(){
					jqXHR.abort( "timeout" );
				}, s.timeout );
			}

			try {
				state = 1;
				transport.send( requestHeaders, done );
			} catch (e) {
				// Propagate exception as error if not done
				if ( state < 2 ) {
					done( -1, e );
				// Simply rethrow otherwise
				} else {
					throw e;
				}
			}
		}

		return jqXHR;
	},

	// Counter for holding the number of active queries
	active: 0,

	// Last-Modified header cache for next request
	lastModified: {},
	etag: {}

});

/* Handles responses to an ajax request:
 * - sets all responseXXX fields accordingly
 * - finds the right dataType (mediates between content-type and expected dataType)
 * - returns the corresponding response
 */
function ajaxHandleResponses( s, jqXHR, responses ) {
	
	var ct, type, finalDataType, firstDataType,
		contents = s.contents,
		dataTypes = s.dataTypes,
		responseFields = s.responseFields;

	// Fill responseXXX fields
	for ( type in responseFields ) {
		if ( type in responses ) {
			jqXHR[ responseFields[type] ] = responses[ type ];
		}
	}

	// Remove auto dataType and get content-type in the process
	while( dataTypes[ 0 ] === "*" ) {
		dataTypes.shift();
		if ( ct === undefined ) {
			ct = s.mimeType || jqXHR.getResponseHeader( "content-type" );
		}
	}

	// Check if we're dealing with a known content-type
	if ( ct ) {
		for ( type in contents ) {
			if ( contents[ type ] && contents[ type ].test( ct ) ) {
				dataTypes.unshift( type );
				break;
			}
		}
	}

	// Check to see if we have a response for the expected dataType
	if ( dataTypes[ 0 ] in responses ) {
		finalDataType = dataTypes[ 0 ];
	} else {
		// Try convertible dataTypes
		for ( type in responses ) {
			if ( !dataTypes[ 0 ] || s.converters[ type + " " + dataTypes[0] ] ) {
				finalDataType = type;
				break;
			}
			if ( !firstDataType ) {
				firstDataType = type;
			}
		}
		// Or just use first one
		finalDataType = finalDataType || firstDataType;
	}

	// If we found a dataType
	// We add the dataType to the list if needed
	// and return the corresponding response
	if ( finalDataType ) {
		if ( finalDataType !== dataTypes[ 0 ] ) {
			dataTypes.unshift( finalDataType );
		}
		return responses[ finalDataType ];
	}
}

// Chain conversions given the request and the original response
function ajaxConvert( s, response ) {

	var conv, conv2, current, tmp,
		// Work with a copy of dataTypes in case we need to modify it for conversion
		dataTypes = s.dataTypes.slice(),
		prev = dataTypes[ 0 ],
		converters = {},
		i = 0;

	// Apply the dataFilter if provided
	if ( s.dataFilter ) {
		response = s.dataFilter( response, s.dataType );
	}

	// Create converters map with lowercased keys
	if ( dataTypes[ 1 ] ) {
		for ( conv in s.converters ) {
			converters[ conv.toLowerCase() ] = s.converters[ conv ];
		}
	}

	// Convert to each sequential dataType, tolerating list modification
	for ( ; (current = dataTypes[++i]); ) {

		// There's only work to do if current dataType is non-auto
		if ( current !== "*" ) {

			// Convert response if prev dataType is non-auto and differs from current
			if ( prev !== "*" && prev !== current ) {

				// Seek a direct converter
				conv = converters[ prev + " " + current ] || converters[ "* " + current ];

				// If none found, seek a pair
				if ( !conv ) {
					for ( conv2 in converters ) {

						// If conv2 outputs current
						tmp = conv2.split(" ");
						if ( tmp[ 1 ] === current ) {

							// If prev can be converted to accepted input
							conv = converters[ prev + " " + tmp[ 0 ] ] ||
								converters[ "* " + tmp[ 0 ] ];
							if ( conv ) {
								// Condense equivalence converters
								if ( conv === true ) {
									conv = converters[ conv2 ];

								// Otherwise, insert the intermediate dataType
								} else if ( converters[ conv2 ] !== true ) {
									current = tmp[ 0 ];
									dataTypes.splice( i--, 0, current );
								}

								break;
							}
						}
					}
				}

				// Apply converter (if not an equivalence)
				if ( conv !== true ) {

					// Unless errors are allowed to bubble, catch and return them
					if ( conv && s["throws"] ) {
						response = conv( response );
					} else {
						try {
							response = conv( response );
						} catch ( e ) {
							return { state: "parsererror", error: conv ? e : "No conversion from " + prev + " to " + current };
						}
					}
				}
			}

			// Update prev for next iteration
			prev = current;
		}
	}

	return { state: "success", data: response };
}
var oldCallbacks = [],
	rquestion = /\?/,
	rjsonp = /(=)\?(?=&|$)|\?\?/,
	nonce = jQuery.now();

// Default jsonp settings
jQuery.ajaxSetup({
	jsonp: "callback",
	jsonpCallback: function() {
		var callback = oldCallbacks.pop() || ( jQuery.expando + "_" + ( nonce++ ) );
		this[ callback ] = true;
		return callback;
	}
});

// Detect, normalize options and install callbacks for jsonp requests
jQuery.ajaxPrefilter( "json jsonp", function( s, originalSettings, jqXHR ) {

	var callbackName, overwritten, responseContainer,
		data = s.data,
		url = s.url,
		hasCallback = s.jsonp !== false,
		replaceInUrl = hasCallback && rjsonp.test( url ),
		replaceInData = hasCallback && !replaceInUrl && typeof data === "string" &&
			!( s.contentType || "" ).indexOf("application/x-www-form-urlencoded") &&
			rjsonp.test( data );

	// Handle iff the expected data type is "jsonp" or we have a parameter to set
	if ( s.dataTypes[ 0 ] === "jsonp" || replaceInUrl || replaceInData ) {

		// Get callback name, remembering preexisting value associated with it
		callbackName = s.jsonpCallback = jQuery.isFunction( s.jsonpCallback ) ?
			s.jsonpCallback() :
			s.jsonpCallback;
		overwritten = window[ callbackName ];

		// Insert callback into url or form data
		if ( replaceInUrl ) {
			s.url = url.replace( rjsonp, "$1" + callbackName );
		} else if ( replaceInData ) {
			s.data = data.replace( rjsonp, "$1" + callbackName );
		} else if ( hasCallback ) {
			s.url += ( rquestion.test( url ) ? "&" : "?" ) + s.jsonp + "=" + callbackName;
		}

		// Use data converter to retrieve json after script execution
		s.converters["script json"] = function() {
			if ( !responseContainer ) {
				jQuery.error( callbackName + " was not called" );
			}
			return responseContainer[ 0 ];
		};

		// force json dataType
		s.dataTypes[ 0 ] = "json";

		// Install callback
		window[ callbackName ] = function() {
			responseContainer = arguments;
		};

		// Clean-up function (fires after converters)
		jqXHR.always(function() {
			// Restore preexisting value
			window[ callbackName ] = overwritten;

			// Save back as free
			if ( s[ callbackName ] ) {
				// make sure that re-using the options doesn't screw things around
				s.jsonpCallback = originalSettings.jsonpCallback;

				// save the callback name for future use
				oldCallbacks.push( callbackName );
			}

			// Call if it was a function and we have a response
			if ( responseContainer && jQuery.isFunction( overwritten ) ) {
				overwritten( responseContainer[ 0 ] );
			}

			responseContainer = overwritten = undefined;
		});

		// Delegate to script
		return "script";
	}
});
// Install script dataType
jQuery.ajaxSetup({
	accepts: {
		script: "text/javascript, application/javascript, application/ecmascript, application/x-ecmascript"
	},
	contents: {
		script: /javascript|ecmascript/
	},
	converters: {
		"text script": function( text ) {
			jQuery.globalEval( text );
			return text;
		}
	}
});

// Handle cache's special case and global
jQuery.ajaxPrefilter( "script", function( s ) {
	if ( s.cache === undefined ) {
		s.cache = false;
	}
	if ( s.crossDomain ) {
		s.type = "GET";
		s.global = false;
	}
});

// Bind script tag hack transport
jQuery.ajaxTransport( "script", function(s) {

	// This transport only deals with cross domain requests
	if ( s.crossDomain ) {

		var script,
			head = document.head || document.getElementsByTagName( "head" )[0] || document.documentElement;

		return {

			send: function( _, callback ) {

				script = document.createElement( "script" );

				script.async = "async";

				if ( s.scriptCharset ) {
					script.charset = s.scriptCharset;
				}

				script.src = s.url;

				// Attach handlers for all browsers
				script.onload = script.onreadystatechange = function( _, isAbort ) {

					if ( isAbort || !script.readyState || /loaded|complete/.test( script.readyState ) ) {

						// Handle memory leak in IE
						script.onload = script.onreadystatechange = null;

						// Remove the script
						if ( head && script.parentNode ) {
							head.removeChild( script );
						}

						// Dereference the script
						script = undefined;

						// Callback if not abort
						if ( !isAbort ) {
							callback( 200, "success" );
						}
					}
				};
				// Use insertBefore instead of appendChild  to circumvent an IE6 bug.
				// This arises when a base node is used (#2709 and #4378).
				head.insertBefore( script, head.firstChild );
			},

			abort: function() {
				if ( script ) {
					script.onload( 0, 1 );
				}
			}
		};
	}
});
var xhrCallbacks,
	// #5280: Internet Explorer will keep connections alive if we don't abort on unload
	xhrOnUnloadAbort = window.ActiveXObject ? function() {
		// Abort all pending requests
		for ( var key in xhrCallbacks ) {
			xhrCallbacks[ key ]( 0, 1 );
		}
	} : false,
	xhrId = 0;

// Functions to create xhrs
function createStandardXHR() {
	try {
		return new window.XMLHttpRequest();
	} catch( e ) {}
}

function createActiveXHR() {
	try {
		return new window.ActiveXObject( "Microsoft.XMLHTTP" );
	} catch( e ) {}
}

// Create the request object
// (This is still attached to ajaxSettings for backward compatibility)
jQuery.ajaxSettings.xhr = window.ActiveXObject ?
	/* Microsoft failed to properly
	 * implement the XMLHttpRequest in IE7 (can't request local files),
	 * so we use the ActiveXObject when it is available
	 * Additionally XMLHttpRequest can be disabled in IE7/IE8 so
	 * we need a fallback.
	 */
	function() {
		return !this.isLocal && createStandardXHR() || createActiveXHR();
	} :
	// For all other browsers, use the standard XMLHttpRequest object
	createStandardXHR;

// Determine support properties
(function( xhr ) {
	jQuery.extend( jQuery.support, {
		ajax: !!xhr,
		cors: !!xhr && ( "withCredentials" in xhr )
	});
})( jQuery.ajaxSettings.xhr() );

// Create transport if the browser can provide an xhr
if ( jQuery.support.ajax ) {

	jQuery.ajaxTransport(function( s ) {
		// Cross domain only allowed if supported through XMLHttpRequest
		if ( !s.crossDomain || jQuery.support.cors ) {

			var callback;

			return {
				send: function( headers, complete ) {

					// Get a new xhr
					var handle, i,
						xhr = s.xhr();

					// Open the socket
					// Passing null username, generates a login popup on Opera (#2865)
					if ( s.username ) {
						xhr.open( s.type, s.url, s.async, s.username, s.password );
					} else {
						xhr.open( s.type, s.url, s.async );
					}

					// Apply custom fields if provided
					if ( s.xhrFields ) {
						for ( i in s.xhrFields ) {
							xhr[ i ] = s.xhrFields[ i ];
						}
					}

					// Override mime type if needed
					if ( s.mimeType && xhr.overrideMimeType ) {
						xhr.overrideMimeType( s.mimeType );
					}

					// X-Requested-With header
					// For cross-domain requests, seeing as conditions for a preflight are
					// akin to a jigsaw puzzle, we simply never set it to be sure.
					// (it can always be set on a per-request basis or even using ajaxSetup)
					// For same-domain requests, won't change header if already provided.
					if ( !s.crossDomain && !headers["X-Requested-With"] ) {
						headers[ "X-Requested-With" ] = "XMLHttpRequest";
					}

					// Need an extra try/catch for cross domain requests in Firefox 3
					try {
						for ( i in headers ) {
							xhr.setRequestHeader( i, headers[ i ] );
						}
					} catch( _ ) {}

					// Do send the request
					// This may raise an exception which is actually
					// handled in jQuery.ajax (so no try/catch here)
					xhr.send( ( s.hasContent && s.data ) || null );

					// Listener
					callback = function( _, isAbort ) {

						var status,
							statusText,
							responseHeaders,
							responses,
							xml;

						// Firefox throws exceptions when accessing properties
						// of an xhr when a network error occurred
						// http://helpful.knobs-dials.com/index.php/Component_returned_failure_code:_0x80040111_(NS_ERROR_NOT_AVAILABLE)
						try {

							// Was never called and is aborted or complete
							if ( callback && ( isAbort || xhr.readyState === 4 ) ) {

								// Only called once
								callback = undefined;

								// Do not keep as active anymore
								if ( handle ) {
									xhr.onreadystatechange = jQuery.noop;
									if ( xhrOnUnloadAbort ) {
										delete xhrCallbacks[ handle ];
									}
								}

								// If it's an abort
								if ( isAbort ) {
									// Abort it manually if needed
									if ( xhr.readyState !== 4 ) {
										xhr.abort();
									}
								} else {
									status = xhr.status;
									responseHeaders = xhr.getAllResponseHeaders();
									responses = {};
									xml = xhr.responseXML;

									// Construct response list
									if ( xml && xml.documentElement /* #4958 */ ) {
										responses.xml = xml;
									}
									
									// When requesting binary data, IE6-9 will throw an exception
									// on any attempt to access responseText (#11426)
									try {
										responses.text = xhr.responseText;
									} catch( _ ) {
									}

									// Firefox throws an exception when accessing
									// statusText for faulty cross-domain requests
									try {
										statusText = xhr.statusText;
									} catch( e ) {
										// We normalize with Webkit giving an empty statusText
										statusText = "";
									}

									// Filter status for non standard behaviors

									// If the request is local and we have data: assume a success
									// (success with no data won't get notified, that's the best we
									// can do given current implementations)
									if ( !status && s.isLocal && !s.crossDomain ) {
										status = responses.text ? 200 : 404;
									// IE - #1450: sometimes returns 1223 when it should be 204
									} else if ( status === 1223 ) {
										status = 204;
									}
								}
							}
						} catch( firefoxAccessException ) {
							if ( !isAbort ) {
								complete( -1, firefoxAccessException );
							}
						}

						// Call complete if needed
						if ( responses ) {
							complete( status, statusText, responses, responseHeaders );
						}
					};

					if ( !s.async ) {
						// if we're in sync mode we fire the callback
						callback();
					} else if ( xhr.readyState === 4 ) {
						// (IE6 & IE7) if it's in cache and has been
						// retrieved directly we need to fire the callback
						setTimeout( callback, 0 );
					} else {
						handle = ++xhrId;
						if ( xhrOnUnloadAbort ) {
							// Create the active xhrs callbacks list if needed
							// and attach the unload handler
							if ( !xhrCallbacks ) {
								xhrCallbacks = {};
								jQuery( window ).unload( xhrOnUnloadAbort );
							}
							// Add to list of active xhrs callbacks
							xhrCallbacks[ handle ] = callback;
						}
						xhr.onreadystatechange = callback;
					}
				},

				abort: function() {
					if ( callback ) {
						callback(0,1);
					}
				}
			};
		}
	});
}
var fxNow, timerId,
	rfxtypes = /^(?:toggle|show|hide)$/,
	rfxnum = new RegExp( "^(?:([-+])=|)(" + core_pnum + ")([a-z%]*)$", "i" ),
	rrun = /queueHooks$/,
	animationPrefilters = [ defaultPrefilter ],
	tweeners = {
		"*": [function( prop, value ) {
			var end, unit,
				tween = this.createTween( prop, value ),
				parts = rfxnum.exec( value ),
				target = tween.cur(),
				start = +target || 0,
				scale = 1,
				maxIterations = 20;

			if ( parts ) {
				end = +parts[2];
				unit = parts[3] || ( jQuery.cssNumber[ prop ] ? "" : "px" );

				// We need to compute starting value
				if ( unit !== "px" && start ) {
					// Iteratively approximate from a nonzero starting point
					// Prefer the current property, because this process will be trivial if it uses the same units
					// Fallback to end or a simple constant
					start = jQuery.css( tween.elem, prop, true ) || end || 1;

					do {
						// If previous iteration zeroed out, double until we get *something*
						// Use a string for doubling factor so we don't accidentally see scale as unchanged below
						scale = scale || ".5";

						// Adjust and apply
						start = start / scale;
						jQuery.style( tween.elem, prop, start + unit );

					// Update scale, tolerating zero or NaN from tween.cur()
					// And breaking the loop if scale is unchanged or perfect, or if we've just had enough
					} while ( scale !== (scale = tween.cur() / target) && scale !== 1 && --maxIterations );
				}

				tween.unit = unit;
				tween.start = start;
				// If a +=/-= token was provided, we're doing a relative animation
				tween.end = parts[1] ? start + ( parts[1] + 1 ) * end : end;
			}
			return tween;
		}]
	};

// Animations created synchronously will run synchronously
function createFxNow() {
	setTimeout(function() {
		fxNow = undefined;
	}, 0 );
	return ( fxNow = jQuery.now() );
}

function createTweens( animation, props ) {
	jQuery.each( props, function( prop, value ) {
		var collection = ( tweeners[ prop ] || [] ).concat( tweeners[ "*" ] ),
			index = 0,
			length = collection.length;
		for ( ; index < length; index++ ) {
			if ( collection[ index ].call( animation, prop, value ) ) {

				// we're done with this property
				return;
			}
		}
	});
}

function Animation( elem, properties, options ) {
	var result,
		index = 0,
		tweenerIndex = 0,
		length = animationPrefilters.length,
		deferred = jQuery.Deferred().always( function() {
			// don't match elem in the :animated selector
			delete tick.elem;
		}),
		tick = function() {
			var currentTime = fxNow || createFxNow(),
				remaining = Math.max( 0, animation.startTime + animation.duration - currentTime ),
				percent = 1 - ( remaining / animation.duration || 0 ),
				index = 0,
				length = animation.tweens.length;

			for ( ; index < length ; index++ ) {
				animation.tweens[ index ].run( percent );
			}

			deferred.notifyWith( elem, [ animation, percent, remaining ]);

			if ( percent < 1 && length ) {
				return remaining;
			} else {
				deferred.resolveWith( elem, [ animation ] );
				return false;
			}
		},
		animation = deferred.promise({
			elem: elem,
			props: jQuery.extend( {}, properties ),
			opts: jQuery.extend( true, { specialEasing: {} }, options ),
			originalProperties: properties,
			originalOptions: options,
			startTime: fxNow || createFxNow(),
			duration: options.duration,
			tweens: [],
			createTween: function( prop, end, easing ) {
				var tween = jQuery.Tween( elem, animation.opts, prop, end,
						animation.opts.specialEasing[ prop ] || animation.opts.easing );
				animation.tweens.push( tween );
				return tween;
			},
			stop: function( gotoEnd ) {
				var index = 0,
					// if we are going to the end, we want to run all the tweens
					// otherwise we skip this part
					length = gotoEnd ? animation.tweens.length : 0;

				for ( ; index < length ; index++ ) {
					animation.tweens[ index ].run( 1 );
				}

				// resolve when we played the last frame
				// otherwise, reject
				if ( gotoEnd ) {
					deferred.resolveWith( elem, [ animation, gotoEnd ] );
				} else {
					deferred.rejectWith( elem, [ animation, gotoEnd ] );
				}
				return this;
			}
		}),
		props = animation.props;

	propFilter( props, animation.opts.specialEasing );

	for ( ; index < length ; index++ ) {
		result = animationPrefilters[ index ].call( animation, elem, props, animation.opts );
		if ( result ) {
			return result;
		}
	}

	createTweens( animation, props );

	if ( jQuery.isFunction( animation.opts.start ) ) {
		animation.opts.start.call( elem, animation );
	}

	jQuery.fx.timer(
		jQuery.extend( tick, {
			anim: animation,
			queue: animation.opts.queue,
			elem: elem
		})
	);

	// attach callbacks from options
	return animation.progress( animation.opts.progress )
		.done( animation.opts.done, animation.opts.complete )
		.fail( animation.opts.fail )
		.always( animation.opts.always );
}

function propFilter( props, specialEasing ) {
	var index, name, easing, value, hooks;

	// camelCase, specialEasing and expand cssHook pass
	for ( index in props ) {
		name = jQuery.camelCase( index );
		easing = specialEasing[ name ];
		value = props[ index ];
		if ( jQuery.isArray( value ) ) {
			easing = value[ 1 ];
			value = props[ index ] = value[ 0 ];
		}

		if ( index !== name ) {
			props[ name ] = value;
			delete props[ index ];
		}

		hooks = jQuery.cssHooks[ name ];
		if ( hooks && "expand" in hooks ) {
			value = hooks.expand( value );
			delete props[ name ];

			// not quite $.extend, this wont overwrite keys already present.
			// also - reusing 'index' from above because we have the correct "name"
			for ( index in value ) {
				if ( !( index in props ) ) {
					props[ index ] = value[ index ];
					specialEasing[ index ] = easing;
				}
			}
		} else {
			specialEasing[ name ] = easing;
		}
	}
}

jQuery.Animation = jQuery.extend( Animation, {

	tweener: function( props, callback ) {
		if ( jQuery.isFunction( props ) ) {
			callback = props;
			props = [ "*" ];
		} else {
			props = props.split(" ");
		}

		var prop,
			index = 0,
			length = props.length;

		for ( ; index < length ; index++ ) {
			prop = props[ index ];
			tweeners[ prop ] = tweeners[ prop ] || [];
			tweeners[ prop ].unshift( callback );
		}
	},

	prefilter: function( callback, prepend ) {
		if ( prepend ) {
			animationPrefilters.unshift( callback );
		} else {
			animationPrefilters.push( callback );
		}
	}
});

function defaultPrefilter( elem, props, opts ) {
	var index, prop, value, length, dataShow, tween, hooks, oldfire,
		anim = this,
		style = elem.style,
		orig = {},
		handled = [],
		hidden = elem.nodeType && isHidden( elem );

	// handle queue: false promises
	if ( !opts.queue ) {
		hooks = jQuery._queueHooks( elem, "fx" );
		if ( hooks.unqueued == null ) {
			hooks.unqueued = 0;
			oldfire = hooks.empty.fire;
			hooks.empty.fire = function() {
				if ( !hooks.unqueued ) {
					oldfire();
				}
			};
		}
		hooks.unqueued++;

		anim.always(function() {
			// doing this makes sure that the complete handler will be called
			// before this completes
			anim.always(function() {
				hooks.unqueued--;
				if ( !jQuery.queue( elem, "fx" ).length ) {
					hooks.empty.fire();
				}
			});
		});
	}

	// height/width overflow pass
	if ( elem.nodeType === 1 && ( "height" in props || "width" in props ) ) {
		// Make sure that nothing sneaks out
		// Record all 3 overflow attributes because IE does not
		// change the overflow attribute when overflowX and
		// overflowY are set to the same value
		opts.overflow = [ style.overflow, style.overflowX, style.overflowY ];

		// Set display property to inline-block for height/width
		// animations on inline elements that are having width/height animated
		if ( jQuery.css( elem, "display" ) === "inline" &&
				jQuery.css( elem, "float" ) === "none" ) {

			// inline-level elements accept inline-block;
			// block-level elements need to be inline with layout
			if ( !jQuery.support.inlineBlockNeedsLayout || css_defaultDisplay( elem.nodeName ) === "inline" ) {
				style.display = "inline-block";

			} else {
				style.zoom = 1;
			}
		}
	}

	if ( opts.overflow ) {
		style.overflow = "hidden";
		if ( !jQuery.support.shrinkWrapBlocks ) {
			anim.done(function() {
				style.overflow = opts.overflow[ 0 ];
				style.overflowX = opts.overflow[ 1 ];
				style.overflowY = opts.overflow[ 2 ];
			});
		}
	}


	// show/hide pass
	for ( index in props ) {
		value = props[ index ];
		if ( rfxtypes.exec( value ) ) {
			delete props[ index ];
			if ( value === ( hidden ? "hide" : "show" ) ) {
				continue;
			}
			handled.push( index );
		}
	}

	length = handled.length;
	if ( length ) {
		dataShow = jQuery._data( elem, "fxshow" ) || jQuery._data( elem, "fxshow", {} );
		if ( hidden ) {
			jQuery( elem ).show();
		} else {
			anim.done(function() {
				jQuery( elem ).hide();
			});
		}
		anim.done(function() {
			var prop;
			jQuery.removeData( elem, "fxshow", true );
			for ( prop in orig ) {
				jQuery.style( elem, prop, orig[ prop ] );
			}
		});
		for ( index = 0 ; index < length ; index++ ) {
			prop = handled[ index ];
			tween = anim.createTween( prop, hidden ? dataShow[ prop ] : 0 );
			orig[ prop ] = dataShow[ prop ] || jQuery.style( elem, prop );

			if ( !( prop in dataShow ) ) {
				dataShow[ prop ] = tween.start;
				if ( hidden ) {
					tween.end = tween.start;
					tween.start = prop === "width" || prop === "height" ? 1 : 0;
				}
			}
		}
	}
}

function Tween( elem, options, prop, end, easing ) {
	return new Tween.prototype.init( elem, options, prop, end, easing );
}
jQuery.Tween = Tween;

Tween.prototype = {
	constructor: Tween,
	init: function( elem, options, prop, end, easing, unit ) {
		this.elem = elem;
		this.prop = prop;
		this.easing = easing || "swing";
		this.options = options;
		this.start = this.now = this.cur();
		this.end = end;
		this.unit = unit || ( jQuery.cssNumber[ prop ] ? "" : "px" );
	},
	cur: function() {
		var hooks = Tween.propHooks[ this.prop ];

		return hooks && hooks.get ?
			hooks.get( this ) :
			Tween.propHooks._default.get( this );
	},
	run: function( percent ) {
		var eased,
			hooks = Tween.propHooks[ this.prop ];

		if ( this.options.duration ) {
			this.pos = eased = jQuery.easing[ this.easing ](
				percent, this.options.duration * percent, 0, 1, this.options.duration
			);
		} else {
			this.pos = eased = percent;
		}
		this.now = ( this.end - this.start ) * eased + this.start;

		if ( this.options.step ) {
			this.options.step.call( this.elem, this.now, this );
		}

		if ( hooks && hooks.set ) {
			hooks.set( this );
		} else {
			Tween.propHooks._default.set( this );
		}
		return this;
	}
};

Tween.prototype.init.prototype = Tween.prototype;

Tween.propHooks = {
	_default: {
		get: function( tween ) {
			var result;

			if ( tween.elem[ tween.prop ] != null &&
				(!tween.elem.style || tween.elem.style[ tween.prop ] == null) ) {
				return tween.elem[ tween.prop ];
			}

			// passing any value as a 4th parameter to .css will automatically
			// attempt a parseFloat and fallback to a string if the parse fails
			// so, simple values such as "10px" are parsed to Float.
			// complex values such as "rotate(1rad)" are returned as is.
			result = jQuery.css( tween.elem, tween.prop, false, "" );
			// Empty strings, null, undefined and "auto" are converted to 0.
			return !result || result === "auto" ? 0 : result;
		},
		set: function( tween ) {
			// use step hook for back compat - use cssHook if its there - use .style if its
			// available and use plain properties where available
			if ( jQuery.fx.step[ tween.prop ] ) {
				jQuery.fx.step[ tween.prop ]( tween );
			} else if ( tween.elem.style && ( tween.elem.style[ jQuery.cssProps[ tween.prop ] ] != null || jQuery.cssHooks[ tween.prop ] ) ) {
				jQuery.style( tween.elem, tween.prop, tween.now + tween.unit );
			} else {
				tween.elem[ tween.prop ] = tween.now;
			}
		}
	}
};

// Remove in 2.0 - this supports IE8's panic based approach
// to setting things on disconnected nodes

Tween.propHooks.scrollTop = Tween.propHooks.scrollLeft = {
	set: function( tween ) {
		if ( tween.elem.nodeType && tween.elem.parentNode ) {
			tween.elem[ tween.prop ] = tween.now;
		}
	}
};

jQuery.each([ "toggle", "show", "hide" ], function( i, name ) {
	var cssFn = jQuery.fn[ name ];
	jQuery.fn[ name ] = function( speed, easing, callback ) {
		return speed == null || typeof speed === "boolean" ||
			// special check for .toggle( handler, handler, ... )
			( !i && jQuery.isFunction( speed ) && jQuery.isFunction( easing ) ) ?
			cssFn.apply( this, arguments ) :
			this.animate( genFx( name, true ), speed, easing, callback );
	};
});

jQuery.fn.extend({
	fadeTo: function( speed, to, easing, callback ) {

		// show any hidden elements after setting opacity to 0
		return this.filter( isHidden ).css( "opacity", 0 ).show()

			// animate to the value specified
			.end().animate({ opacity: to }, speed, easing, callback );
	},
	animate: function( prop, speed, easing, callback ) {
		var empty = jQuery.isEmptyObject( prop ),
			optall = jQuery.speed( speed, easing, callback ),
			doAnimation = function() {
				// Operate on a copy of prop so per-property easing won't be lost
				var anim = Animation( this, jQuery.extend( {}, prop ), optall );

				// Empty animations resolve immediately
				if ( empty ) {
					anim.stop( true );
				}
			};

		return empty || optall.queue === false ?
			this.each( doAnimation ) :
			this.queue( optall.queue, doAnimation );
	},
	stop: function( type, clearQueue, gotoEnd ) {
		var stopQueue = function( hooks ) {
			var stop = hooks.stop;
			delete hooks.stop;
			stop( gotoEnd );
		};

		if ( typeof type !== "string" ) {
			gotoEnd = clearQueue;
			clearQueue = type;
			type = undefined;
		}
		if ( clearQueue && type !== false ) {
			this.queue( type || "fx", [] );
		}

		return this.each(function() {
			var dequeue = true,
				index = type != null && type + "queueHooks",
				timers = jQuery.timers,
				data = jQuery._data( this );

			if ( index ) {
				if ( data[ index ] && data[ index ].stop ) {
					stopQueue( data[ index ] );
				}
			} else {
				for ( index in data ) {
					if ( data[ index ] && data[ index ].stop && rrun.test( index ) ) {
						stopQueue( data[ index ] );
					}
				}
			}

			for ( index = timers.length; index--; ) {
				if ( timers[ index ].elem === this && (type == null || timers[ index ].queue === type) ) {
					timers[ index ].anim.stop( gotoEnd );
					dequeue = false;
					timers.splice( index, 1 );
				}
			}

			// start the next in the queue if the last step wasn't forced
			// timers currently will call their complete callbacks, which will dequeue
			// but only if they were gotoEnd
			if ( dequeue || !gotoEnd ) {
				jQuery.dequeue( this, type );
			}
		});
	}
});

// Generate parameters to create a standard animation
function genFx( type, includeWidth ) {
	var which,
		attrs = { height: type },
		i = 0;

	// if we include width, step value is 1 to do all cssExpand values,
	// if we don't include width, step value is 2 to skip over Left and Right
	includeWidth = includeWidth? 1 : 0;
	for( ; i < 4 ; i += 2 - includeWidth ) {
		which = cssExpand[ i ];
		attrs[ "margin" + which ] = attrs[ "padding" + which ] = type;
	}

	if ( includeWidth ) {
		attrs.opacity = attrs.width = type;
	}

	return attrs;
}

// Generate shortcuts for custom animations
jQuery.each({
	slideDown: genFx("show"),
	slideUp: genFx("hide"),
	slideToggle: genFx("toggle"),
	fadeIn: { opacity: "show" },
	fadeOut: { opacity: "hide" },
	fadeToggle: { opacity: "toggle" }
}, function( name, props ) {
	jQuery.fn[ name ] = function( speed, easing, callback ) {
		return this.animate( props, speed, easing, callback );
	};
});

jQuery.speed = function( speed, easing, fn ) {
	var opt = speed && typeof speed === "object" ? jQuery.extend( {}, speed ) : {
		complete: fn || !fn && easing ||
			jQuery.isFunction( speed ) && speed,
		duration: speed,
		easing: fn && easing || easing && !jQuery.isFunction( easing ) && easing
	};

	opt.duration = jQuery.fx.off ? 0 : typeof opt.duration === "number" ? opt.duration :
		opt.duration in jQuery.fx.speeds ? jQuery.fx.speeds[ opt.duration ] : jQuery.fx.speeds._default;

	// normalize opt.queue - true/undefined/null -> "fx"
	if ( opt.queue == null || opt.queue === true ) {
		opt.queue = "fx";
	}

	// Queueing
	opt.old = opt.complete;

	opt.complete = function() {
		if ( jQuery.isFunction( opt.old ) ) {
			opt.old.call( this );
		}

		if ( opt.queue ) {
			jQuery.dequeue( this, opt.queue );
		}
	};

	return opt;
};

jQuery.easing = {
	linear: function( p ) {
		return p;
	},
	swing: function( p ) {
		return 0.5 - Math.cos( p*Math.PI ) / 2;
	}
};

jQuery.timers = [];
jQuery.fx = Tween.prototype.init;
jQuery.fx.tick = function() {
	var timer,
		timers = jQuery.timers,
		i = 0;

	for ( ; i < timers.length; i++ ) {
		timer = timers[ i ];
		// Checks the timer has not already been removed
		if ( !timer() && timers[ i ] === timer ) {
			timers.splice( i--, 1 );
		}
	}

	if ( !timers.length ) {
		jQuery.fx.stop();
	}
};

jQuery.fx.timer = function( timer ) {
	if ( timer() && jQuery.timers.push( timer ) && !timerId ) {
		timerId = setInterval( jQuery.fx.tick, jQuery.fx.interval );
	}
};

jQuery.fx.interval = 13;

jQuery.fx.stop = function() {
	clearInterval( timerId );
	timerId = null;
};

jQuery.fx.speeds = {
	slow: 600,
	fast: 200,
	// Default speed
	_default: 400
};

// Back Compat <1.8 extension point
jQuery.fx.step = {};

if ( jQuery.expr && jQuery.expr.filters ) {
	jQuery.expr.filters.animated = function( elem ) {
		return jQuery.grep(jQuery.timers, function( fn ) {
			return elem === fn.elem;
		}).length;
	};
}
var rroot = /^(?:body|html)$/i;

jQuery.fn.offset = function( options ) {
	if ( arguments.length ) {
		return options === undefined ?
			this :
			this.each(function( i ) {
				jQuery.offset.setOffset( this, options, i );
			});
	}

	var docElem, body, win, clientTop, clientLeft, scrollTop, scrollLeft,
		box = { top: 0, left: 0 },
		elem = this[ 0 ],
		doc = elem && elem.ownerDocument;

	if ( !doc ) {
		return;
	}

	if ( (body = doc.body) === elem ) {
		return jQuery.offset.bodyOffset( elem );
	}

	docElem = doc.documentElement;

	// Make sure it's not a disconnected DOM node
	if ( !jQuery.contains( docElem, elem ) ) {
		return box;
	}

	// If we don't have gBCR, just use 0,0 rather than error
	// BlackBerry 5, iOS 3 (original iPhone)
	if ( typeof elem.getBoundingClientRect !== "undefined" ) {
		box = elem.getBoundingClientRect();
	}
	win = getWindow( doc );
	clientTop  = docElem.clientTop  || body.clientTop  || 0;
	clientLeft = docElem.clientLeft || body.clientLeft || 0;
	scrollTop  = win.pageYOffset || docElem.scrollTop;
	scrollLeft = win.pageXOffset || docElem.scrollLeft;
	return {
		top: box.top  + scrollTop  - clientTop,
		left: box.left + scrollLeft - clientLeft
	};
};

jQuery.offset = {

	bodyOffset: function( body ) {
		var top = body.offsetTop,
			left = body.offsetLeft;

		if ( jQuery.support.doesNotIncludeMarginInBodyOffset ) {
			top  += parseFloat( jQuery.css(body, "marginTop") ) || 0;
			left += parseFloat( jQuery.css(body, "marginLeft") ) || 0;
		}

		return { top: top, left: left };
	},

	setOffset: function( elem, options, i ) {
		var position = jQuery.css( elem, "position" );

		// set position first, in-case top/left are set even on static elem
		if ( position === "static" ) {
			elem.style.position = "relative";
		}

		var curElem = jQuery( elem ),
			curOffset = curElem.offset(),
			curCSSTop = jQuery.css( elem, "top" ),
			curCSSLeft = jQuery.css( elem, "left" ),
			calculatePosition = ( position === "absolute" || position === "fixed" ) && jQuery.inArray("auto", [curCSSTop, curCSSLeft]) > -1,
			props = {}, curPosition = {}, curTop, curLeft;

		// need to be able to calculate position if either top or left is auto and position is either absolute or fixed
		if ( calculatePosition ) {
			curPosition = curElem.position();
			curTop = curPosition.top;
			curLeft = curPosition.left;
		} else {
			curTop = parseFloat( curCSSTop ) || 0;
			curLeft = parseFloat( curCSSLeft ) || 0;
		}

		if ( jQuery.isFunction( options ) ) {
			options = options.call( elem, i, curOffset );
		}

		if ( options.top != null ) {
			props.top = ( options.top - curOffset.top ) + curTop;
		}
		if ( options.left != null ) {
			props.left = ( options.left - curOffset.left ) + curLeft;
		}

		if ( "using" in options ) {
			options.using.call( elem, props );
		} else {
			curElem.css( props );
		}
	}
};


jQuery.fn.extend({

	position: function() {
		if ( !this[0] ) {
			return;
		}

		var elem = this[0],

		// Get *real* offsetParent
		offsetParent = this.offsetParent(),

		// Get correct offsets
		offset       = this.offset(),
		parentOffset = rroot.test(offsetParent[0].nodeName) ? { top: 0, left: 0 } : offsetParent.offset();

		// Subtract element margins
		// note: when an element has margin: auto the offsetLeft and marginLeft
		// are the same in Safari causing offset.left to incorrectly be 0
		offset.top  -= parseFloat( jQuery.css(elem, "marginTop") ) || 0;
		offset.left -= parseFloat( jQuery.css(elem, "marginLeft") ) || 0;

		// Add offsetParent borders
		parentOffset.top  += parseFloat( jQuery.css(offsetParent[0], "borderTopWidth") ) || 0;
		parentOffset.left += parseFloat( jQuery.css(offsetParent[0], "borderLeftWidth") ) || 0;

		// Subtract the two offsets
		return {
			top:  offset.top  - parentOffset.top,
			left: offset.left - parentOffset.left
		};
	},

	offsetParent: function() {
		return this.map(function() {
			var offsetParent = this.offsetParent || document.body;
			while ( offsetParent && (!rroot.test(offsetParent.nodeName) && jQuery.css(offsetParent, "position") === "static") ) {
				offsetParent = offsetParent.offsetParent;
			}
			return offsetParent || document.body;
		});
	}
});


// Create scrollLeft and scrollTop methods
jQuery.each( {scrollLeft: "pageXOffset", scrollTop: "pageYOffset"}, function( method, prop ) {
	var top = /Y/.test( prop );

	jQuery.fn[ method ] = function( val ) {
		return jQuery.access( this, function( elem, method, val ) {
			var win = getWindow( elem );

			if ( val === undefined ) {
				return win ? (prop in win) ? win[ prop ] :
					win.document.documentElement[ method ] :
					elem[ method ];
			}

			if ( win ) {
				win.scrollTo(
					!top ? val : jQuery( win ).scrollLeft(),
					 top ? val : jQuery( win ).scrollTop()
				);

			} else {
				elem[ method ] = val;
			}
		}, method, val, arguments.length, null );
	};
});

function getWindow( elem ) {
	return jQuery.isWindow( elem ) ?
		elem :
		elem.nodeType === 9 ?
			elem.defaultView || elem.parentWindow :
			false;
}
// Create innerHeight, innerWidth, height, width, outerHeight and outerWidth methods
jQuery.each( { Height: "height", Width: "width" }, function( name, type ) {
	jQuery.each( { padding: "inner" + name, content: type, "": "outer" + name }, function( defaultExtra, funcName ) {
		// margin is only for outerHeight, outerWidth
		jQuery.fn[ funcName ] = function( margin, value ) {
			var chainable = arguments.length && ( defaultExtra || typeof margin !== "boolean" ),
				extra = defaultExtra || ( margin === true || value === true ? "margin" : "border" );

			return jQuery.access( this, function( elem, type, value ) {
				var doc;

				if ( jQuery.isWindow( elem ) ) {
					// As of 5/8/2012 this will yield incorrect results for Mobile Safari, but there
					// isn't a whole lot we can do. See pull request at this URL for discussion:
					// https://github.com/jquery/jquery/pull/764
					return elem.document.documentElement[ "client" + name ];
				}

				// Get document width or height
				if ( elem.nodeType === 9 ) {
					doc = elem.documentElement;

					// Either scroll[Width/Height] or offset[Width/Height] or client[Width/Height], whichever is greatest
					// unfortunately, this causes bug #3838 in IE6/8 only, but there is currently no good, small way to fix it.
					return Math.max(
						elem.body[ "scroll" + name ], doc[ "scroll" + name ],
						elem.body[ "offset" + name ], doc[ "offset" + name ],
						doc[ "client" + name ]
					);
				}

				return value === undefined ?
					// Get width or height on the element, requesting but not forcing parseFloat
					jQuery.css( elem, type, value, extra ) :

					// Set width or height on the element
					jQuery.style( elem, type, value, extra );
			}, type, chainable ? margin : undefined, chainable, null );
		};
	});
});
// Expose jQuery to the global object
window.jQuery = window.$ = jQuery;

// Expose jQuery as an AMD module, but only for AMD loaders that
// understand the issues with loading multiple versions of jQuery
// in a page that all might call define(). The loader will indicate
// they have special allowances for multiple jQuery versions by
// specifying define.amd.jQuery = true. Register as a named module,
// since jQuery can be concatenated with other files that may use define,
// but not use a proper concatenation script that understands anonymous
// AMD modules. A named AMD is safest and most robust way to register.
// Lowercase jquery is used because AMD module names are derived from
// file names, and jQuery is normally delivered in a lowercase file name.
// Do this after creating the global so that if an AMD module wants to call
// noConflict to hide this version of jQuery, it will work.
if ( typeof define === "function" && define.amd && define.amd.jQuery ) {
	define( "jquery", [], function () { return jQuery; } );
}

})( window );

/*!
 * jQuery blockUI plugin
 * Version 2.54 (17-DEC-2012)
 * @requires jQuery v1.3 or later
 *
 * Examples at: http://malsup.com/jquery/block/
 * Copyright (c) 2007-2012 M. Alsup
 * Dual licensed under the MIT and GPL licenses:
 * http://www.opensource.org/licenses/mit-license.php
 * http://www.gnu.org/licenses/gpl.html
 *
 * Thanks to Amir-Hossein Sobhi for some excellent contributions!
 */

;(function() {


	function setup($) {
		if (/^1\.(0|1|2)/.test($.fn.jquery)) {
			/*global alert:true */
			alert('blockUI requires jQuery v1.3 or later!  You are using v' + $.fn.jquery);
			return;
		}

		$.fn._fadeIn = $.fn.fadeIn;

		var noOp = $.noop || function() {};

		// this bit is to ensure we don't call setExpression when we shouldn't (with extra muscle to handle
		// retarded userAgent strings on Vista)
		var msie = /MSIE/.test(navigator.userAgent);
		var ie6  = /MSIE 6.0/.test(navigator.userAgent);
		var mode = document.documentMode || 0;
		// var setExpr = msie && (($.browser.version < 8 && !mode) || mode < 8);
		var setExpr = $.isFunction( document.createElement('div').style.setExpression );

		// global $ methods for blocking/unblocking the entire page
		$.blockUI   = function(opts) { install(window, opts); };
		$.unblockUI = function(opts) { remove(window, opts); };

		// convenience method for quick growl-like notifications  (http://www.google.com/search?q=growl)
		$.growlUI = function(title, message, timeout, onClose) {
			var $m = $('<div class="growlUI"></div>');
			if (title) $m.append('<h1>'+title+'</h1>');
			if (message) $m.append('<h2>'+message+'</h2>');
			if (timeout === undefined) timeout = 3000;
			$.blockUI({
				message: $m, fadeIn: 700, fadeOut: 1000, centerY: false,
				timeout: timeout, showOverlay: false,
				onUnblock: onClose,
				css: $.blockUI.defaults.growlCSS
			});
		};

		// plugin method for blocking element content
		$.fn.block = function(opts) {
			var fullOpts = $.extend({}, $.blockUI.defaults, opts || {});
			this.each(function() {
				var $el = $(this);
				if (fullOpts.ignoreIfBlocked && $el.data('blockUI.isBlocked'))
					return;
				$el.unblock({ fadeOut: 0 });
			});

			return this.each(function() {
				if ($.css(this,'position') == 'static')
					this.style.position = 'relative';
				this.style.zoom = 1; // force 'hasLayout' in ie
				install(this, opts);
			});
		};

		// plugin method for unblocking element content
		$.fn.unblock = function(opts) {
			return this.each(function() {
				remove(this, opts);
			});
		};

		$.blockUI.version = 2.54; // 2nd generation blocking at no extra cost!

		// override these in your code to change the default behavior and style
		$.blockUI.defaults = {
			// message displayed when blocking (use null for no message)
			message:  '<h1>Please wait...</h1>',

			title: null,		// title string; only used when theme == true
			draggable: true,	// only used when theme == true (requires jquery-ui.js to be loaded)

			theme: false, // set to true to use with jQuery UI themes

			// styles for the message when blocking; if you wish to disable
			// these and use an external stylesheet then do this in your code:
			// $.blockUI.defaults.css = {};
			css: {
				padding:	0,
				margin:		0,
				width:		'30%',
				top:		'40%',
				left:		'35%',
				textAlign:	'center',
				color:		'#000',
				border:		'3px solid #aaa',
				backgroundColor:'#fff',
				cursor:		'wait'
			},

			// minimal style set used when themes are used
			themedCSS: {
				width:	'30%',
				top:	'40%',
				left:	'35%'
			},

			// styles for the overlay
			overlayCSS:  {
				backgroundColor:	'#000',
				opacity:			0.6,
				cursor:				'wait'
			},

			// style to replace wait cursor before unblocking to correct issue
			// of lingering wait cursor
			cursorReset: 'default',

			// styles applied when using $.growlUI
			growlCSS: {
				width:		'350px',
				top:		'10px',
				left:		'',
				right:		'10px',
				border:		'none',
				padding:	'5px',
				opacity:	0.6,
				cursor:		'default',
				color:		'#fff',
				backgroundColor: '#000',
				'-webkit-border-radius':'10px',
				'-moz-border-radius':	'10px',
				'border-radius':		'10px'
			},

			// IE issues: 'about:blank' fails on HTTPS and javascript:false is s-l-o-w
			// (hat tip to Jorge H. N. de Vasconcelos)
			/*jshint scripturl:true */
			iframeSrc: /^https/i.test(window.location.href || '') ? 'javascript:false' : 'about:blank',

			// force usage of iframe in non-IE browsers (handy for blocking applets)
			forceIframe: false,

			// z-index for the blocking overlay
			baseZ: 1000,

			// set these to true to have the message automatically centered
			centerX: true, // <-- only effects element blocking (page block controlled via css above)
			centerY: true,

			// allow body element to be stetched in ie6; this makes blocking look better
			// on "short" pages.  disable if you wish to prevent changes to the body height
			allowBodyStretch: true,

			// enable if you want key and mouse events to be disabled for content that is blocked
			bindEvents: true,

			// be default blockUI will supress tab navigation from leaving blocking content
			// (if bindEvents is true)
			constrainTabKey: true,

			// fadeIn time in millis; set to 0 to disable fadeIn on block
			fadeIn:  200,

			// fadeOut time in millis; set to 0 to disable fadeOut on unblock
			fadeOut:  400,

			// time in millis to wait before auto-unblocking; set to 0 to disable auto-unblock
			timeout: 0,

			// disable if you don't want to show the overlay
			showOverlay: true,

			// if true, focus will be placed in the first available input field when
			// page blocking
			focusInput: true,

			// suppresses the use of overlay styles on FF/Linux (due to performance issues with opacity)
			// no longer needed in 2012
			// applyPlatformOpacityRules: true,

			// callback method invoked when fadeIn has completed and blocking message is visible
			onBlock: null,

			// callback method invoked when unblocking has completed; the callback is
			// passed the element that has been unblocked (which is the window object for page
			// blocks) and the options that were passed to the unblock call:
			//	onUnblock(element, options)
			onUnblock: null,

			// callback method invoked when the overlay area is clicked.
			// setting this will turn the cursor to a pointer, otherwise cursor defined in overlayCss will be used.
			onOverlayClick: null,

			// don't ask; if you really must know: http://groups.google.com/group/jquery-en/browse_thread/thread/36640a8730503595/2f6a79a77a78e493#2f6a79a77a78e493
			quirksmodeOffsetHack: 4,

			// class name of the message block
			blockMsgClass: 'blockMsg',

			// if it is already blocked, then ignore it (don't unblock and reblock)
			ignoreIfBlocked: false
		};

		// private data and functions follow...

		var pageBlock = null;
		var pageBlockEls = [];

		function install(el, opts) {
			var css, themedCSS;
			var full = (el == window);
			var msg = (opts && opts.message !== undefined ? opts.message : undefined);
			opts = $.extend({}, $.blockUI.defaults, opts || {});

			if (opts.ignoreIfBlocked && $(el).data('blockUI.isBlocked'))
				return;

			opts.overlayCSS = $.extend({}, $.blockUI.defaults.overlayCSS, opts.overlayCSS || {});
			css = $.extend({}, $.blockUI.defaults.css, opts.css || {});
			if (opts.onOverlayClick)
				opts.overlayCSS.cursor = 'pointer';

			themedCSS = $.extend({}, $.blockUI.defaults.themedCSS, opts.themedCSS || {});
			msg = msg === undefined ? opts.message : msg;

			// remove the current block (if there is one)
			if (full && pageBlock)
				remove(window, {fadeOut:0});

			// if an existing element is being used as the blocking content then we capture
			// its current place in the DOM (and current display style) so we can restore
			// it when we unblock
			if (msg && typeof msg != 'string' && (msg.parentNode || msg.jquery)) {
				var node = msg.jquery ? msg[0] : msg;
				var data = {};
				$(el).data('blockUI.history', data);
				data.el = node;
				data.parent = node.parentNode;
				data.display = node.style.display;
				data.position = node.style.position;
				if (data.parent)
					data.parent.removeChild(node);
			}

			$(el).data('blockUI.onUnblock', opts.onUnblock);
			var z = opts.baseZ;

			// blockUI uses 3 layers for blocking, for simplicity they are all used on every platform;
			// layer1 is the iframe layer which is used to supress bleed through of underlying content
			// layer2 is the overlay layer which has opacity and a wait cursor (by default)
			// layer3 is the message content that is displayed while blocking
			var lyr1, lyr2, lyr3, s;
			if (msie || opts.forceIframe)
				lyr1 = $('<iframe class="blockUI" style="z-index:'+ (z++) +';display:none;border:none;margin:0;padding:0;position:absolute;width:100%;height:100%;top:0;left:0" src="'+opts.iframeSrc+'"></iframe>');
			else
				lyr1 = $('<div class="blockUI" style="display:none"></div>');

			if (opts.theme)
				lyr2 = $('<div class="blockUI blockOverlay ui-widget-overlay" style="z-index:'+ (z++) +';display:none"></div>');
			else
				lyr2 = $('<div class="blockUI blockOverlay" style="z-index:'+ (z++) +';display:none;border:none;margin:0;padding:0;width:100%;height:100%;top:0;left:0"></div>');

			if (opts.theme && full) {
				s = '<div class="blockUI ' + opts.blockMsgClass + ' blockPage ui-dialog ui-widget ui-corner-all" style="z-index:'+(z+10)+';display:none;position:fixed">';
				if ( opts.title ) {
					s += '<div class="ui-widget-header ui-dialog-titlebar ui-corner-all blockTitle">'+(opts.title || '&nbsp;')+'</div>';
				}
				s += '<div class="ui-widget-content ui-dialog-content"></div>';
				s += '</div>';
			}
			else if (opts.theme) {
				s = '<div class="blockUI ' + opts.blockMsgClass + ' blockElement ui-dialog ui-widget ui-corner-all" style="z-index:'+(z+10)+';display:none;position:absolute">';
				if ( opts.title ) {
					s += '<div class="ui-widget-header ui-dialog-titlebar ui-corner-all blockTitle">'+(opts.title || '&nbsp;')+'</div>';
				}  
				s += '<div class="ui-widget-content ui-dialog-content"></div>';
				s += '</div>';
			}
			else if (full) {
				s = '<div class="blockUI ' + opts.blockMsgClass + ' blockPage" style="z-index:'+(z+10)+';display:none;position:fixed"></div>';
			}
			else {
				s = '<div class="blockUI ' + opts.blockMsgClass + ' blockElement" style="z-index:'+(z+10)+';display:none;position:absolute"></div>';
			}
			lyr3 = $(s);

			// if we have a message, style it
			if (msg) {
				if (opts.theme) {
					lyr3.css(themedCSS);
					lyr3.addClass('ui-widget-content');
				}
				else
					lyr3.css(css);
			}

			// style the overlay
			if (!opts.theme /*&& (!opts.applyPlatformOpacityRules)*/)
				lyr2.css(opts.overlayCSS);
			lyr2.css('position', full ? 'fixed' : 'absolute');

			// make iframe layer transparent in IE
			if (msie || opts.forceIframe)
				lyr1.css('opacity',0.0);

			//$([lyr1[0],lyr2[0],lyr3[0]]).appendTo(full ? 'body' : el);
			var layers = [lyr1,lyr2,lyr3], $par = full ? $('body') : $(el);
			$.each(layers, function() {
				this.appendTo($par);
			});

			if (opts.theme && opts.draggable && $.fn.draggable) {
				lyr3.draggable({
					handle: '.ui-dialog-titlebar',
					cancel: 'li'
				});
			}

			// ie7 must use absolute positioning in quirks mode and to account for activex issues (when scrolling)
			var expr = setExpr && (!$.support.boxModel || $('object,embed', full ? null : el).length > 0);
			if (ie6 || expr) {
				// give body 100% height
				if (full && opts.allowBodyStretch && $.support.boxModel)
					$('html,body').css('height','100%');

				// fix ie6 issue when blocked element has a border width
				if ((ie6 || !$.support.boxModel) && !full) {
					var t = sz(el,'borderTopWidth'), l = sz(el,'borderLeftWidth');
					var fixT = t ? '(0 - '+t+')' : 0;
					var fixL = l ? '(0 - '+l+')' : 0;
				}

				// simulate fixed position
				$.each(layers, function(i,o) {
					var s = o[0].style;
					s.position = 'absolute';
					if (i < 2) {
						if (full)
							s.setExpression('height','Math.max(document.body.scrollHeight, document.body.offsetHeight) - (jQuery.support.boxModel?0:'+opts.quirksmodeOffsetHack+') + "px"');
						else
							s.setExpression('height','this.parentNode.offsetHeight + "px"');
						if (full)
							s.setExpression('width','jQuery.support.boxModel && document.documentElement.clientWidth || document.body.clientWidth + "px"');
						else
							s.setExpression('width','this.parentNode.offsetWidth + "px"');
						if (fixL) s.setExpression('left', fixL);
						if (fixT) s.setExpression('top', fixT);
					}
					else if (opts.centerY) {
						if (full) s.setExpression('top','(document.documentElement.clientHeight || document.body.clientHeight) / 2 - (this.offsetHeight / 2) + (blah = document.documentElement.scrollTop ? document.documentElement.scrollTop : document.body.scrollTop) + "px"');
						s.marginTop = 0;
					}
					else if (!opts.centerY && full) {
						var top = (opts.css && opts.css.top) ? parseInt(opts.css.top, 10) : 0;
						var expression = '((document.documentElement.scrollTop ? document.documentElement.scrollTop : document.body.scrollTop) + '+top+') + "px"';
						s.setExpression('top',expression);
					}
				});
			}

			// show the message
			if (msg) {
				if (opts.theme)
					lyr3.find('.ui-widget-content').append(msg);
				else
					lyr3.append(msg);
				if (msg.jquery || msg.nodeType)
					$(msg).show();
			}

			if ((msie || opts.forceIframe) && opts.showOverlay)
				lyr1.show(); // opacity is zero
			if (opts.fadeIn) {
				var cb = opts.onBlock ? opts.onBlock : noOp;
				var cb1 = (opts.showOverlay && !msg) ? cb : noOp;
				var cb2 = msg ? cb : noOp;
				if (opts.showOverlay)
					lyr2._fadeIn(opts.fadeIn, cb1);
				if (msg)
					lyr3._fadeIn(opts.fadeIn, cb2);
			}
			else {
				if (opts.showOverlay)
					lyr2.show();
				if (msg)
					lyr3.show();
				if (opts.onBlock)
					opts.onBlock();
			}

			// bind key and mouse events
			bind(1, el, opts);

			if (full) {
				pageBlock = lyr3[0];
				pageBlockEls = $(':input:enabled:visible',pageBlock);
				if (opts.focusInput)
					setTimeout(focus, 20);
			}
			else
				center(lyr3[0], opts.centerX, opts.centerY);

			if (opts.timeout) {
				// auto-unblock
				var to = setTimeout(function() {
					if (full)
						$.unblockUI(opts);
					else
						$(el).unblock(opts);
				}, opts.timeout);
				$(el).data('blockUI.timeout', to);
			}
		}

		// remove the block
		function remove(el, opts) {
			var full = (el == window);
			var $el = $(el);
			var data = $el.data('blockUI.history');
			var to = $el.data('blockUI.timeout');
			if (to) {
				clearTimeout(to);
				$el.removeData('blockUI.timeout');
			}
			opts = $.extend({}, $.blockUI.defaults, opts || {});
			bind(0, el, opts); // unbind events

			if (opts.onUnblock === null) {
				opts.onUnblock = $el.data('blockUI.onUnblock');
				$el.removeData('blockUI.onUnblock');
			}

			var els;
			if (full) // crazy selector to handle odd field errors in ie6/7
				els = $('body').children().filter('.blockUI').add('body > .blockUI');
			else
				els = $el.find('>.blockUI');

			// fix cursor issue
			if ( opts.cursorReset ) {
				if ( els.length > 1 )
					els[1].style.cursor = opts.cursorReset;
				if ( els.length > 2 )
					els[2].style.cursor = opts.cursorReset;
			}

			if (full)
				pageBlock = pageBlockEls = null;

			if (opts.fadeOut) {
				els.fadeOut(opts.fadeOut);
				setTimeout(function() { reset(els,data,opts,el); }, opts.fadeOut);
			}
			else
				reset(els, data, opts, el);
		}

		// move blocking element back into the DOM where it started
		function reset(els,data,opts,el) {
			els.each(function(i,o) {
				// remove via DOM calls so we don't lose event handlers
				if (this.parentNode)
					this.parentNode.removeChild(this);
			});

			if (data && data.el) {
				data.el.style.display = data.display;
				data.el.style.position = data.position;
				if (data.parent)
					data.parent.appendChild(data.el);
				$(el).removeData('blockUI.history');
			}

			if (typeof opts.onUnblock == 'function')
				opts.onUnblock(el,opts);

			// fix issue in Safari 6 where block artifacts remain until reflow
			var body = $(document.body), w = body.width(), cssW = body[0].style.width;
			body.width(w-1).width(w);
			body[0].style.width = cssW;
		}

		// bind/unbind the handler
		function bind(b, el, opts) {
			var full = el == window, $el = $(el);

			// don't bother unbinding if there is nothing to unbind
			if (!b && (full && !pageBlock || !full && !$el.data('blockUI.isBlocked')))
				return;

			$el.data('blockUI.isBlocked', b);

			// don't bind events when overlay is not in use or if bindEvents is false
			if (!opts.bindEvents || (b && !opts.showOverlay))
				return;

			// bind anchors and inputs for mouse and key events
			var events = 'mousedown mouseup keydown keypress keyup touchstart touchend touchmove';
			if (b)
				$(document).bind(events, opts, handler);
			else
				$(document).unbind(events, handler);

		// former impl...
		//		var $e = $('a,:input');
		//		b ? $e.bind(events, opts, handler) : $e.unbind(events, handler);
		}

		// event handler to suppress keyboard/mouse events when blocking
		function handler(e) {
			// allow tab navigation (conditionally)
			if (e.keyCode && e.keyCode == 9) {
				if (pageBlock && e.data.constrainTabKey) {
					var els = pageBlockEls;
					var fwd = !e.shiftKey && e.target === els[els.length-1];
					var back = e.shiftKey && e.target === els[0];
					if (fwd || back) {
						setTimeout(function(){focus(back);},10);
						return false;
					}
				}
			}
			var opts = e.data;
			var target = $(e.target);
			if (target.hasClass('blockOverlay') && opts.onOverlayClick)
				opts.onOverlayClick();

			// allow events within the message content
			if (target.parents('div.' + opts.blockMsgClass).length > 0)
				return true;

			// allow events for content that is not being blocked
			return target.parents().children().filter('div.blockUI').length === 0;
		}

		function focus(back) {
			if (!pageBlockEls)
				return;
			var e = pageBlockEls[back===true ? pageBlockEls.length-1 : 0];
			if (e)
				e.focus();
		}

		function center(el, x, y) {
			var p = el.parentNode, s = el.style;
			var l = ((p.offsetWidth - el.offsetWidth)/2) - sz(p,'borderLeftWidth');
			var t = ((p.offsetHeight - el.offsetHeight)/2) - sz(p,'borderTopWidth');
			if (x) s.left = l > 0 ? (l+'px') : '0';
			if (y) s.top  = t > 0 ? (t+'px') : '0';
		}

		function sz(el, p) {
			return parseInt($.css(el,p),10)||0;
		}

	}


	/*global define:true */
	//if (typeof define === 'function' && define.amd && define.amd.jQuery) {
	//	define(['jquery'], setup);
	//} else {
		setup(jQuery);
	//}

})();

define("blockui", function(){});

/*! jQuery UI - v1.8.23 - 2012-08-15
* https://github.com/jquery/jquery-ui
* Includes: jquery.ui.core.js
* Copyright (c) 2012 AUTHORS.txt; Licensed MIT, GPL */
(function(a,b){function c(b,c){var e=b.nodeName.toLowerCase();if("area"===e){var f=b.parentNode,g=f.name,h;return!b.href||!g||f.nodeName.toLowerCase()!=="map"?!1:(h=a("img[usemap=#"+g+"]")[0],!!h&&d(h))}return(/input|select|textarea|button|object/.test(e)?!b.disabled:"a"==e?b.href||c:c)&&d(b)}function d(b){return!a(b).parents().andSelf().filter(function(){return a.curCSS(this,"visibility")==="hidden"||a.expr.filters.hidden(this)}).length}a.ui=a.ui||{};if(a.ui.version)return;a.extend(a.ui,{version:"1.8.23",keyCode:{ALT:18,BACKSPACE:8,CAPS_LOCK:20,COMMA:188,COMMAND:91,COMMAND_LEFT:91,COMMAND_RIGHT:93,CONTROL:17,DELETE:46,DOWN:40,END:35,ENTER:13,ESCAPE:27,HOME:36,INSERT:45,LEFT:37,MENU:93,NUMPAD_ADD:107,NUMPAD_DECIMAL:110,NUMPAD_DIVIDE:111,NUMPAD_ENTER:108,NUMPAD_MULTIPLY:106,NUMPAD_SUBTRACT:109,PAGE_DOWN:34,PAGE_UP:33,PERIOD:190,RIGHT:39,SHIFT:16,SPACE:32,TAB:9,UP:38,WINDOWS:91}}),a.fn.extend({propAttr:a.fn.prop||a.fn.attr,_focus:a.fn.focus,focus:function(b,c){return typeof b=="number"?this.each(function(){var d=this;setTimeout(function(){a(d).focus(),c&&c.call(d)},b)}):this._focus.apply(this,arguments)},scrollParent:function(){var b;return a.browser.msie&&/(static|relative)/.test(this.css("position"))||/absolute/.test(this.css("position"))?b=this.parents().filter(function(){return/(relative|absolute|fixed)/.test(a.curCSS(this,"position",1))&&/(auto|scroll)/.test(a.curCSS(this,"overflow",1)+a.curCSS(this,"overflow-y",1)+a.curCSS(this,"overflow-x",1))}).eq(0):b=this.parents().filter(function(){return/(auto|scroll)/.test(a.curCSS(this,"overflow",1)+a.curCSS(this,"overflow-y",1)+a.curCSS(this,"overflow-x",1))}).eq(0),/fixed/.test(this.css("position"))||!b.length?a(document):b},zIndex:function(c){if(c!==b)return this.css("zIndex",c);if(this.length){var d=a(this[0]),e,f;while(d.length&&d[0]!==document){e=d.css("position");if(e==="absolute"||e==="relative"||e==="fixed"){f=parseInt(d.css("zIndex"),10);if(!isNaN(f)&&f!==0)return f}d=d.parent()}}return 0},disableSelection:function(){return this.bind((a.support.selectstart?"selectstart":"mousedown")+".ui-disableSelection",function(a){a.preventDefault()})},enableSelection:function(){return this.unbind(".ui-disableSelection")}}),a("<a>").outerWidth(1).jquery||a.each(["Width","Height"],function(c,d){function h(b,c,d,f){return a.each(e,function(){c-=parseFloat(a.curCSS(b,"padding"+this,!0))||0,d&&(c-=parseFloat(a.curCSS(b,"border"+this+"Width",!0))||0),f&&(c-=parseFloat(a.curCSS(b,"margin"+this,!0))||0)}),c}var e=d==="Width"?["Left","Right"]:["Top","Bottom"],f=d.toLowerCase(),g={innerWidth:a.fn.innerWidth,innerHeight:a.fn.innerHeight,outerWidth:a.fn.outerWidth,outerHeight:a.fn.outerHeight};a.fn["inner"+d]=function(c){return c===b?g["inner"+d].call(this):this.each(function(){a(this).css(f,h(this,c)+"px")})},a.fn["outer"+d]=function(b,c){return typeof b!="number"?g["outer"+d].call(this,b):this.each(function(){a(this).css(f,h(this,b,!0,c)+"px")})}}),a.extend(a.expr[":"],{data:a.expr.createPseudo?a.expr.createPseudo(function(b){return function(c){return!!a.data(c,b)}}):function(b,c,d){return!!a.data(b,d[3])},focusable:function(b){return c(b,!isNaN(a.attr(b,"tabindex")))},tabbable:function(b){var d=a.attr(b,"tabindex"),e=isNaN(d);return(e||d>=0)&&c(b,!e)}}),a(function(){var b=document.body,c=b.appendChild(c=document.createElement("div"));c.offsetHeight,a.extend(c.style,{minHeight:"100px",height:"auto",padding:0,borderWidth:0}),a.support.minHeight=c.offsetHeight===100,a.support.selectstart="onselectstart"in c,b.removeChild(c).style.display="none"}),a.curCSS||(a.curCSS=a.css),a.extend(a.ui,{plugin:{add:function(b,c,d){var e=a.ui[b].prototype;for(var f in d)e.plugins[f]=e.plugins[f]||[],e.plugins[f].push([c,d[f]])},call:function(a,b,c){var d=a.plugins[b];if(!d||!a.element[0].parentNode)return;for(var e=0;e<d.length;e++)a.options[d[e][0]]&&d[e][1].apply(a.element,c)}},contains:function(a,b){return document.compareDocumentPosition?a.compareDocumentPosition(b)&16:a!==b&&a.contains(b)},hasScroll:function(b,c){if(a(b).css("overflow")==="hidden")return!1;var d=c&&c==="left"?"scrollLeft":"scrollTop",e=!1;return b[d]>0?!0:(b[d]=1,e=b[d]>0,b[d]=0,e)},isOverAxis:function(a,b,c){return a>b&&a<b+c},isOver:function(b,c,d,e,f,g){return a.ui.isOverAxis(b,d,f)&&a.ui.isOverAxis(c,e,g)}})})(jQuery);;/*! jQuery UI - v1.8.23 - 2012-08-15
* https://github.com/jquery/jquery-ui
* Includes: jquery.ui.widget.js
* Copyright (c) 2012 AUTHORS.txt; Licensed MIT, GPL */
(function(a,b){if(a.cleanData){var c=a.cleanData;a.cleanData=function(b){for(var d=0,e;(e=b[d])!=null;d++)try{a(e).triggerHandler("remove")}catch(f){}c(b)}}else{var d=a.fn.remove;a.fn.remove=function(b,c){return this.each(function(){return c||(!b||a.filter(b,[this]).length)&&a("*",this).add([this]).each(function(){try{a(this).triggerHandler("remove")}catch(b){}}),d.call(a(this),b,c)})}}a.widget=function(b,c,d){var e=b.split(".")[0],f;b=b.split(".")[1],f=e+"-"+b,d||(d=c,c=a.Widget),a.expr[":"][f]=function(c){return!!a.data(c,b)},a[e]=a[e]||{},a[e][b]=function(a,b){arguments.length&&this._createWidget(a,b)};var g=new c;g.options=a.extend(!0,{},g.options),a[e][b].prototype=a.extend(!0,g,{namespace:e,widgetName:b,widgetEventPrefix:a[e][b].prototype.widgetEventPrefix||b,widgetBaseClass:f},d),a.widget.bridge(b,a[e][b])},a.widget.bridge=function(c,d){a.fn[c]=function(e){var f=typeof e=="string",g=Array.prototype.slice.call(arguments,1),h=this;return e=!f&&g.length?a.extend.apply(null,[!0,e].concat(g)):e,f&&e.charAt(0)==="_"?h:(f?this.each(function(){var d=a.data(this,c),f=d&&a.isFunction(d[e])?d[e].apply(d,g):d;if(f!==d&&f!==b)return h=f,!1}):this.each(function(){var b=a.data(this,c);b?b.option(e||{})._init():a.data(this,c,new d(e,this))}),h)}},a.Widget=function(a,b){arguments.length&&this._createWidget(a,b)},a.Widget.prototype={widgetName:"widget",widgetEventPrefix:"",options:{disabled:!1},_createWidget:function(b,c){a.data(c,this.widgetName,this),this.element=a(c),this.options=a.extend(!0,{},this.options,this._getCreateOptions(),b);var d=this;this.element.bind("remove."+this.widgetName,function(){d.destroy()}),this._create(),this._trigger("create"),this._init()},_getCreateOptions:function(){return a.metadata&&a.metadata.get(this.element[0])[this.widgetName]},_create:function(){},_init:function(){},destroy:function(){this.element.unbind("."+this.widgetName).removeData(this.widgetName),this.widget().unbind("."+this.widgetName).removeAttr("aria-disabled").removeClass(this.widgetBaseClass+"-disabled "+"ui-state-disabled")},widget:function(){return this.element},option:function(c,d){var e=c;if(arguments.length===0)return a.extend({},this.options);if(typeof c=="string"){if(d===b)return this.options[c];e={},e[c]=d}return this._setOptions(e),this},_setOptions:function(b){var c=this;return a.each(b,function(a,b){c._setOption(a,b)}),this},_setOption:function(a,b){return this.options[a]=b,a==="disabled"&&this.widget()[b?"addClass":"removeClass"](this.widgetBaseClass+"-disabled"+" "+"ui-state-disabled").attr("aria-disabled",b),this},enable:function(){return this._setOption("disabled",!1)},disable:function(){return this._setOption("disabled",!0)},_trigger:function(b,c,d){var e,f,g=this.options[b];d=d||{},c=a.Event(c),c.type=(b===this.widgetEventPrefix?b:this.widgetEventPrefix+b).toLowerCase(),c.target=this.element[0],f=c.originalEvent;if(f)for(e in f)e in c||(c[e]=f[e]);return this.element.trigger(c,d),!(a.isFunction(g)&&g.call(this.element[0],c,d)===!1||c.isDefaultPrevented())}}})(jQuery);;/*! jQuery UI - v1.8.23 - 2012-08-15
* https://github.com/jquery/jquery-ui
* Includes: jquery.ui.mouse.js
* Copyright (c) 2012 AUTHORS.txt; Licensed MIT, GPL */
(function(a,b){var c=!1;a(document).mouseup(function(a){c=!1}),a.widget("ui.mouse",{options:{cancel:":input,option",distance:1,delay:0},_mouseInit:function(){var b=this;this.element.bind("mousedown."+this.widgetName,function(a){return b._mouseDown(a)}).bind("click."+this.widgetName,function(c){if(!0===a.data(c.target,b.widgetName+".preventClickEvent"))return a.removeData(c.target,b.widgetName+".preventClickEvent"),c.stopImmediatePropagation(),!1}),this.started=!1},_mouseDestroy:function(){this.element.unbind("."+this.widgetName),this._mouseMoveDelegate&&a(document).unbind("mousemove."+this.widgetName,this._mouseMoveDelegate).unbind("mouseup."+this.widgetName,this._mouseUpDelegate)},_mouseDown:function(b){if(c)return;this._mouseStarted&&this._mouseUp(b),this._mouseDownEvent=b;var d=this,e=b.which==1,f=typeof this.options.cancel=="string"&&b.target.nodeName?a(b.target).closest(this.options.cancel).length:!1;if(!e||f||!this._mouseCapture(b))return!0;this.mouseDelayMet=!this.options.delay,this.mouseDelayMet||(this._mouseDelayTimer=setTimeout(function(){d.mouseDelayMet=!0},this.options.delay));if(this._mouseDistanceMet(b)&&this._mouseDelayMet(b)){this._mouseStarted=this._mouseStart(b)!==!1;if(!this._mouseStarted)return b.preventDefault(),!0}return!0===a.data(b.target,this.widgetName+".preventClickEvent")&&a.removeData(b.target,this.widgetName+".preventClickEvent"),this._mouseMoveDelegate=function(a){return d._mouseMove(a)},this._mouseUpDelegate=function(a){return d._mouseUp(a)},a(document).bind("mousemove."+this.widgetName,this._mouseMoveDelegate).bind("mouseup."+this.widgetName,this._mouseUpDelegate),b.preventDefault(),c=!0,!0},_mouseMove:function(b){return!a.browser.msie||document.documentMode>=9||!!b.button?this._mouseStarted?(this._mouseDrag(b),b.preventDefault()):(this._mouseDistanceMet(b)&&this._mouseDelayMet(b)&&(this._mouseStarted=this._mouseStart(this._mouseDownEvent,b)!==!1,this._mouseStarted?this._mouseDrag(b):this._mouseUp(b)),!this._mouseStarted):this._mouseUp(b)},_mouseUp:function(b){return a(document).unbind("mousemove."+this.widgetName,this._mouseMoveDelegate).unbind("mouseup."+this.widgetName,this._mouseUpDelegate),this._mouseStarted&&(this._mouseStarted=!1,b.target==this._mouseDownEvent.target&&a.data(b.target,this.widgetName+".preventClickEvent",!0),this._mouseStop(b)),!1},_mouseDistanceMet:function(a){return Math.max(Math.abs(this._mouseDownEvent.pageX-a.pageX),Math.abs(this._mouseDownEvent.pageY-a.pageY))>=this.options.distance},_mouseDelayMet:function(a){return this.mouseDelayMet},_mouseStart:function(a){},_mouseDrag:function(a){},_mouseStop:function(a){},_mouseCapture:function(a){return!0}})})(jQuery);;/*! jQuery UI - v1.8.23 - 2012-08-15
* https://github.com/jquery/jquery-ui
* Includes: jquery.ui.position.js
* Copyright (c) 2012 AUTHORS.txt; Licensed MIT, GPL */
(function(a,b){a.ui=a.ui||{};var c=/left|center|right/,d=/top|center|bottom/,e="center",f={},g=a.fn.position,h=a.fn.offset;a.fn.position=function(b){if(!b||!b.of)return g.apply(this,arguments);b=a.extend({},b);var h=a(b.of),i=h[0],j=(b.collision||"flip").split(" "),k=b.offset?b.offset.split(" "):[0,0],l,m,n;return i.nodeType===9?(l=h.width(),m=h.height(),n={top:0,left:0}):i.setTimeout?(l=h.width(),m=h.height(),n={top:h.scrollTop(),left:h.scrollLeft()}):i.preventDefault?(b.at="left top",l=m=0,n={top:b.of.pageY,left:b.of.pageX}):(l=h.outerWidth(),m=h.outerHeight(),n=h.offset()),a.each(["my","at"],function(){var a=(b[this]||"").split(" ");a.length===1&&(a=c.test(a[0])?a.concat([e]):d.test(a[0])?[e].concat(a):[e,e]),a[0]=c.test(a[0])?a[0]:e,a[1]=d.test(a[1])?a[1]:e,b[this]=a}),j.length===1&&(j[1]=j[0]),k[0]=parseInt(k[0],10)||0,k.length===1&&(k[1]=k[0]),k[1]=parseInt(k[1],10)||0,b.at[0]==="right"?n.left+=l:b.at[0]===e&&(n.left+=l/2),b.at[1]==="bottom"?n.top+=m:b.at[1]===e&&(n.top+=m/2),n.left+=k[0],n.top+=k[1],this.each(function(){var c=a(this),d=c.outerWidth(),g=c.outerHeight(),h=parseInt(a.curCSS(this,"marginLeft",!0))||0,i=parseInt(a.curCSS(this,"marginTop",!0))||0,o=d+h+(parseInt(a.curCSS(this,"marginRight",!0))||0),p=g+i+(parseInt(a.curCSS(this,"marginBottom",!0))||0),q=a.extend({},n),r;b.my[0]==="right"?q.left-=d:b.my[0]===e&&(q.left-=d/2),b.my[1]==="bottom"?q.top-=g:b.my[1]===e&&(q.top-=g/2),f.fractions||(q.left=Math.round(q.left),q.top=Math.round(q.top)),r={left:q.left-h,top:q.top-i},a.each(["left","top"],function(c,e){a.ui.position[j[c]]&&a.ui.position[j[c]][e](q,{targetWidth:l,targetHeight:m,elemWidth:d,elemHeight:g,collisionPosition:r,collisionWidth:o,collisionHeight:p,offset:k,my:b.my,at:b.at})}),a.fn.bgiframe&&c.bgiframe(),c.offset(a.extend(q,{using:b.using}))})},a.ui.position={fit:{left:function(b,c){var d=a(window),e=c.collisionPosition.left+c.collisionWidth-d.width()-d.scrollLeft();b.left=e>0?b.left-e:Math.max(b.left-c.collisionPosition.left,b.left)},top:function(b,c){var d=a(window),e=c.collisionPosition.top+c.collisionHeight-d.height()-d.scrollTop();b.top=e>0?b.top-e:Math.max(b.top-c.collisionPosition.top,b.top)}},flip:{left:function(b,c){if(c.at[0]===e)return;var d=a(window),f=c.collisionPosition.left+c.collisionWidth-d.width()-d.scrollLeft(),g=c.my[0]==="left"?-c.elemWidth:c.my[0]==="right"?c.elemWidth:0,h=c.at[0]==="left"?c.targetWidth:-c.targetWidth,i=-2*c.offset[0];b.left+=c.collisionPosition.left<0?g+h+i:f>0?g+h+i:0},top:function(b,c){if(c.at[1]===e)return;var d=a(window),f=c.collisionPosition.top+c.collisionHeight-d.height()-d.scrollTop(),g=c.my[1]==="top"?-c.elemHeight:c.my[1]==="bottom"?c.elemHeight:0,h=c.at[1]==="top"?c.targetHeight:-c.targetHeight,i=-2*c.offset[1];b.top+=c.collisionPosition.top<0?g+h+i:f>0?g+h+i:0}}},a.offset.setOffset||(a.offset.setOffset=function(b,c){/static/.test(a.curCSS(b,"position"))&&(b.style.position="relative");var d=a(b),e=d.offset(),f=parseInt(a.curCSS(b,"top",!0),10)||0,g=parseInt(a.curCSS(b,"left",!0),10)||0,h={top:c.top-e.top+f,left:c.left-e.left+g};"using"in c?c.using.call(b,h):d.css(h)},a.fn.offset=function(b){var c=this[0];return!c||!c.ownerDocument?null:b?a.isFunction(b)?this.each(function(c){a(this).offset(b.call(this,c,a(this).offset()))}):this.each(function(){a.offset.setOffset(this,b)}):h.call(this)}),a.curCSS||(a.curCSS=a.css),function(){var b=document.getElementsByTagName("body")[0],c=document.createElement("div"),d,e,g,h,i;d=document.createElement(b?"div":"body"),g={visibility:"hidden",width:0,height:0,border:0,margin:0,background:"none"},b&&a.extend(g,{position:"absolute",left:"-1000px",top:"-1000px"});for(var j in g)d.style[j]=g[j];d.appendChild(c),e=b||document.documentElement,e.insertBefore(d,e.firstChild),c.style.cssText="position: absolute; left: 10.7432222px; top: 10.432325px; height: 30px; width: 201px;",h=a(c).offset(function(a,b){return b}).offset(),d.innerHTML="",e.removeChild(d),i=h.top+h.left+(b?2e3:0),f.fractions=i>21&&i<22}()})(jQuery);;/*! jQuery UI - v1.8.23 - 2012-08-15
* https://github.com/jquery/jquery-ui
* Includes: jquery.ui.draggable.js
* Copyright (c) 2012 AUTHORS.txt; Licensed MIT, GPL */
(function(a,b){a.widget("ui.draggable",a.ui.mouse,{widgetEventPrefix:"drag",options:{addClasses:!0,appendTo:"parent",axis:!1,connectToSortable:!1,containment:!1,cursor:"auto",cursorAt:!1,grid:!1,handle:!1,helper:"original",iframeFix:!1,opacity:!1,refreshPositions:!1,revert:!1,revertDuration:500,scope:"default",scroll:!0,scrollSensitivity:20,scrollSpeed:20,snap:!1,snapMode:"both",snapTolerance:20,stack:!1,zIndex:!1},_create:function(){this.options.helper=="original"&&!/^(?:r|a|f)/.test(this.element.css("position"))&&(this.element[0].style.position="relative"),this.options.addClasses&&this.element.addClass("ui-draggable"),this.options.disabled&&this.element.addClass("ui-draggable-disabled"),this._mouseInit()},destroy:function(){if(!this.element.data("draggable"))return;return this.element.removeData("draggable").unbind(".draggable").removeClass("ui-draggable ui-draggable-dragging ui-draggable-disabled"),this._mouseDestroy(),this},_mouseCapture:function(b){var c=this.options;return this.helper||c.disabled||a(b.target).is(".ui-resizable-handle")?!1:(this.handle=this._getHandle(b),this.handle?(c.iframeFix&&a(c.iframeFix===!0?"iframe":c.iframeFix).each(function(){a('<div class="ui-draggable-iframeFix" style="background: #fff;"></div>').css({width:this.offsetWidth+"px",height:this.offsetHeight+"px",position:"absolute",opacity:"0.001",zIndex:1e3}).css(a(this).offset()).appendTo("body")}),!0):!1)},_mouseStart:function(b){var c=this.options;return this.helper=this._createHelper(b),this.helper.addClass("ui-draggable-dragging"),this._cacheHelperProportions(),a.ui.ddmanager&&(a.ui.ddmanager.current=this),this._cacheMargins(),this.cssPosition=this.helper.css("position"),this.scrollParent=this.helper.scrollParent(),this.offset=this.positionAbs=this.element.offset(),this.offset={top:this.offset.top-this.margins.top,left:this.offset.left-this.margins.left},a.extend(this.offset,{click:{left:b.pageX-this.offset.left,top:b.pageY-this.offset.top},parent:this._getParentOffset(),relative:this._getRelativeOffset()}),this.originalPosition=this.position=this._generatePosition(b),this.originalPageX=b.pageX,this.originalPageY=b.pageY,c.cursorAt&&this._adjustOffsetFromHelper(c.cursorAt),c.containment&&this._setContainment(),this._trigger("start",b)===!1?(this._clear(),!1):(this._cacheHelperProportions(),a.ui.ddmanager&&!c.dropBehaviour&&a.ui.ddmanager.prepareOffsets(this,b),this._mouseDrag(b,!0),a.ui.ddmanager&&a.ui.ddmanager.dragStart(this,b),!0)},_mouseDrag:function(b,c){this.position=this._generatePosition(b),this.positionAbs=this._convertPositionTo("absolute");if(!c){var d=this._uiHash();if(this._trigger("drag",b,d)===!1)return this._mouseUp({}),!1;this.position=d.position}if(!this.options.axis||this.options.axis!="y")this.helper[0].style.left=this.position.left+"px";if(!this.options.axis||this.options.axis!="x")this.helper[0].style.top=this.position.top+"px";return a.ui.ddmanager&&a.ui.ddmanager.drag(this,b),!1},_mouseStop:function(b){var c=!1;a.ui.ddmanager&&!this.options.dropBehaviour&&(c=a.ui.ddmanager.drop(this,b)),this.dropped&&(c=this.dropped,this.dropped=!1);var d=this.element[0],e=!1;while(d&&(d=d.parentNode))d==document&&(e=!0);if(!e&&this.options.helper==="original")return!1;if(this.options.revert=="invalid"&&!c||this.options.revert=="valid"&&c||this.options.revert===!0||a.isFunction(this.options.revert)&&this.options.revert.call(this.element,c)){var f=this;a(this.helper).animate(this.originalPosition,parseInt(this.options.revertDuration,10),function(){f._trigger("stop",b)!==!1&&f._clear()})}else this._trigger("stop",b)!==!1&&this._clear();return!1},_mouseUp:function(b){return this.options.iframeFix===!0&&a("div.ui-draggable-iframeFix").each(function(){this.parentNode.removeChild(this)}),a.ui.ddmanager&&a.ui.ddmanager.dragStop(this,b),a.ui.mouse.prototype._mouseUp.call(this,b)},cancel:function(){return this.helper.is(".ui-draggable-dragging")?this._mouseUp({}):this._clear(),this},_getHandle:function(b){var c=!this.options.handle||!a(this.options.handle,this.element).length?!0:!1;return a(this.options.handle,this.element).find("*").andSelf().each(function(){this==b.target&&(c=!0)}),c},_createHelper:function(b){var c=this.options,d=a.isFunction(c.helper)?a(c.helper.apply(this.element[0],[b])):c.helper=="clone"?this.element.clone().removeAttr("id"):this.element;return d.parents("body").length||d.appendTo(c.appendTo=="parent"?this.element[0].parentNode:c.appendTo),d[0]!=this.element[0]&&!/(fixed|absolute)/.test(d.css("position"))&&d.css("position","absolute"),d},_adjustOffsetFromHelper:function(b){typeof b=="string"&&(b=b.split(" ")),a.isArray(b)&&(b={left:+b[0],top:+b[1]||0}),"left"in b&&(this.offset.click.left=b.left+this.margins.left),"right"in b&&(this.offset.click.left=this.helperProportions.width-b.right+this.margins.left),"top"in b&&(this.offset.click.top=b.top+this.margins.top),"bottom"in b&&(this.offset.click.top=this.helperProportions.height-b.bottom+this.margins.top)},_getParentOffset:function(){this.offsetParent=this.helper.offsetParent();var b=this.offsetParent.offset();this.cssPosition=="absolute"&&this.scrollParent[0]!=document&&a.ui.contains(this.scrollParent[0],this.offsetParent[0])&&(b.left+=this.scrollParent.scrollLeft(),b.top+=this.scrollParent.scrollTop());if(this.offsetParent[0]==document.body||this.offsetParent[0].tagName&&this.offsetParent[0].tagName.toLowerCase()=="html"&&a.browser.msie)b={top:0,left:0};return{top:b.top+(parseInt(this.offsetParent.css("borderTopWidth"),10)||0),left:b.left+(parseInt(this.offsetParent.css("borderLeftWidth"),10)||0)}},_getRelativeOffset:function(){if(this.cssPosition=="relative"){var a=this.element.position();return{top:a.top-(parseInt(this.helper.css("top"),10)||0)+this.scrollParent.scrollTop(),left:a.left-(parseInt(this.helper.css("left"),10)||0)+this.scrollParent.scrollLeft()}}return{top:0,left:0}},_cacheMargins:function(){this.margins={left:parseInt(this.element.css("marginLeft"),10)||0,top:parseInt(this.element.css("marginTop"),10)||0,right:parseInt(this.element.css("marginRight"),10)||0,bottom:parseInt(this.element.css("marginBottom"),10)||0}},_cacheHelperProportions:function(){this.helperProportions={width:this.helper.outerWidth(),height:this.helper.outerHeight()}},_setContainment:function(){var b=this.options;b.containment=="parent"&&(b.containment=this.helper[0].parentNode);if(b.containment=="document"||b.containment=="window")this.containment=[b.containment=="document"?0:a(window).scrollLeft()-this.offset.relative.left-this.offset.parent.left,b.containment=="document"?0:a(window).scrollTop()-this.offset.relative.top-this.offset.parent.top,(b.containment=="document"?0:a(window).scrollLeft())+a(b.containment=="document"?document:window).width()-this.helperProportions.width-this.margins.left,(b.containment=="document"?0:a(window).scrollTop())+(a(b.containment=="document"?document:window).height()||document.body.parentNode.scrollHeight)-this.helperProportions.height-this.margins.top];if(!/^(document|window|parent)$/.test(b.containment)&&b.containment.constructor!=Array){var c=a(b.containment),d=c[0];if(!d)return;var e=c.offset(),f=a(d).css("overflow")!="hidden";this.containment=[(parseInt(a(d).css("borderLeftWidth"),10)||0)+(parseInt(a(d).css("paddingLeft"),10)||0),(parseInt(a(d).css("borderTopWidth"),10)||0)+(parseInt(a(d).css("paddingTop"),10)||0),(f?Math.max(d.scrollWidth,d.offsetWidth):d.offsetWidth)-(parseInt(a(d).css("borderLeftWidth"),10)||0)-(parseInt(a(d).css("paddingRight"),10)||0)-this.helperProportions.width-this.margins.left-this.margins.right,(f?Math.max(d.scrollHeight,d.offsetHeight):d.offsetHeight)-(parseInt(a(d).css("borderTopWidth"),10)||0)-(parseInt(a(d).css("paddingBottom"),10)||0)-this.helperProportions.height-this.margins.top-this.margins.bottom],this.relative_container=c}else b.containment.constructor==Array&&(this.containment=b.containment)},_convertPositionTo:function(b,c){c||(c=this.position);var d=b=="absolute"?1:-1,e=this.options,f=this.cssPosition=="absolute"&&(this.scrollParent[0]==document||!a.ui.contains(this.scrollParent[0],this.offsetParent[0]))?this.offsetParent:this.scrollParent,g=/(html|body)/i.test(f[0].tagName);return{top:c.top+this.offset.relative.top*d+this.offset.parent.top*d-(a.browser.safari&&a.browser.version<526&&this.cssPosition=="fixed"?0:(this.cssPosition=="fixed"?-this.scrollParent.scrollTop():g?0:f.scrollTop())*d),left:c.left+this.offset.relative.left*d+this.offset.parent.left*d-(a.browser.safari&&a.browser.version<526&&this.cssPosition=="fixed"?0:(this.cssPosition=="fixed"?-this.scrollParent.scrollLeft():g?0:f.scrollLeft())*d)}},_generatePosition:function(b){var c=this.options,d=this.cssPosition=="absolute"&&(this.scrollParent[0]==document||!a.ui.contains(this.scrollParent[0],this.offsetParent[0]))?this.offsetParent:this.scrollParent,e=/(html|body)/i.test(d[0].tagName),f=b.pageX,g=b.pageY;if(this.originalPosition){var h;if(this.containment){if(this.relative_container){var i=this.relative_container.offset();h=[this.containment[0]+i.left,this.containment[1]+i.top,this.containment[2]+i.left,this.containment[3]+i.top]}else h=this.containment;b.pageX-this.offset.click.left<h[0]&&(f=h[0]+this.offset.click.left),b.pageY-this.offset.click.top<h[1]&&(g=h[1]+this.offset.click.top),b.pageX-this.offset.click.left>h[2]&&(f=h[2]+this.offset.click.left),b.pageY-this.offset.click.top>h[3]&&(g=h[3]+this.offset.click.top)}if(c.grid){var j=c.grid[1]?this.originalPageY+Math.round((g-this.originalPageY)/c.grid[1])*c.grid[1]:this.originalPageY;g=h?j-this.offset.click.top<h[1]||j-this.offset.click.top>h[3]?j-this.offset.click.top<h[1]?j+c.grid[1]:j-c.grid[1]:j:j;var k=c.grid[0]?this.originalPageX+Math.round((f-this.originalPageX)/c.grid[0])*c.grid[0]:this.originalPageX;f=h?k-this.offset.click.left<h[0]||k-this.offset.click.left>h[2]?k-this.offset.click.left<h[0]?k+c.grid[0]:k-c.grid[0]:k:k}}return{top:g-this.offset.click.top-this.offset.relative.top-this.offset.parent.top+(a.browser.safari&&a.browser.version<526&&this.cssPosition=="fixed"?0:this.cssPosition=="fixed"?-this.scrollParent.scrollTop():e?0:d.scrollTop()),left:f-this.offset.click.left-this.offset.relative.left-this.offset.parent.left+(a.browser.safari&&a.browser.version<526&&this.cssPosition=="fixed"?0:this.cssPosition=="fixed"?-this.scrollParent.scrollLeft():e?0:d.scrollLeft())}},_clear:function(){this.helper.removeClass("ui-draggable-dragging"),this.helper[0]!=this.element[0]&&!this.cancelHelperRemoval&&this.helper.remove(),this.helper=null,this.cancelHelperRemoval=!1},_trigger:function(b,c,d){return d=d||this._uiHash(),a.ui.plugin.call(this,b,[c,d]),b=="drag"&&(this.positionAbs=this._convertPositionTo("absolute")),a.Widget.prototype._trigger.call(this,b,c,d)},plugins:{},_uiHash:function(a){return{helper:this.helper,position:this.position,originalPosition:this.originalPosition,offset:this.positionAbs}}}),a.extend(a.ui.draggable,{version:"1.8.23"}),a.ui.plugin.add("draggable","connectToSortable",{start:function(b,c){var d=a(this).data("draggable"),e=d.options,f=a.extend({},c,{item:d.element});d.sortables=[],a(e.connectToSortable).each(function(){var c=a.data(this,"sortable");c&&!c.options.disabled&&(d.sortables.push({instance:c,shouldRevert:c.options.revert}),c.refreshPositions(),c._trigger("activate",b,f))})},stop:function(b,c){var d=a(this).data("draggable"),e=a.extend({},c,{item:d.element});a.each(d.sortables,function(){this.instance.isOver?(this.instance.isOver=0,d.cancelHelperRemoval=!0,this.instance.cancelHelperRemoval=!1,this.shouldRevert&&(this.instance.options.revert=!0),this.instance._mouseStop(b),this.instance.options.helper=this.instance.options._helper,d.options.helper=="original"&&this.instance.currentItem.css({top:"auto",left:"auto"})):(this.instance.cancelHelperRemoval=!1,this.instance._trigger("deactivate",b,e))})},drag:function(b,c){var d=a(this).data("draggable"),e=this,f=function(b){var c=this.offset.click.top,d=this.offset.click.left,e=this.positionAbs.top,f=this.positionAbs.left,g=b.height,h=b.width,i=b.top,j=b.left;return a.ui.isOver(e+c,f+d,i,j,g,h)};a.each(d.sortables,function(f){this.instance.positionAbs=d.positionAbs,this.instance.helperProportions=d.helperProportions,this.instance.offset.click=d.offset.click,this.instance._intersectsWith(this.instance.containerCache)?(this.instance.isOver||(this.instance.isOver=1,this.instance.currentItem=a(e).clone().removeAttr("id").appendTo(this.instance.element).data("sortable-item",!0),this.instance.options._helper=this.instance.options.helper,this.instance.options.helper=function(){return c.helper[0]},b.target=this.instance.currentItem[0],this.instance._mouseCapture(b,!0),this.instance._mouseStart(b,!0,!0),this.instance.offset.click.top=d.offset.click.top,this.instance.offset.click.left=d.offset.click.left,this.instance.offset.parent.left-=d.offset.parent.left-this.instance.offset.parent.left,this.instance.offset.parent.top-=d.offset.parent.top-this.instance.offset.parent.top,d._trigger("toSortable",b),d.dropped=this.instance.element,d.currentItem=d.element,this.instance.fromOutside=d),this.instance.currentItem&&this.instance._mouseDrag(b)):this.instance.isOver&&(this.instance.isOver=0,this.instance.cancelHelperRemoval=!0,this.instance.options.revert=!1,this.instance._trigger("out",b,this.instance._uiHash(this.instance)),this.instance._mouseStop(b,!0),this.instance.options.helper=this.instance.options._helper,this.instance.currentItem.remove(),this.instance.placeholder&&this.instance.placeholder.remove(),d._trigger("fromSortable",b),d.dropped=!1)})}}),a.ui.plugin.add("draggable","cursor",{start:function(b,c){var d=a("body"),e=a(this).data("draggable").options;d.css("cursor")&&(e._cursor=d.css("cursor")),d.css("cursor",e.cursor)},stop:function(b,c){var d=a(this).data("draggable").options;d._cursor&&a("body").css("cursor",d._cursor)}}),a.ui.plugin.add("draggable","opacity",{start:function(b,c){var d=a(c.helper),e=a(this).data("draggable").options;d.css("opacity")&&(e._opacity=d.css("opacity")),d.css("opacity",e.opacity)},stop:function(b,c){var d=a(this).data("draggable").options;d._opacity&&a(c.helper).css("opacity",d._opacity)}}),a.ui.plugin.add("draggable","scroll",{start:function(b,c){var d=a(this).data("draggable");d.scrollParent[0]!=document&&d.scrollParent[0].tagName!="HTML"&&(d.overflowOffset=d.scrollParent.offset())},drag:function(b,c){var d=a(this).data("draggable"),e=d.options,f=!1;if(d.scrollParent[0]!=document&&d.scrollParent[0].tagName!="HTML"){if(!e.axis||e.axis!="x")d.overflowOffset.top+d.scrollParent[0].offsetHeight-b.pageY<e.scrollSensitivity?d.scrollParent[0].scrollTop=f=d.scrollParent[0].scrollTop+e.scrollSpeed:b.pageY-d.overflowOffset.top<e.scrollSensitivity&&(d.scrollParent[0].scrollTop=f=d.scrollParent[0].scrollTop-e.scrollSpeed);if(!e.axis||e.axis!="y")d.overflowOffset.left+d.scrollParent[0].offsetWidth-b.pageX<e.scrollSensitivity?d.scrollParent[0].scrollLeft=f=d.scrollParent[0].scrollLeft+e.scrollSpeed:b.pageX-d.overflowOffset.left<e.scrollSensitivity&&(d.scrollParent[0].scrollLeft=f=d.scrollParent[0].scrollLeft-e.scrollSpeed)}else{if(!e.axis||e.axis!="x")b.pageY-a(document).scrollTop()<e.scrollSensitivity?f=a(document).scrollTop(a(document).scrollTop()-e.scrollSpeed):a(window).height()-(b.pageY-a(document).scrollTop())<e.scrollSensitivity&&(f=a(document).scrollTop(a(document).scrollTop()+e.scrollSpeed));if(!e.axis||e.axis!="y")b.pageX-a(document).scrollLeft()<e.scrollSensitivity?f=a(document).scrollLeft(a(document).scrollLeft()-e.scrollSpeed):a(window).width()-(b.pageX-a(document).scrollLeft())<e.scrollSensitivity&&(f=a(document).scrollLeft(a(document).scrollLeft()+e.scrollSpeed))}f!==!1&&a.ui.ddmanager&&!e.dropBehaviour&&a.ui.ddmanager.prepareOffsets(d,b)}}),a.ui.plugin.add("draggable","snap",{start:function(b,c){var d=a(this).data("draggable"),e=d.options;d.snapElements=[],a(e.snap.constructor!=String?e.snap.items||":data(draggable)":e.snap).each(function(){var b=a(this),c=b.offset();this!=d.element[0]&&d.snapElements.push({item:this,width:b.outerWidth(),height:b.outerHeight(),top:c.top,left:c.left})})},drag:function(b,c){var d=a(this).data("draggable"),e=d.options,f=e.snapTolerance,g=c.offset.left,h=g+d.helperProportions.width,i=c.offset.top,j=i+d.helperProportions.height;for(var k=d.snapElements.length-1;k>=0;k--){var l=d.snapElements[k].left,m=l+d.snapElements[k].width,n=d.snapElements[k].top,o=n+d.snapElements[k].height;if(!(l-f<g&&g<m+f&&n-f<i&&i<o+f||l-f<g&&g<m+f&&n-f<j&&j<o+f||l-f<h&&h<m+f&&n-f<i&&i<o+f||l-f<h&&h<m+f&&n-f<j&&j<o+f)){d.snapElements[k].snapping&&d.options.snap.release&&d.options.snap.release.call(d.element,b,a.extend(d._uiHash(),{snapItem:d.snapElements[k].item})),d.snapElements[k].snapping=!1;continue}if(e.snapMode!="inner"){var p=Math.abs(n-j)<=f,q=Math.abs(o-i)<=f,r=Math.abs(l-h)<=f,s=Math.abs(m-g)<=f;p&&(c.position.top=d._convertPositionTo("relative",{top:n-d.helperProportions.height,left:0}).top-d.margins.top),q&&(c.position.top=d._convertPositionTo("relative",{top:o,left:0}).top-d.margins.top),r&&(c.position.left=d._convertPositionTo("relative",{top:0,left:l-d.helperProportions.width}).left-d.margins.left),s&&(c.position.left=d._convertPositionTo("relative",{top:0,left:m}).left-d.margins.left)}var t=p||q||r||s;if(e.snapMode!="outer"){var p=Math.abs(n-i)<=f,q=Math.abs(o-j)<=f,r=Math.abs(l-g)<=f,s=Math.abs(m-h)<=f;p&&(c.position.top=d._convertPositionTo("relative",{top:n,left:0}).top-d.margins.top),q&&(c.position.top=d._convertPositionTo("relative",{top:o-d.helperProportions.height,left:0}).top-d.margins.top),r&&(c.position.left=d._convertPositionTo("relative",{top:0,left:l}).left-d.margins.left),s&&(c.position.left=d._convertPositionTo("relative",{top:0,left:m-d.helperProportions.width}).left-d.margins.left)}!d.snapElements[k].snapping&&(p||q||r||s||t)&&d.options.snap.snap&&d.options.snap.snap.call(d.element,b,a.extend(d._uiHash(),{snapItem:d.snapElements[k].item})),d.snapElements[k].snapping=p||q||r||s||t}}}),a.ui.plugin.add("draggable","stack",{start:function(b,c){var d=a(this).data("draggable").options,e=a.makeArray(a(d.stack)).sort(function(b,c){return(parseInt(a(b).css("zIndex"),10)||0)-(parseInt(a(c).css("zIndex"),10)||0)});if(!e.length)return;var f=parseInt(e[0].style.zIndex)||0;a(e).each(function(a){this.style.zIndex=f+a}),this[0].style.zIndex=f+e.length}}),a.ui.plugin.add("draggable","zIndex",{start:function(b,c){var d=a(c.helper),e=a(this).data("draggable").options;d.css("zIndex")&&(e._zIndex=d.css("zIndex")),d.css("zIndex",e.zIndex)},stop:function(b,c){var d=a(this).data("draggable").options;d._zIndex&&a(c.helper).css("zIndex",d._zIndex)}})})(jQuery);;/*! jQuery UI - v1.8.23 - 2012-08-15
* https://github.com/jquery/jquery-ui
* Includes: jquery.ui.droppable.js
* Copyright (c) 2012 AUTHORS.txt; Licensed MIT, GPL */
(function(a,b){a.widget("ui.droppable",{widgetEventPrefix:"drop",options:{accept:"*",activeClass:!1,addClasses:!0,greedy:!1,hoverClass:!1,scope:"default",tolerance:"intersect"},_create:function(){var b=this.options,c=b.accept;this.isover=0,this.isout=1,this.accept=a.isFunction(c)?c:function(a){return a.is(c)},this.proportions={width:this.element[0].offsetWidth,height:this.element[0].offsetHeight},a.ui.ddmanager.droppables[b.scope]=a.ui.ddmanager.droppables[b.scope]||[],a.ui.ddmanager.droppables[b.scope].push(this),b.addClasses&&this.element.addClass("ui-droppable")},destroy:function(){var b=a.ui.ddmanager.droppables[this.options.scope];for(var c=0;c<b.length;c++)b[c]==this&&b.splice(c,1);return this.element.removeClass("ui-droppable ui-droppable-disabled").removeData("droppable").unbind(".droppable"),this},_setOption:function(b,c){b=="accept"&&(this.accept=a.isFunction(c)?c:function(a){return a.is(c)}),a.Widget.prototype._setOption.apply(this,arguments)},_activate:function(b){var c=a.ui.ddmanager.current;this.options.activeClass&&this.element.addClass(this.options.activeClass),c&&this._trigger("activate",b,this.ui(c))},_deactivate:function(b){var c=a.ui.ddmanager.current;this.options.activeClass&&this.element.removeClass(this.options.activeClass),c&&this._trigger("deactivate",b,this.ui(c))},_over:function(b){var c=a.ui.ddmanager.current;if(!c||(c.currentItem||c.element)[0]==this.element[0])return;this.accept.call(this.element[0],c.currentItem||c.element)&&(this.options.hoverClass&&this.element.addClass(this.options.hoverClass),this._trigger("over",b,this.ui(c)))},_out:function(b){var c=a.ui.ddmanager.current;if(!c||(c.currentItem||c.element)[0]==this.element[0])return;this.accept.call(this.element[0],c.currentItem||c.element)&&(this.options.hoverClass&&this.element.removeClass(this.options.hoverClass),this._trigger("out",b,this.ui(c)))},_drop:function(b,c){var d=c||a.ui.ddmanager.current;if(!d||(d.currentItem||d.element)[0]==this.element[0])return!1;var e=!1;return this.element.find(":data(droppable)").not(".ui-draggable-dragging").each(function(){var b=a.data(this,"droppable");if(b.options.greedy&&!b.options.disabled&&b.options.scope==d.options.scope&&b.accept.call(b.element[0],d.currentItem||d.element)&&a.ui.intersect(d,a.extend(b,{offset:b.element.offset()}),b.options.tolerance))return e=!0,!1}),e?!1:this.accept.call(this.element[0],d.currentItem||d.element)?(this.options.activeClass&&this.element.removeClass(this.options.activeClass),this.options.hoverClass&&this.element.removeClass(this.options.hoverClass),this._trigger("drop",b,this.ui(d)),this.element):!1},ui:function(a){return{draggable:a.currentItem||a.element,helper:a.helper,position:a.position,offset:a.positionAbs}}}),a.extend(a.ui.droppable,{version:"1.8.23"}),a.ui.intersect=function(b,c,d){if(!c.offset)return!1;var e=(b.positionAbs||b.position.absolute).left,f=e+b.helperProportions.width,g=(b.positionAbs||b.position.absolute).top,h=g+b.helperProportions.height,i=c.offset.left,j=i+c.proportions.width,k=c.offset.top,l=k+c.proportions.height;switch(d){case"fit":return i<=e&&f<=j&&k<=g&&h<=l;case"intersect":return i<e+b.helperProportions.width/2&&f-b.helperProportions.width/2<j&&k<g+b.helperProportions.height/2&&h-b.helperProportions.height/2<l;case"pointer":var m=(b.positionAbs||b.position.absolute).left+(b.clickOffset||b.offset.click).left,n=(b.positionAbs||b.position.absolute).top+(b.clickOffset||b.offset.click).top,o=a.ui.isOver(n,m,k,i,c.proportions.height,c.proportions.width);return o;case"touch":return(g>=k&&g<=l||h>=k&&h<=l||g<k&&h>l)&&(e>=i&&e<=j||f>=i&&f<=j||e<i&&f>j);default:return!1}},a.ui.ddmanager={current:null,droppables:{"default":[]},prepareOffsets:function(b,c){var d=a.ui.ddmanager.droppables[b.options.scope]||[],e=c?c.type:null,f=(b.currentItem||b.element).find(":data(droppable)").andSelf();g:for(var h=0;h<d.length;h++){if(d[h].options.disabled||b&&!d[h].accept.call(d[h].element[0],b.currentItem||b.element))continue;for(var i=0;i<f.length;i++)if(f[i]==d[h].element[0]){d[h].proportions.height=0;continue g}d[h].visible=d[h].element.css("display")!="none";if(!d[h].visible)continue;e=="mousedown"&&d[h]._activate.call(d[h],c),d[h].offset=d[h].element.offset(),d[h].proportions={width:d[h].element[0].offsetWidth,height:d[h].element[0].offsetHeight}}},drop:function(b,c){var d=!1;return a.each(a.ui.ddmanager.droppables[b.options.scope]||[],function(){if(!this.options)return;!this.options.disabled&&this.visible&&a.ui.intersect(b,this,this.options.tolerance)&&(d=this._drop.call(this,c)||d),!this.options.disabled&&this.visible&&this.accept.call(this.element[0],b.currentItem||b.element)&&(this.isout=1,this.isover=0,this._deactivate.call(this,c))}),d},dragStart:function(b,c){b.element.parents(":not(body,html)").bind("scroll.droppable",function(){b.options.refreshPositions||a.ui.ddmanager.prepareOffsets(b,c)})},drag:function(b,c){b.options.refreshPositions&&a.ui.ddmanager.prepareOffsets(b,c),a.each(a.ui.ddmanager.droppables[b.options.scope]||[],function(){if(this.options.disabled||this.greedyChild||!this.visible)return;var d=a.ui.intersect(b,this,this.options.tolerance),e=!d&&this.isover==1?"isout":d&&this.isover==0?"isover":null;if(!e)return;var f;if(this.options.greedy){var g=this.element.parents(":data(droppable):eq(0)");g.length&&(f=a.data(g[0],"droppable"),f.greedyChild=e=="isover"?1:0)}f&&e=="isover"&&(f.isover=0,f.isout=1,f._out.call(f,c)),this[e]=1,this[e=="isout"?"isover":"isout"]=0,this[e=="isover"?"_over":"_out"].call(this,c),f&&e=="isout"&&(f.isout=0,f.isover=1,f._over.call(f,c))})},dragStop:function(b,c){b.element.parents(":not(body,html)").unbind("scroll.droppable"),b.options.refreshPositions||a.ui.ddmanager.prepareOffsets(b,c)}}})(jQuery);;/*! jQuery UI - v1.8.23 - 2012-08-15
* https://github.com/jquery/jquery-ui
* Includes: jquery.ui.resizable.js
* Copyright (c) 2012 AUTHORS.txt; Licensed MIT, GPL */
(function(a,b){a.widget("ui.resizable",a.ui.mouse,{widgetEventPrefix:"resize",options:{alsoResize:!1,animate:!1,animateDuration:"slow",animateEasing:"swing",aspectRatio:!1,autoHide:!1,containment:!1,ghost:!1,grid:!1,handles:"e,s,se",helper:!1,maxHeight:null,maxWidth:null,minHeight:10,minWidth:10,zIndex:1e3},_create:function(){var b=this,c=this.options;this.element.addClass("ui-resizable"),a.extend(this,{_aspectRatio:!!c.aspectRatio,aspectRatio:c.aspectRatio,originalElement:this.element,_proportionallyResizeElements:[],_helper:c.helper||c.ghost||c.animate?c.helper||"ui-resizable-helper":null}),this.element[0].nodeName.match(/canvas|textarea|input|select|button|img/i)&&(this.element.wrap(a('<div class="ui-wrapper" style="overflow: hidden;"></div>').css({position:this.element.css("position"),width:this.element.outerWidth(),height:this.element.outerHeight(),top:this.element.css("top"),left:this.element.css("left")})),this.element=this.element.parent().data("resizable",this.element.data("resizable")),this.elementIsWrapper=!0,this.element.css({marginLeft:this.originalElement.css("marginLeft"),marginTop:this.originalElement.css("marginTop"),marginRight:this.originalElement.css("marginRight"),marginBottom:this.originalElement.css("marginBottom")}),this.originalElement.css({marginLeft:0,marginTop:0,marginRight:0,marginBottom:0}),this.originalResizeStyle=this.originalElement.css("resize"),this.originalElement.css("resize","none"),this._proportionallyResizeElements.push(this.originalElement.css({position:"static",zoom:1,display:"block"})),this.originalElement.css({margin:this.originalElement.css("margin")}),this._proportionallyResize()),this.handles=c.handles||(a(".ui-resizable-handle",this.element).length?{n:".ui-resizable-n",e:".ui-resizable-e",s:".ui-resizable-s",w:".ui-resizable-w",se:".ui-resizable-se",sw:".ui-resizable-sw",ne:".ui-resizable-ne",nw:".ui-resizable-nw"}:"e,s,se");if(this.handles.constructor==String){this.handles=="all"&&(this.handles="n,e,s,w,se,sw,ne,nw");var d=this.handles.split(",");this.handles={};for(var e=0;e<d.length;e++){var f=a.trim(d[e]),g="ui-resizable-"+f,h=a('<div class="ui-resizable-handle '+g+'"></div>');h.css({zIndex:c.zIndex}),"se"==f&&h.addClass("ui-icon ui-icon-gripsmall-diagonal-se"),this.handles[f]=".ui-resizable-"+f,this.element.append(h)}}this._renderAxis=function(b){b=b||this.element;for(var c in this.handles){this.handles[c].constructor==String&&(this.handles[c]=a(this.handles[c],this.element).show());if(this.elementIsWrapper&&this.originalElement[0].nodeName.match(/textarea|input|select|button/i)){var d=a(this.handles[c],this.element),e=0;e=/sw|ne|nw|se|n|s/.test(c)?d.outerHeight():d.outerWidth();var f=["padding",/ne|nw|n/.test(c)?"Top":/se|sw|s/.test(c)?"Bottom":/^e$/.test(c)?"Right":"Left"].join("");b.css(f,e),this._proportionallyResize()}if(!a(this.handles[c]).length)continue}},this._renderAxis(this.element),this._handles=a(".ui-resizable-handle",this.element).disableSelection(),this._handles.mouseover(function(){if(!b.resizing){if(this.className)var a=this.className.match(/ui-resizable-(se|sw|ne|nw|n|e|s|w)/i);b.axis=a&&a[1]?a[1]:"se"}}),c.autoHide&&(this._handles.hide(),a(this.element).addClass("ui-resizable-autohide").hover(function(){if(c.disabled)return;a(this).removeClass("ui-resizable-autohide"),b._handles.show()},function(){if(c.disabled)return;b.resizing||(a(this).addClass("ui-resizable-autohide"),b._handles.hide())})),this._mouseInit()},destroy:function(){this._mouseDestroy();var b=function(b){a(b).removeClass("ui-resizable ui-resizable-disabled ui-resizable-resizing").removeData("resizable").unbind(".resizable").find(".ui-resizable-handle").remove()};if(this.elementIsWrapper){b(this.element);var c=this.element;c.after(this.originalElement.css({position:c.css("position"),width:c.outerWidth(),height:c.outerHeight(),top:c.css("top"),left:c.css("left")})).remove()}return this.originalElement.css("resize",this.originalResizeStyle),b(this.originalElement),this},_mouseCapture:function(b){var c=!1;for(var d in this.handles)a(this.handles[d])[0]==b.target&&(c=!0);return!this.options.disabled&&c},_mouseStart:function(b){var d=this.options,e=this.element.position(),f=this.element;this.resizing=!0,this.documentScroll={top:a(document).scrollTop(),left:a(document).scrollLeft()},(f.is(".ui-draggable")||/absolute/.test(f.css("position")))&&f.css({position:"absolute",top:e.top,left:e.left}),this._renderProxy();var g=c(this.helper.css("left")),h=c(this.helper.css("top"));d.containment&&(g+=a(d.containment).scrollLeft()||0,h+=a(d.containment).scrollTop()||0),this.offset=this.helper.offset(),this.position={left:g,top:h},this.size=this._helper?{width:f.outerWidth(),height:f.outerHeight()}:{width:f.width(),height:f.height()},this.originalSize=this._helper?{width:f.outerWidth(),height:f.outerHeight()}:{width:f.width(),height:f.height()},this.originalPosition={left:g,top:h},this.sizeDiff={width:f.outerWidth()-f.width(),height:f.outerHeight()-f.height()},this.originalMousePosition={left:b.pageX,top:b.pageY},this.aspectRatio=typeof d.aspectRatio=="number"?d.aspectRatio:this.originalSize.width/this.originalSize.height||1;var i=a(".ui-resizable-"+this.axis).css("cursor");return a("body").css("cursor",i=="auto"?this.axis+"-resize":i),f.addClass("ui-resizable-resizing"),this._propagate("start",b),!0},_mouseDrag:function(b){var c=this.helper,d=this.options,e={},f=this,g=this.originalMousePosition,h=this.axis,i=b.pageX-g.left||0,j=b.pageY-g.top||0,k=this._change[h];if(!k)return!1;var l=k.apply(this,[b,i,j]),m=a.browser.msie&&a.browser.version<7,n=this.sizeDiff;this._updateVirtualBoundaries(b.shiftKey);if(this._aspectRatio||b.shiftKey)l=this._updateRatio(l,b);return l=this._respectSize(l,b),this._propagate("resize",b),c.css({top:this.position.top+"px",left:this.position.left+"px",width:this.size.width+"px",height:this.size.height+"px"}),!this._helper&&this._proportionallyResizeElements.length&&this._proportionallyResize(),this._updateCache(l),this._trigger("resize",b,this.ui()),!1},_mouseStop:function(b){this.resizing=!1;var c=this.options,d=this;if(this._helper){var e=this._proportionallyResizeElements,f=e.length&&/textarea/i.test(e[0].nodeName),g=f&&a.ui.hasScroll(e[0],"left")?0:d.sizeDiff.height,h=f?0:d.sizeDiff.width,i={width:d.helper.width()-h,height:d.helper.height()-g},j=parseInt(d.element.css("left"),10)+(d.position.left-d.originalPosition.left)||null,k=parseInt(d.element.css("top"),10)+(d.position.top-d.originalPosition.top)||null;c.animate||this.element.css(a.extend(i,{top:k,left:j})),d.helper.height(d.size.height),d.helper.width(d.size.width),this._helper&&!c.animate&&this._proportionallyResize()}return a("body").css("cursor","auto"),this.element.removeClass("ui-resizable-resizing"),this._propagate("stop",b),this._helper&&this.helper.remove(),!1},_updateVirtualBoundaries:function(a){var b=this.options,c,e,f,g,h;h={minWidth:d(b.minWidth)?b.minWidth:0,maxWidth:d(b.maxWidth)?b.maxWidth:Infinity,minHeight:d(b.minHeight)?b.minHeight:0,maxHeight:d(b.maxHeight)?b.maxHeight:Infinity};if(this._aspectRatio||a)c=h.minHeight*this.aspectRatio,f=h.minWidth/this.aspectRatio,e=h.maxHeight*this.aspectRatio,g=h.maxWidth/this.aspectRatio,c>h.minWidth&&(h.minWidth=c),f>h.minHeight&&(h.minHeight=f),e<h.maxWidth&&(h.maxWidth=e),g<h.maxHeight&&(h.maxHeight=g);this._vBoundaries=h},_updateCache:function(a){var b=this.options;this.offset=this.helper.offset(),d(a.left)&&(this.position.left=a.left),d(a.top)&&(this.position.top=a.top),d(a.height)&&(this.size.height=a.height),d(a.width)&&(this.size.width=a.width)},_updateRatio:function(a,b){var c=this.options,e=this.position,f=this.size,g=this.axis;return d(a.height)?a.width=a.height*this.aspectRatio:d(a.width)&&(a.height=a.width/this.aspectRatio),g=="sw"&&(a.left=e.left+(f.width-a.width),a.top=null),g=="nw"&&(a.top=e.top+(f.height-a.height),a.left=e.left+(f.width-a.width)),a},_respectSize:function(a,b){var c=this.helper,e=this._vBoundaries,f=this._aspectRatio||b.shiftKey,g=this.axis,h=d(a.width)&&e.maxWidth&&e.maxWidth<a.width,i=d(a.height)&&e.maxHeight&&e.maxHeight<a.height,j=d(a.width)&&e.minWidth&&e.minWidth>a.width,k=d(a.height)&&e.minHeight&&e.minHeight>a.height;j&&(a.width=e.minWidth),k&&(a.height=e.minHeight),h&&(a.width=e.maxWidth),i&&(a.height=e.maxHeight);var l=this.originalPosition.left+this.originalSize.width,m=this.position.top+this.size.height,n=/sw|nw|w/.test(g),o=/nw|ne|n/.test(g);j&&n&&(a.left=l-e.minWidth),h&&n&&(a.left=l-e.maxWidth),k&&o&&(a.top=m-e.minHeight),i&&o&&(a.top=m-e.maxHeight);var p=!a.width&&!a.height;return p&&!a.left&&a.top?a.top=null:p&&!a.top&&a.left&&(a.left=null),a},_proportionallyResize:function(){var b=this.options;if(!this._proportionallyResizeElements.length)return;var c=this.helper||this.element;for(var d=0;d<this._proportionallyResizeElements.length;d++){var e=this._proportionallyResizeElements[d];if(!this.borderDif){var f=[e.css("borderTopWidth"),e.css("borderRightWidth"),e.css("borderBottomWidth"),e.css("borderLeftWidth")],g=[e.css("paddingTop"),e.css("paddingRight"),e.css("paddingBottom"),e.css("paddingLeft")];this.borderDif=a.map(f,function(a,b){var c=parseInt(a,10)||0,d=parseInt(g[b],10)||0;return c+d})}if(!a.browser.msie||!a(c).is(":hidden")&&!a(c).parents(":hidden").length)e.css({height:c.height()-this.borderDif[0]-this.borderDif[2]||0,width:c.width()-this.borderDif[1]-this.borderDif[3]||0});else continue}},_renderProxy:function(){var b=this.element,c=this.options;this.elementOffset=b.offset();if(this._helper){this.helper=this.helper||a('<div style="overflow:hidden;"></div>');var d=a.browser.msie&&a.browser.version<7,e=d?1:0,f=d?2:-1;this.helper.addClass(this._helper).css({width:this.element.outerWidth()+f,height:this.element.outerHeight()+f,position:"absolute",left:this.elementOffset.left-e+"px",top:this.elementOffset.top-e+"px",zIndex:++c.zIndex}),this.helper.appendTo("body").disableSelection()}else this.helper=this.element},_change:{e:function(a,b,c){return{width:this.originalSize.width+b}},w:function(a,b,c){var d=this.options,e=this.originalSize,f=this.originalPosition;return{left:f.left+b,width:e.width-b}},n:function(a,b,c){var d=this.options,e=this.originalSize,f=this.originalPosition;return{top:f.top+c,height:e.height-c}},s:function(a,b,c){return{height:this.originalSize.height+c}},se:function(b,c,d){return a.extend(this._change.s.apply(this,arguments),this._change.e.apply(this,[b,c,d]))},sw:function(b,c,d){return a.extend(this._change.s.apply(this,arguments),this._change.w.apply(this,[b,c,d]))},ne:function(b,c,d){return a.extend(this._change.n.apply(this,arguments),this._change.e.apply(this,[b,c,d]))},nw:function(b,c,d){return a.extend(this._change.n.apply(this,arguments),this._change.w.apply(this,[b,c,d]))}},_propagate:function(b,c){a.ui.plugin.call(this,b,[c,this.ui()]),b!="resize"&&this._trigger(b,c,this.ui())},plugins:{},ui:function(){return{originalElement:this.originalElement,element:this.element,helper:this.helper,position:this.position,size:this.size,originalSize:this.originalSize,originalPosition:this.originalPosition}}}),a.extend(a.ui.resizable,{version:"1.8.23"}),a.ui.plugin.add("resizable","alsoResize",{start:function(b,c){var d=a(this).data("resizable"),e=d.options,f=function(b){a(b).each(function(){var b=a(this);b.data("resizable-alsoresize",{width:parseInt(b.width(),10),height:parseInt(b.height(),10),left:parseInt(b.css("left"),10),top:parseInt(b.css("top"),10)})})};typeof e.alsoResize=="object"&&!e.alsoResize.parentNode?e.alsoResize.length?(e.alsoResize=e.alsoResize[0],f(e.alsoResize)):a.each(e.alsoResize,function(a){f(a)}):f(e.alsoResize)},resize:function(b,c){var d=a(this).data("resizable"),e=d.options,f=d.originalSize,g=d.originalPosition,h={height:d.size.height-f.height||0,width:d.size.width-f.width||0,top:d.position.top-g.top||0,left:d.position.left-g.left||0},i=function(b,d){a(b).each(function(){var b=a(this),e=a(this).data("resizable-alsoresize"),f={},g=d&&d.length?d:b.parents(c.originalElement[0]).length?["width","height"]:["width","height","top","left"];a.each(g,function(a,b){var c=(e[b]||0)+(h[b]||0);c&&c>=0&&(f[b]=c||null)}),b.css(f)})};typeof e.alsoResize=="object"&&!e.alsoResize.nodeType?a.each(e.alsoResize,function(a,b){i(a,b)}):i(e.alsoResize)},stop:function(b,c){a(this).removeData("resizable-alsoresize")}}),a.ui.plugin.add("resizable","animate",{stop:function(b,c){var d=a(this).data("resizable"),e=d.options,f=d._proportionallyResizeElements,g=f.length&&/textarea/i.test(f[0].nodeName),h=g&&a.ui.hasScroll(f[0],"left")?0:d.sizeDiff.height,i=g?0:d.sizeDiff.width,j={width:d.size.width-i,height:d.size.height-h},k=parseInt(d.element.css("left"),10)+(d.position.left-d.originalPosition.left)||null,l=parseInt(d.element.css("top"),10)+(d.position.top-d.originalPosition.top)||null;d.element.animate(a.extend(j,l&&k?{top:l,left:k}:{}),{duration:e.animateDuration,easing:e.animateEasing,step:function(){var c={width:parseInt(d.element.css("width"),10),height:parseInt(d.element.css("height"),10),top:parseInt(d.element.css("top"),10),left:parseInt(d.element.css("left"),10)};f&&f.length&&a(f[0]).css({width:c.width,height:c.height}),d._updateCache(c),d._propagate("resize",b)}})}}),a.ui.plugin.add("resizable","containment",{start:function(b,d){var e=a(this).data("resizable"),f=e.options,g=e.element,h=f.containment,i=h instanceof a?h.get(0):/parent/.test(h)?g.parent().get(0):h;if(!i)return;e.containerElement=a(i);if(/document/.test(h)||h==document)e.containerOffset={left:0,top:0},e.containerPosition={left:0,top:0},e.parentData={element:a(document),left:0,top:0,width:a(document).width(),height:a(document).height()||document.body.parentNode.scrollHeight};else{var j=a(i),k=[];a(["Top","Right","Left","Bottom"]).each(function(a,b){k[a]=c(j.css("padding"+b))}),e.containerOffset=j.offset(),e.containerPosition=j.position(),e.containerSize={height:j.innerHeight()-k[3],width:j.innerWidth()-k[1]};var l=e.containerOffset,m=e.containerSize.height,n=e.containerSize.width,o=a.ui.hasScroll(i,"left")?i.scrollWidth:n,p=a.ui.hasScroll(i)?i.scrollHeight:m;e.parentData={element:i,left:l.left,top:l.top,width:o,height:p}}},resize:function(b,c){var d=a(this).data("resizable"),e=d.options,f=d.containerSize,g=d.containerOffset,h=d.size,i=d.position,j=d._aspectRatio||b.shiftKey,k={top:0,left:0},l=d.containerElement;l[0]!=document&&/static/.test(l.css("position"))&&(k=g),i.left<(d._helper?g.left:0)&&(d.size.width=d.size.width+(d._helper?d.position.left-g.left:d.position.left-k.left),j&&(d.size.height=d.size.width/d.aspectRatio),d.position.left=e.helper?g.left:0),i.top<(d._helper?g.top:0)&&(d.size.height=d.size.height+(d._helper?d.position.top-g.top:d.position.top),j&&(d.size.width=d.size.height*d.aspectRatio),d.position.top=d._helper?g.top:0),d.offset.left=d.parentData.left+d.position.left,d.offset.top=d.parentData.top+d.position.top;var m=Math.abs((d._helper?d.offset.left-k.left:d.offset.left-k.left)+d.sizeDiff.width),n=Math.abs((d._helper?d.offset.top-k.top:d.offset.top-g.top)+d.sizeDiff.height),o=d.containerElement.get(0)==d.element.parent().get(0),p=/relative|absolute/.test(d.containerElement.css("position"));o&&p&&(m-=d.parentData.left),m+d.size.width>=d.parentData.width&&(d.size.width=d.parentData.width-m,j&&(d.size.height=d.size.width/d.aspectRatio)),n+d.size.height>=d.parentData.height&&(d.size.height=d.parentData.height-n,j&&(d.size.width=d.size.height*d.aspectRatio))},stop:function(b,c){var d=a(this).data("resizable"),e=d.options,f=d.position,g=d.containerOffset,h=d.containerPosition,i=d.containerElement,j=a(d.helper),k=j.offset(),l=j.outerWidth()-d.sizeDiff.width,m=j.outerHeight()-d.sizeDiff.height;d._helper&&!e.animate&&/relative/.test(i.css("position"))&&a(this).css({left:k.left-h.left-g.left,width:l,height:m}),d._helper&&!e.animate&&/static/.test(i.css("position"))&&a(this).css({left:k.left-h.left-g.left,width:l,height:m})}}),a.ui.plugin.add("resizable","ghost",{start:function(b,c){var d=a(this).data("resizable"),e=d.options,f=d.size;d.ghost=d.originalElement.clone(),d.ghost.css({opacity:.25,display:"block",position:"relative",height:f.height,width:f.width,margin:0,left:0,top:0}).addClass("ui-resizable-ghost").addClass(typeof e.ghost=="string"?e.ghost:""),d.ghost.appendTo(d.helper)},resize:function(b,c){var d=a(this).data("resizable"),e=d.options;d.ghost&&d.ghost.css({position:"relative",height:d.size.height,width:d.size.width})},stop:function(b,c){var d=a(this).data("resizable"),e=d.options;d.ghost&&d.helper&&d.helper.get(0).removeChild(d.ghost.get(0))}}),a.ui.plugin.add("resizable","grid",{resize:function(b,c){var d=a(this).data("resizable"),e=d.options,f=d.size,g=d.originalSize,h=d.originalPosition,i=d.axis,j=e._aspectRatio||b.shiftKey;e.grid=typeof e.grid=="number"?[e.grid,e.grid]:e.grid;var k=Math.round((f.width-g.width)/(e.grid[0]||1))*(e.grid[0]||1),l=Math.round((f.height-g.height)/(e.grid[1]||1))*(e.grid[1]||1);/^(se|s|e)$/.test(i)?(d.size.width=g.width+k,d.size.height=g.height+l):/^(ne)$/.test(i)?(d.size.width=g.width+k,d.size.height=g.height+l,d.position.top=h.top-l):/^(sw)$/.test(i)?(d.size.width=g.width+k,d.size.height=g.height+l,d.position.left=h.left-k):(d.size.width=g.width+k,d.size.height=g.height+l,d.position.top=h.top-l,d.position.left=h.left-k)}});var c=function(a){return parseInt(a,10)||0},d=function(a){return!isNaN(parseInt(a,10))}})(jQuery);;/*! jQuery UI - v1.8.23 - 2012-08-15
* https://github.com/jquery/jquery-ui
* Includes: jquery.ui.selectable.js
* Copyright (c) 2012 AUTHORS.txt; Licensed MIT, GPL */
(function(a,b){a.widget("ui.selectable",a.ui.mouse,{options:{appendTo:"body",autoRefresh:!0,distance:0,filter:"*",tolerance:"touch"},_create:function(){var b=this;this.element.addClass("ui-selectable"),this.dragged=!1;var c;this.refresh=function(){c=a(b.options.filter,b.element[0]),c.addClass("ui-selectee"),c.each(function(){var b=a(this),c=b.offset();a.data(this,"selectable-item",{element:this,$element:b,left:c.left,top:c.top,right:c.left+b.outerWidth(),bottom:c.top+b.outerHeight(),startselected:!1,selected:b.hasClass("ui-selected"),selecting:b.hasClass("ui-selecting"),unselecting:b.hasClass("ui-unselecting")})})},this.refresh(),this.selectees=c.addClass("ui-selectee"),this._mouseInit(),this.helper=a("<div class='ui-selectable-helper'></div>")},destroy:function(){return this.selectees.removeClass("ui-selectee").removeData("selectable-item"),this.element.removeClass("ui-selectable ui-selectable-disabled").removeData("selectable").unbind(".selectable"),this._mouseDestroy(),this},_mouseStart:function(b){var c=this;this.opos=[b.pageX,b.pageY];if(this.options.disabled)return;var d=this.options;this.selectees=a(d.filter,this.element[0]),this._trigger("start",b),a(d.appendTo).append(this.helper),this.helper.css({left:b.clientX,top:b.clientY,width:0,height:0}),d.autoRefresh&&this.refresh(),this.selectees.filter(".ui-selected").each(function(){var d=a.data(this,"selectable-item");d.startselected=!0,!b.metaKey&&!b.ctrlKey&&(d.$element.removeClass("ui-selected"),d.selected=!1,d.$element.addClass("ui-unselecting"),d.unselecting=!0,c._trigger("unselecting",b,{unselecting:d.element}))}),a(b.target).parents().andSelf().each(function(){var d=a.data(this,"selectable-item");if(d){var e=!b.metaKey&&!b.ctrlKey||!d.$element.hasClass("ui-selected");return d.$element.removeClass(e?"ui-unselecting":"ui-selected").addClass(e?"ui-selecting":"ui-unselecting"),d.unselecting=!e,d.selecting=e,d.selected=e,e?c._trigger("selecting",b,{selecting:d.element}):c._trigger("unselecting",b,{unselecting:d.element}),!1}})},_mouseDrag:function(b){var c=this;this.dragged=!0;if(this.options.disabled)return;var d=this.options,e=this.opos[0],f=this.opos[1],g=b.pageX,h=b.pageY;if(e>g){var i=g;g=e,e=i}if(f>h){var i=h;h=f,f=i}return this.helper.css({left:e,top:f,width:g-e,height:h-f}),this.selectees.each(function(){var i=a.data(this,"selectable-item");if(!i||i.element==c.element[0])return;var j=!1;d.tolerance=="touch"?j=!(i.left>g||i.right<e||i.top>h||i.bottom<f):d.tolerance=="fit"&&(j=i.left>e&&i.right<g&&i.top>f&&i.bottom<h),j?(i.selected&&(i.$element.removeClass("ui-selected"),i.selected=!1),i.unselecting&&(i.$element.removeClass("ui-unselecting"),i.unselecting=!1),i.selecting||(i.$element.addClass("ui-selecting"),i.selecting=!0,c._trigger("selecting",b,{selecting:i.element}))):(i.selecting&&((b.metaKey||b.ctrlKey)&&i.startselected?(i.$element.removeClass("ui-selecting"),i.selecting=!1,i.$element.addClass("ui-selected"),i.selected=!0):(i.$element.removeClass("ui-selecting"),i.selecting=!1,i.startselected&&(i.$element.addClass("ui-unselecting"),i.unselecting=!0),c._trigger("unselecting",b,{unselecting:i.element}))),i.selected&&!b.metaKey&&!b.ctrlKey&&!i.startselected&&(i.$element.removeClass("ui-selected"),i.selected=!1,i.$element.addClass("ui-unselecting"),i.unselecting=!0,c._trigger("unselecting",b,{unselecting:i.element})))}),!1},_mouseStop:function(b){var c=this;this.dragged=!1;var d=this.options;return a(".ui-unselecting",this.element[0]).each(function(){var d=a.data(this,"selectable-item");d.$element.removeClass("ui-unselecting"),d.unselecting=!1,d.startselected=!1,c._trigger("unselected",b,{unselected:d.element})}),a(".ui-selecting",this.element[0]).each(function(){var d=a.data(this,"selectable-item");d.$element.removeClass("ui-selecting").addClass("ui-selected"),d.selecting=!1,d.selected=!0,d.startselected=!0,c._trigger("selected",b,{selected:d.element})}),this._trigger("stop",b),this.helper.remove(),!1}}),a.extend(a.ui.selectable,{version:"1.8.23"})})(jQuery);;/*! jQuery UI - v1.8.23 - 2012-08-15
* https://github.com/jquery/jquery-ui
* Includes: jquery.ui.sortable.js
* Copyright (c) 2012 AUTHORS.txt; Licensed MIT, GPL */
(function(a,b){a.widget("ui.sortable",a.ui.mouse,{widgetEventPrefix:"sort",ready:!1,options:{appendTo:"parent",axis:!1,connectWith:!1,containment:!1,cursor:"auto",cursorAt:!1,dropOnEmpty:!0,forcePlaceholderSize:!1,forceHelperSize:!1,grid:!1,handle:!1,helper:"original",items:"> *",opacity:!1,placeholder:!1,revert:!1,scroll:!0,scrollSensitivity:20,scrollSpeed:20,scope:"default",tolerance:"intersect",zIndex:1e3},_create:function(){var a=this.options;this.containerCache={},this.element.addClass("ui-sortable"),this.refresh(),this.floating=this.items.length?a.axis==="x"||/left|right/.test(this.items[0].item.css("float"))||/inline|table-cell/.test(this.items[0].item.css("display")):!1,this.offset=this.element.offset(),this._mouseInit(),this.ready=!0},destroy:function(){a.Widget.prototype.destroy.call(this),this.element.removeClass("ui-sortable ui-sortable-disabled"),this._mouseDestroy();for(var b=this.items.length-1;b>=0;b--)this.items[b].item.removeData(this.widgetName+"-item");return this},_setOption:function(b,c){b==="disabled"?(this.options[b]=c,this.widget()[c?"addClass":"removeClass"]("ui-sortable-disabled")):a.Widget.prototype._setOption.apply(this,arguments)},_mouseCapture:function(b,c){var d=this;if(this.reverting)return!1;if(this.options.disabled||this.options.type=="static")return!1;this._refreshItems(b);var e=null,f=this,g=a(b.target).parents().each(function(){if(a.data(this,d.widgetName+"-item")==f)return e=a(this),!1});a.data(b.target,d.widgetName+"-item")==f&&(e=a(b.target));if(!e)return!1;if(this.options.handle&&!c){var h=!1;a(this.options.handle,e).find("*").andSelf().each(function(){this==b.target&&(h=!0)});if(!h)return!1}return this.currentItem=e,this._removeCurrentsFromItems(),!0},_mouseStart:function(b,c,d){var e=this.options,f=this;this.currentContainer=this,this.refreshPositions(),this.helper=this._createHelper(b),this._cacheHelperProportions(),this._cacheMargins(),this.scrollParent=this.helper.scrollParent(),this.offset=this.currentItem.offset(),this.offset={top:this.offset.top-this.margins.top,left:this.offset.left-this.margins.left},a.extend(this.offset,{click:{left:b.pageX-this.offset.left,top:b.pageY-this.offset.top},parent:this._getParentOffset(),relative:this._getRelativeOffset()}),this.helper.css("position","absolute"),this.cssPosition=this.helper.css("position"),this.originalPosition=this._generatePosition(b),this.originalPageX=b.pageX,this.originalPageY=b.pageY,e.cursorAt&&this._adjustOffsetFromHelper(e.cursorAt),this.domPosition={prev:this.currentItem.prev()[0],parent:this.currentItem.parent()[0]},this.helper[0]!=this.currentItem[0]&&this.currentItem.hide(),this._createPlaceholder(),e.containment&&this._setContainment(),e.cursor&&(a("body").css("cursor")&&(this._storedCursor=a("body").css("cursor")),a("body").css("cursor",e.cursor)),e.opacity&&(this.helper.css("opacity")&&(this._storedOpacity=this.helper.css("opacity")),this.helper.css("opacity",e.opacity)),e.zIndex&&(this.helper.css("zIndex")&&(this._storedZIndex=this.helper.css("zIndex")),this.helper.css("zIndex",e.zIndex)),this.scrollParent[0]!=document&&this.scrollParent[0].tagName!="HTML"&&(this.overflowOffset=this.scrollParent.offset()),this._trigger("start",b,this._uiHash()),this._preserveHelperProportions||this._cacheHelperProportions();if(!d)for(var g=this.containers.length-1;g>=0;g--)this.containers[g]._trigger("activate",b,f._uiHash(this));return a.ui.ddmanager&&(a.ui.ddmanager.current=this),a.ui.ddmanager&&!e.dropBehaviour&&a.ui.ddmanager.prepareOffsets(this,b),this.dragging=!0,this.helper.addClass("ui-sortable-helper"),this._mouseDrag(b),!0},_mouseDrag:function(b){this.position=this._generatePosition(b),this.positionAbs=this._convertPositionTo("absolute"),this.lastPositionAbs||(this.lastPositionAbs=this.positionAbs);if(this.options.scroll){var c=this.options,d=!1;this.scrollParent[0]!=document&&this.scrollParent[0].tagName!="HTML"?(this.overflowOffset.top+this.scrollParent[0].offsetHeight-b.pageY<c.scrollSensitivity?this.scrollParent[0].scrollTop=d=this.scrollParent[0].scrollTop+c.scrollSpeed:b.pageY-this.overflowOffset.top<c.scrollSensitivity&&(this.scrollParent[0].scrollTop=d=this.scrollParent[0].scrollTop-c.scrollSpeed),this.overflowOffset.left+this.scrollParent[0].offsetWidth-b.pageX<c.scrollSensitivity?this.scrollParent[0].scrollLeft=d=this.scrollParent[0].scrollLeft+c.scrollSpeed:b.pageX-this.overflowOffset.left<c.scrollSensitivity&&(this.scrollParent[0].scrollLeft=d=this.scrollParent[0].scrollLeft-c.scrollSpeed)):(b.pageY-a(document).scrollTop()<c.scrollSensitivity?d=a(document).scrollTop(a(document).scrollTop()-c.scrollSpeed):a(window).height()-(b.pageY-a(document).scrollTop())<c.scrollSensitivity&&(d=a(document).scrollTop(a(document).scrollTop()+c.scrollSpeed)),b.pageX-a(document).scrollLeft()<c.scrollSensitivity?d=a(document).scrollLeft(a(document).scrollLeft()-c.scrollSpeed):a(window).width()-(b.pageX-a(document).scrollLeft())<c.scrollSensitivity&&(d=a(document).scrollLeft(a(document).scrollLeft()+c.scrollSpeed))),d!==!1&&a.ui.ddmanager&&!c.dropBehaviour&&a.ui.ddmanager.prepareOffsets(this,b)}this.positionAbs=this._convertPositionTo("absolute");if(!this.options.axis||this.options.axis!="y")this.helper[0].style.left=this.position.left+"px";if(!this.options.axis||this.options.axis!="x")this.helper[0].style.top=this.position.top+"px";for(var e=this.items.length-1;e>=0;e--){var f=this.items[e],g=f.item[0],h=this._intersectsWithPointer(f);if(!h)continue;if(g!=this.currentItem[0]&&this.placeholder[h==1?"next":"prev"]()[0]!=g&&!a.ui.contains(this.placeholder[0],g)&&(this.options.type=="semi-dynamic"?!a.ui.contains(this.element[0],g):!0)){this.direction=h==1?"down":"up";if(this.options.tolerance=="pointer"||this._intersectsWithSides(f))this._rearrange(b,f);else break;this._trigger("change",b,this._uiHash());break}}return this._contactContainers(b),a.ui.ddmanager&&a.ui.ddmanager.drag(this,b),this._trigger("sort",b,this._uiHash()),this.lastPositionAbs=this.positionAbs,!1},_mouseStop:function(b,c){if(!b)return;a.ui.ddmanager&&!this.options.dropBehaviour&&a.ui.ddmanager.drop(this,b);if(this.options.revert){var d=this,e=d.placeholder.offset();d.reverting=!0,a(this.helper).animate({left:e.left-this.offset.parent.left-d.margins.left+(this.offsetParent[0]==document.body?0:this.offsetParent[0].scrollLeft),top:e.top-this.offset.parent.top-d.margins.top+(this.offsetParent[0]==document.body?0:this.offsetParent[0].scrollTop)},parseInt(this.options.revert,10)||500,function(){d._clear(b)})}else this._clear(b,c);return!1},cancel:function(){var b=this;if(this.dragging){this._mouseUp({target:null}),this.options.helper=="original"?this.currentItem.css(this._storedCSS).removeClass("ui-sortable-helper"):this.currentItem.show();for(var c=this.containers.length-1;c>=0;c--)this.containers[c]._trigger("deactivate",null,b._uiHash(this)),this.containers[c].containerCache.over&&(this.containers[c]._trigger("out",null,b._uiHash(this)),this.containers[c].containerCache.over=0)}return this.placeholder&&(this.placeholder[0].parentNode&&this.placeholder[0].parentNode.removeChild(this.placeholder[0]),this.options.helper!="original"&&this.helper&&this.helper[0].parentNode&&this.helper.remove(),a.extend(this,{helper:null,dragging:!1,reverting:!1,_noFinalSort:null}),this.domPosition.prev?a(this.domPosition.prev).after(this.currentItem):a(this.domPosition.parent).prepend(this.currentItem)),this},serialize:function(b){var c=this._getItemsAsjQuery(b&&b.connected),d=[];return b=b||{},a(c).each(function(){var c=(a(b.item||this).attr(b.attribute||"id")||"").match(b.expression||/(.+)[-=_](.+)/);c&&d.push((b.key||c[1]+"[]")+"="+(b.key&&b.expression?c[1]:c[2]))}),!d.length&&b.key&&d.push(b.key+"="),d.join("&")},toArray:function(b){var c=this._getItemsAsjQuery(b&&b.connected),d=[];return b=b||{},c.each(function(){d.push(a(b.item||this).attr(b.attribute||"id")||"")}),d},_intersectsWith:function(a){var b=this.positionAbs.left,c=b+this.helperProportions.width,d=this.positionAbs.top,e=d+this.helperProportions.height,f=a.left,g=f+a.width,h=a.top,i=h+a.height,j=this.offset.click.top,k=this.offset.click.left,l=d+j>h&&d+j<i&&b+k>f&&b+k<g;return this.options.tolerance=="pointer"||this.options.forcePointerForContainers||this.options.tolerance!="pointer"&&this.helperProportions[this.floating?"width":"height"]>a[this.floating?"width":"height"]?l:f<b+this.helperProportions.width/2&&c-this.helperProportions.width/2<g&&h<d+this.helperProportions.height/2&&e-this.helperProportions.height/2<i},_intersectsWithPointer:function(b){var c=this.options.axis==="x"||a.ui.isOverAxis(this.positionAbs.top+this.offset.click.top,b.top,b.height),d=this.options.axis==="y"||a.ui.isOverAxis(this.positionAbs.left+this.offset.click.left,b.left,b.width),e=c&&d,f=this._getDragVerticalDirection(),g=this._getDragHorizontalDirection();return e?this.floating?g&&g=="right"||f=="down"?2:1:f&&(f=="down"?2:1):!1},_intersectsWithSides:function(b){var c=a.ui.isOverAxis(this.positionAbs.top+this.offset.click.top,b.top+b.height/2,b.height),d=a.ui.isOverAxis(this.positionAbs.left+this.offset.click.left,b.left+b.width/2,b.width),e=this._getDragVerticalDirection(),f=this._getDragHorizontalDirection();return this.floating&&f?f=="right"&&d||f=="left"&&!d:e&&(e=="down"&&c||e=="up"&&!c)},_getDragVerticalDirection:function(){var a=this.positionAbs.top-this.lastPositionAbs.top;return a!=0&&(a>0?"down":"up")},_getDragHorizontalDirection:function(){var a=this.positionAbs.left-this.lastPositionAbs.left;return a!=0&&(a>0?"right":"left")},refresh:function(a){return this._refreshItems(a),this.refreshPositions(),this},_connectWith:function(){var a=this.options;return a.connectWith.constructor==String?[a.connectWith]:a.connectWith},_getItemsAsjQuery:function(b){var c=this,d=[],e=[],f=this._connectWith();if(f&&b)for(var g=f.length-1;g>=0;g--){var h=a(f[g]);for(var i=h.length-1;i>=0;i--){var j=a.data(h[i],this.widgetName);j&&j!=this&&!j.options.disabled&&e.push([a.isFunction(j.options.items)?j.options.items.call(j.element):a(j.options.items,j.element).not(".ui-sortable-helper").not(".ui-sortable-placeholder"),j])}}e.push([a.isFunction(this.options.items)?this.options.items.call(this.element,null,{options:this.options,item:this.currentItem}):a(this.options.items,this.element).not(".ui-sortable-helper").not(".ui-sortable-placeholder"),this]);for(var g=e.length-1;g>=0;g--)e[g][0].each(function(){d.push(this)});return a(d)},_removeCurrentsFromItems:function(){var a=this.currentItem.find(":data("+this.widgetName+"-item)");for(var b=0;b<this.items.length;b++)for(var c=0;c<a.length;c++)a[c]==this.items[b].item[0]&&this.items.splice(b,1)},_refreshItems:function(b){this.items=[],this.containers=[this];var c=this.items,d=this,e=[[a.isFunction(this.options.items)?this.options.items.call(this.element[0],b,{item:this.currentItem}):a(this.options.items,this.element),this]],f=this._connectWith();if(f&&this.ready)for(var g=f.length-1;g>=0;g--){var h=a(f[g]);for(var i=h.length-1;i>=0;i--){var j=a.data(h[i],this.widgetName);j&&j!=this&&!j.options.disabled&&(e.push([a.isFunction(j.options.items)?j.options.items.call(j.element[0],b,{item:this.currentItem}):a(j.options.items,j.element),j]),this.containers.push(j))}}for(var g=e.length-1;g>=0;g--){var k=e[g][1],l=e[g][0];for(var i=0,m=l.length;i<m;i++){var n=a(l[i]);n.data(this.widgetName+"-item",k),c.push({item:n,instance:k,width:0,height:0,left:0,top:0})}}},refreshPositions:function(b){this.offsetParent&&this.helper&&(this.offset.parent=this._getParentOffset());for(var c=this.items.length-1;c>=0;c--){var d=this.items[c];if(d.instance!=this.currentContainer&&this.currentContainer&&d.item[0]!=this.currentItem[0])continue;var e=this.options.toleranceElement?a(this.options.toleranceElement,d.item):d.item;b||(d.width=e.outerWidth(),d.height=e.outerHeight());var f=e.offset();d.left=f.left,d.top=f.top}if(this.options.custom&&this.options.custom.refreshContainers)this.options.custom.refreshContainers.call(this);else for(var c=this.containers.length-1;c>=0;c--){var f=this.containers[c].element.offset();this.containers[c].containerCache.left=f.left,this.containers[c].containerCache.top=f.top,this.containers[c].containerCache.width=this.containers[c].element.outerWidth(),this.containers[c].containerCache.height=this.containers[c].element.outerHeight()}return this},_createPlaceholder:function(b){var c=b||this,d=c.options;if(!d.placeholder||d.placeholder.constructor==String){var e=d.placeholder;d.placeholder={element:function(){var b=a(document.createElement(c.currentItem[0].nodeName)).addClass(e||c.currentItem[0].className+" ui-sortable-placeholder").removeClass("ui-sortable-helper")[0];return e||(b.style.visibility="hidden"),b},update:function(a,b){if(e&&!d.forcePlaceholderSize)return;b.height()||b.height(c.currentItem.innerHeight()-parseInt(c.currentItem.css("paddingTop")||0,10)-parseInt(c.currentItem.css("paddingBottom")||0,10)),b.width()||b.width(c.currentItem.innerWidth()-parseInt(c.currentItem.css("paddingLeft")||0,10)-parseInt(c.currentItem.css("paddingRight")||0,10))}}}c.placeholder=a(d.placeholder.element.call(c.element,c.currentItem)),c.currentItem.after(c.placeholder),d.placeholder.update(c,c.placeholder)},_contactContainers:function(b){var c=null,d=null;for(var e=this.containers.length-1;e>=0;e--){if(a.ui.contains(this.currentItem[0],this.containers[e].element[0]))continue;if(this._intersectsWith(this.containers[e].containerCache)){if(c&&a.ui.contains(this.containers[e].element[0],c.element[0]))continue;c=this.containers[e],d=e}else this.containers[e].containerCache.over&&(this.containers[e]._trigger("out",b,this._uiHash(this)),this.containers[e].containerCache.over=0)}if(!c)return;if(this.containers.length===1)this.containers[d]._trigger("over",b,this._uiHash(this)),this.containers[d].containerCache.over=1;else if(this.currentContainer!=this.containers[d]){var f=1e4,g=null,h=this.positionAbs[this.containers[d].floating?"left":"top"];for(var i=this.items.length-1;i>=0;i--){if(!a.ui.contains(this.containers[d].element[0],this.items[i].item[0]))continue;var j=this.containers[d].floating?this.items[i].item.offset().left:this.items[i].item.offset().top;Math.abs(j-h)<f&&(f=Math.abs(j-h),g=this.items[i],this.direction=j-h>0?"down":"up")}if(!g&&!this.options.dropOnEmpty)return;this.currentContainer=this.containers[d],g?this._rearrange(b,g,null,!0):this._rearrange(b,null,this.containers[d].element,!0),this._trigger("change",b,this._uiHash()),this.containers[d]._trigger("change",b,this._uiHash(this)),this.options.placeholder.update(this.currentContainer,this.placeholder),this.containers[d]._trigger("over",b,this._uiHash(this)),this.containers[d].containerCache.over=1}},_createHelper:function(b){var c=this.options,d=a.isFunction(c.helper)?a(c.helper.apply(this.element[0],[b,this.currentItem])):c.helper=="clone"?this.currentItem.clone():this.currentItem;return d.parents("body").length||a(c.appendTo!="parent"?c.appendTo:this.currentItem[0].parentNode)[0].appendChild(d[0]),d[0]==this.currentItem[0]&&(this._storedCSS={width:this.currentItem[0].style.width,height:this.currentItem[0].style.height,position:this.currentItem.css("position"),top:this.currentItem.css("top"),left:this.currentItem.css("left")}),(d[0].style.width==""||c.forceHelperSize)&&d.width(this.currentItem.width()),(d[0].style.height==""||c.forceHelperSize)&&d.height(this.currentItem.height()),d},_adjustOffsetFromHelper:function(b){typeof b=="string"&&(b=b.split(" ")),a.isArray(b)&&(b={left:+b[0],top:+b[1]||0}),"left"in b&&(this.offset.click.left=b.left+this.margins.left),"right"in b&&(this.offset.click.left=this.helperProportions.width-b.right+this.margins.left),"top"in b&&(this.offset.click.top=b.top+this.margins.top),"bottom"in b&&(this.offset.click.top=this.helperProportions.height-b.bottom+this.margins.top)},_getParentOffset:function(){this.offsetParent=this.helper.offsetParent();var b=this.offsetParent.offset();this.cssPosition=="absolute"&&this.scrollParent[0]!=document&&a.ui.contains(this.scrollParent[0],this.offsetParent[0])&&(b.left+=this.scrollParent.scrollLeft(),b.top+=this.scrollParent.scrollTop());if(this.offsetParent[0]==document.body||this.offsetParent[0].tagName&&this.offsetParent[0].tagName.toLowerCase()=="html"&&a.browser.msie)b={top:0,left:0};return{top:b.top+(parseInt(this.offsetParent.css("borderTopWidth"),10)||0),left:b.left+(parseInt(this.offsetParent.css("borderLeftWidth"),10)||0)}},_getRelativeOffset:function(){if(this.cssPosition=="relative"){var a=this.currentItem.position();return{top:a.top-(parseInt(this.helper.css("top"),10)||0)+this.scrollParent.scrollTop(),left:a.left-(parseInt(this.helper.css("left"),10)||0)+this.scrollParent.scrollLeft()}}return{top:0,left:0}},_cacheMargins:function(){this.margins={left:parseInt(this.currentItem.css("marginLeft"),10)||0,top:parseInt(this.currentItem.css("marginTop"),10)||0}},_cacheHelperProportions:function(){this.helperProportions={width:this.helper.outerWidth(),height:this.helper.outerHeight()}},_setContainment:function(){var b=this.options;b.containment=="parent"&&(b.containment=this.helper[0].parentNode);if(b.containment=="document"||b.containment=="window")this.containment=[0-this.offset.relative.left-this.offset.parent.left,0-this.offset.relative.top-this.offset.parent.top,a(b.containment=="document"?document:window).width()-this.helperProportions.width-this.margins.left,(a(b.containment=="document"?document:window).height()||document.body.parentNode.scrollHeight)-this.helperProportions.height-this.margins.top];if(!/^(document|window|parent)$/.test(b.containment)){var c=a(b.containment)[0],d=a(b.containment).offset(),e=a(c).css("overflow")!="hidden";this.containment=[d.left+(parseInt(a(c).css("borderLeftWidth"),10)||0)+(parseInt(a(c).css("paddingLeft"),10)||0)-this.margins.left,d.top+(parseInt(a(c).css("borderTopWidth"),10)||0)+(parseInt(a(c).css("paddingTop"),10)||0)-this.margins.top,d.left+(e?Math.max(c.scrollWidth,c.offsetWidth):c.offsetWidth)-(parseInt(a(c).css("borderLeftWidth"),10)||0)-(parseInt(a(c).css("paddingRight"),10)||0)-this.helperProportions.width-this.margins.left,d.top+(e?Math.max(c.scrollHeight,c.offsetHeight):c.offsetHeight)-(parseInt(a(c).css("borderTopWidth"),10)||0)-(parseInt(a(c).css("paddingBottom"),10)||0)-this.helperProportions.height-this.margins.top]}},_convertPositionTo:function(b,c){c||(c=this.position);var d=b=="absolute"?1:-1,e=this.options,f=this.cssPosition=="absolute"&&(this.scrollParent[0]==document||!a.ui.contains(this.scrollParent[0],this.offsetParent[0]))?this.offsetParent:this.scrollParent,g=/(html|body)/i.test(f[0].tagName);return{top:c.top+this.offset.relative.top*d+this.offset.parent.top*d-(a.browser.safari&&this.cssPosition=="fixed"?0:(this.cssPosition=="fixed"?-this.scrollParent.scrollTop():g?0:f.scrollTop())*d),left:c.left+this.offset.relative.left*d+this.offset.parent.left*d-(a.browser.safari&&this.cssPosition=="fixed"?0:(this.cssPosition=="fixed"?-this.scrollParent.scrollLeft():g?0:f.scrollLeft())*d)}},_generatePosition:function(b){var c=this.options,d=this.cssPosition=="absolute"&&(this.scrollParent[0]==document||!a.ui.contains(this.scrollParent[0],this.offsetParent[0]))?this.offsetParent:this.scrollParent,e=/(html|body)/i.test(d[0].tagName);this.cssPosition=="relative"&&(this.scrollParent[0]==document||this.scrollParent[0]==this.offsetParent[0])&&(this.offset.relative=this._getRelativeOffset());var f=b.pageX,g=b.pageY;if(this.originalPosition){this.containment&&(b.pageX-this.offset.click.left<this.containment[0]&&(f=this.containment[0]+this.offset.click.left),b.pageY-this.offset.click.top<this.containment[1]&&(g=this.containment[1]+this.offset.click.top),b.pageX-this.offset.click.left>this.containment[2]&&(f=this.containment[2]+this.offset.click.left),b.pageY-this.offset.click.top>this.containment[3]&&(g=this.containment[3]+this.offset.click.top));if(c.grid){var h=this.originalPageY+Math.round((g-this.originalPageY)/c.grid[1])*c.grid[1];g=this.containment?h-this.offset.click.top<this.containment[1]||h-this.offset.click.top>this.containment[3]?h-this.offset.click.top<this.containment[1]?h+c.grid[1]:h-c.grid[1]:h:h;var i=this.originalPageX+Math.round((f-this.originalPageX)/c.grid[0])*c.grid[0];f=this.containment?i-this.offset.click.left<this.containment[0]||i-this.offset.click.left>this.containment[2]?i-this.offset.click.left<this.containment[0]?i+c.grid[0]:i-c.grid[0]:i:i}}return{top:g-this.offset.click.top-this.offset.relative.top-this.offset.parent.top+(a.browser.safari&&this.cssPosition=="fixed"?0:this.cssPosition=="fixed"?-this.scrollParent.scrollTop():e?0:d.scrollTop()),left:f-this.offset.click.left-this.offset.relative.left-this.offset.parent.left+(a.browser.safari&&this.cssPosition=="fixed"?0:this.cssPosition=="fixed"?-this.scrollParent.scrollLeft():e?0:d.scrollLeft())}},_rearrange:function(a,b,c,d){c?c[0].appendChild(this.placeholder[0]):b.item[0].parentNode.insertBefore(this.placeholder[0],this.direction=="down"?b.item[0]:b.item[0].nextSibling),this.counter=this.counter?++this.counter:1;var e=this,f=this.counter;window.setTimeout(function(){f==e.counter&&e.refreshPositions(!d)},0)},_clear:function(b,c){this.reverting=!1;var d=[],e=this;!this._noFinalSort&&this.currentItem.parent().length&&this.placeholder.before(this.currentItem),this._noFinalSort=null;if(this.helper[0]==this.currentItem[0]){for(var f in this._storedCSS)if(this._storedCSS[f]=="auto"||this._storedCSS[f]=="static")this._storedCSS[f]="";this.currentItem.css(this._storedCSS).removeClass("ui-sortable-helper")}else this.currentItem.show();this.fromOutside&&!c&&d.push(function(a){this._trigger("receive",a,this._uiHash(this.fromOutside))}),(this.fromOutside||this.domPosition.prev!=this.currentItem.prev().not(".ui-sortable-helper")[0]||this.domPosition.parent!=this.currentItem.parent()[0])&&!c&&d.push(function(a){this._trigger("update",a,this._uiHash())});if(!a.ui.contains(this.element[0],this.currentItem[0])){c||d.push(function(a){this._trigger("remove",a,this._uiHash())});for(var f=this.containers.length-1;f>=0;f--)a.ui.contains(this.containers[f].element[0],this.currentItem[0])&&!c&&(d.push(function(a){return function(b){a._trigger("receive",b,this._uiHash(this))}}.call(this,this.containers[f])),d.push(function(a){return function(b){a._trigger("update",b,this._uiHash(this))}}.call(this,this.containers[f])))}for(var f=this.containers.length-1;f>=0;f--)c||d.push(function(a){return function(b){a._trigger("deactivate",b,this._uiHash(this))}}.call(this,this.containers[f])),this.containers[f].containerCache.over&&(d.push(function(a){return function(b){a._trigger("out",b,this._uiHash(this))}}.call(this,this.containers[f])),this.containers[f].containerCache.over=0);this._storedCursor&&a("body").css("cursor",this._storedCursor),this._storedOpacity&&this.helper.css("opacity",this._storedOpacity),this._storedZIndex&&this.helper.css("zIndex",this._storedZIndex=="auto"?"":this._storedZIndex),this.dragging=!1;if(this.cancelHelperRemoval){if(!c){this._trigger("beforeStop",b,this._uiHash());for(var f=0;f<d.length;f++)d[f].call(this,b);this._trigger("stop",b,this._uiHash())}return this.fromOutside=!1,!1}c||this._trigger("beforeStop",b,this._uiHash()),this.placeholder[0].parentNode.removeChild(this.placeholder[0]),this.helper[0]!=this.currentItem[0]&&this.helper.remove(),this.helper=null;if(!c){for(var f=0;f<d.length;f++)d[f].call(this,b);this._trigger("stop",b,this._uiHash())}return this.fromOutside=!1,!0},_trigger:function(){a.Widget.prototype._trigger.apply(this,arguments)===!1&&this.cancel()},_uiHash:function(b){var c=b||this;return{helper:c.helper,placeholder:c.placeholder||a([]),position:c.position,originalPosition:c.originalPosition,offset:c.positionAbs,item:c.currentItem,sender:b?b.element:null}}}),a.extend(a.ui.sortable,{version:"1.8.23"})})(jQuery);;/*! jQuery UI - v1.8.23 - 2012-08-15
* https://github.com/jquery/jquery-ui
* Includes: jquery.ui.accordion.js
* Copyright (c) 2012 AUTHORS.txt; Licensed MIT, GPL */
(function(a,b){a.widget("ui.accordion",{options:{active:0,animated:"slide",autoHeight:!0,clearStyle:!1,collapsible:!1,event:"click",fillSpace:!1,header:"> li > :first-child,> :not(li):even",icons:{header:"ui-icon-triangle-1-e",headerSelected:"ui-icon-triangle-1-s"},navigation:!1,navigationFilter:function(){return this.href.toLowerCase()===location.href.toLowerCase()}},_create:function(){var b=this,c=b.options;b.running=0,b.element.addClass("ui-accordion ui-widget ui-helper-reset").children("li").addClass("ui-accordion-li-fix"),b.headers=b.element.find(c.header).addClass("ui-accordion-header ui-helper-reset ui-state-default ui-corner-all").bind("mouseenter.accordion",function(){if(c.disabled)return;a(this).addClass("ui-state-hover")}).bind("mouseleave.accordion",function(){if(c.disabled)return;a(this).removeClass("ui-state-hover")}).bind("focus.accordion",function(){if(c.disabled)return;a(this).addClass("ui-state-focus")}).bind("blur.accordion",function(){if(c.disabled)return;a(this).removeClass("ui-state-focus")}),b.headers.next().addClass("ui-accordion-content ui-helper-reset ui-widget-content ui-corner-bottom");if(c.navigation){var d=b.element.find("a").filter(c.navigationFilter).eq(0);if(d.length){var e=d.closest(".ui-accordion-header");e.length?b.active=e:b.active=d.closest(".ui-accordion-content").prev()}}b.active=b._findActive(b.active||c.active).addClass("ui-state-default ui-state-active").toggleClass("ui-corner-all").toggleClass("ui-corner-top"),b.active.next().addClass("ui-accordion-content-active"),b._createIcons(),b.resize(),b.element.attr("role","tablist"),b.headers.attr("role","tab").bind("keydown.accordion",function(a){return b._keydown(a)}).next().attr("role","tabpanel"),b.headers.not(b.active||"").attr({"aria-expanded":"false","aria-selected":"false",tabIndex:-1}).next().hide(),b.active.length?b.active.attr({"aria-expanded":"true","aria-selected":"true",tabIndex:0}):b.headers.eq(0).attr("tabIndex",0),a.browser.safari||b.headers.find("a").attr("tabIndex",-1),c.event&&b.headers.bind(c.event.split(" ").join(".accordion ")+".accordion",function(a){b._clickHandler.call(b,a,this),a.preventDefault()})},_createIcons:function(){var b=this.options;b.icons&&(a("<span></span>").addClass("ui-icon "+b.icons.header).prependTo(this.headers),this.active.children(".ui-icon").toggleClass(b.icons.header).toggleClass(b.icons.headerSelected),this.element.addClass("ui-accordion-icons"))},_destroyIcons:function(){this.headers.children(".ui-icon").remove(),this.element.removeClass("ui-accordion-icons")},destroy:function(){var b=this.options;this.element.removeClass("ui-accordion ui-widget ui-helper-reset").removeAttr("role"),this.headers.unbind(".accordion").removeClass("ui-accordion-header ui-accordion-disabled ui-helper-reset ui-state-default ui-corner-all ui-state-active ui-state-disabled ui-corner-top").removeAttr("role").removeAttr("aria-expanded").removeAttr("aria-selected").removeAttr("tabIndex"),this.headers.find("a").removeAttr("tabIndex"),this._destroyIcons();var c=this.headers.next().css("display","").removeAttr("role").removeClass("ui-helper-reset ui-widget-content ui-corner-bottom ui-accordion-content ui-accordion-content-active ui-accordion-disabled ui-state-disabled");return(b.autoHeight||b.fillHeight)&&c.css("height",""),a.Widget.prototype.destroy.call(this)},_setOption:function(b,c){a.Widget.prototype._setOption.apply(this,arguments),b=="active"&&this.activate(c),b=="icons"&&(this._destroyIcons(),c&&this._createIcons()),b=="disabled"&&this.headers.add(this.headers.next())[c?"addClass":"removeClass"]("ui-accordion-disabled ui-state-disabled")},_keydown:function(b){if(this.options.disabled||b.altKey||b.ctrlKey)return;var c=a.ui.keyCode,d=this.headers.length,e=this.headers.index(b.target),f=!1;switch(b.keyCode){case c.RIGHT:case c.DOWN:f=this.headers[(e+1)%d];break;case c.LEFT:case c.UP:f=this.headers[(e-1+d)%d];break;case c.SPACE:case c.ENTER:this._clickHandler({target:b.target},b.target),b.preventDefault()}return f?(a(b.target).attr("tabIndex",-1),a(f).attr("tabIndex",0),f.focus(),!1):!0},resize:function(){var b=this.options,c;if(b.fillSpace){if(a.browser.msie){var d=this.element.parent().css("overflow");this.element.parent().css("overflow","hidden")}c=this.element.parent().height(),a.browser.msie&&this.element.parent().css("overflow",d),this.headers.each(function(){c-=a(this).outerHeight(!0)}),this.headers.next().each(function(){a(this).height(Math.max(0,c-a(this).innerHeight()+a(this).height()))}).css("overflow","auto")}else b.autoHeight&&(c=0,this.headers.next().each(function(){c=Math.max(c,a(this).height("").height())}).height(c));return this},activate:function(a){this.options.active=a;var b=this._findActive(a)[0];return this._clickHandler({target:b},b),this},_findActive:function(b){return b?typeof b=="number"?this.headers.filter(":eq("+b+")"):this.headers.not(this.headers.not(b)):b===!1?a([]):this.headers.filter(":eq(0)")},_clickHandler:function(b,c){var d=this.options;if(d.disabled)return;if(!b.target){if(!d.collapsible)return;this.active.removeClass("ui-state-active ui-corner-top").addClass("ui-state-default ui-corner-all").children(".ui-icon").removeClass(d.icons.headerSelected).addClass(d.icons.header),this.active.next().addClass("ui-accordion-content-active");var e=this.active.next(),f={options:d,newHeader:a([]),oldHeader:d.active,newContent:a([]),oldContent:e},g=this.active=a([]);this._toggle(g,e,f);return}var h=a(b.currentTarget||c),i=h[0]===this.active[0];d.active=d.collapsible&&i?!1:this.headers.index(h);if(this.running||!d.collapsible&&i)return;var j=this.active,g=h.next(),e=this.active.next(),f={options:d,newHeader:i&&d.collapsible?a([]):h,oldHeader:this.active,newContent:i&&d.collapsible?a([]):g,oldContent:e},k=this.headers.index(this.active[0])>this.headers.index(h[0]);this.active=i?a([]):h,this._toggle(g,e,f,i,k),j.removeClass("ui-state-active ui-corner-top").addClass("ui-state-default ui-corner-all").children(".ui-icon").removeClass(d.icons.headerSelected).addClass(d.icons.header),i||(h.removeClass("ui-state-default ui-corner-all").addClass("ui-state-active ui-corner-top").children(".ui-icon").removeClass(d.icons.header).addClass(d.icons.headerSelected),h.next().addClass("ui-accordion-content-active"));return},_toggle:function(b,c,d,e,f){var g=this,h=g.options;g.toShow=b,g.toHide=c,g.data=d;var i=function(){if(!g)return;return g._completed.apply(g,arguments)};g._trigger("changestart",null,g.data),g.running=c.size()===0?b.size():c.size();if(h.animated){var j={};h.collapsible&&e?j={toShow:a([]),toHide:c,complete:i,down:f,autoHeight:h.autoHeight||h.fillSpace}:j={toShow:b,toHide:c,complete:i,down:f,autoHeight:h.autoHeight||h.fillSpace},h.proxied||(h.proxied=h.animated),h.proxiedDuration||(h.proxiedDuration=h.duration),h.animated=a.isFunction(h.proxied)?h.proxied(j):h.proxied,h.duration=a.isFunction(h.proxiedDuration)?h.proxiedDuration(j):h.proxiedDuration;var k=a.ui.accordion.animations,l=h.duration,m=h.animated;m&&!k[m]&&!a.easing[m]&&(m="slide"),k[m]||(k[m]=function(a){this.slide(a,{easing:m,duration:l||700})}),k[m](j)}else h.collapsible&&e?b.toggle():(c.hide(),b.show()),i(!0);c.prev().attr({"aria-expanded":"false","aria-selected":"false",tabIndex:-1}).blur(),b.prev().attr({"aria-expanded":"true","aria-selected":"true",tabIndex:0}).focus()},_completed:function(a){this.running=a?0:--this.running;if(this.running)return;this.options.clearStyle&&this.toShow.add(this.toHide).css({height:"",overflow:""}),this.toHide.removeClass("ui-accordion-content-active"),this.toHide.length&&(this.toHide.parent()[0].className=this.toHide.parent()[0].className),this._trigger("change",null,this.data)}}),a.extend(a.ui.accordion,{version:"1.8.23",animations:{slide:function(b,c){b=a.extend({easing:"swing",duration:300},b,c);if(!b.toHide.size()){b.toShow.animate({height:"show",paddingTop:"show",paddingBottom:"show"},b);return}if(!b.toShow.size()){b.toHide.animate({height:"hide",paddingTop:"hide",paddingBottom:"hide"},b);return}var d=b.toShow.css("overflow"),e=0,f={},g={},h=["height","paddingTop","paddingBottom"],i,j=b.toShow;i=j[0].style.width,j.width(j.parent().width()-parseFloat(j.css("paddingLeft"))-parseFloat(j.css("paddingRight"))-(parseFloat(j.css("borderLeftWidth"))||0)-(parseFloat(j.css("borderRightWidth"))||0)),a.each(h,function(c,d){g[d]="hide";var e=(""+a.css(b.toShow[0],d)).match(/^([\d+-.]+)(.*)$/);f[d]={value:e[1],unit:e[2]||"px"}}),b.toShow.css({height:0,overflow:"hidden"}).show(),b.toHide.filter(":hidden").each(b.complete).end().filter(":visible").animate(g,{step:function(a,c){c.prop=="height"&&(e=c.end-c.start===0?0:(c.now-c.start)/(c.end-c.start)),b.toShow[0].style[c.prop]=e*f[c.prop].value+f[c.prop].unit},duration:b.duration,easing:b.easing,complete:function(){b.autoHeight||b.toShow.css("height",""),b.toShow.css({width:i,overflow:d}),b.complete()}})},bounceslide:function(a){this.slide(a,{easing:a.down?"easeOutBounce":"swing",duration:a.down?1e3:200})}}})})(jQuery);;/*! jQuery UI - v1.8.23 - 2012-08-15
* https://github.com/jquery/jquery-ui
* Includes: jquery.ui.autocomplete.js
* Copyright (c) 2012 AUTHORS.txt; Licensed MIT, GPL */
(function(a,b){var c=0;a.widget("ui.autocomplete",{options:{appendTo:"body",autoFocus:!1,delay:300,minLength:1,position:{my:"left top",at:"left bottom",collision:"none"},source:null},pending:0,_create:function(){var b=this,c=this.element[0].ownerDocument,d;this.isMultiLine=this.element.is("textarea"),this.element.addClass("ui-autocomplete-input").attr("autocomplete","off").attr({role:"textbox","aria-autocomplete":"list","aria-haspopup":"true"}).bind("keydown.autocomplete",function(c){if(b.options.disabled||b.element.propAttr("readOnly"))return;d=!1;var e=a.ui.keyCode;switch(c.keyCode){case e.PAGE_UP:b._move("previousPage",c);break;case e.PAGE_DOWN:b._move("nextPage",c);break;case e.UP:b._keyEvent("previous",c);break;case e.DOWN:b._keyEvent("next",c);break;case e.ENTER:case e.NUMPAD_ENTER:b.menu.active&&(d=!0,c.preventDefault());case e.TAB:if(!b.menu.active)return;b.menu.select(c);break;case e.ESCAPE:b.element.val(b.term),b.close(c);break;default:clearTimeout(b.searching),b.searching=setTimeout(function(){b.term!=b.element.val()&&(b.selectedItem=null,b.search(null,c))},b.options.delay)}}).bind("keypress.autocomplete",function(a){d&&(d=!1,a.preventDefault())}).bind("focus.autocomplete",function(){if(b.options.disabled)return;b.selectedItem=null,b.previous=b.element.val()}).bind("blur.autocomplete",function(a){if(b.options.disabled)return;clearTimeout(b.searching),b.closing=setTimeout(function(){b.close(a),b._change(a)},150)}),this._initSource(),this.menu=a("<ul></ul>").addClass("ui-autocomplete").appendTo(a(this.options.appendTo||"body",c)[0]).mousedown(function(c){var d=b.menu.element[0];a(c.target).closest(".ui-menu-item").length||setTimeout(function(){a(document).one("mousedown",function(c){c.target!==b.element[0]&&c.target!==d&&!a.ui.contains(d,c.target)&&b.close()})},1),setTimeout(function(){clearTimeout(b.closing)},13)}).menu({focus:function(a,c){var d=c.item.data("item.autocomplete");!1!==b._trigger("focus",a,{item:d})&&/^key/.test(a.originalEvent.type)&&b.element.val(d.value)},selected:function(a,d){var e=d.item.data("item.autocomplete"),f=b.previous;b.element[0]!==c.activeElement&&(b.element.focus(),b.previous=f,setTimeout(function(){b.previous=f,b.selectedItem=e},1)),!1!==b._trigger("select",a,{item:e})&&b.element.val(e.value),b.term=b.element.val(),b.close(a),b.selectedItem=e},blur:function(a,c){b.menu.element.is(":visible")&&b.element.val()!==b.term&&b.element.val(b.term)}}).zIndex(this.element.zIndex()+1).css({top:0,left:0}).hide().data("menu"),a.fn.bgiframe&&this.menu.element.bgiframe(),b.beforeunloadHandler=function(){b.element.removeAttr("autocomplete")},a(window).bind("beforeunload",b.beforeunloadHandler)},destroy:function(){this.element.removeClass("ui-autocomplete-input").removeAttr("autocomplete").removeAttr("role").removeAttr("aria-autocomplete").removeAttr("aria-haspopup"),this.menu.element.remove(),a(window).unbind("beforeunload",this.beforeunloadHandler),a.Widget.prototype.destroy.call(this)},_setOption:function(b,c){a.Widget.prototype._setOption.apply(this,arguments),b==="source"&&this._initSource(),b==="appendTo"&&this.menu.element.appendTo(a(c||"body",this.element[0].ownerDocument)[0]),b==="disabled"&&c&&this.xhr&&this.xhr.abort()},_initSource:function(){var b=this,c,d;a.isArray(this.options.source)?(c=this.options.source,this.source=function(b,d){d(a.ui.autocomplete.filter(c,b.term))}):typeof this.options.source=="string"?(d=this.options.source,this.source=function(c,e){b.xhr&&b.xhr.abort(),b.xhr=a.ajax({url:d,data:c,dataType:"json",success:function(a,b){e(a)},error:function(){e([])}})}):this.source=this.options.source},search:function(a,b){a=a!=null?a:this.element.val(),this.term=this.element.val();if(a.length<this.options.minLength)return this.close(b);clearTimeout(this.closing);if(this._trigger("search",b)===!1)return;return this._search(a)},_search:function(a){this.pending++,this.element.addClass("ui-autocomplete-loading"),this.source({term:a},this._response())},_response:function(){var a=this,b=++c;return function(d){b===c&&a.__response(d),a.pending--,a.pending||a.element.removeClass("ui-autocomplete-loading")}},__response:function(a){!this.options.disabled&&a&&a.length?(a=this._normalize(a),this._suggest(a),this._trigger("open")):this.close()},close:function(a){clearTimeout(this.closing),this.menu.element.is(":visible")&&(this.menu.element.hide(),this.menu.deactivate(),this._trigger("close",a))},_change:function(a){this.previous!==this.element.val()&&this._trigger("change",a,{item:this.selectedItem})},_normalize:function(b){return b.length&&b[0].label&&b[0].value?b:a.map(b,function(b){return typeof b=="string"?{label:b,value:b}:a.extend({label:b.label||b.value,value:b.value||b.label},b)})},_suggest:function(b){var c=this.menu.element.empty().zIndex(this.element.zIndex()+1);this._renderMenu(c,b),this.menu.deactivate(),this.menu.refresh(),c.show(),this._resizeMenu(),c.position(a.extend({of:this.element},this.options.position)),this.options.autoFocus&&this.menu.next(new a.Event("mouseover"))},_resizeMenu:function(){var a=this.menu.element;a.outerWidth(Math.max(a.width("").outerWidth()+1,this.element.outerWidth()))},_renderMenu:function(b,c){var d=this;a.each(c,function(a,c){d._renderItem(b,c)})},_renderItem:function(b,c){return a("<li></li>").data("item.autocomplete",c).append(a("<a></a>").text(c.label)).appendTo(b)},_move:function(a,b){if(!this.menu.element.is(":visible")){this.search(null,b);return}if(this.menu.first()&&/^previous/.test(a)||this.menu.last()&&/^next/.test(a)){this.element.val(this.term),this.menu.deactivate();return}this.menu[a](b)},widget:function(){return this.menu.element},_keyEvent:function(a,b){if(!this.isMultiLine||this.menu.element.is(":visible"))this._move(a,b),b.preventDefault()}}),a.extend(a.ui.autocomplete,{escapeRegex:function(a){return a.replace(/[-[\]{}()*+?.,\\^$|#\s]/g,"\\$&")},filter:function(b,c){var d=new RegExp(a.ui.autocomplete.escapeRegex(c),"i");return a.grep(b,function(a){return d.test(a.label||a.value||a)})}})})(jQuery),function(a){a.widget("ui.menu",{_create:function(){var b=this;this.element.addClass("ui-menu ui-widget ui-widget-content ui-corner-all").attr({role:"listbox","aria-activedescendant":"ui-active-menuitem"}).click(function(c){if(!a(c.target).closest(".ui-menu-item a").length)return;c.preventDefault(),b.select(c)}),this.refresh()},refresh:function(){var b=this,c=this.element.children("li:not(.ui-menu-item):has(a)").addClass("ui-menu-item").attr("role","menuitem");c.children("a").addClass("ui-corner-all").attr("tabindex",-1).mouseenter(function(c){b.activate(c,a(this).parent())}).mouseleave(function(){b.deactivate()})},activate:function(a,b){this.deactivate();if(this.hasScroll()){var c=b.offset().top-this.element.offset().top,d=this.element.scrollTop(),e=this.element.height();c<0?this.element.scrollTop(d+c):c>=e&&this.element.scrollTop(d+c-e+b.height())}this.active=b.eq(0).children("a").addClass("ui-state-hover").attr("id","ui-active-menuitem").end(),this._trigger("focus",a,{item:b})},deactivate:function(){if(!this.active)return;this.active.children("a").removeClass("ui-state-hover").removeAttr("id"),this._trigger("blur"),this.active=null},next:function(a){this.move("next",".ui-menu-item:first",a)},previous:function(a){this.move("prev",".ui-menu-item:last",a)},first:function(){return this.active&&!this.active.prevAll(".ui-menu-item").length},last:function(){return this.active&&!this.active.nextAll(".ui-menu-item").length},move:function(a,b,c){if(!this.active){this.activate(c,this.element.children(b));return}var d=this.active[a+"All"](".ui-menu-item").eq(0);d.length?this.activate(c,d):this.activate(c,this.element.children(b))},nextPage:function(b){if(this.hasScroll()){if(!this.active||this.last()){this.activate(b,this.element.children(".ui-menu-item:first"));return}var c=this.active.offset().top,d=this.element.height(),e=this.element.children(".ui-menu-item").filter(function(){var b=a(this).offset().top-c-d+a(this).height();return b<10&&b>-10});e.length||(e=this.element.children(".ui-menu-item:last")),this.activate(b,e)}else this.activate(b,this.element.children(".ui-menu-item").filter(!this.active||this.last()?":first":":last"))},previousPage:function(b){if(this.hasScroll()){if(!this.active||this.first()){this.activate(b,this.element.children(".ui-menu-item:last"));return}var c=this.active.offset().top,d=this.element.height(),e=this.element.children(".ui-menu-item").filter(function(){var b=a(this).offset().top-c+d-a(this).height();return b<10&&b>-10});e.length||(e=this.element.children(".ui-menu-item:first")),this.activate(b,e)}else this.activate(b,this.element.children(".ui-menu-item").filter(!this.active||this.first()?":last":":first"))},hasScroll:function(){return this.element.height()<this.element[a.fn.prop?"prop":"attr"]("scrollHeight")},select:function(a){this._trigger("selected",a,{item:this.active})}})}(jQuery);;/*! jQuery UI - v1.8.23 - 2012-08-15
* https://github.com/jquery/jquery-ui
* Includes: jquery.ui.button.js
* Copyright (c) 2012 AUTHORS.txt; Licensed MIT, GPL */
(function(a,b){var c,d,e,f,g="ui-button ui-widget ui-state-default ui-corner-all",h="ui-state-hover ui-state-active ",i="ui-button-icons-only ui-button-icon-only ui-button-text-icons ui-button-text-icon-primary ui-button-text-icon-secondary ui-button-text-only",j=function(){var b=a(this).find(":ui-button");setTimeout(function(){b.button("refresh")},1)},k=function(b){var c=b.name,d=b.form,e=a([]);return c&&(d?e=a(d).find("[name='"+c+"']"):e=a("[name='"+c+"']",b.ownerDocument).filter(function(){return!this.form})),e};a.widget("ui.button",{options:{disabled:null,text:!0,label:null,icons:{primary:null,secondary:null}},_create:function(){this.element.closest("form").unbind("reset.button").bind("reset.button",j),typeof this.options.disabled!="boolean"?this.options.disabled=!!this.element.propAttr("disabled"):this.element.propAttr("disabled",this.options.disabled),this._determineButtonType(),this.hasTitle=!!this.buttonElement.attr("title");var b=this,h=this.options,i=this.type==="checkbox"||this.type==="radio",l="ui-state-hover"+(i?"":" ui-state-active"),m="ui-state-focus";h.label===null&&(h.label=this.buttonElement.html()),this.buttonElement.addClass(g).attr("role","button").bind("mouseenter.button",function(){if(h.disabled)return;a(this).addClass("ui-state-hover"),this===c&&a(this).addClass("ui-state-active")}).bind("mouseleave.button",function(){if(h.disabled)return;a(this).removeClass(l)}).bind("click.button",function(a){h.disabled&&(a.preventDefault(),a.stopImmediatePropagation())}),this.element.bind("focus.button",function(){b.buttonElement.addClass(m)}).bind("blur.button",function(){b.buttonElement.removeClass(m)}),i&&(this.element.bind("change.button",function(){if(f)return;b.refresh()}),this.buttonElement.bind("mousedown.button",function(a){if(h.disabled)return;f=!1,d=a.pageX,e=a.pageY}).bind("mouseup.button",function(a){if(h.disabled)return;if(d!==a.pageX||e!==a.pageY)f=!0})),this.type==="checkbox"?this.buttonElement.bind("click.button",function(){if(h.disabled||f)return!1;a(this).toggleClass("ui-state-active"),b.buttonElement.attr("aria-pressed",b.element[0].checked)}):this.type==="radio"?this.buttonElement.bind("click.button",function(){if(h.disabled||f)return!1;a(this).addClass("ui-state-active"),b.buttonElement.attr("aria-pressed","true");var c=b.element[0];k(c).not(c).map(function(){return a(this).button("widget")[0]}).removeClass("ui-state-active").attr("aria-pressed","false")}):(this.buttonElement.bind("mousedown.button",function(){if(h.disabled)return!1;a(this).addClass("ui-state-active"),c=this,a(document).one("mouseup",function(){c=null})}).bind("mouseup.button",function(){if(h.disabled)return!1;a(this).removeClass("ui-state-active")}).bind("keydown.button",function(b){if(h.disabled)return!1;(b.keyCode==a.ui.keyCode.SPACE||b.keyCode==a.ui.keyCode.ENTER)&&a(this).addClass("ui-state-active")}).bind("keyup.button",function(){a(this).removeClass("ui-state-active")}),this.buttonElement.is("a")&&this.buttonElement.keyup(function(b){b.keyCode===a.ui.keyCode.SPACE&&a(this).click()})),this._setOption("disabled",h.disabled),this._resetButton()},_determineButtonType:function(){this.element.is(":checkbox")?this.type="checkbox":this.element.is(":radio")?this.type="radio":this.element.is("input")?this.type="input":this.type="button";if(this.type==="checkbox"||this.type==="radio"){var a=this.element.parents().filter(":last"),b="label[for='"+this.element.attr("id")+"']";this.buttonElement=a.find(b),this.buttonElement.length||(a=a.length?a.siblings():this.element.siblings(),this.buttonElement=a.filter(b),this.buttonElement.length||(this.buttonElement=a.find(b))),this.element.addClass("ui-helper-hidden-accessible");var c=this.element.is(":checked");c&&this.buttonElement.addClass("ui-state-active"),this.buttonElement.attr("aria-pressed",c)}else this.buttonElement=this.element},widget:function(){return this.buttonElement},destroy:function(){this.element.removeClass("ui-helper-hidden-accessible"),this.buttonElement.removeClass(g+" "+h+" "+i).removeAttr("role").removeAttr("aria-pressed").html(this.buttonElement.find(".ui-button-text").html()),this.hasTitle||this.buttonElement.removeAttr("title"),a.Widget.prototype.destroy.call(this)},_setOption:function(b,c){a.Widget.prototype._setOption.apply(this,arguments);if(b==="disabled"){c?this.element.propAttr("disabled",!0):this.element.propAttr("disabled",!1);return}this._resetButton()},refresh:function(){var b=this.element.is(":disabled");b!==this.options.disabled&&this._setOption("disabled",b),this.type==="radio"?k(this.element[0]).each(function(){a(this).is(":checked")?a(this).button("widget").addClass("ui-state-active").attr("aria-pressed","true"):a(this).button("widget").removeClass("ui-state-active").attr("aria-pressed","false")}):this.type==="checkbox"&&(this.element.is(":checked")?this.buttonElement.addClass("ui-state-active").attr("aria-pressed","true"):this.buttonElement.removeClass("ui-state-active").attr("aria-pressed","false"))},_resetButton:function(){if(this.type==="input"){this.options.label&&this.element.val(this.options.label);return}var b=this.buttonElement.removeClass(i),c=a("<span></span>",this.element[0].ownerDocument).addClass("ui-button-text").html(this.options.label).appendTo(b.empty()).text(),d=this.options.icons,e=d.primary&&d.secondary,f=[];d.primary||d.secondary?(this.options.text&&f.push("ui-button-text-icon"+(e?"s":d.primary?"-primary":"-secondary")),d.primary&&b.prepend("<span class='ui-button-icon-primary ui-icon "+d.primary+"'></span>"),d.secondary&&b.append("<span class='ui-button-icon-secondary ui-icon "+d.secondary+"'></span>"),this.options.text||(f.push(e?"ui-button-icons-only":"ui-button-icon-only"),this.hasTitle||b.attr("title",c))):f.push("ui-button-text-only"),b.addClass(f.join(" "))}}),a.widget("ui.buttonset",{options:{items:":button, :submit, :reset, :checkbox, :radio, a, :data(button)"},_create:function(){this.element.addClass("ui-buttonset")},_init:function(){this.refresh()},_setOption:function(b,c){b==="disabled"&&this.buttons.button("option",b,c),a.Widget.prototype._setOption.apply(this,arguments)},refresh:function(){var b=this.element.css("direction")==="rtl";this.buttons=this.element.find(this.options.items).filter(":ui-button").button("refresh").end().not(":ui-button").button().end().map(function(){return a(this).button("widget")[0]}).removeClass("ui-corner-all ui-corner-left ui-corner-right").filter(":first").addClass(b?"ui-corner-right":"ui-corner-left").end().filter(":last").addClass(b?"ui-corner-left":"ui-corner-right").end().end()},destroy:function(){this.element.removeClass("ui-buttonset"),this.buttons.map(function(){return a(this).button("widget")[0]}).removeClass("ui-corner-left ui-corner-right").end().button("destroy"),a.Widget.prototype.destroy.call(this)}})})(jQuery);;/*! jQuery UI - v1.8.23 - 2012-08-15
* https://github.com/jquery/jquery-ui
* Includes: jquery.ui.dialog.js
* Copyright (c) 2012 AUTHORS.txt; Licensed MIT, GPL */
(function(a,b){var c="ui-dialog ui-widget ui-widget-content ui-corner-all ",d={buttons:!0,height:!0,maxHeight:!0,maxWidth:!0,minHeight:!0,minWidth:!0,width:!0},e={maxHeight:!0,maxWidth:!0,minHeight:!0,minWidth:!0};a.widget("ui.dialog",{options:{autoOpen:!0,buttons:{},closeOnEscape:!0,closeText:"close",dialogClass:"",draggable:!0,hide:null,height:"auto",maxHeight:!1,maxWidth:!1,minHeight:150,minWidth:150,modal:!1,position:{my:"center",at:"center",collision:"fit",using:function(b){var c=a(this).css(b).offset().top;c<0&&a(this).css("top",b.top-c)}},resizable:!0,show:null,stack:!0,title:"",width:300,zIndex:1e3},_create:function(){this.originalTitle=this.element.attr("title"),typeof this.originalTitle!="string"&&(this.originalTitle=""),this.options.title=this.options.title||this.originalTitle;var b=this,d=b.options,e=d.title||"&#160;",f=a.ui.dialog.getTitleId(b.element),g=(b.uiDialog=a("<div></div>")).appendTo(document.body).hide().addClass(c+d.dialogClass).css({zIndex:d.zIndex}).attr("tabIndex",-1).css("outline",0).keydown(function(c){d.closeOnEscape&&!c.isDefaultPrevented()&&c.keyCode&&c.keyCode===a.ui.keyCode.ESCAPE&&(b.close(c),c.preventDefault())}).attr({role:"dialog","aria-labelledby":f}).mousedown(function(a){b.moveToTop(!1,a)}),h=b.element.show().removeAttr("title").addClass("ui-dialog-content ui-widget-content").appendTo(g),i=(b.uiDialogTitlebar=a("<div></div>")).addClass("ui-dialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix").prependTo(g),j=a('<a href="#"></a>').addClass("ui-dialog-titlebar-close ui-corner-all").attr("role","button").hover(function(){j.addClass("ui-state-hover")},function(){j.removeClass("ui-state-hover")}).focus(function(){j.addClass("ui-state-focus")}).blur(function(){j.removeClass("ui-state-focus")}).click(function(a){return b.close(a),!1}).appendTo(i),k=(b.uiDialogTitlebarCloseText=a("<span></span>")).addClass("ui-icon ui-icon-closethick").text(d.closeText).appendTo(j),l=a("<span></span>").addClass("ui-dialog-title").attr("id",f).html(e).prependTo(i);a.isFunction(d.beforeclose)&&!a.isFunction(d.beforeClose)&&(d.beforeClose=d.beforeclose),i.find("*").add(i).disableSelection(),d.draggable&&a.fn.draggable&&b._makeDraggable(),d.resizable&&a.fn.resizable&&b._makeResizable(),b._createButtons(d.buttons),b._isOpen=!1,a.fn.bgiframe&&g.bgiframe()},_init:function(){this.options.autoOpen&&this.open()},destroy:function(){var a=this;return a.overlay&&a.overlay.destroy(),a.uiDialog.hide(),a.element.unbind(".dialog").removeData("dialog").removeClass("ui-dialog-content ui-widget-content").hide().appendTo("body"),a.uiDialog.remove(),a.originalTitle&&a.element.attr("title",a.originalTitle),a},widget:function(){return this.uiDialog},close:function(b){var c=this,d,e;if(!1===c._trigger("beforeClose",b))return;return c.overlay&&c.overlay.destroy(),c.uiDialog.unbind("keypress.ui-dialog"),c._isOpen=!1,c.options.hide?c.uiDialog.hide(c.options.hide,function(){c._trigger("close",b)}):(c.uiDialog.hide(),c._trigger("close",b)),a.ui.dialog.overlay.resize(),c.options.modal&&(d=0,a(".ui-dialog").each(function(){this!==c.uiDialog[0]&&(e=a(this).css("z-index"),isNaN(e)||(d=Math.max(d,e)))}),a.ui.dialog.maxZ=d),c},isOpen:function(){return this._isOpen},moveToTop:function(b,c){var d=this,e=d.options,f;return e.modal&&!b||!e.stack&&!e.modal?d._trigger("focus",c):(e.zIndex>a.ui.dialog.maxZ&&(a.ui.dialog.maxZ=e.zIndex),d.overlay&&(a.ui.dialog.maxZ+=1,d.overlay.$el.css("z-index",a.ui.dialog.overlay.maxZ=a.ui.dialog.maxZ)),f={scrollTop:d.element.scrollTop(),scrollLeft:d.element.scrollLeft()},a.ui.dialog.maxZ+=1,d.uiDialog.css("z-index",a.ui.dialog.maxZ),d.element.attr(f),d._trigger("focus",c),d)},open:function(){if(this._isOpen)return;var b=this,c=b.options,d=b.uiDialog;return b.overlay=c.modal?new a.ui.dialog.overlay(b):null,b._size(),b._position(c.position),d.show(c.show),b.moveToTop(!0),c.modal&&d.bind("keydown.ui-dialog",function(b){if(b.keyCode!==a.ui.keyCode.TAB)return;var c=a(":tabbable",this),d=c.filter(":first"),e=c.filter(":last");if(b.target===e[0]&&!b.shiftKey)return d.focus(1),!1;if(b.target===d[0]&&b.shiftKey)return e.focus(1),!1}),a(b.element.find(":tabbable").get().concat(d.find(".ui-dialog-buttonpane :tabbable").get().concat(d.get()))).eq(0).focus(),b._isOpen=!0,b._trigger("open"),b},_createButtons:function(b){var c=this,d=!1,e=a("<div></div>").addClass("ui-dialog-buttonpane ui-widget-content ui-helper-clearfix"),f=a("<div></div>").addClass("ui-dialog-buttonset").appendTo(e);c.uiDialog.find(".ui-dialog-buttonpane").remove(),typeof b=="object"&&b!==null&&a.each(b,function(){return!(d=!0)}),d&&(a.each(b,function(b,d){d=a.isFunction(d)?{click:d,text:b}:d;var e=a('<button type="button"></button>').click(function(){d.click.apply(c.element[0],arguments)}).appendTo(f);a.each(d,function(a,b){if(a==="click")return;a in e?e[a](b):e.attr(a,b)}),a.fn.button&&e.button()}),e.appendTo(c.uiDialog))},_makeDraggable:function(){function f(a){return{position:a.position,offset:a.offset}}var b=this,c=b.options,d=a(document),e;b.uiDialog.draggable({cancel:".ui-dialog-content, .ui-dialog-titlebar-close",handle:".ui-dialog-titlebar",containment:"document",start:function(d,g){e=c.height==="auto"?"auto":a(this).height(),a(this).height(a(this).height()).addClass("ui-dialog-dragging"),b._trigger("dragStart",d,f(g))},drag:function(a,c){b._trigger("drag",a,f(c))},stop:function(g,h){c.position=[h.position.left-d.scrollLeft(),h.position.top-d.scrollTop()],a(this).removeClass("ui-dialog-dragging").height(e),b._trigger("dragStop",g,f(h)),a.ui.dialog.overlay.resize()}})},_makeResizable:function(c){function h(a){return{originalPosition:a.originalPosition,originalSize:a.originalSize,position:a.position,size:a.size}}c=c===b?this.options.resizable:c;var d=this,e=d.options,f=d.uiDialog.css("position"),g=typeof c=="string"?c:"n,e,s,w,se,sw,ne,nw";d.uiDialog.resizable({cancel:".ui-dialog-content",containment:"document",alsoResize:d.element,maxWidth:e.maxWidth,maxHeight:e.maxHeight,minWidth:e.minWidth,minHeight:d._minHeight(),handles:g,start:function(b,c){a(this).addClass("ui-dialog-resizing"),d._trigger("resizeStart",b,h(c))},resize:function(a,b){d._trigger("resize",a,h(b))},stop:function(b,c){a(this).removeClass("ui-dialog-resizing"),e.height=a(this).height(),e.width=a(this).width(),d._trigger("resizeStop",b,h(c)),a.ui.dialog.overlay.resize()}}).css("position",f).find(".ui-resizable-se").addClass("ui-icon ui-icon-grip-diagonal-se")},_minHeight:function(){var a=this.options;return a.height==="auto"?a.minHeight:Math.min(a.minHeight,a.height)},_position:function(b){var c=[],d=[0,0],e;if(b){if(typeof b=="string"||typeof b=="object"&&"0"in b)c=b.split?b.split(" "):[b[0],b[1]],c.length===1&&(c[1]=c[0]),a.each(["left","top"],function(a,b){+c[a]===c[a]&&(d[a]=c[a],c[a]=b)}),b={my:c.join(" "),at:c.join(" "),offset:d.join(" ")};b=a.extend({},a.ui.dialog.prototype.options.position,b)}else b=a.ui.dialog.prototype.options.position;e=this.uiDialog.is(":visible"),e||this.uiDialog.show(),this.uiDialog.css({top:0,left:0}).position(a.extend({of:window},b)),e||this.uiDialog.hide()},_setOptions:function(b){var c=this,f={},g=!1;a.each(b,function(a,b){c._setOption(a,b),a in d&&(g=!0),a in e&&(f[a]=b)}),g&&this._size(),this.uiDialog.is(":data(resizable)")&&this.uiDialog.resizable("option",f)},_setOption:function(b,d){var e=this,f=e.uiDialog;switch(b){case"beforeclose":b="beforeClose";break;case"buttons":e._createButtons(d);break;case"closeText":e.uiDialogTitlebarCloseText.text(""+d);break;case"dialogClass":f.removeClass(e.options.dialogClass).addClass(c+d);break;case"disabled":d?f.addClass("ui-dialog-disabled"):f.removeClass("ui-dialog-disabled");break;case"draggable":var g=f.is(":data(draggable)");g&&!d&&f.draggable("destroy"),!g&&d&&e._makeDraggable();break;case"position":e._position(d);break;case"resizable":var h=f.is(":data(resizable)");h&&!d&&f.resizable("destroy"),h&&typeof d=="string"&&f.resizable("option","handles",d),!h&&d!==!1&&e._makeResizable(d);break;case"title":a(".ui-dialog-title",e.uiDialogTitlebar).html(""+(d||"&#160;"))}a.Widget.prototype._setOption.apply(e,arguments)},_size:function(){var b=this.options,c,d,e=this.uiDialog.is(":visible");this.element.show().css({width:"auto",minHeight:0,height:0}),b.minWidth>b.width&&(b.width=b.minWidth),c=this.uiDialog.css({height:"auto",width:b.width}).height(),d=Math.max(0,b.minHeight-c);if(b.height==="auto")if(a.support.minHeight)this.element.css({minHeight:d,height:"auto"});else{this.uiDialog.show();var f=this.element.css("height","auto").height();e||this.uiDialog.hide(),this.element.height(Math.max(f,d))}else this.element.height(Math.max(b.height-c,0));this.uiDialog.is(":data(resizable)")&&this.uiDialog.resizable("option","minHeight",this._minHeight())}}),a.extend(a.ui.dialog,{version:"1.8.23",uuid:0,maxZ:0,getTitleId:function(a){var b=a.attr("id");return b||(this.uuid+=1,b=this.uuid),"ui-dialog-title-"+b},overlay:function(b){this.$el=a.ui.dialog.overlay.create(b)}}),a.extend(a.ui.dialog.overlay,{instances:[],oldInstances:[],maxZ:0,events:a.map("focus,mousedown,mouseup,keydown,keypress,click".split(","),function(a){return a+".dialog-overlay"}).join(" "),create:function(b){this.instances.length===0&&(setTimeout(function(){a.ui.dialog.overlay.instances.length&&a(document).bind(a.ui.dialog.overlay.events,function(b){if(a(b.target).zIndex()<a.ui.dialog.overlay.maxZ)return!1})},1),a(document).bind("keydown.dialog-overlay",function(c){b.options.closeOnEscape&&!c.isDefaultPrevented()&&c.keyCode&&c.keyCode===a.ui.keyCode.ESCAPE&&(b.close(c),c.preventDefault())}),a(window).bind("resize.dialog-overlay",a.ui.dialog.overlay.resize));var c=(this.oldInstances.pop()||a("<div></div>").addClass("ui-widget-overlay")).appendTo(document.body).css({width:this.width(),height:this.height()});return a.fn.bgiframe&&c.bgiframe(),this.instances.push(c),c},destroy:function(b){var c=a.inArray(b,this.instances);c!=-1&&this.oldInstances.push(this.instances.splice(c,1)[0]),this.instances.length===0&&a([document,window]).unbind(".dialog-overlay"),b.remove();var d=0;a.each(this.instances,function(){d=Math.max(d,this.css("z-index"))}),this.maxZ=d},height:function(){var b,c;return a.browser.msie&&a.browser.version<7?(b=Math.max(document.documentElement.scrollHeight,document.body.scrollHeight),c=Math.max(document.documentElement.offsetHeight,document.body.offsetHeight),b<c?a(window).height()+"px":b+"px"):a(document).height()+"px"},width:function(){var b,c;return a.browser.msie?(b=Math.max(document.documentElement.scrollWidth,document.body.scrollWidth),c=Math.max(document.documentElement.offsetWidth,document.body.offsetWidth),b<c?a(window).width()+"px":b+"px"):a(document).width()+"px"},resize:function(){var b=a([]);a.each(a.ui.dialog.overlay.instances,function(){b=b.add(this)}),b.css({width:0,height:0}).css({width:a.ui.dialog.overlay.width(),height:a.ui.dialog.overlay.height()})}}),a.extend(a.ui.dialog.overlay.prototype,{destroy:function(){a.ui.dialog.overlay.destroy(this.$el)}})})(jQuery);;/*! jQuery UI - v1.8.23 - 2012-08-15
* https://github.com/jquery/jquery-ui
* Includes: jquery.ui.slider.js
* Copyright (c) 2012 AUTHORS.txt; Licensed MIT, GPL */
(function(a,b){var c=5;a.widget("ui.slider",a.ui.mouse,{widgetEventPrefix:"slide",options:{animate:!1,distance:0,max:100,min:0,orientation:"horizontal",range:!1,step:1,value:0,values:null},_create:function(){var b=this,d=this.options,e=this.element.find(".ui-slider-handle").addClass("ui-state-default ui-corner-all"),f="<a class='ui-slider-handle ui-state-default ui-corner-all' href='#'></a>",g=d.values&&d.values.length||1,h=[];this._keySliding=!1,this._mouseSliding=!1,this._animateOff=!0,this._handleIndex=null,this._detectOrientation(),this._mouseInit(),this.element.addClass("ui-slider ui-slider-"+this.orientation+" ui-widget"+" ui-widget-content"+" ui-corner-all"+(d.disabled?" ui-slider-disabled ui-disabled":"")),this.range=a([]),d.range&&(d.range===!0&&(d.values||(d.values=[this._valueMin(),this._valueMin()]),d.values.length&&d.values.length!==2&&(d.values=[d.values[0],d.values[0]])),this.range=a("<div></div>").appendTo(this.element).addClass("ui-slider-range ui-widget-header"+(d.range==="min"||d.range==="max"?" ui-slider-range-"+d.range:"")));for(var i=e.length;i<g;i+=1)h.push(f);this.handles=e.add(a(h.join("")).appendTo(b.element)),this.handle=this.handles.eq(0),this.handles.add(this.range).filter("a").click(function(a){a.preventDefault()}).hover(function(){d.disabled||a(this).addClass("ui-state-hover")},function(){a(this).removeClass("ui-state-hover")}).focus(function(){d.disabled?a(this).blur():(a(".ui-slider .ui-state-focus").removeClass("ui-state-focus"),a(this).addClass("ui-state-focus"))}).blur(function(){a(this).removeClass("ui-state-focus")}),this.handles.each(function(b){a(this).data("index.ui-slider-handle",b)}),this.handles.keydown(function(d){var e=a(this).data("index.ui-slider-handle"),f,g,h,i;if(b.options.disabled)return;switch(d.keyCode){case a.ui.keyCode.HOME:case a.ui.keyCode.END:case a.ui.keyCode.PAGE_UP:case a.ui.keyCode.PAGE_DOWN:case a.ui.keyCode.UP:case a.ui.keyCode.RIGHT:case a.ui.keyCode.DOWN:case a.ui.keyCode.LEFT:d.preventDefault();if(!b._keySliding){b._keySliding=!0,a(this).addClass("ui-state-active"),f=b._start(d,e);if(f===!1)return}}i=b.options.step,b.options.values&&b.options.values.length?g=h=b.values(e):g=h=b.value();switch(d.keyCode){case a.ui.keyCode.HOME:h=b._valueMin();break;case a.ui.keyCode.END:h=b._valueMax();break;case a.ui.keyCode.PAGE_UP:h=b._trimAlignValue(g+(b._valueMax()-b._valueMin())/c);break;case a.ui.keyCode.PAGE_DOWN:h=b._trimAlignValue(g-(b._valueMax()-b._valueMin())/c);break;case a.ui.keyCode.UP:case a.ui.keyCode.RIGHT:if(g===b._valueMax())return;h=b._trimAlignValue(g+i);break;case a.ui.keyCode.DOWN:case a.ui.keyCode.LEFT:if(g===b._valueMin())return;h=b._trimAlignValue(g-i)}b._slide(d,e,h)}).keyup(function(c){var d=a(this).data("index.ui-slider-handle");b._keySliding&&(b._keySliding=!1,b._stop(c,d),b._change(c,d),a(this).removeClass("ui-state-active"))}),this._refreshValue(),this._animateOff=!1},destroy:function(){return this.handles.remove(),this.range.remove(),this.element.removeClass("ui-slider ui-slider-horizontal ui-slider-vertical ui-slider-disabled ui-widget ui-widget-content ui-corner-all").removeData("slider").unbind(".slider"),this._mouseDestroy(),this},_mouseCapture:function(b){var c=this.options,d,e,f,g,h,i,j,k,l;return c.disabled?!1:(this.elementSize={width:this.element.outerWidth(),height:this.element.outerHeight()},this.elementOffset=this.element.offset(),d={x:b.pageX,y:b.pageY},e=this._normValueFromMouse(d),f=this._valueMax()-this._valueMin()+1,h=this,this.handles.each(function(b){var c=Math.abs(e-h.values(b));f>c&&(f=c,g=a(this),i=b)}),c.range===!0&&this.values(1)===c.min&&(i+=1,g=a(this.handles[i])),j=this._start(b,i),j===!1?!1:(this._mouseSliding=!0,h._handleIndex=i,g.addClass("ui-state-active").focus(),k=g.offset(),l=!a(b.target).parents().andSelf().is(".ui-slider-handle"),this._clickOffset=l?{left:0,top:0}:{left:b.pageX-k.left-g.width()/2,top:b.pageY-k.top-g.height()/2-(parseInt(g.css("borderTopWidth"),10)||0)-(parseInt(g.css("borderBottomWidth"),10)||0)+(parseInt(g.css("marginTop"),10)||0)},this.handles.hasClass("ui-state-hover")||this._slide(b,i,e),this._animateOff=!0,!0))},_mouseStart:function(a){return!0},_mouseDrag:function(a){var b={x:a.pageX,y:a.pageY},c=this._normValueFromMouse(b);return this._slide(a,this._handleIndex,c),!1},_mouseStop:function(a){return this.handles.removeClass("ui-state-active"),this._mouseSliding=!1,this._stop(a,this._handleIndex),this._change(a,this._handleIndex),this._handleIndex=null,this._clickOffset=null,this._animateOff=!1,!1},_detectOrientation:function(){this.orientation=this.options.orientation==="vertical"?"vertical":"horizontal"},_normValueFromMouse:function(a){var b,c,d,e,f;return this.orientation==="horizontal"?(b=this.elementSize.width,c=a.x-this.elementOffset.left-(this._clickOffset?this._clickOffset.left:0)):(b=this.elementSize.height,c=a.y-this.elementOffset.top-(this._clickOffset?this._clickOffset.top:0)),d=c/b,d>1&&(d=1),d<0&&(d=0),this.orientation==="vertical"&&(d=1-d),e=this._valueMax()-this._valueMin(),f=this._valueMin()+d*e,this._trimAlignValue(f)},_start:function(a,b){var c={handle:this.handles[b],value:this.value()};return this.options.values&&this.options.values.length&&(c.value=this.values(b),c.values=this.values()),this._trigger("start",a,c)},_slide:function(a,b,c){var d,e,f;this.options.values&&this.options.values.length?(d=this.values(b?0:1),this.options.values.length===2&&this.options.range===!0&&(b===0&&c>d||b===1&&c<d)&&(c=d),c!==this.values(b)&&(e=this.values(),e[b]=c,f=this._trigger("slide",a,{handle:this.handles[b],value:c,values:e}),d=this.values(b?0:1),f!==!1&&this.values(b,c,!0))):c!==this.value()&&(f=this._trigger("slide",a,{handle:this.handles[b],value:c}),f!==!1&&this.value(c))},_stop:function(a,b){var c={handle:this.handles[b],value:this.value()};this.options.values&&this.options.values.length&&(c.value=this.values(b),c.values=this.values()),this._trigger("stop",a,c)},_change:function(a,b){if(!this._keySliding&&!this._mouseSliding){var c={handle:this.handles[b],value:this.value()};this.options.values&&this.options.values.length&&(c.value=this.values(b),c.values=this.values()),this._trigger("change",a,c)}},value:function(a){if(arguments.length){this.options.value=this._trimAlignValue(a),this._refreshValue(),this._change(null,0);return}return this._value()},values:function(b,c){var d,e,f;if(arguments.length>1){this.options.values[b]=this._trimAlignValue(c),this._refreshValue(),this._change(null,b);return}if(!arguments.length)return this._values();if(!a.isArray(arguments[0]))return this.options.values&&this.options.values.length?this._values(b):this.value();d=this.options.values,e=arguments[0];for(f=0;f<d.length;f+=1)d[f]=this._trimAlignValue(e[f]),this._change(null,f);this._refreshValue()},_setOption:function(b,c){var d,e=0;a.isArray(this.options.values)&&(e=this.options.values.length),a.Widget.prototype._setOption.apply(this,arguments);switch(b){case"disabled":c?(this.handles.filter(".ui-state-focus").blur(),this.handles.removeClass("ui-state-hover"),this.handles.propAttr("disabled",!0),this.element.addClass("ui-disabled")):(this.handles.propAttr("disabled",!1),this.element.removeClass("ui-disabled"));break;case"orientation":this._detectOrientation(),this.element.removeClass("ui-slider-horizontal ui-slider-vertical").addClass("ui-slider-"+this.orientation),this._refreshValue();break;case"value":this._animateOff=!0,this._refreshValue(),this._change(null,0),this._animateOff=!1;break;case"values":this._animateOff=!0,this._refreshValue();for(d=0;d<e;d+=1)this._change(null,d);this._animateOff=!1}},_value:function(){var a=this.options.value;return a=this._trimAlignValue(a),a},_values:function(a){var b,c,d;if(arguments.length)return b=this.options.values[a],b=this._trimAlignValue(b),b;c=this.options.values.slice();for(d=0;d<c.length;d+=1)c[d]=this._trimAlignValue(c[d]);return c},_trimAlignValue:function(a){if(a<=this._valueMin())return this._valueMin();if(a>=this._valueMax())return this._valueMax();var b=this.options.step>0?this.options.step:1,c=(a-this._valueMin())%b,d=a-c;return Math.abs(c)*2>=b&&(d+=c>0?b:-b),parseFloat(d.toFixed(5))},_valueMin:function(){return this.options.min},_valueMax:function(){return this.options.max},_refreshValue:function(){var b=this.options.range,c=this.options,d=this,e=this._animateOff?!1:c.animate,f,g={},h,i,j,k;this.options.values&&this.options.values.length?this.handles.each(function(b,i){f=(d.values(b)-d._valueMin())/(d._valueMax()-d._valueMin())*100,g[d.orientation==="horizontal"?"left":"bottom"]=f+"%",a(this).stop(1,1)[e?"animate":"css"](g,c.animate),d.options.range===!0&&(d.orientation==="horizontal"?(b===0&&d.range.stop(1,1)[e?"animate":"css"]({left:f+"%"},c.animate),b===1&&d.range[e?"animate":"css"]({width:f-h+"%"},{queue:!1,duration:c.animate})):(b===0&&d.range.stop(1,1)[e?"animate":"css"]({bottom:f+"%"},c.animate),b===1&&d.range[e?"animate":"css"]({height:f-h+"%"},{queue:!1,duration:c.animate}))),h=f}):(i=this.value(),j=this._valueMin(),k=this._valueMax(),f=k!==j?(i-j)/(k-j)*100:0,g[d.orientation==="horizontal"?"left":"bottom"]=f+"%",this.handle.stop(1,1)[e?"animate":"css"](g,c.animate),b==="min"&&this.orientation==="horizontal"&&this.range.stop(1,1)[e?"animate":"css"]({width:f+"%"},c.animate),b==="max"&&this.orientation==="horizontal"&&this.range[e?"animate":"css"]({width:100-f+"%"},{queue:!1,duration:c.animate}),b==="min"&&this.orientation==="vertical"&&this.range.stop(1,1)[e?"animate":"css"]({height:f+"%"},c.animate),b==="max"&&this.orientation==="vertical"&&this.range[e?"animate":"css"]({height:100-f+"%"},{queue:!1,duration:c.animate}))}}),a.extend(a.ui.slider,{version:"1.8.23"})})(jQuery);;/*! jQuery UI - v1.8.23 - 2012-08-15
* https://github.com/jquery/jquery-ui
* Includes: jquery.ui.tabs.js
* Copyright (c) 2012 AUTHORS.txt; Licensed MIT, GPL */
(function(a,b){function e(){return++c}function f(){return++d}var c=0,d=0;a.widget("ui.tabs",{options:{add:null,ajaxOptions:null,cache:!1,cookie:null,collapsible:!1,disable:null,disabled:[],enable:null,event:"click",fx:null,idPrefix:"ui-tabs-",load:null,panelTemplate:"<div></div>",remove:null,select:null,show:null,spinner:"<em>Loading&#8230;</em>",tabTemplate:"<li><a href='#{href}'><span>#{label}</span></a></li>"},_create:function(){this._tabify(!0)},_setOption:function(a,b){if(a=="selected"){if(this.options.collapsible&&b==this.options.selected)return;this.select(b)}else this.options[a]=b,this._tabify()},_tabId:function(a){return a.title&&a.title.replace(/\s/g,"_").replace(/[^\w\u00c0-\uFFFF-]/g,"")||this.options.idPrefix+e()},_sanitizeSelector:function(a){return a.replace(/:/g,"\\:")},_cookie:function(){var b=this.cookie||(this.cookie=this.options.cookie.name||"ui-tabs-"+f());return a.cookie.apply(null,[b].concat(a.makeArray(arguments)))},_ui:function(a,b){return{tab:a,panel:b,index:this.anchors.index(a)}},_cleanup:function(){this.lis.filter(".ui-state-processing").removeClass("ui-state-processing").find("span:data(label.tabs)").each(function(){var b=a(this);b.html(b.data("label.tabs")).removeData("label.tabs")})},_tabify:function(c){function m(b,c){b.css("display",""),!a.support.opacity&&c.opacity&&b[0].style.removeAttribute("filter")}var d=this,e=this.options,f=/^#.+/;this.list=this.element.find("ol,ul").eq(0),this.lis=a(" > li:has(a[href])",this.list),this.anchors=this.lis.map(function(){return a("a",this)[0]}),this.panels=a([]),this.anchors.each(function(b,c){var g=a(c).attr("href"),h=g.split("#")[0],i;h&&(h===location.toString().split("#")[0]||(i=a("base")[0])&&h===i.href)&&(g=c.hash,c.href=g);if(f.test(g))d.panels=d.panels.add(d.element.find(d._sanitizeSelector(g)));else if(g&&g!=="#"){a.data(c,"href.tabs",g),a.data(c,"load.tabs",g.replace(/#.*$/,""));var j=d._tabId(c);c.href="#"+j;var k=d.element.find("#"+j);k.length||(k=a(e.panelTemplate).attr("id",j).addClass("ui-tabs-panel ui-widget-content ui-corner-bottom").insertAfter(d.panels[b-1]||d.list),k.data("destroy.tabs",!0)),d.panels=d.panels.add(k)}else e.disabled.push(b)}),c?(this.element.addClass("ui-tabs ui-widget ui-widget-content ui-corner-all"),this.list.addClass("ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all"),this.lis.addClass("ui-state-default ui-corner-top"),this.panels.addClass("ui-tabs-panel ui-widget-content ui-corner-bottom"),e.selected===b?(location.hash&&this.anchors.each(function(a,b){if(b.hash==location.hash)return e.selected=a,!1}),typeof e.selected!="number"&&e.cookie&&(e.selected=parseInt(d._cookie(),10)),typeof e.selected!="number"&&this.lis.filter(".ui-tabs-selected").length&&(e.selected=this.lis.index(this.lis.filter(".ui-tabs-selected"))),e.selected=e.selected||(this.lis.length?0:-1)):e.selected===null&&(e.selected=-1),e.selected=e.selected>=0&&this.anchors[e.selected]||e.selected<0?e.selected:0,e.disabled=a.unique(e.disabled.concat(a.map(this.lis.filter(".ui-state-disabled"),function(a,b){return d.lis.index(a)}))).sort(),a.inArray(e.selected,e.disabled)!=-1&&e.disabled.splice(a.inArray(e.selected,e.disabled),1),this.panels.addClass("ui-tabs-hide"),this.lis.removeClass("ui-tabs-selected ui-state-active"),e.selected>=0&&this.anchors.length&&(d.element.find(d._sanitizeSelector(d.anchors[e.selected].hash)).removeClass("ui-tabs-hide"),this.lis.eq(e.selected).addClass("ui-tabs-selected ui-state-active"),d.element.queue("tabs",function(){d._trigger("show",null,d._ui(d.anchors[e.selected],d.element.find(d._sanitizeSelector(d.anchors[e.selected].hash))[0]))}),this.load(e.selected)),a(window).bind("unload",function(){d.lis.add(d.anchors).unbind(".tabs"),d.lis=d.anchors=d.panels=null})):e.selected=this.lis.index(this.lis.filter(".ui-tabs-selected")),this.element[e.collapsible?"addClass":"removeClass"]("ui-tabs-collapsible"),e.cookie&&this._cookie(e.selected,e.cookie);for(var g=0,h;h=this.lis[g];g++)a(h)[a.inArray(g,e.disabled)!=-1&&!a(h).hasClass("ui-tabs-selected")?"addClass":"removeClass"]("ui-state-disabled");e.cache===!1&&this.anchors.removeData("cache.tabs"),this.lis.add(this.anchors).unbind(".tabs");if(e.event!=="mouseover"){var i=function(a,b){b.is(":not(.ui-state-disabled)")&&b.addClass("ui-state-"+a)},j=function(a,b){b.removeClass("ui-state-"+a)};this.lis.bind("mouseover.tabs",function(){i("hover",a(this))}),this.lis.bind("mouseout.tabs",function(){j("hover",a(this))}),this.anchors.bind("focus.tabs",function(){i("focus",a(this).closest("li"))}),this.anchors.bind("blur.tabs",function(){j("focus",a(this).closest("li"))})}var k,l;e.fx&&(a.isArray(e.fx)?(k=e.fx[0],l=e.fx[1]):k=l=e.fx);var n=l?function(b,c){a(b).closest("li").addClass("ui-tabs-selected ui-state-active"),c.hide().removeClass("ui-tabs-hide").animate(l,l.duration||"normal",function(){m(c,l),d._trigger("show",null,d._ui(b,c[0]))})}:function(b,c){a(b).closest("li").addClass("ui-tabs-selected ui-state-active"),c.removeClass("ui-tabs-hide"),d._trigger("show",null,d._ui(b,c[0]))},o=k?function(a,b){b.animate(k,k.duration||"normal",function(){d.lis.removeClass("ui-tabs-selected ui-state-active"),b.addClass("ui-tabs-hide"),m(b,k),d.element.dequeue("tabs")})}:function(a,b,c){d.lis.removeClass("ui-tabs-selected ui-state-active"),b.addClass("ui-tabs-hide"),d.element.dequeue("tabs")};this.anchors.bind(e.event+".tabs",function(){var b=this,c=a(b).closest("li"),f=d.panels.filter(":not(.ui-tabs-hide)"),g=d.element.find(d._sanitizeSelector(b.hash));if(c.hasClass("ui-tabs-selected")&&!e.collapsible||c.hasClass("ui-state-disabled")||c.hasClass("ui-state-processing")||d.panels.filter(":animated").length||d._trigger("select",null,d._ui(this,g[0]))===!1)return this.blur(),!1;e.selected=d.anchors.index(this),d.abort();if(e.collapsible){if(c.hasClass("ui-tabs-selected"))return e.selected=-1,e.cookie&&d._cookie(e.selected,e.cookie),d.element.queue("tabs",function(){o(b,f)}).dequeue("tabs"),this.blur(),!1;if(!f.length)return e.cookie&&d._cookie(e.selected,e.cookie),d.element.queue("tabs",function(){n(b,g)}),d.load(d.anchors.index(this)),this.blur(),!1}e.cookie&&d._cookie(e.selected,e.cookie);if(g.length)f.length&&d.element.queue("tabs",function(){o(b,f)}),d.element.queue("tabs",function(){n(b,g)}),d.load(d.anchors.index(this));else throw"jQuery UI Tabs: Mismatching fragment identifier.";a.browser.msie&&this.blur()}),this.anchors.bind("click.tabs",function(){return!1})},_getIndex:function(a){return typeof a=="string"&&(a=this.anchors.index(this.anchors.filter("[href$='"+a+"']"))),a},destroy:function(){var b=this.options;return this.abort(),this.element.unbind(".tabs").removeClass("ui-tabs ui-widget ui-widget-content ui-corner-all ui-tabs-collapsible").removeData("tabs"),this.list.removeClass("ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all"),this.anchors.each(function(){var b=a.data(this,"href.tabs");b&&(this.href=b);var c=a(this).unbind(".tabs");a.each(["href","load","cache"],function(a,b){c.removeData(b+".tabs")})}),this.lis.unbind(".tabs").add(this.panels).each(function(){a.data(this,"destroy.tabs")?a(this).remove():a(this).removeClass(["ui-state-default","ui-corner-top","ui-tabs-selected","ui-state-active","ui-state-hover","ui-state-focus","ui-state-disabled","ui-tabs-panel","ui-widget-content","ui-corner-bottom","ui-tabs-hide"].join(" "))}),b.cookie&&this._cookie(null,b.cookie),this},add:function(c,d,e){e===b&&(e=this.anchors.length);var f=this,g=this.options,h=a(g.tabTemplate.replace(/#\{href\}/g,c).replace(/#\{label\}/g,d)),i=c.indexOf("#")?this._tabId(a("a",h)[0]):c.replace("#","");h.addClass("ui-state-default ui-corner-top").data("destroy.tabs",!0);var j=f.element.find("#"+i);return j.length||(j=a(g.panelTemplate).attr("id",i).data("destroy.tabs",!0)),j.addClass("ui-tabs-panel ui-widget-content ui-corner-bottom ui-tabs-hide"),e>=this.lis.length?(h.appendTo(this.list),j.appendTo(this.list[0].parentNode)):(h.insertBefore(this.lis[e]),j.insertBefore(this.panels[e])),g.disabled=a.map(g.disabled,function(a,b){return a>=e?++a:a}),this._tabify(),this.anchors.length==1&&(g.selected=0,h.addClass("ui-tabs-selected ui-state-active"),j.removeClass("ui-tabs-hide"),this.element.queue("tabs",function(){f._trigger("show",null,f._ui(f.anchors[0],f.panels[0]))}),this.load(0)),this._trigger("add",null,this._ui(this.anchors[e],this.panels[e])),this},remove:function(b){b=this._getIndex(b);var c=this.options,d=this.lis.eq(b).remove(),e=this.panels.eq(b).remove();return d.hasClass("ui-tabs-selected")&&this.anchors.length>1&&this.select(b+(b+1<this.anchors.length?1:-1)),c.disabled=a.map(a.grep(c.disabled,function(a,c){return a!=b}),function(a,c){return a>=b?--a:a}),this._tabify(),this._trigger("remove",null,this._ui(d.find("a")[0],e[0])),this},enable:function(b){b=this._getIndex(b);var c=this.options;if(a.inArray(b,c.disabled)==-1)return;return this.lis.eq(b).removeClass("ui-state-disabled"),c.disabled=a.grep(c.disabled,function(a,c){return a!=b}),this._trigger("enable",null,this._ui(this.anchors[b],this.panels[b])),this},disable:function(a){a=this._getIndex(a);var b=this,c=this.options;return a!=c.selected&&(this.lis.eq(a).addClass("ui-state-disabled"),c.disabled.push(a),c.disabled.sort(),this._trigger("disable",null,this._ui(this.anchors[a],this.panels[a]))),this},select:function(a){a=this._getIndex(a);if(a==-1)if(this.options.collapsible&&this.options.selected!=-1)a=this.options.selected;else return this;return this.anchors.eq(a).trigger(this.options.event+".tabs"),this},load:function(b){b=this._getIndex(b);var c=this,d=this.options,e=this.anchors.eq(b)[0],f=a.data(e,"load.tabs");this.abort();if(!f||this.element.queue("tabs").length!==0&&a.data(e,"cache.tabs")){this.element.dequeue("tabs");return}this.lis.eq(b).addClass("ui-state-processing");if(d.spinner){var g=a("span",e);g.data("label.tabs",g.html()).html(d.spinner)}return this.xhr=a.ajax(a.extend({},d.ajaxOptions,{url:f,success:function(f,g){c.element.find(c._sanitizeSelector(e.hash)).html(f),c._cleanup(),d.cache&&a.data(e,"cache.tabs",!0),c._trigger("load",null,c._ui(c.anchors[b],c.panels[b]));try{d.ajaxOptions.success(f,g)}catch(h){}},error:function(a,f,g){c._cleanup(),c._trigger("load",null,c._ui(c.anchors[b],c.panels[b]));try{d.ajaxOptions.error(a,f,b,e)}catch(g){}}})),c.element.dequeue("tabs"),this},abort:function(){return this.element.queue([]),this.panels.stop(!1,!0),this.element.queue("tabs",this.element.queue("tabs").splice(-2,2)),this.xhr&&(this.xhr.abort(),delete this.xhr),this._cleanup(),this},url:function(a,b){return this.anchors.eq(a).removeData("cache.tabs").data("load.tabs",b),this},length:function(){return this.anchors.length}}),a.extend(a.ui.tabs,{version:"1.8.23"}),a.extend(a.ui.tabs.prototype,{rotation:null,rotate:function(a,b){var c=this,d=this.options,e=c._rotate||(c._rotate=function(b){clearTimeout(c.rotation),c.rotation=setTimeout(function(){var a=d.selected;c.select(++a<c.anchors.length?a:0)},a),b&&b.stopPropagation()}),f=c._unrotate||(c._unrotate=b?function(a){e()}:function(a){a.clientX&&c.rotate(null)});return a?(this.element.bind("tabsshow",e),this.anchors.bind(d.event+".tabs",f),e()):(clearTimeout(c.rotation),this.element.unbind("tabsshow",e),this.anchors.unbind(d.event+".tabs",f),delete this._rotate,delete this._unrotate),this}})})(jQuery);;/*! jQuery UI - v1.8.23 - 2012-08-15
* https://github.com/jquery/jquery-ui
* Includes: jquery.ui.datepicker.js
* Copyright (c) 2012 AUTHORS.txt; Licensed MIT, GPL */
(function($,undefined){function Datepicker(){this.debug=!1,this._curInst=null,this._keyEvent=!1,this._disabledInputs=[],this._datepickerShowing=!1,this._inDialog=!1,this._mainDivId="ui-datepicker-div",this._inlineClass="ui-datepicker-inline",this._appendClass="ui-datepicker-append",this._triggerClass="ui-datepicker-trigger",this._dialogClass="ui-datepicker-dialog",this._disableClass="ui-datepicker-disabled",this._unselectableClass="ui-datepicker-unselectable",this._currentClass="ui-datepicker-current-day",this._dayOverClass="ui-datepicker-days-cell-over",this.regional=[],this.regional[""]={closeText:"Done",prevText:"Prev",nextText:"Next",currentText:"Today",monthNames:["January","February","March","April","May","June","July","August","September","October","November","December"],monthNamesShort:["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"],dayNames:["Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"],dayNamesShort:["Sun","Mon","Tue","Wed","Thu","Fri","Sat"],dayNamesMin:["Su","Mo","Tu","We","Th","Fr","Sa"],weekHeader:"Wk",dateFormat:"mm/dd/yy",firstDay:0,isRTL:!1,showMonthAfterYear:!1,yearSuffix:""},this._defaults={showOn:"focus",showAnim:"fadeIn",showOptions:{},defaultDate:null,appendText:"",buttonText:"...",buttonImage:"",buttonImageOnly:!1,hideIfNoPrevNext:!1,navigationAsDateFormat:!1,gotoCurrent:!1,changeMonth:!1,changeYear:!1,yearRange:"c-10:c+10",showOtherMonths:!1,selectOtherMonths:!1,showWeek:!1,calculateWeek:this.iso8601Week,shortYearCutoff:"+10",minDate:null,maxDate:null,duration:"fast",beforeShowDay:null,beforeShow:null,onSelect:null,onChangeMonthYear:null,onClose:null,numberOfMonths:1,showCurrentAtPos:0,stepMonths:1,stepBigMonths:12,altField:"",altFormat:"",constrainInput:!0,showButtonPanel:!1,autoSize:!1,disabled:!1},$.extend(this._defaults,this.regional[""]),this.dpDiv=bindHover($('<div id="'+this._mainDivId+'" class="ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all"></div>'))}function bindHover(a){var b="button, .ui-datepicker-prev, .ui-datepicker-next, .ui-datepicker-calendar td a";return a.bind("mouseout",function(a){var c=$(a.target).closest(b);if(!c.length)return;c.removeClass("ui-state-hover ui-datepicker-prev-hover ui-datepicker-next-hover")}).bind("mouseover",function(c){var d=$(c.target).closest(b);if($.datepicker._isDisabledDatepicker(instActive.inline?a.parent()[0]:instActive.input[0])||!d.length)return;d.parents(".ui-datepicker-calendar").find("a").removeClass("ui-state-hover"),d.addClass("ui-state-hover"),d.hasClass("ui-datepicker-prev")&&d.addClass("ui-datepicker-prev-hover"),d.hasClass("ui-datepicker-next")&&d.addClass("ui-datepicker-next-hover")})}function extendRemove(a,b){$.extend(a,b);for(var c in b)if(b[c]==null||b[c]==undefined)a[c]=b[c];return a}function isArray(a){return a&&($.browser.safari&&typeof a=="object"&&a.length||a.constructor&&a.constructor.toString().match(/\Array\(\)/))}$.extend($.ui,{datepicker:{version:"1.8.23"}});var PROP_NAME="datepicker",dpuuid=(new Date).getTime(),instActive;$.extend(Datepicker.prototype,{markerClassName:"hasDatepicker",maxRows:4,log:function(){this.debug&&console.log.apply("",arguments)},_widgetDatepicker:function(){return this.dpDiv},setDefaults:function(a){return extendRemove(this._defaults,a||{}),this},_attachDatepicker:function(target,settings){var inlineSettings=null;for(var attrName in this._defaults){var attrValue=target.getAttribute("date:"+attrName);if(attrValue){inlineSettings=inlineSettings||{};try{inlineSettings[attrName]=eval(attrValue)}catch(err){inlineSettings[attrName]=attrValue}}}var nodeName=target.nodeName.toLowerCase(),inline=nodeName=="div"||nodeName=="span";target.id||(this.uuid+=1,target.id="dp"+this.uuid);var inst=this._newInst($(target),inline);inst.settings=$.extend({},settings||{},inlineSettings||{}),nodeName=="input"?this._connectDatepicker(target,inst):inline&&this._inlineDatepicker(target,inst)},_newInst:function(a,b){var c=a[0].id.replace(/([^A-Za-z0-9_-])/g,"\\\\$1");return{id:c,input:a,selectedDay:0,selectedMonth:0,selectedYear:0,drawMonth:0,drawYear:0,inline:b,dpDiv:b?bindHover($('<div class="'+this._inlineClass+' ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all"></div>')):this.dpDiv}},_connectDatepicker:function(a,b){var c=$(a);b.append=$([]),b.trigger=$([]);if(c.hasClass(this.markerClassName))return;this._attachments(c,b),c.addClass(this.markerClassName).keydown(this._doKeyDown).keypress(this._doKeyPress).keyup(this._doKeyUp).bind("setData.datepicker",function(a,c,d){b.settings[c]=d}).bind("getData.datepicker",function(a,c){return this._get(b,c)}),this._autoSize(b),$.data(a,PROP_NAME,b),b.settings.disabled&&this._disableDatepicker(a)},_attachments:function(a,b){var c=this._get(b,"appendText"),d=this._get(b,"isRTL");b.append&&b.append.remove(),c&&(b.append=$('<span class="'+this._appendClass+'">'+c+"</span>"),a[d?"before":"after"](b.append)),a.unbind("focus",this._showDatepicker),b.trigger&&b.trigger.remove();var e=this._get(b,"showOn");(e=="focus"||e=="both")&&a.focus(this._showDatepicker);if(e=="button"||e=="both"){var f=this._get(b,"buttonText"),g=this._get(b,"buttonImage");b.trigger=$(this._get(b,"buttonImageOnly")?$("<img/>").addClass(this._triggerClass).attr({src:g,alt:f,title:f}):$('<button type="button"></button>').addClass(this._triggerClass).html(g==""?f:$("<img/>").attr({src:g,alt:f,title:f}))),a[d?"before":"after"](b.trigger),b.trigger.click(function(){return $.datepicker._datepickerShowing&&$.datepicker._lastInput==a[0]?$.datepicker._hideDatepicker():$.datepicker._datepickerShowing&&$.datepicker._lastInput!=a[0]?($.datepicker._hideDatepicker(),$.datepicker._showDatepicker(a[0])):$.datepicker._showDatepicker(a[0]),!1})}},_autoSize:function(a){if(this._get(a,"autoSize")&&!a.inline){var b=new Date(2009,11,20),c=this._get(a,"dateFormat");if(c.match(/[DM]/)){var d=function(a){var b=0,c=0;for(var d=0;d<a.length;d++)a[d].length>b&&(b=a[d].length,c=d);return c};b.setMonth(d(this._get(a,c.match(/MM/)?"monthNames":"monthNamesShort"))),b.setDate(d(this._get(a,c.match(/DD/)?"dayNames":"dayNamesShort"))+20-b.getDay())}a.input.attr("size",this._formatDate(a,b).length)}},_inlineDatepicker:function(a,b){var c=$(a);if(c.hasClass(this.markerClassName))return;c.addClass(this.markerClassName).append(b.dpDiv).bind("setData.datepicker",function(a,c,d){b.settings[c]=d}).bind("getData.datepicker",function(a,c){return this._get(b,c)}),$.data(a,PROP_NAME,b),this._setDate(b,this._getDefaultDate(b),!0),this._updateDatepicker(b),this._updateAlternate(b),b.settings.disabled&&this._disableDatepicker(a),b.dpDiv.css("display","block")},_dialogDatepicker:function(a,b,c,d,e){var f=this._dialogInst;if(!f){this.uuid+=1;var g="dp"+this.uuid;this._dialogInput=$('<input type="text" id="'+g+'" style="position: absolute; top: -100px; width: 0px;"/>'),this._dialogInput.keydown(this._doKeyDown),$("body").append(this._dialogInput),f=this._dialogInst=this._newInst(this._dialogInput,!1),f.settings={},$.data(this._dialogInput[0],PROP_NAME,f)}extendRemove(f.settings,d||{}),b=b&&b.constructor==Date?this._formatDate(f,b):b,this._dialogInput.val(b),this._pos=e?e.length?e:[e.pageX,e.pageY]:null;if(!this._pos){var h=document.documentElement.clientWidth,i=document.documentElement.clientHeight,j=document.documentElement.scrollLeft||document.body.scrollLeft,k=document.documentElement.scrollTop||document.body.scrollTop;this._pos=[h/2-100+j,i/2-150+k]}return this._dialogInput.css("left",this._pos[0]+20+"px").css("top",this._pos[1]+"px"),f.settings.onSelect=c,this._inDialog=!0,this.dpDiv.addClass(this._dialogClass),this._showDatepicker(this._dialogInput[0]),$.blockUI&&$.blockUI(this.dpDiv),$.data(this._dialogInput[0],PROP_NAME,f),this},_destroyDatepicker:function(a){var b=$(a),c=$.data(a,PROP_NAME);if(!b.hasClass(this.markerClassName))return;var d=a.nodeName.toLowerCase();$.removeData(a,PROP_NAME),d=="input"?(c.append.remove(),c.trigger.remove(),b.removeClass(this.markerClassName).unbind("focus",this._showDatepicker).unbind("keydown",this._doKeyDown).unbind("keypress",this._doKeyPress).unbind("keyup",this._doKeyUp)):(d=="div"||d=="span")&&b.removeClass(this.markerClassName).empty()},_enableDatepicker:function(a){var b=$(a),c=$.data(a,PROP_NAME);if(!b.hasClass(this.markerClassName))return;var d=a.nodeName.toLowerCase();if(d=="input")a.disabled=!1,c.trigger.filter("button").each(function(){this.disabled=!1}).end().filter("img").css({opacity:"1.0",cursor:""});else if(d=="div"||d=="span"){var e=b.children("."+this._inlineClass);e.children().removeClass("ui-state-disabled"),e.find("select.ui-datepicker-month, select.ui-datepicker-year").removeAttr("disabled")}this._disabledInputs=$.map(this._disabledInputs,function(b){return b==a?null:b})},_disableDatepicker:function(a){var b=$(a),c=$.data(a,PROP_NAME);if(!b.hasClass(this.markerClassName))return;var d=a.nodeName.toLowerCase();if(d=="input")a.disabled=!0,c.trigger.filter("button").each(function(){this.disabled=!0}).end().filter("img").css({opacity:"0.5",cursor:"default"});else if(d=="div"||d=="span"){var e=b.children("."+this._inlineClass);e.children().addClass("ui-state-disabled"),e.find("select.ui-datepicker-month, select.ui-datepicker-year").attr("disabled","disabled")}this._disabledInputs=$.map(this._disabledInputs,function(b){return b==a?null:b}),this._disabledInputs[this._disabledInputs.length]=a},_isDisabledDatepicker:function(a){if(!a)return!1;for(var b=0;b<this._disabledInputs.length;b++)if(this._disabledInputs[b]==a)return!0;return!1},_getInst:function(a){try{return $.data(a,PROP_NAME)}catch(b){throw"Missing instance data for this datepicker"}},_optionDatepicker:function(a,b,c){var d=this._getInst(a);if(arguments.length==2&&typeof b=="string")return b=="defaults"?$.extend({},$.datepicker._defaults):d?b=="all"?$.extend({},d.settings):this._get(d,b):null;var e=b||{};typeof b=="string"&&(e={},e[b]=c);if(d){this._curInst==d&&this._hideDatepicker();var f=this._getDateDatepicker(a,!0),g=this._getMinMaxDate(d,"min"),h=this._getMinMaxDate(d,"max");extendRemove(d.settings,e),g!==null&&e.dateFormat!==undefined&&e.minDate===undefined&&(d.settings.minDate=this._formatDate(d,g)),h!==null&&e.dateFormat!==undefined&&e.maxDate===undefined&&(d.settings.maxDate=this._formatDate(d,h)),this._attachments($(a),d),this._autoSize(d),this._setDate(d,f),this._updateAlternate(d),this._updateDatepicker(d)}},_changeDatepicker:function(a,b,c){this._optionDatepicker(a,b,c)},_refreshDatepicker:function(a){var b=this._getInst(a);b&&this._updateDatepicker(b)},_setDateDatepicker:function(a,b){var c=this._getInst(a);c&&(this._setDate(c,b),this._updateDatepicker(c),this._updateAlternate(c))},_getDateDatepicker:function(a,b){var c=this._getInst(a);return c&&!c.inline&&this._setDateFromField(c,b),c?this._getDate(c):null},_doKeyDown:function(a){var b=$.datepicker._getInst(a.target),c=!0,d=b.dpDiv.is(".ui-datepicker-rtl");b._keyEvent=!0;if($.datepicker._datepickerShowing)switch(a.keyCode){case 9:$.datepicker._hideDatepicker(),c=!1;break;case 13:var e=$("td."+$.datepicker._dayOverClass+":not(."+$.datepicker._currentClass+")",b.dpDiv);e[0]&&$.datepicker._selectDay(a.target,b.selectedMonth,b.selectedYear,e[0]);var f=$.datepicker._get(b,"onSelect");if(f){var g=$.datepicker._formatDate(b);f.apply(b.input?b.input[0]:null,[g,b])}else $.datepicker._hideDatepicker();return!1;case 27:$.datepicker._hideDatepicker();break;case 33:$.datepicker._adjustDate(a.target,a.ctrlKey?-$.datepicker._get(b,"stepBigMonths"):-$.datepicker._get(b,"stepMonths"),"M");break;case 34:$.datepicker._adjustDate(a.target,a.ctrlKey?+$.datepicker._get(b,"stepBigMonths"):+$.datepicker._get(b,"stepMonths"),"M");break;case 35:(a.ctrlKey||a.metaKey)&&$.datepicker._clearDate(a.target),c=a.ctrlKey||a.metaKey;break;case 36:(a.ctrlKey||a.metaKey)&&$.datepicker._gotoToday(a.target),c=a.ctrlKey||a.metaKey;break;case 37:(a.ctrlKey||a.metaKey)&&$.datepicker._adjustDate(a.target,d?1:-1,"D"),c=a.ctrlKey||a.metaKey,a.originalEvent.altKey&&$.datepicker._adjustDate(a.target,a.ctrlKey?-$.datepicker._get(b,"stepBigMonths"):-$.datepicker._get(b,"stepMonths"),"M");break;case 38:(a.ctrlKey||a.metaKey)&&$.datepicker._adjustDate(a.target,-7,"D"),c=a.ctrlKey||a.metaKey;break;case 39:(a.ctrlKey||a.metaKey)&&$.datepicker._adjustDate(a.target,d?-1:1,"D"),c=a.ctrlKey||a.metaKey,a.originalEvent.altKey&&$.datepicker._adjustDate(a.target,a.ctrlKey?+$.datepicker._get(b,"stepBigMonths"):+$.datepicker._get(b,"stepMonths"),"M");break;case 40:(a.ctrlKey||a.metaKey)&&$.datepicker._adjustDate(a.target,7,"D"),c=a.ctrlKey||a.metaKey;break;default:c=!1}else a.keyCode==36&&a.ctrlKey?$.datepicker._showDatepicker(this):c=!1;c&&(a.preventDefault(),a.stopPropagation())},_doKeyPress:function(a){var b=$.datepicker._getInst(a.target);if($.datepicker._get(b,"constrainInput")){var c=$.datepicker._possibleChars($.datepicker._get(b,"dateFormat")),d=String.fromCharCode(a.charCode==undefined?a.keyCode:a.charCode);return a.ctrlKey||a.metaKey||d<" "||!c||c.indexOf(d)>-1}},_doKeyUp:function(a){var b=$.datepicker._getInst(a.target);if(b.input.val()!=b.lastVal)try{var c=$.datepicker.parseDate($.datepicker._get(b,"dateFormat"),b.input?b.input.val():null,$.datepicker._getFormatConfig(b));c&&($.datepicker._setDateFromField(b),$.datepicker._updateAlternate(b),$.datepicker._updateDatepicker(b))}catch(d){$.datepicker.log(d)}return!0},_showDatepicker:function(a){a=a.target||a,a.nodeName.toLowerCase()!="input"&&(a=$("input",a.parentNode)[0]);if($.datepicker._isDisabledDatepicker(a)||$.datepicker._lastInput==a)return;var b=$.datepicker._getInst(a);$.datepicker._curInst&&$.datepicker._curInst!=b&&($.datepicker._curInst.dpDiv.stop(!0,!0),b&&$.datepicker._datepickerShowing&&$.datepicker._hideDatepicker($.datepicker._curInst.input[0]));var c=$.datepicker._get(b,"beforeShow"),d=c?c.apply(a,[a,b]):{};if(d===!1)return;extendRemove(b.settings,d),b.lastVal=null,$.datepicker._lastInput=a,$.datepicker._setDateFromField(b),$.datepicker._inDialog&&(a.value=""),$.datepicker._pos||($.datepicker._pos=$.datepicker._findPos(a),$.datepicker._pos[1]+=a.offsetHeight);var e=!1;$(a).parents().each(function(){return e|=$(this).css("position")=="fixed",!e}),e&&$.browser.opera&&($.datepicker._pos[0]-=document.documentElement.scrollLeft,$.datepicker._pos[1]-=document.documentElement.scrollTop);var f={left:$.datepicker._pos[0],top:$.datepicker._pos[1]};$.datepicker._pos=null,b.dpDiv.empty(),b.dpDiv.css({position:"absolute",display:"block",top:"-1000px"}),$.datepicker._updateDatepicker(b),f=$.datepicker._checkOffset(b,f,e),b.dpDiv.css({position:$.datepicker._inDialog&&$.blockUI?"static":e?"fixed":"absolute",display:"none",left:f.left+"px",top:f.top+"px"});if(!b.inline){var g=$.datepicker._get(b,"showAnim"),h=$.datepicker._get(b,"duration"),i=function(){var a=b.dpDiv.find("iframe.ui-datepicker-cover");if(!!a.length){var c=$.datepicker._getBorders(b.dpDiv);a.css({left:-c[0],top:-c[1],width:b.dpDiv.outerWidth(),height:b.dpDiv.outerHeight()})}};b.dpDiv.zIndex($(a).zIndex()+1),$.datepicker._datepickerShowing=!0,$.effects&&$.effects[g]?b.dpDiv.show(g,$.datepicker._get(b,"showOptions"),h,i):b.dpDiv[g||"show"](g?h:null,i),(!g||!h)&&i(),b.input.is(":visible")&&!b.input.is(":disabled")&&b.input.focus(),$.datepicker._curInst=b}},_updateDatepicker:function(a){var b=this;b.maxRows=4;var c=$.datepicker._getBorders(a.dpDiv);instActive=a,a.dpDiv.empty().append(this._generateHTML(a)),this._attachHandlers(a);var d=a.dpDiv.find("iframe.ui-datepicker-cover");!d.length||d.css({left:-c[0],top:-c[1],width:a.dpDiv.outerWidth(),height:a.dpDiv.outerHeight()}),a.dpDiv.find("."+this._dayOverClass+" a").mouseover();var e=this._getNumberOfMonths(a),f=e[1],g=17;a.dpDiv.removeClass("ui-datepicker-multi-2 ui-datepicker-multi-3 ui-datepicker-multi-4").width(""),f>1&&a.dpDiv.addClass("ui-datepicker-multi-"+f).css("width",g*f+"em"),a.dpDiv[(e[0]!=1||e[1]!=1?"add":"remove")+"Class"]("ui-datepicker-multi"),a.dpDiv[(this._get(a,"isRTL")?"add":"remove")+"Class"]("ui-datepicker-rtl"),a==$.datepicker._curInst&&$.datepicker._datepickerShowing&&a.input&&a.input.is(":visible")&&!a.input.is(":disabled")&&a.input[0]!=document.activeElement&&a.input.focus();if(a.yearshtml){var h=a.yearshtml;setTimeout(function(){h===a.yearshtml&&a.yearshtml&&a.dpDiv.find("select.ui-datepicker-year:first").replaceWith(a.yearshtml),h=a.yearshtml=null},0)}},_getBorders:function(a){var b=function(a){return{thin:1,medium:2,thick:3}[a]||a};return[parseFloat(b(a.css("border-left-width"))),parseFloat(b(a.css("border-top-width")))]},_checkOffset:function(a,b,c){var d=a.dpDiv.outerWidth(),e=a.dpDiv.outerHeight(),f=a.input?a.input.outerWidth():0,g=a.input?a.input.outerHeight():0,h=document.documentElement.clientWidth+(c?0:$(document).scrollLeft()),i=document.documentElement.clientHeight+(c?0:$(document).scrollTop());return b.left-=this._get(a,"isRTL")?d-f:0,b.left-=c&&b.left==a.input.offset().left?$(document).scrollLeft():0,b.top-=c&&b.top==a.input.offset().top+g?$(document).scrollTop():0,b.left-=Math.min(b.left,b.left+d>h&&h>d?Math.abs(b.left+d-h):0),b.top-=Math.min(b.top,b.top+e>i&&i>e?Math.abs(e+g):0),b},_findPos:function(a){var b=this._getInst(a),c=this._get(b,"isRTL");while(a&&(a.type=="hidden"||a.nodeType!=1||$.expr.filters.hidden(a)))a=a[c?"previousSibling":"nextSibling"];var d=$(a).offset();return[d.left,d.top]},_hideDatepicker:function(a){var b=this._curInst;if(!b||a&&b!=$.data(a,PROP_NAME))return;if(this._datepickerShowing){var c=this._get(b,"showAnim"),d=this._get(b,"duration"),e=function(){$.datepicker._tidyDialog(b)};$.effects&&$.effects[c]?b.dpDiv.hide(c,$.datepicker._get(b,"showOptions"),d,e):b.dpDiv[c=="slideDown"?"slideUp":c=="fadeIn"?"fadeOut":"hide"](c?d:null,e),c||e(),this._datepickerShowing=!1;var f=this._get(b,"onClose");f&&f.apply(b.input?b.input[0]:null,[b.input?b.input.val():"",b]),this._lastInput=null,this._inDialog&&(this._dialogInput.css({position:"absolute",left:"0",top:"-100px"}),$.blockUI&&($.unblockUI(),$("body").append(this.dpDiv))),this._inDialog=!1}},_tidyDialog:function(a){a.dpDiv.removeClass(this._dialogClass).unbind(".ui-datepicker-calendar")},_checkExternalClick:function(a){if(!$.datepicker._curInst)return;var b=$(a.target),c=$.datepicker._getInst(b[0]);(b[0].id!=$.datepicker._mainDivId&&b.parents("#"+$.datepicker._mainDivId).length==0&&!b.hasClass($.datepicker.markerClassName)&&!b.closest("."+$.datepicker._triggerClass).length&&$.datepicker._datepickerShowing&&(!$.datepicker._inDialog||!$.blockUI)||b.hasClass($.datepicker.markerClassName)&&$.datepicker._curInst!=c)&&$.datepicker._hideDatepicker()},_adjustDate:function(a,b,c){var d=$(a),e=this._getInst(d[0]);if(this._isDisabledDatepicker(d[0]))return;this._adjustInstDate(e,b+(c=="M"?this._get(e,"showCurrentAtPos"):0),c),this._updateDatepicker(e)},_gotoToday:function(a){var b=$(a),c=this._getInst(b[0]);if(this._get(c,"gotoCurrent")&&c.currentDay)c.selectedDay=c.currentDay,c.drawMonth=c.selectedMonth=c.currentMonth,c.drawYear=c.selectedYear=c.currentYear;else{var d=new Date;c.selectedDay=d.getDate(),c.drawMonth=c.selectedMonth=d.getMonth(),c.drawYear=c.selectedYear=d.getFullYear()}this._notifyChange(c),this._adjustDate(b)},_selectMonthYear:function(a,b,c){var d=$(a),e=this._getInst(d[0]);e["selected"+(c=="M"?"Month":"Year")]=e["draw"+(c=="M"?"Month":"Year")]=parseInt(b.options[b.selectedIndex].value,10),this._notifyChange(e),this._adjustDate(d)},_selectDay:function(a,b,c,d){var e=$(a);if($(d).hasClass(this._unselectableClass)||this._isDisabledDatepicker(e[0]))return;var f=this._getInst(e[0]);f.selectedDay=f.currentDay=$("a",d).html(),f.selectedMonth=f.currentMonth=b,f.selectedYear=f.currentYear=c,this._selectDate(a,this._formatDate(f,f.currentDay,f.currentMonth,f.currentYear))},_clearDate:function(a){var b=$(a),c=this._getInst(b[0]);this._selectDate(b,"")},_selectDate:function(a,b){var c=$(a),d=this._getInst(c[0]);b=b!=null?b:this._formatDate(d),d.input&&d.input.val(b),this._updateAlternate(d);var e=this._get(d,"onSelect");e?e.apply(d.input?d.input[0]:null,[b,d]):d.input&&d.input.trigger("change"),d.inline?this._updateDatepicker(d):(this._hideDatepicker(),this._lastInput=d.input[0],typeof d.input[0]!="object"&&d.input.focus(),this._lastInput=null)},_updateAlternate:function(a){var b=this._get(a,"altField");if(b){var c=this._get(a,"altFormat")||this._get(a,"dateFormat"),d=this._getDate(a),e=this.formatDate(c,d,this._getFormatConfig(a));$(b).each(function(){$(this).val(e)})}},noWeekends:function(a){var b=a.getDay();return[b>0&&b<6,""]},iso8601Week:function(a){var b=new Date(a.getTime());b.setDate(b.getDate()+4-(b.getDay()||7));var c=b.getTime();return b.setMonth(0),b.setDate(1),Math.floor(Math.round((c-b)/864e5)/7)+1},parseDate:function(a,b,c){if(a==null||b==null)throw"Invalid arguments";b=typeof b=="object"?b.toString():b+"";if(b=="")return null;var d=(c?c.shortYearCutoff:null)||this._defaults.shortYearCutoff;d=typeof d!="string"?d:(new Date).getFullYear()%100+parseInt(d,10);var e=(c?c.dayNamesShort:null)||this._defaults.dayNamesShort,f=(c?c.dayNames:null)||this._defaults.dayNames,g=(c?c.monthNamesShort:null)||this._defaults.monthNamesShort,h=(c?c.monthNames:null)||this._defaults.monthNames,i=-1,j=-1,k=-1,l=-1,m=!1,n=function(b){var c=s+1<a.length&&a.charAt(s+1)==b;return c&&s++,c},o=function(a){var c=n(a),d=a=="@"?14:a=="!"?20:a=="y"&&c?4:a=="o"?3:2,e=new RegExp("^\\d{1,"+d+"}"),f=b.substring(r).match(e);if(!f)throw"Missing number at position "+r;return r+=f[0].length,parseInt(f[0],10)},p=function(a,c,d){var e=$.map(n(a)?d:c,function(a,b){return[[b,a]]}).sort(function(a,b){return-(a[1].length-b[1].length)}),f=-1;$.each(e,function(a,c){var d=c[1];if(b.substr(r,d.length).toLowerCase()==d.toLowerCase())return f=c[0],r+=d.length,!1});if(f!=-1)return f+1;throw"Unknown name at position "+r},q=function(){if(b.charAt(r)!=a.charAt(s))throw"Unexpected literal at position "+r;r++},r=0;for(var s=0;s<a.length;s++)if(m)a.charAt(s)=="'"&&!n("'")?m=!1:q();else switch(a.charAt(s)){case"d":k=o("d");break;case"D":p("D",e,f);break;case"o":l=o("o");break;case"m":j=o("m");break;case"M":j=p("M",g,h);break;case"y":i=o("y");break;case"@":var t=new Date(o("@"));i=t.getFullYear(),j=t.getMonth()+1,k=t.getDate();break;case"!":var t=new Date((o("!")-this._ticksTo1970)/1e4);i=t.getFullYear(),j=t.getMonth()+1,k=t.getDate();break;case"'":n("'")?q():m=!0;break;default:q()}if(r<b.length)throw"Extra/unparsed characters found in date: "+b.substring(r);i==-1?i=(new Date).getFullYear():i<100&&(i+=(new Date).getFullYear()-(new Date).getFullYear()%100+(i<=d?0:-100));if(l>-1){j=1,k=l;do{var u=this._getDaysInMonth(i,j-1);if(k<=u)break;j++,k-=u}while(!0)}var t=this._daylightSavingAdjust(new Date(i,j-1,k));if(t.getFullYear()!=i||t.getMonth()+1!=j||t.getDate()!=k)throw"Invalid date";return t},ATOM:"yy-mm-dd",COOKIE:"D, dd M yy",ISO_8601:"yy-mm-dd",RFC_822:"D, d M y",RFC_850:"DD, dd-M-y",RFC_1036:"D, d M y",RFC_1123:"D, d M yy",RFC_2822:"D, d M yy",RSS:"D, d M y",TICKS:"!",TIMESTAMP:"@",W3C:"yy-mm-dd",_ticksTo1970:(718685+Math.floor(492.5)-Math.floor(19.7)+Math.floor(4.925))*24*60*60*1e7,formatDate:function(a,b,c){if(!b)return"";var d=(c?c.dayNamesShort:null)||this._defaults.dayNamesShort,e=(c?c.dayNames:null)||this._defaults.dayNames,f=(c?c.monthNamesShort:null)||this._defaults.monthNamesShort,g=(c?c.monthNames:null)||this._defaults.monthNames,h=function(b){var c=m+1<a.length&&a.charAt(m+1)==b;return c&&m++,c},i=function(a,b,c){var d=""+b;if(h(a))while(d.length<c)d="0"+d;return d},j=function(a,b,c,d){return h(a)?d[b]:c[b]},k="",l=!1;if(b)for(var m=0;m<a.length;m++)if(l)a.charAt(m)=="'"&&!h("'")?l=!1:k+=a.charAt(m);else switch(a.charAt(m)){case"d":k+=i("d",b.getDate(),2);break;case"D":k+=j("D",b.getDay(),d,e);break;case"o":k+=i("o",Math.round(((new Date(b.getFullYear(),b.getMonth(),b.getDate())).getTime()-(new Date(b.getFullYear(),0,0)).getTime())/864e5),3);break;case"m":k+=i("m",b.getMonth()+1,2);break;case"M":k+=j("M",b.getMonth(),f,g);break;case"y":k+=h("y")?b.getFullYear():(b.getYear()%100<10?"0":"")+b.getYear()%100;break;case"@":k+=b.getTime();break;case"!":k+=b.getTime()*1e4+this._ticksTo1970;break;case"'":h("'")?k+="'":l=!0;break;default:k+=a.charAt(m)}return k},_possibleChars:function(a){var b="",c=!1,d=function(b){var c=e+1<a.length&&a.charAt(e+1)==b;return c&&e++,c};for(var e=0;e<a.length;e++)if(c)a.charAt(e)=="'"&&!d("'")?c=!1:b+=a.charAt(e);else switch(a.charAt(e)){case"d":case"m":case"y":case"@":b+="0123456789";break;case"D":case"M":return null;case"'":d("'")?b+="'":c=!0;break;default:b+=a.charAt(e)}return b},_get:function(a,b){return a.settings[b]!==undefined?a.settings[b]:this._defaults[b]},_setDateFromField:function(a,b){if(a.input.val()==a.lastVal)return;var c=this._get(a,"dateFormat"),d=a.lastVal=a.input?a.input.val():null,e,f;e=f=this._getDefaultDate(a);var g=this._getFormatConfig(a);try{e=this.parseDate(c,d,g)||f}catch(h){this.log(h),d=b?"":d}a.selectedDay=e.getDate(),a.drawMonth=a.selectedMonth=e.getMonth(),a.drawYear=a.selectedYear=e.getFullYear(),a.currentDay=d?e.getDate():0,a.currentMonth=d?e.getMonth():0,a.currentYear=d?e.getFullYear():0,this._adjustInstDate(a)},_getDefaultDate:function(a){return this._restrictMinMax(a,this._determineDate(a,this._get(a,"defaultDate"),new Date))},_determineDate:function(a,b,c){var d=function(a){var b=new Date;return b.setDate(b.getDate()+a),b},e=function(b){try{return $.datepicker.parseDate($.datepicker._get(a,"dateFormat"),b,$.datepicker._getFormatConfig(a))}catch(c){}var d=(b.toLowerCase().match(/^c/)?$.datepicker._getDate(a):null)||new Date,e=d.getFullYear(),f=d.getMonth(),g=d.getDate(),h=/([+-]?[0-9]+)\s*(d|D|w|W|m|M|y|Y)?/g,i=h.exec(b);while(i){switch(i[2]||"d"){case"d":case"D":g+=parseInt(i[1],10);break;case"w":case"W":g+=parseInt(i[1],10)*7;break;case"m":case"M":f+=parseInt(i[1],10),g=Math.min(g,$.datepicker._getDaysInMonth(e,f));break;case"y":case"Y":e+=parseInt(i[1],10),g=Math.min(g,$.datepicker._getDaysInMonth(e,f))}i=h.exec(b)}return new Date(e,f,g)},f=b==null||b===""?c:typeof b=="string"?e(b):typeof b=="number"?isNaN(b)?c:d(b):new Date(b.getTime());return f=f&&f.toString()=="Invalid Date"?c:f,f&&(f.setHours(0),f.setMinutes(0),f.setSeconds(0),f.setMilliseconds(0)),this._daylightSavingAdjust(f)},_daylightSavingAdjust:function(a){return a?(a.setHours(a.getHours()>12?a.getHours()+2:0),a):null},_setDate:function(a,b,c){var d=!b,e=a.selectedMonth,f=a.selectedYear,g=this._restrictMinMax(a,this._determineDate(a,b,new Date));a.selectedDay=a.currentDay=g.getDate(),a.drawMonth=a.selectedMonth=a.currentMonth=g.getMonth(),a.drawYear=a.selectedYear=a.currentYear=g.getFullYear(),(e!=a.selectedMonth||f!=a.selectedYear)&&!c&&this._notifyChange(a),this._adjustInstDate(a),a.input&&a.input.val(d?"":this._formatDate(a))},_getDate:function(a){var b=!a.currentYear||a.input&&a.input.val()==""?null:this._daylightSavingAdjust(new Date(a.currentYear,a.currentMonth,a.currentDay));return b},_attachHandlers:function(a){var b=this._get(a,"stepMonths"),c="#"+a.id.replace(/\\\\/g,"\\");a.dpDiv.find("[data-handler]").map(function(){var a={prev:function(){window["DP_jQuery_"+dpuuid].datepicker._adjustDate(c,-b,"M")},next:function(){window["DP_jQuery_"+dpuuid].datepicker._adjustDate(c,+b,"M")},hide:function(){window["DP_jQuery_"+dpuuid].datepicker._hideDatepicker()},today:function(){window["DP_jQuery_"+dpuuid].datepicker._gotoToday(c)},selectDay:function(){return window["DP_jQuery_"+dpuuid].datepicker._selectDay(c,+this.getAttribute("data-month"),+this.getAttribute("data-year"),this),!1},selectMonth:function(){return window["DP_jQuery_"+dpuuid].datepicker._selectMonthYear(c,this,"M"),!1},selectYear:function(){return window["DP_jQuery_"+dpuuid].datepicker._selectMonthYear(c,this,"Y"),!1}};$(this).bind(this.getAttribute("data-event"),a[this.getAttribute("data-handler")])})},_generateHTML:function(a){var b=new Date;b=this._daylightSavingAdjust(new Date(b.getFullYear(),b.getMonth(),b.getDate()));var c=this._get(a,"isRTL"),d=this._get(a,"showButtonPanel"),e=this._get(a,"hideIfNoPrevNext"),f=this._get(a,"navigationAsDateFormat"),g=this._getNumberOfMonths(a),h=this._get(a,"showCurrentAtPos"),i=this._get(a,"stepMonths"),j=g[0]!=1||g[1]!=1,k=this._daylightSavingAdjust(a.currentDay?new Date(a.currentYear,a.currentMonth,a.currentDay):new Date(9999,9,9)),l=this._getMinMaxDate(a,"min"),m=this._getMinMaxDate(a,"max"),n=a.drawMonth-h,o=a.drawYear;n<0&&(n+=12,o--);if(m){var p=this._daylightSavingAdjust(new Date(m.getFullYear(),m.getMonth()-g[0]*g[1]+1,m.getDate()));p=l&&p<l?l:p;while(this._daylightSavingAdjust(new Date(o,n,1))>p)n--,n<0&&(n=11,o--)}a.drawMonth=n,a.drawYear=o;var q=this._get(a,"prevText");q=f?this.formatDate(q,this._daylightSavingAdjust(new Date(o,n-i,1)),this._getFormatConfig(a)):q;var r=this._canAdjustMonth(a,-1,o,n)?'<a class="ui-datepicker-prev ui-corner-all" data-handler="prev" data-event="click" title="'+q+'"><span class="ui-icon ui-icon-circle-triangle-'+(c?"e":"w")+'">'+q+"</span></a>":e?"":'<a class="ui-datepicker-prev ui-corner-all ui-state-disabled" title="'+q+'"><span class="ui-icon ui-icon-circle-triangle-'+(c?"e":"w")+'">'+q+"</span></a>",s=this._get(a,"nextText");s=f?this.formatDate(s,this._daylightSavingAdjust(new Date(o,n+i,1)),this._getFormatConfig(a)):s;var t=this._canAdjustMonth(a,1,o,n)?'<a class="ui-datepicker-next ui-corner-all" data-handler="next" data-event="click" title="'+s+'"><span class="ui-icon ui-icon-circle-triangle-'+(c?"w":"e")+'">'+s+"</span></a>":e?"":'<a class="ui-datepicker-next ui-corner-all ui-state-disabled" title="'+s+'"><span class="ui-icon ui-icon-circle-triangle-'+(c?"w":"e")+'">'+s+"</span></a>",u=this._get(a,"currentText"),v=this._get(a,"gotoCurrent")&&a.currentDay?k:b;u=f?this.formatDate(u,v,this._getFormatConfig(a)):u;var w=a.inline?"":'<button type="button" class="ui-datepicker-close ui-state-default ui-priority-primary ui-corner-all" data-handler="hide" data-event="click">'+this._get(a,"closeText")+"</button>",x=d?'<div class="ui-datepicker-buttonpane ui-widget-content">'+(c?w:"")+(this._isInRange(a,v)?'<button type="button" class="ui-datepicker-current ui-state-default ui-priority-secondary ui-corner-all" data-handler="today" data-event="click">'+u+"</button>":"")+(c?"":w)+"</div>":"",y=parseInt(this._get(a,"firstDay"),10);y=isNaN(y)?0:y;var z=this._get(a,"showWeek"),A=this._get(a,"dayNames"),B=this._get(a,"dayNamesShort"),C=this._get(a,"dayNamesMin"),D=this._get(a,"monthNames"),E=this._get(a,"monthNamesShort"),F=this._get(a,"beforeShowDay"),G=this._get(a,"showOtherMonths"),H=this._get(a,"selectOtherMonths"),I=this._get(a,"calculateWeek")||this.iso8601Week,J=this._getDefaultDate(a),K="";for(var L=0;L<g[0];L++){var M="";this.maxRows=4;for(var N=0;N<g[1];N++){var O=this._daylightSavingAdjust(new Date(o,n,a.selectedDay)),P=" ui-corner-all",Q="";if(j){Q+='<div class="ui-datepicker-group';if(g[1]>1)switch(N){case 0:Q+=" ui-datepicker-group-first",P=" ui-corner-"+(c?"right":"left");break;case g[1]-1:Q+=" ui-datepicker-group-last",P=" ui-corner-"+(c?"left":"right");break;default:Q+=" ui-datepicker-group-middle",P=""}Q+='">'}Q+='<div class="ui-datepicker-header ui-widget-header ui-helper-clearfix'+P+'">'+(/all|left/.test(P)&&L==0?c?t:r:"")+(/all|right/.test(P)&&L==0?c?r:t:"")+this._generateMonthYearHeader(a,n,o,l,m,L>0||N>0,D,E)+'</div><table class="ui-datepicker-calendar"><thead>'+"<tr>";var R=z?'<th class="ui-datepicker-week-col">'+this._get(a,"weekHeader")+"</th>":"";for(var S=0;S<7;S++){var T=(S+y)%7;R+="<th"+((S+y+6)%7>=5?' class="ui-datepicker-week-end"':"")+">"+'<span title="'+A[T]+'">'+C[T]+"</span></th>"}Q+=R+"</tr></thead><tbody>";var U=this._getDaysInMonth(o,n);o==a.selectedYear&&n==a.selectedMonth&&(a.selectedDay=Math.min(a.selectedDay,U));var V=(this._getFirstDayOfMonth(o,n)-y+7)%7,W=Math.ceil((V+U)/7),X=j?this.maxRows>W?this.maxRows:W:W;this.maxRows=X;var Y=this._daylightSavingAdjust(new Date(o,n,1-V));for(var Z=0;Z<X;Z++){Q+="<tr>";var _=z?'<td class="ui-datepicker-week-col">'+this._get(a,"calculateWeek")(Y)+"</td>":"";for(var S=0;S<7;S++){var ba=F?F.apply(a.input?a.input[0]:null,[Y]):[!0,""],bb=Y.getMonth()!=n,bc=bb&&!H||!ba[0]||l&&Y<l||m&&Y>m;_+='<td class="'+((S+y+6)%7>=5?" ui-datepicker-week-end":"")+(bb?" ui-datepicker-other-month":"")+(Y.getTime()==O.getTime()&&n==a.selectedMonth&&a._keyEvent||J.getTime()==Y.getTime()&&J.getTime()==O.getTime()?" "+this._dayOverClass:"")+(bc?" "+this._unselectableClass+" ui-state-disabled":"")+(bb&&!G?"":" "+ba[1]+(Y.getTime()==k.getTime()?" "+this._currentClass:"")+(Y.getTime()==b.getTime()?" ui-datepicker-today":""))+'"'+((!bb||G)&&ba[2]?' title="'+ba[2]+'"':"")+(bc?"":' data-handler="selectDay" data-event="click" data-month="'+Y.getMonth()+'" data-year="'+Y.getFullYear()+'"')+">"+(bb&&!G?"&#xa0;":bc?'<span class="ui-state-default">'+Y.getDate()+"</span>":'<a class="ui-state-default'+(Y.getTime()==b.getTime()?" ui-state-highlight":"")+(Y.getTime()==k.getTime()?" ui-state-active":"")+(bb?" ui-priority-secondary":"")+'" href="#">'+Y.getDate()+"</a>")+"</td>",Y.setDate(Y.getDate()+1),Y=this._daylightSavingAdjust(Y)}Q+=_+"</tr>"}n++,n>11&&(n=0,o++),Q+="</tbody></table>"+(j?"</div>"+(g[0]>0&&N==g[1]-1?'<div class="ui-datepicker-row-break"></div>':""):""),M+=Q}K+=M}return K+=x+($.browser.msie&&parseInt($.browser.version,10)<7&&!a.inline?'<iframe src="javascript:false;" class="ui-datepicker-cover" frameborder="0"></iframe>':""),a._keyEvent=!1,K},_generateMonthYearHeader:function(a,b,c,d,e,f,g,h){var i=this._get(a,"changeMonth"),j=this._get(a,"changeYear"),k=this._get(a,"showMonthAfterYear"),l='<div class="ui-datepicker-title">',m="";if(f||!i)m+='<span class="ui-datepicker-month">'+g[b]+"</span>";else{var n=d&&d.getFullYear()==c,o=e&&e.getFullYear()==c;m+='<select class="ui-datepicker-month" data-handler="selectMonth" data-event="change">';for(var p=0;p<12;p++)(!n||p>=d.getMonth())&&(!o||p<=e.getMonth())&&(m+='<option value="'+p+'"'+(p==b?' selected="selected"':"")+">"+h[p]+"</option>");m+="</select>"}k||(l+=m+(f||!i||!j?"&#xa0;":""));if(!a.yearshtml){a.yearshtml="";if(f||!j)l+='<span class="ui-datepicker-year">'+c+"</span>";else{var q=this._get(a,"yearRange").split(":"),r=(new Date).getFullYear(),s=function(a){var b=a.match(/c[+-].*/)?c+parseInt(a.substring(1),10):a.match(/[+-].*/)?r+parseInt(a,10):parseInt(a,10);return isNaN(b)?r:b},t=s(q[0]),u=Math.max(t,s(q[1]||""));t=d?Math.max(t,d.getFullYear()):t,u=e?Math.min(u,e.getFullYear()):u,a.yearshtml+='<select class="ui-datepicker-year" data-handler="selectYear" data-event="change">';for(;t<=u;t++)a.yearshtml+='<option value="'+t+'"'+(t==c?' selected="selected"':"")+">"+t+"</option>";a.yearshtml+="</select>",l+=a.yearshtml,a.yearshtml=null}}return l+=this._get(a,"yearSuffix"),k&&(l+=(f||!i||!j?"&#xa0;":"")+m),l+="</div>",l},_adjustInstDate:function(a,b,c){var d=a.drawYear+(c=="Y"?b:0),e=a.drawMonth+(c=="M"?b:0),f=Math.min(a.selectedDay,this._getDaysInMonth(d,e))+(c=="D"?b:0),g=this._restrictMinMax(a,this._daylightSavingAdjust(new Date(d,e,f)));a.selectedDay=g.getDate(),a.drawMonth=a.selectedMonth=g.getMonth(),a.drawYear=a.selectedYear=g.getFullYear(),(c=="M"||c=="Y")&&this._notifyChange(a)},_restrictMinMax:function(a,b){var c=this._getMinMaxDate(a,"min"),d=this._getMinMaxDate(a,"max"),e=c&&b<c?c:b;return e=d&&e>d?d:e,e},_notifyChange:function(a){var b=this._get(a,"onChangeMonthYear");b&&b.apply(a.input?a.input[0]:null,[a.selectedYear,a.selectedMonth+1,a])},_getNumberOfMonths:function(a){var b=this._get(a,"numberOfMonths");return b==null?[1,1]:typeof b=="number"?[1,b]:b},_getMinMaxDate:function(a,b){return this._determineDate(a,this._get(a,b+"Date"),null)},_getDaysInMonth:function(a,b){return 32-this._daylightSavingAdjust(new Date(a,b,32)).getDate()},_getFirstDayOfMonth:function(a,b){return(new Date(a,b,1)).getDay()},_canAdjustMonth:function(a,b,c,d){var e=this._getNumberOfMonths(a),f=this._daylightSavingAdjust(new Date(c,d+(b<0?b:e[0]*e[1]),1));return b<0&&f.setDate(this._getDaysInMonth(f.getFullYear(),f.getMonth())),this._isInRange(a,f)},_isInRange:function(a,b){var c=this._getMinMaxDate(a,"min"),d=this._getMinMaxDate(a,"max");return(!c||b.getTime()>=c.getTime())&&(!d||b.getTime()<=d.getTime())},_getFormatConfig:function(a){var b=this._get(a,"shortYearCutoff");return b=typeof b!="string"?b:(new Date).getFullYear()%100+parseInt(b,10),{shortYearCutoff:b,dayNamesShort:this._get(a,"dayNamesShort"),dayNames:this._get(a,"dayNames"),monthNamesShort:this._get(a,"monthNamesShort"),monthNames:this._get(a,"monthNames")}},_formatDate:function(a,b,c,d){b||(a.currentDay=a.selectedDay,a.currentMonth=a.selectedMonth,a.currentYear=a.selectedYear);var e=b?typeof b=="object"?b:this._daylightSavingAdjust(new Date(d,c,b)):this._daylightSavingAdjust(new Date(a.currentYear,a.currentMonth,a.currentDay));return this.formatDate(this._get(a,"dateFormat"),e,this._getFormatConfig(a))}}),$.fn.datepicker=function(a){if(!this.length)return this;$.datepicker.initialized||($(document).mousedown($.datepicker._checkExternalClick).find("body").append($.datepicker.dpDiv),$.datepicker.initialized=!0);var b=Array.prototype.slice.call(arguments,1);return typeof a!="string"||a!="isDisabled"&&a!="getDate"&&a!="widget"?a=="option"&&arguments.length==2&&typeof arguments[1]=="string"?$.datepicker["_"+a+"Datepicker"].apply($.datepicker,[this[0]].concat(b)):this.each(function(){typeof a=="string"?$.datepicker["_"+a+"Datepicker"].apply($.datepicker,[this].concat(b)):$.datepicker._attachDatepicker(this,a)}):$.datepicker["_"+a+"Datepicker"].apply($.datepicker,[this[0]].concat(b))},$.datepicker=new Datepicker,$.datepicker.initialized=!1,$.datepicker.uuid=(new Date).getTime(),$.datepicker.version="1.8.23",window["DP_jQuery_"+dpuuid]=$})(jQuery);;/*! jQuery UI - v1.8.23 - 2012-08-15
* https://github.com/jquery/jquery-ui
* Includes: jquery.ui.progressbar.js
* Copyright (c) 2012 AUTHORS.txt; Licensed MIT, GPL */
(function(a,b){a.widget("ui.progressbar",{options:{value:0,max:100},min:0,_create:function(){this.element.addClass("ui-progressbar ui-widget ui-widget-content ui-corner-all").attr({role:"progressbar","aria-valuemin":this.min,"aria-valuemax":this.options.max,"aria-valuenow":this._value()}),this.valueDiv=a("<div class='ui-progressbar-value ui-widget-header ui-corner-left'></div>").appendTo(this.element),this.oldValue=this._value(),this._refreshValue()},destroy:function(){this.element.removeClass("ui-progressbar ui-widget ui-widget-content ui-corner-all").removeAttr("role").removeAttr("aria-valuemin").removeAttr("aria-valuemax").removeAttr("aria-valuenow"),this.valueDiv.remove(),a.Widget.prototype.destroy.apply(this,arguments)},value:function(a){return a===b?this._value():(this._setOption("value",a),this)},_setOption:function(b,c){b==="value"&&(this.options.value=c,this._refreshValue(),this._value()===this.options.max&&this._trigger("complete")),a.Widget.prototype._setOption.apply(this,arguments)},_value:function(){var a=this.options.value;return typeof a!="number"&&(a=0),Math.min(this.options.max,Math.max(this.min,a))},_percentage:function(){return 100*this._value()/this.options.max},_refreshValue:function(){var a=this.value(),b=this._percentage();this.oldValue!==a&&(this.oldValue=a,this._trigger("change")),this.valueDiv.toggle(a>this.min).toggleClass("ui-corner-right",a===this.options.max).width(b.toFixed(0)+"%"),this.element.attr("aria-valuenow",a)}}),a.extend(a.ui.progressbar,{version:"1.8.23"})})(jQuery);;/*! jQuery UI - v1.8.23 - 2012-08-15
* https://github.com/jquery/jquery-ui
* Includes: jquery.effects.core.js
* Copyright (c) 2012 AUTHORS.txt; Licensed MIT, GPL */
jQuery.effects||function(a,b){function c(b){var c;return b&&b.constructor==Array&&b.length==3?b:(c=/rgb\(\s*([0-9]{1,3})\s*,\s*([0-9]{1,3})\s*,\s*([0-9]{1,3})\s*\)/.exec(b))?[parseInt(c[1],10),parseInt(c[2],10),parseInt(c[3],10)]:(c=/rgb\(\s*([0-9]+(?:\.[0-9]+)?)\%\s*,\s*([0-9]+(?:\.[0-9]+)?)\%\s*,\s*([0-9]+(?:\.[0-9]+)?)\%\s*\)/.exec(b))?[parseFloat(c[1])*2.55,parseFloat(c[2])*2.55,parseFloat(c[3])*2.55]:(c=/#([a-fA-F0-9]{2})([a-fA-F0-9]{2})([a-fA-F0-9]{2})/.exec(b))?[parseInt(c[1],16),parseInt(c[2],16),parseInt(c[3],16)]:(c=/#([a-fA-F0-9])([a-fA-F0-9])([a-fA-F0-9])/.exec(b))?[parseInt(c[1]+c[1],16),parseInt(c[2]+c[2],16),parseInt(c[3]+c[3],16)]:(c=/rgba\(0, 0, 0, 0\)/.exec(b))?e.transparent:e[a.trim(b).toLowerCase()]}function d(b,d){var e;do{e=(a.curCSS||a.css)(b,d);if(e!=""&&e!="transparent"||a.nodeName(b,"body"))break;d="backgroundColor"}while(b=b.parentNode);return c(e)}function h(){var a=document.defaultView?document.defaultView.getComputedStyle(this,null):this.currentStyle,b={},c,d;if(a&&a.length&&a[0]&&a[a[0]]){var e=a.length;while(e--)c=a[e],typeof a[c]=="string"&&(d=c.replace(/\-(\w)/g,function(a,b){return b.toUpperCase()}),b[d]=a[c])}else for(c in a)typeof a[c]=="string"&&(b[c]=a[c]);return b}function i(b){var c,d;for(c in b)d=b[c],(d==null||a.isFunction(d)||c in g||/scrollbar/.test(c)||!/color/i.test(c)&&isNaN(parseFloat(d)))&&delete b[c];return b}function j(a,b){var c={_:0},d;for(d in b)a[d]!=b[d]&&(c[d]=b[d]);return c}function k(b,c,d,e){typeof b=="object"&&(e=c,d=null,c=b,b=c.effect),a.isFunction(c)&&(e=c,d=null,c={});if(typeof c=="number"||a.fx.speeds[c])e=d,d=c,c={};return a.isFunction(d)&&(e=d,d=null),c=c||{},d=d||c.duration,d=a.fx.off?0:typeof d=="number"?d:d in a.fx.speeds?a.fx.speeds[d]:a.fx.speeds._default,e=e||c.complete,[b,c,d,e]}function l(b){return!b||typeof b=="number"||a.fx.speeds[b]?!0:typeof b=="string"&&!a.effects[b]?!0:!1}a.effects={},a.each(["backgroundColor","borderBottomColor","borderLeftColor","borderRightColor","borderTopColor","borderColor","color","outlineColor"],function(b,e){a.fx.step[e]=function(a){a.colorInit||(a.start=d(a.elem,e),a.end=c(a.end),a.colorInit=!0),a.elem.style[e]="rgb("+Math.max(Math.min(parseInt(a.pos*(a.end[0]-a.start[0])+a.start[0],10),255),0)+","+Math.max(Math.min(parseInt(a.pos*(a.end[1]-a.start[1])+a.start[1],10),255),0)+","+Math.max(Math.min(parseInt(a.pos*(a.end[2]-a.start[2])+a.start[2],10),255),0)+")"}});var e={aqua:[0,255,255],azure:[240,255,255],beige:[245,245,220],black:[0,0,0],blue:[0,0,255],brown:[165,42,42],cyan:[0,255,255],darkblue:[0,0,139],darkcyan:[0,139,139],darkgrey:[169,169,169],darkgreen:[0,100,0],darkkhaki:[189,183,107],darkmagenta:[139,0,139],darkolivegreen:[85,107,47],darkorange:[255,140,0],darkorchid:[153,50,204],darkred:[139,0,0],darksalmon:[233,150,122],darkviolet:[148,0,211],fuchsia:[255,0,255],gold:[255,215,0],green:[0,128,0],indigo:[75,0,130],khaki:[240,230,140],lightblue:[173,216,230],lightcyan:[224,255,255],lightgreen:[144,238,144],lightgrey:[211,211,211],lightpink:[255,182,193],lightyellow:[255,255,224],lime:[0,255,0],magenta:[255,0,255],maroon:[128,0,0],navy:[0,0,128],olive:[128,128,0],orange:[255,165,0],pink:[255,192,203],purple:[128,0,128],violet:[128,0,128],red:[255,0,0],silver:[192,192,192],white:[255,255,255],yellow:[255,255,0],transparent:[255,255,255]},f=["add","remove","toggle"],g={border:1,borderBottom:1,borderColor:1,borderLeft:1,borderRight:1,borderTop:1,borderWidth:1,margin:1,padding:1};a.effects.animateClass=function(b,c,d,e){return a.isFunction(d)&&(e=d,d=null),this.queue(function(){var g=a(this),k=g.attr("style")||" ",l=i(h.call(this)),m,n=g.attr("class")||"";a.each(f,function(a,c){b[c]&&g[c+"Class"](b[c])}),m=i(h.call(this)),g.attr("class",n),g.animate(j(l,m),{queue:!1,duration:c,easing:d,complete:function(){a.each(f,function(a,c){b[c]&&g[c+"Class"](b[c])}),typeof g.attr("style")=="object"?(g.attr("style").cssText="",g.attr("style").cssText=k):g.attr("style",k),e&&e.apply(this,arguments),a.dequeue(this)}})})},a.fn.extend({_addClass:a.fn.addClass,addClass:function(b,c,d,e){return c?a.effects.animateClass.apply(this,[{add:b},c,d,e]):this._addClass(b)},_removeClass:a.fn.removeClass,removeClass:function(b,c,d,e){return c?a.effects.animateClass.apply(this,[{remove:b},c,d,e]):this._removeClass(b)},_toggleClass:a.fn.toggleClass,toggleClass:function(c,d,e,f,g){return typeof d=="boolean"||d===b?e?a.effects.animateClass.apply(this,[d?{add:c}:{remove:c},e,f,g]):this._toggleClass(c,d):a.effects.animateClass.apply(this,[{toggle:c},d,e,f])},switchClass:function(b,c,d,e,f){return a.effects.animateClass.apply(this,[{add:c,remove:b},d,e,f])}}),a.extend(a.effects,{version:"1.8.23",save:function(a,b){for(var c=0;c<b.length;c++)b[c]!==null&&a.data("ec.storage."+b[c],a[0].style[b[c]])},restore:function(a,b){for(var c=0;c<b.length;c++)b[c]!==null&&a.css(b[c],a.data("ec.storage."+b[c]))},setMode:function(a,b){return b=="toggle"&&(b=a.is(":hidden")?"show":"hide"),b},getBaseline:function(a,b){var c,d;switch(a[0]){case"top":c=0;break;case"middle":c=.5;break;case"bottom":c=1;break;default:c=a[0]/b.height}switch(a[1]){case"left":d=0;break;case"center":d=.5;break;case"right":d=1;break;default:d=a[1]/b.width}return{x:d,y:c}},createWrapper:function(b){if(b.parent().is(".ui-effects-wrapper"))return b.parent();var c={width:b.outerWidth(!0),height:b.outerHeight(!0),"float":b.css("float")},d=a("<div></div>").addClass("ui-effects-wrapper").css({fontSize:"100%",background:"transparent",border:"none",margin:0,padding:0}),e=document.activeElement;try{e.id}catch(f){e=document.body}return b.wrap(d),(b[0]===e||a.contains(b[0],e))&&a(e).focus(),d=b.parent(),b.css("position")=="static"?(d.css({position:"relative"}),b.css({position:"relative"})):(a.extend(c,{position:b.css("position"),zIndex:b.css("z-index")}),a.each(["top","left","bottom","right"],function(a,d){c[d]=b.css(d),isNaN(parseInt(c[d],10))&&(c[d]="auto")}),b.css({position:"relative",top:0,left:0,right:"auto",bottom:"auto"})),d.css(c).show()},removeWrapper:function(b){var c,d=document.activeElement;return b.parent().is(".ui-effects-wrapper")?(c=b.parent().replaceWith(b),(b[0]===d||a.contains(b[0],d))&&a(d).focus(),c):b},setTransition:function(b,c,d,e){return e=e||{},a.each(c,function(a,c){var f=b.cssUnit(c);f[0]>0&&(e[c]=f[0]*d+f[1])}),e}}),a.fn.extend({effect:function(b,c,d,e){var f=k.apply(this,arguments),g={options:f[1],duration:f[2],callback:f[3]},h=g.options.mode,i=a.effects[b];return a.fx.off||!i?h?this[h](g.duration,g.callback):this.each(function(){g.callback&&g.callback.call(this)}):i.call(this,g)},_show:a.fn.show,show:function(a){if(l(a))return this._show.apply(this,arguments);var b=k.apply(this,arguments);return b[1].mode="show",this.effect.apply(this,b)},_hide:a.fn.hide,hide:function(a){if(l(a))return this._hide.apply(this,arguments);var b=k.apply(this,arguments);return b[1].mode="hide",this.effect.apply(this,b)},__toggle:a.fn.toggle,toggle:function(b){if(l(b)||typeof b=="boolean"||a.isFunction(b))return this.__toggle.apply(this,arguments);var c=k.apply(this,arguments);return c[1].mode="toggle",this.effect.apply(this,c)},cssUnit:function(b){var c=this.css(b),d=[];return a.each(["em","px","%","pt"],function(a,b){c.indexOf(b)>0&&(d=[parseFloat(c),b])}),d}});var m={};a.each(["Quad","Cubic","Quart","Quint","Expo"],function(a,b){m[b]=function(b){return Math.pow(b,a+2)}}),a.extend(m,{Sine:function(a){return 1-Math.cos(a*Math.PI/2)},Circ:function(a){return 1-Math.sqrt(1-a*a)},Elastic:function(a){return a===0||a===1?a:-Math.pow(2,8*(a-1))*Math.sin(((a-1)*80-7.5)*Math.PI/15)},Back:function(a){return a*a*(3*a-2)},Bounce:function(a){var b,c=4;while(a<((b=Math.pow(2,--c))-1)/11);return 1/Math.pow(4,3-c)-7.5625*Math.pow((b*3-2)/22-a,2)}}),a.each(m,function(b,c){a.easing["easeIn"+b]=c,a.easing["easeOut"+b]=function(a){return 1-c(1-a)},a.easing["easeInOut"+b]=function(a){return a<.5?c(a*2)/2:c(a*-2+2)/-2+1}})}(jQuery);;/*! jQuery UI - v1.8.23 - 2012-08-15
* https://github.com/jquery/jquery-ui
* Includes: jquery.effects.blind.js
* Copyright (c) 2012 AUTHORS.txt; Licensed MIT, GPL */
(function(a,b){a.effects.blind=function(b){return this.queue(function(){var c=a(this),d=["position","top","bottom","left","right"],e=a.effects.setMode(c,b.options.mode||"hide"),f=b.options.direction||"vertical";a.effects.save(c,d),c.show();var g=a.effects.createWrapper(c).css({overflow:"hidden"}),h=f=="vertical"?"height":"width",i=f=="vertical"?g.height():g.width();e=="show"&&g.css(h,0);var j={};j[h]=e=="show"?i:0,g.animate(j,b.duration,b.options.easing,function(){e=="hide"&&c.hide(),a.effects.restore(c,d),a.effects.removeWrapper(c),b.callback&&b.callback.apply(c[0],arguments),c.dequeue()})})}})(jQuery);;/*! jQuery UI - v1.8.23 - 2012-08-15
* https://github.com/jquery/jquery-ui
* Includes: jquery.effects.bounce.js
* Copyright (c) 2012 AUTHORS.txt; Licensed MIT, GPL */
(function(a,b){a.effects.bounce=function(b){return this.queue(function(){var c=a(this),d=["position","top","bottom","left","right"],e=a.effects.setMode(c,b.options.mode||"effect"),f=b.options.direction||"up",g=b.options.distance||20,h=b.options.times||5,i=b.duration||250;/show|hide/.test(e)&&d.push("opacity"),a.effects.save(c,d),c.show(),a.effects.createWrapper(c);var j=f=="up"||f=="down"?"top":"left",k=f=="up"||f=="left"?"pos":"neg",g=b.options.distance||(j=="top"?c.outerHeight(!0)/3:c.outerWidth(!0)/3);e=="show"&&c.css("opacity",0).css(j,k=="pos"?-g:g),e=="hide"&&(g=g/(h*2)),e!="hide"&&h--;if(e=="show"){var l={opacity:1};l[j]=(k=="pos"?"+=":"-=")+g,c.animate(l,i/2,b.options.easing),g=g/2,h--}for(var m=0;m<h;m++){var n={},p={};n[j]=(k=="pos"?"-=":"+=")+g,p[j]=(k=="pos"?"+=":"-=")+g,c.animate(n,i/2,b.options.easing).animate(p,i/2,b.options.easing),g=e=="hide"?g*2:g/2}if(e=="hide"){var l={opacity:0};l[j]=(k=="pos"?"-=":"+=")+g,c.animate(l,i/2,b.options.easing,function(){c.hide(),a.effects.restore(c,d),a.effects.removeWrapper(c),b.callback&&b.callback.apply(this,arguments)})}else{var n={},p={};n[j]=(k=="pos"?"-=":"+=")+g,p[j]=(k=="pos"?"+=":"-=")+g,c.animate(n,i/2,b.options.easing).animate(p,i/2,b.options.easing,function(){a.effects.restore(c,d),a.effects.removeWrapper(c),b.callback&&b.callback.apply(this,arguments)})}c.queue("fx",function(){c.dequeue()}),c.dequeue()})}})(jQuery);;/*! jQuery UI - v1.8.23 - 2012-08-15
* https://github.com/jquery/jquery-ui
* Includes: jquery.effects.clip.js
* Copyright (c) 2012 AUTHORS.txt; Licensed MIT, GPL */
(function(a,b){a.effects.clip=function(b){return this.queue(function(){var c=a(this),d=["position","top","bottom","left","right","height","width"],e=a.effects.setMode(c,b.options.mode||"hide"),f=b.options.direction||"vertical";a.effects.save(c,d),c.show();var g=a.effects.createWrapper(c).css({overflow:"hidden"}),h=c[0].tagName=="IMG"?g:c,i={size:f=="vertical"?"height":"width",position:f=="vertical"?"top":"left"},j=f=="vertical"?h.height():h.width();e=="show"&&(h.css(i.size,0),h.css(i.position,j/2));var k={};k[i.size]=e=="show"?j:0,k[i.position]=e=="show"?0:j/2,h.animate(k,{queue:!1,duration:b.duration,easing:b.options.easing,complete:function(){e=="hide"&&c.hide(),a.effects.restore(c,d),a.effects.removeWrapper(c),b.callback&&b.callback.apply(c[0],arguments),c.dequeue()}})})}})(jQuery);;/*! jQuery UI - v1.8.23 - 2012-08-15
* https://github.com/jquery/jquery-ui
* Includes: jquery.effects.drop.js
* Copyright (c) 2012 AUTHORS.txt; Licensed MIT, GPL */
(function(a,b){a.effects.drop=function(b){return this.queue(function(){var c=a(this),d=["position","top","bottom","left","right","opacity"],e=a.effects.setMode(c,b.options.mode||"hide"),f=b.options.direction||"left";a.effects.save(c,d),c.show(),a.effects.createWrapper(c);var g=f=="up"||f=="down"?"top":"left",h=f=="up"||f=="left"?"pos":"neg",i=b.options.distance||(g=="top"?c.outerHeight(!0)/2:c.outerWidth(!0)/2);e=="show"&&c.css("opacity",0).css(g,h=="pos"?-i:i);var j={opacity:e=="show"?1:0};j[g]=(e=="show"?h=="pos"?"+=":"-=":h=="pos"?"-=":"+=")+i,c.animate(j,{queue:!1,duration:b.duration,easing:b.options.easing,complete:function(){e=="hide"&&c.hide(),a.effects.restore(c,d),a.effects.removeWrapper(c),b.callback&&b.callback.apply(this,arguments),c.dequeue()}})})}})(jQuery);;/*! jQuery UI - v1.8.23 - 2012-08-15
* https://github.com/jquery/jquery-ui
* Includes: jquery.effects.explode.js
* Copyright (c) 2012 AUTHORS.txt; Licensed MIT, GPL */
(function(a,b){a.effects.explode=function(b){return this.queue(function(){var c=b.options.pieces?Math.round(Math.sqrt(b.options.pieces)):3,d=b.options.pieces?Math.round(Math.sqrt(b.options.pieces)):3;b.options.mode=b.options.mode=="toggle"?a(this).is(":visible")?"hide":"show":b.options.mode;var e=a(this).show().css("visibility","hidden"),f=e.offset();f.top-=parseInt(e.css("marginTop"),10)||0,f.left-=parseInt(e.css("marginLeft"),10)||0;var g=e.outerWidth(!0),h=e.outerHeight(!0);for(var i=0;i<c;i++)for(var j=0;j<d;j++)e.clone().appendTo("body").wrap("<div></div>").css({position:"absolute",visibility:"visible",left:-j*(g/d),top:-i*(h/c)}).parent().addClass("ui-effects-explode").css({position:"absolute",overflow:"hidden",width:g/d,height:h/c,left:f.left+j*(g/d)+(b.options.mode=="show"?(j-Math.floor(d/2))*(g/d):0),top:f.top+i*(h/c)+(b.options.mode=="show"?(i-Math.floor(c/2))*(h/c):0),opacity:b.options.mode=="show"?0:1}).animate({left:f.left+j*(g/d)+(b.options.mode=="show"?0:(j-Math.floor(d/2))*(g/d)),top:f.top+i*(h/c)+(b.options.mode=="show"?0:(i-Math.floor(c/2))*(h/c)),opacity:b.options.mode=="show"?1:0},b.duration||500);setTimeout(function(){b.options.mode=="show"?e.css({visibility:"visible"}):e.css({visibility:"visible"}).hide(),b.callback&&b.callback.apply(e[0]),e.dequeue(),a("div.ui-effects-explode").remove()},b.duration||500)})}})(jQuery);;/*! jQuery UI - v1.8.23 - 2012-08-15
* https://github.com/jquery/jquery-ui
* Includes: jquery.effects.fade.js
* Copyright (c) 2012 AUTHORS.txt; Licensed MIT, GPL */
(function(a,b){a.effects.fade=function(b){return this.queue(function(){var c=a(this),d=a.effects.setMode(c,b.options.mode||"hide");c.animate({opacity:d},{queue:!1,duration:b.duration,easing:b.options.easing,complete:function(){b.callback&&b.callback.apply(this,arguments),c.dequeue()}})})}})(jQuery);;/*! jQuery UI - v1.8.23 - 2012-08-15
* https://github.com/jquery/jquery-ui
* Includes: jquery.effects.fold.js
* Copyright (c) 2012 AUTHORS.txt; Licensed MIT, GPL */
(function(a,b){a.effects.fold=function(b){return this.queue(function(){var c=a(this),d=["position","top","bottom","left","right"],e=a.effects.setMode(c,b.options.mode||"hide"),f=b.options.size||15,g=!!b.options.horizFirst,h=b.duration?b.duration/2:a.fx.speeds._default/2;a.effects.save(c,d),c.show();var i=a.effects.createWrapper(c).css({overflow:"hidden"}),j=e=="show"!=g,k=j?["width","height"]:["height","width"],l=j?[i.width(),i.height()]:[i.height(),i.width()],m=/([0-9]+)%/.exec(f);m&&(f=parseInt(m[1],10)/100*l[e=="hide"?0:1]),e=="show"&&i.css(g?{height:0,width:f}:{height:f,width:0});var n={},p={};n[k[0]]=e=="show"?l[0]:f,p[k[1]]=e=="show"?l[1]:0,i.animate(n,h,b.options.easing).animate(p,h,b.options.easing,function(){e=="hide"&&c.hide(),a.effects.restore(c,d),a.effects.removeWrapper(c),b.callback&&b.callback.apply(c[0],arguments),c.dequeue()})})}})(jQuery);;/*! jQuery UI - v1.8.23 - 2012-08-15
* https://github.com/jquery/jquery-ui
* Includes: jquery.effects.highlight.js
* Copyright (c) 2012 AUTHORS.txt; Licensed MIT, GPL */
(function(a,b){a.effects.highlight=function(b){return this.queue(function(){var c=a(this),d=["backgroundImage","backgroundColor","opacity"],e=a.effects.setMode(c,b.options.mode||"show"),f={backgroundColor:c.css("backgroundColor")};e=="hide"&&(f.opacity=0),a.effects.save(c,d),c.show().css({backgroundImage:"none",backgroundColor:b.options.color||"#ffff99"}).animate(f,{queue:!1,duration:b.duration,easing:b.options.easing,complete:function(){e=="hide"&&c.hide(),a.effects.restore(c,d),e=="show"&&!a.support.opacity&&this.style.removeAttribute("filter"),b.callback&&b.callback.apply(this,arguments),c.dequeue()}})})}})(jQuery);;/*! jQuery UI - v1.8.23 - 2012-08-15
* https://github.com/jquery/jquery-ui
* Includes: jquery.effects.pulsate.js
* Copyright (c) 2012 AUTHORS.txt; Licensed MIT, GPL */
(function(a,b){a.effects.pulsate=function(b){return this.queue(function(){var c=a(this),d=a.effects.setMode(c,b.options.mode||"show"),e=(b.options.times||5)*2-1,f=b.duration?b.duration/2:a.fx.speeds._default/2,g=c.is(":visible"),h=0;g||(c.css("opacity",0).show(),h=1),(d=="hide"&&g||d=="show"&&!g)&&e--;for(var i=0;i<e;i++)c.animate({opacity:h},f,b.options.easing),h=(h+1)%2;c.animate({opacity:h},f,b.options.easing,function(){h==0&&c.hide(),b.callback&&b.callback.apply(this,arguments)}),c.queue("fx",function(){c.dequeue()}).dequeue()})}})(jQuery);;/*! jQuery UI - v1.8.23 - 2012-08-15
* https://github.com/jquery/jquery-ui
* Includes: jquery.effects.scale.js
* Copyright (c) 2012 AUTHORS.txt; Licensed MIT, GPL */
(function(a,b){a.effects.puff=function(b){return this.queue(function(){var c=a(this),d=a.effects.setMode(c,b.options.mode||"hide"),e=parseInt(b.options.percent,10)||150,f=e/100,g={height:c.height(),width:c.width()};a.extend(b.options,{fade:!0,mode:d,percent:d=="hide"?e:100,from:d=="hide"?g:{height:g.height*f,width:g.width*f}}),c.effect("scale",b.options,b.duration,b.callback),c.dequeue()})},a.effects.scale=function(b){return this.queue(function(){var c=a(this),d=a.extend(!0,{},b.options),e=a.effects.setMode(c,b.options.mode||"effect"),f=parseInt(b.options.percent,10)||(parseInt(b.options.percent,10)==0?0:e=="hide"?0:100),g=b.options.direction||"both",h=b.options.origin;e!="effect"&&(d.origin=h||["middle","center"],d.restore=!0);var i={height:c.height(),width:c.width()};c.from=b.options.from||(e=="show"?{height:0,width:0}:i);var j={y:g!="horizontal"?f/100:1,x:g!="vertical"?f/100:1};c.to={height:i.height*j.y,width:i.width*j.x},b.options.fade&&(e=="show"&&(c.from.opacity=0,c.to.opacity=1),e=="hide"&&(c.from.opacity=1,c.to.opacity=0)),d.from=c.from,d.to=c.to,d.mode=e,c.effect("size",d,b.duration,b.callback),c.dequeue()})},a.effects.size=function(b){return this.queue(function(){var c=a(this),d=["position","top","bottom","left","right","width","height","overflow","opacity"],e=["position","top","bottom","left","right","overflow","opacity"],f=["width","height","overflow"],g=["fontSize"],h=["borderTopWidth","borderBottomWidth","paddingTop","paddingBottom"],i=["borderLeftWidth","borderRightWidth","paddingLeft","paddingRight"],j=a.effects.setMode(c,b.options.mode||"effect"),k=b.options.restore||!1,l=b.options.scale||"both",m=b.options.origin,n={height:c.height(),width:c.width()};c.from=b.options.from||n,c.to=b.options.to||n;if(m){var p=a.effects.getBaseline(m,n);c.from.top=(n.height-c.from.height)*p.y,c.from.left=(n.width-c.from.width)*p.x,c.to.top=(n.height-c.to.height)*p.y,c.to.left=(n.width-c.to.width)*p.x}var q={from:{y:c.from.height/n.height,x:c.from.width/n.width},to:{y:c.to.height/n.height,x:c.to.width/n.width}};if(l=="box"||l=="both")q.from.y!=q.to.y&&(d=d.concat(h),c.from=a.effects.setTransition(c,h,q.from.y,c.from),c.to=a.effects.setTransition(c,h,q.to.y,c.to)),q.from.x!=q.to.x&&(d=d.concat(i),c.from=a.effects.setTransition(c,i,q.from.x,c.from),c.to=a.effects.setTransition(c,i,q.to.x,c.to));(l=="content"||l=="both")&&q.from.y!=q.to.y&&(d=d.concat(g),c.from=a.effects.setTransition(c,g,q.from.y,c.from),c.to=a.effects.setTransition(c,g,q.to.y,c.to)),a.effects.save(c,k?d:e),c.show(),a.effects.createWrapper(c),c.css("overflow","hidden").css(c.from);if(l=="content"||l=="both")h=h.concat(["marginTop","marginBottom"]).concat(g),i=i.concat(["marginLeft","marginRight"]),f=d.concat(h).concat(i),c.find("*[width]").each(function(){var c=a(this);k&&a.effects.save(c,f);var d={height:c.height(),width:c.width()};c.from={height:d.height*q.from.y,width:d.width*q.from.x},c.to={height:d.height*q.to.y,width:d.width*q.to.x},q.from.y!=q.to.y&&(c.from=a.effects.setTransition(c,h,q.from.y,c.from),c.to=a.effects.setTransition(c,h,q.to.y,c.to)),q.from.x!=q.to.x&&(c.from=a.effects.setTransition(c,i,q.from.x,c.from),c.to=a.effects.setTransition(c,i,q.to.x,c.to)),c.css(c.from),c.animate(c.to,b.duration,b.options.easing,function(){k&&a.effects.restore(c,f)})});c.animate(c.to,{queue:!1,duration:b.duration,easing:b.options.easing,complete:function(){c.to.opacity===0&&c.css("opacity",c.from.opacity),j=="hide"&&c.hide(),a.effects.restore(c,k?d:e),a.effects.removeWrapper(c),b.callback&&b.callback.apply(this,arguments),c.dequeue()}})})}})(jQuery);;/*! jQuery UI - v1.8.23 - 2012-08-15
* https://github.com/jquery/jquery-ui
* Includes: jquery.effects.shake.js
* Copyright (c) 2012 AUTHORS.txt; Licensed MIT, GPL */
(function(a,b){a.effects.shake=function(b){return this.queue(function(){var c=a(this),d=["position","top","bottom","left","right"],e=a.effects.setMode(c,b.options.mode||"effect"),f=b.options.direction||"left",g=b.options.distance||20,h=b.options.times||3,i=b.duration||b.options.duration||140;a.effects.save(c,d),c.show(),a.effects.createWrapper(c);var j=f=="up"||f=="down"?"top":"left",k=f=="up"||f=="left"?"pos":"neg",l={},m={},n={};l[j]=(k=="pos"?"-=":"+=")+g,m[j]=(k=="pos"?"+=":"-=")+g*2,n[j]=(k=="pos"?"-=":"+=")+g*2,c.animate(l,i,b.options.easing);for(var p=1;p<h;p++)c.animate(m,i,b.options.easing).animate(n,i,b.options.easing);c.animate(m,i,b.options.easing).animate(l,i/2,b.options.easing,function(){a.effects.restore(c,d),a.effects.removeWrapper(c),b.callback&&b.callback.apply(this,arguments)}),c.queue("fx",function(){c.dequeue()}),c.dequeue()})}})(jQuery);;/*! jQuery UI - v1.8.23 - 2012-08-15
* https://github.com/jquery/jquery-ui
* Includes: jquery.effects.slide.js
* Copyright (c) 2012 AUTHORS.txt; Licensed MIT, GPL */
(function(a,b){a.effects.slide=function(b){return this.queue(function(){var c=a(this),d=["position","top","bottom","left","right"],e=a.effects.setMode(c,b.options.mode||"show"),f=b.options.direction||"left";a.effects.save(c,d),c.show(),a.effects.createWrapper(c).css({overflow:"hidden"});var g=f=="up"||f=="down"?"top":"left",h=f=="up"||f=="left"?"pos":"neg",i=b.options.distance||(g=="top"?c.outerHeight(!0):c.outerWidth(!0));e=="show"&&c.css(g,h=="pos"?isNaN(i)?"-"+i:-i:i);var j={};j[g]=(e=="show"?h=="pos"?"+=":"-=":h=="pos"?"-=":"+=")+i,c.animate(j,{queue:!1,duration:b.duration,easing:b.options.easing,complete:function(){e=="hide"&&c.hide(),a.effects.restore(c,d),a.effects.removeWrapper(c),b.callback&&b.callback.apply(this,arguments),c.dequeue()}})})}})(jQuery);;/*! jQuery UI - v1.8.23 - 2012-08-15
* https://github.com/jquery/jquery-ui
* Includes: jquery.effects.transfer.js
* Copyright (c) 2012 AUTHORS.txt; Licensed MIT, GPL */
(function(a,b){a.effects.transfer=function(b){return this.queue(function(){var c=a(this),d=a(b.options.to),e=d.offset(),f={top:e.top,left:e.left,height:d.innerHeight(),width:d.innerWidth()},g=c.offset(),h=a('<div class="ui-effects-transfer"></div>').appendTo(document.body).addClass(b.options.className).css({top:g.top,left:g.left,height:c.innerHeight(),width:c.innerWidth(),position:"absolute"}).animate(f,b.duration,b.options.easing,function(){h.remove(),b.callback&&b.callback.apply(c[0],arguments),c.dequeue()})})}})(jQuery);;
define("jquery-ui", function(){});

;(function($){
/**
 * jqGrid Chinese Translation for v3.6
 * waiting 2010.01.18
 * http://waiting.javaeye.com/
 * Dual licensed under the MIT and GPL licenses:
 * http://www.opensource.org/licenses/mit-license.php
 * http://www.gnu.org/licenses/gpl.html
 * 
 * update 2010.05.04
 *		add double u3000 SPACE for search:odata to fix SEARCH box display err when narrow width from only use of eq/ne/cn/in/lt/gt operator under IE6/7
**/
$.jgrid = {
	defaults : {
		recordtext: "{0} - {1}\u3000共 {2} 条",	// 共字前是全角空格
		emptyrecords: "无数据显示",
		loadtext: "读取中...",
		pgtext : " {0} 共 {1} 页"
	},
	search : {
		caption: "搜索...",
		Find: "查找",
		Reset: "重置",
		odata : ['等于\u3000\u3000', '不等\u3000\u3000', '小于\u3000\u3000', '小于等于','大于\u3000\u3000','大于等于', 
			'开始于','不开始于','属于\u3000\u3000','不属于','结束于','不结束于','包含\u3000\u3000','不包含'],
		groupOps: [	{ op: "AND", text: "所有" },	{ op: "OR",  text: "任一" }	],
		matchText: " 匹配",
		rulesText: " 规则"
	},
	edit : {
		addCaption: "添加记录",
		editCaption: "编辑记录",
		bSubmit: "提交",
		bCancel: "取消",
		bClose: "关闭",
		saveData: "数据已改变，是否保存？",
		bYes : "是",
		bNo : "否",
		bExit : "取消",
		msg: {
			required:"此字段必需",
			number:"请输入有效数字",
			minValue:"输值必须大于等于 ",
			maxValue:"输值必须小于等于 ",
			email: "这不是有效的e-mail地址",
			integer: "请输入有效整数",
			date: "请输入有效时间",
			url: "无效网址。前缀必须为 ('http://' 或 'https://')",
			nodefined : " 未定义！",
			novalue : " 需要返回值！",
			customarray : "自定义函数需要返回数组！",
			customfcheck : "Custom function should be present in case of custom checking!"
			
		}
	},
	view : {
		caption: "查看记录",
		bClose: "关闭"
	},
	del : {
		caption: "删除",
		msg: "删除所选记录？",
		bSubmit: "删除",
		bCancel: "取消"
	},
	nav : {
		edittext: "",
		edittitle: "编辑所选记录",
		addtext:"",
		addtitle: "添加新记录",
		deltext: "",
		deltitle: "删除所选记录",
		searchtext: "",
		searchtitle: "查找",
		refreshtext: "",
		refreshtitle: "刷新表格",
		alertcap: "注意",
		alerttext: "请选择记录",
		viewtext: "",
		viewtitle: "查看所选记录"
	},
	col : {
		caption: "选择列",
		bSubmit: "确定",
		bCancel: "取消"
	},
	errors : {
		errcap : "错误",
		nourl : "没有设置url",
		norecords: "没有要处理的记录",
		model : "colNames 和 colModel 长度不等！"
	},
	formatter : {
		integer : {thousandsSeparator: " ", defaultValue: '0'},
		number : {decimalSeparator:".", thousandsSeparator: " ", decimalPlaces: 2, defaultValue: '0.00'},
		currency : {decimalSeparator:".", thousandsSeparator: " ", decimalPlaces: 2, prefix: "", suffix:"", defaultValue: '0.00'},
		date : {
			dayNames:   [
				"Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat",
		         "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
			],
			monthNames: [
				"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec",
				"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"
			],
			AmPm : ["am","pm","AM","PM"],
			S: function (j) {return j < 11 || j > 13 ? ['st', 'nd', 'rd', 'th'][Math.min((j - 1) % 10, 3)] : 'th'},
			srcformat: 'Y-m-d',
			newformat: 'm-d-Y',
			masks : {
				ISO8601Long:"Y-m-d H:i:s",
				ISO8601Short:"Y-m-d",
				ShortDate: "Y/j/n",
				LongDate: "l, F d, Y",
				FullDateTime: "l, F d, Y g:i:s A",
				MonthDay: "F d",
				ShortTime: "g:i A",
				LongTime: "g:i:s A",
				SortableDateTime: "Y-m-d\\TH:i:s",
				UniversalSortableDateTime: "Y-m-d H:i:sO",
				YearMonth: "F, Y"
			},
			reformatAfterEdit : false
		},
		baseLinkUrl: '',
		showAction: '',
		target: '',
		checkbox : {disabled:true},
		idName : 'id'
	}
};
})(jQuery);

define("jqgrid-i18n", function(){});

/* 
* jqGrid  4.2.0 - jQuery Grid 
* Copyright (c) 2008, Tony Tomov, tony@trirand.com 
* Dual licensed under the MIT and GPL licenses 
* http://www.opensource.org/licenses/mit-license.php 
* http://www.gnu.org/licenses/gpl-2.0.html 
* Date:2011-10-11 
* Modules: grid.base.js; jquery.fmatter.js; grid.custom.js; grid.common.js; grid.formedit.js; grid.filter.js; grid.inlinedit.js; grid.celledit.js; jqModal.js; jqDnR.js; grid.subgrid.js; grid.grouping.js; grid.treegrid.js; grid.import.js; JsonXml.js; grid.tbltogrid.js; grid.jqueryui.js; 
*/
/*
 jqGrid  4.2.0  - jQuery Grid
 Copyright (c) 2008, Tony Tomov, tony@trirand.com
 Dual licensed under the MIT and GPL licenses
 http://www.opensource.org/licenses/mit-license.php
 http://www.gnu.org/licenses/gpl-2.0.html
 Date: 2011-10-11
*/
(function(b){b.jgrid=b.jgrid||{};b.extend(b.jgrid,{htmlDecode:function(f){if(f&&(f=="&nbsp;"||f=="&#160;"||f.length==1&&f.charCodeAt(0)==160))return"";return!f?f:String(f).replace(/&gt;/g,">").replace(/&lt;/g,"<").replace(/&quot;/g,'"').replace(/&amp;/g,"&")},htmlEncode:function(f){return!f?f:String(f).replace(/&/g,"&amp;").replace(/\"/g,"&quot;").replace(/</g,"&lt;").replace(/>/g,"&gt;")},format:function(f){var i=b.makeArray(arguments).slice(1);if(f===undefined)f="";return f.replace(/\{(\d+)\}/g,
function(h,c){return i[c]})},getCellIndex:function(f){f=b(f);if(f.is("tr"))return-1;f=(!f.is("td")&&!f.is("th")?f.closest("td,th"):f)[0];if(b.browser.msie)return b.inArray(f,f.parentNode.cells);return f.cellIndex},stripHtml:function(f){f+="";var i=/<("[^"]*"|'[^']*'|[^'">])*>/gi;if(f)return(f=f.replace(i,""))&&f!=="&nbsp;"&&f!=="&#160;"?f.replace(/\"/g,"'"):"";else return f},stripPref:function(f,i){var h=Object.prototype.toString.call(f).slice(8,-1);if(h=="String"||h=="Number"){f=String(f);i=f!=""?
String(i).replace(String(f),""):i}return i},stringToDoc:function(f){var i;if(typeof f!=="string")return f;try{i=(new DOMParser).parseFromString(f,"text/xml")}catch(h){i=new ActiveXObject("Microsoft.XMLDOM");i.async=false;i.loadXML(f)}return i&&i.documentElement&&i.documentElement.tagName!="parsererror"?i:null},parse:function(f){if(f.substr(0,9)=="while(1);")f=f.substr(9);if(f.substr(0,2)=="/*")f=f.substr(2,f.length-4);f||(f="{}");return b.jgrid.useJSON===true&&typeof JSON==="object"&&typeof JSON.parse===
"function"?JSON.parse(f):eval("("+f+")")},parseDate:function(f,i){var h={m:1,d:1,y:1970,h:0,i:0,s:0},c,g,k;c=/[\\\/:_;.,\t\T\s-]/;if(i&&i!==null&&i!==undefined){i=b.trim(i);i=i.split(c);f=f.split(c);var l=b.jgrid.formatter.date.monthNames,a=b.jgrid.formatter.date.AmPm,r=function(x,y){if(x===0){if(y==12)y=0}else if(y!=12)y+=12;return y};c=0;for(g=f.length;c<g;c++){if(f[c]=="M"){k=b.inArray(i[c],l);if(k!==-1&&k<12)i[c]=k+1}if(f[c]=="F"){k=b.inArray(i[c],l);if(k!==-1&&k>11)i[c]=k+1-12}if(f[c]=="a"){k=
b.inArray(i[c],a);if(k!==-1&&k<2&&i[c]==a[k]){i[c]=k;h.h=r(i[c],h.h)}}if(f[c]=="A"){k=b.inArray(i[c],a);if(k!==-1&&k>1&&i[c]==a[k]){i[c]=k-2;h.h=r(i[c],h.h)}}if(i[c]!==undefined)h[f[c].toLowerCase()]=parseInt(i[c],10)}h.m=parseInt(h.m,10)-1;c=h.y;if(c>=70&&c<=99)h.y=1900+h.y;else if(c>=0&&c<=69)h.y=2E3+h.y}return new Date(h.y,h.m,h.d,h.h,h.i,h.s,0)},jqID:function(f){return String(f).replace(/[!"#$%&'()*+,.\/:;<=>?@\[\\\]\^`{|}~]/g,"\\$&")},guid:1,uidPref:"jqg",randId:function(f){return(f?f:b.jgrid.uidPref)+
b.jgrid.guid++},getAccessor:function(f,i){var h,c,g=[],k;if(typeof i==="function")return i(f);h=f[i];if(h===undefined)try{if(typeof i==="string")g=i.split(".");if(k=g.length)for(h=f;h&&k--;){c=g.shift();h=h[c]}}catch(l){}return h},ajaxOptions:{},from:function(f){return new function(i,h){if(typeof i=="string")i=b.data(i);var c=this,g=i,k=true,l=false,a=h,r=/[\$,%]/g,x=null,y=null,H=0,L=false,M="",P=[],U=true;if(typeof i=="object"&&i.push){if(i.length>0)U=typeof i[0]!="object"?false:true}else throw"data provides is not an array";
this._hasData=function(){return g===null?false:g.length===0?false:true};this._getStr=function(o){var n=[];l&&n.push("jQuery.trim(");n.push("String("+o+")");l&&n.push(")");k||n.push(".toLowerCase()");return n.join("")};this._strComp=function(o){return typeof o=="string"?".toString()":""};this._group=function(o,n){return{field:o.toString(),unique:n,items:[]}};this._toStr=function(o){if(l)o=b.trim(o);k||(o=o.toLowerCase());return o=o.toString().replace(/\\/g,"\\\\").replace(/\"/g,'\\"')};this._funcLoop=
function(o){var n=[];b.each(g,function(s,D){n.push(o(D))});return n};this._append=function(o){var n;if(a===null)a="";else a+=M===""?" && ":M;for(n=0;n<H;n++)a+="(";if(L)a+="!";a+="("+o+")";L=false;M="";H=0};this._setCommand=function(o,n){x=o;y=n};this._resetNegate=function(){L=false};this._repeatCommand=function(o,n){if(x===null)return c;if(o!==null&&n!==null)return x(o,n);if(y===null)return x(o);if(!U)return x(o);return x(y,o)};this._equals=function(o,n){return c._compare(o,n,1)===0};this._compare=
function(o,n,s){if(s===undefined)s=1;if(o===undefined)o=null;if(n===undefined)n=null;if(o===null&&n===null)return 0;if(o===null&&n!==null)return 1;if(o!==null&&n===null)return-1;if(!k&&typeof o!=="number"&&typeof n!=="number"){o=String(o).toLowerCase();n=String(n).toLowerCase()}if(o<n)return-s;if(o>n)return s;return 0};this._performSort=function(){if(P.length!==0)g=c._doSort(g,0)};this._doSort=function(o,n){var s=P[n].by,D=P[n].dir,T=P[n].type,J=P[n].datefmt;if(n==P.length-1)return c._getOrder(o,
s,D,T,J);n++;s=c._getGroup(o,s,D,T,J);D=[];for(T=0;T<s.length;T++){J=c._doSort(s[T].items,n);for(var C=0;C<J.length;C++)D.push(J[C])}return D};this._getOrder=function(o,n,s,D,T){var J=[],C=[],ca=s=="a"?1:-1,V,fa;if(D===undefined)D="text";fa=D=="float"||D=="number"||D=="currency"||D=="numeric"?function(R){R=parseFloat(String(R).replace(r,""));return isNaN(R)?0:R}:D=="int"||D=="integer"?function(R){return R?parseFloat(String(R).replace(r,"")):0}:D=="date"||D=="datetime"?function(R){return b.jgrid.parseDate(T,
R).getTime()}:b.isFunction(D)?D:function(R){R||(R="");return b.trim(String(R).toUpperCase())};b.each(o,function(R,$){V=n!==""?b.jgrid.getAccessor($,n):$;if(V===undefined)V="";V=fa(V,$);C.push({vSort:V,index:R})});C.sort(function(R,$){R=R.vSort;$=$.vSort;return c._compare(R,$,ca)});D=0;for(var oa=o.length;D<oa;){s=C[D].index;J.push(o[s]);D++}return J};this._getGroup=function(o,n,s,D,T){var J=[],C=null,ca=null,V;b.each(c._getOrder(o,n,s,D,T),function(fa,oa){V=b.jgrid.getAccessor(oa,n);if(V===undefined)V=
"";if(!c._equals(ca,V)){ca=V;C!==null&&J.push(C);C=c._group(n,V)}C.items.push(oa)});C!==null&&J.push(C);return J};this.ignoreCase=function(){k=false;return c};this.useCase=function(){k=true;return c};this.trim=function(){l=true;return c};this.noTrim=function(){l=false;return c};this.execute=function(){var o=a,n=[];if(o===null)return c;b.each(g,function(){eval(o)&&n.push(this)});g=n;return c};this.data=function(){return g};this.select=function(o){c._performSort();if(!c._hasData())return[];c.execute();
if(b.isFunction(o)){var n=[];b.each(g,function(s,D){n.push(o(D))});return n}return g};this.hasMatch=function(){if(!c._hasData())return false;c.execute();return g.length>0};this.andNot=function(o,n,s){L=!L;return c.and(o,n,s)};this.orNot=function(o,n,s){L=!L;return c.or(o,n,s)};this.not=function(o,n,s){return c.andNot(o,n,s)};this.and=function(o,n,s){M=" && ";if(o===undefined)return c;return c._repeatCommand(o,n,s)};this.or=function(o,n,s){M=" || ";if(o===undefined)return c;return c._repeatCommand(o,
n,s)};this.orBegin=function(){H++;return c};this.orEnd=function(){if(a!==null)a+=")";return c};this.isNot=function(o){L=!L;return c.is(o)};this.is=function(o){c._append("this."+o);c._resetNegate();return c};this._compareValues=function(o,n,s,D,T){var J;J=U?"jQuery.jgrid.getAccessor(this,'"+n+"')":"this";if(s===undefined)s=null;var C=s,ca=T.stype===undefined?"text":T.stype;if(s!==null)switch(ca){case "int":case "integer":C=isNaN(Number(C))||C===""?"0":C;J="parseInt("+J+",10)";C="parseInt("+C+",10)";
break;case "float":case "number":case "numeric":C=String(C).replace(r,"");C=isNaN(Number(C))||C===""?"0":C;J="parseFloat("+J+")";C="parseFloat("+C+")";break;case "date":case "datetime":C=String(b.jgrid.parseDate(T.newfmt||"Y-m-d",C).getTime());J='jQuery.jgrid.parseDate("'+T.srcfmt+'",'+J+").getTime()";break;default:J=c._getStr(J);C=c._getStr('"'+c._toStr(C)+'"')}c._append(J+" "+D+" "+C);c._setCommand(o,n);c._resetNegate();return c};this.equals=function(o,n,s){return c._compareValues(c.equals,o,n,
"==",s)};this.notEquals=function(o,n,s){return c._compareValues(c.equals,o,n,"!==",s)};this.isNull=function(o,n,s){return c._compareValues(c.equals,o,null,"===",s)};this.greater=function(o,n,s){return c._compareValues(c.greater,o,n,">",s)};this.less=function(o,n,s){return c._compareValues(c.less,o,n,"<",s)};this.greaterOrEquals=function(o,n,s){return c._compareValues(c.greaterOrEquals,o,n,">=",s)};this.lessOrEquals=function(o,n,s){return c._compareValues(c.lessOrEquals,o,n,"<=",s)};this.startsWith=
function(o,n){var s=n===undefined||n===null?o:n;s=l?b.trim(s.toString()).length:s.toString().length;if(U)c._append(c._getStr("jQuery.jgrid.getAccessor(this,'"+o+"')")+".substr(0,"+s+") == "+c._getStr('"'+c._toStr(n)+'"'));else{s=l?b.trim(n.toString()).length:n.toString().length;c._append(c._getStr("this")+".substr(0,"+s+") == "+c._getStr('"'+c._toStr(o)+'"'))}c._setCommand(c.startsWith,o);c._resetNegate();return c};this.endsWith=function(o,n){var s=n===undefined||n===null?o:n;s=l?b.trim(s.toString()).length:
s.toString().length;U?c._append(c._getStr("jQuery.jgrid.getAccessor(this,'"+o+"')")+".substr("+c._getStr("jQuery.jgrid.getAccessor(this,'"+o+"')")+".length-"+s+","+s+') == "'+c._toStr(n)+'"'):c._append(c._getStr("this")+".substr("+c._getStr("this")+'.length-"'+c._toStr(o)+'".length,"'+c._toStr(o)+'".length) == "'+c._toStr(o)+'"');c._setCommand(c.endsWith,o);c._resetNegate();return c};this.contains=function(o,n){U?c._append(c._getStr("jQuery.jgrid.getAccessor(this,'"+o+"')")+'.indexOf("'+c._toStr(n)+
'",0) > -1'):c._append(c._getStr("this")+'.indexOf("'+c._toStr(o)+'",0) > -1');c._setCommand(c.contains,o);c._resetNegate();return c};this.groupBy=function(o,n,s,D){if(!c._hasData())return null;return c._getGroup(g,o,n,s,D)};this.orderBy=function(o,n,s,D){n=n===undefined||n===null?"a":b.trim(n.toString().toLowerCase());if(s===null||s===undefined)s="text";if(D===null||D===undefined)D="Y-m-d";if(n=="desc"||n=="descending")n="d";if(n=="asc"||n=="ascending")n="a";P.push({by:o,dir:n,type:s,datefmt:D});
return c};return c}(f,null)},extend:function(f){b.extend(b.fn.jqGrid,f);this.no_legacy_api||b.fn.extend(f)}});b.fn.jqGrid=function(f){if(typeof f=="string"){var i=b.jgrid.getAccessor(b.fn.jqGrid,f);if(!i)throw"jqGrid - No such method: "+f;var h=b.makeArray(arguments).slice(1);return i.apply(this,h)}return this.each(function(){if(!this.grid){var c=b.extend(true,{url:"",height:150,page:1,rowNum:20,rowTotal:null,records:0,pager:"",pgbuttons:true,pginput:true,colModel:[],rowList:[],colNames:[],sortorder:"asc",
sortname:"",datatype:"xml",mtype:"GET",altRows:false,selarrrow:[],savedRow:[],shrinkToFit:true,xmlReader:{},jsonReader:{},subGrid:false,subGridModel:[],reccount:0,lastpage:0,lastsort:0,selrow:null,beforeSelectRow:null,onSelectRow:null,onSortCol:null,ondblClickRow:null,onRightClickRow:null,onPaging:null,onSelectAll:null,loadComplete:null,gridComplete:null,loadError:null,loadBeforeSend:null,afterInsertRow:null,beforeRequest:null,beforeProcessing:null,onHeaderClick:null,viewrecords:false,loadonce:false,
multiselect:false,multikey:false,editurl:null,search:false,caption:"",hidegrid:true,hiddengrid:false,postData:{},userData:{},treeGrid:false,treeGridModel:"nested",treeReader:{},treeANode:-1,ExpandColumn:null,tree_root_level:0,prmNames:{page:"page",rows:"rows",sort:"sidx",order:"sord",search:"_search",nd:"nd",id:"id",oper:"oper",editoper:"edit",addoper:"add",deloper:"del",subgridid:"id",npage:null,totalrows:"totalrows"},forceFit:false,gridstate:"visible",cellEdit:false,cellsubmit:"remote",nv:0,loadui:"enable",
toolbar:[false,""],scroll:false,multiboxonly:false,deselectAfterSort:true,scrollrows:false,autowidth:false,scrollOffset:18,cellLayout:5,subGridWidth:20,multiselectWidth:20,gridview:false,rownumWidth:25,rownumbers:false,pagerpos:"center",recordpos:"right",footerrow:false,userDataOnFooter:false,hoverrows:true,altclass:"ui-priority-secondary",viewsortcols:[false,"vertical",true],resizeclass:"",autoencode:false,remapColumns:[],ajaxGridOptions:{},direction:"ltr",toppager:false,headertitles:false,scrollTimeout:40,
data:[],_index:{},grouping:false,groupingView:{groupField:[],groupOrder:[],groupText:[],groupColumnShow:[],groupSummary:[],showSummaryOnHide:false,sortitems:[],sortnames:[],groupDataSorted:false,summary:[],summaryval:[],plusicon:"ui-icon-circlesmall-plus",minusicon:"ui-icon-circlesmall-minus"},ignoreCase:false,cmTemplate:{},idPrefix:""},b.jgrid.defaults,f||{}),g={headers:[],cols:[],footers:[],dragStart:function(d,e,j){this.resizing={idx:d,startX:e.clientX,sOL:j[0]};this.hDiv.style.cursor="col-resize";
this.curGbox=b("#rs_m"+b.jgrid.jqID(c.id),"#gbox_"+b.jgrid.jqID(c.id));this.curGbox.css({display:"block",left:j[0],top:j[1],height:j[2]});b.isFunction(c.resizeStart)&&c.resizeStart.call(this,e,d);document.onselectstart=function(){return false}},dragMove:function(d){if(this.resizing){var e=d.clientX-this.resizing.startX;d=this.headers[this.resizing.idx];var j=c.direction==="ltr"?d.width+e:d.width-e,m;if(j>33){this.curGbox.css({left:this.resizing.sOL+e});if(c.forceFit===true){m=this.headers[this.resizing.idx+
c.nv];e=c.direction==="ltr"?m.width-e:m.width+e;if(e>33){d.newWidth=j;m.newWidth=e}}else{this.newWidth=c.direction==="ltr"?c.tblwidth+e:c.tblwidth-e;d.newWidth=j}}}},dragEnd:function(){this.hDiv.style.cursor="default";if(this.resizing){var d=this.resizing.idx,e=this.headers[d].newWidth||this.headers[d].width;e=parseInt(e,10);this.resizing=false;b("#rs_m"+b.jgrid.jqID(c.id)).css("display","none");c.colModel[d].width=e;this.headers[d].width=e;this.headers[d].el.style.width=e+"px";this.cols[d].style.width=
e+"px";if(this.footers.length>0)this.footers[d].style.width=e+"px";if(c.forceFit===true){e=this.headers[d+c.nv].newWidth||this.headers[d+c.nv].width;this.headers[d+c.nv].width=e;this.headers[d+c.nv].el.style.width=e+"px";this.cols[d+c.nv].style.width=e+"px";if(this.footers.length>0)this.footers[d+c.nv].style.width=e+"px";c.colModel[d+c.nv].width=e}else{c.tblwidth=this.newWidth||c.tblwidth;b("table:first",this.bDiv).css("width",c.tblwidth+"px");b("table:first",this.hDiv).css("width",c.tblwidth+"px");
this.hDiv.scrollLeft=this.bDiv.scrollLeft;if(c.footerrow){b("table:first",this.sDiv).css("width",c.tblwidth+"px");this.sDiv.scrollLeft=this.bDiv.scrollLeft}}b.isFunction(c.resizeStop)&&c.resizeStop.call(this,e,d)}this.curGbox=null;document.onselectstart=function(){return true}},populateVisible:function(){g.timer&&clearTimeout(g.timer);g.timer=null;var d=b(g.bDiv).height();if(d){var e=b("table:first",g.bDiv),j,m;if(e[0].rows.length)try{m=(j=e[0].rows[1])?b(j).outerHeight()||g.prevRowHeight:g.prevRowHeight}catch(p){m=
g.prevRowHeight}if(m){g.prevRowHeight=m;var B=c.rowNum;j=g.scrollTop=g.bDiv.scrollTop;var t=Math.round(e.position().top)-j,E=t+e.height();m*=B;var v,z,u;if(E<d&&t<=0&&(c.lastpage===undefined||parseInt((E+j+m-1)/m,10)<=c.lastpage)){z=parseInt((d-E+m-1)/m,10);if(E>=0||z<2||c.scroll===true){v=Math.round((E+j)/m)+1;t=-1}else t=1}if(t>0){v=parseInt(j/m,10)+1;z=parseInt((j+d)/m,10)+2-v;u=true}if(z)if(!(c.lastpage&&v>c.lastpage||c.lastpage==1||v===c.page&&v===c.lastpage))if(g.hDiv.loading)g.timer=setTimeout(g.populateVisible,
c.scrollTimeout);else{c.page=v;if(u){g.selectionPreserver(e[0]);g.emptyRows(g.bDiv,false,false)}g.populate(z)}}}},scrollGrid:function(d){if(c.scroll){var e=g.bDiv.scrollTop;if(g.scrollTop===undefined)g.scrollTop=0;if(e!=g.scrollTop){g.scrollTop=e;g.timer&&clearTimeout(g.timer);g.timer=setTimeout(g.populateVisible,c.scrollTimeout)}}g.hDiv.scrollLeft=g.bDiv.scrollLeft;if(c.footerrow)g.sDiv.scrollLeft=g.bDiv.scrollLeft;d&&d.stopPropagation()},selectionPreserver:function(d){var e=d.p,j=e.selrow,m=e.selarrrow?
b.makeArray(e.selarrrow):null,p=d.grid.bDiv.scrollLeft,B=e.gridComplete;e.gridComplete=function(){e.selrow=null;e.selarrrow=[];if(e.multiselect&&m&&m.length>0)for(var t=0;t<m.length;t++)m[t]!=j&&b(d).jqGrid("setSelection",m[t],false);j&&b(d).jqGrid("setSelection",j,false);d.grid.bDiv.scrollLeft=p;e.gridComplete=B;e.gridComplete&&B()}}};if(this.tagName.toUpperCase()!="TABLE")alert("Element is not a table");else{b(this).empty().attr("tabindex","1");this.p=c;this.p.useProp=!!b.fn.prop;var k,l,a;if(this.p.colNames.length===
0)for(k=0;k<this.p.colModel.length;k++)this.p.colNames[k]=this.p.colModel[k].label||this.p.colModel[k].name;if(this.p.colNames.length!==this.p.colModel.length)alert(b.jgrid.errors.model);else{var r=b("<div class='ui-jqgrid-view'></div>"),x,y=b.browser.msie?true:false,H=b.browser.webkit||b.browser.safari?true:false;a=this;a.p.direction=b.trim(a.p.direction.toLowerCase());if(b.inArray(a.p.direction,["ltr","rtl"])==-1)a.p.direction="ltr";l=a.p.direction;b(r).insertBefore(this);b(this).appendTo(r).removeClass("scroll");
var L=b("<div class='ui-jqgrid ui-widget ui-widget-content ui-corner-all'></div>");b(L).insertBefore(r).attr({id:"gbox_"+this.id,dir:l});b(r).appendTo(L).attr("id","gview_"+this.id);x=y&&b.browser.version<=6?'<iframe style="display:block;position:absolute;z-index:-1;filter:Alpha(Opacity=\'0\');" src="javascript:false;"></iframe>':"";b("<div class='ui-widget-overlay jqgrid-overlay' id='lui_"+this.id+"'></div>").append(x).insertBefore(r);b("<div class='loading ui-state-default ui-state-active' id='load_"+
this.id+"'>"+this.p.loadtext+"</div>").insertBefore(r);b(this).attr({cellspacing:"0",cellpadding:"0",border:"0",role:"grid","aria-multiselectable":!!this.p.multiselect,"aria-labelledby":"gbox_"+this.id});var M=function(d,e){d=parseInt(d,10);return isNaN(d)?e?e:0:d},P=function(d,e,j,m,p,B){var t=a.p.colModel[d],E=t.align,v='style="',z=t.classes,u=t.name,q=[];if(E)v+="text-align:"+E+";";if(t.hidden===true)v+="display:none;";if(e===0)v+="width: "+g.headers[d].width+"px;";else if(t.cellattr&&b.isFunction(t.cellattr))if((d=
t.cellattr.call(a,p,j,m,t,B))&&typeof d==="string"){d=d.replace(/style/i,"style").replace(/title/i,"title");if(d.indexOf("title")>-1)t.title=false;if(d.indexOf("class")>-1)z=undefined;q=d.split("style");if(q.length===2){q[1]=b.trim(q[1].replace("=",""));if(q[1].indexOf("'")===0||q[1].indexOf('"')===0)q[1]=q[1].substring(1);v+=q[1].replace(/'/gi,'"')}else v+='"'}if(!q.length){q[0]="";v+='"'}v+=(z!==undefined?' class="'+z+'"':"")+(t.title&&j?' title="'+b.jgrid.stripHtml(j)+'"':"");v+=' aria-describedby="'+
a.p.id+"_"+u+'"';return v+q[0]},U=function(d){return d===undefined||d===null||d===""?"&#160;":a.p.autoencode?b.jgrid.htmlEncode(d):d+""},o=function(d,e,j,m,p){var B=a.p.colModel[j];if(typeof B.formatter!=="undefined"){d={rowId:d,colModel:B,gid:a.p.id,pos:j};e=b.isFunction(B.formatter)?B.formatter.call(a,e,d,m,p):b.fmatter?b.fn.fmatter(B.formatter,e,d,m,p):U(e)}else e=U(e);return e},n=function(d,e,j,m,p){e=o(d,e,j,p,"add");return'<td role="gridcell" '+P(j,m,e,p,d,true)+">"+e+"</td>"},s=function(d,
e,j){var m='<input role="checkbox" type="checkbox" id="jqg_'+a.p.id+"_"+d+'" class="cbox" name="jqg_'+a.p.id+"_"+d+'"/>';return'<td role="gridcell" '+P(e,j,"",null,d,true)+">"+m+"</td>"},D=function(d,e,j,m){j=(parseInt(j,10)-1)*parseInt(m,10)+1+e;return'<td role="gridcell" class="ui-state-default jqgrid-rownum" '+P(d,e,j,null,e,true)+">"+j+"</td>"},T=function(d){var e,j=[],m=0,p;for(p=0;p<a.p.colModel.length;p++){e=a.p.colModel[p];if(e.name!=="cb"&&e.name!=="subgrid"&&e.name!=="rn"){j[m]=d=="local"?
e.name:d=="xml"?e.xmlmap||e.name:e.jsonmap||e.name;m++}}return j},J=function(d){var e=a.p.remapColumns;if(!e||!e.length)e=b.map(a.p.colModel,function(j,m){return m});if(d)e=b.map(e,function(j){return j<d?null:j-d});return e},C=function(d,e,j){if(a.p.deepempty)b("#"+b.jgrid.jqID(a.p.id)+" tbody:first tr:gt(0)").remove();else{var m=b("#"+b.jgrid.jqID(a.p.id)+" tbody:first tr:first")[0];b("#"+b.jgrid.jqID(a.p.id)+" tbody:first").empty().append(m)}if(e&&a.p.scroll){b(">div:first",d).css({height:"auto"}).children("div:first").css({height:0,
display:"none"});d.scrollTop=0}if(j===true)if(a.p.treeGrid===true){a.p.data=[];a.p._index={}}},ca=function(){var d=a.p.data.length,e,j,m;e=a.p.rownumbers===true?1:0;j=a.p.multiselect===true?1:0;m=a.p.subGrid===true?1:0;e=a.p.keyIndex===false||a.p.loadonce===true?a.p.localReader.id:a.p.colModel[a.p.keyIndex+j+m+e].name;for(j=0;j<d;j++){m=b.jgrid.getAccessor(a.p.data[j],e);a.p._index[m]=j}},V=function(d,e,j,m,p){var B=new Date,t=a.p.datatype!="local"&&a.p.loadonce||a.p.datatype=="xmlstring",E=a.p.datatype==
"local"?"local":"xml";if(t){a.p.data=[];a.p._index={};a.p.localReader.id="_id_"}a.p.reccount=0;if(b.isXMLDoc(d)){if(a.p.treeANode===-1&&!a.p.scroll){C(e,false,true);j=1}else j=j>1?j:1;var v,z,u=0,q,F=0,S=0,N=0,K,O=[],Y,I={},w,A,G=[],ia=a.p.altRows===true?" "+a.p.altclass:"";a.p.xmlReader.repeatitems||(O=T(E));K=a.p.keyIndex===false?a.p.xmlReader.id:a.p.keyIndex;if(O.length>0&&!isNaN(K)){if(a.p.remapColumns&&a.p.remapColumns.length)K=b.inArray(K,a.p.remapColumns);K=O[K]}E=(K+"").indexOf("[")===-1?
O.length?function(ga,aa){return b(K,ga).text()||aa}:function(ga,aa){return b(a.p.xmlReader.cell,ga).eq(K).text()||aa}:function(ga,aa){return ga.getAttribute(K.replace(/[\[\]]/g,""))||aa};a.p.userData={};b(a.p.xmlReader.page,d).each(function(){a.p.page=this.textContent||this.text||0});b(a.p.xmlReader.total,d).each(function(){a.p.lastpage=this.textContent||this.text;if(a.p.lastpage===undefined)a.p.lastpage=1});b(a.p.xmlReader.records,d).each(function(){a.p.records=this.textContent||this.text||0});b(a.p.xmlReader.userdata,
d).each(function(){a.p.userData[this.getAttribute("name")]=b(this).text()});(d=b(a.p.xmlReader.root+" "+a.p.xmlReader.row,d))||(d=[]);var ba=d.length,W=0,Z={},ha;if(d&&ba){ha=parseInt(a.p.rowNum,10);var pa=a.p.scroll?b.jgrid.randId():1;if(p)ha*=p+1;p=b.isFunction(a.p.afterInsertRow);var qa="";if(a.p.grouping&&a.p.groupingView.groupCollapse===true)qa=' style="display:none;"';for(;W<ba;){w=d[W];A=E(w,pa+W);A=a.p.idPrefix+A;v=j===0?0:j+1;v=(v+W)%2==1?ia:"";G.push("<tr"+qa+' id="'+A+'" tabindex="-1" role="row" class ="ui-widget-content jqgrow ui-row-'+
a.p.direction+""+v+'">');if(a.p.rownumbers===true){G.push(D(0,W,a.p.page,a.p.rowNum));N=1}if(a.p.multiselect===true){G.push(s(A,N,W));F=1}if(a.p.subGrid===true){G.push(b(a).jqGrid("addSubGridCell",F+N,W+j));S=1}if(a.p.xmlReader.repeatitems){Y||(Y=J(F+S+N));var Ba=b(a.p.xmlReader.cell,w);b.each(Y,function(ga){var aa=Ba[this];if(!aa)return false;q=aa.textContent||aa.text;I[a.p.colModel[ga+F+S+N].name]=q;G.push(n(A,q,ga+F+S+N,W+j,w))})}else for(v=0;v<O.length;v++){q=b(O[v],w).text();I[a.p.colModel[v+
F+S+N].name]=q;G.push(n(A,q,v+F+S+N,W+j,w))}G.push("</tr>");if(a.p.grouping){v=a.p.groupingView.groupField.length;for(var xa=[],ya=0;ya<v;ya++)xa.push(I[a.p.groupingView.groupField[ya]]);Z=b(a).jqGrid("groupingPrepare",G,xa,Z,I);G=[]}if(t||a.p.treeGrid===true){I._id_=A;a.p.data.push(I);a.p._index[A]=a.p.data.length-1}if(a.p.gridview===false){b("tbody:first",e).append(G.join(""));p&&a.p.afterInsertRow.call(a,A,I,w);G=[]}I={};u++;W++;if(u==ha)break}}if(a.p.gridview===true){z=a.p.treeANode>-1?a.p.treeANode:
0;if(a.p.grouping){b(a).jqGrid("groupingRender",Z,a.p.colModel.length);Z=null}else a.p.treeGrid===true&&z>0?b(a.rows[z]).after(G.join("")):b("tbody:first",e).append(G.join(""))}if(a.p.subGrid===true)try{b(a).jqGrid("addSubGrid",F+N)}catch(Ia){}a.p.totaltime=new Date-B;if(u>0)if(a.p.records===0)a.p.records=ba;G=null;if(a.p.treeGrid===true)try{b(a).jqGrid("setTreeNode",z+1,u+z+1)}catch(Ja){}if(!a.p.treeGrid&&!a.p.scroll)a.grid.bDiv.scrollTop=0;a.p.reccount=u;a.p.treeANode=-1;a.p.userDataOnFooter&&b(a).jqGrid("footerData",
"set",a.p.userData,true);if(t){a.p.records=ba;a.p.lastpage=Math.ceil(ba/ha)}m||a.updatepager(false,true);if(t)for(;u<ba;){w=d[u];A=E(w,u);A=a.p.idPrefix+A;if(a.p.xmlReader.repeatitems){Y||(Y=J(F+S+N));var Fa=b(a.p.xmlReader.cell,w);b.each(Y,function(ga){var aa=Fa[this];if(!aa)return false;q=aa.textContent||aa.text;I[a.p.colModel[ga+F+S+N].name]=q})}else for(v=0;v<O.length;v++){q=b(O[v],w).text();I[a.p.colModel[v+F+S+N].name]=q}I._id_=A;a.p.data.push(I);a.p._index[A]=a.p.data.length-1;I={};u++}}},
fa=function(d,e,j,m,p){var B=new Date;if(d){if(a.p.treeANode===-1&&!a.p.scroll){C(e,false,true);j=1}else j=j>1?j:1;var t,E=a.p.datatype!="local"&&a.p.loadonce||a.p.datatype=="jsonstring";if(E){a.p.data=[];a.p._index={};a.p.localReader.id="_id_"}a.p.reccount=0;if(a.p.datatype=="local"){e=a.p.localReader;t="local"}else{e=a.p.jsonReader;t="json"}var v=0,z,u,q=[],F,S=0,N=0,K=0,O,Y,I={},w,A,G=[],ia=a.p.altRows===true?" "+a.p.altclass:"";a.p.page=b.jgrid.getAccessor(d,e.page)||0;O=b.jgrid.getAccessor(d,
e.total);a.p.lastpage=O===undefined?1:O;a.p.records=b.jgrid.getAccessor(d,e.records)||0;a.p.userData=b.jgrid.getAccessor(d,e.userdata)||{};e.repeatitems||(F=q=T(t));t=a.p.keyIndex===false?e.id:a.p.keyIndex;if(q.length>0&&!isNaN(t)){if(a.p.remapColumns&&a.p.remapColumns.length)t=b.inArray(t,a.p.remapColumns);t=q[t]}(Y=b.jgrid.getAccessor(d,e.root))||(Y=[]);O=Y.length;d=0;var ba=parseInt(a.p.rowNum,10),W=a.p.scroll?b.jgrid.randId():1;if(p)ba*=p+1;var Z=b.isFunction(a.p.afterInsertRow),ha={},pa="";if(a.p.grouping&&
a.p.groupingView.groupCollapse===true)pa=' style="display:none;"';for(;d<O;){p=Y[d];A=b.jgrid.getAccessor(p,t);if(A===undefined){A=W+d;if(q.length===0)if(e.cell)A=b.jgrid.getAccessor(p,e.cell)[t]||A}A=a.p.idPrefix+A;z=j===1?0:j;z=(z+d)%2==1?ia:"";G.push("<tr"+pa+' id="'+A+'" tabindex="-1" role="row" class= "ui-widget-content jqgrow ui-row-'+a.p.direction+""+z+'">');if(a.p.rownumbers===true){G.push(D(0,d,a.p.page,a.p.rowNum));K=1}if(a.p.multiselect){G.push(s(A,K,d));S=1}if(a.p.subGrid){G.push(b(a).jqGrid("addSubGridCell",
S+K,d+j));N=1}if(e.repeatitems){if(e.cell)p=b.jgrid.getAccessor(p,e.cell);F||(F=J(S+N+K))}for(u=0;u<F.length;u++){z=b.jgrid.getAccessor(p,F[u]);G.push(n(A,z,u+S+N+K,d+j,p));I[a.p.colModel[u+S+N+K].name]=z}G.push("</tr>");if(a.p.grouping){z=a.p.groupingView.groupField.length;u=[];for(var qa=0;qa<z;qa++)u.push(I[a.p.groupingView.groupField[qa]]);ha=b(a).jqGrid("groupingPrepare",G,u,ha,I);G=[]}if(E||a.p.treeGrid===true){I._id_=A;a.p.data.push(I);a.p._index[A]=a.p.data.length-1}if(a.p.gridview===false){b("#"+
b.jgrid.jqID(a.p.id)+" tbody:first").append(G.join(""));Z&&a.p.afterInsertRow.call(a,A,I,p);G=[]}I={};v++;d++;if(v==ba)break}if(a.p.gridview===true){w=a.p.treeANode>-1?a.p.treeANode:0;if(a.p.grouping)b(a).jqGrid("groupingRender",ha,a.p.colModel.length);else a.p.treeGrid===true&&w>0?b(a.rows[w]).after(G.join("")):b("#"+b.jgrid.jqID(a.p.id)+" tbody:first").append(G.join(""))}if(a.p.subGrid===true)try{b(a).jqGrid("addSubGrid",S+K)}catch(Ba){}a.p.totaltime=new Date-B;if(v>0)if(a.p.records===0)a.p.records=
O;if(a.p.treeGrid===true)try{b(a).jqGrid("setTreeNode",w+1,v+w+1)}catch(xa){}if(!a.p.treeGrid&&!a.p.scroll)a.grid.bDiv.scrollTop=0;a.p.reccount=v;a.p.treeANode=-1;a.p.userDataOnFooter&&b(a).jqGrid("footerData","set",a.p.userData,true);if(E){a.p.records=O;a.p.lastpage=Math.ceil(O/ba)}m||a.updatepager(false,true);if(E)for(;v<O&&Y[v];){p=Y[v];A=b.jgrid.getAccessor(p,t);if(A===undefined){A=W+v;if(q.length===0)if(e.cell)A=b.jgrid.getAccessor(p,e.cell)[t]||A}if(p){A=a.p.idPrefix+A;if(e.repeatitems){if(e.cell)p=
b.jgrid.getAccessor(p,e.cell);F||(F=J(S+N+K))}for(u=0;u<F.length;u++){z=b.jgrid.getAccessor(p,F[u]);I[a.p.colModel[u+S+N+K].name]=z}I._id_=A;a.p.data.push(I);a.p._index[A]=a.p.data.length-1;I={}}v++}}},oa=function(){function d(w){var A=0,G,ia,ba,W,Z;if(w.groups!==undefined){(ia=w.groups.length&&w.groupOp.toString().toUpperCase()==="OR")&&q.orBegin();for(G=0;G<w.groups.length;G++){A>0&&ia&&q.or();try{d(w.groups[G])}catch(ha){alert(ha)}A++}ia&&q.orEnd()}if(w.rules!==undefined){if(A>0){ia=q.select();
q=b.jgrid.from(ia);if(a.p.ignoreCase)q=q.ignoreCase()}try{(ba=w.rules.length&&w.groupOp.toString().toUpperCase()==="OR")&&q.orBegin();for(G=0;G<w.rules.length;G++){Z=w.rules[G];W=w.groupOp.toString().toUpperCase();if(u[Z.op]&&Z.field){if(A>0&&W&&W==="OR")q=q.or();q=u[Z.op](q,W)(Z.field,Z.data,m[Z.field])}A++}ba&&q.orEnd()}catch(pa){alert(pa)}}}var e,j=false,m={},p=[],B=[],t,E,v;if(b.isArray(a.p.data)){var z=a.p.grouping?a.p.groupingView:false;b.each(a.p.colModel,function(){E=this.sorttype||"text";
if(E=="date"||E=="datetime"){if(this.formatter&&typeof this.formatter==="string"&&this.formatter=="date"){t=this.formatoptions&&this.formatoptions.srcformat?this.formatoptions.srcformat:b.jgrid.formatter.date.srcformat;v=this.formatoptions&&this.formatoptions.newformat?this.formatoptions.newformat:b.jgrid.formatter.date.newformat}else t=v=this.datefmt||"Y-m-d";m[this.name]={stype:E,srcfmt:t,newfmt:v}}else m[this.name]={stype:E,srcfmt:"",newfmt:""};if(a.p.grouping&&this.name==z.groupField[0]){var w=
this.name;if(typeof this.index!="undefined")w=this.index;p[0]=m[w];B.push(w)}if(!j&&(this.index==a.p.sortname||this.name==a.p.sortname)){e=this.name;j=true}});if(a.p.treeGrid)b(a).jqGrid("SortTree",e,a.p.sortorder,m[e].stype,m[e].srcfmt);else{var u={eq:function(w){return w.equals},ne:function(w){return w.notEquals},lt:function(w){return w.less},le:function(w){return w.lessOrEquals},gt:function(w){return w.greater},ge:function(w){return w.greaterOrEquals},cn:function(w){return w.contains},nc:function(w,
A){return A==="OR"?w.orNot().contains:w.andNot().contains},bw:function(w){return w.startsWith},bn:function(w,A){return A==="OR"?w.orNot().startsWith:w.andNot().startsWith},en:function(w,A){return A==="OR"?w.orNot().endsWith:w.andNot().endsWith},ew:function(w){return w.endsWith},ni:function(w,A){return A==="OR"?w.orNot().equals:w.andNot().equals},"in":function(w){return w.equals},nu:function(w){return w.isNull},nn:function(w,A){return A==="OR"?w.orNot().isNull:w.andNot().isNull}},q=b.jgrid.from(a.p.data);
if(a.p.ignoreCase)q=q.ignoreCase();if(a.p.search===true){var F=a.p.postData.filters;if(F){if(typeof F=="string")F=b.jgrid.parse(F);d(F)}else try{q=u[a.p.postData.searchOper](q)(a.p.postData.searchField,a.p.postData.searchString,m[a.p.postData.searchField])}catch(S){}}if(a.p.grouping){q.orderBy(B,z.groupOrder[0],p[0].stype,p[0].srcfmt);z.groupDataSorted=true}if(e&&a.p.sortorder&&j)a.p.sortorder.toUpperCase()=="DESC"?q.orderBy(a.p.sortname,"d",m[e].stype,m[e].srcfmt):q.orderBy(a.p.sortname,"a",m[e].stype,
m[e].srcfmt);F=q.select();var N=parseInt(a.p.rowNum,10),K=F.length,O=parseInt(a.p.page,10),Y=Math.ceil(K/N),I={};F=F.slice((O-1)*N,O*N);m=q=null;I[a.p.localReader.total]=Y;I[a.p.localReader.page]=O;I[a.p.localReader.records]=K;I[a.p.localReader.root]=F;I[a.p.localReader.userdata]=a.p.userData;F=null;return I}}},R=function(){a.grid.hDiv.loading=true;if(!a.p.hiddengrid)switch(a.p.loadui){case "enable":b("#load_"+b.jgrid.jqID(a.p.id)).show();break;case "block":b("#lui_"+b.jgrid.jqID(a.p.id)).show();
b("#load_"+b.jgrid.jqID(a.p.id)).show()}},$=function(){a.grid.hDiv.loading=false;switch(a.p.loadui){case "enable":b("#load_"+b.jgrid.jqID(a.p.id)).hide();break;case "block":b("#lui_"+b.jgrid.jqID(a.p.id)).hide();b("#load_"+b.jgrid.jqID(a.p.id)).hide()}},ja=function(d){if(!a.grid.hDiv.loading){var e=a.p.scroll&&d===false,j={},m,p=a.p.prmNames;if(a.p.page<=0)a.p.page=1;if(p.search!==null)j[p.search]=a.p.search;if(p.nd!==null)j[p.nd]=(new Date).getTime();if(p.rows!==null)j[p.rows]=a.p.rowNum;if(p.page!==
null)j[p.page]=a.p.page;if(p.sort!==null)j[p.sort]=a.p.sortname;if(p.order!==null)j[p.order]=a.p.sortorder;if(a.p.rowTotal!==null&&p.totalrows!==null)j[p.totalrows]=a.p.rowTotal;var B=a.p.loadComplete,t=b.isFunction(B);t||(B=null);var E=0;d=d||1;if(d>1)if(p.npage!==null){j[p.npage]=d;E=d-1;d=1}else B=function(z){a.p.page++;a.grid.hDiv.loading=false;t&&a.p.loadComplete.call(a,z);ja(d-1)};else p.npage!==null&&delete a.p.postData[p.npage];if(a.p.grouping){b(a).jqGrid("groupingSetup");if(a.p.groupingView.groupDataSorted===
true)j[p.sort]=a.p.groupingView.groupField[0]+" "+a.p.groupingView.groupOrder[0]+", "+j[p.sort]}b.extend(a.p.postData,j);var v=!a.p.scroll?1:a.rows.length-1;if(b.isFunction(a.p.datatype))a.p.datatype.call(a,a.p.postData,"load_"+a.p.id);else{if(b.isFunction(a.p.beforeRequest)){j=a.p.beforeRequest.call(a);if(j===undefined)j=true;if(j===false)return}m=a.p.datatype.toLowerCase();switch(m){case "json":case "jsonp":case "xml":case "script":b.ajax(b.extend({url:a.p.url,type:a.p.mtype,dataType:m,data:b.isFunction(a.p.serializeGridData)?
a.p.serializeGridData.call(a,a.p.postData):a.p.postData,success:function(z,u,q){b.isFunction(a.p.beforeProcessing)&&a.p.beforeProcessing.call(a,z,u,q);m==="xml"?V(z,a.grid.bDiv,v,d>1,E):fa(z,a.grid.bDiv,v,d>1,E);B&&B.call(a,z);e&&a.grid.populateVisible();if(a.p.loadonce||a.p.treeGrid)a.p.datatype="local";d===1&&$()},error:function(z,u,q){b.isFunction(a.p.loadError)&&a.p.loadError.call(a,z,u,q);d===1&&$()},beforeSend:function(z,u){var q=true;if(b.isFunction(a.p.loadBeforeSend))q=a.p.loadBeforeSend.call(a,
z,u);if(q===undefined)q=true;if(q===false)return false;else R()}},b.jgrid.ajaxOptions,a.p.ajaxGridOptions));break;case "xmlstring":R();j=b.jgrid.stringToDoc(a.p.datastr);V(j,a.grid.bDiv);t&&a.p.loadComplete.call(a,j);a.p.datatype="local";a.p.datastr=null;$();break;case "jsonstring":R();j=typeof a.p.datastr=="string"?b.jgrid.parse(a.p.datastr):a.p.datastr;fa(j,a.grid.bDiv);t&&a.p.loadComplete.call(a,j);a.p.datatype="local";a.p.datastr=null;$();break;case "local":case "clientside":R();a.p.datatype=
"local";j=oa();fa(j,a.grid.bDiv,v,d>1,E);B&&B.call(a,j);e&&a.grid.populateVisible();$()}}}};x=function(d,e){var j="",m="<table cellspacing='0' cellpadding='0' border='0' style='table-layout:auto;' class='ui-pg-table'><tbody><tr>",p="",B,t,E,v,z=function(u){var q;if(b.isFunction(a.p.onPaging))q=a.p.onPaging.call(a,u);a.p.selrow=null;if(a.p.multiselect){a.p.selarrrow=[];b("#cb_"+b.jgrid.jqID(a.p.id),a.grid.hDiv)[a.p.useProp?"prop":"attr"]("checked",false)}a.p.savedRow=[];if(q=="stop")return false;return true};
d=d.substr(1);e+="_"+d;B="pg_"+d;t=d+"_left";E=d+"_center";v=d+"_right";b("#"+b.jgrid.jqID(d)).append("<div id='"+B+"' class='ui-pager-control' role='group'><table cellspacing='0' cellpadding='0' border='0' class='ui-pg-table' style='width:100%;table-layout:fixed;height:100%;' role='row'><tbody><tr><td id='"+t+"' align='left'></td><td id='"+E+"' align='center' style='white-space:pre;'></td><td id='"+v+"' align='right'></td></tr></tbody></table></div>").attr("dir","ltr");if(a.p.rowList.length>0){p=
"<td dir='"+l+"'>";p+="<select class='ui-pg-selbox' role='listbox'>";for(t=0;t<a.p.rowList.length;t++)p+='<option role="option" value="'+a.p.rowList[t]+'"'+(a.p.rowNum==a.p.rowList[t]?' selected="selected"':"")+">"+a.p.rowList[t]+"</option>";p+="</select></td>"}if(l=="rtl")m+=p;if(a.p.pginput===true)j="<td dir='"+l+"'>"+b.jgrid.format(a.p.pgtext||"","<input class='ui-pg-input' type='text' size='2' maxlength='7' value='0' role='textbox'/>","<span id='sp_1_"+b.jgrid.jqID(d)+"'></span>")+"</td>";if(a.p.pgbuttons===
true){t=["first"+e,"prev"+e,"next"+e,"last"+e];l=="rtl"&&t.reverse();m+="<td id='"+t[0]+"' class='ui-pg-button ui-corner-all'><span class='ui-icon ui-icon-seek-first'></span></td>";m+="<td id='"+t[1]+"' class='ui-pg-button ui-corner-all'><span class='ui-icon ui-icon-seek-prev'></span></td>";m+=j!==""?"<td class='ui-pg-button ui-state-disabled' style='width:4px;'><span class='ui-separator'></span></td>"+j+"<td class='ui-pg-button ui-state-disabled' style='width:4px;'><span class='ui-separator'></span></td>":
"";m+="<td id='"+t[2]+"' class='ui-pg-button ui-corner-all'><span class='ui-icon ui-icon-seek-next'></span></td>";m+="<td id='"+t[3]+"' class='ui-pg-button ui-corner-all'><span class='ui-icon ui-icon-seek-end'></span></td>"}else if(j!=="")m+=j;if(l=="ltr")m+=p;m+="</tr></tbody></table>";a.p.viewrecords===true&&b("td#"+d+"_"+a.p.recordpos,"#"+B).append("<div dir='"+l+"' style='text-align:"+a.p.recordpos+"' class='ui-paging-info'></div>");b("td#"+d+"_"+a.p.pagerpos,"#"+B).append(m);p=b(".ui-jqgrid").css("font-size")||
"11px";b(document.body).append("<div id='testpg' class='ui-jqgrid ui-widget ui-widget-content' style='font-size:"+p+";visibility:hidden;' ></div>");m=b(m).clone().appendTo("#testpg").width();b("#testpg").remove();if(m>0){if(j!=="")m+=50;b("td#"+d+"_"+a.p.pagerpos,"#"+B).width(m)}a.p._nvtd=[];a.p._nvtd[0]=m?Math.floor((a.p.width-m)/2):Math.floor(a.p.width/3);a.p._nvtd[1]=0;m=null;b(".ui-pg-selbox","#"+B).bind("change",function(){a.p.page=Math.round(a.p.rowNum*(a.p.page-1)/this.value-0.5)+1;a.p.rowNum=
this.value;if(e)b(".ui-pg-selbox",a.p.pager).val(this.value);else a.p.toppager&&b(".ui-pg-selbox",a.p.toppager).val(this.value);if(!z("records"))return false;ja();return false});if(a.p.pgbuttons===true){b(".ui-pg-button","#"+B).hover(function(){if(b(this).hasClass("ui-state-disabled"))this.style.cursor="default";else{b(this).addClass("ui-state-hover");this.style.cursor="pointer"}},function(){if(!b(this).hasClass("ui-state-disabled")){b(this).removeClass("ui-state-hover");this.style.cursor="default"}});
b("#first"+b.jgrid.jqID(e)+", #prev"+b.jgrid.jqID(e)+", #next"+b.jgrid.jqID(e)+", #last"+b.jgrid.jqID(e)).click(function(){var u=M(a.p.page,1),q=M(a.p.lastpage,1),F=false,S=true,N=true,K=true,O=true;if(q===0||q===1)O=K=N=S=false;else if(q>1&&u>=1)if(u===1)N=S=false;else{if(!(u>1&&u<q))if(u===q)O=K=false}else if(q>1&&u===0){O=K=false;u=q-1}if(this.id==="first"+e&&S){a.p.page=1;F=true}if(this.id==="prev"+e&&N){a.p.page=u-1;F=true}if(this.id==="next"+e&&K){a.p.page=u+1;F=true}if(this.id==="last"+e&&
O){a.p.page=q;F=true}if(F){if(!z(this.id))return false;ja()}return false})}a.p.pginput===true&&b("input.ui-pg-input","#"+B).keypress(function(u){if((u.charCode?u.charCode:u.keyCode?u.keyCode:0)==13){a.p.page=b(this).val()>0?b(this).val():a.p.page;if(!z("user"))return false;ja();return false}return this})};var Ca=function(d,e,j,m){if(a.p.colModel[e].sortable)if(!(a.p.savedRow.length>0)){if(!j){if(a.p.lastsort==e)if(a.p.sortorder=="asc")a.p.sortorder="desc";else{if(a.p.sortorder=="desc")a.p.sortorder=
"asc"}else a.p.sortorder=a.p.colModel[e].firstsortorder||"asc";a.p.page=1}if(m)if(a.p.lastsort==e&&a.p.sortorder==m&&!j)return;else a.p.sortorder=m;j=a.grid.headers[a.p.lastsort].el;m=a.grid.headers[e].el;b("span.ui-grid-ico-sort",j).addClass("ui-state-disabled");b(j).attr("aria-selected","false");b("span.ui-icon-"+a.p.sortorder,m).removeClass("ui-state-disabled");b(m).attr("aria-selected","true");if(!a.p.viewsortcols[0])if(a.p.lastsort!=e){b("span.s-ico",j).hide();b("span.s-ico",m).show()}d=d.substring(5+
a.p.id.length+1);a.p.sortname=a.p.colModel[e].index||d;j=a.p.sortorder;if(b.isFunction(a.p.onSortCol))if(a.p.onSortCol.call(a,d,e,j)=="stop"){a.p.lastsort=e;return}if(a.p.datatype=="local")a.p.deselectAfterSort&&b(a).jqGrid("resetSelection");else{a.p.selrow=null;if(a.p.multiselect)b("#cb_"+b.jgrid.jqID(a.p.id),a.grid.hDiv)[a.p.useProp?"prop":"attr"]("checked",false);a.p.selarrrow=[];a.p.savedRow=[]}if(a.p.scroll){j=a.grid.bDiv.scrollLeft;C(a.grid.bDiv,true,false);a.grid.hDiv.scrollLeft=j}a.p.subGrid&&
a.p.datatype=="local"&&b("td.sgexpanded","#"+b.jgrid.jqID(a.p.id)).each(function(){b(this).trigger("click")});ja();a.p.lastsort=e;if(a.p.sortname!=d&&e)a.p.lastsort=e}},Ga=function(d){var e,j={},m=H?0:a.p.cellLayout;for(e=j[0]=j[1]=j[2]=0;e<=d;e++)if(a.p.colModel[e].hidden===false)j[0]+=a.p.colModel[e].width+m;if(a.p.direction=="rtl")j[0]=a.p.width-j[0];j[0]-=a.grid.bDiv.scrollLeft;if(b(a.grid.cDiv).is(":visible"))j[1]+=b(a.grid.cDiv).height()+parseInt(b(a.grid.cDiv).css("padding-top"),10)+parseInt(b(a.grid.cDiv).css("padding-bottom"),
10);if(a.p.toolbar[0]===true&&(a.p.toolbar[1]=="top"||a.p.toolbar[1]=="both"))j[1]+=b(a.grid.uDiv).height()+parseInt(b(a.grid.uDiv).css("border-top-width"),10)+parseInt(b(a.grid.uDiv).css("border-bottom-width"),10);if(a.p.toppager)j[1]+=b(a.grid.topDiv).height()+parseInt(b(a.grid.topDiv).css("border-bottom-width"),10);j[2]+=b(a.grid.bDiv).height()+b(a.grid.hDiv).height();return j},Da=function(d){var e,j=a.grid.headers,m=b.jgrid.getCellIndex(d);for(e=0;e<j.length;e++)if(d===j[e].el){m=e;break}return m};
this.p.id=this.id;if(b.inArray(a.p.multikey,["shiftKey","altKey","ctrlKey"])==-1)a.p.multikey=false;a.p.keyIndex=false;for(k=0;k<a.p.colModel.length;k++){a.p.colModel[k]=b.extend(true,{},a.p.cmTemplate,a.p.colModel[k].template||{},a.p.colModel[k]);if(a.p.keyIndex===false&&a.p.colModel[k].key===true)a.p.keyIndex=k}a.p.sortorder=a.p.sortorder.toLowerCase();if(a.p.grouping===true){a.p.scroll=false;a.p.rownumbers=false;a.p.subGrid=false;a.p.treeGrid=false;a.p.gridview=true}if(this.p.treeGrid===true){try{b(this).jqGrid("setTreeGrid")}catch(Ka){}if(a.p.datatype!=
"local")a.p.localReader={id:"_id_"}}if(this.p.subGrid)try{b(a).jqGrid("setSubGrid")}catch(La){}if(this.p.multiselect){this.p.colNames.unshift("<input role='checkbox' id='cb_"+this.p.id+"' class='cbox' type='checkbox'/>");this.p.colModel.unshift({name:"cb",width:H?a.p.multiselectWidth+a.p.cellLayout:a.p.multiselectWidth,sortable:false,resizable:false,hidedlg:true,search:false,align:"center",fixed:true})}if(this.p.rownumbers){this.p.colNames.unshift("");this.p.colModel.unshift({name:"rn",width:a.p.rownumWidth,
sortable:false,resizable:false,hidedlg:true,search:false,align:"center",fixed:true})}a.p.xmlReader=b.extend(true,{root:"rows",row:"row",page:"rows>page",total:"rows>total",records:"rows>records",repeatitems:true,cell:"cell",id:"[id]",userdata:"userdata",subgrid:{root:"rows",row:"row",repeatitems:true,cell:"cell"}},a.p.xmlReader);a.p.jsonReader=b.extend(true,{root:"rows",page:"page",total:"total",records:"records",repeatitems:true,cell:"cell",id:"id",userdata:"userdata",subgrid:{root:"rows",repeatitems:true,
cell:"cell"}},a.p.jsonReader);a.p.localReader=b.extend(true,{root:"rows",page:"page",total:"total",records:"records",repeatitems:false,cell:"cell",id:"id",userdata:"userdata",subgrid:{root:"rows",repeatitems:true,cell:"cell"}},a.p.localReader);if(a.p.scroll){a.p.pgbuttons=false;a.p.pginput=false;a.p.rowList=[]}a.p.data.length&&ca();var da="<thead><tr class='ui-jqgrid-labels' role='rowheader'>",Ea,ma,sa,ra,ta,X,Q,na;ma=na="";if(a.p.shrinkToFit===true&&a.p.forceFit===true)for(k=a.p.colModel.length-
1;k>=0;k--)if(!a.p.colModel[k].hidden){a.p.colModel[k].resizable=false;break}if(a.p.viewsortcols[1]=="horizontal"){na=" ui-i-asc";ma=" ui-i-desc"}Ea=y?"class='ui-th-div-ie'":"";na="<span class='s-ico' style='display:none'><span sort='asc' class='ui-grid-ico-sort ui-icon-asc"+na+" ui-state-disabled ui-icon ui-icon-triangle-1-n ui-sort-"+l+"'></span>";na+="<span sort='desc' class='ui-grid-ico-sort ui-icon-desc"+ma+" ui-state-disabled ui-icon ui-icon-triangle-1-s ui-sort-"+l+"'></span></span>";for(k=
0;k<this.p.colNames.length;k++){ma=a.p.headertitles?' title="'+b.jgrid.stripHtml(a.p.colNames[k])+'"':"";da+="<th id='"+a.p.id+"_"+a.p.colModel[k].name+"' role='columnheader' class='ui-state-default ui-th-column ui-th-"+l+"'"+ma+">";ma=a.p.colModel[k].index||a.p.colModel[k].name;da+="<div id='jqgh_"+a.p.id+"_"+a.p.colModel[k].name+"' "+Ea+">"+a.p.colNames[k];a.p.colModel[k].width=a.p.colModel[k].width?parseInt(a.p.colModel[k].width,10):150;if(typeof a.p.colModel[k].title!=="boolean")a.p.colModel[k].title=
true;if(ma==a.p.sortname)a.p.lastsort=k;da+=na+"</div></th>"}da+="</tr></thead>";na=null;b(this).append(da);b("thead tr:first th",this).hover(function(){b(this).addClass("ui-state-hover")},function(){b(this).removeClass("ui-state-hover")});if(this.p.multiselect){var za=[],ua;b("#cb_"+b.jgrid.jqID(a.p.id),this).bind("click",function(){a.p.selarrrow=[];if(this.checked){b(a.rows).each(function(d){if(d>0)if(!b(this).hasClass("ui-subgrid")&&!b(this).hasClass("jqgroup")&&!b(this).hasClass("ui-state-disabled")){b("#jqg_"+
b.jgrid.jqID(a.p.id)+"_"+b.jgrid.jqID(this.id))[a.p.useProp?"prop":"attr"]("checked",true);b(this).addClass("ui-state-highlight").attr("aria-selected","true");a.p.selarrrow.push(this.id);a.p.selrow=this.id}});ua=true;za=[]}else{b(a.rows).each(function(d){if(d>0)if(!b(this).hasClass("ui-subgrid")&&!b(this).hasClass("ui-state-disabled")){b("#jqg_"+b.jgrid.jqID(a.p.id)+"_"+b.jgrid.jqID(this.id))[a.p.useProp?"prop":"attr"]("checked",false);b(this).removeClass("ui-state-highlight").attr("aria-selected",
"false");za.push(this.id)}});a.p.selrow=null;ua=false}if(b.isFunction(a.p.onSelectAll))a.p.onSelectAll.call(a,ua?a.p.selarrrow:za,ua)})}if(a.p.autowidth===true){da=b(L).innerWidth();a.p.width=da>0?da:"nw"}(function(){var d=0,e=H?0:a.p.cellLayout,j=0,m,p=a.p.scrollOffset,B,t=false,E,v=0,z=0,u;b.each(a.p.colModel,function(){if(typeof this.hidden==="undefined")this.hidden=false;this.widthOrg=B=M(this.width,0);if(this.hidden===false){d+=B+e;if(this.fixed)v+=B+e;else j++;z++}});if(isNaN(a.p.width))a.p.width=
g.width=d;else g.width=a.p.width;a.p.tblwidth=d;if(a.p.shrinkToFit===false&&a.p.forceFit===true)a.p.forceFit=false;if(a.p.shrinkToFit===true&&j>0){E=g.width-e*j-v;if(!isNaN(a.p.height)){E-=p;t=true}d=0;b.each(a.p.colModel,function(q){if(this.hidden===false&&!this.fixed){this.width=B=Math.round(E*this.width/(a.p.tblwidth-e*j-v));d+=B;m=q}});u=0;if(t){if(g.width-v-(d+e*j)!==p)u=g.width-v-(d+e*j)-p}else if(!t&&Math.abs(g.width-v-(d+e*j))!==1)u=g.width-v-(d+e*j);a.p.colModel[m].width+=u;a.p.tblwidth=
d+u+e*j+v;if(a.p.tblwidth>a.p.width){a.p.colModel[m].width-=a.p.tblwidth-parseInt(a.p.width,10);a.p.tblwidth=a.p.width}}})();b(L).css("width",g.width+"px").append("<div class='ui-jqgrid-resize-mark' id='rs_m"+a.p.id+"'>&#160;</div>");b(r).css("width",g.width+"px");da=b("thead:first",a).get(0);var va="";if(a.p.footerrow)va+="<table role='grid' style='width:"+a.p.tblwidth+"px' class='ui-jqgrid-ftable' cellspacing='0' cellpadding='0' border='0'><tbody><tr role='row' class='ui-widget-content footrow footrow-"+
l+"'>";r=b("tr:first",da);var wa="<tr class='jqgfirstrow' role='row' style='height:auto'>";a.p.disableClick=false;b("th",r).each(function(d){sa=a.p.colModel[d].width;if(typeof a.p.colModel[d].resizable==="undefined")a.p.colModel[d].resizable=true;if(a.p.colModel[d].resizable){ra=document.createElement("span");b(ra).html("&#160;").addClass("ui-jqgrid-resize ui-jqgrid-resize-"+l);b.browser.opera||b(ra).css("cursor","col-resize");b(this).addClass(a.p.resizeclass)}else ra="";b(this).css("width",sa+"px").prepend(ra);
var e="";if(a.p.colModel[d].hidden){b(this).css("display","none");e="display:none;"}wa+="<td role='gridcell' style='height:0px;width:"+sa+"px;"+e+"'></td>";g.headers[d]={width:sa,el:this};ta=a.p.colModel[d].sortable;if(typeof ta!=="boolean")ta=a.p.colModel[d].sortable=true;e=a.p.colModel[d].name;e=="cb"||e=="subgrid"||e=="rn"||a.p.viewsortcols[2]&&b("div",this).addClass("ui-jqgrid-sortable");if(ta)if(a.p.viewsortcols[0]){b("div span.s-ico",this).show();d==a.p.lastsort&&b("div span.ui-icon-"+a.p.sortorder,
this).removeClass("ui-state-disabled")}else if(d==a.p.lastsort){b("div span.s-ico",this).show();b("div span.ui-icon-"+a.p.sortorder,this).removeClass("ui-state-disabled")}if(a.p.footerrow)va+="<td role='gridcell' "+P(d,0,"",null,"",false)+">&#160;</td>"}).mousedown(function(d){if(b(d.target).closest("th>span.ui-jqgrid-resize").length==1){var e=Da(this);if(a.p.forceFit===true){var j=a.p,m=e,p;for(p=e+1;p<a.p.colModel.length;p++)if(a.p.colModel[p].hidden!==true){m=p;break}j.nv=m-e}g.dragStart(e,d,Ga(e));
return false}}).click(function(d){if(a.p.disableClick)return a.p.disableClick=false;var e="th>div.ui-jqgrid-sortable",j,m;a.p.viewsortcols[2]||(e="th>div>span>span.ui-grid-ico-sort");d=b(d.target).closest(e);if(d.length==1){e=Da(this);if(!a.p.viewsortcols[2]){j=true;m=d.attr("sort")}Ca(b("div",this)[0].id,e,j,m);return false}});if(a.p.sortable&&b.fn.sortable)try{b(a).jqGrid("sortableColumns",r)}catch(Ma){}if(a.p.footerrow)va+="</tr></tbody></table>";wa+="</tr>";this.appendChild(document.createElement("tbody"));
b(this).addClass("ui-jqgrid-btable").append(wa);wa=null;r=b("<table class='ui-jqgrid-htable' style='width:"+a.p.tblwidth+"px' role='grid' aria-labelledby='gbox_"+this.id+"' cellspacing='0' cellpadding='0' border='0'></table>").append(da);var ea=a.p.caption&&a.p.hiddengrid===true?true:false;k=b("<div class='ui-jqgrid-hbox"+(l=="rtl"?"-rtl":"")+"'></div>");da=null;g.hDiv=document.createElement("div");b(g.hDiv).css({width:g.width+"px"}).addClass("ui-state-default ui-jqgrid-hdiv").append(k);b(k).append(r);
r=null;ea&&b(g.hDiv).hide();if(a.p.pager){if(typeof a.p.pager=="string"){if(a.p.pager.substr(0,1)!="#")a.p.pager="#"+a.p.pager}else a.p.pager="#"+b(a.p.pager).attr("id");b(a.p.pager).css({width:g.width+"px"}).appendTo(L).addClass("ui-state-default ui-jqgrid-pager ui-corner-bottom");ea&&b(a.p.pager).hide();x(a.p.pager,"")}a.p.cellEdit===false&&a.p.hoverrows===true&&b(a).bind("mouseover",function(d){Q=b(d.target).closest("tr.jqgrow");b(Q).attr("class")!=="ui-subgrid"&&b(Q).addClass("ui-state-hover")}).bind("mouseout",
function(d){Q=b(d.target).closest("tr.jqgrow");b(Q).removeClass("ui-state-hover")});var ka,la;b(a).before(g.hDiv).click(function(d){X=d.target;Q=b(X,a.rows).closest("tr.jqgrow");if(b(Q).length===0||Q[0].className.indexOf("ui-state-disabled")>-1)return this;var e=b(X).hasClass("cbox"),j=true;if(b.isFunction(a.p.beforeSelectRow))j=a.p.beforeSelectRow.call(a,Q[0].id,d);if(X.tagName=="A"||(X.tagName=="INPUT"||X.tagName=="TEXTAREA"||X.tagName=="OPTION"||X.tagName=="SELECT")&&!e)return this;if(j===true){if(a.p.cellEdit===
true)if(a.p.multiselect&&e)b(a).jqGrid("setSelection",Q[0].id,true);else{ka=Q[0].rowIndex;la=b.jgrid.getCellIndex(X);try{b(a).jqGrid("editCell",ka,la,true)}catch(m){}}else if(a.p.multikey)if(d[a.p.multikey])b(a).jqGrid("setSelection",Q[0].id,true);else{if(a.p.multiselect&&e){e=b("#jqg_"+b.jgrid.jqID(a.p.id)+"_"+Q[0].id).is(":checked");b("#jqg_"+b.jgrid.jqID(a.p.id)+"_"+Q[0].id)[a.p.useProp?"prop":"attr"]("checked",e)}}else{if(a.p.multiselect&&a.p.multiboxonly)if(!e){b(a.p.selarrrow).each(function(p,
B){var t=a.rows.namedItem(B);b(t).removeClass("ui-state-highlight");b("#jqg_"+b.jgrid.jqID(a.p.id)+"_"+b.jgrid.jqID(B))[a.p.useProp?"prop":"attr"]("checked",false)});a.p.selarrrow=[];b("#cb_"+b.jgrid.jqID(a.p.id),a.grid.hDiv)[a.p.useProp?"prop":"attr"]("checked",false)}b(a).jqGrid("setSelection",Q[0].id,true)}if(b.isFunction(a.p.onCellSelect)){ka=Q[0].id;la=b.jgrid.getCellIndex(X);a.p.onCellSelect.call(a,ka,la,b(X).html(),d)}}return this}).bind("reloadGrid",function(d,e){if(a.p.treeGrid===true)a.p.datatype=
a.p.treedatatype;e&&e.current&&a.grid.selectionPreserver(a);if(a.p.datatype=="local"){b(a).jqGrid("resetSelection");a.p.data.length&&ca()}else if(!a.p.treeGrid){a.p.selrow=null;if(a.p.multiselect){a.p.selarrrow=[];b("#cb_"+b.jgrid.jqID(a.p.id),a.grid.hDiv)[a.p.useProp?"prop":"attr"]("checked",false)}a.p.savedRow=[]}a.p.scroll&&C(a.grid.bDiv,true,false);if(e&&e.page){var j=e.page;if(j>a.p.lastpage)j=a.p.lastpage;if(j<1)j=1;a.p.page=j;a.grid.bDiv.scrollTop=a.grid.prevRowHeight?(j-1)*a.grid.prevRowHeight*
a.p.rowNum:0}if(a.grid.prevRowHeight&&a.p.scroll){delete a.p.lastpage;a.grid.populateVisible()}else a.grid.populate();return false});b.isFunction(this.p.ondblClickRow)&&b(this).dblclick(function(d){X=d.target;Q=b(X,a.rows).closest("tr.jqgrow");if(b(Q).length===0)return false;ka=Q[0].rowIndex;la=b.jgrid.getCellIndex(X);a.p.ondblClickRow.call(a,b(Q).attr("id"),ka,la,d);return false});b.isFunction(this.p.onRightClickRow)&&b(this).bind("contextmenu",function(d){X=d.target;Q=b(X,a.rows).closest("tr.jqgrow");
if(b(Q).length===0)return false;a.p.multiselect||b(a).jqGrid("setSelection",Q[0].id,true);ka=Q[0].rowIndex;la=b.jgrid.getCellIndex(X);a.p.onRightClickRow.call(a,b(Q).attr("id"),ka,la,d);return false});g.bDiv=document.createElement("div");if(y)if(String(a.p.height).toLowerCase()==="auto")a.p.height="100%";b(g.bDiv).append(b('<div style="position:relative;'+(y&&b.browser.version<8?"height:0.01%;":"")+'"></div>').append("<div></div>").append(this)).addClass("ui-jqgrid-bdiv").css({height:a.p.height+(isNaN(a.p.height)?
"":"px"),width:g.width+"px"}).scroll(g.scrollGrid);b("table:first",g.bDiv).css({width:a.p.tblwidth+"px"});if(y){b("tbody",this).size()==2&&b("tbody:gt(0)",this).remove();a.p.multikey&&b(g.bDiv).bind("selectstart",function(){return false})}else a.p.multikey&&b(g.bDiv).bind("mousedown",function(){return false});ea&&b(g.bDiv).hide();g.cDiv=document.createElement("div");var Aa=a.p.hidegrid===true?b("<a role='link' href='javascript:void(0)'/>").addClass("ui-jqgrid-titlebar-close HeaderButton").hover(function(){Aa.addClass("ui-state-hover")},
function(){Aa.removeClass("ui-state-hover")}).append("<span class='ui-icon ui-icon-circle-triangle-n'></span>").css(l=="rtl"?"left":"right","0px"):"";b(g.cDiv).append(Aa).append("<span class='ui-jqgrid-title"+(l=="rtl"?"-rtl":"")+"'>"+a.p.caption+"</span>").addClass("ui-jqgrid-titlebar ui-widget-header ui-corner-top ui-helper-clearfix");b(g.cDiv).insertBefore(g.hDiv);if(a.p.toolbar[0]){g.uDiv=document.createElement("div");if(a.p.toolbar[1]=="top")b(g.uDiv).insertBefore(g.hDiv);else a.p.toolbar[1]==
"bottom"&&b(g.uDiv).insertAfter(g.hDiv);if(a.p.toolbar[1]=="both"){g.ubDiv=document.createElement("div");b(g.uDiv).insertBefore(g.hDiv).addClass("ui-userdata ui-state-default").attr("id","t_"+this.id);b(g.ubDiv).insertAfter(g.hDiv).addClass("ui-userdata ui-state-default").attr("id","tb_"+this.id);ea&&b(g.ubDiv).hide()}else b(g.uDiv).width(g.width).addClass("ui-userdata ui-state-default").attr("id","t_"+this.id);ea&&b(g.uDiv).hide()}if(a.p.toppager){a.p.toppager=b.jgrid.jqID(a.p.id)+"_toppager";g.topDiv=
b("<div id='"+a.p.toppager+"'></div>")[0];a.p.toppager="#"+a.p.toppager;b(g.topDiv).insertBefore(g.hDiv).addClass("ui-state-default ui-jqgrid-toppager").width(g.width);x(a.p.toppager,"_t")}if(a.p.footerrow){g.sDiv=b("<div class='ui-jqgrid-sdiv'></div>")[0];k=b("<div class='ui-jqgrid-hbox"+(l=="rtl"?"-rtl":"")+"'></div>");b(g.sDiv).append(k).insertAfter(g.hDiv).width(g.width);b(k).append(va);g.footers=b(".ui-jqgrid-ftable",g.sDiv)[0].rows[0].cells;if(a.p.rownumbers)g.footers[0].className="ui-state-default jqgrid-rownum";
ea&&b(g.sDiv).hide()}k=null;if(a.p.caption){var Ha=a.p.datatype;if(a.p.hidegrid===true){b(".ui-jqgrid-titlebar-close",g.cDiv).click(function(d){var e=b.isFunction(a.p.onHeaderClick),j=".ui-jqgrid-bdiv, .ui-jqgrid-hdiv, .ui-jqgrid-pager, .ui-jqgrid-sdiv",m,p=this;if(a.p.toolbar[0]===true){if(a.p.toolbar[1]=="both")j+=", #"+b(g.ubDiv).attr("id");j+=", #"+b(g.uDiv).attr("id")}m=b(j,"#gview_"+b.jgrid.jqID(a.p.id)).length;if(a.p.gridstate=="visible")b(j,"#gbox_"+b.jgrid.jqID(a.p.id)).slideUp("fast",function(){m--;
if(m===0){b("span",p).removeClass("ui-icon-circle-triangle-n").addClass("ui-icon-circle-triangle-s");a.p.gridstate="hidden";b("#gbox_"+b.jgrid.jqID(a.p.id)).hasClass("ui-resizable")&&b(".ui-resizable-handle","#gbox_"+b.jgrid.jqID(a.p.id)).hide();if(e)ea||a.p.onHeaderClick.call(a,a.p.gridstate,d)}});else a.p.gridstate=="hidden"&&b(j,"#gbox_"+b.jgrid.jqID(a.p.id)).slideDown("fast",function(){m--;if(m===0){b("span",p).removeClass("ui-icon-circle-triangle-s").addClass("ui-icon-circle-triangle-n");if(ea){a.p.datatype=
Ha;ja();ea=false}a.p.gridstate="visible";b("#gbox_"+b.jgrid.jqID(a.p.id)).hasClass("ui-resizable")&&b(".ui-resizable-handle","#gbox_"+b.jgrid.jqID(a.p.id)).show();if(e)ea||a.p.onHeaderClick.call(a,a.p.gridstate,d)}});return false});if(ea){a.p.datatype="local";b(".ui-jqgrid-titlebar-close",g.cDiv).trigger("click")}}}else b(g.cDiv).hide();b(g.hDiv).after(g.bDiv).mousemove(function(d){if(g.resizing){g.dragMove(d);return false}});b(".ui-jqgrid-labels",g.hDiv).bind("selectstart",function(){return false});
b(document).mouseup(function(){if(g.resizing){g.dragEnd();return false}return true});a.formatCol=P;a.sortData=Ca;a.updatepager=function(d,e){var j,m,p,B,t,E,v,z="",u=a.p.pager?"_"+b.jgrid.jqID(a.p.pager.substr(1)):"",q=a.p.toppager?"_"+a.p.toppager.substr(1):"";p=parseInt(a.p.page,10)-1;if(p<0)p=0;p*=parseInt(a.p.rowNum,10);t=p+a.p.reccount;if(a.p.scroll){j=b("tbody:first > tr:gt(0)",a.grid.bDiv);p=t-j.length;a.p.reccount=j.length;if(m=j.outerHeight()||a.grid.prevRowHeight){j=p*m;m*=parseInt(a.p.records,
10);b(">div:first",a.grid.bDiv).css({height:m}).children("div:first").css({height:j,display:j?"":"none"})}a.grid.bDiv.scrollLeft=a.grid.hDiv.scrollLeft}z=a.p.pager?a.p.pager:"";z+=a.p.toppager?z?","+a.p.toppager:a.p.toppager:"";if(z){v=b.jgrid.formatter.integer||{};j=M(a.p.page);m=M(a.p.lastpage);b(".selbox",z)[this.p.useProp?"prop":"attr"]("disabled",false);if(a.p.pginput===true){b(".ui-pg-input",z).val(a.p.page);B=a.p.toppager?"#sp_1"+u+",#sp_1"+q:"#sp_1"+u;b(B).html(b.fmatter?b.fmatter.util.NumberFormat(a.p.lastpage,
v):a.p.lastpage)}if(a.p.viewrecords)if(a.p.reccount===0)b(".ui-paging-info",z).html(a.p.emptyrecords);else{B=p+1;E=a.p.records;if(b.fmatter){B=b.fmatter.util.NumberFormat(B,v);t=b.fmatter.util.NumberFormat(t,v);E=b.fmatter.util.NumberFormat(E,v)}b(".ui-paging-info",z).html(b.jgrid.format(a.p.recordtext,B,t,E))}if(a.p.pgbuttons===true){if(j<=0)j=m=0;if(j==1||j===0){b("#first"+u+", #prev"+u).addClass("ui-state-disabled").removeClass("ui-state-hover");a.p.toppager&&b("#first_t"+q+", #prev_t"+q).addClass("ui-state-disabled").removeClass("ui-state-hover")}else{b("#first"+
u+", #prev"+u).removeClass("ui-state-disabled");a.p.toppager&&b("#first_t"+q+", #prev_t"+q).removeClass("ui-state-disabled")}if(j==m||j===0){b("#next"+u+", #last"+u).addClass("ui-state-disabled").removeClass("ui-state-hover");a.p.toppager&&b("#next_t"+q+", #last_t"+q).addClass("ui-state-disabled").removeClass("ui-state-hover")}else{b("#next"+u+", #last"+u).removeClass("ui-state-disabled");a.p.toppager&&b("#next_t"+q+", #last_t"+q).removeClass("ui-state-disabled")}}}d===true&&a.p.rownumbers===true&&
b("td.jqgrid-rownum",a.rows).each(function(F){b(this).html(p+1+F)});e&&a.p.jqgdnd&&b(a).jqGrid("gridDnD","updateDnD");b.isFunction(a.p.gridComplete)&&a.p.gridComplete.call(a)};a.refreshIndex=ca;a.formatter=function(d,e,j,m,p){return o(d,e,j,m,p)};b.extend(g,{populate:ja,emptyRows:C});this.grid=g;a.addXmlData=function(d){V(d,a.grid.bDiv)};a.addJSONData=function(d){fa(d,a.grid.bDiv)};this.grid.cols=this.rows[0].cells;ja();a.p.hiddengrid=false;b(window).unload(function(){a=null})}}}})};b.jgrid.extend({getGridParam:function(f){var i=
this[0];if(i&&i.grid)return f?typeof i.p[f]!="undefined"?i.p[f]:null:i.p},setGridParam:function(f){return this.each(function(){this.grid&&typeof f==="object"&&b.extend(true,this.p,f)})},getDataIDs:function(){var f=[],i=0,h,c=0;this.each(function(){if((h=this.rows.length)&&h>0)for(;i<h;){if(b(this.rows[i]).hasClass("jqgrow")){f[c]=this.rows[i].id;c++}i++}});return f},setSelection:function(f,i){return this.each(function(){function h(a){var r=b(c.grid.bDiv)[0].clientHeight,x=b(c.grid.bDiv)[0].scrollTop,
y=c.rows[a].offsetTop;a=c.rows[a].clientHeight;if(y+a>=r+x)b(c.grid.bDiv)[0].scrollTop=y-(r+x)+a+x;else if(y<r+x)if(y<x)b(c.grid.bDiv)[0].scrollTop=y}var c=this,g,k,l;if(f!==undefined){i=i===false?false:true;k=c.rows.namedItem(f+"");if(!(!k||k.className.indexOf("ui-state-disabled")>-1)){if(c.p.scrollrows===true){g=c.rows.namedItem(f).rowIndex;g>=0&&h(g)}if(c.p.multiselect){b("#cb_"+b.jgrid.jqID(c.p.id),c.grid.hDiv)[c.p.useProp?"prop":"attr"]("checked",false);c.p.selrow=k.id;l=b.inArray(c.p.selrow,
c.p.selarrrow);if(l===-1){k.className!=="ui-subgrid"&&b(k).addClass("ui-state-highlight").attr("aria-selected","true");g=true;b("#jqg_"+b.jgrid.jqID(c.p.id)+"_"+b.jgrid.jqID(c.p.selrow))[c.p.useProp?"prop":"attr"]("checked",g);c.p.selarrrow.push(c.p.selrow)}else{k.className!=="ui-subgrid"&&b(k).removeClass("ui-state-highlight").attr("aria-selected","false");g=false;b("#jqg_"+b.jgrid.jqID(c.p.id)+"_"+b.jgrid.jqID(c.p.selrow))[c.p.useProp?"prop":"attr"]("checked",g);c.p.selarrrow.splice(l,1);l=c.p.selarrrow[0];
c.p.selrow=l===undefined?null:l}c.p.onSelectRow&&i&&c.p.onSelectRow.call(c,k.id,g)}else if(k.className!=="ui-subgrid"){if(c.p.selrow!=k.id){b(c.rows.namedItem(c.p.selrow)).removeClass("ui-state-highlight").attr({"aria-selected":"false",tabindex:"-1"});b(k).addClass("ui-state-highlight").attr({"aria-selected":"true",tabindex:"0"});g=true}else g=false;c.p.selrow=k.id;c.p.onSelectRow&&i&&c.p.onSelectRow.call(c,k.id,g)}}}})},resetSelection:function(f){return this.each(function(){var i=this,h,c;if(typeof f!==
"undefined"){c=f===i.p.selrow?i.p.selrow:f;b("#"+b.jgrid.jqID(i.p.id)+" tbody:first tr#"+b.jgrid.jqID(c)).removeClass("ui-state-highlight").attr("aria-selected","false");if(i.p.multiselect){b("#jqg_"+b.jgrid.jqID(i.p.id)+"_"+b.jgrid.jqID(c))[i.p.useProp?"prop":"attr"]("checked",false);b("#cb_"+b.jgrid.jqID(i.p.id))[i.p.useProp?"prop":"attr"]("checked",false)}c=null}else if(i.p.multiselect){b(i.p.selarrrow).each(function(g,k){h=i.rows.namedItem(k);b(h).removeClass("ui-state-highlight").attr("aria-selected",
"false");b("#jqg_"+b.jgrid.jqID(i.p.id)+"_"+b.jgrid.jqID(k))[i.p.useProp?"prop":"attr"]("checked",false)});b("#cb_"+b.jgrid.jqID(i.p.id))[i.p.useProp?"prop":"attr"]("checked",false);i.p.selarrrow=[]}else if(i.p.selrow){b("#"+b.jgrid.jqID(i.p.id)+" tbody:first tr#"+b.jgrid.jqID(i.p.selrow)).removeClass("ui-state-highlight").attr("aria-selected","false");i.p.selrow=null}if(i.p.cellEdit===true)if(parseInt(i.p.iCol,10)>=0&&parseInt(i.p.iRow,10)>=0){b("td:eq("+i.p.iCol+")",i.rows[i.p.iRow]).removeClass("edit-cell ui-state-highlight");
b(i.rows[i.p.iRow]).removeClass("selected-row ui-state-hover")}i.p.savedRow=[]})},getRowData:function(f){var i={},h,c=false,g,k=0;this.each(function(){var l=this,a,r;if(typeof f=="undefined"){c=true;h=[];g=l.rows.length}else{r=l.rows.namedItem(f);if(!r)return i;g=2}for(;k<g;){if(c)r=l.rows[k];if(b(r).hasClass("jqgrow")){b("td",r).each(function(x){a=l.p.colModel[x].name;if(a!=="cb"&&a!=="subgrid"&&a!=="rn")if(l.p.treeGrid===true&&a==l.p.ExpandColumn)i[a]=b.jgrid.htmlDecode(b("span:first",this).html());
else try{i[a]=b.unformat(this,{rowId:r.id,colModel:l.p.colModel[x]},x)}catch(y){i[a]=b.jgrid.htmlDecode(b(this).html())}});if(c){h.push(i);i={}}}k++}});return h?h:i},delRowData:function(f){var i=false,h,c;this.each(function(){if(h=this.rows.namedItem(f)){b(h).remove();this.p.records--;this.p.reccount--;this.updatepager(true,false);i=true;if(this.p.multiselect){c=b.inArray(f,this.p.selarrrow);c!=-1&&this.p.selarrrow.splice(c,1)}if(f==this.p.selrow)this.p.selrow=null}else return false;if(this.p.datatype==
"local"){var g=this.p._index[f];if(typeof g!="undefined"){this.p.data.splice(g,1);this.refreshIndex()}}if(this.p.altRows===true&&i){var k=this.p.altclass;b(this.rows).each(function(l){l%2==1?b(this).addClass(k):b(this).removeClass(k)})}});return i},setRowData:function(f,i,h){var c,g=true,k;this.each(function(){if(!this.grid)return false;var l=this,a,r,x=typeof h,y={};r=l.rows.namedItem(f);if(!r)return false;if(i)try{b(this.p.colModel).each(function(P){c=this.name;if(i[c]!==undefined){y[c]=this.formatter&&
typeof this.formatter==="string"&&this.formatter=="date"?b.unformat.date(i[c],this):i[c];a=l.formatter(f,i[c],P,i,"edit");k=this.title?{title:b.jgrid.stripHtml(a)}:{};l.p.treeGrid===true&&c==l.p.ExpandColumn?b("td:eq("+P+") > span:first",r).html(a).attr(k):b("td:eq("+P+")",r).html(a).attr(k)}});if(l.p.datatype=="local"){var H=l.p._index[f];if(l.p.treeGrid)for(var L in l.p.treeReader)y.hasOwnProperty(l.p.treeReader[L])&&delete y[l.p.treeReader[L]];if(typeof H!="undefined")l.p.data[H]=b.extend(true,
l.p.data[H],y);y=null}}catch(M){g=false}if(g)if(x==="string")b(r).addClass(h);else x==="object"&&b(r).css(h)});return g},addRowData:function(f,i,h,c){h||(h="last");var g=false,k,l,a,r,x,y,H,L,M="",P,U,o,n,s;if(i){if(b.isArray(i)){P=true;h="last";U=f}else{i=[i];P=false}this.each(function(){var D=i.length;x=this.p.rownumbers===true?1:0;a=this.p.multiselect===true?1:0;r=this.p.subGrid===true?1:0;if(!P)if(typeof f!="undefined")f+="";else{f=b.jgrid.randId();if(this.p.keyIndex!==false){U=this.p.colModel[this.p.keyIndex+
a+r+x].name;if(typeof i[0][U]!="undefined")f=i[0][U]}}o=this.p.altclass;for(var T=0,J="",C={},ca=b.isFunction(this.p.afterInsertRow)?true:false;T<D;){n=i[T];l="";if(P){try{f=n[U]}catch(V){f=b.jgrid.randId()}J=this.p.altRows===true?(this.rows.length-1)%2===0?o:"":""}f=this.p.idPrefix+f;if(x){M=this.formatCol(0,1,"",null,f,true);l+='<td role="gridcell" aria-describedby="'+this.p.id+'_rn" class="ui-state-default jqgrid-rownum" '+M+">0</td>"}if(a){L='<input role="checkbox" type="checkbox" id="jqg_'+this.p.id+
"_"+f+'" class="cbox"/>';M=this.formatCol(x,1,"",null,f,true);l+='<td role="gridcell" aria-describedby="'+this.p.id+'_cb" '+M+">"+L+"</td>"}if(r)l+=b(this).jqGrid("addSubGridCell",a+x,1);for(H=a+r+x;H<this.p.colModel.length;H++){s=this.p.colModel[H];k=s.name;C[k]=s.formatter&&typeof s.formatter==="string"&&s.formatter=="date"?b.unformat.date(n[k],s):n[k];L=this.formatter(f,b.jgrid.getAccessor(n,k),H,n,"edit");M=this.formatCol(H,1,L,n,f,true);l+='<td role="gridcell" aria-describedby="'+this.p.id+"_"+
k+'" '+M+">"+L+"</td>"}l='<tr id="'+f+'" role="row" tabindex="-1" class="ui-widget-content jqgrow ui-row-'+this.p.direction+" "+J+'">'+l+"</tr>";if(this.rows.length===0)b("table:first",this.grid.bDiv).append(l);else switch(h){case "last":b(this.rows[this.rows.length-1]).after(l);y=this.rows.length-1;break;case "first":b(this.rows[0]).after(l);y=1;break;case "after":if(y=this.rows.namedItem(c))b(this.rows[y.rowIndex+1]).hasClass("ui-subgrid")?b(this.rows[y.rowIndex+1]).after(l):b(y).after(l);y++;break;
case "before":if(y=this.rows.namedItem(c)){b(y).before(l);y=y.rowIndex}y--}this.p.subGrid===true&&b(this).jqGrid("addSubGrid",a+x,y);this.p.records++;this.p.reccount++;ca&&this.p.afterInsertRow.call(this,f,n,n);T++;if(this.p.datatype=="local"){C[this.p.localReader.id]=f;this.p._index[f]=this.p.data.length;this.p.data.push(C);C={}}}if(this.p.altRows===true&&!P)if(h=="last")(this.rows.length-1)%2==1&&b(this.rows[this.rows.length-1]).addClass(o);else b(this.rows).each(function(fa){fa%2==1?b(this).addClass(o):
b(this).removeClass(o)});this.updatepager(true,true);g=true})}return g},footerData:function(f,i,h){function c(r){for(var x in r)if(r.hasOwnProperty(x))return false;return true}var g,k=false,l={},a;if(typeof f=="undefined")f="get";if(typeof h!="boolean")h=true;f=f.toLowerCase();this.each(function(){var r=this,x;if(!r.grid||!r.p.footerrow)return false;if(f=="set")if(c(i))return false;k=true;b(this.p.colModel).each(function(y){g=this.name;if(f=="set"){if(i[g]!==undefined){x=h?r.formatter("",i[g],y,i,
"edit"):i[g];a=this.title?{title:b.jgrid.stripHtml(x)}:{};b("tr.footrow td:eq("+y+")",r.grid.sDiv).html(x).attr(a);k=true}}else if(f=="get")l[g]=b("tr.footrow td:eq("+y+")",r.grid.sDiv).html()})});return f=="get"?l:k},showHideCol:function(f,i){return this.each(function(){var h=this,c=false,g=b.browser.webkit||b.browser.safari?0:h.p.cellLayout,k;if(h.grid){if(typeof f==="string")f=[f];i=i!="none"?"":"none";var l=i===""?true:false,a=h.p.groupHeader&&(typeof h.p.groupHeader==="object"||b.isFunction(h.p.groupHeader));
a&&b(h).jqGrid("destroyGroupHeader",false);b(this.p.colModel).each(function(r){if(b.inArray(this.name,f)!==-1&&this.hidden===l){b("tr",h.grid.hDiv).each(function(){b(this.cells[r]).css("display",i)});b(h.rows).each(function(){b(this.cells[r]).css("display",i)});h.p.footerrow&&b("tr.footrow td:eq("+r+")",h.grid.sDiv).css("display",i);k=this.widthOrg?this.widthOrg:parseInt(this.width,10);if(i==="none")h.p.tblwidth-=k+g;else h.p.tblwidth+=k+g;this.hidden=!l;c=true}});if(c===true)b(h).jqGrid("setGridWidth",
h.p.shrinkToFit===true?h.p.tblwidth:h.p.width);a&&b(h).jqGrid("setGroupHeaders",h.p.groupHeader)}})},hideCol:function(f){return this.each(function(){b(this).jqGrid("showHideCol",f,"none")})},showCol:function(f){return this.each(function(){b(this).jqGrid("showHideCol",f,"")})},remapColumns:function(f,i,h){function c(l){var a;a=l.length?b.makeArray(l):b.extend({},l);b.each(f,function(r){l[r]=a[this]})}function g(l,a){b(">tr"+(a||""),l).each(function(){var r=this,x=b.makeArray(r.cells);b.each(f,function(){var y=
x[this];y&&r.appendChild(y)})})}var k=this.get(0);c(k.p.colModel);c(k.p.colNames);c(k.grid.headers);g(b("thead:first",k.grid.hDiv),h&&":not(.ui-jqgrid-labels)");i&&g(b("#"+b.jgrid.jqID(k.p.id)+" tbody:first"),".jqgfirstrow, tr.jqgrow, tr.jqfoot");k.p.footerrow&&g(b("tbody:first",k.grid.sDiv));if(k.p.remapColumns)if(k.p.remapColumns.length)c(k.p.remapColumns);else k.p.remapColumns=b.makeArray(f);k.p.lastsort=b.inArray(k.p.lastsort,f);if(k.p.treeGrid)k.p.expColInd=b.inArray(k.p.expColInd,f)},setGridWidth:function(f,
i){return this.each(function(){if(this.grid){var h=this,c,g=0,k=b.browser.webkit||b.browser.safari?0:h.p.cellLayout,l,a=0,r=false,x=h.p.scrollOffset,y,H=0,L=0,M;if(typeof i!="boolean")i=h.p.shrinkToFit;if(!isNaN(f)){f=parseInt(f,10);h.grid.width=h.p.width=f;b("#gbox_"+b.jgrid.jqID(h.p.id)).css("width",f+"px");b("#gview_"+b.jgrid.jqID(h.p.id)).css("width",f+"px");b(h.grid.bDiv).css("width",f+"px");b(h.grid.hDiv).css("width",f+"px");h.p.pager&&b(h.p.pager).css("width",f+"px");h.p.toppager&&b(h.p.toppager).css("width",
f+"px");if(h.p.toolbar[0]===true){b(h.grid.uDiv).css("width",f+"px");h.p.toolbar[1]=="both"&&b(h.grid.ubDiv).css("width",f+"px")}h.p.footerrow&&b(h.grid.sDiv).css("width",f+"px");if(i===false&&h.p.forceFit===true)h.p.forceFit=false;if(i===true){b.each(h.p.colModel,function(){if(this.hidden===false){c=this.widthOrg?this.widthOrg:parseInt(this.width,10);g+=c+k;if(this.fixed)H+=c+k;else a++;L++}});if(a===0)return;h.p.tblwidth=g;y=f-k*a-H;if(!isNaN(h.p.height))if(b(h.grid.bDiv)[0].clientHeight<b(h.grid.bDiv)[0].scrollHeight||
h.rows.length===1){r=true;y-=x}g=0;var P=h.grid.cols.length>0;b.each(h.p.colModel,function(U){if(this.hidden===false&&!this.fixed){c=this.widthOrg?this.widthOrg:parseInt(this.width,10);c=Math.round(y*c/(h.p.tblwidth-k*a-H));if(!(c<0)){this.width=c;g+=c;h.grid.headers[U].width=c;h.grid.headers[U].el.style.width=c+"px";if(h.p.footerrow)h.grid.footers[U].style.width=c+"px";if(P)h.grid.cols[U].style.width=c+"px";l=U}}});if(!l)return;M=0;if(r){if(f-H-(g+k*a)!==x)M=f-H-(g+k*a)-x}else if(Math.abs(f-H-(g+
k*a))!==1)M=f-H-(g+k*a);h.p.colModel[l].width+=M;h.p.tblwidth=g+M+k*a+H;if(h.p.tblwidth>f){r=h.p.tblwidth-parseInt(f,10);h.p.tblwidth=f;c=h.p.colModel[l].width-=r}else c=h.p.colModel[l].width;h.grid.headers[l].width=c;h.grid.headers[l].el.style.width=c+"px";if(P)h.grid.cols[l].style.width=c+"px";if(h.p.footerrow)h.grid.footers[l].style.width=c+"px"}if(h.p.tblwidth){b("table:first",h.grid.bDiv).css("width",h.p.tblwidth+"px");b("table:first",h.grid.hDiv).css("width",h.p.tblwidth+"px");h.grid.hDiv.scrollLeft=
h.grid.bDiv.scrollLeft;h.p.footerrow&&b("table:first",h.grid.sDiv).css("width",h.p.tblwidth+"px")}}}})},setGridHeight:function(f){return this.each(function(){if(this.grid){b(this.grid.bDiv).css({height:f+(isNaN(f)?"":"px")});this.p.height=f;this.p.scroll&&this.grid.populateVisible()}})},setCaption:function(f){return this.each(function(){this.p.caption=f;b("span.ui-jqgrid-title",this.grid.cDiv).html(f);b(this.grid.cDiv).show()})},setLabel:function(f,i,h,c){return this.each(function(){var g=-1;if(this.grid)if(typeof f!=
"undefined"){b(this.p.colModel).each(function(a){if(this.name==f){g=a;return false}});if(g>=0){var k=b("tr.ui-jqgrid-labels th:eq("+g+")",this.grid.hDiv);if(i){var l=b(".s-ico",k);b("[id^=jqgh_]",k).empty().html(i).append(l);this.p.colNames[g]=i}if(h)typeof h==="string"?b(k).addClass(h):b(k).css(h);typeof c==="object"&&b(k).attr(c)}}})},setCell:function(f,i,h,c,g,k){return this.each(function(){var l=-1,a,r;if(this.grid){if(isNaN(i))b(this.p.colModel).each(function(y){if(this.name==i){l=y;return false}});
else l=parseInt(i,10);if(l>=0)if(a=this.rows.namedItem(f)){var x=b("td:eq("+l+")",a);if(h!==""||k===true){a=this.formatter(f,h,l,a,"edit");r=this.p.colModel[l].title?{title:b.jgrid.stripHtml(a)}:{};this.p.treeGrid&&b(".tree-wrap",b(x)).length>0?b("span",b(x)).html(a).attr(r):b(x).html(a).attr(r);if(this.p.datatype=="local"){a=this.p.colModel[l];h=a.formatter&&typeof a.formatter==="string"&&a.formatter=="date"?b.unformat.date(h,a):h;r=this.p._index[f];if(typeof r!="undefined")this.p.data[r][a.name]=
h}}if(typeof c==="string")b(x).addClass(c);else c&&b(x).css(c);typeof g==="object"&&b(x).attr(g)}}})},getCell:function(f,i){var h=false;this.each(function(){var c=-1;if(this.grid){if(isNaN(i))b(this.p.colModel).each(function(l){if(this.name===i){c=l;return false}});else c=parseInt(i,10);if(c>=0){var g=this.rows.namedItem(f);if(g)try{h=b.unformat(b("td:eq("+c+")",g),{rowId:g.id,colModel:this.p.colModel[c]},c)}catch(k){h=b.jgrid.htmlDecode(b("td:eq("+c+")",g).html())}}}});return h},getCol:function(f,
i,h){var c=[],g,k=0,l=0,a=0,r;i=typeof i!="boolean"?false:i;if(typeof h=="undefined")h=false;this.each(function(){var x=-1;if(this.grid){if(isNaN(f))b(this.p.colModel).each(function(M){if(this.name===f){x=M;return false}});else x=parseInt(f,10);if(x>=0){var y=this.rows.length,H=0;if(y&&y>0){for(;H<y;){if(b(this.rows[H]).hasClass("jqgrow")){try{g=b.unformat(b(this.rows[H].cells[x]),{rowId:this.rows[H].id,colModel:this.p.colModel[x]},x)}catch(L){g=b.jgrid.htmlDecode(this.rows[H].cells[x].innerHTML)}if(h){r=
parseFloat(g);k+=r;l=Math.min(l,r);a=Math.max(a,r)}else i?c.push({id:this.rows[H].id,value:g}):c.push(g)}H++}if(h)switch(h.toLowerCase()){case "sum":c=k;break;case "avg":c=k/y;break;case "count":c=y;break;case "min":c=l;break;case "max":c=a}}}}});return c},clearGridData:function(f){return this.each(function(){if(this.grid){if(typeof f!="boolean")f=false;if(this.p.deepempty)b("#"+b.jgrid.jqID(this.p.id)+" tbody:first tr:gt(0)").remove();else{var i=b("#"+b.jgrid.jqID(this.p.id)+" tbody:first tr:first")[0];
b("#"+b.jgrid.jqID(this.p.id)+" tbody:first").empty().append(i)}this.p.footerrow&&f&&b(".ui-jqgrid-ftable td",this.grid.sDiv).html("&#160;");this.p.selrow=null;this.p.selarrrow=[];this.p.savedRow=[];this.p.records=0;this.p.page=1;this.p.lastpage=0;this.p.reccount=0;this.p.data=[];this.p._index={};this.updatepager(true,false)}})},getInd:function(f,i){var h=false,c;this.each(function(){if(c=this.rows.namedItem(f))h=i===true?c:c.rowIndex});return h},bindKeys:function(f){var i=b.extend({onEnter:null,
onSpace:null,onLeftKey:null,onRightKey:null,scrollingRows:true},f||{});return this.each(function(){var h=this;b("body").is("[role]")||b("body").attr("role","application");h.p.scrollrows=i.scrollingRows;b(h).keydown(function(c){var g=b(h).find("tr[tabindex=0]")[0],k,l,a,r=h.p.treeReader.expanded_field;if(g){a=h.p._index[g.id];if(c.keyCode===37||c.keyCode===38||c.keyCode===39||c.keyCode===40){if(c.keyCode===38){l=g.previousSibling;k="";if(l)if(b(l).is(":hidden"))for(;l;){l=l.previousSibling;if(!b(l).is(":hidden")&&
b(l).hasClass("jqgrow")){k=l.id;break}}else k=l.id;b(h).jqGrid("setSelection",k)}if(c.keyCode===40){l=g.nextSibling;k="";if(l)if(b(l).is(":hidden"))for(;l;){l=l.nextSibling;if(!b(l).is(":hidden")&&b(l).hasClass("jqgrow")){k=l.id;break}}else k=l.id;b(h).jqGrid("setSelection",k)}if(c.keyCode===37){h.p.treeGrid&&h.p.data[a][r]&&b(g).find("div.treeclick").trigger("click");b.isFunction(i.onLeftKey)&&i.onLeftKey.call(h,h.p.selrow)}if(c.keyCode===39){h.p.treeGrid&&!h.p.data[a][r]&&b(g).find("div.treeclick").trigger("click");
b.isFunction(i.onRightKey)&&i.onRightKey.call(h,h.p.selrow)}}else if(c.keyCode===13)b.isFunction(i.onEnter)&&i.onEnter.call(h,h.p.selrow);else c.keyCode===32&&b.isFunction(i.onSpace)&&i.onSpace.call(h,h.p.selrow)}})})},unbindKeys:function(){return this.each(function(){b(this).unbind("keydown")})},getLocalRow:function(f){var i=false,h;this.each(function(){if(typeof f!=="undefined"){h=this.p._index[f];if(h>=0)i=this.p.data[h]}});return i}})})(jQuery);
(function(b){b.fmatter={};b.extend(b.fmatter,{isBoolean:function(a){return typeof a==="boolean"},isObject:function(a){return a&&(typeof a==="object"||b.isFunction(a))||false},isString:function(a){return typeof a==="string"},isNumber:function(a){return typeof a==="number"&&isFinite(a)},isNull:function(a){return a===null},isUndefined:function(a){return typeof a==="undefined"},isValue:function(a){return this.isObject(a)||this.isString(a)||this.isNumber(a)||this.isBoolean(a)},isEmpty:function(a){if(!this.isString(a)&&
this.isValue(a))return false;else if(!this.isValue(a))return true;a=b.trim(a).replace(/\&nbsp\;/ig,"").replace(/\&#160\;/ig,"");return a===""}});b.fn.fmatter=function(a,c,d,e,f){var g=c;d=b.extend({},b.jgrid.formatter,d);if(b.fn.fmatter[a])g=b.fn.fmatter[a](c,d,e,f);return g};b.fmatter.util={NumberFormat:function(a,c){b.fmatter.isNumber(a)||(a*=1);if(b.fmatter.isNumber(a)){var d=a<0,e=a+"",f=c.decimalSeparator?c.decimalSeparator:".",g;if(b.fmatter.isNumber(c.decimalPlaces)){var h=c.decimalPlaces;
e=Math.pow(10,h);e=Math.round(a*e)/e+"";g=e.lastIndexOf(".");if(h>0){if(g<0){e+=f;g=e.length-1}else if(f!==".")e=e.replace(".",f);for(;e.length-1-g<h;)e+="0"}}if(c.thousandsSeparator){h=c.thousandsSeparator;g=e.lastIndexOf(f);g=g>-1?g:e.length;f=e.substring(g);for(var i=-1,j=g;j>0;j--){i++;if(i%3===0&&j!==g&&(!d||j>1))f=h+f;f=e.charAt(j-1)+f}e=f}e=c.prefix?c.prefix+e:e;return e=c.suffix?e+c.suffix:e}else return a},DateFormat:function(a,c,d,e){var f=/^\/Date\((([-+])?[0-9]+)(([-+])([0-9]{2})([0-9]{2}))?\)\/$/,
g=typeof c==="string"?c.match(f):null;f=function(m,r){m=String(m);for(r=parseInt(r,10)||2;m.length<r;)m="0"+m;return m};var h={m:1,d:1,y:1970,h:0,i:0,s:0,u:0},i=0,j,k=["i18n"];k.i18n={dayNames:e.dayNames,monthNames:e.monthNames};if(a in e.masks)a=e.masks[a];if(!isNaN(c-0)&&String(a).toLowerCase()=="u")i=new Date(parseFloat(c)*1E3);else if(c.constructor===Date)i=c;else if(g!==null){i=new Date(parseInt(g[1],10));if(g[3]){a=Number(g[5])*60+Number(g[6]);a*=g[4]=="-"?1:-1;a-=i.getTimezoneOffset();i.setTime(Number(Number(i)+
a*6E4))}}else{c=String(c).split(/[\\\/:_;.,\t\T\s-]/);a=a.split(/[\\\/:_;.,\t\T\s-]/);g=0;for(j=a.length;g<j;g++){if(a[g]=="M"){i=b.inArray(c[g],k.i18n.monthNames);if(i!==-1&&i<12)c[g]=i+1}if(a[g]=="F"){i=b.inArray(c[g],k.i18n.monthNames);if(i!==-1&&i>11)c[g]=i+1-12}if(c[g])h[a[g].toLowerCase()]=parseInt(c[g],10)}if(h.f)h.m=h.f;if(h.m===0&&h.y===0&&h.d===0)return"&#160;";h.m=parseInt(h.m,10)-1;i=h.y;if(i>=70&&i<=99)h.y=1900+h.y;else if(i>=0&&i<=69)h.y=2E3+h.y;i=new Date(h.y,h.m,h.d,h.h,h.i,h.s,h.u)}if(d in
e.masks)d=e.masks[d];else d||(d="Y-m-d");a=i.getHours();c=i.getMinutes();h=i.getDate();g=i.getMonth()+1;j=i.getTimezoneOffset();var l=i.getSeconds(),o=i.getMilliseconds(),n=i.getDay(),p=i.getFullYear(),q=(n+6)%7+1,s=(new Date(p,g-1,h)-new Date(p,0,1))/864E5,t={d:f(h),D:k.i18n.dayNames[n],j:h,l:k.i18n.dayNames[n+7],N:q,S:e.S(h),w:n,z:s,W:q<5?Math.floor((s+q-1)/7)+1:Math.floor((s+q-1)/7)||(((new Date(p-1,0,1)).getDay()+6)%7<4?53:52),F:k.i18n.monthNames[g-1+12],m:f(g),M:k.i18n.monthNames[g-1],n:g,t:"?",
L:"?",o:"?",Y:p,y:String(p).substring(2),a:a<12?e.AmPm[0]:e.AmPm[1],A:a<12?e.AmPm[2]:e.AmPm[3],B:"?",g:a%12||12,G:a,h:f(a%12||12),H:f(a),i:f(c),s:f(l),u:o,e:"?",I:"?",O:(j>0?"-":"+")+f(Math.floor(Math.abs(j)/60)*100+Math.abs(j)%60,4),P:"?",T:(String(i).match(/\b(?:[PMCEA][SDP]T|(?:Pacific|Mountain|Central|Eastern|Atlantic) (?:Standard|Daylight|Prevailing) Time|(?:GMT|UTC)(?:[-+]\d{4})?)\b/g)||[""]).pop().replace(/[^-+\dA-Z]/g,""),Z:"?",c:"?",r:"?",U:Math.floor(i/1E3)};return d.replace(/\\.|[dDjlNSwzWFmMntLoYyaABgGhHisueIOPTZcrU]/g,
function(m){return m in t?t[m]:m.substring(1)})}};b.fn.fmatter.defaultFormat=function(a,c){return b.fmatter.isValue(a)&&a!==""?a:c.defaultValue?c.defaultValue:"&#160;"};b.fn.fmatter.email=function(a,c){return b.fmatter.isEmpty(a)?b.fn.fmatter.defaultFormat(a,c):'<a href="mailto:'+a+'">'+a+"</a>"};b.fn.fmatter.checkbox=function(a,c){var d=b.extend({},c.checkbox),e;b.fmatter.isUndefined(c.colModel.formatoptions)||(d=b.extend({},d,c.colModel.formatoptions));e=d.disabled===true?'disabled="disabled"':
"";if(b.fmatter.isEmpty(a)||b.fmatter.isUndefined(a))a=b.fn.fmatter.defaultFormat(a,d);a+="";a=a.toLowerCase();return'<input type="checkbox" '+(a.search(/(false|0|no|off)/i)<0?" checked='checked' ":"")+' value="'+a+'" offval="no" '+e+"/>"};b.fn.fmatter.link=function(a,c){var d={target:c.target},e="";b.fmatter.isUndefined(c.colModel.formatoptions)||(d=b.extend({},d,c.colModel.formatoptions));if(d.target)e="target="+d.target;return b.fmatter.isEmpty(a)?b.fn.fmatter.defaultFormat(a,c):"<a "+e+' href="'+
a+'">'+a+"</a>"};b.fn.fmatter.showlink=function(a,c){var d={baseLinkUrl:c.baseLinkUrl,showAction:c.showAction,addParam:c.addParam||"",target:c.target,idName:c.idName},e="";b.fmatter.isUndefined(c.colModel.formatoptions)||(d=b.extend({},d,c.colModel.formatoptions));if(d.target)e="target="+d.target;d=d.baseLinkUrl+d.showAction+"?"+d.idName+"="+c.rowId+d.addParam;return b.fmatter.isString(a)||b.fmatter.isNumber(a)?"<a "+e+' href="'+d+'">'+a+"</a>":b.fn.fmatter.defaultFormat(a,c)};b.fn.fmatter.integer=
function(a,c){var d=b.extend({},c.integer);b.fmatter.isUndefined(c.colModel.formatoptions)||(d=b.extend({},d,c.colModel.formatoptions));if(b.fmatter.isEmpty(a))return d.defaultValue;return b.fmatter.util.NumberFormat(a,d)};b.fn.fmatter.number=function(a,c){var d=b.extend({},c.number);b.fmatter.isUndefined(c.colModel.formatoptions)||(d=b.extend({},d,c.colModel.formatoptions));if(b.fmatter.isEmpty(a))return d.defaultValue;return b.fmatter.util.NumberFormat(a,d)};b.fn.fmatter.currency=function(a,c){var d=
b.extend({},c.currency);b.fmatter.isUndefined(c.colModel.formatoptions)||(d=b.extend({},d,c.colModel.formatoptions));if(b.fmatter.isEmpty(a))return d.defaultValue;return b.fmatter.util.NumberFormat(a,d)};b.fn.fmatter.date=function(a,c,d,e){d=b.extend({},c.date);b.fmatter.isUndefined(c.colModel.formatoptions)||(d=b.extend({},d,c.colModel.formatoptions));return!d.reformatAfterEdit&&e=="edit"?b.fn.fmatter.defaultFormat(a,c):b.fmatter.isEmpty(a)?b.fn.fmatter.defaultFormat(a,c):b.fmatter.util.DateFormat(d.srcformat,
a,d.newformat,d)};b.fn.fmatter.select=function(a,c){a+="";var d=false,e=[];if(b.fmatter.isUndefined(c.colModel.formatoptions)){if(!b.fmatter.isUndefined(c.colModel.editoptions))d=c.colModel.editoptions.value}else d=c.colModel.formatoptions.value;if(d){var f=c.colModel.editoptions.multiple===true?true:false,g=[],h;if(f){g=a.split(",");g=b.map(g,function(l){return b.trim(l)})}if(b.fmatter.isString(d))for(var i=d.split(";"),j=0,k=0;k<i.length;k++){h=i[k].split(":");if(h.length>2)h[1]=jQuery.map(h,function(l,
o){if(o>0)return l}).join(":");if(f){if(jQuery.inArray(h[0],g)>-1){e[j]=h[1];j++}}else if(b.trim(h[0])==b.trim(a)){e[0]=h[1];break}}else if(b.fmatter.isObject(d))if(f)e=jQuery.map(g,function(l){return d[l]});else e[0]=d[a]||""}a=e.join(", ");return a===""?b.fn.fmatter.defaultFormat(a,c):a};b.fn.fmatter.rowactions=function(a,c,d,e){var f={keys:false,onEdit:null,onSuccess:null,afterSave:null,onError:null,afterRestore:null,extraparam:{oper:"edit"},url:null,delOptions:{},editOptions:{}};a=b.jgrid.jqID(a);
c=b.jgrid.jqID(c);e=b("#"+c)[0].p.colModel[e];b.fmatter.isUndefined(e.formatoptions)||(f=b.extend(f,e.formatoptions));if(!b.fmatter.isUndefined(b("#"+c)[0].p.editOptions))f.editOptions=b("#"+c)[0].p.editOptions;if(!b.fmatter.isUndefined(b("#"+c)[0].p.delOptions))f.delOptions=b("#"+c)[0].p.delOptions;e=function(h){f.afterSave&&f.afterSave(h);b("tr#"+a+" div.ui-inline-edit, tr#"+a+" div.ui-inline-del","#"+c+".ui-jqgrid-btable:first").show();b("tr#"+a+" div.ui-inline-save, tr#"+a+" div.ui-inline-cancel",
"#"+c+".ui-jqgrid-btable:first").hide()};var g=function(h){f.afterRestore&&f.afterRestore(h);b("tr#"+a+" div.ui-inline-edit, tr#"+a+" div.ui-inline-del","#"+c+".ui-jqgrid-btable:first").show();b("tr#"+a+" div.ui-inline-save, tr#"+a+" div.ui-inline-cancel","#"+c+".ui-jqgrid-btable:first").hide()};switch(d){case "edit":b("#"+c).jqGrid("editRow",a,f.keys,f.onEdit,f.onSuccess,f.url,f.extraparam,e,f.onError,g);b("tr#"+a+" div.ui-inline-edit, tr#"+a+" div.ui-inline-del","#"+c+".ui-jqgrid-btable:first").hide();
b("tr#"+a+" div.ui-inline-save, tr#"+a+" div.ui-inline-cancel","#"+c+".ui-jqgrid-btable:first").show();break;case "save":if(b("#"+c).jqGrid("saveRow",a,f.onSuccess,f.url,f.extraparam,e,f.onError,g)){b("tr#"+a+" div.ui-inline-edit, tr#"+a+" div.ui-inline-del","#"+c+".ui-jqgrid-btable:first").show();b("tr#"+a+" div.ui-inline-save, tr#"+a+" div.ui-inline-cancel","#"+c+".ui-jqgrid-btable:first").hide()}break;case "cancel":b("#"+c).jqGrid("restoreRow",a,g);b("tr#"+a+" div.ui-inline-edit, tr#"+a+" div.ui-inline-del",
"#"+c+".ui-jqgrid-btable:first").show();b("tr#"+a+" div.ui-inline-save, tr#"+a+" div.ui-inline-cancel","#"+c+".ui-jqgrid-btable:first").hide();break;case "del":b("#"+c).jqGrid("delGridRow",a,f.delOptions);break;case "formedit":b("#"+c).jqGrid("setSelection",a);b("#"+c).jqGrid("editGridRow",a,f.editOptions)}};b.fn.fmatter.actions=function(a,c){var d={keys:false,editbutton:true,delbutton:true,editformbutton:false};b.fmatter.isUndefined(c.colModel.formatoptions)||(d=b.extend(d,c.colModel.formatoptions));
var e=c.rowId,f="",g;if(typeof e=="undefined"||b.fmatter.isEmpty(e))return"";if(d.editformbutton){g="onclick=jQuery.fn.fmatter.rowactions('"+e+"','"+c.gid+"','formedit',"+c.pos+"); onmouseover=jQuery(this).addClass('ui-state-hover'); onmouseout=jQuery(this).removeClass('ui-state-hover'); ";f=f+"<div title='"+b.jgrid.nav.edittitle+"' style='float:left;cursor:pointer;' class='ui-pg-div ui-inline-edit' "+g+"><span class='ui-icon ui-icon-pencil'></span></div>"}else if(d.editbutton){g="onclick=jQuery.fn.fmatter.rowactions('"+
e+"','"+c.gid+"','edit',"+c.pos+"); onmouseover=jQuery(this).addClass('ui-state-hover'); onmouseout=jQuery(this).removeClass('ui-state-hover') ";f=f+"<div title='"+b.jgrid.nav.edittitle+"' style='float:left;cursor:pointer;' class='ui-pg-div ui-inline-edit' "+g+"><span class='ui-icon ui-icon-pencil'></span></div>"}if(d.delbutton){g="onclick=jQuery.fn.fmatter.rowactions('"+e+"','"+c.gid+"','del',"+c.pos+"); onmouseover=jQuery(this).addClass('ui-state-hover'); onmouseout=jQuery(this).removeClass('ui-state-hover'); ";
f=f+"<div title='"+b.jgrid.nav.deltitle+"' style='float:left;margin-left:5px;' class='ui-pg-div ui-inline-del' "+g+"><span class='ui-icon ui-icon-trash'></span></div>"}g="onclick=jQuery.fn.fmatter.rowactions('"+e+"','"+c.gid+"','save',"+c.pos+"); onmouseover=jQuery(this).addClass('ui-state-hover'); onmouseout=jQuery(this).removeClass('ui-state-hover'); ";f=f+"<div title='"+b.jgrid.edit.bSubmit+"' style='float:left;display:none' class='ui-pg-div ui-inline-save' "+g+"><span class='ui-icon ui-icon-disk'></span></div>";
g="onclick=jQuery.fn.fmatter.rowactions('"+e+"','"+c.gid+"','cancel',"+c.pos+"); onmouseover=jQuery(this).addClass('ui-state-hover'); onmouseout=jQuery(this).removeClass('ui-state-hover'); ";f=f+"<div title='"+b.jgrid.edit.bCancel+"' style='float:left;display:none;margin-left:5px;' class='ui-pg-div ui-inline-cancel' "+g+"><span class='ui-icon ui-icon-cancel'></span></div>";return"<div style='margin-left:8px;'>"+f+"</div>"};b.unformat=function(a,c,d,e){var f,g=c.colModel.formatter,h=c.colModel.formatoptions||
{},i=/([\.\*\_\'\(\)\{\}\+\?\\])/g,j=c.colModel.unformat||b.fn.fmatter[g]&&b.fn.fmatter[g].unformat;if(typeof j!=="undefined"&&b.isFunction(j))f=j(b(a).text(),c,a);else if(!b.fmatter.isUndefined(g)&&b.fmatter.isString(g)){f=b.jgrid.formatter||{};switch(g){case "integer":h=b.extend({},f.integer,h);c=h.thousandsSeparator.replace(i,"\\$1");f=b(a).text().replace(RegExp(c,"g"),"");break;case "number":h=b.extend({},f.number,h);c=h.thousandsSeparator.replace(i,"\\$1");f=b(a).text().replace(RegExp(c,"g"),
"").replace(h.decimalSeparator,".");break;case "currency":h=b.extend({},f.currency,h);c=h.thousandsSeparator.replace(i,"\\$1");f=b(a).text().replace(RegExp(c,"g"),"").replace(h.decimalSeparator,".").replace(h.prefix,"").replace(h.suffix,"");break;case "checkbox":h=c.colModel.editoptions?c.colModel.editoptions.value.split(":"):["Yes","No"];f=b("input",a).is(":checked")?h[0]:h[1];break;case "select":f=b.unformat.select(a,c,d,e);break;case "actions":return"";default:f=b(a).text()}}return f!==undefined?
f:e===true?b(a).text():b.jgrid.htmlDecode(b(a).html())};b.unformat.select=function(a,c,d,e){d=[];a=b(a).text();if(e===true)return a;c=b.extend({},c.colModel.editoptions);if(c.value){var f=c.value;c=c.multiple===true?true:false;e=[];var g;if(c){e=a.split(",");e=b.map(e,function(k){return b.trim(k)})}if(b.fmatter.isString(f))for(var h=f.split(";"),i=0,j=0;j<h.length;j++){g=h[j].split(":");if(g.length>2)g[1]=jQuery.map(g,function(k,l){if(l>0)return k}).join(":");if(c){if(jQuery.inArray(g[1],e)>-1){d[i]=
g[0];i++}}else if(b.trim(g[1])==b.trim(a)){d[0]=g[0];break}}else if(b.fmatter.isObject(f)||b.isArray(f)){c||(e[0]=a);d=jQuery.map(e,function(k){var l;b.each(f,function(o,n){if(n==k){l=o;return false}});if(typeof l!="undefined")return l})}return d.join(", ")}else return a||""};b.unformat.date=function(a,c){var d=b.jgrid.formatter.date||{};b.fmatter.isUndefined(c.formatoptions)||(d=b.extend({},d,c.formatoptions));return b.fmatter.isEmpty(a)?b.fn.fmatter.defaultFormat(a,c):b.fmatter.util.DateFormat(d.newformat,
a,d.srcformat,d)}})(jQuery);
(function(a){a.jgrid.extend({getColProp:function(c){var g={},b=this[0];if(!b.grid)return false;b=b.p.colModel;for(var i=0;i<b.length;i++)if(b[i].name==c){g=b[i];break}return g},setColProp:function(c,g){return this.each(function(){if(this.grid)if(g)for(var b=this.p.colModel,i=0;i<b.length;i++)if(b[i].name==c){a.extend(this.p.colModel[i],g);break}})},sortGrid:function(c,g,b){return this.each(function(){var i=-1;if(this.grid){if(!c)c=this.p.sortname;for(var l=0;l<this.p.colModel.length;l++)if(this.p.colModel[l].index==
c||this.p.colModel[l].name==c){i=l;break}if(i!=-1){l=this.p.colModel[i].sortable;if(typeof l!=="boolean")l=true;if(typeof g!=="boolean")g=false;l&&this.sortData("jqgh_"+this.p.id+"_"+c,i,g,b)}}})},GridDestroy:function(){return this.each(function(){if(this.grid){this.p.pager&&a(this.p.pager).remove();var c=this.id;try{a("#gbox_"+c).remove()}catch(g){}}})},GridUnload:function(){return this.each(function(){if(this.grid){var c={id:a(this).attr("id"),cl:a(this).attr("class")};this.p.pager&&a(this.p.pager).empty().removeClass("ui-state-default ui-jqgrid-pager corner-bottom");
var g=document.createElement("table");a(g).attr({id:c.id});g.className=c.cl;c=this.id;a(g).removeClass("ui-jqgrid-btable");if(a(this.p.pager).parents("#gbox_"+c).length===1){a(g).insertBefore("#gbox_"+c).show();a(this.p.pager).insertBefore("#gbox_"+c)}else a(g).insertBefore("#gbox_"+c).show();a("#gbox_"+c).remove()}})},setGridState:function(c){return this.each(function(){if(this.grid)if(c=="hidden"){a(".ui-jqgrid-bdiv, .ui-jqgrid-hdiv","#gview_"+this.p.id).slideUp("fast");this.p.pager&&a(this.p.pager).slideUp("fast");
this.p.toppager&&a(this.p.toppager).slideUp("fast");if(this.p.toolbar[0]===true){this.p.toolbar[1]=="both"&&a(this.grid.ubDiv).slideUp("fast");a(this.grid.uDiv).slideUp("fast")}this.p.footerrow&&a(".ui-jqgrid-sdiv","#gbox_"+this.p.id).slideUp("fast");a(".ui-jqgrid-titlebar-close span",this.grid.cDiv).removeClass("ui-icon-circle-triangle-n").addClass("ui-icon-circle-triangle-s");this.p.gridstate="hidden"}else if(c=="visible"){a(".ui-jqgrid-hdiv, .ui-jqgrid-bdiv","#gview_"+this.p.id).slideDown("fast");
this.p.pager&&a(this.p.pager).slideDown("fast");this.p.toppager&&a(this.p.toppager).slideDown("fast");if(this.p.toolbar[0]===true){this.p.toolbar[1]=="both"&&a(this.grid.ubDiv).slideDown("fast");a(this.grid.uDiv).slideDown("fast")}this.p.footerrow&&a(".ui-jqgrid-sdiv","#gbox_"+this.p.id).slideDown("fast");a(".ui-jqgrid-titlebar-close span",this.grid.cDiv).removeClass("ui-icon-circle-triangle-s").addClass("ui-icon-circle-triangle-n");this.p.gridstate="visible"}})},filterToolbar:function(c){c=a.extend({autosearch:true,
searchOnEnter:true,beforeSearch:null,afterSearch:null,beforeClear:null,afterClear:null,searchurl:"",stringResult:false,groupOp:"AND",defaultSearch:"bw"},c||{});return this.each(function(){function g(d,f){var j=a(d);j[0]&&jQuery.each(f,function(){this.data!==undefined?j.bind(this.type,this.data,this.fn):j.bind(this.type,this.fn)})}var b=this;if(!this.ftoolbar){var i=function(){var d={},f=0,j,e,h={},n;a.each(b.p.colModel,function(){e=this.index||this.name;switch(this.stype){case "select":n=this.searchoptions&&
this.searchoptions.sopt?this.searchoptions.sopt[0]:"eq";if(j=a("#gs_"+a.jgrid.jqID(this.name),b.grid.hDiv).val()){d[e]=j;h[e]=n;f++}else try{delete b.p.postData[e]}catch(r){}break;case "text":n=this.searchoptions&&this.searchoptions.sopt?this.searchoptions.sopt[0]:c.defaultSearch;if(j=a("#gs_"+a.jgrid.jqID(this.name),b.grid.hDiv).val()){d[e]=j;h[e]=n;f++}else try{delete b.p.postData[e]}catch(u){}}});var o=f>0?true:false;if(c.stringResult===true||b.p.datatype=="local"){var k='{"groupOp":"'+c.groupOp+
'","rules":[',t=0;a.each(d,function(r,u){if(t>0)k+=",";k+='{"field":"'+r+'",';k+='"op":"'+h[r]+'",';u+="";k+='"data":"'+u.replace(/\\/g,"\\\\").replace(/\"/g,'\\"')+'"}';t++});k+="]}";a.extend(b.p.postData,{filters:k});a.each(["searchField","searchString","searchOper"],function(r,u){b.p.postData.hasOwnProperty(u)&&delete b.p.postData[u]})}else a.extend(b.p.postData,d);var m;if(b.p.searchurl){m=b.p.url;a(b).jqGrid("setGridParam",{url:b.p.searchurl})}var q=false;if(a.isFunction(c.beforeSearch))q=c.beforeSearch.call(b);
q||a(b).jqGrid("setGridParam",{search:o}).trigger("reloadGrid",[{page:1}]);m&&a(b).jqGrid("setGridParam",{url:m});a.isFunction(c.afterSearch)&&c.afterSearch()},l=a("<tr class='ui-search-toolbar' role='rowheader'></tr>"),p;a.each(b.p.colModel,function(){var d=this,f,j,e,h;j=a("<th role='columnheader' class='ui-state-default ui-th-column ui-th-"+b.p.direction+"'></th>");f=a("<div style='width:100%;position:relative;height:100%;padding-right:0.3em;'></div>");this.hidden===true&&a(j).css("display","none");
this.search=this.search===false?false:true;if(typeof this.stype=="undefined")this.stype="text";e=a.extend({},this.searchoptions||{});if(this.search)switch(this.stype){case "select":if(h=this.surl||e.dataUrl)a.ajax(a.extend({url:h,dataType:"html",success:function(m){if(e.buildSelect!==undefined)(m=e.buildSelect(m))&&a(f).append(m);else a(f).append(m);e.defaultValue&&a("select",f).val(e.defaultValue);a("select",f).attr({name:d.index||d.name,id:"gs_"+d.name});e.attr&&a("select",f).attr(e.attr);a("select",
f).css({width:"100%"});e.dataInit!==undefined&&e.dataInit(a("select",f)[0]);e.dataEvents!==undefined&&g(a("select",f)[0],e.dataEvents);c.autosearch===true&&a("select",f).change(function(){i();return false});m=null}},a.jgrid.ajaxOptions,b.p.ajaxSelectOptions||{}));else{var n;if(d.searchoptions&&d.searchoptions.value)n=d.searchoptions.value;else if(d.editoptions&&d.editoptions.value)n=d.editoptions.value;if(n){h=document.createElement("select");h.style.width="100%";a(h).attr({name:d.index||d.name,id:"gs_"+
d.name});var o,k;if(typeof n==="string"){n=n.split(";");for(var t=0;t<n.length;t++){o=n[t].split(":");k=document.createElement("option");k.value=o[0];k.innerHTML=o[1];h.appendChild(k)}}else if(typeof n==="object")for(o in n)if(n.hasOwnProperty(o)){k=document.createElement("option");k.value=o;k.innerHTML=n[o];h.appendChild(k)}e.defaultValue&&a(h).val(e.defaultValue);e.attr&&a(h).attr(e.attr);e.dataInit!==undefined&&e.dataInit(h);e.dataEvents!==undefined&&g(h,e.dataEvents);a(f).append(h);c.autosearch===
true&&a(h).change(function(){i();return false})}}break;case "text":h=e.defaultValue?e.defaultValue:"";a(f).append("<input type='text' style='width:95%;padding:0px;' name='"+(d.index||d.name)+"' id='gs_"+d.name+"' value='"+h+"'/>");e.attr&&a("input",f).attr(e.attr);e.dataInit!==undefined&&e.dataInit(a("input",f)[0]);e.dataEvents!==undefined&&g(a("input",f)[0],e.dataEvents);if(c.autosearch===true)c.searchOnEnter?a("input",f).keypress(function(m){if((m.charCode?m.charCode:m.keyCode?m.keyCode:0)==13){i();
return false}return this}):a("input",f).keydown(function(m){switch(m.which){case 13:return false;case 9:case 16:case 37:case 38:case 39:case 40:case 27:break;default:p&&clearTimeout(p);p=setTimeout(function(){i()},500)}})}a(j).append(f);a(l).append(j)});a("table thead",b.grid.hDiv).append(l);this.ftoolbar=true;this.triggerToolbar=i;this.clearToolbar=function(d){var f={},j,e=0,h;d=typeof d!="boolean"?true:d;a.each(b.p.colModel,function(){j=this.searchoptions&&this.searchoptions.defaultValue?this.searchoptions.defaultValue:
"";h=this.index||this.name;switch(this.stype){case "select":var q;a("#gs_"+a.jgrid.jqID(h)+" option",b.grid.hDiv).each(function(s){if(s===0)this.selected=true;if(a(this).text()==j){this.selected=true;q=a(this).val();return false}});if(q){f[h]=q;e++}else try{delete b.p.postData[h]}catch(r){}break;case "text":a("#gs_"+a.jgrid.jqID(h),b.grid.hDiv).val(j);if(j){f[h]=j;e++}else try{delete b.p.postData[h]}catch(u){}}});var n=e>0?true:false;if(c.stringResult===true||b.p.datatype=="local"){var o='{"groupOp":"'+
c.groupOp+'","rules":[',k=0;a.each(f,function(q,r){if(k>0)o+=",";o+='{"field":"'+q+'",';o+='"op":"eq",';r+="";o+='"data":"'+r.replace(/\\/g,"\\\\").replace(/\"/g,'\\"')+'"}';k++});o+="]}";a.extend(b.p.postData,{filters:o});a.each(["searchField","searchString","searchOper"],function(q,r){b.p.postData.hasOwnProperty(r)&&delete b.p.postData[r]})}else a.extend(b.p.postData,f);var t;if(b.p.searchurl){t=b.p.url;a(b).jqGrid("setGridParam",{url:b.p.searchurl})}var m=false;if(a.isFunction(c.beforeClear))m=
c.beforeClear.call(b);m||d&&a(b).jqGrid("setGridParam",{search:n}).trigger("reloadGrid",[{page:1}]);t&&a(b).jqGrid("setGridParam",{url:t});a.isFunction(c.afterClear)&&c.afterClear()};this.toggleToolbar=function(){var d=a("tr.ui-search-toolbar",b.grid.hDiv);d.css("display")=="none"?d.show():d.hide()}}})},destroyGroupHeader:function(c){if(typeof c=="undefined")c=true;return this.each(function(){var g,b,i,l,p,d;b=this.grid;var f=a("table.ui-jqgrid-htable thead",b.hDiv),j=this.p.colModel;if(b){g=a("<tr>",
{role:"rowheader"}).addClass("ui-jqgrid-labels");l=b.headers;b=0;for(i=l.length;b<i;b++){p=j[b].hidden?"none":"";p=a(l[b].el).width(l[b].width).removeAttr("rowSpan").css("display",p);g.append(p);d=p.children("span.ui-jqgrid-resize");if(d.length>0)d[0].style.height="";p.children("div")[0].style.top=""}a(f).children("tr.ui-jqgrid-labels").remove();a(f).prepend(g);c===true&&a(this).jqGrid("setGridParam",{groupHeader:null})}})},setGroupHeaders:function(c){c=a.extend({useColSpanStyle:false,groupHeaders:[]},
c||{});return this.each(function(){this.p.groupHeader=c;var g=this,b,i,l=0,p,d,f,j,e,h=g.p.colModel,n=h.length,o=g.grid.headers,k=a("table.ui-jqgrid-htable",g.grid.hDiv),t=k.children("thead").children("tr.ui-jqgrid-labels:last").addClass("jqg-second-row-header");p=k.children("thead");var m,q=k.find(".jqg-first-row-header");if(q.html()===null)q=a("<tr>",{role:"row","aria-hidden":"true"}).addClass("jqg-first-row-header").css("height","auto");else q.empty();var r,u=function(s,v){for(var w=0,x=v.length;w<
x;w++)if(v[w].startColumnName===s)return w;return-1};a(g).prepend(p);p=a("<tr>",{role:"rowheader"}).addClass("ui-jqgrid-labels jqg-third-row-header");for(b=0;b<n;b++){f=o[b].el;j=a(f);i=h[b];d={height:"0px",width:o[b].width+"px",display:i.hidden?"none":""};a("<th>",{role:"gridcell"}).css(d).addClass("ui-first-th-"+g.p.direction).appendTo(q);f.style.width="";d=u(i.name,c.groupHeaders);if(d>=0){d=c.groupHeaders[d];l=d.numberOfColumns;e=d.titleText;for(d=i=0;d<l&&b+d<n;d++)h[b+d].hidden||i++;d=a("<th>",
{colspan:String(i),role:"columnheader"}).addClass("ui-state-default ui-th-column-header ui-th-"+g.p.direction).css({height:"22px","border-top":"0px none"}).html(e);g.p.headertitles&&d.attr("title",d.text());i===0&&d.hide();j.before(d);p.append(f);l-=1}else if(l===0)if(c.useColSpanStyle)j.attr("rowspan","2");else{a("<th>",{role:"columnheader"}).addClass("ui-state-default ui-th-column-header ui-th-"+g.p.direction).css({display:i.hidden?"none":"","border-top":"0px none"}).insertBefore(j);p.append(f)}else{p.append(f);
l--}}h=a(g).children("thead");h.prepend(q);p.insertAfter(t);k.append(h);if(c.useColSpanStyle){k.find("span.ui-jqgrid-resize").each(function(){var s=a(this).parent();if(s.is(":visible"))this.style.cssText="height: "+s.height()+"px !important; cursor: col-resize;"});k.find("div.ui-jqgrid-sortable").each(function(){var s=a(this),v=s.parent();v.is(":visible")&&s.css("top",(v.height()-s.outerHeight())/2+"px")})}if(a.isFunction(g.p.resizeStop))m=g.p.resizeStop;r=h.find("tr.jqg-first-row-header");g.p.resizeStop=
function(s,v){r.find("th").eq(v).width(s);a.isFunction(m)&&m.call(g,s,v)}})}})})(jQuery);
(function(a){a.extend(a.jgrid,{showModal:function(b){b.w.show()},closeModal:function(b){b.w.hide().attr("aria-hidden","true");b.o&&b.o.remove()},hideModal:function(b,c){c=a.extend({jqm:true,gb:""},c||{});if(c.onClose){var d=c.onClose(b);if(typeof d=="boolean"&&!d)return}if(a.fn.jqm&&c.jqm===true)a(b).attr("aria-hidden","true").jqmHide();else{if(c.gb!=="")try{a(".jqgrid-overlay:first",c.gb).hide()}catch(f){}a(b).hide().attr("aria-hidden","true")}},findPos:function(b){var c=0,d=0;if(b.offsetParent){do{c+=
b.offsetLeft;d+=b.offsetTop}while(b=b.offsetParent)}return[c,d]},createModal:function(b,c,d,f,g,h,j){var e=document.createElement("div"),k,m=this;j=a.extend({},j||{});k=a(d.gbox).attr("dir")=="rtl"?true:false;e.className="ui-widget ui-widget-content ui-corner-all ui-jqdialog";e.id=b.themodal;var i=document.createElement("div");i.className="ui-jqdialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix";i.id=b.modalhead;a(i).append("<span class='ui-jqdialog-title'>"+d.caption+"</span>");var q=
a("<a href='javascript:void(0)' class='ui-jqdialog-titlebar-close ui-corner-all'></a>").hover(function(){q.addClass("ui-state-hover")},function(){q.removeClass("ui-state-hover")}).append("<span class='ui-icon ui-icon-closethick'></span>");a(i).append(q);if(k){e.dir="rtl";a(".ui-jqdialog-title",i).css("float","right");a(".ui-jqdialog-titlebar-close",i).css("left","0.3em")}else{e.dir="ltr";a(".ui-jqdialog-title",i).css("float","left");a(".ui-jqdialog-titlebar-close",i).css("right","0.3em")}var l=document.createElement("div");
a(l).addClass("ui-jqdialog-content ui-widget-content").attr("id",b.modalcontent);a(l).append(c);e.appendChild(l);a(e).prepend(i);if(h===true)a("body").append(e);else typeof h=="string"?a(h).append(e):a(e).insertBefore(f);a(e).css(j);if(typeof d.jqModal==="undefined")d.jqModal=true;c={};if(a.fn.jqm&&d.jqModal===true){if(d.left===0&&d.top===0&&d.overlay){j=[];j=this.findPos(g);d.left=j[0]+4;d.top=j[1]+4}c.top=d.top+"px";c.left=d.left}else if(d.left!==0||d.top!==0){c.left=d.left;c.top=d.top+"px"}a("a.ui-jqdialog-titlebar-close",
i).click(function(){var p=a("#"+b.themodal).data("onClose")||d.onClose,o=a("#"+b.themodal).data("gbox")||d.gbox;m.hideModal("#"+b.themodal,{gb:o,jqm:d.jqModal,onClose:p});return false});if(d.width===0||!d.width)d.width=300;if(d.height===0||!d.height)d.height=200;if(!d.zIndex){f=a(f).parents("*[role=dialog]").filter(":first").css("z-index");d.zIndex=f?parseInt(f,10)+1:950}f=0;if(k&&c.left&&!h){f=a(d.gbox).width()-(!isNaN(d.width)?parseInt(d.width,10):0)-8;c.left=parseInt(c.left,10)+parseInt(f,10)}if(c.left)c.left+=
"px";a(e).css(a.extend({width:isNaN(d.width)?"auto":d.width+"px",height:isNaN(d.height)?"auto":d.height+"px",zIndex:d.zIndex,overflow:"hidden"},c)).attr({tabIndex:"-1",role:"dialog","aria-labelledby":b.modalhead,"aria-hidden":"true"});if(typeof d.drag=="undefined")d.drag=true;if(typeof d.resize=="undefined")d.resize=true;if(d.drag){a(i).css("cursor","move");if(a.fn.jqDrag)a(e).jqDrag(i);else try{a(e).draggable({handle:a("#"+i.id)})}catch(n){}}if(d.resize)if(a.fn.jqResize){a(e).append("<div class='jqResize ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se ui-icon-grip-diagonal-se'></div>");
a("#"+b.themodal).jqResize(".jqResize",b.scrollelm?"#"+b.scrollelm:false)}else try{a(e).resizable({handles:"se, sw",alsoResize:b.scrollelm?"#"+b.scrollelm:false})}catch(r){}d.closeOnEscape===true&&a(e).keydown(function(p){if(p.which==27){p=a("#"+b.themodal).data("onClose")||d.onClose;m.hideModal(this,{gb:d.gbox,jqm:d.jqModal,onClose:p})}})},viewModal:function(b,c){c=a.extend({toTop:true,overlay:10,modal:false,overlayClass:"ui-widget-overlay",onShow:this.showModal,onHide:this.closeModal,gbox:"",jqm:true,
jqM:true},c||{});if(a.fn.jqm&&c.jqm===true)c.jqM?a(b).attr("aria-hidden","false").jqm(c).jqmShow():a(b).attr("aria-hidden","false").jqmShow();else{if(c.gbox!==""){a(".jqgrid-overlay:first",c.gbox).show();a(b).data("gbox",c.gbox)}a(b).show().attr("aria-hidden","false");try{a(":input:visible",b)[0].focus()}catch(d){}}},info_dialog:function(b,c,d,f){var g={width:290,height:"auto",dataheight:"auto",drag:true,resize:false,caption:"<b>"+b+"</b>",left:250,top:170,zIndex:1E3,jqModal:true,modal:false,closeOnEscape:true,
align:"center",buttonalign:"center",buttons:[]};a.extend(g,f||{});var h=g.jqModal,j=this;if(a.fn.jqm&&!h)h=false;b="";if(g.buttons.length>0)for(f=0;f<g.buttons.length;f++){if(typeof g.buttons[f].id=="undefined")g.buttons[f].id="info_button_"+f;b+="<a href='javascript:void(0)' id='"+g.buttons[f].id+"' class='fm-button ui-state-default ui-corner-all'>"+g.buttons[f].text+"</a>"}f=isNaN(g.dataheight)?g.dataheight:g.dataheight+"px";var e="<div id='info_id'>";e+="<div id='infocnt' style='margin:0px;padding-bottom:1em;width:100%;overflow:auto;position:relative;height:"+
f+";"+("text-align:"+g.align+";")+"'>"+c+"</div>";e+=d?"<div class='ui-widget-content ui-helper-clearfix' style='text-align:"+g.buttonalign+";padding-bottom:0.8em;padding-top:0.5em;background-image: none;border-width: 1px 0 0 0;'><a href='javascript:void(0)' id='closedialog' class='fm-button ui-state-default ui-corner-all'>"+d+"</a>"+b+"</div>":b!==""?"<div class='ui-widget-content ui-helper-clearfix' style='text-align:"+g.buttonalign+";padding-bottom:0.8em;padding-top:0.5em;background-image: none;border-width: 1px 0 0 0;'>"+
b+"</div>":"";e+="</div>";try{a("#info_dialog").attr("aria-hidden")=="false"&&this.hideModal("#info_dialog",{jqm:h});a("#info_dialog").remove()}catch(k){}this.createModal({themodal:"info_dialog",modalhead:"info_head",modalcontent:"info_content",scrollelm:"infocnt"},e,g,"","",true);b&&a.each(g.buttons,function(i){a("#"+this.id,"#info_id").bind("click",function(){g.buttons[i].onClick.call(a("#info_dialog"));return false})});a("#closedialog","#info_id").click(function(){j.hideModal("#info_dialog",{jqm:h});
return false});a(".fm-button","#info_dialog").hover(function(){a(this).addClass("ui-state-hover")},function(){a(this).removeClass("ui-state-hover")});a.isFunction(g.beforeOpen)&&g.beforeOpen();this.viewModal("#info_dialog",{onHide:function(i){i.w.hide().remove();i.o&&i.o.remove()},modal:g.modal,jqm:h});a.isFunction(g.afterOpen)&&g.afterOpen();try{a("#info_dialog").focus()}catch(m){}},createEl:function(b,c,d,f,g){function h(l,n){a.isFunction(n.dataInit)&&n.dataInit(l);n.dataEvents&&a.each(n.dataEvents,
function(){this.data!==undefined?a(l).bind(this.type,this.data,this.fn):a(l).bind(this.type,this.fn)});return n}function j(l,n,r){var p=["dataInit","dataEvents","dataUrl","buildSelect","sopt","searchhidden","defaultValue","attr"];if(typeof r!="undefined"&&a.isArray(r))p=a.extend(p,r);a.each(n,function(o,s){a.inArray(o,p)===-1&&a(l).attr(o,s)});n.hasOwnProperty("id")||a(l).attr("id",a.jgrid.randId())}var e="";switch(b){case "textarea":e=document.createElement("textarea");if(f)c.cols||a(e).css({width:"98%"});
else if(!c.cols)c.cols=20;if(!c.rows)c.rows=2;if(d=="&nbsp;"||d=="&#160;"||d.length==1&&d.charCodeAt(0)==160)d="";e.value=d;j(e,c);c=h(e,c);a(e).attr({role:"textbox",multiline:"true"});break;case "checkbox":e=document.createElement("input");e.type="checkbox";if(c.value){b=c.value.split(":");if(d===b[0]){e.checked=true;e.defaultChecked=true}e.value=b[0];a(e).attr("offval",b[1])}else{b=d.toLowerCase();if(b.search(/(false|0|no|off|undefined)/i)<0&&b!==""){e.checked=true;e.defaultChecked=true;e.value=
d}else e.value="on";a(e).attr("offval","off")}j(e,c,["value"]);c=h(e,c);a(e).attr("role","checkbox");break;case "select":e=document.createElement("select");e.setAttribute("role","select");f=[];if(c.multiple===true){b=true;e.multiple="multiple";a(e).attr("aria-multiselectable","true")}else b=false;if(typeof c.dataUrl!="undefined")a.ajax(a.extend({url:c.dataUrl,type:"GET",dataType:"html",context:{elem:e,options:c,vl:d},success:function(l){var n=[],r=this.elem,p=this.vl,o=a.extend({},this.options),s=
o.multiple===true;if(typeof o.buildSelect!="undefined")l=o.buildSelect(l);if(l=a(l).html()){a(r).append(l);j(r,o);o=h(r,o);if(typeof o.size==="undefined")o.size=s?3:1;if(s){n=p.split(",");n=a.map(n,function(t){return a.trim(t)})}else n[0]=a.trim(p);setTimeout(function(){a("option",r).each(function(){a(this).attr("role","option");if(a.inArray(a.trim(a(this).text()),n)>-1||a.inArray(a.trim(a(this).val()),n)>-1)this.selected="selected"})},0)}}},g||{}));else if(c.value){var k;if(typeof c.size==="undefined")c.size=
b?3:1;if(b){f=d.split(",");f=a.map(f,function(l){return a.trim(l)})}if(typeof c.value==="function")c.value=c.value();var m,i;if(typeof c.value==="string"){m=c.value.split(";");for(k=0;k<m.length;k++){i=m[k].split(":");if(i.length>2)i[1]=a.map(i,function(l,n){if(n>0)return l}).join(":");g=document.createElement("option");g.setAttribute("role","option");g.value=i[0];g.innerHTML=i[1];e.appendChild(g);if(!b&&(a.trim(i[0])==a.trim(d)||a.trim(i[1])==a.trim(d)))g.selected="selected";if(b&&(a.inArray(a.trim(i[1]),
f)>-1||a.inArray(a.trim(i[0]),f)>-1))g.selected="selected"}}else if(typeof c.value==="object"){m=c.value;for(k in m)if(m.hasOwnProperty(k)){g=document.createElement("option");g.setAttribute("role","option");g.value=k;g.innerHTML=m[k];e.appendChild(g);if(!b&&(a.trim(k)==a.trim(d)||a.trim(m[k])==a.trim(d)))g.selected="selected";if(b&&(a.inArray(a.trim(m[k]),f)>-1||a.inArray(a.trim(k),f)>-1))g.selected="selected"}}j(e,c,["value"]);c=h(e,c)}break;case "text":case "password":case "button":k=b=="button"?
"button":"textbox";e=document.createElement("input");e.type=b;e.value=d;j(e,c);c=h(e,c);if(b!="button")if(f)c.size||a(e).css({width:"98%"});else if(!c.size)c.size=20;a(e).attr("role",k);break;case "image":case "file":e=document.createElement("input");e.type=b;j(e,c);c=h(e,c);break;case "custom":e=document.createElement("span");try{if(a.isFunction(c.custom_element))if(m=c.custom_element.call(this,d,c)){m=a(m).addClass("customelement").attr({id:c.id,name:c.name});a(e).empty().append(m)}else throw"e2";
else throw"e1";}catch(q){q=="e1"&&this.info_dialog(a.jgrid.errors.errcap,"function 'custom_element' "+a.jgrid.edit.msg.nodefined,a.jgrid.edit.bClose);q=="e2"?this.info_dialog(a.jgrid.errors.errcap,"function 'custom_element' "+a.jgrid.edit.msg.novalue,a.jgrid.edit.bClose):this.info_dialog(a.jgrid.errors.errcap,typeof q==="string"?q:q.message,a.jgrid.edit.bClose)}}return e},checkDate:function(b,c){var d={},f;b=b.toLowerCase();f=b.indexOf("/")!=-1?"/":b.indexOf("-")!=-1?"-":b.indexOf(".")!=-1?".":"/";
b=b.split(f);c=c.split(f);if(c.length!=3)return false;f=-1;for(var g,h=-1,j=-1,e=0;e<b.length;e++){g=isNaN(c[e])?0:parseInt(c[e],10);d[b[e]]=g;g=b[e];if(g.indexOf("y")!=-1)f=e;if(g.indexOf("m")!=-1)j=e;if(g.indexOf("d")!=-1)h=e}g=b[f]=="y"||b[f]=="yyyy"?4:b[f]=="yy"?2:-1;e=function(m){for(var i=1;i<=m;i++){this[i]=31;if(i==4||i==6||i==9||i==11)this[i]=30;if(i==2)this[i]=29}return this}(12);var k;if(f===-1)return false;else{k=d[b[f]].toString();if(g==2&&k.length==1)g=1;if(k.length!=g||d[b[f]]===0&&
c[f]!="00")return false}if(j===-1)return false;else{k=d[b[j]].toString();if(k.length<1||d[b[j]]<1||d[b[j]]>12)return false}if(h===-1)return false;else{k=d[b[h]].toString();if(k.length<1||d[b[h]]<1||d[b[h]]>31||d[b[j]]==2&&d[b[h]]>(d[b[f]]%4===0&&(d[b[f]]%100!==0||d[b[f]]%400===0)?29:28)||d[b[h]]>e[d[b[j]]])return false}return true},isEmpty:function(b){return b.match(/^\s+$/)||b===""?true:false},checkTime:function(b){var c=/^(\d{1,2}):(\d{2})([ap]m)?$/;if(!this.isEmpty(b))if(b=b.match(c)){if(b[3]){if(b[1]<
1||b[1]>12)return false}else if(b[1]>23)return false;if(b[2]>59)return false}else return false;return true},checkValues:function(b,c,d,f,g){var h,j;if(typeof f==="undefined")if(typeof c=="string"){f=0;for(g=d.p.colModel.length;f<g;f++)if(d.p.colModel[f].name==c){h=d.p.colModel[f].editrules;c=f;try{j=d.p.colModel[f].formoptions.label}catch(e){}break}}else{if(c>=0)h=d.p.colModel[c].editrules}else{h=f;j=g===undefined?"_":g}if(h){j||(j=d.p.colNames[c]);if(h.required===true)if(this.isEmpty(b))return[false,
j+": "+a.jgrid.edit.msg.required,""];f=h.required===false?false:true;if(h.number===true)if(!(f===false&&this.isEmpty(b)))if(isNaN(b))return[false,j+": "+a.jgrid.edit.msg.number,""];if(typeof h.minValue!="undefined"&&!isNaN(h.minValue))if(parseFloat(b)<parseFloat(h.minValue))return[false,j+": "+a.jgrid.edit.msg.minValue+" "+h.minValue,""];if(typeof h.maxValue!="undefined"&&!isNaN(h.maxValue))if(parseFloat(b)>parseFloat(h.maxValue))return[false,j+": "+a.jgrid.edit.msg.maxValue+" "+h.maxValue,""];if(h.email===
true)if(!(f===false&&this.isEmpty(b))){g=/^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i;
if(!g.test(b))return[false,j+": "+a.jgrid.edit.msg.email,""]}if(h.integer===true)if(!(f===false&&this.isEmpty(b))){if(isNaN(b))return[false,j+": "+a.jgrid.edit.msg.integer,""];if(b%1!==0||b.indexOf(".")!=-1)return[false,j+": "+a.jgrid.edit.msg.integer,""]}if(h.date===true)if(!(f===false&&this.isEmpty(b))){c=d.p.colModel[c].formatoptions&&d.p.colModel[c].formatoptions.newformat?d.p.colModel[c].formatoptions.newformat:d.p.colModel[c].datefmt||"Y-m-d";if(!this.checkDate(c,b))return[false,j+": "+a.jgrid.edit.msg.date+
" - "+c,""]}if(h.time===true)if(!(f===false&&this.isEmpty(b)))if(!this.checkTime(b))return[false,j+": "+a.jgrid.edit.msg.date+" - hh:mm (am/pm)",""];if(h.url===true)if(!(f===false&&this.isEmpty(b))){g=/^(((https?)|(ftp)):\/\/([\-\w]+\.)+\w{2,3}(\/[%\-\w]+(\.\w{2,})?)*(([\w\-\.\?\\\/+@&#;`~=%!]*)(\.\w{2,})?)*\/?)/i;if(!g.test(b))return[false,j+": "+a.jgrid.edit.msg.url,""]}if(h.custom===true)if(!(f===false&&this.isEmpty(b)))if(a.isFunction(h.custom_func)){b=h.custom_func.call(d,b,j);return a.isArray(b)?
b:[false,a.jgrid.edit.msg.customarray,""]}else return[false,a.jgrid.edit.msg.customfcheck,""]}return[true,"",""]}})})(jQuery);
(function(a){var d={};a.jgrid.extend({searchGrid:function(f){f=a.extend({recreateFilter:false,drag:true,sField:"searchField",sValue:"searchString",sOper:"searchOper",sFilter:"filters",loadDefaults:true,beforeShowSearch:null,afterShowSearch:null,onInitializeSearch:null,afterRedraw:null,closeAfterSearch:false,closeAfterReset:false,closeOnEscape:false,multipleSearch:false,multipleGroup:false,top:0,left:0,jqModal:true,modal:false,resize:true,width:450,height:"auto",dataheight:"auto",showQuery:false,errorcheck:true,
sopt:null,stringResult:undefined,onClose:null,onSearch:null,onReset:null,toTop:true,overlay:30,columns:[],tmplNames:null,tmplFilters:null,tmplLabel:" Template: ",showOnLoad:false,layer:null},a.jgrid.search,f||{});return this.each(function(){function b(){if(a.isFunction(f.beforeShowSearch)){x=f.beforeShowSearch(a("#"+r));if(typeof x==="undefined")x=true}if(x){a.jgrid.viewModal("#"+D.themodal,{gbox:"#gbox_"+r,jqm:f.jqModal,modal:f.modal,overlay:f.overlay,toTop:f.toTop});a.isFunction(f.afterShowSearch)&&
f.afterShowSearch(a("#"+r))}}var e=this;if(e.grid){var r="fbox_"+e.p.id,x=true,D={themodal:"searchmod"+r,modalhead:"searchhd"+r,modalcontent:"searchcnt"+r,scrollelm:r},F=e.p.postData[f.sFilter];if(typeof F==="string")F=a.jgrid.parse(F);f.recreateFilter===true&&a("#"+D.themodal).remove();if(a("#"+D.themodal).html()!==null)b();else{var y=a("<div><div id='"+r+"' class='searchFilter' style='overflow:auto'></div></div>").insertBefore("#gview_"+e.p.id),o="left",k="";if(e.p.direction=="rtl"){o="right";k=
" style='text-align:left'";y.attr("dir","rtl")}if(a.isFunction(f.onInitializeSearch))f.onInitializeSearch(a("#"+r));var s=a.extend([],e.p.colModel),N="<a href='javascript:void(0)' id='"+r+"_search' class='fm-button ui-state-default ui-corner-all fm-button-icon-right ui-reset'><span class='ui-icon ui-icon-search'></span>"+f.Find+"</a>",c="<a href='javascript:void(0)' id='"+r+"_reset' class='fm-button ui-state-default ui-corner-all fm-button-icon-left ui-search'><span class='ui-icon ui-icon-arrowreturnthick-1-w'></span>"+
f.Reset+"</a>",t="",p="",j,n=false,G=-1;if(f.showQuery)t="<a href='javascript:void(0)' id='"+r+"_query' class='fm-button ui-state-default ui-corner-all fm-button-icon-left'><span class='ui-icon ui-icon-comment'></span>Query</a>";if(f.columns.length)s=f.columns;else a.each(s,function(u,E){if(!E.label)E.label=e.p.colNames[u];if(!n){var B=typeof E.search==="undefined"?true:E.search,m=E.hidden===true;if(E.searchoptions&&E.searchoptions.searchhidden===true&&B||B&&!m){n=true;j=E.index||E.name;G=u}}});if(!F&&
j||f.multipleSearch===false){var J="eq";if(G>=0&&s[G].searchoptions&&s[G].searchoptions.sopt)J=s[G].searchoptions.sopt[0];else if(f.sopt&&f.sopt.length)J=f.sopt[0];F={groupOp:"AND",rules:[{field:j,op:J,data:""}]}}n=false;if(f.tmplNames&&f.tmplNames.length){n=true;p=f.tmplLabel;p+="<select class='ui-template'>";p+="<option value='default'>Default</option>";a.each(f.tmplNames,function(u,E){p+="<option value='"+u+"'>"+E+"</option>"});p+="</select>"}o="<table class='EditTable' style='border:0px none;margin-top:5px' id='"+
r+"_2'><tbody><tr><td colspan='2'><hr class='ui-widget-content' style='margin:1px'/></td></tr><tr><td class='EditButton' style='text-align:"+o+"'>"+c+p+"</td><td class='EditButton' "+k+">"+t+N+"</td></tr></tbody></table>";a("#"+r).jqFilter({columns:s,filter:f.loadDefaults?F:null,showQuery:f.showQuery,errorcheck:f.errorcheck,sopt:f.sopt,groupButton:f.multipleGroup,ruleButtons:f.multipleSearch,afterRedraw:f.afterRedraw,_gridsopt:a.jgrid.search.odata,onChange:function(){this.p.showQuery&&a(".query",
this).html(this.toUserFriendlyString())},direction:e.p.direction});y.append(o);n&&f.tmplFilters&&f.tmplFilters.length&&a(".ui-template",y).bind("change",function(){var u=a(this).val();u=="default"?a("#"+r).jqFilter("addFilter",F):a("#"+r).jqFilter("addFilter",f.tmplFilters[parseInt(u,10)]);return false});if(f.multipleGroup===true)f.multipleSearch=true;if(a.isFunction(f.onInitializeSearch))f.onInitializeSearch(a("#"+r));f.gbox="#gbox_"+r;f.layer?a.jgrid.createModal(D,y,f,"#gview_"+e.p.id,a("#gbox_"+
e.p.id)[0],"#"+f.layer,{position:"relative"}):a.jgrid.createModal(D,y,f,"#gview_"+e.p.id,a("#gbox_"+e.p.id)[0]);t&&a("#"+r+"_query").bind("click",function(){a(".queryresult",y).toggle();return false});if(f.stringResult===undefined)f.stringResult=f.multipleSearch;a("#"+r+"_search").bind("click",function(){var u=a("#"+r),E={},B,m=u.jqFilter("filterData");if(f.errorcheck){u[0].hideError();f.showQuery||u.jqFilter("toSQLString");if(u[0].p.error){u[0].showError();return false}}if(f.stringResult){try{B=
xmlJsonClass.toJson(m,"","",false)}catch(z){try{B=JSON.stringify(m)}catch(h){}}if(typeof B==="string"){E[f.sFilter]=B;a.each([f.sField,f.sValue,f.sOper],function(){E[this]=""})}}else if(f.multipleSearch){E[f.sFilter]=m;a.each([f.sField,f.sValue,f.sOper],function(){E[this]=""})}else{E[f.sField]=m.rules[0].field;E[f.sValue]=m.rules[0].data;E[f.sOper]=m.rules[0].op;E[f.sFilter]=""}e.p.search=true;a.extend(e.p.postData,E);if(a.isFunction(f.onSearch))f.onSearch();a(e).trigger("reloadGrid",[{page:1}]);
f.closeAfterSearch&&a.jgrid.hideModal("#"+D.themodal,{gb:"#gbox_"+e.p.id,jqm:f.jqModal,onClose:f.onClose});return false});a("#"+r+"_reset").bind("click",function(){var u={},E=a("#"+r);e.p.search=false;if(f.multipleSearch===false)u[f.sField]=u[f.sValue]=u[f.sOper]="";else u[f.sFilter]="";E[0].resetFilter();n&&a(".ui-template",y).val("default");a.extend(e.p.postData,u);if(a.isFunction(f.onReset))f.onReset();a(e).trigger("reloadGrid",[{page:1}]);return false});b();a(".fm-button:not(.ui-state-disabled)",
y).hover(function(){a(this).addClass("ui-state-hover")},function(){a(this).removeClass("ui-state-hover")})}}})},editGridRow:function(f,b){b=a.extend({top:0,left:0,width:300,height:"auto",dataheight:"auto",modal:false,overlay:30,drag:true,resize:true,url:null,mtype:"POST",clearAfterAdd:true,closeAfterEdit:false,reloadAfterSubmit:true,onInitializeForm:null,beforeInitData:null,beforeShowForm:null,afterShowForm:null,beforeSubmit:null,afterSubmit:null,onclickSubmit:null,afterComplete:null,onclickPgButtons:null,
afterclickPgButtons:null,editData:{},recreateForm:false,jqModal:true,closeOnEscape:false,addedrow:"first",topinfo:"",bottominfo:"",saveicon:[],closeicon:[],savekey:[false,13],navkeys:[false,38,40],checkOnSubmit:false,checkOnUpdate:false,_savedData:{},processing:false,onClose:null,ajaxEditOptions:{},serializeEditData:null,viewPagerButtons:true},a.jgrid.edit,b||{});d[a(this)[0].p.id]=b;return this.each(function(){function e(){a("#"+j+" > tbody > tr > td > .FormElement").each(function(){var g=a(".customelement",
this);if(g.length){var l=a(g[0]).attr("name");a.each(c.p.colModel,function(){if(this.name===l&&this.editoptions&&a.isFunction(this.editoptions.custom_value)){try{h[l]=this.editoptions.custom_value(a("#"+a.jgrid.jqID(l),"#"+j),"get");if(h[l]===undefined)throw"e1";}catch(q){q==="e1"?a.jgrid.info_dialog(jQuery.jgrid.errors.errcap,"function 'custom_value' "+a.jgrid.edit.msg.novalue,jQuery.jgrid.edit.bClose):a.jgrid.info_dialog(jQuery.jgrid.errors.errcap,q.message,jQuery.jgrid.edit.bClose)}return true}})}else{switch(a(this).get(0).type){case "checkbox":if(a(this).is(":checked"))h[this.name]=
a(this).val();else{g=a(this).attr("offval");h[this.name]=g}break;case "select-one":h[this.name]=a("option:selected",this).val();P[this.name]=a("option:selected",this).text();break;case "select-multiple":h[this.name]=a(this).val();h[this.name]=h[this.name]?h[this.name].join(","):"";var w=[];a("option:selected",this).each(function(q,H){w[q]=a(H).text()});P[this.name]=w.join(",");break;case "password":case "text":case "textarea":case "button":h[this.name]=a(this).val()}if(c.p.autoencode)h[this.name]=
a.jgrid.htmlEncode(h[this.name])}});return true}function r(g,l,w,q){var H,C,v,K=0,A,Q,I,U=[],M=false,aa="",S;for(S=1;S<=q;S++)aa+="<td class='CaptionTD'>&#160;</td><td class='DataTD'>&#160;</td>";if(g!="_empty")M=a(l).jqGrid("getInd",g);a(l.p.colModel).each(function(T){H=this.name;Q=(C=this.editrules&&this.editrules.edithidden===true?false:this.hidden===true?true:false)?"style='display:none'":"";if(H!=="cb"&&H!=="subgrid"&&this.editable===true&&H!=="rn"){if(M===false)A="";else if(H==l.p.ExpandColumn&&
l.p.treeGrid===true)A=a("td:eq("+T+")",l.rows[M]).text();else{try{A=a.unformat(a("td:eq("+T+")",l.rows[M]),{rowId:g,colModel:this},T)}catch(ga){A=this.edittype&&this.edittype=="textarea"?a("td:eq("+T+")",l.rows[M]).text():a("td:eq("+T+")",l.rows[M]).html()}if(!A||A=="&nbsp;"||A=="&#160;"||A.length==1&&A.charCodeAt(0)==160)A=""}var Y=a.extend({},this.editoptions||{},{id:H,name:H}),Z=a.extend({},{elmprefix:"",elmsuffix:"",rowabove:false,rowcontent:""},this.formoptions||{}),ea=parseInt(Z.rowpos,10)||
K+1,ha=parseInt((parseInt(Z.colpos,10)||1)*2,10);if(g=="_empty"&&Y.defaultValue)A=a.isFunction(Y.defaultValue)?Y.defaultValue():Y.defaultValue;if(!this.edittype)this.edittype="text";if(c.p.autoencode)A=a.jgrid.htmlDecode(A);I=a.jgrid.createEl(this.edittype,Y,A,false,a.extend({},a.jgrid.ajaxOptions,l.p.ajaxSelectOptions||{}));if(A===""&&this.edittype=="checkbox")A=a(I).attr("offval");if(A===""&&this.edittype=="select")A=a("option:eq(0)",I).text();if(d[c.p.id].checkOnSubmit||d[c.p.id].checkOnUpdate)d[c.p.id]._savedData[H]=
A;a(I).addClass("FormElement");if(this.edittype=="text"||this.edittype=="textarea")a(I).addClass("ui-widget-content ui-corner-all");v=a(w).find("tr[rowpos="+ea+"]");if(Z.rowabove){Y=a("<tr><td class='contentinfo' colspan='"+q*2+"'>"+Z.rowcontent+"</td></tr>");a(w).append(Y);Y[0].rp=ea}if(v.length===0){v=a("<tr "+Q+" rowpos='"+ea+"'></tr>").addClass("FormData").attr("id","tr_"+H);a(v).append(aa);a(w).append(v);v[0].rp=ea}a("td:eq("+(ha-2)+")",v[0]).html(typeof Z.label==="undefined"?l.p.colNames[T]:
Z.label);a("td:eq("+(ha-1)+")",v[0]).append(Z.elmprefix).append(I).append(Z.elmsuffix);U[K]=T;K++}});if(K>0){S=a("<tr class='FormData' style='display:none'><td class='CaptionTD'></td><td colspan='"+(q*2-1)+"' class='DataTD'><input class='FormElement' id='id_g' type='text' name='"+l.p.id+"_id' value='"+g+"'/></td></tr>");S[0].rp=K+999;a(w).append(S);if(d[c.p.id].checkOnSubmit||d[c.p.id].checkOnUpdate)d[c.p.id]._savedData[l.p.id+"_id"]=g}return U}function x(g,l,w){var q,H=0,C,v,K,A,Q;if(d[c.p.id].checkOnSubmit||
d[c.p.id].checkOnUpdate){d[c.p.id]._savedData={};d[c.p.id]._savedData[l.p.id+"_id"]=g}var I=l.p.colModel;if(g=="_empty"){a(I).each(function(){q=this.name;K=a.extend({},this.editoptions||{});if((v=a("#"+a.jgrid.jqID(q),"#"+w))&&v.length&&v[0]!==null){A="";if(K.defaultValue){A=a.isFunction(K.defaultValue)?K.defaultValue():K.defaultValue;if(v[0].type=="checkbox"){Q=A.toLowerCase();if(Q.search(/(false|0|no|off|undefined)/i)<0&&Q!==""){v[0].checked=true;v[0].defaultChecked=true;v[0].value=A}else{v[0].checked=
false;v[0].defaultChecked=false}}else v.val(A)}else if(v[0].type=="checkbox"){v[0].checked=false;v[0].defaultChecked=false;A=a(v).attr("offval")}else if(v[0].type&&v[0].type.substr(0,6)=="select")v[0].selectedIndex=0;else v.val(A);if(d[c.p.id].checkOnSubmit===true||d[c.p.id].checkOnUpdate)d[c.p.id]._savedData[q]=A}});a("#id_g","#"+w).val(g)}else{var U=a(l).jqGrid("getInd",g,true);if(U){a("td",U).each(function(M){q=I[M].name;if(q!=="cb"&&q!=="subgrid"&&q!=="rn"&&I[M].editable===true){if(q==l.p.ExpandColumn&&
l.p.treeGrid===true)C=a(this).text();else try{C=a.unformat(a(this),{rowId:g,colModel:I[M]},M)}catch(aa){C=I[M].edittype=="textarea"?a(this).text():a(this).html()}if(c.p.autoencode)C=a.jgrid.htmlDecode(C);if(d[c.p.id].checkOnSubmit===true||d[c.p.id].checkOnUpdate)d[c.p.id]._savedData[q]=C;q=a.jgrid.jqID(q);switch(I[M].edittype){case "password":case "text":case "button":case "image":case "textarea":if(C=="&nbsp;"||C=="&#160;"||C.length==1&&C.charCodeAt(0)==160)C="";a("#"+q,"#"+w).val(C);break;case "select":var S=
C.split(",");S=a.map(S,function(ga){return a.trim(ga)});a("#"+q+" option","#"+w).each(function(){this.selected=!I[M].editoptions.multiple&&(a.trim(C)==a.trim(a(this).text())||S[0]==a.trim(a(this).text())||S[0]==a.trim(a(this).val()))?true:I[M].editoptions.multiple?a.inArray(a.trim(a(this).text()),S)>-1||a.inArray(a.trim(a(this).val()),S)>-1?true:false:false});break;case "checkbox":C+="";if(I[M].editoptions&&I[M].editoptions.value)if(I[M].editoptions.value.split(":")[0]==C){a("#"+q,"#"+w)[c.p.useProp?
"prop":"attr"]("checked",true);a("#"+q,"#"+w)[c.p.useProp?"prop":"attr"]("defaultChecked",true)}else{a("#"+q,"#"+w)[c.p.useProp?"prop":"attr"]("checked",false);a("#"+q,"#"+w)[c.p.useProp?"prop":"attr"]("defaultChecked",false)}else{C=C.toLowerCase();if(C.search(/(false|0|no|off|undefined)/i)<0&&C!==""){a("#"+q,"#"+w)[c.p.useProp?"prop":"attr"]("checked",true);a("#"+q,"#"+w)[c.p.useProp?"prop":"attr"]("defaultChecked",true)}else{a("#"+q,"#"+w)[c.p.useProp?"prop":"attr"]("checked",false);a("#"+q,"#"+
w)[c.p.useProp?"prop":"attr"]("defaultChecked",false)}}break;case "custom":try{if(I[M].editoptions&&a.isFunction(I[M].editoptions.custom_value))I[M].editoptions.custom_value(a("#"+q,"#"+w),"set",C);else throw"e1";}catch(T){T=="e1"?a.jgrid.info_dialog(jQuery.jgrid.errors.errcap,"function 'custom_value' "+a.jgrid.edit.msg.nodefined,jQuery.jgrid.edit.bClose):a.jgrid.info_dialog(jQuery.jgrid.errors.errcap,T.message,jQuery.jgrid.edit.bClose)}}H++}});H>0&&a("#id_g","#"+j).val(g)}}}function D(){var g,l=
[true,"",""],w={},q=c.p.prmNames,H,C,v,K;if(a.isFunction(d[c.p.id].beforeCheckValues)){var A=d[c.p.id].beforeCheckValues(h,a("#"+p),h[c.p.id+"_id"]=="_empty"?q.addoper:q.editoper);if(A&&typeof A==="object")h=A}for(v in h)if(h.hasOwnProperty(v)){l=a.jgrid.checkValues(h[v],v,c);if(l[0]===false)break}y();if(l[0]){if(a.isFunction(d[c.p.id].onclickSubmit))w=d[c.p.id].onclickSubmit(d[c.p.id],h)||{};if(a.isFunction(d[c.p.id].beforeSubmit))l=d[c.p.id].beforeSubmit(h,a("#"+p))}if(l[0]&&!d[c.p.id].processing){d[c.p.id].processing=
true;a("#sData","#"+j+"_2").addClass("ui-state-active");C=q.oper;H=q.id;h[C]=a.trim(h[c.p.id+"_id"])=="_empty"?q.addoper:q.editoper;if(h[C]!=q.addoper)h[H]=h[c.p.id+"_id"];else if(h[H]===undefined)h[H]=h[c.p.id+"_id"];delete h[c.p.id+"_id"];h=a.extend(h,d[c.p.id].editData,w);if(c.p.treeGrid===true){if(h[C]==q.addoper){K=a(c).jqGrid("getGridParam","selrow");h[c.p.treeGridModel=="adjacency"?c.p.treeReader.parent_id_field:"parent_id"]=K}for(i in c.p.treeReader){w=c.p.treeReader[i];if(h.hasOwnProperty(w))h[C]==
q.addoper&&i==="parent_id_field"||delete h[w]}}h[H]=a.jgrid.stripPref(c.p.idPrefix,h[H]);w=a.extend({url:d[c.p.id].url?d[c.p.id].url:a(c).jqGrid("getGridParam","editurl"),type:d[c.p.id].mtype,data:a.isFunction(d[c.p.id].serializeEditData)?d[c.p.id].serializeEditData(h):h,complete:function(Q,I){h[H]=c.p.idPrefix+h[H];if(I!="success"){l[0]=false;l[1]=a.isFunction(d[c.p.id].errorTextFormat)?d[c.p.id].errorTextFormat(Q):I+" Status: '"+Q.statusText+"'. Error code: "+Q.status}else if(a.isFunction(d[c.p.id].afterSubmit))l=
d[c.p.id].afterSubmit(Q,h);if(l[0]===false){a("#FormError>td","#"+j).html(l[1]);a("#FormError","#"+j).show()}else{a.each(c.p.colModel,function(){if(P[this.name]&&this.formatter&&this.formatter=="select")try{delete P[this.name]}catch(aa){}});h=a.extend(h,P);c.p.autoencode&&a.each(h,function(aa,S){h[aa]=a.jgrid.htmlDecode(S)});if(h[C]==q.addoper){l[2]||(l[2]=a.jgrid.randId());h[H]=l[2];if(d[c.p.id].closeAfterAdd){if(d[c.p.id].reloadAfterSubmit)a(c).trigger("reloadGrid");else if(c.p.treeGrid===true)a(c).jqGrid("addChildNode",
l[2],K,h);else{a(c).jqGrid("addRowData",l[2],h,b.addedrow);a(c).jqGrid("setSelection",l[2])}a.jgrid.hideModal("#"+n.themodal,{gb:"#gbox_"+t,jqm:b.jqModal,onClose:d[c.p.id].onClose})}else if(d[c.p.id].clearAfterAdd){if(d[c.p.id].reloadAfterSubmit)a(c).trigger("reloadGrid");else c.p.treeGrid===true?a(c).jqGrid("addChildNode",l[2],K,h):a(c).jqGrid("addRowData",l[2],h,b.addedrow);x("_empty",c,p)}else if(d[c.p.id].reloadAfterSubmit)a(c).trigger("reloadGrid");else c.p.treeGrid===true?a(c).jqGrid("addChildNode",
l[2],K,h):a(c).jqGrid("addRowData",l[2],h,b.addedrow)}else{if(d[c.p.id].reloadAfterSubmit){a(c).trigger("reloadGrid");d[c.p.id].closeAfterEdit||setTimeout(function(){a(c).jqGrid("setSelection",h[H])},1E3)}else c.p.treeGrid===true?a(c).jqGrid("setTreeRow",h[H],h):a(c).jqGrid("setRowData",h[H],h);d[c.p.id].closeAfterEdit&&a.jgrid.hideModal("#"+n.themodal,{gb:"#gbox_"+t,jqm:b.jqModal,onClose:d[c.p.id].onClose})}if(a.isFunction(d[c.p.id].afterComplete)){g=Q;setTimeout(function(){d[c.p.id].afterComplete(g,
h,a("#"+p));g=null},500)}if(d[c.p.id].checkOnSubmit||d[c.p.id].checkOnUpdate){a("#"+p).data("disabled",false);if(d[c.p.id]._savedData[c.p.id+"_id"]!="_empty")for(var U in d[c.p.id]._savedData)if(h[U])d[c.p.id]._savedData[U]=h[U]}}d[c.p.id].processing=false;a("#sData","#"+j+"_2").removeClass("ui-state-active");try{a(":input:visible","#"+p)[0].focus()}catch(M){}}},a.jgrid.ajaxOptions,d[c.p.id].ajaxEditOptions);if(!w.url&&!d[c.p.id].useDataProxy)if(a.isFunction(c.p.dataProxy))d[c.p.id].useDataProxy=
true;else{l[0]=false;l[1]+=" "+a.jgrid.errors.nourl}if(l[0])if(d[c.p.id].useDataProxy){v=c.p.dataProxy.call(c,w,"set_"+c.p.id);if(typeof v=="undefined")v=[true,""];if(v[0]===false){l[0]=false;l[1]=v[1]||"Error deleting the selected row!"}else{w.data.oper==q.addoper&&d[c.p.id].closeAfterAdd&&a.jgrid.hideModal("#"+n.themodal,{gb:"#gbox_"+t,jqm:b.jqModal,onClose:d[c.p.id].onClose});w.data.oper==q.editoper&&d[c.p.id].closeAfterEdit&&a.jgrid.hideModal("#"+n.themodal,{gb:"#gbox_"+t,jqm:b.jqModal,onClose:d[c.p.id].onClose})}}else a.ajax(w)}if(l[0]===
false){a("#FormError>td","#"+j).html(l[1]);a("#FormError","#"+j).show()}}function F(g,l){var w=false,q;for(q in g)if(g[q]!=l[q]){w=true;break}return w}function y(){a.each(c.p.colModel,function(g,l){if(l.editoptions&&l.editoptions.NullIfEmpty===true)if(h.hasOwnProperty(l.name)&&h[l.name]=="")h[l.name]="null"})}function o(){var g=true;a("#FormError","#"+j).hide();if(d[c.p.id].checkOnUpdate){h={};P={};e();O=a.extend({},h,P);if(V=F(O,d[c.p.id]._savedData)){a("#"+p).data("disabled",true);a(".confirm",
"#"+n.themodal).show();g=false}}return g}function k(){if(f!=="_empty"&&typeof c.p.savedRow!=="undefined"&&c.p.savedRow.length>0&&a.isFunction(a.fn.jqGrid.restoreRow))for(var g=0;g<c.p.savedRow.length;g++)if(c.p.savedRow[g].id==f){a(c).jqGrid("restoreRow",f);break}}function s(g,l){g===0?a("#pData","#"+j+"_2").addClass("ui-state-disabled"):a("#pData","#"+j+"_2").removeClass("ui-state-disabled");g==l?a("#nData","#"+j+"_2").addClass("ui-state-disabled"):a("#nData","#"+j+"_2").removeClass("ui-state-disabled")}
function N(){var g=a(c).jqGrid("getDataIDs"),l=a("#id_g","#"+j).val();return[a.inArray(l,g),g]}var c=this;if(c.grid&&f){var t=c.p.id,p="FrmGrid_"+t,j="TblGrid_"+t,n={themodal:"editmod"+t,modalhead:"edithd"+t,modalcontent:"editcnt"+t,scrollelm:p},G=a.isFunction(d[c.p.id].beforeShowForm)?d[c.p.id].beforeShowForm:false,J=a.isFunction(d[c.p.id].afterShowForm)?d[c.p.id].afterShowForm:false,u=a.isFunction(d[c.p.id].beforeInitData)?d[c.p.id].beforeInitData:false,E=a.isFunction(d[c.p.id].onInitializeForm)?
d[c.p.id].onInitializeForm:false,B=true,m=1,z=0,h,P,O,V;if(f==="new"){f="_empty";b.caption=d[c.p.id].addCaption}else b.caption=d[c.p.id].editCaption;b.recreateForm===true&&a("#"+n.themodal).html()!==null&&a("#"+n.themodal).remove();var R=true;if(b.checkOnUpdate&&b.jqModal&&!b.modal)R=false;if(a("#"+n.themodal).html()!==null){if(u){B=u(a("#"+p));if(typeof B=="undefined")B=true}if(B===false)return;k();a(".ui-jqdialog-title","#"+n.modalhead).html(b.caption);a("#FormError","#"+j).hide();if(d[c.p.id].topinfo){a(".topinfo",
"#"+j).html(d[c.p.id].topinfo);a(".tinfo","#"+j).show()}else a(".tinfo","#"+j).hide();if(d[c.p.id].bottominfo){a(".bottominfo","#"+j+"_2").html(d[c.p.id].bottominfo);a(".binfo","#"+j+"_2").show()}else a(".binfo","#"+j+"_2").hide();x(f,c,p);f=="_empty"||!d[c.p.id].viewPagerButtons?a("#pData, #nData","#"+j+"_2").hide():a("#pData, #nData","#"+j+"_2").show();if(d[c.p.id].processing===true){d[c.p.id].processing=false;a("#sData","#"+j+"_2").removeClass("ui-state-active")}if(a("#"+p).data("disabled")===
true){a(".confirm","#"+n.themodal).hide();a("#"+p).data("disabled",false)}G&&G(a("#"+p));a("#"+n.themodal).data("onClose",d[c.p.id].onClose);a.jgrid.viewModal("#"+n.themodal,{gbox:"#gbox_"+t,jqm:b.jqModal,jqM:false,overlay:b.overlay,modal:b.modal});R||a(".jqmOverlay").click(function(){if(!o())return false;a.jgrid.hideModal("#"+n.themodal,{gb:"#gbox_"+t,jqm:b.jqModal,onClose:d[c.p.id].onClose});return false});J&&J(a("#"+p))}else{var L=isNaN(b.dataheight)?b.dataheight:b.dataheight+"px";L=a("<form name='FormPost' id='"+
p+"' class='FormGrid' onSubmit='return false;' style='width:100%;overflow:auto;position:relative;height:"+L+";'></form>").data("disabled",false);var W=a("<table id='"+j+"' class='EditTable' cellspacing='0' cellpadding='0' border='0'><tbody></tbody></table>");if(u){B=u(a("#"+p));if(typeof B=="undefined")B=true}if(B===false)return;k();a(c.p.colModel).each(function(){var g=this.formoptions;m=Math.max(m,g?g.colpos||0:0);z=Math.max(z,g?g.rowpos||0:0)});a(L).append(W);u=a("<tr id='FormError' style='display:none'><td class='ui-state-error' colspan='"+
m*2+"'></td></tr>");u[0].rp=0;a(W).append(u);u=a("<tr style='display:none' class='tinfo'><td class='topinfo' colspan='"+m*2+"'>"+d[c.p.id].topinfo+"</td></tr>");u[0].rp=0;a(W).append(u);B=(u=c.p.direction=="rtl"?true:false)?"nData":"pData";var X=u?"pData":"nData";r(f,c,W,m);B="<a href='javascript:void(0)' id='"+B+"' class='fm-button ui-state-default ui-corner-left'><span class='ui-icon ui-icon-triangle-1-w'></span></a>";X="<a href='javascript:void(0)' id='"+X+"' class='fm-button ui-state-default ui-corner-right'><span class='ui-icon ui-icon-triangle-1-e'></span></a>";
var ba="<a href='javascript:void(0)' id='sData' class='fm-button ui-state-default ui-corner-all'>"+b.bSubmit+"</a>",$="<a href='javascript:void(0)' id='cData' class='fm-button ui-state-default ui-corner-all'>"+b.bCancel+"</a>";B="<table border='0' cellspacing='0' cellpadding='0' class='EditTable' id='"+j+"_2'><tbody><tr><td colspan='2'><hr class='ui-widget-content' style='margin:1px'/></td></tr><tr id='Act_Buttons'><td class='navButton'>"+(u?X+B:B+X)+"</td><td class='EditButton'>"+ba+$+"</td></tr>";
B+="<tr style='display:none' class='binfo'><td class='bottominfo' colspan='2'>"+d[c.p.id].bottominfo+"</td></tr>";B+="</tbody></table>";if(z>0){var ca=[],da={};a.each(a(W)[0].rows,function(g,l){ca[g]=l});ca.sort(function(g,l){if(g.rp>l.rp)return 1;if(g.rp<l.rp)return-1;return 0});a.each(ca,function(g,l){da.html+=l});a("tbody",W).append(da.html)}b.gbox="#gbox_"+t;var fa=false;if(b.closeOnEscape===true){b.closeOnEscape=false;fa=true}L=a("<span></span>").append(L).append(B);a.jgrid.createModal(n,L,b,
"#gview_"+c.p.id,a("#gbox_"+c.p.id)[0]);if(u){a("#pData, #nData","#"+j+"_2").css("float","right");a(".EditButton","#"+j+"_2").css("text-align","left")}d[c.p.id].topinfo&&a(".tinfo","#"+j).show();d[c.p.id].bottominfo&&a(".binfo","#"+j+"_2").show();B=L=null;a("#"+n.themodal).keydown(function(g){var l=g.target;if(a("#"+p).data("disabled")===true)return false;if(d[c.p.id].savekey[0]===true&&g.which==d[c.p.id].savekey[1])if(l.tagName!="TEXTAREA"){a("#sData","#"+j+"_2").trigger("click");return false}if(g.which===
27){if(!o())return false;fa&&a.jgrid.hideModal(this,{gb:b.gbox,jqm:b.jqModal,onClose:d[c.p.id].onClose});return false}if(d[c.p.id].navkeys[0]===true){if(a("#id_g","#"+j).val()=="_empty")return true;if(g.which==d[c.p.id].navkeys[1]){a("#pData","#"+j+"_2").trigger("click");return false}if(g.which==d[c.p.id].navkeys[2]){a("#nData","#"+j+"_2").trigger("click");return false}}});if(b.checkOnUpdate){a("a.ui-jqdialog-titlebar-close span","#"+n.themodal).removeClass("jqmClose");a("a.ui-jqdialog-titlebar-close",
"#"+n.themodal).unbind("click").click(function(){if(!o())return false;a.jgrid.hideModal("#"+n.themodal,{gb:"#gbox_"+t,jqm:b.jqModal,onClose:d[c.p.id].onClose});return false})}b.saveicon=a.extend([true,"left","ui-icon-disk"],b.saveicon);b.closeicon=a.extend([true,"left","ui-icon-close"],b.closeicon);if(b.saveicon[0]===true)a("#sData","#"+j+"_2").addClass(b.saveicon[1]=="right"?"fm-button-icon-right":"fm-button-icon-left").append("<span class='ui-icon "+b.saveicon[2]+"'></span>");if(b.closeicon[0]===
true)a("#cData","#"+j+"_2").addClass(b.closeicon[1]=="right"?"fm-button-icon-right":"fm-button-icon-left").append("<span class='ui-icon "+b.closeicon[2]+"'></span>");if(d[c.p.id].checkOnSubmit||d[c.p.id].checkOnUpdate){ba="<a href='javascript:void(0)' id='sNew' class='fm-button ui-state-default ui-corner-all' style='z-index:1002'>"+b.bYes+"</a>";X="<a href='javascript:void(0)' id='nNew' class='fm-button ui-state-default ui-corner-all' style='z-index:1002'>"+b.bNo+"</a>";$="<a href='javascript:void(0)' id='cNew' class='fm-button ui-state-default ui-corner-all' style='z-index:1002'>"+
b.bExit+"</a>";L=b.zIndex||999;L++;a("<div class='ui-widget-overlay jqgrid-overlay confirm' style='z-index:"+L+";display:none;'>&#160;"+(a.browser.msie&&a.browser.version==6?'<iframe style="display:block;position:absolute;z-index:-1;filter:Alpha(Opacity=\'0\');" src="javascript:false;"></iframe>':"")+"</div><div class='confirm ui-widget-content ui-jqconfirm' style='z-index:"+(L+1)+"'>"+b.saveData+"<br/><br/>"+ba+X+$+"</div>").insertAfter("#"+p);a("#sNew","#"+n.themodal).click(function(){D();a("#"+
p).data("disabled",false);a(".confirm","#"+n.themodal).hide();return false});a("#nNew","#"+n.themodal).click(function(){a(".confirm","#"+n.themodal).hide();a("#"+p).data("disabled",false);setTimeout(function(){a(":input","#"+p)[0].focus()},0);return false});a("#cNew","#"+n.themodal).click(function(){a(".confirm","#"+n.themodal).hide();a("#"+p).data("disabled",false);a.jgrid.hideModal("#"+n.themodal,{gb:"#gbox_"+t,jqm:b.jqModal,onClose:d[c.p.id].onClose});return false})}E&&E(a("#"+p));f=="_empty"||
!d[c.p.id].viewPagerButtons?a("#pData,#nData","#"+j+"_2").hide():a("#pData,#nData","#"+j+"_2").show();G&&G(a("#"+p));a("#"+n.themodal).data("onClose",d[c.p.id].onClose);a.jgrid.viewModal("#"+n.themodal,{gbox:"#gbox_"+t,jqm:b.jqModal,overlay:b.overlay,modal:b.modal});R||a(".jqmOverlay").click(function(){if(!o())return false;a.jgrid.hideModal("#"+n.themodal,{gb:"#gbox_"+t,jqm:b.jqModal,onClose:d[c.p.id].onClose});return false});J&&J(a("#"+p));a(".fm-button","#"+n.themodal).hover(function(){a(this).addClass("ui-state-hover")},
function(){a(this).removeClass("ui-state-hover")});a("#sData","#"+j+"_2").click(function(){h={};P={};a("#FormError","#"+j).hide();e();if(h[c.p.id+"_id"]=="_empty")D();else if(b.checkOnSubmit===true){O=a.extend({},h,P);if(V=F(O,d[c.p.id]._savedData)){a("#"+p).data("disabled",true);a(".confirm","#"+n.themodal).show()}else D()}else D();return false});a("#cData","#"+j+"_2").click(function(){if(!o())return false;a.jgrid.hideModal("#"+n.themodal,{gb:"#gbox_"+t,jqm:b.jqModal,onClose:d[c.p.id].onClose});
return false});a("#nData","#"+j+"_2").click(function(){if(!o())return false;a("#FormError","#"+j).hide();var g=N();g[0]=parseInt(g[0],10);if(g[0]!=-1&&g[1][g[0]+1]){if(a.isFunction(b.onclickPgButtons))b.onclickPgButtons("next",a("#"+p),g[1][g[0]]);x(g[1][g[0]+1],c,p);a(c).jqGrid("setSelection",g[1][g[0]+1]);a.isFunction(b.afterclickPgButtons)&&b.afterclickPgButtons("next",a("#"+p),g[1][g[0]+1]);s(g[0]+1,g[1].length-1)}return false});a("#pData","#"+j+"_2").click(function(){if(!o())return false;a("#FormError",
"#"+j).hide();var g=N();if(g[0]!=-1&&g[1][g[0]-1]){if(a.isFunction(b.onclickPgButtons))b.onclickPgButtons("prev",a("#"+p),g[1][g[0]]);x(g[1][g[0]-1],c,p);a(c).jqGrid("setSelection",g[1][g[0]-1]);a.isFunction(b.afterclickPgButtons)&&b.afterclickPgButtons("prev",a("#"+p),g[1][g[0]-1]);s(g[0]-1,g[1].length-1)}return false})}G=N();s(G[0],G[1].length-1)}})},viewGridRow:function(f,b){b=a.extend({top:0,left:0,width:0,height:"auto",dataheight:"auto",modal:false,overlay:30,drag:true,resize:true,jqModal:true,
closeOnEscape:false,labelswidth:"30%",closeicon:[],navkeys:[false,38,40],onClose:null,beforeShowForm:null,beforeInitData:null,viewPagerButtons:true},a.jgrid.view,b||{});return this.each(function(){function e(){if(b.closeOnEscape===true||b.navkeys[0]===true)setTimeout(function(){a(".ui-jqdialog-titlebar-close","#"+N.modalhead).focus()},0)}function r(m,z,h,P){for(var O,V,R,L=0,W,X,ba=[],$=false,ca="<td class='CaptionTD form-view-label ui-widget-content' width='"+b.labelswidth+"'>&#160;</td><td class='DataTD form-view-data ui-helper-reset ui-widget-content'>&#160;</td>",
da="",fa=["integer","number","currency"],g=0,l=0,w,q,H,C=1;C<=P;C++)da+=C==1?ca:"<td class='CaptionTD form-view-label ui-widget-content'>&#160;</td><td class='DataTD form-view-data ui-widget-content'>&#160;</td>";a(z.p.colModel).each(function(){V=this.editrules&&this.editrules.edithidden===true?false:this.hidden===true?true:false;if(!V&&this.align==="right")if(this.formatter&&a.inArray(this.formatter,fa)!==-1)g=Math.max(g,parseInt(this.width,10));else l=Math.max(l,parseInt(this.width,10))});w=g!==
0?g:l!==0?l:0;$=a(z).jqGrid("getInd",m);a(z.p.colModel).each(function(v){O=this.name;q=false;X=(V=this.editrules&&this.editrules.edithidden===true?false:this.hidden===true?true:false)?"style='display:none'":"";H=typeof this.viewable!="boolean"?true:this.viewable;if(O!=="cb"&&O!=="subgrid"&&O!=="rn"&&H){W=$===false?"":O==z.p.ExpandColumn&&z.p.treeGrid===true?a("td:eq("+v+")",z.rows[$]).text():a("td:eq("+v+")",z.rows[$]).html();q=this.align==="right"&&w!==0?true:false;a.extend({},this.editoptions||
{},{id:O,name:O});var K=a.extend({},{rowabove:false,rowcontent:""},this.formoptions||{}),A=parseInt(K.rowpos,10)||L+1,Q=parseInt((parseInt(K.colpos,10)||1)*2,10);if(K.rowabove){var I=a("<tr><td class='contentinfo' colspan='"+P*2+"'>"+K.rowcontent+"</td></tr>");a(h).append(I);I[0].rp=A}R=a(h).find("tr[rowpos="+A+"]");if(R.length===0){R=a("<tr "+X+" rowpos='"+A+"'></tr>").addClass("FormData").attr("id","trv_"+O);a(R).append(da);a(h).append(R);R[0].rp=A}a("td:eq("+(Q-2)+")",R[0]).html("<b>"+(typeof K.label===
"undefined"?z.p.colNames[v]:K.label)+"</b>");a("td:eq("+(Q-1)+")",R[0]).append("<span>"+W+"</span>").attr("id","v_"+O);q&&a("td:eq("+(Q-1)+") span",R[0]).css({"text-align":"right",width:w+"px"});ba[L]=v;L++}});if(L>0){m=a("<tr class='FormData' style='display:none'><td class='CaptionTD'></td><td colspan='"+(P*2-1)+"' class='DataTD'><input class='FormElement' id='id_g' type='text' name='id' value='"+m+"'/></td></tr>");m[0].rp=L+99;a(h).append(m)}return ba}function x(m,z){var h,P,O=0,V,R;if(R=a(z).jqGrid("getInd",
m,true)){a("td",R).each(function(L){h=z.p.colModel[L].name;P=z.p.colModel[L].editrules&&z.p.colModel[L].editrules.edithidden===true?false:z.p.colModel[L].hidden===true?true:false;if(h!=="cb"&&h!=="subgrid"&&h!=="rn"){V=h==z.p.ExpandColumn&&z.p.treeGrid===true?a(this).text():a(this).html();a.extend({},z.p.colModel[L].editoptions||{});h=a.jgrid.jqID("v_"+h);a("#"+h+" span","#"+s).html(V);P&&a("#"+h,"#"+s).parents("tr:first").hide();O++}});O>0&&a("#id_g","#"+s).val(m)}}function D(m,z){m===0?a("#pData",
"#"+s+"_2").addClass("ui-state-disabled"):a("#pData","#"+s+"_2").removeClass("ui-state-disabled");m==z?a("#nData","#"+s+"_2").addClass("ui-state-disabled"):a("#nData","#"+s+"_2").removeClass("ui-state-disabled")}function F(){var m=a(y).jqGrid("getDataIDs"),z=a("#id_g","#"+s).val();return[a.inArray(z,m),m]}var y=this;if(y.grid&&f){var o=y.p.id,k="ViewGrid_"+o,s="ViewTbl_"+o,N={themodal:"viewmod"+o,modalhead:"viewhd"+o,modalcontent:"viewcnt"+o,scrollelm:k},c=a.isFunction(b.beforeInitData)?b.beforeInitData:
false,t=true,p=1,j=0;if(a("#"+N.themodal).html()!==null){if(c){t=c(a("#"+k));if(typeof t=="undefined")t=true}if(t===false)return;a(".ui-jqdialog-title","#"+N.modalhead).html(b.caption);a("#FormError","#"+s).hide();x(f,y);a.isFunction(b.beforeShowForm)&&b.beforeShowForm(a("#"+k));a.jgrid.viewModal("#"+N.themodal,{gbox:"#gbox_"+o,jqm:b.jqModal,jqM:false,overlay:b.overlay,modal:b.modal});e()}else{var n=isNaN(b.dataheight)?b.dataheight:b.dataheight+"px";n=a("<form name='FormPost' id='"+k+"' class='FormGrid' style='width:100%;overflow:auto;position:relative;height:"+
n+";'></form>");var G=a("<table id='"+s+"' class='EditTable' cellspacing='1' cellpadding='2' border='0' style='table-layout:fixed'><tbody></tbody></table>");if(c){t=c(a("#"+k));if(typeof t=="undefined")t=true}if(t===false)return;a(y.p.colModel).each(function(){var m=this.formoptions;p=Math.max(p,m?m.colpos||0:0);j=Math.max(j,m?m.rowpos||0:0)});a(n).append(G);r(f,y,G,p);c=y.p.direction=="rtl"?true:false;t="<a href='javascript:void(0)' id='"+(c?"nData":"pData")+"' class='fm-button ui-state-default ui-corner-left'><span class='ui-icon ui-icon-triangle-1-w'></span></a>";
var J="<a href='javascript:void(0)' id='"+(c?"pData":"nData")+"' class='fm-button ui-state-default ui-corner-right'><span class='ui-icon ui-icon-triangle-1-e'></span></a>",u="<a href='javascript:void(0)' id='cData' class='fm-button ui-state-default ui-corner-all'>"+b.bClose+"</a>";if(j>0){var E=[];a.each(a(G)[0].rows,function(m,z){E[m]=z});E.sort(function(m,z){if(m.rp>z.rp)return 1;if(m.rp<z.rp)return-1;return 0});a.each(E,function(m,z){a("tbody",G).append(z)})}b.gbox="#gbox_"+o;var B=false;if(b.closeOnEscape===
true){b.closeOnEscape=false;B=true}n=a("<span></span>").append(n).append("<table border='0' class='EditTable' id='"+s+"_2'><tbody><tr id='Act_Buttons'><td class='navButton' width='"+b.labelswidth+"'>"+(c?J+t:t+J)+"</td><td class='EditButton'>"+u+"</td></tr></tbody></table>");a.jgrid.createModal(N,n,b,"#gview_"+y.p.id,a("#gview_"+y.p.id)[0]);if(c){a("#pData, #nData","#"+s+"_2").css("float","right");a(".EditButton","#"+s+"_2").css("text-align","left")}b.viewPagerButtons||a("#pData, #nData","#"+s+"_2").hide();
n=null;a("#"+N.themodal).keydown(function(m){if(m.which===27){B&&a.jgrid.hideModal(this,{gb:b.gbox,jqm:b.jqModal,onClose:b.onClose});return false}if(b.navkeys[0]===true){if(m.which===b.navkeys[1]){a("#pData","#"+s+"_2").trigger("click");return false}if(m.which===b.navkeys[2]){a("#nData","#"+s+"_2").trigger("click");return false}}});b.closeicon=a.extend([true,"left","ui-icon-close"],b.closeicon);if(b.closeicon[0]===true)a("#cData","#"+s+"_2").addClass(b.closeicon[1]=="right"?"fm-button-icon-right":
"fm-button-icon-left").append("<span class='ui-icon "+b.closeicon[2]+"'></span>");a.isFunction(b.beforeShowForm)&&b.beforeShowForm(a("#"+k));a.jgrid.viewModal("#"+N.themodal,{gbox:"#gbox_"+o,jqm:b.jqModal,modal:b.modal});a(".fm-button:not(.ui-state-disabled)","#"+s+"_2").hover(function(){a(this).addClass("ui-state-hover")},function(){a(this).removeClass("ui-state-hover")});e();a("#cData","#"+s+"_2").click(function(){a.jgrid.hideModal("#"+N.themodal,{gb:"#gbox_"+o,jqm:b.jqModal,onClose:b.onClose});
return false});a("#nData","#"+s+"_2").click(function(){a("#FormError","#"+s).hide();var m=F();m[0]=parseInt(m[0],10);if(m[0]!=-1&&m[1][m[0]+1]){if(a.isFunction(b.onclickPgButtons))b.onclickPgButtons("next",a("#"+k),m[1][m[0]]);x(m[1][m[0]+1],y);a(y).jqGrid("setSelection",m[1][m[0]+1]);a.isFunction(b.afterclickPgButtons)&&b.afterclickPgButtons("next",a("#"+k),m[1][m[0]+1]);D(m[0]+1,m[1].length-1)}e();return false});a("#pData","#"+s+"_2").click(function(){a("#FormError","#"+s).hide();var m=F();if(m[0]!=
-1&&m[1][m[0]-1]){if(a.isFunction(b.onclickPgButtons))b.onclickPgButtons("prev",a("#"+k),m[1][m[0]]);x(m[1][m[0]-1],y);a(y).jqGrid("setSelection",m[1][m[0]-1]);a.isFunction(b.afterclickPgButtons)&&b.afterclickPgButtons("prev",a("#"+k),m[1][m[0]-1]);D(m[0]-1,m[1].length-1)}e();return false})}n=F();D(n[0],n[1].length-1)}})},delGridRow:function(f,b){b=a.extend({top:0,left:0,width:240,height:"auto",dataheight:"auto",modal:false,overlay:30,drag:true,resize:true,url:"",mtype:"POST",reloadAfterSubmit:true,
beforeShowForm:null,beforeInitData:null,afterShowForm:null,beforeSubmit:null,onclickSubmit:null,afterSubmit:null,jqModal:true,closeOnEscape:false,delData:{},delicon:[],cancelicon:[],onClose:null,ajaxDelOptions:{},processing:false,serializeDelData:null,useDataProxy:false},a.jgrid.del,b||{});d[a(this)[0].p.id]=b;return this.each(function(){var e=this;if(e.grid)if(f){var r=a.isFunction(d[e.p.id].beforeShowForm),x=a.isFunction(d[e.p.id].afterShowForm),D=a.isFunction(d[e.p.id].beforeInitData)?d[e.p.id].beforeInitData:
false,F=e.p.id,y={},o=true,k="DelTbl_"+F,s,N,c,t,p={themodal:"delmod"+F,modalhead:"delhd"+F,modalcontent:"delcnt"+F,scrollelm:k};if(jQuery.isArray(f))f=f.join();if(a("#"+p.themodal).html()!==null){if(D){o=D(a("#"+k));if(typeof o=="undefined")o=true}if(o===false)return;a("#DelData>td","#"+k).text(f);a("#DelError","#"+k).hide();if(d[e.p.id].processing===true){d[e.p.id].processing=false;a("#dData","#"+k).removeClass("ui-state-active")}r&&d[e.p.id].beforeShowForm(a("#"+k));a.jgrid.viewModal("#"+p.themodal,
{gbox:"#gbox_"+F,jqm:d[e.p.id].jqModal,jqM:false,overlay:d[e.p.id].overlay,modal:d[e.p.id].modal})}else{var j=isNaN(d[e.p.id].dataheight)?d[e.p.id].dataheight:d[e.p.id].dataheight+"px";j="<div id='"+k+"' class='formdata' style='width:100%;overflow:auto;position:relative;height:"+j+";'>";j+="<table class='DelTable'><tbody>";j+="<tr id='DelError' style='display:none'><td class='ui-state-error'></td></tr>";j+="<tr id='DelData' style='display:none'><td >"+f+"</td></tr>";j+='<tr><td class="delmsg" style="white-space:pre;">'+
d[e.p.id].msg+"</td></tr><tr><td >&#160;</td></tr>";j+="</tbody></table></div>";j+="<table cellspacing='0' cellpadding='0' border='0' class='EditTable' id='"+k+"_2'><tbody><tr><td><hr class='ui-widget-content' style='margin:1px'/></td></tr><tr><td class='DelButton EditButton'>"+("<a href='javascript:void(0)' id='dData' class='fm-button ui-state-default ui-corner-all'>"+b.bSubmit+"</a>")+"&#160;"+("<a href='javascript:void(0)' id='eData' class='fm-button ui-state-default ui-corner-all'>"+b.bCancel+
"</a>")+"</td></tr></tbody></table>";b.gbox="#gbox_"+F;a.jgrid.createModal(p,j,b,"#gview_"+e.p.id,a("#gview_"+e.p.id)[0]);if(D){o=D(a("#"+k));if(typeof o=="undefined")o=true}if(o===false)return;a(".fm-button","#"+k+"_2").hover(function(){a(this).addClass("ui-state-hover")},function(){a(this).removeClass("ui-state-hover")});b.delicon=a.extend([true,"left","ui-icon-scissors"],d[e.p.id].delicon);b.cancelicon=a.extend([true,"left","ui-icon-cancel"],d[e.p.id].cancelicon);if(b.delicon[0]===true)a("#dData",
"#"+k+"_2").addClass(b.delicon[1]=="right"?"fm-button-icon-right":"fm-button-icon-left").append("<span class='ui-icon "+b.delicon[2]+"'></span>");if(b.cancelicon[0]===true)a("#eData","#"+k+"_2").addClass(b.cancelicon[1]=="right"?"fm-button-icon-right":"fm-button-icon-left").append("<span class='ui-icon "+b.cancelicon[2]+"'></span>");a("#dData","#"+k+"_2").click(function(){var n=[true,""];y={};var G=a("#DelData>td","#"+k).text();if(a.isFunction(d[e.p.id].onclickSubmit))y=d[e.p.id].onclickSubmit(d[e.p.id],
G)||{};if(a.isFunction(d[e.p.id].beforeSubmit))n=d[e.p.id].beforeSubmit(G);if(n[0]&&!d[e.p.id].processing){d[e.p.id].processing=true;a(this).addClass("ui-state-active");c=e.p.prmNames;s=a.extend({},d[e.p.id].delData,y);t=c.oper;s[t]=c.deloper;N=c.id;G=G.split(",");for(var J in G)if(G.hasOwnProperty(J))G[J]=a.jgrid.stripPref(e.p.idPrefix,G[J]);s[N]=G.join();J=a.extend({url:d[e.p.id].url?d[e.p.id].url:a(e).jqGrid("getGridParam","editurl"),type:d[e.p.id].mtype,data:a.isFunction(d[e.p.id].serializeDelData)?
d[e.p.id].serializeDelData(s):s,complete:function(u,E){if(E!="success"){n[0]=false;n[1]=a.isFunction(d[e.p.id].errorTextFormat)?d[e.p.id].errorTextFormat(u):E+" Status: '"+u.statusText+"'. Error code: "+u.status}else if(a.isFunction(d[e.p.id].afterSubmit))n=d[e.p.id].afterSubmit(u,s);if(n[0]===false){a("#DelError>td","#"+k).html(n[1]);a("#DelError","#"+k).show()}else{if(d[e.p.id].reloadAfterSubmit&&e.p.datatype!="local")a(e).trigger("reloadGrid");else{var B=[];B=G.split(",");if(e.p.treeGrid===true)try{a(e).jqGrid("delTreeNode",
e.p.idPrefix+B[0])}catch(m){}else for(var z=0;z<B.length;z++)a(e).jqGrid("delRowData",e.p.idPrefix+B[z]);e.p.selrow=null;e.p.selarrrow=[]}a.isFunction(d[e.p.id].afterComplete)&&setTimeout(function(){d[e.p.id].afterComplete(u,G)},500)}d[e.p.id].processing=false;a("#dData","#"+k+"_2").removeClass("ui-state-active");n[0]&&a.jgrid.hideModal("#"+p.themodal,{gb:"#gbox_"+F,jqm:b.jqModal,onClose:d[e.p.id].onClose})}},a.jgrid.ajaxOptions,d[e.p.id].ajaxDelOptions);if(!J.url&&!d[e.p.id].useDataProxy)if(a.isFunction(e.p.dataProxy))d[e.p.id].useDataProxy=
true;else{n[0]=false;n[1]+=" "+a.jgrid.errors.nourl}if(n[0])if(d[e.p.id].useDataProxy){J=e.p.dataProxy.call(e,J,"del_"+e.p.id);if(typeof J=="undefined")J=[true,""];if(J[0]===false){n[0]=false;n[1]=J[1]||"Error deleting the selected row!"}else a.jgrid.hideModal("#"+p.themodal,{gb:"#gbox_"+F,jqm:b.jqModal,onClose:d[e.p.id].onClose})}else a.ajax(J)}if(n[0]===false){a("#DelError>td","#"+k).html(n[1]);a("#DelError","#"+k).show()}return false});a("#eData","#"+k+"_2").click(function(){a.jgrid.hideModal("#"+
p.themodal,{gb:"#gbox_"+F,jqm:d[e.p.id].jqModal,onClose:d[e.p.id].onClose});return false});r&&d[e.p.id].beforeShowForm(a("#"+k));a.jgrid.viewModal("#"+p.themodal,{gbox:"#gbox_"+F,jqm:d[e.p.id].jqModal,overlay:d[e.p.id].overlay,modal:d[e.p.id].modal})}x&&d[e.p.id].afterShowForm(a("#"+k));d[e.p.id].closeOnEscape===true&&setTimeout(function(){a(".ui-jqdialog-titlebar-close","#"+p.modalhead).focus()},0)}})},navGrid:function(f,b,e,r,x,D,F){b=a.extend({edit:true,editicon:"ui-icon-pencil",add:true,addicon:"ui-icon-plus",
del:true,delicon:"ui-icon-trash",search:true,searchicon:"ui-icon-search",refresh:true,refreshicon:"ui-icon-refresh",refreshstate:"firstpage",view:false,viewicon:"ui-icon-document",position:"left",closeOnEscape:true,beforeRefresh:null,afterRefresh:null,cloneToTop:false,alertwidth:200,alertheight:"auto",alerttop:null,alertleft:null,alertzIndex:null},a.jgrid.nav,b||{});return this.each(function(){if(!this.nav){var y={themodal:"alertmod",modalhead:"alerthd",modalcontent:"alertcnt"},o=this,k;if(!(!o.grid||
typeof f!="string")){if(a("#"+y.themodal).html()===null){if(!b.alerttop&&!b.alertleft){if(typeof window.innerWidth!="undefined"){b.alertleft=window.innerWidth;b.alerttop=window.innerHeight}else if(typeof document.documentElement!="undefined"&&typeof document.documentElement.clientWidth!="undefined"&&document.documentElement.clientWidth!==0){b.alertleft=document.documentElement.clientWidth;b.alerttop=document.documentElement.clientHeight}else{b.alertleft=1024;b.alerttop=768}b.alertleft=b.alertleft/
2-parseInt(b.alertwidth,10)/2;b.alerttop=b.alerttop/2-25}a.jgrid.createModal(y,"<div>"+b.alerttext+"</div><span tabindex='0'><span tabindex='-1' id='jqg_alrt'></span></span>",{gbox:"#gbox_"+o.p.id,jqModal:true,drag:true,resize:true,caption:b.alertcap,top:b.alerttop,left:b.alertleft,width:b.alertwidth,height:b.alertheight,closeOnEscape:b.closeOnEscape,zIndex:b.alertzIndex},"","",true)}var s=1;if(b.cloneToTop&&o.p.toppager)s=2;for(var N=0;N<s;N++){var c=a("<table cellspacing='0' cellpadding='0' border='0' class='ui-pg-table navtable' style='float:left;table-layout:auto;'><tbody><tr></tr></tbody></table>"),
t,p;if(N===0){t=f;p=o.p.id;if(t==o.p.toppager){p+="_top";s=1}}else{t=o.p.toppager;p=o.p.id+"_top"}o.p.direction=="rtl"&&a(c).attr("dir","rtl").css("float","right");if(b.add){r=r||{};k=a("<td class='ui-pg-button ui-corner-all'></td>");a(k).append("<div class='ui-pg-div'><span class='ui-icon "+b.addicon+"'></span>"+b.addtext+"</div>");a("tr",c).append(k);a(k,c).attr({title:b.addtitle||"",id:r.id||"add_"+p}).click(function(){a(this).hasClass("ui-state-disabled")||(a.isFunction(b.addfunc)?b.addfunc():
a(o).jqGrid("editGridRow","new",r));return false}).hover(function(){a(this).hasClass("ui-state-disabled")||a(this).addClass("ui-state-hover")},function(){a(this).removeClass("ui-state-hover")});k=null}if(b.edit){k=a("<td class='ui-pg-button ui-corner-all'></td>");e=e||{};a(k).append("<div class='ui-pg-div'><span class='ui-icon "+b.editicon+"'></span>"+b.edittext+"</div>");a("tr",c).append(k);a(k,c).attr({title:b.edittitle||"",id:e.id||"edit_"+p}).click(function(){if(!a(this).hasClass("ui-state-disabled")){var j=
o.p.selrow;if(j)a.isFunction(b.editfunc)?b.editfunc(j):a(o).jqGrid("editGridRow",j,e);else{a.jgrid.viewModal("#"+y.themodal,{gbox:"#gbox_"+o.p.id,jqm:true});a("#jqg_alrt").focus()}}return false}).hover(function(){a(this).hasClass("ui-state-disabled")||a(this).addClass("ui-state-hover")},function(){a(this).removeClass("ui-state-hover")});k=null}if(b.view){k=a("<td class='ui-pg-button ui-corner-all'></td>");F=F||{};a(k).append("<div class='ui-pg-div'><span class='ui-icon "+b.viewicon+"'></span>"+b.viewtext+
"</div>");a("tr",c).append(k);a(k,c).attr({title:b.viewtitle||"",id:F.id||"view_"+p}).click(function(){if(!a(this).hasClass("ui-state-disabled")){var j=o.p.selrow;if(j)a.isFunction(b.viewfunc)?b.viewfunc(j):a(o).jqGrid("viewGridRow",j,F);else{a.jgrid.viewModal("#"+y.themodal,{gbox:"#gbox_"+o.p.id,jqm:true});a("#jqg_alrt").focus()}}return false}).hover(function(){a(this).hasClass("ui-state-disabled")||a(this).addClass("ui-state-hover")},function(){a(this).removeClass("ui-state-hover")});k=null}if(b.del){k=
a("<td class='ui-pg-button ui-corner-all'></td>");x=x||{};a(k).append("<div class='ui-pg-div'><span class='ui-icon "+b.delicon+"'></span>"+b.deltext+"</div>");a("tr",c).append(k);a(k,c).attr({title:b.deltitle||"",id:x.id||"del_"+p}).click(function(){if(!a(this).hasClass("ui-state-disabled")){var j;if(o.p.multiselect){j=o.p.selarrrow;if(j.length===0)j=null}else j=o.p.selrow;if(j)"function"==typeof b.delfunc?b.delfunc(j):a(o).jqGrid("delGridRow",j,x);else{a.jgrid.viewModal("#"+y.themodal,{gbox:"#gbox_"+
o.p.id,jqm:true});a("#jqg_alrt").focus()}}return false}).hover(function(){a(this).hasClass("ui-state-disabled")||a(this).addClass("ui-state-hover")},function(){a(this).removeClass("ui-state-hover")});k=null}if(b.add||b.edit||b.del||b.view)a("tr",c).append("<td class='ui-pg-button ui-state-disabled' style='width:4px;'><span class='ui-separator'></span></td>");if(b.search){k=a("<td class='ui-pg-button ui-corner-all'></td>");D=D||{};a(k).append("<div class='ui-pg-div'><span class='ui-icon "+b.searchicon+
"'></span>"+b.searchtext+"</div>");a("tr",c).append(k);a(k,c).attr({title:b.searchtitle||"",id:D.id||"search_"+p}).click(function(){a(this).hasClass("ui-state-disabled")||a(o).jqGrid("searchGrid",D);return false}).hover(function(){a(this).hasClass("ui-state-disabled")||a(this).addClass("ui-state-hover")},function(){a(this).removeClass("ui-state-hover")});D.showOnLoad&&D.showOnLoad===true&&a(k,c).click();k=null}if(b.refresh){k=a("<td class='ui-pg-button ui-corner-all'></td>");a(k).append("<div class='ui-pg-div'><span class='ui-icon "+
b.refreshicon+"'></span>"+b.refreshtext+"</div>");a("tr",c).append(k);a(k,c).attr({title:b.refreshtitle||"",id:"refresh_"+p}).click(function(){if(!a(this).hasClass("ui-state-disabled")){a.isFunction(b.beforeRefresh)&&b.beforeRefresh();o.p.search=false;try{var j=o.p.id;o.p.postData.filters="";a("#fbox_"+j).jqFilter("resetFilter");a.isFunction(o.clearToolbar)&&o.clearToolbar(false)}catch(n){}switch(b.refreshstate){case "firstpage":a(o).trigger("reloadGrid",[{page:1}]);break;case "current":a(o).trigger("reloadGrid",
[{current:true}])}a.isFunction(b.afterRefresh)&&b.afterRefresh()}return false}).hover(function(){a(this).hasClass("ui-state-disabled")||a(this).addClass("ui-state-hover")},function(){a(this).removeClass("ui-state-hover")});k=null}k=a(".ui-jqgrid").css("font-size")||"11px";a("body").append("<div id='testpg2' class='ui-jqgrid ui-widget ui-widget-content' style='font-size:"+k+";visibility:hidden;' ></div>");k=a(c).clone().appendTo("#testpg2").width();a("#testpg2").remove();a(t+"_"+b.position,t).append(c);
if(o.p._nvtd){if(k>o.p._nvtd[0]){a(t+"_"+b.position,t).width(k);o.p._nvtd[0]=k}o.p._nvtd[1]=k}c=k=k=null;this.nav=true}}}})},navButtonAdd:function(f,b){b=a.extend({caption:"newButton",title:"",buttonicon:"ui-icon-newwin",onClickButton:null,position:"last",cursor:"pointer"},b||{});return this.each(function(){if(this.grid){if(f.indexOf("#")!==0)f="#"+f;var e=a(".navtable",f)[0],r=this;if(e)if(!(b.id&&a("#"+b.id,e).html()!==null)){var x=a("<td></td>");b.buttonicon.toString().toUpperCase()=="NONE"?a(x).addClass("ui-pg-button ui-corner-all").append("<div class='ui-pg-div'>"+
b.caption+"</div>"):a(x).addClass("ui-pg-button ui-corner-all").append("<div class='ui-pg-div'><span class='ui-icon "+b.buttonicon+"'></span>"+b.caption+"</div>");b.id&&a(x).attr("id",b.id);if(b.position=="first")e.rows[0].cells.length===0?a("tr",e).append(x):a("tr td:eq(0)",e).before(x);else a("tr",e).append(x);a(x,e).attr("title",b.title||"").click(function(D){a(this).hasClass("ui-state-disabled")||a.isFunction(b.onClickButton)&&b.onClickButton.call(r,D);return false}).hover(function(){a(this).hasClass("ui-state-disabled")||
a(this).addClass("ui-state-hover")},function(){a(this).removeClass("ui-state-hover")})}}})},navSeparatorAdd:function(f,b){b=a.extend({sepclass:"ui-separator",sepcontent:""},b||{});return this.each(function(){if(this.grid){if(f.indexOf("#")!==0)f="#"+f;var e=a(".navtable",f)[0];if(e){var r="<td class='ui-pg-button ui-state-disabled' style='width:4px;'><span class='"+b.sepclass+"'></span>"+b.sepcontent+"</td>";a("tr",e).append(r)}}})},GridToForm:function(f,b){return this.each(function(){var e=this;
if(e.grid){var r=a(e).jqGrid("getRowData",f);if(r)for(var x in r)a("[name="+a.jgrid.jqID(x)+"]",b).is("input:radio")||a("[name="+a.jgrid.jqID(x)+"]",b).is("input:checkbox")?a("[name="+a.jgrid.jqID(x)+"]",b).each(function(){if(a(this).val()==r[x])a(this)[e.p.useProp?"prop":"attr"]("checked",true);else a(this)[e.p.useProp?"prop":"attr"]("checked",false)}):a("[name="+a.jgrid.jqID(x)+"]",b).val(r[x])}})},FormToGrid:function(f,b,e,r){return this.each(function(){if(this.grid){e||(e="set");r||(r="first");
var x=a(b).serializeArray(),D={};a.each(x,function(F,y){D[y.name]=y.value});if(e=="add")a(this).jqGrid("addRowData",f,D,r);else e=="set"&&a(this).jqGrid("setRowData",f,D)}})}})})(jQuery);
(function(c){c.fn.jqFilter=function(k){if(typeof k==="string"){var w=c.fn.jqFilter[k];if(!w)throw"jqFilter - No such method: "+k;var B=c.makeArray(arguments).slice(1);return w.apply(this,B)}var o=c.extend(true,{filter:null,columns:[],onChange:null,afterRedraw:null,checkValues:null,error:false,errmsg:"",errorcheck:true,showQuery:true,sopt:null,ops:[{name:"eq",description:"equal",operator:"="},{name:"ne",description:"not equal",operator:"<>"},{name:"lt",description:"less",operator:"<"},{name:"le",description:"less or equal",
operator:"<="},{name:"gt",description:"greater",operator:">"},{name:"ge",description:"greater or equal",operator:">="},{name:"bw",description:"begins with",operator:"LIKE"},{name:"bn",description:"does not begin with",operator:"NOT LIKE"},{name:"in",description:"in",operator:"IN"},{name:"ni",description:"not in",operator:"NOT IN"},{name:"ew",description:"ends with",operator:"LIKE"},{name:"en",description:"does not end with",operator:"NOT LIKE"},{name:"cn",description:"contains",operator:"LIKE"},{name:"nc",
description:"does not contain",operator:"NOT LIKE"},{name:"nu",description:"is null",operator:"IS NULL"},{name:"nn",description:"is not null",operator:"IS NOT NULL"}],numopts:["eq","ne","lt","le","gt","ge","nu","nn","in","ni"],stropts:["eq","ne","bw","bn","ew","en","cn","nc","nu","nn","in","ni"],_gridsopt:[],groupOps:["AND","OR"],groupButton:true,ruleButtons:true,direction:"ltr"},k||{});return this.each(function(){if(!this.filter){this.p=o;if(this.p.filter===null||this.p.filter===undefined)this.p.filter=
{groupOp:this.p.groupOps[0],rules:[],groups:[]};var q,x=this.p.columns.length,j,y=/msie/i.test(navigator.userAgent)&&!window.opera;if(this.p._gridsopt.length)for(q=0;q<this.p._gridsopt.length;q++)this.p.ops[q].description=this.p._gridsopt[q];this.p.initFilter=c.extend(true,{},this.p.filter);if(x){for(q=0;q<x;q++){j=this.p.columns[q];if(j.stype)j.inputtype=j.stype;else if(!j.inputtype)j.inputtype="text";if(j.sorttype)j.searchtype=j.sorttype;else if(!j.searchtype)j.searchtype="string";if(j.hidden===
undefined)j.hidden=false;if(!j.label)j.label=j.name;if(j.index)j.name=j.index;if(!j.hasOwnProperty("searchoptions"))j.searchoptions={};if(!j.hasOwnProperty("searchrules"))j.searchrules={}}this.p.showQuery&&c(this).append("<table class='queryresult ui-widget ui-widget-content' style='display:block;max-width:440px;border:0px none;' dir='"+this.p.direction+"'><tbody><tr><td class='query'></td></tr></tbody></table>");var z=function(d,g){var a=[true,""];if(c.isFunction(g.searchrules))a=g.searchrules(d,
g);else if(c.jgrid&&c.jgrid.checkValues)try{a=c.jgrid.checkValues(d,-1,null,g.searchrules,g.label)}catch(b){}if(a&&a.length&&a[0]===false){o.error=!a[0];o.errmsg=a[1]}};this.onchange=function(){this.p.error=false;this.p.errmsg="";return c.isFunction(this.p.onChange)?this.p.onChange.call(this,this.p):false};this.reDraw=function(){c("table.group:first",this).remove();var d=this.createTableForGroup(o.filter,null);c(this).append(d);c.isFunction(this.p.afterRedraw)&&this.p.afterRedraw.call(this,this.p)};
this.createTableForGroup=function(d,g){var a=this,b,e=c("<table class='group ui-widget ui-widget-content' style='border:0px none;'><tbody></tbody></table>"),i="left";if(this.p.direction=="rtl"){i="right";e.attr("dir","rtl")}g===null&&e.append("<tr class='error' style='display:none;'><th colspan='5' class='ui-state-error' align='"+i+"'></th></tr>");var f=c("<tr></tr>");e.append(f);i=c("<th colspan='5' align='"+i+"'></th>");f.append(i);if(this.p.ruleButtons===true){var h=c("<select class='opsel'></select>");
i.append(h);f="";var l;for(b=0;b<o.groupOps.length;b++){l=d.groupOp===a.p.groupOps[b]?" selected='selected'":"";f+="<option value='"+a.p.groupOps[b]+"'"+l+">"+a.p.groupOps[b]+"</option>"}h.append(f).bind("change",function(){d.groupOp=c(h).val();a.onchange()})}f="<span></span>";if(this.p.groupButton){f=c("<input type='button' value='+ {}' title='Add subgroup' class='add-group'/>");f.bind("click",function(){if(d.groups===undefined)d.groups=[];d.groups.push({groupOp:o.groupOps[0],rules:[],groups:[]});
a.reDraw();a.onchange();return false})}i.append(f);if(this.p.ruleButtons===true){f=c("<input type='button' value='+' title='Add rule' class='add-rule ui-add'/>");var m;f.bind("click",function(){if(d.rules===undefined)d.rules=[];for(b=0;b<a.p.columns.length;b++){var n=typeof a.p.columns[b].search==="undefined"?true:a.p.columns[b].search,s=a.p.columns[b].hidden===true;if(a.p.columns[b].searchoptions.searchhidden===true&&n||n&&!s){m=a.p.columns[b];break}}d.rules.push({field:m.name,op:(m.searchoptions.sopt?
m.searchoptions.sopt:a.p.sopt?a.p.sopt:m.searchtype==="string"?a.p.stropts:a.p.numopts)[0],data:""});a.reDraw();return false});i.append(f)}if(g!==null){f=c("<input type='button' value='-' title='Delete group' class='delete-group'/>");i.append(f);f.bind("click",function(){for(b=0;b<g.groups.length;b++)if(g.groups[b]===d){g.groups.splice(b,1);break}a.reDraw();a.onchange();return false})}if(d.groups!==undefined)for(b=0;b<d.groups.length;b++){i=c("<tr></tr>");e.append(i);f=c("<td class='first'></td>");
i.append(f);f=c("<td colspan='4'></td>");f.append(this.createTableForGroup(d.groups[b],d));i.append(f)}if(d.groupOp===undefined)d.groupOp=a.p.groupOps[0];if(d.rules!==undefined)for(b=0;b<d.rules.length;b++)e.append(this.createTableRowForRule(d.rules[b],d));return e};this.createTableRowForRule=function(d,g){var a=this,b=c("<tr></tr>"),e,i,f,h,l="",m;b.append("<td class='first'></td>");var n=c("<td class='columns'></td>");b.append(n);var s=c("<select></select>"),p,t=[];n.append(s);s.bind("change",function(){d.field=
c(s).val();f=c(this).parents("tr:first");for(e=0;e<a.p.columns.length;e++)if(a.p.columns[e].name===d.field){h=a.p.columns[e];break}if(h){h.searchoptions.id=c.jgrid.randId();if(y&&h.inputtype==="text")if(!h.searchoptions.size)h.searchoptions.size=10;var r=c.jgrid.createEl(h.inputtype,h.searchoptions,"",true,a.p.ajaxSelectOptions,true);c(r).addClass("input-elm");i=h.searchoptions.sopt?h.searchoptions.sopt:a.p.sopt?a.p.sopt:h.searchtype==="string"?a.p.stropts:a.p.numopts;var u="",A=0;t=[];c.each(a.p.ops,
function(){t.push(this.name)});for(e=0;e<i.length;e++){p=c.inArray(i[e],t);if(p!==-1){if(A===0)d.op=a.p.ops[p].name;u+="<option value='"+a.p.ops[p].name+"'>"+a.p.ops[p].description+"</option>";A++}}c(".selectopts",f).empty().append(u);c(".selectopts",f)[0].selectedIndex=0;if(c.browser.msie&&c.browser.version<9){u=parseInt(c("select.selectopts",f)[0].offsetWidth)+1;c(".selectopts",f).width(u);c(".selectopts",f).css("width","auto")}c(".data",f).empty().append(r);c(".input-elm",f).bind("change",function(){d.data=
c(this).val();a.onchange()});setTimeout(function(){d.data=c(r).val();a.onchange()},0)}});for(e=n=0;e<a.p.columns.length;e++){m=typeof a.p.columns[e].search==="undefined"?true:a.p.columns[e].search;var C=a.p.columns[e].hidden===true;if(a.p.columns[e].searchoptions.searchhidden===true&&m||m&&!C){m="";if(d.field===a.p.columns[e].name){m=" selected='selected'";n=e}l+="<option value='"+a.p.columns[e].name+"'"+m+">"+a.p.columns[e].label+"</option>"}}s.append(l);l=c("<td class='operators'></td>");b.append(l);
h=o.columns[n];h.searchoptions.id=c.jgrid.randId();if(y&&h.inputtype==="text")if(!h.searchoptions.size)h.searchoptions.size=10;n=c.jgrid.createEl(h.inputtype,h.searchoptions,d.data,true,a.p.ajaxSelectOptions,true);var v=c("<select class='selectopts'></select>");l.append(v);v.bind("change",function(){d.op=c(v).val();f=c(this).parents("tr:first");var r=c(".input-elm",f)[0];if(d.op==="nu"||d.op==="nn"){d.data="";r.value="";r.setAttribute("readonly","true");r.setAttribute("disabled","true")}else{r.removeAttribute("readonly");
r.removeAttribute("disabled")}a.onchange()});i=h.searchoptions.sopt?h.searchoptions.sopt:a.p.sopt?a.p.sopt:h.searchtype==="string"?o.stropts:a.p.numopts;l="";c.each(a.p.ops,function(){t.push(this.name)});for(e=0;e<i.length;e++){p=c.inArray(i[e],t);if(p!==-1){m=d.op===a.p.ops[p].name?" selected='selected'":"";l+="<option value='"+a.p.ops[p].name+"'"+m+">"+a.p.ops[p].description+"</option>"}}v.append(l);l=c("<td class='data'></td>");b.append(l);l.append(n);c(n).addClass("input-elm").bind("change",function(){d.data=
c(this).val();a.onchange()});l=c("<td></td>");b.append(l);if(this.p.ruleButtons===true){n=c("<input type='button' value='-' title='Delete rule' class='delete-rule ui-del'/>");l.append(n);n.bind("click",function(){for(e=0;e<g.rules.length;e++)if(g.rules[e]===d){g.rules.splice(e,1);break}a.reDraw();a.onchange();return false})}return b};this.getStringForGroup=function(d){var g="(",a;if(d.groups!==undefined)for(a=0;a<d.groups.length;a++){if(g.length>1)g+=" "+d.groupOp+" ";try{g+=this.getStringForGroup(d.groups[a])}catch(b){alert(b)}}if(d.rules!==
undefined)try{for(a=0;a<d.rules.length;a++){if(g.length>1)g+=" "+d.groupOp+" ";g+=this.getStringForRule(d.rules[a])}}catch(e){alert(e)}g+=")";return g==="()"?"":g};this.getStringForRule=function(d){var g="",a="",b,e;for(b=0;b<this.p.ops.length;b++)if(this.p.ops[b].name===d.op){g=this.p.ops[b].operator;a=this.p.ops[b].name;break}for(b=0;b<this.p.columns.length;b++)if(this.p.columns[b].name===d.field){e=this.p.columns[b];break}b=d.data;if(a==="bw"||a==="bn")b+="%";if(a==="ew"||a==="en")b="%"+b;if(a===
"cn"||a==="nc")b="%"+b+"%";if(a==="in"||a==="ni")b=" ("+b+")";o.errorcheck&&z(d.data,e);return c.inArray(e.searchtype,["int","integer","float","number","currency"])!==-1||a==="nn"||a==="nu"?d.field+" "+g+" "+b:d.field+" "+g+' "'+b+'"'};this.resetFilter=function(){this.p.filter=c.extend(true,{},this.p.initFilter);this.reDraw();this.onchange()};this.hideError=function(){c("th.ui-state-error",this).html("");c("tr.error",this).hide()};this.showError=function(){c("th.ui-state-error",this).html(this.p.errmsg);
c("tr.error",this).show()};this.toUserFriendlyString=function(){return this.getStringForGroup(o.filter)};this.toString=function(){function d(a){var b="(",e;if(a.groups!==undefined)for(e=0;e<a.groups.length;e++){if(b.length>1)b+=a.groupOp==="OR"?" || ":" && ";b+=d(a.groups[e])}if(a.rules!==undefined)for(e=0;e<a.rules.length;e++){if(b.length>1)b+=a.groupOp==="OR"?" || ":" && ";var i=a.rules[e];if(g.p.errorcheck){var f=void 0,h=void 0;for(f=0;f<g.p.columns.length;f++)if(g.p.columns[f].name===i.field){h=
g.p.columns[f];break}h&&z(i.data,h)}b+=i.op+"(item."+i.field+",'"+i.data+"')"}b+=")";return b==="()"?"":b}var g=this;return d(this.p.filter)};this.reDraw();if(this.p.showQuery)this.onchange();this.filter=true}}})};c.extend(c.fn.jqFilter,{toSQLString:function(){var k="";this.each(function(){k=this.toUserFriendlyString()});return k},filterData:function(){var k;this.each(function(){k=this.p.filter});return k},getParameter:function(k){if(k!==undefined)if(this.p.hasOwnProperty(k))return this.p[k];return this.p},
resetFilter:function(){return this.each(function(){this.resetFilter()})},addFilter:function(k){if(typeof k==="string")k=jQuery.jgrid.parse(k);this.each(function(){this.p.filter=k;this.reDraw();this.onchange()})}})})(jQuery);
(function(a){a.jgrid.extend({editRow:function(g,x,m,s,u,y,v,l,t){var h={keys:x||false,oneditfunc:m||null,successfunc:s||null,url:u||null,extraparam:y||{},aftersavefunc:v||null,errorfunc:l||null,afterrestorefunc:t||null,restoreAfterError:true,mtype:"POST"},o=a.makeArray(arguments).slice(1),b;b=o[0]&&typeof o[0]=="object"&&!a.isFunction(o[0])?a.extend(h,o[0]):h;return this.each(function(){var d=this,c,j,q=0,r=null,p={},k,e;if(d.grid){k=a(d).jqGrid("getInd",g,true);if(k!==false)if((a(k).attr("editable")||
"0")=="0"&&!a(k).hasClass("not-editable-row")){e=d.p.colModel;a("td",k).each(function(f){c=e[f].name;var A=d.p.treeGrid===true&&c==d.p.ExpandColumn;if(A)j=a("span:first",this).html();else try{j=a.unformat(this,{rowId:g,colModel:e[f]},f)}catch(n){j=e[f].edittype&&e[f].edittype=="textarea"?a(this).text():a(this).html()}if(c!="cb"&&c!="subgrid"&&c!="rn"){if(d.p.autoencode)j=a.jgrid.htmlDecode(j);p[c]=j;if(e[f].editable===true){if(r===null)r=f;A?a("span:first",this).html(""):a(this).html("");var i=a.extend({},
e[f].editoptions||{},{id:g+"_"+c,name:c});if(!e[f].edittype)e[f].edittype="text";if(j=="&nbsp;"||j=="&#160;"||j.length==1&&j.charCodeAt(0)==160)j="";i=a.jgrid.createEl(e[f].edittype,i,j,true,a.extend({},a.jgrid.ajaxOptions,d.p.ajaxSelectOptions||{}));a(i).addClass("editable");A?a("span:first",this).append(i):a(this).append(i);e[f].edittype=="select"&&typeof e[f].editoptions!=="undefined"&&e[f].editoptions.multiple===true&&typeof e[f].editoptions.dataUrl==="undefined"&&a.browser.msie&&a(i).width(a(i).width());
q++}}});if(q>0){p.id=g;d.p.savedRow.push(p);a(k).attr("editable","1");a("td:eq("+r+") input",k).focus();b.keys===true&&a(k).bind("keydown",function(f){f.keyCode===27&&a(d).jqGrid("restoreRow",g,t);if(f.keyCode===13){if(f.target.tagName=="TEXTAREA")return true;a(d).jqGrid("saveRow",g,b);return false}f.stopPropagation()});a.isFunction(b.oneditfunc)&&b.oneditfunc.call(d,g)}}}})},saveRow:function(g,x,m,s,u,y,v){var l={successfunc:x||null,url:m||null,extraparam:s||{},aftersavefunc:u||null,errorfunc:y||
null,afterrestorefunc:v||null,restoreAfterError:true,mtype:"POST"},t=a.makeArray(arguments).slice(1),h;h=t[0]&&typeof t[0]=="object"&&!a.isFunction(t[0])?a.extend(l,t[0]):l;var o=false,b=this[0],d,c={},j={},q={},r,p,k;if(!b.grid)return o;k=a(b).jqGrid("getInd",g,true);if(k===false)return o;l=a(k).attr("editable");h.url=h.url?h.url:b.p.editurl;if(l==="1"){var e;a("td",k).each(function(n){e=b.p.colModel[n];d=e.name;if(d!="cb"&&d!="subgrid"&&e.editable===true&&d!="rn"&&!a(this).hasClass("not-editable-cell")){switch(e.edittype){case "checkbox":var i=
["Yes","No"];if(e.editoptions)i=e.editoptions.value.split(":");c[d]=a("input",this).is(":checked")?i[0]:i[1];break;case "text":case "password":case "textarea":case "button":c[d]=a("input, textarea",this).val();break;case "select":if(e.editoptions.multiple){i=a("select",this);var w=[];c[d]=a(i).val();c[d]=c[d]?c[d].join(","):"";a("select option:selected",this).each(function(B,C){w[B]=a(C).text()});j[d]=w.join(",")}else{c[d]=a("select option:selected",this).val();j[d]=a("select option:selected",this).text()}if(e.formatter&&
e.formatter=="select")j={};break;case "custom":try{if(e.editoptions&&a.isFunction(e.editoptions.custom_value)){c[d]=e.editoptions.custom_value.call(b,a(".customelement",this),"get");if(c[d]===undefined)throw"e2";}else throw"e1";}catch(z){z=="e1"&&a.jgrid.info_dialog(jQuery.jgrid.errors.errcap,"function 'custom_value' "+a.jgrid.edit.msg.nodefined,jQuery.jgrid.edit.bClose);z=="e2"?a.jgrid.info_dialog(jQuery.jgrid.errors.errcap,"function 'custom_value' "+a.jgrid.edit.msg.novalue,jQuery.jgrid.edit.bClose):
a.jgrid.info_dialog(jQuery.jgrid.errors.errcap,z.message,jQuery.jgrid.edit.bClose)}}p=a.jgrid.checkValues(c[d],n,b);if(p[0]===false){p[1]=c[d]+" "+p[1];return false}if(b.p.autoencode)c[d]=a.jgrid.htmlEncode(c[d]);if(h.url!=="clientArray"&&e.editoptions&&e.editoptions.NullIfEmpty===true)if(c[d]=="")q[d]="null"}});if(p[0]===false){try{var f=a.jgrid.findPos(a("#"+a.jgrid.jqID(g),b.grid.bDiv)[0]);a.jgrid.info_dialog(a.jgrid.errors.errcap,p[1],a.jgrid.edit.bClose,{left:f[0],top:f[1]})}catch(A){alert(p[1])}return o}l=
b.p.prmNames;t=l.oper;f=l.id;if(c){c[t]=l.editoper;c[f]=g;if(typeof b.p.inlineData=="undefined")b.p.inlineData={};c=a.extend({},c,b.p.inlineData,h.extraparam)}if(h.url=="clientArray"){c=a.extend({},c,j);b.p.autoencode&&a.each(c,function(n,i){c[n]=a.jgrid.htmlDecode(i)});f=a(b).jqGrid("setRowData",g,c);a(k).attr("editable","0");for(l=0;l<b.p.savedRow.length;l++)if(b.p.savedRow[l].id==g){r=l;break}r>=0&&b.p.savedRow.splice(r,1);a.isFunction(h.aftersavefunc)&&h.aftersavefunc.call(b,g,f);o=true;a(k).unbind("keydown")}else{a("#lui_"+
b.p.id).show();q=a.extend({},c,q);q[f]=a.jgrid.stripPref(b.p.idPrefix,q[f]);a.ajax(a.extend({url:h.url,data:a.isFunction(b.p.serializeRowData)?b.p.serializeRowData.call(b,q):q,type:h.mtype,async:false,complete:function(n,i){a("#lui_"+b.p.id).hide();if(i==="success")if((a.isFunction(h.successfunc)?h.successfunc.call(b,n):true)===true){b.p.autoencode&&a.each(c,function(z,B){c[z]=a.jgrid.htmlDecode(B)});c=a.extend({},c,j);a(b).jqGrid("setRowData",g,c);a(k).attr("editable","0");for(var w=0;w<b.p.savedRow.length;w++)if(b.p.savedRow[w].id==
g){r=w;break}r>=0&&b.p.savedRow.splice(r,1);a.isFunction(h.aftersavefunc)&&h.aftersavefunc.call(b,g,n);o=true;a(k).unbind("keydown")}else{a.isFunction(h.errorfunc)&&h.errorfunc.call(b,g,n,i);h.restoreAfterError===true&&a(b).jqGrid("restoreRow",g,h.afterrestorefunc)}},error:function(n,i){a("#lui_"+b.p.id).hide();if(a.isFunction(h.errorfunc))h.errorfunc.call(b,g,n,i);else try{jQuery.jgrid.info_dialog(jQuery.jgrid.errors.errcap,'<div class="ui-state-error">'+n.responseText+"</div>",jQuery.jgrid.edit.bClose,
{buttonalign:"right"})}catch(w){alert(n.responseText)}h.restoreAfterError===true&&a(b).jqGrid("restoreRow",g,h.afterrestorefunc)}},a.jgrid.ajaxOptions,b.p.ajaxRowOptions||{}))}}return o},restoreRow:function(g,x){return this.each(function(){var m=this,s,u,y={};if(m.grid){u=a(m).jqGrid("getInd",g,true);if(u!==false){for(var v=0;v<m.p.savedRow.length;v++)if(m.p.savedRow[v].id==g){s=v;break}if(s>=0){if(a.isFunction(a.fn.datepicker))try{a("input.hasDatepicker","#"+a.jgrid.jqID(u.id)).datepicker("hide")}catch(l){}a.each(m.p.colModel,
function(){if(this.editable===true&&this.name in m.p.savedRow[s]&&!a(this).hasClass("not-editable-cell"))y[this.name]=m.p.savedRow[s][this.name]});a(m).jqGrid("setRowData",g,y);a(u).attr("editable","0").unbind("keydown");m.p.savedRow.splice(s,1)}a.isFunction(x)&&x.call(m,g)}}})}})})(jQuery);
(function(b){b.jgrid.extend({editCell:function(d,f,a){return this.each(function(){var c=this,h,e,g,i;if(!(!c.grid||c.p.cellEdit!==true)){f=parseInt(f,10);c.p.selrow=c.rows[d].id;c.p.knv||b(c).jqGrid("GridNav");if(c.p.savedRow.length>0){if(a===true)if(d==c.p.iRow&&f==c.p.iCol)return;b(c).jqGrid("saveCell",c.p.savedRow[0].id,c.p.savedRow[0].ic)}else window.setTimeout(function(){b("#"+c.p.knv).attr("tabindex","-1").focus()},0);i=c.p.colModel[f];h=i.name;if(!(h=="subgrid"||h=="cb"||h=="rn")){g=b("td:eq("+
f+")",c.rows[d]);if(i.editable===true&&a===true&&!g.hasClass("not-editable-cell")){if(parseInt(c.p.iCol,10)>=0&&parseInt(c.p.iRow,10)>=0){b("td:eq("+c.p.iCol+")",c.rows[c.p.iRow]).removeClass("edit-cell ui-state-highlight");b(c.rows[c.p.iRow]).removeClass("selected-row ui-state-hover")}b(g).addClass("edit-cell ui-state-highlight");b(c.rows[d]).addClass("selected-row ui-state-hover");try{e=b.unformat(g,{rowId:c.rows[d].id,colModel:i},f)}catch(k){e=i.edittype&&i.edittype=="textarea"?b(g).text():b(g).html()}if(c.p.autoencode)e=
b.jgrid.htmlDecode(e);if(!i.edittype)i.edittype="text";c.p.savedRow.push({id:d,ic:f,name:h,v:e});if(e=="&nbsp;"||e=="&#160;"||e.length==1&&e.charCodeAt(0)==160)e="";if(b.isFunction(c.p.formatCell)){var j=c.p.formatCell.call(c,c.rows[d].id,h,e,d,f);if(j!==undefined)e=j}j=b.extend({},i.editoptions||{},{id:d+"_"+h,name:h});var m=b.jgrid.createEl(i.edittype,j,e,true,b.extend({},b.jgrid.ajaxOptions,c.p.ajaxSelectOptions||{}));b.isFunction(c.p.beforeEditCell)&&c.p.beforeEditCell.call(c,c.rows[d].id,h,e,
d,f);b(g).html("").append(m).attr("tabindex","0");window.setTimeout(function(){b(m).focus()},0);b("input, select, textarea",g).bind("keydown",function(l){if(l.keyCode===27)if(b("input.hasDatepicker",g).length>0)b(".ui-datepicker").is(":hidden")?b(c).jqGrid("restoreCell",d,f):b("input.hasDatepicker",g).datepicker("hide");else b(c).jqGrid("restoreCell",d,f);l.keyCode===13&&b(c).jqGrid("saveCell",d,f);if(l.keyCode==9)if(c.grid.hDiv.loading)return false;else l.shiftKey?b(c).jqGrid("prevCell",d,f):b(c).jqGrid("nextCell",
d,f);l.stopPropagation()});b.isFunction(c.p.afterEditCell)&&c.p.afterEditCell.call(c,c.rows[d].id,h,e,d,f)}else{if(parseInt(c.p.iCol,10)>=0&&parseInt(c.p.iRow,10)>=0){b("td:eq("+c.p.iCol+")",c.rows[c.p.iRow]).removeClass("edit-cell ui-state-highlight");b(c.rows[c.p.iRow]).removeClass("selected-row ui-state-hover")}g.addClass("edit-cell ui-state-highlight");b(c.rows[d]).addClass("selected-row ui-state-hover");if(b.isFunction(c.p.onSelectCell)){e=g.html().replace(/\&#160\;/ig,"");c.p.onSelectCell.call(c,
c.rows[d].id,h,e,d,f)}}c.p.iCol=f;c.p.iRow=d}}})},saveCell:function(d,f){return this.each(function(){var a=this,c;if(!(!a.grid||a.p.cellEdit!==true)){c=a.p.savedRow.length>=1?0:null;if(c!==null){var h=b("td:eq("+f+")",a.rows[d]),e,g,i=a.p.colModel[f],k=i.name,j=b.jgrid.jqID(k);switch(i.edittype){case "select":if(i.editoptions.multiple){j=b("#"+d+"_"+j,a.rows[d]);var m=[];if(e=b(j).val())e.join(",");else e="";b("option:selected",j).each(function(o,p){m[o]=b(p).text()});g=m.join(",")}else{e=b("#"+d+
"_"+j+">option:selected",a.rows[d]).val();g=b("#"+d+"_"+j+">option:selected",a.rows[d]).text()}if(i.formatter)g=e;break;case "checkbox":var l=["Yes","No"];if(i.editoptions)l=i.editoptions.value.split(":");g=e=b("#"+d+"_"+j,a.rows[d]).is(":checked")?l[0]:l[1];break;case "password":case "text":case "textarea":case "button":g=e=b("#"+d+"_"+j,a.rows[d]).val();break;case "custom":try{if(i.editoptions&&b.isFunction(i.editoptions.custom_value)){e=i.editoptions.custom_value.call(a,b(".customelement",h),"get");
if(e===undefined)throw"e2";else g=e}else throw"e1";}catch(q){q=="e1"&&b.jgrid.info_dialog(jQuery.jgrid.errors.errcap,"function 'custom_value' "+b.jgrid.edit.msg.nodefined,jQuery.jgrid.edit.bClose);q=="e2"?b.jgrid.info_dialog(jQuery.jgrid.errors.errcap,"function 'custom_value' "+b.jgrid.edit.msg.novalue,jQuery.jgrid.edit.bClose):b.jgrid.info_dialog(jQuery.jgrid.errors.errcap,q.message,jQuery.jgrid.edit.bClose)}}if(g!==a.p.savedRow[c].v){if(b.isFunction(a.p.beforeSaveCell))if(c=a.p.beforeSaveCell.call(a,
a.rows[d].id,k,e,d,f))g=e=c;var r=b.jgrid.checkValues(e,f,a);if(r[0]===true){c={};if(b.isFunction(a.p.beforeSubmitCell))(c=a.p.beforeSubmitCell.call(a,a.rows[d].id,k,e,d,f))||(c={});b("input.hasDatepicker",h).length>0&&b("input.hasDatepicker",h).datepicker("hide");if(a.p.cellsubmit=="remote")if(a.p.cellurl){var n={};if(a.p.autoencode)e=b.jgrid.htmlEncode(e);n[k]=e;l=a.p.prmNames;i=l.id;j=l.oper;n[i]=b.jgrid.stripPref(a.p.idPrefix,a.rows[d].id);n[j]=l.editoper;n=b.extend(c,n);b("#lui_"+a.p.id).show();
a.grid.hDiv.loading=true;b.ajax(b.extend({url:a.p.cellurl,data:b.isFunction(a.p.serializeCellData)?a.p.serializeCellData.call(a,n):n,type:"POST",complete:function(o,p){b("#lui_"+a.p.id).hide();a.grid.hDiv.loading=false;if(p=="success")if(b.isFunction(a.p.afterSubmitCell)){var s=a.p.afterSubmitCell.call(a,o,n.id,k,e,d,f);if(s[0]===true){b(h).empty();b(a).jqGrid("setCell",a.rows[d].id,f,g,false,false,true);b(h).addClass("dirty-cell");b(a.rows[d]).addClass("edited");b.isFunction(a.p.afterSaveCell)&&
a.p.afterSaveCell.call(a,a.rows[d].id,k,e,d,f);a.p.savedRow.splice(0,1)}else{b.jgrid.info_dialog(b.jgrid.errors.errcap,s[1],b.jgrid.edit.bClose);b(a).jqGrid("restoreCell",d,f)}}else{b(h).empty();b(a).jqGrid("setCell",a.rows[d].id,f,g,false,false,true);b(h).addClass("dirty-cell");b(a.rows[d]).addClass("edited");b.isFunction(a.p.afterSaveCell)&&a.p.afterSaveCell.call(a,a.rows[d].id,k,e,d,f);a.p.savedRow.splice(0,1)}},error:function(o,p){b("#lui_"+a.p.id).hide();a.grid.hDiv.loading=false;b.isFunction(a.p.errorCell)?
a.p.errorCell.call(a,o,p):b.jgrid.info_dialog(b.jgrid.errors.errcap,o.status+" : "+o.statusText+"<br/>"+p,b.jgrid.edit.bClose);b(a).jqGrid("restoreCell",d,f)}},b.jgrid.ajaxOptions,a.p.ajaxCellOptions||{}))}else try{b.jgrid.info_dialog(b.jgrid.errors.errcap,b.jgrid.errors.nourl,b.jgrid.edit.bClose);b(a).jqGrid("restoreCell",d,f)}catch(t){}if(a.p.cellsubmit=="clientArray"){b(h).empty();b(a).jqGrid("setCell",a.rows[d].id,f,g,false,false,true);b(h).addClass("dirty-cell");b(a.rows[d]).addClass("edited");
b.isFunction(a.p.afterSaveCell)&&a.p.afterSaveCell.call(a,a.rows[d].id,k,e,d,f);a.p.savedRow.splice(0,1)}}else try{window.setTimeout(function(){b.jgrid.info_dialog(b.jgrid.errors.errcap,e+" "+r[1],b.jgrid.edit.bClose)},100);b(a).jqGrid("restoreCell",d,f)}catch(u){}}else b(a).jqGrid("restoreCell",d,f)}b.browser.opera?b("#"+a.p.knv).attr("tabindex","-1").focus():window.setTimeout(function(){b("#"+a.p.knv).attr("tabindex","-1").focus()},0)}})},restoreCell:function(d,f){return this.each(function(){var a=
this,c;if(!(!a.grid||a.p.cellEdit!==true)){c=a.p.savedRow.length>=1?0:null;if(c!==null){var h=b("td:eq("+f+")",a.rows[d]);if(b.isFunction(b.fn.datepicker))try{b("input.hasDatepicker",h).datepicker("hide")}catch(e){}b(h).empty().attr("tabindex","-1");b(a).jqGrid("setCell",a.rows[d].id,f,a.p.savedRow[c].v,false,false,true);b.isFunction(a.p.afterRestoreCell)&&a.p.afterRestoreCell.call(a,a.rows[d].id,a.p.savedRow[c].v,d,f);a.p.savedRow.splice(0,1)}window.setTimeout(function(){b("#"+a.p.knv).attr("tabindex",
"-1").focus()},0)}})},nextCell:function(d,f){return this.each(function(){var a=false;if(!(!this.grid||this.p.cellEdit!==true)){for(var c=f+1;c<this.p.colModel.length;c++)if(this.p.colModel[c].editable===true){a=c;break}if(a!==false)b(this).jqGrid("editCell",d,a,true);else this.p.savedRow.length>0&&b(this).jqGrid("saveCell",d,f)}})},prevCell:function(d,f){return this.each(function(){var a=false;if(!(!this.grid||this.p.cellEdit!==true)){for(var c=f-1;c>=0;c--)if(this.p.colModel[c].editable===true){a=
c;break}if(a!==false)b(this).jqGrid("editCell",d,a,true);else this.p.savedRow.length>0&&b(this).jqGrid("saveCell",d,f)}})},GridNav:function(){return this.each(function(){function d(g,i,k){if(k.substr(0,1)=="v"){var j=b(a.grid.bDiv)[0].clientHeight,m=b(a.grid.bDiv)[0].scrollTop,l=a.rows[g].offsetTop+a.rows[g].clientHeight,q=a.rows[g].offsetTop;if(k=="vd")if(l>=j)b(a.grid.bDiv)[0].scrollTop=b(a.grid.bDiv)[0].scrollTop+a.rows[g].clientHeight;if(k=="vu")if(q<m)b(a.grid.bDiv)[0].scrollTop=b(a.grid.bDiv)[0].scrollTop-
a.rows[g].clientHeight}if(k=="h"){k=b(a.grid.bDiv)[0].clientWidth;j=b(a.grid.bDiv)[0].scrollLeft;m=a.rows[g].cells[i].offsetLeft;if(a.rows[g].cells[i].offsetLeft+a.rows[g].cells[i].clientWidth>=k+parseInt(j,10))b(a.grid.bDiv)[0].scrollLeft=b(a.grid.bDiv)[0].scrollLeft+a.rows[g].cells[i].clientWidth;else if(m<j)b(a.grid.bDiv)[0].scrollLeft=b(a.grid.bDiv)[0].scrollLeft-a.rows[g].cells[i].clientWidth}}function f(g,i){var k,j;if(i=="lft"){k=g+1;for(j=g;j>=0;j--)if(a.p.colModel[j].hidden!==true){k=j;break}}if(i==
"rgt"){k=g-1;for(j=g;j<a.p.colModel.length;j++)if(a.p.colModel[j].hidden!==true){k=j;break}}return k}var a=this;if(!(!a.grid||a.p.cellEdit!==true)){a.p.knv=a.p.id+"_kn";var c=b("<span style='width:0px;height:0px;background-color:black;' tabindex='0'><span tabindex='-1' style='width:0px;height:0px;background-color:grey' id='"+a.p.knv+"'></span></span>"),h,e;b(c).insertBefore(a.grid.cDiv);b("#"+a.p.knv).focus().keydown(function(g){e=g.keyCode;if(a.p.direction=="rtl")if(e==37)e=39;else if(e==39)e=37;
switch(e){case 38:if(a.p.iRow-1>0){d(a.p.iRow-1,a.p.iCol,"vu");b(a).jqGrid("editCell",a.p.iRow-1,a.p.iCol,false)}break;case 40:if(a.p.iRow+1<=a.rows.length-1){d(a.p.iRow+1,a.p.iCol,"vd");b(a).jqGrid("editCell",a.p.iRow+1,a.p.iCol,false)}break;case 37:if(a.p.iCol-1>=0){h=f(a.p.iCol-1,"lft");d(a.p.iRow,h,"h");b(a).jqGrid("editCell",a.p.iRow,h,false)}break;case 39:if(a.p.iCol+1<=a.p.colModel.length-1){h=f(a.p.iCol+1,"rgt");d(a.p.iRow,h,"h");b(a).jqGrid("editCell",a.p.iRow,h,false)}break;case 13:parseInt(a.p.iCol,
10)>=0&&parseInt(a.p.iRow,10)>=0&&b(a).jqGrid("editCell",a.p.iRow,a.p.iCol,true)}return false})}})},getChangedCells:function(d){var f=[];d||(d="all");this.each(function(){var a=this,c;!a.grid||a.p.cellEdit!==true||b(a.rows).each(function(h){var e={};if(b(this).hasClass("edited")){b("td",this).each(function(g){c=a.p.colModel[g].name;if(c!=="cb"&&c!=="subgrid")if(d=="dirty"){if(b(this).hasClass("dirty-cell"))try{e[c]=b.unformat(this,{rowId:a.rows[h].id,colModel:a.p.colModel[g]},g)}catch(i){e[c]=b.jgrid.htmlDecode(b(this).html())}}else try{e[c]=
b.unformat(this,{rowId:a.rows[h].id,colModel:a.p.colModel[g]},g)}catch(k){e[c]=b.jgrid.htmlDecode(b(this).html())}});e.id=this.id;f.push(e)}})});return f}})})(jQuery);
(function(b){b.fn.jqm=function(a){var f={overlay:50,closeoverlay:true,overlayClass:"jqmOverlay",closeClass:"jqmClose",trigger:".jqModal",ajax:e,ajaxText:"",target:e,modal:e,toTop:e,onShow:e,onHide:e,onLoad:e};return this.each(function(){if(this._jqm)return j[this._jqm].c=b.extend({},j[this._jqm].c,a);l++;this._jqm=l;j[l]={c:b.extend(f,b.jqm.params,a),a:e,w:b(this).addClass("jqmID"+l),s:l};f.trigger&&b(this).jqmAddTrigger(f.trigger)})};b.fn.jqmAddClose=function(a){return o(this,a,"jqmHide")};b.fn.jqmAddTrigger=
function(a){return o(this,a,"jqmShow")};b.fn.jqmShow=function(a){return this.each(function(){b.jqm.open(this._jqm,a)})};b.fn.jqmHide=function(a){return this.each(function(){b.jqm.close(this._jqm,a)})};b.jqm={hash:{},open:function(a,f){var c=j[a],d=c.c,i="."+d.closeClass,g=parseInt(c.w.css("z-index"));g=g>0?g:3E3;var h=b("<div></div>").css({height:"100%",width:"100%",position:"fixed",left:0,top:0,"z-index":g-1,opacity:d.overlay/100});if(c.a)return e;c.t=f;c.a=true;c.w.css("z-index",g);if(d.modal){k[0]||
setTimeout(function(){p("bind")},1);k.push(a)}else if(d.overlay>0)d.closeoverlay&&c.w.jqmAddClose(h);else h=e;c.o=h?h.addClass(d.overlayClass).prependTo("body"):e;if(q){b("html,body").css({height:"100%",width:"100%"});if(h){h=h.css({position:"absolute"})[0];for(var m in{Top:1,Left:1})h.style.setExpression(m.toLowerCase(),"(_=(document.documentElement.scroll"+m+" || document.body.scroll"+m+"))+'px'")}}if(d.ajax){g=d.target||c.w;h=d.ajax;g=typeof g=="string"?b(g,c.w):b(g);h=h.substr(0,1)=="@"?b(f).attr(h.substring(1)):
h;g.html(d.ajaxText).load(h,function(){d.onLoad&&d.onLoad.call(this,c);i&&c.w.jqmAddClose(b(i,c.w));r(c)})}else i&&c.w.jqmAddClose(b(i,c.w));d.toTop&&c.o&&c.w.before('<span id="jqmP'+c.w[0]._jqm+'"></span>').insertAfter(c.o);d.onShow?d.onShow(c):c.w.show();r(c);return e},close:function(a){a=j[a];if(!a.a)return e;a.a=e;if(k[0]){k.pop();k[0]||p("unbind")}a.c.toTop&&a.o&&b("#jqmP"+a.w[0]._jqm).after(a.w).remove();if(a.c.onHide)a.c.onHide(a);else{a.w.hide();a.o&&a.o.remove()}return e},params:{}};var l=
0,j=b.jqm.hash,k=[],q=b.browser.msie&&b.browser.version=="6.0",e=false,r=function(a){var f=b('<iframe src="javascript:false;document.write(\'\');" class="jqm"></iframe>').css({opacity:0});if(q)if(a.o)a.o.html('<p style="width:100%;height:100%"/>').prepend(f);else b("iframe.jqm",a.w)[0]||a.w.prepend(f);s(a)},s=function(a){try{b(":input:visible",a.w)[0].focus()}catch(f){}},p=function(a){b(document)[a]("keypress",n)[a]("keydown",n)[a]("mousedown",n)},n=function(a){var f=j[k[k.length-1]];(a=!b(a.target).parents(".jqmID"+
f.s)[0])&&s(f);return!a},o=function(a,f,c){return a.each(function(){var d=this._jqm;b(f).each(function(){if(!this[c]){this[c]=[];b(this).click(function(){for(var i in{jqmShow:1,jqmHide:1})for(var g in this[i])if(j[this[i][g]])j[this[i][g]].w[i](this);return e})}this[c].push(d)})})}})(jQuery);
(function(b){b.fn.jqDrag=function(a){return l(this,a,"d")};b.fn.jqResize=function(a,e){return l(this,a,"r",e)};b.jqDnR={dnr:{},e:0,drag:function(a){if(c.k=="d")d.css({left:c.X+a.pageX-c.pX,top:c.Y+a.pageY-c.pY});else{d.css({width:Math.max(a.pageX-c.pX+c.W,0),height:Math.max(a.pageY-c.pY+c.H,0)});M1&&f.css({width:Math.max(a.pageX-M1.pX+M1.W,0),height:Math.max(a.pageY-M1.pY+M1.H,0)})}return false},stop:function(){b(document).unbind("mousemove",i.drag).unbind("mouseup",i.stop)}};var i=b.jqDnR,c=i.dnr,
d=i.e,f,l=function(a,e,n,m){return a.each(function(){e=e?b(e,a):a;e.bind("mousedown",{e:a,k:n},function(g){var j=g.data,h={};d=j.e;f=m?b(m):false;if(d.css("position")!="relative")try{d.position(h)}catch(o){}c={X:h.left||k("left")||0,Y:h.top||k("top")||0,W:k("width")||d[0].scrollWidth||0,H:k("height")||d[0].scrollHeight||0,pX:g.pageX,pY:g.pageY,k:j.k};M1=f&&j.k!="d"?{X:h.left||f1("left")||0,Y:h.top||f1("top")||0,W:f[0].offsetWidth||f1("width")||0,H:f[0].offsetHeight||f1("height")||0,pX:g.pageX,pY:g.pageY,
k:j.k}:false;if(b("input.hasDatepicker",d[0])[0])try{b("input.hasDatepicker",d[0]).datepicker("hide")}catch(p){}b(document).mousemove(b.jqDnR.drag).mouseup(b.jqDnR.stop);return false})})},k=function(a){return parseInt(d.css(a))||false};f1=function(a){return parseInt(f.css(a))||false}})(jQuery);
(function(b){b.jgrid.extend({setSubGrid:function(){return this.each(function(){var f;this.p.subGridOptions=b.extend({plusicon:"ui-icon-plus",minusicon:"ui-icon-minus",openicon:"ui-icon-carat-1-sw",expandOnLoad:false,delayOnLoad:50,selectOnExpand:false,reloadOnExpand:true},this.p.subGridOptions||{});this.p.colNames.unshift("");this.p.colModel.unshift({name:"subgrid",width:b.browser.safari?this.p.subGridWidth+this.p.cellLayout:this.p.subGridWidth,sortable:false,resizable:false,hidedlg:true,search:false,
fixed:true});f=this.p.subGridModel;if(f[0]){f[0].align=b.extend([],f[0].align||[]);for(var d=0;d<f[0].name.length;d++)f[0].align[d]=f[0].align[d]||"left"}})},addSubGridCell:function(f,d){var a="",n,s;this.each(function(){a=this.formatCol(f,d);s=this.p.id;n=this.p.subGridOptions.plusicon});return'<td role="grid" aria-describedby="'+s+'_subgrid" class="ui-sgcollapsed sgcollapsed" '+a+"><a href='javascript:void(0);'><span class='ui-icon "+n+"'></span></a></td>"},addSubGrid:function(f,d){return this.each(function(){var a=
this;if(a.grid){var n=function(g,j,e){j=b("<td align='"+a.p.subGridModel[0].align[e]+"'></td>").html(j);b(g).append(j)},s=function(g,j){var e,c,h,k=b("<table cellspacing='0' cellpadding='0' border='0'><tbody></tbody></table>"),i=b("<tr></tr>");for(c=0;c<a.p.subGridModel[0].name.length;c++){e=b("<th class='ui-state-default ui-th-subgrid ui-th-column ui-th-"+a.p.direction+"'></th>");b(e).html(a.p.subGridModel[0].name[c]);b(e).width(a.p.subGridModel[0].width[c]);b(i).append(e)}b(k).append(i);if(g){h=
a.p.xmlReader.subgrid;b(h.root+" "+h.row,g).each(function(){i=b("<tr class='ui-widget-content ui-subtblcell'></tr>");if(h.repeatitems===true)b(h.cell,this).each(function(m){n(i,b(this).text()||"&#160;",m)});else{var o=a.p.subGridModel[0].mapping||a.p.subGridModel[0].name;if(o)for(c=0;c<o.length;c++)n(i,b(o[c],this).text()||"&#160;",c)}b(k).append(i)})}e=b("table:first",a.grid.bDiv).attr("id")+"_";b("#"+e+j).append(k);a.grid.hDiv.loading=false;b("#load_"+a.p.id).hide();return false},v=function(g,j){var e,
c,h,k,i,o=b("<table cellspacing='0' cellpadding='0' border='0'><tbody></tbody></table>"),m=b("<tr></tr>");for(c=0;c<a.p.subGridModel[0].name.length;c++){e=b("<th class='ui-state-default ui-th-subgrid ui-th-column ui-th-"+a.p.direction+"'></th>");b(e).html(a.p.subGridModel[0].name[c]);b(e).width(a.p.subGridModel[0].width[c]);b(m).append(e)}b(o).append(m);if(g){k=a.p.jsonReader.subgrid;e=g[k.root];if(typeof e!=="undefined")for(c=0;c<e.length;c++){h=e[c];m=b("<tr class='ui-widget-content ui-subtblcell'></tr>");
if(k.repeatitems===true){if(k.cell)h=h[k.cell];for(i=0;i<h.length;i++)n(m,h[i]||"&#160;",i)}else{var u=a.p.subGridModel[0].mapping||a.p.subGridModel[0].name;if(u.length)for(i=0;i<u.length;i++)n(m,h[u[i]]||"&#160;",i)}b(o).append(m)}}c=b("table:first",a.grid.bDiv).attr("id")+"_";b("#"+c+j).append(o);a.grid.hDiv.loading=false;b("#load_"+a.p.id).hide();return false},z=function(g){var j,e,c,h;j=b(g).attr("id");e={nd_:(new Date).getTime()};e[a.p.prmNames.subgridid]=j;if(!a.p.subGridModel[0])return false;
if(a.p.subGridModel[0].params)for(h=0;h<a.p.subGridModel[0].params.length;h++)for(c=0;c<a.p.colModel.length;c++)if(a.p.colModel[c].name==a.p.subGridModel[0].params[h])e[a.p.colModel[c].name]=b("td:eq("+c+")",g).text().replace(/\&#160\;/ig,"");if(!a.grid.hDiv.loading){a.grid.hDiv.loading=true;b("#load_"+a.p.id).show();if(!a.p.subgridtype)a.p.subgridtype=a.p.datatype;if(b.isFunction(a.p.subgridtype))a.p.subgridtype.call(a,e);else a.p.subgridtype=a.p.subgridtype.toLowerCase();switch(a.p.subgridtype){case "xml":case "json":b.ajax(b.extend({type:a.p.mtype,
url:a.p.subGridUrl,dataType:a.p.subgridtype,data:b.isFunction(a.p.serializeSubGridData)?a.p.serializeSubGridData.call(a,e):e,complete:function(k){a.p.subgridtype=="xml"?s(k.responseXML,j):v(b.jgrid.parse(k.responseText),j)}},b.jgrid.ajaxOptions,a.p.ajaxSubgridOptions||{}))}}return false},l,t,w,x=0,p,q;b.each(a.p.colModel,function(){if(this.hidden===true||this.name=="rn"||this.name=="cb")x++});var y=a.rows.length,r=1;if(d!==undefined&&d>0){r=d;y=d+1}for(;r<y;){b(a.rows[r]).hasClass("jqgrow")&&b(a.rows[r].cells[f]).bind("click",
function(){var g=b(this).parent("tr")[0];q=g.nextSibling;if(b(this).hasClass("sgcollapsed")){t=a.p.id;l=g.id;if(a.p.subGridOptions.reloadOnExpand===true||a.p.subGridOptions.reloadOnExpand===false&&!b(q).hasClass("ui-subgrid")){w=f>=1?"<td colspan='"+f+"'>&#160;</td>":"";p=true;if(b.isFunction(a.p.subGridBeforeExpand))p=a.p.subGridBeforeExpand.call(a,t+"_"+l,l);if(p===false)return false;b(g).after("<tr role='row' class='ui-subgrid'>"+w+"<td class='ui-widget-content subgrid-cell'><span class='ui-icon "+
a.p.subGridOptions.openicon+"'></span></td><td colspan='"+parseInt(a.p.colNames.length-1-x,10)+"' class='ui-widget-content subgrid-data'><div id="+t+"_"+l+" class='tablediv'></div></td></tr>");b.isFunction(a.p.subGridRowExpanded)?a.p.subGridRowExpanded.call(a,t+"_"+l,l):z(g)}else b(q).show();b(this).html("<a href='javascript:void(0);'><span class='ui-icon "+a.p.subGridOptions.minusicon+"'></span></a>").removeClass("sgcollapsed").addClass("sgexpanded");a.p.subGridOptions.selectOnExpand&&b(a).jqGrid("setSelection",
l)}else if(b(this).hasClass("sgexpanded")){p=true;if(b.isFunction(a.p.subGridRowColapsed)){l=g.id;p=a.p.subGridRowColapsed.call(a,t+"_"+l,l)}if(p===false)return false;if(a.p.subGridOptions.reloadOnExpand===true)b(q).remove(".ui-subgrid");else b(q).hasClass("ui-subgrid")&&b(q).hide();b(this).html("<a href='javascript:void(0);'><span class='ui-icon "+a.p.subGridOptions.plusicon+"'></span></a>").removeClass("sgexpanded").addClass("sgcollapsed")}return false});a.p.subGridOptions.expandOnLoad===true&&
b(a.rows[r].cells[f]).trigger("click");r++}a.subGridXml=function(g,j){s(g,j)};a.subGridJson=function(g,j){v(g,j)}}})},expandSubGridRow:function(f){return this.each(function(){if(this.grid||f)if(this.p.subGrid===true){var d=b(this).jqGrid("getInd",f,true);if(d)(d=b("td.sgcollapsed",d)[0])&&b(d).trigger("click")}})},collapseSubGridRow:function(f){return this.each(function(){if(this.grid||f)if(this.p.subGrid===true){var d=b(this).jqGrid("getInd",f,true);if(d)(d=b("td.sgexpanded",d)[0])&&b(d).trigger("click")}})},
toggleSubGridRow:function(f){return this.each(function(){if(this.grid||f)if(this.p.subGrid===true){var d=b(this).jqGrid("getInd",f,true);if(d){var a=b("td.sgcollapsed",d)[0];if(a)b(a).trigger("click");else(a=b("td.sgexpanded",d)[0])&&b(a).trigger("click")}}})}})})(jQuery);
(function(e){e.jgrid.extend({groupingSetup:function(){return this.each(function(){var a=this.p.groupingView;if(a!==null&&(typeof a==="object"||e.isFunction(a)))if(a.groupField.length){if(typeof a.visibiltyOnNextGrouping=="undefined")a.visibiltyOnNextGrouping=[];for(var c=0;c<a.groupField.length;c++){a.groupOrder[c]||(a.groupOrder[c]="asc");a.groupText[c]||(a.groupText[c]="{0}");if(typeof a.groupColumnShow[c]!="boolean")a.groupColumnShow[c]=true;if(typeof a.groupSummary[c]!="boolean")a.groupSummary[c]=
false;if(a.groupColumnShow[c]===true){a.visibiltyOnNextGrouping[c]=true;e(this).jqGrid("showCol",a.groupField[c])}else{a.visibiltyOnNextGrouping[c]=e("#"+this.p.id+"_"+a.groupField[c]).is(":visible");e(this).jqGrid("hideCol",a.groupField[c])}a.sortitems[c]=[];a.sortnames[c]=[];a.summaryval[c]=[];if(a.groupSummary[c]){a.summary[c]=[];for(var b=this.p.colModel,d=0,g=b.length;d<g;d++)b[d].summaryType&&a.summary[c].push({nm:b[d].name,st:b[d].summaryType,v:""})}}this.p.scroll=false;this.p.rownumbers=false;
this.p.subGrid=false;this.p.treeGrid=false;this.p.gridview=true}else this.p.grouping=false;else this.p.grouping=false})},groupingPrepare:function(a,c,b,d){this.each(function(){c[0]+="";var g=c[0].toString().split(" ").join(""),h=this.p.groupingView,f=this;if(b.hasOwnProperty(g))b[g].push(a);else{b[g]=[];b[g].push(a);h.sortitems[0].push(g);h.sortnames[0].push(e.trim(c[0].toString()));h.summaryval[0][g]=e.extend(true,[],h.summary[0])}h.groupSummary[0]&&e.each(h.summaryval[0][g],function(){this.v=e.isFunction(this.st)?
this.st.call(f,this.v,this.nm,d):e(f).jqGrid("groupingCalculations."+this.st,this.v,this.nm,d)})});return b},groupingToggle:function(a){this.each(function(){var c=this.p.groupingView,b=a.lastIndexOf("_"),d=a.substring(0,b+1);b=parseInt(a.substring(b+1),10)+1;var g=c.minusicon,h=c.plusicon,f=e("#"+a);f=f.length?f[0].nextSibling:null;var k=e("#"+a+" span.tree-wrap-"+this.p.direction),l=false;if(k.hasClass(g)){if(c.showSummaryOnHide&&c.groupSummary[0]){if(f)for(;f;){if(e(f).hasClass("jqfoot"))break;
e(f).hide();f=f.nextSibling}}else if(f)for(;f;){if(e(f).attr("id")==d+String(b))break;e(f).hide();f=f.nextSibling}k.removeClass(g).addClass(h);l=true}else{if(f)for(;f;){if(e(f).attr("id")==d+String(b))break;e(f).show();f=f.nextSibling}k.removeClass(h).addClass(g)}e.isFunction(this.p.onClickGroup)&&this.p.onClickGroup.call(this,a,l)});return false},groupingRender:function(a,c){return this.each(function(){var b=this,d=b.p.groupingView,g="",h="",f,k=d.groupCollapse?d.plusicon:d.minusicon,l,r,m;if(!d.groupDataSorted){d.sortitems[0].sort();
d.sortnames[0].sort();if(d.groupOrder[0].toLowerCase()=="desc"){d.sortitems[0].reverse();d.sortnames[0].reverse()}}k+=" tree-wrap-"+b.p.direction;for(m=0;m<c;){if(b.p.colModel[m].name==d.groupField[0]){r=m;break}m++}e.each(d.sortitems[0],function(o,n){f=b.p.id+"ghead_"+o;h="<span style='cursor:pointer;' class='ui-icon "+k+"' onclick=\"jQuery('#"+b.p.id+"').jqGrid('groupingToggle','"+f+"');return false;\"></span>";try{l=b.formatter(f,d.sortnames[0][o],r,d.sortitems[0])}catch(v){l=d.sortnames[0][o]}g+=
'<tr id="'+f+'" role="row" class= "ui-widget-content jqgroup ui-row-'+b.p.direction+'"><td colspan="'+c+'">'+h+e.jgrid.format(d.groupText[0],l,a[n].length)+"</td></tr>";for(var i=0;i<a[n].length;i++)g+=a[n][i].join("");if(d.groupSummary[0]){i="";if(d.groupCollapse&&!d.showSummaryOnHide)i=' style="display:none;"';g+="<tr"+i+' role="row" class="ui-widget-content jqfoot ui-row-'+b.p.direction+'">';i=d.summaryval[0][n];for(var p=b.p.colModel,q,s=a[n].length,j=0;j<c;j++){var t="<td "+b.formatCol(j,1,"")+
">&#160;</td>",u="{0}";e.each(i,function(){if(this.nm==p[j].name){if(p[j].summaryTpl)u=p[j].summaryTpl;if(this.st=="avg")if(this.v&&s>0)this.v/=s;try{q=b.formatter("",this.v,j,this)}catch(w){q=this.v}t="<td "+b.formatCol(j,1,"")+">"+e.jgrid.format(u,q)+"</td>";return false}});g+=t}g+="</tr>"}});e("#"+b.p.id+" tbody:first").append(g);g=null})},groupingGroupBy:function(a,c){return this.each(function(){if(typeof a=="string")a=[a];var b=this.p.groupingView;this.p.grouping=true;if(typeof b.visibiltyOnNextGrouping==
"undefined")b.visibiltyOnNextGrouping=[];var d;for(d=0;d<b.groupField.length;d++)!b.groupColumnShow[d]&&b.visibiltyOnNextGrouping[d]&&e(this).jqGrid("showCol",b.groupField[d]);for(d=0;d<a.length;d++)b.visibiltyOnNextGrouping[d]=e("#"+this.p.id+"_"+a[d]).is(":visible");this.p.groupingView=e.extend(this.p.groupingView,c||{});b.groupField=a;e(this).trigger("reloadGrid")})},groupingRemove:function(a){return this.each(function(){if(typeof a=="undefined")a=true;this.p.grouping=false;if(a===true){for(var c=
this.p.groupingView,b=0;b<c.groupField.length;b++)!c.groupColumnShow[b]&&c.visibiltyOnNextGrouping[b]&&e(this).jqGrid("showCol",c.groupField);e("tr.jqgroup, tr.jqfoot","#"+this.p.id+" tbody:first").remove();e("tr.jqgrow:hidden","#"+this.p.id+" tbody:first").show()}else e(this).trigger("reloadGrid")})},groupingCalculations:{sum:function(a,c,b){return parseFloat(a||0)+parseFloat(b[c]||0)},min:function(a,c,b){if(a==="")return parseFloat(b[c]||0);return Math.min(parseFloat(a),parseFloat(b[c]||0))},max:function(a,
c,b){if(a==="")return parseFloat(b[c]||0);return Math.max(parseFloat(a),parseFloat(b[c]||0))},count:function(a,c,b){if(a==="")a=0;return b.hasOwnProperty(c)?a+1:0},avg:function(a,c,b){return parseFloat(a||0)+parseFloat(b[c]||0)}}})})(jQuery);
(function(d){d.jgrid.extend({setTreeNode:function(a,c){return this.each(function(){var b=this;if(b.grid&&b.p.treeGrid)for(var e=b.p.expColInd,g=b.p.treeReader.expanded_field,h=b.p.treeReader.leaf_field,f=b.p.treeReader.level_field,l=b.p.treeReader.icon_field,i=b.p.treeReader.loaded,j,o,n,k;a<c;){k=b.p.data[b.p._index[b.rows[a].id]];if(b.p.treeGridModel=="nested")if(!k[h]){j=parseInt(k[b.p.treeReader.left_field],10);o=parseInt(k[b.p.treeReader.right_field],10);k[h]=o===j+1?"true":"false";b.rows[a].cells[b.p._treeleafpos].innerHTML=
k[h]}j=parseInt(k[f],10);if(b.p.tree_root_level===0){n=j+1;o=j}else{n=j;o=j-1}n="<div class='tree-wrap tree-wrap-"+b.p.direction+"' style='width:"+n*18+"px;'>";n+="<div style='"+(b.p.direction=="rtl"?"right:":"left:")+o*18+"px;' class='ui-icon ";if(k[i]!==undefined)k[i]=k[i]=="true"||k[i]===true?true:false;if(k[h]=="true"||k[h]===true){n+=(k[l]!==undefined&&k[l]!==""?k[l]:b.p.treeIcons.leaf)+" tree-leaf treeclick";k[h]=true;o="leaf"}else{k[h]=false;o=""}k[g]=(k[g]=="true"||k[g]===true?true:false)&&
k[i];n+=k[g]===false?k[h]===true?"'":b.p.treeIcons.plus+" tree-plus treeclick'":k[h]===true?"'":b.p.treeIcons.minus+" tree-minus treeclick'";n+="></div></div>";d(b.rows[a].cells[e]).wrapInner("<span class='cell-wrapper"+o+"'></span>").prepend(n);if(j!==parseInt(b.p.tree_root_level,10))(k=(k=d(b).jqGrid("getNodeParent",k))&&k.hasOwnProperty(g)?k[g]:true)||d(b.rows[a]).css("display","none");d(b.rows[a].cells[e]).find("div.treeclick").bind("click",function(m){m=d(m.target||m.srcElement,b.rows).closest("tr.jqgrow")[0].id;
m=b.p._index[m];if(!b.p.data[m][h])if(b.p.data[m][g]){d(b).jqGrid("collapseRow",b.p.data[m]);d(b).jqGrid("collapseNode",b.p.data[m])}else{d(b).jqGrid("expandRow",b.p.data[m]);d(b).jqGrid("expandNode",b.p.data[m])}return false});b.p.ExpandColClick===true&&d(b.rows[a].cells[e]).find("span.cell-wrapper").css("cursor","pointer").bind("click",function(m){m=d(m.target||m.srcElement,b.rows).closest("tr.jqgrow")[0].id;var r=b.p._index[m];if(!b.p.data[r][h])if(b.p.data[r][g]){d(b).jqGrid("collapseRow",b.p.data[r]);
d(b).jqGrid("collapseNode",b.p.data[r])}else{d(b).jqGrid("expandRow",b.p.data[r]);d(b).jqGrid("expandNode",b.p.data[r])}d(b).jqGrid("setSelection",m);return false});a++}})},setTreeGrid:function(){return this.each(function(){var a=this,c=0,b=false,e,g,h=[];if(a.p.treeGrid){a.p.treedatatype||d.extend(a.p,{treedatatype:a.p.datatype});a.p.subGrid=false;a.p.altRows=false;a.p.pgbuttons=false;a.p.pginput=false;a.p.gridview=true;if(a.p.rowTotal===null)a.p.rowNum=1E4;a.p.multiselect=false;a.p.rowList=[];a.p.expColInd=
0;a.p.treeIcons=d.extend({plus:"ui-icon-triangle-1-"+(a.p.direction=="rtl"?"w":"e"),minus:"ui-icon-triangle-1-s",leaf:"ui-icon-radio-off"},a.p.treeIcons||{});if(a.p.treeGridModel=="nested")a.p.treeReader=d.extend({level_field:"level",left_field:"lft",right_field:"rgt",leaf_field:"isLeaf",expanded_field:"expanded",loaded:"loaded",icon_field:"icon"},a.p.treeReader);else if(a.p.treeGridModel=="adjacency")a.p.treeReader=d.extend({level_field:"level",parent_id_field:"parent",leaf_field:"isLeaf",expanded_field:"expanded",
loaded:"loaded",icon_field:"icon"},a.p.treeReader);for(g in a.p.colModel)if(a.p.colModel.hasOwnProperty(g)){e=a.p.colModel[g].name;if(e==a.p.ExpandColumn&&!b){b=true;a.p.expColInd=c}c++;for(var f in a.p.treeReader)a.p.treeReader[f]==e&&h.push(e)}d.each(a.p.treeReader,function(l,i){if(i&&d.inArray(i,h)===-1){if(l==="leaf_field")a.p._treeleafpos=c;c++;a.p.colNames.push(i);a.p.colModel.push({name:i,width:1,hidden:true,sortable:false,resizable:false,hidedlg:true,editable:true,search:false})}})}})},expandRow:function(a){this.each(function(){var c=
this;if(c.grid&&c.p.treeGrid){var b=d(c).jqGrid("getNodeChildren",a),e=c.p.treeReader.expanded_field;d(b).each(function(){var g=d.jgrid.getAccessor(this,c.p.localReader.id);d("#"+g,c.grid.bDiv).css("display","");this[e]&&d(c).jqGrid("expandRow",this)})}})},collapseRow:function(a){this.each(function(){var c=this;if(c.grid&&c.p.treeGrid){var b=d(c).jqGrid("getNodeChildren",a),e=c.p.treeReader.expanded_field;d(b).each(function(){var g=d.jgrid.getAccessor(this,c.p.localReader.id);d("#"+g,c.grid.bDiv).css("display",
"none");this[e]&&d(c).jqGrid("collapseRow",this)})}})},getRootNodes:function(){var a=[];this.each(function(){var c=this;if(c.grid&&c.p.treeGrid)switch(c.p.treeGridModel){case "nested":var b=c.p.treeReader.level_field;d(c.p.data).each(function(){parseInt(this[b],10)===parseInt(c.p.tree_root_level,10)&&a.push(this)});break;case "adjacency":var e=c.p.treeReader.parent_id_field;d(c.p.data).each(function(){if(this[e]===null||String(this[e]).toLowerCase()=="null")a.push(this)})}});return a},getNodeDepth:function(a){var c=
null;this.each(function(){if(this.grid&&this.p.treeGrid)switch(this.p.treeGridModel){case "nested":c=parseInt(a[this.p.treeReader.level_field],10)-parseInt(this.p.tree_root_level,10);break;case "adjacency":c=d(this).jqGrid("getNodeAncestors",a).length}});return c},getNodeParent:function(a){var c=null;this.each(function(){if(this.grid&&this.p.treeGrid)switch(this.p.treeGridModel){case "nested":var b=this.p.treeReader.left_field,e=this.p.treeReader.right_field,g=this.p.treeReader.level_field,h=parseInt(a[b],
10),f=parseInt(a[e],10),l=parseInt(a[g],10);d(this.p.data).each(function(){if(parseInt(this[g],10)===l-1&&parseInt(this[b],10)<h&&parseInt(this[e],10)>f){c=this;return false}});break;case "adjacency":var i=this.p.treeReader.parent_id_field,j=this.p.localReader.id;d(this.p.data).each(function(){if(this[j]==a[i]){c=this;return false}})}});return c},getNodeChildren:function(a){var c=[];this.each(function(){if(this.grid&&this.p.treeGrid)switch(this.p.treeGridModel){case "nested":var b=this.p.treeReader.left_field,
e=this.p.treeReader.right_field,g=this.p.treeReader.level_field,h=parseInt(a[b],10),f=parseInt(a[e],10),l=parseInt(a[g],10);d(this.p.data).each(function(){parseInt(this[g],10)===l+1&&parseInt(this[b],10)>h&&parseInt(this[e],10)<f&&c.push(this)});break;case "adjacency":var i=this.p.treeReader.parent_id_field,j=this.p.localReader.id;d(this.p.data).each(function(){this[i]==a[j]&&c.push(this)})}});return c},getFullTreeNode:function(a){var c=[];this.each(function(){var b;if(this.grid&&this.p.treeGrid)switch(this.p.treeGridModel){case "nested":var e=
this.p.treeReader.left_field,g=this.p.treeReader.right_field,h=this.p.treeReader.level_field,f=parseInt(a[e],10),l=parseInt(a[g],10),i=parseInt(a[h],10);d(this.p.data).each(function(){parseInt(this[h],10)>=i&&parseInt(this[e],10)>=f&&parseInt(this[e],10)<=l&&c.push(this)});break;case "adjacency":if(a){c.push(a);var j=this.p.treeReader.parent_id_field,o=this.p.localReader.id;d(this.p.data).each(function(n){b=c.length;for(n=0;n<b;n++)if(c[n][o]==this[j]){c.push(this);break}})}}});return c},getNodeAncestors:function(a){var c=
[];this.each(function(){if(this.grid&&this.p.treeGrid)for(var b=d(this).jqGrid("getNodeParent",a);b;){c.push(b);b=d(this).jqGrid("getNodeParent",b)}});return c},isVisibleNode:function(a){var c=true;this.each(function(){if(this.grid&&this.p.treeGrid){var b=d(this).jqGrid("getNodeAncestors",a),e=this.p.treeReader.expanded_field;d(b).each(function(){c=c&&this[e];if(!c)return false})}});return c},isNodeLoaded:function(a){var c;this.each(function(){if(this.grid&&this.p.treeGrid){var b=this.p.treeReader.leaf_field;
c=a!==undefined?a.loaded!==undefined?a.loaded:a[b]||d(this).jqGrid("getNodeChildren",a).length>0?true:false:false}});return c},expandNode:function(a){return this.each(function(){if(this.grid&&this.p.treeGrid){var c=this.p.treeReader.expanded_field,b=this.p.treeReader.parent_id_field,e=this.p.treeReader.loaded,g=this.p.treeReader.level_field,h=this.p.treeReader.left_field,f=this.p.treeReader.right_field;if(!a[c]){var l=d.jgrid.getAccessor(a,this.p.localReader.id),i=d("#"+l,this.grid.bDiv)[0],j=this.p._index[l];
if(d(this).jqGrid("isNodeLoaded",this.p.data[j])){a[c]=true;d("div.treeclick",i).removeClass(this.p.treeIcons.plus+" tree-plus").addClass(this.p.treeIcons.minus+" tree-minus")}else{a[c]=true;d("div.treeclick",i).removeClass(this.p.treeIcons.plus+" tree-plus").addClass(this.p.treeIcons.minus+" tree-minus");this.p.treeANode=i.rowIndex;this.p.datatype=this.p.treedatatype;this.p.treeGridModel=="nested"?d(this).jqGrid("setGridParam",{postData:{nodeid:l,n_left:a[h],n_right:a[f],n_level:a[g]}}):d(this).jqGrid("setGridParam",
{postData:{nodeid:l,parentid:a[b],n_level:a[g]}});d(this).trigger("reloadGrid");a[e]=true;this.p.treeGridModel=="nested"?d(this).jqGrid("setGridParam",{postData:{nodeid:"",n_left:"",n_right:"",n_level:""}}):d(this).jqGrid("setGridParam",{postData:{nodeid:"",parentid:"",n_level:""}})}}}})},collapseNode:function(a){return this.each(function(){if(this.grid&&this.p.treeGrid)if(a.expanded){a.expanded=false;var c=d.jgrid.getAccessor(a,this.p.localReader.id);c=d("#"+c,this.grid.bDiv)[0];d("div.treeclick",
c).removeClass(this.p.treeIcons.minus+" tree-minus").addClass(this.p.treeIcons.plus+" tree-plus")}})},SortTree:function(a,c,b,e){return this.each(function(){if(this.grid&&this.p.treeGrid){var g,h,f,l=[],i=this,j;g=d(this).jqGrid("getRootNodes");g=d.jgrid.from(g);g.orderBy(a,c,b,e);j=g.select();g=0;for(h=j.length;g<h;g++){f=j[g];l.push(f);d(this).jqGrid("collectChildrenSortTree",l,f,a,c,b,e)}d.each(l,function(o){var n=d.jgrid.getAccessor(this,i.p.localReader.id);d("#"+i.p.id+" tbody tr:eq("+o+")").after(d("tr#"+
n,i.grid.bDiv))});l=j=g=null}})},collectChildrenSortTree:function(a,c,b,e,g,h){return this.each(function(){if(this.grid&&this.p.treeGrid){var f,l,i,j;f=d(this).jqGrid("getNodeChildren",c);f=d.jgrid.from(f);f.orderBy(b,e,g,h);j=f.select();f=0;for(l=j.length;f<l;f++){i=j[f];a.push(i);d(this).jqGrid("collectChildrenSortTree",a,i,b,e,g,h)}}})},setTreeRow:function(a,c){var b=false;this.each(function(){if(this.grid&&this.p.treeGrid)b=d(this).jqGrid("setRowData",a,c)});return b},delTreeNode:function(a){return this.each(function(){var c=
this.p.localReader.id,b=this.p.treeReader.left_field,e=this.p.treeReader.right_field,g,h,f;if(this.grid&&this.p.treeGrid){var l=this.p._index[a];if(l!==undefined){g=parseInt(this.p.data[l][e],10);h=g-parseInt(this.p.data[l][b],10)+1;l=d(this).jqGrid("getFullTreeNode",this.p.data[l]);if(l.length>0)for(var i=0;i<l.length;i++)d(this).jqGrid("delRowData",l[i][c]);if(this.p.treeGridModel==="nested"){c=d.jgrid.from(this.p.data).greater(b,g,{stype:"integer"}).select();if(c.length)for(f in c)c[f][b]=parseInt(c[f][b],
10)-h;c=d.jgrid.from(this.p.data).greater(e,g,{stype:"integer"}).select();if(c.length)for(f in c)c[f][e]=parseInt(c[f][e],10)-h}}}})},addChildNode:function(a,c,b){var e=this[0];if(b){var g=e.p.treeReader.expanded_field,h=e.p.treeReader.leaf_field,f=e.p.treeReader.level_field,l=e.p.treeReader.parent_id_field,i=e.p.treeReader.left_field,j=e.p.treeReader.right_field,o=e.p.treeReader.loaded,n,k,m,r,p;n=0;var s=c,t;if(!a){p=e.p.data.length-1;if(p>=0)for(;p>=0;){n=Math.max(n,parseInt(e.p.data[p][e.p.localReader.id],
10));p--}a=n+1}var u=d(e).jqGrid("getInd",c);t=false;if(c===undefined||c===null||c===""){s=c=null;n="last";r=e.p.tree_root_level;p=e.p.data.length+1}else{n="after";k=e.p._index[c];m=e.p.data[k];c=m[e.p.localReader.id];r=parseInt(m[f],10)+1;p=d(e).jqGrid("getFullTreeNode",m);if(p.length){s=p=p[p.length-1][e.p.localReader.id];p=d(e).jqGrid("getInd",s)+1}else p=d(e).jqGrid("getInd",c)+1;if(m[h]){t=true;m[g]=true;d(e.rows[u]).find("span.cell-wrapperleaf").removeClass("cell-wrapperleaf").addClass("cell-wrapper").end().find("div.tree-leaf").removeClass(e.p.treeIcons.leaf+
" tree-leaf").addClass(e.p.treeIcons.minus+" tree-minus");e.p.data[k][h]=false;m[o]=true}}k=p+1;b[g]=false;b[o]=true;b[f]=r;b[h]=true;if(e.p.treeGridModel==="adjacency")b[l]=c;if(e.p.treeGridModel==="nested"){var q;if(c!==null){h=parseInt(m[j],10);f=d.jgrid.from(e.p.data);f=f.greaterOrEquals(j,h,{stype:"integer"});f=f.select();if(f.length)for(q in f){f[q][i]=f[q][i]>h?parseInt(f[q][i],10)+2:f[q][i];f[q][j]=f[q][j]>=h?parseInt(f[q][j],10)+2:f[q][j]}b[i]=h;b[j]=h+1}else{h=parseInt(d(e).jqGrid("getCol",
j,false,"max"),10);f=d.jgrid.from(e.p.data).greater(i,h,{stype:"integer"}).select();if(f.length)for(q in f)f[q][i]=parseInt(f[q][i],10)+2;f=d.jgrid.from(e.p.data).greater(j,h,{stype:"integer"}).select();if(f.length)for(q in f)f[q][j]=parseInt(f[q][j],10)+2;b[i]=h+1;b[j]=h+2}}if(c===null||d(e).jqGrid("isNodeLoaded",m)||t){d(e).jqGrid("addRowData",a,b,n,s);d(e).jqGrid("setTreeNode",p,k)}m&&!m[g]&&d(e.rows[u]).find("div.treeclick").click()}}})})(jQuery);
(function(b){b.jgrid.extend({jqGridImport:function(a){a=b.extend({imptype:"xml",impstring:"",impurl:"",mtype:"GET",impData:{},xmlGrid:{config:"roots>grid",data:"roots>rows"},jsonGrid:{config:"grid",data:"data"},ajaxOptions:{}},a||{});return this.each(function(){var d=this,c=function(f,g){var e=b(g.xmlGrid.config,f)[0],h=b(g.xmlGrid.data,f)[0],i;if(xmlJsonClass.xml2json&&b.jgrid.parse){e=xmlJsonClass.xml2json(e," ");e=b.jgrid.parse(e);for(var l in e)if(e.hasOwnProperty(l))i=e[l];if(h){h=e.grid.datatype;
e.grid.datatype="xmlstring";e.grid.datastr=f;b(d).jqGrid(i).jqGrid("setGridParam",{datatype:h})}else b(d).jqGrid(i)}else alert("xml2json or parse are not present")},j=function(f,g){if(f&&typeof f=="string"){var e=b.jgrid.parse(f),h=e[g.jsonGrid.config];if(e=e[g.jsonGrid.data]){var i=h.datatype;h.datatype="jsonstring";h.datastr=e;b(d).jqGrid(h).jqGrid("setGridParam",{datatype:i})}else b(d).jqGrid(h)}};switch(a.imptype){case "xml":b.ajax(b.extend({url:a.impurl,type:a.mtype,data:a.impData,dataType:"xml",
complete:function(f,g){if(g=="success"){c(f.responseXML,a);b.isFunction(a.importComplete)&&a.importComplete(f)}}},a.ajaxOptions));break;case "xmlstring":if(a.impstring&&typeof a.impstring=="string"){var k=b.jgrid.stringToDoc(a.impstring);if(k){c(k,a);b.isFunction(a.importComplete)&&a.importComplete(k);a.impstring=null}k=null}break;case "json":b.ajax(b.extend({url:a.impurl,type:a.mtype,data:a.impData,dataType:"json",complete:function(f,g){if(g=="success"){j(f.responseText,a);b.isFunction(a.importComplete)&&
a.importComplete(f)}}},a.ajaxOptions));break;case "jsonstring":if(a.impstring&&typeof a.impstring=="string"){j(a.impstring,a);b.isFunction(a.importComplete)&&a.importComplete(a.impstring);a.impstring=null}}})},jqGridExport:function(a){a=b.extend({exptype:"xmlstring",root:"grid",ident:"\t"},a||{});var d=null;this.each(function(){if(this.grid){var c=b.extend({},b(this).jqGrid("getGridParam"));if(c.rownumbers){c.colNames.splice(0,1);c.colModel.splice(0,1)}if(c.multiselect){c.colNames.splice(0,1);c.colModel.splice(0,
1)}if(c.subGrid){c.colNames.splice(0,1);c.colModel.splice(0,1)}c.knv=null;if(c.treeGrid)for(var j in c.treeReader)if(c.treeReader.hasOwnProperty(j)){c.colNames.splice(c.colNames.length-1);c.colModel.splice(c.colModel.length-1)}switch(a.exptype){case "xmlstring":d="<"+a.root+">"+xmlJsonClass.json2xml(c,a.ident)+"</"+a.root+">";break;case "jsonstring":d="{"+xmlJsonClass.toJson(c,a.root,a.ident,false)+"}";if(c.postData.filters!==undefined){d=d.replace(/filters":"/,'filters":');d=d.replace(/}]}"/,"}]}")}}}});
return d},excelExport:function(a){a=b.extend({exptype:"remote",url:null,oper:"oper",tag:"excel",exportOptions:{}},a||{});return this.each(function(){if(this.grid){var d;if(a.exptype=="remote"){d=b.extend({},this.p.postData);d[a.oper]=a.tag;d=jQuery.param(d);d=a.url.indexOf("?")!=-1?a.url+"&"+d:a.url+"?"+d;window.location=d}}})}})})(jQuery);
var xmlJsonClass={xml2json:function(a,b){if(a.nodeType===9)a=a.documentElement;var h=this.toJson(this.toObj(this.removeWhite(a)),a.nodeName,"\t");return"{\n"+b+(b?h.replace(/\t/g,b):h.replace(/\t|\n/g,""))+"\n}"},json2xml:function(a,b){var h=function(d,c,i){var g="",k,j;if(d instanceof Array)if(d.length===0)g+=i+"<"+c+">__EMPTY_ARRAY_</"+c+">\n";else{k=0;for(j=d.length;k<j;k+=1){var l=i+h(d[k],c,i+"\t")+"\n";g+=l}}else if(typeof d==="object"){k=false;g+=i+"<"+c;for(j in d)if(d.hasOwnProperty(j))if(j.charAt(0)===
"@")g+=" "+j.substr(1)+'="'+d[j].toString()+'"';else k=true;g+=k?">":"/>";if(k){for(j in d)if(d.hasOwnProperty(j))if(j==="#text")g+=d[j];else if(j==="#cdata")g+="<![CDATA["+d[j]+"]]\>";else if(j.charAt(0)!=="@")g+=h(d[j],j,i+"\t");g+=(g.charAt(g.length-1)==="\n"?i:"")+"</"+c+">"}}else if(typeof d==="function")g+=i+"<"+c+"><![CDATA["+d+"]]\></"+c+">";else{if(d===undefined)d="";g+=d.toString()==='""'||d.toString().length===0?i+"<"+c+">__EMPTY_STRING_</"+c+">":i+"<"+c+">"+d.toString()+"</"+c+">"}return g},
e="",f;for(f in a)if(a.hasOwnProperty(f))e+=h(a[f],f,"");return b?e.replace(/\t/g,b):e.replace(/\t|\n/g,"")},toObj:function(a){var b={},h=/function/i;if(a.nodeType===1){if(a.attributes.length){var e;for(e=0;e<a.attributes.length;e+=1)b["@"+a.attributes[e].nodeName]=(a.attributes[e].nodeValue||"").toString()}if(a.firstChild){var f=e=0,d=false,c;for(c=a.firstChild;c;c=c.nextSibling)if(c.nodeType===1)d=true;else if(c.nodeType===3&&c.nodeValue.match(/[^ \f\n\r\t\v]/))e+=1;else if(c.nodeType===4)f+=1;
if(d)if(e<2&&f<2){this.removeWhite(a);for(c=a.firstChild;c;c=c.nextSibling)if(c.nodeType===3)b["#text"]=this.escape(c.nodeValue);else if(c.nodeType===4)if(h.test(c.nodeValue))b[c.nodeName]=[b[c.nodeName],c.nodeValue];else b["#cdata"]=this.escape(c.nodeValue);else if(b[c.nodeName])if(b[c.nodeName]instanceof Array)b[c.nodeName][b[c.nodeName].length]=this.toObj(c);else b[c.nodeName]=[b[c.nodeName],this.toObj(c)];else b[c.nodeName]=this.toObj(c)}else if(a.attributes.length)b["#text"]=this.escape(this.innerXml(a));
else b=this.escape(this.innerXml(a));else if(e)if(a.attributes.length)b["#text"]=this.escape(this.innerXml(a));else{b=this.escape(this.innerXml(a));if(b==="__EMPTY_ARRAY_")b="[]";else if(b==="__EMPTY_STRING_")b=""}else if(f)if(f>1)b=this.escape(this.innerXml(a));else for(c=a.firstChild;c;c=c.nextSibling)if(h.test(a.firstChild.nodeValue)){b=a.firstChild.nodeValue;break}else b["#cdata"]=this.escape(c.nodeValue)}if(!a.attributes.length&&!a.firstChild)b=null}else if(a.nodeType===9)b=this.toObj(a.documentElement);
else alert("unhandled node type: "+a.nodeType);return b},toJson:function(a,b,h,e){if(e===undefined)e=true;var f=b?'"'+b+'"':"",d="\t",c="\n";if(!e)c=d="";if(a==="[]")f+=b?":[]":"[]";else if(a instanceof Array){var i,g,k=[];g=0;for(i=a.length;g<i;g+=1)k[g]=this.toJson(a[g],"",h+d,e);f+=(b?":[":"[")+(k.length>1?c+h+d+k.join(","+c+h+d)+c+h:k.join(""))+"]"}else if(a===null)f+=(b&&":")+"null";else if(typeof a==="object"){i=[];for(g in a)if(a.hasOwnProperty(g))i[i.length]=this.toJson(a[g],g,h+d,e);f+=(b?
":{":"{")+(i.length>1?c+h+d+i.join(","+c+h+d)+c+h:i.join(""))+"}"}else f+=typeof a==="string"?(b&&":")+'"'+a.replace(/\\/g,"\\\\").replace(/\"/g,'\\"')+'"':(b&&":")+'"'+a.toString()+'"';return f},innerXml:function(a){var b="";if("innerHTML"in a)b=a.innerHTML;else{var h=function(e){var f="",d;if(e.nodeType===1){f+="<"+e.nodeName;for(d=0;d<e.attributes.length;d+=1)f+=" "+e.attributes[d].nodeName+'="'+(e.attributes[d].nodeValue||"").toString()+'"';if(e.firstChild){f+=">";for(d=e.firstChild;d;d=d.nextSibling)f+=
h(d);f+="</"+e.nodeName+">"}else f+="/>"}else if(e.nodeType===3)f+=e.nodeValue;else if(e.nodeType===4)f+="<![CDATA["+e.nodeValue+"]]\>";return f};for(a=a.firstChild;a;a=a.nextSibling)b+=h(a)}return b},escape:function(a){return a.replace(/[\\]/g,"\\\\").replace(/[\"]/g,'\\"').replace(/[\n]/g,"\\n").replace(/[\r]/g,"\\r")},removeWhite:function(a){a.normalize();var b;for(b=a.firstChild;b;)if(b.nodeType===3)if(b.nodeValue.match(/[^ \f\n\r\t\v]/))b=b.nextSibling;else{var h=b.nextSibling;a.removeChild(b);
b=h}else{b.nodeType===1&&this.removeWhite(b);b=b.nextSibling}return a}};
function tableToGrid(n,o){jQuery(n).each(function(){if(!this.grid){jQuery(this).width("99%");var a=jQuery(this).width(),d=jQuery("tr td:first-child input[type=checkbox]:first",jQuery(this)),b=jQuery("tr td:first-child input[type=radio]:first",jQuery(this));d=d.length>0;b=!d&&b.length>0;var l=d||b,c=[],g=[];jQuery("th",jQuery(this)).each(function(){if(c.length===0&&l){c.push({name:"__selection__",index:"__selection__",width:0,hidden:true});g.push("__selection__")}else{c.push({name:jQuery(this).attr("id")||
jQuery.trim(jQuery.jgrid.stripHtml(jQuery(this).html())).split(" ").join("_"),index:jQuery(this).attr("id")||jQuery.trim(jQuery.jgrid.stripHtml(jQuery(this).html())).split(" ").join("_"),width:jQuery(this).width()||150});g.push(jQuery(this).html())}});var f=[],h=[],i=[];jQuery("tbody > tr",jQuery(this)).each(function(){var j={},e=0;jQuery("td",jQuery(this)).each(function(){if(e===0&&l){var k=jQuery("input",jQuery(this)),m=k.attr("value");h.push(m||f.length);k.is(":checked")&&i.push(m);j[c[e].name]=
k.attr("value")}else j[c[e].name]=jQuery(this).html();e++});e>0&&f.push(j)});jQuery(this).empty();jQuery(this).addClass("scroll");jQuery(this).jqGrid(jQuery.extend({datatype:"local",width:a,colNames:g,colModel:c,multiselect:d},o||{}));for(a=0;a<f.length;a++){b=null;if(h.length>0)if((b=h[a])&&b.replace)b=encodeURIComponent(b).replace(/[.\-%]/g,"_");if(b===null)b=a+1;jQuery(this).jqGrid("addRowData",b,f[a])}for(a=0;a<i.length;a++)jQuery(this).jqGrid("setSelection",i[a])}})};
(function(a){if(a.browser.msie&&a.browser.version==8)a.expr[":"].hidden=function(b){return b.offsetWidth===0||b.offsetHeight===0||b.style.display=="none"};a.jgrid._multiselect=false;if(a.ui)if(a.ui.multiselect){if(a.ui.multiselect.prototype._setSelected){var q=a.ui.multiselect.prototype._setSelected;a.ui.multiselect.prototype._setSelected=function(b,g){var c=q.call(this,b,g);if(g&&this.selectedList){var f=this.element;this.selectedList.find("li").each(function(){a(this).data("optionLink")&&a(this).data("optionLink").remove().appendTo(f)})}return c}}if(a.ui.multiselect.prototype.destroy)a.ui.multiselect.prototype.destroy=
function(){this.element.show();this.container.remove();a.Widget===undefined?a.widget.prototype.destroy.apply(this,arguments):a.Widget.prototype.destroy.apply(this,arguments)};a.jgrid._multiselect=true}a.jgrid.extend({sortableColumns:function(b){return this.each(function(){function g(){c.p.disableClick=true}var c=this,f=c.p.id;f={tolerance:"pointer",axis:"x",scrollSensitivity:"1",items:">th:not(:has(#jqgh_"+f+"_cb,#jqgh_"+f+"_rn,#jqgh_"+f+"_subgrid),:hidden)",placeholder:{element:function(h){return a(document.createElement(h[0].nodeName)).addClass(h[0].className+
" ui-sortable-placeholder ui-state-highlight").removeClass("ui-sortable-helper")[0]},update:function(h,j){j.height(h.currentItem.innerHeight()-parseInt(h.currentItem.css("paddingTop")||0,10)-parseInt(h.currentItem.css("paddingBottom")||0,10));j.width(h.currentItem.innerWidth()-parseInt(h.currentItem.css("paddingLeft")||0,10)-parseInt(h.currentItem.css("paddingRight")||0,10))}},update:function(h,j){var i=a(j.item).parent();i=a(">th",i);var l={},m=c.p.id+"_";a.each(c.p.colModel,function(k){l[this.name]=
k});var d=[];i.each(function(){var k=a(">div",this).get(0).id.replace(/^jqgh_/,"").replace(m,"");k in l&&d.push(l[k])});a(c).jqGrid("remapColumns",d,true,true);a.isFunction(c.p.sortable.update)&&c.p.sortable.update(d);setTimeout(function(){c.p.disableClick=false},50)}};if(c.p.sortable.options)a.extend(f,c.p.sortable.options);else if(a.isFunction(c.p.sortable))c.p.sortable={update:c.p.sortable};if(f.start){var e=f.start;f.start=function(h,j){g();e.call(this,h,j)}}else f.start=g;if(c.p.sortable.exclude)f.items+=
":not("+c.p.sortable.exclude+")";b.sortable(f).data("sortable").floating=true})},columnChooser:function(b){function g(d,k){if(d)if(typeof d=="string")a.fn[d]&&a.fn[d].apply(k,a.makeArray(arguments).slice(2));else a.isFunction(d)&&d.apply(k,a.makeArray(arguments).slice(2))}var c=this;if(!a("#colchooser_"+c[0].p.id).length){var f=a('<div id="colchooser_'+c[0].p.id+'" style="position:relative;overflow:hidden"><div><select multiple="multiple"></select></div></div>'),e=a("select",f);b=a.extend({width:420,
height:240,classname:null,done:function(d){d&&c.jqGrid("remapColumns",d,true)},msel:"multiselect",dlog:"dialog",dlog_opts:function(d){var k={};k[d.bSubmit]=function(){d.apply_perm();d.cleanup(false)};k[d.bCancel]=function(){d.cleanup(true)};return{buttons:k,close:function(){d.cleanup(true)},modal:d.modal?d.modal:false,resizable:d.resizable?d.resizable:true,width:d.width+20}},apply_perm:function(){a("option",e).each(function(){this.selected?c.jqGrid("showCol",h[this.value].name):c.jqGrid("hideCol",
h[this.value].name)});var d=[];a("option:selected",e).each(function(){d.push(parseInt(this.value,10))});a.each(d,function(){delete i[h[parseInt(this,10)].name]});a.each(i,function(){var k=parseInt(this,10);var p=d,o=k;if(o>=0){var n=p.slice(),r=n.splice(o,Math.max(p.length-o,o));if(o>p.length)o=p.length;n[o]=k;d=n.concat(r)}else d=void 0});b.done&&b.done.call(c,d)},cleanup:function(d){g(b.dlog,f,"destroy");g(b.msel,e,"destroy");f.remove();d&&b.done&&b.done.call(c)},msel_opts:{}},a.jgrid.col,b||{});
if(a.ui)if(a.ui.multiselect)if(b.msel=="multiselect"){if(!a.jgrid._multiselect){alert("Multiselect plugin loaded after jqGrid. Please load the plugin before the jqGrid!");return}b.msel_opts=a.extend(a.ui.multiselect.defaults,b.msel_opts)}b.caption&&f.attr("title",b.caption);if(b.classname){f.addClass(b.classname);e.addClass(b.classname)}if(b.width){a(">div",f).css({width:b.width,margin:"0 auto"});e.css("width",b.width)}if(b.height){a(">div",f).css("height",b.height);e.css("height",b.height-10)}var h=
c.jqGrid("getGridParam","colModel"),j=c.jqGrid("getGridParam","colNames"),i={},l=[];e.empty();a.each(h,function(d){i[this.name]=d;if(this.hidedlg)this.hidden||l.push(d);else e.append("<option value='"+d+"' "+(this.hidden?"":"selected='selected'")+">"+j[d]+"</option>")});var m=a.isFunction(b.dlog_opts)?b.dlog_opts.call(c,b):b.dlog_opts;g(b.dlog,f,m);m=a.isFunction(b.msel_opts)?b.msel_opts.call(c,b):b.msel_opts;g(b.msel,e,m)}},sortableRows:function(b){return this.each(function(){var g=this;if(g.grid)if(!g.p.treeGrid)if(a.fn.sortable){b=
a.extend({cursor:"move",axis:"y",items:".jqgrow"},b||{});if(b.start&&a.isFunction(b.start)){b._start_=b.start;delete b.start}else b._start_=false;if(b.update&&a.isFunction(b.update)){b._update_=b.update;delete b.update}else b._update_=false;b.start=function(c,f){a(f.item).css("border-width","0px");a("td",f.item).each(function(j){this.style.width=g.grid.cols[j].style.width});if(g.p.subGrid){var e=a(f.item).attr("id");try{a(g).jqGrid("collapseSubGridRow",e)}catch(h){}}b._start_&&b._start_.apply(this,
[c,f])};b.update=function(c,f){a(f.item).css("border-width","");g.p.rownumbers===true&&a("td.jqgrid-rownum",g.rows).each(function(e){a(this).html(e+1+(parseInt(g.p.page,10)-1)*parseInt(g.p.rowNum,10))});b._update_&&b._update_.apply(this,[c,f])};a("tbody:first",g).sortable(b);a("tbody:first",g).disableSelection()}})},gridDnD:function(b){return this.each(function(){function g(){var e=a.data(c,"dnd");a("tr.jqgrow:not(.ui-draggable)",c).draggable(a.isFunction(e.drag)?e.drag.call(a(c),e):e.drag)}var c=
this;if(c.grid)if(!c.p.treeGrid)if(a.fn.draggable&&a.fn.droppable){a("#jqgrid_dnd").html()===null&&a("body").append("<table id='jqgrid_dnd' class='ui-jqgrid-dnd'></table>");if(typeof b=="string"&&b=="updateDnD"&&c.p.jqgdnd===true)g();else{b=a.extend({drag:function(e){return a.extend({start:function(h,j){if(c.p.subGrid){var i=a(j.helper).attr("id");try{a(c).jqGrid("collapseSubGridRow",i)}catch(l){}}for(i=0;i<a.data(c,"dnd").connectWith.length;i++)a(a.data(c,"dnd").connectWith[i]).jqGrid("getGridParam",
"reccount")=="0"&&a(a.data(c,"dnd").connectWith[i]).jqGrid("addRowData","jqg_empty_row",{});j.helper.addClass("ui-state-highlight");a("td",j.helper).each(function(m){this.style.width=c.grid.headers[m].width+"px"});e.onstart&&a.isFunction(e.onstart)&&e.onstart.call(a(c),h,j)},stop:function(h,j){if(j.helper.dropped&&!e.dragcopy){var i=a(j.helper).attr("id");a(c).jqGrid("delRowData",i)}for(i=0;i<a.data(c,"dnd").connectWith.length;i++)a(a.data(c,"dnd").connectWith[i]).jqGrid("delRowData","jqg_empty_row");
e.onstop&&a.isFunction(e.onstop)&&e.onstop.call(a(c),h,j)}},e.drag_opts||{})},drop:function(e){return a.extend({accept:function(h){if(!a(h).hasClass("jqgrow"))return h;var j=a(h).closest("table.ui-jqgrid-btable");if(j.length>0&&a.data(j[0],"dnd")!==undefined){h=a.data(j[0],"dnd").connectWith;return a.inArray("#"+this.id,h)!=-1?true:false}return h},drop:function(h,j){if(a(j.draggable).hasClass("jqgrow")){var i=a(j.draggable).attr("id");i=j.draggable.parent().parent().jqGrid("getRowData",i);if(!e.dropbyname){var l=
0,m={},d,k=a("#"+this.id).jqGrid("getGridParam","colModel");try{for(var p in i){if(i.hasOwnProperty(p)&&k[l]){d=k[l].name;m[d]=i[p]}l++}i=m}catch(o){}}j.helper.dropped=true;if(e.beforedrop&&a.isFunction(e.beforedrop)){d=e.beforedrop.call(this,h,j,i,a("#"+c.id),a(this));if(typeof d!="undefined"&&d!==null&&typeof d=="object")i=d}if(j.helper.dropped){var n;if(e.autoid)if(a.isFunction(e.autoid))n=e.autoid.call(this,i);else{n=Math.ceil(Math.random()*1E3);n=e.autoidprefix+n}a("#"+this.id).jqGrid("addRowData",
n,i,e.droppos)}e.ondrop&&a.isFunction(e.ondrop)&&e.ondrop.call(this,h,j,i)}}},e.drop_opts||{})},onstart:null,onstop:null,beforedrop:null,ondrop:null,drop_opts:{activeClass:"ui-state-active",hoverClass:"ui-state-hover"},drag_opts:{revert:"invalid",helper:"clone",cursor:"move",appendTo:"#jqgrid_dnd",zIndex:5E3},dragcopy:false,dropbyname:false,droppos:"first",autoid:true,autoidprefix:"dnd_"},b||{});if(b.connectWith){b.connectWith=b.connectWith.split(",");b.connectWith=a.map(b.connectWith,function(e){return a.trim(e)});
a.data(c,"dnd",b);c.p.reccount!="0"&&!c.p.jqgdnd&&g();c.p.jqgdnd=true;for(var f=0;f<b.connectWith.length;f++)a(b.connectWith[f]).droppable(a.isFunction(b.drop)?b.drop.call(a(c),b):b.drop)}}}})},gridResize:function(b){return this.each(function(){var g=this;if(g.grid&&a.fn.resizable){b=a.extend({},b||{});if(b.alsoResize){b._alsoResize_=b.alsoResize;delete b.alsoResize}else b._alsoResize_=false;if(b.stop&&a.isFunction(b.stop)){b._stop_=b.stop;delete b.stop}else b._stop_=false;b.stop=function(c,f){a(g).jqGrid("setGridParam",
{height:a("#gview_"+g.p.id+" .ui-jqgrid-bdiv").height()});a(g).jqGrid("setGridWidth",f.size.width,b.shrinkToFit);b._stop_&&b._stop_.call(g,c,f)};b.alsoResize=b._alsoResize_?eval("("+("{'#gview_"+g.p.id+" .ui-jqgrid-bdiv':true,'"+b._alsoResize_+"':true}")+")"):a(".ui-jqgrid-bdiv","#gview_"+g.p.id);delete b._alsoResize_;a("#gbox_"+g.p.id).resizable(b)}})}})})(jQuery);

define("jqgrid", function(){});

(function($){
    $.fn.validationEngineLanguage = function(){
    };
    $.validationEngineLanguage = {
        newLang: function(){
            $.validationEngineLanguage.allRules = {
                "required": { // Add your regex rules here, you can take telephone as an example
                    "regex": "none",
                    "alertText": "* 此处不可空白",
                    "alertTextCheckboxMultiple": "* 请选择一个项目",
                    "alertTextCheckboxe": "* 您必须钩选此栏",
                    "alertTextDateRange": "* 日期范围不可空白"
                },
                "dateRange": {
                    "regex": "none",
                    "alertText": "* 无效的 ",
                    "alertText2": " 日期范围"
                },
                "dateTimeRange": {
                    "regex": "none",
                    "alertText": "* 无效的 ",
                    "alertText2": " 时间范围"
                },
                "minSize": {
                    "regex": "none",
                    "alertText": "* 最少 ",
                    "alertText2": " 个字符"
                },
                "maxSize": {
                    "regex": "none",
                    "alertText": "* 最多 ",
                    "alertText2": " 个字符"
                },
				"groupRequired": {
                    "regex": "none",
                    "alertText": "* 你必需选填其中一个栏位"
                },
                "min": {
                    "regex": "none",
                    "alertText": "* 最小值為 "
                },
                "max": {
                    "regex": "none",
                    "alertText": "* 最大值为 "
                },
                "past": {
                    "regex": "none",
                    "alertText": "* 日期必需早于 "
                },
                "future": {
                    "regex": "none",
                    "alertText": "* 日期必需晚于 "
                },	
                "maxCheckbox": {
                    "regex": "none",
                    "alertText": "* 最多选取 ",
                    "alertText2": " 个项目"
                },
                "minCheckbox": {
                    "regex": "none",
                    "alertText": "* 请选择 ",
                    "alertText2": " 个项目"
                },
                "equals": {
                    "regex": "none",
                    "alertText": "* 请输入与上面相同的密码"
                },
                "creditCard": {
                    "regex": "none",
                    "alertText": "* 无效的信用卡号码"
                },
                "phone": {
                    // credit: jquery.h5validate.js / orefalo
                    "regex": /^([\+][0-9]{1,3}[ \.\-])?([\(]{1}[0-9]{2,6}[\)])?([0-9 \.\-\/]{3,20})((x|ext|extension)[ ]?[0-9]{1,4})?$/,
                    "alertText": "* 无效的电话号码"
                },
                "email": {
                    // Shamelessly lifted from Scott Gonzalez via the Bassistance Validation plugin http://projects.scottsplayground.com/email_address_validation/
                    "regex": /^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i,
                    "alertText": "* 邮件地址无效"
                },
                "integer": {
                    "regex": /^[\-\+]?\d+$/,
                    "alertText": "* 不是有效的整数"
                },
                "number": {
                    // Number, including positive, negative, and floating decimal. credit: orefalo
                    "regex": /^[\-\+]?(([0-9]+)([\.,]([0-9]+))?|([\.,]([0-9]+))?)$/,
                    "alertText": "* 无效的数字"
                },
                "date": {
                    "regex": /^\d{4}[\/\-](0?[1-9]|1[012])[\/\-](0?[1-9]|[12][0-9]|3[01])$/,
                    "alertText": "* 无效的日期，格式必需为 YYYY-MM-DD"
                },
                "ipv4": {
                    "regex": /^((([01]?[0-9]{1,2})|(2[0-4][0-9])|(25[0-5]))[.]){3}(([0-1]?[0-9]{1,2})|(2[0-4][0-9])|(25[0-5]))$/,
                    "alertText": "* 无效的 IP 地址"
                },
                "url": {
                    "regex": /^(https?|ftp):\/\/(((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:)*@)?(((\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5]))|((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?)(:\d*)?)(\/((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)+(\/(([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)*)*)?)?(\?((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|[\uE000-\uF8FF]|\/|\?)*)?(\#((([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|\/|\?)*)?$/i,
                    "alertText": "* Invalid URL"
                },
                "onlyNumberSp": {
                    "regex": /^[0-9\ ]+$/,
                    "alertText": "* 只能填数字"
                },
                "onlyLetterSp": {
                    "regex": /^[a-zA-Z\ \']+$/,
                    "alertText": "* 只接受英文字母大小写"
                },
                "onlyLetterNumber": {
                    "regex": /^[0-9a-zA-Z]+$/,
                    "alertText": "* 不接受特殊字符"
                },
                // --- CUSTOM RULES -- Those are specific to the demos, they can be removed or changed to your likings
                "ajaxUserCall": {
                    "url": "ajaxValidateFieldUser",
                    // you may want to pass extra data on the ajax call
                    "extraData": "name=eric",
                    "alertText": "* 此名称已被其他人使用",
                    "alertTextLoad": "* 正在确认名称是否有其他人使用，请稍等。"
                },
				"ajaxUserCallPhp": {
                    "url": "phpajax/ajaxValidateFieldUser.php",
                    // you may want to pass extra data on the ajax call
                    "extraData": "name=eric",
                    // if you provide an "alertTextOk", it will show as a green prompt when the field validates
                    "alertTextOk": "* 此帐号名称可以使用",
                    "alertText": "* 此名称已被其他人使用",
                    "alertTextLoad": "* 正在确认帐号名称是否有其他人使用，请稍等。"
                },
                "ajaxNameCall": {
                    // remote json service location
                    "url": "ajaxValidateFieldName",
                    // error
                    "alertText": "* 此名称可以使用",
                    // if you provide an "alertTextOk", it will show as a green prompt when the field validates
                    "alertTextOk": "* 此名称已被其他人使用",
                    // speaks by itself
                    "alertTextLoad": "* 正在确认名称是否有其他人使用，请稍等。"
                },
				 "ajaxNameCallPhp": {
	                    // remote json service location
	                    "url": "phpajax/ajaxValidateFieldName.php",
	                    // error
	                    "alertText": "* 此名称已被其他人使用",
	                    // speaks by itself
	                    "alertTextLoad": "* 正在确认名称是否有其他人使用，请稍等。"
	                },
                "validate2fields": {
                    "alertText": "* 请输入 HELLO"
                },
	            //tls warning:homegrown not fielded 
                "dateFormat":{
                    "regex": /^\d{4}[\/\-](0?[1-9]|1[012])[\/\-](0?[1-9]|[12][0-9]|3[01])$|^(?:(?:(?:0?[13578]|1[02])(\/|-)31)|(?:(?:0?[1,3-9]|1[0-2])(\/|-)(?:29|30)))(\/|-)(?:[1-9]\d\d\d|\d[1-9]\d\d|\d\d[1-9]\d|\d\d\d[1-9])$|^(?:(?:0?[1-9]|1[0-2])(\/|-)(?:0?[1-9]|1\d|2[0-8]))(\/|-)(?:[1-9]\d\d\d|\d[1-9]\d\d|\d\d[1-9]\d|\d\d\d[1-9])$|^(0?2(\/|-)29)(\/|-)(?:(?:0[48]00|[13579][26]00|[2468][048]00)|(?:\d\d)?(?:0[48]|[2468][048]|[13579][26]))$/,
                    "alertText": "* 无效的日期格式"
                },
                //tls warning:homegrown not fielded 
				"dateTimeFormat": {
	                "regex": /^\d{4}[\/\-](0?[1-9]|1[012])[\/\-](0?[1-9]|[12][0-9]|3[01])\s+(1[012]|0?[1-9]){1}:(0?[1-5]|[0-6][0-9]){1}:(0?[0-6]|[0-6][0-9]){1}\s+(am|pm|AM|PM){1}$|^(?:(?:(?:0?[13578]|1[02])(\/|-)31)|(?:(?:0?[1,3-9]|1[0-2])(\/|-)(?:29|30)))(\/|-)(?:[1-9]\d\d\d|\d[1-9]\d\d|\d\d[1-9]\d|\d\d\d[1-9])$|^((1[012]|0?[1-9]){1}\/(0?[1-9]|[12][0-9]|3[01]){1}\/\d{2,4}\s+(1[012]|0?[1-9]){1}:(0?[1-5]|[0-6][0-9]){1}:(0?[0-6]|[0-6][0-9]){1}\s+(am|pm|AM|PM){1})$/,
                    "alertText": "* 无效的日期或时间格式",
                    "alertText2": "可接受的格式： ",
                    "alertText3": "mm/dd/yyyy hh:mm:ss AM|PM 或 ", 
                    "alertText4": "yyyy-mm-dd hh:mm:ss AM|PM"
	            }
            };
            
        }
    };
    $.validationEngineLanguage.newLang();
})(jQuery);

define("validate-i18n", function(){});

/*
 * Inline Form Validation Engine 2.5.1, jQuery plugin
 *
 * Copyright(c) 2010, Cedric Dugas
 * http://www.position-absolute.com
 *
 * 2.0 Rewrite by Olivier Refalo
 * http://www.crionics.com
 *
 * Form validation engine allowing custom regex rules to be added.
 * Licensed under the MIT License
 */
 (function($) {

	 

	 var methods = {

		 /**
		 * Kind of the constructor, called before any action
		 * @param {Map} user options
		 */
		 init: function(options) {
			 var form = this;
			 if (!form.data('jqv') || form.data('jqv') == null ) {
				 options = methods._saveOptions(form, options);
				 // bind all formError elements to close on click
				 $(".formError").live("click", function() {
					 $(this).fadeOut(150, function() {
						 // remove prompt once invisible
						 $(this).parent('.formErrorOuter').remove();
						 $(this).remove();
					 });
				 });

			 }
			 return this;
		 },
		/**
		* Attachs jQuery.validationEngine to form.submit and field.blur events
		* Takes an optional params: a list of options
		* ie. jQuery("#formID1").validationEngine('attach', {promptPosition : "centerRight"});
		*/
		attach: function(userOptions) {

			var form = this;
			var options;

			if(userOptions)
				options = methods._saveOptions(form, userOptions);
			else
				options = form.data('jqv');

			options.validateAttribute = (form.find("[data-validation-engine*=validate]").length) ? "data-validation-engine" : "class";
			if (options.binded) {

				// bind fields
				form.find("["+options.validateAttribute+"*=validate]").not("[type=checkbox]").not("[type=radio]").not(".datepicker").bind(options.validationEventTrigger, methods._onFieldEvent);
				form.find("["+options.validateAttribute+"*=validate][type=checkbox],["+options.validateAttribute+"*=validate][type=radio]").bind("click", methods._onFieldEvent);
				form.find("["+options.validateAttribute+"*=validate][class*=datepicker]").bind(options.validationEventTrigger,{"delay": 300}, methods._onFieldEvent);
			}
			if (options.autoPositionUpdate) {
				$(window).bind("resize", {
					"noAnimation": true,
					"formElem": form
				}, methods.updatePromptsPosition);
			}
			// bind form.submit
			form.bind("submit", methods._onSubmitEvent);
			return this;
		},
		/**
		* Unregisters any bindings that may point to jQuery.validaitonEngine
		*/
		detach: function() {
			var form = this;
			var options = form.data('jqv');

			// unbind fields
			form.find("["+options.validateAttribute+"*=validate]").not("[type=checkbox]").unbind(options.validationEventTrigger, methods._onFieldEvent);
			form.find("["+options.validateAttribute+"*=validate][type=checkbox],[class*=validate][type=radio]").unbind("click", methods._onFieldEvent);

			// unbind form.submit
			form.unbind("submit", methods.onAjaxFormComplete);

			// unbind live fields (kill)
			form.find("["+options.validateAttribute+"*=validate]").not("[type=checkbox]").die(options.validationEventTrigger, methods._onFieldEvent);
			form.find("["+options.validateAttribute+"*=validate][type=checkbox]").die("click", methods._onFieldEvent);

			// unbind form.submit
			form.die("submit", methods.onAjaxFormComplete);
			form.removeData('jqv');

			if (options.autoPositionUpdate) {
				$(window).unbind("resize", methods.updatePromptsPosition)
			}

			return this;
		},
		/**
		* Validates the form fields, shows prompts accordingly.
		* Note: There is no ajax form validation with this method, only field ajax validation are evaluated
		*
		* @return true if the form validates, false if it fails
		*/
		 validate: function() {
			 return methods._validateFields(this);
		 },
		 /**
		 * Validates one field, shows prompt accordingly.
		 * Note: There is no ajax form validation with this method, only field ajax validation are evaluated
		 *
		 * @return true if the form validates, false if it fails
		 */
		 validateField: function(el) {
			 var options = $(this).data('jqv');
			 var r = methods._validateField($(el), options);

			 if (options.onSuccess && options.InvalidFields.length == 0)
			 	options.onSuccess();
			 else if (options.onFailure && options.InvalidFields.length > 0)
			 	options.onFailure();

			 return r;
		 },
		 /**
		 * Validates the form fields, shows prompts accordingly.
		 * Note: this methods performs fields and form ajax validations(if setup)
		 *
		 * @return true if the form validates, false if it fails, undefined if ajax is used for form validation
		 */
		 validateform: function() {
			 return methods._onSubmitEvent.call(this);
		 },
		/**
		*  Redraw prompts position, useful when you change the DOM state when validating
		*/
		updatePromptsPosition: function(event) {

			if (event && this == window) {
				var form = event.data.formElem;
				var noAnimation = event.data.noAnimation;
			}
			else
			var form = $(this.closest('form'));

			var options = form.data('jqv');
			// No option, take default one
			form.find('['+options.validateAttribute+'*=validate]').not(':hidden').not(":disabled").each(function(){
				var field = $(this);
				var prompt = methods._getPrompt(field);
				var promptText = $(prompt).find(".formErrorContent").html();

				if(prompt)
				methods._updatePrompt(field, $(prompt), promptText, undefined, false, options, noAnimation);
			});
			return this;
		},
		/**
		* Displays a prompt on a element.
		* Note that the element needs an id!
		*
		* @param {String} promptText html text to display type
		* @param {String} type the type of bubble: 'pass' (green), 'load' (black) anything else (red)
		* @param {String} possible values topLeft, topRight, bottomLeft, centerRight, bottomRight
		*/
		showPrompt: function(promptText, type, promptPosition, showArrow) {

			var form = this.closest('form');
			var options = form.data('jqv');
			// No option, take default one
			if(!options) options = methods._saveOptions(this, options);
			if(promptPosition)
			options.promptPosition=promptPosition;
			options.showArrow = showArrow==true;

			methods._showPrompt(this, promptText, type, false, options);
			return this;
		},
		/**
		* Closes all error prompts on the page
		*/
		hidePrompt: function() {
			var form = this;
			var options = form.data('jqv');
			var promptClass =  "."+ methods._getClassName($(this).attr("id")) + "formError";
			$(promptClass).fadeTo(options.fadeDuration, 0.3, function() {
				$(this).parent('.formErrorOuter').remove();
				$(this).remove();
			});
			return this;
		},
		/**
		* Closes form error prompts, CAN be invidual
		*/
		 hide: function() {
			 var form = this;
			 var options = this.data('jqv');
			 var closingtag;
			 if($(this).is("form")){
				 closingtag = "parentForm"+methods._getClassName($(this).attr("id"));
			 }else{
				 closingtag = methods._getClassName($(this).attr("id")) +"formError";
				 options = this.closest("form").data("jqv");
			 }
			 
			 $('.'+closingtag).fadeTo(options.fadeDuration, 0.3, function() {
				 $(this).parent('.formErrorOuter').remove();
				 $(this).remove();
			 });
			 return this;
		 },
		 /**
		 * Closes all error prompts on the page
		 */
		 hideAll: function() {
			 var form = this;
			 var options = form.data('jqv');
			 $('.formError').fadeTo(options.fadeDuration, 0.3, function() {
				 $(this).parent('.formErrorOuter').remove();
				 $(this).remove();
			 });
			 return this;
		 },
		/**
		* Typically called when user exists a field using tab or a mouse click, triggers a field
		* validation
		*/
		_onFieldEvent: function(event) {
			var field = $(this);
			var form = field.closest('form');
			var options = form.data('jqv');
			// validate the current field
			window.setTimeout(function() {
				methods._validateField(field, options);
				if (options.InvalidFields.length == 0 && options.onSuccess) {
					options.onSuccess();
				} else if (options.InvalidFields.length > 0 && options.onFailure) {
					options.onFailure();
				}
			}, (event.data) ? event.data.delay : 0);

		},
		/**
		* Called when the form is submited, shows prompts accordingly
		*
		* @param {jqObject}
		*            form
		* @return false if form submission needs to be cancelled
		*/
		_onSubmitEvent: function() {
			var form = $(this);
			var options = form.data('jqv');

			// validate each field 
			// (- skip field ajax validation, not necessary IF we will perform an ajax form validation)
			var r=methods._validateFields(form, options.ajaxFormValidation);

			if (r && options.ajaxFormValidation) {
				methods._validateFormWithAjax(form, options);
				return false;
			}

			if(options.onValidationComplete) {
				options.onValidationComplete(form, r);
				return false;
			}
			return r;
		},
		/**
		* Return true if the ajax field validations passed so far
		* @param {Object} options
		* @return true, is all ajax validation passed so far (remember ajax is async)
		*/
		_checkAjaxStatus: function(options) {
			var status = true;
			$.each(options.ajaxValidCache, function(key, value) {
				if (!value) {
					status = false;
					// break the each
					return false;
				}
			});
			return status;
		},
		/**
		* Validates form fields, shows prompts accordingly
		*
		* @param {jqObject}
		*            form
		* @param {skipAjaxFieldValidation}
		*            boolean - when set to true, ajax field validation is skipped, typically used when the submit button is clicked
		*
		* @return true if form is valid, false if not, undefined if ajax form validation is done
		*/
		_validateFields: function(form, skipAjaxValidation) {
			var options = form.data('jqv');

			// this variable is set to true if an error is found
			var errorFound = false;

			// Trigger hook, start validation
			form.trigger("jqv.form.validating");
			// first, evaluate status of non ajax fields
			var first_err=null;
			form.find('['+options.validateAttribute+'*=validate]').not(':hidden').not(":disabled").each( function() {
		            var field = $(this);
		            var names = [];
		            if ($.inArray(field.attr('name'), names) < 0) {                   
		                errorFound |= methods._validateField(field, options, skipAjaxValidation);
		                if (options.doNotShowAllErrosOnSubmit)
		                    return false;
		                if (errorFound && first_err==null) {
		                    first_err=field;
		                }
		                names.push(field.attr('name'));
		            }
			});

			// second, check to see if all ajax calls completed ok
			// errorFound |= !methods._checkAjaxStatus(options);

			// third, check status and scroll the container accordingly
			form.trigger("jqv.form.result", [errorFound]);

			if (errorFound) {
				if (options.scroll) {
					var destination=first_err.offset().top;
					var fixleft = first_err.offset().left;

					//prompt positioning adjustment support. Usage: positionType:Xshift,Yshift (for ex.: bottomLeft:+20 or bottomLeft:-20,+10)
					var positionType=options.promptPosition;
					if (typeof(positionType)=='string' && positionType.indexOf(":")!=-1)
						positionType=positionType.substring(0,positionType.indexOf(":"));

					if (positionType!="bottomRight" && positionType!="bottomLeft") {
						var prompt_err= methods._getPrompt(first_err);
						destination=prompt_err.offset().top;
					}

					// get the position of the first error, there should be at least one, no need to check this
					//var destination = form.find(".formError:not('.greenPopup'):first").offset().top;
					if (options.isOverflown) {
						var overflowDIV = $(options.overflownDIV);
						if(!overflowDIV.length) return false;
						var scrollContainerScroll = overflowDIV.scrollTop();
						var scrollContainerPos = -parseInt(overflowDIV.offset().top);

						destination += scrollContainerScroll + scrollContainerPos - 5;
						var scrollContainer = $(options.overflownDIV + ":not(:animated)");

						scrollContainer.animate({ scrollTop: destination }, 1100, function(){
							if(options.focusFirstField) first_err.focus();
						});
					} else {
						$("html:not(:animated),body:not(:animated)").animate({
							scrollTop: destination,
							scrollLeft: fixleft
						}, 1100, function(){
							if(options.focusFirstField) first_err.focus();
						});
					}

				} else if(options.focusFirstField)
					first_err.focus();
				return false;
			}
			return true;
		},
		/**
		* This method is called to perform an ajax form validation.
		* During this process all the (field, value) pairs are sent to the server which returns a list of invalid fields or true
		*
		* @param {jqObject} form
		* @param {Map} options
		*/
		_validateFormWithAjax: function(form, options) {

			var data = form.serialize();
			var url = (options.ajaxFormValidationURL) ? options.ajaxFormValidationURL : form.attr("action");
			$.ajax({
				type: "GET",
				url: url,
				cache: false,
				dataType: "json",
				data: data,
				form: form,
				methods: methods,
				options: options,
				beforeSend: function() {
					return options.onBeforeAjaxFormValidation(form, options);
				},
				error: function(data, transport) {
					methods._ajaxError(data, transport);
				},
				success: function(json) {
					if (json !== true) {
						// getting to this case doesn't necessary means that the form is invalid
						// the server may return green or closing prompt actions
						// this flag helps figuring it out
						var errorInForm=false;
						for (var i = 0; i < json.length; i++) {
							var value = json[i];

							var errorFieldId = value[0];
							var errorField = $($("#" + errorFieldId)[0]);

							// make sure we found the element
							if (errorField.length == 1) {

								// promptText or selector
								var msg = value[2];
								// if the field is valid
								if (value[1] == true) {

									if (msg == ""  || !msg){
										// if for some reason, status==true and error="", just close the prompt
										methods._closePrompt(errorField);
									} else {
										// the field is valid, but we are displaying a green prompt
										if (options.allrules[msg]) {
											var txt = options.allrules[msg].alertTextOk;
											if (txt)
												msg = txt;
										}
										methods._showPrompt(errorField, msg, "pass", false, options, true);
									}
								} else {
									// the field is invalid, show the red error prompt
									errorInForm|=true;
									if (options.allrules[msg]) {
										var txt = options.allrules[msg].alertText;
										if (txt)
											msg = txt;
									}
									methods._showPrompt(errorField, msg, "", false, options, true);
								}
							}
						}
						options.onAjaxFormComplete(!errorInForm, form, json, options);
					} else
						options.onAjaxFormComplete(true, form, "", options);
				}
			});

		},
		/**
		* Validates field, shows prompts accordingly
		*
		* @param {jqObject}
		*            field
		* @param {Array[String]}
		*            field's validation rules
		* @param {Map}
		*            user options
		* @return true if field is valid
		*/
		_validateField: function(field, options, skipAjaxValidation) {
			if (!field.attr("id"))
				$.error("jQueryValidate: an ID attribute is required for this field: " + field.attr("name") + " class:" +
			field.attr("class"));

			var rulesParsing = field.attr(options.validateAttribute);
			var getRules = /validate\[(.*)\]/.exec(rulesParsing);

			if (!getRules)
				return false;
			var str = getRules[1];
			var rules = str.split(/\[|,|\]/);

			// true if we ran the ajax validation, tells the logic to stop messing with prompts
			var isAjaxValidator = false;
			var fieldName = field.attr("name");
			var promptText = "";
			var required = false;
			options.isError = false;
			options.showArrow = true;

			var form = $(field.closest("form"));

			for (var i = 0; i < rules.length; i++) {
				// Fix for adding spaces in the rules
				rules[i] = rules[i].replace(" ", "")
				var errorMsg = undefined;
				switch (rules[i]) {

					case "required":
						required = true;
						errorMsg = methods._required(field, rules, i, options);
						break;
					case "custom":
						errorMsg = methods._customRegex(field, rules, i, options);
						break;
					case "groupRequired":
						// Check is its the first of group, if not, reload validation with first field
						// AND continue normal validation on present field
						var classGroup = "["+options.validateAttribute+"*=" +rules[i + 1] +"]";
						var firstOfGroup = form.find(classGroup).eq(0);
						if(firstOfGroup[0] != field[0]){
							methods._validateField(firstOfGroup, options, skipAjaxValidation)
							options.showArrow = true;
							continue;
						};
						errorMsg = methods._groupRequired(field, rules, i, options);
						if(errorMsg) required = true;
						options.showArrow = false;
						break;
					case "ajax":
						// ajax has its own prompts handling technique
						if(!skipAjaxValidation){
							methods._ajax(field, rules, i, options);
							isAjaxValidator = true;
						}
						break;
					case "minSize":
						errorMsg = methods._minSize(field, rules, i, options);
						break;
					case "maxSize":
						errorMsg = methods._maxSize(field, rules, i, options);
						break;
					case "min":
						errorMsg = methods._min(field, rules, i, options);
						break;
					case "max":
						errorMsg = methods._max(field, rules, i, options);
						break;
					case "past":
						errorMsg = methods._past(field, rules, i, options);
						break;
					case "future":
						errorMsg = methods._future(field, rules, i, options);
						break;
					case "dateRange":
						var classGroup = "["+options.validateAttribute+"*=" + rules[i + 1] + "]";
						var firstOfGroup = form.find(classGroup).eq(0);
						var secondOfGroup = form.find(classGroup).eq(1);

						//if one entry out of the pair has value then proceed to run through validation
						if (firstOfGroup[0].value || secondOfGroup[0].value) {
							errorMsg = methods._dateRange(firstOfGroup, secondOfGroup, rules, i, options);
						}
						if (errorMsg) required = true;
						options.showArrow = false;
						break;

					case "dateTimeRange":
						var classGroup = "["+options.validateAttribute+"*=" + rules[i + 1] + "]";
						var firstOfGroup = form.find(classGroup).eq(0);
						var secondOfGroup = form.find(classGroup).eq(1);

						//if one entry out of the pair has value then proceed to run through validation
						if (firstOfGroup[0].value || secondOfGroup[0].value) {
							errorMsg = methods._dateTimeRange(firstOfGroup, secondOfGroup, rules, i, options);
						}
						if (errorMsg) required = true;
						options.showArrow = false;
						break;
					case "maxCheckbox":
						errorMsg = methods._maxCheckbox(form, field, rules, i, options);
						field = $(form.find("input[name='" + fieldName + "']"));
						break;
					case "minCheckbox":
						errorMsg = methods._minCheckbox(form, field, rules, i, options);
						field = $(form.find("input[name='" + fieldName + "']"));
						break;
					case "equals":
						errorMsg = methods._equals(field, rules, i, options);
						break;
					case "funcCall":
						errorMsg = methods._funcCall(field, rules, i, options);
						break;
					case "creditCard":
						errorMsg = methods._creditCard(field, rules, i, options);
						break;

					default:
					//$.error("jQueryValidator rule not found"+rules[i]);
				}
				if (errorMsg !== undefined) {
					promptText += errorMsg + "<br/>";
					options.isError = true;
				}
			}
			// If the rules required is not added, an empty field is not validated
			if(!required && field.val() == "") options.isError = false;

			// Hack for radio/checkbox group button, the validation go into the
			// first radio/checkbox of the group
			var fieldType = field.prop("type");

			if ((fieldType == "radio" || fieldType == "checkbox") && form.find("input[name='" + fieldName + "']").size() > 1) {
				field = $(form.find("input[name='" + fieldName + "'][type!=hidden]:first"));
				options.showArrow = false;
			}

			if (fieldType == "text" && form.find("input[name='" + fieldName + "']").size() > 1) {
				field = $(form.find("input[name='" + fieldName + "'][type!=hidden]:first"));
				options.showArrow = false;
			}

			if (options.isError){
				methods._showPrompt(field, promptText, "", false, options);
			}else{
				if (!isAjaxValidator) methods._closePrompt(field);
			}

			if (!isAjaxValidator) {
				field.trigger("jqv.field.result", [field, options.isError, promptText]);
			}

			/* Record error */
			var errindex = $.inArray(field[0], options.InvalidFields);
			if (errindex == -1) {
				if (options.isError)
				options.InvalidFields.push(field[0]);
			} else if (!options.isError) {
				options.InvalidFields.splice(errindex, 1);
			}

			return options.isError;
		},
		/**
		* Required validation
		*
		* @param {jqObject} field
		* @param {Array[String]} rules
		* @param {int} i rules index
		* @param {Map}
		*            user options
		* @return an error string if validation failed
		*/
		_required: function(field, rules, i, options) {
			switch (field.prop("type")) {
				case "text":
                    //2011/12/28,rodeschen,add trim empty error
					if(!$.trim(field.val()))
						return options.allrules[rules[i]].alertText;
				case "password":
				case "textarea":
				case "file":
				default:
					if (!($.trim(field.val())))
						return options.allrules[rules[i]].alertText;
					break;
				case "radio":
				case "checkbox":
					var form = field.closest("form");
					var name = field.attr("name");
					if (form.find("input[name='" + name + "']:checked").size() == 0) {
						if (form.find("input[name='" + name + "']").size() == 1)
							return options.allrules[rules[i]].alertTextCheckboxe;
						else
							return options.allrules[rules[i]].alertTextCheckboxMultiple;
					}
					break;
				// required for <select>
				case "select-one":
					// added by paul@kinetek.net for select boxes, Thank you
					if (!field.val())
						return options.allrules[rules[i]].alertText;
					break;
				case "select-multiple":
					// added by paul@kinetek.net for select boxes, Thank you
					if (!field.find("option:selected").val())
						return options.allrules[rules[i]].alertText;
			}
		},
		/**
		* Validate that 1 from the group field is required
		*
		* @param {jqObject} field
		* @param {Array[String]} rules
		* @param {int} i rules index
		* @param {Map}
		*            user options
		* @return an error string if validation failed
		*/
		_groupRequired: function(field, rules, i, options) {
			var classGroup = "["+options.validateAttribute+"*=" +rules[i + 1] +"]";
			var isValid = false;
			// Check all fields from the group
			field.closest("form").find(classGroup).each(function(){
				if(!methods._required($(this), rules, i, options)){
					isValid = true;
					return false;
				}
			})

			if(!isValid) return options.allrules[rules[i]].alertText;
		},
		/**
		* Validate Regex rules
		*
		* @param {jqObject} field
		* @param {Array[String]} rules
		* @param {int} i rules index
		* @param {Map}
		*            user options
		* @return an error string if validation failed
		*/
		_customRegex: function(field, rules, i, options) {
			var customRule = rules[i + 1];
			var rule = options.allrules[customRule];
			if(!rule) {
				alert("jqv:custom rule not found "+customRule);
				return;
			}

			var ex=rule.regex;
			if(!ex) {
				alert("jqv:custom regex not found "+customRule);
				return;
			}
			var pattern = new RegExp(ex);

			if (!pattern.test(field.val()))
				return options.allrules[customRule].alertText;
		},
		/**
		* Validate custom function outside of the engine scope
		*
		* @param {jqObject} field
		* @param {Array[String]} rules
		* @param {int} i rules index
		* @param {Map}
		*            user options
		* @return an error string if validation failed
		*/
		_funcCall: function(field, rules, i, options) {
			var functionName = rules[i + 1];
			var fn;
			if(functionName.indexOf('.')>-1)
			{
				var namespaces = functionName.split('.');
				var scope = window;
				while(namespaces.length)
				{
					scope = scope[namespaces.shift()];
				}
				fn = scope;
			}
			else
				fn = window[functionName] || options.customFunctions[functionName];
			if (typeof(fn) == 'function')
				return fn(field, rules, i, options);

		},
		/**
		* Field match
		*
		* @param {jqObject} field
		* @param {Array[String]} rules
		* @param {int} i rules index
		* @param {Map}
		*            user options
		* @return an error string if validation failed
		*/
		_equals: function(field, rules, i, options) {
			var equalsField = rules[i + 1];

			if (field.val() != $("#" + equalsField).val())
				return options.allrules.equals.alertText;
		},
		/**
		* Check the maximum size (in characters)
		*
		* @param {jqObject} field
		* @param {Array[String]} rules
		* @param {int} i rules index
		* @param {Map}
		*            user options
		* @return an error string if validation failed
		*/
		_maxSize: function(field, rules, i, options) {
			var max = rules[i + 1];
			var len = field.val().length;

			if (len > max) {
				var rule = options.allrules.maxSize;
				return rule.alertText + max + rule.alertText2;
			}
		},
		/**
		* Check the minimum size (in characters)
		*
		* @param {jqObject} field
		* @param {Array[String]} rules
		* @param {int} i rules index
		* @param {Map}
		*            user options
		* @return an error string if validation failed
		*/
		_minSize: function(field, rules, i, options) {
			var min = rules[i + 1];
			var len = field.val().length;

			if (len < min) {
				var rule = options.allrules.minSize;
				return rule.alertText + min + rule.alertText2;
			}
		},
		/**
		* Check number minimum value
		*
		* @param {jqObject} field
		* @param {Array[String]} rules
		* @param {int} i rules index
		* @param {Map}
		*            user options
		* @return an error string if validation failed
		*/
		_min: function(field, rules, i, options) {
			var min = parseFloat(rules[i + 1]);
			var len = parseFloat(field.val());

			if (len < min) {
				var rule = options.allrules.min;
				if (rule.alertText2) return rule.alertText + min + rule.alertText2;
				return rule.alertText + min;
			}
		},
		/**
		* Check number maximum value
		*
		* @param {jqObject} field
		* @param {Array[String]} rules
		* @param {int} i rules index
		* @param {Map}
		*            user options
		* @return an error string if validation failed
		*/
		_max: function(field, rules, i, options) {
			var max = parseFloat(rules[i + 1]);
			var len = parseFloat(field.val());

			if (len >max ) {
				var rule = options.allrules.max;
				if (rule.alertText2) return rule.alertText + max + rule.alertText2;
				//orefalo: to review, also do the translations
				return rule.alertText + max;
			}
		},
		/**
		* Checks date is in the past
		*
		* @param {jqObject} field
		* @param {Array[String]} rules
		* @param {int} i rules index
		* @param {Map}
		*            user options
		* @return an error string if validation failed
		*/
		_past: function(field, rules, i, options) {

			var p=rules[i + 1];
			var pdate = (p.toLowerCase() == "now")? new Date():methods._parseDate(p);
			var vdate = methods._parseDate(field.val());

			if (vdate > pdate ) {
				var rule = options.allrules.past;
				if (rule.alertText2) return rule.alertText + methods._dateToString(pdate) + rule.alertText2;
				return rule.alertText + methods._dateToString(pdate);
			}
		},
		/**
		* Checks date is in the future
		*
		* @param {jqObject} field
		* @param {Array[String]} rules
		* @param {int} i rules index
		* @param {Map}
		*            user options
		* @return an error string if validation failed
		*/
		_future: function(field, rules, i, options) {

			var p=rules[i + 1];
			var pdate = (p.toLowerCase() == "now")? new Date():methods._parseDate(p);
			var vdate = methods._parseDate(field.val());

			if (vdate < pdate ) {
				var rule = options.allrules.future;
				if (rule.alertText2)
					return rule.alertText + methods._dateToString(pdate) + rule.alertText2;
				return rule.alertText + methods._dateToString(pdate);
			}
		},
		/**
		* Checks if valid date
		*
		* @param {string} date string
		* @return a bool based on determination of valid date
		*/
		_isDate: function (value) {
			var dateRegEx = new RegExp(/^\d{4}[\/\-](0?[1-9]|1[012])[\/\-](0?[1-9]|[12][0-9]|3[01])$|^(?:(?:(?:0?[13578]|1[02])(\/|-)31)|(?:(?:0?[1,3-9]|1[0-2])(\/|-)(?:29|30)))(\/|-)(?:[1-9]\d\d\d|\d[1-9]\d\d|\d\d[1-9]\d|\d\d\d[1-9])$|^(?:(?:0?[1-9]|1[0-2])(\/|-)(?:0?[1-9]|1\d|2[0-8]))(\/|-)(?:[1-9]\d\d\d|\d[1-9]\d\d|\d\d[1-9]\d|\d\d\d[1-9])$|^(0?2(\/|-)29)(\/|-)(?:(?:0[48]00|[13579][26]00|[2468][048]00)|(?:\d\d)?(?:0[48]|[2468][048]|[13579][26]))$/);
			return dateRegEx.test(value);
		},
		/**
		* Checks if valid date time
		*
		* @param {string} date string
		* @return a bool based on determination of valid date time
		*/
		_isDateTime: function (value){
			var dateTimeRegEx = new RegExp(/^\d{4}[\/\-](0?[1-9]|1[012])[\/\-](0?[1-9]|[12][0-9]|3[01])\s+(1[012]|0?[1-9]){1}:(0?[1-5]|[0-6][0-9]){1}:(0?[0-6]|[0-6][0-9]){1}\s+(am|pm|AM|PM){1}$|^(?:(?:(?:0?[13578]|1[02])(\/|-)31)|(?:(?:0?[1,3-9]|1[0-2])(\/|-)(?:29|30)))(\/|-)(?:[1-9]\d\d\d|\d[1-9]\d\d|\d\d[1-9]\d|\d\d\d[1-9])$|^((1[012]|0?[1-9]){1}\/(0?[1-9]|[12][0-9]|3[01]){1}\/\d{2,4}\s+(1[012]|0?[1-9]){1}:(0?[1-5]|[0-6][0-9]){1}:(0?[0-6]|[0-6][0-9]){1}\s+(am|pm|AM|PM){1})$/);
			return dateTimeRegEx.test(value);
		},
		//Checks if the start date is before the end date
		//returns true if end is later than start
		_dateCompare: function (start, end) {
			return (new Date(start.toString()) < new Date(end.toString()));
		},
		/**
		* Checks date range
		*
		* @param {jqObject} first field name
		* @param {jqObject} second field name
		* @return an error string if validation failed
		*/
		_dateRange: function (first, second, rules, i, options) {
			//are not both populated
			if ((!first[0].value && second[0].value) || (first[0].value && !second[0].value)) {
				return options.allrules[rules[i]].alertText + options.allrules[rules[i]].alertText2;
			}

			//are not both dates
			if (!methods._isDate(first[0].value) || !methods._isDate(second[0].value)) {
				return options.allrules[rules[i]].alertText + options.allrules[rules[i]].alertText2;
			}

			//are both dates but range is off
			if (!methods._dateCompare(first[0].value, second[0].value)) {
				return options.allrules[rules[i]].alertText + options.allrules[rules[i]].alertText2;
			}
		},
		/**
		* Checks date time range
		*
		* @param {jqObject} first field name
		* @param {jqObject} second field name
		* @return an error string if validation failed
		*/
		_dateTimeRange: function (first, second, rules, i, options) {
			//are not both populated
			if ((!first[0].value && second[0].value) || (first[0].value && !second[0].value)) {
				return options.allrules[rules[i]].alertText + options.allrules[rules[i]].alertText2;
			}
			//are not both dates
			if (!methods._isDateTime(first[0].value) || !methods._isDateTime(second[0].value)) {
				return options.allrules[rules[i]].alertText + options.allrules[rules[i]].alertText2;
			}
			//are both dates but range is off
			if (!methods._dateCompare(first[0].value, second[0].value)) {
				return options.allrules[rules[i]].alertText + options.allrules[rules[i]].alertText2;
			}
		},
		/**
		* Max number of checkbox selected
		*
		* @param {jqObject} field
		* @param {Array[String]} rules
		* @param {int} i rules index
		* @param {Map}
		*            user options
		* @return an error string if validation failed
		*/
		_maxCheckbox: function(form, field, rules, i, options) {

			var nbCheck = rules[i + 1];
			var groupname = field.attr("name");
			var groupSize = form.find("input[name='" + groupname + "']:checked").size();
			if (groupSize > nbCheck) {
				options.showArrow = false;
				if (options.allrules.maxCheckbox.alertText2)
					 return options.allrules.maxCheckbox.alertText + " " + nbCheck + " " + options.allrules.maxCheckbox.alertText2;
				return options.allrules.maxCheckbox.alertText;
			}
		},
		/**
		* Min number of checkbox selected
		*
		* @param {jqObject} field
		* @param {Array[String]} rules
		* @param {int} i rules index
		* @param {Map}
		*            user options
		* @return an error string if validation failed
		*/
		_minCheckbox: function(form, field, rules, i, options) {

			var nbCheck = rules[i + 1];
			var groupname = field.attr("name");
			var groupSize = form.find("input[name='" + groupname + "']:checked").size();
			if (groupSize < nbCheck) {
				options.showArrow = false;
				return options.allrules.minCheckbox.alertText + " " + nbCheck + " " + options.allrules.minCheckbox.alertText2;
			}
		},
		/**
		* Checks that it is a valid credit card number according to the
		* Luhn checksum algorithm.
		*
		* @param {jqObject} field
		* @param {Array[String]} rules
		* @param {int} i rules index
		* @param {Map}
		*            user options
		* @return an error string if validation failed
		*/
		_creditCard: function(field, rules, i, options) {
			//spaces and dashes may be valid characters, but must be stripped to calculate the checksum.
			var valid = false, cardNumber = field.val().replace(/ +/g, '').replace(/-+/g, '');

			var numDigits = cardNumber.length;
			if (numDigits >= 14 && numDigits <= 16 && parseInt(cardNumber) > 0) {

				var sum = 0, i = numDigits - 1, pos = 1, digit, luhn = new String();
				do {
					digit = parseInt(cardNumber.charAt(i));
					luhn += (pos++ % 2 == 0) ? digit * 2 : digit;
				} while (--i >= 0)

				for (i = 0; i < luhn.length; i++) {
					sum += parseInt(luhn.charAt(i));
				}
				valid = sum % 10 == 0;
			}
			if (!valid) return options.allrules.creditCard.alertText;
		},
		/**
		* Ajax field validation
		*
		* @param {jqObject} field
		* @param {Array[String]} rules
		* @param {int} i rules index
		* @param {Map}
		*            user options
		* @return nothing! the ajax validator handles the prompts itself
		*/
		 _ajax: function(field, rules, i, options) {

			 var errorSelector = rules[i + 1];
			 var rule = options.allrules[errorSelector];
			 var extraData = rule.extraData;
			 var extraDataDynamic = rule.extraDataDynamic;

			 if (!extraData)
			 	extraData = "";

			 if (extraDataDynamic) {
				 var tmpData = [];
				 var domIds = String(extraDataDynamic).split(",");
				 for (var i = 0; i < domIds.length; i++) {
					 var id = domIds[i];
					 if ($(id).length) {
						 var inputValue = field.closest("form").find(id).val();
						 var keyValue = id.replace('#', '') + '=' + escape(inputValue);
						 tmpData.push(keyValue);
					 }
				 }
				 extraDataDynamic = tmpData.join("&");
			 } else {
				 extraDataDynamic = "";
			 }

			 if (!options.isError) {
				 $.ajax({
					 type: "GET",
					 url: rule.url,
					 cache: false,
					 dataType: "json",
					 data: "fieldId=" + field.attr("id") + "&fieldValue=" + field.val() + "&extraData=" + extraData + "&" + extraDataDynamic,
					 field: field,
					 rule: rule,
					 methods: methods,
					 options: options,
					 beforeSend: function() {
						 // build the loading prompt
						 var loadingText = rule.alertTextLoad;
						 if (loadingText)
						 	methods._showPrompt(field, loadingText, "load", true, options);
					 },
					 error: function(data, transport) {
						 methods._ajaxError(data, transport);
					 },
					 success: function(json) {

						 // asynchronously called on success, data is the json answer from the server
						 var errorFieldId = json[0];
						 //var errorField = $($("#" + errorFieldId)[0]);
						 var errorField = $($("input[id='" + errorFieldId +"']")[0]);

						 // make sure we found the element
						 if (errorField.length == 1) {
							 var status = json[1];
							 // read the optional msg from the server
							 var msg = json[2];
							 if (!status) {
								 // Houston we got a problem - display an red prompt
								 options.ajaxValidCache[errorFieldId] = false;
								 options.isError = true;

								 // resolve the msg prompt
								 if(msg) {
									 if (options.allrules[msg]) {
										 var txt = options.allrules[msg].alertText;
										 if (txt)
										 	msg = txt;
									 }
								 }
								 else
								 	msg = rule.alertText;

								 methods._showPrompt(errorField, msg, "", true, options);
							 } else {
								 if (options.ajaxValidCache[errorFieldId] !== undefined)
								 	options.ajaxValidCache[errorFieldId] = true;

								 // resolves the msg prompt
								 if(msg) {
									 if (options.allrules[msg]) {
										 var txt = options.allrules[msg].alertTextOk;
										 if (txt)
										 	msg = txt;
									 }
								 }
								 else
								 msg = rule.alertTextOk;

								 // see if we should display a green prompt
								 if (msg)
								 	methods._showPrompt(errorField, msg, "pass", true, options);
								 else
								 	methods._closePrompt(errorField);
							 }
						 }
						 errorField.trigger("jqv.field.result", [errorField, options.isError, msg]);
					 }
				 });
			 }
		 },
		/**
		* Common method to handle ajax errors
		*
		* @param {Object} data
		* @param {Object} transport
		*/
		_ajaxError: function(data, transport) {
			if(data.status == 0 && transport == null)
				alert("The page is not served from a server! ajax call failed");
			else if(typeof console != "undefined")
				console.log("Ajax error: " + data.status + " " + transport);
		},
		/**
		* date -> string
		*
		* @param {Object} date
		*/
		_dateToString: function(date) {
			return date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate();
		},
		/**
		* Parses an ISO date
		* @param {String} d
		*/
		_parseDate: function(d) {

			var dateParts = d.split("-");
			if(dateParts==d)
				dateParts = d.split("/");
			return new Date(dateParts[0], (dateParts[1] - 1) ,dateParts[2]);
		},
		/**
		* Builds or updates a prompt with the given information
		*
		* @param {jqObject} field
		* @param {String} promptText html text to display type
		* @param {String} type the type of bubble: 'pass' (green), 'load' (black) anything else (red)
		* @param {boolean} ajaxed - use to mark fields than being validated with ajax
		* @param {Map} options user options
		*/
		 _showPrompt: function(field, promptText, type, ajaxed, options, ajaxform) {
			 var prompt = methods._getPrompt(field);
			 // The ajax submit errors are not see has an error in the form,
			 // When the form errors are returned, the engine see 2 bubbles, but those are ebing closed by the engine at the same time
			 // Because no error was found befor submitting
			 if(ajaxform) prompt = false;
			 if (prompt)
			 	methods._updatePrompt(field, prompt, promptText, type, ajaxed, options);
			 else
			 	prompt = methods._buildPrompt(field, promptText, type, ajaxed, options);
			
			// rodeschen add
             setTimeout(function(){field.is(":visible") ? field.validationEngine('hide') : prompt.remove();},2000);
		 },
		/**
		* Builds and shades a prompt for the given field.
		*
		* @param {jqObject} field
		* @param {String} promptText html text to display type
		* @param {String} type the type of bubble: 'pass' (green), 'load' (black) anything else (red)
		* @param {boolean} ajaxed - use to mark fields than being validated with ajax
		* @param {Map} options user options
		*/
		_buildPrompt: function(field, promptText, type, ajaxed, options) {

			// create the prompt
			var prompt = $('<div>');
			prompt.addClass(methods._getClassName(field.attr("id")) + "formError");
			// add a class name to identify the parent form of the prompt
			if(field.is(":input"))
				prompt.addClass("parentForm"+methods._getClassName(field.parents('form').attr("id")));
			prompt.addClass("formError");

			switch (type) {
				case "pass":
					prompt.addClass("greenPopup");
					break;
				case "load":
					prompt.addClass("blackPopup");
					break;
				default:
					/* it has error  */
					//alert("unknown popup type:"+type);
			}
			if (ajaxed)
				prompt.addClass("ajaxed");

			// create the prompt content
			var promptContent = $('<div>').addClass("formErrorContent").html(promptText).appendTo(prompt);
			// create the css arrow pointing at the field
			// note that there is no triangle on max-checkbox and radio
			if (options.showArrow) {
				var arrow = $('<div>').addClass("formErrorArrow");

				//prompt positioning adjustment support. Usage: positionType:Xshift,Yshift (for ex.: bottomLeft:+20 or bottomLeft:-20,+10)
				var positionType=field.data("promptPosition") || options.promptPosition;
				if (typeof(positionType)=='string') 
				{
					var pos=positionType.indexOf(":");
				 	if(pos!=-1)
						positionType=positionType.substring(0,pos);
				}

				switch (positionType) {
					case "bottomLeft":
					case "bottomRight":
						prompt.find(".formErrorContent").before(arrow);
						arrow.addClass("formErrorArrowBottom").html('<div class="line1"><!-- --></div><div class="line2"><!-- --></div><div class="line3"><!-- --></div><div class="line4"><!-- --></div><div class="line5"><!-- --></div><div class="line6"><!-- --></div><div class="line7"><!-- --></div><div class="line8"><!-- --></div><div class="line9"><!-- --></div><div class="line10"><!-- --></div>');
						break;
					case "topLeft":
					case "topRight":
						arrow.html('<div class="line10"><!-- --></div><div class="line9"><!-- --></div><div class="line8"><!-- --></div><div class="line7"><!-- --></div><div class="line6"><!-- --></div><div class="line5"><!-- --></div><div class="line4"><!-- --></div><div class="line3"><!-- --></div><div class="line2"><!-- --></div><div class="line1"><!-- --></div>');
						prompt.append(arrow);
						break;
				}
			}
			// Modify z-indexes  for jquery ui
			if (field.closest('.ui-dialog').length)
				prompt.addClass('formErrorInsideDialog');

			prompt.css({
				"opacity": 0
			});
			if (options.relative) {
				// empty relative span does not disturb page layout
				// prompt positioned absolute to relative span
				// vertical-align:top so position calculations are the same as isOverflown
				var outer = $('<div>').css({
					'position'		:'relative',
					'display'		:'inline',
					'overflow'		:'auto'
				}).addClass('formErrorOuter').append(prompt.css('position','absolute'));

				field.before(outer);
				if(options.relativePadding) {
					outer.css('padding-bottom', prompt.height() + 'px');
				}
			} else if (options.isOverflown) {
				//Cedric: Needed if a container is in position:relative
				// insert prompt in the form or in the overflown container?
				field.before(prompt);
			} else {
				$("body").append(prompt);
			}
			var pos = methods._calculatePosition(field, prompt, options);
			prompt.css({
				"top": pos.callerTopPosition,
				"left": pos.callerleftPosition,
				"marginTop": pos.marginTopSize,
				"opacity": 0
			}).data("callerField", field);

			if (options.autoHidePrompt) {
				setTimeout(function(){
					prompt.animate({
						"opacity": 0
					},function(){
						prompt.closest('.formErrorOuter').remove();
						prompt.remove();
					});
				}, options.autoHideDelay);
			} 
			return prompt.animate({
				"opacity": 0.87
			});
		},
		/**
		* Updates the prompt text field - the field for which the prompt
		* @param {jqObject} field
		* @param {String} promptText html text to display type
		* @param {String} type the type of bubble: 'pass' (green), 'load' (black) anything else (red)
		* @param {boolean} ajaxed - use to mark fields than being validated with ajax
		* @param {Map} options user options
		*/
		_updatePrompt: function(field, prompt, promptText, type, ajaxed, options, noAnimation) {

			if (prompt) {
				if (typeof type !== "undefined") {
					if (type == "pass")
						prompt.addClass("greenPopup");
					else
						prompt.removeClass("greenPopup");

					if (type == "load")
						prompt.addClass("blackPopup");
					else
						prompt.removeClass("blackPopup");
				}
				if (ajaxed)
					prompt.addClass("ajaxed");
				else
					prompt.removeClass("ajaxed");

				prompt.find(".formErrorContent").html(promptText);

				var pos = methods._calculatePosition(field, prompt, options);
				var css = {"top": pos.callerTopPosition,
				"left": pos.callerleftPosition,
				"marginTop": pos.marginTopSize};

				if (noAnimation)
					prompt.css(css);
				else
					prompt.animate(css);
			}
		},
		/**
		* Closes the prompt associated with the given field
		*
		* @param {jqObject}
		*            field
		*/
		 _closePrompt: function(field) {
			 var prompt = methods._getPrompt(field);
			 if (prompt)
				 prompt.fadeTo("fast", 0, function() {
					 prompt.parent('.formErrorOuter').remove();
					 prompt.remove();
				 });
		 },
		 closePrompt: function(field) {
			 return methods._closePrompt(field);
		 },
		/**
		* Returns the error prompt matching the field if any
		*
		* @param {jqObject}
		*            field
		* @return undefined or the error prompt (jqObject)
		*/
		_getPrompt: function(field) {
            var formId = $(field).closest('form').attr('id');
			var className = methods._getClassName(field.attr("id")) + "formError";
            var match = $("." + methods._escapeExpression(className) + '.parentForm' + formId)[0];
			if (match)
			return $(match);
		},
		/**
		  * Returns the escapade classname
		  *
		  * @param {selector}
		  *            className
		  */
		  _escapeExpression: function (selector) {
			  return selector.replace(/([#;&,\.\+\*\~':"\!\^$\[\]\(\)=>\|])/g, "\\$1");
		  },
		/**
		 * returns true if we are in a RTLed document
		 *
		 * @param {jqObject} field
		 */
		isRTL: function(field)
		{
			var $document = $(document);
			var $body = $('body');
			var rtl =
				(field && field.hasClass('rtl')) ||
				(field && (field.attr('dir') || '').toLowerCase()==='rtl') ||
				$document.hasClass('rtl') ||
				($document.attr('dir') || '').toLowerCase()==='rtl' ||
				$body.hasClass('rtl') ||
				($body.attr('dir') || '').toLowerCase()==='rtl';
			return Boolean(rtl);
		},
		/**
		* Calculates prompt position
		*
		* @param {jqObject}
		*            field
		* @param {jqObject}
		*            the prompt
		* @param {Map}
		*            options
		* @return positions
		*/
		_calculatePosition: function (field, promptElmt, options) {

			var promptTopPosition, promptleftPosition, marginTopSize;
			var fieldWidth = field.width();
			var promptHeight = promptElmt.height();

			var overflow = options.isOverflown || options.relative;
			if (overflow) {
				// is the form contained in an overflown container?
				promptTopPosition = promptleftPosition = 0;
				// compensation for the arrow
				marginTopSize = -promptHeight;
			} else {
				var offset = field.offset();
				promptTopPosition = offset.top;
				promptleftPosition = offset.left;
				marginTopSize = 0;
			}

			//prompt positioning adjustment support
			//now you can adjust prompt position
			//usage: positionType:Xshift,Yshift
			//for example:
			//   bottomLeft:+20 means bottomLeft position shifted by 20 pixels right horizontally
			//   topRight:20, -15 means topRight position shifted by 20 pixels to right and 15 pixels to top
			//You can use +pixels, - pixels. If no sign is provided than + is default.
			var positionType=field.data("promptPosition") || options.promptPosition;
			var shift1="";
			var shift2="";
			var shiftX=0;
			var shiftY=0;
			if (typeof(positionType)=='string') {
				//do we have any position adjustments ?
				if (positionType.indexOf(":")!=-1) {
					shift1=positionType.substring(positionType.indexOf(":")+1);
					positionType=positionType.substring(0,positionType.indexOf(":"));

					//if any advanced positioning will be needed (percents or something else) - parser should be added here
					//for now we use simple parseInt()

					//do we have second parameter?
					if (shift1.indexOf(",")!=-1) {
						shift2=shift1.substring(shift1.indexOf(",")+1);
						shift1=shift1.substring(0,shift1.indexOf(","));
						shiftY=parseInt(shift2);
						if (isNaN(shiftY)) shiftY=0;
					};

					shiftX=parseInt(shift1);
					if (isNaN(shift1)) shift1=0;

				};
			};

			if(!methods.isRTL(field))
			{
				switch (positionType) {
					default:
					case "topRight":
						if (overflow)
							promptleftPosition += fieldWidth - 30;
						else {
							promptleftPosition += fieldWidth - 30;
							promptTopPosition += -promptHeight -2;
						}
						break;

					case "topLeft":
						if (!overflow) {
							promptTopPosition += -promptHeight - 10;
						}
						break;

					case "centerRight":
						if (overflow) {
							promptTopPosition = 0;
							marginTopSize = 0;
							promptleftPosition=field.outerWidth(1)+5;
						} else {
							promptleftPosition+=field.outerWidth()+5;
						}
						break;
					case "centerLeft":
						promptleftPosition -= promptElmt.width() + 2;
						if (overflow) {
							promptTopPosition = 0;
							marginTopSize = 0;
						}
						break;

					case "bottomLeft":
						promptTopPosition = promptTopPosition + field.height() + 5;
						if (overflow) {
							marginTopSize = 0;
						}
						break;
					case "bottomRight":
						promptleftPosition += fieldWidth - 30;
						promptTopPosition += field.height() + 5;
						if (overflow) {
							marginTopSize = 0;
						}
				}
			}
			else
			{
				switch (positionType) {
					default:
					case "topLeft":
						if (overflow)
							promptleftPosition = -(promptElmt.width() + fieldWidth - 30);
						else {
							promptleftPosition -= promptElmt.width() - 30;
							promptTopPosition += -promptHeight -2;
						}
						break;
					case "topRight":
						if (overflow)
							promptleftPosition = -promptElmt.width();
						else {
							promptleftPosition += fieldWidth - promptElmt.width();
							promptTopPosition += -promptHeight -2;
						}
						break;
					case "centerRight":
						if (overflow) {
							promptTopPosition = 0;
							marginTopSize = 0;
							promptleftPosition = 5;
						} else {
							promptleftPosition+=field.outerWidth()+5;
						}
						break;

					case "centerLeft":
						if (overflow) {
							promptleftPosition = -(promptElmt.width() + field.outerWidth() + 2);
							promptTopPosition = 0;
							marginTopSize = 0;
						} else {
							promptleftPosition -= promptElmt.width() + 2;
						}
						break;

					case "bottomLeft":
						if (overflow) {
							promptTopPosition = field.height() + 5;
							promptleftPosition = -(promptElmt.width() + fieldWidth - 30);
							marginTopSize = 0;
						} else {
							promptleftPosition += -promptElmt.width() + 30;
							promptTopPosition = promptTopPosition + field.height() + 15;
						}
						break;

					case "bottomRight":
						if (overflow) {
							promptTopPosition = field.height() + 5;
							promptleftPosition = -promptElmt.width();
							marginTopSize = 0;
						} else {
							promptleftPosition += fieldWidth - promptElmt.width();
							promptTopPosition += field.height() + 15;
						}
				}
			}

			//apply adjusments if any
			promptleftPosition += shiftX;
			promptTopPosition  += shiftY;

			return {
				"callerTopPosition": promptTopPosition + "px",
				"callerleftPosition": promptleftPosition + "px",
				"marginTopSize": marginTopSize + "px"
			};
		},
		/**
		* Saves the user options and variables in the form.data
		*
		* @param {jqObject}
		*            form - the form where the user option should be saved
		* @param {Map}
		*            options - the user options
		* @return the user options (extended from the defaults)
		*/
		 _saveOptions: function(form, options) {

			 // is there a language localisation ?
			 if ($.validationEngineLanguage)
			 var allRules = $.validationEngineLanguage.allRules;
			 else
			 $.error("jQuery.validationEngine rules are not loaded, plz add localization files to the page");
			 // --- Internals DO NOT TOUCH or OVERLOAD ---
			 // validation rules and i18
			 $.validationEngine.defaults.allrules = allRules;

			 var userOptions = $.extend(true,{},$.validationEngine.defaults,options);

			 // Needed to be retro compatible
			 if (userOptions.isOverflown) userOptions.relative = true;
			 if (userOptions.relative) userOptions.isOverflown = true;

			 form.data('jqv', userOptions);
			 return userOptions;
		 },

		 /**
		 * Removes forbidden characters from class name
		 * @param {String} className
		 */
		 _getClassName: function(className) {
			 if(className)
				 return className.replace(/:/g, "_").replace(/\./g, "_");
		 }
	 };

	 /**
	 * Plugin entry point.
	 * You may pass an action as a parameter or a list of options.
	 * if none, the init and attach methods are being called.
	 * Remember: if you pass options, the attached method is NOT called automatically
	 *
	 * @param {String}
	 *            method (optional) action
	 */
	 $.fn.validationEngine = function(method) {

		 var form = $(this);
		 if(!form[0]) return false;  // stop here if the form does not exist

		 if (typeof(method) == 'string' && method.charAt(0) != '_' && methods[method]) {

			 // make sure init is called once
			 if(method != "showPrompt" && method != "hidePrompt" && method != "hide" && method != "hideAll")
			 methods.init.apply(form);

			 return methods[method].apply(form, Array.prototype.slice.call(arguments, 1));
		 } else if (typeof method == 'object' || !method) {

			 // default constructor with or without arguments
			 methods.init.apply(form, arguments);
			 return methods.attach.apply(form);
		 } else {
			 $.error('Method ' + method + ' does not exist in jQuery.validationEngine');
		 }
	};



	// LEAK GLOBAL OPTIONS
	$.validationEngine= {defaults:{

		// Name of the event triggering field validation
		validationEventTrigger: "blur",
		// Automatically scroll viewport to the first error
		scroll: true,
		// Focus on the first input
		focusFirstField:true,
		// Opening box position, possible locations are: topLeft,
		// topRight, bottomLeft, centerRight, bottomRight
		promptPosition: "topRight",
		bindMethod:"bind",
		// internal, automatically set to true when it parse a _ajax rule
		inlineAjax: false,
		// if set to true, the form data is sent asynchronously via ajax to the form.action url (get)
		ajaxFormValidation: false,
		// Ajax form validation callback method: boolean onComplete(form, status, errors, options)
		// retuns false if the form.submit event needs to be canceled.
		ajaxFormValidationURL: false,
		// The url to send the submit ajax validation (default to action)
		onAjaxFormComplete: $.noop,
		// called right before the ajax call, may return false to cancel
		onBeforeAjaxFormValidation: $.noop,
		// Stops form from submitting and execute function assiciated with it
		onValidationComplete: false,

		// better relative positioning
		relative: false,
		// insert spacing when error prompts inserted if relative = True and relativePadding = True
		// Use it if you want to have your prompts below your field integrated
		relativePadding: false,
		// Used when the form is displayed within a scrolling DIV
		isOverflown: false,
		overflownDIV: "",

		// Used when you have a form fields too close and the errors messages are on top of other disturbing viewing messages
		doNotShowAllErrosOnSubmit: false,

		// true if you want to vind the input fields
		binded: true,
		// set to true, when the prompt arrow needs to be displayed
		showArrow: true,
		// did one of the validation fail ? kept global to stop further ajax validations
		isError: false,
		// Caches field validation status, typically only bad status are created.
		// the array is used during ajax form validation to detect issues early and prevent an expensive submit
		ajaxValidCache: {},
		// Auto update prompt position after window resize
		autoPositionUpdate: false,

		InvalidFields: [],
		onSuccess: false,
		onFailure: false,
		// Auto-hide prompt
		autoHidePrompt: false,
		// Delay before auto-hide
		autoHideDelay: 10000,
		// Fade out duration while hiding the validations
		fadeDuration: 0.3
	}};
	$(function(){$.validationEngine.defaults.promptPosition = methods.isRTL()?'topLeft':"topRight"});
	
	
	/** rodes add	 */
	function shiftValCls(obj){
		 var valReg = "(^|\\s)validate\\[[\\[\\]a-zA-Z0-9, ]*\\]\s*";
		 var cls = obj.attr("class");
		 if(cls && (cls = cls.match(valReg))){
		 	obj.removeClass(cls[0]);
		 	return $.trim(cls[0].replace(/\s?validate\[|\]$/g,""));
		 }
		 return "";
	}
	
	
	$.fn.extend({
		addValid:function(str){
			var cls = shiftValCls(this);
			return this.addClass("validate[" + cls + (cls?",":"") + str + "]");
		},
		removeValid:function(str){
			var cls = shiftValCls(this);
			return this.addClass("validate[" + (cls.replace(new RegExp("("+str + "\s*,?|,\s*" +str+"$)"),"")) + "]");
		}
	});

	/** rodes add end	 */
})(jQuery);

define("validate", function(){});


jQuery.extend({


    createUploadIframe: function(id, uri){
        //create frame
        var frameId = 'jUploadFrame' + id;
        
        if (window.ActiveXObject) {
            var io = document.createElement('<iframe id="' + frameId + '" name="' + frameId + '" />');
            if (typeof uri == 'boolean') {
                io.src = 'javascript:false';
            } else if (typeof uri == 'string') {
                io.src = uri;
            }
        } else {
            var io = document.createElement('iframe');
            io.id = frameId;
            io.name = frameId;
        }
        io.style.position = 'absolute';
        io.style.top = '-1000px';
        io.style.left = '-1000px';
        
        document.body.appendChild(io);
        
        return io;
    },
    createUploadForm: function(id, fileElementId, data){
        //create form	
        var formId = 'jUploadForm' + id;
        var fileId = 'jUploadFile' + id;
        var form = $('<form  action="" method="POST" name="' + formId + '" id="' + formId + '" enctype="multipart/form-data"></form>');
        var oldElement = $('#' + fileElementId);
        var newElement = $(oldElement).clone();
        $(oldElement).attr('id', fileId);
        $(oldElement).before(newElement);
        $(oldElement).appendTo(form);
        
        // Increased support for the text parameter  
        if (data) {
                for (var i in data) {
                        $('<input type="hidden" name="' + i + '" value="' + data[i] + '" />').appendTo(form);
                }
        }
        
        //set attributes
        $(form).css('position', 'absolute');
        $(form).css('top', '-1200px');
        $(form).css('left', '-1200px');
        $(form).appendTo('body');
        return form;
    },
    
    ajaxFileUpload: function(s){
        // TODO introduce global settings, allowing the client to modify them for all requests, not only timeout		
        s = jQuery.extend({}, jQuery.ajaxSettings, s);
        var id = new Date().getTime();
        var form = jQuery.createUploadForm(id, s.fileElementId, s.data);
        var io = jQuery.createUploadIframe(id, s.secureuri);
        var frameId = 'jUploadFrame' + id;
        var formId = 'jUploadForm' + id;
        // Watch for a new set of requests
        if (s.global && !jQuery.active++) {
            jQuery.event.trigger("ajaxStart");
        }
        var requestDone = false;
        // Create the request object
        var xml = {};
        if (s.global) 
            jQuery.event.trigger("ajaxSend", [xml, s]);
        // Wait for a response to come back
        var uploadCallback = function(isTimeout){
            var io = document.getElementById(frameId);
            try {
                if (io.contentWindow) {
                    xml.responseText = io.contentWindow.document.body ? $(io.contentWindow.document.body.innerHTML).text() : null;
                    xml.responseXML = io.contentWindow.document.XMLDocument ? io.contentWindow.document.XMLDocument : io.contentWindow.document;
                    
                } else if (io.contentDocument) {
                    xml.responseText = io.contentDocument.document.body ? $(io.contentDocument.document.body.innerHTML).text() : null;
                    xml.responseXML = io.contentDocument.document.XMLDocument ? io.contentDocument.document.XMLDocument : io.contentDocument.document;
                }
            } 
            catch (e) {
                jQuery.handleError(s, xml, null, e);
            }
            if (xml || isTimeout == "timeout") {
                requestDone = true;
                var status;
                try {
                    status = isTimeout != "timeout" ? "success" : "error";
                    // Make sure that the request was successful or notmodified
                    if (status != "error") {
                        // process the data (runs the xml through httpData regardless of callback)
                        var data = jQuery.uploadHttpData(xml, s.dataType);
                        // If a local callback was specified, fire it and pass it the data
                        if (s.success) 
                            s.success(data, status);
                        
                        // Fire the global callback
                        if (s.global) 
                            jQuery.event.trigger("ajaxSuccess", [xml, s]);
                    } else jQuery.handleError(s, xml, status);
                } 
                catch (e) {
                    status = "error";
                    jQuery.handleError(s, xml, status, e);
                }
                
                // The request was completed
                if (s.global) 
                    jQuery.event.trigger("ajaxComplete", [xml, s]);
                
                // Handle the global AJAX counter
                if (s.global && !--jQuery.active) 
                    jQuery.event.trigger("ajaxStop");
                
                // Process result
                if (s.complete) 
                    s.complete(xml, status);
                
                jQuery(io).unbind();
                
                setTimeout(function(){
                    try {
                        $(io).remove();
                        $(form).remove();
                        
                    } 
                    catch (e) {
                        jQuery.handleError(s, xml, null, e);
                    }
                    
                }, 100);
                
                xml = null;
                
            }
        };
        // Timeout checker
        if (s.timeout > 0) {
            setTimeout(function(){
                // Check to see if the request is still happening
                if (!requestDone) 
                    uploadCallback("timeout");
            }, s.timeout);
        }
        try {
            // var io = $('#' + frameId);
            var form = $('#' + formId);
            $(form).attr('action', s.url);
            $(form).attr('method', 'POST');
            $(form).attr('target', frameId);
            if (form.encoding) {
                form.encoding = 'multipart/form-data';
            } else {
                form.enctype = 'multipart/form-data';
            }
            $(form).submit();
            
        } 
        catch (e) {
            jQuery.handleError(s, xml, null, e);
        }
        if (window.attachEvent) {
            document.getElementById(frameId).attachEvent('onload', uploadCallback);
        } else {
            document.getElementById(frameId).addEventListener('load', uploadCallback, false);
        }
        return {
            abort: function(){
            }
        };
        
    },
    
    uploadHttpData: function(r, type){
        var data = !type;
        data = type == "xml" || data ? r.responseXML : r.responseText;
        // If the type is "script", eval it in global context	
        if (type == "script") 
            jQuery.globalEval(data);
        // Get the JavaScript object, if JSON is used.
        if (type == "json") 
            eval("data = " + data);
        // evaluate scripts within html
        if (type == "html") 
            jQuery("<div>").html(data).evalScripts();
        //alert($('param', data).each(function(){alert($(this).attr('value'));}));
        return data;
    }
});


define("fileupload", function(){});

//     Underscore.js 1.4.1
//     http://underscorejs.org
//     (c) 2009-2012 Jeremy Ashkenas, DocumentCloud Inc.
//     Underscore may be freely distributed under the MIT license.

(function() {

  // Baseline setup
  // --------------

  // Establish the root object, `window` in the browser, or `global` on the server.
  var root = this;

  // Save the previous value of the `_` variable.
  var previousUnderscore = root._;

  // Establish the object that gets returned to break out of a loop iteration.
  var breaker = {};

  // Save bytes in the minified (but not gzipped) version:
  var ArrayProto = Array.prototype, ObjProto = Object.prototype, FuncProto = Function.prototype;

  // Create quick reference variables for speed access to core prototypes.
  var push             = ArrayProto.push,
      slice            = ArrayProto.slice,
      concat           = ArrayProto.concat,
      unshift          = ArrayProto.unshift,
      toString         = ObjProto.toString,
      hasOwnProperty   = ObjProto.hasOwnProperty;

  // All **ECMAScript 5** native function implementations that we hope to use
  // are declared here.
  var
    nativeForEach      = ArrayProto.forEach,
    nativeMap          = ArrayProto.map,
    nativeReduce       = ArrayProto.reduce,
    nativeReduceRight  = ArrayProto.reduceRight,
    nativeFilter       = ArrayProto.filter,
    nativeEvery        = ArrayProto.every,
    nativeSome         = ArrayProto.some,
    nativeIndexOf      = ArrayProto.indexOf,
    nativeLastIndexOf  = ArrayProto.lastIndexOf,
    nativeIsArray      = Array.isArray,
    nativeKeys         = Object.keys,
    nativeBind         = FuncProto.bind;

  // Create a safe reference to the Underscore object for use below.
  var _ = function(obj) {
    if (obj instanceof _) return obj;
    if (!(this instanceof _)) return new _(obj);
    this._wrapped = obj;
  };

  // Export the Underscore object for **Node.js**, with
  // backwards-compatibility for the old `require()` API. If we're in
  // the browser, add `_` as a global object via a string identifier,
  // for Closure Compiler "advanced" mode.
  if (typeof exports !== 'undefined') {
    if (typeof module !== 'undefined' && module.exports) {
      exports = module.exports = _;
    }
    exports._ = _;
  } else {
    root['_'] = _;
  }

  // Current version.
  _.VERSION = '1.4.1';

  // Collection Functions
  // --------------------

  // The cornerstone, an `each` implementation, aka `forEach`.
  // Handles objects with the built-in `forEach`, arrays, and raw objects.
  // Delegates to **ECMAScript 5**'s native `forEach` if available.
  var each = _.each = _.forEach = function(obj, iterator, context) {
    if (nativeForEach && obj.forEach === nativeForEach) {
      obj.forEach(iterator, context);
    } else if (obj.length === +obj.length) {
      for (var i = 0, l = obj.length; i < l; i++) {
        if (iterator.call(context, obj[i], i, obj) === breaker) return;
      }
    } else {
      for (var key in obj) {
        if (_.has(obj, key)) {
          if (iterator.call(context, obj[key], key, obj) === breaker) return;
        }
      }
    }
  };

  // Return the results of applying the iterator to each element.
  // Delegates to **ECMAScript 5**'s native `map` if available.
  _.map = _.collect = function(obj, iterator, context) {
    var results = [];
    if (nativeMap && obj.map === nativeMap) return obj.map(iterator, context);
    each(obj, function(value, index, list) {
      results[results.length] = iterator.call(context, value, index, list);
    });
    return results;
  };

  // **Reduce** builds up a single result from a list of values, aka `inject`,
  // or `foldl`. Delegates to **ECMAScript 5**'s native `reduce` if available.
  _.reduce = _.foldl = _.inject = function(obj, iterator, memo, context) {
    var initial = arguments.length > 2;
    if (nativeReduce && obj.reduce === nativeReduce) {
      if (context) iterator = _.bind(iterator, context);
      return initial ? obj.reduce(iterator, memo) : obj.reduce(iterator);
    }
    each(obj, function(value, index, list) {
      if (!initial) {
        memo = value;
        initial = true;
      } else {
        memo = iterator.call(context, memo, value, index, list);
      }
    });
    if (!initial) throw new TypeError('Reduce of empty array with no initial value');
    return memo;
  };

  // The right-associative version of reduce, also known as `foldr`.
  // Delegates to **ECMAScript 5**'s native `reduceRight` if available.
  _.reduceRight = _.foldr = function(obj, iterator, memo, context) {
    var initial = arguments.length > 2;
    if (nativeReduceRight && obj.reduceRight === nativeReduceRight) {
      if (context) iterator = _.bind(iterator, context);
      return arguments.length > 2 ? obj.reduceRight(iterator, memo) : obj.reduceRight(iterator);
    }
    var length = obj.length;
    if (length !== +length) {
      var keys = _.keys(obj);
      length = keys.length;
    }
    each(obj, function(value, index, list) {
      index = keys ? keys[--length] : --length;
      if (!initial) {
        memo = obj[index];
        initial = true;
      } else {
        memo = iterator.call(context, memo, obj[index], index, list);
      }
    });
    if (!initial) throw new TypeError('Reduce of empty array with no initial value');
    return memo;
  };

  // Return the first value which passes a truth test. Aliased as `detect`.
  _.find = _.detect = function(obj, iterator, context) {
    var result;
    any(obj, function(value, index, list) {
      if (iterator.call(context, value, index, list)) {
        result = value;
        return true;
      }
    });
    return result;
  };

  // Return all the elements that pass a truth test.
  // Delegates to **ECMAScript 5**'s native `filter` if available.
  // Aliased as `select`.
  _.filter = _.select = function(obj, iterator, context) {
    var results = [];
    if (nativeFilter && obj.filter === nativeFilter) return obj.filter(iterator, context);
    each(obj, function(value, index, list) {
      if (iterator.call(context, value, index, list)) results[results.length] = value;
    });
    return results;
  };

  // Return all the elements for which a truth test fails.
  _.reject = function(obj, iterator, context) {
    var results = [];
    each(obj, function(value, index, list) {
      if (!iterator.call(context, value, index, list)) results[results.length] = value;
    });
    return results;
  };

  // Determine whether all of the elements match a truth test.
  // Delegates to **ECMAScript 5**'s native `every` if available.
  // Aliased as `all`.
  _.every = _.all = function(obj, iterator, context) {
    iterator || (iterator = _.identity);
    var result = true;
    if (nativeEvery && obj.every === nativeEvery) return obj.every(iterator, context);
    each(obj, function(value, index, list) {
      if (!(result = result && iterator.call(context, value, index, list))) return breaker;
    });
    return !!result;
  };

  // Determine if at least one element in the object matches a truth test.
  // Delegates to **ECMAScript 5**'s native `some` if available.
  // Aliased as `any`.
  var any = _.some = _.any = function(obj, iterator, context) {
    iterator || (iterator = _.identity);
    var result = false;
    if (nativeSome && obj.some === nativeSome) return obj.some(iterator, context);
    each(obj, function(value, index, list) {
      if (result || (result = iterator.call(context, value, index, list))) return breaker;
    });
    return !!result;
  };

  // Determine if the array or object contains a given value (using `===`).
  // Aliased as `include`.
  _.contains = _.include = function(obj, target) {
    var found = false;
    if (nativeIndexOf && obj.indexOf === nativeIndexOf) return obj.indexOf(target) != -1;
    found = any(obj, function(value) {
      return value === target;
    });
    return found;
  };

  // Invoke a method (with arguments) on every item in a collection.
  _.invoke = function(obj, method) {
    var args = slice.call(arguments, 2);
    return _.map(obj, function(value) {
      return (_.isFunction(method) ? method : value[method]).apply(value, args);
    });
  };

  // Convenience version of a common use case of `map`: fetching a property.
  _.pluck = function(obj, key) {
    return _.map(obj, function(value){ return value[key]; });
  };

  // Convenience version of a common use case of `filter`: selecting only objects
  // with specific `key:value` pairs.
  _.where = function(obj, attrs) {
    if (_.isEmpty(attrs)) return [];
    return _.filter(obj, function(value) {
      for (var key in attrs) {
        if (attrs[key] !== value[key]) return false;
      }
      return true;
    });
  };

  // Return the maximum element or (element-based computation).
  // Can't optimize arrays of integers longer than 65,535 elements.
  // See: https://bugs.webkit.org/show_bug.cgi?id=80797
  _.max = function(obj, iterator, context) {
    if (!iterator && _.isArray(obj) && obj[0] === +obj[0] && obj.length < 65535) {
      return Math.max.apply(Math, obj);
    }
    if (!iterator && _.isEmpty(obj)) return -Infinity;
    var result = {computed : -Infinity};
    each(obj, function(value, index, list) {
      var computed = iterator ? iterator.call(context, value, index, list) : value;
      computed >= result.computed && (result = {value : value, computed : computed});
    });
    return result.value;
  };

  // Return the minimum element (or element-based computation).
  _.min = function(obj, iterator, context) {
    if (!iterator && _.isArray(obj) && obj[0] === +obj[0] && obj.length < 65535) {
      return Math.min.apply(Math, obj);
    }
    if (!iterator && _.isEmpty(obj)) return Infinity;
    var result = {computed : Infinity};
    each(obj, function(value, index, list) {
      var computed = iterator ? iterator.call(context, value, index, list) : value;
      computed < result.computed && (result = {value : value, computed : computed});
    });
    return result.value;
  };

  // Shuffle an array.
  _.shuffle = function(obj) {
    var rand;
    var index = 0;
    var shuffled = [];
    each(obj, function(value) {
      rand = _.random(index++);
      shuffled[index - 1] = shuffled[rand];
      shuffled[rand] = value;
    });
    return shuffled;
  };

  // An internal function to generate lookup iterators.
  var lookupIterator = function(value) {
    return _.isFunction(value) ? value : function(obj){ return obj[value]; };
  };

  // Sort the object's values by a criterion produced by an iterator.
  _.sortBy = function(obj, value, context) {
    var iterator = lookupIterator(value);
    return _.pluck(_.map(obj, function(value, index, list) {
      return {
        value : value,
        index : index,
        criteria : iterator.call(context, value, index, list)
      };
    }).sort(function(left, right) {
      var a = left.criteria;
      var b = right.criteria;
      if (a !== b) {
        if (a > b || a === void 0) return 1;
        if (a < b || b === void 0) return -1;
      }
      return left.index < right.index ? -1 : 1;
    }), 'value');
  };

  // An internal function used for aggregate "group by" operations.
  var group = function(obj, value, context, behavior) {
    var result = {};
    var iterator = lookupIterator(value);
    each(obj, function(value, index) {
      var key = iterator.call(context, value, index, obj);
      behavior(result, key, value);
    });
    return result;
  };

  // Groups the object's values by a criterion. Pass either a string attribute
  // to group by, or a function that returns the criterion.
  _.groupBy = function(obj, value, context) {
    return group(obj, value, context, function(result, key, value) {
      (_.has(result, key) ? result[key] : (result[key] = [])).push(value);
    });
  };

  // Counts instances of an object that group by a certain criterion. Pass
  // either a string attribute to count by, or a function that returns the
  // criterion.
  _.countBy = function(obj, value, context) {
    return group(obj, value, context, function(result, key, value) {
      if (!_.has(result, key)) result[key] = 0;
      result[key]++;
    });
  };

  // Use a comparator function to figure out the smallest index at which
  // an object should be inserted so as to maintain order. Uses binary search.
  _.sortedIndex = function(array, obj, iterator, context) {
    iterator = iterator == null ? _.identity : lookupIterator(iterator);
    var value = iterator.call(context, obj);
    var low = 0, high = array.length;
    while (low < high) {
      var mid = (low + high) >>> 1;
      iterator.call(context, array[mid]) < value ? low = mid + 1 : high = mid;
    }
    return low;
  };

  // Safely convert anything iterable into a real, live array.
  _.toArray = function(obj) {
    if (!obj) return [];
    if (obj.length === +obj.length) return slice.call(obj);
    return _.values(obj);
  };

  // Return the number of elements in an object.
  _.size = function(obj) {
    return (obj.length === +obj.length) ? obj.length : _.keys(obj).length;
  };

  // Array Functions
  // ---------------

  // Get the first element of an array. Passing **n** will return the first N
  // values in the array. Aliased as `head` and `take`. The **guard** check
  // allows it to work with `_.map`.
  _.first = _.head = _.take = function(array, n, guard) {
    return (n != null) && !guard ? slice.call(array, 0, n) : array[0];
  };

  // Returns everything but the last entry of the array. Especially useful on
  // the arguments object. Passing **n** will return all the values in
  // the array, excluding the last N. The **guard** check allows it to work with
  // `_.map`.
  _.initial = function(array, n, guard) {
    return slice.call(array, 0, array.length - ((n == null) || guard ? 1 : n));
  };

  // Get the last element of an array. Passing **n** will return the last N
  // values in the array. The **guard** check allows it to work with `_.map`.
  _.last = function(array, n, guard) {
    if ((n != null) && !guard) {
      return slice.call(array, Math.max(array.length - n, 0));
    } else {
      return array[array.length - 1];
    }
  };

  // Returns everything but the first entry of the array. Aliased as `tail` and `drop`.
  // Especially useful on the arguments object. Passing an **n** will return
  // the rest N values in the array. The **guard**
  // check allows it to work with `_.map`.
  _.rest = _.tail = _.drop = function(array, n, guard) {
    return slice.call(array, (n == null) || guard ? 1 : n);
  };

  // Trim out all falsy values from an array.
  _.compact = function(array) {
    return _.filter(array, function(value){ return !!value; });
  };

  // Internal implementation of a recursive `flatten` function.
  var flatten = function(input, shallow, output) {
    each(input, function(value) {
      if (_.isArray(value)) {
        shallow ? push.apply(output, value) : flatten(value, shallow, output);
      } else {
        output.push(value);
      }
    });
    return output;
  };

  // Return a completely flattened version of an array.
  _.flatten = function(array, shallow) {
    return flatten(array, shallow, []);
  };

  // Return a version of the array that does not contain the specified value(s).
  _.without = function(array) {
    return _.difference(array, slice.call(arguments, 1));
  };

  // Produce a duplicate-free version of the array. If the array has already
  // been sorted, you have the option of using a faster algorithm.
  // Aliased as `unique`.
  _.uniq = _.unique = function(array, isSorted, iterator, context) {
    var initial = iterator ? _.map(array, iterator, context) : array;
    var results = [];
    var seen = [];
    each(initial, function(value, index) {
      if (isSorted ? (!index || seen[seen.length - 1] !== value) : !_.contains(seen, value)) {
        seen.push(value);
        results.push(array[index]);
      }
    });
    return results;
  };

  // Produce an array that contains the union: each distinct element from all of
  // the passed-in arrays.
  _.union = function() {
    return _.uniq(concat.apply(ArrayProto, arguments));
  };

  // Produce an array that contains every item shared between all the
  // passed-in arrays.
  _.intersection = function(array) {
    var rest = slice.call(arguments, 1);
    return _.filter(_.uniq(array), function(item) {
      return _.every(rest, function(other) {
        return _.indexOf(other, item) >= 0;
      });
    });
  };

  // Take the difference between one array and a number of other arrays.
  // Only the elements present in just the first array will remain.
  _.difference = function(array) {
    var rest = concat.apply(ArrayProto, slice.call(arguments, 1));
    return _.filter(array, function(value){ return !_.contains(rest, value); });
  };

  // Zip together multiple lists into a single array -- elements that share
  // an index go together.
  _.zip = function() {
    var args = slice.call(arguments);
    var length = _.max(_.pluck(args, 'length'));
    var results = new Array(length);
    for (var i = 0; i < length; i++) {
      results[i] = _.pluck(args, "" + i);
    }
    return results;
  };

  // Converts lists into objects. Pass either a single array of `[key, value]`
  // pairs, or two parallel arrays of the same length -- one of keys, and one of
  // the corresponding values.
  _.object = function(list, values) {
    var result = {};
    for (var i = 0, l = list.length; i < l; i++) {
      if (values) {
        result[list[i]] = values[i];
      } else {
        result[list[i][0]] = list[i][1];
      }
    }
    return result;
  };

  // If the browser doesn't supply us with indexOf (I'm looking at you, **MSIE**),
  // we need this function. Return the position of the first occurrence of an
  // item in an array, or -1 if the item is not included in the array.
  // Delegates to **ECMAScript 5**'s native `indexOf` if available.
  // If the array is large and already in sort order, pass `true`
  // for **isSorted** to use binary search.
  _.indexOf = function(array, item, isSorted) {
    var i = 0, l = array.length;
    if (isSorted) {
      if (typeof isSorted == 'number') {
        i = (isSorted < 0 ? Math.max(0, l + isSorted) : isSorted);
      } else {
        i = _.sortedIndex(array, item);
        return array[i] === item ? i : -1;
      }
    }
    if (nativeIndexOf && array.indexOf === nativeIndexOf) return array.indexOf(item, isSorted);
    for (; i < l; i++) if (array[i] === item) return i;
    return -1;
  };

  // Delegates to **ECMAScript 5**'s native `lastIndexOf` if available.
  _.lastIndexOf = function(array, item, from) {
    var hasIndex = from != null;
    if (nativeLastIndexOf && array.lastIndexOf === nativeLastIndexOf) {
      return hasIndex ? array.lastIndexOf(item, from) : array.lastIndexOf(item);
    }
    var i = (hasIndex ? from : array.length);
    while (i--) if (array[i] === item) return i;
    return -1;
  };

  // Generate an integer Array containing an arithmetic progression. A port of
  // the native Python `range()` function. See
  // [the Python documentation](http://docs.python.org/library/functions.html#range).
  _.range = function(start, stop, step) {
    if (arguments.length <= 1) {
      stop = start || 0;
      start = 0;
    }
    step = arguments[2] || 1;

    var len = Math.max(Math.ceil((stop - start) / step), 0);
    var idx = 0;
    var range = new Array(len);

    while(idx < len) {
      range[idx++] = start;
      start += step;
    }

    return range;
  };

  // Function (ahem) Functions
  // ------------------

  // Reusable constructor function for prototype setting.
  var ctor = function(){};

  // Create a function bound to a given object (assigning `this`, and arguments,
  // optionally). Binding with arguments is also known as `curry`.
  // Delegates to **ECMAScript 5**'s native `Function.bind` if available.
  // We check for `func.bind` first, to fail fast when `func` is undefined.
  _.bind = function bind(func, context) {
    var bound, args;
    if (func.bind === nativeBind && nativeBind) return nativeBind.apply(func, slice.call(arguments, 1));
    if (!_.isFunction(func)) throw new TypeError;
    args = slice.call(arguments, 2);
    return bound = function() {
      if (!(this instanceof bound)) return func.apply(context, args.concat(slice.call(arguments)));
      ctor.prototype = func.prototype;
      var self = new ctor;
      var result = func.apply(self, args.concat(slice.call(arguments)));
      if (Object(result) === result) return result;
      return self;
    };
  };

  // Bind all of an object's methods to that object. Useful for ensuring that
  // all callbacks defined on an object belong to it.
  _.bindAll = function(obj) {
    var funcs = slice.call(arguments, 1);
    if (funcs.length == 0) funcs = _.functions(obj);
    each(funcs, function(f) { obj[f] = _.bind(obj[f], obj); });
    return obj;
  };

  // Memoize an expensive function by storing its results.
  _.memoize = function(func, hasher) {
    var memo = {};
    hasher || (hasher = _.identity);
    return function() {
      var key = hasher.apply(this, arguments);
      return _.has(memo, key) ? memo[key] : (memo[key] = func.apply(this, arguments));
    };
  };

  // Delays a function for the given number of milliseconds, and then calls
  // it with the arguments supplied.
  _.delay = function(func, wait) {
    var args = slice.call(arguments, 2);
    return setTimeout(function(){ return func.apply(null, args); }, wait);
  };

  // Defers a function, scheduling it to run after the current call stack has
  // cleared.
  _.defer = function(func) {
    return _.delay.apply(_, [func, 1].concat(slice.call(arguments, 1)));
  };

  // Returns a function, that, when invoked, will only be triggered at most once
  // during a given window of time.
  _.throttle = function(func, wait) {
    var context, args, timeout, throttling, more, result;
    var whenDone = _.debounce(function(){ more = throttling = false; }, wait);
    return function() {
      context = this; args = arguments;
      var later = function() {
        timeout = null;
        if (more) {
          result = func.apply(context, args);
        }
        whenDone();
      };
      if (!timeout) timeout = setTimeout(later, wait);
      if (throttling) {
        more = true;
      } else {
        throttling = true;
        result = func.apply(context, args);
      }
      whenDone();
      return result;
    };
  };

  // Returns a function, that, as long as it continues to be invoked, will not
  // be triggered. The function will be called after it stops being called for
  // N milliseconds. If `immediate` is passed, trigger the function on the
  // leading edge, instead of the trailing.
  _.debounce = function(func, wait, immediate) {
    var timeout, result;
    return function() {
      var context = this, args = arguments;
      var later = function() {
        timeout = null;
        if (!immediate) result = func.apply(context, args);
      };
      var callNow = immediate && !timeout;
      clearTimeout(timeout);
      timeout = setTimeout(later, wait);
      if (callNow) result = func.apply(context, args);
      return result;
    };
  };

  // Returns a function that will be executed at most one time, no matter how
  // often you call it. Useful for lazy initialization.
  _.once = function(func) {
    var ran = false, memo;
    return function() {
      if (ran) return memo;
      ran = true;
      memo = func.apply(this, arguments);
      func = null;
      return memo;
    };
  };

  // Returns the first function passed as an argument to the second,
  // allowing you to adjust arguments, run code before and after, and
  // conditionally execute the original function.
  _.wrap = function(func, wrapper) {
    return function() {
      var args = [func];
      push.apply(args, arguments);
      return wrapper.apply(this, args);
    };
  };

  // Returns a function that is the composition of a list of functions, each
  // consuming the return value of the function that follows.
  _.compose = function() {
    var funcs = arguments;
    return function() {
      var args = arguments;
      for (var i = funcs.length - 1; i >= 0; i--) {
        args = [funcs[i].apply(this, args)];
      }
      return args[0];
    };
  };

  // Returns a function that will only be executed after being called N times.
  _.after = function(times, func) {
    if (times <= 0) return func();
    return function() {
      if (--times < 1) {
        return func.apply(this, arguments);
      }
    };
  };

  // Object Functions
  // ----------------

  // Retrieve the names of an object's properties.
  // Delegates to **ECMAScript 5**'s native `Object.keys`
  _.keys = nativeKeys || function(obj) {
    if (obj !== Object(obj)) throw new TypeError('Invalid object');
    var keys = [];
    for (var key in obj) if (_.has(obj, key)) keys[keys.length] = key;
    return keys;
  };

  // Retrieve the values of an object's properties.
  _.values = function(obj) {
    var values = [];
    for (var key in obj) if (_.has(obj, key)) values.push(obj[key]);
    return values;
  };

  // Convert an object into a list of `[key, value]` pairs.
  _.pairs = function(obj) {
    var pairs = [];
    for (var key in obj) if (_.has(obj, key)) pairs.push([key, obj[key]]);
    return pairs;
  };

  // Invert the keys and values of an object. The values must be serializable.
  _.invert = function(obj) {
    var result = {};
    for (var key in obj) if (_.has(obj, key)) result[obj[key]] = key;
    return result;
  };

  // Return a sorted list of the function names available on the object.
  // Aliased as `methods`
  _.functions = _.methods = function(obj) {
    var names = [];
    for (var key in obj) {
      if (_.isFunction(obj[key])) names.push(key);
    }
    return names.sort();
  };

  // Extend a given object with all the properties in passed-in object(s).
  _.extend = function(obj) {
    each(slice.call(arguments, 1), function(source) {
      for (var prop in source) {
        obj[prop] = source[prop];
      }
    });
    return obj;
  };

  // Return a copy of the object only containing the whitelisted properties.
  _.pick = function(obj) {
    var copy = {};
    var keys = concat.apply(ArrayProto, slice.call(arguments, 1));
    each(keys, function(key) {
      if (key in obj) copy[key] = obj[key];
    });
    return copy;
  };

   // Return a copy of the object without the blacklisted properties.
  _.omit = function(obj) {
    var copy = {};
    var keys = concat.apply(ArrayProto, slice.call(arguments, 1));
    for (var key in obj) {
      if (!_.contains(keys, key)) copy[key] = obj[key];
    }
    return copy;
  };

  // Fill in a given object with default properties.
  _.defaults = function(obj) {
    each(slice.call(arguments, 1), function(source) {
      for (var prop in source) {
        if (obj[prop] == null) obj[prop] = source[prop];
      }
    });
    return obj;
  };

  // Create a (shallow-cloned) duplicate of an object.
  _.clone = function(obj) {
    if (!_.isObject(obj)) return obj;
    return _.isArray(obj) ? obj.slice() : _.extend({}, obj);
  };

  // Invokes interceptor with the obj, and then returns obj.
  // The primary purpose of this method is to "tap into" a method chain, in
  // order to perform operations on intermediate results within the chain.
  _.tap = function(obj, interceptor) {
    interceptor(obj);
    return obj;
  };

  // Internal recursive comparison function for `isEqual`.
  var eq = function(a, b, aStack, bStack) {
    // Identical objects are equal. `0 === -0`, but they aren't identical.
    // See the Harmony `egal` proposal: http://wiki.ecmascript.org/doku.php?id=harmony:egal.
    if (a === b) return a !== 0 || 1 / a == 1 / b;
    // A strict comparison is necessary because `null == undefined`.
    if (a == null || b == null) return a === b;
    // Unwrap any wrapped objects.
    if (a instanceof _) a = a._wrapped;
    if (b instanceof _) b = b._wrapped;
    // Compare `[[Class]]` names.
    var className = toString.call(a);
    if (className != toString.call(b)) return false;
    switch (className) {
      // Strings, numbers, dates, and booleans are compared by value.
      case '[object String]':
        // Primitives and their corresponding object wrappers are equivalent; thus, `"5"` is
        // equivalent to `new String("5")`.
        return a == String(b);
      case '[object Number]':
        // `NaN`s are equivalent, but non-reflexive. An `egal` comparison is performed for
        // other numeric values.
        return a != +a ? b != +b : (a == 0 ? 1 / a == 1 / b : a == +b);
      case '[object Date]':
      case '[object Boolean]':
        // Coerce dates and booleans to numeric primitive values. Dates are compared by their
        // millisecond representations. Note that invalid dates with millisecond representations
        // of `NaN` are not equivalent.
        return +a == +b;
      // RegExps are compared by their source patterns and flags.
      case '[object RegExp]':
        return a.source == b.source &&
               a.global == b.global &&
               a.multiline == b.multiline &&
               a.ignoreCase == b.ignoreCase;
    }
    if (typeof a != 'object' || typeof b != 'object') return false;
    // Assume equality for cyclic structures. The algorithm for detecting cyclic
    // structures is adapted from ES 5.1 section 15.12.3, abstract operation `JO`.
    var length = aStack.length;
    while (length--) {
      // Linear search. Performance is inversely proportional to the number of
      // unique nested structures.
      if (aStack[length] == a) return bStack[length] == b;
    }
    // Add the first object to the stack of traversed objects.
    aStack.push(a);
    bStack.push(b);
    var size = 0, result = true;
    // Recursively compare objects and arrays.
    if (className == '[object Array]') {
      // Compare array lengths to determine if a deep comparison is necessary.
      size = a.length;
      result = size == b.length;
      if (result) {
        // Deep compare the contents, ignoring non-numeric properties.
        while (size--) {
          if (!(result = eq(a[size], b[size], aStack, bStack))) break;
        }
      }
    } else {
      // Objects with different constructors are not equivalent, but `Object`s
      // from different frames are.
      var aCtor = a.constructor, bCtor = b.constructor;
      if (aCtor !== bCtor && !(_.isFunction(aCtor) && (aCtor instanceof aCtor) &&
                               _.isFunction(bCtor) && (bCtor instanceof bCtor))) {
        return false;
      }
      // Deep compare objects.
      for (var key in a) {
        if (_.has(a, key)) {
          // Count the expected number of properties.
          size++;
          // Deep compare each member.
          if (!(result = _.has(b, key) && eq(a[key], b[key], aStack, bStack))) break;
        }
      }
      // Ensure that both objects contain the same number of properties.
      if (result) {
        for (key in b) {
          if (_.has(b, key) && !(size--)) break;
        }
        result = !size;
      }
    }
    // Remove the first object from the stack of traversed objects.
    aStack.pop();
    bStack.pop();
    return result;
  };

  // Perform a deep comparison to check if two objects are equal.
  _.isEqual = function(a, b) {
    return eq(a, b, [], []);
  };

  // Is a given array, string, or object empty?
  // An "empty" object has no enumerable own-properties.
  _.isEmpty = function(obj) {
    if (obj == null) return true;
    if (_.isArray(obj) || _.isString(obj)) return obj.length === 0;
    for (var key in obj) if (_.has(obj, key)) return false;
    return true;
  };

  // Is a given value a DOM element?
  _.isElement = function(obj) {
    return !!(obj && obj.nodeType === 1);
  };

  // Is a given value an array?
  // Delegates to ECMA5's native Array.isArray
  _.isArray = nativeIsArray || function(obj) {
    return toString.call(obj) == '[object Array]';
  };

  // Is a given variable an object?
  _.isObject = function(obj) {
    return obj === Object(obj);
  };

  // Add some isType methods: isArguments, isFunction, isString, isNumber, isDate, isRegExp.
  each(['Arguments', 'Function', 'String', 'Number', 'Date', 'RegExp'], function(name) {
    _['is' + name] = function(obj) {
      return toString.call(obj) == '[object ' + name + ']';
    };
  });

  // Define a fallback version of the method in browsers (ahem, IE), where
  // there isn't any inspectable "Arguments" type.
  if (!_.isArguments(arguments)) {
    _.isArguments = function(obj) {
      return !!(obj && _.has(obj, 'callee'));
    };
  }

  // Optimize `isFunction` if appropriate.
  if (typeof (/./) !== 'function') {
    _.isFunction = function(obj) {
      return typeof obj === 'function';
    };
  }

  // Is a given object a finite number?
  _.isFinite = function(obj) {
    return _.isNumber(obj) && isFinite(obj);
  };

  // Is the given value `NaN`? (NaN is the only number which does not equal itself).
  _.isNaN = function(obj) {
    return _.isNumber(obj) && obj != +obj;
  };

  // Is a given value a boolean?
  _.isBoolean = function(obj) {
    return obj === true || obj === false || toString.call(obj) == '[object Boolean]';
  };

  // Is a given value equal to null?
  _.isNull = function(obj) {
    return obj === null;
  };

  // Is a given variable undefined?
  _.isUndefined = function(obj) {
    return obj === void 0;
  };

  // Shortcut function for checking if an object has a given property directly
  // on itself (in other words, not on a prototype).
  _.has = function(obj, key) {
    return hasOwnProperty.call(obj, key);
  };

  // Utility Functions
  // -----------------

  // Run Underscore.js in *noConflict* mode, returning the `_` variable to its
  // previous owner. Returns a reference to the Underscore object.
  _.noConflict = function() {
    root._ = previousUnderscore;
    return this;
  };

  // Keep the identity function around for default iterators.
  _.identity = function(value) {
    return value;
  };

  // Run a function **n** times.
  _.times = function(n, iterator, context) {
    for (var i = 0; i < n; i++) iterator.call(context, i);
  };

  // Return a random integer between min and max (inclusive).
  _.random = function(min, max) {
    if (max == null) {
      max = min;
      min = 0;
    }
    return min + (0 | Math.random() * (max - min + 1));
  };

  // List of HTML entities for escaping.
  var entityMap = {
    escape: {
      '&': '&amp;',
      '<': '&lt;',
      '>': '&gt;',
      '"': '&quot;',
      "'": '&#x27;',
      '/': '&#x2F;'
    }
  };
  entityMap.unescape = _.invert(entityMap.escape);

  // Regexes containing the keys and values listed immediately above.
  var entityRegexes = {
    escape:   new RegExp('[' + _.keys(entityMap.escape).join('') + ']', 'g'),
    unescape: new RegExp('(' + _.keys(entityMap.unescape).join('|') + ')', 'g')
  };

  // Functions for escaping and unescaping strings to/from HTML interpolation.
  _.each(['escape', 'unescape'], function(method) {
    _[method] = function(string) {
      if (string == null) return '';
      return ('' + string).replace(entityRegexes[method], function(match) {
        return entityMap[method][match];
      });
    };
  });

  // If the value of the named property is a function then invoke it;
  // otherwise, return it.
  _.result = function(object, property) {
    if (object == null) return null;
    var value = object[property];
    return _.isFunction(value) ? value.call(object) : value;
  };

  // Add your own custom functions to the Underscore object.
  _.mixin = function(obj) {
    each(_.functions(obj), function(name){
      var func = _[name] = obj[name];
      _.prototype[name] = function() {
        var args = [this._wrapped];
        push.apply(args, arguments);
        return result.call(this, func.apply(_, args));
      };
    });
  };

  // Generate a unique integer id (unique within the entire client session).
  // Useful for temporary DOM ids.
  var idCounter = 0;
  _.uniqueId = function(prefix) {
    var id = idCounter++;
    return prefix ? prefix + id : id;
  };

  // By default, Underscore uses ERB-style template delimiters, change the
  // following template settings to use alternative delimiters.
  _.templateSettings = {
    evaluate    : /<%([\s\S]+?)%>/g,
    interpolate : /<%=([\s\S]+?)%>/g,
    escape      : /<%-([\s\S]+?)%>/g
  };

  // When customizing `templateSettings`, if you don't want to define an
  // interpolation, evaluation or escaping regex, we need one that is
  // guaranteed not to match.
  var noMatch = /(.)^/;

  // Certain characters need to be escaped so that they can be put into a
  // string literal.
  var escapes = {
    "'":      "'",
    '\\':     '\\',
    '\r':     'r',
    '\n':     'n',
    '\t':     't',
    '\u2028': 'u2028',
    '\u2029': 'u2029'
  };

  var escaper = /\\|'|\r|\n|\t|\u2028|\u2029/g;

  // JavaScript micro-templating, similar to John Resig's implementation.
  // Underscore templating handles arbitrary delimiters, preserves whitespace,
  // and correctly escapes quotes within interpolated code.
  _.template = function(text, data, settings) {
    settings = _.defaults({}, settings, _.templateSettings);

    // Combine delimiters into one regular expression via alternation.
    var matcher = new RegExp([
      (settings.escape || noMatch).source,
      (settings.interpolate || noMatch).source,
      (settings.evaluate || noMatch).source
    ].join('|') + '|$', 'g');

    // Compile the template source, escaping string literals appropriately.
    var index = 0;
    var source = "__p+='";
    text.replace(matcher, function(match, escape, interpolate, evaluate, offset) {
      source += text.slice(index, offset)
        .replace(escaper, function(match) { return '\\' + escapes[match]; });
      source +=
        escape ? "'+\n((__t=(" + escape + "))==null?'':_.escape(__t))+\n'" :
        interpolate ? "'+\n((__t=(" + interpolate + "))==null?'':__t)+\n'" :
        evaluate ? "';\n" + evaluate + "\n__p+='" : '';
      index = offset + match.length;
    });
    source += "';\n";

    // If a variable is not specified, place data values in local scope.
    if (!settings.variable) source = 'with(obj||{}){\n' + source + '}\n';

    source = "var __t,__p='',__j=Array.prototype.join," +
      "print=function(){__p+=__j.call(arguments,'');};\n" +
      source + "return __p;\n";

    try {
      var render = new Function(settings.variable || 'obj', '_', source);
    } catch (e) {
      e.source = source;
      throw e;
    }

    if (data) return render(data, _);
    var template = function(data) {
      return render.call(this, data, _);
    };

    // Provide the compiled function source as a convenience for precompilation.
    template.source = 'function(' + (settings.variable || 'obj') + '){\n' + source + '}';

    return template;
  };

  // Add a "chain" function, which will delegate to the wrapper.
  _.chain = function(obj) {
    return _(obj).chain();
  };

  // OOP
  // ---------------
  // If Underscore is called as a function, it returns a wrapped object that
  // can be used OO-style. This wrapper holds altered versions of all the
  // underscore functions. Wrapped objects may be chained.

  // Helper function to continue chaining intermediate results.
  var result = function(obj) {
    return this._chain ? _(obj).chain() : obj;
  };

  // Add all of the Underscore functions to the wrapper object.
  _.mixin(_);

  // Add all mutator Array functions to the wrapper.
  each(['pop', 'push', 'reverse', 'shift', 'sort', 'splice', 'unshift'], function(name) {
    var method = ArrayProto[name];
    _.prototype[name] = function() {
      var obj = this._wrapped;
      method.apply(obj, arguments);
      if ((name == 'shift' || name == 'splice') && obj.length === 0) delete obj[0];
      return result.call(this, obj);
    };
  });

  // Add all accessor Array functions to the wrapper.
  each(['concat', 'join', 'slice'], function(name) {
    var method = ArrayProto[name];
    _.prototype[name] = function() {
      return result.call(this, method.apply(this._wrapped, arguments));
    };
  });

  _.extend(_.prototype, {

    // Start chaining a wrapped Underscore object.
    chain: function() {
      this._chain = true;
      return this;
    },

    // Extracts the result from a wrapped and chained object.
    value: function() {
      return this._wrapped;
    }

  });

}).call(this);

define("underscore", function(){});

//     Backbone.js 0.9.2

//     (c) 2010-2012 Jeremy Ashkenas, DocumentCloud Inc.
//     Backbone may be freely distributed under the MIT license.
//     For all details and documentation:
//     http://backbonejs.org

(function(){

  // Initial Setup
  // -------------

  // Save a reference to the global object (`window` in the browser, `global`
  // on the server).
  var root = this;

  // Save the previous value of the `Backbone` variable, so that it can be
  // restored later on, if `noConflict` is used.
  var previousBackbone = root.Backbone;

  // Create a local reference to slice/splice.
  var slice = Array.prototype.slice;
  var splice = Array.prototype.splice;

  // The top-level namespace. All public Backbone classes and modules will
  // be attached to this. Exported for both CommonJS and the browser.
  var Backbone;
  if (typeof exports !== 'undefined') {
    Backbone = exports;
  } else {
    Backbone = root.Backbone = {};
  }

  // Current version of the library. Keep in sync with `package.json`.
  Backbone.VERSION = '0.9.2';

  // Require Underscore, if we're on the server, and it's not already present.
  var _ = root._;
  if (!_ && (typeof require !== 'undefined')) _ = require('underscore');

  // For Backbone's purposes, jQuery, Zepto, or Ender owns the `$` variable.
  var $ = root.jQuery || root.Zepto || root.ender;

  // Set the JavaScript library that will be used for DOM manipulation and
  // Ajax calls (a.k.a. the `$` variable). By default Backbone will use: jQuery,
  // Zepto, or Ender; but the `setDomLibrary()` method lets you inject an
  // alternate JavaScript library (or a mock library for testing your views
  // outside of a browser).
  Backbone.setDomLibrary = function(lib) {
    $ = lib;
  };

  // Runs Backbone.js in *noConflict* mode, returning the `Backbone` variable
  // to its previous owner. Returns a reference to this Backbone object.
  Backbone.noConflict = function() {
    root.Backbone = previousBackbone;
    return this;
  };

  // Turn on `emulateHTTP` to support legacy HTTP servers. Setting this option
  // will fake `"PUT"` and `"DELETE"` requests via the `_method` parameter and
  // set a `X-Http-Method-Override` header.
  Backbone.emulateHTTP = false;

  // Turn on `emulateJSON` to support legacy servers that can't deal with direct
  // `application/json` requests ... will encode the body as
  // `application/x-www-form-urlencoded` instead and will send the model in a
  // form param named `model`.
  Backbone.emulateJSON = false;

  // Backbone.Events
  // -----------------

  // Regular expression used to split event strings
  var eventSplitter = /\s+/;

  // A module that can be mixed in to *any object* in order to provide it with
  // custom events. You may bind with `on` or remove with `off` callback functions
  // to an event; trigger`-ing an event fires all callbacks in succession.
  //
  //     var object = {};
  //     _.extend(object, Backbone.Events);
  //     object.on('expand', function(){ alert('expanded'); });
  //     object.trigger('expand');
  //
  var Events = Backbone.Events = {

    // Bind one or more space separated events, `events`, to a `callback`
    // function. Passing `"all"` will bind the callback to all events fired.
    on: function(events, callback, context) {

      var calls, event, node, tail, list;
      if (!callback) return this;
      events = events.split(eventSplitter);
      calls = this._callbacks || (this._callbacks = {});

      // Create an immutable callback list, allowing traversal during
      // modification.  The tail is an empty object that will always be used
      // as the next node.
      while (event = events.shift()) {
        list = calls[event];
        node = list ? list.tail : {};
        node.next = tail = {};
        node.context = context;
        node.callback = callback;
        calls[event] = {tail: tail, next: list ? list.next : node};
      }

      return this;
    },

    // Remove one or many callbacks. If `context` is null, removes all callbacks
    // with that function. If `callback` is null, removes all callbacks for the
    // event. If `events` is null, removes all bound callbacks for all events.
    off: function(events, callback, context) {
      var event, calls, node, tail, cb, ctx;

      // No events, or removing *all* events.
      if (!(calls = this._callbacks)) return;
      if (!(events || callback || context)) {
        delete this._callbacks;
        return this;
      }

      // Loop through the listed events and contexts, splicing them out of the
      // linked list of callbacks if appropriate.
      events = events ? events.split(eventSplitter) : _.keys(calls);
      while (event = events.shift()) {
        node = calls[event];
        delete calls[event];
        if (!node || !(callback || context)) continue;
        // Create a new list, omitting the indicated callbacks.
        tail = node.tail;
        while ((node = node.next) !== tail) {
          cb = node.callback;
          ctx = node.context;
          if ((callback && cb !== callback) || (context && ctx !== context)) {
            this.on(event, cb, ctx);
          }
        }
      }

      return this;
    },

    // Trigger one or many events, firing all bound callbacks. Callbacks are
    // passed the same arguments as `trigger` is, apart from the event name
    // (unless you're listening on `"all"`, which will cause your callback to
    // receive the true name of the event as the first argument).
    trigger: function(events) {
      var event, node, calls, tail, args, all, rest;
      if (!(calls = this._callbacks)) return this;
      all = calls.all;
      events = events.split(eventSplitter);
      rest = slice.call(arguments, 1);

      // For each event, walk through the linked list of callbacks twice,
      // first to trigger the event, then to trigger any `"all"` callbacks.
      while (event = events.shift()) {
        if (node = calls[event]) {
          tail = node.tail;
          while ((node = node.next) !== tail) {
            node.callback.apply(node.context || this, rest);
          }
        }
        if (node = all) {
          tail = node.tail;
          args = [event].concat(rest);
          while ((node = node.next) !== tail) {
            node.callback.apply(node.context || this, args);
          }
        }
      }

      return this;
    }

  };

  // Aliases for backwards compatibility.
  Events.bind   = Events.on;
  Events.unbind = Events.off;

  // Backbone.Model
  // --------------

  // Create a new model, with defined attributes. A client id (`cid`)
  // is automatically generated and assigned for you.
  var Model = Backbone.Model = function(attributes, options) {
    var defaults;
    attributes || (attributes = {});
    if (options && options.parse) attributes = this.parse(attributes);
    if (defaults = getValue(this, 'defaults')) {
      attributes = _.extend({}, defaults, attributes);
    }
    if (options && options.collection) this.collection = options.collection;
    this.attributes = {};
    this._escapedAttributes = {};
    this.cid = _.uniqueId('c');
    this.changed = {};
    this._silent = {};
    this._pending = {};
    this.set(attributes, {silent: true});
    // Reset change tracking.
    this.changed = {};
    this._silent = {};
    this._pending = {};
    this._previousAttributes = _.clone(this.attributes);
    this.initialize.apply(this, arguments);
  };

  // Attach all inheritable methods to the Model prototype.
  _.extend(Model.prototype, Events, {

    // A hash of attributes whose current and previous value differ.
    changed: null,

    // A hash of attributes that have silently changed since the last time
    // `change` was called.  Will become pending attributes on the next call.
    _silent: null,

    // A hash of attributes that have changed since the last `'change'` event
    // began.
    _pending: null,

    // The default name for the JSON `id` attribute is `"id"`. MongoDB and
    // CouchDB users may want to set this to `"_id"`.
    idAttribute: 'id',

    // Initialize is an empty function by default. Override it with your own
    // initialization logic.
    initialize: function(){},

    // Return a copy of the model's `attributes` object.
    toJSON: function(options) {
      return _.clone(this.attributes);
    },

    // Get the value of an attribute.
    get: function(attr) {
      return this.attributes[attr];
    },

    // Get the HTML-escaped value of an attribute.
    escape: function(attr) {
      var html;
      if (html = this._escapedAttributes[attr]) return html;
      var val = this.get(attr);
      return this._escapedAttributes[attr] = _.escape(val == null ? '' : '' + val);
    },

    // Returns `true` if the attribute contains a value that is not null
    // or undefined.
    has: function(attr) {
      return this.get(attr) != null;
    },

    // Set a hash of model attributes on the object, firing `"change"` unless
    // you choose to silence it.
    set: function(key, value, options) {
      var attrs, attr, val;

      // Handle both `"key", value` and `{key: value}` -style arguments.
      if (_.isObject(key) || key == null) {
        attrs = key;
        options = value;
      } else {
        attrs = {};
        attrs[key] = value;
      }

      // Extract attributes and options.
      options || (options = {});
      if (!attrs) return this;
      if (attrs instanceof Model) attrs = attrs.attributes;
      if (options.unset) for (attr in attrs) attrs[attr] = void 0;

      // Run validation.
      if (!this._validate(attrs, options)) return false;

      // Check for changes of `id`.
      if (this.idAttribute in attrs) this.id = attrs[this.idAttribute];

      var changes = options.changes = {};
      var now = this.attributes;
      var escaped = this._escapedAttributes;
      var prev = this._previousAttributes || {};

      // For each `set` attribute...
      for (attr in attrs) {
        val = attrs[attr];

        // If the new and current value differ, record the change.
        if (!_.isEqual(now[attr], val) || (options.unset && _.has(now, attr))) {
          delete escaped[attr];
          (options.silent ? this._silent : changes)[attr] = true;
        }

        // Update or delete the current value.
        options.unset ? delete now[attr] : now[attr] = val;

        // If the new and previous value differ, record the change.  If not,
        // then remove changes for this attribute.
        if (!_.isEqual(prev[attr], val) || (_.has(now, attr) != _.has(prev, attr))) {
          this.changed[attr] = val;
          if (!options.silent) this._pending[attr] = true;
        } else {
          delete this.changed[attr];
          delete this._pending[attr];
        }
      }

      // Fire the `"change"` events.
      if (!options.silent) this.change(options);
      return this;
    },

    // Remove an attribute from the model, firing `"change"` unless you choose
    // to silence it. `unset` is a noop if the attribute doesn't exist.
    unset: function(attr, options) {
      (options || (options = {})).unset = true;
      return this.set(attr, null, options);
    },

    // Clear all attributes on the model, firing `"change"` unless you choose
    // to silence it.
    clear: function(options) {
      (options || (options = {})).unset = true;
      return this.set(_.clone(this.attributes), options);
    },

    // Fetch the model from the server. If the server's representation of the
    // model differs from its current attributes, they will be overriden,
    // triggering a `"change"` event.
    fetch: function(options) {
      options = options ? _.clone(options) : {};
      var model = this;
      var success = options.success;
      options.success = function(resp, status, xhr) {
        if (!model.set(model.parse(resp, xhr), options)) return false;
        if (success) success(model, resp);
      };
      options.error = Backbone.wrapError(options.error, model, options);
      return (this.sync || Backbone.sync).call(this, 'read', this, options);
    },

    // Set a hash of model attributes, and sync the model to the server.
    // If the server returns an attributes hash that differs, the model's
    // state will be `set` again.
    save: function(key, value, options) {
      var attrs, current;

      // Handle both `("key", value)` and `({key: value})` -style calls.
      if (_.isObject(key) || key == null) {
        attrs = key;
        options = value;
      } else {
        attrs = {};
        attrs[key] = value;
      }
      options = options ? _.clone(options) : {};

      // If we're "wait"-ing to set changed attributes, validate early.
      if (options.wait) {
        if (!this._validate(attrs, options)) return false;
        current = _.clone(this.attributes);
      }

      // Regular saves `set` attributes before persisting to the server.
      var silentOptions = _.extend({}, options, {silent: true});
      if (attrs && !this.set(attrs, options.wait ? silentOptions : options)) {
        return false;
      }

      // After a successful server-side save, the client is (optionally)
      // updated with the server-side state.
      var model = this;
      var success = options.success;
      options.success = function(resp, status, xhr) {
        var serverAttrs = model.parse(resp, xhr);
        if (options.wait) {
          delete options.wait;
          serverAttrs = _.extend(attrs || {}, serverAttrs);
        }
        if (!model.set(serverAttrs, options)) return false;
        if (success) {
          success(model, resp);
        } else {
          model.trigger('sync', model, resp, options);
        }
      };

      // Finish configuring and sending the Ajax request.
      options.error = Backbone.wrapError(options.error, model, options);
      var method = this.isNew() ? 'create' : 'update';
      var xhr = (this.sync || Backbone.sync).call(this, method, this, options);
      if (options.wait) this.set(current, silentOptions);
      return xhr;
    },

    // Destroy this model on the server if it was already persisted.
    // Optimistically removes the model from its collection, if it has one.
    // If `wait: true` is passed, waits for the server to respond before removal.
    destroy: function(options) {
      options = options ? _.clone(options) : {};
      var model = this;
      var success = options.success;

      var triggerDestroy = function() {
        model.trigger('destroy', model, model.collection, options);
      };

      if (this.isNew()) {
        triggerDestroy();
        return false;
      }

      options.success = function(resp) {
        if (options.wait) triggerDestroy();
        if (success) {
          success(model, resp);
        } else {
          model.trigger('sync', model, resp, options);
        }
      };

      options.error = Backbone.wrapError(options.error, model, options);
      var xhr = (this.sync || Backbone.sync).call(this, 'delete', this, options);
      if (!options.wait) triggerDestroy();
      return xhr;
    },

    // Default URL for the model's representation on the server -- if you're
    // using Backbone's restful methods, override this to change the endpoint
    // that will be called.
    url: function() {
      var base = getValue(this, 'urlRoot') || getValue(this.collection, 'url') || urlError();
      if (this.isNew()) return base;
      return base + (base.charAt(base.length - 1) == '/' ? '' : '/') + encodeURIComponent(this.id);
    },

    // **parse** converts a response into the hash of attributes to be `set` on
    // the model. The default implementation is just to pass the response along.
    parse: function(resp, xhr) {
      return resp;
    },

    // Create a new model with identical attributes to this one.
    clone: function() {
      return new this.constructor(this.attributes);
    },

    // A model is new if it has never been saved to the server, and lacks an id.
    isNew: function() {
      return this.id == null;
    },

    // Call this method to manually fire a `"change"` event for this model and
    // a `"change:attribute"` event for each changed attribute.
    // Calling this will cause all objects observing the model to update.
    change: function(options) {
      options || (options = {});
      var changing = this._changing;
      this._changing = true;

      // Silent changes become pending changes.
      for (var attr in this._silent) this._pending[attr] = true;

      // Silent changes are triggered.
      var changes = _.extend({}, options.changes, this._silent);
      this._silent = {};
      for (var attr in changes) {
        this.trigger('change:' + attr, this, this.get(attr), options);
      }
      if (changing) return this;

      // Continue firing `"change"` events while there are pending changes.
      while (!_.isEmpty(this._pending)) {
        this._pending = {};
        this.trigger('change', this, options);
        // Pending and silent changes still remain.
        for (var attr in this.changed) {
          if (this._pending[attr] || this._silent[attr]) continue;
          delete this.changed[attr];
        }
        this._previousAttributes = _.clone(this.attributes);
      }

      this._changing = false;
      return this;
    },

    // Determine if the model has changed since the last `"change"` event.
    // If you specify an attribute name, determine if that attribute has changed.
    hasChanged: function(attr) {
      if (!arguments.length) return !_.isEmpty(this.changed);
      return _.has(this.changed, attr);
    },

    // Return an object containing all the attributes that have changed, or
    // false if there are no changed attributes. Useful for determining what
    // parts of a view need to be updated and/or what attributes need to be
    // persisted to the server. Unset attributes will be set to undefined.
    // You can also pass an attributes object to diff against the model,
    // determining if there *would be* a change.
    changedAttributes: function(diff) {
      if (!diff) return this.hasChanged() ? _.clone(this.changed) : false;
      var val, changed = false, old = this._previousAttributes;
      for (var attr in diff) {
        if (_.isEqual(old[attr], (val = diff[attr]))) continue;
        (changed || (changed = {}))[attr] = val;
      }
      return changed;
    },

    // Get the previous value of an attribute, recorded at the time the last
    // `"change"` event was fired.
    previous: function(attr) {
      if (!arguments.length || !this._previousAttributes) return null;
      return this._previousAttributes[attr];
    },

    // Get all of the attributes of the model at the time of the previous
    // `"change"` event.
    previousAttributes: function() {
      return _.clone(this._previousAttributes);
    },

    // Check if the model is currently in a valid state. It's only possible to
    // get into an *invalid* state if you're using silent changes.
    isValid: function() {
      return !this.validate(this.attributes);
    },

    // Run validation against the next complete set of model attributes,
    // returning `true` if all is well. If a specific `error` callback has
    // been passed, call that instead of firing the general `"error"` event.
    _validate: function(attrs, options) {
      if (options.silent || !this.validate) return true;
      attrs = _.extend({}, this.attributes, attrs);
      var error = this.validate(attrs, options);
      if (!error) return true;
      if (options && options.error) {
        options.error(this, error, options);
      } else {
        this.trigger('error', this, error, options);
      }
      return false;
    }

  });

  // Backbone.Collection
  // -------------------

  // Provides a standard collection class for our sets of models, ordered
  // or unordered. If a `comparator` is specified, the Collection will maintain
  // its models in sort order, as they're added and removed.
  var Collection = Backbone.Collection = function(models, options) {
    options || (options = {});
    if (options.model) this.model = options.model;
    if (options.comparator) this.comparator = options.comparator;
    this._reset();
    this.initialize.apply(this, arguments);
    if (models) this.reset(models, {silent: true, parse: options.parse});
  };

  // Define the Collection's inheritable methods.
  _.extend(Collection.prototype, Events, {

    // The default model for a collection is just a **Backbone.Model**.
    // This should be overridden in most cases.
    model: Model,

    // Initialize is an empty function by default. Override it with your own
    // initialization logic.
    initialize: function(){},

    // The JSON representation of a Collection is an array of the
    // models' attributes.
    toJSON: function(options) {
      return this.map(function(model){ return model.toJSON(options); });
    },

    // Add a model, or list of models to the set. Pass **silent** to avoid
    // firing the `add` event for every new model.
    add: function(models, options) {
      var i, index, length, model, cid, id, cids = {}, ids = {}, dups = [];
      options || (options = {});
      models = _.isArray(models) ? models.slice() : [models];

      // Begin by turning bare objects into model references, and preventing
      // invalid models or duplicate models from being added.
      for (i = 0, length = models.length; i < length; i++) {
        if (!(model = models[i] = this._prepareModel(models[i], options))) {
          throw new Error("Can't add an invalid model to a collection");
        }
        cid = model.cid;
        id = model.id;
        if (cids[cid] || this._byCid[cid] || ((id != null) && (ids[id] || this._byId[id]))) {
          dups.push(i);
          continue;
        }
        cids[cid] = ids[id] = model;
      }

      // Remove duplicates.
      i = dups.length;
      while (i--) {
        models.splice(dups[i], 1);
      }

      // Listen to added models' events, and index models for lookup by
      // `id` and by `cid`.
      for (i = 0, length = models.length; i < length; i++) {
        (model = models[i]).on('all', this._onModelEvent, this);
        this._byCid[model.cid] = model;
        if (model.id != null) this._byId[model.id] = model;
      }

      // Insert models into the collection, re-sorting if needed, and triggering
      // `add` events unless silenced.
      this.length += length;
      index = options.at != null ? options.at : this.models.length;
      splice.apply(this.models, [index, 0].concat(models));
      if (this.comparator) this.sort({silent: true});
      if (options.silent) return this;
      for (i = 0, length = this.models.length; i < length; i++) {
        if (!cids[(model = this.models[i]).cid]) continue;
        options.index = i;
        model.trigger('add', model, this, options);
      }
      return this;
    },

    // Remove a model, or a list of models from the set. Pass silent to avoid
    // firing the `remove` event for every model removed.
    remove: function(models, options) {
      var i, l, index, model;
      options || (options = {});
      models = _.isArray(models) ? models.slice() : [models];
      for (i = 0, l = models.length; i < l; i++) {
        model = this.getByCid(models[i]) || this.get(models[i]);
        if (!model) continue;
        delete this._byId[model.id];
        delete this._byCid[model.cid];
        index = this.indexOf(model);
        this.models.splice(index, 1);
        this.length--;
        if (!options.silent) {
          options.index = index;
          model.trigger('remove', model, this, options);
        }
        this._removeReference(model);
      }
      return this;
    },

    // Add a model to the end of the collection.
    push: function(model, options) {
      model = this._prepareModel(model, options);
      this.add(model, options);
      return model;
    },

    // Remove a model from the end of the collection.
    pop: function(options) {
      var model = this.at(this.length - 1);
      this.remove(model, options);
      return model;
    },

    // Add a model to the beginning of the collection.
    unshift: function(model, options) {
      model = this._prepareModel(model, options);
      this.add(model, _.extend({at: 0}, options));
      return model;
    },

    // Remove a model from the beginning of the collection.
    shift: function(options) {
      var model = this.at(0);
      this.remove(model, options);
      return model;
    },

    // Get a model from the set by id.
    get: function(id) {
      if (id == null) return void 0;
      return this._byId[id.id != null ? id.id : id];
    },

    // Get a model from the set by client id.
    getByCid: function(cid) {
      return cid && this._byCid[cid.cid || cid];
    },

    // Get the model at the given index.
    at: function(index) {
      return this.models[index];
    },

    // Return models with matching attributes. Useful for simple cases of `filter`.
    where: function(attrs) {
      if (_.isEmpty(attrs)) return [];
      return this.filter(function(model) {
        for (var key in attrs) {
          if (attrs[key] !== model.get(key)) return false;
        }
        return true;
      });
    },

    // Force the collection to re-sort itself. You don't need to call this under
    // normal circumstances, as the set will maintain sort order as each item
    // is added.
    sort: function(options) {
      options || (options = {});
      if (!this.comparator) throw new Error('Cannot sort a set without a comparator');
      var boundComparator = _.bind(this.comparator, this);
      if (this.comparator.length == 1) {
        this.models = this.sortBy(boundComparator);
      } else {
        this.models.sort(boundComparator);
      }
      if (!options.silent) this.trigger('reset', this, options);
      return this;
    },

    // Pluck an attribute from each model in the collection.
    pluck: function(attr) {
      return _.map(this.models, function(model){ return model.get(attr); });
    },

    // When you have more items than you want to add or remove individually,
    // you can reset the entire set with a new list of models, without firing
    // any `add` or `remove` events. Fires `reset` when finished.
    reset: function(models, options) {
      models  || (models = []);
      options || (options = {});
      for (var i = 0, l = this.models.length; i < l; i++) {
        this._removeReference(this.models[i]);
      }
      this._reset();
      this.add(models, _.extend({silent: true}, options));
      if (!options.silent) this.trigger('reset', this, options);
      return this;
    },

    // Fetch the default set of models for this collection, resetting the
    // collection when they arrive. If `add: true` is passed, appends the
    // models to the collection instead of resetting.
    fetch: function(options) {
      options = options ? _.clone(options) : {};
      if (options.parse === undefined) options.parse = true;
      var collection = this;
      var success = options.success;
      options.success = function(resp, status, xhr) {
        collection[options.add ? 'add' : 'reset'](collection.parse(resp, xhr), options);
        if (success) success(collection, resp);
      };
      options.error = Backbone.wrapError(options.error, collection, options);
      return (this.sync || Backbone.sync).call(this, 'read', this, options);
    },

    // Create a new instance of a model in this collection. Add the model to the
    // collection immediately, unless `wait: true` is passed, in which case we
    // wait for the server to agree.
    create: function(model, options) {
      var coll = this;
      options = options ? _.clone(options) : {};
      model = this._prepareModel(model, options);
      if (!model) return false;
      if (!options.wait) coll.add(model, options);
      var success = options.success;
      options.success = function(nextModel, resp, xhr) {
        if (options.wait) coll.add(nextModel, options);
        if (success) {
          success(nextModel, resp);
        } else {
          nextModel.trigger('sync', model, resp, options);
        }
      };
      model.save(null, options);
      return model;
    },

    // **parse** converts a response into a list of models to be added to the
    // collection. The default implementation is just to pass it through.
    parse: function(resp, xhr) {
      return resp;
    },

    // Proxy to _'s chain. Can't be proxied the same way the rest of the
    // underscore methods are proxied because it relies on the underscore
    // constructor.
    chain: function () {
      return _(this.models).chain();
    },

    // Reset all internal state. Called when the collection is reset.
    _reset: function(options) {
      this.length = 0;
      this.models = [];
      this._byId  = {};
      this._byCid = {};
    },

    // Prepare a model or hash of attributes to be added to this collection.
    _prepareModel: function(model, options) {
      options || (options = {});
      if (!(model instanceof Model)) {
        var attrs = model;
        options.collection = this;
        model = new this.model(attrs, options);
        if (!model._validate(model.attributes, options)) model = false;
      } else if (!model.collection) {
        model.collection = this;
      }
      return model;
    },

    // Internal method to remove a model's ties to a collection.
    _removeReference: function(model) {
      if (this == model.collection) {
        delete model.collection;
      }
      model.off('all', this._onModelEvent, this);
    },

    // Internal method called every time a model in the set fires an event.
    // Sets need to update their indexes when models change ids. All other
    // events simply proxy through. "add" and "remove" events that originate
    // in other collections are ignored.
    _onModelEvent: function(event, model, collection, options) {
      if ((event == 'add' || event == 'remove') && collection != this) return;
      if (event == 'destroy') {
        this.remove(model, options);
      }
      if (model && event === 'change:' + model.idAttribute) {
        delete this._byId[model.previous(model.idAttribute)];
        this._byId[model.id] = model;
      }
      this.trigger.apply(this, arguments);
    }

  });

  // Underscore methods that we want to implement on the Collection.
  var methods = ['forEach', 'each', 'map', 'reduce', 'reduceRight', 'find',
    'detect', 'filter', 'select', 'reject', 'every', 'all', 'some', 'any',
    'include', 'contains', 'invoke', 'max', 'min', 'sortBy', 'sortedIndex',
    'toArray', 'size', 'first', 'initial', 'rest', 'last', 'without', 'indexOf',
    'shuffle', 'lastIndexOf', 'isEmpty', 'groupBy'];

  // Mix in each Underscore method as a proxy to `Collection#models`.
  _.each(methods, function(method) {
    Collection.prototype[method] = function() {
      return _[method].apply(_, [this.models].concat(_.toArray(arguments)));
    };
  });

  // Backbone.Router
  // -------------------

  // Routers map faux-URLs to actions, and fire events when routes are
  // matched. Creating a new one sets its `routes` hash, if not set statically.
  var Router = Backbone.Router = function(options) {
    options || (options = {});
    if (options.routes) this.routes = options.routes;
    this._bindRoutes();
    this.initialize.apply(this, arguments);
  };

  // Cached regular expressions for matching named param parts and splatted
  // parts of route strings.
  var namedParam    = /:\w+/g;
  var splatParam    = /\*\w+/g;
  var escapeRegExp  = /[-[\]{}()+?.,\\^$|#\s]/g;

  // Set up all inheritable **Backbone.Router** properties and methods.
  _.extend(Router.prototype, Events, {

    // Initialize is an empty function by default. Override it with your own
    // initialization logic.
    initialize: function(){},

    // Manually bind a single named route to a callback. For example:
    //
    //     this.route('search/:query/p:num', 'search', function(query, num) {
    //       ...
    //     });
    //
    route: function(route, name, callback) {
      Backbone.history || (Backbone.history = new History);
      if (!_.isRegExp(route)) route = this._routeToRegExp(route);
      if (!callback) callback = this[name];
      Backbone.history.route(route, _.bind(function(fragment) {
        var args = this._extractParameters(route, fragment);
        callback && callback.apply(this, args);
        this.trigger.apply(this, ['route:' + name].concat(args));
        Backbone.history.trigger('route', this, name, args);
      }, this));
      return this;
    },

    // Simple proxy to `Backbone.history` to save a fragment into the history.
    navigate: function(fragment, options) {
      Backbone.history.navigate(fragment, options);
    },

    // Bind all defined routes to `Backbone.history`. We have to reverse the
    // order of the routes here to support behavior where the most general
    // routes can be defined at the bottom of the route map.
    _bindRoutes: function() {
      if (!this.routes) return;
      var routes = [];
      for (var route in this.routes) {
        routes.unshift([route, this.routes[route]]);
      }
      for (var i = 0, l = routes.length; i < l; i++) {
        this.route(routes[i][0], routes[i][1], this[routes[i][1]]);
      }
    },

    // Convert a route string into a regular expression, suitable for matching
    // against the current location hash.
    _routeToRegExp: function(route) {
      route = route.replace(escapeRegExp, '\\$&')
                   .replace(namedParam, '([^\/]+)')
                   .replace(splatParam, '(.*?)');
      return new RegExp('^' + route + '$');
    },

    // Given a route, and a URL fragment that it matches, return the array of
    // extracted parameters.
    _extractParameters: function(route, fragment) {
      return route.exec(fragment).slice(1);
    }

  });

  // Backbone.History
  // ----------------

  // Handles cross-browser history management, based on URL fragments. If the
  // browser does not support `onhashchange`, falls back to polling.
  var History = Backbone.History = function() {
    this.handlers = [];
    _.bindAll(this, 'checkUrl');
  };

  // Cached regex for cleaning leading hashes and slashes .
  var routeStripper = /^[#\/]/;

  // Cached regex for detecting MSIE.
  var isExplorer = /msie [\w.]+/;

  // Has the history handling already been started?
  History.started = false;

  // Set up all inheritable **Backbone.History** properties and methods.
  _.extend(History.prototype, Events, {

    // The default interval to poll for hash changes, if necessary, is
    // twenty times a second.
    interval: 50,

    // Gets the true hash value. Cannot use location.hash directly due to bug
    // in Firefox where location.hash will always be decoded.
    getHash: function(windowOverride) {
      var loc = windowOverride ? windowOverride.location : window.location;
      var match = loc.href.match(/#(.*)$/);
      return match ? match[1] : '';
    },

    // Get the cross-browser normalized URL fragment, either from the URL,
    // the hash, or the override.
    getFragment: function(fragment, forcePushState) {
      if (fragment == null) {
        if (this._hasPushState || forcePushState) {
          fragment = window.location.pathname;
          var search = window.location.search;
          if (search) fragment += search;
        } else {
          fragment = this.getHash();
        }
      }
      if (!fragment.indexOf(this.options.root)) fragment = fragment.substr(this.options.root.length);
      return fragment.replace(routeStripper, '');
    },

    // Start the hash change handling, returning `true` if the current URL matches
    // an existing route, and `false` otherwise.
    start: function(options) {
      if (History.started) throw new Error("Backbone.history has already been started");
      History.started = true;

      // Figure out the initial configuration. Do we need an iframe?
      // Is pushState desired ... is it available?
      this.options          = _.extend({}, {root: '/'}, this.options, options);
      this._wantsHashChange = this.options.hashChange !== false;
      this._wantsPushState  = !!this.options.pushState;
      this._hasPushState    = !!(this.options.pushState && window.history && window.history.pushState);
      var fragment          = this.getFragment();
      var docMode           = document.documentMode;
      var oldIE             = (isExplorer.exec(navigator.userAgent.toLowerCase()) && (!docMode || docMode <= 7));

      if (oldIE) {
        this.iframe = $('<iframe src="javascript:0" tabindex="-1" />').hide().appendTo('body')[0].contentWindow;
        this.navigate(fragment);
      }

      // Depending on whether we're using pushState or hashes, and whether
      // 'onhashchange' is supported, determine how we check the URL state.
      if (this._hasPushState) {
        $(window).bind('popstate', this.checkUrl);
      } else if (this._wantsHashChange && ('onhashchange' in window) && !oldIE) {
        $(window).bind('hashchange', this.checkUrl);
      } else if (this._wantsHashChange) {
        this._checkUrlInterval = setInterval(this.checkUrl, this.interval);
      }

      // Determine if we need to change the base url, for a pushState link
      // opened by a non-pushState browser.
      this.fragment = fragment;
      var loc = window.location;
      var atRoot  = loc.pathname == this.options.root;

      // If we've started off with a route from a `pushState`-enabled browser,
      // but we're currently in a browser that doesn't support it...
      if (this._wantsHashChange && this._wantsPushState && !this._hasPushState && !atRoot) {
        this.fragment = this.getFragment(null, true);
        window.location.replace(this.options.root + '#' + this.fragment);
        // Return immediately as browser will do redirect to new url
        return true;

      // Or if we've started out with a hash-based route, but we're currently
      // in a browser where it could be `pushState`-based instead...
      } else if (this._wantsPushState && this._hasPushState && atRoot && loc.hash) {
        this.fragment = this.getHash().replace(routeStripper, '');
        window.history.replaceState({}, document.title, loc.protocol + '//' + loc.host + this.options.root + this.fragment);
      }

      if (!this.options.silent) {
        return this.loadUrl();
      }
    },

    // Disable Backbone.history, perhaps temporarily. Not useful in a real app,
    // but possibly useful for unit testing Routers.
    stop: function() {
      $(window).unbind('popstate', this.checkUrl).unbind('hashchange', this.checkUrl);
      clearInterval(this._checkUrlInterval);
      History.started = false;
    },

    // Add a route to be tested when the fragment changes. Routes added later
    // may override previous routes.
    route: function(route, callback) {
      this.handlers.unshift({route: route, callback: callback});
    },

    // Checks the current URL to see if it has changed, and if it has,
    // calls `loadUrl`, normalizing across the hidden iframe.
    checkUrl: function(e) {
      var current = this.getFragment();
      if (current == this.fragment && this.iframe) current = this.getFragment(this.getHash(this.iframe));
      if (current == this.fragment) return false;
      if (this.iframe) this.navigate(current);
      this.loadUrl() || this.loadUrl(this.getHash());
    },

    // Attempt to load the current URL fragment. If a route succeeds with a
    // match, returns `true`. If no defined routes matches the fragment,
    // returns `false`.
    loadUrl: function(fragmentOverride) {
      var fragment = this.fragment = this.getFragment(fragmentOverride);
      var matched = _.any(this.handlers, function(handler) {
        if (handler.route.test(fragment)) {
          handler.callback(fragment);
          return true;
        }
      });
      return matched;
    },

    // Save a fragment into the hash history, or replace the URL state if the
    // 'replace' option is passed. You are responsible for properly URL-encoding
    // the fragment in advance.
    //
    // The options object can contain `trigger: true` if you wish to have the
    // route callback be fired (not usually desirable), or `replace: true`, if
    // you wish to modify the current URL without adding an entry to the history.
    navigate: function(fragment, options) {
      if (!History.started) return false;
      if (!options || options === true) options = {trigger: options};
      var frag = (fragment || '').replace(routeStripper, '');
      if (this.fragment == frag) return;

      // If pushState is available, we use it to set the fragment as a real URL.
      if (this._hasPushState) {
        if (frag.indexOf(this.options.root) != 0) frag = this.options.root + frag;
        this.fragment = frag;
        window.history[options.replace ? 'replaceState' : 'pushState']({}, document.title, frag);

      // If hash changes haven't been explicitly disabled, update the hash
      // fragment to store history.
      } else if (this._wantsHashChange) {
        this.fragment = frag;
        this._updateHash(window.location, frag, options.replace);
        if (this.iframe && (frag != this.getFragment(this.getHash(this.iframe)))) {
          // Opening and closing the iframe tricks IE7 and earlier to push a history entry on hash-tag change.
          // When replace is true, we don't want this.
          if(!options.replace) this.iframe.document.open().close();
          this._updateHash(this.iframe.location, frag, options.replace);
        }

      // If you've told us that you explicitly don't want fallback hashchange-
      // based history, then `navigate` becomes a page refresh.
      } else {
        window.location.assign(this.options.root + fragment);
      }
      if (options.trigger) this.loadUrl(fragment);
    },

    // Update the hash location, either replacing the current entry, or adding
    // a new one to the browser history.
    _updateHash: function(location, fragment, replace) {
      if (replace) {
        location.replace(location.toString().replace(/(javascript:|#).*$/, '') + '#' + fragment);
      } else {
        location.hash = fragment;
      }
    }
  });

  // Backbone.View
  // -------------

  // Creating a Backbone.View creates its initial element outside of the DOM,
  // if an existing element is not provided...
  var View = Backbone.View = function(options) {
    this.cid = _.uniqueId('view');
    this._configure(options || {});
    this._ensureElement();
    this.initialize.apply(this, arguments);
    this.delegateEvents();
  };

  // Cached regex to split keys for `delegate`.
  var delegateEventSplitter = /^(\S+)\s*(.*)$/;

  // List of view options to be merged as properties.
  var viewOptions = ['model', 'collection', 'el', 'id', 'attributes', 'className', 'tagName'];

  // Set up all inheritable **Backbone.View** properties and methods.
  _.extend(View.prototype, Events, {

    // The default `tagName` of a View's element is `"div"`.
    tagName: 'div',

    // jQuery delegate for element lookup, scoped to DOM elements within the
    // current view. This should be prefered to global lookups where possible.
    $: function(selector) {
      return this.$el.find(selector);
    },

    // Initialize is an empty function by default. Override it with your own
    // initialization logic.
    initialize: function(){},

    // **render** is the core function that your view should override, in order
    // to populate its element (`this.el`), with the appropriate HTML. The
    // convention is for **render** to always return `this`.
    render: function() {
      return this;
    },

    // Remove this view from the DOM. Note that the view isn't present in the
    // DOM by default, so calling this method may be a no-op.
    remove: function() {
      this.$el.remove();
      return this;
    },

    // For small amounts of DOM Elements, where a full-blown template isn't
    // needed, use **make** to manufacture elements, one at a time.
    //
    //     var el = this.make('li', {'class': 'row'}, this.model.escape('title'));
    //
    make: function(tagName, attributes, content) {
      var el = document.createElement(tagName);
      if (attributes) $(el).attr(attributes);
      if (content) $(el).html(content);
      return el;
    },

    // Change the view's element (`this.el` property), including event
    // re-delegation.
    setElement: function(element, delegate) {
      if (this.$el) this.undelegateEvents();
      this.$el = (element instanceof $) ? element : $(element);
      this.el = this.$el[0];
      if (delegate !== false) this.delegateEvents();
      return this;
    },

    // Set callbacks, where `this.events` is a hash of
    //
    // *{"event selector": "callback"}*
    //
    //     {
    //       'mousedown .title':  'edit',
    //       'click .button':     'save'
    //       'click .open':       function(e) { ... }
    //     }
    //
    // pairs. Callbacks will be bound to the view, with `this` set properly.
    // Uses event delegation for efficiency.
    // Omitting the selector binds the event to `this.el`.
    // This only works for delegate-able events: not `focus`, `blur`, and
    // not `change`, `submit`, and `reset` in Internet Explorer.
    delegateEvents: function(events) {
      if (!(events || (events = getValue(this, 'events')))) return;
      this.undelegateEvents();
      for (var key in events) {
        var method = events[key];
        if (!_.isFunction(method)) method = this[events[key]];
        if (!method) throw new Error('Method "' + events[key] + '" does not exist');
        var match = key.match(delegateEventSplitter);
        var eventName = match[1], selector = match[2];
        method = _.bind(method, this);
        eventName += '.delegateEvents' + this.cid;
        if (selector === '') {
          this.$el.bind(eventName, method);
        } else {
          this.$el.delegate(selector, eventName, method);
        }
      }
    },

    // Clears all callbacks previously bound to the view with `delegateEvents`.
    // You usually don't need to use this, but may wish to if you have multiple
    // Backbone views attached to the same DOM element.
    undelegateEvents: function() {
      this.$el.unbind('.delegateEvents' + this.cid);
    },

    // Performs the initial configuration of a View with a set of options.
    // Keys with special meaning *(model, collection, id, className)*, are
    // attached directly to the view.
    _configure: function(options) {
      if (this.options) options = _.extend({}, this.options, options);
      for (var i = 0, l = viewOptions.length; i < l; i++) {
        var attr = viewOptions[i];
        if (options[attr]) this[attr] = options[attr];
      }
      this.options = options;
    },

    // Ensure that the View has a DOM element to render into.
    // If `this.el` is a string, pass it through `$()`, take the first
    // matching element, and re-assign it to `el`. Otherwise, create
    // an element from the `id`, `className` and `tagName` properties.
    _ensureElement: function() {
      if (!this.el) {
        var attrs = getValue(this, 'attributes') || {};
        if (this.id) attrs.id = this.id;
        if (this.className) attrs['class'] = this.className;
        this.setElement(this.make(this.tagName, attrs), false);
      } else {
        this.setElement(this.el, false);
      }
    }

  });

  // The self-propagating extend function that Backbone classes use.
  var extend = function (protoProps, classProps) {
    var child = inherits(this, protoProps, classProps);
    child.extend = this.extend;
    return child;
  };

  // Set up inheritance for the model, collection, and view.
  Model.extend = Collection.extend = Router.extend = View.extend = extend;

  // Backbone.sync
  // -------------

  // Map from CRUD to HTTP for our default `Backbone.sync` implementation.
  var methodMap = {
    'create': 'POST',
    'update': 'PUT',
    'delete': 'DELETE',
    'read':   'GET'
  };

  // Override this function to change the manner in which Backbone persists
  // models to the server. You will be passed the type of request, and the
  // model in question. By default, makes a RESTful Ajax request
  // to the model's `url()`. Some possible customizations could be:
  //
  // * Use `setTimeout` to batch rapid-fire updates into a single request.
  // * Send up the models as XML instead of JSON.
  // * Persist models via WebSockets instead of Ajax.
  //
  // Turn on `Backbone.emulateHTTP` in order to send `PUT` and `DELETE` requests
  // as `POST`, with a `_method` parameter containing the true HTTP method,
  // as well as all requests with the body as `application/x-www-form-urlencoded`
  // instead of `application/json` with the model in a param named `model`.
  // Useful when interfacing with server-side languages like **PHP** that make
  // it difficult to read the body of `PUT` requests.
  Backbone.sync = function(method, model, options) {
    var type = methodMap[method];

    // Default options, unless specified.
    options || (options = {});

    // Default JSON-request options.
    var params = {type: type, dataType: 'json'};

    // Ensure that we have a URL.
    if (!options.url) {
      params.url = getValue(model, 'url') || urlError();
    }

    // Ensure that we have the appropriate request data.
    if (!options.data && model && (method == 'create' || method == 'update')) {
      params.contentType = 'application/json';
      params.data = JSON.stringify(model.toJSON());
    }

    // For older servers, emulate JSON by encoding the request into an HTML-form.
    if (Backbone.emulateJSON) {
      params.contentType = 'application/x-www-form-urlencoded';
      params.data = params.data ? {model: params.data} : {};
    }

    // For older servers, emulate HTTP by mimicking the HTTP method with `_method`
    // And an `X-HTTP-Method-Override` header.
    if (Backbone.emulateHTTP) {
      if (type === 'PUT' || type === 'DELETE') {
        if (Backbone.emulateJSON) params.data._method = type;
        params.type = 'POST';
        params.beforeSend = function(xhr) {
          xhr.setRequestHeader('X-HTTP-Method-Override', type);
        };
      }
    }

    // Don't process data on a non-GET request.
    if (params.type !== 'GET' && !Backbone.emulateJSON) {
      params.processData = false;
    }

    // Make the request, allowing the user to override any Ajax options.
    return $.ajax(_.extend(params, options));
  };

  // Wrap an optional error callback with a fallback error event.
  Backbone.wrapError = function(onError, originalModel, options) {
    return function(model, resp) {
      resp = model === originalModel ? resp : model;
      if (onError) {
        onError(originalModel, resp, options);
      } else {
        originalModel.trigger('error', originalModel, resp, options);
      }
    };
  };

  // Helpers
  // -------

  // Shared empty constructor function to aid in prototype-chain creation.
  var ctor = function(){};

  // Helper function to correctly set up the prototype chain, for subclasses.
  // Similar to `goog.inherits`, but uses a hash of prototype properties and
  // class properties to be extended.
  var inherits = function(parent, protoProps, staticProps) {
    var child;

    // The constructor function for the new subclass is either defined by you
    // (the "constructor" property in your `extend` definition), or defaulted
    // by us to simply call the parent's constructor.
    if (protoProps && protoProps.hasOwnProperty('constructor')) {
      child = protoProps.constructor;
    } else {
      child = function(){ parent.apply(this, arguments); };
    }

    // Inherit class (static) properties from parent.
    _.extend(child, parent);

    // Set the prototype chain to inherit from `parent`, without calling
    // `parent`'s constructor function.
    ctor.prototype = parent.prototype;
    child.prototype = new ctor();

    // Add prototype properties (instance properties) to the subclass,
    // if supplied.
    if (protoProps) _.extend(child.prototype, protoProps);

    // Add static properties to the constructor function, if supplied.
    if (staticProps) _.extend(child, staticProps);

    // Correctly set child's `prototype.constructor`.
    child.prototype.constructor = child;

    // Set a convenience property in case the parent's prototype is needed later.
    child.__super__ = parent.prototype;

    return child;
  };

  // Helper function to get a value from a Backbone object as a property
  // or as a function.
  var getValue = function(object, prop) {
    if (!(object && object[prop])) return null;
    return _.isFunction(object[prop]) ? object[prop]() : object[prop];
  };

  // Throw an error when a URL is needed, and none is supplied.
  var urlError = function() {
    throw new Error('A "url" property or function must be specified');
  };

}).call(this);

define("backbone", function(){});

require.config({
    //all js setting
    paths : {
        'json3' : 'lib/js/json3.min',
        'jquery' : 'lib/js/jquery/jquery-1.8.2',
        'jquery-ui' : 'lib/js/jquery/ui/js/jquery-ui-1.8.23.custom.min',
        'jqgrid-i18n' : 'lib/js/jquery/plugin/jquery.jqGrid-4.2.0/js/i18n/grid.locale-cn',
        'jqgrid' : 'lib/js/jquery/plugin/jquery.jqGrid-4.2.0/js/jquery.jqGrid.min',
        'validate-i18n' : 'lib/js/jquery/plugin/formValidator/languages/jquery.validationEngine-zh_CN',
        'validate' : 'lib/js/jquery/plugin/formValidator/jquery.validationEngine',
        'fileupload' : 'lib/js/jquery/plugin/ajaxfileupload/ajaxfileupload',
        'blockui' : 'lib/js/jquery/plugin/blockUI/jquery.blockUI',
        'underscore' : 'lib/js/backbone/underscore',
        'backbone' : 'lib/js/backbone/backbone'
    },
    shim : {
        'blockui' : ['jquery'],
        'jquery-ui' : ['jquery'],
        'jqgrid-i18n' : ['jquery'],
        'jqgrid' : ['jquery-ui', 'jqgrid-i18n'],
        'validate-i18n' : ['jquery'],
        'validate' : ['jquery', 'validate-i18n'],
        'fileupload' : ['jquery'],
        'backbone' : ['underscore', 'jquery']
    }
});

define('libjs', ['json3', 'jquery', 'blockui', 'jquery-ui', 'jqgrid-i18n', 'jqgrid', 'validate-i18n', 'validate', 'fileupload', 'underscore', 'backbone'], function() {
   // $.holdReady(true); // enable at common.js
    logDebug('lib init');
});


/* 專案JS設定檔    */
Properties = {
	window : {
		closeConfirm : false,
		closeWindowMsg : false,
		onunload : function() {

		}
	},

	title : window.document.title,
	ajaxTimeOut : 60 * 1000 * 3, // timeOut: 1000
	// 下拉選單handler
	ComboBoxHandler : 'webroot/codetypehandler/queryByKeys',
	fileUploadSuccessHandler : "webroot/basehandler/fileSuccess",
	Grid : {
		rowNum : 30,
		rowList : []
	}

};

define("common.properties", function(){});

/* 專案JS設定檔    */
$.extend(Properties || {}, {
	window : {
		closeConfirm : true,
		closeWindowMsg : '重新載入後資料將會消失!!\nReload the page data will be lost!!',
		onunload : function() {
		}
	},
	contextName : "/cap-web/",
	ajaxTimeOut : 60 * 1000 * 3, // timeOut: 1000
	// 下拉選單handler
	ComboBoxHandler : '/cap-web/codetypehandler/queryByKeys',
	Grid : {
		rowNum : 30,
		rowList : []
	}
});

define("cust-properties", function(){});

;
$.holdReady(true);
(function(_jQuery, window) {
    _jQuery.browser.msie7 = !!(_jQuery.browser.msie && parseInt(_jQuery.browser.version, 10) < 8);
    _jQuery.ajaxSettings.traditional = true;
    _jQuery.ajaxSetup({
        jsonp : null,
        jsonpCallback : null,
        cache : false,
        dataType : 'json',
        type : "POST",
        data : {
            _isAjax : true
        },
        timeout : Properties.ajaxTimeOut
    });

    _jQuery.datepicker.setDefaults({
        dateFormat : 'yy-mm-dd',
        buttonImageOnly : true,
        showButtonPanel : true,
        changeMonth : true,
        changeYear : true,
        buttonImage : '../static/images/icon_date.png',
        showOn : 'both'
    });

    $.extend(window, {
        router : {
            set : function(settings) {
                if (settings) {
                    Backbone.history && Backbone.history.stop();
                    window._router = new (Backbone.Router.extend(settings));
                    Backbone.history.start();
                }
            },
            to : function(path) {
                if (path && window._router)
                    window._router.navigate(path, {
                        trigger : true
                    });
                else
                    throw "no router";
            }
        },

        url : function(path) {
            return Properties.contextName + path;
        }
    });
    // i18n plugin
    (function($) {
        var s = {
            url : url("i18njs")
        };
        window['i18n'] = {
            keys : [],
            load : function(f, st) {
                return $.ajax($.extend({
                    async : st && st.async || false,
                    cache : false,
                    dataType : 'json',
                    data : {
                        f : f,
                        _ : Math.random()
                    },
                    success : function(res) {
                        i18n.set(f.match("\\w+$")[0], res);
                        // i18n.set(f, res);
                    }
                }, s));
            },
            set : function(key, jsonValue) {
                $.extend(window['i18n'][key] = (function(value) {
                    return function(key, values) {
                        var msg = value[key];
                        msg && values && $.each(values, function(i, v) {
                            msg = msg.replace(new RegExp("\\{" + i + "\\}", "g"), v);
                        });
                        return msg;
                    };
                })(jsonValue), jsonValue);
                i18n.keys.push(key);
            },

            setup : function(settings) {
                s = $.extend(true, s, settings);
            }
        };
        // load default i18n Data
    })(_jQuery);

    //所有動作均等待i18n 完成後再動作
    window.i18n.load("def").done(function() {
        // common js 初始化開始
        (function($) {
            //global function
            $.extend(window, {
                //logger
                logDebug : function() {
                    if (window.console) {
                        console.log(arguments);
                    }
                },

                // windows close confirm
                closeConfirm : Properties.window.closeConfirm,
                closeWindowMsg : Properties.window.closeWindowMsg,
                pageChangeMsg : false,
                setCloseWindowMsg : function(msg) {
                    this.closeWindowMsg = msg;
                },
                setCloseConfirm : function(f) {
                    window.closeConfirm = f;
                },
                getCloseConfirm : function() {
                    return window.closeConfirm;
                },
                onbeforeunload : function() {
                    if (getCloseConfirm())
                        return this.closeWindowMsg;
                },
                // 關閉視窗或重新整理後的動作
                onunload : Properties.window.onunload,
                realclosefunc : window.close,
                close : function() {
                    window.closeConfirm = false;
                    if ($.browser.msie) {
                        var win = window.open("", "_top", "", "true");
                        win.opener = true;
                        win.realclosefunc();
                    }
                    window.realclosefunc();
                },
                setPageChangeMsg : function(message) {
                    window.pageChangeMsg = message;
                },
                getPageChangeMsg : function() {
                    return window.pageChangeMsg;
                },

                //error function
                checkFormErrorAndRequired : function(form) {
                    if (form.find(".data-error,.item-data-error").size()) {
                        return false;
                    }
                    if (!form.valid()) {
                        return false;
                    }
                    return true;
                },
                errorCheck : (function() {
                    var _errorCheck = function(xhr, action) {
                        var json, res = true;
                        try {
                            json = JSON.parse(xhr.responseText);
                        } catch (e) {
                            // logDebug("ajaxError", e);
                            json = {};
                        }
                        // ilog.debug(json);
                        for (var rule in errorCheck.rule) {
                            res && json[rule] && ( res = errorCheck.rule[rule](xhr, action, json));
                        }

                        if (res && xhr.status && xhr.status != '200' || xhr.status == 0) {
                            // ilog.server("http error code: 「" + xhr.status + "」");
                            return false;
                        }
                        return res;
                    };

                    _errorCheck.rule = {
                        AJAX_CLOSE_PAGE_HANDLER_EXCEPTION : function(xhr, action, json) {
                            // ilog.debug(json.AJAX_CLOSE_PAGE_HANDLER_EXCEPTION);
                            // ilog.debug(encodeURIComponent(json.AJAX_CLOSE_PAGE_HANDLER_EXCEPTION));
                            API.showErrorMessage(json.AJAX_CLOSE_PAGE_HANDLER_EXCEPTION, function() {
                                window.location = window.location.href.replace(/#$/, '');
                                window.close();
                            });
                            // API.loadPage("../error/errormsg?errorMsg=" +
                            // encodeURIComponent(encodeURIComponent(json.AJAX_CLOSE_PAGE_HANDLER_EXCEPTION)),
                            // $("#" + Properties.innerPageFrameId));
                            return false;
                        },
                        AJAX_MESSAGE_HANDLER_EXCEPTION : function(xhr, action, json) {
                            // ilog.debug(json.AJAX_MESSAGE_HANDLER_EXCEPTION);
                            // CommonAPI.showPopMessage(json.AJAX_MESSAGE_HANDLER_EXCEPTION, action
                            // || undefined);
                            API.showErrorMessage(json.AJAX_MESSAGE_HANDLER_EXCEPTION);
                            return false;
                        },
                        AJAX_HANDLER_EXCEPTION : function(xhr, action, json) {
                            try {
                                ilog.debug(xhr.status + " : " + xhr.statusText + ", " + json.AJAX_HANDLER_EXCEPTION);
                            } catch (e) {
                            }
                            API.showErrorMessage(xhr.status + " : " + xhr.statusText + ", " + json.AJAX_HANDLER_EXCEPTION);
                            // ilog.server(json.AJAX_HANDLER_EXCEPTION);
                            return false;
                        },
                        AJAX_HANDLER_TIMEOUT : function(xhr, action, json) {
                            // ilog.server(json.AJAX_HANDLER_TIMEOUT);
                            window.setCloseConfirm(false);
                            alert(i18n.def.sessionTimeout);
                            window.location = window.location.href.replace(/#$/, '');
                            return false;
                        },
                        AJAX_SESSION_EXPIRE_EXCEPTION : function(xhr, action, json) {
                            window.setCloseConfirm(false);
                            API.showErrorMessage(json.AJAX_SESSION_EXPIRE_EXCEPTION, function() {
                                window.location = window.location.href.replace(/#$/, '');
                            });
                            return false;
                        }
                    };

                    return _errorCheck;
                })(),

                getErrorMessage : function(xhr) {
                    var json;
                    try {
                        json = JSON.parse(xhr.responseText);
                    } catch (e) {
                        logDebug("ajaxError", e);
                        json = {};
                    }
                    // ilog.debug(json);
                    for (var rule in errorCheck.rule) {
                        if (json[rule]) {
                            return json[rule];
                        }
                    }

                    if (res && xhr.status && xhr.status != '200') {
                        // ilog.server("http error code: 「" + xhr.status + "」");
                        return "connect error";
                    }
                    return "";
                },

                CommonAPI : {
                    /**
                     *判斷是否為 JSON Object
                     */
                    isJSON : function(obj) {
                        return typeof obj == "object" && obj.constructor == Object;
                    },
                    /**
                     * 產生對話框
                     *
                     * @param {Object}
                     *            settings
                     * @param {String}
                     *            action
                     */
                    _showConfirmMessage : function(settings, action) {
                        settings = settings || {};
                        var dialogId = settings.id || "iConfirmDialog";
                        if (action && action === 'close') {
                            $("#" + settings).dialog('close');
                        } else if (settings === 'close') {
                            $('#' + dialogId).dialog('close');
                        } else {
                            var s = $.extend({
                                title : i18n.def.confirmTitle,
                                closeName : i18n.def.cancel,
                                closeBtnAction : null

                            }, settings);
                            var cDialog = $('#' + s.id);
                            cDialog = ((cDialog.size()) ? cDialog : $("<div style='iConfirmDialog' id='" + dialogId + "' title='" + s.title + "'><span id='" + dialogId + "Message' style='max-width:600px;display:block'>" + s.message + "</span></div>").appendTo("body"));
                            var defaultButton = {};
                            defaultButton[s.closeName] = function() {
                                cDialog.dialog('close');
                            };
                            var tmpClose = s.close || $.noop;
                            delete s['close'];
                            cDialog.dialog($.extend({
                                bgiframe : false,
                                autoOpen : false,
                                modal : true,
                                maxWidth : $.browser.msie7 ? 600 : null
                            }, $.extend(s, {
                                close : function() {
                                    tmpClose();
                                    cDialog.dialog('destroy');
                                }
                            }), {
                                buttons : $.extend(s.buttons, s.noClose === true && {} || defaultButton)
                            }));
                            cDialog.dialog('open');
                            $.browser.msie7 && cDialog.dialog('option', 'width', cDialog.find('#' + dialogId + 'Message').width());
                            cDialog.dialog("option", "position", 'center');
                            return cDialog;
                        }
                    },
                    showConfirmMessage : function(title, message, action, cls) {
                        var randomID = "sysCMessage" + parseInt(Math.random() * 1000, 10);
                        action = $.isFunction(message) ? message : action;
                        var closeBtn = {};
                        var dfd = $.Deferred();
                        dfd.done(function() {
                            $("#" + randomID).remove();
                        });
                        action && dfd.done(action);
                        closeBtn[i18n && i18n.def && i18n.def.sure || "Yes"] = function() {
                            dfd.resolve(true);
                        };
                        closeBtn[i18n && i18n.def && i18n.def.cancel || "cancel"] = function() {
                            dfd.resolve(false);
                        };

                        return CommonAPI._showConfirmMessage({
                            dialogClass : cls || 'defDialogCss',
                            id : randomID,
                            closeName : i18n.def.close,
                            title : message && !$.isFunction(message) ? title : i18n.def.confirmTitle,
                            message : message && !$.isFunction(message) ? message : title,
                            // buttons: closeBtn,
                            buttons : closeBtn,
                            noClose : true
                        });

                    },
                    /**
                     * 產生提示對話框
                     *
                     * @param {String}
                     *            title title
                     * @param {Object}
                     *            message message
                     * @param {Object}
                     *            action 關閉對話框後動作
                     */
                    showPopMessage : function(title, message, action, cls) {
                        var randomID = "sysMessage" + parseInt(Math.random() * 1000, 10);
                        // var closeBtn = {};
                        // closeBtn[i18n.def.close] = function(){
                        // CommonAPI.iConfirmDialog(randomID, 'close');
                        // };

                        return CommonAPI._showConfirmMessage({
                            dialogClass : cls || 'defDialogCss',
                            id : randomID,
                            closeName : i18n.def.close,
                            title : message && !$.isFunction(message) ? title : i18n.def.confirmTitle,
                            message : message && !$.isFunction(message) ? message : title,
                            // buttons: closeBtn,
                            close : function() {
                                $("#" + randomID).remove();
                                action && action();
                                $.isFunction(message || "") && message();
                            }
                        });
                    },

                    /**
                     * 產生提示對話框(預設與showPopMessage同 提供給予各專案replace使用)
                     *
                     * @param {String}
                     *            title title
                     * @param {Object}
                     *            message message
                     * @param {Object}
                     *            action 關閉對話框後動作
                     */
                    showMessage : function(title, message, action) {
                        return API.showPopMessage(title, message, action);
                    },

                    /**
                     * 產生提示對話框(預設與showPopMessage同 提供給予各專案replace使用)
                     *
                     * @param {String}
                     *            title title
                     * @param {Object}
                     *            message message
                     * @param {Object}
                     *            action 關閉對話框後動作
                     */
                    showErrorMessage : function(title, message, action) {
                        return API.showPopMessage(title, message, action, "xxxxxxx");
                    },

                    /**
                     * get Today(yyyy-MM-dd)
                     */
                    getToday : function() {
                        var tDate = new Date();
                        return tDate.getFullYear() + "-" + (tDate.getMonth() < 9 ? "0" : "") + (tDate.getMonth() + 1) + "-" + (tDate.getDate() < 10 ? "0" : "") + tDate.getDate();

                    },

                    /**
                     * ajax 動作完成後錯誤訊息顯示方式(預設與showPopMessage同 提供給予各專案replace使用)
                     *
                     * @param {String}
                     *            msg
                     */
                    ajaxErrorMessage : function(msg) {
                        CommonAPI.showPopMessage(msg);
                    },

                    /**
                     * ajax 動作完成後通知訊息顯示方式(預設與showPopMessage同 提供給予各專案replace使用)
                     *
                     * @param {String}
                     *            msg
                     */
                    ajaxNotifyMessage : function(msg) {
                        CommonAPI.showPopMessage(msg);
                    },

                    /**
                     * 清除訊息
                     */
                    clearMessage : function() {

                    },

                    /**
                     * 補滿字串
                     *
                     * @param {string}
                     *            data 轉入資料
                     * @param {integer}
                     *            length 長度
                     * @param {boolean}
                     *            rightAlign 是否補字串後方
                     * @param {char}
                     *            ch 補足字元
                     */
                    fillString : function(data, length, rightAlign, ch) {
                        var inlength = data.length;
                        if (inlength >= length)
                            return data;
                        for (var i = 0; i < (length - inlength); i++) {
                            data = (!!rightAlign ? (data + ch || "0") : ((ch || "0") + data));
                        }
                        return data;
                    },
                    /**
                     *
                     * @param {String}
                     *            id
                     * @param {String}
                     *            action
                     */
                    triggerOpener : function(id, action) {
                        id = id || 'gridview';
                        action = action || 'reloadGrid';
                        try {
                            window.opener.$("#" + id).trigger(action);
                        } catch (e) {
                            // ilog.debug(e);
                        }
                    },
                    /**
                     * 建立i18n or key為變數之 JSON
                     *
                     * @param {Object}
                     *            array
                     */
                    createJSON : function(array) {
                        var json = {};
                        for (var data in array) {
                            json[array[data].key] = array[data].value;
                        }
                        return json;
                    },
                    loadPage : function(href, fn) {
                        $.blockUI.showBG = true;
                        $.startBlockUI && $.startBlockUI();
                        var section = $("article");
                        section.animate({
                            opacity : 0.01
                        }, 500, (function(loadHref) {
                            return function() {
                                section.html("404");
                                section.load(loadHref, function() {
                                    section.animate({
                                        opacity : 1
                                    }, 800);
                                    fn && fn();
                                });
                                $.blockUI.showBG = false;
                            };
                        })(href));
                    },
                    formSubmit : function(settings) {
                        settings = $.extend(true, {
                            data : {},
                            type : 'POST',
                            url : "",
                            target : "_self"
                        }, settings || {});
                        var obj = $('<form />');
                        $('body').append(obj);
                        obj.attr({
                            css : {
                                display : "none"
                            },
                            action : settings.url,
                            target : settings.target,
                            method : settings.type
                        });
                        for (var key in settings.data) {
                            if (settings.data[key]) {
                                if (settings.data[key].constructor == Array) {
                                    for (var key2 in settings.data[key]) {
                                        obj.append('<input type="text" class="hide" name="' + key + '" value=\'' + settings.data[key][key2] + '\' />');
                                    }
                                } else {
                                    obj.append('<input type="text" class="hide" name="' + key + '" value=\'' + settings.data[key] + '\' />');
                                }
                            }
                        }
                        $('body').append(obj);
                        obj.submit();
                        obj.empty().remove();
                    },
                    /**
                     * 於後端取得下拉選單資料
                     *
                     * @param {Array ||
                     *            String} updatekeys reutrn {JSON} comboList
                     */
                    loadCombos : function(updateKeys, comboaction) {
                        if (updateKeys === "")
                            return {};
                        var nkeys = ( typeof updateKeys === 'string') ? [updateKeys] : updateKeys, ukeys = [];
                        for (var key in nkeys) {
                            if (!icombos[nkeys[key]])
                                ukeys.push(nkeys[key]);
                        }
                        (ukeys.length || (comboaction && comboaction.length)) && (function() {
                            $.ajax({
                                type : 'post',
                                async : false,
                                url : Properties.ComboBoxHandler,
                                data : {
                                    keys : ukeys || [],
                                    akeys : comboaction || []
                                },
                                success : function(json) {
                                    $.extend(icombos, json);
                                }
                            });
                        })();

                        return icombos;
                    }
                }
            });

            //add String method
            $.extend(String.prototype, {
                // 計算有幾個全型字、中文字... 或英數字混雜
                countLength : function(type) {
                    var c = this.match(/[^ -~]/g);
                    if (type == 'B') {// big5 +2
                        return this.length + ( c ? c.length : 0);
                    } else {// 預設UTF-8 +3
                        return this.length + ( c ? c.length * 2 : 0);
                    }
                },

                /* 半型字符範圍：33-126;全型字符範圍：65281-65374:對應關係是相差：65248;全型空格：12288;半型空格：32* */
                // 轉全型
                toFull : function() {
                    var result = "";
                    var str = String.trim(this);
                    for (var i = 0; i < str.length; i++) {
                        var tmp;
                        var c = str.charCodeAt(i);
                        tmp = (c <= 126 && c >= 33) && c + 65248 || (c == 32) && 12288 || c;
                        result += String.fromCharCode(tmp);
                    }
                    return result;
                },
                // 轉半型
                toHalf : function() {
                    var result = "";
                    var str = String.trim(this);
                    for (var i = 0; i < str.length; i++) {
                        var tmp;
                        var c = str.charCodeAt(i);
                        tmp = (c <= 65374 && c >= 65281) && c - 65248 || (c == 12288) && 32 || c;
                        result += String.fromCharCode(tmp);
                    }
                    return result;
                }
            });

            //add jQuery static method
            $.extend({
                emptyFunction : function() {
                    return true;
                },
                emptyJSON : {},
                __ajax : $.ajax,
                ajax : function(s) {
                    s = $.extend({
                        handler : "",
                        action : "",
                        formId : "",
                        noHide : false,
                        target : null
                    }, s);

                    if (s.formId) {
                        var form = $("#" + s.formId);
                        // for cbcl start
                        if (!checkFormErrorAndRequired(form)) {
                            return false;
                        } else
                            $.extend(s.data, form.serializeData(s.noHide), s.data);
                    }
                    if (s.url.match("^webroot")) {
                        s.url = s.url.replace("webroot/", Properties.contextName);
                    }
                    // ---------------------------------------------------------------------------------
                    // 移除page 以防server side 無法抓取正確值
                    // if(window.responseJSON) delete responseJSON.page;
                    return $.__ajax($.extend({
                        dataType : "json",
                        cache : false,
                        type : 'post'
                    }, s, {
                        success : function(data, status) {
                            // 如有錯誤通知訊息則顯示於畫面上
                            // ilog.debug(data);
                            if (data.ERROR_NOTIFY_MESSAGE) {
                                API.ajaxErrorMessage(data.ERROR_NOTIFY_MESSAGE);
                            }
                            // 如有通知訊息則顯示於畫面上
                            else if (data.NOTIFY_MESSAGE) {
                                API.ajaxNotifyMessage(data.NOTIFY_MESSAGE);
                            }
                            s.success && s.success(data, status);
                            data.ERROR_NOTIFY_MESSAGE && s.successError && s.successError(data, status);
                        },
                        error : function(xhr, status, e) {
                            s.error && s.error(xhr, status, e);

                            var statusText = "";
                            try {
                                statusText = xhr.statusText;
                            } catch (e) {
                            }
                            if (statusText == 'timeout') {
                                // request timeout
                                API.showErrorMessage(i18n.def.timeout);
                            } else if (!xhr.status && statusText) {
                                API.showErrorMessage(i18n.def.connectError + "-「" + statusText + "」");
                            } else if (xhr.responseText) {
                                errorCheck(xhr);
                            } else if (xhr.status == 0 || xhr.status && xhr.status != '200') {
                                API.showErrorMessage("http error code: 「" + xhr.status + "」");
                            }
                        },
                        data : $.extend({}, window.responseJSON ? responseJSON : {}, {
                            _pa : s.handler || '',
                            formAction : s.action || ''
                        }, s.data)
                    }));
                },

                // 檔案下載動作
                capFileDownload : function(s) {
                    CommonAPI.formSubmit({
                        url : s.url,
                        type : 'post',
                        target : "_blank",
                        encode : true,
                        data : s.data || {}
                    });
                }
            });

            //設定blockUI
            if ($.blockUI) {
                $.blockUI.showBG = true;
                $.extend({
                    startBlockUI : function(event, xhr) {
                        $.blockUI({
                            fadeIn : 0,
                            fadeOut : 0,
                            message : i18n.def.loading + '   <img src="' + url("static/images/ajax-loader.gif") + '" style="width: 16px;hight:11px;"/>',
                            css : {
                                'z-index' : 10010,
                                top : '0',
                                left : '40%',
                                backgroundColor : '#E0ECFF',
                                border : '#000 1px solid',
                                '-webkit-border-radius' : '5px',
                                '-moz-border-radius' : '5px',
                                //opacity: .85,
                                'font-size' : '0.8em',
                                padding : '2px',
                                fontWeight : 'bolder',
                                height : '18px',
                                width : '20%',
                                color : '#000',
                                cursor : 'default'
                            },
                            overlayCSS : {
                                'z-index' : 10010,
                                backgroundColor : '#CCC',
                                opacity : $.blockUI.showBG ? 0.3 : 0,
                                cursor : 'default'
                            }
                        });
                    }
                });
                $(document).bind("ajaxStart", $.startBlockUI);
                $(document).bind("ajaxStop", $.unblockUI);
            }

            // 檔案上傳動作
            if ($.ajaxFileUpload) {
                $.extend({
                    capFileUpload : function(setting) {
                        var s = $.extend({
                            uploadMsg : i18n.def.fileUploading,
                            successMsg : i18n.def.fileUploadSuccess
                        }, setting, {
                            url : setting.url + (/[?]/.test(setting.url) ? "&" : "?") + ("limitSize=" + (setting.limitSize || 3145728)) + (setting.fileEncoding && ("&fileEncoding=" + setting.fileEncoding) || "")
                        });
                        var telm = $("#" + s.fileElementId), val = telm.val();

                        if (!val.length) {
                            CommonAPI.showErrorMessage(i18n.def.fileSelect);
                            return;
                        }
                        // 檢核副檔名
                        if (s.fileCheck) {
                            var regs = "";
                            $(s.fileCheck).each(function(index, value) {
                                regs += (value + "|");
                            });

                            regs = regs.replace(/\|$/, "");
                            if (!((new RegExp("(" + regs + ")$", "i")).test(val))) {
                                CommonAPI.showErrorMessage(i18n.def.fileSelError + "  (" + regs + ")");
                                return;
                            }
                        }
                        var uploadMsg = CommonAPI.showMessage(s.uploadMsg);
                        $.ajaxFileUpload($.extend({}, s, {
                            secureuri : false,
                            complete : function(xhr, status) {
                                uploadMsg.dialog('close');
                                try {
                                    var json = JSON.parse(xhr.responseText);
                                } catch (e) {
                                    logDebug("ajaxError", e);
                                    json = {};
                                }
                                errorCheck(xhr) && (function() {
                                    s.successMsg && CommonAPI.showMessage(s.successMsg);
                                    // 如有通知訊息則顯示於畫面上
                                    json.NOTIFY_MESSAGE && API.showMessage(json.NOTIFY_MESSAGE);
                                    s.success && s.success(json);
                                    json.ERROR_NOTIFY_MESSAGE && s.successError && s.successError(json, status);
                                    return true;
                                })() || s.error && s.error(xhr, status, json);
                                s.complete && s.complete(xhr, status, json);
                                $.post(Properties.fileUploadSuccessHandler);

                            },
                            error : function(data, status, e) {
                                $.isFunction(uploadMsg) && uploadMsg.dialog('close');
                                CommonAPI.showErrorMessage(i18n.def.fileUploadError);
                            },
                            data : $.extend(s.data || {}, {
                                iframe : true // ie error access denied
                            })
                        }));

                    }
                });
            }

            // add jQuery prototype method
            $.fn.extend({
                //增加val 行為
                __val : jQuery.fn.val,
                val : function(value) {
                    var res = (this.data("maskRule") && this.data("realValue")) ? this.data("realValue") : (this.is("span,div") ? this.text() : this.__val());
                    if (value != undefined) {
                        this.data("realValue", value)[(this.is("span,div") ? "text" : "__val")](value);
                        if (this.data("maskRule") && this.data("isChange") !== true) {
                            this.data("isChange", true).trigger("change").data("isChange", false).trigger("mask");
                        };
                        res = this;
                    }
                    return res;
                },
                ____load : $.fn.load,
                load : function(url, params, callback) {
                    if ( typeof url !== "string" && this.___load) {
                        return this.___load.apply(this, arguments);
                    }

                    // Don't do a request if no elements are being requested
                    if (!this.length) {
                        return this;
                    }

                    var selector, type, response, self = this, off = url.indexOf(" ");

                    if (off >= 0) {
                        selector = url.slice(off, url.length);
                        url = url.slice(0, off);
                    }

                    // If it's a function
                    if ($.isFunction(params)) {

                        // We assume that it's the callback
                        callback = params;
                        params = undefined;

                        // Otherwise, build a param string
                    } else if (params && typeof params === "object") {
                        type = "POST";
                    }
                    var self = this;
                    // Request the remote document
                    $.ajax({
                        url : url,

                        // if "type" variable is undefined, then "GET" method will be used
                        type : type,
                        dataType : "html",
                        data : params,
                        context : self,
                        converters : {
                            "text html" : function(s) {
                                var t = s.match(/<title>(?!<>)(.*)<\/title>/);
                                t && t[1] && (document.title = Properties.title + ' - ' + t[1]);
                                return "<script type=\"text/javascript\">$(document).ready(function(){loadPageInit.call($(\"#" + self.attr("id") + "\"), true);})</script>" + s;
                            }
                        },
                        complete : function(jqXHR, status) {
                            if (callback) {
                                self.each(callback, response || [jqXHR.responseText, status, jqXHR]);
                            }
                        }
                    }).done(function(responseText) {

                        // Save response for use in complete callback
                        response = arguments;

                        // See if a selector was specified
                        self.html( selector ? // Create a dummy div to hold the results
                        $("<div>")// inject the contents of the document in, removing the scripts
                        // to avoid any 'Permission Denied' errors in IE
                        .append(responseText.replace(rscript, ""))// Locate the specified elements
                        .find(selector) : // If not, just inject the full result
                        responseText);

                    });

                    return this;
                },

                __dialog : $.fn.dialog,
                dialog : function(arg1, arg2, arg3) {
                    if ( typeof arg1 !== "string") {
                        var $this = this;
                        $this.find('form').each(function() {
                            //$(this).validate();
                            $(this).validationEngine('validate');
                        });
                        var _o = arg1 && arg1.open;
                        arg1 = $.extend({
                            dialogClass : this.attr("id") + "_-dialog",
                            bgiframe : true,
                            autoOpen : false,
                            modal : true,
                            maxWidth : 600,
                            // width: 'auto',
                            minWidth : 350
                            // minWidth: 350
                        }, arg1, {
                            open : function() {
                                _o && _o.apply(this, arguments);
                            }
                        });
                        var ndialog = this.__dialog(arg1, arg2, arg3);
                        var dialogs;
                        ( dialogs = $("." + this.attr("id") + "_-dialog")).each(function(index, element) {
                            ((dialogs.size() - 1) == index) ? ( ndialog = $(element)) : ($(element).empty().remove());
                        });
                        $("div[id='" + this.attr("id") + "'],span[id='" + this.attr("id") + "']").each(function() {
                            $(this).is(".ui-dialog-content") || $(this).empty().remove();
                        });
                        return ndialog.find('.ui-dialog-content');
                    }
                    return this.__dialog(arg1, arg2, arg3);
                },
                /**
                 * form reset
                 */
                reset : function() {
                    $(this).find("input:text,.field").filter(".field").val("").end().end().each(function() {
                        this.reset();
                    });
                    return this;
                },
                /**
                 * 將JSON內值放入 selector
                 * 所選之subitem(input,radio,checkbox,textarea,div,span)
                 *
                 * @param {JSON}
                 *            json
                 */
                injectData : function(rjson) {
                    var json = $.extend({}, rjson);
                    var obj = $(this);
                    $(["input", "select", "textarea", "span[id]", "div[id]"]).each(function(i, v) {
                        var _f = obj.find(v);
                        _f.each(function() {
                            var item = $(this);
                            var jid = item.attr("id");
                            if (json[jid]) {
                                try {
                                    var value = json[jid];
                                    value = (value == null ? "" : value);
                                    switch ((item.attr("type") ||
                                    "").toLowerCase()) {
                                        case "text":
                                        case "hidden":
                                        case "password":
                                            item.val(value).data("realData", value);
                                            break;
                                        case "radio":
                                            obj.find("input[name='" + jid + "']").attr('checked', false).filter("[value='" + json[jid] + "']").trigger('click').attr("checked", true);
                                            break;

                                        case "checkbox":
                                            if ($.isArray(json[jid])) {
                                                var _cbs = obj.find("input[name='" + jid + "']").attr('checked', false);
                                                for (var _i in json[jid]) {
                                                    _cbs.filter("[value='" + json[jid][_i] + "']").attr("checked", true).trigger('click').attr("checked", true);
                                                }
                                            } else {
                                                obj.find("input[name='" + jid + "']").attr('checked', false).filter("[value='" + json[jid] + "']").attr("checked", true).trigger('click').attr("checked", true);
                                            }
                                            break;
                                        default:
                                            var iTagName = item[0].nodeName.toLowerCase();
                                            if (iTagName == 'select') {
                                                if (item.attr('addNew') == 'true' && value) {
                                                    item.setOptions((function() {
                                                        var b = {};
                                                        b[value] = value;
                                                        return b;
                                                    })(), true);
                                                }
                                                if (item.attr('submitbytext') == 'true') {
                                                    item.find("option[showvalue='" + value + "']").attr("selected", true);
                                                } else {
                                                    item.val(value);
                                                }
                                            } else {
                                                if (iTagName.toLowerCase() == "form") {
                                                    item.setData(value);
                                                } else {
                                                    item[(iTagName.match(/(textarea|div|span)/)) ? 'val' : 'html'](value);
                                                }
                                            }
                                    }
                                } catch (e) {
                                    // ilog.debug(e);
                                }
                                delete json[jid];
                            }
                        });
                    });
                    for (var jid in json) {
                        var value = json[jid];
                        // 當整個html上無此欄位時,才自動產生隱藏欄位
                        try {
                            var hItem = $("#" + jid);
                            if (!hItem.size()) {
                                obj.append($("<input type='hidden' id='" + jid + "'" + " name='" + jid + "'" + " value='" + value + "'" + " />"));
                            } else {
                                switch ((hItem.attr("type") || "").toLowerCase()) {
                                    case "text":
                                    case "hidden":
                                    case "password":
                                        hItem.val(value).data("realData", value);
                                        break;
                                    case "radio":
                                    case "checkbox":
                                        break;
                                    default:
                                        var iTagName = hItem[0].nodeName.toLowerCase();
                                        hItem[(iTagName.match(/(textarea|div|span|select)/)) ? 'val' : 'html'](value);
                                }
                            }
                        } catch (e2) {
                            // ilog.debug(e2);
                        }
                    }
                    return obj;
                },

                /**
                 * 將dom內之輸入欄位轉成Json
                 *
                 * @param {boolean}
                 *            noHide 無需Hidden 欄位 預設為 false (全取)
                 */
                serializeData : function(noHide) {
                    var result = {}, self = $(this);
                    $(["input", "select", "textarea", "span.field"]).each(function(i, v) {
                        self.find(v).filter(function() {
                            return !!!noHide || !$(this).is(":hidden");
                        }).each(function() {
                            var $this = $(this);
                            $this.each(function() {
                                switch (this.nodeName.toLowerCase()) {
                                    case 'input':
                                        switch (this.type.toLowerCase()) {
                                            case "text":
                                            case "hidden":
                                            case "password":
                                                seValue(this.name, $this.val());
                                                break;
                                            case "radio":
                                            case "checkbox":
                                                !result[this.name] && (result[this.name] = "");
                                                this.checked && seValue(this.name, $this.val());
                                                break;
                                        }
                                        break;
                                    case 'textarea':
                                        var value = "";
                                        try {
                                            value = $this.val();
                                        } catch (e) {
                                            try {
                                                value = $this.html();
                                            } catch (e1) {
                                                $.log(e1);
                                            }
                                        }
                                        seValue(this.name, value);
                                        break;
                                    case 'select':
                                        var sThis = $(this);
                                        if (sThis.attr("submitByText") == 'true') {
                                            seValue(this.name, (sThis.find("option[value='" + $this.val() + "']").attr("showValue")) || "");
                                        } else {
                                            seValue(this.name, $this.val());
                                        }
                                        break;
                                    case "span":
                                        seValue($this.attr("id"), $.trim($this.val()));
                                }
                            });
                        });
                    });
                    return result;

                    function seValue(name, value) {
                        if (name) {
                            result[name] ? (result[name].constructor == Array ? result[name].push(value) : (function() {
                                var tmp = result[name];
                                result[name] = new Array();
                                result[name].push(tmp);
                                result[name].push(value);
                            })()) : result[name] = value;
                        }

                    }

                },
                /**
                 * 設定 Selector's subitem readonly 狀態
                 * @param {boolean} b 預設為 true (readOnly)
                 * @param {String} jquerySelector
                 */
                readOnlyChilds : function(b, excludeSelector) {
                    b = (b == undefined) ? true : b;
                    $(this).find("input,select,textarea,button").not(excludeSelector || "").each(function() {
                        $(this).readOnly(b);
                    });
                    return $(this);
                },
                /**
                 * 設定欄位Readonly 狀態
                 * @param {boolean} f 預設為 true (readOnly)
                 */
                readOnly : function(b) {
                    b = (b == undefined) ? true : b;
                    var $this = $(this);
                    $this.each(function() {
                        switch (this.nodeName.toLowerCase()) {
                            case 'input':
                                switch (this.type.toLowerCase()) {
                                    case 'text':
                                        ($(this).is('.date') || $(this).is('.date2')) && ( b ? $(this).datepicker('destroy') : $(this).datepicker());
                                        this.readOnly = b;
                                        break;
                                    default:
                                        this.disabled = b;
                                }
                                break;
                            case 'textarea':
                                this.readOnly = b;
                                break;
                            case 'select':
                                this.disabled = b;
                        }
                        this.tabIndex = b ? -1 : "";
                    });
                    return this;
                },
                /**
                 * 動態新增Select 選單
                 *
                 * @param {JSON}
                 *            options
                 * @param {boolean}
                 *            append
                 */
                setOptions : function(options, append) {
                    return !this[0] ? $(this) : this[0].nodeName.toLowerCase() != 'select' ? $(this) : (function(o, a) {
                        var okey = "";
                        if ( typeof o === "string") {
                            okey = o;
                            o = CommonAPI.loadCombos(o)[o];
                        }
                        var to = {}, s = $(this), defalutValue = s.attr("defaultValue") || "", ops = ""/*
                         * (s.attr("space") ==
                         * "true" &&
                         * (!s.find('option').size() ||
                         * !append)) ? "<option
                         * value=''></option>" : ""
                         */, type = s.attr("comboType");
                        if (append) {
                            o = $.extend(s.data('realOptions') || {}, o);
                            options && (
                            delete options[i18n.def.newData]);
                        } else {
                            s.empty();
                        }
                        for (var key in o || {}) {
                            ops += ("<option key='" + key + "' value='" + (type == '3' ? o[key] : key) + "' showValue='" + o[key] + "'>" + (function(k, v, t) {

                                switch (t) {
                                    case '1':
                                        to[k] = k;
                                        return k;
                                    case '2':
                                        to[k] = v;
                                        return v;
                                    case '3':
                                        to[v] = v;
                                        return v;
                                    default:
                                        to[k] = k + ' - ' + v;
                                        return k + ' - ' + v;
                                }
                            })(key, o[key], type) + "</option>");
                        }
                        if (s.attr("addNew") == 'true') {
                            !ops.match("'>" + i18n.def.newData + "</option>") && (ops += ("<option value='" + i18n.def.newData + "'>" + i18n.def.newData + "</option>"));
                            if (!s.data('bindChanged'))
                                s.bind('change', function() {
                                    var value = $(this).val();
                                    if (value == i18n.def.newData) {
                                        CommonAPI.includeID({
                                            needCancel : true,
                                            checkType : s.attr("addCheckType") || "",
                                            title : i18n.def.newData + (s.attr("addTitle") || i18n.def.selectOption),
                                            subtitle : s.attr("addTitle") || i18n.def.selectOption,
                                            buttonName : i18n.def.sure,
                                            buttonAction : function() {
                                                if ($("#searchForm").valid()) {
                                                    var options = s.data("viewOptions") || {};
                                                    options[$("#sseid").val()] = $("#sseid").val();
                                                    delete options[i18n.def.newData];
                                                    options[i18n.def.newData] = i18n.def.newData;
                                                    s.data("viewOptions", options).setOptions(options).val($("#sseid").val());
                                                    CommonAPI.includeID('close');
                                                }
                                            }
                                        });
                                    }
                                }).data('bindChanged', true);
                        }
                        return s.html(ops = ((s.attr("space")!=undefined && s.attr("space")!='false' ? ("<option value=''>" + (s.attr("space") == "true" ? i18n.def.comboSpace : s.attr("space"))  + "</option>") : "") + ops)).val(defalutValue).data('realOptions', o || {}).data('viewOptions', to || {}).attr("list", okey || s.attr("list"));
                    }).call(this, options, append);
                },

                /**
                 * 移除options (多個 or 單一 選項)
                 *
                 * @param {Array ||
                 *            string} options
                 */
                removeOptions : function(options) {
                    return !this[0] ? $(this) : this[0].nodeName.toLowerCase() != 'select' ? $(this) : (function(o) {
                        if ( typeof o === "string") {
                            o = [o];
                        }
                        var $this = $(this);
                        var opts = $this.data('realOptions') || {};
                        $.each(o, function(i, e) {
                            delete opts[e];
                        });
                        $this.setOptions(opts, false);
                    }).call(this, options);
                },
                // ajax queue
                _ajaxQueueContent : [],
                _ajaxQueueStatus : false,
                ajaxQueue : function(s) {
                    if (s.constructor == Array) {
                        (function(tses) {
                            (function ajaxStart(ts) {
                                if (ts) {
                                    $.ajax($.extend({}, ts, {
                                        success : function(data, textStatus, XMLHttpRequest) {
                                            ts.success && ts.success(data, textStatus, XMLHttpRequest);
                                            ajaxStart(tses.shift());
                                        }
                                    }));
                                }
                            })(tses.shift());
                        })(s);
                    } else {
                        $._ajaxQueueContent.push(s);
                        if (!$._ajaxQueueStatus) {
                            (function ajaxStart(ts) {
                                if (ts) {
                                    $._ajaxQueueStatus = true;
                                    $.ajax($.extend({}, ts, {
                                        complete : function(xhr, status) {
                                            ts.complete && ts.complete(xhr, status);
                                            ajaxStart($._ajaxQueueContent.shift());
                                        }
                                    }));
                                } else {
                                    $._ajaxQueueStatus = false;
                                }
                            })($._ajaxQueueContent.shift());
                        }
                    }
                }
            });

            $.extend(window, {
                // 下拉選單暫存變數
                icombos : {},
                // 畫面初始化method
                loadPageInit : function(isSubPage) {
                    var $_this = $(this);
                    $_this.find("[commonitem],input[padding]").filter("[commonitem]").each(function() {
                        var $cthis = $(this), common = Properties.commonItem && Properties.commonItem[$cthis.attr("commonitem")];
                        if (!common)
                            return;
                        else {
                            if (common.valid) {
                                $cthis.bind("blur.comm", common.valid);
                            }
                            for (var attr in common) {
                                switch (attr) {
                                    case "class":
                                        $cthis.attr("class", $cthis.attr("class") + " " + common[attr]);
                                        break;
                                    case "css":
                                        $cthis.css(common[attr]);
                                        break;
                                    case "maxlength":
                                        $cthis.attr(attr) != -1 && $cthis.attr(attr, common[attr]);
                                        break;
                                    case "size":
                                        $cthis.attr(attr, common[attr]);
                                    case "valid":
                                        break;
                                    default:
                                        $cthis.attr(attr, $cthis.attr(attr) || common[attr]);
                                        break;
                                }
                            }
                        }
                        // 放入padding 功能
                    }).end().filter("input[padding]").each(function() {
                        $(this).bind("blur.fill", function() {
                            var $fthis = $(this);
                            if ($fthis.val().length) {
                                $fthis.val(API.fillString($fthis.val(), parseInt($fthis.attr("padding"), 10), $fthis.attr("paddingright") == "true", $fthis.attr("paddinchar") || "0"));
                            }
                        });
                    });

                    if (!isSubPage) {
                        if (/(home)$/i.test(location.pathname)) {
                            // 如為主頁面將window name 設為mainPage
                            window.name = "mainPage";
                        }

                        $(document).bind("ajaxStop", function() {
                            // $.unblockUI();
                        }).bind("ajaxComplete", function(event, xhr, settings) {
                        }).bind("ajaxSuccess", function(event, xhr) {
                        }).bind("ajaxError", function(event, xhr, ajaxOptions, thrownError) {
                        });
                    }
                    $_this.find(".tabs").tabs();
                    // 設定可輸欄位才可選日期
                    $_this.find(".date").filter(function() {
                        return !$(this).attr('readonly');
                    }).datepicker();
                    $_this.find("button").not(".def_btn").addClass("btn1").button();

                    $_this.find("form").each(function() {
                        $(this).validationEngine({
                            validationEventTrigger : 'blur',
                            scroll : false
                        });
                    });
                    var combos, combokeys = [], comboaction = [];
                    ( combos = $_this.find('select[comboKey],select[comboaction]')).each(function() {
                        var key = null;
                        ( key = $(this).attr("comboKey")) && combokeys.push(key);
                        ( key = $(this).attr("comboaction")) && comboaction.push(key);
                    });
                    API.loadCombos(combokeys, comboaction);
                    combos.each(function() {
                        var $cthis = $(this);
                        $cthis.setOptions(icombos[$cthis.attr("comboKey") || $cthis.attr("comboaction")], false);
                    });
                    combos = combokeys = null;
                }
            });
            /** valid */
            $.extend(window, {
                contCodeCheck : function(field, rules, i, options) {
                    field.val((field.val() || "").toUpperCase());
                    if (!/^UCN[0-9]{11}$/.test(field.val())) {
                        return i18n.def['valid.contcCodeNbr'];
                    }
                },
                betweenDate : function(field, rules, i, options) {
                    var st = $("#" + rules[i + 2]), et = $("#" + rules[i + 3]);
                    if (st.val() && et.val()) {
                        if (rules[i + 4] === '0' && !(et.val() >= st.val())) {
                            return i18n.def['valid.dateBetweenEq'];
                        } else if (rules[i + 4] === '1' && !(et.val() > st.val())) {
                            return i18n.def['valid.dateBetween'];
                        }
                    }
                },
                betweenAge : function(field, rules, i, options) {
                    var bd = $("#" + rules[i + 2]), sd = $("#" + rules[i + 3]);
                    if (bd.val() && sd.val()) {
                        if (sd.val() > bd.val()) {
                            return i18n.def['valid.age'];
                        }
                    }
                },
                chlNbr : function(field, rules, i, options) {
                    if (!/^[0-9]{6}$/.test(field.val())) {
                        return i18n.def['valid.chlNbr'];
                    }
                },
                sceneNbr : function(field, rules, i, options) {
                    if (!/^[0-9]{4}$/.test(field.val())) {
                        return i18n.def['valid.sceneNbr'];
                    }
                },
                maxUTF8 : function(field, rules, i, options) {
                    var val = field.val();
                    if (val) {
                        if (val.countLength() > parseInt(rules[i + 2], 10)) {
                            return i18n && i18n.def && i18n.def("valid.maxUTF8", [parseInt(rules[i + 2] / 3, 10), rules[i + 2]]);
                        }
                    }
                }
            });
            // APIS
            window.API = window.CommonAPI;

            // init
            $(document).ready(function() {
                loadPageInit.call(document);
                $("body").on("click", "a", function(e) {
                    if ($(this).attr('href').match("^#")) {
                        e.preventDefault();
                    }
                });
            });
            $.holdReady(false);
        })(_jQuery);
    });
})(jQuery, window);

define("commonjs", function(){});

/**
 * override grid
 */
(function($) {

    $.extend($.fn, {
        /**
         * 取得目前所選取資料行資料
         */
        getSelRowDatas : function() {
            var tGrid = $(this);
            if (tGrid.jqGrid('getGridParam', 'multiselect')) {
                var sels = tGrid.jqGrid('getGridParam', 'selarrrow');
                var res = [];
                for (var i = 0; i < sels.length; i++) {
                    res.push(tGrid.getRowData(sels[i]));
                }
                return res.length ? res : undefined;
            } else {
                var selrow = tGrid.jqGrid('getGridParam', 'selrow');
                return selrow ? tGrid.getRowData(selrow) : undefined;
            }
        },
        /**
         * 將GridData轉換為Array<JSON>值
         * @param {boolean} stringify
         */
        serializeGridData : function(stringify) {
            var data = [];
            if ($(this).attr('role') == 'grid') {
                var tGrid = $(this);
                tGrid.find('tr[id]').each(function() {
                    data.push($.extend(tGrid.getRowData($(this).attr('id')), {
                        rowId : $(this).attr('id')
                    }));
                });
            }
            return stringify ? JSON.stringify(data) : data;
        },
        /**
         * add data to grid by Array[json,json,....] or Array[array,array,....]
         * @param {Object} datas
         */
        addGridData : function(datas) {
            var $this = $(this), ids = $this.jqGrid("getGridParam", "colIds")

            function _convertJson(d) {
                var td = {};
                for (var i in ids) {
                    td[ids[i]] = d[i++];
                }
                return td;
            }

            if ( datas instanceof Array) {
                for (var data in datas) {
                    var _data = (datas[data] instanceof Array) ? _convertJson(datas[data]) : datas[data], rowId = _data[$this[0].colKey];
                    var _new = !$this[0].rows.namedItem(rowId);
                    $this[_new ? "addRowData" : "setRowData"](rowId, _data);
                }
            }
            return this;

        },
        /**
         * 刪除所選 row data
         */
        removeSelected : function() {
            return this.removeGridData(this.jqGrid('getGridParam', 'multiselect') ? this.jqGrid('getGridParam', 'selarrrow') : this.jqGrid('getGridParam', 'selrow'));
        },

        /**
         * 刪除row data by Array[id1,id2] or id
         * @param {Object} array or string - ids
         */
        removeGridData : function(ids) {
            ids = ( typeof ids === 'string' ) ? [ids] : [].concat(ids);
            for (i in ids) {
                this.delRowData(ids[i]);
            }
            return this;
        },
        /**
         * 自動設定寬度
         * @param {integer} maxWidth 寬度
         * @param {boolean} fitColumn 是否自動調整欄寬
         */
        iGridFitSize : function(maxWidth, fitColumn) {
            var self = this.closest(".ui-jqgrid"), $this = $(this);
            if (!$this.is(":visible"))
                return;
            if ( typeof maxWidth == 'boolean') {
                maxWidth = 0;
                // fitColumn = maxWidth;
            }
            //fitColumn = !!fitColumn;
            $this.each(function() {
                if (this.p.autowidth) {
                    maxWidth = maxWidth || self.parent().width();
                    maxWidth = (maxWidth > 960) ? 960 : maxWidth
                } else {
                    maxWidth = maxWidth || this.p.freezeWidth;
                }
                $this.setGridWidth((maxWidth * 98) / 100, fitColumn == undefined ? this.p.forceFit : fitColumn);
                // ? this.p.forceFit : !(self.width() > maxWidth)); //);
            });
        },
        /**
         * Grid hide (extend jQuery hide)
         * @param {integer} speed
         * @param {function} callback
         */
        iGridHide : function(speed, callback) {
            $("#gbox_" + $(this).attr("id")).hide(speed, callback);
            return $(this);
        },
        /**
         * Gird show (extend jQuery show)
         * @param {integer} speed
         * @param {function} callback
         */
        iGridShow : function(speed, callback) {
            $("#gbox_" + $(this).attr("id")).show(speed, callback);
            return $(this);
        }
    });

    //    $.extend($.jgrid.defaults, {
    //        rowNum: 50,
    //        //	scroll: 1,
    //        hidegrid: false,
    //        datatype: "",
    //        height: 100,
    //        rownumbers: true,
    //        mtype: 'POST',
    //        autowidth: true,
    //        forceFit: true
    //    });
    var _jqGrid = $.fn.jqGrid;
    $.fn.jqGrid = function() {
        if (!arguments.length) {
            alert("grid argument error");
            return this;
        }

        if ((this.is("div") || !this.is("[role=grid]")) && typeof arguments[0] === 'object') {
            var url = arguments[0].url;
            //default settings
            var needPager = !(arguments[0].pager === false);
            var s = $.extend({}, {
                ajaxGridOptions : {// ajax option
                    global : false
                },
                forceFit : true,
                url : '',
                mtype : 'POST',
                rowNum : (needPager == false) ? 1000 : Properties.Grid.rowNum,
                rowList : Properties.Grid.rowList,
                multiselect : false,
                viewrecords : true,
                pgbuttons : needPager,
                pginput : needPager,
                loadonce : false,
                autowidth : true,
                localFirst : false,
                gridview : true
            }, arguments[0]);
            //  console.debug(s);
            var id = this.attr("id");
            this.append($("<table />", {
                id : id
            })).addClass("r-grid").removeAttr("id");
            // add pager
            // arguments[0].pager &&
            this.append($("<div />", {
                id : id + "-pager"
            }));
            $.extend(s, {
                pager : id + "-pager",
                hidegrid : false,
                datatype : (!s.localFirst && url) ? 'json' : 'local',
                url : (!s.localFirst && url) ? url : ''
            });

            //add header
            var _colNames = s.colNames || [];
            s.colNames = [];
            s.colIds = []
            for (var col in s.colModel) {
                s.colNames.push(_colNames[col] || s.colModel[col].header || s.colModel[col].name);
                s.colIds.push(s.colModel[col].name);
            }
            // add columns info
            s = $.extend({}, s, {
                postData : $.extend(s.postData || {}, {
                    _columnParam : JSON.stringify(s.colModel, null),
                    groupCloumn : JSON.stringify(s.groupingView && s.groupingView.groupField || [], null),
                    mtype : "post"
                })
            });
            //            console.debug(s)
            var resGrid = _jqGrid.call(this.is("table") ? this : this.find("table"), s);
            resGrid.navGrid("#" + id + "-pager", {
                del : false,
                add : false,
                edit : false,
                search : false
            });

            s.localFirst && resGrid.setGridParam({
                datatype : url ? 'json' : 'local',
                url : url
            });

            //set cust properties
            resGrid.each(function() {
                this.p.colIds = s.colIds;
            });

            return resGrid;
        }
        //
        return _jqGrid.apply(this.is("table") ? $(this) : $(this.find("table")), arguments);
    };
    $.extend($.fn.jqGrid, _jqGrid);
    
    
    
    //add jqGrid foramter
    $.extend($.fn.fmatter, {
        click : (function() {
            var _click = function(cellvalue, options, rowdata) {
                return "<a href=\"#\" role=\"gridcellclick\" cellvalue=\"" + cellvalue + "\" idname=\"" + options.colModel.name + "\" rowid=\"" + options.rowId + "\">" + cellvalue + "</a>";
            };

            _click.unformat = function(cellvalue, options) {
                return cellvalue;
            };
            return _click;
        })(),

        fileDownload : (function() {
            var _download = function(cellvalue, options, rowdata) {
                return "<a href=\"#\" role=\"gridcelldownload\" cellvalue=\"" + cellvalue + "\" idname=\"" + options.colModel.name + "\" rowid=\"" + options.rowId + "\">" + (i18n && i18n.def.download || "下載") + "</a>";
            };

            _download.unformat = function(cellvalue, options) {
                return cellvalue;
            };
            return _download;
        })()
    });
})(jQuery);

define("common.jqgrid", function(){});

require.config({
    paths : {
        'common.properties' : 'lib/js/common/common.properties',
        'common.jqgrid' : 'lib/js/common/common.jqgrid',
        'commonjs' : 'lib/js/common/common'
    },
    shim : {
        'commonjs' : ['libjs'], //, 'common.properties'],
        'common.jqgrid' : ['commonjs']
    }
});

define('capjs', ['libjs', 'commonjs', 'common.jqgrid'], function(capjs) {
    logDebug("cap js init");
});

// init
// var menu = {
    // "menu" : [{
// 
        // "name" : "系統設定",
        // "url" : "system",
        // "child" : [{
            // "name" : "代碼設定",
            // "url" : "codetype"
        // },{
            // "name" : "參數設定",
            // "url" : "sysparm"
        // },{
            // "name" : "流水號檢視",
            // "url" : "sequence"
        // }]
    // }, {
// 
        // "name" : "系统功能",
        // "url" : "sample",
        // "child" : [{
            // "name" : "檔案上下傳",
            // "url" : "fileUpdDwn"
        // }]
    // },{
        // "name" : "排程管理",
        // "url" : "batch",
        // "child" : [{
            // "name" : "排程設定",
            // "url" : "schedule"
        // }, {
            // "name" : "排程Job清單",
            // "url" : "jobs"
        // }, {
            // "name" : "排程監控",
            // "url" : "jobexecution"
        // }]
// 
    // }]
// }

// init
$(document).ready(function() {
    logDebug("cust common ready init");
    var navTop = $("nav.top"), navSub = $("nav.sub ol");
    $.get("webroot/samplehandler/queryMenu").done(function(res) {
        var _menu = res.menu, ul = $("nav.top ul.navmenu");
        $("#userName").val(res.userName);
        navTop.on("click", "li a", function(ev) {
            ev.preventDefault();
            router.to($(this).attr("url"));
        });

        navSub.on("click", "li a", function(ev) {
            router.to($(this).attr("url"));
            ev.preventDefault();
            return false;
        });

        // render menu
        for (var m in _menu) {
            ul.append($("<li/>").append($("<a/>", {
                href : "#",
                url : _menu[m].url,
                data : {
                    smenu : _menu[m].child,
                    url : _menu[m].url
                },
                text : _menu[m].name
            })));
        }

        router.set({
            routes : {
                "" : "loadfirst", //default route
                ":page" : "loadsub", // http://xxxxx/xxx/#page
                ":page/:page2" : "loadpage" // http://xxxxx/xxx/#page
            },
            loadfirst : function() {
                ul.find("li a:first").click();
            },
            loadsub : function(folder) {
            
                var tlink = navTop.find("a").removeClass("select").filter("a[url=" + folder + "]").addClass("select");
                var smenu = tlink.data("smenu");
                if (navSub.find('a').size()) {
                    navSub.animate({
                        opacity : 0.01
                    }, 200, _f);
                } else {
                    navSub.css("opacity", "0.01");
                    _f();
                }

                function _f() {
                    navSub.empty().data("cmenu", folder);
                    for (var sm in smenu) {
                        navSub.append($("<li/>").append($("<a/>", {
                            url : tlink.data("url") + "/" + smenu[sm].url || "",
                            data : {
                                url : tlink.data("url") + "/" + smenu[sm].url || ""

                            },
                            text : smenu[sm].name
                        })));
                    }
                    navSub.animate({
                        opacity : 1
                    });
                }

            },
            //router method
            loadpage : function(folder, page) {
                if (!(navSub.data("cmenu") == folder)) {
                    this.loadsub(folder);
                }
                navSub.find('.selected').removeClass('selected').end().find("a[url='" + folder + '/' + page + "']").addClass("selected");
                API.loadPage(folder + '/' + page);
            }
        });
    });
    
    $("a[href='#language']").click(function() {
        var o = $(this).parents("ol");
        if (o.height() == 18) {
            $(this).parent("li.lang").css('background-image', 'url(webroot/static/images/icon-down.png)');
            $(o).animate({
                height : 100
            });
        } else {
            $(this).parent("li.lang").css('background-image', 'url(webroot/static/images/icon-right.png)');
            $(o).animate({
                height : 18
            });
        }
        return false;
    });
});


define("cust-common", function(){});


var logDebug = function() {
	if (window.console) {
		console.log(arguments);
	}

};
require.config({
	urlArgs : 'cache=' + parseInt(Math.random() * 1000),
	baseUrl : '../static',
	paths : {
		'libjs' : 'lib/js/libjs',          //third party lib
		'capjs' : 'lib/js/capjs',          //cap lib
		'common.properties' : 'lib/js/common/common.properties', 
		'cust-properties' : 'js/common/cust.properties', // 客制化設定檔
		'cust-common' : 'js/common/cust.common'　 // 客制化 CommonJS檔
	},
	shim : {
		'cust-properties' : ['libjs', 'common.properties' ],
		'capjs' : ['libjs', 'cust-properties'],
		'cust-common' : ['libjs', 'common.properties','capjs' ] //客制化lib 載入設定
	}
});

require(['libjs', 'common.properties', 'cust-properties','capjs', 'cust-common'], function() {
	logDebug("cust js init");
});

//global method
window.loadScript = function(url) {
	require(['cust-common'], function() {
		require([url], function(pageJs) {
			logDebug(url + ' loaded!');
			pageJs && pageJs.init();
		})
	});
};
window.pageInit = function(settings) {
	if (settings) {
		define.call(window,['cust-common'], function() {
			return settings instanceof Function ? {
				init : settings
			} : settings;
		});
	}
}
;
define("main", function(){});
