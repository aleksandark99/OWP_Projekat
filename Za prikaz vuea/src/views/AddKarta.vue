<template >
  <v-stepper v-model="e6" vertical>
    <v-stepper-step :complete="e6 > 1" step="1">Projekcija</v-stepper-step>

    <v-stepper-content step="1">
      <b-table responsive :fields="fields" :items="items" :sort-by.sync="sortBy">
        <template v-slot:cell(film.naziv)="data">
          <router-link :to="`/film/${data.item.film.id}`">{{ data.value}}</router-link>
        </template>
        <template v-slot:cell(datum)="data">
          <router-link :to="`/projekcija/${data.item.id}`">{{ data.value}}</router-link>
        </template>
      </b-table>

      <v-card color="grey lighten-1" class="mb-12" height="200px"></v-card>
      <v-btn color="success" @click="e6 = 2">Continue</v-btn>
      <v-btn text>Cancel</v-btn>
    </v-stepper-content>

    <v-stepper-step id="sekcijaSedista" :complete="e6 > 2" step="2">Izabir sedista</v-stepper-step>

    <v-stepper-content step="2">
      <!-- <p v-for="sediste in this.sedista" :key="sediste.id">{{ sediste}}</p> -->
      <!-- <p v-for="sediste in this.sedista" :key="sediste.id">        </p> -->
        <div v-for="(sediste,index) in sedista " :key="sediste.redniBroj" style="display: inline;
    width: fit-content;
    margin: 0;"
    >
     <br v-if="index % 10 ==0">
      <label>
        <input :disabled="false" ref="sediste.redniBroj" type="checkbox" :value="sediste.redniBroj"  @change="testttt(sediste.redniBroj)"> {{ sediste.redniBroj }}
      </label>

    </div>
      <v-card color="grey lighten-1" class="mb-12" height="200px"></v-card>
      <!-- <v-btn color="success" @click="e6 = 3"      >Continue</v-btn> -->
        <v-btn color="success" @click="test2"      >Continue</v-btn>
      <v-btn text>Cancel</v-btn>
    </v-stepper-content>

    <v-stepper-step :complete="e6 > 3" step="3">Kasa</v-stepper-step>

    <v-stepper-content step="3">
      <v-card color="grey lighten-1" class="mb-12" height="200px"></v-card>
      <v-btn class="bluebtn" color="success" @click="e6 = 4">Continue</v-btn>
      <v-btn text>Cancel</v-btn>
    </v-stepper-content>
  </v-stepper>
</template>


<script>
import axios from "axios";

export default {
  name: "AddKarta",
  props: ["id"],
  data() {
    return {
      sedista: null,
      selektovanaSedista:[],
      e6: 1,
      sortBy: "datum",
      fields: [
        {
          label: "Film",
          key: "film.naziv",
          sortable: true
        },
        { label: "Tip ", key: "tipProjekcije.naziv", sortable: true },
        {
          label: "Sala",
          key: "sala.naizv", // pazi na type bio sam lenj da prepravim bazu
          sortable: true
        },
        {
          key: "cenaKarte",
          sortable: true
        },

        {
          key: "datum",
          sortable: true,
          formatter: value => {
            return new Date(value).toLocaleString();
          }
        }
      ],
      items: []
    };
  },

  mounted() {
    //   axios
    //   .get(`http://localhost:8081/SF-15-2018-OWP/ProjekcijaServlet?id=${this.id}`)
    //   .then(res => this.items.push(res.data.projekcija))
    //   .catch(err => console.log(err));

    axios
      .get(
        `http://localhost:8081/SF-15-2018-OWP/ProjekcijaServlet?id=${this.id}`
      )
      .then(res => {
        this.items.push(res.data.projekcija);
        this.sedista=(res.data.sedista);
        console.log(this.sedista);
                // console.log(this.sedista[0][0]);
       
      })
      .catch(err => console.log(err));
  },

  methods: {
      test2(){
          if (this.selektovanaSedista.length>0){
              this.e6 = 3;
          }else{
              alert("Morate izabrati sedista")
          }
      },
      testttt(a){
        // console.log(a)
      if(this.selektovanaSedista.includes(a)){
          this.selektovanaSedista.pop(a)
      }else{
                  this.selektovanaSedista.push(a);

      }
            //   console.log(this.selektovanaSedista)

      },
    onInput(val) {
      this.steps = parseInt(val);
    },
    nextStep(n) {
      if (n === this.steps) {
        this.e1 = 1;
      } else {
        this.e1 = n + 1;
      }
    }
  }
};
</script>

<style >
.theme--light.v-btn:not(.v-btn--flat):not(.v-btn--text):not(.v-btn--outlined) {
  background-color: #5ba6ed;
}
.theme--light.v-stepper .v-stepper__step__step {
  color: black;
  background: #5ba6ed;
}

/* .v-stepper__label{
        width: 100%;

} */
</style>

<style  scoped>
.theme--light.v-btn:not(.v-btn--flat):not(.v-btn--text):not(.v-btn--outlined) {
  background-color: #5ba6ed;
}
</style>