(function(t){function e(e){for(var r,i,s=e[0],l=e[1],c=e[2],d=0,f=[];d<s.length;d++)i=s[d],Object.prototype.hasOwnProperty.call(n,i)&&n[i]&&f.push(n[i][0]),n[i]=0;for(r in l)Object.prototype.hasOwnProperty.call(l,r)&&(t[r]=l[r]);u&&u(e);while(f.length)f.shift()();return o.push.apply(o,c||[]),a()}function a(){for(var t,e=0;e<o.length;e++){for(var a=o[e],r=!0,s=1;s<a.length;s++){var l=a[s];0!==n[l]&&(r=!1)}r&&(o.splice(e--,1),t=i(i.s=a[0]))}return t}var r={},n={app:0},o=[];function i(e){if(r[e])return r[e].exports;var a=r[e]={i:e,l:!1,exports:{}};return t[e].call(a.exports,a,a.exports,i),a.l=!0,a.exports}i.m=t,i.c=r,i.d=function(t,e,a){i.o(t,e)||Object.defineProperty(t,e,{enumerable:!0,get:a})},i.r=function(t){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(t,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(t,"__esModule",{value:!0})},i.t=function(t,e){if(1&e&&(t=i(t)),8&e)return t;if(4&e&&"object"===typeof t&&t&&t.__esModule)return t;var a=Object.create(null);if(i.r(a),Object.defineProperty(a,"default",{enumerable:!0,value:t}),2&e&&"string"!=typeof t)for(var r in t)i.d(a,r,function(e){return t[e]}.bind(null,r));return a},i.n=function(t){var e=t&&t.__esModule?function(){return t["default"]}:function(){return t};return i.d(e,"a",e),e},i.o=function(t,e){return Object.prototype.hasOwnProperty.call(t,e)},i.p="/SF-15-2018-OWP/";var s=window["webpackJsonp"]=window["webpackJsonp"]||[],l=s.push.bind(s);s.push=e,s=s.slice();for(var c=0;c<s.length;c++)e(s[c]);var u=l;o.push([0,"chunk-vendors"]),a()})({0:function(t,e,a){t.exports=a("56d7")},"034f":function(t,e,a){"use strict";var r=a("85ec"),n=a.n(r);n.a},3937:function(t,e,a){},"48d5":function(t,e,a){},"56d7":function(t,e,a){"use strict";a.r(e);a("e260"),a("e6cf"),a("cca6"),a("a79d");var r=a("2b0e"),n=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{attrs:{id:"app"}},[a("div",{attrs:{id:"nav"}},[a("NavBar",{attrs:{c:t.seen}})],1),a("router-view")],1)},o=[],i=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{attrs:{id:"ss"}},[a("b-navbar",{attrs:{toggleable:"lg",type:"dark",variant:"info"}},[a("b-navbar-brand",{attrs:{id:"navTitle",to:"/"}},[t._v("Vueplex bioskop web")]),a("b-navbar-toggle",{attrs:{target:"nav-collapse"}}),a("b-collapse",{attrs:{id:"nav-collapse","is-nav":""}},[a("b-navbar-nav",[a("b-nav-item",{attrs:{to:"/filmovi"}},[t._v(" Filmovi")]),a("b-nav-item",{attrs:{to:"/users"}},[t._v(" Users")]),a("b-button",{directives:[{name:"show",rawName:"v-show",value:t.c,expression:"c"}],attrs:{to:"/addUser"}},[t._v("Add User")])],1),a("b-navbar-nav",{staticClass:"ml-auto"},[a("button",{staticClass:"btn btn-success",attrs:{type:"button"}},[t._v("Login")]),a("br"),a("br"),a("button",{staticClass:"btn btn-danger",attrs:{type:"button"}},[t._v("Register")]),a("b-nav-item-dropdown",{staticClass:"user",attrs:{right:""},scopedSlots:t._u([{key:"button-content",fn:function(){return[a("em",[t._v("User")])]},proxy:!0}])},[a("b-dropdown-item",{attrs:{href:"#"}},[t._v("Profile")]),a("b-dropdown-item",{attrs:{href:"#"}},[t._v("Sign Out")])],1)],1)],1)],1)],1)},s=[],l={props:{c:{type:Boolean,required:!0}},name:"NavBar",data:function(){return{}},mounted:function(){}},c=l,u=(a("b805"),a("2877")),d=Object(u["a"])(c,i,s,!1,null,"3e65575a",null),f=d.exports,p={components:{NavBar:f},data:function(){return{seen:!1}}},m=p,v=(a("034f"),Object(u["a"])(m,n,o,!1,null,null,null)),b=v.exports,h=a("8c4f"),y=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"home"},[t._v(" ssss ")])},g=[],_={name:"home"},k=_,j=Object(u["a"])(k,y,g,!1,null,null,null),x=j.exports,S=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("div",{staticClass:"container",attrs:{id:"s"}},[a("div",{staticClass:"row"},[a("div",{staticClass:"col-md-4 mx-auto"},[t._v(" Pretraga po Nazivu "),a("b-form-input",{attrs:{type:"search",id:"poNazivu",placeholder:"Type to Search by Username"},on:{input:t.filterMovie},model:{value:t.a,callback:function(e){t.a=e},expression:"a"}})],1),a("div",{staticClass:"col-md-4 mx-auto"},[t._v(" Pretraga po Trajanju "),a("b-form-input",{attrs:{type:"search",id:"filterInput",placeholder:"Type to Search by password"},on:{input:t.filterMovie},model:{value:t.b,callback:function(e){t.b=e},expression:"b"}})],1),a("div",{staticClass:"col-md-4 mx-auto"},[t._v(" Pretraga po Zemlji Porekla "),a("b-form-input",{attrs:{type:"search",id:"filterInput",placeholder:"Type to Search by Datum Registracije"},on:{input:t.filterMovie},model:{value:t.c,callback:function(e){t.c=e},expression:"c"}})],1),a("div",{staticClass:"col-md-4 mx-auto"},[t._v(" Pretraga po Zanru "),a("b-form-input",{attrs:{type:"search",id:"filterInput",placeholder:"Type to Search"},on:{input:t.filterMovie},model:{value:t.d,callback:function(e){t.d=e},expression:"d"}})],1),a("div",{staticClass:"col-md-4 mx-auto"},[t._v(" Pretraga po Distributeru "),a("b-form-input",{attrs:{type:"search",id:"filterInput",placeholder:"Type to Search"},on:{input:t.filterMovie},model:{value:t.e,callback:function(e){t.e=e},expression:"e"}})],1),a("div",{staticClass:"col-md-4 mx-auto"},[t._v(" Pretraga po Godini proizvodnje "),a("b-form-input",{attrs:{type:"search",id:"filterInput",placeholder:"Type to Search"},on:{input:t.filterMovie},model:{value:t.f,callback:function(e){t.f=e},expression:"f"}})],1)])]),a("b-table",{attrs:{fields:t.fields,items:t.items},scopedSlots:t._u([{key:"cell(naziv)",fn:function(e){return[a("router-link",{attrs:{to:"/film/"+e.item.id}},[t._v(t._s(e.value))])]}}])})],1)},w=[],P=(a("99af"),a("bc3a")),O=a.n(P),C={name:"Filmovi",data:function(){return{a:"",b:"",c:"",d:"",e:"",f:"",fields:[{key:"naziv",sortable:!0},{key:"zanrovi",sortable:!0},{key:"trajanje",sortable:!0},{key:"distributer",sortable:!0},{label:"Zemlja Porekla",key:"zemljaPorekla",sortable:!0},{label:"Godina Proizvodnje",key:"godina",sortable:!0}],items:[]}},methods:{filterMovie:function(){var t=this;console.log("sss"+this.a),""===this.b&&(this.b=0),""===this.f&&(this.f=0),O.a.get("http://172.16.170.175:8081/SF-15-2018-OWP/FilmoviServlet?nazivFilma=".concat(this.a,"&trajanje=").concat(this.b,"&zemljaPorekla=").concat(this.c,"&zanr=").concat(this.d,"&distributer=").concat(this.e,"&godina=").concat(this.f)).then((function(e){t.items=e.data,0===t.b&&(t.b=""),0===t.f&&(t.f="")})).catch((function(t){return console.log(t)}))}},mounted:function(){var t=this;O.a.get("http://172.16.170.175:8081/SF-15-2018-OWP/FilmoviServlet").then((function(e){return t.items=e.data})).catch((function(t){return console.log(t)}))}},z=C,F=(a("fca7"),Object(u["a"])(z,S,w,!1,null,"098f1b81",null)),T=F.exports,U=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("b-table",{attrs:{striped:"",hover:"",items:t.items,fields:t.fields}})],1)},M=[],I={name:"Film",props:["id"],data:function(){return{fields:[{key:"naziv",sortable:!1,formatter:"filmId"},{key:"zanrovi",sortable:!1},{key:"trajanje",sortable:!1},{key:"distributer",sortable:!1},{label:"Zemlja Porekla",key:"zemljaPorekla",sortable:!1},{label:"Godina Proizvodnje",key:"godina",sortable:!1}],items:[],methods:{filmId:function(t){return"".concat(t.naziv," ")}}}},mounted:function(){var t=this;O.a.get("http://172.16.170.175:8081/SF-15-2018-OWP/FilmServlet?id=".concat(this.id)).then((function(e){return t.items.push(e.data)})).catch((function(t){return console.log(t)}))}},$=I,E=Object(u["a"])($,U,M,!1,null,null,null),D=E.exports,N=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("div",{staticClass:"container",attrs:{id:"s"}},[a("div",{staticClass:"row"},[a("div",{staticClass:"col-md-3 mx-auto"},[a("b-form-input",{attrs:{type:"search",id:"filterInput",placeholder:"Type to Search by Username"}})],1),a("div",{staticClass:"col-md-3 mx-auto"},[a("b-form-input",{attrs:{type:"search",id:"filterInput",placeholder:"Type to Search by password"}})],1),a("div",{staticClass:"col-md-3 mx-auto"},[a("b-form-input",{attrs:{type:"search",id:"filterInput",placeholder:"Type to Search by Datum Registracije"}})],1),a("div",{staticClass:"col-md-3 mx-auto"})])]),a("b-table",{attrs:{fields:t.fields,items:t.items},scopedSlots:t._u([{key:"cell(username)",fn:function(e){return[a("router-link",{attrs:{to:"/user/"+e.item.username}},[t._v(t._s(e.value))])]}}])})],1)},W=[],R={name:"Users",data:function(){return{fields:[{key:"username",sortable:!0},{key:"password",sortable:!0},{key:"datumRegistracije",sortable:!0,formatter:function(t){return new Date(t).toLocaleDateString()}},{key:"uloga",sortable:!0}],items:[]}},mounted:function(){var t=this;O.a.get("http://172.16.170.175:8081/SF-15-2018-OWP/KorisniciServlet").then((function(e){return t.items=e.data})).catch((function(t){return console.log(t)}))}},B=R,Z=(a("5e7b"),Object(u["a"])(B,N,W,!1,null,"57edec18",null)),A=Z.exports,G=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("b-table",{attrs:{striped:"",hover:"",items:t.items,fields:t.fields}})],1)},L=[],J={name:"User",props:["username"],data:function(){return{fields:[{key:"username",sortable:!1},{key:"password",sortable:!1},{key:"datumRegistracije",sortable:!1,formatter:function(t){return new Date(t).toLocaleDateString()}},{key:"uloga",sortable:!1}],items:[]}},mounted:function(){var t=this;O.a.get("http://172.16.170.175:8081/SF-15-2018-OWP/KorisnikServlet?username=".concat(this.username)).then((function(e){return t.items.push(e.data)})).catch((function(t){return console.log(t)}))}},K=J,q=Object(u["a"])(K,G,L,!1,null,null,null),V=q.exports,H=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[t._v(" adduser ")])},Q=[],X={name:"AddUser"},Y=X,tt=Object(u["a"])(Y,H,Q,!1,null,null,null),et=tt.exports,at=a("5f5b"),rt=a("b1e0");a("f9e3"),a("2dd8");r["default"].use(at["a"]),r["default"].use(rt["a"]),r["default"].use(h["a"]);var nt=[{path:"/",name:"home",component:x},{path:"/filmovi",name:"Filmovi",component:T},{path:"/film/:id",name:"Film",component:D,props:!0},{path:"/users",name:"Users",component:A},{path:"/user/:username",name:"User",component:V,props:!0},{path:"/addUser",name:"AddUser",component:et}],ot=new h["a"]({routes:nt}),it=ot;r["default"].config.productionTip=!1,new r["default"]({router:it,render:function(t){return t(b)}}).$mount("#app")},"5e7b":function(t,e,a){"use strict";var r=a("48d5"),n=a.n(r);n.a},"85ec":function(t,e,a){},b805:function(t,e,a){"use strict";var r=a("3937"),n=a.n(r);n.a},d9b9:function(t,e,a){},fca7:function(t,e,a){"use strict";var r=a("d9b9"),n=a.n(r);n.a}});
//# sourceMappingURL=app.b3298cb5.js.map