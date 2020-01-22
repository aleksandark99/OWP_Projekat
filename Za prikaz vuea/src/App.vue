
<template>
  <div id="app">
    <div id="nav">

      <NavBar :c="seen" />
      <!-- <HelloWorld/> -->
      
      
      <!-- <router-link to="/">Home</router-link> | -->
      <!-- <router-link to="/filmovi">About</router-link> -->
    </div>
    <router-view/>
  </div>
</template>

<script>
//  import HelloWorld from '@/components/HelloWorld.vue';
 import NavBar from '@/components/NavBar.vue'
  export default {
  components: {
    NavBar

  }
  ,
  data(){
    return{
      seen:true
    }
  }
} 
 
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 0;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
</style>
