(function(t){function e(e){for(var r,u,i=e[0],l=e[1],s=e[2],f=0,p=[];f<i.length;f++)u=i[f],Object.prototype.hasOwnProperty.call(a,u)&&a[u]&&p.push(a[u][0]),a[u]=0;for(r in l)Object.prototype.hasOwnProperty.call(l,r)&&(t[r]=l[r]);c&&c(e);while(p.length)p.shift()();return o.push.apply(o,s||[]),n()}function n(){for(var t,e=0;e<o.length;e++){for(var n=o[e],r=!0,i=1;i<n.length;i++){var l=n[i];0!==a[l]&&(r=!1)}r&&(o.splice(e--,1),t=u(u.s=n[0]))}return t}var r={},a={app:0},o=[];function u(e){if(r[e])return r[e].exports;var n=r[e]={i:e,l:!1,exports:{}};return t[e].call(n.exports,n,n.exports,u),n.l=!0,n.exports}u.m=t,u.c=r,u.d=function(t,e,n){u.o(t,e)||Object.defineProperty(t,e,{enumerable:!0,get:n})},u.r=function(t){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(t,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(t,"__esModule",{value:!0})},u.t=function(t,e){if(1&e&&(t=u(t)),8&e)return t;if(4&e&&"object"===typeof t&&t&&t.__esModule)return t;var n=Object.create(null);if(u.r(n),Object.defineProperty(n,"default",{enumerable:!0,value:t}),2&e&&"string"!=typeof t)for(var r in t)u.d(n,r,function(e){return t[e]}.bind(null,r));return n},u.n=function(t){var e=t&&t.__esModule?function(){return t["default"]}:function(){return t};return u.d(e,"a",e),e},u.o=function(t,e){return Object.prototype.hasOwnProperty.call(t,e)},u.p="/SF-15-2018-OWP/";var i=window["webpackJsonp"]=window["webpackJsonp"]||[],l=i.push.bind(i);i.push=e,i=i.slice();for(var s=0;s<i.length;s++)e(i[s]);var c=l;o.push([0,"chunk-vendors"]),n()})({0:function(t,e,n){t.exports=n("56d7")},"034f":function(t,e,n){"use strict";var r=n("85ec"),a=n.n(r);a.a},1723:function(t,e,n){"use strict";var r=n("2f64"),a=n.n(r);a.a},"2f64":function(t,e,n){},"56d7":function(t,e,n){"use strict";n.r(e);n("e260"),n("e6cf"),n("cca6"),n("a79d");var r=n("2b0e"),a=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{attrs:{id:"app"}},[n("div",{attrs:{id:"nav"}},[n("NavBar")],1),n("router-view")],1)},o=[],u=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",[n("b-navbar",{attrs:{toggleable:"lg",type:"dark",variant:"info"}},[n("b-navbar-brand",{attrs:{id:"navTitle",href:"#"}},[t._v("Vueplex bioskop web")]),n("b-navbar-toggle",{attrs:{target:"nav-collapse"}}),n("b-collapse",{attrs:{id:"nav-collapse","is-nav":""}},[n("b-navbar-nav",[n("b-nav-item",{attrs:{to:"/filmovi"}},[t._v(" Filmovi")]),n("b-nav-item",{attrs:{to:"#"}},[t._v(" Projekcije")])],1),n("b-navbar-nav",{staticClass:"ml-auto"},[n("button",{staticClass:"btn btn-success",attrs:{type:"button"}},[t._v("Login")]),n("br"),n("br"),n("button",{staticClass:"btn btn-danger",attrs:{type:"button"}},[t._v("Register")]),n("b-nav-item-dropdown",{staticClass:"user",attrs:{right:""},scopedSlots:t._u([{key:"button-content",fn:function(){return[n("em",[t._v("User")])]},proxy:!0}])},[n("b-dropdown-item",{attrs:{href:"#"}},[t._v("Profile")]),n("b-dropdown-item",{attrs:{href:"#"}},[t._v("Sign Out")])],1)],1)],1)],1)],1)},i=[],l={name:"NavBar"},s=l,c=(n("1723"),n("2877")),f=Object(c["a"])(s,u,i,!1,null,"dd20827a",null),p=f.exports,v={components:{NavBar:p}},b=v,d=(n("034f"),Object(c["a"])(b,a,o,!1,null,null,null)),m=d.exports,h=n("8c4f"),_=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"home"},[t._v(" ssss ")])},g=[],y={name:"home"},w=y,O=Object(c["a"])(w,_,g,!1,null,null,null),j=O.exports,x=function(){var t=this,e=t.$createElement;t._self._c;return t._m(0)},P=[function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",[n("p",[t._v(" sss ")])])}],S={name:"Filmovi"},k=S,$=Object(c["a"])(k,x,P,!1,null,null,null),C=$.exports,E=n("5f5b"),F=n("b1e0");n("f9e3"),n("2dd8");r["default"].use(E["a"]),r["default"].use(F["a"]),r["default"].use(h["a"]);var M=[{path:"/",name:"home",component:j},{path:"/filmovi",name:"Filmovi",component:C}],T=new h["a"]({routes:M}),B=T;r["default"].config.productionTip=!1,new r["default"]({router:B,render:function(t){return t(m)}}).$mount("#app")},"85ec":function(t,e,n){}});
//# sourceMappingURL=app.fa66ce8b.js.map