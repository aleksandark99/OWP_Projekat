<template>
  <div>
    <!-- <b-button to="/addUser">Add User</b-button> -->

    <!-- <input @input="filterMovie" placeholder="edit me"> -->

    <div class="container" id="s">
      <div class="row">
        <div class="col-md-4 mx-auto">
          Pretraga po Nazivu
          <b-form-input
            @input="filterMovie"
            v-model="a"
            type="search"
            id="poNazivu"
            placeholder="Type to Search by Username"
          ></b-form-input>
        </div>
        <div class="col-md-4 mx-auto">
          Pretraga po Trajanju
          <b-form-input
            @input="filterMovie"
            v-model="b"
            type="search"
            id="filterInput"
            placeholder="Type to Search by password"
          ></b-form-input>
        </div>
        <div class="col-md-4 mx-auto">
          Pretraga po Zemlji Porekla
          <b-form-input
            @input="filterMovie"
            v-model="c"
            type="search"
            id="filterInput"
            placeholder="Type to Search by Datum Registracije"
          ></b-form-input>
        </div>
        <div class="col-md-4 mx-auto">
          Pretraga po Zanru
          <b-form-input
            @input="filterMovie"
            v-model="d"
            type="search"
            id="filterInput"
            placeholder="Type to Search"
          ></b-form-input>
        </div>
        <div class="col-md-4 mx-auto">
          Pretraga po Distributeru
          <b-form-input
            @input="filterMovie"
            v-model="e"
            type="search"
            id="filterInput"
            placeholder="Type to Search"
          ></b-form-input>
        </div>
        <div class="col-md-4 mx-auto">
          Pretraga po Godini proizvodnje
          <b-form-input
            @input="filterMovie"
            v-model="f"
            type="search"
            id="filterInput"
            placeholder="Type to Search"
          ></b-form-input>
        </div>
      </div>
    </div>

    <b-table responsive :fields="fields" :items="items">
      <template v-slot:cell(naziv)="data">
        <router-link :to="`/film/${data.item.id}`">{{ data.value}}</router-link>
      </template>
    </b-table>
  </div>
</template>


<script>
import axios from "axios";
export default {
  name: "Filmovi",
  data() {
    return {
      a: "",
      b: "",
      c: "",
      d: "",
      e: "",
      f: "",
      // filter:'',
      // Note 'isActive' is left out and will not appear in the rendered table
      fields: [
        {
          key: "naziv",
          sortable: true
        },
        {
          key: "zanrovi",
          sortable: true
        },
        {
          key: "trajanje",
          sortable: true
        },
        {
          key: "distributer",
          sortable: true
        },
        {
          label: "Zemlja Porekla",
          key: "zemljaPorekla",
          sortable: true
        },
        {
          label: "Godina Proizvodnje",
          key: "godina",
          sortable: true
        }
      ],
      items: []
    };
  },

  methods: {
    filterMovie() {
      console.log("sss" + this.a);
      if (this.b === "") {
        this.b = 0;
      }
      if (this.f === "") {
        this.f = 0;
      }

      axios
        .get(
          `http://localhost:8081/SF-15-2018-OWP/FilmoviServlet?nazivFilma=${this.a}&trajanje=${this.b}&zemljaPorekla=${this.c}&zanr=${this.d}&distributer=${this.e}&godina=${this.f}`
        )
        // .then(res =>  this.items=res.data)
        .then(res => {
          this.items = res.data;
          if (this.b === 0) {
            this.b = "";
          }
          if (this.f === 0) {
            this.f = "";
          }
        })

        // .then(res =>  console.log("sss"+typeof( res.data)))
        .catch(err => console.log(err));
    }
  },
  mounted() {
    //'http://172.16.170.175:8081/SF-15-2018-OWP/FilmoviServlet'
    // 'http://localhost:8081/SF-15-2018-OWP/FilmoviServlet'
    axios
      .get("http://localhost:8081/SF-15-2018-OWP/FilmoviServlet")
      .then(res => (this.items = res.data))
      // .then(res =>  console.log("sss"+res.data))
      .catch(err => console.log(err));
  }
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
