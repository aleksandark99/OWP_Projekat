<template>
  <div id="ss" >

  <b-navbar toggleable="lg" type="dark" variant="info">
    <b-navbar-brand id="navTitle" to="/">Vueplex bioskop web</b-navbar-brand>

    <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

    <b-collapse id="nav-collapse" is-nav>
      <b-navbar-nav>
        <b-nav-item to="/filmovi"> Filmovi</b-nav-item>
        <b-nav-item to="/users"> Users</b-nav-item>
        <!-- <b-button v-show="c" to="/addUser"  variant="danger">Add User</b-button> -->
        <b-button v-show="c" to="/addMovie"  variant="success">Add Movie</b-button>
        <b-button v-show="c" to="/addProjekcija"  variant="success">Add Projekcija</b-button>




        <!-- <b-nav-item to="#"> {{b}}</b-nav-item> -->
    

      </b-navbar-nav>

      <!-- Right aligned nav items -->
      <b-navbar-nav class="ml-auto">
        <!-- <button type="button" class="btn btn-success">Login</button> -->
                <b-button v-show="!c" to="/login"  variant="success" id="reg">Login</b-button>

        <br>
        <br>
        <!-- <button type="button" @click="routeToAddUser" class="btn btn-danger">Register</button> -->
        <b-button v-show="!c" to="/addUser"  variant="danger" id="reg">Register</b-button>

        


        <b-nav-item-dropdown right class="user">
          <!-- Using 'button-content' slot -->
          <template v-slot:button-content >
            <em >User</em>
          </template>
          <b-dropdown-item href="#">Profile</b-dropdown-item>
          <b-dropdown-item href="#">Sign Out</b-dropdown-item>
        </b-nav-item-dropdown>
      </b-navbar-nav>
    </b-collapse>
  </b-navbar>
  </div>
</template>

<script>

export default {
  props: {
    c:{
      type:Boolean,
      required:true
    }
  },
  name: 'NavBar',
  // seen:true,
  // el:"ss",
  data(){
    return{
      // seen:this.props[0]
    
    
    
    }

  },
  mounted(){
  

   
   },
   methods:{
     routeToAddUser(){
    //  this.router.replace('/addUser')
     }

   }


}

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

.btn-success{
  margin-right: 5px;
}
.user{
  display: none;
  visibility: hidden;
}
#navTitle{
color: #2c3e50;
}
#nav a.router-link-exact-active {
  color: purple;
}
#reg{
color: white;
text-align: center;
font-weight: 100;
}
</style>
