<template>
  <div class="home"> 
    <div class="container" id="s">
      <div class="row">
        <div class="col-md-4 mx-auto">
          Pretraga po Nazivu
          <b-form-input
            @input="filterProjekcije"
            v-model="a"
            type="search"
            id="poNazivu"
            placeholder="Type to Search by Username"
          ></b-form-input>
        </div>
        <div class="col-md-4 mx-auto">
          Pretraga po tipu
  <div>
  <b-button-group horizontal style="width: -webkit-fill-available">
    <b-button @click="changeType('2D')">2D</b-button>
    <b-button @click="changeType('3D')">3D</b-button>
    <b-button @click="changeType('4D')">4D</b-button>
    <b-button @click="changeType('')">Any</b-button>


  </b-button-group>
</div>
        </div>
        <div class="col-md-4 mx-auto">
          Pretraga po Sali
           <b-form-select v-model="selected" :options="options"></b-form-select>
        </div>
         <div class="col-md-4 mx-auto">
          min cena
          <b-form-input
            @input="filterProjekcije"
            v-model="b"
            type="search"
            id="filterInput"
            placeholder="Type to Search"
          ></b-form-input>
        </div>
               <div class="col-md-4 mx-auto">
          max cena
          <b-form-input
            @input="filterProjekcije"
            v-model="c"
            type="search"
            id="filterInput"
            placeholder="Type to Search"
          ></b-form-input>
        </div>
      
        <div class="col-md-6 mx-auto">
          OD
          <datepicker class="inLine" @input="filterProjekcije" :disabled-dates="disabledDates" v-model="date1"></datepicker>
          <vue-timepicker class="inLine" @input="filterProjekcije" v-model="yourTimeValue1"></vue-timepicker>

        </div>
         <div class="col-md-6 mx-auto">
           DO
          <datepicker class="inLine" @input="filterProjekcije" v-model="date2" ></datepicker>
          <vue-timepicker class="inLine" @input="filterProjekcije" v-model="yourTimeValue2"></vue-timepicker>

        </div>
      </div>
    </div>
    <b-table responsive :fields="fields" :items="items" :sort-by.sync="sortBy"  
>
      <template v-slot:cell(film.naziv)="data">
        <router-link :to="`/film/${data.item.film.id}`">{{ data.value}}</router-link>
      </template>
          <template v-slot:cell(datum)="data">
        <router-link :to="`/projekcija/${data.item.id}`">{{ data.value}}</router-link>
      </template>
    </b-table>
    <button @click="filterProjekcije"></button>
  </div>
</template>

<script>
// @ is an alias to /src
// import HelloWorld from '@/components/HelloWorld.vue'
import axios from "axios";
import Datepicker from 'vuejs-datepicker';
import VueTimepicker from 'vuejs-timepicker'


export default {
    props: ['id'],
    components: {
    Datepicker,
    VueTimepicker 
  },
  name: "home",
  data() {
    return {
      disabledDates: {
        to:new Date()
      },
      date:new Date(),
         yourTimeValue1: {
        HH: "00",
        mm: "00",
      },
      
        date1:"",
      
               yourTimeValue2: {
        HH: "00",
        mm: "00",
      },
        date2:"",
      tip:'',
      a:"",
      b:"",
      c:"",
      sale:[],
              selected: null,

      options:[
        
      ]

      ,
      sortBy: 'datum',
      fields: [
        {
          label:'Film',
          key: "film.naziv",
          sortable: true
        },
        {label:'Tip ',
          key: "tipProjekcije.naziv",
          sortable: true
        },
           {
          label:'Sala',
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
        },
      ],
      items: []
    };
  },
  methods:{
    testd(){
        if(this.date1 != ""){
                 var formatted_date =this.date1.getFullYear()+"-" +  this.date1.getDate() + "-" + (this.date1.getMonth() + 1) +" "+this.yourTimeValue1.HH+":"+this.yourTimeValue1.mm+":"+"00"
            console.log(formatted_date)
            return formatted_date;
    }},
    testf(){
       console.log(this.date)
        if(this.date2 != ""){
                 var formatted_date =this.date2.getFullYear()+"-" +  this.date2.getDate() + "-" + (this.date2.getMonth() + 1) +" "+this.yourTimeValue2.HH+":"+this.yourTimeValue2.mm+":"+"00"
            console.log(formatted_date)
            return formatted_date;
        }

     // axios
      // .post(`http://localhost:8081/SF-15-2018-OWP/AddProjekcija?datum=${formatted_date}`)
      // .then(res => console.log(res))
      // .catch(err => console.log(err));
    },
    changeType(a){
      if(a=="2D"){
        this.tip=1;
      }else if(a=='3D'){
        this.tip=2;

      }else if(a=='4D'){
        this.tip=3;

      }else{
        this.tip="";

      }
      this.filterProjekcije();
    },
    filterProjekcije(){
            console.log("sss" + this.a);
    var odDate=this.testd();

     var doDate=this.testf();

      axios
      .get(`http://localhost:8081/SF-15-2018-OWP/ProjekcijeServlet?movie=${this.a}&tip=${this.tip}&min=${this.b}&max=${this.c}&odDate=${odDate}&doDate=${doDate}`)
      .then(res => (this.items = res.data))
      .catch(err => console.log(err));

    }
  }
  ,
    mounted() {
      var op=[];
      op.push({ value: null, text: 'Please select an option' });
    axios
      .get("http://localhost:8081/SF-15-2018-OWP/ProjekcijeServlet")
      .then(res => (this.items = res.data))
      .catch(err => console.log(err));

  
    axios
      .get("http://localhost:8081/SF-15-2018-OWP/SaleServlet")
      .then(function(response){
      for (var i = 0; i < response.data.length; i++) {
         op.push({ value: response.data[i].id, text: response.data[i].naizv })
      } 
      })
      .catch(err => console.log(err));   
      this.options=op;
  }
};
</script>

<style scoped>
.inLine{
  display: inline-block;
  margin: 5px;
}
</style>