<template>
  <div >
  <b-navbar toggleable="lg" type="dark" variant="info">
    <b-navbar-brand href="#">Vueplex bioskop web</b-navbar-brand>

    <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

    <b-collapse id="nav-collapse" is-nav>
      <b-navbar-nav>
        <b-nav-item to="/filmovi"> Filmovi</b-nav-item>
        <b-nav-item to="#"> Projekcije</b-nav-item>

      </b-navbar-nav>

      <!-- Right aligned nav items -->
      <b-navbar-nav class="ml-auto">
        <button type="button" class="btn btn-success">Login</button>
        <br>
        <br>
        <button type="button" class="btn btn-danger">Register</button>



        <b-nav-item-dropdown right class="user">
          <!-- Using 'button-content' slot -->
          <template v-slot:button-content>
            <em>User</em>
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
  name: 'HelloWorld',
  props: {
    msg: String
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

</style>
