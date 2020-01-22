import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Filmovi from '../views/Filmovi.vue'
import Film from '../views/Film.vue'
import Users from '../views/Users.vue'
import User from '../views/User.vue'
import AddUser from '../views/AddUser.vue'
import AddMovie from '../views/AddMovie.vue'


import { BootstrapVue, IconsPlugin } from 'bootstrap-vue'

// Install BootstrapVue
Vue.use(BootstrapVue)
// Optionally install the BootstrapVue icon components plugin
Vue.use(IconsPlugin)


Vue.use(VueRouter)
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

const routes = [
  
  {
    path: '/',
    name: 'home',
    component: Home
  },
  {
    path: '/filmovi',
    name: 'Filmovi',
    component: Filmovi
  },
//     {path: '/film-*',
//     name: 'Film',
//     component: Film ,
    
    
// },
{path: '/film/:id',
name: 'Film',
component: Film ,
props:true
},
{
  path: '/users',
  name: 'Users',
  component: Users
},
{path: '/user/:username',
name: 'User',
component: User ,
props:true
},
{
path:'/addUser',
name:'AddUser',
component: AddUser,
},
{
path:'/addMovie',
name:'AddMovie',
component: AddMovie
}
]

const router = new VueRouter({
  routes
})

export default router
