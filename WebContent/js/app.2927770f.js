(function(t){function e(e){for(var r,l,u=e[0],s=e[1],i=e[2],f=0,p=[];f<u.length;f++)l=u[f],Object.prototype.hasOwnProperty.call(o,l)&&o[l]&&p.push(o[l][0]),o[l]=0;for(r in s)Object.prototype.hasOwnProperty.call(s,r)&&(t[r]=s[r]);c&&c(e);while(p.length)p.shift()();return a.push.apply(a,i||[]),n()}function n(){for(var t,e=0;e<a.length;e++){for(var n=a[e],r=!0,u=1;u<n.length;u++){var s=n[u];0!==o[s]&&(r=!1)}r&&(a.splice(e--,1),t=l(l.s=n[0]))}return t}var r={},o={app:0},a=[];function l(e){if(r[e])return r[e].exports;var n=r[e]={i:e,l:!1,exports:{}};return t[e].call(n.exports,n,n.exports,l),n.l=!0,n.exports}l.m=t,l.c=r,l.d=function(t,e,n){l.o(t,e)||Object.defineProperty(t,e,{enumerable:!0,get:n})},l.r=function(t){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(t,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(t,"__esModule",{value:!0})},l.t=function(t,e){if(1&e&&(t=l(t)),8&e)return t;if(4&e&&"object"===typeof t&&t&&t.__esModule)return t;var n=Object.create(null);if(l.r(n),Object.defineProperty(n,"default",{enumerable:!0,value:t}),2&e&&"string"!=typeof t)for(var r in t)l.d(n,r,function(e){return t[e]}.bind(null,r));return n},l.n=function(t){var e=t&&t.__esModule?function(){return t["default"]}:function(){return t};return l.d(e,"a",e),e},l.o=function(t,e){return Object.prototype.hasOwnProperty.call(t,e)},l.p="/SF-15-2018-OWP/";var u=window["webpackJsonp"]=window["webpackJsonp"]||[],s=u.push.bind(u);u.push=e,u=u.slice();for(var i=0;i<u.length;i++)e(u[i]);var c=s;a.push([0,"chunk-vendors"]),n()})({0:function(t,e,n){t.exports=n("56d7")},"034f":function(t,e,n){"use strict";var r=n("85ec"),o=n.n(r);o.a},"56d7":function(t,e,n){"use strict";n.r(e);n("e260"),n("e6cf"),n("cca6"),n("a79d");var r=n("2b0e"),o=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{attrs:{id:"app"}},[n("div",{attrs:{id:"nav"}},[n("HelloWorld")],1),n("router-view")],1)},a=[],l=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",[n("b-navbar",{attrs:{toggleable:"lg",type:"dark",variant:"info"}},[n("b-navbar-brand",{attrs:{href:"#"}},[t._v("Vueplex bioskop web")]),n("b-navbar-toggle",{attrs:{target:"nav-collapse"}}),n("b-collapse",{attrs:{id:"nav-collapse","is-nav":""}},[n("b-navbar-nav",[n("b-nav-item",{attrs:{to:"/filmovi"}},[t._v(" Filmovi")]),n("b-nav-item",{attrs:{to:"#"}},[t._v(" Projekcije")])],1),n("b-navbar-nav",{staticClass:"ml-auto"},[n("button",{staticClass:"btn btn-success",attrs:{type:"button"}},[t._v("Login")]),n("br"),n("br"),n("button",{staticClass:"btn btn-danger",attrs:{type:"button"}},[t._v("Register")]),n("b-nav-item-dropdown",{staticClass:"user",attrs:{right:""},scopedSlots:t._u([{key:"button-content",fn:function(){return[n("em",[t._v("User")])]},proxy:!0}])},[n("b-dropdown-item",{attrs:{href:"#"}},[t._v("Profile")]),n("b-dropdown-item",{attrs:{href:"#"}},[t._v("Sign Out")])],1)],1)],1)],1)],1)},u=[],s={name:"HelloWorld",props:{msg:String}},i=s,c=(n("a96c"),n("2877")),f=Object(c["a"])(i,l,u,!1,null,"b0fcde46",null),p=f.exports,v={components:{HelloWorld:p}},b=v,d=(n("034f"),Object(c["a"])(b,o,a,!1,null,null,null)),m=d.exports,h=n("8c4f"),_=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"home"},[n("HelloWorld",{attrs:{msg:"Welcome to Your Vue.js App"}})],1)},g=[],y={name:"home",components:{HelloWorld:p}},w=y,O=Object(c["a"])(w,_,g,!1,null,null,null),j=O.exports,x=function(){var t=this,e=t.$createElement;t._self._c;return t._m(0)},P=[function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",[n("p",[t._v(" sss ")])])}],S={name:"Filmovi"},k=S,W=Object(c["a"])(k,x,P,!1,null,null,null),$=W.exports,C=n("5f5b"),E=n("b1e0");n("f9e3"),n("2dd8");r["default"].use(C["a"]),r["default"].use(E["a"]),r["default"].use(h["a"]);var H=[{path:"/",name:"home",component:j},{path:"/filmovi",name:"Filmovi",component:$}],F=new h["a"]({routes:H}),M=F;r["default"].config.productionTip=!1,new r["default"]({router:M,render:function(t){return t(m)}}).$mount("#app")},"85ec":function(t,e,n){},a96c:function(t,e,n){"use strict";var r=n("f7b1"),o=n.n(r);o.a},f7b1:function(t,e,n){}});
//# sourceMappingURL=app.2927770f.js.map