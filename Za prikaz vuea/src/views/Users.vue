<template>
  <div>
    <div class="container" id="s">
      <div class="row">
        <div class="col-md-4 mx-auto" id="filterInput0">
          <b-form-input v-model="a" @input="filterUsers" type="search" placeholder="Type to Search by Username"></b-form-input>
        </div>
        <!-- ove "kolone sluze za vizielni momenat " -->
        <div class="col-md-3 mx-auto"></div>
        <div class="col-md-2 mx-auto"></div>
        <!-- ove "kolone sluze za vizielni momenat " -->

        <div class="col-md-3 mx-auto">
          <!-- <b-form-input v-model="b" @input="filterUsers" type="search" id="filterInput1" placeholder="Type to Search by Uloga"></b-form-input> -->
  <!-- <b-dropdown id="dropdown-1" style="width: -webkit-fill-available">
    sssasdsadass
    <b-dropdown-item>First Action</b-dropdown-item>
    <b-dropdown-item>Second Action</b-dropdown-item>
  </b-dropdown> -->
  <div>
  <b-button-group horizontal style="width: -webkit-fill-available">
    <b-button @click="changeRole('ADMIN')">Admin</b-button>
    <b-button @click="changeRole('USER')">User</b-button>
    <b-button @click="changeRole('')">All</b-button>

  </b-button-group>
</div>

        </div>
      </div>
    </div>

    <b-table :fields="fields" :items="items">
      <template v-slot:cell(username)="data">
        <router-link :to="`/user/${data.item.username}`">{{ data.value}}</router-link>
      </template>
    </b-table>
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: "Users",
  data() {
    return {
    
      a:"",
      b:"",
      // Note 'isActive' is left out and will not appear in the rendered table
      fields: [
        {
          key: "username",
          sortable: true
        },

        {
          key: "datumRegistracije",
          sortable: true,
          formatter: value => {
            // return new Date(value)
            // return new Date(value).toLocaleDateString();
            return new Date(value).toLocaleString();
          }
        },
        {
          key: "uloga",
          sortable: true
        }
      ],
      items: []

      // items: [{"username":"a","password":"a","datumRegistracije":1986,"uloga":"ADMIN"}],

      // methods: {
      //   filmId(value) {
      //     return `${value.naziv } `
      //   },

      // }
    };
  },
    methods:{
    changeRole(role){
      this.b=role
      console.log(this.b)
      this.filterUsers();
    },
    filterUsers(){
          axios
      .get(`http://172.16.170.175:8081/SF-15-2018-OWP/KorisniciServlet?username=${this.a}&uloga=${this.b}`)
      .then(res => (this.items = res.data))
      // .then(res =>  console.log("sss"+res.data))
      .catch(err => console.log(err));
    }
  },
  mounted() {
    //'http://172.16.170.175:8081/SF-15-2018-OWP/KorisniciServlet'
    // 'http://localhost:8081/SF-15-2018-OWP/KorisniciServlet'
    axios
      .get("http://localhost:8081/SF-15-2018-OWP/KorisniciServlet")
      .then(res => (this.items = res.data))
      // .then(res =>  console.log("sss"+res.data))
      .catch(err => console.log(err));
  },
  // methods:{
  //   filterUsers(){
  //         axios
  //     .get(`"http://172.16.170.175:8081/SF-15-2018-OWP/KorisniciServlet"`)
  //     .then(res => (this.items = res.data))
  //     // .then(res =>  console.log("sss"+res.data))
  //     .catch(err => console.log(err));
  //   }
  // }
};
</script>
<style scoped>
#s {
  padding: 0;
  margin: 0;
}
.container {
  max-width: inherit;
}
#filterInput1 {
  margin-left: 30px;
}
#filterInput0 {
  padding-right: 75px;
}
</style>

@media (min-width: 1200px)
<style>
.container,
.container-sm,
.container-md,
.container-lg,
.container-xl {
  max-width: inherit;
}
